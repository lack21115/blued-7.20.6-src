package com.anythink.basead.d.a;

import android.text.TextUtils;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.core.common.a.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.out.TemplateBannerView;
import com.anythink.expressad.out.h;
import com.anythink.expressad.out.o;
import com.anythink.expressad.splash.d.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/b.class */
public class b {
    private static volatile b c;
    private final String b = getClass().getSimpleName();
    ConcurrentHashMap<String, g> a = new ConcurrentHashMap<>(2);

    /* renamed from: com.anythink.basead.d.a.b$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/b$1.class */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.g a;
        final /* synthetic */ j b;
        final /* synthetic */ d c;
        final /* synthetic */ a d;

        AnonymousClass1(com.anythink.core.common.e.g gVar, j jVar, d dVar, a aVar) {
            this.a = gVar;
            this.b = jVar;
            this.c = dVar;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g cVar = new c(n.a().g(), "", TextUtils.isEmpty(this.a.S()) ? this.b.c : this.a.S());
            cVar.b(this.b.m.p() == 0);
            int n = ((int) this.b.m.n()) / 1000;
            if (n <= 2) {
                cVar.a(2);
            } else if (n >= 10) {
                cVar.a(10);
            } else {
                cVar.a(n);
            }
            cVar.a(this.b.m.x() == 0);
            cVar.f();
            ArrayList<com.anythink.expressad.foundation.d.c> arrayList = this.c.J;
            if (arrayList != null && arrayList.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar2 : arrayList) {
                    if (cVar2 != null) {
                        String c = cVar2.c();
                        String str = c;
                        if (!TextUtils.isEmpty(c)) {
                            boolean z = this.b.m.x() == 0;
                            boolean z2 = com.anythink.expressad.shake.a.a().b() && this.b.m.M() == 1;
                            String b = b.b(b.c(c, z), z2, this.b.m.N(), this.b.m.O());
                            if (z2 || z) {
                                str = b;
                                if (z2) {
                                    str = b.b(b, false);
                                }
                            } else {
                                str = b.b(b, true);
                            }
                        }
                        cVar2.a(str);
                    }
                }
            }
            cVar.a(new com.anythink.expressad.out.d() { // from class: com.anythink.basead.d.a.b.1.1
                public final void a() {
                    ConcurrentHashMap<String, g> concurrentHashMap = b.this.a;
                    g gVar = (c) concurrentHashMap.remove(AnonymousClass1.this.b.b + AnonymousClass1.this.b.a);
                    if (gVar != null) {
                        if (AnonymousClass1.this.d != null) {
                            AnonymousClass1.this.d.a(gVar);
                        }
                    } else if (AnonymousClass1.this.d != null) {
                        AnonymousClass1.this.d.a(f.a(f.l, "Resource download fail."));
                    }
                }

                public final void a(String str2) {
                    b.a(b.this, str2, AnonymousClass1.this.b, AnonymousClass1.this.d);
                }

                public final void b() {
                }
            });
            ConcurrentHashMap<String, g> concurrentHashMap = b.this.a;
            concurrentHashMap.put(this.b.b + this.b.a, cVar);
            cVar.a(this.c);
        }
    }

    /* renamed from: com.anythink.basead.d.a.b$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/b$2.class */
    final class AnonymousClass2 implements h {
        final /* synthetic */ j a;
        final /* synthetic */ a b;

        AnonymousClass2(j jVar, a aVar) {
            this.a = jVar;
            this.b = aVar;
        }

        public final void a() {
            ConcurrentHashMap<String, g> concurrentHashMap = b.this.a;
            g gVar = (TemplateBannerView) concurrentHashMap.remove(this.a.b + this.a.a);
            if (gVar != null) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(gVar);
                }
            } else if (this.b != null) {
                this.b.a(f.a(f.l, "Resource download fail."));
            }
        }

        public final void a(com.anythink.expressad.foundation.d.c cVar) {
        }

        public final void a(String str) {
            b.a(b.this, str, this.a, this.b);
        }

        public final void b() {
        }

        public final void c() {
        }

        public final void d() {
        }

        public final void e() {
        }

        public final void f() {
        }
    }

    /* renamed from: com.anythink.basead.d.a.b$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/b$4.class */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ com.anythink.core.common.e.g a;
        final /* synthetic */ j b;
        final /* synthetic */ a c;
        final /* synthetic */ d d;

        AnonymousClass4(com.anythink.core.common.e.g gVar, j jVar, a aVar, d dVar) {
            this.a = gVar;
            this.b = jVar;
            this.c = aVar;
            this.d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g cVar = new com.anythink.expressad.advanced.d.c("", TextUtils.isEmpty(this.a.S()) ? this.b.c : this.a.S(), n.a().g());
            cVar.a(new o() { // from class: com.anythink.basead.d.a.b.4.1
                public final void a() {
                    ConcurrentHashMap<String, g> concurrentHashMap = b.this.a;
                    g gVar = (com.anythink.expressad.advanced.d.c) concurrentHashMap.remove(AnonymousClass4.this.b.b + AnonymousClass4.this.b.a);
                    if (gVar != null) {
                        if (AnonymousClass4.this.c != null) {
                            AnonymousClass4.this.c.a(gVar);
                        }
                    } else if (AnonymousClass4.this.c != null) {
                        AnonymousClass4.this.c.a(f.a(f.m, f.H));
                    }
                }

                public final void a(com.anythink.expressad.foundation.d.c cVar2) {
                }

                public final void a(String str) {
                    b.a(b.this, str, AnonymousClass4.this.b, AnonymousClass4.this.c);
                }

                public final void b() {
                }

                public final void c() {
                }

                public final void d() {
                }

                public final void e() {
                }

                public final void f() {
                }
            });
            ConcurrentHashMap<String, g> concurrentHashMap = b.this.a;
            concurrentHashMap.put(this.b.b + this.b.a, cVar);
            cVar.a(this.d);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/b$a.class */
    public interface a {
        void a(e eVar);

        void a(g gVar);
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.basead.a.c a(com.anythink.basead.a.c r6, com.anythink.expressad.foundation.d.c r7) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.a.b.a(com.anythink.basead.a.c, com.anythink.expressad.foundation.d.c):com.anythink.basead.a.c");
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    static /* synthetic */ void a(b bVar, String str, j jVar, a aVar) {
        ConcurrentHashMap<String, g> concurrentHashMap = bVar.a;
        concurrentHashMap.remove(jVar.b + jVar.a);
        if (aVar != null) {
            aVar.a(f.a(f.l, str));
        }
    }

    public static void a(com.anythink.core.common.e.g gVar, com.anythink.expressad.foundation.d.c cVar) {
        gVar.w(cVar.ba());
        gVar.n(cVar.bd());
        gVar.l(cVar.bb());
        gVar.m(cVar.bc());
        gVar.v(cVar.ad());
        gVar.u(cVar.af());
        ac X = gVar.X();
        ac acVar = X;
        if (X == null) {
            acVar = new ac();
            gVar.a(acVar);
        }
        com.anythink.expressad.foundation.d.n L = cVar.L();
        if (L != null) {
            acVar.b(L.a());
            acVar.c(L.b());
            acVar.d(L.c());
        }
        a((i) gVar, cVar);
    }

    public static void a(com.anythink.core.common.e.g gVar, List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            cVar.t(gVar.v());
        }
    }

    public static void a(i iVar, com.anythink.expressad.foundation.d.c cVar) {
        String[] l;
        com.anythink.core.common.e.g gVar = iVar instanceof com.anythink.core.common.e.g ? (com.anythink.core.common.e.g) iVar : null;
        if (iVar == null || cVar == null) {
            return;
        }
        iVar.v(cVar.ad());
        iVar.d(cVar.aO());
        iVar.c(cVar.aN());
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.ah() + "&opdptype={opdptype}&apk_ptype={apk_ptype}");
        com.anythink.expressad.foundation.d.n L = cVar.L();
        if (L != null && (l = L.l()) != null) {
            int length = l.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                arrayList.add(l[i2]);
                i = i2 + 1;
            }
        }
        ac X = gVar.X();
        ac acVar = X;
        if (X == null) {
            acVar = new ac();
            gVar.a(acVar);
        }
        acVar.a((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public static void a(j jVar, List<com.anythink.expressad.foundation.d.c> list) {
        if (jVar.j == 1 || jVar.j == 3) {
            list.get(0).a(jVar.m.z());
        }
    }

    private void a(String str, j jVar, a aVar) {
        ConcurrentHashMap<String, g> concurrentHashMap = this.a;
        concurrentHashMap.remove(jVar.b + jVar.a);
        if (aVar != null) {
            aVar.a(f.a(f.l, str));
        }
    }

    static /* synthetic */ String b(String str, boolean z) {
        if (z) {
            if (str.contains("hdbtn")) {
                return str.replace("hdbtn=1", "hdbtn=0");
            }
            return str + "&hdbtn=0";
        } else if (str.contains("hdbtn")) {
            return str.replace("hdbtn=0", "hdbtn=1");
        } else {
            return str + "&hdbtn=1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, boolean z, int i, long j) {
        String str2;
        String str3;
        if (z) {
            if (str.contains("shake_show")) {
                str2 = str.replace("shake_show=0", "shake_show=1");
            } else {
                str2 = str + "&shake_show=1";
            }
        } else if (str.contains("shake_show")) {
            str2 = str.replace("shake_show=1", "shake_show=0");
        } else {
            str2 = str + "&shake_show=0";
        }
        if (str2.contains("shake_time")) {
            str3 = str2.replaceAll("(shake_time=[^&]*)", "shake_time=" + (j / 1000));
        } else {
            str3 = str2 + "&shake_time=" + (j / 1000);
        }
        if (str3.contains("shake_strength")) {
            return str3.replaceAll("(shake_strength=[^&]*)", "shake_strength=".concat(String.valueOf(i)));
        }
        return str3 + "&shake_strength=" + i;
    }

    private void b(com.anythink.core.common.e.g gVar, j jVar, d dVar, a aVar) {
        n.a().a(new AnonymousClass1(gVar, jVar, dVar, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, boolean z) {
        if (z) {
            if (str.contains("alecfc")) {
                return str.replace("alecfc=0", "alecfc=1");
            }
            return str + "&alecfc=1";
        } else if (str.contains("alecfc")) {
            return str.replace("alecfc=1", "alecfc=0");
        } else {
            return str + "&alecfc=0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.anythink.core.common.e.g r8, com.anythink.core.common.e.j r9, com.anythink.expressad.foundation.d.d r10, com.anythink.basead.d.a.b.a r11) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.a.b.c(com.anythink.core.common.e.g, com.anythink.core.common.e.j, com.anythink.expressad.foundation.d.d, com.anythink.basead.d.a.b$a):void");
    }

    private static String d(String str, boolean z) {
        if (z) {
            if (str.contains("hdbtn")) {
                return str.replace("hdbtn=1", "hdbtn=0");
            }
            return str + "&hdbtn=0";
        } else if (str.contains("hdbtn")) {
            return str.replace("hdbtn=0", "hdbtn=1");
        } else {
            return str + "&hdbtn=1";
        }
    }

    private void d(com.anythink.core.common.e.g gVar, final j jVar, d dVar, final a aVar) {
        g aVar2 = new com.anythink.expressad.reward.b.a();
        String S = TextUtils.isEmpty(gVar.S()) ? jVar.c : gVar.S();
        if (jVar.j == 1) {
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), S, false);
            aVar2.a(false);
        } else if (jVar.j == 3) {
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), S, true);
            aVar2.a(true);
        }
        aVar2.a(jVar.m.y() == 0 ? 1 : 2);
        aVar2.a("", S);
        com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), S, false);
        if (jVar.m.z() >= 0) {
            a2.a(jVar.m.z());
        }
        if (jVar.j == 1) {
            a2.l();
        }
        ArrayList<com.anythink.expressad.foundation.d.c> arrayList = dVar.J;
        if (arrayList != null && arrayList.size() > 0) {
            for (com.anythink.expressad.foundation.d.c cVar : arrayList) {
                if (cVar != null) {
                    boolean z = com.anythink.expressad.shake.a.a().b() && jVar.m.M() == 1;
                    boolean z2 = jVar.m.x() == 0;
                    String I = cVar.I();
                    if (!TextUtils.isEmpty(I)) {
                        cVar.k(b(c(I, z2), z, jVar.m.N(), jVar.m.O()));
                    }
                    String P = cVar.P();
                    if (!TextUtils.isEmpty(P)) {
                        cVar.n(b(c(P, z2), z, jVar.m.N(), jVar.m.O()));
                    }
                    c.c M = cVar.M();
                    boolean z3 = jVar.m.u() == 1;
                    if (M != null) {
                        String e = M.e();
                        if (!TextUtils.isEmpty(e)) {
                            M.a(c(e, z3));
                        }
                    }
                }
            }
        }
        aVar2.a(new com.anythink.expressad.videocommon.d.a() { // from class: com.anythink.basead.d.a.b.3
            public final void a() {
            }

            public final void a(com.anythink.expressad.foundation.d.c cVar2) {
            }

            public final void a(String str) {
                b.a(b.this, str, jVar, aVar);
            }

            public final void a(boolean z4, String str, float f) {
            }

            public final void b() {
                ConcurrentHashMap<String, g> concurrentHashMap = b.this.a;
                g gVar2 = (com.anythink.expressad.reward.b.a) concurrentHashMap.remove(jVar.b + jVar.a);
                if (gVar2 == null || !gVar2.isReady()) {
                    if (aVar != null) {
                        aVar.a(f.a(f.l, "Resource download fail."));
                        return;
                    }
                    return;
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(gVar2);
                }
            }

            public final void b(String str) {
            }

            public final void c() {
            }

            public final void d() {
            }

            public final void e() {
            }

            public final void f() {
            }
        });
        ConcurrentHashMap<String, g> concurrentHashMap = this.a;
        concurrentHashMap.put(jVar.b + jVar.a, aVar2);
        aVar2.a(dVar);
    }

    private void e(com.anythink.core.common.e.g gVar, j jVar, d dVar, a aVar) {
        n.a().a(new AnonymousClass4(gVar, jVar, aVar, dVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.core.common.e.g r10, com.anythink.core.common.e.j r11, com.anythink.expressad.foundation.d.d r12, com.anythink.basead.d.a.b.a r13) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.a.b.a(com.anythink.core.common.e.g, com.anythink.core.common.e.j, com.anythink.expressad.foundation.d.d, com.anythink.basead.d.a.b$a):void");
    }
}
