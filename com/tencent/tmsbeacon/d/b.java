package com.tencent.tmsbeacon.d;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/b.class */
public class b implements com.tencent.tmsbeacon.a.a.d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f25851a;
    public int b = 48;

    /* renamed from: c  reason: collision with root package name */
    public int f25852c = 2000;
    public int d = 48;
    public int e = 3000;
    public boolean f = true;
    public boolean g = true;
    public Set<String> h = null;
    public Map<String, Float> i = null;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public float m = 1.0f;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public int q = 1;
    public long r = 6400;
    public int s = 20;
    public int t = 300;
    public boolean u = true;
    public boolean v = true;
    public boolean w = true;
    public boolean x = true;
    public int y = 10000;
    public boolean z = false;
    public int A = 1;

    public b() {
        com.tencent.tmsbeacon.a.a.b.a().a(8, this);
    }

    public static b a() {
        if (f25851a == null) {
            synchronized (b.class) {
                try {
                    if (f25851a == null) {
                        f25851a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25851a;
    }

    private void b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("d_m", new HashMap(map));
        com.tencent.tmsbeacon.a.a.b.a().b(new com.tencent.tmsbeacon.a.a.c(2, hashMap));
    }

    public void a(Map<String, String> map) {
        synchronized (this) {
            if (map != null) {
                b(map);
                try {
                    this.b = com.tencent.tmsbeacon.base.util.b.a(map.get("realtimeUploadNum"), this.b, 24, 100);
                    this.f25852c = com.tencent.tmsbeacon.base.util.b.a(map.get("realtimePollingTime"), this.f25852c, 1000, 10000);
                    this.e = com.tencent.tmsbeacon.base.util.b.a(map.get("normalPollingTime"), this.e, 2000, (int) BaseConstants.Time.HOUR);
                    this.d = com.tencent.tmsbeacon.base.util.b.a(map.get("normalUploadNum"), this.d, 24, 100);
                    this.g = com.tencent.tmsbeacon.base.util.b.a(map.get("heartOnOff"), this.g);
                    this.j = com.tencent.tmsbeacon.base.util.b.a(map.get("tidyEF"), this.j);
                    this.k = com.tencent.tmsbeacon.base.util.b.a(map.get("lauEveSim"), this.k);
                    this.l = com.tencent.tmsbeacon.base.util.b.a(map.get("zeroPeakOnOff"), this.l);
                    String str = map.get("zeroPeakRate");
                    if (str != null) {
                        String trim = str.trim();
                        if (trim.length() > 0) {
                            String[] split = trim.split(",");
                            if (split.length == 2) {
                                try {
                                    this.m = Float.valueOf(split[0]).floatValue() / Float.valueOf(split[1]).floatValue();
                                } catch (Exception e) {
                                    com.tencent.tmsbeacon.base.util.c.a(e);
                                }
                            }
                        }
                    }
                    this.z = com.tencent.tmsbeacon.base.util.b.a(map.get("straOnOff"), this.z);
                    this.A = com.tencent.tmsbeacon.base.util.b.a(map.get("straDayMaxCount"), this.A, 1, Integer.MAX_VALUE);
                    this.n = com.tencent.tmsbeacon.base.util.b.a(map.get("acceleEnable"), this.n);
                    this.o = com.tencent.tmsbeacon.base.util.b.a(map.get("gyroEnable"), this.o);
                    this.p = com.tencent.tmsbeacon.base.util.b.a(map.get("magneticEnable"), this.p);
                    this.q = com.tencent.tmsbeacon.base.util.b.a(map.get("gatherCount"), this.q, 1, 50);
                    this.r = com.tencent.tmsbeacon.base.util.b.a(map.get("gatherDur"), this.r, 1000L, 20000L);
                    this.s = com.tencent.tmsbeacon.base.util.b.a(map.get("hertzCount"), this.s, 20, 100);
                    this.t = com.tencent.tmsbeacon.base.util.b.a(map.get("consuming"), this.t, 60, 86400);
                    this.u = com.tencent.tmsbeacon.base.util.b.a(map.get("bidEnable"), this.u);
                    this.v = com.tencent.tmsbeacon.base.util.b.a(map.get("auditEnable"), this.v);
                    this.y = com.tencent.tmsbeacon.base.util.b.a(map.get("maxDBCount"), this.y, 10000, 100000);
                    com.tencent.tmsbeacon.base.net.b.b.c(map.get("eventUrl"));
                    com.tencent.tmsbeacon.base.net.b.b.e(map.get("strategyUrl"));
                } catch (Exception e2) {
                    com.tencent.tmsbeacon.base.util.c.a(e2);
                }
            }
        }
    }

    public void a(Set<String> set) {
        synchronized (this) {
            this.h = set;
        }
    }

    public void a(boolean z) {
        this.w = z;
    }

    public boolean a(String str) {
        boolean z;
        synchronized (this) {
            Set<String> set = this.h;
            z = false;
            if (set != null) {
                z = false;
                if (set.size() > 0) {
                    z = this.h.contains(str);
                }
            }
        }
        return z;
    }

    public int b() {
        return this.y;
    }

    public void b(Set<String> set) {
        synchronized (this) {
            if (this.i == null) {
                this.i = new HashMap();
            }
            if (set == null) {
                return;
            }
            for (String str : set) {
                String[] split = str.split(",");
                if (split.length == 3) {
                    try {
                        this.i.put(split[0].toLowerCase(), Float.valueOf(Float.valueOf(split[1]).floatValue() / Float.valueOf(split[2]).floatValue()));
                    } catch (Exception e) {
                        com.tencent.tmsbeacon.base.util.c.a(e);
                    }
                }
            }
        }
    }

    public boolean b(String str) {
        synchronized (this) {
            Map<String, Float> map = this.i;
            boolean z = true;
            if (map != null && map.get(str.toLowerCase()) != null) {
                if (new Random().nextInt(1000) + 1 > ((int) (this.i.get(str.toLowerCase()).floatValue() * 1000.0f))) {
                    z = false;
                }
                return z;
            }
            return true;
        }
    }

    public int c() {
        int i;
        synchronized (this) {
            i = this.A;
        }
        return i;
    }

    public boolean d() {
        return this.u;
    }

    public boolean e() {
        boolean z;
        synchronized (this) {
            z = this.k;
        }
        return z;
    }

    public boolean f() {
        return this.f;
    }

    public boolean g() {
        return this.w;
    }

    public boolean h() {
        return this.x;
    }

    public boolean i() {
        boolean z;
        synchronized (this) {
            z = this.z;
        }
        return z;
    }

    @Override // com.tencent.tmsbeacon.a.a.d
    public void onEvent(com.tencent.tmsbeacon.a.a.c cVar) {
        if (cVar.f25769a != 8) {
            return;
        }
        this.v = cVar.b.containsKey("u_c_a_e") ? ((Boolean) cVar.b.get("u_c_a_e")).booleanValue() : this.v;
        this.u = cVar.b.containsKey("u_c_b_e") ? ((Boolean) cVar.b.get("u_c_b_e")).booleanValue() : this.u;
        this.y = cVar.b.containsKey("u_c_d_s") ? ((Integer) cVar.b.get("u_c_d_s")).intValue() : this.y;
        this.f = cVar.b.containsKey("u_c_p_s") ? ((Boolean) cVar.b.get("u_c_p_s")).booleanValue() : this.f;
        this.x = cVar.b.containsKey("u_s_o_h") ? ((Boolean) cVar.b.get("u_s_o_h")).booleanValue() : this.x;
    }
}
