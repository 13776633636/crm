package com.shsxt.crm.exception;


import com.shsxt.crm.base.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultInfo exceptionHandler(Exception e) {
        //Map map = new HashMap<>();
        ResultInfo resultInfo = new ResultInfo();

        resultInfo.setCode(300);
        resultInfo.setMsg("操作失败！");
        resultInfo.setResult(null);
        if (e instanceof MyException) {
            MyException pe = (MyException) e;
            resultInfo.setCode(pe.getCode());
            resultInfo.setMsg(pe.getMsg());

        }
        if (e instanceof NullPointerException){
            resultInfo.setCode(40001);
            resultInfo.setMsg("空指针异常");

        }
        if (e instanceof IOException){
            resultInfo.setCode(40002);
            resultInfo.setMsg("IOException");

        }
        return resultInfo;
    }

}
