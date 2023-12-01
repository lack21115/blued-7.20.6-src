package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadResponseHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/DownloadChunkRunnable.class */
public class DownloadChunkRunnable implements Runnable {
    private static final String TAG = DownloadChunkRunnable.class.getSimpleName();
    private final IDownloadRunnableCallback callback;
    private volatile boolean canceled;
    private DownloadChunk curDownloadChunk;
    private IDownloadCache downloadCache;
    private DownloadChunk downloadChunk;
    private DownloadInfo downloadInfo;
    private DownloadResponseHandler downloadResponseHandler;
    private final DownloadTask downloadTask;
    private IDownloadHttpConnection httpConnection;
    private boolean isHttpConnectionInject;
    private volatile boolean paused;

    public DownloadChunkRunnable(DownloadChunk downloadChunk, DownloadTask downloadTask, IDownloadHttpConnection iDownloadHttpConnection, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this(downloadChunk, downloadTask, iDownloadRunnableCallback);
        this.httpConnection = iDownloadHttpConnection;
    }

    public DownloadChunkRunnable(DownloadChunk downloadChunk, DownloadTask downloadTask, IDownloadRunnableCallback iDownloadRunnableCallback) {
        this.isHttpConnectionInject = false;
        this.downloadChunk = downloadChunk;
        this.downloadTask = downloadTask;
        if (downloadTask != null) {
            this.downloadInfo = downloadTask.getDownloadInfo();
        }
        this.callback = iDownloadRunnableCallback;
        this.downloadCache = DownloadComponentManager.getDownloadCache();
        this.downloadChunk.setChunkRunnable(this);
    }

