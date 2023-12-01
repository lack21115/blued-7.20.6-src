package com.tencent.qimei.l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qmsp.oaid2.VendorManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/l/d.class */
public class d implements com.tencent.qimei.g.c {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, d> f24660a = new ConcurrentHashMap();
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f24661c = new Object();
    public boolean d = false;

    public d(String str) {
        this.b = str;
    }

    public static d a(String str) {
        d dVar;
        synchronized (d.class) {
            try {
                d dVar2 = f24660a.get(str);
                dVar = dVar2;
                if (dVar2 == null) {
                    dVar = new d(str);
                    f24660a.put(str, dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public static /* synthetic */ void a(d dVar, com.tencent.qimei.c.d dVar2) {
        dVar.d = false;
        com.tencent.qimei.b.a.a().a(10000L, new b(dVar, dVar2));
        com.tencent.qimei.c.c j = com.tencent.qimei.c.c.j();
        c cVar = new c(dVar, dVar2);
        if (j.b == null) {
            cVar.a(3);
        } else if (j.h == null) {
            j.f24628c = SystemClock.elapsedRealtime();
            new VendorManager().getVendorInfo(j.b, new com.tencent.qimei.c.b(j, cVar));
        }
        com.tencent.qimei.k.a.b("SDK_INIT ｜ DeviceInfo", " 初始化完成 ", new Object[0]);
    }

    @Override // com.tencent.qimei.g.c
    public void a() {
        com.tencent.qimei.c.c.j().v();
    }

    @Override // com.tencent.qimei.g.c
    public void b() {
        com.tencent.qimei.c.c.j().v();
    }

    public String c() {
        String d = com.tencent.qimei.v.d.a(this.b).d();
        return !TextUtils.isEmpty(d) ? d : !com.tencent.qimei.v.d.a(this.b).y() ? "" : com.tencent.qimei.c.c.j().b();
    }

    public String d() {
        return !com.tencent.qimei.v.d.a(this.b).t() ? "" : com.tencent.qimei.c.c.j().c();
    }

    public String e() {
        String m = com.tencent.qimei.v.d.a(this.b).m();
        return !TextUtils.isEmpty(m) ? m : !com.tencent.qimei.v.d.a(this.b).j() ? "" : com.tencent.qimei.c.c.j().d();
    }

    public String f() {
        String e = com.tencent.qimei.v.d.a(this.b).e();
        return !TextUtils.isEmpty(e) ? e : !com.tencent.qimei.v.d.a(this.b).E() ? "" : com.tencent.qimei.c.c.j().h();
    }

    public String g() {
        String a2 = com.tencent.qimei.v.d.a(this.b).a();
        return !TextUtils.isEmpty(a2) ? a2 : !com.tencent.qimei.v.d.a(this.b).F() ? "" : com.tencent.qimei.c.c.j().i();
    }

    public String h() {
        String o = com.tencent.qimei.v.d.a(this.b).o();
        return !TextUtils.isEmpty(o) ? o : !com.tencent.qimei.v.d.a(this.b).q() ? "" : com.tencent.qimei.c.c.j().l();
    }

    public String i() {
        String p = com.tencent.qimei.v.d.a(this.b).p();
        return !TextUtils.isEmpty(p) ? p : !com.tencent.qimei.v.d.a(this.b).n() ? "" : com.tencent.qimei.c.c.j().e();
    }

    public String j() {
        String str;
        String A = com.tencent.qimei.v.d.a(this.b).A();
        return !TextUtils.isEmpty(A) ? A : (com.tencent.qimei.v.d.a(this.b).h() && (str = com.tencent.qimei.c.c.j().h) != null) ? str : "";
    }
}
