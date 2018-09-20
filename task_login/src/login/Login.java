package login;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        try {
            boolean b = queryDatabase(username, password);
            if (b){
                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean queryDatabase(String name,String pass) throws Exception {
        Properties properties=new Properties();
        InputStream resourceAsStream = Login.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource ds=DruidDataSourceFactory.createDataSource(properties);
        JdbcTemplate jdbcTemplate=new JdbcTemplate(ds);
        String sql="select * from users where username=? and passwd=?";
        try {
            Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, name, pass);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
