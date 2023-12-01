package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.f;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLMediaFile.class */
public class PLMediaFile {
    private f mMediaFile;

    public PLMediaFile(String str) {
        this.mMediaFile = new f(str);
    }

    public int getAudioChannels() {
        return this.mMediaFile.n();
    }

    public int getAudioSampleRate() {
        return this.mMediaFile.o();
    }

    public long getDurationMs() {
        return this.mMediaFile.g();
    }

    public String getFilepath() {
        return this.mMediaFile.b();
    }

    public int getVideoBitrate() {
        return this.mMediaFile.k();
    }

    public PLVideoFrame getVideoFrameByIndex(int i, boolean z) {
        return this.mMediaFile.a(i, z);
    }

    public PLVideoFrame getVideoFrameByIndex(int i, boolean z, int i2, int i3) {
        return this.mMediaFile.a(i, z, i2, i3);
    }

    public PLVideoFrame getVideoFrameByTime(long j, boolean z) {
        return this.mMediaFile.a(j, z);
    }

    public PLVideoFrame getVideoFrameByTime(long j, boolean z, int i, int i2) {
        return this.mMediaFile.a(j, z, i, i2);
    }

    public int getVideoFrameCount(boolean z) {
        return this.mMediaFile.a(z);
    }

    public int getVideoFrameRate() {
        return this.mMediaFile.j();
    }

    public int getVideoHeight() {
        return this.mMediaFile.i();
    }

    public int getVideoIFrameInterval() {
        return this.mMediaFile.l();
    }

    public int getVideoRotation() {
        return this.mMediaFile.m();
    }

    public int getVideoWidth() {
        return this.mMediaFile.h();
    }

    public boolean hasAudio() {
        return this.mMediaFile.f() != null;
    }

    public boolean hasVideo() {
        return this.mMediaFile.e() != null;
    }

    public void release() {
        this.mMediaFile.a();
    }
}
