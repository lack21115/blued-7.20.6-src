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
    ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap<>(3);
    ConcurrentHashMap<String, g> b = new ConcurrentHashMap<>(2);
    private Context c;

    /* renamed from: com.anythink.basead.d.a.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/a$1.class */
    final class AnonymousClass1 implements i {
        final /* synthetic */ j a;
        final /* synthetic */ InterfaceC0032a b;

        AnonymousClass1(j jVar, InterfaceC0032a interfaceC0032a) {
            this.a = jVar;
            this.b = interfaceC0032a;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i) {
            InterfaceC0032a interfaceC0032a = this.b;
            if (interfaceC0032a != null) {
                interfaceC0032a.a((com.anythink.core.common.e.g) null, f.a(f.i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i, String str, AdError adError) {
            InterfaceC0032a interfaceC0032a = this.b;
            if (interfaceC0032a != null) {
                interfaceC0032a.a((com.anythink.core.common.e.g) null, f.a(f.i, str));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadFinish(int i, Object obj) {
            com.anythink.core.common.e.g gVar;
            try {
                gVar = c.a(this.a.a, new JSONObject(obj.toString()), this.a.f);
            } catch (Exception e) {
                gVar = null;
            }
            if (gVar == null) {
                InterfaceC0032a interfaceC0032a = this.b;
                if (interfaceC0032a != null) {
                    interfaceC0032a.a((com.anythink.core.common.e.g) null, f.a(f.i, obj != null ? obj.toString() : "No Ad Return."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.c.b.a(gVar);
            com.anythink.basead.d.c.a.a(this.a, gVar);
            d.a(this.a, gVar);
            if (this.a.f == 67) {
                com.anythink.core.common.d.c.a(a.this.c).a(gVar.p(), gVar.P());
                com.anythink.core.common.d.b.a(a.this.c).a(gVar.q(), gVar.P());
            }
            com.anythink.basead.a.b.a(10, gVar, new com.anythink.basead.c.i(this.a.d, ""));
            com.anythink.core.common.a.a.a().a(a.this.c, this.a.f, this.a.c, this.a.a, obj.toString());
            com.anythink.expressad.foundation.d.d a = a.this.a(gVar, this.a);
            InterfaceC0032a interfaceC0032a2 = this.b;
            if (interfaceC0032a2 != null) {
                interfaceC0032a2.a(gVar);
            }
            a.this.a(gVar, this.a, a, this.b);
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.basead.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a/a$a.class */
    public interface InterfaceC0032a {
        void a(com.anythink.core.common.e.g gVar);

        void a(com.anythink.core.common.e.g gVar, e eVar);

        void a(com.anythink.core.common.e.g gVar, g gVar2);
    }

    private a(Context context) {
        this.c = context.getApplicationContext();
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
            com.anythink.expressad.foundation.d.d a = com.anythink.expressad.foundation.d.d.a(gVar.a());
            ArrayList arrayList = a.J;
            b.a(gVar, (com.anythink.expressad.foundation.d.c) arrayList.get(0));
            b.a(gVar, arrayList);
            b.a(jVar, arrayList);
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.anythink.core.common.e.g gVar, final j jVar, com.anythink.expressad.foundation.d.d dVar, final InterfaceC0032a interfaceC0032a) {
        if (!TextUtils.isEmpty(gVar.a())) {
            b.a().a(gVar, jVar, dVar, new b.a() { // from class: com.anythink.basead.d.a.a.2
                @Override // com.anythink.basead.d.a.b.a
                public final void a(e eVar) {
                    ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                    concurrentHashMap.put(jVar.b + jVar.a, Boolean.FALSE);
                    InterfaceC0032a interfaceC0032a2 = interfaceC0032a;
                    if (interfaceC0032a2 != null) {
                        interfaceC0032a2.a(gVar, eVar);
                    }
                }

                @Override // com.anythink.basead.d.a.b.a
                public final void a(g gVar2) {
                    ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                    concurrentHashMap.put(jVar.b + jVar.a, Boolean.FALSE);
                    InterfaceC0032a interfaceC0032a2 = interfaceC0032a;
                    if (interfaceC0032a2 != null) {
                        interfaceC0032a2.a(gVar, gVar2);
                    }
                }
            });
            return;
        }
        com.anythink.basead.a.f.a();
        com.anythink.basead.a.f.a(jVar.b, gVar, jVar, new b.InterfaceC0027b() { // from class: com.anythink.basead.d.a.a.3
            @Override // com.anythink.basead.a.b.b.InterfaceC0027b
            public final void a() {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                concurrentHashMap.put(jVar.b + jVar.a, Boolean.FALSE);
                InterfaceC0032a interfaceC0032a2 = interfaceC0032a;
                if (interfaceC0032a2 != null) {
                    interfaceC0032a2.a(gVar, (g) null);
                }
            }

            @Override // com.anythink.basead.a.b.b.InterfaceC0027b
            public final void a(e eVar) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                concurrentHashMap.put(jVar.b + jVar.a, Boolean.FALSE);
                InterfaceC0032a interfaceC0032a2 = interfaceC0032a;
                if (interfaceC0032a2 != null) {
                    interfaceC0032a2.a(gVar, eVar);
                }
            }
        });
    }

    private void b(j jVar, InterfaceC0032a interfaceC0032a) {
        com.anythink.core.common.e.g gVar;
        try {
            gVar = a(jVar);
        } catch (Throwable th) {
            gVar = null;
        }
        if (gVar == null) {
            new com.anythink.basead.g.a(jVar).a(0, (i) new AnonymousClass1(jVar, interfaceC0032a));
            return;
        }
        com.anythink.core.common.a.a.a();
        if (!com.anythink.core.common.a.a.d(this.c, gVar.b())) {
            com.anythink.basead.a.b.a(10, gVar, new com.anythink.basead.c.i(jVar.d, ""));
            com.anythink.core.common.a.a.a();
            com.anythink.core.common.a.a.c(this.c, gVar.b());
        }
        com.anythink.expressad.foundation.d.d a = a(gVar, jVar);
        if (interfaceC0032a != null) {
            interfaceC0032a.a(gVar);
        }
        a(gVar, jVar, a, interfaceC0032a);
    }

    public final com.anythink.core.common.e.g a(j jVar) {
        String a = com.anythink.core.common.a.a.a().a(this.c, jVar.a);
        com.anythink.core.common.e.g gVar = null;
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            gVar = c.a(jVar.a, new JSONObject(a), jVar.f);
        } catch (Throwable th) {
        }
        if (gVar != null) {
            com.anythink.basead.d.c.b.a(gVar);
            com.anythink.basead.d.c.a.a(jVar, gVar);
            d.a(jVar, gVar);
        }
        return gVar;
    }

    public final void a(j jVar, InterfaceC0032a interfaceC0032a) {
        com.anythink.core.common.e.g gVar = null;
        if (this.a.contains(jVar.b + jVar.a)) {
            if (this.a.get(jVar.b + jVar.a).booleanValue()) {
                interfaceC0032a.a((com.anythink.core.common.e.g) null, f.a(f.g, f.q));
                return;
            }
        }
        this.a.put(jVar.b + jVar.a, Boolean.TRUE);
        try {
            gVar = a(jVar);
        } catch (Throwable th) {
        }
        if (gVar == null) {
            new com.anythink.basead.g.a(jVar).a(0, (i) new AnonymousClass1(jVar, interfaceC0032a));
            return;
        }
        com.anythink.core.common.a.a.a();
        if (!com.anythink.core.common.a.a.d(this.c, gVar.b())) {
            com.anythink.basead.a.b.a(10, gVar, new com.anythink.basead.c.i(jVar.d, ""));
            com.anythink.core.common.a.a.a();
            com.anythink.core.common.a.a.c(this.c, gVar.b());
        }
        com.anythink.expressad.foundation.d.d a = a(gVar, jVar);
        interfaceC0032a.a(gVar);
        a(gVar, jVar, a, interfaceC0032a);
    }
}
