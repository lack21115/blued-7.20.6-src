package com.anythink.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.c.d;
import com.anythink.core.common.b.g;
import com.anythink.core.common.k.p;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/a/b.class */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f6324c;

    /* renamed from: a  reason: collision with root package name */
    final String f6325a = b.class.getSimpleName();
    ConcurrentHashMap<String, com.anythink.core.common.e.c> b = new ConcurrentHashMap<>();

    public static b a() {
        if (f6324c == null) {
            synchronized (b.class) {
                try {
                    if (f6324c == null) {
                        f6324c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6324c;
    }

    public final boolean a(Context context, String str, d dVar) {
        if (dVar.ak() <= 0) {
            return false;
        }
        com.anythink.core.common.e.c cVar = this.b.get(str);
        com.anythink.core.common.e.c cVar2 = cVar;
        if (cVar == null) {
            String b = p.b(context, g.s, str, "");
            cVar2 = new com.anythink.core.common.e.c();
            if (!TextUtils.isEmpty(b)) {
                cVar2.a(b);
            }
            this.b.put(str, cVar2);
        }
        StringBuilder sb = new StringBuilder("Load Cap info:");
        sb.append(str);
        sb.append(":");
        sb.append(cVar2.toString());
        return cVar2.f6652a >= dVar.ak() && System.currentTimeMillis() - cVar2.b <= dVar.al();
    }

    public final void b(Context context, String str, d dVar) {
        com.anythink.core.common.e.c cVar = this.b.get(str);
        com.anythink.core.common.e.c cVar2 = cVar;
        if (cVar == null) {
            String b = p.b(context, g.s, str, "");
            cVar2 = new com.anythink.core.common.e.c();
            if (!TextUtils.isEmpty(b)) {
                cVar2.a(b);
            }
            this.b.put(str, cVar2);
        }
        if (System.currentTimeMillis() - cVar2.b > dVar.al()) {
            cVar2.b = System.currentTimeMillis();
            cVar2.f6652a = 0;
        }
        cVar2.f6652a++;
        StringBuilder sb = new StringBuilder("After save load cap:");
        sb.append(str);
        sb.append(":");
        sb.append(cVar2.toString());
        p.a(context, g.s, str, cVar2.toString());
    }
}
