package com.yc.biz;

import com.yc.bean.Account;
import com.yc.bean.OpRecord;
import com.yc.bean.OpType;
import com.yc.dao.AccountDao;
import com.yc.dao.OpRecordDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional
public class AccountBizImpl implements AccountBiz {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private OpRecordDao opRecordDao;

    //spring对异常处理：
    //正常的程序异常
    @Override
    public Account findAccount(int accountid) {
        return this.accountDao.findById(accountid);
    }

    @Override
    public Account openAccount(double money) {
        //开户操作，返回新账号的id
        int accountid = this.accountDao.insert(money);
        //包装日志信息
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(accountid);
        opRecord.setOpmoney(money);
        opRecord.setOptype(OpType.DEPOSITE);
        this.opRecordDao.insertOpRecord(opRecord);
        //返回新的账户信息
        Account a = new Account();
        a.setAccountid(accountid);
        a.setMoney(money);
        return a;
    }

    @Override
    public Account deposite(int accountid, double money) {
        return this.deposite(accountid, money, null);
    }

    @Override
    public Account deposite(int accountid, double money, Integer transferId) {
        Account a = null;
        try {
            a = this.accountDao.findById(accountid);
        } catch (RuntimeException re) {
            log.error(re.getMessage()); //TODO:封装保存日志的操作
            throw new RuntimeException("查无此账户" + accountid + "，无法完成存款操作");
        }
        //存款时，金额增加
        a.setMoney(a.getMoney() + money);

        this.accountDao.update(accountid, a.getMoney());

        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(accountid);
        opRecord.setOpmoney(money);
        if (transferId != null) {
            opRecord.setOptype(OpType.TRANSFER);
            opRecord.setTransferid(transferId);
        } else {
            opRecord.setOptype(OpType.DEPOSITE);
        }
        this.opRecordDao.insertOpRecord(opRecord);
        return a;
    }

    @Override
    public Account withdraw(int accountid, double money) {
        return this.withdraw(accountid, money, null);
    }

    @Override
    public Account withdraw(int accountid, double money, Integer transferId) {
        Account a = null;
        try {
            a = this.accountDao.findById(accountid);
        } catch ( RuntimeException re) {
            log.error(re.getMessage()); //TODO:封装保存日志的操作
            throw new RuntimeException("查无此账户" + accountid + "，无法完成存款操作");
        }
        a.setMoney(a.getMoney() - money);

        this.accountDao.update(accountid, a.getMoney());
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(accountid);
        opRecord.setOpmoney(money);
        if (transferId != null) {
            opRecord.setOptype(OpType.TRANSFER);
            opRecord.setTransferid(transferId);
        } else {
            opRecord.setOptype(OpType.WITHDRAW);
        }
        //dao -> datasource -> connection ->jdbc 隐式事务提交  ->  一条sql提交一次 commit()
        this.opRecordDao.insertOpRecord(opRecord);  //先插入日志
        this.accountDao.update(accountid, a.getMoney());  //再减金额
        return a;
    }

    @Override                   //1.withdraw    100    2deposite
    public Account transfer(int accountId, double money, int toAccountId) {
        //从accountid转money到toAccountid
        this.deposite(toAccountId, money, accountId); //收款方
        //accountid 从账户中取出money
        Account a = this.withdraw(accountId, money, toAccountId);
        return a;
    }


}
