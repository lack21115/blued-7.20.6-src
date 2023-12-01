package com.bytedance.bdtracker;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bw;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/t.class */
public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public int f21306a;
    public volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    public long f21307c;
    public boolean d;
    public final v e;
    public final c f;

    public t(v vVar) {
        this.e = vVar;
        this.f = vVar.f21325c;
    }

    public final long a() {
        String str = com.alipay.sdk.util.e.f4661a;
        long b = b();
        if (b <= System.currentTimeMillis()) {
            try {
                boolean c2 = c();
                this.f21307c = System.currentTimeMillis();
                this.f21306a = c2 ? 0 : this.f21306a + 1;
                StringBuilder a2 = a.a("The worker:");
                a2.append(d());
                a2.append(" worked ");
                if (c2) {
                    str = bw.o;
                }
                a2.append(str);
                z2.a(a2.toString());
            } catch (Throwable th) {
                try {
                    z2.c("U SHALL NOT PASS!", th);
                } finally {
                    this.f21307c = System.currentTimeMillis();
                    this.f21306a++;
                    StringBuilder a3 = a.a("The worker:");
                    a3.append(d());
                    a3.append(" worked ");
                    a3.append(com.alipay.sdk.util.e.f4661a);
                    z2.a(a3.toString());
                }
            }
            return b();
        }
        return b;
    }

    public final long b() {
        if (g()) {
            Context a2 = this.e.a();
            s2.b(a2);
            s2.a(a2);
            if (!s2.b.a()) {
                z2.a("checkWorkTime, 0");
                return System.currentTimeMillis() + 5000;
            }
        }
        long j = 0;
        if (this.b) {
            this.f21307c = 0L;
            this.b = false;
        } else {
            int i = this.f21306a;
            if (i > 0) {
                long[] e = e();
                j = e[(i - 1) % e.length];
            } else {
                j = h();
            }
        }
        return this.f21307c + j;
    }

    public abstract boolean c();

    public abstract String d();

    public abstract long[] e();

    public boolean f() {
        return this.d;
    }

    public abstract boolean g();

    public abstract long h();

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends t> T i() {
        this.b = true;
        return this;
    }

    public void setStop(boolean z) {
        this.d = z;
    }
}
