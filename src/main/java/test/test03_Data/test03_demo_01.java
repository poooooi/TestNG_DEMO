package test.test03_Data;


import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;
import utils.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static config.envParam.*;

/**
 * @program: TestNG_DEMO
 * @description: 实现数据驱动
 * @author: poooooi
 * @create: 2021-03-17 20:37
 **/


public class test03_demo_01 {

    @Test
    public void Login() {
        Map<String, String> postHeader = new HashMap<>();
        postHeader.put("content-type", "application/json;charset=UTF-8");

        Map<String, String> form = new HashMap<>();
        form.put("ck", "");
        form.put("remember", "true");
        form.put("name", "182XXX1234");
        form.put("password", "123456");

        String postJson = "{\"ck\":,\"remember\":false,\"name\":\"182XXX1234\",\"password\":\"123456\"}";

        ArrayList<BasicNameValuePair> list = new ArrayList<>();
        form.forEach((key, value) -> list.add(new BasicNameValuePair(String.valueOf(key), String.valueOf(value))));
        for (Object object : list) {
            System.out.print(object);
        }

        System.out.println("登录结果:"+HttpUtil.doPostByJson(testURL,postJson,postHeader));
    }

}
