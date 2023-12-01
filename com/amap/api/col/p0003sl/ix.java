package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.ix  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ix.class */
public class ix {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<ke> f5189a;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<ky> f5190c;
    private static WeakReference<ky> d;
    private static String[] e = new String[10];
    private static int f = 0;
    private static boolean g = false;
    private static int h;
    private static ia i;

    /* renamed from: com.amap.api.col.3sl.ix$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ix$a.class */
    public interface a {
        void a(int i);
    }

    private static ia a(String str) {
        List<ia> a2 = iu.a();
        ArrayList arrayList = a2;
        if (a2 == null) {
            arrayList = new ArrayList();
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        for (ia iaVar : arrayList) {
            if (iu.a(iaVar.f(), str)) {
                return iaVar;
            }
        }
        if (str.contains("com.amap.api.col")) {
            try {
                return ib.a();
            } catch (hn e2) {
                e2.printStackTrace();
            }
        }
        if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
            try {
                ia b2 = ib.b();
                b2.a(true);
                return b2;
            } catch (hn e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return null;
    }

    static /* synthetic */ String a(Context context, ia iaVar, String str, String str2) {
        String a2 = kl.a();
        String a3 = kl.a(context, iaVar);
        ho.a(context);
        return kl.a(a3, a2, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01dd A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0139 -> B:98:0x01d3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.util.List<com.amap.api.col.p0003sl.ia> r5) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ix.a(java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        String a2;
        ia iaVar;
        List<ia> a3 = iu.a();
        if (a3 == null || a3.size() == 0 || (a2 = a(a3)) == null || "".equals(a2) || (iaVar = i) == null) {
            return;
        }
        a(context, iaVar, 2, "ANR", a2);
    }

    private static void a(Context context, ia iaVar, int i2, String str, String str2) {
        String str3;
        String a2 = kl.a();
        String a3 = kl.a(context, iaVar);
        ho.a(context);
        String a4 = kl.a(a3, a2, i2, str, str2);
        if (a4 == null || "".equals(a4)) {
            return;
        }
        String c2 = hw.c(str2);
        if (i2 == 1) {
            str3 = iu.b;
        } else if (i2 == 2) {
            str3 = iu.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = iu.f5182c;
        }
        ke a5 = kl.a(f5189a);
        kl.a(context, a5, str3, 1000, 4096000, "1");
        if (a5.e == null) {
            a5.e = new jl(new jm(new jo(new jp())));
        }
        try {
            kf.a(c2, ib.a(a4.replaceAll("\n", "<br/>")), a5);
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, ia iaVar, String str, int i2, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append("class:");
            sb.append(str2);
        }
        if (str3 != null) {
            sb.append(" method:");
            sb.append(str3);
            sb.append("$<br/>");
        }
        sb.append(str);
        a(context, iaVar, i2, str2, sb.toString());
    }

    public static void a(final Context context, final ia iaVar, final String str, final ke keVar, final String str2) {
        try {
            lb.a().a(new lc() { // from class: com.amap.api.col.3sl.ix.1
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    String a2 = ix.a(Context.this, iaVar, str, str2);
                    if (keVar.e == null) {
                        keVar.e = new jl(new jm(new jo(new jp())));
                    }
                    try {
                        kf.a(hw.c(a2), ib.a(a2), keVar);
                    } catch (Throwable th) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public static void a(final Context context, final ke keVar, final a aVar) {
        try {
            lb.a().a(new lc() { // from class: com.amap.api.col.3sl.ix.3
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    try {
                        synchronized (ix.class) {
                            if (ke.this.g == null) {
                                ke.this.g = new kp(new ko(context, new kt(), new jm(new jo(new jp())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", ho.f(context), hs.v(context), hs.u(context), ho.c(context), Build.MODEL, ho.b(context), ho.d(context), Build.VERSION.RELEASE));
                            }
                            int a2 = kf.a(ke.this);
                            if (aVar != null) {
                                aVar.a(a2);
                            }
                        }
                    } catch (Throwable th) {
                        iw.c(th, "lg", "pul");
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    private static void a(final Context context, final ky kyVar, final String str) {
        lb.a().a(new lc() { // from class: com.amap.api.col.3sl.ix.2
            @Override // com.amap.api.col.p0003sl.lc
            public final void runTask() {
                try {
                    synchronized (ix.class) {
                        ke a2 = kl.a(ix.f5189a);
                        kl.a(Context.this, a2, str, 1000, 4096000, "1");
                        a2.f = kyVar;
                        if (a2.g == null) {
                            a2.g = new kp(new ko(Context.this, new kt(), new jm(new jo(new jp())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", ho.f(Context.this), hs.v(Context.this), hs.u(Context.this), ho.c(Context.this), Build.MODEL, ho.b(Context.this), ho.d(Context.this), Build.VERSION.RELEASE));
                        }
                        a2.h = 3600000;
                        kf.a(a2);
                    }
                } catch (Throwable th) {
                    iw.c(th, "lg", "pul");
                }
            }
        });
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String a2 = ib.a(th);
        ia a3 = a(a2);
        if (a(a3)) {
            String replaceAll = a2.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$<br/>");
            }
            sb.append(replaceAll);
            a(context, a3, i2, th2, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ia iaVar, Context context, String str, String str2) {
        if (!a(iaVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, iaVar, 1, str, str2);
    }

    private static boolean a(ia iaVar) {
        return iaVar != null && iaVar.e();
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            int i2 = f;
            while (true) {
                int i3 = i2;
                if (i3 >= 10 || i3 > 9) {
                    break;
                }
                sb.append(e[i3]);
                i2 = i3 + 1;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= f) {
                    break;
                }
                sb.append(e[i5]);
                i4 = i5 + 1;
            }
        } catch (Throwable th) {
            iw.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        kw kwVar = new kw(b);
        b = false;
        a(context, kwVar, iu.f5182c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context) {
        WeakReference<ky> weakReference = f5190c;
        if (weakReference == null || weakReference.get() == null) {
            f5190c = new WeakReference<>(new kx(context, 3600000, "hKey", new kz(context, false)));
        }
        a(context, f5190c.get(), iu.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        WeakReference<ky> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new kx(context, 3600000, "gKey", new kz(context, false)));
        }
        a(context, d.get(), iu.b);
    }
}
