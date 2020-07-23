import com.trace.domain.Account;
import com.trace.service.IAccountService;
import config.SpringConfiguraction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author PC
 * @date 2020/6/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguraction.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
//    ApplicationContext applicationContext;
    @Autowired
    IAccountService accountService;

/*    @Before
    public void init(){
        applicationContext = new AnnotationConfigApplicationContext(SpringConfiguraction.class);
        accountService = applicationContext.getBean("accountService",IAccountService.class);
    }*/

    @Test
    public void testFindAll(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        List<Account> accounts = accountService.findAllAccount();
        for (Account account:accounts) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);
        Account account = accountService.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setName("zs");
        account.setMoney(1001f);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);
        accountService.saveAccount(account);
    }

    @Test
    public void deleteAccount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);
        accountService.deleteAccount(1);
    }

    @Test
    public void updateAccount(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);
        Account account = accountService.findAccountById(4);
        account.setName("ls");
        accountService.updateAccount(account);
    }
    @Test
    public void testTransfer(){
        accountService.transfer("bbb","ccc",100f);
    }

}
