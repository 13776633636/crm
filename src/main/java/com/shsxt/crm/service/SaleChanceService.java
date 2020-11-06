package com.shsxt.crm.service;

import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.po.SaleChanceVo;

import java.util.Map;

public interface SaleChanceService {
     Map<String,Object> queryList(SaleChanceVo vo);

    int insert(SaleChance vo);

    SaleChance querySaleChanceById(String saleChanceId);

    int update(SaleChance vo);

    int delete(String[]  ids);
}
