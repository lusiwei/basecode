package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.User;
import util.JdbcPoolUtil;

public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcPoolUtil.getDataSource());

    public User query(String username) {
//        System.out.println(jdbcTemplate);
        String sql = "select * from xuser where username like ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username+"%");
        } catch (Exception e) {
        }
        System.out.println(user);
        return user;
    }

}
