package com.cmic.gen.sdk.tencent.view;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f21703a;
    private a b;

    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/b$a.class */
    public interface a {
        void a();
    }

    public static b a() {
        if (f21703a == null) {
            synchronized (b.class) {
                try {
                    if (f21703a == null) {
                        f21703a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21703a;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public a b() {
        return this.b;
    }

    public void c() {
        if (this.b != null) {
            this.b = null;
        }
    }
}
