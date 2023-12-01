package com.tencent.beacon.e;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/b.class */
public class b implements com.tencent.beacon.a.a.d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f21325a;
    protected Boolean f;
    protected c h;
    protected int b = 48;

    /* renamed from: c  reason: collision with root package name */
    protected int f21326c = 2000;
    protected int d = 48;
    protected int e = 5000;
    protected boolean g = true;
    protected boolean i = true;
    protected boolean j = true;
    protected Set<String> k = null;
    protected Map<String, Float> l = null;
    protected boolean m = false;
    protected boolean n = false;
    protected boolean o = false;
    protected float p = 1.0f;
    protected boolean q = false;
    protected boolean r = false;
    protected boolean s = false;
    protected int t = 1;
    protected long u = 6400;
    protected int v = 20;
    protected int w = 300;
    protected boolean x = true;
    protected boolean y = true;
    protected boolean z = true;
    protected boolean A = true;
    protected boolean B = true;
    protected int C = 10000;
    protected boolean D = true;
    protected boolean E = true;
    protected boolean F = false;
    protected int G = 1;

    protected b() {
        com.tencent.beacon.a.a.b.a().a(8, this);
    }

    public static b a() {
        if (f21325a == null) {
            synchronized (b.class) {
                try {
                    if (f21325a == null) {
                        f21325a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21325a;
    }

    private void b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("d_m", new HashMap(map));
        com.tencent.beacon.a.a.b.a().b(new com.tencent.beacon.a.a.c(2, hashMap));
    }

    private void o() {
        c cVar = this.h;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void a(int i) {
        if (i < 24 || i > 100) {
            return;
        }
        this.d = i;
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        if (cVar.f21229a != 8) {
            return;
        }
        this.y = cVar.b.containsKey("u_c_a_e") ? ((Boolean) cVar.b.get("u_c_a_e")).booleanValue() : this.y;
        this.x = cVar.b.containsKey("u_c_b_e") ? ((Boolean) cVar.b.get("u_c_b_e")).booleanValue() : this.x;
        this.C = cVar.b.containsKey("u_c_d_s") ? ((Integer) cVar.b.get("u_c_d_s")).intValue() : this.C;
        this.i = cVar.b.containsKey("u_c_p_s") ? ((Boolean) cVar.b.get("u_c_p_s")).booleanValue() : this.i;
        this.z = cVar.b.containsKey("u_s_o_h") ? ((Boolean) cVar.b.get("u_s_o_h")).booleanValue() : this.z;
    }

    public void a(c cVar) {
        this.h = cVar;
    }

    public void a(Map<String, String> map) {
        synchronized (this) {
            if (map != null) {
                b(map);
                try {
                    if (this.b == 48) {
                        this.b = com.tencent.beacon.base.util.b.a(map.get("realtimeUploadNum"), this.b, 24, 100);
                    }
                    if (this.d == 48) {
                        this.d = com.tencent.beacon.base.util.b.a(map.get("normalUploadNum"), this.d, 24, 100);
                    }
                    if (this.e == 5000) {
                        this.e = com.tencent.beacon.base.util.b.a(map.get("normalPollingTime"), this.e, 2000, (int) BaseConstants.Time.HOUR);
                    }
                    if (this.f21326c == 2000) {
                        this.f21326c = com.tencent.beacon.base.util.b.a(map.get("realtimePollingTime"), this.f21326c, 1000, 10000);
                    }
                    this.j = com.tencent.beacon.base.util.b.a(map.get("heartOnOff"), this.j);
                    this.m = com.tencent.beacon.base.util.b.a(map.get("tidyEF"), this.m);
                    this.n = com.tencent.beacon.base.util.b.a(map.get("lauEveSim"), this.n);
                    this.o = com.tencent.beacon.base.util.b.a(map.get("zeroPeakOnOff"), this.o);
                    String str = map.get("zeroPeakRate");
                    if (str != null) {
                        String trim = str.trim();
                        if (trim.length() > 0) {
                            String[] split = trim.split(",");
                            if (split.length == 2) {
                                try {
                                    this.p = Float.valueOf(split[0]).floatValue() / Float.valueOf(split[1]).floatValue();
                                } catch (Exception e) {
                                    com.tencent.beacon.base.util.c.a(e);
                                }
                            }
                        }
                    }
                    this.F = com.tencent.beacon.base.util.b.a(map.get("straOnOff"), this.F);
                    this.G = com.tencent.beacon.base.util.b.a(map.get("straDayMaxCount"), this.G, 1, Integer.MAX_VALUE);
                    this.q = com.tencent.beacon.base.util.b.a(map.get("acceleEnable"), this.q);
                    this.r = com.tencent.beacon.base.util.b.a(map.get("gyroEnable"), this.r);
                    this.s = com.tencent.beacon.base.util.b.a(map.get("magneticEnable"), this.s);
                    this.t = com.tencent.beacon.base.util.b.a(map.get("gatherCount"), this.t, 1, 50);
                    this.u = com.tencent.beacon.base.util.b.a(map.get("gatherDur"), this.u, 1000L, 20000L);
                    this.v = com.tencent.beacon.base.util.b.a(map.get("hertzCount"), this.v, 20, 100);
                    this.w = com.tencent.beacon.base.util.b.a(map.get("consuming"), this.w, 60, 86400);
                    this.x = com.tencent.beacon.base.util.b.a(map.get("bidEnable"), this.x);
                    this.y = com.tencent.beacon.base.util.b.a(map.get("auditEnable"), this.y);
                    this.C = com.tencent.beacon.base.util.b.a(map.get("maxDBCount"), this.C, 10000, 100000);
                    com.tencent.beacon.base.net.b.b.c(map.get("eventUrl"));
                    com.tencent.beacon.base.net.b.b.e(map.get("strategyUrl"));
                } catch (Exception e2) {
                    com.tencent.beacon.base.util.c.a(e2);
                }
            }
        }
    }

    public void a(Set<String> set) {
        synchronized (this) {
            this.k = set;
        }
    }

    public void a(boolean z) {
        this.A = z;
    }

    public void a(boolean z, boolean z2) {
        com.tencent.beacon.base.util.c.a("event report state changed: " + z, new Object[0]);
        boolean h = h();
        if (z2) {
            this.f = Boolean.valueOf(z);
        } else {
            this.g = z;
        }
        if (h != h()) {
            o();
        }
    }

    public boolean a(String str) {
        boolean z;
        synchronized (this) {
            Set<String> set = this.k;
            z = false;
            if (set != null) {
                z = false;
                if (set.size() > 0) {
                    z = this.k.contains(str);
                }
            }
        }
        return z;
    }

    public int b() {
        return this.C;
    }

    public void b(int i) {
        if (i < 24 || i > 100) {
            return;
        }
        this.b = i;
    }

    public void b(Set<String> set) {
        synchronized (this) {
            if (this.l == null) {
                this.l = new HashMap();
            }
            if (set == null) {
                return;
            }
            for (String str : set) {
                String[] split = str.split(",");
                if (split.length == 3) {
                    try {
                        this.l.put(split[0].toLowerCase(), Float.valueOf(Float.valueOf(split[1]).floatValue() / Float.valueOf(split[2]).floatValue()));
                    } catch (Exception e) {
                        com.tencent.beacon.base.util.c.a(e);
                    }
                }
            }
        }
    }

    public void b(boolean z) {
        this.B = z;
    }

    public boolean b(String str) {
        synchronized (this) {
            Map<String, Float> map = this.l;
            boolean z = true;
            if (map != null && map.get(str.toLowerCase()) != null) {
                if (new Random().nextInt(1000) + 1 > ((int) (this.l.get(str.toLowerCase()).floatValue() * 1000.0f))) {
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
            i = this.d;
        }
        return i;
    }

    public int d() {
        int i;
        synchronized (this) {
            i = this.b;
        }
        return i;
    }

    public int e() {
        int i;
        synchronized (this) {
            i = this.G;
        }
        return i;
    }

    public boolean f() {
        return this.y;
    }

    public boolean g() {
        return this.x;
    }

    public boolean h() {
        Boolean bool = this.f;
        return bool == null ? this.g : bool.booleanValue();
    }

    public boolean i() {
        boolean z;
        synchronized (this) {
            z = this.n;
        }
        return z;
    }

    public boolean j() {
        return this.i;
    }

    public boolean k() {
        return this.B;
    }

    public boolean l() {
        return this.A;
    }

    public boolean m() {
        return this.z;
    }

    public boolean n() {
        boolean z;
        synchronized (this) {
            z = this.F;
        }
        return z;
    }
}
