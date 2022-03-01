package com.example.dao;

import com.example.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.omg.CORBA.ObjectHelper;

import javax.management.Query;
import javax.xml.ws.handler.Handler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: zhang
 * @Discription:
 * @Date: Created in 22:06 2022/3/1
 */
public abstract class BaseDao {

    private QueryRunner runner = new QueryRunner();

    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return runner.update(sql, connection, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object...args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return runner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtils.close(conn);
        }

        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();

        try {
            return runner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtils.close(conn);
        }

        return null;
    }

    public Object queryForSingleValue(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn,sql, new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
            JdbcUtils.close(conn);
        }

        return null;
    }

}
