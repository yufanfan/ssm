package cn.hibernate.day04OneToMany.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yu  fan on 2017/12/31.
 */

public class OpenSessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
