package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import com.kwad.sdk.core.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/core/utils/JsonHelper.class */
public class JsonHelper {
    public static <T> List<T> jsonArrayToList(String str, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            return jsonArrayToList(new JSONArray(str), cls);
        } catch (JSONException e) {
            b.printStackTraceOnly(e);
            return arrayList;
        }
    }

    public static <T> List<T> jsonArrayToList(JSONArray jSONArray, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            if (jSONArray.length() <= 0) {
                return arrayList;
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    Object obj = jSONArray.get(i2);
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                    i = i2 + 1;
                } catch (Exception e) {
                    b.printStackTraceOnly(e);
                }
            }
        }
        return arrayList;
    }

    public static void merge(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            Object opt = jSONObject2.opt(obj);
            if (opt != null) {
                try {
                    jSONObject.put(obj, opt);
                } catch (JSONException e) {
                }
            }
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        try {
            return parseJSON2MapString(new JSONObject(str));
        } catch (JSONException e) {
            return new HashMap();
        }
    }

    public static Map<String, String> parseJSON2MapString(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next, "");
            String str = "";
            if (!TextUtils.isEmpty(optString)) {
                str = TextUtils.equals(com.igexin.push.core.b.l, optString) ? "" : optString;
            }
            hashMap.put(next, str);
        }
        return hashMap;
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            if (map.isEmpty()) {
                return jSONObject;
            }
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e) {
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public static void putValue(JSONArray jSONArray, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        try {
            jSONObject.put(str, (int) b);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, double d) {
        try {
            jSONObject.put(str, d);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, float f) {
        try {
            jSONObject.put(str, f);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, int i) {
        try {
            jSONObject.put(str, i);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, IOfflineCompoJsonParse iOfflineCompoJsonParse) {
        if (iOfflineCompoJsonParse == null) {
            return;
        }
        try {
            jSONObject.put(str, iOfflineCompoJsonParse.toJson());
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (list == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        for (Object obj : list) {
            if (obj instanceof IOfflineCompoJsonParse) {
                putValue(jSONArray, ((IOfflineCompoJsonParse) obj).toJson());
            } else if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof Double) || (obj instanceof Boolean)) {
                jSONArray.put(obj);
            } else {
                if (!(obj instanceof Float)) {
                    break;
                }
                try {
                    jSONArray.put(((Float) obj).floatValue());
                } catch (JSONException e) {
                }
            }
            z = true;
        }
        if (z) {
            putValue(jSONObject, str, jSONArray);
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0 || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, z);
        } catch (JSONException e) {
        }
    }

    public static JSONArray toJsonArray(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static <T extends IOfflineCompoJsonParse> JSONArray toJsonArrayForJsonParseList(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        for (T t : list) {
            jSONArray.put(t.toJson());
        }
        return jSONArray;
    }
}
