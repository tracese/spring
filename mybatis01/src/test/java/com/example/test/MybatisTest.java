package com.example.test;

import com.example.dao.IUserDao;
import com.example.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

/**
 * @author 沈泽群
 * @date 2020/7/4
 */
public class MybatisTest {

    @Test
    public void testFindAll() throws Exception{
        //1、加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建sqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //3、创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4、获取代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        //5、执行方法
        List<User> users = mapper.findAll();
        for(User user:users){
            System.out.println(user);
        }
        //6、释放资源
        in.close();
        sqlSession.close();
    }
}
