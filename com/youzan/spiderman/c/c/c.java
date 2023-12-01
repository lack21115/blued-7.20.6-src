package com.youzan.spiderman.c.c;

import android.content.Context;
import com.youzan.spiderman.html.f;
import com.youzan.spiderman.html.k;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/c/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f41756a;

    private c() {
    }

    public static c a() {
        if (f41756a == null) {
            f41756a = new c();
        }
        return f41756a;
    }

    public static void a(Context context) {
        f fVar = new f(context, k.a().b(), com.youzan.spiderman.c.a.a.a().f());
        if (fVar.a()) {
            com.youzan.spiderman.a.c.a().a(new a(context, fVar));
        }
    }
}
