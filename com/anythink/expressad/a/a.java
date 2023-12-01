package com.anythink.expressad.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.common.b.k;
import com.anythink.expressad.a.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.out.LoadingActivity;
import com.anythink.expressad.out.j;
import com.anythink.expressad.out.p;
import com.ss.android.download.api.constant.BaseConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6943a = "Anythink SDK M";
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Long> f6944c = new HashMap();
    public static Set<String> d = new HashSet();
    public static final String e = "2";
    private static final int f = 1;
    private String g;
    private long h;
    private com.anythink.expressad.foundation.c.c i;
    private Context j;
    private c k;
    private com.anythink.expressad.out.f l;
    private com.anythink.expressad.d.a n;
    private boolean o;
    private boolean r;
    private p.c m = null;
    private boolean p = false;
    private boolean q = true;

    public a(Context context, String str) {
        this.i = null;
        this.j = null;
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
        this.n = b2;
        if (b2 == null) {
            com.anythink.expressad.d.b.a();
            this.n = com.anythink.expressad.d.b.c();
        }
        this.o = this.n.t();
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        this.g = str;
        if (this.i == null) {
            this.i = com.anythink.expressad.foundation.c.c.a(applicationContext);
        }
    }

    private void a(int i, String str, com.anythink.expressad.foundation.d.c cVar, p.c cVar2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i == 2) {
                s.a(this.j, str, cVar, cVar2);
            } else {
                s.a(this.j, str, cVar2);
            }
        } catch (Throwable th) {
            o.b(f6943a, th.getMessage(), th);
        }
    }

    public static void a(Context context, com.anythink.expressad.foundation.d.c cVar, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        new c(context.getApplicationContext()).a("2", str, cVar, null, str2, false, z, com.anythink.expressad.a.a.a.h);
    }

    public static void a(Context context, com.anythink.expressad.foundation.d.c cVar, String str, String str2, boolean z, boolean z2, int i) {
        if (context == null) {
            return;
        }
        new c(context.getApplicationContext()).a("2", str, cVar, null, str2, z, z2, i);
    }

    public static void a(Context context, com.anythink.expressad.foundation.d.c cVar, String str, String[] strArr, boolean z) {
        if (context == null || cVar == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        c cVar2 = new c(context.getApplicationContext());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            cVar2.a("2", str, cVar, null, strArr[i2], false, z, com.anythink.expressad.a.a.a.h);
            i = i2 + 1;
        }
    }

    static /* synthetic */ void a(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            k.a(aVar.j).a(intent);
        } catch (Exception e2) {
            o.b(f6943a, "Exception", e2);
        }
    }

    private void a(c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z) {
        if (cVar == null || bVar == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.h;
            com.anythink.expressad.foundation.d.f fVar = new com.anythink.expressad.foundation.d.f();
            fVar.i(cVar.aa());
            fVar.a();
            fVar.h(String.valueOf(currentTimeMillis - j));
            fVar.g(cVar.aZ());
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), "utf-8"));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.h / 1000);
            fVar.b(sb.toString());
            fVar.a(Integer.parseInt(cVar.ac()));
            fVar.b(cVar.Q());
            fVar.a(this.g);
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), "utf-8"));
            }
            if (this.o) {
                fVar.c(bVar.a());
                if (!TextUtils.isEmpty(bVar.d())) {
                    fVar.d(URLEncoder.encode(bVar.d(), "utf-8"));
                }
                if (!TextUtils.isEmpty(bVar.f())) {
                    fVar.e(URLEncoder.encode(bVar.f(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(bVar.e())) {
                    fVar.c(URLEncoder.encode(bVar.e(), "utf-8"));
                }
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(fVar);
            w.b(com.anythink.expressad.foundation.d.f.a(arrayList));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ef, code lost:
        if (com.anythink.expressad.foundation.h.s.a.a(r0, com.ss.android.download.api.constant.BaseConstants.MARKET_PREFIX + r7.ba(), r6.m) == false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.foundation.d.c r7, com.anythink.expressad.a.c.b r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.a(com.anythink.expressad.foundation.d.c, com.anythink.expressad.a.c$b, boolean, boolean):void");
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(this.j, cVar, this.g, str, true, false, com.anythink.expressad.a.a.a.k);
    }

    private void a(com.anythink.expressad.out.f fVar) {
        this.l = fVar;
    }

    private void a(j jVar, String str) {
        try {
            if (TextUtils.isEmpty(str) || jVar == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c cVar = null;
            if (jVar instanceof com.anythink.expressad.foundation.d.c) {
                cVar = (com.anythink.expressad.foundation.d.c) jVar;
            }
            if ((!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) || s.a.a(this.j, str, this.m) || cVar == null) {
                return;
            }
            if (TextUtils.isEmpty(cVar.ba())) {
                if (i() == 2) {
                    s.a(this.j, cVar.ad(), cVar, this.m);
                    return;
                } else {
                    s.a(this.j, cVar.ad(), this.m);
                    return;
                }
            }
            s.a.a(this.j, BaseConstants.MARKET_PREFIX + cVar.ba(), this.m);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str) {
        this.g = str;
    }

    private void a(final boolean z, final j jVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anythink.expressad.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (z && !a.b && com.anythink.expressad.a.o) {
                    a.a(a.this);
                }
                if (a.this.m == null || a.b || !com.anythink.expressad.a.o) {
                    return;
                }
                a.this.m.b(jVar);
            }
        });
    }

    private static boolean a(int i, String str) {
        try {
            if (i == 2) {
                if (s.a.a(str)) {
                    return true;
                }
            } else if (!TextUtils.isEmpty(str)) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        Long l;
        if (cVar != null) {
            try {
                if (2 == cVar.Q() || 3 == cVar.Q()) {
                    String aZ = cVar.aZ();
                    if (f6944c != null) {
                        if (f6944c.containsKey(aZ) && (l = f6944c.get(aZ)) != null) {
                            if (l.longValue() > System.currentTimeMillis()) {
                                return false;
                            }
                            if (d.contains(cVar.aZ())) {
                                return false;
                            }
                        }
                        f6944c.put(cVar.aZ(), Long.valueOf(System.currentTimeMillis() + (cVar.Y() * 1000)));
                        return true;
                    }
                    return true;
                }
                return true;
            } catch (Exception e2) {
                if (com.anythink.expressad.a.f6941a) {
                    e2.printStackTrace();
                    return true;
                }
                return true;
            }
        }
        return true;
    }

    private boolean a(com.anythink.expressad.foundation.d.c cVar, c.b bVar, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (z) {
            try {
                s.a(this.j, cVar.ad(), this.m);
                z3 = true;
            } catch (Throwable th) {
                o.b(f6943a, th.getMessage(), th);
                z2 = false;
            }
        }
        b(bVar, cVar, true);
        if (z3) {
            z2 = z3;
            if (this.m != null) {
                boolean z4 = z3;
                this.m.a((j) cVar, bVar.j());
                return z3;
            }
        } else {
            z2 = z3;
            if (this.m != null) {
                boolean z5 = z3;
                this.m.b(cVar, bVar.j());
                return z3;
            }
        }
        return z2;
    }

    private boolean a(com.anythink.expressad.foundation.d.c cVar, c.b bVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        if (z) {
            try {
                int parseInt = Integer.parseInt(cVar.ac());
                if (parseInt == 1) {
                    s.a(this.j, bVar.j(), this.m);
                } else if (parseInt == 2) {
                    s.a(this.j, bVar.j(), cVar, this.m);
                } else if (cVar.ba() != null) {
                    Context context = this.j;
                    StringBuilder sb = new StringBuilder(BaseConstants.MARKET_PREFIX);
                    sb.append(cVar.ba());
                    if (!s.a.a(context, sb.toString(), this.m)) {
                        a(i, bVar.j(), cVar, this.m);
                        z3 = false;
                    }
                } else {
                    a(i, bVar.j(), cVar, this.m);
                    z3 = false;
                }
                z3 = true;
            } catch (Throwable th) {
                o.b(f6943a, th.getMessage(), th);
                z2 = false;
            }
        }
        if (z3) {
            b(bVar, cVar, true);
            z2 = z3;
            if (this.m != null) {
                boolean z4 = z3;
                this.m.a((j) cVar, bVar.j());
                return z3;
            }
        } else {
            b(bVar, cVar, true);
            z2 = z3;
            if (this.m != null) {
                z2 = z3;
                if (z) {
                    this.m.b(cVar, bVar.j());
                    return z3;
                }
            }
        }
        return z2;
    }

    private void b(c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z) {
        if (cVar == null || bVar == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.h;
            com.anythink.expressad.foundation.d.f fVar = new com.anythink.expressad.foundation.d.f();
            fVar.i(cVar.aa());
            fVar.a();
            fVar.h(String.valueOf(currentTimeMillis - j));
            fVar.g(cVar.aZ());
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), "utf-8"));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.h / 1000);
            fVar.b(sb.toString());
            fVar.a(Integer.parseInt(cVar.ac()));
            fVar.b(cVar.Q());
            fVar.a(this.g);
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), "utf-8"));
            }
            if (this.o) {
                fVar.c(bVar.a());
                if (!TextUtils.isEmpty(bVar.d())) {
                    fVar.d(URLEncoder.encode(bVar.d(), "utf-8"));
                }
                if (!TextUtils.isEmpty(bVar.f())) {
                    fVar.e(URLEncoder.encode(bVar.f(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(bVar.e())) {
                    fVar.c(URLEncoder.encode(bVar.e(), "utf-8"));
                }
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(fVar);
            w.b(com.anythink.expressad.foundation.d.f.a(arrayList));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        try {
            Intent intent = new Intent(this.j, LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("icon_url", cVar.bd());
            this.j.startActivity(intent);
        } catch (Exception e2) {
            o.b(f6943a, "Exception", e2);
        }
    }

    private boolean c() {
        return this.q;
    }

    private com.anythink.expressad.out.f d() {
        return this.l;
    }

    private com.anythink.expressad.foundation.c.c e() {
        return this.i;
    }

    private static void f() {
    }

    private void g() {
        c cVar = this.k;
        if (cVar == null || !cVar.a()) {
            return;
        }
        this.k.b();
    }

    private static void h() {
    }

    private int i() {
        try {
            if (this.n != null) {
                return this.n.k();
            }
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    private void j() {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            k.a(this.j).a(intent);
        } catch (Exception e2) {
            o.b(f6943a, "Exception", e2);
        }
    }

    public final void a() {
        this.q = false;
    }

    public final void a(p.c cVar) {
        this.m = cVar;
    }

    public final void b() {
        try {
            this.m = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
