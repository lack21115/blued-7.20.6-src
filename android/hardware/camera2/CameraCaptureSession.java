package android.hardware.camera2;

import android.os.Handler;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraCaptureSession.class */
public abstract class CameraCaptureSession implements AutoCloseable {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraCaptureSession$CaptureCallback.class */
    public static abstract class CaptureCallback {
        public static final int NO_FRAMES_CAPTURED = -1;

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        }

        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        }

        public void onCapturePartial(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
        }

        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j) {
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            onCaptureStarted(cameraCaptureSession, captureRequest, j);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraCaptureSession$CaptureListener.class */
    public static abstract class CaptureListener extends CaptureCallback {
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraCaptureSession$StateCallback.class */
    public static abstract class StateCallback {
        public void onActive(CameraCaptureSession cameraCaptureSession) {
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
        }

        public abstract void onConfigureFailed(CameraCaptureSession cameraCaptureSession);

        public abstract void onConfigured(CameraCaptureSession cameraCaptureSession);

        public void onReady(CameraCaptureSession cameraCaptureSession) {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraCaptureSession$StateListener.class */
    public static abstract class StateListener extends StateCallback {
    }

    public abstract void abortCaptures() throws CameraAccessException;

    public abstract int capture(CaptureRequest captureRequest, CaptureCallback captureCallback, Handler handler) throws CameraAccessException;

    public abstract int captureBurst(List<CaptureRequest> list, CaptureCallback captureCallback, Handler handler) throws CameraAccessException;

    @Override // java.lang.AutoCloseable
    public abstract void close();

    public abstract CameraDevice getDevice();

    public abstract int setRepeatingBurst(List<CaptureRequest> list, CaptureCallback captureCallback, Handler handler) throws CameraAccessException;

    public abstract int setRepeatingRequest(CaptureRequest captureRequest, CaptureCallback captureCallback, Handler handler) throws CameraAccessException;

    public abstract void stopRepeating() throws CameraAccessException;
}
