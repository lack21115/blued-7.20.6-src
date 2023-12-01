package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/hd.class */
public class hd extends uc<id> {
    public hd(ri riVar) {
        super(riVar);
    }

    @Override // com.tencent.mapsdk.internal.uc
    public gd a(id idVar) {
        gd gdVar;
        synchronized (this) {
            gdVar = (gd) super.a((hd) idVar);
        }
        return gdVar;
    }

    @Override // com.tencent.mapsdk.internal.uc
    public void a(tc tcVar) {
    }

    @Override // com.tencent.mapsdk.internal.uc
    public tc<id> b(id idVar) {
        return new gd(this, idVar);
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
            gd gdVar = (gd) this.d.get(this.d.keyAt(i2));
            gdVar.a(this.b.a(gdVar.f()));
            gdVar.f().setBitmap(null);
            gdVar.f().setLatLngBounds(null);
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
            gd gdVar = (gd) this.f.get(this.f.keyAt(i2));
            this.b.a(gdVar.x(), gdVar.f());
            gdVar.f().setBitmap(null);
            gdVar.f().setLatLngBounds(null);
            i = i2 + 1;
        }
    }
}
