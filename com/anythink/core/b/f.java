package com.anythink.core.b;

import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.p;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/f.class */
public final class f {
    private static f h;
    ConcurrentHashMap<String, List<ai>> d;
    ConcurrentHashMap<String, Integer> e;
    private MediationBidManager i;
    private final String g = getClass().getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    ConcurrentHashMap<String, m> f6374a = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, j> b = new ConcurrentHashMap<>(5);

    /* renamed from: c  reason: collision with root package name */
    ConcurrentHashMap<String, ai> f6375c = new ConcurrentHashMap<>(5);
    List<Integer> f = new CopyOnWriteArrayList();

    private f() {
    }

    public static f a() {
        if (h == null) {
            h = new f();
        }
        return h;
    }

    private void a(ai aiVar, m mVar) {
        this.f6374a.put(aiVar.t(), mVar);
        if (aiVar.l() == 3 || aiVar.l() == 7) {
            a(aiVar.t(), mVar);
        }
    }

    public static void a(String str, m mVar) {
        p.a(n.a().g(), com.anythink.core.common.b.g.u, str, mVar.c());
    }

    public static void b(String str) {
        p.a(n.a().g(), com.anythink.core.common.b.g.u, str);
    }

    private j c(ai aiVar) {
        if (aiVar != null) {
            return b(aiVar.N().g, aiVar.N().k);
        }
        return null;
    }

    private void d(ai aiVar) {
        m N;
        if (aiVar == null || (N = aiVar.N()) == null) {
            return;
        }
        c(N.g, N.k);
    }

    private void d(String str) {
        if (this.e == null) {
            this.e = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.e;
        concurrentHashMap.put(str + "_c2sfirstStatus", 1);
    }

    private boolean e(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_c2sfirstStatus");
            return concurrentHashMap.get(sb.toString()) == null;
        }
        return true;
    }

    public final double a(String str, String str2) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.b;
        j jVar = concurrentHashMap.get(str + BridgeUtil.UNDERLINE_STR + str2);
        if (jVar != null) {
            return jVar.f6387c;
        }
        return 0.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        if (r6.l() == 7) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.anythink.core.common.e.m a(com.anythink.core.common.e.ai r6) {
        /*
            r5 = this;
            r0 = r5
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.e.m> r0 = r0.f6374a
            r1 = r6
            java.lang.String r1 = r1.t()
            java.lang.Object r0 = r0.get(r1)
            com.anythink.core.common.e.m r0 = (com.anythink.core.common.e.m) r0
            r7 = r0
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L5b
            r0 = r6
            int r0 = r0.l()
            r1 = 3
            if (r0 == r1) goto L28
            r0 = r7
            r8 = r0
            r0 = r6
            int r0 = r0.l()
            r1 = 7
            if (r0 != r1) goto L5b
        L28:
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()
            android.content.Context r0 = r0.g()
            java.lang.String r1 = "anythink_hb_cache_file"
            r2 = r6
            java.lang.String r2 = r2.t()
            java.lang.String r3 = ""
            java.lang.String r0 = com.anythink.core.common.k.p.b(r0, r1, r2, r3)
            r8 = r0
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L46
            r0 = r8
            com.anythink.core.common.e.m r0 = com.anythink.core.common.e.m.a(r0)
            r7 = r0
        L46:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 == 0) goto L5b
            r0 = r5
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.e.m> r0 = r0.f6374a
            r1 = r6
            java.lang.String r1 = r1.t()
            r2 = r7
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r7
            r8 = r0
        L5b:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.f.a(com.anythink.core.common.e.ai):com.anythink.core.common.e.m");
    }

    public final void a(int i) {
        synchronized (this.f) {
            if (!this.f.contains(Integer.valueOf(i))) {
                this.f.add(Integer.valueOf(i));
            }
        }
    }

    public final void a(MediationBidManager mediationBidManager) {
        this.i = mediationBidManager;
    }

    public final void a(String str) {
        this.f6374a.remove(str);
    }

    public final void a(String str, ai aiVar) {
        this.f6375c.put(str, aiVar);
    }

    public final void a(String str, String str2, j jVar) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.b;
        concurrentHashMap.put(str + BridgeUtil.UNDERLINE_STR + str2, jVar);
    }

    public final double b(ai aiVar) {
        m N;
        if (aiVar == null || (N = aiVar.N()) == null) {
            return 0.0d;
        }
        return a(N.g, aiVar.t());
    }

    public final MediationBidManager b() {
        return this.i;
    }

    public final j b(String str, String str2) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.b;
        return concurrentHashMap.get(str + BridgeUtil.UNDERLINE_STR + str2);
    }

    public final boolean b(int i) {
        boolean z;
        synchronized (this.f) {
            z = !this.f.contains(Integer.valueOf(i));
        }
        return z;
    }

    public final ai c(String str) {
        return this.f6375c.get(str);
    }

    public final void c(String str, String str2) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.b;
        concurrentHashMap.remove(str + BridgeUtil.UNDERLINE_STR + str2);
    }
}
