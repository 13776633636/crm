package com.shsxt.crm.interceptor;

import com.shsxt.crm.util.LoginUserUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyInterception implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //request.setAttribute("ctx", request.getContextPath());

        String id = LoginUserUtil.releaseUserIdFromCookie(request,"id");
        if (null == id || "".equals(id)){
            //重定向到登陆页面
            System.out.println(request.getContextPath()+"/index");
            response.sendRedirect(request.getContextPath()+"/index");
            return false;
        }else{
            return true;
        }
    }
}
