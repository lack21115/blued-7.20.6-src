package com.tencent.live2.impl;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLiveDefInner.class */
public class V2TXLiveDefInner {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLiveDefInner$SurfaceSize.class */
    public static class SurfaceSize {
        public int height;
        public int width;

        public SurfaceSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public String toString() {
            return "[width:" + this.width + "][height:" + this.height + "]";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLiveDefInner$TXLivePropertyKey.class */
    public static class TXLivePropertyKey {
        public static final String kV2EnableAGC = "enableAGC";
        public static final String kV2EnableANS = "enableANS";
        public static final String kV2EnableRTMPAcc = "enableRTMPAcc";
        public static final String kV2EnableRealtimeMode = "enableRealtimeMode";
        public static final String kV2SetAudioRoute = "setAudioRoute";
        public static final String kV2SetFramework = "setFramework";
        public static final String kV2SetLEBEnvironment = "setLEBEnvironment";
        public static final String kV2SetMetaData = "setMetaData";
        public static final String kV2SetSurface = "setSurface";
        public static final String kV2SetSurfaceSize = "setSurfaceSize";
    }
}
