package com.example.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhang
 * @Discription:
 * @Date: Created in 21:46 2022/3/1
 */
class JdbcUtilsTest {

    @Test
    void getConnection() {
        for (int i = 0; i < 100; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection + "===" + String.valueOf(i));
            JdbcUtils.close(connection);
        }
    }

    @Test
    void close() {
    }
}