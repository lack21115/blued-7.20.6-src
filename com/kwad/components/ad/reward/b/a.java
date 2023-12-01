package com.kwad.components.ad.reward.b;

import android.content.Context;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/b/a.class */
public class a {
    private static volatile a rl;
    private j qt;
    private b rm;
    private volatile boolean rn = false;
    private volatile boolean ro = false;
    private List<WeakReference<com.kwad.components.core.webview.jshandler.e>> rp = new CopyOnWriteArrayList();

    private a() {
    }

    public static a gQ() {
        if (rl == null) {
            synchronized (a.class) {
                try {
                    if (rl == null) {
                        rl = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return rl;
    }

    private boolean gS() {
        boolean z;
        synchronized (this) {
            if (this.rm != null) {
                if (this.rm.rt == b.rq) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public final void O(Context context) {
        boolean gS = gS();
        com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + gS + ", hadToast: " + this.ro);
        if (this.ro || !gS) {
            return;
        }
        this.ro = true;
        v.H(context, "恭喜获得第2份奖励");
    }

    public final void a(com.kwad.components.core.webview.jshandler.e eVar) {
        com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + eVar);
        if (eVar != null) {
            this.rp.add(new WeakReference<>(eVar));
        }
    }

    public final void a(AdTemplate adTemplate, b bVar) {
        synchronized (this) {
            if (adTemplate == null) {
                return;
            }
            com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
            this.rm = bVar;
            if (bVar.rt == b.rq && !this.rn) {
                this.rn = true;
                c.a(this.rm, KSRewardVideoActivityProxy.a.E(adTemplate.getUniqueId()));
                com.kwad.sdk.core.report.a.aC(adTemplate);
            }
            for (WeakReference<com.kwad.components.core.webview.jshandler.e> weakReference : this.rp) {
                if (weakReference.get() == null) {
                    this.rp.remove(weakReference);
                } else {
                    b gR = gR();
                    com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + gR.toJson().toString());
                    weakReference.get().a(gR);
                }
            }
        }
    }

    public final void d(AdTemplate adTemplate, int i) {
        synchronized (this) {
            com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
            if (this.qt != null && this.qt.fX() && i == b.STATUS_NONE) {
                com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
                return;
            }
            b gR = gQ().gR();
            gR.O(i);
            gQ().a(adTemplate, gR);
        }
    }

    public final b gR() {
        b bVar;
        synchronized (this) {
            if (this.rm == null) {
                b gU = c.gU();
                this.rm = gU;
                gU.rt = 0;
            }
            com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.rm.rt);
            bVar = this.rm;
        }
        return bVar;
    }

    public final void reset() {
        synchronized (this) {
            this.rm = null;
            this.ro = false;
            this.rn = false;
            this.qt = null;
        }
    }

    public final void setCallerContext(j jVar) {
        this.qt = jVar;
    }
}
