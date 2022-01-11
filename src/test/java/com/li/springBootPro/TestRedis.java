package com.li.springBootPro;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void set(){
//        for (int i = 0; i <10 ; i++) {
//            redisTemplate.opsForValue().set("mykeyFromSrping" + i, "helloRedis" + (10*i));
//        }
        redisTemplate.opsForValue().set("mykeyFromSrping10", "helloRedis10023");
            System.out.println(redisTemplate.opsForValue().get("mykeyFromSrping10"));
    }
}
