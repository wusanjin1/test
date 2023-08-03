package com.yc.dao;

import com.yc.bean.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 添加账号
     * @param money
     * @return  :  这个新账号的编号，如何取出 auto_increment自动生成的id号????How to do
     */
    public int insert(double money);

    /**
     * 根据账号将money更新  :  都当成  balance=balance + money
     * @param accountid
     * @param money    整数表示存，负数表示取
     */
    public void update(int accountid, double money);

    /**
     * 删除账号
     * @param accountid
     */
    public void delete(int accountid);

    /**
     * 查询账号总数
     * @return
     */
    public int findCount();

    /**
     * 查询所有的账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据id查询账号
     * @param accountid
     * @return
     */
    public Account findById(int accountid);
}
