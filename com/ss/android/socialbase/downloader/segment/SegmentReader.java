package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.video.module.a.a.m;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.umeng.analytics.pro.at;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/SegmentReader.class */
public class SegmentReader implements Runnable {
    private static final int SEGMENT_APPLY_RETRY_MAX_COUNT = 50;
    private static final int SWITCH_URL_MAX_COUNT = 30;
    private static final String TAG = "SegmentReader";
    private volatile boolean changeSegment;
    private volatile boolean closed;
    volatile long connectEndTime;
    volatile long connectStartTime;
    String curHostIp;
    String curHostRealIp;
    private int curRetryCount;
    volatile Segment curSegment;
    String curUrl;
    private final DownloadInfo downloadInfo;
    private volatile long endOffsetInConnection;
    private boolean exited;
    private boolean failed;
    private BaseException failedException;
    private Future future;
    private final ISegmentCallback host;
    private IDownloadHttpConnection httpConnection;
    private HttpResponse httpResponse;
    private boolean httpsToHttpRetryUsed;
    private long lastConnectStartTime;
    private final IBufferPool pool;
    private volatile long readBytes;
    volatile long readEndTime;
    volatile long readStartTime;
    private volatile boolean reconnect;
    private int retryCount;
    private int segmentApplyRetryTimes;
    private volatile long segmentNewEndOffset;
    private final DownloadSetting setting;
    private long startOffsetInConnection;
    private DownloadStenographer stenographer;
    private int switchUrlTimes;
    private Thread thread;
    private volatile boolean threadDirty;
    final int threadIndex;
    UrlRecord urlRecord;
    private final List<Segment> succeedSegments = new ArrayList();
    private volatile long curSegmentReadOffset = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentReader(DownloadInfo downloadInfo, SegmentDispatcher segmentDispatcher, IBufferPool iBufferPool, UrlRecord urlRecord, int i) {
        this.downloadInfo = downloadInfo;
        this.host = segmentDispatcher;
        this.pool = iBufferPool;
        this.setting = DownloadSetting.obtain(downloadInfo.getId());
        this.urlRecord = urlRecord;
        this.threadIndex = i;
    }

