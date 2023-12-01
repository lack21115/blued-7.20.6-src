package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.constants.RetryDelayStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DownloadRunnable;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/AbsDownloadEngine.class */
public abstract class AbsDownloadEngine implements WeakDownloadHandler.IHandler {
    private static final String TAG = "AbsDownloadEngine";
    private final SparseArray<DownloadTask> downloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> successDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> failedDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> retryDelayDownloadTaskMap = new SparseArray<>();
    private final SparseArray<DownloadTask> waitingAsyncDownloadTaskMap = new SparseArray<>();
    private final SparseArray<SparseArray<DownloadTask>> downloadTaskWithListenerMap = new SparseArray<>();
    private final LruCache<Integer, DownloadTask> pengingTaskCache = new LruCache<>();
    private final SparseArray<Long> lastTaskTryDownloadTime = new SparseArray<>();
    private final LinkedBlockingDeque<DownloadTask> orderedTaskQueue = new LinkedBlockingDeque<>();
    protected final WeakDownloadHandler mainHandler = new WeakDownloadHandler(Looper.getMainLooper(), this);
    private final IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();

    private void cancelAlarm(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != RetryDelayStatus.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(RetryDelayStatus.DELAY_RETRY_NONE);
                    Logger.d(TAG, "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDownloadDataInSubThread(int i, boolean z) {
        synchronized (this) {
            Logger.d(TAG, "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                if (z) {
                    DownloadUtils.deleteAllDownloadFiles(downloadInfo);
                } else {
                    DownloadUtils.deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
                }
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeDownloadTaskData(i);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            refreshDownloadTaskMap(i, 0, -4);
            if (this.failedDownloadTaskMap.get(i) != null) {
                this.failedDownloadTaskMap.remove(i);
            }
            if (this.successDownloadTaskMap.get(i) != null) {
                this.successDownloadTaskMap.remove(i);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i));
            DownloadSetting.removeTaskDownloadSetting(i);
        }
    }

