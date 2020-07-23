package com.trace.dao;

import com.trace.domain.Account;

import java.util.List;

/**
 * @author PC
 * @date 2020/6/8
 */
public interface IAccountDao {
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
     * 根据名称查询账户
     * @param accountName 账户名称
     * @return 如果有唯一的结果就返回，如果没有结果就返回null
     *         如果结果集超过一个就抛异常
     */
    Account findAccountByName(String accountName);
}
