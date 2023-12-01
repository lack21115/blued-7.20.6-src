package com.tencent.qimei.o;

import com.tencent.qimei.o.m;
import com.tencent.qimei.sdk.Qimei;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/w.class */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, w> f24709a = new ConcurrentHashMap();
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f24710c = new Object();

    public w(String str) {
        this.b = str;
    }

    public static w a(String str) {
        w wVar;
        synchronized (w.class) {
            try {
                w wVar2 = f24709a.get(str);
                wVar = wVar2;
                if (wVar2 == null) {
                    wVar = new w(str);
                    f24709a.put(str, wVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public final String a() {
        Qimei i = com.tencent.qimei.a.a.i(this.b);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(m.a.KEY_PARAMS_APP_KEY.W, this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String a2 = m.f24691a.a(com.tencent.qimei.j.a.a(), this.b, i, jSONObject.toString());
        com.tencent.qimei.b.a.a().a(new v(this, a2));
        return a2;
    }

    public final String b() {
        String c2;
        synchronized (this.f24710c) {
            c2 = com.tencent.qimei.i.f.a(this.b).c("tn");
        }
        return c2;
    }

    public final void b(String str) {
        if (com.tencent.qimei.c.a.i()) {
            synchronized (this.f24710c) {
                com.tencent.qimei.i.f.a(this.b).a("tn", str);
                com.tencent.qimei.i.f.a(this.b).a("t_s_t", System.currentTimeMillis());
            }
        }
    }

    public final void c(String str) {
        com.tencent.qimei.b.a.a().a(new v(this, str));
    }
}
