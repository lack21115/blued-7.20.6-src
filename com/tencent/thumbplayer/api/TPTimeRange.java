package com.tencent.thumbplayer.api;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPTimeRange.class */
public class TPTimeRange {
    private long mEndTimeMs;
    private long mStartTimeMs;

    public TPTimeRange(long j, long j2) {
        this.mStartTimeMs = j;
        this.mEndTimeMs = j2;
    }

    public long getEndTimeMs() {
        return this.mEndTimeMs;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public void setEndTimeMs(long j) {
        this.mEndTimeMs = j;
    }

    public void setStartTimeMs(long j) {
        this.mStartTimeMs = j;
    }
}
