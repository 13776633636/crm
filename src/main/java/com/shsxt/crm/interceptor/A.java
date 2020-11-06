package com.shsxt.crm.interceptor;

import org.springframework.boot.devtools.remote.server.Dispatcher;
import org.springframework.boot.devtools.remote.server.DispatcherFilter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 过滤器
 *  所有的请求都过滤，将ctx加入到作用域中
 *
 */

@WebFilter("/*")
public class A implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest){
            HttpServletRequest r = (HttpServletRequest) request;
            request.setAttribute("ctx", r.getContextPath());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
