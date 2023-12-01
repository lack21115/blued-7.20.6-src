package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/zc.class */
public class zc extends uc<yc> {
    public zc(ri riVar) {
        super(riVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public xc a(yc ycVar) {
        xc xcVar;
        synchronized (this) {
            xcVar = (xc) super.a((zc) ycVar);
        }
        return xcVar;
    }

    public VectorHeatAggregationUnit a(long j, LatLng latLng) {
        ri riVar = this.b;
        if (riVar == null) {
            return null;
        }
        return riVar.a(j, latLng);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public tc<yc> b(yc ycVar) {
        return new xc(this, ycVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void f() {
        if (this.b.m()) {
            this.b.T();
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void g() {
        int size = this.f24354c.size();
        boolean O = this.b.O();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            O |= ((xc) this.f24354c.get(this.f24354c.keyAt(i2))).f().isAnimate();
            i = i2 + 1;
        }
        if (O) {
            this.b.T();
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void h() {
        int size = this.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            xc xcVar = (xc) this.d.get(this.d.keyAt(i2));
            xcVar.a(this.b.a(xcVar.f()));
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void i() {
        int size = this.h.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.b.f(((tc) this.h.get(this.h.keyAt(i2))).x());
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void j() {
        int size = this.f.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            xc xcVar = (xc) this.f.get(this.f.keyAt(i2));
            this.b.a(xcVar.x(), xcVar.f());
            i = i2 + 1;
        }
    }
}
