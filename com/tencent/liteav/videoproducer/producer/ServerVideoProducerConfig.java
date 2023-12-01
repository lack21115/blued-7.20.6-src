package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.utils.Rotation;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ServerVideoProducerConfig.class */
public class ServerVideoProducerConfig {
    private int hardwareEncodeType = 2;
    private boolean hardwareEncoderHighProfileEnable = true;
    private boolean hardwareEncoderHighProfileSupport = true;
    private int camera2SupportMinApiLevel = Integer.MAX_VALUE;
    private Rotation frontCameraRealRotation = null;
    private Rotation backCameraRealRotation = null;

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getCamera2SupportMinApiLevel() {
        return this.camera2SupportMinApiLevel;
    }

    public Rotation getCameraRealRotation(boolean z) {
        return z ? this.frontCameraRealRotation : this.backCameraRealRotation;
    }

    public boolean isHardwareEncoderAllowed() {
        return this.hardwareEncodeType != 0;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        return this.hardwareEncodeType == 2 && this.hardwareEncoderHighProfileEnable && this.hardwareEncoderHighProfileSupport;
    }

    public void setCamera2SupportMinApiLevel(int i) {
        this.camera2SupportMinApiLevel = i;
    }

    public void setCameraRealRotation(int i, int i2) {
        this.frontCameraRealRotation = Rotation.b(i) ? Rotation.a(i) : null;
        Rotation rotation = null;
        if (Rotation.b(i2)) {
            rotation = Rotation.a(i2);
        }
        this.backCameraRealRotation = rotation;
    }

    public void setHardwareEncodeType(int i) {
        this.hardwareEncodeType = i;
    }

    public void setHardwareEncoderHighProfileEnable(boolean z) {
        this.hardwareEncoderHighProfileEnable = z;
    }

    public void setHardwareEncoderHighProfileSupport(boolean z) {
        this.hardwareEncoderHighProfileSupport = z;
    }
}
