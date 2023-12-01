package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/i.class */
public final class i extends a {
    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        try {
            this.qt.oN.jH().jB();
        } catch (Throwable th) {
            bi.postOnUiThread(new aw() { // from class: com.kwad.components.ad.reward.presenter.i.1
                @Override // com.kwad.sdk.utils.aw
                public final void doTask() {
                    com.kwad.sdk.crash.b.g(th);
                    i.this.hq();
                }
            });
        }
    }
}
