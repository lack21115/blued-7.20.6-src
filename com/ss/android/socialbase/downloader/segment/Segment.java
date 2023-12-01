package com.ss.android.socialbase.downloader.segment;

import android.util.Log;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/Segment.class */
public final class Segment {
    private static final String TAG = "Segment";
    int competitor;
    private final AtomicLong currentOffset;
    private volatile long currentOffsetRead;
    private long endOffset;
    private int index;
    private JSONObject jsonObject;
    volatile SegmentReader owner;
    private final long startOffset;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/segment/Segment$JsonKey.class */
    interface JsonKey {
        public static final String CURRENT = "cu";
        public static final String END = "en";
        public static final String START = "st";
    }

    public Segment(long j) {
        this(j, -1L);
    }

    public Segment(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = j;
        atomicLong.set(j);
        this.currentOffsetRead = j;
        if (j2 >= j) {
            this.endOffset = j2;
        } else {
            this.endOffset = -1L;
        }
    }

    public Segment(Segment segment) {
        AtomicLong atomicLong = new AtomicLong();
        this.currentOffset = atomicLong;
        this.competitor = 0;
        this.startOffset = segment.startOffset;
        this.endOffset = segment.endOffset;
        atomicLong.set(segment.currentOffset.get());
        this.currentOffsetRead = this.currentOffset.get();
        this.index = segment.index;
    }

    public Segment(JSONObject jSONObject) {
        this.currentOffset = new AtomicLong();
        this.competitor = 0;
        this.startOffset = jSONObject.optLong("st");
        setEndOffset(jSONObject.optLong("en"));
        setCurrentOffset(jSONObject.optLong(JsonKey.CURRENT));
        setCurrentOffsetRead(getCurrentOffset());
    }

    public static String toString(List<Segment> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<Segment>() { // from class: com.ss.android.socialbase.downloader.segment.Segment.1
            @Override // java.util.Comparator
            public int compare(Segment segment, Segment segment2) {
                return (int) (segment.getStartOffset() - segment2.getStartOffset());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Segment segment : list) {
            sb.append(segment);
            sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decreaseCompetitor() {
        this.competitor--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCompetitor() {
        return this.competitor;
    }

    public long getCurrentOffset() {
        long j = this.currentOffset.get();
        long j2 = this.endOffset;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long getCurrentOffsetRead() {
        SegmentReader segmentReader = this.owner;
        if (segmentReader != null) {
            long curSegmentReadOffset = segmentReader.getCurSegmentReadOffset();
            if (curSegmentReadOffset > this.currentOffsetRead) {
                return curSegmentReadOffset;
            }
        }
        return this.currentOffsetRead;
    }

    public long getDownloadBytes() {
        return this.currentOffset.get() - this.startOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public int getIndex() {
        return this.index;
    }

    public long getReadBytes() {
        return getCurrentOffsetRead() - this.startOffset;
    }

    public long getRemainDownloadBytes() {
        long j = this.endOffset;
        if (j >= this.startOffset) {
            return (j - this.currentOffset.get()) + 1;
        }
        return -1L;
    }

    public long getRemainReadBytes() {
        long j = this.endOffset;
        if (j >= this.startOffset) {
            return (j - getCurrentOffsetRead()) + 1;
        }
        return -1L;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increaseCompetitor() {
        this.competitor++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void increaseCurrentOffset(long j) {
        this.currentOffset.addAndGet(j);
    }

    public boolean isDownloaded() {
        return this.endOffset >= this.startOffset && this.currentOffset.get() > this.endOffset;
    }

    public boolean isReadFinish() {
        return this.endOffset >= this.startOffset && getCurrentOffsetRead() > this.endOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompetitor(int i) {
        this.competitor = i;
    }

    public void setCurrentOffset(long j) {
        long j2 = this.startOffset;
        long j3 = j;
        if (j < j2) {
            j3 = j2;
        }
        long j4 = this.endOffset;
        long j5 = j3;
        if (j4 > 0) {
            long j6 = j4 + 1;
            j5 = j3;
            if (j3 > j6) {
                j5 = j6;
            }
        }
        this.currentOffset.set(j5);
    }

    public void setCurrentOffsetRead(long j) {
        if (j >= this.currentOffset.get()) {
            this.currentOffsetRead = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndOffset(long j) {
        if (j >= this.startOffset) {
            this.endOffset = j;
            return;
        }
        Log.w(TAG, "setEndOffset: endOffset = " + j + ", segment = " + this);
        if (j == -1) {
            this.endOffset = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIndex(int i) {
        this.index = i;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = this.jsonObject;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
            this.jsonObject = jSONObject2;
        }
        jSONObject2.put("st", getStartOffset());
        jSONObject2.put(JsonKey.CURRENT, getCurrentOffset());
        jSONObject2.put("en", getEndOffset());
        return jSONObject2;
    }

    public String toString() {
        return "Segment{startOffset=" + this.startOffset + ",\t currentOffset=" + this.currentOffset + ",\t currentOffsetRead=" + getCurrentOffsetRead() + ",\t endOffset=" + this.endOffset + '}';
    }
}
