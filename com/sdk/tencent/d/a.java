package com.sdk.tencent.d;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/d/a.class */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14339a = false;
    public e<?> b;

    /* renamed from: c  reason: collision with root package name */
    public a<T> f14340c;

    public a(T t) {
        a(t);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.sdk.tencent.d.e, com.sdk.tencent.d.e<?>] */
    public T a() {
        ?? r0 = (T) this.b;
        if (r0 == 0) {
            return null;
        }
        return this.f14339a ? r0 : (T) r0.b;
    }

    public void a(T t) {
        if (t == null) {
            this.b = null;
        } else if (!(t instanceof e)) {
            this.b = new e<>(b.DEFAULT, t);
        } else {
            this.b = (e) t;
            this.f14339a = true;
        }
    }
}
