package com.li.springBootPro.controller;

import com.li.springBootPro.service.TestRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/testRedis")
public class TestRedisController {

    @Autowired
    TestRedisService testRedisService;

    @RequestMapping(value = "/typeString",method = RequestMethod.GET)
    public Object typeString(){
        return testRedisService.typeString();
    }

    @RequestMapping(value = "/typeHash",method = RequestMethod.GET)
    public Object typeHash(){
        return testRedisService.typeHash();
    }
}
