package test;

import dao.UserDao;
import org.junit.Test;

public class TestLogin {
    @Test
    public void login(){
        new UserDao().login("张三","123456");
    }
}
