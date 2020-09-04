package com.springutil.test.test200814.robot;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Robot常用类
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年09月04日
 */
public class RobotCommon {
    public static void main(String[] args) {
        System.out.println((char) KeyEvent.VK_0);
    }

    public static void phoneToAscii(String phone, Robot robot) {
        for (char c : phone.toCharArray()) {
            robot.keyPress(c);
            robot.keyRelease(c);
        }
    }
}
