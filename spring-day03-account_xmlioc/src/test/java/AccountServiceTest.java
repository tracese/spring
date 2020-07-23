import domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

import java.util.List;

/**
 * @author 沈泽群
 * @date 2020/7/23
 */
public class AccountServiceTest {

    @Test
    public void testFindAll(){
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        //3、执行方法
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setName("Trace");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate(){
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(5);
        account.setMoney(2000f);
        accountService.updateAccount(account);
    }
    @Test
    public void testDelete(){
        //1、获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2、得到业务层对象
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(5);
    }
}
