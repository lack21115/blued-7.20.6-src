package com.meizu.cloud.pushsdk.b;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/b/h.class */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f23992a;
    private T b;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.b = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        T t = this.f23992a;
        return t != null ? t : this.b;
    }
}
