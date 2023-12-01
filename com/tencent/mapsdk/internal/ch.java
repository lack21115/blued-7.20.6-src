package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.mapsdk.core.components.protocol.jce.rtt.RttRequest;
import com.tencent.mapsdk.core.components.protocol.jce.user.user_login_t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ch.class */
public class ch extends Thread {
    private static final String h = "rttserverex";
    private static final String i = "getRtt";
    private static final String j = "info";
    private static final String k = "req";
    public static final String l = "UTF-8";
    private static final int m = 30000;
    private rc b;

    /* renamed from: c  reason: collision with root package name */
    private ib f37374c;
    private boolean d = true;
    private boolean e = false;
    private boolean f = false;
    private List<ah> g;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ch$b.class */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f37375a;
        public int b;

        private b() {
        }
    }

    public ch(rc rcVar, ib ibVar) {
        this.b = null;
        this.f37374c = null;
        setName("tms-traffic-refresh");
        this.b = rcVar;
        this.f37374c = ibVar;
        this.g = new ArrayList();
    }

    private RttRequest a() {
        rc rcVar = this.b;
        RttRequest rttRequest = null;
        if (rcVar == null) {
            return null;
        }
        bh[] k2 = rcVar.S().k();
        if (k2 != null) {
            if (k2.length == 0) {
                return null;
            }
            rttRequest = new RttRequest();
            ArrayList<Integer> arrayList = new ArrayList<>();
            int length = k2.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                bh bhVar = k2[i3];
                arrayList.add(Integer.valueOf(bhVar.d));
                arrayList.add(Integer.valueOf(bhVar.f37330c));
                arrayList.add(Integer.valueOf(bhVar.f));
                arrayList.add(Integer.valueOf(bhVar.e));
                arrayList.add(Integer.valueOf(bhVar.g));
                i2 = i3 + 1;
            }
            rttRequest.bounds = arrayList;
            rttRequest.zip = (short) 1;
            rttRequest.zoom = (short) k2[0].f37329a;
        }
        return rttRequest;
    }

    private b a(double d, double d2) {
        double sin = Math.sin((d2 * 3.1415926d) / 180.0d);
        double log = (180.0d - ((Math.log((sin + 1.0d) / (1.0d - sin)) * 180.0d) / 6.2831852d)) / 360.0d;
        b bVar = new b();
        bVar.f37375a = (int) ((((d + 180.0d) / 360.0d) * 2.68435456E8d) + 0.5d);
        bVar.b = (int) ((log * 2.68435456E8d) + 0.5d);
        return bVar;
    }

    private byte[] a(RttRequest rttRequest) {
        user_login_t user_login_tVar = new user_login_t();
        user_login_tVar.pf = "android_sdk";
        user_login_tVar.is_login = false;
        user_login_tVar.channel = c7.N();
        user_login_tVar.imei = c7.A();
        f fVar = new f();
        fVar.g(h);
        fVar.f(i);
        fVar.a("info", (String) user_login_tVar);
        fVar.a("req", (String) rttRequest);
        return fVar.b();
    }

    private void b() {
        int r = this.b.h().r();
        Rect i2 = this.b.h().i();
        double d = i2.left / 1000000.0f;
        double d2 = i2.bottom / 1000000.0f;
        double d3 = i2.right / 1000000.0f;
        double d4 = i2.top / 1000000.0f;
        b a2 = a(d, d2);
        b a3 = a(d3, d4);
        this.b.S().a(r, Math.min(a2.f37375a, a3.f37375a), Math.min(a2.b, a3.b), Math.max(a3.f37375a, a2.f37375a), Math.max(a3.b, a2.b));
    }

    private byte[] d() {
        RttRequest a2;
        if (this.b == null || (a2 = a()) == null) {
            return null;
        }
        return this.f37374c.a(a(a2));
    }

    private void f() {
        rc rcVar = this.b;
        if (rcVar == null) {
            return;
        }
        try {
            synchronized (rcVar.S().r()) {
                b();
            }
            byte[] d = d();
            if (d == null || d.length <= 0) {
                return;
            }
            this.b.S().a(d, d.length, true, false);
        } catch (Throwable th) {
            na.b("refreshTrafficData error", th);
        }
    }

    public void a(ah ahVar) {
        List<ah> list = this.g;
        if (list == null || ahVar == null) {
            return;
        }
        list.add(ahVar);
    }

    public void b(ah ahVar) {
        List<ah> list = this.g;
        if (list == null || ahVar == null) {
            return;
        }
        list.remove(ahVar);
    }

    public void c() {
        this.e = false;
        synchronized (this) {
            notifyAll();
        }
    }

    public void e() {
        this.e = true;
        synchronized (this) {
            notifyAll();
        }
    }

    public void g() {
        this.f = true;
        synchronized (this) {
            notifyAll();
        }
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        while (!this.f) {
            if (!this.e) {
                if (this.b == null) {
                    return;
                }
                f();
                this.b.w0();
            }
            try {
                synchronized (this) {
                    if (this.d) {
                        wait(500L);
                        this.d = false;
                    } else {
                        wait(30000L);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
