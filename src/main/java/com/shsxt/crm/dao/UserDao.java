package com.shsxt.crm.dao;

import com.shsxt.crm.po.User;
import com.shsxt.crm.po.UserVo;

import java.util.List;


//@Repository
public interface UserDao {
   User queryUserByName(String userName);

   User queryUserById(String id);

   int updateUserPwd(String id, String userPwd);

    List<User> list(UserVo vo);

    int addUser(UserVo vo);

    int updateUser(UserVo vo);

    int deleteUser(List<String> ids);
}
