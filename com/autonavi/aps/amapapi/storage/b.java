package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.3sl.jb;
import com.amap.api.col.3sl.jc;
import com.amap.api.location.AMapLocation;

@jb(a = "c")
/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/storage/b.class */
public class b {
    @jc(a = "a2", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f6424a;
    @jc(a = "a3", b = 5)
    private long b;
    @jc(a = "a4", b = 6)

    /* renamed from: c  reason: collision with root package name */
    private String f6425c;
    private AMapLocation d;

    public final AMapLocation a() {
        return this.d;
    }

    public final void a(long j) {
        this.b = j;
    }

    public final void a(AMapLocation aMapLocation) {
        this.d = aMapLocation;
    }

    public final void a(String str) {
        this.f6425c = str;
    }

    public final String b() {
        return this.f6425c;
    }

    public final void b(String str) {
        this.f6424a = str;
    }

    public final String c() {
        return this.f6424a;
    }

    public final long d() {
        return this.b;
    }
}
