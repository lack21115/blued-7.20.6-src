package android.hardware.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraDevice.class */
public abstract class CameraDevice implements AutoCloseable {
    public static final int TEMPLATE_MANUAL = 6;
    public static final int TEMPLATE_PREVIEW = 1;
    public static final int TEMPLATE_RECORD = 3;
    public static final int TEMPLATE_STILL_CAPTURE = 2;
    public static final int TEMPLATE_VIDEO_SNAPSHOT = 4;
    public static final int TEMPLATE_ZERO_SHUTTER_LAG = 5;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraDevice$StateCallback.class */
    public static abstract class StateCallback {
        public static final int ERROR_CAMERA_DEVICE = 4;
        public static final int ERROR_CAMERA_DISABLED = 3;
        public static final int ERROR_CAMERA_IN_USE = 1;
        public static final int ERROR_CAMERA_SERVICE = 5;
        public static final int ERROR_MAX_CAMERAS_IN_USE = 2;

        public void onClosed(CameraDevice cameraDevice) {
        }

        public abstract void onDisconnected(CameraDevice cameraDevice);

        public abstract void onError(CameraDevice cameraDevice, int i);

        public abstract void onOpened(CameraDevice cameraDevice);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraDevice$StateListener.class */
    public static abstract class StateListener extends StateCallback {
    }

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract CaptureRequest.Builder createCaptureRequest(int i) throws CameraAccessException;

    public abstract void createCaptureSession(List<Surface> list, CameraCaptureSession.StateCallback stateCallback, Handler handler) throws CameraAccessException;

    public abstract String getId();
}
