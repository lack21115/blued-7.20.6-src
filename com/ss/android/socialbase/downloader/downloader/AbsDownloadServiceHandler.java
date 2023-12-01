package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/AbsDownloadServiceHandler.class */
public abstract class AbsDownloadServiceHandler implements IDownloadServiceHandler {
    private static final String TAG = AbsDownloadServiceHandler.class.getSimpleName();
    private WeakReference<Service> downloadService;
    protected volatile boolean isServiceForeground;
    protected final SparseArray<List<DownloadTask>> pendingTasks = new SparseArray<>();
    protected volatile boolean isServiceAlive = false;
    protected volatile boolean isInvokeStartService = false;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable debounceStartServiceRunnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler.1
        @Override // java.lang.Runnable
        public void run() {
            if (Logger.debug()) {
                Logger.d(AbsDownloadServiceHandler.TAG, "tryDownload: 2 try");
            }
            if (AbsDownloadServiceHandler.this.isServiceAlive) {
                return;
            }
            if (Logger.debug()) {
                Logger.d(AbsDownloadServiceHandler.TAG, "tryDownload: 2 error");
            }
            AbsDownloadServiceHandler.this.startService(DownloadComponentManager.getAppContext(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceAlive() {
        return this.isServiceAlive;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public boolean isServiceForeground() {
        String str = TAG;
        Logger.i(str, "isServiceForeground = " + this.isServiceForeground);
        return this.isServiceForeground;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public IBinder onBind(Intent intent) {
        Logger.d(TAG, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onDestroy() {
        this.isServiceAlive = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void pendDownloadTask(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.pendingTasks) {
            String str = TAG;
            Logger.d(str, "pendDownloadTask pendingTasks.size:" + this.pendingTasks.size() + " downloadId:" + downloadId);
            List<DownloadTask> list = this.pendingTasks.get(downloadId);
            ArrayList arrayList = list;
            if (list == null) {
                arrayList = new ArrayList();
                this.pendingTasks.put(downloadId, arrayList);
            }
            String str2 = TAG;
            Logger.d(str2, "before pendDownloadTask taskArray.size:" + arrayList.size());
            arrayList.add(downloadTask);
            String str3 = TAG;
            Logger.d(str3, "after pendDownloadTask pendingTasks.size:" + this.pendingTasks.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resumePendingTask() {
        SparseArray<List<DownloadTask>> m1029clone;
        synchronized (this.pendingTasks) {
            String str = TAG;
            Logger.d(str, "resumePendingTask pendingTasks.size:" + this.pendingTasks.size());
            m1029clone = this.pendingTasks.m1029clone();
            this.pendingTasks.clear();
        }
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m1029clone.size()) {
                return;
            }
            List<DownloadTask> list = m1029clone.get(m1029clone.keyAt(i2));
            if (list != null) {
                for (DownloadTask downloadTask : list) {
                    String str2 = TAG;
                    Logger.d(str2, "resumePendingTask key:" + downloadTask.getDownloadId());
                    downloadEngine.tryDownload(downloadTask);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setDownloadService(WeakReference weakReference) {
        this.downloadService = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setLogLevel(int i) {
        Logger.setLogLevel(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void setServiceConnectionListener(IDownloadServiceConnectionListener iDownloadServiceConnectionListener) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startForeground(int i, Notification notification) {
        WeakReference<Service> weakReference = this.downloadService;
        if (weakReference == null || weakReference.get() == null) {
            Logger.w(TAG, "startForeground: downloadService is null, do nothing!");
            return;
        }
        String str = TAG;
        Logger.i(str, "startForeground  id = " + i + ", service = " + this.downloadService.get() + ",  isServiceAlive = " + this.isServiceAlive);
        try {
            this.downloadService.get().startForeground(i, notification);
            this.isServiceForeground = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void startService() {
        if (this.isServiceAlive) {
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "startService");
        }
        startService(DownloadComponentManager.getAppContext(), null);
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void stopForeground(boolean z) {
        WeakReference<Service> weakReference = this.downloadService;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = TAG;
        Logger.i(str, "stopForeground  service = " + this.downloadService.get() + ",  isServiceAlive = " + this.isServiceAlive);
        try {
            this.isServiceForeground = false;
            this.downloadService.get().stopForeground(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownload(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (this.isServiceAlive) {
            Logger.d(TAG, "tryDownload when isServiceAlive");
            resumePendingTask();
            AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
            if (downloadEngine != null) {
                String str = TAG;
                Logger.d(str, "tryDownload current task: " + downloadTask.getDownloadId());
                downloadEngine.tryDownload(downloadTask);
                return;
            }
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "tryDownload but service is not alive");
        }
        if (!DownloadExpSwitchCode.isSwitchEnable(262144)) {
            pendDownloadTask(downloadTask);
            startService(DownloadComponentManager.getAppContext(), null);
            return;
        }
        pendDownloadTask(downloadTask);
        if (this.isInvokeStartService) {
            this.handler.removeCallbacks(this.debounceStartServiceRunnable);
            this.handler.postDelayed(this.debounceStartServiceRunnable, 10L);
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "tryDownload: 1");
        }
        startService(DownloadComponentManager.getAppContext(), null);
        this.isInvokeStartService = true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void tryDownloadWithEngine(DownloadTask downloadTask) {
    }
}
