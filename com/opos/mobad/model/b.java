package com.opos.mobad.model;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.mobads.sdk.api.SplashAd;
import com.opos.mobad.model.b.c;
import com.opos.mobad.model.d.g;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.d.s;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.model.e.e;
import com.opos.mobad.service.f;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b.class */
public class b {
    private static volatile b f;
    private com.opos.mobad.model.e.b g = new com.opos.mobad.model.e.b();
    private com.opos.mobad.model.a.a.b h;
    private static String e = b.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static int f12693a = 0;
    public static int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f12694c = 2;
    public static int d = 3;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/b$a.class */
    public interface a {
        void a(int i, a.C0537a c0537a);

        void a(int i, String str, AdData adData);
    }

    private b(Context context) {
        this.h = new com.opos.mobad.model.a.a.b(context);
    }

    private int a(int i) {
        switch (i) {
            case 1:
                return f.b().j();
            case 2:
                return f.b().o();
            case 3:
            case 6:
                return f.b().l();
            case 4:
                return f.b().t();
            case 5:
                return f.b().r();
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(long j, int i) {
        long max = Math.max(SystemClock.elapsedRealtime() - j, 0L);
        long j2 = i;
        if (j2 > max) {
            return (int) Math.max((j2 - max) - 100, 0L);
        }
        return 0;
    }

    public static b a(Context context) {
        if (f == null) {
            synchronized (b.class) {
                try {
                    if (f == null) {
                        f = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    private FutureTask<Integer> a(Context context, String str, int i) {
        if (i == 5) {
            return null;
        }
        return com.opos.mobad.service.a.a().a(context, str);
    }

    private void a(Context context, String str, int i, String str2, int i2, final com.opos.mobad.model.c.a aVar) {
        c a2 = com.opos.mobad.cmn.a.b.f.a(context, str, i, str2);
        int a3 = a(i);
        String str3 = e;
        com.opos.cmn.an.f.a.b(str3, "fetch ad with sync timeout:" + a3);
        if (a3 > 0) {
            new s(context, str, str2, a2, true, this.h, i2, a3, new m.a() { // from class: com.opos.mobad.model.b.4
                @Override // com.opos.mobad.model.d.m.a
                public void a() {
                }

                @Override // com.opos.mobad.model.d.m.a
                public void a(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void b(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void c(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }
            }).f();
        } else {
            new g(context, this.h).a(str, a2, aVar, 30000L, true, new Object[0]);
        }
    }

    private void a(Context context, String str, int i, String str2, int i2, final com.opos.mobad.model.c.a aVar, int i3, int i4) {
        boolean z;
        c a2 = com.opos.mobad.cmn.a.b.f.a(context, str, i, str2);
        int i5 = 1;
        if (i3 == f12693a || i3 == b) {
            if (i3 == b) {
                i5 = 2;
            }
            a2.a(i5);
            z = false;
        } else {
            z = true;
        }
        a2.f(i4);
        int a3 = a(i);
        if (a3 > 0) {
            new s(context, str, str2, a2, z, this.h, i2, a3, new m.a() { // from class: com.opos.mobad.model.b.3
                @Override // com.opos.mobad.model.d.m.a
                public void a() {
                }

                @Override // com.opos.mobad.model.d.m.a
                public void a(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void b(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }

                @Override // com.opos.mobad.model.d.m.a
                public void c(AdData adData) {
                    aVar.a(adData.d(), adData.e(), adData, new Object[0]);
                }
            }).f();
        } else {
            new g(context, this.h).a(str, a2, aVar, 30000L, z, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, int i, String str2, AdData adData, int i2, a aVar) {
        String str3;
        if (adData != null && adData.g() > 0) {
            int g = adData.g() * 1000;
            com.opos.cmn.an.f.a.b(e, "setReqAdInterval=" + g);
            this.g.a(str, g);
        }
        if (10000 != i || adData == null) {
            String str4 = e;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i);
            sb.append(",msg=");
            sb.append(str2 != null ? str2 : "");
            com.opos.cmn.an.f.a.a(str4, sb.toString());
            aVar.a(i, str2, adData);
            return;
        }
        a.C0537a a2 = com.opos.mobad.model.e.a.a(adData);
        if (a2 != null) {
            int c2 = adData.c();
            a2.f12794a.a(i2);
            com.opos.mobad.service.c.b.a().a(a2.f12795c.b());
            aVar.a(c2, a2);
            return;
        }
        int i3 = 10401;
        if (e.a(context, adData)) {
            str3 = com.opos.mobad.ad.a.a(10401);
        } else {
            i3 = -1;
            str3 = "ad data is null";
        }
        aVar.a(i3, str3, adData);
    }

    private boolean a(String str, a aVar) {
        int i;
        if (!com.opos.mobad.cmn.a.b.f.e()) {
            i = 11005;
        } else if (this.g.b(str)) {
            return true;
        } else {
            i = 11003;
        }
        aVar.a(i, com.opos.mobad.ad.a.a(i), null);
        return false;
    }

    public com.opos.mobad.model.a.a.b a() {
        return this.h;
    }

    public void a(final Context context, final String str, int i, String str2, final int i2, final a aVar) {
        com.opos.cmn.an.f.a.b(e, SplashAd.KEY_FETCHAD);
        if (a(str, aVar)) {
            this.g.a(str);
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = e;
            com.opos.cmn.an.f.a.b(str3, "fetchAd start:" + elapsedRealtime);
            final FutureTask<Integer> a2 = a(context, str, i);
            a(context.getApplicationContext(), str, i, str2, i2, new com.opos.mobad.model.c.a() { // from class: com.opos.mobad.model.b.1
                @Override // com.opos.mobad.model.c.a
                public void a(int i3, String str4, AdData adData, Object... objArr) {
                    int f2;
                    FutureTask futureTask = a2;
                    if (futureTask != null) {
                        try {
                            f2 = ((Integer) futureTask.get(b.this.a(elapsedRealtime, i2), TimeUnit.MILLISECONDS)).intValue();
                        } catch (Exception e2) {
                            f2 = com.opos.mobad.service.a.a().f();
                            com.opos.cmn.an.f.a.b(b.e, "check future fail", e2);
                        }
                    } else {
                        f2 = 0;
                    }
                    b.this.a(context.getApplicationContext(), str, i3, str4, adData, f2, aVar);
                }
            });
        }
    }

    public void a(Context context, String str, int i, String str2, int i2, a aVar, int i3) {
        a(context.getApplicationContext(), str, i, str2, i2, aVar, i3, -1);
    }

    public void a(final Context context, final String str, int i, String str2, final int i2, final a aVar, int i3, int i4) {
        com.opos.cmn.an.f.a.b(e, SplashAd.KEY_FETCHAD);
        if (a(str, aVar)) {
            this.g.a(str);
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = e;
            com.opos.cmn.an.f.a.b(str3, "fetchAd start:" + elapsedRealtime);
            final FutureTask<Integer> a2 = a(context, str, i);
            a(context, str, i, str2, i2, new com.opos.mobad.model.c.a() { // from class: com.opos.mobad.model.b.2
                @Override // com.opos.mobad.model.c.a
                public void a(int i5, String str4, AdData adData, Object... objArr) {
                    int f2;
                    FutureTask futureTask = a2;
                    if (futureTask != null) {
                        try {
                            f2 = ((Integer) futureTask.get(b.this.a(elapsedRealtime, i2), TimeUnit.MILLISECONDS)).intValue();
                        } catch (Exception e2) {
                            f2 = com.opos.mobad.service.a.a().f();
                            com.opos.cmn.an.f.a.b(b.e, "check future fail", e2);
                        }
                    } else {
                        f2 = 0;
                    }
                    b.this.a(context, str, i5, str4, adData, f2, aVar);
                }
            }, i3, i4);
        }
    }
}
