package com.springutil.test.test_20200707;

import com.springutil.model.User;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射链接数据库
 * href:https://blog.csdn.net/qq_43370892/article/details/107878103
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年08月10日
 */
public class JdbcUtil {

    public static void main(String[] args) {
        List<User> users = rsToList("select * from user", User.class);
        System.out.println(users);
    }

    /**
     * 封装结果集的通用方法
     */
    public static <T> List<T> rsToList(String sql, Class<T> c) {

        List<T> list = new ArrayList<>();
        //加载驱动，获取连接对象
        try {
            //加载驱动，获取连接对象
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.20.10.16:3306/ceshi_lts?useSSL=false", "root", "onceas");
            //获取执行sql对象,执行sql，返回结果集rs
            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery(sql);
            //3.遍历rs 借助元数据，获取列名和总列数
            ResultSetMetaData md = rs.getMetaData();
            int count = md.getColumnCount();
            while (rs.next()) {
                //循环一次获取一行数据，调用一次Object获取一个单元格的数据
                T t = c.newInstance();
                for (int i = 1; i <= count; i++) {
                    Object value = rs.getObject(i);
                    //每一列的列名充当T中的属性名，获取对应的属性管理对象f
                    Field f = c.getDeclaredField(md.getColumnName(i));
                    f.setAccessible(true);
                    //为私有属性赋值
                    f.set(t, value);
                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
