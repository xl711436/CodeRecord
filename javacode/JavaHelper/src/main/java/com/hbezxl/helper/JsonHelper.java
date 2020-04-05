package com.hbezxl.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonHelper {


    public  static String ObjectToString(Object I_Obj)
    {
        String jsonString = JSON.toJSONString(I_Obj);

        return jsonString;
    }

    public static <T> T StringToObject(String I_Str, Class<T> I_Class) {
        T curClass = JSON.parseObject(I_Str,I_Class);
        return curClass;

    }

    public static JSONObject StringToJsonObject(String I_Str) {
        JSONObject curClass = JSON.parseObject(I_Str);
        return curClass;

    }


}
