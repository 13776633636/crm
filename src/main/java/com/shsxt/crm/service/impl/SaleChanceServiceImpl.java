package com.shsxt.crm.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shsxt.crm.dao.SaleChanceDao;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.po.SaleChanceVo;
import com.shsxt.crm.service.SaleChanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleChanceServiceImpl implements SaleChanceService {

    @Resource
    SaleChanceDao saleChanceDao;

    public Map<String,Object> queryList(SaleChanceVo vo){
        //使用 pageHelper 帮我们处理了总记录数
        PageHelper.startPage(vo.getPage(),vo.getLimit());
        //
        List<SaleChance> list = saleChanceDao.queryList(vo);
        PageInfo<SaleChance> pageInfo = new PageInfo<>(list);

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("code",0);
        map.put("msg","");
        map.put("count", pageInfo.getTotal());
        map.put("data",list);

        System.out.println(map);

        return map;
    }

    @Override
    public int insert(SaleChance vo) {
        int row = saleChanceDao.insert(vo);

        return 0;
    }

    @Override
    public SaleChance querySaleChanceById(String saleChanceId) {
        SaleChance saleChance = saleChanceDao.querySaleChanceById(saleChanceId);

        return saleChance;
    }

    @Override
    public int update(SaleChance vo) {
        int row = saleChanceDao.update(vo);

        return row;
    }

    @Override
    public int delete(String[] ids) {
        int row = saleChanceDao.delete(ids);

        return row;
    }
}
