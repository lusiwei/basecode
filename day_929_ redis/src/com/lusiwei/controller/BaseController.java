package com.lusiwei.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName= request.getParameter("method");
        methodName=methodName==null?"defaultMethod":methodName;
        Class<? extends BaseController> aClass = this.getClass();
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            String invoke = (String) method.invoke(this, request, response);
            if (invoke != null) {
                if (invoke.contains("redirect")) {
                    response.sendRedirect(invoke.substring(invoke.indexOf(":")+1));
                }else{
                    request.getRequestDispatcher(invoke).forward(request,response);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
