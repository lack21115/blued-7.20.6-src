package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/wd.class */
public class wd extends uc<xd> {
    public wd(ri riVar) {
        super(riVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public vd a(xd xdVar) {
        vd vdVar;
        synchronized (this) {
            vdVar = (vd) super.a((wd) xdVar);
        }
        return vdVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public tc<xd> b(xd xdVar) {
        return new vd(this, xdVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void f() {
        if (this.b.m()) {
            this.b.T();
        }
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void g() {
        int size = this.f38045c.size();
        boolean O = this.b.O();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            O |= ((vd) this.f38045c.get(this.f38045c.keyAt(i2))).f().getIsAnimate();
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
            vd vdVar = (vd) this.d.get(this.d.keyAt(i2));
            vdVar.a(this.b.a(vdVar.f()));
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
            vd vdVar = (vd) this.f.get(this.f.keyAt(i2));
            this.b.a(vdVar.x(), vdVar.f());
            i = i2 + 1;
        }
    }
}
