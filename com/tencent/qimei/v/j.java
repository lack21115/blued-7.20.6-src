package com.tencent.qimei.v;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/j.class */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final String f24738a;

    /* renamed from: c  reason: collision with root package name */
    public final f f24739c;
    public volatile AtomicBoolean b = new AtomicBoolean(false);
    public k d = null;

    public j(f fVar, String str) {
        this.f24739c = fVar;
        this.f24738a = str;
    }

    public void a() {
        try {
            String c2 = com.tencent.qimei.i.f.a(this.f24738a).c("s_d");
            if (!c2.equals("")) {
                try {
                    c2 = com.tencent.qimei.a.a.a(c2, com.tencent.qimei.a.a.a("s_d"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (c2 != null) {
                a(c2, false);
            }
        } catch (Exception e2) {
            com.tencent.qimei.k.a.a(e2);
        } finally {
            c();
        }
    }

    public final void a(String str, String str2) {
        String str3;
        try {
            com.tencent.qimei.f.b bVar = com.tencent.qimei.f.b.KEY_CODE;
            bVar.f = str;
            String a2 = bVar.a(this.f24738a);
            if (!a2.equals("0")) {
                if (a2.equals("304")) {
                    com.tencent.qimei.i.f.a(this.f24738a).a("s_s_t", System.currentTimeMillis());
                }
                b();
                return;
            }
            com.tencent.qimei.f.b bVar2 = com.tencent.qimei.f.b.KEY_DATA;
            bVar2.f = str;
            try {
                str3 = com.tencent.qimei.a.a.a(bVar2.a(this.f24738a), str2);
            } catch (Exception e) {
                e.printStackTrace();
                str3 = "";
            }
            a(str3, true);
            this.f24739c.a(true);
            b();
        } catch (Throwable th) {
            com.tencent.qimei.k.a.a(th);
        }
    }

    public void a(String str, boolean z) {
        try {
            g.f24735a.put(this.f24738a, str);
            String str2 = this.f24738a;
            d.a(this.f24738a, new h(str2, d.a(str2)));
            if (z) {
                com.tencent.qimei.i.f a2 = com.tencent.qimei.i.f.a(this.f24738a);
                try {
                    str = com.tencent.qimei.a.a.b(str, com.tencent.qimei.a.a.a("s_d"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                a2.a("s_d", str);
                com.tencent.qimei.i.f.a(this.f24738a).a("s_s_t", System.currentTimeMillis());
            }
        } catch (Throwable th) {
            com.tencent.qimei.k.a.a(th);
        }
    }

    public final void b() {
        com.tencent.qimei.b.a.a().a(TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS), this);
        k kVar = this.d;
        if (kVar != null) {
            ((com.tencent.qimei.o.d) kVar).b();
        }
        this.b.set(false);
    }

    public final void c() {
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        this.b.set(true);
        String a2 = com.tencent.qimei.j.a.a();
        String D = d.a(this.f24738a).D();
        if (D.isEmpty()) {
            str = com.tencent.qimei.e.a.a() + "/config";
        } else {
            str = D + "/config";
        }
        String str3 = this.f24738a;
        com.tencent.qimei.u.d b = com.tencent.qimei.u.d.b();
        com.tencent.qimei.c.c j = com.tencent.qimei.c.c.j();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.qimei.w.c.KEY_CIPHER_KEY.k, com.tencent.qimei.a.a.c(a2, com.tencent.qimei.e.a.b()));
            String str4 = com.tencent.qimei.w.c.KEY_PLATFORM_ID.k;
            j.r();
            jSONObject.put(str4, 1);
            jSONObject.put(com.tencent.qimei.w.c.KEY_OS_VERSION.k, j.p());
            jSONObject.put(com.tencent.qimei.w.c.KEY_APP_VERSION.k, com.tencent.qimei.c.a.a());
            jSONObject.put(com.tencent.qimei.w.c.KEY_SDK_VERSION.k, b.getSdkVersion());
            jSONObject.put(com.tencent.qimei.w.c.KEY_AUDIT_VERSION.k, b.a() == null ? "" : b.a().O());
            jSONObject.put(com.tencent.qimei.w.c.KEY_APP_KEY.k, str3);
            jSONObject.put(com.tencent.qimei.w.c.KEY_CONFIG_VERSION.k, d.a(str3).r());
            jSONObject.put(com.tencent.qimei.w.c.KEY_PACKAGE_NAME.k, com.tencent.qimei.c.a.d());
            jSONObject.toString();
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            str2 = "";
        }
        com.tencent.qimei.a.a.a(str, str2, new i(this, a2));
    }
}
