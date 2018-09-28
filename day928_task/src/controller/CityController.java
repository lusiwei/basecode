package controller;

import com.alibaba.fastjson.JSON;
import pojo.City;
import service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cityController")
public class CityController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method.equals("getProvince")) {
            queryProvince(req, resp);
        } else if (method.equals("queryCity")) {
            System.out.println("进入queryCity");
            queryCity(req, resp);
        }
    }

    private void queryCity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pId = req.getParameter("pid");
        System.out.println(pId);
        List<City> cities = new CityService().queryCity(pId);
        String cString = JSON.toJSONString(cities);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(cString);
    }

    private void queryProvince(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<City> cities = new CityService().queryProvince();
        String string = JSON.toJSONString(cities);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(string);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
