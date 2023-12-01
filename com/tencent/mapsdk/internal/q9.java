package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.internal.m9;
import com.tencent.mapsdk.internal.s9;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/q9.class */
public class q9 {

    /* renamed from: a  reason: collision with root package name */
    private static o9 f24027a = new o9();

    public static <D extends n9> k9<D> a(m9<D> m9Var) {
        if (m9Var instanceof k9) {
            return (k9) m9Var;
        }
        return null;
    }

    public static <D extends n9> k9<D> a(Class<D> cls, m9.a... aVarArr) {
        return a(b(cls, aVarArr));
    }

    public static String a(String str) {
        return f24027a.a(str);
    }

    public static <D extends n9> m9<D> b(Class<D> cls, m9.a... aVarArr) {
        m9<D> m9Var = null;
        m9<D> m9Var2 = null;
        if (cls != null) {
            m9Var2 = null;
            if (aVarArr != null) {
                if (aVarArr.length == 0) {
                    return null;
                }
                p9 p9Var = new p9();
                boolean z = aVarArr.length > 1;
                int length = aVarArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    m9Var2 = m9Var;
                    if (i2 >= length) {
                        break;
                    }
                    m9.a aVar = aVarArr[i2];
                    if (aVar instanceof MemoryCache.a) {
                        m9Var = f24027a.a(cls, (MemoryCache.a) aVar, MemoryCache.class);
                    } else {
                        m9Var = m9Var2;
                        if (aVar instanceof s9.d) {
                            s9.d dVar = (s9.d) aVar;
                            if (dVar.b() == s9.b.DISK) {
                                m9Var = f24027a.a(cls, dVar, DiskCache.class);
                            } else {
                                m9Var = m9Var2;
                                if (dVar.b() == s9.b.DB) {
                                    m9Var = f24027a.a(cls, dVar, r9.class);
                                }
                            }
                        }
                    }
                    if (z && m9Var != null) {
                        p9Var.a(m9Var);
                    }
                    i = i2 + 1;
                }
                if (z) {
                    return p9Var;
                }
            }
        }
        return m9Var2;
    }

    public static <D extends n9> t9<D> b(m9<D> m9Var) {
        if (m9Var instanceof t9) {
            return (t9) m9Var;
        }
        return null;
    }

    public static <D extends n9> t9<D> c(Class<D> cls, m9.a... aVarArr) {
        return b(b(cls, aVarArr));
    }
}
