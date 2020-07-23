import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author PC
 * @date 2020/6/16
 */
public class URLClassLoaderTest {
    private static Connection conn;
    public static Connection getConn(String url,String user,String password) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        if (conn == null){
            //创建一个URL数组
            URL[] urls = {new URL("file:mysql-connector-java-5.1.47.jar")};
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            //加载MySQL的JDBC驱动，并创建默认实例
            Driver driver = (Driver) myClassLoader.loadClass("com.mysql.jdbc.Driver").getConstructor().newInstance();
            //创建一个设置JDBC连接属性的Properties对象
            Properties prop = new Properties();
            prop.setProperty("user",user);
            prop.setProperty("password",password);
            //调用Driver对象的connect方法来获取得数据库连接
            conn = driver.connect(url,prop);
        }
        return conn;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, SQLException, MalformedURLException, ClassNotFoundException {
        System.out.println(getConn("jdbc:mysql://localhost:3306/eesy","root","123456"));
    }
}
