package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/td.class */
public class td extends uc<ud> {
    public td(ri riVar) {
        super(riVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public sd a(ud udVar) {
        sd sdVar;
        synchronized (this) {
            sdVar = (sd) super.a((td) udVar);
        }
        return sdVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public tc<ud> b(ud udVar) {
        return new sd(this, udVar);
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
            O |= ((sd) this.f24354c.get(this.f24354c.keyAt(i2))).f().isAnimate();
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
            sd sdVar = (sd) this.d.get(this.d.keyAt(i2));
            sdVar.a(this.b.a(sdVar.f()));
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
            sd sdVar = (sd) this.f.get(this.f.keyAt(i2));
            this.b.a(sdVar.x(), sdVar.f());
            i = i2 + 1;
        }
    }
}
