package com.anythink.basead.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.k;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    com.anythink.basead.d f5822a;
    com.anythink.core.common.k.a.c b;
    private View d;
    private com.anythink.core.common.e.j e;
    private InterfaceC0066a f;
    private Application.ActivityLifecycleCallbacks i;

    /* renamed from: c  reason: collision with root package name */
    private final String f5823c = getClass().getSimpleName();
    private Activity g = null;
    private boolean h = false;

    /* renamed from: com.anythink.basead.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/a$a.class */
    public interface InterfaceC0066a {
        void a(int i);
    }

    public a(View view, com.anythink.core.common.e.j jVar, InterfaceC0066a interfaceC0066a) {
        this.d = view;
        this.e = jVar;
        this.f = interfaceC0066a;
        Context applicationContext = view.getContext().getApplicationContext();
        Context g = applicationContext instanceof Application ? applicationContext : n.a().g();
        final Context context = g;
        com.anythink.basead.a aVar = new com.anythink.basead.a() { // from class: com.anythink.basead.a.a.1
            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
                if ((a.this.g == activity || a.b(a.this)) && a.this.i != null) {
                    ((Application) context).unregisterActivityLifecycleCallbacks(a.this.i);
                    a.this.i = null;
                }
            }

            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
                if (a.this.g == activity || a.b(a.this)) {
                    a.this.f5822a.b();
                }
            }

            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                if (a.this.g == null && (activity instanceof BaseAdActivity)) {
                    a.this.g = activity;
                }
                if (a.this.g == activity || a.b(a.this)) {
                    a.c(a.this);
                }
            }
        };
        this.i = aVar;
        try {
            ((Application) g).registerActivityLifecycleCallbacks(aVar);
        } catch (Exception e) {
            com.anythink.core.common.j.c.a("Error", "Error, cannot registerActivityLifecycleCallbacks here!", n.a().r());
        }
        this.f5822a = new com.anythink.basead.d(this.e.m.G(), new Runnable() { // from class: com.anythink.basead.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r5.d.isShown() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (com.anythink.core.common.k.u.b(r5.d) != false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(final int r6) {
        /*
            r5 = this;
            r0 = 0
            r8 = r0
            r0 = r6
            r1 = 2
            if (r0 != r1) goto L6d
            r0 = r5
            com.anythink.core.common.e.j r0 = r0.e
            int r0 = r0.j
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L3e
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L3e
            r0 = r5
            android.view.View r0 = r0.d
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L6f
            r0 = r8
            r7 = r0
            r0 = r9
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L6f
            r0 = r8
            r7 = r0
            r0 = r5
            android.view.View r0 = r0.d
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L6f
            goto L6d
        L3e:
            r0 = r5
            android.view.View r0 = r0.d
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L6f
            r0 = r8
            r7 = r0
            r0 = r9
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L6f
            r0 = r8
            r7 = r0
            r0 = r5
            android.view.View r0 = r0.d
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L6f
            r0 = r8
            r7 = r0
            r0 = r5
            android.view.View r0 = r0.d
            boolean r0 = com.anythink.core.common.k.u.b(r0)
            if (r0 == 0) goto L6f
        L6d:
            r0 = 1
            r7 = r0
        L6f:
            r0 = r7
            if (r0 == 0) goto L79
            r0 = r5
            r1 = r6
            r0.b(r1)
            return
        L79:
            r0 = r5
            com.anythink.core.common.e.j r0 = r0.e
            int r0 = r0.j
            r1 = 2
            if (r0 == r1) goto L8e
            r0 = r5
            com.anythink.core.common.e.j r0 = r0.e
            int r0 = r0.j
            if (r0 != 0) goto Lc0
        L8e:
            com.anythink.basead.a.a$3 r0 = new com.anythink.basead.a.a$3
            r1 = r0
            r2 = r5
            r3 = r6
            r1.<init>()
            r9 = r0
            r0 = r5
            com.anythink.core.common.k.a.c r0 = r0.b
            if (r0 != 0) goto Lb3
            r0 = r5
            android.view.View r0 = r0.d
            android.content.Context r0 = r0.getContext()
            r0 = r5
            com.anythink.core.common.k.a.c r1 = new com.anythink.core.common.k.a.c
            r2 = r1
            r2.<init>()
            r0.b = r1
        Lb3:
            r0 = r5
            com.anythink.core.common.k.a.c r0 = r0.b
            r1 = r5
            android.view.View r1 = r1.d
            r2 = r9
            r0.a(r1, r2)
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.a.a.a(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        if (this.f != null) {
            n.a().a(new Runnable() { // from class: com.anythink.basead.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.f.a(i);
                }
            });
        }
    }

    static /* synthetic */ boolean b(a aVar) {
        return aVar.e.j == 4;
    }

    static /* synthetic */ void c(a aVar) {
        if (aVar.h) {
            aVar.a();
        }
    }

    private boolean d() {
        return this.e.j == 4;
    }

    private void e() {
        if (this.h) {
            a();
        }
    }

    private void f() {
        this.f5822a.b();
    }

    public final void a() {
        this.h = true;
        k kVar = this.e.m;
        if (kVar.F() != 2 || kVar.G() < 0) {
            return;
        }
        this.f5822a.a();
    }

    public final void b() {
        if (this.i != null) {
            ((Application) n.a().g()).unregisterActivityLifecycleCallbacks(this.i);
            this.i = null;
        }
        this.f5822a.c();
        com.anythink.core.common.k.a.c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void c() {
        if (this.e.m.F() == 3) {
            a(3);
        }
    }
}
