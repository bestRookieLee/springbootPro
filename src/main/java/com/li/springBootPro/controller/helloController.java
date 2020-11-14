package com.li.springBootPro.controller;

import com.li.springBootPro.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/helloYou")
public class helloController {
    @Autowired
    HelloMapper helloMapper;

    @RequestMapping(value = "/Hi",method = RequestMethod.GET)
    public String sayHiToYou(){
        return "long time no see,brother";
    }

    @RequestMapping(value = "/HiInfo",method = RequestMethod.GET)
    public Map<String, Object> getAllInfo(){
        Map<String, Object> result = new HashMap<>();
        result.put("count", helloMapper.getHelloInfoCount());
        result.put("top10", helloMapper.getHelloInfoLimit10());
        return result;
    }
}
