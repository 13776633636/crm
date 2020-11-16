package com.shsxt.crm.service.impl;

import com.shsxt.crm.dao.CusPlanDao;
import com.shsxt.crm.service.CusPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CusPlanServiceImpl implements CusPlanService {

    @Resource
    CusPlanDao cusPlanDao;


}
