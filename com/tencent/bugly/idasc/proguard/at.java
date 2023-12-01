package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.idasc.proguard.ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/at.class */
public final class at {
    private static at D;

    /* renamed from: a  reason: collision with root package name */
    public static int f21570a = 0;
    public static boolean b = false;
    public static int d = 2;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 3000;
    public static int h = 20480;
    public static long i = 209715200;
    public static long j = 604800000;
    public static String k;
    public static boolean l = false;
    public static String m;
    public static int n = 5000;
    public static boolean o = true;
    public static boolean p = false;
    public static String q;
    public static String r;
    public Boolean A;
    public int B = 31;
    public boolean C = false;

    /* renamed from: c  reason: collision with root package name */
    public final Context f21571c;
    public final as s;
    public final av t;
    public final NativeCrashHandler u;
    public final ac v;
    public final ak w;
    public final ay x;
    public BuglyStrategy.a y;
    public aw z;

    private at(Context context, ak akVar, boolean z, BuglyStrategy.a aVar) {
        f21570a = 1004;
        Context a2 = ap.a(context);
        this.f21571c = a2;
        this.v = ac.a();
        this.w = akVar;
        this.y = aVar;
        this.z = null;
        this.s = new as(a2, ai.a(), w.a(), this.v, aVar);
        aa a3 = aa.a(a2);
        this.t = new av(a2, this.s, this.v, a3);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a2, a3, this.s, this.v, akVar, z, null);
        this.u = nativeCrashHandler;
        a3.N = nativeCrashHandler;
        ac acVar = this.v;
        as asVar = this.s;
        if (ay.f == null) {
            ay.f = new ay(a2, acVar, a3, akVar, asVar);
        }
        this.x = ay.f;
    }

    public static at a() {
        at atVar;
        synchronized (at.class) {
            try {
                atVar = D;
            } catch (Throwable th) {
                throw th;
            }
        }
        return atVar;
    }

    public static at a(Context context, boolean z, BuglyStrategy.a aVar) {
        at atVar;
        synchronized (at.class) {
            try {
                if (D == null) {
                    D = new at(context, ak.a(), z, aVar);
                }
                atVar = D;
            } catch (Throwable th) {
                throw th;
            }
        }
        return atVar;
    }

    public final void a(long j2) {
        ak.a().a(new Thread() { // from class: com.tencent.bugly.idasc.proguard.at.4
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                if (!ap.a(at.this.f21571c, "local_crash_lock")) {
                    al.c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                ag a2 = ag.a.a();
                List<ag.b> a3 = ag.a();
                if (a3 == null || a3.isEmpty()) {
                    al.c("sla local data is null", new Object[0]);
                } else {
                    al.c("sla load local data list size:%s", Integer.valueOf(a3.size()));
                    Iterator<ag.b> it = a3.iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it.hasNext()) {
                        ag.b next = it.next();
                        if (next.b < ap.b() - 604800000) {
                            al.c("sla local data is expired:%s", next.f21534c);
                            arrayList.add(next);
                            it.remove();
                        }
                    }
                    ag.d(arrayList);
                    a2.b(a3);
                }
                ArrayList a4 = as.a();
                if (a4 == null || a4.size() <= 0) {
                    al.c("no crash need to be uploaded at this start", new Object[0]);
                } else {
                    al.c("Size of crash list: %s", Integer.valueOf(a4.size()));
                    int size = a4.size();
                    if (size > 20) {
                        ArrayList arrayList2 = new ArrayList();
                        Collections.sort(a4);
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= 20) {
                                break;
                            }
                            arrayList2.add(a4.get((size - 1) - i3));
                            i2 = i3 + 1;
                        }
                        a4 = arrayList2;
                    }
                    at.this.s.a(a4, 0L, false, false, false);
                }
                ap.b(at.this.f21571c, "local_crash_lock");
            }
        }, j2);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.s.b(crashDetailBean);
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        synchronized (this) {
            this.u.testNativeCrash(z, z2, z3);
        }
    }

    public final void b() {
        synchronized (this) {
            this.t.a();
            e();
            f();
        }
    }

    public final void c() {
        synchronized (this) {
            this.t.b();
            d();
            g();
        }
    }

    public final void d() {
        this.u.setUserOpened(false);
    }

    public final void e() {
        this.u.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.at.1
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(true);
            }
        });
        this.x.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.at.2
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(false);
            }
        });
        this.x.b(false);
    }

    public final void h() {
        synchronized (this) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int i4 = i3 + 1;
                if (i3 < 30) {
                    try {
                        al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i4));
                        ap.b(5000L);
                        i2 = i4;
                    } catch (Throwable th) {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        return;
                    }
                }
            }
        }
    }

    public final boolean i() {
        return this.x.f21586a.get();
    }

    public final boolean j() {
        return (this.B & 16) > 0;
    }

    public final boolean k() {
        return (this.B & 8) > 0;
    }
}
