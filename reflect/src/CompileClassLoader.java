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
     * ��ȡһ���ļ�������
     */
    private byte[] getBytes(String name) throws IOException {
        File file = new File(name);
        long length = file.length();
        byte[] raw = new byte[(int)length];
        try(FileInputStream fis = new FileInputStream(file)){
            int r = fis.read(raw);
            if(r != length) {
                throw new IOException("�޷���ȡȫ���ļ���"+r+" != "+length);
            }
            return raw;
        }
    }

    /**
     * �������ָ��Java�ļ��ķ���
     */
    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompileClassLoader:���ڱ��� "+javaFile+"...");
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
                  * �������ʧ�ܻ��߸�class�ļ�������
                  */
                 if((!compile(javaFileName)) || !classFile.exists()){
                     throw new ClassNotFoundException("ClassNotFoundException:"+javaFileName);
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         /**
          * ���class�ļ����ڣ�ϵͳ���𽫸��ļ�ϵͳת����Class����
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
         * ������иó���ʱû�в�������û��Ŀ����
         */
        if (args.length < 1){
            System.out.println("ȱ��Ŀ���࣬�밴���¸�ʽ����JavaԴ�ļ���");
            System.out.println("java CompileClassLoader ClassName");
        }
        /**
         * ��һ����������Ҫ���е���
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
