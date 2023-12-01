package com.tramini.plugin.a.e;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/c.class */
public final class c extends f {
    private static com.tramini.plugin.a.c.a a(Object obj, String str, String str2, JSONObject jSONObject, JSONArray jSONArray) {
        com.tramini.plugin.a.c.a a2;
        String str3;
        if (obj == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        String str4 = str + obj.getClass().getName() + ",";
        try {
            ArrayList arrayList = new ArrayList();
            a(obj.getClass(), arrayList);
            int size = arrayList.size();
            Field[] fieldArr = new Field[size];
            arrayList.toArray(fieldArr);
            if (size == 0) {
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return null;
                }
                Field field = fieldArr[i2];
                field.setAccessible(true);
                Object obj2 = field.get(obj);
                if (obj2 != null && (obj2 instanceof JSONObject)) {
                    String str5 = "";
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        int i3 = 0;
                        while (i3 < jSONArray.length()) {
                            String optString = jSONArray.optString(i3);
                            String optString2 = jSONObject.optString(optString);
                            if (TextUtils.equals(optString2, "all")) {
                                str3 = optString;
                            } else {
                                String a3 = a(optString2, (JSONObject) obj2);
                                str3 = str5;
                                if (!TextUtils.isEmpty(a3)) {
                                    jSONObject2.put(optString, a3);
                                    str3 = str5;
                                }
                            }
                            i3++;
                            str5 = str3;
                        }
                        if (jSONObject2.length() != 0) {
                            com.tramini.plugin.a.c.a aVar = new com.tramini.plugin.a.c.a();
                            if (!TextUtils.isEmpty(str5)) {
                                jSONObject2.put(str5, obj2.toString());
                            }
                            aVar.f40498a = jSONObject2;
                            return aVar;
                        }
                        continue;
                    } catch (Throwable th) {
                    }
                } else if (obj2 != null && !str4.contains(obj2.getClass().getName()) && (a2 = a(obj2, str4, str2, jSONObject, jSONArray)) != null) {
                    return a2;
                }
                i = i2 + 1;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static com.tramini.plugin.a.c.a a(JSONObject jSONObject, com.tramini.plugin.a.c.c cVar, String str) {
        return a(a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject, cVar.e);
    }

    private static String a(String str, JSONObject jSONObject) {
        try {
            String[] split = str.split(":");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= split.length) {
                    return "";
                }
                int i3 = i2 + 1;
                if (i3 == split.length) {
                    return jSONObject.optString(split[i2]);
                }
                jSONObject = jSONObject.optJSONObject(split[i2]);
                i = i3;
            }
        } catch (Throwable th) {
            return "";
        }
    }
}
