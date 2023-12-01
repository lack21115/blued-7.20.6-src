package com.ss.android.socialbase.downloader.thread;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadFileExistException;
import com.ss.android.socialbase.downloader.exception.DownloadOnlyWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.RetryDelayTimeParamCalculator;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.connectionpool.DownloadConnectionPool;
import com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.connectionpool.FakeDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.segment.SegmentDispatcher;
import com.ss.android.socialbase.downloader.segment.SegmentStrategy;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadSettingsUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/DownloadRunnable.class */
public class DownloadRunnable implements IDownloadRunnableCallback, Runnable {
    private static final int MAX_RESET_RETAIN_RETRY_TIMES_COUNT = 3;
    private static final String TAG = DownloadRunnable.class.getSimpleName();
    private boolean acceptPartial;
    private boolean canResumeFromCache;
    private long curBytesNeedCheckSpaceOverFlow;
    private IDownloadDiskSpaceHandler diskSpaceHandler;
    private final IDownloadCache downloadCache;
    private DownloadInfo downloadInfo;
    private final DownloadTask downloadTask;
    private volatile BaseException errorException;
    private String existTargetFileName;
    private IDownloadHttpConnection firstGetConnection;
    private IDownloadHeadHttpConnection firstHeadConnection;
    private volatile DownloadResponseHandler firstHttpResponseHandler;
    private IDownloadForbiddenHandler forbiddenHandler;
    private final IChunkAdjustCalculator globalChunkAdjustCalculator;
    private final IChunkCntCalculator globalChunkCalculator;
    private final AtomicBoolean isAlive;
    private boolean isChunked;
    private boolean isResponseFromBegin;
    private boolean isSingleChunk;
    private Future mFuture;
    private long prepareDownloadTime;
    private AtomicInteger retainRetryTimes;
    private IRetryDelayTimeCalculator retryDelayTimeCalculator;
    private final DownloadSetting setting;
    private final DownloadStatusHandler statusHandler;
    private IChunkAdjustCalculator taskChunkAdjustCalculator;
    private IChunkCntCalculator taskChunkCalculator;
    private volatile boolean isTriedFixRangeNotSatisfiable = false;
    private final ArrayList<DownloadChunkRunnable> downloadChunkRunnableList = new ArrayList<>();
    private volatile RunStatus runStatus = RunStatus.RUN_STATUS_NONE;
    private volatile int bytesRetryCount = 5;
    private boolean needJumpToStart = false;
    private boolean firstHeadConnectionFailed = false;
    private boolean needCheckIfModified = false;
    private int resetRetainRetryTimesCount = 0;
    private volatile SegmentDispatcher segmentDispatcher = null;

