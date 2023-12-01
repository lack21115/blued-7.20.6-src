package com.tencent.liteav.base.util;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/n.class */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public int f36340a;
    public int b;

    public n() {
        this(0, 0);
    }

    public n(int i, int i2) {
        this.f36340a = i;
        this.b = i2;
    }

    public n(n nVar) {
        a(nVar);
    }

    public final void a() {
        int i = this.f36340a;
        this.f36340a = this.b;
        this.b = i;
    }

    public final void a(int i, int i2) {
        this.f36340a = i;
        this.b = i2;
    }

    public final void a(n nVar) {
        if (nVar != null) {
            this.f36340a = nVar.f36340a;
            this.b = nVar.b;
            return;
        }
        this.f36340a = 0;
        this.b = 0;
    }

    public final int b() {
        if (d()) {
            return this.f36340a * this.b;
        }
        return 0;
    }

    public final double c() {
        return (this.f36340a * 1.0d) / this.b;
    }

    public final boolean d() {
        return this.f36340a > 0 && this.b > 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return nVar.f36340a == this.f36340a && nVar.b == this.b;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f36340a * 32713) + this.b;
    }

    public final String toString() {
        return "Size(" + this.f36340a + ", " + this.b + ")";
    }
}
