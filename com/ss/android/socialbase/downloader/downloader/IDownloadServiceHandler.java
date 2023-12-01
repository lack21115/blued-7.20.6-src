package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/IDownloadServiceHandler.class */
public interface IDownloadServiceHandler<T extends DownloadService> {
    boolean isServiceAlive();

    boolean isServiceForeground();

    IBinder onBind(Intent intent);

    void onDestroy();

    void onStartCommand(Intent intent, int i, int i2);

    void onStartCommandOnMainThread();

    void pendDownloadTask(DownloadTask downloadTask);

    void setDownloadService(WeakReference<T> weakReference);

    void setLogLevel(int i);

    void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener);

    void startForeground(int i, Notification notification);

    void startService();

    void stopForeground(boolean z);

    void tryDownload(DownloadTask downloadTask);

    void tryDownloadWithEngine(DownloadTask downloadTask);
}
