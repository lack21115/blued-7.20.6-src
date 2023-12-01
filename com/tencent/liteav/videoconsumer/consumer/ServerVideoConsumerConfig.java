package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/ServerVideoConsumerConfig.class */
public class ServerVideoConsumerConfig {
    public boolean enableVui = true;
    public int hwDecoderMaxCacheForHighRes = 8;
    public int hwDecoderMaxCacheForLowRes = 6;

    public static boolean isHWHevcDecodeAllowed() {
        return nativeIsHardwareHevcDecodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcDecodeAllowed();

    public void setEnableVui(boolean z) {
        this.enableVui = z;
    }

    public void setHardwareDecoderMaxCache(int i, int i2) {
        this.hwDecoderMaxCacheForHighRes = i;
        this.hwDecoderMaxCacheForLowRes = i2;
    }

    public String toString() {
        return "ServerVideoConsumerConfig(" + ("enableVui=" + this.enableVui + ",hwDecoderMaxCacheForHighRes=" + this.hwDecoderMaxCacheForHighRes + ",hwDecoderMaxCacheForLowRes=" + this.hwDecoderMaxCacheForLowRes) + ")";
    }
}
