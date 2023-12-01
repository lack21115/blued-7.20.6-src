package com.kwad.components.ad.reward;

import com.kwad.components.core.webview.a.a.r;
import com.kwad.sdk.utils.bi;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/d.class */
public final class d {
    private final Set<com.kwad.components.ad.reward.d.k> oi;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/d$a.class */
    static final class a {
        private static final d ol = new d((byte) 0);
    }

    private d() {
        this.oi = new HashSet();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (this.oi.size() == 0) {
            return;
        }
        for (com.kwad.components.ad.reward.d.k kVar : this.oi) {
            kVar.a(rVar);
        }
    }

    public static d fm() {
        return a.ol;
    }

    public final void a(com.kwad.components.ad.reward.d.k kVar) {
        if (kVar != null) {
            this.oi.add(kVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.k kVar) {
        this.oi.remove(kVar);
    }

    public final void c(final r rVar) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(rVar);
            }
        });
    }
}
