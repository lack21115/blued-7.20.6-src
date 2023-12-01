package com.ss.android.socialbase.downloader.thread;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/DownloadThreadPool.class */
public class DownloadThreadPool {
    private static ExecutorService executorService = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("Download_OP_Thread"));
    private int clearTimes = 0;
    private volatile SparseArray<DownloadRunnable> downloadRunnablePool = new SparseArray<>();

    private void clearRunnableNotAlive() {
        int i;
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = 0;
                if (i3 >= this.downloadRunnablePool.size()) {
                    break;
                }
                int keyAt = this.downloadRunnablePool.keyAt(i3);
                if (!this.downloadRunnablePool.get(keyAt).isAlive()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
                i2 = i3 + 1;
            }
            while (true) {
                if (i >= arrayList.size()) {
                    return;
                }
                Integer num = (Integer) arrayList.get(i);
                if (num != null) {
                    this.downloadRunnablePool.remove(num.intValue());
                }
                i++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void executeOP(Runnable runnable) {
        executorService.execute(runnable);
    }

    private void removeFromThreadPool(DownloadRunnable downloadRunnable) {
        Future future;
        if (downloadRunnable == null) {
            return;
        }
        try {
            ExecutorService mixDefaultThreadExecutor = DownloadComponentManager.getMixDefaultThreadExecutor();
            DownloadTask downloadTask = downloadRunnable.getDownloadTask();
            ExecutorService executorService2 = mixDefaultThreadExecutor;
            if (downloadTask != null) {
                executorService2 = mixDefaultThreadExecutor;
                if (downloadTask.getDownloadInfo() != null) {
                    int executorGroup = downloadTask.getDownloadInfo().getExecutorGroup();
                    executorService2 = executorGroup != 3 ? executorGroup != 4 ? mixDefaultThreadExecutor : DownloadComponentManager.getMixApkThreadExecutor() : DownloadComponentManager.getMixFrequentThreadExecutor();
                }
            }
            if (executorService2 == null || !(executorService2 instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorService2).remove(downloadRunnable);
            if (!DownloadSetting.obtain(downloadRunnable.getDownloadId()).optBugFix(DownloadSettingKeys.BugFix.BUGFIX_PAUSE_WITH_INTERRUPT, false) || (future = downloadRunnable.getFuture()) == null) {
                return;
            }
            future.cancel(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DownloadRunnable cancel(int i) {
        synchronized (DownloadThreadPool.class) {
            try {
                clearRunnableNotAlive();
                DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
                if (downloadRunnable != null) {
                    downloadRunnable.cancel();
                    removeFromThreadPool(downloadRunnable);
                    this.downloadRunnablePool.remove(i);
                    return downloadRunnable;
                }
                return null;
            } finally {
            }
        }
    }

    public boolean containsTask(int i) {
        synchronized (DownloadThreadPool.class) {
            try {
                if (this.downloadRunnablePool != null && this.downloadRunnablePool.size() > 0) {
                    DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
                    boolean z = false;
                    if (downloadRunnable != null) {
                        z = false;
                        if (downloadRunnable.isAlive()) {
                            z = true;
                        }
                    }
                    return z;
                }
                return false;
            } finally {
            }
        }
    }

    public void execute(DownloadRunnable downloadRunnable) {
        downloadRunnable.prepareDownload();
        synchronized (DownloadThreadPool.class) {
            try {
                if (this.clearTimes >= 500) {
                    clearRunnableNotAlive();
                    this.clearTimes = 0;
                } else {
                    this.clearTimes++;
                }
                this.downloadRunnablePool.put(downloadRunnable.getDownloadId(), downloadRunnable);
            } catch (Throwable th) {
                throw th;
            }
        }
        DownloadTask downloadTask = downloadRunnable.getDownloadTask();
        try {
            ExecutorService mixDefaultThreadExecutor = DownloadComponentManager.getMixDefaultThreadExecutor();
            ExecutorService executorService2 = mixDefaultThreadExecutor;
            if (downloadTask != null) {
                executorService2 = mixDefaultThreadExecutor;
                if (downloadTask.getDownloadInfo() != null) {
                    if (DownloadConstants.MIME_PLG.equals(downloadTask.getDownloadInfo().getMimeType()) && DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.DIVIDE_PLUGIN, 1) == 1) {
                        downloadTask.getDownloadInfo().safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_EXECUTOR, 3);
                    }
                    int executorGroup = downloadTask.getDownloadInfo().getExecutorGroup();
                    executorService2 = executorGroup != 3 ? executorGroup != 4 ? mixDefaultThreadExecutor : DownloadComponentManager.getMixApkThreadExecutor() : DownloadComponentManager.getMixFrequentThreadExecutor();
                }
            }
            if (executorService2 == null) {
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            } else if (DownloadSetting.obtain(downloadRunnable.getDownloadId()).optBugFix(DownloadSettingKeys.BugFix.BUGFIX_PAUSE_WITH_INTERRUPT, false)) {
                downloadRunnable.setFuture(executorService2.submit(downloadRunnable));
            } else {
                executorService2.execute(downloadRunnable);
            }
        } catch (Exception e) {
            if (downloadTask != null) {
                IDownloadMonitorDepend monitorDepend = downloadTask.getMonitorDepend();
                DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
                BaseException baseException = new BaseException(1003, DownloadUtils.getErrorMsgWithTagPrefix(e, "DownloadThreadPoolExecute"));
                int i = 0;
                if (downloadTask.getDownloadInfo() != null) {
                    i = downloadTask.getDownloadInfo().getStatus();
                }
                DownloadMonitorHelper.monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, i);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (downloadTask != null) {
                IDownloadMonitorDepend monitorDepend2 = downloadTask.getMonitorDepend();
                DownloadInfo downloadInfo2 = downloadTask.getDownloadInfo();
                BaseException baseException2 = new BaseException(1003, "execute OOM");
                int i2 = 0;
                if (downloadTask.getDownloadInfo() != null) {
                    i2 = downloadTask.getDownloadInfo().getStatus();
                }
                DownloadMonitorHelper.monitorSendWithTaskMonitor(monitorDepend2, downloadInfo2, baseException2, i2);
            }
            e2.printStackTrace();
        }
    }

    public List<Integer> getAllAliveDownloadIds() {
        ArrayList arrayList;
        synchronized (DownloadThreadPool.class) {
            try {
                clearRunnableNotAlive();
                arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < this.downloadRunnablePool.size()) {
                        DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(this.downloadRunnablePool.keyAt(i2));
                        if (downloadRunnable != null) {
                            arrayList.add(Integer.valueOf(downloadRunnable.getDownloadId()));
                        }
                        i = i2 + 1;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public void pause(int i) {
        synchronized (DownloadThreadPool.class) {
            try {
                clearRunnableNotAlive();
                DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
                if (downloadRunnable != null) {
                    downloadRunnable.pause();
                    removeFromThreadPool(downloadRunnable);
                    this.downloadRunnablePool.remove(i);
                }
            } finally {
            }
        }
    }

    public void removeUnAliveDownloadRunnable(DownloadRunnable downloadRunnable) {
        if (downloadRunnable == null) {
            return;
        }
        synchronized (DownloadThreadPool.class) {
            try {
                if (DownloadExpSwitchCode.isSwitchEnable(524288)) {
                    int indexOfValue = this.downloadRunnablePool.indexOfValue(downloadRunnable);
                    if (indexOfValue >= 0) {
                        this.downloadRunnablePool.removeAt(indexOfValue);
                    }
                } else {
                    this.downloadRunnablePool.remove(downloadRunnable.getDownloadId());
                }
            }
        }
    }

    public void setThrottleNetSpeed(int i, long j) {
        DownloadRunnable downloadRunnable = this.downloadRunnablePool.get(i);
        if (downloadRunnable != null) {
            downloadRunnable.setThrottleNetSpeed(j);
        }
    }
}
