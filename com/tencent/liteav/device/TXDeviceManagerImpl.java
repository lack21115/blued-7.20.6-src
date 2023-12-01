package com.tencent.liteav.device;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.device.TXDeviceManager;

@JNINamespace("liteav::manager")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManagerImpl.class */
public class TXDeviceManagerImpl implements TXDeviceManager {
    private long mNativeDeviceMgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.device.TXDeviceManagerImpl$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManagerImpl$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXAudioRoute;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXCameraCaptureMode;
        static final /* synthetic */ int[] $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007f -> B:57:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0083 -> B:53:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0087 -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008b -> B:10:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008f -> B:55:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0093 -> B:15:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0097 -> B:47:0x0068). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x009b -> B:41:0x0073). Please submit an issue!!! */
        static {
            int[] iArr = new int[TXDeviceManager.TXCameraCaptureMode.values().length];
            $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXCameraCaptureMode = iArr;
            try {
                iArr[TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXCameraCaptureMode[TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXCameraCaptureMode[TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXCameraCaptureMode[TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[TXDeviceManager.TXAudioRoute.values().length];
            $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXAudioRoute = iArr2;
            try {
                iArr2[TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXAudioRoute[TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            int[] iArr3 = new int[TXDeviceManager.TXSystemVolumeType.values().length];
            $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType = iArr3;
            try {
                iArr3[TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/device/TXDeviceManagerImpl$CameraCaptureParam.class */
    static class CameraCaptureParam {
        private TXDeviceManager.TXCameraCaptureParam mParams;

        public CameraCaptureParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
            this.mParams = tXCameraCaptureParam;
        }

        public int getHeight() {
            return this.mParams.height;
        }

        public int getMode() {
            return TXDeviceManagerImpl.cameraCaptureModeAsInt(this.mParams.mode);
        }

        public int getWidth() {
            return this.mParams.width;
        }
    }

    public TXDeviceManagerImpl(long j) {
        this.mNativeDeviceMgr = 0L;
        this.mNativeDeviceMgr = j;
    }

    public static int audioRouteAsInt(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        int i = AnonymousClass1.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXAudioRoute[tXAudioRoute.ordinal()];
        int i2 = 1;
        if (i == 1 || i != 2) {
            i2 = 0;
        }
        return i2;
    }

    public static TXDeviceManager.TXAudioRoute audioRouteFromInt(int i) {
        if (i != 0 && i == 1) {
            return TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
        }
        return TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
    }

    public static int cameraCaptureModeAsInt(TXDeviceManager.TXCameraCaptureMode tXCameraCaptureMode) {
        int i = AnonymousClass1.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXCameraCaptureMode[tXCameraCaptureMode.ordinal()];
        int i2 = 3;
        if (i != 1) {
            if (i == 2) {
                i2 = 1;
            } else if (i == 3) {
                return 2;
            } else {
                if (i != 4) {
                    return 0;
                }
            }
            return i2;
        }
        return 0;
    }

    public static TXDeviceManager.TXCameraCaptureMode cameraCaptureModeFromInt(int i) {
        return i == 0 ? TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto : i == 1 ? TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance : i == 2 ? TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality : i == 3 ? TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual : TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto;
    }

    private static native void nativeDestroy(long j);

    private static native int nativeEnableCameraAutoFocus(long j, boolean z);

    private static native boolean nativeEnableCameraTorch(long j, boolean z);

    private static native float nativeGetCameraZoomMaxRatio(long j);

    private static native boolean nativeIsAutoFocusEnabled(long j);

    private static native boolean nativeIsCameraAutoFocusFaceModeSupported(long j);

    private static native boolean nativeIsCameraFocusPositionInPreviewSupported(long j);

    private static native boolean nativeIsCameraTorchSupported(long j);

    private static native boolean nativeIsCameraZoomSupported(long j);

    private static native boolean nativeIsFrontCamera(long j);

    private static native boolean nativeIsLowLatencyEarMonitorSupported(long j);

    private static native int nativeSetAudioRoute(long j, int i);

    private static native void nativeSetCameraCapturerParam(long j, CameraCaptureParam cameraCaptureParam);

    private static native int nativeSetCameraFocusPosition(long j, int i, int i2);

    private static native int nativeSetCameraZoomRatio(long j, float f);

    private static native int nativeSetSystemVolumeType(long j, int i);

    private static native int nativeSwitchCamera(long j, boolean z);

    public static int systemVolumeTypeAsInt(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        int i = AnonymousClass1.$SwitchMap$com$tencent$liteav$device$TXDeviceManager$TXSystemVolumeType[tXSystemVolumeType.ordinal()];
        int i2 = 2;
        if (i != 1) {
            if (i == 2) {
                i2 = 1;
            } else if (i != 3) {
                return 0;
            }
            return i2;
        }
        return 0;
    }

    public static TXDeviceManager.TXSystemVolumeType systemVolumeTypefromInt(int i) {
        return i == 0 ? TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto : i == 1 ? TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia : i == 2 ? TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP : TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int enableCameraAutoFocus(boolean z) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeEnableCameraAutoFocus(j, z);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean enableCameraTorch(boolean z) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeEnableCameraTorch(j, z);
        }
        return false;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeDeviceMgr = 0L;
        }
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public float getCameraZoomMaxRatio() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeGetCameraZoomMaxRatio(j);
        }
        return 0.0f;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean isAutoFocusEnabled() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsAutoFocusEnabled(j);
        }
        return false;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        long j = this.mNativeDeviceMgr;
        if (j == 0) {
            return false;
        }
        return nativeIsCameraAutoFocusFaceModeSupported(j);
    }

    public boolean isCameraFocusPositionInPreviewSupported() {
        long j = this.mNativeDeviceMgr;
        if (j == 0) {
            return false;
        }
        return nativeIsCameraFocusPositionInPreviewSupported(j);
    }

    public boolean isCameraTorchSupported() {
        long j = this.mNativeDeviceMgr;
        if (j == 0) {
            return false;
        }
        return nativeIsCameraTorchSupported(j);
    }

    public boolean isCameraZoomSupported() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsCameraZoomSupported(j);
        }
        return false;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public boolean isFrontCamera() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsFrontCamera(j);
        }
        return false;
    }

    public boolean isLowLatencyEarMonitorSupported() {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeIsLowLatencyEarMonitorSupported(j);
        }
        return false;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setAudioRoute(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetAudioRoute(j, audioRouteAsInt(tXAudioRoute));
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public void setCameraCapturerParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            nativeSetCameraCapturerParam(j, new CameraCaptureParam(tXCameraCaptureParam));
        }
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setCameraFocusPosition(int i, int i2) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetCameraFocusPosition(j, i, i2);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setCameraZoomRatio(float f) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetCameraZoomRatio(j, f);
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int setSystemVolumeType(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSetSystemVolumeType(j, systemVolumeTypeAsInt(tXSystemVolumeType));
        }
        return 0;
    }

    @Override // com.tencent.liteav.device.TXDeviceManager
    public int switchCamera(boolean z) {
        long j = this.mNativeDeviceMgr;
        if (j != 0) {
            return nativeSwitchCamera(j, z);
        }
        return 0;
    }
}
