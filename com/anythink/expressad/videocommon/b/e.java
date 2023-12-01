package com.anythink.expressad.videocommon.b;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8734a = "DownLoadManager";
    private static e b;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f8735c;
    private boolean d = false;
    private ConcurrentHashMap<String, n> e = new ConcurrentHashMap<>();
    private Map<String, List<Map<String, c>>> f;
    private Map<String, List<com.anythink.expressad.foundation.d.c>> g;
    private Map<String, List<c>> h;

    private e() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.f8735c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                try {
                    if (b == null) {
                        b = new e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private n a(String str, com.anythink.expressad.foundation.d.c cVar, int i, com.anythink.expressad.videocommon.d.b bVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return null;
        }
        if (!this.e.containsKey(str)) {
            n nVar = new n(cVar, this.f8735c, str, i);
            if (bVar != null) {
                nVar.a(bVar);
            }
            this.e.put(str, nVar);
            return nVar;
        }
        n nVar2 = this.e.get(str);
        if (i == 94 || i == 287) {
            nVar2.a(cVar.Z(), bVar);
        } else {
            nVar2.a(bVar);
        }
        nVar2.a(cVar);
        return nVar2;
    }

    private static void a(n nVar, String str) {
        try {
            com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), str);
            if (a2 == null) {
                return;
            }
            if (a2.F() == 2) {
                nVar.c();
            } else {
                nVar.a();
            }
        } catch (Exception e) {
            com.anythink.expressad.foundation.h.o.d(f8734a, e.getMessage());
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), str);
                com.anythink.expressad.d.c cVar = c2;
                if (c2 == null) {
                    cVar = com.anythink.expressad.d.c.d(str);
                }
                if (cVar.m() == 2) {
                    nVar.c();
                } else {
                    nVar.a();
                }
            } catch (Exception e2) {
                com.anythink.expressad.foundation.h.o.d(f8734a, e2.getMessage());
            }
        }
    }

    private c b(int i, String str, boolean z) {
        n c2 = c(str);
        if (c2 != null) {
            return c2.b(i, z);
        }
        return null;
    }

    private void b(String str, String str2) {
        n c2 = c(str);
        if (c2 != null) {
            try {
                c2.b(str2);
            } catch (Exception e) {
            }
        }
    }

    private void d() {
        ConcurrentHashMap<String, n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> entry : concurrentHashMap.entrySet()) {
                n value = entry.getValue();
                if (value != null) {
                    value.b();
                }
            }
        }
    }

    private List<Map<String, c>> e(String str) {
        Map<String, List<Map<String, c>>> map = this.f;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    private void f(String str) {
        n c2 = c(str);
        if (c2 != null) {
            c2.d();
        }
    }

    public final c a(String str, String str2) {
        n c2 = c(str);
        if (c2 != null) {
            return c2.a(str2);
        }
        return null;
    }

    public final n a(String str, List<com.anythink.expressad.foundation.d.c> list, int i, com.anythink.expressad.videocommon.d.b bVar) {
        if (TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return null;
        }
        if (!this.e.containsKey(str)) {
            n nVar = new n(list, this.f8735c, str, i);
            if (bVar != null) {
                nVar.a(bVar);
            }
            this.e.put(str, nVar);
            return nVar;
        }
        n nVar2 = this.e.get(str);
        if (i == 94 || i == 287) {
            nVar2.a(list.get(0).Z(), bVar);
        } else {
            nVar2.a(bVar);
        }
        nVar2.a(list);
        return nVar2;
    }

    public final List<com.anythink.expressad.foundation.d.c> a(String str) {
        Map<String, List<com.anythink.expressad.foundation.d.c>> map = this.g;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.g.get(str);
    }

    public final void a(boolean z) {
        if (!z) {
            this.d = false;
        } else if (this.d) {
            return;
        }
        ConcurrentHashMap<String, n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> entry : concurrentHashMap.entrySet()) {
                entry.getValue().a();
            }
        }
    }

    public final boolean a(int i, String str, boolean z) {
        try {
            n c2 = c(str);
            if (c2 != null) {
                return c2.a(i, z) != null;
            }
            return false;
        } catch (Exception e) {
            if (com.anythink.expressad.a.f6941a) {
                e.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public final boolean a(String str, boolean z, int i, boolean z2, int i2, List<com.anythink.expressad.foundation.d.c> list) {
        return b(str, z, i, z2, i2, list);
    }

    public final List<c> b(String str) {
        Map<String, List<c>> map = this.h;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.h.get(str);
    }

    public final void b() {
        this.d = false;
        ConcurrentHashMap<String, n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> entry : concurrentHashMap.entrySet()) {
                n value = entry.getValue();
                if (value != null) {
                    value.c();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x0203, code lost:
        if (r0.size() >= r7) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(java.lang.String r5, boolean r6, int r7, boolean r8, int r9, java.util.List<com.anythink.expressad.foundation.d.c> r10) {
        /*
            Method dump skipped, instructions count: 1224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.b.e.b(java.lang.String, boolean, int, boolean, int, java.util.List):boolean");
    }

    public final n c(String str) {
        ConcurrentHashMap<String, n> concurrentHashMap = this.e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public final void c() {
        ConcurrentHashMap<String, n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> entry : concurrentHashMap.entrySet()) {
                n value = entry.getValue();
                String key = entry.getKey();
                try {
                    com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), key);
                    if (a2 != null) {
                        if (a2.F() == 2) {
                            value.c();
                        } else {
                            value.a();
                        }
                    }
                } catch (Exception e) {
                    com.anythink.expressad.foundation.h.o.d(f8734a, e.getMessage());
                    try {
                        if (!TextUtils.isEmpty(key)) {
                            com.anythink.expressad.d.b.a();
                            com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), key);
                            com.anythink.expressad.d.c cVar = c2;
                            if (c2 == null) {
                                cVar = com.anythink.expressad.d.c.d(key);
                            }
                            if (cVar.m() == 2) {
                                value.c();
                            } else {
                                value.a();
                            }
                        }
                    } catch (Exception e2) {
                        com.anythink.expressad.foundation.h.o.d(f8734a, e2.getMessage());
                    }
                }
            }
        }
    }

    public final void d(String str) {
        n c2 = c(str);
        if (c2 != null) {
            c2.a();
        }
    }
}
