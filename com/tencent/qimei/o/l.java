package com.tencent.qimei.o;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qimei.o.m;
import com.tencent.qimei.sdk.Qimei;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, l> f24689a = new ConcurrentHashMap();
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public Qimei f24690c;
    public boolean h = false;
    public String d = "";
    public long e = 0;
    public int f = 0;
    public boolean g = false;

    public l(String str) {
        this.b = str;
        Qimei qimei = new Qimei();
        this.f24690c = qimei;
        qimei.setAppKey(str);
    }

    public static l a(String str) {
        l lVar;
        synchronized (l.class) {
            try {
                l lVar2 = f24689a.get(str);
                lVar = lVar2;
                if (lVar2 == null) {
                    lVar = new l(str);
                    if (!lVar.h) {
                        lVar.a();
                        lVar.h = true;
                    }
                    f24689a.put(str, lVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public final void a() {
        synchronized (this) {
            b(com.tencent.qimei.a.a.e(this.b));
            com.tencent.qimei.q.a a2 = com.tencent.qimei.q.a.a(this.b);
            if (a2.a()) {
                a2.f = this.f24690c;
                Qimei qimei = new Qimei();
                this.f24690c = qimei;
                qimei.setAppKey(this.b);
                com.tencent.qimei.a.a.b(this.b);
                SharedPreferences sharedPreferences = com.tencent.qimei.i.f.a(this.b).b;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().remove("is_first").apply();
                }
                return;
            }
            String a3 = this.f24690c.a();
            String b = this.f24690c.b();
            if (TextUtils.isEmpty(a3) && TextUtils.isEmpty(b)) {
                com.tencent.qimei.k.a.b("QM", "Local qm cache not found, try load from old version cache(appKey: %s)", this.b);
                Qimei a4 = k.a();
                if (a4 == null) {
                    com.tencent.qimei.k.a.b("QM", "Local qm cache failed(appKey: %s)", this.b);
                    return;
                } else {
                    this.f24690c = a4;
                    this.g = true;
                }
            }
            com.tencent.qimei.k.a.b("QM", "(appKey: %s) Qm load successfully from cache, detail: %s", this.b, this.f24690c.toString());
        }
    }

    public final String b() {
        String d = com.tencent.qimei.l.d.a(this.b).d();
        return d == null ? "" : com.tencent.qimei.j.a.b(d);
    }

    public void b(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Qimei a2 = m.b.a(str);
        this.f24690c = a2;
        a2.setAppKey(this.b);
    }
}
