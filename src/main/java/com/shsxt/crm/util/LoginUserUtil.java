package com.shsxt.crm.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginUserUtil {

    //通过cookie中的name获取value,如果为null则返回 ""
    public static String releaseUserIdFromCookie(HttpServletRequest request,String id){
        Cookie[] cookies = request.getCookies();
        String value="";
        if(cookies == null){
            return value;
        }

        for (Cookie cookie : cookies){
            if (cookie.getName().equals(id)){
                value = cookie.getValue();
            }
        }
        return value;
    }
}
