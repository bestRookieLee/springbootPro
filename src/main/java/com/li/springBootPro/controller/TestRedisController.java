package com.li.springBootPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/testRedis")
public class TestRedisController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = "/hiRedis",method = RequestMethod.GET)
    public String hiRedis(){
        redisTemplate.opsForValue().set("mykeyFromSrping10", new Date().toString());
        return redisTemplate.opsForValue().get("mykeyFromSrping10");
    }

}
