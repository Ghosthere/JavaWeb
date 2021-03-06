package com.example.dao.impl;

import com.example.dao.BaseDao;
import com.example.dao.UserDao;
import com.example.pojo.User;

/**
 * @Author: zhang
 * @Discription:
 * @Date: Created in 20:26 2022/3/1
 */
public class UserImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";

        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";

        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
