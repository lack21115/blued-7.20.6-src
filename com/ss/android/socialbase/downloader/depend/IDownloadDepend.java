package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/depend/IDownloadDepend.class */
public interface IDownloadDepend {
    void monitorLogSend(DownloadInfo downloadInfo, BaseException baseException, int i);
}
