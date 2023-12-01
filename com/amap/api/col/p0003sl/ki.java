package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.amap.api.col.3sl.ki  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ki.class */
public class ki {

    /* renamed from: a  reason: collision with root package name */
    static int f5272a = 1000;
    static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    static int f5273c = 20;
    static int d = 0;
    private static WeakReference<ke> e;
    private static int f = 10;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.ki$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ki$a.class */
    public static final class a extends lc {

        /* renamed from: a  reason: collision with root package name */
        private int f5274a;
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private kh f5275c;

        a(Context context, int i) {
            this.b = context;
            this.f5274a = i;
        }

        a(Context context, kh khVar) {
            this(context, 1);
            this.f5275c = khVar;
        }

        @Override // com.amap.api.col.p0003sl.lc
        public final void runTask() {
            int i = this.f5274a;
            if (i == 1) {
                try {
                    synchronized (ki.class) {
                        String l = Long.toString(System.currentTimeMillis());
                        ke a2 = kl.a(ki.e);
                        kl.a(this.b, a2, iu.i, ki.f5272a, 2097152, "6");
                        if (a2.e == null) {
                            a2.e = new jm(new jo(new jp(new jo())));
                        }
                        kf.a(l, this.f5275c.a(), a2);
                    }
                } catch (Throwable th) {
                    iw.c(th, "ofm", "aple");
                }
            } else if (i == 2) {
                try {
                    ke a3 = kl.a(ki.e);
                    kl.a(this.b, a3, iu.i, ki.f5272a, 2097152, "6");
                    a3.h = 14400000;
                    if (a3.g == null) {
                        a3.g = new kp(new ko(this.b, new kt(), new jm(new jo(new jp())), new String(ip.a(10)), ho.f(this.b), hs.v(this.b), hs.k(this.b), hs.h(this.b), hs.a(), Build.MANUFACTURER, Build.DEVICE, hs.y(this.b), ho.c(this.b), Build.MODEL, ho.d(this.b), ho.b(this.b), hs.g(this.b), hs.a(this.b), String.valueOf(Build.VERSION.SDK_INT)));
                    }
                    if (TextUtils.isEmpty(a3.i)) {
                        a3.i = "fKey";
                    }
                    a3.f = new kx(this.b, a3.h, a3.i, new kv(this.b, ki.b, ki.f * 1024, ki.f5273c * 1024, "offLocKey", ki.d * 1024));
                    kf.a(a3);
                } catch (Throwable th2) {
                    iw.c(th2, "ofm", "uold");
                }
            }
        }
    }

    @Deprecated
    public static void a(int i, boolean z) {
        synchronized (ki.class) {
            try {
                f5272a = i;
                b = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r5 > 100) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(int r3, boolean r4, int r5, int r6) {
        /*
            java.lang.Class<com.amap.api.col.3sl.ki> r0 = com.amap.api.col.p0003sl.ki.class
            monitor-enter(r0)
            r0 = r3
            com.amap.api.col.p0003sl.ki.f5272a = r0     // Catch: java.lang.Throwable -> L37
            r0 = r4
            com.amap.api.col.p0003sl.ki.b = r0     // Catch: java.lang.Throwable -> L37
            r0 = r5
            r1 = 10
            if (r0 < r1) goto L3f
            r0 = r5
            r3 = r0
            r0 = r5
            r1 = 100
            if (r0 <= r1) goto L1c
            goto L3f
        L1c:
            r0 = r3
            com.amap.api.col.p0003sl.ki.f5273c = r0     // Catch: java.lang.Throwable -> L37
            r0 = r3
            r1 = 5
            int r0 = r0 / r1
            int r1 = com.amap.api.col.p0003sl.ki.f     // Catch: java.lang.Throwable -> L37
            if (r0 <= r1) goto L2f
            r0 = r3
            r1 = 5
            int r0 = r0 / r1
            com.amap.api.col.p0003sl.ki.f = r0     // Catch: java.lang.Throwable -> L37
        L2f:
            r0 = r6
            com.amap.api.col.p0003sl.ki.d = r0     // Catch: java.lang.Throwable -> L37
            java.lang.Class<com.amap.api.col.3sl.ki> r0 = com.amap.api.col.p0003sl.ki.class
            monitor-exit(r0)
            return
        L37:
            r7 = move-exception
            java.lang.Class<com.amap.api.col.3sl.ki> r0 = com.amap.api.col.p0003sl.ki.class
            monitor-exit(r0)
            r0 = r7
            throw r0
        L3f:
            r0 = 20
            r3 = r0
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ki.a(int, boolean, int, int):void");
    }

    public static void a(Context context) {
        lb.a().a(new a(context, 2));
    }

    public static void a(kh khVar, Context context) {
        synchronized (ki.class) {
            try {
                lb.a().a(new a(context, khVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
