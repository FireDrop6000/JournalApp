package org.pratik.journalapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    void redisTest() {
        redisTemplate.opsForValue().set("email", "pratik.neel02@gmail.com");
        Object email = redisTemplate.opsForValue().get("email");
        Object salary = redisTemplate.opsForValue().get("salary");
        int a = 1;
    }
}
