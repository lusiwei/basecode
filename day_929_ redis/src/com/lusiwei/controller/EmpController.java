package com.lusiwei.controller;

import com.alibaba.fastjson.JSON;
import com.lusiwei.pojo.Dept;
import com.lusiwei.pojo.Emp;
import com.lusiwei.service.EmpService;
import com.lusiwei.util.JedisUtil;
import org.apache.commons.beanutils.BeanUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/empController")
public class EmpController extends BaseController {
    EmpService empService = new EmpService();

    //通过部门id查询员工信息
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

    //
    //查询所有部门信息
    public String queryAllDept(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        Jedis jedisPool = JedisUtil.getJedisPool();
        String string;
        if (jedisPool.get("allDept") == null) {
            System.out.println("第一次访问,redis中没有数据,从数据库查询写到redis中");
            List<Dept> depts = empService.queryAllDept();
            string = JSON.toJSONString(depts);
            jedisPool.set("allDept", string);
            jedisPool.close();
        } else {
            System.out.println("不是第一次访问,从redis中读取写到前台");
            string = jedisPool.get("allDept");
        }
        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //增删改
    public String addEmp(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("进入addEmp");
        Jedis jedisPool = JedisUtil.getJedisPool();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Emp emp = new Emp();
        try {
            BeanUtils.populate(emp, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(emp));
        empService.addEmp(emp);
        jedisPool.del("allDept");
        jedisPool.close();
        return "redirect:index.html";
    }

    public void defaultMethod(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("默认方法执行了");
    }
}
