package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import utils.JDBCUtil;

//查询数据库
public class PersonDao {
    public  User query(String username, String passwd) {
        //retrieve data
        String sql = "select * from person where username=? and passwd=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDs());
        User user;
        try{
             user=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, passwd);
             return user;
        }catch (Exception e){
            return null;
        }
    }

}
