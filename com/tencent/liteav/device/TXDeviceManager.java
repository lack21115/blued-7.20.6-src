package com.tencent.liteav.device;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManager.class */
public interface TXDeviceManager {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManager$TXAudioRoute.class */
    public enum TXAudioRoute {
        TXAudioRouteSpeakerphone,
        TXAudioRouteEarpiece
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManager$TXCameraCaptureMode.class */
    public enum TXCameraCaptureMode {
        TXCameraResolutionStrategyAuto,
        TXCameraResolutionStrategyPerformance,
        TXCameraResolutionStrategyHighQuality,
        TXCameraCaptureManual
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManager$TXCameraCaptureParam.class */
    public static class TXCameraCaptureParam {
        public int height;
        public TXCameraCaptureMode mode;
        public int width;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManager$TXSystemVolumeType.class */
    public enum TXSystemVolumeType {
        TXSystemVolumeTypeAuto,
        TXSystemVolumeTypeMedia,
        TXSystemVolumeTypeVOIP
    }

    int enableCameraAutoFocus(boolean z);

    boolean enableCameraTorch(boolean z);

    float getCameraZoomMaxRatio();

    boolean isAutoFocusEnabled();

    boolean isFrontCamera();

    int setAudioRoute(TXAudioRoute tXAudioRoute);

    void setCameraCapturerParam(TXCameraCaptureParam tXCameraCaptureParam);

    int setCameraFocusPosition(int i, int i2);

    int setCameraZoomRatio(float f);

    int setSystemVolumeType(TXSystemVolumeType tXSystemVolumeType);

    int switchCamera(boolean z);
}
