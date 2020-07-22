package factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 沈泽群
 * @date 2020/7/22
 */
public class BeanFactory1 {
    /**
     * 定义一个Properties对象
     */
    private static Properties prop;

    /**
     * 定义一个Map集合，用于存放我们要创建的对象
     */
    private static Map<String,Object> beans;

    static{
        try{
            //实例化Properties对象
            prop = new Properties();
            //获取Properties文件的流对象
            InputStream inputStream = BeanFactory1.class.getClassLoader().getResourceAsStream("bean.properties");
            //加载流对象
            prop.load(inputStream);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中的所有key
            Enumeration<Object> keys = prop.keys();
            //遍历key
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                //根据key获取beanPath
                String beanPath = prop.getProperty(key);
                //通过类的全限定类名反射创建对象
                Object o = Class.forName(beanPath).newInstance();
                //将创建的对象存储到容器中
                beans.put(key,o);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化bean异常");
        }

    }

    /**
     * 根据beanName获取bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
       return beans.get(beanName);
    }

}
