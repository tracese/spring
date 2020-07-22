package ui;

import factory.BeanFactory;
import factory.BeanFactory1;
import service.IAccountService;
import service.impl.AccountServiceImpl;

/**
 * @author 沈泽群
 * @date 2020/7/22
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        IAccountService accountService = (IAccountService) BeanFactory1.getBean("accountService");
        accountService.saveAccount();
    }


}