    private boolean checkCanUseHttpsToHttpRetry(BaseException baseException) {
        if (DownloadUtils.isHttpsError(baseException)) {
            String str = this.urlRecord.url;
            if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.downloadInfo.isNeedHttpsToHttpRetry() || this.httpsToHttpRetryUsed) {
                return false;
            }
            this.httpsToHttpRetryUsed = true;
            resetRetryTimes();
            return true;
        }
        return false;
    }

    private void closeConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            try {
                Logger.i(TAG, "closeConnection: thread = " + this.threadIndex);
                iDownloadHttpConnection.end();
                iDownloadHttpConnection.cancel();
            } catch (Throwable th) {
            }
        }
    }

    private void createConnection(Segment segment) throws BaseException {
        String str;
        String str2;
        IDownloadHttpConnection downloadWithConnection;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.connectEndTime = 0L;
                this.connectStartTime = currentTimeMillis;
                this.startOffsetInConnection = segment.getCurrentOffsetRead();
                this.endOffsetInConnection = segment.getEndOffset();
                if (this.endOffsetInConnection > 0 && this.startOffsetInConnection > this.endOffsetInConnection) {
                    throw new SegmentApplyException(6, "createConn, " + segment);
                }
                this.stenographer = new DownloadStenographer();
                List<HttpHeader> addRangeHeader = DownloadUtils.addRangeHeader(this.downloadInfo.getExtraHeaders(), this.downloadInfo.geteTag(), this.startOffsetInConnection, this.endOffsetInConnection);
                addRangeHeader.add(new HttpHeader("Segment-Index", String.valueOf(segment.getIndex())));
                addRangeHeader.add(new HttpHeader("Thread-Index", String.valueOf(this.threadIndex)));
                DownloadUtils.addThrottleNetSpeed(addRangeHeader, this.downloadInfo);
                DownloadUtils.addTTNetProtectTimeout(addRangeHeader, this.downloadInfo);
                String str3 = this.urlRecord.url;
                str = str3;
                if (this.httpsToHttpRetryUsed) {
                    str = str3;
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                        if (str3.startsWith("https")) {
                            str = str3.replaceFirst("https", "http");
                        }
                    }
                }
                str2 = this.urlRecord.ip;
                Logger.i(TAG, "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + segment + ", threadIndex = " + this.threadIndex);
                this.curUrl = str;
                this.curHostIp = str2;
                downloadWithConnection = DownloadComponentManager.downloadWithConnection(this.downloadInfo.isNeedDefaultHttpServiceBackUp(), this.downloadInfo.getMaxBytes(), str, str2, addRangeHeader, 0, currentTimeMillis - this.lastConnectStartTime > m.ag && this.setting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT) > 0, this.downloadInfo);
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                DownloadUtils.parseException(th, "createConn");
            }
            if (downloadWithConnection == null) {
                throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
            }
            this.httpConnection = downloadWithConnection;
            this.httpResponse = new HttpResponse(str, downloadWithConnection);
            if (this.closed) {
                throw new StreamClosedException("createConn");
            }
            if (downloadWithConnection instanceof AbsDownloadHttpConnection) {
                this.curHostRealIp = ((AbsDownloadHttpConnection) downloadWithConnection).getHostIp();
            }
            Log.i(TAG, "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.curHostRealIp + ", threadIndex = " + this.threadIndex);
        } finally {
            this.connectEndTime = System.currentTimeMillis();
        }
    }

    private void doConnect(Segment segment) throws BaseException, RetryThrowable {
        createConnection(segment);
        this.host.onSegmentConnected(this, segment, this.urlRecord, this.httpResponse);
        this.urlRecord.recordSucceed();
    }

    private boolean download(Segment segment) throws BaseException {
        initParams();
        while (true) {
            try {
                doConnect(segment);
                loopAndRead(segment);
                releaseDownload();
                return true;
            } catch (SegmentApplyException e) {
                this.failedException = e;
                throw e;
            } catch (Throwable th) {
                try {
                    Logger.e(TAG, "download: e = " + th + ", threadIndex = " + this.threadIndex + ", reconnect = " + this.reconnect + ", closed = " + this.closed);
                    if (this.closed) {
                        releaseDownload();
                        return false;
                    } else if (this.reconnect) {
                        this.reconnect = false;
                        Thread.interrupted();
                        if (this.changeSegment) {
                            this.changeSegment = false;
                            throw new SegmentApplyException(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e2 = null;
                        if (th instanceof BaseException) {
                            e2 = th;
                        } else {
                            try {
                                DownloadUtils.parseException(th, "download");
                            } catch (BaseException e3) {
                                e2 = e3;
                            }
                        }
                        if (e2 == null || !handleFailedAndCheckRetry(segment, e2)) {
                            releaseDownload();
                            return false;
                        }
                    }
                } finally {
                    releaseDownload();
                }
            }
        }
    }

    private boolean handleFailedAndCheckRetry(Segment segment, BaseException baseException) {
        Logger.e(TAG, "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.curRetryCount + ", retryCount = " + this.retryCount);
        this.failedException = baseException;
        this.urlRecord.recordFailed();
        this.host.onSegmentRetry(this, this.urlRecord, segment, baseException, this.curRetryCount, this.retryCount);
        int i = this.curRetryCount;
        if (i < this.retryCount) {
            this.curRetryCount = i + 1;
            return true;
        } else if (checkCanUseHttpsToHttpRetry(baseException)) {
            return true;
        } else {
            this.host.onSegmentFailed(this, this.urlRecord, segment, baseException);
            return false;
        }
    }

    private void initParams() {
        this.httpsToHttpRetryUsed = false;
        resetRetryTimes();
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x02dc, code lost:
        r26 = r28 + 1;
        r0 = r20 - r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02ed, code lost:
        if (r0 <= 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02f4, code lost:
        r0 = new java.lang.StringBuilder();
        r0 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0301, code lost:
        r0.append("loopAndRead: redundant = ");
        r0 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x030e, code lost:
        r0.append(r0);
        r0 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x031a, code lost:
        com.ss.android.socialbase.downloader.logger.Logger.e(com.ss.android.socialbase.downloader.segment.SegmentReader.TAG, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0325, code lost:
        r16.curSegmentReadOffset = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x032f, code lost:
        r20 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0334, code lost:
        r34 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0358, code lost:
        throw r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0363, code lost:
        throw new com.ss.android.socialbase.downloader.segment.StreamClosedException("loopAndRead");
     */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x067d: MOVE  (r0 I:??[long, double]) = (r30 I:??[long, double]), block:B:229:0x0679 */
    /* JADX WARN: Not initialized variable reg: 38, insn: 0x0670: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r38 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:227:0x0668 */
    /* JADX WARN: Not initialized variable reg: 39, insn: 0x0681: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r39 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:229:0x0679 */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x095f  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0977  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loopAndRead(com.ss.android.socialbase.downloader.segment.Segment r17) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 2683
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.loopAndRead(com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private Buffer probeFirstBuffer(IBufferPool iBufferPool, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i;
        Buffer obtain = iBufferPool.obtain();
        try {
            i = inputStream.read(obtain.data);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i != -1) {
                obtain.size = i;
                if (i == -1) {
                    iBufferPool.recycle(obtain);
                }
                return obtain;
            }
            throw new BaseException((int) DownloadErrorCode.ERROR_PROBE_FIRST_BUFFER, at.s);
        } catch (Throwable th2) {
            th = th2;
            if (i == -1) {
                iBufferPool.recycle(obtain);
            }
            throw th;
        }
    }

    private long refreshSegmentEndOffset() {
        long j = this.segmentNewEndOffset;
        this.segmentNewEndOffset = 0L;
        long j2 = j;
        if (j <= 0) {
            j2 = Long.MAX_VALUE;
        }
        return j2;
    }

    private void releaseDownload() {
        this.lastConnectStartTime = this.connectStartTime;
        this.connectStartTime = -1L;
        this.connectEndTime = -1L;
        this.readStartTime = -1L;
        this.readEndTime = -1L;
        closeConnection();
    }

    private void resetRetryTimes() {
        this.retryCount = this.urlRecord.isMainUrl ? this.downloadInfo.getRetryCount() : this.downloadInfo.getBackUpUrlRetryCount();
        this.curRetryCount = 0;
    }

    public boolean adjustSegmentEndOffset(long j) {
        long j2 = this.endOffsetInConnection;
        if (j > 0 || j2 <= 0) {
            if (j <= j2 || j2 <= 0) {
                this.segmentNewEndOffset = j;
                this.threadDirty = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public void close() {
        Logger.i(TAG, "close: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.closed = true;
            this.threadDirty = true;
        }
        closeConnection();
        Future future = this.future;
        if (future != null) {
            this.future = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    int getCurRetryCount() {
        return this.curRetryCount;
    }

    long getCurSegmentDownloadSpeed(long j) {
        long j2 = this.readStartTime;
        if (j2 <= 0) {
            return -1L;
        }
        long j3 = j - j2;
        if (j3 <= 0) {
            return -1L;
        }
        long j4 = this.curSegmentReadOffset;
        long j5 = this.startOffsetInConnection;
        if (j5 < 0 || j4 < j5) {
            return 0L;
        }
        return (j4 - j5) / j3;
    }

    public long getCurSegmentReadOffset() {
        return this.curSegmentReadOffset;
    }

    BaseException getFailedException() {
        return this.failedException;
    }

    public long getReadBytes() {
        long j;
        long readingBytes;
        synchronized (this.host) {
            j = this.readBytes;
            readingBytes = getReadingBytes();
        }
        return j + readingBytes;
    }

    public long getReadingBytes() {
        synchronized (this.host) {
            long j = this.curSegmentReadOffset;
            long j2 = this.startOffsetInConnection;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getRecentDownloadSpeed(long j, long j2) {
        DownloadStenographer downloadStenographer = this.stenographer;
        if (downloadStenographer == null) {
            return -1L;
        }
        return downloadStenographer.getRecentDownloadSpeed(j, j2);
    }

    int getRetryCount() {
        return this.retryCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getStartOffsetInConnection() {
        return this.startOffsetInConnection;
    }

    public boolean isExited() {
        return this.exited;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFailed() {
        return this.failed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markProgress(long j) {
        long j2 = this.curSegmentReadOffset;
        DownloadStenographer downloadStenographer = this.stenographer;
        if (j2 < 0 || downloadStenographer == null) {
            return;
        }
        Log.i(TAG, "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.threadIndex);
        downloadStenographer.markProgress(j2, j);
    }

    public void reconnect() {
        reconnect(false);
    }

    public void reconnect(boolean z) {
        Logger.i(TAG, "reconnect: threadIndex = " + this.threadIndex);
        synchronized (this) {
            this.changeSegment = z;
            this.reconnect = true;
            this.threadDirty = true;
        }
        closeConnection();
        Thread thread = this.thread;
        if (thread != null) {
            try {
                Log.i(TAG, "reconnect: t.interrupt threadIndex = " + this.threadIndex);
                thread.interrupt();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00cc, code lost:
        r4.curSegment = null;
        r5 = r4.host;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentReader.run():void");
    }

    public void setExited(boolean z) {
        this.exited = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFailed(boolean z) {
        this.failed = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFuture(Future future) {
        this.future = future;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean switchUrlRecord(UrlRecord urlRecord) {
        int i = this.switchUrlTimes;
        if (i >= 30) {
            return false;
        }
        this.switchUrlTimes = i + 1;
        UrlRecord urlRecord2 = this.urlRecord;
        if (urlRecord2 != null) {
            urlRecord2.recordUnUse(this);
        }
        urlRecord.recordUse(this);
        this.urlRecord = urlRecord;
        resetRetryTimes();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateReadBytes() {
        UrlRecord urlRecord = this.urlRecord;
        try {
            synchronized (this.host) {
                long readingBytes = getReadingBytes();
                if (readingBytes > 0) {
                    this.readBytes += readingBytes;
                    urlRecord.increaseDownloadBytes(readingBytes);
                }
                this.curSegmentReadOffset = -1L;
            }
        } catch (Throwable th) {
        }
    }
}
