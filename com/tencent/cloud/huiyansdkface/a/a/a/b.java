package com.tencent.cloud.huiyansdkface.a.a.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    int f21737a;
    int b;

    public b(int i, int i2) {
        this.f21737a = i;
        this.b = i2;
    }

    public int a() {
        return this.f21737a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.f21737a >= 0 && this.b >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f21737a == bVar.f21737a && this.b == bVar.b;
    }

    public int hashCode() {
        return (this.f21737a * 31) + this.b;
    }

    public String toString() {
        return "{min=" + this.f21737a + ", max=" + this.b + '}';
    }
}
