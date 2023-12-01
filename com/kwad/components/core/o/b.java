package com.kwad.components.core.o;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/o/b.class */
public class b {
    private static volatile b Pb;
    private static volatile int Pc = 204800;
    static volatile boolean Pd = true;
    static volatile boolean Pe = false;
    static volatile Set<c> Pf = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static void a(c cVar) {
        synchronized (b.class) {
            try {
                if (Pf.contains(cVar)) {
                    Pf.remove(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(boolean z, int i) {
        if (i > 0) {
            Pc = i * 1024;
        }
        Pd = z;
    }

    public static b pm() {
        if (Pb == null) {
            synchronized (b.class) {
                try {
                    if (Pb == null) {
                        Pb = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Pb;
    }

    public static boolean pn() {
        return Pd;
    }

    public static int po() {
        return Pc / 1024;
    }

    public static void register() {
        try {
            com.kwad.sdk.service.a.b(SpeedLimitApi.class, a.class);
        } catch (Throwable th) {
        }
    }

    private static InputStream wrap(InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            try {
                cVar = new c(inputStream, Pc / (Pf.size() + 1));
                Pf.add(cVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final int pp() {
        int i;
        synchronized (this) {
            int i2 = 0;
            int i3 = 0;
            try {
                Iterator<c> it = Pf.iterator();
                while (true) {
                    i = i3;
                    i2 = i3;
                    if (!it.hasNext()) {
                        break;
                    }
                    int i4 = i3;
                    i3 += (int) it.next().pq();
                }
            } catch (Exception e) {
                i = i2;
            }
        }
        return i;
    }
}
