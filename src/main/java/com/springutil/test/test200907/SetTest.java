package com.springutil.test.test200907;

import java.util.HashSet;
import java.util.Set;

/**
 * Set取并集
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年09月07日
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("英雄联盟");
                add("穿越火线");
                add("地下城与勇士");
            }
        };

        Set<String> set2 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("地下城与勇士");
                add("魔兽世界");
            }
        };

        Set<String> result = new HashSet<>(set1);
        set2.retainAll(result);
        System.out.println("交集：" + set2);
    }
}
