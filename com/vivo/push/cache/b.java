package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.p;
import java.lang.reflect.Method;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/cache/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f41066a;
    private d b;

    private b() {
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f41066a == null) {
                    f41066a = new b();
                }
                bVar = f41066a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final d a(Context context) {
        d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        try {
            Method method = Class.forName("com.vivo.push.cache.ClientConfigManagerImpl").getMethod("getInstance", Context.class);
            p.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            d dVar2 = (d) method.invoke(null, context);
            this.b = dVar2;
            return dVar2;
        } catch (Exception e) {
            e.printStackTrace();
            p.b("ConfigManagerFactory", "createConfig error", e);
            return null;
        }
    }
}
