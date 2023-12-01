package com.tramini.plugin.a.e;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/d.class */
public final class d extends f {
    private static com.tramini.plugin.a.c.a a(Object obj, String str, String str2, String str3, JSONObject jSONObject, JSONArray jSONArray) {
        com.tramini.plugin.a.c.a a2;
        String str4;
        if (obj == null || !obj.getClass().getName().startsWith(str2)) {
            return null;
        }
        String str5 = str + obj.getClass().getName() + ",";
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
                Method c2 = c(obj2, str3);
                if (obj2 != null && c2 != null) {
                    c2.setAccessible(true);
                    try {
                        Object invoke = c2.invoke(obj2, new Object[0]);
                        if (invoke instanceof JSONObject) {
                            String str6 = "";
                            JSONObject jSONObject2 = new JSONObject();
                            int i3 = 0;
                            while (i3 < jSONArray.length()) {
                                try {
                                    String optString = jSONArray.optString(i3);
                                    try {
                                        String optString2 = jSONObject.optString(optString);
                                        if (TextUtils.equals(optString2, "all")) {
                                            str4 = optString;
                                        } else {
                                            String d = d(invoke, optString2);
                                            str4 = str6;
                                            if (!TextUtils.isEmpty(d)) {
                                                jSONObject2.put(optString, d);
                                                str4 = str6;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        str4 = str6;
                                    }
                                } catch (Throwable th2) {
                                    str4 = str6;
                                }
                                i3++;
                                str6 = str4;
                            }
                            try {
                                if (jSONObject2.length() > 0) {
                                    com.tramini.plugin.a.c.a aVar = new com.tramini.plugin.a.c.a();
                                    if (!TextUtils.isEmpty(str6)) {
                                        jSONObject2.put(str6, invoke.toString());
                                    }
                                    aVar.f26807a = jSONObject2;
                                    return aVar;
                                }
                                continue;
                            } catch (Throwable th3) {
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable th4) {
                    }
                } else if (obj2 != null && !str5.contains(obj2.getClass().getName()) && (a2 = a(obj2, str5, str2, str3, jSONObject, jSONArray)) != null) {
                    return a2;
                }
                i = i2 + 1;
            }
        } catch (Throwable th5) {
            return null;
        }
    }

    public static com.tramini.plugin.a.c.a a(JSONObject jSONObject, com.tramini.plugin.a.c.c cVar, String str) {
        return a(a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject.optString("mena"), jSONObject, cVar.e);
    }

    private static Method c(Object obj, String str) {
        Method method;
        try {
            ArrayList arrayList = new ArrayList();
            b(obj.getClass(), arrayList);
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                method = (Method) it.next();
            } while (!method.getGenericReturnType().toString().contains(str));
            return method;
        } catch (Exception e) {
            return null;
        }
    }

    private static String d(Object obj, String str) {
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            if (jSONObject.has(str)) {
                return jSONObject.optString(str);
            }
            while (keys.hasNext()) {
                Object opt = jSONObject.opt(keys.next());
                if ((opt instanceof JSONObject) || (opt instanceof JSONArray)) {
                    String d = d(opt, str);
                    if (!TextUtils.isEmpty(d)) {
                        return d;
                    }
                }
            }
        }
        if (!(obj instanceof JSONArray)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            JSONArray jSONArray = (JSONArray) obj;
            if (i2 >= jSONArray.length()) {
                return null;
            }
            Object opt2 = jSONArray.opt(i2);
            if ((opt2 instanceof JSONObject) || (opt2 instanceof JSONArray)) {
                String d2 = d(opt2, str);
                if (!TextUtils.isEmpty(d2)) {
                    return d2;
                }
            }
            i = i2 + 1;
        }
    }
}
