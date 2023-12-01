package com.tramini.plugin.a.e;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/i.class */
public final class i extends f {
    private static com.tramini.plugin.a.c.a a(Object obj, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONArray jSONArray) {
        com.tramini.plugin.a.c.a a2;
        Method[] methodArr;
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
                Method[] c2 = c(obj2, str3);
                if (obj2 != null && c2 != null) {
                    int length = c2.length;
                    int i3 = 0;
                    while (i3 < length) {
                        Method method = c2[i3];
                        method.setAccessible(true);
                        try {
                            Object invoke = method.invoke(obj2, new Object[0]);
                            if (invoke instanceof JSONObject) {
                                try {
                                    if (((JSONObject) invoke).has(str4)) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        int i4 = 0;
                                        while (i4 < jSONArray.length()) {
                                            try {
                                                String optString = jSONArray.optString(i4);
                                                methodArr = c2;
                                                try {
                                                    String optString2 = jSONObject.optString(optString);
                                                    try {
                                                        if (TextUtils.equals(optString2, "all")) {
                                                            jSONObject2.put(optString, invoke.toString());
                                                        } else {
                                                            jSONObject2.put(optString, a(optString2, (JSONObject) invoke));
                                                        }
                                                        i4++;
                                                        c2 = methodArr;
                                                    } catch (Throwable th) {
                                                        methodArr = c2;
                                                    }
                                                } catch (Throwable th2) {
                                                }
                                            } catch (Throwable th3) {
                                            }
                                        }
                                        com.tramini.plugin.a.c.a aVar = new com.tramini.plugin.a.c.a();
                                        aVar.f26807a = jSONObject2;
                                        return aVar;
                                    }
                                } catch (Throwable th4) {
                                    c2 = c2;
                                    length = length;
                                }
                            }
                        } catch (Throwable th5) {
                        }
                        methodArr = c2;
                        i3++;
                        c2 = methodArr;
                    }
                    continue;
                } else if (obj2 != null && !str5.contains(obj2.getClass().getName()) && (a2 = a(obj2, str5, str2, str3, str4, jSONObject, jSONArray)) != null) {
                    return a2;
                }
                i = i2 + 1;
            }
        } catch (Throwable th6) {
            return null;
        }
    }

    public static com.tramini.plugin.a.c.a a(JSONObject jSONObject, com.tramini.plugin.a.c.c cVar, String str) {
        return a(a(jSONObject.optString("in_na"), str), "", jSONObject.optString("pre"), jSONObject.optString("mena"), jSONObject.optString("agu"), jSONObject, cVar.e);
    }

    private static String a(String str, JSONObject jSONObject) {
        String[] split;
        int i;
        JSONObject jSONObject2;
        try {
            split = str.split(":");
            i = 0;
            jSONObject2 = jSONObject;
        } catch (Throwable th) {
            return "";
        }
        while (i < split.length) {
            int i2 = i + 1;
            if (i2 == split.length) {
                return jSONObject2.optString(split[i]);
            }
            try {
                jSONObject2 = new JSONObject(jSONObject2.optString(split[i]));
            } catch (JSONException e) {
                jSONObject2 = new JSONArray(jSONObject2.optString(split[i])).getJSONObject(0);
            }
            i = i2;
            return "";
        }
        return "";
    }

    private static Method[] c(Object obj, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return (Method[]) arrayList.toArray(new Method[0]);
                }
                Method method = declaredMethods[i2];
                if (method.getGenericReturnType().toString().contains(str)) {
                    arrayList.add(method);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
