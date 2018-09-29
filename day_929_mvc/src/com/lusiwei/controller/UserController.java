package com.lusiwei.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userController")
public class UserController extends BaseController{
    public String queryList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("方法执行了");
        return "redirect:index.jsp";
    }

    public String defaultMethod(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("默认方法执行了");
        return "index.jsp";
    }
}
