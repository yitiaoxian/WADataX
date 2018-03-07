package com.wangankeji.datax.common;

import com.alibaba.datax.common.util.Configuration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.derby.iapi.reference.ClassName;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

public class TestJson {
    private Configuration configuration;
    public static void main(String[] args) throws FileNotFoundException {
        TestJson i = new TestJson();
        JSONObject data = null;
        String message = "";
        data = JSONObject.parseObject(message);
        GetFile1();

    }
    private TestJson() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("E:/IdeaProjects/p.json");

        configuration = Configuration.from(fileInputStream);
        System.out.println(configuration);
        JSON json = (JSON) JSON.parse(String.valueOf(configuration));
        System.out.println("convert:"+json);
        //增加json数据
        configuration.set("测试增加的json","测试增加的json");
        System.out.println(configuration);
    }
    public static void GetFile1() throws FileNotFoundException {
        System.out.println(System.getProperty("user.dir"));
        String configPath = System.getProperty("user.dir")+"/common/src/main/config/p.json";
        System.out.println(configPath);
        InputStream inputStream = new FileInputStream(configPath);
    }


}
