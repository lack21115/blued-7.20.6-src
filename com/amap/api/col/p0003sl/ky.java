package com.amap.api.col.p0003sl;

/* renamed from: com.amap.api.col.3sl.ky  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ky.class */
public abstract class ky {
    ky c;

    public ky() {
    }

    public ky(ky kyVar) {
        this.c = kyVar;
    }

    public int a() {
        ky kyVar = this.c;
        return Math.min(Integer.MAX_VALUE, kyVar != null ? kyVar.a() : Integer.MAX_VALUE);
    }

    public void b_(int i) {
        ky kyVar = this.c;
        if (kyVar != null) {
            kyVar.b_(i);
        }
    }

    protected abstract boolean c();

    public void c_(boolean z) {
        ky kyVar = this.c;
        if (kyVar != null) {
            kyVar.c_(z);
        }
    }

    public final boolean d() {
        ky kyVar = this.c;
        if (kyVar != null ? kyVar.d() : true) {
            return c();
        }
        return false;
    }
}
