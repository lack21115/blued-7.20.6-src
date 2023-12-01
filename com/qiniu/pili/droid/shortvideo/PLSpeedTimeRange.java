package com.qiniu.pili.droid.shortvideo;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLSpeedTimeRange.class */
public class PLSpeedTimeRange {
    private long mEndTimeMs;
    private double mSpeed;
    private long mStartTimeMs;

    public PLSpeedTimeRange(double d, long j, long j2) {
        this.mStartTimeMs = j;
        this.mEndTimeMs = j2;
        this.mSpeed = d;
    }

    public long getEndTimeMs() {
        return this.mEndTimeMs;
    }

    public long getRangeTimeMs() {
        return this.mEndTimeMs - this.mStartTimeMs;
    }

    public double getSpeed() {
        return this.mSpeed;
    }

    public long getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public boolean isIncludeTimeUs(long j) {
        return j > this.mStartTimeMs * 1000 && j < this.mEndTimeMs * 1000;
    }

    public String toString() {
        return "speed : " + this.mSpeed + " time : [" + this.mStartTimeMs + "-" + this.mEndTimeMs + "]";
    }
}
