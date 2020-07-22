package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import factory.BeanFactory;
import factory.BeanFactory1;
import service.IAccountService;

/**
 * @author 沈泽群
 * @date 2020/7/22
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = (IAccountDao) BeanFactory1.getBean("accountDao");
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
