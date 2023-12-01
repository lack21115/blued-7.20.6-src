package com.anythink.basead.a;

import com.anythink.basead.a.b.b;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/f.class */
public class f {
    public static final String a = f.class.getSimpleName();
    private static volatile f b;

    private f() {
    }

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                try {
                    if (b == null) {
                        b = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static String a(int i, String str) {
        return com.anythink.core.common.res.d.a(n.a().g()).b(i, com.anythink.core.common.k.f.a(str));
    }

    public static void a(String str, com.anythink.core.common.e.i iVar, com.anythink.core.common.e.j jVar, b.InterfaceC0027b interfaceC0027b) {
        a(str, false, iVar, jVar, interfaceC0027b);
    }

    private static void a(String str, List<s> list, u uVar) {
        if (list == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            com.anythink.core.common.e.j jVar = new com.anythink.core.common.e.j();
            jVar.m = uVar;
            a(str, true, list.get(i2), jVar, null);
            i = i2 + 1;
        }
    }

    public static void a(String str, boolean z, com.anythink.core.common.e.i iVar, com.anythink.core.common.e.j jVar, b.InterfaceC0027b interfaceC0027b) {
        new com.anythink.basead.a.b.b(str, z, iVar, jVar).a(interfaceC0027b);
    }

    public static boolean a(s sVar, int i, k kVar) {
        return com.anythink.basead.a.b.c.a(sVar, i, kVar);
    }

    public static boolean a(s sVar, com.anythink.core.common.e.j jVar) {
        return com.anythink.basead.a.b.c.a(sVar, jVar);
    }

    public static boolean a(String str, InputStream inputStream) {
        if (str == null || inputStream == null) {
            return false;
        }
        return com.anythink.core.common.res.d.a(n.a().g()).a(1, com.anythink.core.common.k.f.a(str), inputStream);
    }

    private static FileInputStream b(int i, String str) {
        return com.anythink.core.common.res.d.a(n.a().g()).a(i, com.anythink.core.common.k.f.a(str));
    }
}
