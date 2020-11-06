package com.shsxt.crm.base;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
   /* @ModelAttribute//请求前执行，可以用拦截器或者过滤器代替
    public void preHandler(HttpServletRequest request){
        request.setAttribute("ctx", request.getContextPath());
    }*/

}
