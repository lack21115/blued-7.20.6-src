package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.bg  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bg.class */
public final class bg {

    /* renamed from: a  reason: collision with root package name */
    private static bg f4776a;
    private lb b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedHashMap<String, lc> f4777c = new LinkedHashMap<>();
    private boolean d = true;

    private bg() {
        try {
            if (this.b == null) {
                this.b = lb.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static bg a() {
        return c();
    }

    private static bg c() {
        bg bgVar;
        synchronized (bg.class) {
            try {
                if (f4776a == null) {
                    f4776a = new bg();
                } else if (f4776a.b == null) {
                    f4776a.b = lb.b();
                }
                bgVar = f4776a;
            }
        }
        return bgVar;
    }

    private void d() {
        synchronized (this.f4777c) {
            if (this.f4777c.size() <= 0) {
                return;
            }
            for (Map.Entry<String, lc> entry : this.f4777c.entrySet()) {
                entry.getKey();
                ((bc) entry.getValue()).a();
            }
            this.f4777c.clear();
        }
    }

    private static void e() {
        f4776a = null;
    }

    public final void a(bf bfVar) {
        synchronized (this.f4777c) {
            bc bcVar = (bc) this.f4777c.get(bfVar.b());
            if (bcVar == null) {
                return;
            }
            bcVar.a();
            this.f4777c.remove(bfVar.b());
        }
    }

    public final void a(bf bfVar, Context context) throws hn {
        if (!this.f4777c.containsKey(bfVar.b())) {
            bc bcVar = new bc((bw) bfVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.f4777c) {
                this.f4777c.put(bfVar.b(), bcVar);
            }
        }
        this.b.a(this.f4777c.get(bfVar.b()));
    }

    public final void b() {
        d();
        this.b.e();
        this.b = null;
        e();
    }

    public final void b(bf bfVar) {
        bc bcVar = (bc) this.f4777c.get(bfVar.b());
        if (bcVar != null) {
            synchronized (this.f4777c) {
                bcVar.b();
                this.f4777c.remove(bfVar.b());
            }
        }
    }
}
