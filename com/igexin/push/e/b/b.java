package com.igexin.push.e.b;

import com.igexin.push.core.j;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/b/b.class */
public final class b extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23607a = -2147483642;
    private static final String b = "HeartBeatTimerTask";

    /* renamed from: c  reason: collision with root package name */
    private static b f23608c;

    public b() {
        super(j.a().b(), (byte) 0);
        this.p = true;
    }

    public static b g() {
        if (f23608c == null) {
            f23608c = new b();
        }
        return f23608c;
    }

    private static void p() {
    }

    @Override // com.igexin.push.e.b.f
    protected final void b() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        com.igexin.push.core.e.P = System.currentTimeMillis();
        if (!com.igexin.push.core.e.u) {
            com.igexin.c.a.c.a.a("HeartBeatTimerTask doTaskMethod isOnline = false, refresh wait time !!!!!!", new Object[0]);
            h();
            return;
        }
        System.currentTimeMillis();
        com.igexin.c.a.c.a.a("heartbeatReq", new Object[0]);
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.f();
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return f23607a;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d_() {
        super.d_();
        if (this.m) {
            return;
        }
        h();
    }

    public final void h() {
        a(j.a().b(), TimeUnit.MILLISECONDS);
    }
}
