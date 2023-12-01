package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.e.al;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/x.class */
public class x {
    private static final String c = x.class.getSimpleName();
    private static volatile x d;
    Map<String, al> a;
    Context b;

    private x(Context context) {
        this.b = context.getApplicationContext();
        a();
    }

    public static x a(Context context) {
        if (d == null) {
            synchronized (x.class) {
                try {
                    if (d == null) {
                        d = new x(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    private void a() {
        if (this.a == null) {
            this.a = new ConcurrentHashMap(5);
            try {
                Map<String, ?> a = com.anythink.core.common.k.p.a(this.b, com.anythink.core.common.b.g.B);
                if (a != null) {
                    for (Map.Entry<String, ?> entry : a.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            this.a.put(key, al.a((String) value));
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private al b(String str) {
        Map<String, al> map = this.a;
        if (map != null) {
            return map.remove(str);
        }
        return null;
    }

    private static void b() {
    }

    public final void a(String str) {
        Map<String, al> map = this.a;
        if (map == null) {
            return;
        }
        try {
            al alVar = map.get(str);
            if (alVar != null) {
                com.anythink.core.common.k.p.a(this.b, com.anythink.core.common.b.g.B, str, alVar.a().toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String str, String str2, al.a aVar, al.a aVar2) {
        Map<String, al> map = this.a;
        if (map == null) {
            return;
        }
        al alVar = map.get(str);
        al alVar2 = alVar;
        if (alVar == null) {
            synchronized (this) {
                al alVar3 = this.a.get(str);
                alVar2 = alVar3;
                if (alVar3 == null) {
                    alVar2 = new al();
                    alVar2.b(str2);
                    this.a.put(str, alVar2);
                }
            }
        }
        if (TextUtils.equals(str2, alVar2.b())) {
            if (aVar != null) {
                alVar2.a(aVar);
                alVar2.a(System.currentTimeMillis());
            }
            if (aVar2 != null) {
                alVar2.b(aVar2);
            }
        }
    }
}
