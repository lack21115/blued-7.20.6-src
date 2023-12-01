package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/ac.class */
public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static int f21525a = 1000;
    public static long b = 259200000;
    private static ac d;
    private static String i;

    /* renamed from: c  reason: collision with root package name */
    public final ak f21526c;
    private final List<o> e;
    private final StrategyBean f;
    private StrategyBean g = null;
    private Context h;

    private ac(Context context, List<o> list) {
        String str;
        this.h = context;
        if (aa.a(context) != null) {
            String str2 = aa.a(context).H;
            if ("oversea".equals(str2)) {
                str = "https://astat.bugly.qcloud.com/rqd/async";
            } else {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
            StrategyBean.f21505a = str;
            StrategyBean.b = str;
        }
        this.f = new StrategyBean();
        this.e = list;
        this.f21526c = ak.a();
    }

    public static ac a() {
        ac acVar;
        synchronized (ac.class) {
            try {
                acVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return acVar;
    }

    public static ac a(Context context, List<o> list) {
        ac acVar;
        synchronized (ac.class) {
            try {
                if (d == null) {
                    d = new ac(context, list);
                }
                acVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return acVar;
    }

    public static void a(String str) {
        if (ap.b(str) || !ap.d(str)) {
            al.d("URL user set is invalid.", new Object[0]);
        } else {
            i = str;
        }
    }

    public static StrategyBean d() {
        List<y> a2 = w.a().a(2);
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        y yVar = a2.get(0);
        if (yVar.g != null) {
            return (StrategyBean) ap.a(yVar.g, StrategyBean.CREATOR);
        }
        return null;
    }

    protected final void a(StrategyBean strategyBean, boolean z) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z);
        for (o oVar : this.e) {
            try {
                al.c("[Strategy] Notify %s", oVar.getClass().getName());
                oVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final void a(bt btVar) {
        if (btVar == null) {
            return;
        }
        if (this.g == null || btVar.h != this.g.o) {
            StrategyBean strategyBean = new StrategyBean();
            strategyBean.f = btVar.f21620a;
            strategyBean.h = btVar.f21621c;
            strategyBean.g = btVar.b;
            if (ap.b(i) || !ap.d(i)) {
                if (ap.d(btVar.d)) {
                    al.c("[Strategy] Upload url changes to %s", btVar.d);
                    strategyBean.q = btVar.d;
                }
                if (ap.d(btVar.e)) {
                    al.c("[Strategy] Exception upload url changes to %s", btVar.e);
                    strategyBean.r = btVar.e;
                }
            }
            if (btVar.f != null && !ap.b(btVar.f.f21619a)) {
                strategyBean.s = btVar.f.f21619a;
            }
            if (btVar.h != 0) {
                strategyBean.o = btVar.h;
            }
            if (btVar != null && btVar.g != null && btVar.g.size() > 0) {
                strategyBean.t = btVar.g;
                String str = btVar.g.get("B11");
                strategyBean.i = str != null && str.equals("1");
                String str2 = btVar.g.get("B3");
                if (str2 != null) {
                    strategyBean.w = Long.parseLong(str2);
                }
                strategyBean.p = btVar.l;
                strategyBean.v = btVar.l;
                String str3 = btVar.g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean.u = parseInt;
                        }
                    } catch (Exception e) {
                        if (!al.a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                String str4 = btVar.g.get("B25");
                strategyBean.k = str4 != null && str4.equals("1");
            }
            al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.f), Boolean.valueOf(strategyBean.h), Boolean.valueOf(strategyBean.g), Boolean.valueOf(strategyBean.i), Boolean.valueOf(strategyBean.j), Boolean.valueOf(strategyBean.m), Boolean.valueOf(strategyBean.n), Long.valueOf(strategyBean.p), Boolean.valueOf(strategyBean.k), Long.valueOf(strategyBean.o));
            this.g = strategyBean;
            if (!ap.d(btVar.d)) {
                al.c("[Strategy] download url is null", new Object[0]);
                this.g.q = "";
            }
            if (!ap.d(btVar.e)) {
                al.c("[Strategy] download crashurl is null", new Object[0]);
                this.g.r = "";
            }
            w.a().b(2);
            y yVar = new y();
            yVar.b = 2;
            yVar.f21662a = strategyBean.d;
            yVar.e = strategyBean.e;
            yVar.g = ap.a(strategyBean);
            w.a().a(yVar);
            a(strategyBean, true);
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            z = this.g != null;
        }
        return z;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.g;
        if (strategyBean != null) {
            if (!ap.d(strategyBean.q)) {
                this.g.q = StrategyBean.f21505a;
            }
            if (!ap.d(this.g.r)) {
                this.g.r = StrategyBean.b;
            }
            return this.g;
        }
        if (!ap.b(i) && ap.d(i)) {
            this.f.q = i;
            this.f.r = i;
        }
        return this.f;
    }
}
