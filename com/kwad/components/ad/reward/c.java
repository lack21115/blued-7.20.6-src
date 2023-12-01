package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/c.class */
public final class c {
    private final Set<com.kwad.components.ad.reward.d.j> of;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/c$a.class */
    static final class a {
        private static final c oh = new c((byte) 0);
    }

    private c() {
        this.of = new HashSet();
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c fj() {
        return a.oh;
    }

    private void fk() {
        if (this.of.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.j jVar : this.of) {
            jVar.onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.d.j jVar) {
        if (jVar != null) {
            this.of.add(jVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.j jVar) {
        this.of.remove(jVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fk();
        } else {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.notifyRewardVerify();
                }
            });
        }
    }
}
