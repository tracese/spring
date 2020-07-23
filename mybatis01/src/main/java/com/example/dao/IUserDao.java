package com.example.dao;

import com.example.domain.User;

import java.util.List;

/**
 * @author 沈泽群
 * @date 2020/7/4
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return 用户列表
     */
    List<User> findAll();

}
