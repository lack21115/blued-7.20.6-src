package com.anythink.basead.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.k;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/i.class */
public final class i implements com.anythink.core.common.f.b {

    /* renamed from: a  reason: collision with root package name */
    com.anythink.basead.d f5872a;
    Context b = n.a().g();

    @Override // com.anythink.core.common.f.b
    public final void a(final com.anythink.core.common.e.i iVar, final String str, final String str2, boolean z) {
        if (z) {
            b.a(this.b, iVar);
            return;
        }
        k k = iVar.k();
        if (k == null) {
            return;
        }
        int H = k.H();
        int I = k.I();
        if (H != 1) {
            if (H != 3) {
                return;
            }
            com.anythink.core.common.b.a().a("1", new com.anythink.basead.c.g(iVar, str2, str));
            return;
        }
        final com.anythink.basead.a aVar = new com.anythink.basead.a() { // from class: com.anythink.basead.a.i.1
            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
                super.onActivityPaused(activity);
                if (i.this.f5872a != null) {
                    i.this.f5872a.b();
                }
            }

            @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                if (i.this.f5872a != null) {
                    i.this.f5872a.a();
                }
            }
        };
        this.f5872a = new com.anythink.basead.d(I, new Runnable() { // from class: com.anythink.basead.a.i.2
            @Override // java.lang.Runnable
            public final void run() {
                ((Application) i.this.b).unregisterActivityLifecycleCallbacks(aVar);
                if (b.a(i.this.b, iVar)) {
                    com.anythink.core.common.j.c.a(str, iVar.p(), str2, 6, (String) null, 0L, 0L);
                }
            }
        });
        try {
            ((Application) this.b).registerActivityLifecycleCallbacks(aVar);
        } catch (Exception e) {
            com.anythink.core.common.j.c.a("Error", "Error, cannot registerActivityLifecycleCallbacks here!", n.a().r());
        }
    }
}
