package c.t.m.g;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q2.class */
public class q2 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile Context f3944a;

    public static final Context a() {
        Context context;
        synchronized (q2.class) {
            try {
                if (f3944a == null) {
                    throw new NullPointerException("u should init first.");
                }
                context = f3944a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return context;
    }

    public static final void a(Context context) {
        synchronized (q2.class) {
            try {
                if (f3944a == null || f3944a.getApplicationContext() == null) {
                    if (context == null || context.getApplicationContext() == null) {
                        throw new NullPointerException("context cannot be null.");
                    }
                    f3944a = context.getApplicationContext();
                    r0.b();
                }
            } finally {
            }
        }
    }

    public static final void a(boolean z) {
    }
}
