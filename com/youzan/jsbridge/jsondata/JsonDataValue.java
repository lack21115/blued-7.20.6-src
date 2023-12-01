package com.youzan.jsbridge.jsondata;

import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonAdapter(JsonDataTypeAdapter.class)
/* loaded from: source-8829756-dex2jar.jar:com/youzan/jsbridge/jsondata/JsonDataValue.class */
public class JsonDataValue {
    public String stringValue = null;
    public Map<String, JsonDataValue> mapValue = null;
    public List<JsonDataValue> arrayValue = null;

    public static List<JsonDataValue> getArrayFromData(JsonDataValue jsonDataValue) {
        if (jsonDataValue != null) {
            return jsonDataValue.arrayValue;
        }
        return null;
    }

    public static Map<String, JsonDataValue> getMapFromData(JsonDataValue jsonDataValue) {
        if (jsonDataValue != null) {
            return jsonDataValue.mapValue;
        }
        return null;
    }

    public static String getStringFromData(JsonDataValue jsonDataValue) {
        if (jsonDataValue != null) {
            return jsonDataValue.stringValue;
        }
        return null;
    }

    public static String getStringFromDataNotNull(JsonDataValue jsonDataValue) {
        return jsonDataValue != null ? jsonDataValue.getStringValueNotNull() : "";
    }

    public List<JsonDataValue> getArrayValueNotNull() {
        List<JsonDataValue> list = this.arrayValue;
        return list != null ? list : new ArrayList();
    }

    public Map<String, JsonDataValue> getMapValueNotNull() {
        Map<String, JsonDataValue> map = this.mapValue;
        return map != null ? map : new HashMap();
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public String getStringValueNotNull() {
        String str = this.stringValue;
        return str != null ? str : "";
    }
}
