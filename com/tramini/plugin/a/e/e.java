package com.tramini.plugin.a.e;

import android.text.TextUtils;
import com.tramini.plugin.a.e.f;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/e/e.class */
public final class e extends f {
    private static com.tramini.plugin.a.c.a a(Object obj, String str, final String str2, JSONObject jSONObject, JSONArray jSONArray, String str3) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            Object obj2 = obj;
            if (!TextUtils.equals(str3, "0")) {
                obj2 = a(obj, str, stringBuffer, new f.c() { // from class: com.tramini.plugin.a.e.e.1
                    @Override // com.tramini.plugin.a.e.f.c
                    public final boolean a(Object obj3) {
                        return (obj3 instanceof List) || obj3.getClass().getName().contains(String.this);
                    }

                    @Override // com.tramini.plugin.a.e.f.c
                    public final f.a b(Object obj3) {
                        try {
                            if (obj3 instanceof List) {
                                List list = (List) obj3;
                                if (list != null && list.size() > 0) {
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= list.size()) {
                                            return f.a.a();
                                        }
                                        Object obj4 = list.get(i2);
                                        if (obj4.getClass().getName().contains(String.this)) {
                                            return f.a.a(obj4);
                                        }
                                        i = i2 + 1;
                                    }
                                }
                                return f.a.a();
                            }
                            return f.a.a(obj3);
                        } catch (Throwable th) {
                            return null;
                        }
                    }
                });
            }
            if (obj2 == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                try {
                    String optString = jSONArray.optString(i2);
                    Object a2 = a(obj2, jSONObject.optString(optString));
                    if (a2 != null) {
                        String obj3 = a2.toString();
                        if (!TextUtils.isEmpty(obj3)) {
                            jSONObject2.put(optString, obj3);
                        }
                    }
                } catch (Throwable th) {
                }
                i = i2 + 1;
            }
            if (jSONObject2.length() > 0) {
                com.tramini.plugin.a.c.a aVar = new com.tramini.plugin.a.c.a();
                aVar.f40498a = jSONObject2;
                return aVar;
            }
            return null;
        } catch (Throwable th2) {
            return null;
        }
    }

    public static com.tramini.plugin.a.c.a a(JSONObject jSONObject, com.tramini.plugin.a.c.c cVar, String str, String str2) {
        return a(a(jSONObject.optString("in_na"), str), jSONObject.optString("pre"), jSONObject.optString("clna"), jSONObject, cVar.e, str2);
    }
}
