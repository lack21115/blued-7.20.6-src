package com.anythink.basead.d.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.b.b;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.basead.d.c.c;
import com.anythink.basead.g.d;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.z;
import com.anythink.core.common.g.i;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b/a.class */
public class a {
    private static volatile a c;
    ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap<>(3);
    private Context b;

    /* renamed from: com.anythink.basead.d.b.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b/a$1.class */
    final class AnonymousClass1 implements i {
        final /* synthetic */ j a;
        final /* synthetic */ InterfaceC0035a b;

        AnonymousClass1(j jVar, InterfaceC0035a interfaceC0035a) {
            this.a = jVar;
            this.b = interfaceC0035a;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i) {
            InterfaceC0035a interfaceC0035a = this.b;
            if (interfaceC0035a != null) {
                interfaceC0035a.a(null, f.a(f.i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i, String str, AdError adError) {
            InterfaceC0035a interfaceC0035a = this.b;
            if (interfaceC0035a != null) {
                interfaceC0035a.a(null, f.a(f.i, str));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
        @Override // com.anythink.core.common.g.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onLoadFinish(int r8, java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 379
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.d.b.a.AnonymousClass1.onLoadFinish(int, java.lang.Object):void");
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.basead.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b/a$a.class */
    public interface InterfaceC0035a {
        void a();

        void a(z zVar);

        void a(z zVar, e eVar);
    }

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final z zVar, final j jVar, final InterfaceC0035a interfaceC0035a) {
        com.anythink.basead.a.f.a();
        com.anythink.basead.a.f.a(jVar.b, zVar, jVar, new b.InterfaceC0027b() { // from class: com.anythink.basead.d.b.a.2
            @Override // com.anythink.basead.a.b.b.InterfaceC0027b
            public final void a() {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(jVar), Boolean.FALSE);
                InterfaceC0035a interfaceC0035a2 = interfaceC0035a;
                if (interfaceC0035a2 != null) {
                    interfaceC0035a2.a(zVar);
                }
            }

            @Override // com.anythink.basead.a.b.b.InterfaceC0027b
            public final void a(e eVar) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(jVar), Boolean.FALSE);
                InterfaceC0035a interfaceC0035a2 = interfaceC0035a;
                if (interfaceC0035a2 != null) {
                    interfaceC0035a2.a(zVar, eVar);
                }
            }
        });
    }

    private void b(j jVar, String str, InterfaceC0035a interfaceC0035a) {
        z zVar;
        int i;
        int parseInt;
        int parseInt2;
        try {
            zVar = a(jVar);
        } catch (Throwable th) {
            zVar = null;
        }
        if (zVar != null && !zVar.N()) {
            if (interfaceC0035a != null) {
                interfaceC0035a.a();
            }
            a(zVar, jVar, interfaceC0035a);
            return;
        }
        if (!TextUtils.isEmpty(jVar.m.r())) {
            try {
                String[] split = jVar.m.r().split("x");
                parseInt = Integer.parseInt(split[0]);
                try {
                    parseInt2 = Integer.parseInt(split[1]);
                } catch (Throwable th2) {
                    i = parseInt;
                }
            } catch (Throwable th3) {
                i = 0;
            }
            new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0035a));
        }
        i = 0;
        parseInt2 = 0;
        parseInt = i;
        new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0035a));
    }

    public final z a(j jVar) {
        com.anythink.core.basead.b.a();
        String a = com.anythink.core.basead.b.a(jVar);
        com.anythink.core.basead.b.a();
        String a2 = com.anythink.core.basead.b.a(this.b, a);
        z zVar = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            zVar = b.a(jVar, new JSONObject(a2));
        } catch (Throwable th) {
        }
        if (zVar != null) {
            com.anythink.basead.d.c.b.a(zVar);
            com.anythink.basead.d.c.a.a(jVar, zVar);
        }
        return zVar;
    }

    public final void a(j jVar, String str, InterfaceC0035a interfaceC0035a) {
        int i;
        int parseInt;
        int parseInt2;
        com.anythink.core.basead.b.a();
        String a = com.anythink.core.basead.b.a(jVar);
        z zVar = null;
        if (this.a.contains(a) && this.a.get(a).booleanValue()) {
            interfaceC0035a.a(null, f.a(f.g, f.q));
            return;
        }
        this.a.put(a, Boolean.TRUE);
        try {
            zVar = a(jVar);
        } catch (Throwable th) {
        }
        if (zVar != null && !zVar.N()) {
            interfaceC0035a.a();
            a(zVar, jVar, interfaceC0035a);
            return;
        }
        if (!TextUtils.isEmpty(jVar.m.r())) {
            try {
                String[] split = jVar.m.r().split("x");
                parseInt = Integer.parseInt(split[0]);
                try {
                    parseInt2 = Integer.parseInt(split[1]);
                } catch (Throwable th2) {
                    i = parseInt;
                }
            } catch (Throwable th3) {
                i = 0;
            }
            new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0035a));
        }
        i = 0;
        parseInt2 = 0;
        parseInt = i;
        new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0035a));
    }
}
