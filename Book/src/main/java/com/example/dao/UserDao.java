package com.example.dao;

import com.example.pojo.User;

/**
 * @Author: zhang
 * @Discription:
 * @Date: Created in 22:44 2022/3/1
 */
public interface UserDao {
    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username, String password);

    public int addUser(User user);

}
