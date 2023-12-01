package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/w.class */
public class w {
    public static Map<String, List<q>> a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> a2 = h0.a(context, str);
        b(a2);
        return a(a2);
    }

    public static Map<String, List<q>> a(Context context, String str, String str2) {
        Map<String, List<q>> a2;
        Map<String, List<q>> a3;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            z.c("hmsSdk", "read all event records");
            a2 = a(context, "stat_v2_1");
            a3 = a(context, "cached_v2_1");
        } else {
            String a4 = v0.a(str, str2);
            a2 = b(context, "stat_v2_1", a4);
            a3 = b(context, "cached_v2_1", a4);
        }
        return a(a2, a3);
    }

    public static Map<String, List<q>> a(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                a(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    public static Map<String, List<q>> a(Map<String, List<q>> map, Map<String, List<q>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    public static void a(String str, String str2, Map<String, List<q>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    map.put(str, arrayList);
                    return;
                }
                q qVar = new q();
                try {
                    qVar.a(jSONArray.getJSONObject(i2));
                    arrayList.add(qVar);
                } catch (JSONException e) {
                    z.e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
                i = i2 + 1;
            }
        } catch (JSONException e2) {
            z.e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    public static Map<String, List<q>> b(Context context, String str, String str2) {
        String a2 = h0.a(context, str, str2, "");
        HashMap hashMap = new HashMap();
        a(str2, a2, hashMap);
        return hashMap;
    }

    public static void b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> a2 = v0.a(b.b());
        while (it.hasNext()) {
            if (!a2.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }
}
