package com.springutil.test.test200814;

// import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64使用
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年09月03日
 */
public class Base64EncoderTest {

    public static void main(String[] args) {
        // useBase64Encoder();
        // useBase64();

        useJava8Base64();
    }

    /**
     * 早期用法
     */
    static void useBase64Encoder() {
        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        final String text = "字串文字";
        final byte[] textByte;
        try {
            textByte = text.getBytes(StandardCharsets.UTF_8);
            //编码 5a2X5Liy5paH5a2X
            final String encodedText = encoder.encode(textByte);
            System.out.println("加密后：" + encodedText);
            //解码
            System.out.println("解密后：" + new String(decoder.decodeBuffer(encodedText), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Apache Commons Codec作法
     */
    /*static void useBase64() {
        final Base64 base64 = new Base64();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes(StandardCharsets.UTF_8);
        //编码 5a2X5Liy5paH5a2X
        final String encodedText = base64.encodeToString(textByte);
        System.out.println("加密后：" + encodedText);
        //解码
        System.out.println("解密后：" + new String(base64.decode(encodedText), StandardCharsets.UTF_8));
    }*/
    static void useJava8Base64() {
        final String text = "字串文字";
        final byte[] textByte = text.getBytes(StandardCharsets.UTF_8);
        //编码
        final String encodedText = Base64.getEncoder().encodeToString(textByte);
        System.out.println("加密后：" + encodedText);
        //解码
        System.out.println("解密后：" + new String(Base64.getDecoder().decode(encodedText), StandardCharsets.UTF_8));
    }
}
