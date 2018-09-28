package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.City;
import util.JDBCUtil;

import java.util.List;

public class CityDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDs());

    public List<City> queryProvince() {
        String sql = "select * from city where pId=?";
        List<City> cities = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(City.class), 0);
        return cities;
    }

    public List<City> queryCity(String pid) {
        String sql="select * from city where pId=?";
        List<City> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(City.class), pid);
        return query;
    }
}
