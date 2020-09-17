package com.springutil.test.test200907;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTime使用
 * https://www.cnblogs.com/wt20/p/8179118.html
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年09月17日
 */
public class TimeTest {
    public static void main(String[] args) {
        testTime();
    }

    public static void testTime() {
        LocalDateTime time = LocalDateTime.now();

        System.out.println(time.toString()); //字符串表示
        System.out.println(time.toLocalTime()); //获取时间(LocalTime)
        System.out.println(time.toLocalDate()); //获取日期(LocalDate)
        System.out.println(time.getDayOfMonth()); //获取当前时间月份的第几天
        System.out.println(time.getDayOfWeek());  //获取当前周的第几天
        System.out.println(time.getDayOfYear());  //获取当前时间在该年属于第几天
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getMonthValue());
        System.out.println(time.getMonth());
        System.out.println("-----------------------------------");
        //格式化输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(time.format(formatter));
        //构造时间
        LocalDateTime startTime = LocalDateTime.of(2018, 1, 1, 20, 31, 20);
        LocalDateTime endTime = LocalDateTime.of(2018, 1, 3, 20, 31, 20);
        //比较时间
        System.out.println(time.isAfter(startTime));
        System.out.println(time.isBefore(endTime));

        //时间运算，相加相减
        System.out.println(time.plusYears(2)); //加2年
        System.out.println(time.plusDays(2)); //加两天
        System.out.println(time.minusYears(2)); //减两年
        System.out.println(time.minusDays(2)); //减两天

        //获取毫秒数(使用Instant)
        System.out.println(time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        //获取秒数(使用Instant)
        System.out.println(time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
    }
}
