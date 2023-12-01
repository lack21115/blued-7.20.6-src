package com.zego.zegoavkit2.camera;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/camera/ZegoCameraExposureMode.class */
public enum ZegoCameraExposureMode {
    AUTO(0),
    CUSTOM(1);
    
    private int mCode;

    ZegoCameraExposureMode(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
