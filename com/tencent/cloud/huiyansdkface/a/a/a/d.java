package com.tencent.cloud.huiyansdkface.a.a.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f35431a;
    public int b;

    public d(int i, int i2) {
        this.f35431a = i;
        this.b = i2;
    }

    public int a() {
        return this.f35431a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f35431a * this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f35431a == dVar.f35431a && this.b == dVar.b;
    }

    public int hashCode() {
        return (this.f35431a * 31) + this.b;
    }

    public String toString() {
        return "{width=" + this.f35431a + ", height=" + this.b + '}';
    }
}
