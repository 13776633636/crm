package com.shsxt.crm.po;

import com.shsxt.crm.base.BaseQuery;
/**
 * 前端分页查询的参数封装到此类
 */

public class SaleChanceVo extends BaseQuery  {
    private String createMan;
    private String state;

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}