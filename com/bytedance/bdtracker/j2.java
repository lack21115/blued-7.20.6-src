package com.bytedance.bdtracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j2.class */
public abstract class j2<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f7632a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f7632a == null) {
            synchronized (this) {
                if (this.f7632a == null) {
                    this.f7632a = a(objArr);
                }
            }
        }
        return this.f7632a;
    }
}
