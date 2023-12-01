package com.amap.api.col.p0003sl;

import com.huawei.openalliance.ad.constant.t;

/* renamed from: com.amap.api.col.3sl.im  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/im.class */
public final class im extends ky {
    private static int g = 10000000;

    /* renamed from: a  reason: collision with root package name */
    protected int f5166a;
    protected long b;
    private boolean d;
    private boolean e;
    private int f;
    private long h;

    public im(boolean z, ky kyVar, long j, int i) {
        super(kyVar);
        this.d = false;
        this.e = false;
        this.f = g;
        this.h = 0L;
        this.d = z;
        this.f5166a = t.Y;
        this.h = j;
        this.f = i;
    }

    @Override // com.amap.api.col.p0003sl.ky
    public final int a() {
        return 320000;
    }

    public final void a(int i) {
        if (i <= 0) {
            return;
        }
        this.h += i;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final long b() {
        return this.h;
    }

    @Override // com.amap.api.col.p0003sl.ky
    protected final boolean c() {
        if (!this.e || this.h > this.f) {
            if (this.d && this.h < this.f) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.b < this.f5166a) {
                    return false;
                }
                this.b = currentTimeMillis;
                return true;
            }
            return false;
        }
        return true;
    }
}
