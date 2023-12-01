package com.zego.zegoavkit2.camera;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/camera/ZegoCameraJNI.class */
final class ZegoCameraJNI {
    ZegoCameraJNI() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enableCamAdaptiveFPS(boolean z, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native float getCamMaxZoomFactor(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamExposureCompensation(float f, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamExposureMode(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamExposurePoint(float f, float f2, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamExposurePointInPreview(float f, float f2, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamFocusMode(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamFocusPoint(float f, float f2, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamFocusPointInPreview(float f, float f2, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean setCamZoomFactor(float f, int i);
}
