import sun.misc.Launcher;

import java.net.URL;
import java.util.Properties;

/**
 * @author 沈泽群
 * @date 2020/7/19
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
//        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
//        for(URL url:urLs){
//            System.out.println(url);
//        }
        String property = System.getProperty("java.ext.dirs");
        for(String path:property.split(";")){
            System.out.println(path);
        }

    }
}
