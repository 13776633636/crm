package com.shsxt.crm.dao;

import com.shsxt.crm.po.Role;
import com.shsxt.crm.po.RoleVo;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> list(RoleVo vo);

    Role queryRoleById(String id);

    Role queryRoleByName(String roleName);

    int addRole(RoleVo vo);

    int updateRole(RoleVo vo);


    int deleteRole(String id);

    List<Map<String, Object>> queryAllRoles(String userId);
}
