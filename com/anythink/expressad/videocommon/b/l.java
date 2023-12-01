package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/l.class */
public final class l {
    private static Map<String, Boolean> b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Boolean> f8749a;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Boolean> f8750c;
    private Map<String, Boolean> d;
    private Map<String, Boolean> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/l$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f8751a = new l((byte) 0);

        private a() {
        }
    }

    private l() {
        this.f8749a = new HashMap();
        this.f8750c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    /* synthetic */ l(byte b2) {
        this();
    }

    public static l a() {
        return a.f8751a;
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            b(cVar);
            e(cVar.aZ());
        }
    }

    private static boolean a(c.C0143c c0143c) {
        List<c.C0143c.a> f;
        if (c0143c == null || (f = c0143c.f()) == null) {
            return true;
        }
        for (c.C0143c.a aVar : f) {
            if (aVar != null && aVar.b != null) {
                for (String str : aVar.b) {
                    boolean a2 = a(b, str);
                    if (a2 || com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)) {
                        a2 = true;
                    }
                    if (!a2) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    private static boolean a(Map<String, Boolean> map, String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (map == null) {
            new HashMap().put(str, Boolean.FALSE);
            return false;
        } else if (map.containsKey(str)) {
            return map.get(str).booleanValue();
        } else {
            map.put(str, Boolean.FALSE);
            return false;
        }
    }

    private boolean a(boolean z, String str) {
        boolean a2 = a(this.f8750c, str);
        if (a2) {
            return a2;
        }
        if (!z || TextUtils.isEmpty(i.a().c(str))) {
            return a2;
        }
        this.f8750c.put(str, Boolean.TRUE);
        return true;
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        List<c.C0143c.a> f;
        if (cVar != null) {
            String S = cVar.S();
            Map<String, Boolean> map = this.f8749a;
            if (map != null && !map.containsKey(S)) {
                this.f8749a.put(S, Boolean.FALSE);
            }
            String I = cVar.I();
            Map<String, Boolean> map2 = this.f8750c;
            if (map2 != null && !map2.containsKey(I)) {
                this.f8750c.put(I, Boolean.FALSE);
            }
            c.C0143c M = cVar.M();
            if (M == null || (f = M.f()) == null) {
                return;
            }
            for (c.C0143c.a aVar : f) {
                if (aVar != null) {
                    b(aVar.b);
                }
            }
        }
    }

    private static void b(List<String> list) {
        Map<String, Boolean> map;
        if (list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && (map = b) != null && !map.containsKey(str)) {
                b.put(str, Boolean.valueOf(com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)));
            }
        }
    }

    public static void c(String str) {
        if (b == null) {
            b = new HashMap();
        }
        b.put(str, Boolean.TRUE);
    }

    private void e(String str) {
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, Boolean.FALSE);
    }

    private void f(String str) {
        if (this.e.containsKey(str)) {
            this.e.remove(str);
        }
    }

    private static boolean g(String str) {
        boolean a2 = a(b, str);
        if (a2 || com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d()).b(str)) {
            return true;
        }
        return a2;
    }

    private static boolean h(String str) {
        String d = com.anythink.expressad.foundation.h.m.d(str);
        File file = new File(com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_VC) + File.separator + d);
        try {
            if (file.exists() && file.isFile()) {
                return file.canRead();
            }
            return false;
        } catch (Throwable th) {
            if (com.anythink.expressad.a.f6941a) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public final void a(String str, boolean z) {
        if (this.f8749a == null) {
            this.f8749a = new HashMap();
        }
        this.f8749a.put(str, Boolean.valueOf(z));
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                b(cVar);
                e(cVar.aZ());
            }
        }
    }

    public final boolean a(String str) {
        if (this.f8749a == null || TextUtils.isEmpty(str) || !this.f8749a.containsKey(str)) {
            return false;
        }
        return this.f8749a.get(str).booleanValue();
    }

    public final void b(String str, boolean z) {
        if (this.f8750c == null) {
            this.f8750c = new HashMap();
        }
        this.f8750c.put(str, Boolean.valueOf(z));
    }

    public final boolean b(String str) {
        if (this.f8750c == null || TextUtils.isEmpty(str) || !this.f8750c.containsKey(str)) {
            return false;
        }
        return this.f8750c.get(str).booleanValue();
    }

    public final void c(String str, boolean z) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        this.e.put(str, Boolean.valueOf(z));
    }

    public final boolean d(String str) {
        if (!TextUtils.isEmpty(str) && this.e.containsKey(str)) {
            return this.e.get(str).booleanValue();
        }
        return false;
    }
}
