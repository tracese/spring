package com.trace.service;

import com.trace.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 * @author PC
 * @date 2020/6/8
 */
public interface IAccountService {

    /**
     * 查询所有
     * @return 账户列表
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return 单个账户
     * @param accountId 账户id
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存账户
     * @param account 账户实例
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account 账户实例
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param accountId 账户id
     */
    void deleteAccount(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName,String targetName,Float money);

}
