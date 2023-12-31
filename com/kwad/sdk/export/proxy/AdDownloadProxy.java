package com.kwad.sdk.export.proxy;

import android.content.Context;
import com.kwad.sdk.core.download.DownloadParams;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/export/proxy/AdDownloadProxy.class */
public interface AdDownloadProxy {
    void cancelDownload(Context context, String str, DownloadParams downloadParams);

    String getDownloadFilePath(DownloadParams downloadParams);

    void pauseDownload(Context context, String str, DownloadParams downloadParams);

    void startDownload(Context context, String str, DownloadParams downloadParams);
}
