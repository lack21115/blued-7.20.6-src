package com.tencent.liteav.videobase.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/common/CodecType.class */
public enum CodecType {
    H264(0),
    H265(1),
    VP8(2);
    
    private static final CodecType[] d = values();
    public final int mValue;

    CodecType(int i) {
        this.mValue = i;
    }

    public static CodecType a(int i) {
        CodecType[] codecTypeArr = d;
        int length = codecTypeArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return H264;
            }
            CodecType codecType = codecTypeArr[i3];
            if (i == codecType.mValue) {
                return codecType;
            }
            i2 = i3 + 1;
        }
    }
}
