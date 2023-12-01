package com.bumptech.glide.util;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/util/MultiClassKey.class */
public class MultiClassKey {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f21107a;
    private Class<?> b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f21108c;

    public MultiClassKey() {
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f21107a = cls;
        this.b = cls2;
        this.f21108c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f21107a.equals(multiClassKey.f21107a) && this.b.equals(multiClassKey.b) && Util.a(this.f21108c, multiClassKey.f21108c);
    }

    public int hashCode() {
        int hashCode = this.f21107a.hashCode();
        int hashCode2 = this.b.hashCode();
        Class<?> cls = this.f21108c;
        return (((hashCode * 31) + hashCode2) * 31) + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f21107a + ", second=" + this.b + '}';
    }
}
