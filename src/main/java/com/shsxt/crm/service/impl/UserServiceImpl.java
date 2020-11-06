package com.shsxt.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.exception.MyException;
import com.shsxt.crm.po.User;
import com.shsxt.crm.po.UserRole;
import com.shsxt.crm.po.UserVo;
import com.shsxt.crm.service.UserService;
import com.shsxt.crm.util.AssertUtil;
import com.shsxt.crm.util.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Resource
    UserRoleService userRoleService;

    @Override
    public User queryUserByName(String userName) {
        //判断是否为空
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名不能为空",400);
        //查询数据库
        User user = userDao.queryUserByName(userName);
        return user;
    }


    public User login (String userName,String userPwd)  {

        AssertUtil.isTrue(StringUtils.isBlank(userPwd),"用户密码不能为空",400);
        //查询数据，返回User
        User user = userDao.queryUserByName(userName);
        AssertUtil.isTrue( null == user,"用户不存在",400);
        //校验密码
        String str = Md5Util.encode(userPwd);
        System.out.println(userPwd);
        System.out.println(str);
        System.out.println(user.getUserPwd());
        AssertUtil.isTrue(!str.equals(user.getUserPwd()),"用户密码不正确",400);
        return user;
    }


    public void updatePwd(String id, String oldPwd, String newPwd, String repeatPwd)  {
        AssertUtil.isTrue(StringUtils.isBlank(oldPwd),"旧密码不能为空",400);
        AssertUtil.isTrue(StringUtils.isBlank(newPwd),"新密码不能为空",400);
        AssertUtil.isTrue(StringUtils.isBlank(repeatPwd),"确认密码不能为空",400);
        AssertUtil.isTrue(!newPwd.equals(repeatPwd),"两次输入密码不相同",400);
        AssertUtil.isTrue(oldPwd.equals(repeatPwd),"并没有改变",400);
        //根据id查询用户
        //System.out.println(id);
        User user = userDao.queryUserById(id);
        //将老密码加密，并判断和查询到的密码是否一致
        String str = Md5Util.encode(oldPwd);
        AssertUtil.isTrue(!str.equals(user.getUserPwd()),"旧密码输入错误",400);

        int row = userDao.updateUserPwd(id,Md5Util.encode(newPwd));
        AssertUtil.isTrue(row < 1 ,"修改失败",400);
    }

    @Override
    public User queryUserById(String userId) {
        AssertUtil.isTrue(StringUtils.isBlank(userId),"id不能为空",400);
        return  userDao.queryUserById(userId);
    }







    @Override
    public Map<String,Object> deleteUser(List<String> ids) {
        int row = userDao.deleteUser(ids);
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

    public Map<String,Object> list(UserVo vo) {

        //使用 pageHelper 帮我们处理了总记录数
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        //
        List<User> list = userDao.list(vo);
        PageInfo<User> pageInfo = new PageInfo<>(list);

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("code",0);
        map.put("msg","");
        map.put("count", pageInfo.getTotal());
        map.put("data",list);
        System.out.println(map);
        return map;
    }

    public int addUser(UserVo vo){

        //通过name查数据库，如果存在则表示已经存在该用户，不能再添加
        User user = userDao.queryUserByName(vo.getUserName());
        if (user == null){
            m1(vo);
            int row = userDao.addUser(vo);
            return row;//成功返回受影响行数
        }
        throw new MyException("用户已经存在",400);
    }

    @Override
    public Map<String, Object> updateUser(UserVo vo) {
        Map map = new HashMap();
        int row = userDao.updateUser(vo);//更新user表中的数据
        Integer userId = vo.getId();//获取用户id

         m1(vo);

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

    public  void m1(UserVo vo){
        Integer userId = vo.getId();//获取用户id
        //获取roleIds
        String[] roleIds=null;
        if (vo.getRoleIds().length > 0){
            userRoleService.deleteUser(userId);//删除userId的记录

            //int a = 1/0;测试全局事务处理

            roleIds = vo.getRoleIds();

            UserRole userRole = new UserRole();
            userRole.setUserId(userId);

            roleIds = vo.getRoleIds();
            //获取ids中的每一个值，添加
            for (int i=0 ; i < roleIds.length;i++) {
                //roleIds[i]
                userRole.setRoleId(roleIds[i]);
                userRoleService.insertUserRole(userRole);
            }
        }
    }


}
