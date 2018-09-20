package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Product;
import utils.JDBCUtil;

import java.util.List;

public class ProductDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtil.getDs());
    private String sql;
    public List<Product> query(){
        sql="select * from products";
        List<Product> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return query;
    }
}
