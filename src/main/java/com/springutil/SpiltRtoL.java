package com.springutil;

/**
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年04月02日
 */
public class SpiltRtoL {

    /**
     * 将指定的字符串进行倒转
     *
     * @param s 要倒转的字符串
     * @return 返回值 java.lang.String 倒转后的字符串
     * @author 创建人 jiaohongtao
     */
    public static String spiltRtoL(String s) {

        StringBuilder sb = new StringBuilder();
        int length = s.length();
        char[] c = new char[length];
        for (int i = 0; i < length; i++) {
            c[i] = s.charAt(i);
        }
        for (int i = length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "com.abc.123";
        spiltRtoL(s);
        System.out.println(spiltRtoL(s));
    }
}
