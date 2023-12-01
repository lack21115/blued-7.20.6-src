package com.tencent.ugc.videoprocessor.watermark.data;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/watermark/data/TailWaterMark.class */
public class TailWaterMark extends WaterMark {
    public float mBlurLevel;
    private int mDuration;
    public float mMarkAlphaLevel;
    private long mStartTime;

    public TailWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j, int i) {
        super(bitmap, tXRect);
        this.mStartTime = j;
        this.mDuration = i;
        this.mBlurLevel = 0.0f;
        this.mMarkAlphaLevel = 1.0f;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    @Override // com.tencent.ugc.videoprocessor.watermark.data.WaterMark
    public void release() {
        super.release();
    }
}
