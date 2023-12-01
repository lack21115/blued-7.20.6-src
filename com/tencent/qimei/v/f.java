package com.tencent.qimei.v;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, f> f38424a = new ConcurrentHashMap();
    public static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final String f38425c;
    public j d;
    public boolean e = false;

    public f(String str) {
        this.f38425c = str;
        this.d = new j(this, str);
    }

    public static f a(String str) {
        f fVar;
        synchronized (f.class) {
            try {
                f fVar2 = f38424a.get(str);
                fVar = fVar2;
                if (fVar2 == null) {
                    fVar = new f(str);
                    f38424a.put(str, fVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public void a(boolean z) {
        synchronized (b) {
            this.e = z;
        }
    }

    public boolean a() {
        boolean z;
        synchronized (b) {
            z = this.e;
        }
        return z;
    }

    public final void b() {
        synchronized (this) {
            if (com.tencent.qimei.c.a.i()) {
                if (com.tencent.qimei.a.a.a(com.tencent.qimei.i.f.a(this.f38425c).b("s_s_t"))) {
                    com.tencent.qimei.k.a.b("SDK_INIT ｜ 策略", "距离上次请求Strategy超过24小时", new Object[0]);
                    if (!this.d.b.get()) {
                        com.tencent.qimei.b.a.a().a(this.d);
                    }
                    return;
                }
                k kVar = this.d.d;
                if (kVar != null) {
                    ((com.tencent.qimei.o.d) kVar).b();
                }
            }
        }
    }
}
