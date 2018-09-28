package test;

import com.alibaba.fastjson.JSON;
import dao.CityDao;
import org.junit.Test;
import pojo.City;

import java.util.List;

public class TestDao {
    CityDao cityDao = new CityDao();

    @Test
    public void queryProvince() {
        List<City> cities = cityDao.queryProvince();
        System.out.println(JSON.toJSONString(cities));
    }

    @Test
    public void queryCity(){
        List<City> cities = cityDao.queryCity("1");
        System.out.println(JSON.toJSONString(cities));
    }
}
