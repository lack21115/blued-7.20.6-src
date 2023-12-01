package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/c/a.class */
public final class a extends com.kwad.components.ad.splashscreen.kwai.a {
    @Override // com.kwad.components.ad.splashscreen.kwai.a
    public final KsFragment a(AdResultData adResultData, com.kwad.sdk.core.g.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return b.b(adResultData, bVar, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.splashscreen.kwai.a.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }
}
