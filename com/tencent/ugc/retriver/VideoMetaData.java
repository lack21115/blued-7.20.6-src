package com.tencent.ugc.retriver;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/retriver/VideoMetaData.class */
public class VideoMetaData {
    private long mAudioBitrate;
    private long mAudioDuration;
    private int mChannels;
    private float mFps;
    private int mHeight;
    private int mRotation;
    private int mSampleRate;
    private long mVideoBitrate;
    private long mVideoDuration;
    private String mVideoMimeType;
    private int mWidth;

    public long getAudioBitrate() {
        return this.mAudioBitrate;
    }

    public long getAudioDuration() {
        return this.mAudioDuration;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public float getFps() {
        return this.mFps;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public long getVideoBitrate() {
        return this.mVideoBitrate;
    }

    public long getVideoDuration() {
        return this.mVideoDuration;
    }

    public String getVideoMimeType() {
        return this.mVideoMimeType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setAudioBitrate(long j) {
        this.mAudioBitrate = j;
    }

    public void setAudioDuration(long j) {
        this.mAudioDuration = j;
    }

    public void setChannels(int i) {
        this.mChannels = i;
    }

    public void setFps(float f) {
        this.mFps = f;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setSampleRate(int i) {
        this.mSampleRate = i;
    }

    public void setVideoBitrate(long j) {
        this.mVideoBitrate = j;
    }

    public void setVideoDuration(long j) {
        this.mVideoDuration = j;
    }

    public void setVideoMimeType(String str) {
        this.mVideoMimeType = str;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public String toString() {
        return "FFMediaInfo{rotation=" + this.mRotation + ", width=" + this.mWidth + ", height=" + this.mHeight + ", fps=" + this.mFps + ", videoBitrate=" + this.mVideoBitrate + ", videoDuration=" + this.mVideoDuration + ", sampleRate=" + this.mSampleRate + ", channels=" + this.mChannels + ", audioBitrate=" + this.mAudioBitrate + ", audioDuration=" + this.mAudioDuration + '}';
    }
}
