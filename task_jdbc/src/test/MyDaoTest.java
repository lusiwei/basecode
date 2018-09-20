package test;

import dao.MyDao;
import org.junit.Test;
import pojo.User;
import util.JDBCUtils;

public class MyDaoTest {
    @Test
    public void update(){
        String sql="insert into person(username,passwd) values(?,?)";
//        new MyDao().update(JDBCUtils.getConnection(),sql,"john","123456");
        String sql1="delete from person where username=?";
        System.out.println(new MyDao().update(JDBCUtils.getConnection(), sql1, "john"));
        JDBCUtils.commit(JDBCUtils.getConnection());
    }
    @Test
    public void count(){
        String sql="select count(*) from person";
        System.out.println(new MyDao().queryCount(JDBCUtils.getConnection(), sql));
    }
    @Test
    public void querySingle(){
        String sql="select * from person where username='jack'";
        MyDao<User> myDao=new MyDao<>();
        System.out.println(myDao.querySingle(JDBCUtils.getConnection(), User.class, sql));

    }
}
