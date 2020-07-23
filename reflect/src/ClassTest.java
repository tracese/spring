import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author PC
 * @date 2020/6/17
 */
@Repeatable(Annos.class)
@interface Anno{}
/**
 * @author Trace
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Annos{
    Anno[] value();
}
@SuppressWarnings(value = "unchecked")
@Deprecated
@Anno
@Anno
public class ClassTest {
    public ClassTest() {
    }
    public ClassTest(String name){
        System.out.println("执行有参数的构造器");
    }
    public void info(){
        System.out.println("执行有参数的构造器");
    }
    public void info(String str){
        System.out.println("..."+str);
    }
    class Inner{}

    public static void main(String[] args) {
        Class<ClassTest> clazz = ClassTest.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        Method[] methods = clazz.getMethods();
        for (Method method:methods) {
            System.out.println(method);
        }
    }
}
