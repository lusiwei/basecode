import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@WebFilter("/*")
public class myFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入filter");
        ServletRequest requestProxy = (ServletRequest) Proxy.newProxyInstance(myFilter.class.getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String invoke = (String) method.invoke(req, args);
                    if (invoke.contains("小马聪聪")) {
                        invoke = invoke.replace("小马聪聪", "****");
                        System.out.println("--------");
                    }
                    return invoke;
                } else {
                    return method.invoke(req, args);
                }
            }
        });
        System.out.println(requestProxy);
        chain.doFilter(requestProxy, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
