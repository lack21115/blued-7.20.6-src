package com.anythink.expressad.videocommon.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.anythink.core.common.res.a.a;
import com.anythink.expressad.foundation.g.f.d.b;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/c.class */
public class c implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8727a = "2000077";
    protected static final String b = "CampaignDownLoadTask";
    private static final long d = -510642107992871538L;
    private static final int e = 1;
    private static final int f = 2000;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 4;
    private static final int l = 5;
    private static final String m = "errorMsg";
    private static final int p = 10010;
    private Object A;
    private Class B;
    private Object C;
    private com.anythink.expressad.foundation.d.c D;
    private String E;
    private Context G;
    private long H;
    private String I;
    private String L;
    private long O;
    private com.anythink.expressad.videocommon.d.b P;
    private com.anythink.expressad.videocommon.d.b Q;
    private String U;
    private b.a V;
    private int Z;

    /* renamed from: c  reason: collision with root package name */
    b f8728c;
    private boolean o;
    private int q;
    private String r;
    private String s;
    private Runnable t;
    private f w;
    private ExecutorService x;
    private o y;
    private Class z;
    private boolean g = false;
    private int n = 1;
    private volatile int u = 0;
    private CopyOnWriteArrayList<f> v = new CopyOnWriteArrayList<>();
    private boolean F = false;
    private long J = 0;
    private int K = 0;
    private boolean M = false;
    private boolean N = false;
    private int R = 100;
    private boolean S = false;
    private boolean T = false;
    private int W = 1;
    private f X = new f() { // from class: com.anythink.expressad.videocommon.b.c.1
        @Override // com.anythink.expressad.videocommon.b.f
        public final void a(long j2, int i2) {
            if (c.this.F) {
                return;
            }
            c.a(c.this, j2, i2);
        }
    };
    private Handler Y = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.videocommon.b.c.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                c cVar = c.this;
                c.a(cVar, cVar.J, c.this.u);
            } else if (i2 == 2) {
                if (c.this.u != 2) {
                    c.this.u = 2;
                    c cVar2 = c.this;
                    c.a(cVar2, cVar2.J, c.this.u);
                }
            } else if (i2 == 3) {
                if (c.this.u == 4 || c.this.u == 2 || c.this.u == 5) {
                    return;
                }
                c.this.u = 4;
                c cVar3 = c.this;
                c.a(cVar3, cVar3.J, c.this.u);
            } else if (i2 == 4) {
                c.this.u = 5;
                c.d(c.this);
                c cVar4 = c.this;
                c.a(cVar4, cVar4.J, c.this.u);
            } else if (i2 == 5) {
                c.this.h();
            } else if (i2 == 10010 && message.obj != null) {
                c.s();
            }
        }
    };

    public c(Context context, com.anythink.expressad.foundation.d.c cVar, ExecutorService executorService, String str) {
        this.o = false;
        if (context == null && cVar == null) {
            return;
        }
        this.O = System.currentTimeMillis();
        this.G = com.anythink.expressad.foundation.b.a.b().d();
        this.D = cVar;
        this.E = str;
        this.x = executorService;
        if (cVar != null) {
            this.I = cVar.S();
        }
        this.U = com.anythink.expressad.foundation.h.m.d(this.I);
        a.a();
        this.L = a.a(this.I);
        this.o = false;
        try {
            if (TextUtils.isEmpty(this.I) || this.n == 3) {
                return;
            }
            x();
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.b(b, e2.getMessage());
        }
    }

    private void A() {
        try {
            if (this.z == null || this.A == null) {
                Class<?> cls = Class.forName("com.anythink.expressad.reward.b.a");
                this.z = cls;
                this.A = cls.newInstance();
                this.z.getMethod("insertExcludeId", String.class, com.anythink.expressad.foundation.d.c.class).invoke(this.A, this.E, this.D);
            }
            if (this.B == null || this.C == null) {
                Class<?> cls2 = Class.forName("com.anythink.expressad.atnative.controller.NativeController");
                this.B = cls2;
                this.C = cls2.newInstance();
                this.B.getMethod("insertExcludeId", String.class, com.anythink.expressad.foundation.d.c.class).invoke(this.C, this.E, this.D);
            }
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.d(b, e2.getMessage());
        }
    }

    private static void B() {
    }

    private void C() {
        String str;
        Message obtain = Message.obtain();
        obtain.what = 10010;
        if (this.D == null || TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.D.Z()) || TextUtils.isEmpty(this.D.S())) {
            str = "";
        } else {
            str = "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.q + "&cid=" + this.D.aZ() + "&type=" + this.u;
        }
        obtain.obj = str;
        this.Y.sendMessage(obtain);
    }

    private static void D() {
        com.anythink.expressad.foundation.b.a.b().d();
    }

    private String E() {
        if (this.D == null || TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.D.Z()) || TextUtils.isEmpty(this.D.S())) {
            return "";
        }
        return "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.q + "&cid=" + this.D.aZ() + "&type=" + this.u;
    }

    private static double a(double d2, double d3, int i2) {
        if (i2 >= 0) {
            return new BigDecimal(Double.toString(d2)).divide(new BigDecimal(Double.toString(d3)), i2, 4).doubleValue();
        }
        throw new IllegalAccessException("精确度不能小于0");
    }

    private void a(long j2, int i2) {
        this.J = j2;
        int i3 = this.R;
        if (100 * j2 >= i3 * this.H && !this.S && i2 != 4) {
            if (i3 == 100 && i2 != 5) {
                this.u = 5;
                return;
            }
            v();
        }
        if (this.F) {
            CopyOnWriteArrayList<f> copyOnWriteArrayList = this.v;
            if (copyOnWriteArrayList != null) {
                Iterator<f> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (next != null) {
                        next.a(j2, i2);
                    }
                }
            }
            if (this.w != null) {
                if (this.u == 5 || this.u == 4 || this.u == 2 || this.u == 6) {
                    this.w.a(j2, i2);
                    this.w = null;
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, long j2, int i2) {
        cVar.J = j2;
        int i3 = cVar.R;
        if (100 * j2 >= i3 * cVar.H && !cVar.S && i2 != 4) {
            if (i3 == 100 && i2 != 5) {
                cVar.u = 5;
                return;
            }
            cVar.v();
        }
        if (cVar.F) {
            CopyOnWriteArrayList<f> copyOnWriteArrayList = cVar.v;
            if (copyOnWriteArrayList != null) {
                Iterator<f> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    f next = it.next();
                    if (next != null) {
                        next.a(j2, i2);
                    }
                }
            }
            if (cVar.w != null) {
                if (cVar.u == 5 || cVar.u == 4 || cVar.u == 2 || cVar.u == 6) {
                    cVar.w.a(j2, i2);
                    cVar.w = null;
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        cVar.K++;
        try {
            if (cVar.G != null) {
                Object systemService = cVar.G.getSystemService(Context.CONNECTIVITY_SERVICE);
                ConnectivityManager connectivityManager = null;
                if (systemService instanceof ConnectivityManager) {
                    connectivityManager = (ConnectivityManager) systemService;
                }
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    if (!connectivityManager.getActiveNetworkInfo().isAvailable()) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (cVar.K <= 1) {
            com.anythink.expressad.foundation.h.o.d(b, "delFileAndDB");
            cVar.Y.sendEmptyMessageDelayed(5, 2000L);
            return;
        }
        cVar.A();
        if (cVar.P != null) {
            com.anythink.expressad.foundation.h.o.d(b, "video load retry fail");
            cVar.P.a(str, cVar.I);
        }
        com.anythink.expressad.videocommon.d.b bVar = cVar.Q;
        if (bVar != null) {
            bVar.a(str, cVar.I);
        }
        cVar.u = 4;
        Message obtain = Message.obtain();
        obtain.what = 3;
        cVar.Y.sendMessage(obtain);
    }

    private void b(f fVar) {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.v;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(fVar);
        }
    }

    private void b(com.anythink.expressad.videocommon.d.b bVar) {
        this.Q = bVar;
    }

    private void b(String str) {
        if (this.P != null) {
            com.anythink.expressad.foundation.h.o.d(b, "video load retry fail");
            this.P.a(str, this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar = this.Q;
        if (bVar != null) {
            bVar.a(str, this.I);
        }
        this.u = 4;
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.Y.sendMessage(obtain);
    }

    private void c(String str) {
        this.K++;
        try {
            if (this.G != null) {
                Object systemService = this.G.getSystemService(Context.CONNECTIVITY_SERVICE);
                ConnectivityManager connectivityManager = null;
                if (systemService instanceof ConnectivityManager) {
                    connectivityManager = (ConnectivityManager) systemService;
                }
                if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
                    if (!connectivityManager.getActiveNetworkInfo().isAvailable()) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.K <= 1) {
            com.anythink.expressad.foundation.h.o.d(b, "delFileAndDB");
            this.Y.sendEmptyMessageDelayed(5, 2000L);
            return;
        }
        A();
        if (this.P != null) {
            com.anythink.expressad.foundation.h.o.d(b, "video load retry fail");
            this.P.a(str, this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar = this.Q;
        if (bVar != null) {
            bVar.a(str, this.I);
        }
        this.u = 4;
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.Y.sendMessage(obtain);
    }

    static /* synthetic */ boolean d(c cVar) {
        cVar.g = false;
        return false;
    }

    static /* synthetic */ void s() {
        com.anythink.expressad.foundation.b.a.b().d();
    }

    private void t() {
        try {
            if (TextUtils.isEmpty(this.I) || this.n == 3) {
                return;
            }
            x();
        } catch (Exception e2) {
            com.anythink.expressad.foundation.h.o.b(b, e2.getMessage());
        }
    }

    private void u() {
        if (this.f8728c == null) {
            b bVar = new b(this.I, this.R, this.W);
            this.f8728c = bVar;
            bVar.a(new a.AbstractC0108a() { // from class: com.anythink.expressad.videocommon.b.c.3
                @Override // com.anythink.core.common.res.a.a.AbstractC0108a
                public final void a(String str, String str2) {
                    c cVar = c.this;
                    c.a(cVar, "errorCode:" + str + ",errorMsg:" + str2);
                }

                @Override // com.anythink.core.common.res.a.a.AbstractC0108a
                public final boolean a(int i2, long j2, long j3) {
                    if (c.this.H != j3) {
                        c.this.H = j3;
                    }
                    c cVar = c.this;
                    c.a(cVar, j2, cVar.u);
                    if (i2 >= c.this.R) {
                        c.this.g();
                        c.this.q();
                        return true;
                    }
                    int i3 = 2;
                    if (c.this.u == 2 || c.this.u == 4) {
                        if (c.this.u == 4) {
                            i3 = 3;
                        }
                        Message obtain = Message.obtain();
                        obtain.what = i3;
                        c.this.Y.sendMessage(obtain);
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    private void v() {
        if (this.S) {
            return;
        }
        this.S = true;
        com.anythink.expressad.videocommon.d.b bVar = this.P;
        if (bVar != null) {
            bVar.a(this.I);
        }
        com.anythink.expressad.videocommon.d.b bVar2 = this.Q;
        if (bVar2 != null) {
            bVar2.a(this.I);
        }
    }

    private boolean w() {
        return this.F;
    }

    private void x() {
        com.anythink.core.common.a.i a2;
        a.a();
        this.L = a.a(this.I);
        File file = new File(this.L);
        if (file.exists()) {
            this.J = file.length();
        } else {
            this.J = 0L;
        }
        if (this.H != 0 || (a2 = com.anythink.core.common.a.j.a().a(this.I)) == null) {
            return;
        }
        this.H = a2.d();
    }

    private f y() {
        return this.X;
    }

    private static void z() {
    }

    public final String a() {
        return this.I;
    }

    public final void a(int i2) {
        this.n = i2;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.D = cVar;
    }

    public final void a(f fVar) {
        this.w = fVar;
    }

    public final void a(com.anythink.expressad.videocommon.d.b bVar) {
        this.P = bVar;
    }

    public final void a(String str) {
        this.r = str;
    }

    public final void a(boolean z) {
        if (!z) {
            this.o = false;
        }
        this.T = z;
    }

    public final void b(int i2) {
        this.q = i2;
    }

    public final void b(boolean z) {
        this.N = z;
    }

    public final boolean b() {
        return this.T;
    }

    public final long c() {
        return this.O;
    }

    public final void c(int i2) {
        this.W = i2;
        com.anythink.expressad.foundation.h.o.b(b, "mVideoCtnType:" + this.W);
    }

    public final void d(int i2) {
        this.R = i2;
        com.anythink.expressad.foundation.h.o.b(b, "mReadyRate:" + this.R);
    }

    public final boolean d() {
        return this.N;
    }

    public final String e() {
        return this.L;
    }

    public final void e(int i2) {
        this.Z = i2;
    }

    public final long f() {
        return this.H;
    }

    public final void g() {
        Message obtain = Message.obtain();
        this.u = 5;
        obtain.what = 4;
        this.Y.sendMessage(obtain);
    }

    public final void h() {
        if (TextUtils.isEmpty(this.I)) {
            return;
        }
        if (this.u == 5) {
            v();
        } else if (this.n == 3) {
            g();
        } else if (this.R == 0) {
            g();
        } else {
            x();
            u();
            if (this.f8728c != null) {
                this.u = 1;
                this.F = true;
                this.f8728c.a();
            }
        }
    }

    public final void i() {
        x();
        u();
        if (this.f8728c != null) {
            this.u = 1;
            this.F = true;
            this.f8728c.b();
        }
    }

    public final void j() {
        A();
        this.u = 4;
    }

    public final int k() {
        return this.u;
    }

    public final void l() {
        this.u = 0;
    }

    public final String m() {
        if (this.n == 3) {
            return "";
        }
        File file = new File(this.L);
        try {
            return file.exists() ? file.canRead() ? file.length() > 0 ? "" : "file length is 0 " : "file can not read " : "file is not exist ";
        } catch (Throwable th) {
            String message = th.getMessage();
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
            }
            return message;
        }
    }

    public final com.anythink.expressad.foundation.d.c n() {
        return this.D;
    }

    public final void o() {
        if (this.v != null) {
            this.v = null;
        }
    }

    public final long p() {
        return this.J;
    }

    public final void q() {
        String str;
        Message obtain = Message.obtain();
        obtain.what = 10010;
        if (this.D == null || TextUtils.isEmpty(this.E) || TextUtils.isEmpty(this.D.Z()) || TextUtils.isEmpty(this.D.S())) {
            str = "";
        } else {
            str = "key=2000077&unit_id=" + this.E + "&request_id=" + this.D.Z() + "&request_id_notice=" + this.D.aa() + "&package_name=" + com.anythink.expressad.foundation.b.a.b().a() + "&app_id=" + com.anythink.expressad.foundation.b.a.b().e() + "&video_url=" + URLEncoder.encode(this.D.S()) + "&process_size=" + this.J + "&file_size=" + this.H + "&ready_rate=" + this.R + "&cd_rate=" + this.q + "&cid=" + this.D.aZ() + "&type=" + this.u;
        }
        obtain.obj = str;
        this.Y.sendMessage(obtain);
    }

    public final String r() {
        return this.r;
    }
}
