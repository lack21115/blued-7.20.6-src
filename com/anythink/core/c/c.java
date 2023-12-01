package com.anythink.core.c;

import android.text.TextUtils;
import com.anythink.core.common.k.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/c.class */
public final class c {
    private static String m = "ofm_logger";
    private static String n = "ofm_tk_sw";
    private static String o = "ofm_da_sw";
    private static String p = "tk_address";
    private static String q = "tk_max_amount";
    private static String r = "tk_interval";
    private static String s = "da_rt_keys_ft";
    private static String t = "tk_no_t_ft";
    private static String u = "da_not_keys_ft";
    private static String v = "ofm_system";
    private static String w = "ofm_tid";
    private static String x = "ofm_firm_info";
    private static String y = "ofm_st_vt";
    String a = String.valueOf(hashCode());
    public Map<String, Object> b;
    private boolean c;
    private int d;
    private int e;
    private long f;
    private int g;
    private int h;
    private String i;
    private int j;
    private long k;
    private Map<String, String> l;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.d = jSONObject.optInt(v);
            cVar.e = jSONObject.optInt(w);
            cVar.f = jSONObject.optLong(y);
            cVar.b = h.c(jSONObject.optString(x));
            JSONObject optJSONObject = jSONObject.optJSONObject(m);
            if (optJSONObject != null) {
                cVar.g = optJSONObject.optInt(n);
                cVar.h = optJSONObject.optInt(o);
                cVar.i = optJSONObject.optString(p);
                cVar.j = optJSONObject.optInt(q);
                cVar.k = optJSONObject.optLong(r);
                try {
                    JSONObject jSONObject2 = new JSONObject(optJSONObject.optString(t));
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.optString(next));
                    }
                    cVar.l = hashMap;
                } catch (Throwable th) {
                    return cVar;
                }
            }
            return cVar;
        } catch (Throwable th2) {
            return null;
        }
    }

    private int b() {
        return this.d;
    }

    private Map<String, Object> b(String str) {
        try {
            if (this.b != null) {
                return h.c(this.b.get(str).toString());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int c() {
        return this.e;
    }

    private static c c(String str) {
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            cVar.c = true;
            cVar.d = jSONObject.optInt(v);
            cVar.b = h.c(jSONObject.optString(x));
            cVar.g = 1;
            cVar.h = 1;
            return cVar;
        } catch (Throwable th) {
            return null;
        }
    }

    private int d() {
        return this.g;
    }

    private int e() {
        return this.h;
    }

    private String f() {
        return this.i;
    }

    private int g() {
        return this.j;
    }

    private long h() {
        return this.k;
    }

    private Map<String, String> i() {
        return this.l;
    }

    private String j() {
        return this.a;
    }

    private boolean k() {
        return this.c;
    }

    public final long a() {
        return this.f;
    }
}