    private void closeConnection() {
        IDownloadHttpConnection iDownloadHttpConnection = this.httpConnection;
        if (iDownloadHttpConnection != null) {
            iDownloadHttpConnection.end();
            this.httpConnection = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r26.getChunkIndex() == r10.getChunkIndex()) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0320 A[Catch: all -> 0x0462, TRY_ENTER, TryCatch #1 {all -> 0x0462, blocks: (B:141:0x030f, B:145:0x0320, B:147:0x0328, B:150:0x033a, B:152:0x0348, B:154:0x0350, B:159:0x036a, B:161:0x0371, B:163:0x0379, B:166:0x0393, B:167:0x03a2, B:168:0x03b8, B:171:0x03c9, B:173:0x03d1, B:175:0x03f3, B:181:0x0405, B:174:0x03e4, B:183:0x0415, B:185:0x041f, B:187:0x0429, B:189:0x0434, B:191:0x0440, B:194:0x0451, B:128:0x02dc, B:132:0x02ed, B:134:0x02f7), top: B:206:0x030f, inners: #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x031a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x019c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a2 A[Catch: all -> 0x02db, BaseException -> 0x0307, TRY_ENTER, TryCatch #10 {BaseException -> 0x0307, blocks: (B:22:0x006b, B:26:0x007c, B:30:0x008f, B:65:0x0191, B:69:0x01a2, B:71:0x01a9, B:84:0x01f5, B:53:0x014f), top: B:215:0x006b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean downloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk r10) {
        /*
            Method dump skipped, instructions count: 1146
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable.downloadChunkInner(com.ss.android.socialbase.downloader.model.DownloadChunk):boolean");
    }

    private String getUrl() {
        return this.downloadInfo.getConnectionUrl();
    }

    private boolean isStoppedStatus() {
        return this.paused || this.canceled;
    }

    private void revertDownloadChunk(DownloadChunk downloadChunk, long j) {
        DownloadChunk firstReuseChunk = downloadChunk.isHostChunk() ? downloadChunk.getFirstReuseChunk() : downloadChunk;
        if (firstReuseChunk == null) {
            if (downloadChunk.isHostChunk()) {
                this.downloadCache.updateDownloadChunk(downloadChunk.getId(), downloadChunk.getChunkIndex(), j);
                return;
            }
            return;
        }
        if (firstReuseChunk.canRefreshCurOffsetForReuseChunk()) {
            this.downloadCache.updateDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getHostChunkIndex(), j);
        }
        firstReuseChunk.setCurrentOffset(j);
        this.downloadCache.updateSubDownloadChunk(firstReuseChunk.getId(), firstReuseChunk.getChunkIndex(), firstReuseChunk.getHostChunkIndex(), j);
    }

    public void cancel() {
        this.canceled = true;
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.cancel();
        }
    }

    public int getChunkIndex() {
        return this.downloadChunk.getChunkIndex();
    }

    public void pause() {
        this.paused = true;
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler != null) {
            downloadResponseHandler.pause();
        }
    }

    public void refreshResponseHandleOffset(long j, long j2) {
        DownloadResponseHandler downloadResponseHandler = this.downloadResponseHandler;
        if (downloadResponseHandler == null) {
            return;
        }
        downloadResponseHandler.setEndOffset(j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
        r4.curDownloadChunk.setDownloading(false);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            r0 = r4
            r1 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r1.downloadChunk
            r0.curDownloadChunk = r1
        Ld:
            r0 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r0.curDownloadChunk     // Catch: java.lang.Throwable -> L92
            r1 = r4
            r0.setChunkRunnable(r1)     // Catch: java.lang.Throwable -> L92
            r0 = r4
            r1 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r1.curDownloadChunk     // Catch: java.lang.Throwable -> L92
            boolean r0 = r0.downloadChunkInner(r1)     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L2b
            r0 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r0.curDownloadChunk     // Catch: java.lang.Throwable -> L92
            r1 = 0
            r0.setDownloading(r1)     // Catch: java.lang.Throwable -> L92
            goto L75
        L2b:
            r0 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r0.curDownloadChunk     // Catch: java.lang.Throwable -> L92
            r1 = 0
            r0.setDownloading(r1)     // Catch: java.lang.Throwable -> L92
            r0 = r4
            boolean r0 = r0.isStoppedStatus()     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L3d
            goto L75
        L3d:
            r0 = r4
            r1 = r4
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r1 = r1.callback     // Catch: java.lang.Throwable -> L92
            r2 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r2 = r2.curDownloadChunk     // Catch: java.lang.Throwable -> L92
            int r2 = r2.getChunkIndex()     // Catch: java.lang.Throwable -> L92
            com.ss.android.socialbase.downloader.model.DownloadChunk r1 = r1.getUnCompletedSubChunk(r2)     // Catch: java.lang.Throwable -> L92
            r0.curDownloadChunk = r1     // Catch: java.lang.Throwable -> L92
            r0 = r4
            boolean r0 = r0.isStoppedStatus()     // Catch: java.lang.Throwable -> L92
            if (r0 != 0) goto L75
            r0 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r0.curDownloadChunk     // Catch: java.lang.Throwable -> L92
            r5 = r0
            r0 = r5
            if (r0 != 0) goto L64
            goto L75
        L64:
            r0 = 50
            java.lang.Thread.sleep(r0)     // Catch: java.lang.Throwable -> L6d
            goto Ld
        L6d:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L92
            goto Ld
        L75:
            r0 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r0.curDownloadChunk
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L83
            r0 = r5
            r1 = 0
            r0.setDownloading(r1)
        L83:
            r0 = r4
            r0.closeConnection()
            r0 = r4
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r0 = r0.callback
            r1 = r4
            r0.onCompleted(r1)
            return
        L92:
            r5 = move-exception
            r0 = r4
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = r0.curDownloadChunk
            r6 = r0
            r0 = r6
            if (r0 == 0) goto La1
            r0 = r6
            r1 = 0
            r0.setDownloading(r1)
        La1:
            r0 = r4
            r0.closeConnection()
            r0 = r4
            com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback r0 = r0.callback
            r1 = r4
            r0.onCompleted(r1)
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable.run():void");
    }
}
