package com.tencent.beacon.event.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.beacon.event.open.EventType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/c/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, g> f21357a = new ConcurrentHashMap(5);
    private static volatile Handler b;
    private final Context m;
    private final String n;
    private long p;
    private long t;
    private long u;
    private long v;
    private long w;
    private long x;
    private long y;
    private SharedPreferences z;

    /* renamed from: c  reason: collision with root package name */
    private final String f21358c = "normal_log_id";
    private final String d = "realtime_log_id";
    private final String e = "immediate_log_id";
    private final String f = "normal_min_log_id";
    private final String g = "normal_max_log_id";
    private final String h = "realtime_min_log_id";
    private final String i = "realtime_max_log_id";
    private final String j = "immediate_min_log_id";
    private final String k = "immediate_max_log_id";
    private final String l = "on_date";
    private final List<String> o = new ArrayList();
    private AtomicLong q = new AtomicLong(0);
    private AtomicLong r = new AtomicLong(0);
    private AtomicLong s = new AtomicLong(0);
    private final Runnable A = new e(this);
    private boolean B = false;

    private g(Context context, String str) {
        this.m = context;
        this.n = str;
    }

    private long a(EventType eventType) {
        switch (f.f21356a[eventType.ordinal()]) {
            case 1:
            case 2:
                return this.q.incrementAndGet();
            case 3:
            case 4:
                return this.r.incrementAndGet();
            case 5:
            case 6:
                return this.s.incrementAndGet();
            default:
                return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences a(Context context) {
        if (this.z == null) {
            this.z = context.getSharedPreferences("new_b_log_ID_" + com.tencent.beacon.a.c.b.c(context) + "_" + this.n, 0);
        }
        return this.z;
    }

    public static g a(Context context, String str) {
        g gVar;
        synchronized (g.class) {
            try {
                g gVar2 = f21357a.get(str);
                gVar = gVar2;
                if (gVar2 == null) {
                    gVar = new g(context, str);
                    f21357a.put(str, gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private void a() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (d()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.p);
            String str6 = "";
            sb.append("");
            String sb2 = sb.toString();
            String c2 = com.tencent.beacon.a.c.b.c(this.m);
            String packageName = this.m.getPackageName();
            if (this.t == 0) {
                str = "";
            } else {
                str = (this.t - 1) + "";
            }
            if (this.u == 0) {
                str2 = "";
            } else {
                str2 = this.u + "";
            }
            if (this.v == 0) {
                str3 = "";
            } else {
                str3 = (this.v - 1) + "";
            }
            if (this.w == 0) {
                str4 = "";
            } else {
                str4 = this.w + "";
            }
            if (this.x == 0) {
                str5 = "";
            } else {
                str5 = (this.x - 1) + "";
            }
            if (this.y != 0) {
                str6 = this.y + "";
            }
            com.tencent.beacon.a.b.f.e().a("701", "process_name=" + c2 + "&real_logid_min=" + str + "&real_logid_max=" + str2 + "&normal_logid_min=" + str3 + "&normal_logid_max=" + str4 + "&immediate_logid_min=" + str5 + "&immediate_logid_max=" + str6 + "&logid_day=" + sb2.substring(0, sb2.length() - 3) + "&appkey=" + this.n + "&bundleid=" + packageName);
            e();
        }
    }

    private void a(long j, EventType eventType) {
        if (eventType == EventType.REALTIME || eventType == EventType.DT_REALTIME) {
            long j2 = this.u;
            this.u = j2 == 0 ? j : Math.max(j, j2);
            long j3 = this.t;
            if (j3 != 0) {
                j = Math.min(j, j3);
            }
            this.t = j;
        } else if (eventType == EventType.NORMAL || eventType == EventType.DT_NORMAL) {
            long j4 = this.w;
            this.w = j4 == 0 ? j : Math.max(j, j4);
            long j5 = this.v;
            if (j5 != 0) {
                j = Math.min(j, j5);
            }
            this.v = j;
        } else if (eventType == EventType.IMMEDIATE_MSF || eventType == EventType.IMMEDIATE_WNS) {
            long j6 = this.y;
            this.y = j6 == 0 ? j : Math.max(j, j6);
            long j7 = this.x;
            if (j7 != 0) {
                j = Math.min(j, j7);
            }
            this.x = j;
        }
    }

    private void b() {
        b = com.tencent.beacon.a.b.a.a().a(113);
        this.o.add("rqd_model");
        this.o.add("rqd_appresumed");
        c();
    }

    private void c() {
        SharedPreferences a2 = a(this.m);
        this.p = a2.getLong("on_date", 0L);
        this.r.set(a2.getLong("realtime_log_id", 0L));
        this.q.set(a2.getLong("normal_log_id", 0L));
        this.s.set(a2.getLong("immediate_log_id", 0L));
        this.t = a2.getLong("realtime_min_log_id", 0L);
        this.u = a2.getLong("realtime_max_log_id", 0L);
        this.v = a2.getLong("normal_min_log_id", 0L);
        this.w = a2.getLong("normal_max_log_id", 0L);
        this.x = a2.getLong("immediate_min_log_id", 0L);
        this.y = a2.getLong("immediate_max_log_id", 0L);
        com.tencent.beacon.base.util.c.a("[LogID " + this.n + "]", " load LogID from sp, date: %s , realtime: %d, normal: %d, immediate: %d", Long.valueOf(this.p), Long.valueOf(this.r.get()), Long.valueOf(this.q.get()), Long.valueOf(this.s.get()));
    }

    private boolean d() {
        long c2 = com.tencent.beacon.base.util.b.c();
        long j = this.p;
        return (j == 0 || com.tencent.beacon.base.util.b.a(c2, j)) ? false : true;
    }

    private void e() {
        this.t = this.u + 1;
        this.v = this.w + 1;
        this.x = this.y + 1;
    }

    public String a(String str, EventType eventType) {
        synchronized (this) {
            if (!this.B) {
                b();
                this.B = true;
            }
            if (this.o.contains(str)) {
                return "";
            }
            long a2 = a(eventType);
            a();
            this.p = com.tencent.beacon.base.util.b.c();
            a(a2, eventType);
            com.tencent.beacon.base.util.c.a("[stat " + this.n + "]", "type: %s, code: %s, logID: %s.", eventType, str, Long.valueOf(a2));
            b.post(this.A);
            return a2 + "";
        }
    }
}
