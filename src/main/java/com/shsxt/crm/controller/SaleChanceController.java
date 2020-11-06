package com.shsxt.crm.controller;


import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.po.SaleChance;
import com.shsxt.crm.po.SaleChanceVo;
import com.shsxt.crm.service.SaleChanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController {

    @Resource
    SaleChanceService saleChangeService;

    @RequestMapping("index")
    public String index() {
        return "saleChance/sale_chance";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> list(SaleChanceVo vo) {
        Map<String, Object> map = saleChangeService.queryList(vo);

        return map;
    }

    @RequestMapping("toAddOrUpdatePage")
    public String toAddOrUpdatePage(String saleChanceId, HttpServletRequest request) {
        if (saleChanceId != null) {
            SaleChance saleChance = saleChangeService.querySaleChanceById(saleChanceId);
            request.setAttribute("saleChance", saleChance);
        }

        return "saleChance/add_update";

    }

    @RequestMapping("add")
    @ResponseBody
    public Map<String, Object> insert(SaleChance vo) {
        int row = saleChangeService.insert(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);

        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> pdate(SaleChance vo) {
        int row = saleChangeService.update(vo);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);

        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> delete(String[] ids) {
        int row = saleChangeService.delete(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        return map;
    }

}
