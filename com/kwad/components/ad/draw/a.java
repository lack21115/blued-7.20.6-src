package com.kwad.components.ad.draw;

import android.content.Context;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a.class */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.a.b {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.a.b.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.a.b
    public final void loadDrawAd(KsScene ksScene, KsLoadManager.DrawAdListener drawAdListener) {
        d.loadDrawAd(ksScene, drawAdListener);
    }
}
