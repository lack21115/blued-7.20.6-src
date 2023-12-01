package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/YUVReadTools.class */
public class YUVReadTools {
    public static native void nativeReadYUVPlanesForByteArray(int i, int i2, byte[] bArr);

    public static native void nativeReadYUVPlanesForByteBuffer(int i, int i2, ByteBuffer byteBuffer);
}
