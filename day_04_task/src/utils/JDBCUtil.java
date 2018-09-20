package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource ds;
    static {
        Properties properties=new Properties();

        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
            ds= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDs() {
        if (ds != null) {
            return ds;
        }
        return null;
    }
    public static Connection getConnection(){
        if (ds != null) {
            try {
                return ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void closeConnection(Connection connection){
        if (ds != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void closeDS(){
        if (ds != null) {
            ds=null;
        }
    }
}
