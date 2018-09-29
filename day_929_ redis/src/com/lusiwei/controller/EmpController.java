package com.lusiwei.controller;

import com.alibaba.fastjson.JSON;
import com.lusiwei.pojo.Dept;
import com.lusiwei.pojo.Emp;
import com.lusiwei.service.EmpService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/empController")
public class EmpController extends BaseController {
    EmpService empService = new EmpService();

    public String queryEmpByDept(HttpServletRequest request, HttpServletResponse response) {
        Integer dept_id = Integer.parseInt(request.getParameter("dept_id"));
        System.out.println(dept_id);
        List<Emp> emps = empService.queryEmpByDept(dept_id);
        String string = JSON.toJSONString(emps);
        System.out.println(string);
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String queryAllDept(HttpServletRequest request, HttpServletResponse response) {
        List<Dept> depts = empService.queryAllDept();
        String string = JSON.toJSONString(depts);
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
