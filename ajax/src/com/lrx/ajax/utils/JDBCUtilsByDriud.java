package com.lrx.ajax.utils;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 刘瑞玺
 * @version 1.0
 * 基于Druid数据库连接池的工具类
 */
public class JDBCUtilsByDriud {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        try {
            //如果是javase 可以通过这种方式获得资源
            //properties.load(new FileInputStream("src\\druid.properties"));
            //现在是javaweb ，通过类加载器获得资源，真正存储位置在out下
            properties.load(JDBCUtilsByDriud.class.getClassLoader()
                    .getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
