package com.anythink.core.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.af;
import com.anythink.core.common.g.i;
import com.anythink.core.common.k.p;
import com.anythink.core.common.r;
import com.anythink.core.common.res.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6416a = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f6417c = null;
    private static com.anythink.core.c.a d = null;
    private Context e;
    private Object g = new Object();
    private boolean f = false;
    List<a> b = Collections.synchronizedList(new ArrayList(3));

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/b$a.class */
    public interface a {
        void a();

        void b();
    }

    private b(Context context) {
        this.e = context;
    }

    public static long a() {
        com.anythink.core.c.a aVar = d;
        if (aVar == null || aVar.J() == 0) {
            return 51200L;
        }
        return d.J();
    }

    private static com.anythink.core.c.a a(Context context, String str) {
        List<af> a2 = com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(context)).a(str, g.o.f6522a);
        com.anythink.core.c.a aVar = null;
        if (a2 != null) {
            aVar = null;
            if (a2.size() > 0) {
                af afVar = a2.get(0);
                aVar = null;
                if (afVar != null) {
                    com.anythink.core.c.a f = com.anythink.core.c.a.f(afVar.d());
                    aVar = f;
                    if (f != null) {
                        f.a(Long.parseLong(afVar.a()));
                        aVar = f;
                    }
                }
            }
        }
        return aVar;
    }

    public static com.anythink.core.c.a a(Context context, String str, String str2) {
        com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(context)).a(str, str2, g.o.f6522a);
        com.anythink.core.c.a f = com.anythink.core.c.a.f(str2);
        f.a(System.currentTimeMillis());
        p.a(context, g.o, g.o.j, f.U());
        return f;
    }

    public static b a(Context context) {
        if (f6417c == null) {
            synchronized (b.class) {
                try {
                    if (f6417c == null) {
                        f6417c = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6417c;
    }

    static /* synthetic */ void a(Context context, com.anythink.core.c.a aVar) {
        if (aVar != null) {
            String n = aVar.n();
            if (TextUtils.isEmpty(n)) {
                return;
            }
            com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, n), (b.a) null);
        }
    }

    private void a(a aVar) {
        synchronized (this.g) {
            if (this.g != null) {
                this.b.add(aVar);
            }
        }
    }

    static /* synthetic */ boolean a(b bVar) {
        bVar.f = false;
        return false;
    }

    private void b(Context context) {
        this.e = context;
    }

    private static void b(Context context, com.anythink.core.c.a aVar) {
        if (aVar == null) {
            return;
        }
        String n = aVar.n();
        if (TextUtils.isEmpty(n)) {
            return;
        }
        com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, n), (b.a) null);
    }

    private void b(a aVar) {
        synchronized (this.g) {
            if (aVar != null) {
                this.b.remove(aVar);
            }
        }
    }

    private Context c() {
        return this.e;
    }

    static /* synthetic */ void c(b bVar) {
        synchronized (bVar.g) {
            Iterator<a> it = bVar.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
            bVar.b.clear();
        }
    }

    private void d() {
        synchronized (this.g) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.b.clear();
        }
    }

    private static com.anythink.core.c.a e() {
        com.anythink.core.c.a aVar = new com.anythink.core.c.a();
        aVar.b = true;
        aVar.Q();
        aVar.b("0");
        aVar.a(0L);
        aVar.W();
        aVar.Z();
        aVar.ab();
        aVar.c("");
        aVar.ae();
        aVar.ag();
        aVar.d("");
        aVar.O();
        aVar.K();
        aVar.C();
        aVar.E();
        aVar.a("[\"com.anythink\"]");
        aVar.y();
        aVar.e();
        aVar.i();
        aVar.g();
        aVar.k();
        return aVar;
    }

    private boolean f() {
        return this.f;
    }

    private static void g() {
    }

    public final void a(final String str, String str2) {
        synchronized (this) {
            if (this.f) {
                return;
            }
            this.f = true;
            new com.anythink.core.common.g.d(this.e, str, str2).a(0, new i() { // from class: com.anythink.core.c.b.1
                @Override // com.anythink.core.common.g.i
                public final void onLoadCanceled(int i) {
                    b.a(b.this);
                    b.c(b.this);
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadError(int i, String str3, AdError adError) {
                    b.a(b.this);
                    String str4 = b.f6416a;
                    b.c(b.this);
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadFinish(int i, Object obj) {
                    b.a(b.this);
                    if (obj == null) {
                        String str3 = b.f6416a;
                        return;
                    }
                    com.anythink.core.c.a unused = b.d = b.a(b.this.e, str, obj.toString());
                    if (b.d != null) {
                        String s = b.d.s();
                        if (!TextUtils.isEmpty(s) && TextUtils.isEmpty(n.a().y())) {
                            n.a().i(s);
                        }
                        r.a(b.this.e).a(b.d);
                        Context unused2 = b.this.e;
                        com.anythink.core.c.a unused3 = b.d;
                        b.a(b.this.e, b.d);
                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.c.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.anythink.core.common.n.a().a(b.d.c());
                            }
                        });
                        com.anythink.core.common.c.a().a(b.d.b());
                    }
                    b.c(b.this);
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadStart(int i) {
                }
            });
        }
    }

    public final boolean a(String str) {
        com.anythink.core.c.a b = b(str);
        if (b != null) {
            c a2 = b.a();
            long P = b.P();
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = b.L() + P <= currentTimeMillis;
            boolean z2 = a2 != null && b.L() + a2.a() <= currentTimeMillis;
            Map<String, Object> map = b.f6412c;
            Map<String, Object> m = n.a().m();
            return z || z2 || (map != null ? map.equals(m) ^ true : m != null);
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ea -> B:27:0x00dd). Please submit an issue!!! */
    public final com.anythink.core.c.a b(String str) {
        com.anythink.core.c.a aVar;
        synchronized (this) {
            if (d == null) {
                try {
                    if (this.e == null) {
                        this.e = n.a().g();
                    }
                    List<af> a2 = com.anythink.core.common.c.d.a(com.anythink.core.common.c.c.a(this.e)).a(str, g.o.f6522a);
                    com.anythink.core.c.a aVar2 = null;
                    if (a2 != null) {
                        aVar2 = null;
                        if (a2.size() > 0) {
                            af afVar = a2.get(0);
                            aVar2 = null;
                            if (afVar != null) {
                                com.anythink.core.c.a f = com.anythink.core.c.a.f(afVar.d());
                                aVar2 = f;
                                if (f != null) {
                                    f.a(Long.parseLong(afVar.a()));
                                    aVar2 = f;
                                }
                            }
                        }
                    }
                    d = aVar2;
                    if (aVar2 == null) {
                        com.anythink.core.c.a aVar3 = new com.anythink.core.c.a();
                        aVar3.b = true;
                        aVar3.Q();
                        aVar3.b("0");
                        aVar3.a(0L);
                        aVar3.W();
                        aVar3.Z();
                        aVar3.ab();
                        aVar3.c("");
                        aVar3.ae();
                        aVar3.ag();
                        aVar3.d("");
                        aVar3.O();
                        aVar3.K();
                        aVar3.C();
                        aVar3.E();
                        aVar3.a("[\"com.anythink\"]");
                        aVar3.y();
                        aVar3.e();
                        aVar3.i();
                        aVar3.g();
                        aVar3.k();
                        d = aVar3;
                    }
                } catch (Exception e) {
                }
            }
            aVar = d;
        }
        return aVar;
    }
}
