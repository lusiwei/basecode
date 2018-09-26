package com.lusiwei;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class myFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("拦截到请求");
        chain.doFilter(req, resp);
        System.out.println("拦截到响应");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
