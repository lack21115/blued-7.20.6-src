package com.ss.android.download.api.download.mb;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/download/mb/mb.class */
public interface mb {
    void mb(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig);

    void mb(DownloadInfo downloadInfo);

    void mb(DownloadInfo downloadInfo, BaseException baseException, String str);

    void mb(DownloadInfo downloadInfo, String str);

    void ox(DownloadInfo downloadInfo, String str);
}
