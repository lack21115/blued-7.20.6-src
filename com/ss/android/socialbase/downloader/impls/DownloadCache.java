package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DownloadCache.class */
public class DownloadCache implements IDownloadCache {
    private final SparseArray<DownloadInfo> downloadInfoMap = new SparseArray<>();
    private final SparseArray<List<DownloadChunk>> chunkListMap = new SparseArray<>();
    private final SparseArray<Map<Long, Segment>> segmentListMap = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-4);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-3);
            downloadInfo.setFirstDownload(false);
            downloadInfo.setFirstSuccess(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int i, long j, String str, String str2) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setTotalBytes(j);
            downloadInfo.seteTag(str);
            if (TextUtils.isEmpty(downloadInfo.getName()) && !TextUtils.isEmpty(str2)) {
                downloadInfo.setName(str2);
            }
            downloadInfo.setStatus(3);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-1);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(-7);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(1);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int i, long j) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != -2 && !DownloadStatus.isFailedStatus(downloadInfo.getStatus()) && downloadInfo.getStatus() != -4) {
                downloadInfo.setStatus(4);
            }
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(5);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(DownloadChunk downloadChunk) {
        int id = downloadChunk.getId();
        List<DownloadChunk> list = this.chunkListMap.get(id);
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
            this.chunkListMap.put(id, arrayList);
        }
        arrayList.add(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(DownloadChunk downloadChunk) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        return getDownloadInfo(i) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        synchronized (this) {
            this.downloadInfoMap.clear();
            this.chunkListMap.clear();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        synchronized (this) {
            if (this.downloadInfoMap.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(this.downloadInfoMap.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.downloadInfoMap.size()) {
                    return arrayList;
                }
                DownloadInfo valueAt = this.downloadInfoMap.valueAt(i2);
                if (valueAt != null) {
                    arrayList.add(valueAt);
                }
                i = i2 + 1;
            }
        }
    }

    public SparseArray<List<DownloadChunk>> getChunkListMap() {
        return this.chunkListMap;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadChunk> getDownloadChunk(int i) {
        List<DownloadChunk> list;
        synchronized (this) {
            list = this.chunkListMap.get(i);
        }
        return list;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int i) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            try {
                downloadInfo = this.downloadInfoMap.get(i);
            } catch (Exception e) {
                e.printStackTrace();
                downloadInfo = null;
            }
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String str) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            try {
                int size = this.downloadInfoMap.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    DownloadInfo valueAt = this.downloadInfoMap.valueAt(i2);
                    if (str != null && str.equals(valueAt.getUrl())) {
                        arrayList.add(valueAt);
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public SparseArray<DownloadInfo> getDownloadInfoMap() {
        return this.downloadInfoMap;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.downloadInfoMap.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.downloadInfoMap.size()) {
                    return arrayList;
                }
                DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i2));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                    arrayList.add(downloadInfo);
                }
                i = i2 + 1;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int i) {
        Map<Long, Segment> map;
        synchronized (this) {
            map = this.segmentListMap.get(i);
        }
        return map;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int i) {
        synchronized (this) {
            Map<Long, Segment> map = this.segmentListMap.get(i);
            if (map != null && !map.isEmpty()) {
                return new ArrayList(map.values());
            }
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.downloadInfoMap.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.downloadInfoMap.size()) {
                    return arrayList;
                }
                DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i2));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                    arrayList.add(downloadInfo);
                }
                i = i2 + 1;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (this.downloadInfoMap.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.downloadInfoMap.size()) {
                    return arrayList;
                }
                DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i2));
                if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                    arrayList.add(downloadInfo);
                }
                i = i2 + 1;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int i) {
        DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeAllDownloadChunk(int i) {
        synchronized (this) {
            this.chunkListMap.remove(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int i) {
        synchronized (this) {
            this.downloadInfoMap.remove(i);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        removeDownloadInfo(i);
        removeAllDownloadChunk(i);
        removeSegments(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int i) {
        synchronized (this) {
            this.segmentListMap.remove(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadChunks(int i, List<DownloadChunk> list) {
        synchronized (this) {
            if (list == null) {
                return;
            }
            removeAllDownloadChunk(i);
            for (DownloadChunk downloadChunk : list) {
                if (downloadChunk != null) {
                    addDownloadChunk(downloadChunk);
                    if (downloadChunk.hasChunkDivided()) {
                        for (DownloadChunk downloadChunk2 : downloadChunk.getSubChunkList()) {
                            addDownloadChunk(downloadChunk2);
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo downloadInfo) {
        updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i, List<DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo updateChunkCount(int i, int i2) {
        DownloadInfo downloadInfo;
        synchronized (this) {
            downloadInfo = getDownloadInfo(i);
            if (downloadInfo != null) {
                downloadInfo.setChunkCount(i2);
            }
        }
        return downloadInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        r0.setCurrentOffset(r7);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateDownloadChunk(int r5, int r6, long r7) {
        /*
            r4 = this;
            r0 = r4
            monitor-enter(r0)
            r0 = r4
            r1 = r5
            java.util.List r0 = r0.getDownloadChunk(r1)     // Catch: java.lang.Throwable -> L47
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L11
            r0 = r4
            monitor-exit(r0)
            return
        L11:
            r0 = r9
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L47
            r9 = r0
        L1a:
            r0 = r9
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L44
            r0 = r9
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L47
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = (com.ss.android.socialbase.downloader.model.DownloadChunk) r0     // Catch: java.lang.Throwable -> L47
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L1a
            r0 = r10
            int r0 = r0.getChunkIndex()     // Catch: java.lang.Throwable -> L47
            r1 = r6
            if (r0 != r1) goto L1a
            r0 = r10
            r1 = r7
            r0.setCurrentOffset(r1)     // Catch: java.lang.Throwable -> L47
        L44:
            r0 = r4
            monitor-exit(r0)
            return
        L47:
            r9 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.DownloadCache.updateDownloadChunk(int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo downloadInfo) {
        synchronized (this) {
            boolean z = true;
            if (downloadInfo == null) {
                return true;
            }
            if (this.downloadInfoMap.get(downloadInfo.getId()) == null) {
                z = false;
            }
            this.downloadInfoMap.put(downloadInfo.getId(), downloadInfo);
            return z;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int i, Map<Long, Segment> map) {
        synchronized (this) {
            this.segmentListMap.put(i, map);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r0.getSubChunkList() != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        r0 = r0.getSubChunkList().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (r0.hasNext() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
        r0 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007e, code lost:
        if (r0.getChunkIndex() != r6) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
        r0.setCurrentOffset(r8);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateSubDownloadChunk(int r5, int r6, int r7, long r8) {
        /*
            r4 = this;
            r0 = r4
            monitor-enter(r0)
            r0 = r4
            r1 = r5
            java.util.List r0 = r0.getDownloadChunk(r1)     // Catch: java.lang.Throwable -> L8b
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L11
            r0 = r4
            monitor-exit(r0)
            return
        L11:
            r0 = r10
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L8b
            r10 = r0
        L1a:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L88
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L8b
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = (com.ss.android.socialbase.downloader.model.DownloadChunk) r0     // Catch: java.lang.Throwable -> L8b
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L1a
            r0 = r11
            int r0 = r0.getChunkIndex()     // Catch: java.lang.Throwable -> L8b
            r1 = r7
            if (r0 != r1) goto L1a
            r0 = r11
            boolean r0 = r0.hasChunkDivided()     // Catch: java.lang.Throwable -> L8b
            if (r0 != 0) goto L1a
            r0 = r11
            java.util.List r0 = r0.getSubChunkList()     // Catch: java.lang.Throwable -> L8b
            if (r0 != 0) goto L51
            goto L88
        L51:
            r0 = r11
            java.util.List r0 = r0.getSubChunkList()     // Catch: java.lang.Throwable -> L8b
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L8b
            r10 = r0
        L5d:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L88
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L8b
            com.ss.android.socialbase.downloader.model.DownloadChunk r0 = (com.ss.android.socialbase.downloader.model.DownloadChunk) r0     // Catch: java.lang.Throwable -> L8b
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L5d
            r0 = r11
            int r0 = r0.getChunkIndex()     // Catch: java.lang.Throwable -> L8b
            r1 = r6
            if (r0 != r1) goto L5d
            r0 = r11
            r1 = r8
            r0.setCurrentOffset(r1)     // Catch: java.lang.Throwable -> L8b
        L88:
            r0 = r4
            monitor-exit(r0)
            return
        L8b:
            r10 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.DownloadCache.updateSubDownloadChunk(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) {
    }
}
