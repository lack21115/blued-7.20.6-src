package com.tencent.qimei.n;

import android.content.Context;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/n/i.class */
public class i implements a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f38365a;
    public f b;

    public static i a() {
        i iVar;
        synchronized (i.class) {
            try {
                if (f38365a == null) {
                    synchronized (i.class) {
                        if (f38365a == null) {
                            f38365a = new i();
                        }
                    }
                }
                iVar = f38365a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public c a(String str, Object obj) {
        c cVar = new c();
        cVar.b.put(str, obj);
        return cVar;
    }

    public void a(Context context) {
        this.b = new f();
    }

    public final void a(String str, Map<String, Object> map, String str2, String str3) {
        String str4;
        String str5;
        d dVar = d.f38358a;
        String a2 = dVar.a(com.tencent.qimei.v.d.a(str3).D(), str);
        String c2 = com.tencent.qimei.l.d.a(str3).c();
        try {
            JSONObject jSONObject = new JSONObject();
            dVar.a(jSONObject, str3);
            com.tencent.qimei.c.c j = com.tencent.qimei.c.c.j();
            jSONObject.put(e.REPORT_DATA_IP.K, j.k());
            jSONObject.put(e.REPORT_DATA_NET_TYPE.K, j.m());
            jSONObject.put(e.REPORT_AD.K, c2);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            try {
                str5 = com.tencent.qimei.a.a.b(jSONObject.toString(), "dZdcQik9lkNsvFYx");
            } catch (Exception e) {
                e.printStackTrace();
                str5 = "";
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(e.REPORT_TYPE.K, str2);
            jSONObject2.put(e.REPORT_DATA.K, str5);
            str4 = jSONObject2.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            str4 = "";
        }
        com.tencent.qimei.a.a.a(a2, str4, new h(this));
        f fVar = this.b;
        if (fVar.a(str2)) {
            return;
        }
        Set<String> set = fVar.f38362a;
        set.add(str3 + str2);
    }

    public void b(String str, Map<String, Object> map, String str2, String str3) {
        boolean contains;
        if (com.tencent.qimei.v.d.a(str3).B() && com.tencent.qimei.c.a.i()) {
            f fVar = this.b;
            if (fVar.a(str2)) {
                contains = false;
            } else {
                contains = fVar.f38362a.contains(str3 + str2);
            }
            if (contains) {
                return;
            }
            com.tencent.qimei.b.a.a().a(new g(this, str, map, str2, str3));
        }
    }
}
