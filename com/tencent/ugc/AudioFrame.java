package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/AudioFrame.class */
public class AudioFrame {
    private int mChannels;
    private AudioCodecFormat mCodecFormat;
    private ByteBuffer mData;
    private int mSampleRate;
    private long mTimestampMs;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/AudioFrame$AudioCodecFormat.class */
    public enum AudioCodecFormat {
        UNKNOWN(0),
        PCM(99),
        AAC(10);
        
        private final int mValue;

        AudioCodecFormat(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public int getChannelCount() {
        return this.mChannels;
    }

    public AudioCodecFormat getCodecFormat() {
        return this.mCodecFormat;
    }

    public ByteBuffer getData() {
        return this.mData;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public long getTimestamp() {
        return this.mTimestampMs;
    }

    public void setChannelCount(int i) {
        this.mChannels = i;
    }

    public void setCodecFormat(AudioCodecFormat audioCodecFormat) {
        this.mCodecFormat = audioCodecFormat;
    }

    public void setData(ByteBuffer byteBuffer) {
        this.mData = byteBuffer;
    }

    public void setSampleRate(int i) {
        this.mSampleRate = i;
    }

    public void setTimestamp(long j) {
        this.mTimestampMs = j;
    }
}
