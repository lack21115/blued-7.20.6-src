package com.kwad.components.core.r;

import android.content.Context;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/a.class */
public class a {
    private static volatile a PO;
    private com.kwad.sdk.utils.h PK;
    private List<WeakReference<OfflineOnAudioConflictListener>> PL = new ArrayList();
    private boolean PM = false;
    private boolean PN = false;

    private a(Context context) {
        init(context);
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.PN = true;
        return true;
    }

    public static a aj(Context context) {
        if (PO == null) {
            synchronized (a.class) {
                try {
                    if (PO == null) {
                        PO = new a(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return PO;
    }

    private void init(Context context) {
        this.PM = false;
        com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
        this.PK = hVar;
        hVar.c(new h.a() { // from class: com.kwad.components.core.r.a.1
            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeOccupied() {
                OfflineOnAudioConflictListener offlineOnAudioConflictListener;
                Iterator it = a.this.PL.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        offlineOnAudioConflictListener.onAudioBeOccupied();
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeReleased() {
                OfflineOnAudioConflictListener offlineOnAudioConflictListener;
                Iterator it = a.this.PL.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null || (offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get()) == null) {
                        it.remove();
                    } else {
                        offlineOnAudioConflictListener.onAudioBeReleased();
                    }
                }
            }
        });
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.PL.add(new WeakReference<>(offlineOnAudioConflictListener));
    }

    public final boolean aL(boolean z) {
        if (this.PK == null) {
            return false;
        }
        if (z || !this.PM) {
            this.PM = true;
            this.PN = false;
            return this.PK.CQ();
        }
        return false;
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.PL.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean pI() {
        return this.PN;
    }

    public final boolean pJ() {
        return this.PM;
    }
}
