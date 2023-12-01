package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/thread/IDownloadRunnableCallback.class */
public interface IDownloadRunnableCallback {
    boolean canRetry(BaseException baseException);

    void checkSpaceOverflow(long j) throws BaseException;

    DownloadChunk getUnCompletedSubChunk(int i);

    void handleFirstConnection(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection, long j) throws BaseException, RetryThrowable;

    void onAllChunkRetryWithReset(BaseException baseException, boolean z);

    void onChunkDowngradeRetry(BaseException baseException);

    void onCompleted(DownloadChunkRunnable downloadChunkRunnable);

    void onError(BaseException baseException);

    boolean onProgress(long j) throws BaseException;

    RetryCheckStatus onRetry(BaseException baseException, long j);

    RetryCheckStatus onSingleChunkRetry(DownloadChunk downloadChunk, BaseException baseException, long j);

    void setHttpResponseStatus(IDownloadHeadHttpConnection iDownloadHeadHttpConnection);
}
