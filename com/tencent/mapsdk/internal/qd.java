package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/qd.class */
public class qd extends uc<rd> {
    public qd(ri riVar) {
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
    public pd a(rd rdVar) {
        pd pdVar;
        synchronized (this) {
            pdVar = (pd) super.a((qd) rdVar);
        }
        return pdVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    /* renamed from: b */
    public pd a(int i) {
        pd pdVar;
        synchronized (this) {
            pdVar = (pd) super.a(i);
        }
        return pdVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public pd b(rd rdVar) {
        return new pd(this, rdVar);
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
            pd pdVar = (pd) this.d.get(this.d.keyAt(i2));
            pdVar.a(this.b.a(pdVar.f()));
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
            this.b.e(((pd) this.h.get(this.h.keyAt(i2))).x());
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
            pd pdVar = (pd) this.f.get(this.f.keyAt(i2));
            this.b.a(pdVar.x(), pdVar.f());
            i = i2 + 1;
        }
    }
}
