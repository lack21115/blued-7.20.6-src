package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/IDownloadCache.class */
public interface IDownloadCache {
    DownloadInfo OnDownloadTaskCancel(int i, long j);

    DownloadInfo OnDownloadTaskCompleted(int i, long j);

    DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2);

    DownloadInfo OnDownloadTaskError(int i, long j);

    DownloadInfo OnDownloadTaskIntercept(int i);

    DownloadInfo OnDownloadTaskPause(int i, long j);

    DownloadInfo OnDownloadTaskPrepare(int i);

    DownloadInfo OnDownloadTaskProgress(int i, long j);

    DownloadInfo OnDownloadTaskRetry(int i);

    void addDownloadChunk(DownloadChunk downloadChunk);

    void addSubDownloadChunk(DownloadChunk downloadChunk);

    boolean cacheExist(int i);

    void clearData();

    boolean ensureDownloadCacheSyncSuccess();

    List<DownloadInfo> getAllDownloadInfo();

    List<DownloadChunk> getDownloadChunk(int i);

    DownloadInfo getDownloadInfo(int i);

    List<DownloadInfo> getDownloadInfoList(String str);

    List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str);

    Map<Long, Segment> getSegmentMap(int i);

    List<Segment> getSegments(int i);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str);

    void init();

    boolean isDownloadCacheSyncSuccess();

    DownloadInfo onDownloadTaskStart(int i);

    void removeAllDownloadChunk(int i);

    boolean removeDownloadInfo(int i);

    boolean removeDownloadTaskData(int i);

    void removeSegments(int i);

    void syncDownloadChunks(int i, List<DownloadChunk> list);

    void syncDownloadInfo(DownloadInfo downloadInfo);

    void syncDownloadInfoFromOtherCache(int i, List<DownloadChunk> list);

    DownloadInfo updateChunkCount(int i, int i2);

    void updateDownloadChunk(int i, int i2, long j);

    boolean updateDownloadInfo(DownloadInfo downloadInfo);

    boolean updateSegments(int i, Map<Long, Segment> map);

    void updateSubDownloadChunk(int i, int i2, int i3, long j);

    void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4);
}