    private void enqueue(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.orderedTaskQueue.isEmpty()) {
                tryDownload(downloadTask, true);
                this.orderedTaskQueue.put(downloadTask);
            } else if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_TAIL) {
                DownloadTask first = this.orderedTaskQueue.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
                    return;
                }
                pause(first.getDownloadId());
                tryDownload(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.orderedTaskQueue.putFirst(downloadTask);
                }
            } else if (this.orderedTaskQueue.getFirst().getDownloadId() == downloadTask.getDownloadId() && isDownloading(downloadTask.getDownloadId())) {
            } else {
                Iterator<DownloadTask> it = this.orderedTaskQueue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.orderedTaskQueue.put(downloadTask);
                new DownloadStatusHandler(downloadTask, this.mainHandler).onPrepare();
            }
        } catch (InterruptedException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask getDownloadTask(int i) {
        DownloadTask downloadTask = this.downloadTaskMap.get(i);
        DownloadTask downloadTask2 = downloadTask;
        if (downloadTask == null) {
            DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
            downloadTask2 = downloadTask3;
            if (downloadTask3 == null) {
                DownloadTask downloadTask4 = this.successDownloadTaskMap.get(i);
                downloadTask2 = downloadTask4;
                if (downloadTask4 == null) {
                    DownloadTask downloadTask5 = this.retryDelayDownloadTaskMap.get(i);
                    downloadTask2 = downloadTask5;
                    if (downloadTask5 == null) {
                        downloadTask2 = this.waitingAsyncDownloadTaskMap.get(i);
                    }
                }
            }
        }
        return downloadTask2;
    }

    private boolean isPauseReserveOnWifi(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    private void notifyDownloadTaskStatus(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(ListenerType.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            DownloadListenerUtils.notifyListener(i, downloadListeners, true, downloadInfo, baseException);
            DownloadListenerUtils.notifyListener(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void removeTask(int i, int i2) {
        Logger.d(TAG, "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.downloadTaskMap.remove(i);
            this.downloadTaskWithListenerMap.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i);
        if (sparseArray == null) {
            this.downloadTaskMap.remove(i);
            return;
        }
        sparseArray.remove(i2);
        Logger.d(TAG, "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
        if (sparseArray.size() == 0) {
            this.downloadTaskMap.remove(i);
            this.downloadTaskWithListenerMap.remove(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDownloadDataInSubThread(int i, boolean z) {
        try {
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo != null) {
                DownloadUtils.deleteAllDownloadFiles(downloadInfo, z);
                downloadInfo.erase();
            }
            try {
                this.downloadCache.removeAllDownloadChunk(i);
                this.downloadCache.updateDownloadInfo(downloadInfo);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            if (this.failedDownloadTaskMap.get(i) != null) {
                this.failedDownloadTaskMap.remove(i);
            }
            if (this.successDownloadTaskMap.get(i) != null) {
                this.successDownloadTaskMap.remove(i);
            }
            this.pengingTaskCache.remove(Integer.valueOf(i));
            DownloadSetting.removeTaskDownloadSetting(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void tryCacheSameTaskWithListenerHashCode(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        int i = hashCodeForSameTask;
        if (hashCodeForSameTask == 0) {
            i = hashCodeForSameTask;
            if (downloadTask.isAutoSetHashCodeForSameTask()) {
                i = downloadTask.autoCalAndGetHashCodeForSameTask();
            }
        }
        if (i == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(downloadTask.getDownloadId());
        SparseArray<DownloadTask> sparseArray2 = sparseArray;
        if (sparseArray == null) {
            sparseArray2 = new SparseArray<>();
            this.downloadTaskWithListenerMap.put(downloadTask.getDownloadId(), sparseArray2);
        }
        Logger.d(TAG, "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + i);
        sparseArray2.put(i, downloadTask);
    }

    private void tryDownload(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i;
        boolean z2;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
        } else if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.NO_NET_OPT, 0) == 1 && !DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) && !downloadInfo.isFirstDownload()) {
            new DownloadStatusHandler(downloadTask, this.mainHandler).onError(new BaseException(1049, "network_not_available"));
        } else {
            int id = downloadInfo.getId();
            if (z) {
                cancelAlarm(downloadInfo);
            }
            if (this.failedDownloadTaskMap.get(id) != null) {
                this.failedDownloadTaskMap.remove(id);
            }
            if (this.successDownloadTaskMap.get(id) != null) {
                this.successDownloadTaskMap.remove(id);
            }
            if (this.retryDelayDownloadTaskMap.get(id) != null) {
                this.retryDelayDownloadTaskMap.remove(id);
            }
            if (this.waitingAsyncDownloadTaskMap.get(id) != null) {
                this.waitingAsyncDownloadTaskMap.remove(id);
            }
            if (isDownloading(id) && !downloadInfo.canReStartAsyncTask()) {
                Logger.d(TAG, "another task with same id is downloading when tryDownload");
                downloadTask.addListenerToDownloadingSameTask();
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
                return;
            }
            Logger.d(TAG, "no downloading task :" + id);
            if (downloadInfo.canReStartAsyncTask()) {
                downloadInfo.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
            }
            if (DownloadExpSwitchCode.isSwitchEnable(32768) && (remove = this.pengingTaskCache.remove(Integer.valueOf(id))) != null) {
                downloadTask.copyListenerFromPendingTask(remove);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            DownloadTask downloadTask2 = this.downloadTaskMap.get(id);
            if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
                i = 0;
                z2 = false;
            } else {
                int status = downloadInfo2.getStatus();
                z2 = false;
                i = status;
                if (DownloadStatus.isDownloading(status)) {
                    z2 = true;
                    i = status;
                }
            }
            Logger.d(TAG, "can add listener " + z2 + " , oldTaskStatus is :" + i);
            if (z2) {
                downloadTask.addListenerToDownloadingSameTask();
                return;
            }
            tryCacheSameTaskWithListenerHashCode(downloadTask);
            this.downloadTaskMap.put(id, downloadTask);
            this.lastTaskTryDownloadTime.put(id, Long.valueOf(uptimeMillis));
            doDownload(id, downloadTask);
        }
    }

    private void tryDownloadNextTaskInQueue(int i) {
        DownloadTask first;
        if (this.orderedTaskQueue.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.orderedTaskQueue.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.orderedTaskQueue.poll();
        }
        if (this.orderedTaskQueue.isEmpty() || (first = this.orderedTaskQueue.getFirst()) == null) {
            return;
        }
        tryDownload(first, true);
    }

    public void addDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        synchronized (this) {
            addDownloadListener(i, i2, iDownloadListener, listenerType, z, true);
        }
    }

    public void addDownloadListener(int i, int i2, final IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            DownloadTask downloadTask = getDownloadTask(i);
            if (downloadTask != null) {
                downloadTask.addDownloadListener(i2, iDownloadListener, listenerType, z);
                final DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
                if (z2 && downloadInfo2 != null && !isDownloading(i) && (listenerType == ListenerType.MAIN || listenerType == ListenerType.NOTIFICATION)) {
                    boolean z3 = true;
                    if (listenerType == ListenerType.NOTIFICATION) {
                        z3 = true;
                        if (!downloadInfo2.canShowNotification()) {
                            z3 = false;
                        }
                    }
                    if (z3) {
                        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.6
                            @Override // java.lang.Runnable
                            public void run() {
                                if (iDownloadListener != null) {
                                    if (downloadInfo2.getStatus() == -3) {
                                        iDownloadListener.onSuccessed(downloadInfo2);
                                    } else if (downloadInfo2.getStatus() == -1) {
                                        iDownloadListener.onFailed(downloadInfo2, new BaseException(1000, "try add listener for failed task"));
                                    }
                                }
                            }
                        });
                    }
                }
            } else if (DownloadExpSwitchCode.isSwitchEnable(32768) && (downloadInfo = this.downloadCache.getDownloadInfo(i)) != null && downloadInfo.getStatus() != -3) {
                DownloadTask downloadTask2 = this.pengingTaskCache.get(Integer.valueOf(i));
                DownloadTask downloadTask3 = downloadTask2;
                if (downloadTask2 == null) {
                    downloadTask3 = new DownloadTask(downloadInfo);
                    this.pengingTaskCache.put(Integer.valueOf(i), downloadTask3);
                }
                downloadTask3.addDownloadListener(i2, iDownloadListener, listenerType, z);
            }
        }
    }

    public boolean cancel(int i, boolean z) {
        synchronized (this) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            DownloadTask downloadTask2 = downloadTask;
            if (downloadTask == null) {
                downloadTask2 = downloadTask;
                if (DownloadExpSwitchCode.isSwitchEnable(65536)) {
                    downloadTask2 = getDownloadTask(i);
                }
            }
            if (downloadTask2 != null) {
                if (!DownloadSetting.obtain(i).optBugFix(DownloadSettingKeys.BugFix.FIX_ON_CANCEL_CALL_TWICE, true)) {
                    new DownloadStatusHandler(downloadTask2, this.mainHandler).onCancel();
                }
                final DownloadInfo downloadInfo = downloadTask2.getDownloadInfo();
                final SparseArray<IDownloadListener> downloadListeners = downloadTask2.getDownloadListeners(ListenerType.MAIN);
                final SparseArray<IDownloadListener> downloadListeners2 = downloadTask2.getDownloadListeners(ListenerType.NOTIFICATION);
                this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SparseArray sparseArray;
                        SparseArray sparseArray2 = downloadListeners;
                        if (sparseArray2 != null) {
                            synchronized (sparseArray2) {
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 >= downloadListeners.size()) {
                                        break;
                                    }
                                    IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i3));
                                    if (iDownloadListener != null) {
                                        iDownloadListener.onCanceled(downloadInfo);
                                    }
                                    i2 = i3 + 1;
                                }
                            }
                        }
                        DownloadInfo downloadInfo2 = downloadInfo;
                        if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                            return;
                        }
                        synchronized (sparseArray) {
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 < downloadListeners2.size()) {
                                    IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i5));
                                    if (iDownloadListener2 != null) {
                                        iDownloadListener2.onCanceled(downloadInfo);
                                    }
                                    i4 = i5 + 1;
                                }
                            }
                        }
                    }
                });
            }
            DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
            if (DownloadExpSwitchCode.isSwitchEnable(65536)) {
                if (downloadInfo2 != null) {
                    downloadInfo2.setStatus(-4);
                }
            } else if (downloadInfo2 != null && DownloadStatus.isDownloading(downloadInfo2.getStatus())) {
                downloadInfo2.setStatus(-4);
            }
            clearDownloadData(i, z);
        }
        return true;
    }

    public void clearDownloadData(final int i, final boolean z) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask downloadTask;
                if (AbsDownloadEngine.this.doCancel(i) == null && (downloadTask = AbsDownloadEngine.this.getDownloadTask(i)) != null) {
                    DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(ListenerType.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= downloadListeners.size()) {
                                    break;
                                }
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo2);
                                }
                                i2 = i3 + 1;
                            }
                        }
                    }
                }
                AbsDownloadEngine.this.clearDownloadDataInSubThread(i, z);
            }
        }, false);
    }

    protected abstract DownloadRunnable doCancel(int i);

    protected abstract void doDownload(int i, DownloadTask downloadTask);

    protected abstract void doPause(int i);

    public abstract void doSetThrottleNetSpeed(int i, long j);

    public void forceDownloadIgnoreRecommendSize(int i) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
                downloadInfo.setForceIgnoreRecommendSize(true);
                tryDownload(downloadTask);
            }
        }
    }

    protected abstract List<Integer> getAllAliveDownloadIds();

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        synchronized (this) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null) {
                return downloadTask.getFileUriProvider();
            }
            DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
            if (downloadTask2 != null) {
                return downloadTask2.getFileUriProvider();
            }
            DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
            if (downloadTask3 != null) {
                return downloadTask3.getFileUriProvider();
            }
            DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i);
            if (downloadTask4 != null) {
                return downloadTask4.getFileUriProvider();
            }
            DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i);
            if (downloadTask5 != null) {
                return downloadTask5.getFileUriProvider();
            }
            return null;
        }
    }

    public DownloadInfo getDownloadInfo(int i) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
            downloadInfo = downloadInfo2;
            if (downloadInfo2 == null) {
                DownloadTask downloadTask = this.downloadTaskMap.get(i);
                downloadInfo = downloadInfo2;
                if (downloadTask != null) {
                    downloadInfo = downloadTask.getDownloadInfo();
                }
            }
        }
        return downloadInfo;
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<DownloadInfo> downloadInfoList = this.downloadCache.getDownloadInfoList(str);
            if (downloadInfoList != null && !downloadInfoList.isEmpty()) {
                return downloadInfoList;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.downloadTaskMap.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return arrayList;
                }
                DownloadTask valueAt = this.downloadTaskMap.valueAt(i2);
                if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
                i = i2 + 1;
            }
        }
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        synchronized (this) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null) {
                return downloadTask.getNotificationEventListener();
            }
            DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
            if (downloadTask2 != null) {
                return downloadTask2.getNotificationEventListener();
            }
            DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
            if (downloadTask3 != null) {
                return downloadTask3.getNotificationEventListener();
            }
            DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i);
            if (downloadTask4 != null) {
                return downloadTask4.getNotificationEventListener();
            }
            DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i);
            if (downloadTask5 != null) {
                return downloadTask5.getNotificationEventListener();
            }
            return null;
        }
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : getAllAliveDownloadIds()) {
            DownloadInfo downloadInfo = getDownloadInfo(num.intValue());
            if (downloadInfo != null && str.equals(downloadInfo.getMimeType())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public INotificationClickCallback getNotificationClickCallback(int i) {
        synchronized (this) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null) {
                return downloadTask.getNotificationClickCallback();
            }
            DownloadTask downloadTask2 = this.successDownloadTaskMap.get(i);
            if (downloadTask2 != null) {
                return downloadTask2.getNotificationClickCallback();
            }
            DownloadTask downloadTask3 = this.failedDownloadTaskMap.get(i);
            if (downloadTask3 != null) {
                return downloadTask3.getNotificationClickCallback();
            }
            DownloadTask downloadTask4 = this.retryDelayDownloadTaskMap.get(i);
            if (downloadTask4 != null) {
                return downloadTask4.getNotificationClickCallback();
            }
            DownloadTask downloadTask5 = this.waitingAsyncDownloadTaskMap.get(i);
            if (downloadTask5 != null) {
                return downloadTask5.getNotificationClickCallback();
            }
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void handleMsg(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        Logger.d(TAG, "handleMsg id: " + i + " listener hasCode: " + i2);
        DownloadTask downloadTask = null;
        BaseException baseException = message.obj instanceof Exception ? (BaseException) message.obj : null;
        synchronized (this) {
            if (i2 == 0) {
                downloadTask = this.downloadTaskMap.get(i);
            } else {
                SparseArray<DownloadTask> sparseArray = this.downloadTaskWithListenerMap.get(i);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i2);
                }
            }
            if (downloadTask == null) {
                return;
            }
            notifyDownloadTaskStatus(message.what, baseException, downloadTask);
            refreshDownloadTaskMap(i, i2, message.what);
        }
    }

    public abstract boolean isDownloading(int i);

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r3.failedDownloadTaskMap.get(r4) != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isInDownloadTaskPool(int r4) {
        /*
            r3 = this;
            r0 = r3
            monitor-enter(r0)
            r0 = r4
            if (r0 == 0) goto L28
            r0 = r3
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r0.downloadTaskMap     // Catch: java.lang.Throwable -> L23
            r1 = r4
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L1e
            r0 = r3
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r0.failedDownloadTaskMap     // Catch: java.lang.Throwable -> L23
            r1 = r4
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L23
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L28
        L1e:
            r0 = 1
            r5 = r0
            goto L2a
        L23:
            r6 = move-exception
            r0 = r3
            monitor-exit(r0)
            r0 = r6
            throw r0
        L28:
            r0 = 0
            r5 = r0
        L2a:
            r0 = r3
            monitor-exit(r0)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.isInDownloadTaskPool(int):boolean");
    }

    public boolean pause(int i) {
        synchronized (this) {
            Logger.d(TAG, "pause id=" + i);
            DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo == null || downloadInfo.getStatus() != 11) {
                synchronized (this.downloadTaskMap) {
                    doPause(i);
                }
                if (downloadInfo == null) {
                    DownloadTask downloadTask = this.downloadTaskMap.get(i);
                    if (downloadTask != null) {
                        new DownloadStatusHandler(downloadTask, this.mainHandler).onPause();
                        return true;
                    }
                } else {
                    cancelAlarm(downloadInfo);
                    if (downloadInfo.getStatus() == 1) {
                        DownloadTask downloadTask2 = this.downloadTaskMap.get(i);
                        if (downloadTask2 != null) {
                            new DownloadStatusHandler(downloadTask2, this.mainHandler).onPause();
                            return true;
                        }
                    } else if (DownloadStatus.isDownloading(downloadInfo.getStatus())) {
                        downloadInfo.setStatus(-2);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public void refreshDownloadTaskMap(int i, int i2, int i3) {
        synchronized (this) {
            if (i3 != -7) {
                if (i3 == -6) {
                    this.successDownloadTaskMap.put(i, this.downloadTaskMap.get(i));
                    removeTask(i, i2);
                } else if (i3 == -4) {
                    removeTask(i, i2);
                    tryDownloadNextTaskInQueue(i);
                } else if (i3 == -3) {
                    this.successDownloadTaskMap.put(i, this.downloadTaskMap.get(i));
                    removeTask(i, i2);
                    tryDownloadNextTaskInQueue(i);
                } else if (i3 != -1) {
                    if (i3 == 7) {
                        DownloadTask downloadTask = this.downloadTaskMap.get(i);
                        if (downloadTask != null) {
                            if (this.retryDelayDownloadTaskMap.get(i) == null) {
                                this.retryDelayDownloadTaskMap.put(i, downloadTask);
                            }
                            removeTask(i, i2);
                        }
                        tryDownloadNextTaskInQueue(i);
                    } else if (i3 == 8) {
                        DownloadTask downloadTask2 = this.downloadTaskMap.get(i);
                        if (downloadTask2 != null && this.waitingAsyncDownloadTaskMap.get(i) == null) {
                            this.waitingAsyncDownloadTaskMap.put(i, downloadTask2);
                        }
                        tryDownloadNextTaskInQueue(i);
                    }
                }
            }
            DownloadTask downloadTask3 = this.downloadTaskMap.get(i);
            if (downloadTask3 != null) {
                if (this.failedDownloadTaskMap.get(i) == null) {
                    this.failedDownloadTaskMap.put(i, downloadTask3);
                }
                removeTask(i, i2);
            }
            tryDownloadNextTaskInQueue(i);
        }
    }

    public void removeDownloadListener(int i, int i2, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        synchronized (this) {
            DownloadTask downloadTask = getDownloadTask(i);
            DownloadTask downloadTask2 = downloadTask;
            if (downloadTask == null) {
                downloadTask2 = this.pengingTaskCache.get(Integer.valueOf(i));
            }
            if (downloadTask2 != null) {
                downloadTask2.removeDownloadListener(i2, iDownloadListener, listenerType, z);
            }
        }
    }

    public abstract void removeDownloadRunnable(DownloadRunnable downloadRunnable);

    public void resetDownloadData(final int i, final boolean z) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            cancelAlarm(downloadInfo);
        }
        this.mainHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.4
            @Override // java.lang.Runnable
            public void run() {
                DownloadNotificationManager.getInstance().cancelNotification(i);
            }
        });
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.5
            @Override // java.lang.Runnable
            public void run() {
                AbsDownloadEngine.this.doCancel(i);
                AbsDownloadEngine.this.resetDownloadDataInSubThread(i, z);
            }
        }, false);
    }

    public boolean restart(int i) {
        synchronized (this) {
            DownloadTask downloadTask = this.failedDownloadTaskMap.get(i);
            DownloadTask downloadTask2 = downloadTask;
            if (downloadTask == null) {
                downloadTask2 = this.retryDelayDownloadTaskMap.get(i);
            }
            if (downloadTask2 != null) {
                DownloadInfo downloadInfo = downloadTask2.getDownloadInfo();
                if (downloadInfo != null) {
                    downloadInfo.setDownloadFromReserveWifi(false);
                }
                tryDownload(downloadTask2);
                return true;
            }
            return false;
        }
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            try {
                boolean isWifi = DownloadExpSwitchCode.isSwitchEnable(1048576) ? DownloadUtils.isWifi(DownloadComponentManager.getAppContext()) : true;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.failedDownloadTaskMap.size()) {
                        break;
                    }
                    DownloadTask downloadTask = this.failedDownloadTaskMap.get(this.failedDownloadTaskMap.keyAt(i2));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || isWifi)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        tryDownload(downloadTask);
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (DownloadUtils.isWifi(DownloadComponentManager.getAppContext())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.downloadTaskMap.size()) {
                        break;
                    }
                    DownloadTask downloadTask = this.downloadTaskMap.get(this.downloadTaskMap.keyAt(i2));
                    if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && isPauseReserveOnWifi(downloadInfo)) {
                        downloadInfo.setAutoResumed(true);
                        downloadInfo.setShowNotificationForNetworkResumed(true);
                        tryDownload(downloadTask);
                        downloadInfo.setDownloadFromReserveWifi(true);
                        IReserveWifiStatusListener reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
                        if (reserveWifiStatusListener != null) {
                            reserveWifiStatusListener.onStatusChanged(downloadInfo, 5, 2);
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public boolean restartAsyncWaitingTask(int i) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            DownloadTask downloadTask = this.waitingAsyncDownloadTaskMap.get(i);
            if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
                return false;
            }
            if (downloadInfo.canReStartAsyncTask()) {
                tryDownload(downloadTask);
            }
            return true;
        }
    }

    public boolean resume(int i) {
        synchronized (this) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null) {
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                if (downloadInfo != null) {
                    downloadInfo.setDownloadFromReserveWifi(false);
                }
                tryDownload(downloadTask);
            } else {
                restart(i);
            }
        }
        return true;
    }

    public boolean retryDelayStart(int i) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            DownloadTask downloadTask = this.retryDelayDownloadTaskMap.get(i);
            if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
                if (downloadInfo.canStartRetryDelayTask()) {
                    tryDownload(downloadTask, false);
                }
                return true;
            }
            DownloadInfo downloadInfo2 = this.downloadCache.getDownloadInfo(i);
            if (downloadInfo2 != null && downloadInfo2.canStartRetryDelayTask()) {
                tryDownload(new DownloadTask(downloadInfo2), false);
            }
            return false;
        }
    }

    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        synchronized (this) {
            DownloadTask downloadTask = this.downloadTaskMap.get(i);
            if (downloadTask != null) {
                downloadTask.setNotificationEventListener(iDownloadNotificationEventListener);
            }
        }
    }

    public void setThrottleNetSpeed(int i, long j) {
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setThrottleNetSpeed(j);
        }
        doSetThrottleNetSpeed(i, j);
    }

    public void shutDown() {
        List<Integer> allAliveDownloadIds = getAllAliveDownloadIds();
        if (allAliveDownloadIds == null) {
            return;
        }
        for (Integer num : allAliveDownloadIds) {
            pause(num.intValue());
        }
    }

    public void tryDownload(DownloadTask downloadTask) {
        synchronized (this) {
            if (downloadTask == null) {
                return;
            }
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            downloadInfo.setDownloadFromReserveWifi(false);
            if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
                enqueue(downloadTask);
            } else {
                tryDownload(downloadTask, true);
            }
        }
    }
}
