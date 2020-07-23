import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author PC
 * @date 2020/6/16
 */
public class  CompileClassLoader extends ClassLoader{
    /**
     * 读取一个文件的内容
     */
    private byte[] getBytes(String name) throws IOException {
        File file = new File(name);
        long length = file.length();
        byte[] raw = new byte[(int)length];
        try(FileInputStream fis = new FileInputStream(file)){
            int r = fis.read(raw);
            if(r != length) {
                throw new IOException("无法读取全部文件："+r+" != "+length);
            }
            return raw;
        }
    }

    /**
     * 定义编译指定Java文件的方法
     */
    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompileClassLoader:正在编译 "+javaFile+"...");
        Process process = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int exitValue = process.exitValue();
        return exitValue == 0;
    }


     @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
         String fileStub = name.replace(".", "/");
         String javaFileName = fileStub + ".java";
         String classFileName = fileStub + ".class";
         File javaFile = new File(javaFileName);
         File classFile = new File(classFileName);
         if(javaFile.exists()&&(!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()){
             try {
                 /**
                  * 如果编译失败或者该class文件不存在
                  */
                 if((!compile(javaFileName)) || !classFile.exists()){
                     throw new ClassNotFoundException("ClassNotFoundException:"+javaFileName);
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         /**
          * 如果class文件存在，系统负责将该文件系统转换成Class对象
          */
         if(classFile.exists()){
             try {
                 byte[] raw = getBytes(classFileName);
                 clazz = defineClass(name,raw,0, raw.length);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         if(clazz==null){
             throw new ClassNotFoundException(name);
         }
         return clazz;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /**
         * 如果运行该程序时没有参数，即没有目标类
         */
        if (args.length < 1){
            System.out.println("缺少目标类，请按如下格式运行Java源文件：");
            System.out.println("java CompileClassLoader ClassName");
        }
        /**
         * 第一个参数是需要运行的类
         */
        String progClass = args[0];
        String[] progArgs = new String[args.length-1];
        System.arraycopy(args,1,progArgs,0,progArgs.length);
        CompileClassLoader ccl = new CompileClassLoader();
        Class<?> clazz = ccl.loadClass(progClass);
        Method main = clazz.getMethod("main", String[].class);
        Object argsArray[] = {progArgs};
        main.invoke(null,argsArray);
    }
}
