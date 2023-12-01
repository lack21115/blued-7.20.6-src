package com.kwad.sdk.core.download.kwai;

import com.kwad.sdk.api.KsAppDownloadListener;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/download/kwai/a.class */
public abstract class a implements KsAppDownloadListener {
    public String downloadId;

    public a() {
    }

    public a(String str) {
        this.downloadId = str;
    }

    public final String nc() {
        return this.downloadId;
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    public void onPaused(int i) {
    }
}
