package com.spring_util;

import com.spring_util.test.test_20200707.PropertiesValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年08月12日
 */
@SpringBootTest
public class PropertiesValueGet {
    @Autowired
    PropertiesValue value;

    @Test
    public void getMyTest() {
        System.out.println(value);
    }
}
