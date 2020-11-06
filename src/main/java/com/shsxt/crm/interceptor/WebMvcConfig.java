package com.shsxt.crm.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    MyInterception myInterception;

  /* @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index");
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(myInterception);
        registration.addPathPatterns("/**");
        registration.excludePathPatterns("/index","/user/login","/css/**","/images/**","/js/**","/lib/**");
    }




}
