package com.li.springBootPro.service.impl;

import com.li.springBootPro.service.TestRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestRedisServiceImpl implements TestRedisService {

    private final static String yyyy_MM_dd = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public Map<String, String> typeString(){
        SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd);
        if (!redisTemplate.hasKey("timeStampNum") && !redisTemplate.hasKey("mykeyFromSrping10")) {
            redisTemplate.opsForValue().set("timeStampNum", String.valueOf(new Date().getTime()));
            redisTemplate.opsForValue().set("mykeyFromSrping10", sdf.format(new Date()));
        }
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("timeStampNum", redisTemplate.opsForValue().get("timeStampNum"));
        resultMap.put("mykeyFromSrping10", redisTemplate.opsForValue().get("mykeyFromSrping10"));
        return resultMap;
    }
}
