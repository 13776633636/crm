package com.shsxt.crm.controller;


import com.shsxt.crm.po.Role;
import com.shsxt.crm.po.RoleVo;
import com.shsxt.crm.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {

    @Resource
    RoleService roleService;

    /**
     * 角色管理主页面
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {

        return "role/role";
    }

    /**
     * 查询功能
     *
     * @param vo
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(RoleVo vo) {
        Map<String, Object> map = roleService.list(vo);

        return map;
    }

    /**
     * 添加的页面
     * 返回视图
     */
    @RequestMapping("addOrUpdateRolePage")
    public String addOrUpdateRolePage(HttpServletRequest request, String id) {
        //判断id是否存在，存在表示编辑角色，不存在表示添加角色
        if (id != null) {//通过id查询用户信息
            Role role = roleService.queryRoleById(id);
            //设置到作用域中
            request.setAttribute("role", role);
        }
        return "role/add_update";
    }

    /**
     * 添加角色
     */

    @RequestMapping("add")
    @ResponseBody
    public Map<String, Object> addRole(RoleVo vo) {
        Map<String, Object> map = roleService.addRole(vo);

        return map;
    }

    /**
     * 更新用户
     *
     * @param vo
     * @return
     */

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> updateRole(RoleVo vo) {
        Map<String, Object> map = roleService.updateRole(vo);

        return map;
    }

    /**
     * 删除角色
     */
    @ResponseBody
    @RequestMapping("delete")
    public Map<String, Object> delete(String roleId) {

        Map<String, Object> map = roleService.deleteRole(roleId);

        // Map<String, Object> map = roleService.deleteRole(ids);
        return map;

    }

    @RequestMapping("toAddGrantPage")
    public String toAddGrantPage() {

        return "role/grant";
    }

    @ResponseBody
    @RequestMapping("queryAllRoles")
    public List<Map<String, Object>> queryAllRoles(String userId) {

        List<Map<String, Object>> map = roleService.queryAllRoles(userId);
        return map;

    }
}
