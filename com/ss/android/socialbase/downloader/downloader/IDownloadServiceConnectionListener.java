package com.ss.android.socialbase.downloader.downloader;

import android.os.IBinder;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/IDownloadServiceConnectionListener.class */
public interface IDownloadServiceConnectionListener {
    void onServiceConnection(IBinder iBinder);

    void onServiceDisConnection();
}
