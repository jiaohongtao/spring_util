package com.springutil;

import com.springutil.model.RedisValueBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年09月07日
 */
@SpringBootTest
public class RedisValueTests {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testObject() {
        RedisValueBean test = new RedisValueBean(111, "测试redis");
        ValueOperations<String, Serializable> opsForValue = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey("redisValueTest1");
        System.out.println(hasKey);
        opsForValue.set("redisValueTest1", test);
        hasKey = redisTemplate.hasKey("redisValueTest1");
        System.out.println(hasKey);
        Serializable testOut = opsForValue.get("redisValueTest1");
        System.out.println(testOut);

    }
}
