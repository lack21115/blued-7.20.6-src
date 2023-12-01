package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DownloadCache;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.reader.AsyncStreamReader;
import com.ss.android.socialbase.downloader.reader.IStreamReader;
import com.ss.android.socialbase.downloader.reader.SyncStreamReader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/DownloadResponseHandler.class */
public class DownloadResponseHandler {
    private static final boolean DEBUG = false;
    public static final int MIN_SYNC_STEP_BYTE = 65536;
    public static final long MIN_SYNC_TIME_MS = 500;
    private static String TAG = "ResponseHandler";
    private final AppStatusManager appStatusManager;
    private final boolean bugfixCancelThenUpdate;
    private final IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private long curOffset;
    private IDownloadCache customCache;
    private long debugReadTimeNs;
    private long debugSyncTimeNs;
    private long debugTotalTimeNs;
    private long debugWriteTimeNs;
    private DownloadCache downloadCache;
    private final DownloadChunk downloadChunk;
    private volatile long downloadChunkContentLen;
    private final DownloadInfo downloadInfo;
    private volatile long endOffset;
    private BaseException exception;
    private long handleStartOffset;
    private final boolean hasSyncStrategy;
    private final IDownloadHttpConnection httpConnection;
    private final boolean isMonitorRw;
    private RandomAccessOutputStream outputStream;
    private volatile boolean paused;
    private boolean rwConcurrent;
    private final DownloadSetting setting;
    private ISqlDownloadCache sqlDownloadCache;
    private final long syncIntervalMsBg;
    private final long syncIntervalMsFg;
    private final String url;
    boolean openLimitSpeed = false;
    private volatile long lastSyncBytes = 0;
    private volatile long lastSyncTimestamp = 0;

