package com.baidu.mobads.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/j.class */
public class j {
    public static Bitmap a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "";
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    HashMap hashMap = new HashMap(map);
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    String[] strArr = ArticleInfo.PREDEFINED_KEYS;
                    int length = strArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i >= length) {
                            break;
                        }
                        String str = strArr[i];
                        int i4 = i3;
                        if (hashMap.containsKey(str)) {
                            String str2 = (String) hashMap.remove(str);
                            if (TextUtils.isEmpty(str2)) {
                                i4 = i3;
                            } else {
                                int length2 = str2.length() + i3;
                                i4 = i3;
                                if (length2 < 150) {
                                    hashMap2.put(str, str2);
                                    i4 = length2;
                                }
                            }
                        }
                        i++;
                        i2 = i4;
                    }
                    if (!hashMap.isEmpty()) {
                        Set<String> keySet = hashMap.keySet();
                        JSONArray jSONArray = new JSONArray();
                        for (String str3 : keySet) {
                            if (!TextUtils.isEmpty(str3)) {
                                String str4 = (String) hashMap.get(str3);
                                if (!TextUtils.isEmpty(str4)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("k", str3);
                                    jSONObject.put("v", str4);
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("ext", jSONArray.toString());
                            if (jSONObject2.toString().length() < 3000) {
                                hashMap2.put("ext", jSONObject2.toString());
                                return hashMap2;
                            }
                        }
                    }
                    return hashMap2;
                }
            } catch (Throwable th) {
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        } catch (Exception e) {
            bq.a().a("json2HashMap error");
        }
        return hashMap;
    }

    public static JSONArray a(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                JSONArray jSONArray2 = new JSONArray();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= list.get(i2).length) {
                        break;
                    }
                    jSONArray2.put(list.get(i2)[i4]);
                    i3 = i4 + 1;
                }
                jSONArray.put(jSONArray2);
                i = i2 + 1;
            } catch (Exception e) {
                bq.a().a(e);
            }
        }
        return jSONArray;
    }

    public static JSONArray a(double[] dArr) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (dArr != null) {
            try {
                JSONArray jSONArray3 = new JSONArray();
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= dArr.length) {
                            return jSONArray3;
                        }
                        jSONArray3.put(dArr[i2]);
                        i = i2 + 1;
                    } catch (Exception e) {
                        jSONArray = jSONArray3;
                        e = e;
                        bq.a().a(e);
                        jSONArray2 = jSONArray;
                        return jSONArray2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                jSONArray = null;
            }
        }
        return jSONArray2;
    }

    public static JSONObject a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(hashMap);
        } catch (Exception e) {
            bq.a().a("hashMap2Json error");
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }
}
