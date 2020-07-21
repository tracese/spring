<h4>耦合：程序间的依赖关系</h4>
* 包括：
*   1、类之间的依赖关系
*   2、方法之间的依赖关系

<h4>解耦：降低程序之间的依赖关系</h4>
<h4>实际开发中：</h4>
*   应该做到编译期不依赖，运行期才依赖

<h4>解耦的思路：</h4>
*   第一步：使用反射创建创建对象，而避免使用new关键字
*   第二步：通过读取配置文件来获取要创建的对象的全限定类名

<h4>Jdbc连接数据库的步骤</h4>
<h4>导入依赖</h4>
```
<dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.48</version>
        </dependency>
    </dependencies>
```
<h4>编写程序</h4>

```
public class JdbcDemo {
    public static void main(String[] args) throws Exception{
        //注册驱动
        //编译器耦合
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
```
