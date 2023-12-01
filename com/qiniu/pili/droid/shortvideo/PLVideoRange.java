package com.qiniu.pili.droid.shortvideo;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLVideoRange.class */
public class PLVideoRange {
    private long mEndTimeMs;
    private long mStartTimeMs;
    private String mVideoPath;

    public PLVideoRange(String str) {
        this.mVideoPath = str;
    }

    public long getEndTime() {
        return this.mEndTimeMs;
    }

    public long getRangeTime() {
        return this.mEndTimeMs - this.mStartTimeMs;
    }

    public long getStartTime() {
        return this.mStartTimeMs;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public boolean isValidRange() {
        long j = this.mStartTimeMs;
        if (j >= 0) {
            long j2 = this.mEndTimeMs;
            return j2 > 0 && j2 > j;
        }
        return false;
    }

    public PLVideoRange setEndTime(long j) {
        this.mEndTimeMs = j;
        return this;
    }

    public PLVideoRange setStartTime(long j) {
        this.mStartTimeMs = j;
        return this;
    }
}
