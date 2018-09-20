package login;

import dao.PersonDao;
import pojo.User;
import utils.CookieUtil;
import utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/login")
public class login extends HttpServlet {
    PersonDao personDao = new PersonDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = personDao.query(username, password);
        HttpSession session1 = req.getSession();
        Object user1 = session1.getAttribute("user");
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", new User(username, password));
            Cookie[] cookies = req.getCookies();
            Cookie cookie = CookieUtil.getCookieByName(cookies, "lastTime");
            String message;
            if (cookie == null) {
                message = "你是第一次登录";
            } else {
                message = "你上次登录时间为" + cookie.getValue();
            }
            cookie = new Cookie("lastTime", DateUtil.parseDate(new Date()));
            cookie.setMaxAge(600);
            resp.addCookie(cookie);
            req.setAttribute("message", message);
//            resp.sendRedirect("success.jsp");
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("redirect.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
