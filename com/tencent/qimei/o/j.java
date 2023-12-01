package com.tencent.qimei.o;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qimei.s.c;
import com.tencent.qimei.sdk.IQimeiSDK;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/j.class */
public class j implements c.b, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38376a = "j";
    public static final Map<String, j> b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public final String f38377c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public Context i;
    public boolean j;

    public j(String str) {
        this.f38377c = str;
    }

    public static j a(String str) {
        j jVar;
        synchronized (j.class) {
            try {
                j jVar2 = b.get(str);
                jVar = jVar2;
                if (jVar2 == null) {
                    jVar = new j(str);
                    b.put(str, jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            r6 = this;
            com.tencent.qimei.s.c r0 = new com.tencent.qimei.s.c
            r1 = r0
            r2 = r6
            android.content.Context r2 = r2.i
            r3 = r6
            java.lang.String r3 = r3.f38377c
            r4 = r6
            r1.<init>(r2, r3, r4)
            r11 = r0
            r0 = r11
            java.lang.String r1 = "tun-cos-1258344701.html"
            boolean r0 = r0.a(r1)
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = r9
            if (r0 == 0) goto L2f
            r0 = r11
            java.lang.String r1 = "tun-cos-1258344701.js"
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L2f
            r0 = 1
            r7 = r0
            goto L31
        L2f:
            r0 = 0
            r7 = r0
        L31:
            r0 = r7
            if (r0 != 0) goto L46
            r0 = r11
            r1 = 1
            r0.a(r1)
            r0 = r11
            r1 = 1
            r0.b(r1)
        L41:
            r0 = 1
            r7 = r0
            goto L9a
        L46:
            r0 = r8
            r7 = r0
            r0 = r6
            java.lang.String r1 = "lc_fe_tm"
            java.lang.String r2 = ""
            boolean r0 = r0.a(r1, r2)
            if (r0 == 0) goto L9a
            r0 = r11
            java.lang.String r1 = "tun-cos-1258344701.html"
            java.lang.String r2 = "lc_fe_st_hm"
            boolean r0 = r0.a(r1, r2)
            r9 = r0
            r0 = r11
            java.lang.String r1 = "tun-cos-1258344701.js"
            java.lang.String r2 = "lc_fe_st_js"
            boolean r0 = r0.a(r1, r2)
            r10 = r0
            r0 = r9
            if (r0 == 0) goto L76
            r0 = r10
            if (r0 == 0) goto L76
            r0 = 1
            r7 = r0
            goto L78
        L76:
            r0 = 0
            r7 = r0
        L78:
            r0 = r7
            if (r0 != 0) goto L8b
            r0 = r11
            r1 = 1
            r0.a(r1)
            r0 = r11
            r1 = 1
            r0.b(r1)
            goto L41
        L8b:
            r0 = r11
            r1 = 0
            r0.a(r1)
            r0 = r11
            r1 = 0
            r0.b(r1)
            goto L41
        L9a:
            r0 = r7
            if (r0 != 0) goto La2
            r0 = r6
            r0.c()
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.o.j.a():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.tencent.qimei.y.b r8) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.o.j.a(com.tencent.qimei.y.b):void");
    }

    public final boolean a(String str, String str2) {
        com.tencent.qimei.i.f a2 = com.tencent.qimei.i.f.a(this.f38377c);
        return com.tencent.qimei.a.a.a(a2.b(str + str2));
    }

    public final void b() {
        synchronized (this) {
            if (this.j) {
                return;
            }
            com.tencent.qimei.b.a.a().a(this);
            this.j = true;
        }
    }

    public final void c() {
        boolean z;
        boolean z2;
        try {
            Class.forName("com.tencent.smtt.sdk.WebView");
            z = true;
        } catch (ClassNotFoundException e) {
            z = false;
        }
        if (z) {
            Object a2 = com.tencent.qimei.a.a.a("com.tencent.smtt.sdk.QbSdk", "isTbsCoreInited", new Class[0], new Object[0]);
            Object a3 = com.tencent.qimei.a.a.a("com.tencent.smtt.sdk.QbSdk", "getTbsVersion", new Class[]{Context.class}, new Object[]{this.i});
            z2 = false;
            if (a2 != null) {
                if (a3 == null) {
                    z2 = false;
                } else {
                    boolean booleanValue = ((Boolean) a2).booleanValue();
                    int intValue = ((Integer) a3).intValue();
                    if (!booleanValue || intValue == 0) {
                        com.tencent.qimei.k.a.a(f38376a, "x5 not ready,isInited: %b x5Version: %d", Boolean.valueOf(booleanValue), a3);
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
            }
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.d != 0) {
                this.g = true;
                com.tencent.qimei.y.k kVar = new com.tencent.qimei.y.k(this.i);
                new Handler(Looper.getMainLooper()).post(new com.tencent.qimei.y.i(kVar));
                kVar.f38454c.b();
                new Handler(Looper.getMainLooper()).post(new com.tencent.qimei.y.j(kVar));
                a(kVar.f38454c.a());
            }
        } else if (this.e != 0) {
            this.h = true;
            com.tencent.qimei.y.g gVar = new com.tencent.qimei.y.g(this.i);
            new Handler(Looper.getMainLooper()).post(new com.tencent.qimei.y.e(gVar));
            gVar.f38450c.b();
            new Handler(Looper.getMainLooper()).post(new com.tencent.qimei.y.f(gVar));
            a(gVar.f38450c.a());
        }
        com.tencent.qimei.b.a a4 = com.tencent.qimei.b.a.a();
        int i = 600;
        if (this.g) {
            i = this.d;
        } else if (this.h) {
            i = this.e;
        }
        a4.a(i * 1000, this);
    }

    public final void d() {
        if (Build.VERSION.SDK_INT >= 23) {
            Looper.getMainLooper().getQueue().addIdleHandler(new h(this));
        }
        com.tencent.qimei.b.a.a().a(30000L, new i(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        IQimeiSDK qimeiSDK = QimeiSDK.getInstance(this.f38377c);
        Qimei qimei = qimeiSDK.getQimei();
        if (qimei == null || qimei.isEmpty()) {
            qimeiSDK.getQimei(new g(this));
        } else {
            a();
        }
    }
}
