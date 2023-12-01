package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.b;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/GlobalImageListener.class */
public class GlobalImageListener implements OnRenderResultListener<AdTemplate> {
    @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
    public void onRenderResult(boolean z, AdTemplate adTemplate, String str, String str2) {
        if (!z) {
            ((b) ServiceProvider.get(b.class)).n(str, str2);
        }
        if (z) {
            return;
        }
        ((b) ServiceProvider.get(b.class)).W(adTemplate);
    }
}
