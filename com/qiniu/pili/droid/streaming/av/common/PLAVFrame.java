package com.qiniu.pili.droid.streaming.av.common;

import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/av/common/PLAVFrame.class */
public class PLAVFrame {
    public ByteBuffer mBuffer;
    public long mDtsUs;
    public long mPresentationTimeUs;
    public int mSize;
    public volatile long usedCounter = 0;
    public int mCurrentWidth = 0;
    public int mCurrentHeight = 0;

    public PLAVFrame(ByteBuffer byteBuffer, int i, long j) {
        this.mBuffer = byteBuffer;
        this.mSize = i;
        this.mPresentationTimeUs = j;
    }

    public void fillFrame(ByteBuffer byteBuffer, int i, long j) {
        this.mBuffer.clear();
        this.mSize = i;
        this.mBuffer = this.mBuffer.put(byteBuffer);
        this.mPresentationTimeUs = j;
    }

    public void fillFrame(byte[] bArr, long j) {
        this.mBuffer.clear();
        this.mBuffer = this.mBuffer.put(bArr);
        this.mSize = bArr.length;
        this.mPresentationTimeUs = j;
    }

    public void fillFrame(ByteBuffer[] byteBufferArr, long j) {
        this.mBuffer.clear();
        this.mSize = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            byteBuffer.rewind();
            this.mSize += byteBuffer.capacity();
            this.mBuffer.put(byteBuffer);
        }
        this.mPresentationTimeUs = j;
    }
}
