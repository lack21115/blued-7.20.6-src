package com.tramini.plugin.a.e;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/g.class */
public final class g extends f {
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a9, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tramini.plugin.a.c.a a(java.lang.Object r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, org.json.JSONObject r13, org.json.JSONArray r14) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.e.g.a(java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject, org.json.JSONArray):com.tramini.plugin.a.c.a");
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
