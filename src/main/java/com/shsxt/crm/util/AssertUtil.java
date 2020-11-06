package com.shsxt.crm.util;


import com.shsxt.crm.exception.MyException;

public class AssertUtil {

    public static void isTrue(boolean flag,String msg,Integer code)  {
        if (flag){
            throw new MyException(msg,code);
        }
    }
}
