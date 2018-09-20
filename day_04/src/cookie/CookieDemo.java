package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/welcome")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if (c==null||!c.getName().contains("myCookie")) {
                resp.getWriter().write("<!doctype html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta name='viewport'\n" +
                        "          content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='ie=edge'>\n" +
                        "    <title>welcome</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h1>欢迎你,首次登录</h1>\n" +
                        "</body>\n" +
                        "</html>");
            } else {
                Cookie cookie = new Cookie("myCookie", "visit");
                resp.addCookie(cookie);
                resp.getWriter().write("<!doctype html>\n" +
                        "<html lang='en'>\n" +
                        "<head>\n" +
                        "    <meta charset='UTF-8'>\n" +
                        "    <meta name='viewport'\n" +
                        "          content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>\n" +
                        "    <meta http-equiv='X-UA-Compatible' content='ie=edge'>\n" +
                        "    <title>Document</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    欢迎回来,你上次访问时间为\n" + new Date().toString() +
                        "</body>\n" +
                        "</html>");
            }
        }
    }

}
