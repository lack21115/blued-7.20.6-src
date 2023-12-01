package com.ishumei.sdk.captcha;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/sdk/captcha/O000O00000o0O.class */
public class O000O00000o0O {
    public static JSONArray O0000O000000oO(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new JSONException("Not a primitive data: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return jSONArray;
            }
            jSONArray.put(O000O00000OoO(Array.get(obj, i2)));
            i = i2 + 1;
        }
    }

    public static JSONArray O0000O000000oO(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null) {
            for (Object obj : collection) {
                jSONArray.put(O000O00000OoO(obj));
            }
        }
        return jSONArray;
    }

    public static JSONObject O0000O000000oO(Map<?, ?> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new NullPointerException("key == null");
                }
                try {
                    jSONObject.put(str, O000O00000OoO(entry.getValue()));
                } catch (JSONException e) {
                }
            }
            return jSONObject;
        } catch (Exception e2) {
            return jSONObject;
        }
    }

    private static Object O000O00000OoO(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
            try {
                if (obj instanceof Collection) {
                    return O0000O000000oO((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return O0000O000000oO(obj);
                }
                if (obj instanceof Map) {
                    return O0000O000000oO((Map<?, ?>) obj);
                }
                String str = obj;
                if (!(obj instanceof Boolean)) {
                    str = obj;
                    if (!(obj instanceof Byte)) {
                        str = obj;
                        if (!(obj instanceof Character)) {
                            str = obj;
                            if (!(obj instanceof Double)) {
                                str = obj;
                                if (!(obj instanceof Float)) {
                                    str = obj;
                                    if (!(obj instanceof Integer)) {
                                        str = obj;
                                        if (!(obj instanceof Long)) {
                                            str = obj;
                                            if (!(obj instanceof Short)) {
                                                if (obj instanceof String) {
                                                    return obj;
                                                }
                                                if (!obj.getClass().getPackage().getName().startsWith("java.")) {
                                                    return null;
                                                }
                                                str = obj.toString();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return str;
            } catch (Exception e) {
                return null;
            }
        }
        return obj;
    }
}
