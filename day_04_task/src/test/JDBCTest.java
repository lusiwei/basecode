package test;

import dao.PersonDao;
import dao.ProductDao;
import org.junit.Test;
import utils.DateUtil;

import java.util.Date;

public class JDBCTest {
    @Test
    public void testCon(){
        System.out.println(new PersonDao().query("jack", "123456"));
    }
    @Test
    public void testDateUtil(){
        System.out.println(DateUtil.parseDate(new Date()));
    }
    @Test
    public void testProductDao(){
        System.out.println(new ProductDao().query());
    }
}
