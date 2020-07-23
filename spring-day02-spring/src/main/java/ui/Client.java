package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;
import service.impl.AccountServiceImpl;

/**
 * @author 沈泽群
 * @date 2020/7/22
 * 模拟表现层
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService accountService = new AccountServiceImpl();
        IAccountService accountService = ac.getBean("accountService",IAccountService.class);
        accountService.saveAccount();
        System.out.println(accountService);
        ((ClassPathXmlApplicationContext)ac).close();
    }
}
