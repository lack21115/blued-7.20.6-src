package com.bytedance.bdtracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/f3.class */
public abstract class f3<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f7612a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.f7612a == null) {
            synchronized (this) {
                if (this.f7612a == null) {
                    this.f7612a = a(objArr);
                }
            }
        }
        return this.f7612a;
    }
}
