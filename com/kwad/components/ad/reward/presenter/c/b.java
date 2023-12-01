package com.kwad.components.ad.reward.presenter.c;

import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.c.kwai.c;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/c/b.class */
public final class b extends com.kwad.components.ad.reward.presenter.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/c/b$a.class */
    public static final class a extends com.kwad.components.ad.reward.presenter.b {
        public a(AdInfo adInfo) {
            super(adInfo);
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int hr() {
            return R.id.ksad_blur_end_cover;
        }

        @Override // com.kwad.components.ad.reward.presenter.b
        public final int hs() {
            return 8;
        }
    }

    public b(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        if (z) {
            il();
        } else {
            im();
        }
    }

    private void il() {
        if (j.h(this.mAdInfo)) {
            a(new r());
        }
        a(new com.kwad.components.ad.reward.presenter.c.kwai.b());
        if (com.kwad.sdk.core.response.a.b.be(this.mAdTemplate)) {
            a(new c());
        }
        a(new a(this.mAdInfo));
        if (com.kwad.components.ad.reward.kwai.b.l(this.mAdInfo) || !com.kwad.sdk.core.response.a.a.aj(this.mAdInfo)) {
            return;
        }
        a(new com.kwad.components.ad.reward.presenter.c.kwai.a());
    }

    private void im() {
        a(new com.kwad.components.ad.reward.presenter.c.kwai.b());
        if (com.kwad.sdk.core.response.a.b.be(this.mAdTemplate)) {
            a(new c());
        }
        if (com.kwad.sdk.core.response.a.a.al(this.mAdInfo)) {
            a(new com.kwad.components.ad.reward.presenter.c.kwai.a());
        }
    }
}
