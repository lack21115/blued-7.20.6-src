package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.d.a.b;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpResponse;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.DownloadDnsManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import com.ss.android.socialbase.downloader.utils.DownloadStenographer;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/SegmentDispatcher.class */
public class SegmentDispatcher implements DownloadDnsManager.Callback, ISegmentCallback {
    private static final int READ_WATCH_TIME = 2000;
    private static final String TAG = "SegmentDispatcher";
    private final BufferQueue bufferQueue;
    private long connectTimeout;
    private final boolean debug;
    private final DownloadInfo downloadInfo;
    private BaseException failedException;
    private HttpResponse firstBackupUrlHttpResponse;
    private final IDownloadRunnableCallback hostCallback;
    private volatile boolean isAllContentDownloaded;
    private long lastReconnectTime;
    private HttpResponse mainUrlHttpResponse;
    private float poorSpeedRatio;
    private long readTimeout;
    private int reconnectCount;
    private final DownloadStenographer stenographer;
    private final SegmentStrategy strategy;
    private long totalLength;
    private int urlIndex;
    private final DownloadWatchDog watchDog;
    private final MultiSegmentWriter writer;
    private volatile boolean canceled = false;
    private volatile boolean paused = false;
    private final List<SegmentReader> readers = new ArrayList();
    private final List<UrlRecord> urlRecords = new ArrayList();
    private volatile boolean needWaitDnsResolve = true;
    private final LinkedList<Segment> toDispatchSegments = new LinkedList<>();
    private final List<Segment> dispatchedSegments = new ArrayList();
    private final Object firstConnectionLock = new Object();
    private volatile boolean allReaderFailed = false;
    private final DownloadWatchDog.IWatcher connectWatcher = new DownloadWatchDog.IWatcher() { // from class: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.1
        private int watchTimes;

        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            if (SegmentDispatcher.this.canceled || SegmentDispatcher.this.paused) {
                return -1L;
            }
            synchronized (SegmentDispatcher.this) {
                if (SegmentDispatcher.this.mainUrlHttpResponse == null && SegmentDispatcher.this.firstBackupUrlHttpResponse == null) {
                    long j = SegmentDispatcher.this.connectTimeout;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.watchTimes++;
                    SegmentReader findEarliestConnectTimeoutReader = SegmentDispatcher.this.findEarliestConnectTimeoutReader(false, System.currentTimeMillis(), j);
                    if (findEarliestConnectTimeoutReader != null) {
                        Log.i(SegmentDispatcher.TAG, "connectWatcher: switchUrl and reconnect");
                        SegmentDispatcher.this.trySwitchNextUrlForReader(findEarliestConnectTimeoutReader);
                        findEarliestConnectTimeoutReader.reconnect();
                        return ((this.watchTimes / SegmentDispatcher.this.urlRecords.size()) + 1) * j;
                    }
                    return j;
                }
                return -1L;
            }
        }
    };
    private final DownloadWatchDog.IWatcher readWatcher = new DownloadWatchDog.IWatcher() { // from class: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.2
        @Override // com.ss.android.socialbase.downloader.thread.DownloadWatchDog.IWatcher
        public long onScheduleWatch() {
            return SegmentDispatcher.this.scheduleWatchRead();
        }
    };

    public SegmentDispatcher(DownloadInfo downloadInfo, SegmentStrategy segmentStrategy, IDownloadRunnableCallback iDownloadRunnableCallback) {
        boolean z = false;
        this.downloadInfo = downloadInfo;
        this.strategy = segmentStrategy;
        BufferQueue bufferQueue = new BufferQueue(segmentStrategy.getBufferCount(), this.strategy.getBufferSize());
        this.bufferQueue = bufferQueue;
        this.hostCallback = iDownloadRunnableCallback;
        this.writer = new MultiSegmentWriter(downloadInfo, iDownloadRunnableCallback, bufferQueue);
        this.watchDog = new DownloadWatchDog();
        this.stenographer = new DownloadStenographer();
        this.debug = DownloadSetting.obtain(downloadInfo.getId()).optInt("debug") == 1 ? true : z;
    }

    private void addIpListLocked(String str, List<UrlRecord> list) {
        int indexOfUrl;
        if (this.debug) {
            for (UrlRecord urlRecord : list) {
                Log.i(TAG, "addIpListLocked: urlRecord = " + urlRecord);
            }
        }
        int ipStrategy = this.strategy.getIpStrategy();
        if ((ipStrategy == 1 || ipStrategy == 3) && (indexOfUrl = indexOfUrl(str)) >= 0 && indexOfUrl < this.urlRecords.size()) {
            this.urlRecords.addAll(indexOfUrl + 1, list);
        } else {
            this.urlRecords.addAll(list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void applySegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader r8, com.ss.android.socialbase.downloader.segment.Segment r9) throws com.ss.android.socialbase.downloader.segment.SegmentApplyException {
        /*
            Method dump skipped, instructions count: 1222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.applySegmentLocked(com.ss.android.socialbase.downloader.segment.SegmentReader, com.ss.android.socialbase.downloader.segment.Segment):void");
    }

    private void arrangeSegmentLocked(List<Segment> list, Segment segment, boolean z) {
        int i;
        long startOffset = segment.getStartOffset();
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= size || startOffset < list.get(i).getStartOffset()) {
                break;
            }
            i2 = i + 1;
        }
        list.add(i, segment);
        if (z) {
            segment.setIndex(size);
        }
    }

    private List<UrlRecord> assembleIpAddress(String str, List<InetAddress> list) {
        boolean z;
        if (list == null || list.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (InetAddress inetAddress : list) {
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (this.debug) {
                        Log.i(TAG, "onDnsResolved: ip = " + hostAddress);
                    }
                    UrlRecord urlRecord = new UrlRecord(str, hostAddress);
                    LinkedList linkedList = (LinkedList) linkedHashMap.get(urlRecord.ipFamily);
                    LinkedList linkedList2 = linkedList;
                    if (linkedList == null) {
                        linkedList2 = new LinkedList();
                        linkedHashMap.put(urlRecord.ipFamily, linkedList2);
                    }
                    linkedList2.add(urlRecord);
                    i++;
                }
            }
        }
        if (i > 0) {
            ArrayList arrayList = new ArrayList();
            int i2 = i;
            do {
                z = false;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    LinkedList linkedList3 = (LinkedList) entry.getValue();
                    if (linkedList3 != null && !linkedList3.isEmpty()) {
                        arrayList.add((UrlRecord) linkedList3.pollFirst());
                        i2--;
                        z = true;
                    }
                }
                if (i2 <= 0) {
                    break;
                }
            } while (z);
            return arrayList;
        }
        return null;
    }

    private void checkDownloadedBytesLocked(List<Segment> list) {
        long downloadedBytes = SegmentUtils.getDownloadedBytes(list);
        Logger.i(TAG, "checkDownloadBytes: getCurBytes = " + this.downloadInfo.getCurBytes() + ", totalBytes = " + this.downloadInfo.getTotalBytes() + ", downloadedBytes = " + downloadedBytes);
        long j = downloadedBytes;
        if (downloadedBytes > this.downloadInfo.getTotalBytes()) {
            j = downloadedBytes;
            if (this.downloadInfo.getTotalBytes() > 0) {
                j = this.downloadInfo.getTotalBytes();
            }
        }
        if (this.downloadInfo.getCurBytes() == this.downloadInfo.getTotalBytes() || this.downloadInfo.getCurBytes() == j) {
            return;
        }
        this.downloadInfo.setCurBytes(j);
    }

    private void checkSegmentHttpResponseLocked(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws BaseException, RetryThrowable {
        SegmentReader segmentReader2 = segment.owner;
        if (segmentReader2 != null && segmentReader2 != segmentReader) {
            throw new SegmentApplyException(1, "segment already has an owner");
        }
        if (segmentReader.getStartOffsetInConnection() != segment.getCurrentOffsetRead()) {
            throw new SegmentApplyException(5, "applySegment");
        }
        if (!httpResponse.acceptPartial()) {
            if (segment.getCurrentOffsetRead() > 0) {
                int i = httpResponse.responseCode;
                throw new DownloadHttpException(1004, i, "1: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
            Logger.e(TAG, "parseHttpResponse: segment.getCurrentOffsetRead = " + segment.getCurrentOffsetRead());
            if (!httpResponse.isResponseDataFromBegin()) {
                int i2 = httpResponse.responseCode;
                throw new DownloadHttpException(1004, i2, "2: response code error : " + httpResponse.responseCode + " segment=" + segment);
            }
        }
        if (!urlRecord.isMainUrl) {
            validateHttpResponse(httpResponse);
            if (this.firstBackupUrlHttpResponse == null) {
                this.firstBackupUrlHttpResponse = httpResponse;
                if (this.downloadInfo.getTotalBytes() <= 0) {
                    long totalLength = httpResponse.getTotalLength();
                    Logger.i(TAG, "checkSegmentHttpResponse:len=" + totalLength + ",url=" + urlRecord.url);
                    this.downloadInfo.setTotalBytes(totalLength);
                }
                synchronized (this.firstConnectionLock) {
                    this.firstConnectionLock.notify();
                }
            }
        } else if (this.mainUrlHttpResponse == null) {
            this.mainUrlHttpResponse = httpResponse;
            synchronized (this.firstConnectionLock) {
                this.firstConnectionLock.notify();
            }
            IDownloadRunnableCallback iDownloadRunnableCallback = this.hostCallback;
            if (iDownloadRunnableCallback != null) {
                iDownloadRunnableCallback.handleFirstConnection(urlRecord.url, httpResponse.connection, segment.getCurrentOffsetRead());
            }
            long totalLength2 = httpResponse.getTotalLength();
            if (totalLength2 > 0) {
                for (Segment segment2 : this.dispatchedSegments) {
                    if (segment2.getEndOffset() <= 0 || segment2.getEndOffset() > totalLength2 - 1) {
                        segment2.setEndOffset(totalLength2 - 1);
                    }
                }
            }
        }
    }

    private void clearCoveredSegmentLocked() {
        int size;
        ArrayList arrayList;
        int i;
        if (this.totalLength > 0 && (size = this.dispatchedSegments.size()) > 1) {
            ArrayList<Segment> arrayList2 = null;
            int i2 = 0;
            int i3 = 1;
            while (i3 < size) {
                Segment segment = this.dispatchedSegments.get(i2);
                Segment segment2 = this.dispatchedSegments.get(i3);
                if (segment.getCurrentOffsetRead() <= segment2.getStartOffset() || segment2.getDownloadBytes() > 0 || segment2.owner != null) {
                    arrayList = arrayList2;
                    i = i2;
                    if (segment2.getCurrentOffsetRead() > segment.getCurrentOffsetRead()) {
                        i = i2 + 1;
                        arrayList = arrayList2;
                    }
                } else {
                    ArrayList arrayList3 = arrayList2;
                    if (arrayList2 == null) {
                        arrayList3 = new ArrayList(1);
                    }
                    arrayList3.add(segment2);
                    arrayList = arrayList3;
                    i = i2;
                    if (this.debug) {
                        Log.w(TAG, "clearCovered, covered = " + segment2 + ", prev = " + segment);
                        arrayList = arrayList3;
                        i = i2;
                    }
                }
                i3++;
                arrayList2 = arrayList;
                i2 = i;
            }
            if (arrayList2 != null) {
                for (Segment segment3 : arrayList2) {
                    this.dispatchedSegments.remove(segment3);
                    for (SegmentReader segmentReader : this.readers) {
                        if (segmentReader.curSegment == segment3) {
                            if (this.debug) {
                                Log.w(TAG, "clearCoveredSegmentLocked: reconnect, segment = " + segment3 + ", threadIndex = " + segmentReader.threadIndex);
                            }
                            segmentReader.reconnect(true);
                        }
                    }
                }
            }
        }
    }

    private void dispatchReadThread() {
        int i;
        if (this.totalLength <= 0 || this.needWaitDnsResolve) {
            i = 1;
        } else {
            int threadCount = this.strategy.getThreadCount();
            int segmentMinInitSize = (int) (this.totalLength / this.strategy.getSegmentMinInitSize());
            i = threadCount;
            if (threadCount > segmentMinInitSize) {
                i = segmentMinInitSize;
            }
        }
        Logger.i(TAG, "dispatchReadThread: totalLength = " + this.totalLength + ", threadCount = " + i);
        if (i <= 0) {
            i = 1;
        }
        synchronized (this) {
            do {
                if (this.readers.size() >= i) {
                    break;
                }
                if (!this.paused && !this.canceled) {
                    dispatchReadThreadOnce(obtainUrl());
                }
                return;
            } while (!this.strategy.segmentOneByOne());
        }
    }

    private void dispatchReadThreadOnce(UrlRecord urlRecord) {
        SegmentReader segmentReader = new SegmentReader(this.downloadInfo, this, this.bufferQueue, urlRecord, this.readers.size());
        this.readers.add(segmentReader);
        segmentReader.setFuture(DownloadComponentManager.getChunkDownloadThreadExecutorService().submit(segmentReader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SegmentReader findEarliestConnectTimeoutReader(boolean z, long j, long j2) {
        SegmentReader segmentReader = null;
        for (SegmentReader segmentReader2 : this.readers) {
            if (segmentReader2.threadIndex != 0 || z) {
                if (segmentReader2.connectStartTime > 0 && segmentReader2.connectEndTime <= 0 && j - segmentReader2.connectStartTime > j2 && (segmentReader == null || segmentReader2.connectStartTime < segmentReader.connectStartTime)) {
                    segmentReader = segmentReader2;
                }
            }
        }
        return segmentReader;
    }

    private UrlRecord findNextUrlLocked(SegmentReader segmentReader) {
        UrlRecord urlRecord;
        Iterator<UrlRecord> it = this.urlRecords.iterator();
        UrlRecord urlRecord2 = null;
        while (true) {
            if (!it.hasNext()) {
                urlRecord = null;
                break;
            }
            urlRecord = it.next();
            if (urlRecord != segmentReader.urlRecord && !urlRecord.isCurrentFailed()) {
                UrlRecord urlRecord3 = urlRecord2;
                if (urlRecord2 == null) {
                    urlRecord3 = urlRecord;
                }
                urlRecord2 = urlRecord3;
                if (urlRecord.getCurrentUsers() <= 0) {
                    urlRecord2 = urlRecord3;
                    break;
                }
            }
        }
        if (this.strategy.urlBalance()) {
            if (urlRecord != null) {
                return urlRecord;
            }
            if (this.strategy.urlBalanceStrictly()) {
                return null;
            }
        }
        return urlRecord2;
    }

    private SegmentReader findPoorReadThread(long j, long j2, long j3, int i) {
        long j4 = Long.MAX_VALUE;
        int i2 = 0;
        SegmentReader segmentReader = null;
        for (SegmentReader segmentReader2 : this.readers) {
            if (segmentReader2.readStartTime > 0) {
                i2++;
                if (segmentReader2.readStartTime < j) {
                    long recentDownloadSpeed = segmentReader2.getRecentDownloadSpeed(j, j2);
                    if (this.debug) {
                        Log.i(TAG, "findPoorReadThread: speed = " + recentDownloadSpeed + ", threadIndex = " + segmentReader2.threadIndex);
                    }
                    if (recentDownloadSpeed >= 0 && recentDownloadSpeed < j4) {
                        j4 = recentDownloadSpeed;
                        segmentReader = segmentReader2;
                    }
                }
            }
        }
        if (segmentReader == null || i2 < i || j4 >= j3) {
            return null;
        }
        Logger.i(TAG, "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + segmentReader.threadIndex);
        return segmentReader;
    }

    private boolean findPoorReadThreadAndReconnect(long j, long j2) {
        long j3 = j - j2;
        long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j3, j);
        int size = this.readers.size();
        long j4 = recentDownloadSpeed;
        if (size > 0) {
            j4 = recentDownloadSpeed / size;
        }
        SegmentReader findPoorReadThread = findPoorReadThread(j3, j, Math.max(10.0f, ((float) j4) * this.poorSpeedRatio), size / 2);
        if (findPoorReadThread != null) {
            trySwitchNextUrlForReader(findPoorReadThread);
            Logger.w(TAG, "handlePoorReadThread: reconnect for poor speed, threadIndex = " + findPoorReadThread.threadIndex);
            findPoorReadThread.reconnect();
            return true;
        }
        SegmentReader findEarliestConnectTimeoutReader = findEarliestConnectTimeoutReader(true, j, j2);
        if (findEarliestConnectTimeoutReader != null) {
            trySwitchNextUrlForReader(findEarliestConnectTimeoutReader);
            Logger.w(TAG, "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + findEarliestConnectTimeoutReader.threadIndex);
            findEarliestConnectTimeoutReader.reconnect();
            return true;
        }
        return false;
    }

    private void fixSegmentsLocked(List<Segment> list) {
        Segment segment = list.get(0);
        long startOffset = segment.getStartOffset();
        if (startOffset > 0) {
            Segment segment2 = new Segment(0L, startOffset - 1);
            Log.w(TAG, "fixSegmentsLocked: first = " + segment + ", add new first = " + segment2);
            arrangeSegmentLocked(list, segment2, true);
        }
        Iterator<Segment> it = list.iterator();
        if (it.hasNext()) {
            Segment next = it.next();
            while (true) {
                Segment segment3 = next;
                if (!it.hasNext()) {
                    break;
                }
                Segment next2 = it.next();
                if (segment3.getEndOffset() < next2.getStartOffset() - 1) {
                    Logger.w(TAG, "fixSegment: segment = " + segment3 + ", new end = " + (next2.getStartOffset() - 1));
                    segment3.setEndOffset(next2.getStartOffset() - 1);
                }
                next = next2;
            }
        }
        Segment segment4 = list.get(list.size() - 1);
        long totalBytes = this.downloadInfo.getTotalBytes();
        if (totalBytes <= 0 || (segment4.getEndOffset() != -1 && segment4.getEndOffset() < totalBytes - 1)) {
            Logger.w(TAG, "fixSegment: last segment = " + segment4 + ", new end=-1");
            segment4.setEndOffset(-1L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0045, code lost:
        if (r0 >= 1.0f) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float getDownloadRatio(com.ss.android.socialbase.downloader.segment.SegmentReader r6, com.ss.android.socialbase.downloader.segment.UrlRecord r7) {
        /*
            r5 = this;
            r0 = r6
            long r0 = r0.getReadBytes()
            r13 = r0
            r0 = r5
            java.util.List<com.ss.android.socialbase.downloader.segment.SegmentReader> r0 = r0.readers
            int r0 = r0.size()
            r12 = r0
            r0 = r12
            r11 = r0
            r0 = r12
            r1 = 1
            if (r0 > r1) goto L24
            r0 = r5
            com.ss.android.socialbase.downloader.segment.SegmentStrategy r0 = r0.strategy
            int r0 = r0.getThreadCount()
            r11 = r0
        L24:
            r0 = 1065353216(0x3f800000, float:1.0)
            r9 = r0
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L73
            r0 = r5
            com.ss.android.socialbase.downloader.segment.SegmentStrategy r0 = r0.strategy
            float r0 = r0.getMainRatio()
            r10 = r0
            r0 = r10
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L48
            r0 = r10
            r8 = r0
            r0 = r10
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L4e
        L48:
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = r11
            float r1 = (float) r1
            float r0 = r0 / r1
            r8 = r0
        L4e:
            r0 = r6
            int r0 = r0.threadIndex
            if (r0 != 0) goto L57
            r0 = r8
            return r0
        L57:
            r0 = r11
            r12 = r0
            r0 = r11
            r1 = 1
            if (r0 <= r1) goto L6c
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = r8
            float r0 = r0 - r1
            r9 = r0
            r0 = r11
            r1 = 1
            int r0 = r0 - r1
            r12 = r0
        L6c:
            r0 = r9
            r1 = r12
            float r1 = (float) r1
            float r0 = r0 / r1
            return r0
        L73:
            r0 = r5
            long r0 = r0.getTotalReadBytes()
            r15 = r0
            r0 = r11
            r12 = r0
            r0 = r15
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L6c
            r0 = r13
            float r0 = (float) r0
            r1 = r15
            float r1 = (float) r1
            float r0 = r0 / r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.segment.SegmentDispatcher.getDownloadRatio(com.ss.android.socialbase.downloader.segment.SegmentReader, com.ss.android.socialbase.downloader.segment.UrlRecord):float");
    }

    private long getRemainReadBytes(Segment segment) {
        long remainReadBytes = segment.getRemainReadBytes();
        long j = remainReadBytes;
        if (remainReadBytes == -1) {
            long j2 = this.totalLength;
            j = remainReadBytes;
            if (j2 > 0) {
                j = j2 - segment.getCurrentOffsetRead();
            }
        }
        return j;
    }

    private long getTotalReadBytes() {
        Iterator<SegmentReader> it = this.readers.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = j2 + it.next().getReadBytes();
        }
    }

    private long getUnconfirmedRemainBytes(int i, int i2) {
        Segment segment = this.dispatchedSegments.get(i);
        long remainReadBytes = getRemainReadBytes(segment);
        int i3 = i + 1;
        Segment segment2 = i3 < i2 ? this.dispatchedSegments.get(i3) : null;
        if (segment2 == null) {
            return remainReadBytes;
        }
        long startOffset = segment2.getStartOffset() - segment.getCurrentOffsetRead();
        return remainReadBytes == -1 ? startOffset : Math.min(remainReadBytes, startOffset);
    }

    private int indexOfSegmentLocked(long j) {
        int size = this.dispatchedSegments.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return -1;
            }
            Segment segment = this.dispatchedSegments.get(i2);
            if (segment.getStartOffset() == j) {
                return i2;
            }
            if (segment.getStartOffset() > j) {
                return -1;
            }
            i = i2 + 1;
        }
    }

    private int indexOfUrl(String str) {
        int size = this.urlRecords.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return -1;
            }
            if (TextUtils.equals(this.urlRecords.get(i2).url, str)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private void initDns() {
        List<String> backUpUrls;
        int ipStrategy = this.strategy.getIpStrategy();
        if (ipStrategy <= 0) {
            this.needWaitDnsResolve = false;
            dispatchReadThread();
            return;
        }
        DownloadDnsManager downloadDnsManager = DownloadDnsManager.getInstance();
        downloadDnsManager.resolveDnsAsync(this.downloadInfo.getUrl(), this, 2000L);
        if (ipStrategy <= 2 || (backUpUrls = this.downloadInfo.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                downloadDnsManager.resolveDnsAsync(str, this, 2000L);
            }
        }
    }

    private void initSegments(List<Segment> list) {
        long totalBytes = this.downloadInfo.getTotalBytes();
        this.totalLength = totalBytes;
        if (totalBytes <= 0) {
            this.totalLength = this.downloadInfo.getExpectFileLength();
            Logger.i(TAG, "initSegments: getExpectFileLength = " + this.totalLength);
        }
        synchronized (this) {
            this.toDispatchSegments.clear();
            if (list != null && !list.isEmpty()) {
                for (Segment segment : list) {
                    arrangeSegmentLocked(this.toDispatchSegments, new Segment(segment), false);
                }
                fixSegmentsLocked(this.toDispatchSegments);
                checkDownloadedBytesLocked(this.toDispatchSegments);
                Logger.i(TAG, "initSegments: totalLength = " + this.totalLength);
            }
            arrangeSegmentLocked(this.toDispatchSegments, new Segment(0L, -1L), false);
            Logger.i(TAG, "initSegments: totalLength = " + this.totalLength);
        }
    }

    private void initUrlRecords() {
        this.urlRecords.add(new UrlRecord(this.downloadInfo.getUrl(), true));
        List<String> backUpUrls = this.downloadInfo.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.urlRecords.add(new UrlRecord(str, false));
                }
            }
        }
        this.strategy.updateUrlCount(this.urlRecords.size());
    }

    private void initWatchDog() {
        SegmentStrategy segmentStrategy = this.strategy;
        this.connectTimeout = segmentStrategy.getConnectTimeout();
        this.readTimeout = segmentStrategy.getReadTimeout();
        this.poorSpeedRatio = segmentStrategy.getPoorSpeedRatio();
        int i = this.reconnectCount;
        if (i > 0) {
            this.watchDog.addWatcher(this.connectWatcher, i);
        }
    }

    private void initWatchDog2() {
        if (this.readTimeout > 0) {
            this.lastReconnectTime = System.currentTimeMillis();
            this.watchDog.addWatcher(this.readWatcher, 0L);
        }
    }

    private boolean isAllContentDownloaded() {
        long j = this.totalLength;
        if (j <= 0) {
            this.isAllContentDownloaded = false;
            return false;
        }
        synchronized (this) {
            long firstOffset = SegmentUtils.getFirstOffset(this.dispatchedSegments);
            Logger.i(TAG, "isAllContentDownloaded: firstOffset = " + firstOffset);
            if (firstOffset >= j) {
                this.isAllContentDownloaded = true;
                return true;
            }
            this.isAllContentDownloaded = false;
            return false;
        }
    }

    private boolean isAllReaderFailedLocked() {
        for (SegmentReader segmentReader : this.readers) {
            if (!segmentReader.isFailed()) {
                return false;
            }
        }
        return true;
    }

    private boolean isDownloadSpeedPoor(SegmentReader segmentReader, long j, long j2, long j3, double d) {
        if (segmentReader.readStartTime > 0) {
            long recentDownloadSpeed = this.stenographer.getRecentDownloadSpeed(j, j2);
            int size = this.readers.size();
            long j4 = size > 0 ? recentDownloadSpeed / size : recentDownloadSpeed;
            long recentDownloadSpeed2 = segmentReader.getRecentDownloadSpeed(j, j2);
            if (recentDownloadSpeed2 < j3 || recentDownloadSpeed2 < j4 * d) {
                Log.i(TAG, "isDownloadSpeedPoor: totalSpeed = " + recentDownloadSpeed + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + recentDownloadSpeed2 + ",threadIndex = " + segmentReader.threadIndex);
                return true;
            }
            return false;
        }
        return false;
    }

    private void markProgress(long j) {
        this.stenographer.markProgress(this.downloadInfo.getCurBytes(), j);
        for (SegmentReader segmentReader : this.readers) {
            segmentReader.markProgress(j);
        }
    }

    private Segment obtainChildSegmentFromMaxRemain(SegmentReader segmentReader, UrlRecord urlRecord) {
        int size = this.dispatchedSegments.size();
        long j = -1;
        int i = -1;
        int i2 = 0;
        while (i2 < size) {
            long unconfirmedRemainBytes = getUnconfirmedRemainBytes(i2, size);
            long j2 = j;
            if (unconfirmedRemainBytes > j) {
                i = i2;
                j2 = unconfirmedRemainBytes;
            }
            i2++;
            j = j2;
        }
        long segmentMinSize = this.strategy.getSegmentMinSize();
        long segmentMaxSize = this.strategy.getSegmentMaxSize();
        if (i < 0 || j <= segmentMinSize) {
            return null;
        }
        Segment segment = this.dispatchedSegments.get(i);
        int ratioSegmentStrategy = this.dispatchedSegments.size() < this.readers.size() ? 2 : this.strategy.getRatioSegmentStrategy();
        if (ratioSegmentStrategy == 1) {
            SegmentReader segmentReader2 = segment.owner;
            if (segmentReader2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = currentTimeMillis - 4000;
                long recentDownloadSpeed = segmentReader2.getRecentDownloadSpeed(j3, currentTimeMillis);
                long recentDownloadSpeed2 = segmentReader.getRecentDownloadSpeed(j3, currentTimeMillis);
                float f = (recentDownloadSpeed <= 0 || recentDownloadSpeed2 <= 0) ? -1.0f : ((float) recentDownloadSpeed2) / ((float) (recentDownloadSpeed + recentDownloadSpeed2));
                if (f == -1.0f) {
                    long readBytes = segmentReader2.getReadBytes();
                    long readBytes2 = segmentReader.getReadBytes();
                    if (readBytes > 0 && readBytes2 > 0) {
                        f = ((float) readBytes2) / ((float) (readBytes + readBytes2));
                    }
                }
                if (f > 0.0f) {
                    float f2 = f * 0.9f;
                    long j4 = ((float) j) * f2;
                    long j5 = j4;
                    if (j4 < segmentMinSize) {
                        j5 = segmentMinSize;
                    }
                    if (segmentMaxSize > 0 && j5 > segmentMaxSize) {
                        j5 = segmentMaxSize;
                    }
                    long j6 = segmentMinSize / 2;
                    long j7 = j - j6;
                    if (j5 <= j7) {
                        j7 = j5;
                        if (j5 < j6) {
                            j7 = j6;
                        }
                    }
                    Segment segment2 = new Segment(segment.getCurrentOffsetRead() + (j - j7), segment.getEndOffset());
                    Logger.i(TAG, "obtainSegment: parent = " + segment + ", child = " + segment2 + ", maxRemainBytes = " + j + ", childLength = " + j7 + ", ratio = " + f2 + ", threadIndex = " + segmentReader.threadIndex);
                    return segment2;
                }
            }
        } else if (ratioSegmentStrategy == 2) {
            long j8 = this.totalLength;
            long curBytes = this.downloadInfo.getCurBytes();
            float downloadRatio = getDownloadRatio(segmentReader, urlRecord);
            long j9 = ((float) (j8 - curBytes)) * downloadRatio;
            long j10 = j9;
            if (j9 < segmentMinSize) {
                j10 = segmentMinSize;
            }
            if (segmentMaxSize > 0 && j10 > segmentMaxSize) {
                j10 = segmentMaxSize;
            }
            long j11 = segmentMinSize / 2;
            long j12 = j - j11;
            if (j10 <= j12) {
                j12 = j10;
                if (j10 < j11) {
                    j12 = j11;
                }
            }
            Segment segment3 = new Segment(segment.getCurrentOffsetRead() + (j - j12), segment.getEndOffset());
            Logger.i(TAG, "obtainSegment: parent = " + segment + ", child = " + segment3 + ", maxRemainBytes = " + j + ", childLength = " + j12 + ", ratio = " + downloadRatio + ", threadIndex = " + segmentReader.threadIndex);
            return segment3;
        }
        Segment segment4 = new Segment(segment.getCurrentOffsetRead() + (j / 2), segment.getEndOffset());
        Logger.i(TAG, "obtainSegment: parent = " + segment + ",child = " + segment4);
        return segment4;
    }

    private Segment obtainLeastCompetitorSegment() {
        int competitor;
        Segment segment = null;
        int i = Integer.MAX_VALUE;
        for (Segment segment2 : this.dispatchedSegments) {
            if (getRemainReadBytes(segment2) > 0 && (competitor = segment2.getCompetitor()) < i) {
                segment = segment2;
                i = competitor;
            }
        }
        return segment;
    }

    private Segment obtainSegmentLocked(SegmentReader segmentReader, UrlRecord urlRecord) {
        while (!this.toDispatchSegments.isEmpty()) {
            Segment poll = this.toDispatchSegments.poll();
            if (poll != null) {
                arrangeSegmentLocked(this.dispatchedSegments, poll, true);
                if (getRemainReadBytes(poll) > 0 || this.totalLength <= 0) {
                    return poll;
                }
            }
        }
        clearCoveredSegmentLocked();
        Segment obtainChildSegmentFromMaxRemain = obtainChildSegmentFromMaxRemain(segmentReader, urlRecord);
        if (obtainChildSegmentFromMaxRemain != null && getRemainReadBytes(obtainChildSegmentFromMaxRemain) > 0) {
            arrangeSegmentLocked(this.dispatchedSegments, obtainChildSegmentFromMaxRemain, true);
            return obtainChildSegmentFromMaxRemain;
        }
        Segment obtainSegmentWhenNoNewSegment = obtainSegmentWhenNoNewSegment();
        if (obtainSegmentWhenNoNewSegment != null) {
            return obtainSegmentWhenNoNewSegment;
        }
        return null;
    }

    private Segment obtainSegmentWhenNoNewSegment() {
        int i = 0;
        while (true) {
            int i2 = i;
            Segment obtainLeastCompetitorSegment = obtainLeastCompetitorSegment();
            if (obtainLeastCompetitorSegment == null) {
                return null;
            }
            SegmentReader segmentReader = obtainLeastCompetitorSegment.owner;
            if (segmentReader == null) {
                return obtainLeastCompetitorSegment;
            }
            if (obtainLeastCompetitorSegment.getCompetitor() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            markProgress(currentTimeMillis);
            if (currentTimeMillis - segmentReader.readStartTime > 2000 && isDownloadSpeedPoor(segmentReader, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.debug) {
                    Log.i(TAG, "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + obtainLeastCompetitorSegment + ", owner.threadIndex = " + segmentReader.threadIndex);
                }
                return obtainLeastCompetitorSegment;
            } else if (i2 > 2) {
                if (this.debug) {
                    Log.i(TAG, "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + obtainLeastCompetitorSegment);
                }
                return obtainLeastCompetitorSegment;
            } else {
                try {
                    synchronized (this) {
                        wait(500L);
                    }
                    i = i2 + 1;
                } catch (InterruptedException e) {
                    return null;
                }
            }
        }
    }

    private UrlRecord obtainUrl() {
        UrlRecord urlRecord;
        synchronized (this) {
            int i = this.urlIndex;
            int size = this.urlRecords.size();
            if (this.strategy.urlBalance()) {
                this.urlIndex++;
            }
            urlRecord = this.urlRecords.get(i % size);
        }
        return urlRecord;
    }

    private void onComplete() {
        Logger.i(TAG, "onComplete");
        this.bufferQueue.close();
        synchronized (this.firstConnectionLock) {
            this.firstConnectionLock.notify();
        }
    }

    private void onError(BaseException baseException) {
        Logger.e(TAG, "onError, e = " + baseException);
        this.failedException = baseException;
        this.bufferQueue.close();
        synchronized (this) {
            for (SegmentReader segmentReader : this.readers) {
                segmentReader.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long scheduleWatchRead() {
        if (this.canceled || this.paused) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            markProgress(currentTimeMillis);
            long readTimeout = this.strategy.getReadTimeout();
            if (readTimeout > 0) {
                long j = this.lastReconnectTime;
                if (j > 0 && currentTimeMillis - j > readTimeout && findPoorReadThreadAndReconnect(currentTimeMillis, readTimeout)) {
                    this.lastReconnectTime = currentTimeMillis;
                    this.reconnectCount++;
                }
            }
        }
        return 2000L;
    }

    private void switchToNextUrl() {
        synchronized (this) {
            this.urlIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean trySwitchNextUrlForReader(SegmentReader segmentReader) {
        synchronized (this) {
            UrlRecord findNextUrlLocked = findNextUrlLocked(segmentReader);
            if (findNextUrlLocked == null) {
                return false;
            }
            return segmentReader.switchUrlRecord(findNextUrlLocked);
        }
    }

    private void validateHttpResponse(HttpResponse httpResponse) throws BaseException {
        HttpResponse httpResponse2 = this.mainUrlHttpResponse;
        HttpResponse httpResponse3 = httpResponse2;
        if (httpResponse2 == null) {
            HttpResponse httpResponse4 = this.firstBackupUrlHttpResponse;
            httpResponse3 = httpResponse4;
            if (httpResponse4 == null) {
                return;
            }
        }
        long totalLength = httpResponse.getTotalLength();
        long totalLength2 = httpResponse3.getTotalLength();
        if (totalLength != totalLength2) {
            String str = "total len not equals,len=" + totalLength + ",sLen=" + totalLength2 + ",code=" + httpResponse.responseCode + ",sCode=" + httpResponse3.responseCode + ",range=" + httpResponse.getContentRange() + ",sRange = " + httpResponse3.getContentRange() + ",url = " + httpResponse.url + ",sUrl=" + httpResponse3.url;
            Logger.e(TAG, str);
            if (totalLength > 0 && totalLength2 > 0) {
                throw new BaseException((int) DownloadErrorCode.ERROR_BAD_URL, str);
            }
        }
        String etag = httpResponse.getEtag();
        String etag2 = httpResponse3.getEtag();
        if (TextUtils.equals(etag, etag2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + etag + ", mainEtag = " + etag2;
        Logger.e(TAG, str2);
        if (!TextUtils.isEmpty(etag) && !TextUtils.isEmpty(etag2) && !etag.equalsIgnoreCase(etag2)) {
            throw new BaseException((int) DownloadErrorCode.ERROR_BAD_URL, str2);
        }
    }

    private void waitFirstConnection() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.firstConnectionLock) {
            if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null) {
                this.firstConnectionLock.wait();
            }
        }
        if (this.mainUrlHttpResponse == null && this.firstBackupUrlHttpResponse == null && (baseException = this.failedException) != null) {
            throw baseException;
        }
    }

    private void writeSegments() throws BaseException {
        try {
            this.writer.loopAndWrite(this.bufferQueue);
        } catch (StreamClosedException e) {
        } catch (BaseException e2) {
            Logger.e(TAG, "dispatchSegments: loopAndWrite e = " + e2);
            onError(e2);
            throw e2;
        }
        if (this.paused || this.canceled) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.toDispatchSegments.isEmpty()) {
                    Segment poll = this.toDispatchSegments.poll();
                    if (poll != null) {
                        arrangeSegmentLocked(this.dispatchedSegments, poll, true);
                    }
                }
                checkDownloadedBytesLocked(this.dispatchedSegments);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!this.allReaderFailed || this.failedException == null) {
            if (this.downloadInfo.getCurBytes() != this.downloadInfo.getTotalBytes()) {
                DownloadMonitorHelper.monitorSegmentsError(this.downloadInfo, this.dispatchedSegments);
            }
            Logger.i(TAG, "dispatchSegments::download finished");
            return;
        }
        Logger.e(TAG, "dispatchSegments: loopAndWrite  failedException = " + this.failedException);
        throw this.failedException;
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void applySegment(SegmentReader segmentReader, Segment segment) throws BaseException {
        synchronized (this) {
            applySegmentLocked(segmentReader, segment);
        }
    }

    public void cancel() {
        Logger.i(TAG, b.dO);
        this.canceled = true;
        synchronized (this) {
            for (SegmentReader segmentReader : this.readers) {
                segmentReader.close();
            }
        }
        this.writer.cancel();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public IOutput createOutput(SegmentReader segmentReader, Segment segment) throws BaseException {
        IOutput stub;
        synchronized (this) {
            SegmentOutput segmentOutput = new SegmentOutput(this.downloadInfo, this.bufferQueue, segment);
            this.writer.assignOutput(segmentOutput);
            stub = segmentOutput.getStub();
        }
        return stub;
    }

    /* JADX WARN: Finally extract failed */
    public boolean downloadSegments(List<Segment> list) throws BaseException, InterruptedException {
        try {
            initUrlRecords();
            initSegments(list);
            dispatchReadThread();
            initWatchDog();
            initDns();
            long currentTimeMillis = System.currentTimeMillis();
            waitFirstConnection();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.downloadInfo.increaseAllConnectTime(currentTimeMillis2);
            this.downloadInfo.setFirstSpeedTime(currentTimeMillis2);
            if (!this.paused && !this.canceled) {
                this.hostCallback.checkSpaceOverflow(this.totalLength);
                initWatchDog2();
                writeSegments();
                if (!this.paused && !this.canceled) {
                    Logger.i(TAG, "finally pause");
                    pause();
                }
                this.watchDog.release();
                return true;
            }
            if (!this.paused && !this.canceled) {
                Logger.i(TAG, "finally pause");
                pause();
            }
            this.watchDog.release();
            return true;
        } catch (Throwable th) {
            if (!this.paused && !this.canceled) {
                Logger.i(TAG, "finally pause");
                pause();
            }
            this.watchDog.release();
            throw th;
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public Segment obtainSegment(SegmentReader segmentReader, UrlRecord urlRecord) {
        if (this.canceled || this.paused) {
            return null;
        }
        synchronized (this) {
            Segment obtainSegmentLocked = obtainSegmentLocked(segmentReader, urlRecord);
            if (obtainSegmentLocked != null) {
                obtainSegmentLocked.increaseCompetitor();
                if (obtainSegmentLocked.getCompetitor() > 1) {
                    return new Segment(obtainSegmentLocked);
                }
            }
            return obtainSegmentLocked;
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.DownloadDnsManager.Callback
    public void onDnsResolved(String str, List<InetAddress> list) {
        List<UrlRecord> list2;
        if (this.paused || this.canceled) {
            return;
        }
        try {
            list2 = assembleIpAddress(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
            list2 = null;
        }
        synchronized (this) {
            if (list2 != null) {
                addIpListLocked(str, list2);
            }
            this.needWaitDnsResolve = false;
            this.strategy.updateUrlCount(this.urlRecords.size());
            Log.i(TAG, "onDnsResolved: dispatchReadThread");
            dispatchReadThread();
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderExit(SegmentReader segmentReader) {
        Logger.i(TAG, "onReaderExit: threadIndex = " + segmentReader.threadIndex);
        synchronized (this) {
            segmentReader.setExited(true);
            this.readers.remove(segmentReader);
            clearCoveredSegmentLocked();
            if (this.readers.isEmpty()) {
                onComplete();
            } else if (isAllContentDownloaded()) {
                Log.i(TAG, "onReaderExit: allContentDownloaded");
                for (SegmentReader segmentReader2 : this.readers) {
                    segmentReader2.close();
                }
                onComplete();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onReaderRun(SegmentReader segmentReader) {
        if (this.debug) {
            Logger.i(TAG, "onReaderRun, threadIndex = " + segmentReader.threadIndex);
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentConnected(SegmentReader segmentReader, Segment segment, UrlRecord urlRecord, HttpResponse httpResponse) throws BaseException, RetryThrowable {
        synchronized (this) {
            if (this.canceled || this.paused) {
                throw new StreamClosedException("connected");
            }
            checkSegmentHttpResponseLocked(segmentReader, segment, urlRecord, httpResponse);
            segmentReader.setFailed(false);
            if (this.totalLength <= 0) {
                long totalBytes = this.downloadInfo.getTotalBytes();
                this.totalLength = totalBytes;
                if (totalBytes <= 0) {
                    this.totalLength = httpResponse.getTotalLength();
                }
                dispatchReadThread();
            } else if (this.strategy.segmentOneByOne()) {
                dispatchReadThread();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentFailed(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException) {
        synchronized (this) {
            Logger.e(TAG, "onSegmentFailed: segment = " + segment + ", e = " + baseException);
            segmentReader.setFailed(true);
            if (segmentReader.threadIndex == 0) {
                this.failedException = baseException;
            }
            if (isAllReaderFailedLocked()) {
                if (this.failedException == null) {
                    this.failedException = baseException;
                }
                this.allReaderFailed = true;
                onError(this.failedException);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void onSegmentRetry(SegmentReader segmentReader, UrlRecord urlRecord, Segment segment, BaseException baseException, int i, int i2) {
        boolean isResponseCodeError = DownloadUtils.isResponseCodeError(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            isResponseCodeError = true;
        }
        if (isResponseCodeError || i >= i2) {
            trySwitchNextUrlForReader(segmentReader);
        }
    }

    public void pause() {
        Logger.i(TAG, "pause1");
        this.paused = true;
        synchronized (this) {
            for (SegmentReader segmentReader : this.readers) {
                segmentReader.close();
            }
        }
        this.writer.pause();
        this.bufferQueue.close();
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unApplySegment(SegmentReader segmentReader, Segment segment) {
        synchronized (this) {
            if (segment.owner == segmentReader) {
                Logger.i(TAG, "unApplySegment " + segment);
                segment.setCurrentOffsetRead(segmentReader.getCurSegmentReadOffset());
                segment.owner = null;
                segmentReader.updateReadBytes();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.segment.ISegmentCallback
    public void unObtainSegment(SegmentReader segmentReader, Segment segment) {
        synchronized (this) {
            segment.decreaseCompetitor();
        }
    }
}
