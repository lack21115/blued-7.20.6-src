package com.kwad.sdk.components;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/components/c.class */
public final class c {
    private static final Map<Class, a> abu = new ConcurrentHashMap();

    public static void a(Class cls, a aVar) {
        abu.put(cls, aVar);
    }

    public static <T extends a> T f(Class<T> cls) {
        T t = (T) abu.get(cls);
        if (t != null) {
            return t;
        }
        com.kwad.sdk.core.d.b.w("KSAdSDK", new ComponentsNotFoundException(cls.getSimpleName()));
        try {
            if (DevelopMangerComponents.class.isAssignableFrom(cls)) {
                e eVar = new e();
                abu.put(cls, eVar);
                return eVar;
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static void init(Context context) {
        ArrayList arrayList = new ArrayList(abu.values());
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.kwad.sdk.components.c.1
            private static int a(a aVar, a aVar2) {
                if (aVar == null) {
                    return -1;
                }
                if (aVar2 == null) {
                    return 1;
                }
                try {
                    try {
                        return aVar.priority() - aVar2.priority();
                    } catch (Exception e) {
                        return 1;
                    }
                } catch (Exception e2) {
                    return -1;
                }
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                return a(aVar, aVar2);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                try {
                    aVar.init(context);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        }
    }
}
