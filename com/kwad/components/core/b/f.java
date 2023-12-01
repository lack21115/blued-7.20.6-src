package com.kwad.components.core.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/f.class */
public class f {
    private static volatile f Ii;
    private ConcurrentHashMap<String, WeakReference<Object>> Ih = new ConcurrentHashMap<>();

    private static String G(AdTemplate adTemplate) {
        long bU = com.kwad.sdk.core.response.a.d.bU(adTemplate);
        long cl = com.kwad.sdk.core.response.a.d.cl(adTemplate);
        return bU + "-" + cl;
    }

    private static String b(g gVar) {
        String ml = gVar.ml();
        String mr = gVar.mr();
        return ml + "-" + mr;
    }

    public static f mk() {
        if (Ii == null) {
            synchronized (f.class) {
                try {
                    if (Ii == null) {
                        Ii = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Ii;
    }

    public final void F(AdTemplate adTemplate) {
        this.Ih.remove(G(adTemplate));
    }

    public final boolean a(g gVar) {
        String b = b(gVar);
        com.kwad.sdk.core.d.b.d("AdMemCachePool", "contains key: " + b);
        if (this.Ih.containsKey(b)) {
            WeakReference<Object> weakReference = this.Ih.get(b);
            boolean z = false;
            if (weakReference != null) {
                z = false;
                if (weakReference.get() != null) {
                    z = true;
                }
            }
            if (z) {
                com.kwad.sdk.core.d.b.d("AdMemCachePool", "contains ad: " + weakReference.get());
            }
            return z;
        }
        return false;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Ih.put(G(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }
}
