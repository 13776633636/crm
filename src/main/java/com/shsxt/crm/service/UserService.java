package com.shsxt.crm.service;

import com.shsxt.crm.po.User;
import com.shsxt.crm.po.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {

    User queryUserByName(String userName) ;
    User queryUserById(String userId) ;


    Map<String,Object> updateUser(UserVo vo);

    Map deleteUser(List<String> ids);
}
