package com.shsxt.crm.controller;

import com.shsxt.crm.po.User;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.util.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    UserService userService;

    /**
     * �����
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    // �������
    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * �������
     *
     * @return
     */
    @RequestMapping("main")
    public String main(HttpServletRequest request) {
        // 通过工具类，从cookie获取userId
        String userId = LoginUserUtil.releaseUserIdFromCookie(request, "id");
        // 通过id查询对象
        User user = userService.queryUserById(userId);
        // 将对象设置到request作用域中
        request.setAttribute("user", user);
        return "main";
    }
}