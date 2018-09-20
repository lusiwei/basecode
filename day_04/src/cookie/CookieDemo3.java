package cookie;

import util.CookieUtils;
import util.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/demo")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = CookieUtils.getCookieByName(request.getCookies(), "lastTime");
        String result = "";
        if(cookie==null){//第一次访问
            result = "你是第一次访问";
        }else{
            result = "欢迎回来,你上次访问时间为:"+cookie.getValue();
            //把lastTime这个cookie的值替换为当前时间
        }
        cookie = new Cookie("lastTime", DataUtils.parseDate(new Date()));
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<h1>"+result+"</h1>");
    }
}
