package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/au.class */
public final class au {

    /* renamed from: a  reason: collision with root package name */
    private static au f21577a;
    private ac b;

    /* renamed from: c  reason: collision with root package name */
    private aa f21578c;
    private as d;
    private Context e;

    private au(Context context) {
        at a2 = at.a();
        if (a2 == null) {
            return;
        }
        this.b = ac.a();
        this.f21578c = aa.a(context);
        this.d = a2.s;
        this.e = context;
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.au.1
            @Override // java.lang.Runnable
            public final void run() {
                au.a(au.this);
            }
        });
    }

    public static au a(Context context) {
        if (f21577a == null) {
            f21577a = new au(context);
        }
        return f21577a;
    }

    static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.idasc.agent.GameAgent");
            auVar.f21578c.getClass();
            ap.a(cls, "sdkPackageName", "com.tencent.bugly.idasc");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable th) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(au auVar, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i == 4) {
            str4 = "Unity";
        } else if (i == 5 || i == 6) {
            str4 = "Cocos";
        } else if (i != 8) {
            al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
            return;
        } else {
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!auVar.b.b()) {
                al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c2 = auVar.b.c();
            if (!c2.f && auVar.b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(str4, ap.a(), auVar.f21578c.d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i == 5 || i == 6) {
                if (!c2.k) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i == 8 && !c2.l) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i == 8) {
                i = 5;
            }
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = auVar.f21578c.k();
            crashDetailBean.G = auVar.f21578c.j();
            crashDetailBean.H = auVar.f21578c.l();
            crashDetailBean.I = ab.b(auVar.e);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = i;
            crashDetailBean.e = auVar.f21578c.g();
            crashDetailBean.f = auVar.f21578c.o;
            crashDetailBean.g = auVar.f21578c.q();
            crashDetailBean.m = auVar.f21578c.f();
            crashDetailBean.n = String.valueOf(str);
            crashDetailBean.o = String.valueOf(str2);
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.p = str5;
            crashDetailBean.q = str6;
            crashDetailBean.r = System.currentTimeMillis();
            crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
            crashDetailBean.z = ap.a(auVar.f21578c.Q, at.h);
            crashDetailBean.A = auVar.f21578c.d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.L = auVar.f21578c.s();
            crashDetailBean.h = auVar.f21578c.p();
            crashDetailBean.Q = auVar.f21578c.f21520a;
            crashDetailBean.R = auVar.f21578c.a();
            crashDetailBean.U = auVar.f21578c.z();
            crashDetailBean.V = auVar.f21578c.x;
            crashDetailBean.W = auVar.f21578c.t();
            crashDetailBean.X = auVar.f21578c.y();
            crashDetailBean.y = ao.a();
            if (crashDetailBean.S == null) {
                crashDetailBean.S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.S.putAll(map);
            }
            String a2 = ap.a();
            as.a(str4, a2, auVar.f21578c.d, currentThread.getName(), str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!auVar.d.a(crashDetailBean, !at.a().C)) {
                auVar.d.b(crashDetailBean, false);
            }
            al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    public static void a(final Thread thread, final int i, final String str, final String str2, final String str3, final Map<String, String> map) {
        ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.au.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (au.f21577a == null) {
                        al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    } else {
                        au.a(au.f21577a, thread, i, str, str2, str3, map);
                    }
                } catch (Throwable th) {
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                    al.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
