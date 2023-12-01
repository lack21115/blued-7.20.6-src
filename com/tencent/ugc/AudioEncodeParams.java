package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/AudioEncodeParams.class */
public class AudioEncodeParams {
    private int mBitrate;
    private int mBitsPerChannel;
    private int mChannels;
    private int mSampleRate;

    public AudioEncodeParams() {
    }

    public AudioEncodeParams(AudioEncodeParams audioEncodeParams) {
        if (audioEncodeParams == null) {
            return;
        }
        this.mChannels = audioEncodeParams.mChannels;
        this.mSampleRate = audioEncodeParams.mSampleRate;
        this.mBitsPerChannel = audioEncodeParams.mBitsPerChannel;
        this.mBitrate = audioEncodeParams.mBitrate;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getBitsPerChannel() {
        return this.mBitsPerChannel;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
    }

    public void setBitsPerChannel(int i) {
        this.mBitsPerChannel = i;
    }

    public void setChannels(int i) {
        this.mChannels = i;
    }

    public void setSampleRate(int i) {
        this.mSampleRate = i;
    }
}
