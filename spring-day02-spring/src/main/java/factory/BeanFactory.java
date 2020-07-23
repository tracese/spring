package factory;

import service.IAccountService;
import service.impl.AccountServiceImpl;

/**
 * @author 沈泽群
 * @date 2020/7/22
 */
public class BeanFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
