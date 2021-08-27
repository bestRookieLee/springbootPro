package com.li.springBootPro.service.impl;

import com.li.springBootPro.service.TestRedisService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TestRedisServiceImpl implements TestRedisService {

    private final static String yyyy_MM_dd = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public Map<String, Object> typeString(){
        SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd);
        if (!redisTemplate.hasKey("timeStampNum") && !redisTemplate.hasKey("mykeyFromSrping10")) {
            redisTemplate.opsForValue().set("timeStampNum", String.valueOf(new Date().getTime()));
            redisTemplate.opsForValue().set("mykeyFromSrping10", sdf.format(new Date()));
        }
        //反返回map 键值对
        Map<Object, Object> map = redisTemplate.opsForHash().entries("runoobkey");
        for(Map.Entry<Object, Object> entry: map.entrySet()){
            System.out.println("key is: " + entry.getKey() + " value is:" + entry.getValue());
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("timeStampNum", redisTemplate.opsForValue().get("timeStampNum"));
        resultMap.put("mykeyFromSrping10", redisTemplate.opsForValue().get("mykeyFromSrping10"));
        resultMap.put("map", map);
        return resultMap;
    }

    public Map<String, String> typeHash(){
        String key = "hash";
        Map<String, String> map = new HashMap<String,String>();
        map.put("f1", "val1");
        map.put("f2", "val2");
        // 相当于hmset命令
        redisTemplate.opsForHash().putAll(key, map);
        // 相当于hset命令
        redisTemplate.opsForHash().put(key, "f3", "6");
        printValueForhash (redisTemplate, key, "f3");
        // 相当于 hexists key filed 命令
        boolean exists = redisTemplate.opsForHash().hasKey(key, "f3");
        System.out.println(exists);
        // 相当于hgetall命令
        Map keyValMap = redisTemplate.opsForHash().entries(key);
        //相当于hincrby命令
        redisTemplate.opsForHash().increment(key, "f3",2);
        printValueForhash (redisTemplate, key, "f3");
        //相当于hincrbyfloat命令
        redisTemplate.opsForHash().increment (key, "f3", 0.88);
        printValueForhash(redisTemplate, key, "f3");
        //相当于hvals命令
        List valueList = redisTemplate.opsForHash().values(key);
        //相当于hkeys命令
        Set keyList = redisTemplate.opsForHash().keys(key);
        List<String> fieldList = new ArrayList<String>();
        fieldList.add("f1");
        fieldList.add("f2");
        //相当于hmget命令 获取keyList中所有field对应的值
        List valueList2 = redisTemplate.opsForHash().multiGet(key, keyList);
        //相当于hsetnx命令 当field不存在的时候设置这个field的值
        boolean success = redisTemplate.opsForHash().putIfAbsent(key, "f4", "val4");
        System.out.println(success);
        //相当于hdel命令
        Long result = redisTemplate.opsForHash().delete(key, "fl", "f2");
        System.out.println(result);
        return null;
    }

    private static void printValueForhash(RedisTemplate redisTemplate,String key,String field) {
        //相当于hget命令
        Object value = redisTemplate.opsForHash().get(key,field);
        System.out.println(value);
    }
}
