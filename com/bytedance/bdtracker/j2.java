package com.bytedance.bdtracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j2.class */
public abstract class j2<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f21238a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f21238a == null) {
            synchronized (this) {
                if (this.f21238a == null) {
                    this.f21238a = a(objArr);
                }
            }
        }
        return this.f21238a;
    }
}
