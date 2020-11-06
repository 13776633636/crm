package com.shsxt.crm.service;

import com.shsxt.crm.po.Role;
import com.shsxt.crm.po.RoleVo;

import java.util.List;
import java.util.Map;

public interface RoleService {


    Map<String, Object> list(RoleVo vo);

    Role queryRoleById(String id);

    Map<String, Object> addRole(RoleVo vo);

    Map<String, Object> updateRole(RoleVo vo);

    Map<String, Object> deleteRole(String id);

    List<Map<String, Object>> queryAllRoles(String userId);
}
