package com.spring_util.test.test_20200707;

import org.springframework.util.StringUtils;

/**
 * 下划线大小写互转
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年08月10日
 */
public class FieldToColumn {

    public static String fieldToColumn(String filed) {
        if (StringUtils.isEmpty(filed)) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder(filed);
            int count = 0;
            builder.replace(0, 1, (filed.charAt(0) + "").toLowerCase());

            for (int i = 1; i < filed.length(); ++i) {
                char c = filed.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    builder.replace(i + count, i + count + 1, (c + "").toLowerCase());
                    builder.insert(i + count, "_");
                    ++count;
                }
            }
            return builder.toString();
        }
    }

    /**
     * 首字母大写
     *
     * @param filed 对应字符串
     */
    public static String firstCharacterToUpper(String filed) {
        return filed.substring(0, 1).toUpperCase() + filed.substring(1);
    }

    /**
     * 替换字符串并让它的下一个字母为大写
     *
     * @param filed   对应字符串
     * @param split   分隔符
     * @param replace 替换字符
     */
    public static String replaceUnderlineAndFirstToUpper(String filed, String split, String replace) {
        StringBuilder newString = new StringBuilder();
        int first;
        while (filed.contains(split)) {
            first = filed.indexOf(split);
            System.out.println("分隔符位置：" + first);
            if (first != filed.length()) {
                newString.append(filed, 0, first).append(replace);
                System.out.println("当前newString拼接为：" + newString);
                filed = filed.substring(first + split.length());
                filed = firstCharacterToUpper(filed);
            }
        }
        newString.append(filed);
        return newString.toString();
    }


    public static void main(String[] args) {
        System.out.println(fieldToColumn("abcdAbC"));
        System.out.println(replaceUnderlineAndFirstToUpper("abc_ef_g_h", "_", ""));
    }
}
