package com.shsxt.crm.service.impl;


import com.shsxt.crm.dao.UserRoleDao;
import com.shsxt.crm.po.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleService {

    @Resource
    UserRoleDao userRoleDao;

    public int deleteUser(Integer id){
        int row = userRoleDao.deleteUser(id);
        return row;
    }

    public int insertUserRole(UserRole userRole){
       int row = userRoleDao.insertUserRole(userRole);

       return 0;
    }


}
