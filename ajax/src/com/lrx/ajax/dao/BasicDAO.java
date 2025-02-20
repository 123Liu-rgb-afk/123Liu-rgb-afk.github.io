package com.lrx.ajax.dao;

import com.lrx.ajax.utils.JDBCUtilsByDriud;
import com.lrx.ajax.utils.JDBCUtilsByDriud;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 刘瑞玺
 * @version 1.0
 * 开发BasicDAO，是其他dao的父类
 */
public class BasicDAO<T> {//泛型指定具体的类型
    private QueryRunner qr = new QueryRunner();

    //开发通用的dml方法，针对任意表
    public int update(String sql,Object... parametes){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDriud.getConnection();
            int update = qr.update(connection, sql, parametes);
            return update;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDriud.close(null,null,connection);
        }
    }

    //开发查询多行语句的方法
    public List<T> queryMany(String sql, Class<T> clazz,Object...parametes) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDriud.getConnection();
            return qr.query(connection,sql,new BeanListHandler<T>(clazz),parametes);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDriud.close(null,null,connection);
        }
    }

    //开发查询单行语句的方法
    public T querySingle(String sql, Class<T> clazz, Object...parametes) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDriud.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parametes);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDriud.close(null, null, connection);
        }
    }

    //查询单行单列的方法
    public Object queryScalar(String sql, Object...parametes) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDriud.getConnection();
            return qr.query(connection,sql,new ScalarHandler(),parametes);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        } finally {
            JDBCUtilsByDriud.close(null,null,connection);
        }
    }

}
