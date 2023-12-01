package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/common/strategy/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f35135a = 1000;
    private static a b;
    private static String h;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.tencent.bugly.a> f35136c;
    private final w d;
    private final StrategyBean e;
    private StrategyBean f = null;
    private Context g;

    private a(Context context, List<com.tencent.bugly.a> list) {
        String str;
        this.g = context;
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str2 = com.tencent.bugly.crashreport.common.info.a.a(context).z;
            if ("oversea".equals(str2)) {
                str = "https://astat.bugly.qcloud.com/rqd/async";
            } else {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
            StrategyBean.f35133a = str;
            StrategyBean.b = str;
        }
        this.e = new StrategyBean();
        this.f35136c = list;
        this.d = w.a();
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                aVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static a a(Context context, List<com.tencent.bugly.a> list) {
        a aVar;
        synchronized (a.class) {
            try {
                if (b == null) {
                    b = new a(context, list);
                }
                aVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static void a(String str) {
        if (z.a(str) || !z.c(str)) {
            x.d("URL user set is invalid.", new Object[0]);
        } else {
            h = str;
        }
    }

    public static StrategyBean d() {
        List<r> a2 = p.a().a(2);
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        r rVar = a2.get(0);
        if (rVar.g != null) {
            return (StrategyBean) z.a(rVar.g, StrategyBean.CREATOR);
        }
        return null;
    }

    public final void a(long j) {
        this.d.a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> a2 = p.a().a(a.f35135a, (o) null, true);
                    if (a2 != null) {
                        byte[] bArr = a2.get("device");
                        byte[] bArr2 = a2.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.g).e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.g).d(new String(bArr2));
                        }
                    }
                    a.this.f = a.d();
                    if (a.this.f != null) {
                        if (z.a(a.h) || !z.c(a.h)) {
                            a.this.f.p = StrategyBean.f35133a;
                            a.this.f.q = StrategyBean.b;
                        } else {
                            a.this.f.p = a.h;
                            a.this.f.q = a.h;
                        }
                    }
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.f, false);
            }
        }, j);
    }

    protected final void a(StrategyBean strategyBean, boolean z) {
        x.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f35136c) {
            try {
                x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(ap apVar) {
        if (apVar == null) {
            return;
        }
        if (this.f == null || apVar.h != this.f.n) {
            StrategyBean strategyBean = new StrategyBean();
            strategyBean.e = apVar.f35376a;
            strategyBean.g = apVar.f35377c;
            strategyBean.f = apVar.b;
            if (z.a(h) || !z.c(h)) {
                if (z.c(apVar.d)) {
                    x.c("[Strategy] Upload url changes to %s", apVar.d);
                    strategyBean.p = apVar.d;
                }
                if (z.c(apVar.e)) {
                    x.c("[Strategy] Exception upload url changes to %s", apVar.e);
                    strategyBean.q = apVar.e;
                }
            }
            if (apVar.f != null && !z.a(apVar.f.f35375a)) {
                strategyBean.r = apVar.f.f35375a;
            }
            if (apVar.h != 0) {
                strategyBean.n = apVar.h;
            }
            if (apVar.g != null && apVar.g.size() > 0) {
                strategyBean.s = apVar.g;
                String str = apVar.g.get("B11");
                if (str == null || !str.equals("1")) {
                    strategyBean.h = false;
                } else {
                    strategyBean.h = true;
                }
                String str2 = apVar.g.get("B3");
                if (str2 != null) {
                    strategyBean.v = Long.valueOf(str2).longValue();
                }
                strategyBean.o = apVar.i;
                strategyBean.u = apVar.i;
                String str3 = apVar.g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean.t = parseInt;
                        }
                    } catch (Exception e) {
                        if (!x.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                String str4 = apVar.g.get("B25");
                if (str4 == null || !str4.equals("1")) {
                    strategyBean.j = false;
                } else {
                    strategyBean.j = true;
                }
            }
            x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.e), Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.f), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.l), Boolean.valueOf(strategyBean.m), Long.valueOf(strategyBean.o), Boolean.valueOf(strategyBean.j), Long.valueOf(strategyBean.n));
            this.f = strategyBean;
            if (!z.c(apVar.d)) {
                x.c("[Strategy] download url is null", new Object[0]);
                this.f.p = "";
            }
            if (!z.c(apVar.e)) {
                x.c("[Strategy] download crashurl is null", new Object[0]);
                this.f.q = "";
            }
            p.a().b(2);
            r rVar = new r();
            rVar.b = 2;
            rVar.f35402a = strategyBean.f35134c;
            rVar.e = strategyBean.d;
            rVar.g = z.a(strategyBean);
            p.a().a(rVar);
            a(strategyBean, true);
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            z = this.f != null;
        }
        return z;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f;
        if (strategyBean != null) {
            if (!z.c(strategyBean.p)) {
                this.f.p = StrategyBean.f35133a;
            }
            if (!z.c(this.f.q)) {
                this.f.q = StrategyBean.b;
            }
            return this.f;
        }
        if (!z.a(h) && z.c(h)) {
            this.e.p = h;
            this.e.q = h;
        }
        return this.e;
    }
}
