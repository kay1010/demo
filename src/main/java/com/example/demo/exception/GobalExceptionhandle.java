package com.example.demo.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GobalExceptionhandle {


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map returnErrorMsg(Exception e){
        Map errorMap=new HashMap();
        errorMap.put("error","系统异常");
        errorMap.put("msg",e.getMessage());
        return errorMap;
    }

}
