package com.shsxt.crm.service.impl;


import com.shsxt.crm.dao.MenuDao;
import com.shsxt.crm.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;


    @Override
    public  List<Map<String, Object>> selectList() {
        List<Map<String, Object>> map = menuDao.selectList();
        System.out.println(map);
        return map;
    }
}

