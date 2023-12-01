package com.zego.zegoavkit2.camera;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/camera/ZegoCamera.class */
public class ZegoCamera {
    public static void enableCamAdaptiveFPS(boolean z, int i, int i2, int i3) {
        ZegoCameraJNI.enableCamAdaptiveFPS(z, i, i2, i3);
    }

    public static float getCamMaxZoomFactor(int i) {
        return ZegoCameraJNI.getCamMaxZoomFactor(i);
    }

    public static boolean setCamExposureCompensation(float f, int i) {
        return ZegoCameraJNI.setCamExposureCompensation(f, i);
    }

    public static boolean setCamExposureMode(ZegoCameraExposureMode zegoCameraExposureMode, int i) {
        return ZegoCameraJNI.setCamExposureMode(zegoCameraExposureMode.getCode(), i);
    }

    @Deprecated
    public static boolean setCamExposurePoint(float f, float f2, int i) {
        return ZegoCameraJNI.setCamExposurePoint(f, f2, i);
    }

    public static boolean setCamExposurePointInPreview(float f, float f2, int i) {
        return ZegoCameraJNI.setCamExposurePointInPreview(f, f2, i);
    }

    public static boolean setCamFocusMode(ZegoCameraFocusMode zegoCameraFocusMode, int i) {
        return ZegoCameraJNI.setCamFocusMode(zegoCameraFocusMode.getCode(), i);
    }

    @Deprecated
    public static boolean setCamFocusPoint(float f, float f2, int i) {
        return ZegoCameraJNI.setCamFocusPoint(f, f2, i);
    }

    public static boolean setCamFocusPointInPreview(float f, float f2, int i) {
        return ZegoCameraJNI.setCamFocusPointInPreview(f, f2, i);
    }

    public static boolean setCamZoomFactor(float f, int i) {
        return ZegoCameraJNI.setCamZoomFactor(f, i);
    }
}
