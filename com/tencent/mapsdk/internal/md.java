package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/md.class */
public class md extends uc<od> {
    public md(ri riVar) {
        super(riVar);
    }

    public int a(long j) {
        ri riVar = this.b;
        if (riVar == null || j == 0) {
            return 0;
        }
        return riVar.d(j);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public nd a(od odVar) {
        nd ndVar;
        synchronized (this) {
            ndVar = (nd) super.a((md) odVar);
        }
        return ndVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public nd b(od odVar) {
        return new nd(this, odVar);
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
            nd ndVar = (nd) this.d.get(this.d.keyAt(i2));
            ndVar.a(this.b.a(ndVar.f()));
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
            this.b.e(((tc) this.h.get(this.h.keyAt(i2))).x());
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
            nd ndVar = (nd) this.f.get(this.f.keyAt(i2));
            this.b.a(ndVar.x(), ndVar.f());
            i = i2 + 1;
        }
    }
}