    public DownloadRunnable(DownloadTask downloadTask, Handler handler) {
        this.downloadTask = downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
            this.taskChunkCalculator = downloadTask.getChunkStrategy();
            this.taskChunkAdjustCalculator = downloadTask.getChunkAdjustCalculator();
            this.forbiddenHandler = downloadTask.getForbiddenHandler();
            this.diskSpaceHandler = downloadTask.getDiskSpaceHandler();
            this.retryDelayTimeCalculator = getRetryDelayTimeCalculator(downloadTask);
            this.setting = DownloadSetting.obtain(this.downloadInfo.getId());
        } else {
            this.setting = DownloadSetting.obtainGlobal();
        }
        updateRetainRetryTimes();
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        this.globalChunkCalculator = DownloadComponentManager.getChunkCntCalculator();
        this.globalChunkAdjustCalculator = DownloadComponentManager.getChunkAdjustCalculator();
        this.statusHandler = new DownloadStatusHandler(downloadTask, handler);
        this.isAlive = new AtomicBoolean(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a0, code lost:
        if (r12 <= 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int calculateChunkCount(long r9, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> r11) {
        /*
            r8 = this;
            r0 = r8
            boolean r0 = r0.isMultiChunkDownloadAvailable()
            if (r0 == 0) goto La3
            r0 = r8
            boolean r0 = r0.canResumeFromCache
            if (r0 == 0) goto L29
            r0 = r11
            if (r0 == 0) goto L1d
            r0 = r11
            int r0 = r0.size()
            r12 = r0
            goto L9a
        L1d:
            r0 = r8
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            int r0 = r0.getChunkCount()
            r12 = r0
            goto L9a
        L29:
            r0 = r8
            com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator r0 = r0.taskChunkCalculator
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L3e
            r0 = r11
            r1 = r9
            int r0 = r0.calculateChunkCount(r1)
            r12 = r0
            goto L4a
        L3e:
            r0 = r8
            com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator r0 = r0.globalChunkCalculator
            r1 = r9
            int r0 = r0.calculateChunkCount(r1)
            r12 = r0
        L4a:
            com.ss.android.socialbase.downloader.network.NetTrafficManager r0 = com.ss.android.socialbase.downloader.network.NetTrafficManager.getInstance()
            com.ss.android.socialbase.downloader.network.NetworkQuality r0 = r0.getCurrentNetworkQuality()
            r11 = r0
            java.lang.String r0 = com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG
            java.lang.String r1 = "NetworkQuality is : %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r11
            java.lang.String r5 = r5.name()
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            com.ss.android.socialbase.downloader.logger.Logger.d(r0, r1)
            r0 = r8
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            r1 = r11
            java.lang.String r1 = r1.name()
            r0.setNetworkQuality(r1)
            r0 = r8
            com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator r0 = r0.taskChunkAdjustCalculator
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L8c
            r0 = r14
            r1 = r12
            r2 = r11
            int r0 = r0.calculateChunkCount(r1, r2)
            r12 = r0
            goto L9a
        L8c:
            r0 = r8
            com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator r0 = r0.globalChunkAdjustCalculator
            r1 = r12
            r2 = r11
            int r0 = r0.calculateChunkCount(r1, r2)
            r12 = r0
        L9a:
            r0 = r12
            r13 = r0
            r0 = r12
            if (r0 > 0) goto La6
        La3:
            r0 = 1
            r13 = r0
        La6:
            boolean r0 = com.ss.android.socialbase.downloader.logger.Logger.debug()
            if (r0 == 0) goto Ld5
            java.lang.String r0 = com.ss.android.socialbase.downloader.thread.DownloadRunnable.TAG
            java.lang.String r1 = "chunk count : %s for %s contentLen:%s"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r13
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r8
            com.ss.android.socialbase.downloader.model.DownloadInfo r5 = r5.downloadInfo
            java.lang.String r5 = r5.getName()
            r3[r4] = r5
            r3 = r2
            r4 = 2
            r5 = r9
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            com.ss.android.socialbase.downloader.logger.Logger.d(r0, r1)
        Ld5:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.calculateChunkCount(long, java.util.List):int");
    }

    private void cancelAllChunkRunnable() {
        try {
            Iterator it = ((ArrayList) this.downloadChunkRunnableList.clone()).iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable downloadChunkRunnable = (DownloadChunkRunnable) it.next();
                if (downloadChunkRunnable != null) {
                    downloadChunkRunnable.cancel();
                }
            }
        } catch (Throwable th) {
            String str = TAG;
            Logger.i(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private boolean checkCompletedByteValid() {
        if (this.downloadInfo.isChunked()) {
            DownloadInfo downloadInfo = this.downloadInfo;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = TAG;
        Logger.i(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.downloadInfo.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.downloadInfo.getTotalBytes());
        if (this.downloadInfo.getCurBytes() > 0) {
            if (this.downloadInfo.isIgnoreDataVerify()) {
                return true;
            }
            if (this.downloadInfo.getTotalBytes() > 0 && this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes()) {
                return true;
            }
        }
        this.downloadInfo.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.downloadInfo.reset();
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        return false;
    }

    private void checkHasAnotherSameTask() throws RetryThrowable, BaseException {
        AbsDownloadEngine downloadEngine;
        int id = this.downloadInfo.getId();
        int downloadId = DownloadComponentManager.getDownloadId(this.downloadInfo);
        if (this.downloadInfo.isDownloaded() && !this.downloadInfo.isExpiredRedownload() && !this.needCheckIfModified) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo downloadInfo = this.downloadCache.getDownloadInfo(downloadId);
        if (downloadInfo == null || (downloadEngine = DownloadComponentManager.getDownloadEngine()) == null || downloadInfo.getId() == id || !downloadInfo.equalsTask(this.downloadInfo)) {
            return;
        }
        if (downloadEngine.isDownloading(downloadInfo.getId())) {
            this.downloadCache.removeDownloadTaskData(id);
            throw new BaseException(1025, "another same task is downloading");
        }
        List<DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(downloadId);
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        this.downloadCache.removeDownloadTaskData(downloadId);
        if (downloadInfo == null || !downloadInfo.isBreakpointAvailable()) {
            return;
        }
        this.downloadInfo.copyFromCacheData(downloadInfo, false);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        if (downloadChunk != null) {
            for (DownloadChunk downloadChunk2 : downloadChunk) {
                downloadChunk2.setId(id);
                this.downloadCache.addDownloadChunk(downloadChunk2);
            }
        }
        throw new RetryThrowable("retry task because id generator changed");
    }

    private boolean checkIsStoppedByUser() {
        if (isStoppedStatus() || this.downloadInfo.getStatus() == -2) {
            if (isStoppedStatus()) {
                return true;
            }
            if (this.downloadInfo.getStatus() == -2) {
                this.runStatus = RunStatus.RUN_STATUS_PAUSE;
                return true;
            } else if (this.downloadInfo.getStatus() == -4) {
                this.runStatus = RunStatus.RUN_STATUS_CANCELED;
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean checkNeedRetryDelay() {
        return false;
    }

    private void checkSavePathValid() throws BaseException {
        if (TextUtils.isEmpty(this.downloadInfo.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.downloadInfo.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.downloadInfo.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!DownloadSettingsUtils.isOptimizeSavePath(this.downloadInfo)) {
                throw new BaseException(1031, "download savePath is not a directory:" + this.downloadInfo.getSavePath());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new BaseException(1031, "download savePath is not directory:path=" + this.downloadInfo.getSavePath());
        }
        boolean mkdirs = file.mkdirs();
        if (mkdirs || file.exists()) {
            return;
        }
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
            throw new BaseException(1030, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
        }
        for (int i = 0; !mkdirs && i < 3; i++) {
            try {
                Thread.sleep(10L);
                mkdirs = file.mkdirs();
            } catch (InterruptedException e) {
            }
        }
        if (mkdirs || file.exists()) {
            return;
        }
        if (DownloadUtils.getAvailableSpaceBytes(this.downloadInfo.getSavePath()) < 16384) {
            throw new BaseException(1006, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
        }
        throw new BaseException(1030, "download savePath directory can not created:" + this.downloadInfo.getSavePath());
    }

    private void checkSpaceOverflowInProgress() throws BaseException {
        long j;
        int optInt;
        try {
            j = DownloadUtils.getAvailableSpaceBytes(this.downloadInfo.getTempPath());
        } catch (BaseException e) {
            j = 0;
        }
        Logger.i(TAG, "checkSpaceOverflowInProgress: available = " + DownloadUtils.byteToMb(j) + "MB");
        if (j > 0) {
            long totalBytes = this.downloadInfo.getTotalBytes() - this.downloadInfo.getCurBytes();
            if (j < totalBytes && (optInt = DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100)) > 0) {
                long j2 = j - (optInt * 1048576);
                Logger.i(TAG, "checkSpaceOverflowInProgress: minKeep  = " + optInt + "MB, canDownload = " + DownloadUtils.byteToMb(j2) + "MB");
                if (j2 > 0) {
                    this.curBytesNeedCheckSpaceOverFlow = this.downloadInfo.getCurBytes() + j2 + 1048576;
                    return;
                } else {
                    this.curBytesNeedCheckSpaceOverFlow = 0L;
                    throw new DownloadOutOfSpaceException(j, totalBytes);
                }
            }
        }
        this.curBytesNeedCheckSpaceOverFlow = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01bd, code lost:
        if (r8.setting.optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_FILE_EXIST_UPDATE_DOWNLOAD_INFO) != false) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkTaskCache() throws com.ss.android.socialbase.downloader.exception.DownloadFileExistException {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.checkTaskCache():void");
    }

    private void checkTaskCanResume() {
        long curByte = DownloadUtils.getCurByte(this.downloadInfo);
        long curBytes = this.downloadInfo.getCurBytes();
        if (curByte != curBytes) {
            String str = TAG;
            Logger.w(str, "checkTaskCanResume: offset = " + curByte + ", curBytes = " + curBytes);
        }
        this.downloadInfo.setCurBytes(curByte);
        boolean z = curByte > 0;
        this.canResumeFromCache = z;
        if (z || this.needCheckIfModified) {
            return;
        }
        Logger.i(TAG, "checkTaskCanResume: deleteAllDownloadFiles");
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
    }

    private boolean checkTaskStatusValid() {
        int status = this.downloadInfo.getStatus();
        if (status == 1 || this.downloadInfo.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        onError(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    private void checkWifiTaskValid() throws DownloadRetryNeedlessException {
        if (this.downloadInfo.isOnlyWifi() && !DownloadUtils.checkPermission(DownloadComponentManager.getAppContext(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new DownloadRetryNeedlessException(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (!this.downloadInfo.isDownloadWithWifiValid()) {
            throw new DownloadOnlyWifiException();
        }
        if (!this.downloadInfo.isPauseReserveWithWifiValid()) {
            throw new DownloadPauseReserveWifiException();
        }
    }

    private void clearCurrentDownloadData() {
        String str = TAG;
        Logger.w(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
            this.downloadCache.removeSegments(this.downloadInfo.getId());
            DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
            this.canResumeFromCache = false;
            this.downloadInfo.resetDataForEtagEndure("");
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void closeConnection() {
        closeFirstHeadConnection();
        closeFirstConnection();
    }

    private void closeFirstConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.firstGetConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
            this.firstGetConnection = null;
        }
    }

    private void closeFirstHeadConnection() {
        IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.firstHeadConnection;
        if (iDownloadHeadHttpConnection != null) {
            iDownloadHeadHttpConnection.cancel();
            this.firstHeadConnection = null;
        }
    }

    public static DownloadChunk createFirstDownloadChunk(DownloadInfo downloadInfo, long j) {
        return new DownloadChunk.Builder(downloadInfo.getId()).chunkIndex(-1).startOffset(0L).oldOffset(j).currentOffset(j).endOffset(0L).contentLength(downloadInfo.getTotalBytes() - j).build();
    }

    private void createFirstGetConnection(String str, List<HttpHeader> list) throws BaseException, RetryThrowable {
        if (this.firstGetConnection != null) {
            return;
        }
        FakeDownloadHttpConnection fakeDownloadHttpConnection = null;
        if (this.downloadInfo.getChunkCount() == 1) {
            fakeDownloadHttpConnection = DownloadConnectionPool.getInstance().getCachedDownloadConnection(str, list);
        }
        if (fakeDownloadHttpConnection != null) {
            setHttpResponseStatus(this.firstGetConnection);
            this.downloadInfo.setPreconnectLevel(2);
            this.firstGetConnection = fakeDownloadHttpConnection;
        } else {
            try {
                try {
                    IDownloadHttpConnection downloadWithConnection = DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), str, null, list, this.setting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY), this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0) > 0, this.downloadInfo);
                    this.firstGetConnection = downloadWithConnection;
                    setHttpResponseStatus(downloadWithConnection);
                }
            } catch (BaseException e) {
                throw e;
            }
        }
        if (this.firstGetConnection == null) {
            throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
        }
    }

    private void createFirstHeadConnection(String str, List<HttpHeader> list, long j) throws BaseException, RetryThrowable {
        FakeDownloadHeadHttpConnection cachedHeadConnection;
        boolean z = true;
        if (this.downloadInfo.getChunkCount() == 1 && (cachedHeadConnection = DownloadConnectionPool.getInstance().getCachedHeadConnection(str, list)) != null) {
            this.firstHeadConnection = cachedHeadConnection;
            this.downloadInfo.setPreconnectLevel(1);
        }
        if (this.firstHeadConnection == null && !this.firstHeadConnectionFailed && this.downloadInfo.isHeadConnectionAvailable()) {
            try {
                int optInt = this.setting.optInt(DownloadSettingKeys.NET_LIB_STRATEGY);
                if (this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0) <= 0) {
                    z = false;
                }
                this.firstHeadConnection = DownloadComponentManager.downloadWithHeadConnection(str, list, optInt, z, this.downloadInfo);
            } catch (Throwable th) {
                this.downloadInfo.setHeadConnectionException(DownloadUtils.getThrowableMsg(th));
            }
        }
    }

    private void doFirstConnect(String str, List<HttpHeader> list, long j) throws BaseException, RetryThrowable {
        createFirstHeadConnection(str, list, j);
        IDownloadHeadHttpConnection iDownloadHeadHttpConnection = this.firstHeadConnection;
        if (iDownloadHeadHttpConnection != null) {
            try {
                handleFirstConnection(str, iDownloadHeadHttpConnection, j);
            } catch (Throwable th) {
                this.firstHeadConnectionFailed = true;
            }
        }
        if (this.firstHeadConnection == null || this.firstHeadConnectionFailed) {
            createFirstGetConnection(str, list);
            handleFirstConnection(str, this.firstGetConnection, j);
        }
    }

    private boolean doTaskStatusHandle() {
        if (this.runStatus == RunStatus.RUN_STATUS_ERROR) {
            this.statusHandler.onError(this.errorException);
            return true;
        } else if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
            this.statusHandler.onCancel();
            return true;
        } else if (this.runStatus == RunStatus.RUN_STATUS_PAUSE) {
            this.statusHandler.onPause();
            return true;
        } else if (this.runStatus == RunStatus.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.statusHandler.onCompleteForFileExist();
                return true;
            } catch (BaseException e) {
                this.statusHandler.onError(e);
                return true;
            }
        } else if (this.runStatus == RunStatus.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.statusHandler.onCompleteForFileExist(this.existTargetFileName);
                return true;
            } catch (BaseException e2) {
                this.statusHandler.onError(e2);
                return true;
            }
        } else if (this.runStatus == RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.statusHandler.onRetry(this.errorException, false);
            return false;
        } else if (this.runStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            if (this.runStatus == RunStatus.RUN_STATUS_RETRY_DELAY && !isAllChunkDownloadComplete()) {
                Logger.d(TAG, "doTaskStatusHandle retryDelay");
                startRetryDelayAlarm();
                return this.runStatus == RunStatus.RUN_STATUS_RETRY_DELAY;
            }
            try {
                if (checkCompletedByteValid()) {
                    this.statusHandler.onCompleted();
                    RetryScheduler.getInstance().scheduleRetryWhenHasTaskSucceed();
                    return true;
                }
                return false;
            } catch (Throwable th) {
                onError(new BaseException(1008, DownloadUtils.getErrorMsgWithTagPrefix(th, "doTaskStatusHandle onComplete")));
                return true;
            }
        }
    }

    private void downloadInner() {
        boolean z;
        List<DownloadChunk> downloadChunk;
        try {
            this.runStatus = RunStatus.RUN_STATUS_NONE;
            this.downloadInfo.updateStartDownloadTime();
            this.downloadInfo.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.downloadInfo.setFirstSpeedTime(-1L);
            try {
                checkTaskCache();
                z = false;
            } catch (DownloadFileExistException e) {
                Logger.d(TAG, "file exist " + e.getExistTargetFileName());
                this.existTargetFileName = e.getExistTargetFileName();
                z = true;
            }
            if (!this.needJumpToStart) {
                this.statusHandler.onStart();
            }
            this.needJumpToStart = false;
            if (checkIsStoppedByUser()) {
                endDownloadRunnable();
                return;
            }
            if (!TextUtils.isEmpty(this.existTargetFileName) && z) {
                if (this.downloadInfo.isExpiredRedownload()) {
                    this.needCheckIfModified = DownloadUtils.cacheExpired(this.downloadInfo);
                }
                if (!this.needCheckIfModified) {
                    finishWithFileExist();
                    endDownloadRunnable();
                    return;
                }
            }
            while (!checkIsStoppedByUser()) {
                try {
                    checkSavePathValid();
                    checkHasAnotherSameTask();
                    checkWifiTaskValid();
                    downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
                    checkTaskCanResume();
                } catch (DownloadFileExistException e2) {
                    finishWithFileExist();
                } catch (BaseException e3) {
                    Logger.w(TAG, "downloadInner: baseException = " + e3);
                    if (this.runStatus != RunStatus.RUN_STATUS_PAUSE) {
                        if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                            if (canRetry(e3)) {
                                if (DownloadUtils.isHttpDataDirtyError(e3)) {
                                    clearCurrentDownloadData();
                                }
                                if (onRetry(e3, 0L) == RetryCheckStatus.RETURN) {
                                    closeConnection();
                                    endDownloadRunnable();
                                    return;
                                }
                                closeConnection();
                            } else {
                                onError(e3);
                            }
                        }
                        this.runStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
                        closeConnection();
                        endDownloadRunnable();
                        return;
                    }
                } catch (RetryThrowable e4) {
                    Logger.w(TAG, "downloadInner: retry throwable for " + e4.getErrorMsg());
                    if (this.runStatus != RunStatus.RUN_STATUS_PAUSE) {
                        if (this.retainRetryTimes != null && this.retainRetryTimes.get() > 0) {
                            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.decrementAndGet());
                            this.downloadInfo.setStatus(5);
                        } else if (this.retainRetryTimes == null) {
                            onError(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e4.getErrorMsg()));
                        } else if (this.downloadInfo.trySwitchToNextBackupUrl()) {
                            this.downloadInfo.setStatus(5);
                            this.retainRetryTimes.set(this.downloadInfo.getRetryCount());
                            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
                        } else {
                            onError(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.downloadInfo.getRetryCount()), e4.getErrorMsg())));
                        }
                        closeConnection();
                    }
                }
                if (downloadSegments()) {
                    Logger.i(TAG, "downloadSegments return");
                    closeConnection();
                    endDownloadRunnable();
                    return;
                }
                String connectionUrl = this.downloadInfo.getConnectionUrl();
                if (checkIsStoppedByUser()) {
                    closeConnection();
                    endDownloadRunnable();
                    return;
                }
                long firstOffset = this.canResumeFromCache ? DownloadUtils.getFirstOffset(this.downloadInfo) : 0L;
                DownloadChunk createFirstDownloadChunk = createFirstDownloadChunk(this.downloadInfo, firstOffset);
                List<HttpHeader> extraHeaders = getExtraHeaders(createFirstDownloadChunk);
                DownloadUtils.addThrottleNetSpeed(extraHeaders, this.downloadInfo);
                DownloadUtils.addTTNetProtectTimeout(extraHeaders, this.downloadInfo);
                this.downloadInfo.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    doFirstConnect(connectionUrl, extraHeaders, firstOffset);
                    this.downloadInfo.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (checkIsStoppedByUser()) {
                        closeConnection();
                        endDownloadRunnable();
                        return;
                    }
                    long totalBytes = this.downloadInfo.getTotalBytes();
                    checkSpaceOverflow(totalBytes);
                    int calculateChunkCount = calculateChunkCount(totalBytes, downloadChunk);
                    if (checkIsStoppedByUser()) {
                        closeConnection();
                        endDownloadRunnable();
                        return;
                    } else if (calculateChunkCount <= 0) {
                        throw new BaseException(1032, "chunkCount is 0");
                    } else {
                        boolean z2 = calculateChunkCount == 1;
                        this.isSingleChunk = z2;
                        if (z2) {
                            if (this.firstGetConnection == null) {
                                long j = currentTimeMillis2;
                                try {
                                    long currentTimeMillis3 = System.currentTimeMillis();
                                    j = currentTimeMillis3;
                                    createFirstGetConnection(connectionUrl, extraHeaders);
                                    this.downloadInfo.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis3);
                                } catch (Throwable th) {
                                    this.downloadInfo.increaseAllConnectTime(System.currentTimeMillis() - j);
                                    throw th;
                                }
                            }
                            if (checkIsStoppedByUser()) {
                                closeConnection();
                                endDownloadRunnable();
                                return;
                            }
                            this.downloadInfo.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            resetRetainRetryTimes();
                            handleResponseWithSingleChunk(createFirstDownloadChunk, connectionUrl, this.firstGetConnection);
                        } else {
                            if (!this.downloadInfo.isNeedReuseFirstConnection()) {
                                closeFirstConnection();
                            }
                            if (checkIsStoppedByUser()) {
                                closeConnection();
                                endDownloadRunnable();
                                return;
                            }
                            resetRetainRetryTimes();
                            this.downloadInfo.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            if (this.canResumeFromCache) {
                                handleResponseWithMultiChunkFromResume(calculateChunkCount, downloadChunk);
                            } else {
                                handleResponseMultiChunkFromBegin(totalBytes, calculateChunkCount);
                            }
                        }
                        closeConnection();
                        endDownloadRunnable();
                        return;
                    }
                } catch (Throwable th2) {
                    this.downloadInfo.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    throw th2;
                }
            }
            endDownloadRunnable();
        } catch (Throwable th3) {
            endDownloadRunnable();
            throw th3;
        }
    }

    private boolean downloadSegments() throws BaseException, InterruptedException {
        if (!this.downloadInfo.isExpiredRedownload() && this.downloadInfo.getChunkCount() == 1 && this.downloadInfo.getThrottleNetSpeed() <= 0) {
            JSONObject optJSONObject = DownloadSetting.obtain(this.downloadInfo.getId()).optJSONObject(DownloadSettingKeys.SEGMENT_CONFIG);
            List<Segment> segments = this.downloadCache.getSegments(this.downloadInfo.getId());
            JSONObject jSONObject = optJSONObject;
            if (this.downloadInfo.getCurBytes() > 0) {
                if (segments == null || segments.isEmpty()) {
                    return false;
                }
                jSONObject = optJSONObject;
                if (optJSONObject == null) {
                    jSONObject = new JSONObject();
                }
            }
            if (jSONObject == null) {
                return false;
            }
            this.segmentDispatcher = new SegmentDispatcher(this.downloadInfo, SegmentStrategy.from(jSONObject), this);
            if (checkIsStoppedByUser()) {
                Logger.i(TAG, "downloadSegments: is stopped by user");
                if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
                    this.segmentDispatcher.cancel();
                    return true;
                }
                this.segmentDispatcher.pause();
                return true;
            }
            return this.segmentDispatcher.downloadSegments(segments);
        }
        return false;
    }

    private void endDownloadRunnable() {
        boolean z;
        boolean z2;
        Logger.d(TAG, "endDownloadRunnable::runStatus=" + this.runStatus);
        boolean z3 = (this.runStatus == RunStatus.RUN_STATUS_PAUSE || this.runStatus == RunStatus.RUN_STATUS_CANCELED) ? false : true;
        try {
            z = doTaskStatusHandle();
            z2 = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.statusHandler.onError((BaseException) e);
            } else {
                this.statusHandler.onError(new BaseException(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            this.needJumpToStart = true;
            Logger.d(TAG, "jump to restart");
            return;
        }
        this.isAlive.set(false);
        if (z3) {
            try {
                AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
                if (downloadEngine != null) {
                    downloadEngine.removeDownloadRunnable(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                IDownloadMonitorDepend monitorDepend = this.downloadTask.getMonitorDepend();
                DownloadInfo downloadInfo = this.downloadInfo;
                BaseException baseException = new BaseException(1014, DownloadUtils.getErrorMsgWithTagPrefix(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.downloadInfo;
                int i = 0;
                if (downloadInfo2 != null) {
                    i = downloadInfo2.getStatus();
                }
                DownloadMonitorHelper.monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, i);
            }
        }
    }

    private void finishWithFileExist() {
        Logger.d(TAG, "finishWithFileExist");
        if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.FIX_END_FOR_FILE_EXIST_ERROR, true)) {
            if (this.existTargetFileName.equals(this.downloadInfo.getName())) {
                this.runStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.runStatus = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.existTargetFileName.equals(this.downloadInfo.getTargetFilePath())) {
            this.runStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.runStatus = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private long getDelayTime() {
        return this.retryDelayTimeCalculator.calculateRetryDelayTime(this.downloadInfo.getCurRetryTimeInTotal(), this.downloadInfo.getTotalRetryCount());
    }

    private List<HttpHeader> getExtraHeaders(DownloadChunk downloadChunk) {
        List<HttpHeader> addRangeHeader = DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), downloadChunk);
        if (this.downloadInfo.isExpiredRedownload() && this.needCheckIfModified && this.downloadInfo.getLastModified() != null) {
            addRangeHeader.add(new HttpHeader(DownloadUtils.IF_MODIFIED_SINCE, this.downloadInfo.getLastModified()));
            addRangeHeader.add(new HttpHeader(DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE, DownloadUtils.HEADER_TAG_DOWNLOAD_CACHE));
            String str = TAG;
            Logger.d(str, "dcache::add head IF_MODIFIED_SINCE=" + this.downloadInfo.getLastModified());
        }
        return addRangeHeader;
    }

    private IRetryDelayTimeCalculator getRetryDelayTimeCalculator(DownloadTask downloadTask) {
        IRetryDelayTimeCalculator retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new RetryDelayTimeParamCalculator(retryDelayTimeArray);
            }
        }
        return DownloadComponentManager.getRetryDelayTimeCalculator();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b9, code lost:
        if (r7.hasChunkDivided() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.model.DownloadChunk getUnCompletedSubChunk(com.ss.android.socialbase.downloader.model.DownloadChunk r7, int r8) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.getUnCompletedSubChunk(com.ss.android.socialbase.downloader.model.DownloadChunk, int):com.ss.android.socialbase.downloader.model.DownloadChunk");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDiskSpaceCallback() {
        AbsDownloadEngine downloadEngine;
        if (checkIsStoppedByUser() || (downloadEngine = DownloadComponentManager.getDownloadEngine()) == null) {
            return;
        }
        downloadEngine.restartAsyncWaitingTask(this.downloadInfo.getId());
    }

    private void handleFirstResponse() throws BaseException {
        if (this.firstHttpResponseHandler != null) {
            if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
                this.downloadInfo.setStatus(-4);
                this.firstHttpResponseHandler.cancel();
            } else if (this.runStatus != RunStatus.RUN_STATUS_PAUSE) {
                this.firstHttpResponseHandler.handleResponse();
            } else {
                this.downloadInfo.setStatus(-2);
                this.firstHttpResponseHandler.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleForbiddenCallback(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.downloadInfo.setForbiddenBackupUrls(list, this.runStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER);
        AbsDownloadEngine downloadEngine = DownloadComponentManager.getDownloadEngine();
        if (downloadEngine != null) {
            downloadEngine.restartAsyncWaitingTask(this.downloadInfo.getId());
        }
    }

    private void handleResponseCodeError(String str, String str2) throws RetryThrowable {
        this.downloadCache.removeAllDownloadChunk(this.downloadInfo.getId());
        this.downloadCache.removeSegments(this.downloadInfo.getId());
        DownloadUtils.deleteAllDownloadFiles(this.downloadInfo);
        this.canResumeFromCache = false;
        this.downloadInfo.resetDataForEtagEndure(str);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        throw new RetryThrowable(str2);
    }

    private void handleResponseMultiChunkFromBegin(long j, int i) throws BaseException {
        long j2 = j / i;
        int id = this.downloadInfo.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            DownloadChunk build = new DownloadChunk.Builder(id).chunkIndex(i2).startOffset(j3).oldOffset(j3).currentOffset(j3).endOffset(i2 == i - 1 ? 0L : (j3 + j2) - 1).build();
            arrayList.add(build);
            this.downloadCache.addDownloadChunk(build);
            j3 += j2;
            i2++;
        }
        this.downloadInfo.setChunkCount(i);
        this.downloadCache.updateChunkCount(id, i);
        handleResponseWithMultiChunk(arrayList, j);
    }

    private void handleResponseWithMultiChunk(List<DownloadChunk> list, long j) throws BaseException {
        for (DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                long currentOffset = downloadChunk.getEndOffset() == 0 ? j - downloadChunk.getCurrentOffset() : (downloadChunk.getEndOffset() - downloadChunk.getCurrentOffset()) + 1;
                if (currentOffset > 0) {
                    downloadChunk.setContentLength(currentOffset);
                    if (!this.downloadInfo.isNeedReuseFirstConnection() || this.firstGetConnection == null || (this.downloadInfo.isHeadConnectionAvailable() && !this.firstHeadConnectionFailed)) {
                        this.downloadChunkRunnableList.add(new DownloadChunkRunnable(downloadChunk, this.downloadTask, this));
                    } else if (downloadChunk.getChunkIndex() == 0) {
                        this.downloadChunkRunnableList.add(new DownloadChunkRunnable(downloadChunk, this.downloadTask, this.firstGetConnection, this));
                    } else if (downloadChunk.getChunkIndex() > 0) {
                        this.downloadChunkRunnableList.add(new DownloadChunkRunnable(downloadChunk, this.downloadTask, this));
                    }
                }
            }
        }
        if (!DownloadExpSwitchCode.isSwitchEnable(64)) {
            ArrayList arrayList = new ArrayList(this.downloadChunkRunnableList.size());
            Iterator<DownloadChunkRunnable> it = this.downloadChunkRunnableList.iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable next = it.next();
                if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
                    next.cancel();
                } else if (this.runStatus == RunStatus.RUN_STATUS_PAUSE) {
                    next.pause();
                } else {
                    arrayList.add(Executors.callable(next));
                }
            }
            if (checkIsStoppedByUser()) {
                return;
            }
            try {
                DefaultDownloadEngine.invokeFutureTasks(arrayList);
                return;
            } catch (InterruptedException e) {
                throw new BaseException(1020, e);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.downloadChunkRunnableList.size());
        Iterator<DownloadChunkRunnable> it2 = this.downloadChunkRunnableList.iterator();
        while (it2.hasNext()) {
            DownloadChunkRunnable next2 = it2.next();
            if (this.runStatus == RunStatus.RUN_STATUS_CANCELED) {
                next2.cancel();
            } else if (this.runStatus == RunStatus.RUN_STATUS_PAUSE) {
                next2.pause();
            } else {
                arrayList2.add(next2);
            }
        }
        try {
            List<Future> executeFutureTasks = DefaultDownloadEngine.executeFutureTasks(arrayList2);
            for (Runnable runnable = (Runnable) arrayList2.remove(0); runnable != null; runnable = DefaultDownloadEngine.getUnstartedTask(executeFutureTasks)) {
                if (checkIsStoppedByUser()) {
                    return;
                }
                runnable.run();
            }
            if (executeFutureTasks == null || executeFutureTasks.isEmpty()) {
                return;
            }
            for (Future future : executeFutureTasks) {
                if (future != null && !future.isDone()) {
                    try {
                        future.get();
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    private void handleResponseWithMultiChunkFromResume(int i, List<DownloadChunk> list) throws BaseException {
        if (list.size() != i) {
            throw new BaseException(1033, new IllegalArgumentException());
        }
        handleResponseWithMultiChunk(list, this.downloadInfo.getTotalBytes());
    }

    private void handleResponseWithSingleChunk(DownloadChunk downloadChunk, String str, IDownloadHttpConnection iDownloadHttpConnection) throws BaseException {
        downloadChunk.setContentLength(this.downloadInfo.getTotalBytes() - downloadChunk.getCurrentOffset());
        this.downloadInfo.setChunkCount(1);
        this.downloadCache.updateChunkCount(this.downloadInfo.getId(), 1);
        this.firstHttpResponseHandler = new DownloadResponseHandler(this.downloadInfo, str, iDownloadHttpConnection, downloadChunk, this);
        handleFirstResponse();
    }

    private boolean handleRetryTime(BaseException baseException) {
        boolean z;
        AtomicInteger atomicInteger = this.retainRetryTimes;
        if (atomicInteger == null) {
            onError(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        if (atomicInteger.get() > 0) {
            z = true;
            if (baseException != null) {
                if (baseException.getErrorCode() != 1070) {
                    z = true;
                }
            }
            if (this.runStatus == RunStatus.RUN_STATUS_RETRY_DELAY && z) {
                this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.decrementAndGet());
                return false;
            }
        }
        if (this.downloadInfo.trySwitchToNextBackupUrl()) {
            this.retainRetryTimes.set(this.downloadInfo.getBackUpUrlRetryCount());
            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
        } else if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.downloadInfo.canReplaceHttpForRetry())) {
            onError(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.retainRetryTimes), String.valueOf(this.downloadInfo.getRetryCount()), baseException.getErrorMessage())));
            return true;
        } else {
            this.retainRetryTimes.set(this.downloadInfo.getRetryCount());
            this.downloadInfo.updateCurRetryTime(this.retainRetryTimes.get());
            this.downloadInfo.setHttpsToHttpRetryUsed(true);
        }
        z = false;
        return this.runStatus == RunStatus.RUN_STATUS_RETRY_DELAY ? false : false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isAllChunkDownloadComplete() {
        /*
            r5 = this;
            r0 = r5
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            int r0 = r0.getChunkCount()
            r1 = 1
            if (r0 > r1) goto L2d
            r0 = r5
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            long r0 = r0.getCurBytes()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L2b
            r0 = r5
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            long r0 = r0.getCurBytes()
            r1 = r5
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r1.downloadInfo
            long r1 = r1.getTotalBytes()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L2b
            r0 = 1
            return r0
        L2b:
            r0 = 0
            return r0
        L2d:
            r0 = r5
            com.ss.android.socialbase.downloader.downloader.IDownloadCache r0 = r0.downloadCache
            r1 = r5
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r1.downloadInfo
            int r1 = r1.getId()
            java.util.List r0 = r0.getDownloadChunk(r1)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L77
            r0 = r6
            int r0 = r0.size()
            r1 = 1
            if (r0 > r1) goto L4e
            r0 = 0
            return r0
        L4e:
            r0 = r6
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L55:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L75
            r0 = r6
            java.lang.Object r0 = r0.next()
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = (com.ss.android.socialbase.downloader.model.DownloadChunk) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L73
            r0 = r7
            boolean r0 = r0.hasNoBytesDownload()
            if (r0 != 0) goto L55
        L73:
            r0 = 0
            return r0
        L75:
            r0 = 1
            return r0
        L77:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.isAllChunkDownloadComplete():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r3.downloadInfo.getChunkCount() > 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isMultiChunkDownloadAvailable() {
        /*
            r3 = this;
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L4a
            r0 = r5
            r4 = r0
            r0 = r6
            boolean r0 = r0.isExpiredRedownload()
            if (r0 != 0) goto L4a
            r0 = r3
            boolean r0 = r0.canResumeFromCache
            if (r0 == 0) goto L2a
            r0 = r5
            r4 = r0
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            int r0 = r0.getChunkCount()
            r1 = 1
            if (r0 <= r1) goto L4a
        L2a:
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            boolean r0 = r0.isChunkDowngradeRetryUsed()
            if (r0 == 0) goto L36
            r0 = 0
            return r0
        L36:
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = r0.acceptPartial
            if (r0 == 0) goto L4a
            r0 = r5
            r4 = r0
            r0 = r3
            boolean r0 = r0.isChunked
            if (r0 != 0) goto L4a
            r0 = 1
            r4 = r0
        L4a:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.isMultiChunkDownloadAvailable():boolean");
    }

    private boolean isResponseCodeError(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.isResponseFromBegin || this.acceptPartial)) {
            return (i == 201 || i == 416) && this.downloadInfo.getCurBytes() > 0;
        }
        return true;
    }

    private boolean isStoppedStatus() {
        return this.runStatus == RunStatus.RUN_STATUS_CANCELED || this.runStatus == RunStatus.RUN_STATUS_PAUSE;
    }

    private void resetRetainRetryTimes() {
        if (DownloadSetting.obtain(this.downloadInfo.getId()).optInt(DownloadSettingKeys.RESET_RETAIN_RETRY_TIMES, 0) != 1 || this.resetRetainRetryTimesCount >= 3) {
            return;
        }
        this.retainRetryTimes.set(this.downloadInfo.isBackUpUrlUsed() ? this.downloadInfo.getBackUpUrlRetryCount() : this.downloadInfo.getRetryCount());
        this.resetRetainRetryTimesCount++;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c A[LOOP:0: B:26:0x008c->B:61:0x008c, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void runInner() {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.runInner():void");
    }

    private void startRetryDelayAlarm() {
        this.runStatus = RunStatus.RUN_STATUS_NONE;
    }

    private void updateRetainRetryTimes() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.downloadInfo.getCurRetryTime();
        int i = retryCount;
        if (retryCount < 0) {
            i = 0;
        }
        AtomicInteger atomicInteger = this.retainRetryTimes;
        if (atomicInteger == null) {
            this.retainRetryTimes = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
        if ((r4.getCause() instanceof javax.net.ssl.SSLHandshakeException) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0095, code lost:
        if (r3.downloadInfo.canReplaceHttpForRetry() != false) goto L23;
     */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean canRetry(com.ss.android.socialbase.downloader.exception.BaseException r4) {
        /*
            r3 = this;
            r0 = r3
            com.ss.android.socialbase.downloader.segment.SegmentDispatcher r0 = r0.segmentDispatcher
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r7
            if (r0 == 0) goto L27
            r0 = r4
            boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadUtils.isNetworkError(r0)
            if (r0 == 0) goto L27
            r0 = r3
            java.util.concurrent.atomic.AtomicInteger r0 = r0.retainRetryTimes
            int r0 = r0.get()
            r1 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r1.downloadInfo
            int r1 = r1.getRetryCount()
            if (r0 >= r1) goto L27
            r0 = 0
            return r0
        L27:
            r0 = r4
            boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadUtils.isResponseCodeError(r0)
            if (r0 == 0) goto L4a
            r0 = r3
            boolean r0 = r0.isSingleChunk
            if (r0 == 0) goto L48
            r0 = r3
            boolean r0 = r0.isTriedFixRangeNotSatisfiable
            if (r0 != 0) goto L48
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            com.ss.android.socialbase.downloader.utils.DownloadUtils.deleteAllDownloadFiles(r0)
            r0 = r3
            r1 = 1
            r0.isTriedFixRangeNotSatisfiable = r1
        L48:
            r0 = 1
            return r0
        L4a:
            r0 = r3
            java.util.concurrent.atomic.AtomicInteger r0 = r0.retainRetryTimes
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L5d
            r0 = r7
            int r0 = r0.get()
            if (r0 > 0) goto L98
        L5d:
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            boolean r0 = r0.hasNextBackupUrl()
            if (r0 != 0) goto L98
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto La3
            r0 = r4
            int r0 = r0.getErrorCode()
            r1 = 1011(0x3f3, float:1.417E-42)
            if (r0 == r1) goto L8c
            r0 = r6
            r5 = r0
            r0 = r4
            java.lang.Throwable r0 = r0.getCause()
            if (r0 == 0) goto La3
            r0 = r6
            r5 = r0
            r0 = r4
            java.lang.Throwable r0 = r0.getCause()
            boolean r0 = r0 instanceof javax.net.ssl.SSLHandshakeException
            if (r0 == 0) goto La3
        L8c:
            r0 = r6
            r5 = r0
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            boolean r0 = r0.canReplaceHttpForRetry()
            if (r0 == 0) goto La3
        L98:
            r0 = r6
            r5 = r0
            r0 = r4
            boolean r0 = r0 instanceof com.ss.android.socialbase.downloader.exception.DownloadRetryNeedlessException
            if (r0 != 0) goto La3
            r0 = 1
            r5 = r0
        La3:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.canRetry(com.ss.android.socialbase.downloader.exception.BaseException):boolean");
    }

    public void cancel() {
        this.runStatus = RunStatus.RUN_STATUS_CANCELED;
        if (this.segmentDispatcher != null) {
            this.segmentDispatcher.cancel();
        }
        if (this.firstHttpResponseHandler != null) {
            this.firstHttpResponseHandler.cancel();
        }
        if (this.segmentDispatcher == null && this.firstHttpResponseHandler == null) {
            closeConnection();
            this.runStatus = RunStatus.RUN_STATUS_CANCELED;
            endDownloadRunnable();
        }
        cancelAllChunkRunnable();
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0343, code lost:
        if ((r11 + r0) <= r8) goto L34;
     */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkSpaceOverflow(long r8) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 857
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.checkSpaceOverflow(long):void");
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public DownloadTask getDownloadTask() {
        return this.downloadTask;
    }

    public Future getFuture() {
        return this.mFuture;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public DownloadChunk getUnCompletedSubChunk(int i) {
        DownloadChunk unCompletedSubChunk;
        synchronized (this) {
            if (this.downloadInfo.getChunkCount() < 2) {
                return null;
            }
            List<DownloadChunk> downloadChunk = this.downloadCache.getDownloadChunk(this.downloadInfo.getId());
            if (downloadChunk != null && !downloadChunk.isEmpty()) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= downloadChunk.size()) {
                        return null;
                    }
                    DownloadChunk downloadChunk2 = downloadChunk.get(i3);
                    if (downloadChunk2 != null && (unCompletedSubChunk = getUnCompletedSubChunk(downloadChunk2, i)) != null) {
                        return unCompletedSubChunk;
                    }
                    i2 = i3 + 1;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01ec A[Catch: all -> 0x0507, RetryThrowable -> 0x0510, BaseException -> 0x0513, TRY_ENTER, TRY_LEAVE, TryCatch #2 {BaseException -> 0x0513, RetryThrowable -> 0x0510, all -> 0x0507, blocks: (B:5:0x0005, B:7:0x002a, B:9:0x0031, B:11:0x003b, B:13:0x00c1, B:15:0x016b, B:17:0x017e, B:19:0x0193, B:21:0x019c, B:23:0x01a3, B:29:0x01bb, B:31:0x01c8, B:39:0x01ec, B:40:0x01f6, B:41:0x0233, B:34:0x01d5, B:45:0x023e, B:47:0x0248, B:49:0x0257, B:51:0x026c, B:53:0x0272, B:55:0x027c, B:57:0x0287, B:61:0x0291, B:65:0x029c, B:69:0x02aa, B:71:0x02b9, B:72:0x02c8, B:75:0x02cc, B:77:0x02d3, B:82:0x02e5, B:83:0x02f2, B:84:0x02f3, B:84:0x02f3, B:85:0x02f6, B:86:0x031a, B:88:0x031c, B:92:0x0327, B:94:0x032f, B:95:0x033c, B:96:0x0349, B:98:0x034c, B:103:0x0360, B:106:0x036d, B:107:0x037a, B:109:0x037c, B:111:0x0388, B:112:0x0398, B:116:0x03b1, B:119:0x03bc, B:120:0x03c9, B:122:0x03cb, B:124:0x03d1, B:126:0x040c, B:128:0x041a, B:131:0x048c, B:134:0x0494, B:136:0x04a0, B:138:0x04b4, B:141:0x04c3, B:142:0x04fb, B:144:0x04fd, B:130:0x0450), top: B:159:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f6 A[Catch: all -> 0x0507, RetryThrowable -> 0x0510, BaseException -> 0x0513, TRY_ENTER, TryCatch #2 {BaseException -> 0x0513, RetryThrowable -> 0x0510, all -> 0x0507, blocks: (B:5:0x0005, B:7:0x002a, B:9:0x0031, B:11:0x003b, B:13:0x00c1, B:15:0x016b, B:17:0x017e, B:19:0x0193, B:21:0x019c, B:23:0x01a3, B:29:0x01bb, B:31:0x01c8, B:39:0x01ec, B:40:0x01f6, B:41:0x0233, B:34:0x01d5, B:45:0x023e, B:47:0x0248, B:49:0x0257, B:51:0x026c, B:53:0x0272, B:55:0x027c, B:57:0x0287, B:61:0x0291, B:65:0x029c, B:69:0x02aa, B:71:0x02b9, B:72:0x02c8, B:75:0x02cc, B:77:0x02d3, B:82:0x02e5, B:83:0x02f2, B:84:0x02f3, B:84:0x02f3, B:85:0x02f6, B:86:0x031a, B:88:0x031c, B:92:0x0327, B:94:0x032f, B:95:0x033c, B:96:0x0349, B:98:0x034c, B:103:0x0360, B:106:0x036d, B:107:0x037a, B:109:0x037c, B:111:0x0388, B:112:0x0398, B:116:0x03b1, B:119:0x03bc, B:120:0x03c9, B:122:0x03cb, B:124:0x03d1, B:126:0x040c, B:128:0x041a, B:131:0x048c, B:134:0x0494, B:136:0x04a0, B:138:0x04b4, B:141:0x04c3, B:142:0x04fb, B:144:0x04fd, B:130:0x0450), top: B:159:0x0005 }] */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleFirstConnection(java.lang.String r9, com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r10, long r11) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.RetryThrowable {
        /*
            Method dump skipped, instructions count: 1325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.handleFirstConnection(java.lang.String, com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection, long):void");
    }

    public boolean isAlive() {
        return this.isAlive.get();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onAllChunkRetryWithReset(BaseException baseException, boolean z) {
        Logger.d(TAG, "onAllChunkRetryWithReset");
        this.runStatus = RunStatus.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.errorException = baseException;
        cancelAllChunkRunnable();
        if (z ? handleRetryTime(baseException) : false) {
            return;
        }
        clearCurrentDownloadData();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onChunkDowngradeRetry(BaseException baseException) {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        onAllChunkRetryWithReset(baseException, false);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onCompleted(DownloadChunkRunnable downloadChunkRunnable) {
        if (this.isSingleChunk) {
            return;
        }
        synchronized (this) {
            this.downloadChunkRunnableList.remove(downloadChunkRunnable);
        }
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public void onError(BaseException baseException) {
        String str = TAG;
        Logger.d(str, "onError:" + baseException.getMessage());
        this.runStatus = RunStatus.RUN_STATUS_ERROR;
        this.errorException = baseException;
        cancelAllChunkRunnable();
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public boolean onProgress(long j) throws BaseException {
        if (this.curBytesNeedCheckSpaceOverFlow > 0 && this.downloadInfo.getCurBytes() > this.curBytesNeedCheckSpaceOverFlow) {
            checkSpaceOverflowInProgress();
        }
        return this.statusHandler.onProgress(j);
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public RetryCheckStatus onRetry(BaseException baseException, long j) {
        long totalBytes;
        long j2;
        boolean z;
        this.errorException = baseException;
        this.downloadInfo.increaseCurBytes(-j);
        this.downloadCache.updateDownloadInfo(this.downloadInfo);
        if (isStoppedStatus()) {
            return RetryCheckStatus.RETURN;
        }
        boolean z2 = true;
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.forbiddenHandler != null && !this.downloadInfo.isForbiddenRetryed()) {
                AbsDownloadForbiddenCallback absDownloadForbiddenCallback = new AbsDownloadForbiddenCallback() { // from class: com.ss.android.socialbase.downloader.thread.DownloadRunnable.1
                    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadForbiddenCallback, com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
                    public void onCallback(List<String> list) {
                        super.onCallback(list);
                        DownloadRunnable.this.handleForbiddenCallback(list);
                    }
                };
                boolean onForbidden = this.forbiddenHandler.onForbidden(absDownloadForbiddenCallback);
                this.downloadInfo.setForbiddenRetryed();
                if (onForbidden) {
                    if (!absDownloadForbiddenCallback.hasCallback()) {
                        cancelAllChunkRunnable();
                        this.statusHandler.handleWaitingAsyncHandler();
                        this.runStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return RetryCheckStatus.RETURN;
                    }
                    z = true;
                }
            } else if (handleRetryTime(baseException)) {
                return RetryCheckStatus.RETURN;
            }
            z = false;
        } else if (!DownloadUtils.isInsufficientSpaceError(baseException)) {
            if (handleRetryTime(baseException)) {
                return RetryCheckStatus.RETURN;
            }
            z = false;
        } else if (this.diskSpaceHandler == null) {
            onError(baseException);
            return RetryCheckStatus.RETURN;
        } else {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback = new IDownloadDiskSpaceCallback() { // from class: com.ss.android.socialbase.downloader.thread.DownloadRunnable.2
                @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
                public void onDiskCleaned() {
                    synchronized (DownloadRunnable.this) {
                        atomicBoolean.set(true);
                        DownloadRunnable.this.handleDiskSpaceCallback();
                    }
                }
            };
            if (baseException instanceof DownloadOutOfSpaceException) {
                DownloadOutOfSpaceException downloadOutOfSpaceException = (DownloadOutOfSpaceException) baseException;
                j2 = downloadOutOfSpaceException.getAvaliableSpaceBytes();
                totalBytes = downloadOutOfSpaceException.getRequiredSpaceBytes();
            } else {
                totalBytes = this.downloadInfo.getTotalBytes();
                j2 = -1;
            }
            synchronized (this) {
                if (!this.diskSpaceHandler.cleanUpDisk(j2, totalBytes, iDownloadDiskSpaceCallback)) {
                    if (this.runStatus == RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        return RetryCheckStatus.RETURN;
                    }
                    onError(baseException);
                    return RetryCheckStatus.RETURN;
                }
                if (!DownloadSetting.obtain(this.downloadInfo.getId()).optBugFix(DownloadSettingKeys.BugFix.NOT_DELETE_WHEN_CLEAN_SPACE, false)) {
                    checkCompletedByteValid();
                }
                if (!atomicBoolean.get()) {
                    if (this.runStatus != RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                        this.runStatus = RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        cancelAllChunkRunnable();
                        this.statusHandler.handleWaitingAsyncHandler();
                    }
                    return RetryCheckStatus.RETURN;
                }
                if (handleRetryTime(baseException)) {
                    return RetryCheckStatus.RETURN;
                }
                z = true;
            }
        }
        if (!z && checkNeedRetryDelay()) {
            cancelAllChunkRunnable();
        }
        DownloadStatusHandler downloadStatusHandler = this.statusHandler;
        if (this.runStatus != RunStatus.RUN_STATUS_RETRY_DELAY) {
            z2 = false;
        }
        downloadStatusHandler.onRetry(baseException, z2);
        return this.runStatus == RunStatus.RUN_STATUS_RETRY_DELAY ? RetryCheckStatus.RETURN : RetryCheckStatus.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public RetryCheckStatus onSingleChunkRetry(DownloadChunk downloadChunk, BaseException baseException, long j) {
        if (isStoppedStatus()) {
            return RetryCheckStatus.RETURN;
        }
        if (baseException == null || !(baseException.getErrorCode() == 1047 || DownloadUtils.isInsufficientSpaceError(baseException))) {
            this.errorException = baseException;
            this.downloadInfo.increaseCurBytes(-j);
            this.downloadCache.updateDownloadInfo(this.downloadInfo);
            if (handleRetryTime(baseException)) {
                return RetryCheckStatus.RETURN;
            }
            this.statusHandler.onSingleChunkRetry(downloadChunk, baseException, this.runStatus == RunStatus.RUN_STATUS_RETRY_DELAY);
            if (this.runStatus != RunStatus.RUN_STATUS_RETRY_DELAY && this.downloadInfo.isNeedRetryDelay()) {
                long delayTime = getDelayTime();
                if (delayTime > 0) {
                    String str = TAG;
                    Logger.i(str, "onSingleChunkRetry with delay time " + delayTime);
                    try {
                        Thread.sleep(delayTime);
                    } catch (Throwable th) {
                        String str2 = TAG;
                        Logger.w(str2, "onSingleChunkRetry:" + th.getMessage());
                    }
                }
            }
            return RetryCheckStatus.CONTINUE;
        }
        return onRetry(baseException, j);
    }

    public void pause() {
        this.runStatus = RunStatus.RUN_STATUS_PAUSE;
        if (this.segmentDispatcher != null) {
            this.segmentDispatcher.pause();
        }
        if (this.firstHttpResponseHandler != null) {
            this.firstHttpResponseHandler.pause();
        }
        if (this.segmentDispatcher == null && this.firstHttpResponseHandler == null) {
            closeConnection();
            this.runStatus = RunStatus.RUN_STATUS_PAUSE;
            endDownloadRunnable();
        }
        try {
            Iterator it = ((ArrayList) this.downloadChunkRunnableList.clone()).iterator();
            while (it.hasNext()) {
                DownloadChunkRunnable downloadChunkRunnable = (DownloadChunkRunnable) it.next();
                if (downloadChunkRunnable != null) {
                    downloadChunkRunnable.pause();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void prepareDownload() {
        this.prepareDownloadTime = System.currentTimeMillis();
        this.statusHandler.onPrepare();
    }

    @Override // java.lang.Runnable
    public void run() {
        DownloadComponentManager.onDownloadTaskStart(this.downloadTask, 3);
        try {
            DeviceBandwidthSampler.getInstance().startSampling();
            runInner();
            DeviceBandwidthSampler.getInstance().stopSampling();
            DownloadComponentManager.onDownloadTaskFinish(this.downloadTask, 3);
        } catch (Throwable th) {
            DeviceBandwidthSampler.getInstance().stopSampling();
            throw th;
        }
    }

    public void setFuture(Future future) {
        this.mFuture = future;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setHttpResponseStatus(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 == 0) goto L28
            r0 = r4
            int r0 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L23
            r5 = r0
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo     // Catch: java.lang.Throwable -> L23
            r1 = r5
            r0.setHttpStatusCode(r1)     // Catch: java.lang.Throwable -> L23
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo     // Catch: java.lang.Throwable -> L23
            r1 = r5
            java.lang.String r1 = com.ss.android.socialbase.downloader.utils.DownloadHttpUtils.httpCodeToMessage(r1)     // Catch: java.lang.Throwable -> L23
            r0.setHttpStatusMessage(r1)     // Catch: java.lang.Throwable -> L23
            r0 = 1
            r5 = r0
            goto L2a
        L23:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L28:
            r0 = 0
            r5 = r0
        L2a:
            r0 = r5
            if (r0 != 0) goto L40
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            r1 = -1
            r0.setHttpStatusCode(r1)
            r0 = r3
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r0.downloadInfo
            java.lang.String r1 = ""
            r0.setHttpStatusMessage(r1)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadRunnable.setHttpResponseStatus(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection):void");
    }

    public void setThrottleNetSpeed(long j) {
        IDownloadHttpConnection iDownloadHttpConnection = this.firstGetConnection;
        if (iDownloadHttpConnection != null && (iDownloadHttpConnection instanceof AbsDownloadHttpConnection)) {
            try {
                ((AbsDownloadHttpConnection) iDownloadHttpConnection).setThrottleNetSpeedWhenRunning(j);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
