package com.example.service;

import com.example.pojo.User;

/**
 * @Author: zhang
 * @Discription:
 * @Date: Created in 22:55 2022/3/1
 */
public interface UserService {

    public void register(User user);

    public User login(User user);

    boolean checkUsername(String username);

}
