package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;
import com.umeng.analytics.pro.at;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w6.class */
public class w6 extends x6 {
    @Json(name = "create")
    private long b;
    @Json(name = "destroy")

    /* renamed from: c  reason: collision with root package name */
    private long f38089c;
    @Json(name = "mapLoad")
    private s6 d;
    @Json(name = "oversea")
    private u6 e;
    @Json(name = "indoorLog")
    private r6 f;
    @Json(name = "darkMode")
    private m6 g;
    @Json(name = "pointEvent")
    private v6 h;
    @Json(name = "aoi")
    private i6 i;
    @Json(name = "vectorHeat")
    private a7 j;
    @Json(name = "heatMap")
    private q6 k;
    @Json(name = "arcLine")
    private j6 l;
    @Json(name = "dotScatter")
    private n6 m;
    @Json(name = "bitmapScatter")
    private k6 n;
    @Json(name = "trail")
    private y6 o;
    @Json(name = "model")
    private o6 p;
    @Json(name = "groundOverlay")
    private p6 q;
    @Json(name = "offline")
    private t6 r;
    @Json(name = "customStyle")
    private l6 s;
    @Json(name = at.j)
    private z6 t;

    public w6(long j) {
        super(j);
        this.b = j;
    }

    public i6 b() {
        if (this.i == null) {
            this.i = new i6(System.currentTimeMillis() - this.f38104a);
        }
        return this.i;
    }

    public j6 c() {
        if (this.l == null) {
            this.l = new j6(System.currentTimeMillis() - this.f38104a);
        }
        return this.l;
    }

    public k6 d() {
        if (this.n == null) {
            this.n = new k6(System.currentTimeMillis() - this.f38104a);
        }
        return this.n;
    }

    public l6 e() {
        if (this.s == null) {
            this.s = new l6(System.currentTimeMillis() - this.f38104a);
        }
        return this.s;
    }

    public m6 f() {
        if (this.g == null) {
            this.g = new m6(System.currentTimeMillis() - this.f38104a);
        }
        return this.g;
    }

    public n6 g() {
        if (this.m == null) {
            this.m = new n6(System.currentTimeMillis() - this.f38104a);
        }
        return this.m;
    }

    public o6 h() {
        if (this.p == null) {
            this.p = new o6(System.currentTimeMillis() - this.f38104a);
        }
        return this.p;
    }

    public p6 i() {
        if (this.q == null) {
            this.q = new p6(System.currentTimeMillis() - this.f38104a);
        }
        return this.q;
    }

    public q6 j() {
        if (this.k == null) {
            this.k = new q6(System.currentTimeMillis() - this.f38104a);
        }
        return this.k;
    }

    public r6 k() {
        if (this.f == null) {
            this.f = new r6(System.currentTimeMillis() - this.f38104a);
        }
        return this.f;
    }

    public s6 l() {
        if (this.d == null) {
            this.d = new s6(this.f38104a);
        }
        return this.d;
    }

    public t6 m() {
        if (this.r == null) {
            this.r = new t6(System.currentTimeMillis() - this.f38104a);
        }
        return this.r;
    }

    public u6 n() {
        if (this.e == null) {
            this.e = new u6(System.currentTimeMillis() - this.f38104a);
        }
        return this.e;
    }

    public v6 o() {
        if (this.h == null) {
            this.h = new v6(System.currentTimeMillis() - this.f38104a);
        }
        return this.h;
    }

    public y6 p() {
        if (this.o == null) {
            this.o = new y6(System.currentTimeMillis() - this.f38104a);
        }
        return this.o;
    }

    public z6 q() {
        if (this.t == null) {
            this.t = new z6(System.currentTimeMillis() - this.f38104a);
        }
        return this.t;
    }

    public a7 r() {
        if (this.j == null) {
            this.j = new a7(System.currentTimeMillis() - this.f38104a);
        }
        return this.j;
    }

    public w6 s() {
        this.f38089c = System.currentTimeMillis() - this.b;
        return this;
    }
}
