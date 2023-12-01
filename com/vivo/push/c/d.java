package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/c/d.class */
public class d {
    private static volatile d d;

    /* renamed from: a  reason: collision with root package name */
    private b f27371a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27372c;

    private d(Context context) {
        if (this.f27371a == null) {
            Context context2 = ContextDelegate.getContext(context.getApplicationContext());
            this.f27372c = context2;
            this.f27371a = new e(context2);
        }
        if (this.b == null) {
            this.b = new a();
        }
    }

    public static d a(Context context) {
        if (d == null) {
            synchronized (d.class) {
                try {
                    if (d == null && context != null) {
                        d = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public final b a() {
        return this.f27371a;
    }
}
