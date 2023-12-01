package com.youzan.jsbridge.util;

import com.google.gson.stream.JsonWriter;
import com.youzan.jsbridge.jsondata.JsonDataTypeAdapter;
import com.youzan.jsbridge.jsondata.JsonDataValue;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/util/JsonDataUtil.class */
public class JsonDataUtil {
    public static String transferJsonDataToString(JsonDataValue jsonDataValue) {
        if (jsonDataValue != null) {
            StringWriter stringWriter = new StringWriter();
            try {
                new JsonDataTypeAdapter().write(new JsonWriter(stringWriter), jsonDataValue);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringWriter.toString();
        }
        return null;
    }

    public static Map<String, String> transferToStringParams(Map<String, JsonDataValue> map) {
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, JsonDataValue> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), transferJsonDataToString(entry.getValue()));
            }
            return hashMap;
        }
        return null;
    }
}
