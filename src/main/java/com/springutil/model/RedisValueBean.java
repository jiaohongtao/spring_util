package com.springutil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Redis测试Bean
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年09月07日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisValueBean implements Serializable {
    private Integer id;
    private String username;
}
