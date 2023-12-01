package com.anythink.basead.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.b.b;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.basead.d.a.b;
import com.anythink.basead.d.c.d;
import com.anythink.core.api.AdError;
import com.anythink.core.common.a.c;
import com.anythink.core.common.a.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.g.i;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/a.class */
public class a {
    private static volatile a d;

    /* renamed from: a  reason: collision with root package name */
    ConcurrentHashMap<String, Boolean> f5916a = new ConcurrentHashMap<>(3);
    ConcurrentHashMap<String, g> b = new ConcurrentHashMap<>(2);

    /* renamed from: c  reason: collision with root package name */
    private Context f5917c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.d.a.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/a$1.class */
    public final class AnonymousClass1 implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f5918a;
        final /* synthetic */ InterfaceC0072a b;

        AnonymousClass1(j jVar, InterfaceC0072a interfaceC0072a) {
            this.f5918a = jVar;
            this.b = interfaceC0072a;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i) {
            InterfaceC0072a interfaceC0072a = this.b;
            if (interfaceC0072a != null) {
                interfaceC0072a.a((com.anythink.core.common.e.g) null, f.a(f.i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i, String str, AdError adError) {
            InterfaceC0072a interfaceC0072a = this.b;
            if (interfaceC0072a != null) {
                interfaceC0072a.a((com.anythink.core.common.e.g) null, f.a(f.i, str));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadFinish(int i, Object obj) {
            com.anythink.core.common.e.g gVar;
            try {
                gVar = c.a(this.f5918a.f6663a, new JSONObject(obj.toString()), this.f5918a.f);
            } catch (Exception e) {
                gVar = null;
            }
            if (gVar == null) {
                InterfaceC0072a interfaceC0072a = this.b;
                if (interfaceC0072a != null) {
                    interfaceC0072a.a((com.anythink.core.common.e.g) null, f.a(f.i, obj != null ? obj.toString() : "No Ad Return."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.c.b.a(gVar);
            com.anythink.basead.d.c.a.a(this.f5918a, gVar);
            d.a(this.f5918a, gVar);
            if (this.f5918a.f == 67) {
                com.anythink.core.common.d.c.a(a.this.f5917c).a(gVar.p(), gVar.P());
                com.anythink.core.common.d.b.a(a.this.f5917c).a(gVar.q(), gVar.P());
            }
            com.anythink.basead.a.b.a(10, gVar, new com.anythink.basead.c.i(this.f5918a.d, ""));
            com.anythink.core.common.a.a.a().a(a.this.f5917c, this.f5918a.f, this.f5918a.f6664c, this.f5918a.f6663a, obj.toString());
            com.anythink.expressad.foundation.d.d a2 = a.this.a(gVar, this.f5918a);
            InterfaceC0072a interfaceC0072a2 = this.b;
            if (interfaceC0072a2 != null) {
                interfaceC0072a2.a(gVar);
            }
            a.this.a(gVar, this.f5918a, a2, this.b);
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.basead.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/a$a.class */
    public interface InterfaceC0072a {
        void a(com.anythink.core.common.e.g gVar);

        void a(com.anythink.core.common.e.g gVar, e eVar);

        void a(com.anythink.core.common.e.g gVar, g gVar2);
    }

    private a(Context context) {
        this.f5917c = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                try {
                    if (d == null) {
                        d = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.anythink.expressad.foundation.d.d a(com.anythink.core.common.e.g gVar, j jVar) {
        synchronized (this) {
            if (TextUtils.isEmpty(gVar.a())) {
                return null;
            }
            com.anythink.expressad.foundation.d.d a2 = com.anythink.expressad.foundation.d.d.a(gVar.a());
            ArrayList<com.anythink.expressad.foundation.d.c> arrayList = a2.J;
            b.a(gVar, arrayList.get(0));
            b.a(gVar, arrayList);
            b.a(jVar, arrayList);
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.anythink.core.common.e.g gVar, final j jVar, com.anythink.expressad.foundation.d.d dVar, final InterfaceC0072a interfaceC0072a) {
        if (!TextUtils.isEmpty(gVar.a())) {
            b.a().a(gVar, jVar, dVar, new b.a() { // from class: com.anythink.basead.d.a.a.2
                @Override // com.anythink.basead.d.a.b.a
                public final void a(e eVar) {
                    ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.f5916a;
                    concurrentHashMap.put(jVar.b + jVar.f6663a, Boolean.FALSE);
                    InterfaceC0072a interfaceC0072a2 = interfaceC0072a;
                    if (interfaceC0072a2 != null) {
                        interfaceC0072a2.a(gVar, eVar);
                    }
                }

                @Override // com.anythink.basead.d.a.b.a
                public final void a(g gVar2) {
                    ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.f5916a;
                    concurrentHashMap.put(jVar.b + jVar.f6663a, Boolean.FALSE);
                    InterfaceC0072a interfaceC0072a2 = interfaceC0072a;
                    if (interfaceC0072a2 != null) {
                        interfaceC0072a2.a(gVar, gVar2);
                    }
                }
            });
            return;
        }
        com.anythink.basead.a.f.a();
        com.anythink.basead.a.f.a(jVar.b, gVar, jVar, new b.InterfaceC0067b() { // from class: com.anythink.basead.d.a.a.3
            @Override // com.anythink.basead.a.b.b.InterfaceC0067b
            public final void a() {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.f5916a;
                concurrentHashMap.put(jVar.b + jVar.f6663a, Boolean.FALSE);
                InterfaceC0072a interfaceC0072a2 = interfaceC0072a;
                if (interfaceC0072a2 != null) {
                    interfaceC0072a2.a(gVar, (g) null);
                }
            }

            @Override // com.anythink.basead.a.b.b.InterfaceC0067b
            public final void a(e eVar) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.f5916a;
                concurrentHashMap.put(jVar.b + jVar.f6663a, Boolean.FALSE);
                InterfaceC0072a interfaceC0072a2 = interfaceC0072a;
                if (interfaceC0072a2 != null) {
                    interfaceC0072a2.a(gVar, eVar);
                }
            }
        });
    }

    private void b(j jVar, InterfaceC0072a interfaceC0072a) {
        com.anythink.core.common.e.g gVar;
        try {
            gVar = a(jVar);
        } catch (Throwable th) {
            gVar = null;
        }
        if (gVar == null) {
            new com.anythink.basead.g.a(jVar).a(0, (i) new AnonymousClass1(jVar, interfaceC0072a));
            return;
        }
        com.anythink.core.common.a.a.a();
        if (!com.anythink.core.common.a.a.d(this.f5917c, gVar.b())) {
            com.anythink.basead.a.b.a(10, gVar, new com.anythink.basead.c.i(jVar.d, ""));
            com.anythink.core.common.a.a.a();
            com.anythink.core.common.a.a.c(this.f5917c, gVar.b());
        }
        com.anythink.expressad.foundation.d.d a2 = a(gVar, jVar);
        if (interfaceC0072a != null) {
            interfaceC0072a.a(gVar);
        }
        a(gVar, jVar, a2, interfaceC0072a);
    }

    public final com.anythink.core.common.e.g a(j jVar) {
        String a2 = com.anythink.core.common.a.a.a().a(this.f5917c, jVar.f6663a);
        com.anythink.core.common.e.g gVar = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            gVar = c.a(jVar.f6663a, new JSONObject(a2), jVar.f);
        } catch (Throwable th) {
        }
        if (gVar != null) {
            com.anythink.basead.d.c.b.a(gVar);
            com.anythink.basead.d.c.a.a(jVar, gVar);
            d.a(jVar, gVar);
        }
        return gVar;
    }

    public final void a(j jVar, InterfaceC0072a interfaceC0072a) {
        com.anythink.core.common.e.g gVar = null;
        if (this.f5916a.contains(jVar.b + jVar.f6663a)) {
            if (this.f5916a.get(jVar.b + jVar.f6663a).booleanValue()) {
                interfaceC0072a.a((com.anythink.core.common.e.g) null, f.a(f.g, f.q));
                return;
            }
        }
        this.f5916a.put(jVar.b + jVar.f6663a, Boolean.TRUE);
        try {
            gVar = a(jVar);
        } catch (Throwable th) {
        }
        if (gVar == null) {
            new com.anythink.basead.g.a(jVar).a(0, (i) new AnonymousClass1(jVar, interfaceC0072a));
            return;
        }
        com.anythink.core.common.a.a.a();
        if (!com.anythink.core.common.a.a.d(this.f5917c, gVar.b())) {
            com.anythink.basead.a.b.a(10, gVar, new com.anythink.basead.c.i(jVar.d, ""));
            com.anythink.core.common.a.a.a();
            com.anythink.core.common.a.a.c(this.f5917c, gVar.b());
        }
        com.anythink.expressad.foundation.d.d a2 = a(gVar, jVar);
        interfaceC0072a.a(gVar);
        a(gVar, jVar, a2, interfaceC0072a);
    }
}
