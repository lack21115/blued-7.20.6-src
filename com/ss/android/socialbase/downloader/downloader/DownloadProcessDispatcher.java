package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/DownloadProcessDispatcher.class */
public class DownloadProcessDispatcher {
    private static volatile DownloadProcessDispatcher instance;
    private volatile SparseArray<Boolean> independentMap = new SparseArray<>();
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private volatile List<IDownloaderProcessConnectedListener> processConnectedListeners = new ArrayList();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private IDownloadProxy getDownloadHandler(DownloadTask downloadTask) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:322)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static DownloadProcessDispatcher getInstance() {
        if (instance == null) {
            synchronized (DownloadProcessDispatcher.class) {
                try {
                    instance = new DownloadProcessDispatcher();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private List<DownloadInfo> handleDownloadInfos(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sparseArray.size()) {
                return arrayList;
            }
            arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
            i = i2 + 1;
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.addDownloadListener(i, iDownloadListener.hashCode(), iDownloadListener, listenerType, z);
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z, boolean z2) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.addDownloadListener(i, iDownloadListener.hashCode(), iDownloadListener, listenerType, z, z2);
    }

    public boolean canResume(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.canResume(i);
    }

    public void cancel(int i, boolean z) {
        if (!DownloadUtils.isMainProcess()) {
            IDownloadProxy downloadHandler = getDownloadHandler(i);
            if (downloadHandler != null) {
                downloadHandler.cancel(i, z);
            }
            DownloadProxy.get(true).dispatchProcessCallback(2, i);
        } else if (DownloadExpSwitchCode.isSwitchEnable(8388608)) {
            IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
            if (iDownloadProxy != null) {
                iDownloadProxy.cancel(i, z);
            }
            IDownloadProxy iDownloadProxy2 = DownloadProxy.get(false);
            if (iDownloadProxy2 != null) {
                iDownloadProxy2.cancel(i, z);
            }
        } else {
            IDownloadProxy iDownloadProxy3 = DownloadProxy.get(false);
            if (iDownloadProxy3 != null) {
                iDownloadProxy3.cancel(i, z);
            }
            IDownloadProxy iDownloadProxy4 = DownloadProxy.get(true);
            if (iDownloadProxy4 != null) {
                iDownloadProxy4.cancel(i, z);
            }
        }
    }

    public void clearDownloadData(int i, boolean z) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.clearDownloadData(i, z);
    }

    public void dispatchDownloaderProcessConnectedEvent() {
        synchronized (this.processConnectedListeners) {
            for (IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener : this.processConnectedListeners) {
                if (iDownloaderProcessConnectedListener != null) {
                    iDownloaderProcessConnectedListener.onConnected();
                }
            }
        }
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.forceDownloadIngoreRecommendSize(i);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> allDownloadInfo = iDownloadProxy != null ? iDownloadProxy.getAllDownloadInfo() : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            list = iDownloadProxy2.getAllDownloadInfo();
        }
        return handleDownloadInfos(allDownloadInfo, list, sparseArray);
    }

    public long getCurBytes(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return 0L;
        }
        return downloadHandler.getCurBytes(i);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadFileUriProvider(i);
    }

    public IDownloadProxy getDownloadHandler(int i) {
        boolean z = true;
        if (getDownloadWithIndependentProcessStatus(i) != 1 || DownloadUtils.isDownloaderProcess()) {
            z = false;
        }
        return DownloadProxy.get(z);
    }

    public int getDownloadId(String str, String str2) {
        return DownloadComponentManager.getDownloadId(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadInfo(i);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        int downloadId = getDownloadId(str, str2);
        IDownloadProxy downloadHandler = getDownloadHandler(downloadId);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadInfo(downloadId);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        List<DownloadInfo> downloadInfoList = DownloadProxy.get(false).getDownloadInfoList(str);
        List<DownloadInfo> downloadInfoList2 = DownloadProxy.get(true).getDownloadInfoList(str);
        if (downloadInfoList == null && downloadInfoList2 == null) {
            return null;
        }
        if (downloadInfoList == null || downloadInfoList2 == null) {
            return downloadInfoList != null ? downloadInfoList : downloadInfoList2;
        }
        ArrayList arrayList = new ArrayList(downloadInfoList);
        arrayList.addAll(downloadInfoList2);
        return arrayList;
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getDownloadNotificationEventListener(i);
    }

    public int getDownloadWithIndependentProcessStatus(int i) {
        if (DownloadComponentManager.supportMultiProc()) {
            return (DownloadUtils.isDownloaderProcess() || !DownloadProxy.get(true).isServiceAlive()) ? getDownloadWithIndependentProcessStatusInner(i) : DownloadProxy.get(true).getDownloadWithIndependentProcessStatus(i);
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int getDownloadWithIndependentProcessStatusInner(int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> downloadingDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getDownloadingDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            list = iDownloadProxy2.getDownloadingDownloadInfosWithMimeType(str);
        }
        return handleDownloadInfos(downloadingDownloadInfosWithMimeType, list, sparseArray);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> failedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getFailedDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            list = iDownloadProxy2.getFailedDownloadInfosWithMimeType(str);
        }
        return handleDownloadInfos(failedDownloadInfosWithMimeType, list, sparseArray);
    }

    public INotificationClickCallback getNotificationClickCallback(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return null;
        }
        return downloadHandler.getNotificationClickCallback(i);
    }

    public int getStatus(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return 0;
        }
        return downloadHandler.getStatus(i);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> successedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getSuccessedDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            list = iDownloadProxy2.getSuccessedDownloadInfosWithMimeType(str);
        }
        return handleDownloadInfos(successedDownloadInfosWithMimeType, list, sparseArray);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        List<DownloadInfo> list = null;
        List<DownloadInfo> unCompletedDownloadInfosWithMimeType = iDownloadProxy != null ? iDownloadProxy.getUnCompletedDownloadInfosWithMimeType(str) : null;
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            list = iDownloadProxy2.getUnCompletedDownloadInfosWithMimeType(str);
        }
        return handleDownloadInfos(unCompletedDownloadInfosWithMimeType, list, sparseArray);
    }

    public boolean isDownloadCacheSyncSuccess() {
        boolean z = false;
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            z = iDownloadProxy.isDownloadCacheSyncSuccess();
        }
        return z;
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        IDownloadProxy downloadHandler;
        if (downloadInfo == null || (downloadHandler = getDownloadHandler(downloadInfo.getId())) == null) {
            return false;
        }
        return downloadHandler.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    public boolean isDownloading(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.isDownloading(i);
    }

    public boolean isHttpServiceInit() {
        return DownloadComponentManager.isHttpServiceInit();
    }

    public void pause(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.pause(i);
    }

    public void pauseAll() {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.pauseAll();
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.pauseAll();
        }
    }

    public void recordTaskProcessIndependent(int i) {
        if (i == 0) {
            return;
        }
        setDownloadIndependentProcessStatus(i, Boolean.TRUE.booleanValue());
        IDownloadProxy iDownloadProxy = DownloadProxy.get(true);
        if (iDownloadProxy == null) {
            return;
        }
        iDownloadProxy.startService();
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadComponentManager.registerDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        if (iDownloaderProcessConnectedListener == null) {
            return;
        }
        if (DownloadUtils.isDownloaderProcess()) {
            iDownloaderProcessConnectedListener.onConnected();
            return;
        }
        if (DownloadProxy.get(true).isServiceAlive()) {
            iDownloaderProcessConnectedListener.onConnected();
        }
        synchronized (this.processConnectedListeners) {
            if (!this.processConnectedListeners.contains(iDownloaderProcessConnectedListener)) {
                this.processConnectedListeners.add(iDownloaderProcessConnectedListener);
            }
        }
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.removeDownloadListener(i, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, listenerType, z);
    }

    public void restart(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.restart(i);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllFailedDownloadTasks(list);
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.restartAllFailedDownloadTasks(list);
        }
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.restartAllPauseReserveOnWifiDownloadTasks(list);
        }
    }

    public void resume(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.resume(i);
    }

    public boolean retryDelayStart(int i) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return false;
        }
        return downloadHandler.retryDelayStart(i);
    }

    public void setDownloadIndependentProcessStatus(int i, boolean z) {
        synchronized (this) {
            this.independentMap.put(i, z ? Boolean.TRUE : Boolean.FALSE);
        }
    }

    public void setDownloadNotificationEventListener(int i, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.setDownloadNotificationEventListener(i, iDownloadNotificationEventListener);
    }

    public void setDownloadWithIndependentProcessStatus(int i, boolean z) {
        setDownloadIndependentProcessStatus(i, z);
        if (DownloadComponentManager.supportMultiProc() && !DownloadUtils.isDownloaderProcess() && DownloadProxy.get(true).isServiceAlive()) {
            DownloadProxy.get(true).setDownloadWithIndependentProcessStatus(i, z);
        }
        if (DownloadComponentManager.isDownloadInMultiProcess() || DownloadUtils.isDownloaderProcess() || DownloadUtils.isMainProcess()) {
            return;
        }
        try {
            Intent intent = new Intent(DownloadComponentManager.getAppContext(), DownloadHandleService.class);
            intent.setAction(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY);
            intent.putExtra("extra_download_id", i);
            DownloadComponentManager.getAppContext().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLogLevel(int i) {
        IDownloadProxy iDownloadProxy = DownloadProxy.get(false);
        if (iDownloadProxy != null) {
            iDownloadProxy.setLogLevel(i);
        }
        IDownloadProxy iDownloadProxy2 = DownloadProxy.get(true);
        if (iDownloadProxy2 != null) {
            iDownloadProxy2.setLogLevel(i);
        }
    }

    public void setThrottleNetSpeed(int i, long j) {
        IDownloadProxy downloadHandler = getDownloadHandler(i);
        if (downloadHandler == null) {
            return;
        }
        downloadHandler.setThrottleNetSpeed(i, j);
    }

    public void tryDownload(final DownloadTask downloadTask) {
        final IDownloadProxy downloadHandler = getDownloadHandler(downloadTask);
        if (downloadHandler == null) {
            if (downloadTask != null) {
                DownloadMonitorHelper.monitorSendWithTaskMonitor(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.mainThreadHandler.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    downloadHandler.tryDownload(downloadTask);
                }
            }, 500L);
        } else {
            downloadHandler.tryDownload(downloadTask);
        }
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        DownloadComponentManager.unRegisterDownloadCacheSyncListener(iDownloadCacheSyncStatusListener);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener iDownloaderProcessConnectedListener) {
        if (iDownloaderProcessConnectedListener == null) {
            return;
        }
        synchronized (this.processConnectedListeners) {
            if (this.processConnectedListeners.contains(iDownloaderProcessConnectedListener)) {
                this.processConnectedListeners.remove(iDownloaderProcessConnectedListener);
            }
        }
    }
}
