package query;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/query")
public class QueryTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserDao userDao=new UserDao();
        String str=req.getParameter("name");

        User query = userDao.query(str);
        if (query!=null){
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<style>table,td{border: 1px solid;padding: 0;text-align: center;}table{width: 300px;margin: 0 auto;}td{width: 100px;}</style>");
            resp.getWriter().write("<table><tr><td>姓名</td><td>密码</td><td>年龄</td></tr></table>");
            resp.getWriter().write("<table><tr><td>" +query.getUsername()+
                    "</td><td>"+query.getPasswd()+"</td><td>"+query.getAge()+"</td></tr></table>");
        }
    }
}
