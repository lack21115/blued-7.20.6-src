package com.qiniu.pili.droid.streaming.av.common;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/av/common/PLFourCC.class */
public final class PLFourCC {
    public static final int FOURCC_UNKNOWN = -1;
    public static final int FOURCC_I420 = makeFourCC('I', '4', '2', '0');
    public static final int FOURCC_NV21 = makeFourCC('N', 'V', '2', '1');
    public static final int FOURCC_NV12 = makeFourCC('N', 'V', '1', '2');
    public static final int FOURCC_ABGR = makeFourCC('A', 'B', 'G', 'R');

    public static int makeFourCC(char c2, char c3, char c4, char c5) {
        return c2 | (c3 << '\b') | (c4 << 16) | (c5 << 24);
    }
}
