package com.bytedance.bdtracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f3.class */
public abstract class f3<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f21218a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f21218a == null) {
            synchronized (this) {
                if (this.f21218a == null) {
                    this.f21218a = a(objArr);
                }
            }
        }
        return this.f21218a;
    }
}
