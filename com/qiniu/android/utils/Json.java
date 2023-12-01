package com.qiniu.android.utils;

import com.google.gson.Gson;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/Json.class */
public final class Json {
    public static String encodeList(Collection collection) {
        return new JSONArray(collection).toString();
    }

    public static String encodeMap(Map map) {
        return new JSONObject(map).toString();
    }

    public static String object2Json(Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Throwable th) {
            return "";
        }
    }
}
