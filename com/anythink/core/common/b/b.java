package com.anythink.core.common.b;

import android.util.Log;
import com.anythink.core.api.ATAdSourceStatusListener;
import com.anythink.core.api.AdError;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<ATAdSourceStatusListener> f6473a;

    private ATAdSourceStatusListener a() {
        WeakReference<ATAdSourceStatusListener> weakReference = this.f6473a;
        if (weakReference != null) {
            ATAdSourceStatusListener aTAdSourceStatusListener = weakReference.get();
            if (aTAdSourceStatusListener == null) {
                Log.e("anythink", "ATAdSourceStatusListener had been released.");
            }
            return aTAdSourceStatusListener;
        }
        return null;
    }

    static /* synthetic */ ATAdSourceStatusListener a(b bVar) {
        WeakReference<ATAdSourceStatusListener> weakReference = bVar.f6473a;
        if (weakReference != null) {
            ATAdSourceStatusListener aTAdSourceStatusListener = weakReference.get();
            if (aTAdSourceStatusListener == null) {
                Log.e("anythink", "ATAdSourceStatusListener had been released.");
            }
            return aTAdSourceStatusListener;
        }
        return null;
    }

    public final void a(ATAdSourceStatusListener aTAdSourceStatusListener) {
        if (aTAdSourceStatusListener == null) {
            return;
        }
        this.f6473a = new WeakReference<>(aTAdSourceStatusListener);
    }

    public final void a(com.anythink.core.common.e.e eVar) {
        final j a2 = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a3 = b.a(b.this);
                if (a3 != null) {
                    a3.onAdSourceBiddingAttempt(a2);
                }
            }
        });
    }

    public final void a(com.anythink.core.common.e.e eVar, final AdError adError) {
        final j a2 = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.3
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a3 = b.a(b.this);
                if (a3 != null) {
                    a3.onAdSourceBiddingFail(a2, adError);
                }
            }
        });
    }

    public final void b(com.anythink.core.common.e.e eVar) {
        final j a2 = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.2
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a3 = b.a(b.this);
                if (a3 != null) {
                    a3.onAdSourceBiddingFilled(a2);
                }
            }
        });
    }

    public final void b(com.anythink.core.common.e.e eVar, final AdError adError) {
        final j a2 = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.6
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a3 = b.a(b.this);
                if (a3 != null) {
                    a3.onAdSourceLoadFail(a2, adError);
                }
            }
        });
    }

    public final void c(com.anythink.core.common.e.e eVar) {
        final j a2 = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.4
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a3 = b.a(b.this);
                if (a3 != null) {
                    a3.onAdSourceAttempt(a2);
                }
            }
        });
    }

    public final void d(com.anythink.core.common.e.e eVar) {
        final j a2 = j.a(eVar, (d) null);
        n.a().a(new Runnable() { // from class: com.anythink.core.common.b.b.5
            @Override // java.lang.Runnable
            public final void run() {
                ATAdSourceStatusListener a3 = b.a(b.this);
                if (a3 != null) {
                    a3.onAdSourceLoadFilled(a2);
                }
            }
        });
    }
}
