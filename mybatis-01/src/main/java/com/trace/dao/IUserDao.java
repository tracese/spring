package com.trace.dao;

import com.trace.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 沈泽群
 * @date 2020/7/31
 */
public interface IUserDao {
    /**
     * @return 查询所有
     * 注解方式： @Select("select * from user")
     */
    List<User> findAll();

}
