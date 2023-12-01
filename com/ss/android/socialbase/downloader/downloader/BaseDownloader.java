package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/BaseDownloader.class */
public class BaseDownloader {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    private File getGlobalSaveDir(String str, boolean z) {
        File file;
        File file2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            file = new File(str);
            try {
            } catch (Throwable th) {
                file2 = file;
                return file2;
            }
        } catch (Throwable th2) {
            file = null;
        }
        if (!file.exists()) {
            file.mkdirs();
            return file;
        }
        file2 = file;
        if (!file.isDirectory()) {
            if (z) {
                file.delete();
                file.mkdirs();
                return file;
            }
            return null;
        }
        return file2;
    }

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.MAIN, false);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.SUB, false);
    }

    public boolean canResume(int i) {
        return DownloadProcessDispatcher.getInstance().canResume(i);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void cancel(int i, boolean z) {
        DownloadProcessDispatcher.getInstance().cancel(i, z);
    }

    public void clearDownloadData(int i) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(i, true);
    }

    public void clearDownloadData(int i, boolean z) {
        DownloadProcessDispatcher.getInstance().clearDownloadData(i, z);
    }

    public void destoryDownloader() {
        DownloadComponentManager.unRegisterDownloadReceiver();
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        DownloadProcessDispatcher.getInstance().forceDownloadIngoreRecommendSize(i);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return DownloadProcessDispatcher.getInstance().getAllDownloadInfo();
    }

    public long getCurBytes(int i) {
        return DownloadProcessDispatcher.getInstance().getCurBytes(i);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return DownloadProcessDispatcher.getInstance().getDownloadFileUriProvider(i);
    }

    public int getDownloadId(String str, String str2) {
        return DownloadProcessDispatcher.getInstance().getDownloadId(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfo(str, str2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return DownloadProcessDispatcher.getInstance().getDownloadInfoList(str);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        return DownloadProcessDispatcher.getInstance().getDownloadNotificationEventListener(i);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getDownloadingDownloadInfosWithMimeType(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getFailedDownloadInfosWithMimeType(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return DownloadComponentManager.getReserveWifiStatusListener();
    }

    public int getStatus(int i) {
        return DownloadProcessDispatcher.getInstance().getStatus(i);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getSuccessedDownloadInfosWithMimeType(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return DownloadProcessDispatcher.getInstance().getUnCompletedDownloadInfosWithMimeType(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return DownloadProcessDispatcher.getInstance().isDownloadCacheSyncSuccess();
    }

    public boolean isDownloadServiceForeground(int i) {
        return DownloadProcessDispatcher.getInstance().getDownloadHandler(i).isServiceForeground();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return DownloadProcessDispatcher.getInstance().isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    public boolean isDownloading(int i) {
        boolean isDownloading;
        if (DownloadExpSwitchCode.isSwitchEnable(4194304)) {
            synchronized (this) {
                isDownloading = DownloadProcessDispatcher.getInstance().isDownloading(i);
            }
            return isDownloading;
        }
        return DownloadProcessDispatcher.getInstance().isDownloading(i);
    }

    public boolean isHttpServiceInit() {
        return DownloadProcessDispatcher.getInstance().isHttpServiceInit();
    }

    public void pause(int i) {
        DownloadProcessDispatcher.getInstance().pause(i);
    }

    public void pauseAll() {
        DownloadProcessDispatcher.getInstance().pauseAll();
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadProcessDispatcher.getInstance().registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        DownloadProcessDispatcher.getInstance().registerDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, ListenerType.MAIN, false);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, iDownloadListener, ListenerType.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, ListenerType.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, ListenerType.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        DownloadProcessDispatcher.getInstance().removeDownloadListener(i, null, ListenerType.SUB, true);
    }

    public void restart(int i) {
        DownloadProcessDispatcher.getInstance().restart(i);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        DownloadProcessDispatcher.getInstance().restartAllFailedDownloadTasks(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        DownloadProcessDispatcher.getInstance().restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    public void resume(int i) {
        DownloadProcessDispatcher.getInstance().resume(i);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (!DownloadExpSwitchCode.isSwitchEnable(4194304)) {
            DownloadComponentManager.setDownloadInMultiProcess();
            return;
        }
        synchronized (this) {
            DownloadComponentManager.setDownloadInMultiProcess();
        }
    }

    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        DownloadProcessDispatcher.getInstance().setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    public void setLogLevel(int i) {
        DownloadProcessDispatcher.getInstance().setLogLevel(i);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.MAIN, true);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.MAIN, true, z);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        DownloadComponentManager.setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        DownloadProcessDispatcher.getInstance().addDownloadListener(i, iDownloadListener, ListenerType.SUB, true);
    }

    public void setThrottleNetSpeed(int i, long j) {
        DownloadProcessDispatcher.getInstance().setThrottleNetSpeed(i, j);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        DownloadProcessDispatcher.getInstance().unRegisterDownloaderProcessConnectedListener(iDownloaderProcessConnectedListener);
    }
}
