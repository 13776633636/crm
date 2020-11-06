package com.shsxt.crm.controller;


import com.shsxt.crm.base.ResultInfo;
import com.shsxt.crm.po.User;
import com.shsxt.crm.po.UserVo;
import com.shsxt.crm.service.impl.UserServiceImpl;
import com.shsxt.crm.util.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * 用户管理模块
     * 点击用户管理 返回一个 用户列表(静态页面)
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        return "user/user";

    }

    /**
     * user/list
     * 通过pageNum pageSize。。信息查询用户列表 并显示在index页面
     *
     * @ResponseBody
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(UserVo vo) {
        Map<String, Object> map = userService.list(vo);

        return map;
    }


    /**
     * 返回添加用户的视图
     *
     * @return
     */
    @RequestMapping("addOrUpdateUserPage")

    public String addOrUpdateUserPage(HttpServletRequest request, String id) {

        //如果id！=null，则通过id查询用户并设置到请求域中
        if (id != null) {
            User user = userService.queryUserById(id);
            request.setAttribute("user", user);//与前端js中保持一致
        }

        return "user/add_update";
    }


    /**
     * 前端登录按钮
     *
     * @param userName 用户名
     * @param userPwd  密码
     * @return
     */
    @ResponseBody
    @RequestMapping("login")
    public ResultInfo login(String userName, String userPwd) {
        ResultInfo resultInfo = new ResultInfo();
        User user = userService.login(userName, userPwd);//通过姓名去查询数据库，并把返回的信息存到结果信息
        resultInfo.setCode(200);
        resultInfo.setMsg("登陆成功");
        resultInfo.setResult(user);
        return resultInfo;
    }


    @RequestMapping("query")
    public ResultInfo queryUserByName(String userName) {
        ResultInfo resultInfo = new ResultInfo();
        User user = userService.queryUserByName(userName);//通过姓名去查询数据库，并把返回的信息存到结果信息
        resultInfo.setCode(200);
        resultInfo.setMsg("登陆成功");
        resultInfo.setResult(user);
        return resultInfo;
    }

    @RequestMapping("toPasswordPage")
    public String toPasswordPage() {
        return "user/password";
    }


    /**
     * 更改密码功能的实现
     *
     * @param request
     * @param oldPwd
     * @param newPwd
     * @param repeatPwd
     * @return
     */
    @ResponseBody
    @RequestMapping("updatePwd")
    public ResultInfo updatePWD(HttpServletRequest request, String oldPwd, String newPwd, String repeatPwd) {
        String id = LoginUserUtil.releaseUserIdFromCookie(request, "id");
        userService.updatePwd(id, oldPwd, newPwd, repeatPwd);
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(200);
        resultInfo.setMsg("成功");
        resultInfo.setResult(null);
        return null;

    }

    /**
     * 新增用户功能
     * 不返回视图
     */
    @RequestMapping("add")
    @ResponseBody
    public Map<String, Object> addUser(UserVo vo) {
        int row = userService.addUser(vo);

        Map map = new HashMap();
        map.put("code", 200);
        map.put("message", "成功");
        return map;
    }

    /**
     * 更新用户信息
     */
    @ResponseBody
    @RequestMapping("update")
    public Map<String, Object> update(UserVo vo) {

        Map map = userService.updateUser(vo);
        return map;

    }

    /**
     * 删除用户
     */
    @ResponseBody
    @RequestMapping("delete")
    public Map<String, Object> delete(@RequestParam List<String> ids) {

        Map map = userService.deleteUser(ids);
        return map;

    }

}
