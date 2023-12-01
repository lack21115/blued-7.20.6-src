package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.r;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer.class */
public class PLShortVideoTrimmer {
    private PLMediaFile mMediaFile;
    private r mShortVideoTrimmerCore;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoTrimmer$TRIM_MODE.class */
    public enum TRIM_MODE {
        FAST,
        ACCURATE
    }

    public PLShortVideoTrimmer(Context context, String str, String str2) {
        this.mMediaFile = new PLMediaFile(str);
        this.mShortVideoTrimmerCore = new r(context, str, str2);
        QosManager.a().a(QosManager.KeyPoint.trim_init);
    }

    public void cancelTrim() {
        this.mShortVideoTrimmerCore.a();
    }

    public void destroy() {
        this.mMediaFile.release();
        this.mShortVideoTrimmerCore.b();
    }

    @Deprecated
    public long getSrcDurationMs() {
        return this.mMediaFile.getDurationMs();
    }

    @Deprecated
    public PLVideoFrame getVideoFrameByIndex(int i, boolean z) {
        return this.mMediaFile.getVideoFrameByIndex(i, z);
    }

    @Deprecated
    public PLVideoFrame getVideoFrameByIndex(int i, boolean z, int i2, int i3) {
        return this.mMediaFile.getVideoFrameByIndex(i, z, i2, i3);
    }

    @Deprecated
    public PLVideoFrame getVideoFrameByTime(long j, boolean z) {
        return this.mMediaFile.getVideoFrameByTime(j, z);
    }

    @Deprecated
    public PLVideoFrame getVideoFrameByTime(long j, boolean z, int i, int i2) {
        return this.mMediaFile.getVideoFrameByTime(j, z, i, i2);
    }

    @Deprecated
    public int getVideoFrameCount(boolean z) {
        return this.mMediaFile.getVideoFrameCount(z);
    }

    public void setSpeed(double d) {
        this.mShortVideoTrimmerCore.a(d);
    }

    public void trim(long j, long j2, TRIM_MODE trim_mode, PLVideoSaveListener pLVideoSaveListener) {
        this.mShortVideoTrimmerCore.a(j, j2, trim_mode, pLVideoSaveListener);
        QosManager.a().a(this.mShortVideoTrimmerCore.c());
        QosManager.a().a(QosManager.KeyPoint.trim_video);
    }

    public void trim(long j, long j2, PLVideoSaveListener pLVideoSaveListener) {
        trim(j, j2, TRIM_MODE.ACCURATE, pLVideoSaveListener);
    }
}
