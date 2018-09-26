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
        ServletRequest requestProxy = (ServletRequest) Proxy.newProxyInstance(myFilter.class.getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.equals("getParameter")) {
                    String invoke = (String) method.invoke(req, args);
                    if (invoke.contains("小马聪聪")) {
                        invoke = invoke.replace("小马聪聪", "****");
                    }
                    return invoke;
                } else {
                    return method.invoke(req, args);
                }
            }
        });
        chain.doFilter(requestProxy, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
