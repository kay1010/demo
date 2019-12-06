package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/*",dispatcherTypes =DispatcherType.REQUEST )
public class filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---------请求经过filter1-------");
        //逻辑操作。。。
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("------响应经过filter1-----------");
    }

    @Override
    public void destroy() {

    }
}
