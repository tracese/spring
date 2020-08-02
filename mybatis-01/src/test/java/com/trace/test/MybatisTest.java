package com.trace.test;

import com.trace.dao.IUserDao;
import com.trace.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author 沈泽群
 * @date 2020/7/31
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产sqlSession对象
        SqlSession session = factory.openSession();
        //4.使用sqlSession对象创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
