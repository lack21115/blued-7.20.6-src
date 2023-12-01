package com.tencent.map.tools.json;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/json/JsonParser.class */
public interface JsonParser {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/json/JsonParser$Deserializer.class */
    public interface Deserializer<T> {
        T deserialize(Object obj, String str, Object obj2) throws JSONException;
    }

    void parse(JSONObject jSONObject);
}
