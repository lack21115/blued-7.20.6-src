package com.anythink.core.common.b;

import android.util.Log;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.AdError;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/b.class */
public class b {
    WeakReference<ATAdSourceStatusListener> a;

    private ATAdSourceStatusListener a() {
        WeakReference<ATAdSourceStatusListener> weakReference = this.a;
        if (weakReference != null) {
            ATAdSourceStatusListener aTAdSourceStatusListener = weakReference.get();
            if (aTAdSourceStatusListener == null) {
                Log.e(g.n, "ATAdSourceStatusListener had been released.");
            }
            return aTAdSourceStatusListener;
        }
        return null;
    }

    static /* synthetic */ ATAdSourceStatusListener a(b bVar) {
        WeakReference<ATAdSourceStatusListener> weakReference = bVar.a;
        if (weakReference != null) {
            ATAdSourceStatusListener aTAdSourceStatusListener = weakReference.get();
            if (aTAdSourceStatusListener == null) {
                Log.e(g.n, "ATAdSourceStatusListener had been released.");
            }
            return aTAdSourceStatusListener;
        }
        return null;
    }

    public final void a(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (aTAdSourceStatusListener == null) {
            return;
        }
        this.a = new WeakReference<>(aTAdSourceStatusListener);
    }

    public final void a(com.anythink.core.common.e.e eVar) {
        final j a = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a2 = b.a(b.this);
                if (a2 != null) {
                    a2.onAdSourceBiddingAttempt(a);
                }
            }
        });
    }

    public final void a(com.anythink.core.common.e.e eVar, final AdError adError) {
        final j a = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.3
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a2 = b.a(b.this);
                if (a2 != null) {
                    a2.onAdSourceBiddingFail(a, adError);
                }
            }
        });
    }

    public final void b(com.anythink.core.common.e.e eVar) {
        final j a = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.2
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a2 = b.a(b.this);
                if (a2 != null) {
                    a2.onAdSourceBiddingFilled(a);
                }
            }
        });
    }

    public final void b(com.anythink.core.common.e.e eVar, final AdError adError) {
        final j a = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.6
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a2 = b.a(b.this);
                if (a2 != null) {
                    a2.onAdSourceLoadFail(a, adError);
                }
            }
        });
    }

    public final void c(com.anythink.core.common.e.e eVar) {
        final j a = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.4
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a2 = b.a(b.this);
                if (a2 != null) {
                    a2.onAdSourceAttempt(a);
                }
            }
        });
    }

    public final void d(com.anythink.core.common.e.e eVar) {
        final j a = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.5
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a2 = b.a(b.this);
                if (a2 != null) {
                    a2.onAdSourceLoadFilled(a);
                }
            }
        });
    }
}
