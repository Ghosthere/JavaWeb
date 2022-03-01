package com.example.service.impl;

import com.example.dao.impl.UserImpl;
import com.example.pojo.User;
import com.example.service.UserService;

/**
 * @Author: zhang
 * @Discription:
 * @Date: Created in 22:58 2022/3/1
 */
public class UserServiceImpl extends UserImpl implements UserService {
    @Override
    public void register(User user) {
        addUser(user);
    }

    @Override
    public User login(User user) {
        return queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean checkUsername(String username) {
        return checkUsername(username);
    }
}
