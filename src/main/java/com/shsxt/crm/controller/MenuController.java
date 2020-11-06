package com.shsxt.crm.controller;

import com.shsxt.crm.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("module")
public class MenuController {
    @Resource
    private MenuService menuService;


    @RequestMapping("queryAllModules")
    public  List<Map<String, Object>>selectList(){
        List<Map<String, Object>> map= menuService.selectList();


        return map;
    }



}
