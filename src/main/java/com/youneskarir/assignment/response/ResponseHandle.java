package com.youneskarir.assignment.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandle {
    
    public static ResponseEntity<Object> build(String message, HttpStatus status, Object object)
    {
        Map<String,Object> data =  new HashMap<>();
        data.put("message",message);
        data.put("status",status);
        if(object!=null) data.put("data",object);
        return new ResponseEntity<Object>(data,status);
    }

    public static ResponseEntity<Object> buildToken(String message, HttpStatus status, Object object)
    {
        Map<String,Object> data =  new HashMap<>();
        data.put("message",message);
        data.put("status",status);
        if(object!=null) data.put("token",object);
        return new ResponseEntity<Object>(data,status);
    }
}
