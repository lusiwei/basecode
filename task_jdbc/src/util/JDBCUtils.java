package util;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            //加载配置文件 读取用户名等...
            Properties properties = new Properties();
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("加载配置文件错误");
            e.printStackTrace();
        }
    }

    //获得连接
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭资源
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {

                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {

                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //回滚  关闭连接
    public static void rollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
                close(connection, null, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //提交
    public static void commit(Connection connection) {
        if (connection != null) {
            try {
                connection.commit();
                close(connection, null, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

