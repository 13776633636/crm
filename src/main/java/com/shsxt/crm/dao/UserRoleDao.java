package com.shsxt.crm.dao;

import com.shsxt.crm.po.UserRole;

public interface UserRoleDao {
    int deleteUser(Integer id);

    int insertUserRole(UserRole userRole);
}
