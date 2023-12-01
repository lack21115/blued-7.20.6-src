package com.kwad.components.core.l;

import android.os.Bundle;
import com.kwad.sdk.utils.bi;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/l/h.class */
public class h {
    private static volatile h NT;
    private final List<i> mListeners = new CopyOnWriteArrayList();

    private void a(final com.kwad.sdk.e.a<i> aVar) {
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.l.h.5
            @Override // java.lang.Runnable
            public final void run() {
                for (i iVar : h.this.mListeners) {
                    if (iVar != null) {
                        try {
                            aVar.accept(iVar);
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }
            }
        });
    }

    public static h oZ() {
        if (NT == null) {
            synchronized (h.class) {
                try {
                    if (NT == null) {
                        NT = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return NT;
    }

    public final void a(final d dVar, final Bundle bundle) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityCreated(dVar, bundle);
            }
        });
    }

    public final void a(i iVar) {
        this.mListeners.add(iVar);
    }

    public final void d(final d dVar) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityResumed(dVar);
            }
        });
    }

    public final void e(final d dVar) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityPaused(dVar);
            }
        });
    }

    public final void f(final d dVar) {
        a(new com.kwad.sdk.e.a<i>() { // from class: com.kwad.components.core.l.h.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(i iVar) {
                iVar.onActivityDestroyed(dVar);
            }
        });
    }
}
