package download;

import util.DownLoadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download")
public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fileName = req.getParameter("fileName");
        String realPath = req.getServletContext().getRealPath("/download/" + fileName);
        InputStream is = new FileInputStream(realPath);
        byte[] bytes = new byte[1024];
        int len = 0;
        System.out.println(req.getHeader("user-agent"));
        //设置文件mime类型
        resp.setContentType(req.getServletContext().getMimeType(fileName));
        fileName = DownLoadUtils.getFileName(req.getHeader("user-agent"), fileName);
        //设置content-disposition
        resp.setHeader("content-disposition", "attachment;fileName=" + fileName);
        while ((len = is.read(bytes)) != -1) {
            resp.getOutputStream().write(bytes, 0, len);
        }
        //关闭流
        is.close();
    }
}
