package com.example.dao;

import com.example.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 * @author PC
 * @date 2020/7/3
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return 用户列表
     */
    List<User> findAll();

}
