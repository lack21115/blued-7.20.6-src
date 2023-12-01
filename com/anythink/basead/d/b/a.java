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

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f5943c;

    /* renamed from: a  reason: collision with root package name */
    ConcurrentHashMap<String, Boolean> f5944a = new ConcurrentHashMap<>(3);
    private Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.d.b.a$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/b/a$1.class */
    public final class AnonymousClass1 implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f5947a;
        final /* synthetic */ InterfaceC0075a b;

        AnonymousClass1(j jVar, InterfaceC0075a interfaceC0075a) {
            this.f5947a = jVar;
            this.b = interfaceC0075a;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i) {
            InterfaceC0075a interfaceC0075a = this.b;
            if (interfaceC0075a != null) {
                interfaceC0075a.a(null, f.a(f.i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i, String str, AdError adError) {
            InterfaceC0075a interfaceC0075a = this.b;
            if (interfaceC0075a != null) {
                interfaceC0075a.a(null, f.a(f.i, str));
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
    public interface InterfaceC0075a {
        void a();

        void a(z zVar);

        void a(z zVar, e eVar);
    }

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (f5943c == null) {
            synchronized (a.class) {
                try {
                    if (f5943c == null) {
                        f5943c = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5943c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final z zVar, final j jVar, final InterfaceC0075a interfaceC0075a) {
        com.anythink.basead.a.f.a();
        com.anythink.basead.a.f.a(jVar.b, zVar, jVar, new b.InterfaceC0067b() { // from class: com.anythink.basead.d.b.a.2
            @Override // com.anythink.basead.a.b.b.InterfaceC0067b
            public final void a() {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.f5944a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(jVar), Boolean.FALSE);
                InterfaceC0075a interfaceC0075a2 = interfaceC0075a;
                if (interfaceC0075a2 != null) {
                    interfaceC0075a2.a(zVar);
                }
            }

            @Override // com.anythink.basead.a.b.b.InterfaceC0067b
            public final void a(e eVar) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.f5944a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(jVar), Boolean.FALSE);
                InterfaceC0075a interfaceC0075a2 = interfaceC0075a;
                if (interfaceC0075a2 != null) {
                    interfaceC0075a2.a(zVar, eVar);
                }
            }
        });
    }

    private void b(j jVar, String str, InterfaceC0075a interfaceC0075a) {
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
            if (interfaceC0075a != null) {
                interfaceC0075a.a();
            }
            a(zVar, jVar, interfaceC0075a);
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
            new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.f6664c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0075a));
        }
        i = 0;
        parseInt2 = 0;
        parseInt = i;
        new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.f6664c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0075a));
    }

    public final z a(j jVar) {
        com.anythink.core.basead.b.a();
        String a2 = com.anythink.core.basead.b.a(jVar);
        com.anythink.core.basead.b.a();
        String a3 = com.anythink.core.basead.b.a(this.b, a2);
        z zVar = null;
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        try {
            zVar = b.a(jVar, new JSONObject(a3));
        } catch (Throwable th) {
        }
        if (zVar != null) {
            com.anythink.basead.d.c.b.a(zVar);
            com.anythink.basead.d.c.a.a(jVar, zVar);
        }
        return zVar;
    }

    public final void a(j jVar, String str, InterfaceC0075a interfaceC0075a) {
        int i;
        int parseInt;
        int parseInt2;
        com.anythink.core.basead.b.a();
        String a2 = com.anythink.core.basead.b.a(jVar);
        z zVar = null;
        if (this.f5944a.contains(a2) && this.f5944a.get(a2).booleanValue()) {
            interfaceC0075a.a(null, f.a(f.g, f.q));
            return;
        }
        this.f5944a.put(a2, Boolean.TRUE);
        try {
            zVar = a(jVar);
        } catch (Throwable th) {
        }
        if (zVar != null && !zVar.N()) {
            interfaceC0075a.a();
            a(zVar, jVar, interfaceC0075a);
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
            new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.f6664c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0075a));
        }
        i = 0;
        parseInt2 = 0;
        parseInt = i;
        new d(jVar, parseInt, parseInt2, c.a().a(this.b, c.a(jVar.b, jVar.f6664c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0075a));
    }
}
