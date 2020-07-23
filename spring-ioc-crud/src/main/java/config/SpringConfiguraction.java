package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author PC
 * @date 2020/6/10
 * 配置类，作用相当于bean.xml
 * Configuration：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写，这种情况可以不扫描
 *      要么作为AnnotationConfigApplicationContext对象的参数，要么配置@Configuration和@ComponentScab
 * ComponentScan:用于通过注解指定Spring在创建容器时要扫描的包
 *         属性：value:它和basePackages的作用是一样的
 *         使用此注解就等同于在xml中配置了<context:component-scan base-package="com.trace"/>
 *
 * Bean:
 *      作用：用于把当前方法的返回值作为bean对象存入Spring的ioc容器中
 *      属性：
 *          name:用于指定bean的id,当不写时，默认值是当前方法的名称
 *      细节：当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
 *           查找的方式和Autowired注解的作用是一样的
 * Import：用于导入其他的配置类
 * @Import(JdbcConfig.class) JdbcConfig类作为一个类，不需要加扫描和配置类
 * PropertySource:用于指定properties文件的位置
 *      value:指定文件的名称和路径
 *      关键字：classpath
 */
//@Configuration
@ComponentScan(basePackages = {"com.trace"})
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguraction {
}
