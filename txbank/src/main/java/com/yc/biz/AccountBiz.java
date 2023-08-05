package com.yc.biz;

import com.yc.bean.Account;

public interface AccountBiz {
    /** 银行开户...  */
    public Account openAccount(double money);

    public Account deposite(int accountid, double money);

    /** 存款：给accountid存入  money  并返回最后的余额信息 */
    public Account deposite(int accountid, double money, Integer transferId);

    Account withdraw(int accountid, double money);

    /** 取款：给accountid取出money，并返回最后的余额信息 */
    public Account withdraw(int accountid, double money, Integer transferId);

    /** 从accountid中转出money到toAccountId账户...*/
    public Account transfer(int accountId, double money, int toAccountId);

    /** 查询是否存在accountid账户 */
    public Account findAccount(int accountid);

}
