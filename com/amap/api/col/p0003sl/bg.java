package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.bg  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bg.class */
public final class bg {
    private static bg a;
    private lb b;
    private LinkedHashMap<String, lc> c = new LinkedHashMap<>();
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
                if (a == null) {
                    a = new bg();
                } else if (a.b == null) {
                    a.b = lb.b();
                }
                bgVar = a;
            }
        }
        return bgVar;
    }

    private void d() {
        synchronized (this.c) {
            if (this.c.size() <= 0) {
                return;
            }
            for (Map.Entry<String, lc> entry : this.c.entrySet()) {
                entry.getKey();
                ((bc) entry.getValue()).a();
            }
            this.c.clear();
        }
    }

    private static void e() {
        a = null;
    }

    public final void a(bf bfVar) {
        synchronized (this.c) {
            bc bcVar = (bc) this.c.get(bfVar.b());
            if (bcVar == null) {
                return;
            }
            bcVar.a();
            this.c.remove(bfVar.b());
        }
    }

    public final void a(bf bfVar, Context context) throws hn {
        if (!this.c.containsKey(bfVar.b())) {
            bc bcVar = new bc((bw) bfVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.c) {
                this.c.put(bfVar.b(), bcVar);
            }
        }
        this.b.a(this.c.get(bfVar.b()));
    }

    public final void b() {
        d();
        this.b.e();
        this.b = null;
        e();
    }

    public final void b(bf bfVar) {
        bc bcVar = (bc) this.c.get(bfVar.b());
        if (bcVar != null) {
            synchronized (this.c) {
                bcVar.b();
                this.c.remove(bfVar.b());
            }
        }
    }
}
