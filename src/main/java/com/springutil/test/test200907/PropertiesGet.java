package com.springutil.test.test200907;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

/**
 * https://www.studyjava.cn/post/46
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年10月13日
 */
public class PropertiesGet {

    public static void main(String[] args) throws IOException, JSONException {
        InputStream is = PropertiesGet.class.getClassLoader().getResourceAsStream("author.properties");
        Properties pro = new Properties();
        pro.load(is);
        System.out.println(pro.getProperty("name"));

        /*Yaml yaml = new Yaml();
        URL url = ClassLoader.getSystemResource("application.yml");
        Map map = yaml.loadAs(new FileInputStream(url.getFile()), Map.class);

        JSONObject object = new JSONObject(map);
        // System.out.println(object.getJSONObject("my.test").get("name"));
        System.out.println(object.getJSONObject("spring").getJSONObject("redis").get("host"));//.get("name"));*/
    }
}
