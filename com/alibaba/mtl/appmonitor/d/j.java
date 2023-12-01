package com.alibaba.mtl.appmonitor.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/j.class */
public class j {
    private static final String TAG = null;

    /* renamed from: a  reason: collision with root package name */
    private static j f4469a;
    private String A;
    private Map<com.alibaba.mtl.appmonitor.a.f, g> q = new HashMap();
    private int r;

    private j() {
        com.alibaba.mtl.appmonitor.a.f[] values = com.alibaba.mtl.appmonitor.a.f.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            com.alibaba.mtl.appmonitor.a.f fVar = values[i2];
            if (fVar == com.alibaba.mtl.appmonitor.a.f.ALARM) {
                this.q.put(fVar, new f(fVar, fVar.e()));
            } else {
                this.q.put(fVar, new g(fVar, fVar.e()));
            }
            i = i2 + 1;
        }
    }

    public static j a() {
        if (f4469a == null) {
            synchronized (j.class) {
                try {
                    if (f4469a == null) {
                        f4469a = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4469a;
    }

    public static boolean a(com.alibaba.mtl.appmonitor.a.f fVar, String str, String str2) {
        return a().b(fVar, str, str2, (Map<String, String>) null);
    }

    public static boolean a(com.alibaba.mtl.appmonitor.a.f fVar, String str, String str2, Map<String, String> map) {
        return a().b(fVar, str, str2, map);
    }

    public static boolean a(String str, String str2, Boolean bool, Map<String, String> map) {
        return a().b(str, str2, bool, map);
    }

    public void a(com.alibaba.mtl.appmonitor.a.f fVar, int i) {
        g gVar = this.q.get(fVar);
        if (gVar != null) {
            gVar.setSampling(i);
        }
    }

    public void b(String str) {
        com.alibaba.mtl.log.e.i.a("SampleRules", "config:", str);
        synchronized (this) {
            if (!com.alibaba.mtl.appmonitor.f.b.isBlank(str) && (this.A == null || !this.A.equals(str))) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    com.alibaba.mtl.appmonitor.a.f[] values = com.alibaba.mtl.appmonitor.a.f.values();
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            this.A = str;
                            return;
                        }
                        com.alibaba.mtl.appmonitor.a.f fVar = values[i2];
                        JSONObject optJSONObject = jSONObject.optJSONObject(fVar.toString());
                        g gVar = this.q.get(fVar);
                        if (optJSONObject != null && gVar != null) {
                            com.alibaba.mtl.log.e.i.a(TAG, fVar, optJSONObject);
                            gVar.b(optJSONObject);
                        }
                        i = i2 + 1;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public boolean b(com.alibaba.mtl.appmonitor.a.f fVar, String str, String str2, Map<String, String> map) {
        g gVar = this.q.get(fVar);
        if (gVar != null) {
            return gVar.a(this.r, str, str2, map);
        }
        return false;
    }

    public boolean b(String str, String str2, Boolean bool, Map<String, String> map) {
        g gVar = this.q.get(com.alibaba.mtl.appmonitor.a.f.ALARM);
        if (gVar == null || !(gVar instanceof f)) {
            return false;
        }
        return ((f) gVar).a(this.r, str, str2, bool, map);
    }

    public void init(Context context) {
        k();
    }

    public void k() {
        this.r = new Random(System.currentTimeMillis()).nextInt(10000);
    }
}
