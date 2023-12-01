package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/e/a.class */
public abstract class a extends com.kwad.sdk.core.download.kwai.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;

    public a(Context context, AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mContext = context;
    }

    private void ae(int i) {
        String a2 = com.kwad.sdk.core.response.a.b.cY(this.mAdInfo) ? com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, i) : com.kwad.sdk.core.response.a.b.dc(this.mAdInfo) ? com.kwad.components.ad.splashscreen.d.c(this.mAdInfo, i) : com.kwad.components.ad.splashscreen.d.a(this.mAdInfo, i);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        ac(a2);
    }

    protected abstract void ac(String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        ae(7);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        ae(8);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        ae(0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        ae(12);
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        ae(4);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        ae(2);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
