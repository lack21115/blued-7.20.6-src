package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.anythink.expressad.video.module.a.a.m;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f35162a = 0;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static int f35163c = 2;
    public static boolean d = true;
    public static int e = 20480;
    public static int f = 20480;
    public static long g = 604800000;
    public static String h;
    public static boolean i = false;
    public static String j;
    public static int k = 5000;
    public static boolean l = true;
    public static boolean m = false;
    public static String n;
    public static String o;
    private static c r;
    public final b p;
    private final Context q;
    private final e s;
    private final NativeCrashHandler t;
    private com.tencent.bugly.crashreport.common.strategy.a u;
    private w v;
    private final com.tencent.bugly.crashreport.crash.anr.b w;
    private Boolean x;
    private int y = 31;
    private boolean z = false;

    /* renamed from: com.tencent.bugly.crashreport.crash.c$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/c$2.class */
    final class AnonymousClass2 extends Thread {
        AnonymousClass2() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            if (z.a(c.this.q, "local_crash_lock", 10000L)) {
                ArrayList a2 = c.this.p.a();
                if (a2 != null && a2.size() > 0) {
                    x.c("Size of crash list: %s", Integer.valueOf(a2.size()));
                    int size = a2.size();
                    if (size > 20) {
                        ArrayList arrayList = new ArrayList();
                        Collections.sort(a2);
                        for (int i = 0; i < 20; i++) {
                            arrayList.add(a2.get((size - 1) - i));
                        }
                        a2 = arrayList;
                    }
                    c.this.p.a(a2, 0L, false, false, false);
                }
                z.b(c.this.q, "local_crash_lock");
            }
        }
    }

    private c(int i2, Context context, w wVar, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        f35162a = i2;
        Context a2 = z.a(context);
        this.q = a2;
        this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.v = wVar;
        u a3 = u.a();
        p a4 = p.a();
        this.p = new b(i2, a2, a3, a4, this.u, aVar, oVar);
        com.tencent.bugly.crashreport.common.info.a a5 = com.tencent.bugly.crashreport.common.info.a.a(a2);
        this.s = new e(a2, this.p, this.u, a5);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a2, a5, this.p, this.u, wVar, z, str);
        this.t = nativeCrashHandler;
        a5.E = nativeCrashHandler;
        this.w = com.tencent.bugly.crashreport.crash.anr.b.a(a2, this.u, a5, wVar, a4, this.p, aVar);
    }

    public static c a() {
        c cVar;
        synchronized (c.class) {
            try {
                cVar = r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static c a(int i2, Context context, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        c cVar;
        synchronized (c.class) {
            try {
                if (r == null) {
                    r = new c(1004, context, w.a(), z, aVar, null, null);
                }
                cVar = r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public final void a(int i2) {
        this.y = i2;
    }

    public final void a(long j2) {
        w.a().a(new AnonymousClass2(), j2);
    }

    public final void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.c();
        w.a().a(new AnonymousClass2(), m.ag);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    public final void a(final Thread thread, final Throwable th, boolean z, String str, byte[] bArr, final boolean z2) {
        this.v.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.c("post a throwable %b", Boolean.valueOf(r5));
                    c.this.s.a(thread, th, false, r8, r9);
                    if (z2) {
                        x.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(c.this.q).u();
                    }
                } catch (Throwable th2) {
                    if (!x.b(th2)) {
                        th2.printStackTrace();
                    }
                    x.e("java catch error: %s", th.toString());
                }
            }
        });
    }

    public final void a(boolean z) {
        this.z = z;
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        synchronized (this) {
            this.t.testNativeCrash(z, z2, z3);
        }
    }

    public final boolean b() {
        Boolean bool = this.x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().d;
        List<r> a2 = p.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a2 == null || a2.size() <= 0) {
            this.x = false;
            return false;
        }
        for (r rVar : a2) {
            if (str.equals(rVar.f35403c)) {
                this.x = true;
                arrayList.add(rVar);
            }
        }
        if (arrayList.size() > 0) {
            p.a().a(arrayList);
            return true;
        }
        return true;
    }

    public final void c() {
        synchronized (this) {
            this.s.a();
            this.t.setUserOpened(true);
            this.w.a(true);
        }
    }

    public final void d() {
        synchronized (this) {
            this.s.b();
            this.t.setUserOpened(false);
            this.w.a(false);
        }
    }

    public final void e() {
        this.s.a();
    }

    public final void f() {
        this.t.setUserOpened(false);
    }

    public final void g() {
        this.t.setUserOpened(true);
    }

    public final void h() {
        this.w.a(true);
    }

    public final void i() {
        this.w.a(false);
    }

    public final void j() {
        this.t.enableCatchAnrTrace();
    }

    public final void k() {
        synchronized (this) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int i4 = i3 + 1;
                if (i3 < 30) {
                    try {
                        x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i4));
                        z.b(5000L);
                        i2 = i4;
                    } catch (Throwable th) {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        return;
                    }
                }
            }
        }
    }

    public final boolean l() {
        return this.w.a();
    }

    public final void m() {
        this.t.checkUploadRecordCrash();
    }

    public final void n() {
        if (com.tencent.bugly.crashreport.common.info.a.b().d.equals(AppInfo.a(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public final boolean o() {
        return this.z;
    }

    public final boolean p() {
        return (this.y & 16) > 0;
    }

    public final boolean q() {
        return (this.y & 8) > 0;
    }

    public final boolean r() {
        return (this.y & 4) > 0;
    }

    public final boolean s() {
        return (this.y & 2) > 0;
    }

    public final boolean t() {
        return (this.y & 1) > 0;
    }
}
