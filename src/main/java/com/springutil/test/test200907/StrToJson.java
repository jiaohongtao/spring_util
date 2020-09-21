package com.springutil.test.test200907;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

/**
 * 字符串转JSONArray
 *
 * @author jiaohongtao
 * @version 1.0
 * @since 2020年09月21日
 */
public class StrToJson {
    public static void main(String[] args) {
        String string = "name:zookeeper,alias_name:java,pid:23085|name:rabbitmq,alias_name:rabbitmq-server,pid:1386";
        try {
            System.out.println(strToJsonArray(string, "\\|", "\\,", "\\:"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param string    待分隔字符串 eg：name:zookeeper,alias_name:java|name:rabbitmq,alias_name:rabbitmq-server
     * @param arrSpit   数组分割字符 eg：\\|
     * @param objSpit   对象分隔字符 eg：\\,
     * @param fieldSpit 字段分隔字符 eg：\\:
     */
    public static JSONArray strToJsonArray(String string, String arrSpit, String objSpit, String fieldSpit) throws JSONException {

        string = string.replaceAll("\\s*|\r|\n", "");
        String[] stdoutArr = string.split(arrSpit, -1);

        JSONArray array = new JSONArray();
        for (String s : stdoutArr) {
            JSONObject object = new JSONObject();
            for (String kv : s.split(objSpit)) {
                String[] keyV = kv.split(fieldSpit, -1);
                object.put(keyV[0], keyV[1]);
            }
            array.put(object);
        }
        return array;
    }
}
