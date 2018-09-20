package am.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获得请求类型"+req.getMethod());
        System.out.println("获得请求的虚拟路径"+req.getContextPath());
        System.out.println("获得servlet的请求路径"+req.getServletPath());
        System.out.println("获得请求的字符串"+req.getQueryString());
        System.out.println("获得请求的协议"+req.getProtocol());
        System.out.println("获得请求的ip地址"+req.getRemoteAddr());
        System.out.println("获得请求的URI"+req.getRequestURI());
        System.out.println("获得请求的URL"+req.getRequestURL());
    }
}
