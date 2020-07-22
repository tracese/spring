package dao.impl;

import dao.IAccountDao;

/**
 * @author 沈泽群
 * @date 2020/7/22
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存了一个账户");
    }
}
