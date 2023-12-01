package com.qiniu.pili.droid.streaming.av.common;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/av/common/PLBufferInfo.class */
public final class PLBufferInfo {
    public static final int BUFFER_FLAG_CODEC_CONFIG = 2;
    public static final int BUFFER_FLAG_END_OF_STREAM = 4;
    public static final int BUFFER_FLAG_KEY_FRAME = 1;
    public static final int BUFFER_FLAG_P_FRAME = 8;
    public long dtsUs;
    public int flags;
    public boolean isNeedAddHeader = true;
    public int offset;
    public long presentationTimeUs;
    public int size;

    public PLBufferInfo() {
        set(0, 0, 0L, 0L, 0);
    }

    public PLBufferInfo dup() {
        PLBufferInfo pLBufferInfo = new PLBufferInfo();
        pLBufferInfo.set(this.offset, this.size, this.presentationTimeUs, this.dtsUs, this.flags);
        return pLBufferInfo;
    }

    public void set(int i, int i2, long j, long j2, int i3) {
        this.offset = i;
        this.size = i2;
        this.presentationTimeUs = j;
        this.dtsUs = j2;
        this.flags = i3;
    }
}
