package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/depend/IDownloadExtListener.class */
public interface IDownloadExtListener extends IDownloadListener {
    void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo);
}
