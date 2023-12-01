package com.tencent.qimei.b;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/b/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f38311a;

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f38311a == null) {
                    f38311a = new c();
                }
                aVar = f38311a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public abstract void a(long j, Runnable runnable);

    public abstract void a(Runnable runnable);
}
