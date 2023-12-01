package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b.class */
public final class b {
    private final Set<com.kwad.components.ad.reward.d.h> oa;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b$a.class */
    static final class a {
        private static final b oe = new b((byte) 0);
    }

    private b() {
        this.oa = new HashSet();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, com.kwad.components.ad.reward.d.l lVar) {
        if (this.oa.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.h hVar : this.oa) {
            hVar.a(playableSource, lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.oa.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.h hVar : this.oa) {
            hVar.cb();
        }
    }

    public static b ff() {
        return a.oe;
    }

    private void fh() {
        if (this.oa.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.h hVar : this.oa) {
            hVar.ca();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.d.h hVar) {
        if (hVar != null) {
            this.oa.add(hVar);
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(com.kwad.components.ad.reward.d.h hVar) {
        this.oa.remove(hVar);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c(playableSource);
                }
            });
        }
    }

    public final void c(final PlayableSource playableSource, final com.kwad.components.ad.reward.d.l lVar) {
        if (isMainThread()) {
            b(playableSource, lVar);
        } else {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(playableSource, lVar);
                }
            });
        }
    }

    public final void fg() {
        if (isMainThread()) {
            fh();
        } else {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.fg();
                }
            });
        }
    }
}
