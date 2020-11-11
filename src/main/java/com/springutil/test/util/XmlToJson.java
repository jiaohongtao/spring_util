package com.springutil.test.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * xml 转换成 json
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年11月11日
 */
@Slf4j
public class XmlToJson {
    public static void main(String[] args) {
        String xml = " <message>\n" +
                "\t\t\t               <code>001</code>\n" +
                "\t\t\t               <test11>11</test11>\n" +
                "\t\t\t               <test22>22</test22>\n" +
                "\t\t\t               <data>\n" +
                "\t\t\t            \t\t\t<id>abcderftg</id>\n" +
                "\t\t\t            \t\t\t<title>测测测测测测测试</title>\n" +
                "\t\t\t            \t\t\t<name>asdaadsadasdasdada000001</name>\n" +
                "\t\t\t            \t\t\t<date>2020-09-29 11:11:11</date>\n" +
                "\t\t\t               </data>\n" +
                "\t\t\t            </message>";

        JSONObject json = new JSONObject();
        try {
            json = xmlToJson(xml.getBytes());
        } catch (JDOMException e) {
            log.error("JDOMException error:", e);
        } catch (IOException e) {
            log.error("IOException error:", e);
        }
        System.out.println(json.toJSONString());
    }


    public static JSONObject xmlToJson(byte[] xml) throws JDOMException, IOException {
        JSONObject json = new JSONObject();
        InputStream is = new ByteArrayInputStream(xml);
        SAXBuilder sb = new SAXBuilder();
        Document doc = sb.build(is);
        Element root = doc.getRootElement();
        json.put(root.getName(), iterateElement(root));
        return json;
    }

    private static JSONObject iterateElement(Element element) {
        List node = element.getChildren();
        Element et;
        JSONObject obj = new JSONObject();
        List list;
        for (Object o : node) {
            list = new LinkedList<>();
            et = (Element) o;
            if ("".equals(et.getTextTrim())) {
                if (et.getChildren().size() == 0) {
                    continue;
                }
                if (obj.containsKey(et.getName())) {
                    list = obj.getObject(et.getName(), List.class);
                }
                list.add(iterateElement(et));
                obj.put(et.getName(), list);
            } else {
                if (obj.containsKey(et.getName())) {
                    list = obj.getObject(et.getName(), List.class);
                }
                list.add(et.getTextTrim());
                obj.put(et.getName(), list);
            }
        }
        return obj;
    }

}
