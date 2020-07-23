/**
 * @author PC
 * @date 2020/6/15
 */
class Tester1 {
    static{
        System.out.println("Tester类的静态初始化块");
    }
}
public class Tester{
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        cl.loadClass("Tester1");
        System.out.println("系统加载Tester类");
        Class.forName("Tester1");
    }
}
