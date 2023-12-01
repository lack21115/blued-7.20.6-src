package com.igexin.push.c;

import android.content.Intent;
import android.os.Bundle;
import com.igexin.push.e.b.d;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c.class */
public final class c {

    /* renamed from: a */
    public static final String f23327a = "ConnectModelCoordinator";
    private static final long i = 20000;
    private static final long j = 200000;
    public boolean b;

    /* renamed from: c */
    public long f23328c;
    public int d;
    public com.igexin.push.c.b e;
    private int f;
    private int g;
    private int h;
    private long k;
    private a l;

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c$a.class */
    public enum a {
        WIFI,
        MOBILE
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c$b.class */
    public static final class b {

        /* renamed from: a */
        private static final c f23335a = new c((byte) 0);

        private b() {
        }

        public static /* synthetic */ c a() {
            return f23335a;
        }
    }

    private c() {
        this.f = com.igexin.push.config.d.x;
        this.g = com.igexin.push.config.d.z;
        this.e = new d();
        this.l = com.igexin.push.f.c.b() ? a.WIFI : a.MOBILE;
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private static void a(int i2) {
        if (com.igexin.push.core.e.l == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("com.igexin.sdk.action.polling");
            Bundle bundle = new Bundle();
            bundle.putInt("code", i2);
            intent.putExtras(bundle);
            intent.setPackage(com.igexin.push.core.e.l.getPackageName());
            com.igexin.push.core.e.l.sendBroadcast(intent);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(f23327a, th.toString());
        }
    }

    private void a(boolean z) {
        this.b = z;
        com.igexin.c.a.c.a.a("ConnectModelCoordinator|init, current is polling mdl = ".concat(String.valueOf(z)), new Object[0]);
        if (z) {
            d.a.f23611a.g();
        }
    }

    private static c e() {
        return b.f23335a;
    }

    private com.igexin.push.c.b f() {
        return this.e;
    }

    private void g() {
        this.f23328c = System.currentTimeMillis();
        if (!this.b) {
            b();
            return;
        }
        com.igexin.c.a.c.a.a(f23327a, "loginRsp| enter polling");
        this.e = new e();
        d.a.f23611a.g();
        this.d = 0;
    }

    private void h() {
        com.igexin.push.c.b bVar;
        if (!this.b || (bVar = this.e) == null || (bVar instanceof d)) {
            return;
        }
        this.e = new d();
    }

    private static void i() {
        a(0);
    }

    private static void j() {
        a(1);
    }

    public final void a() {
        synchronized (this) {
            a aVar = com.igexin.push.f.c.b() ? a.WIFI : a.MOBILE;
            if (aVar != this.l) {
                com.igexin.c.a.c.a.a(f23327a, "net type changed " + this.l + "->" + aVar);
                com.igexin.c.a.c.a.a("ConnectModelCoordinator|net type changed " + this.l + "->" + aVar, new Object[0]);
                b();
                this.l = aVar;
            }
        }
    }

    public final void b() {
        com.igexin.c.a.c.a.a("ConnectModelCoordinator|reset current mdl = normal", new Object[0]);
        com.igexin.push.c.b bVar = this.e;
        if (bVar != null && !(bVar instanceof d)) {
            this.e = new d();
        }
        d.a.f23611a.h();
        this.d = 0;
        this.h = 0;
        this.b = false;
        com.igexin.push.core.e.f.a().b(this.b);
    }

    public final void c() {
        synchronized (this) {
            if (this.b) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f23328c;
            if (currentTimeMillis > i && currentTimeMillis < j) {
                this.h++;
                com.igexin.c.a.c.a.a(f23327a, "read len = -1, interval = " + currentTimeMillis + ", tcpDisconnectSuccess =" + this.h);
                com.igexin.c.a.c.a.a("ConnectModelCoordinator|read len = -1, interval = " + currentTimeMillis + ", tcpDisconnectSuccess =" + this.h, new Object[0]);
                if (this.h >= this.f) {
                    com.igexin.c.a.c.a.a(f23327a, "enter polling mode #####");
                    com.igexin.c.a.c.a.a("ConnectModelCoordinator|enter polling mode ####", new Object[0]);
                    a(0);
                    this.b = true;
                    this.e = new e();
                    d.a.f23611a.g();
                    com.igexin.push.core.e.f.a().b(this.b);
                }
            }
        }
    }

    public final void d() {
        synchronized (this) {
            if (this.b) {
                this.d++;
                com.igexin.c.a.c.a.a(f23327a, "polling mode, cur hearbeat = " + this.d);
                com.igexin.c.a.c.a.a("ConnectModelCoordinator|polling mode, cur hearbeat =" + this.d, new Object[0]);
                if (this.d >= this.g) {
                    com.igexin.c.a.c.a.a(f23327a, "enter normal mode #####");
                    com.igexin.c.a.c.a.a("ConnectModelCoordinator|enter normal mode ####", new Object[0]);
                    a(1);
                    com.igexin.push.core.e.O = 0L;
                    b();
                }
            }
        }
    }
}
