package service;


import dao.CityDao;
import pojo.City;

import java.util.List;

public class CityService {

    public List<City> queryProvince() {
        List<City> cities = new CityDao().queryProvince();
        return cities;
    }

    public List<City> queryCity(String pid) {
        return new CityDao().queryCity(pid);
    }
}
