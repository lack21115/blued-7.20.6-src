package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/j1.class */
public final class j1 {

    /* renamed from: c  reason: collision with root package name */
    public static j1 f9148c;

    /* renamed from: a  reason: collision with root package name */
    public Context f9149a;
    public final Object b = new Object();

    public static j1 a() {
        if (f9148c == null) {
            b();
        }
        return f9148c;
    }

    public static void b() {
        synchronized (j1.class) {
            try {
                if (f9148c == null) {
                    f9148c = new j1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                z.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    public void a(Context context) {
        synchronized (this.b) {
            if (this.f9149a != null) {
                return;
            }
            this.f9149a = context;
            i0.a().a(context);
        }
    }

    public void a(String str, int i) {
        i0.a().a(str, i);
    }

    public void a(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        i0.a().a(str, i, str2, a(linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            i0.a().a(str, 0, str2, jSONObject);
        } catch (JSONException e) {
            z.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    public void b(String str, int i, String str2, LinkedHashMap<String, String> linkedHashMap) {
        i0.a().a(str, i, str2, a(linkedHashMap), System.currentTimeMillis());
    }
}
