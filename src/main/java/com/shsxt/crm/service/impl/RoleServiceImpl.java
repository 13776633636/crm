package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.dao.RoleDao;
import com.shsxt.crm.exception.MyException;
import com.shsxt.crm.po.Role;
import com.shsxt.crm.po.RoleVo;
import com.shsxt.crm.service.RoleService;
import com.shsxt.crm.util.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleDao roleDao;

    @Override
    public Map<String, Object> list(RoleVo  vo) {

        //使用 pageHelper 帮我们处理了总记录数
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<Role> list = roleDao.list(vo);
        System.out.println(list);
        PageInfo<Role> pageInfo = new PageInfo<>(list);

        Map<String, Object> map = new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count", pageInfo.getTotal());
        map.put("data",list);
        System.out.println(map);
        return map;


    }

    @Override
    public Role queryRoleById(String id) {
        AssertUtil.isTrue(StringUtils.isBlank(id),"id不能为空",400);
        Role role = roleDao.queryRoleById(id);

        return role;
    }

    @Override
    public Map<String, Object> addRole(RoleVo vo) {


        //通过name查数据库，如果存在则表示已经存在该用户，不能再添加
        Role role= roleDao.queryRoleByName(vo.getRoleName());
        if (role == null){
            int row = roleDao.addRole(vo);
            Map<String, Object> map  = new HashMap<>();
            map.put("code",200);
            return map;
        }
        throw new MyException("角色已经存在",400);


    }

    @Override
    public Map<String, Object> updateRole(RoleVo vo) {
        Map map = new HashMap();
        int row = roleDao.updateRole(vo);
        if (row > 0){
            map.put("code", 200);
            map.put("message", "成功");
            return map;
        }else{
            map.put("code", 400);
            map.put("message", "修改失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> deleteRole(String id) {
        int row = roleDao.deleteRole(id);

        Map map = new HashMap();
        if (row > 0){
            map.put("code", 200);
            map.put("message", "成功");
            return map;
        }else{
            map.put("code", 400);
            map.put("message", "修改失败");
            return map;
        }
    }

    @Override
    public List<Map<String, Object>>queryAllRoles(String userId) {
        List<Map<String, Object>> list = roleDao.queryAllRoles(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("data",list);

        return list;
    }



    /*
    @Override
    public Map<String, Object> deleteRole(String ids) {
        int row = roleDao.deleteRole(ids);
        Map map = new HashMap();
        if (row > 0){
            map.put("code", 200);
            map.put("message", "成功");
            return map;
        }else{
            map.put("code", 400);
            map.put("message", "修改失败");
            return map;
        }
    }*/




}
