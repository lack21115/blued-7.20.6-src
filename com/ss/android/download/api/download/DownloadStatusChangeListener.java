package com.ss.android.download.api.download;

import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/download/DownloadStatusChangeListener.class */
public interface DownloadStatusChangeListener {
    void onDownloadActive(DownloadShortInfo downloadShortInfo, int i);

    void onDownloadFailed(DownloadShortInfo downloadShortInfo);

    void onDownloadFinished(DownloadShortInfo downloadShortInfo);

    void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i);

    void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController);

    void onIdle();

    void onInstalled(DownloadShortInfo downloadShortInfo);
}
