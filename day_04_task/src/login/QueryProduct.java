package login;

import dao.ProductDao;
import pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/query")
public class QueryProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        System.out.println(user);
        if (user==null){
            resp.setContentType("text/html;charset=utf-8");
            resp.sendRedirect("/redirect.html");

        }
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("<style>body{display: flex;justify-content: center;}table,td,th{border: 1px solid;}td{width: 80px;text-align: center;}</style>");
        stringBuffer.append("<table><tr><th>商品id</th><th>商品名字</th><th>商品价格</th></tr>");
        List<Product> products = new ProductDao().query();
        for (Product product : products) {
           stringBuffer.append("<tr>\n" +
                   "    <td>"+product.getPid()+"</td>\n" +
                   "    <td>"+product.getPname()+"</td>\n" +
                   "    <td>"+product.getPrice()+"</td>\n" +
                   "</tr>");
        }
        stringBuffer.append("</table>");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(stringBuffer.toString());
    }
}
