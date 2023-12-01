package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bd.class */
public class bd extends uc<cd> {
    public bd(ri riVar) {
        super(riVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public ad a(cd cdVar) {
        ad adVar;
        synchronized (this) {
            adVar = (ad) super.a((bd) cdVar);
        }
        return adVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public tc<cd> b(cd cdVar) {
        return new ad(this, cdVar);
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
            O |= ((ad) this.f24354c.get(this.f24354c.keyAt(i2))).f().getIsAnimate();
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
            ad adVar = (ad) this.d.get(this.d.keyAt(i2));
            adVar.a(this.b.a(adVar.f()));
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
            ad adVar = (ad) this.f.get(this.f.keyAt(i2));
            this.b.a(adVar.x(), adVar.f());
            i = i2 + 1;
        }
    }
}
