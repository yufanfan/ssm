package cn.hibernate.day05ManyToMany.filter;

import cn.hibernate.day05ManyToMany.util.HibernateUtil;
import org.hibernate.Transaction;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yu  fan on 2017/12/31.
 */

public class OpenFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //将请求管道交给下一个过滤器或者是处理器，service
        Transaction tx = HibernateUtil.getSession().beginTransaction();
        chain.doFilter(req, resp);
        tx.commit();
        HibernateUtil.getSession();
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
