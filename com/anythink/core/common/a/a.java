package com.anythink.core.common.a;

import android.content.Context;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.c.k;
import com.anythink.core.common.k.p;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6443a;
    private k b;

    private a() {
        if (n.a().g() != null) {
            this.b = k.a(com.anythink.core.common.c.c.a(n.a().g()));
        }
    }

    public static a a() {
        if (f6443a == null) {
            synchronized (a.class) {
                try {
                    if (f6443a == null) {
                        f6443a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6443a;
    }

    public static void c(Context context, String str) {
        p.a(context, com.anythink.core.common.b.g.y, str + g.o.n, 1);
    }

    public static boolean d(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g.o.n);
        return p.b(context, com.anythink.core.common.b.g.y, sb.toString(), 0) == 1;
    }

    public final String a(Context context, String str) {
        if (this.b == null) {
            this.b = k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
        }
        return this.b.b(str);
    }

    public final void a(Context context, int i, String str, String str2, String str3) {
        if (this.b == null) {
            this.b = k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
        }
        h hVar = new h();
        hVar.a(str2);
        hVar.b(str);
        hVar.a(i);
        hVar.c(str3);
        this.b.a(hVar);
    }

    public final void b(final Context context, final String str) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.b == null) {
                    a.this.b = k.a(com.anythink.core.common.c.c.a(context.getApplicationContext()));
                }
                a.this.b.a(str);
            }
        });
        p.a(context, com.anythink.core.common.b.g.y, str + g.o.n);
    }
}
