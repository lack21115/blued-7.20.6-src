package com.kwad.components.ad.a;

import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/a/f.class */
public interface f extends com.kwad.sdk.components.a {
    void loadNativeAd(KsScene ksScene, KsLoadManager.NativeAdListener nativeAdListener);

    void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener);
}
