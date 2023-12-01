package com.kwad.components.ad.reward.f;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/f/b.class */
public final class b extends aw implements aw.a {
    private PlayableSource rN;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.rN = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.aw.a
    public final boolean dC() {
        com.kwad.components.ad.reward.b.ff().c(this.rN, new a(this.mContext));
        return false;
    }
}
