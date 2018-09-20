package dao;


import util.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

public class MyDao<T> {
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    //增删改的方法
    public int update(Connection connection, String sql, Object... objects) {
        try {
            //初始化预编译平台
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            for (int i = 1; i <= objects.length; i++) {
                preparedStatement.setObject(i, objects[i - 1]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, resultSet);
        }
        return 0;
    }

    public T querySingle(Connection connection, Class<T> cls, String sql, Object... objects) {
        T t = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i < objects.length + 1; i++) {
                preparedStatement.setObject(i, objects[i - 1]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                t = cls.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    String fieldName = columnName.substring(columnName.indexOf("_") + 1);
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    String columnTypeName = metaData.getColumnTypeName(i + 1);
                    Method method;
                    if (columnTypeName.equals("INT")) {
                        method = cls.getMethod(methodName, Integer.class);
                        method.invoke(t, resultSet.getInt(i + 1));
                    }
                    if (columnTypeName.equals("VARCHAR")) {
                        method = cls.getMethod(methodName, String.class);
                        method.invoke(t, resultSet.getString(i + 1));
                    }
                    if (columnTypeName.equals("DOUBLE")) {
                        method = cls.getMethod(methodName, Double.class);
                        method.invoke(t, resultSet.getDouble(i + 1));
                    }
                    if (columnTypeName.equals("DATE")) {
                        Date date = resultSet.getDate(i + 1);
                        method = cls.getMethod(methodName, Date.class);
                        java.util.Date date1 = new java.util.Date(date.getTime());
                        method.invoke(methodName, date1);
                    }


                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    //查询数据库的总个数
    public long queryCount(Connection connection, String sql, Object... objects) {
        //初始化预编译平台
        try {
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            for (int i = 1; i <= objects.length; i++) {
                preparedStatement.setObject(i, objects[i - 1]);
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, resultSet);
        }
        return 0;
    }

}

