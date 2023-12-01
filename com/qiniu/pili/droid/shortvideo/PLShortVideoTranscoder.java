package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.q;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortVideoTranscoder.class */
public class PLShortVideoTranscoder {
    private PLMediaFile mMediaFile;
    private q mShortVideoTranscoderCore;

    public PLShortVideoTranscoder(Context context, String str, String str2) {
        this.mMediaFile = new PLMediaFile(str);
        this.mShortVideoTranscoderCore = new q(context, str, str2);
    }

    public void cancelTranscode() {
        this.mShortVideoTranscoderCore.a();
    }

    @Deprecated
    public int getSrcBitrate() {
        return this.mMediaFile.getVideoBitrate();
    }

    @Deprecated
    public long getSrcDurationMs() {
        return this.mMediaFile.getDurationMs();
    }

    @Deprecated
    public int getSrcHeight() {
        return this.mMediaFile.getVideoHeight();
    }

    @Deprecated
    public int getSrcWidth() {
        return this.mMediaFile.getVideoWidth();
    }

    public void setClipArea(int i, int i2, int i3, int i4) {
        this.mShortVideoTranscoderCore.a(i, i2, i3, i4);
        QosManager.a().a(QosManager.KeyPoint.transcode_clip_video);
    }

    public void setMaxFrameRate(int i) {
        this.mShortVideoTranscoderCore.b(i);
    }

    public void setMixAudioFile(String str, long j, long j2, boolean z) {
        this.mShortVideoTranscoderCore.a(str, j, j2, z);
    }

    public void setWatermark(PLWatermarkSetting pLWatermarkSetting) {
        this.mShortVideoTranscoderCore.a(pLWatermarkSetting);
    }

    public boolean transcode(int i, int i2, int i3, int i4, PLVideoSaveListener pLVideoSaveListener) {
        QosManager.a().a(QosManager.KeyPoint.transcode_rotate);
        QosManager.a().a(this.mShortVideoTranscoderCore.b());
        return this.mShortVideoTranscoderCore.a(i, i2, i3, i4, pLVideoSaveListener);
    }

    public boolean transcode(int i, int i2, int i3, int i4, boolean z, PLVideoSaveListener pLVideoSaveListener) {
        if (z) {
            QosManager.a().a(QosManager.KeyPoint.reverse_video);
        }
        QosManager.a().a(this.mShortVideoTranscoderCore.b());
        return this.mShortVideoTranscoderCore.a(i, i2, i3, i4, z, pLVideoSaveListener);
    }

    public boolean transcode(int i, int i2, int i3, PLVideoSaveListener pLVideoSaveListener) {
        QosManager.a().a(QosManager.KeyPoint.transcode_video);
        QosManager.a().a(this.mShortVideoTranscoderCore.b());
        return this.mShortVideoTranscoderCore.a(i, i2, i3, pLVideoSaveListener);
    }

    public boolean transcode(int i, int i2, int i3, boolean z, PLVideoSaveListener pLVideoSaveListener) {
        if (z) {
            QosManager.a().a(QosManager.KeyPoint.reverse_video);
        }
        QosManager.a().a(this.mShortVideoTranscoderCore.b());
        return this.mShortVideoTranscoderCore.a(i, i2, i3, z, pLVideoSaveListener);
    }
}
