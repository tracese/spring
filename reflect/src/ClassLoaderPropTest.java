import java.net.URL;

/**
 * @author PC
 * @date 2020/6/15
 */
public class ClassLoaderPropTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器："+systemClassLoader);
        //加载器的加载路径
        URL resource = systemClassLoader.getResource("");
        System.out.println(resource);
        //获取系统类加载器的父类加载器：扩展类加载器
        ClassLoader extensionLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器："+extensionLoader);
        //加载器的加载路径
        System.out.println(System.getProperty("java.ext.dirs"));
        //获取根类加载器
        System.out.println(extensionLoader.getParent());
    }
}
