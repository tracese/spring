package factory;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author 沈泽群
 * @date 2020/7/22
 */
public class BeanFactory {
    private static Properties prop;

    static {
        try {
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            prop = new Properties();
            prop.load(inputStream);
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化异常");
        }
    }
    public static Object getBean(String name) {
        Object bean = null;
        String beanPath = prop.getProperty(name);
        try{
            bean = Class.forName(beanPath).newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
        return bean;

    }
}
