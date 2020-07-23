import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 沈泽群
 * @date 2020/7/22
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception{
        //注册驱动
        //编译期耦合
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //运行期耦合
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","123456");
        //获取操作数据库的预处理对象
        PreparedStatement preparedStatement = conn.prepareStatement("select * from account");
        //执行SQL语句，得到结果集
        ResultSet rs = preparedStatement.executeQuery();
        //遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //释放资源
        conn.close();
        preparedStatement.close();
        rs.close();
    }
}
