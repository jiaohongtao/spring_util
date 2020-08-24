package com.springutil.test.test_20200707;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年08月12日
 */
@Data
@Component
@ConfigurationProperties(prefix = "my.test")
public class PropertiesValue {
    private String name;
    private int age;
    private String sex;
}
