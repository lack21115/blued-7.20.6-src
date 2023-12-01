package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kd.class */
public class kd extends uc<ld> {
    public kd(ri riVar) {
        super(riVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public jd a(ld ldVar) {
        jd jdVar;
        synchronized (this) {
            jdVar = (jd) super.a((kd) ldVar);
        }
        return jdVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public tc<ld> b(ld ldVar) {
        return new jd(this, ldVar);
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
            O |= ((jd) this.f24354c.get(this.f24354c.keyAt(i2))).f().isAnimate();
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
            jd jdVar = (jd) this.d.get(this.d.keyAt(i2));
            jdVar.a(this.b.a(jdVar.f()));
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
            jd jdVar = (jd) this.f.get(this.f.keyAt(i2));
            this.b.a(jdVar.x(), jdVar.f());
            i = i2 + 1;
        }
    }
}
