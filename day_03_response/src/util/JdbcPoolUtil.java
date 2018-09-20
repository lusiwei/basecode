package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcPoolUtil {
    private static DataSource ds;


    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JdbcPoolUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("读取配置文件错误....");
            e.printStackTrace();
        }
    }

    //获取连接池
    public static DataSource getDataSource() {
        return ds;
    }


    //获取连接
    public static Connection getConnectoin() {
        if (ds != null) {
            try {
                return ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        if (ds != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeDataSource() {
        if (ds != null) {
            ds = null;
        }
    }

}
