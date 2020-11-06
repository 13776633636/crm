package com.shsxt.crm.dao;

import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.po.SaleChanceVo;

import java.util.List;

public interface SaleChanceDao {
    List<SaleChance> queryList(SaleChanceVo vo);

    int insert(SaleChance vo);

    SaleChance querySaleChanceById(String saleChanceId);

    int update(SaleChance vo);

    int delete(String[] ids);
}