    public DownloadResponseHandler(DownloadInfo downloadInfo, String str, IDownloadHttpConnection iDownloadHttpConnection, DownloadChunk downloadChunk, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.downloadInfo = downloadInfo;
        this.url = str;
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        this.customCache = downloadCache;
        if (downloadCache instanceof DefaultDownloadCache) {
            DefaultDownloadCache defaultDownloadCache = (DefaultDownloadCache) downloadCache;
            this.downloadCache = defaultDownloadCache.getDownloadCache();
            this.sqlDownloadCache = defaultDownloadCache.getSqlDownloadCache();
        }
        this.httpConnection = iDownloadHttpConnection;
        this.downloadChunk = downloadChunk;
        this.callback = iDownloadRunnableCallback;
        long currentOffset = downloadChunk.getCurrentOffset();
        this.curOffset = currentOffset;
        this.handleStartOffset = currentOffset;
        if (downloadChunk.isHostChunk()) {
            this.downloadChunkContentLen = downloadChunk.getContentLength();
        } else {
            this.downloadChunkContentLen = downloadChunk.getRetainLength(false);
        }
        this.endOffset = downloadChunk.getEndOffset();
        this.appStatusManager = AppStatusManager.getInstance();
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        this.setting = obtain;
        boolean z = obtain.optInt(DownloadSettingKeys.SYNC_STRATEGY, 0) == 1;
        this.hasSyncStrategy = z;
        if (z) {
            this.syncIntervalMsFg = Math.max(this.setting.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_FG, 5000), 500L);
            this.syncIntervalMsBg = Math.max(this.setting.optInt(DownloadSettingKeys.SYNC_INTERVAL_MS_BG, 1000), 500L);
        } else {
            this.syncIntervalMsFg = 0L;
            this.syncIntervalMsBg = 0L;
        }
        this.isMonitorRw = this.setting.optInt(DownloadSettingKeys.MONITOR_RW) == 1;
        this.bugfixCancelThenUpdate = DownloadExpSwitchCode.isSwitchEnable(65536);
    }

    private boolean canReuseConnection() {
        return this.downloadInfo.isNeedReuseFirstConnection() && this.downloadChunk.isReuseingFirstConnection();
    }

    private void cancelConnection() {
        ExecutorService cPUThreadExecutor;
        if (this.httpConnection == null || (cPUThreadExecutor = DownloadComponentManager.getCPUThreadExecutor()) == null) {
            return;
        }
        cPUThreadExecutor.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DownloadResponseHandler.this.httpConnection.end();
                } catch (Throwable th) {
                }
            }
        });
    }

    private void checkAndSync(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.lastSyncTimestamp;
        if (this.hasSyncStrategy) {
            if (j > (this.appStatusManager.isAppForeground() ? this.syncIntervalMsFg : this.syncIntervalMsBg)) {
                sync();
                this.lastSyncTimestamp = uptimeMillis;
                return;
            }
            return;
        }
        long j2 = this.curOffset;
        long j3 = this.lastSyncBytes;
        if (z || isNeedSync(j2 - j3, j)) {
            sync();
            this.lastSyncTimestamp = uptimeMillis;
        }
    }

    private IStreamReader createStreamReader(InputStream inputStream) {
        int writeBufferSize = DownloadComponentManager.getWriteBufferSize();
        if (this.setting.optInt("rw_concurrent", 0) == 1 && this.downloadInfo.getChunkCount() == 1 && this.downloadInfo.getTotalBytes() > 20971520) {
            try {
                AsyncStreamReader asyncStreamReader = new AsyncStreamReader(inputStream, writeBufferSize, this.setting.optInt(DownloadSettingKeys.RW_CONCURRENT_MAX_BUFFER_COUNT, 4));
                this.rwConcurrent = true;
                return asyncStreamReader;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        SyncStreamReader syncStreamReader = new SyncStreamReader(inputStream, writeBufferSize);
        this.rwConcurrent = false;
        return syncStreamReader;
    }

    private boolean isNeedSync(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void sync() {
        boolean z;
        long nanoTime = this.isMonitorRw ? System.nanoTime() : 0L;
        try {
            this.outputStream.flushAndSync();
            z = true;
        } catch (Exception e) {
            z = false;
        }
        if (z) {
            this.downloadInfo.updateRealDownloadTime(true);
            boolean z2 = false;
            if (this.downloadInfo.getChunkCount() > 1) {
                z2 = true;
            }
            IDownloadProxy iDownloadProxy = DownloadProxy.get(DownloadUtils.needNotifyDownloaderProcess());
            if (z2) {
                updateDownloadChunk(this.sqlDownloadCache);
                if (iDownloadProxy != null) {
                    iDownloadProxy.updateDownloadInfo(this.downloadInfo);
                } else {
                    this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadInfo.getId(), this.downloadInfo.getCurBytes());
                }
            } else if (iDownloadProxy != null) {
                iDownloadProxy.updateDownloadInfo(this.downloadInfo);
            } else {
                this.sqlDownloadCache.OnDownloadTaskProgress(this.downloadChunk.getId(), this.curOffset);
            }
            this.lastSyncBytes = this.curOffset;
        }
        if (this.isMonitorRw) {
            this.debugSyncTimeNs += System.nanoTime() - nanoTime;
        }
    }

    private void updateDownloadChunk(IDownloadCache iDownloadCache) {
        if (iDownloadCache == null) {
            return;
        }
        IDownloadProxy iDownloadProxy = null;
        boolean z = iDownloadCache instanceof SqlDownloadCache;
        if (z) {
            IDownloadProxy iDownloadProxy2 = DownloadProxy.get(DownloadUtils.needNotifyDownloaderProcess());
            iDownloadProxy = iDownloadProxy2;
            if (iDownloadProxy2 == null) {
                return;
            }
        }
        DownloadChunk firstReuseChunk = this.downloadChunk.isHostChunk() ? this.downloadChunk.getFirstReuseChunk() : this.downloadChunk;
        if (firstReuseChunk == null) {
            if (this.downloadChunk.isHostChunk()) {
                if (!z || iDownloadProxy == null) {
                    iDownloadCache.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                } else {
                    iDownloadProxy.updateDownloadChunk(this.downloadChunk.getId(), this.downloadChunk.getChunkIndex(), this.curOffset);
                    return;
                }
            }
            return;
        }
        firstReuseChunk.setCurrentOffset(this.curOffset);
        if (!z || iDownloadProxy == null) {
            iDownloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
        } else {
            iDownloadProxy.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
        }
        if (firstReuseChunk.canRefreshCurOffsetForReuseChunk()) {
            boolean z2 = false;
            if (firstReuseChunk.hasNoBytesDownload()) {
                long nextChunkCurOffset = firstReuseChunk.getNextChunkCurOffset();
                z2 = false;
                if (nextChunkCurOffset > this.curOffset) {
                    if (!z || iDownloadProxy == null) {
                        iDownloadCache.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), nextChunkCurOffset);
                    } else {
                        iDownloadProxy.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), nextChunkCurOffset);
                    }
                    z2 = true;
                }
            }
            if (z2) {
                return;
            }
            if (!z || iDownloadProxy == null) {
                iDownloadCache.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
            } else {
                iDownloadProxy.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), this.curOffset);
            }
        }
    }

    public void cancel() {
        if (this.canceled) {
            return;
        }
        synchronized (this.callback) {
            this.canceled = true;
        }
        cancelConnection();
    }

    public long getCurOffset() {
        return this.curOffset;
    }

    public long getLastSyncBytes() {
        return this.lastSyncBytes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x039e, code lost:
        r0 = r20.httpConnection;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x03a6, code lost:
        if (r0 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03a9, code lost:
        r0.end();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03b2, code lost:
        if (r0 == null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03b5, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03c0, code lost:
        if (r20.bugfixCancelThenUpdate == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03c3, code lost:
        r0 = r20.callback;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03cb, code lost:
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x03d0, code lost:
        if (r20.canceled != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03d3, code lost:
        updateDownloadChunk(r20.downloadCache);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03df, code lost:
        if (r20.outputStream == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x03e2, code lost:
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x03e8, code lost:
        monitor-exit(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03f5, code lost:
        updateDownloadChunk(r20.downloadCache);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0400, code lost:
        if (r20.outputStream == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0403, code lost:
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0408, code lost:
        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(r20.outputStream);
        r20.debugTotalTimeNs = java.lang.System.nanoTime() - r0;
        r54 = r20.setting;
        r55 = r20.downloadInfo;
        r56 = r20.url;
        r57 = r20.httpConnection;
        r50 = r20.paused;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0440, code lost:
        r54 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0442, code lost:
        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(r20.outputStream);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0452, code lost:
        throw r54;
     */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x093e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleResponse() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 2672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler.handleResponse():void");
    }

    public void pause() {
        if (this.paused) {
            return;
        }
        this.paused = true;
        cancelConnection();
    }

    public void setChunkOffset(long j, long j2, long j3) {
        this.curOffset = j;
        this.handleStartOffset = j;
        this.endOffset = j2;
        this.downloadChunkContentLen = j3;
    }

    public void setEndOffset(long j, long j2) {
        this.endOffset = j;
        this.downloadChunkContentLen = j2;
    }
}
