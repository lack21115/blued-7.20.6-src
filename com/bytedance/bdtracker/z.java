package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.IAppLogInstance;
import com.cdo.oaps.ad.OapsKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/z.class */
public class z {
    public static volatile long o;
    public static b p;

    /* renamed from: a  reason: collision with root package name */
    public long f21339a;
    public final v b;

    /* renamed from: c  reason: collision with root package name */
    public c2 f21340c;
    public c2 d;
    public String e;
    public volatile long f;
    public int g;
    public volatile boolean i;
    public long j;
    public int k;
    public String l;
    public volatile String m;
    public long h = -1;
    public volatile boolean n = false;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/z$b.class */
    public static class b extends f2 {
        public /* synthetic */ b(a aVar) {
        }
    }

    public z(v vVar) {
        this.b = vVar;
    }

    public static boolean a(t1 t1Var) {
        if (t1Var instanceof c2) {
            return ((c2) t1Var).l();
        }
        return false;
    }

    public static long c() {
        long j = o + 1;
        o = j;
        return j;
    }

    public Bundle a(long j, long j2) {
        Bundle bundle;
        synchronized (this) {
            long j3 = this.f;
            bundle = null;
            if (this.b.d.b.isPlayEnable()) {
                bundle = null;
                if (b()) {
                    bundle = null;
                    if (j3 > 0) {
                        long j4 = j - j3;
                        bundle = null;
                        if (j4 > j2) {
                            bundle = new Bundle();
                            bundle.putInt("session_no", this.k);
                            int i = this.g + 1;
                            this.g = i;
                            bundle.putInt("send_times", i);
                            bundle.putLong("current_duration", j4 / 1000);
                            bundle.putString(com.umeng.analytics.pro.u.f40781a, t1.n.format(new Date(this.h)));
                            this.f = j;
                        }
                    }
                }
            }
        }
        return bundle;
    }

    public a2 a(IAppLogInstance iAppLogInstance, t1 t1Var, ArrayList<t1> arrayList, boolean z) {
        a2 a2Var;
        synchronized (this) {
            long j = t1Var instanceof b ? -1L : t1Var.b;
            this.e = UUID.randomUUID().toString();
            if (z && !this.b.u && TextUtils.isEmpty(this.m)) {
                this.m = this.e;
            }
            o = 10000L;
            this.h = j;
            this.i = z;
            this.j = 0L;
            this.f = 0L;
            if (z) {
                Calendar calendar = Calendar.getInstance();
                StringBuilder a2 = com.bytedance.bdtracker.a.a("");
                a2.append(calendar.get(1));
                a2.append(calendar.get(2));
                a2.append(calendar.get(5));
                String sb = a2.toString();
                m0 m0Var = this.b.d;
                if (TextUtils.isEmpty(this.l)) {
                    this.l = m0Var.d.getString("session_last_day", "");
                    this.k = m0Var.d.getInt("session_order", 0);
                }
                if (sb.equals(this.l)) {
                    this.k++;
                } else {
                    this.l = sb;
                    this.k = 1;
                }
                m0Var.d.edit().putString("session_last_day", sb).putInt("session_order", this.k).apply();
                this.g = 0;
                this.f = t1Var.b;
            }
            a2Var = null;
            if (j != -1) {
                a2Var = new a2();
                a2Var.k = t1Var.k;
                a2Var.d = this.e;
                a2Var.r = !this.i;
                a2Var.f21309c = c();
                a2Var.a(this.h);
                a2Var.q = this.b.h.m();
                a2Var.p = this.b.h.l();
                a2Var.e = this.f21339a;
                a2Var.f = iAppLogInstance.getUserUniqueID();
                a2Var.g = iAppLogInstance.getSsid();
                a2Var.h = iAppLogInstance.getAbSdkVersion();
                a2Var.t = z ? this.b.d.e.getInt("is_first_time_launch", 1) : 0;
                if (z && a2Var.t == 1) {
                    this.b.d.e.edit().putInt("is_first_time_launch", 0).apply();
                }
                c2 a3 = o.a();
                if (a3 != null) {
                    a2Var.v = a3.r;
                    a2Var.u = a3.s;
                }
                if (this.i && this.n) {
                    a2Var.w = this.n;
                    this.n = false;
                }
                arrayList.add(a2Var);
            }
            c cVar = this.b.f21325c;
            if (cVar.k <= 0) {
                cVar.k = 6;
            }
            StringBuilder a4 = com.bytedance.bdtracker.a.a("startSession, ");
            a4.append(this.i ? "fg" : OapsKey.KEY_BG);
            a4.append(", ");
            a4.append(this.e);
            z2.a(a4.toString());
        }
        return a2Var;
    }

    public String a() {
        return this.e;
    }

    public void a(IAppLogInstance iAppLogInstance, t1 t1Var) {
        if (t1Var != null) {
            t1Var.k = iAppLogInstance.getAppId();
            t1Var.e = this.f21339a;
            t1Var.f = iAppLogInstance.getUserUniqueID();
            t1Var.g = iAppLogInstance.getSsid();
            t1Var.d = this.e;
            t1Var.f21309c = c();
            t1Var.h = iAppLogInstance.getAbSdkVersion();
            Context a2 = this.b.a();
            s2.b(a2);
            s2.a(a2);
            t1Var.i = s2.b.f21304a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0109, code lost:
        if (((r0.b - r10.b) - r10.p) < 500) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.bytedance.applog.IAppLogInstance r8, com.bytedance.bdtracker.t1 r9, java.util.ArrayList<com.bytedance.bdtracker.t1> r10) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.z.a(com.bytedance.applog.IAppLogInstance, com.bytedance.bdtracker.t1, java.util.ArrayList):boolean");
    }

    public boolean b() {
        return this.i && this.j == 0;
    }
}
