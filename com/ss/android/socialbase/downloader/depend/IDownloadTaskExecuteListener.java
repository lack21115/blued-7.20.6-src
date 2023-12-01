package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/depend/IDownloadTaskExecuteListener.class */
public interface IDownloadTaskExecuteListener {
    void onFinish(DownloadTask downloadTask, int i);

    void onStart(DownloadTask downloadTask, int i);
}
