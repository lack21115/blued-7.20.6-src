package android.hardware.camera2.utils;

import android.hardware.camera2.CameraAccessException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/CameraRuntimeException.class */
public class CameraRuntimeException extends RuntimeException {
    private Throwable mCause;
    private String mMessage;
    private final int mReason;

    public CameraRuntimeException(int i) {
        this.mReason = i;
    }

    public CameraRuntimeException(int i, String str) {
        super(str);
        this.mReason = i;
        this.mMessage = str;
    }

    public CameraRuntimeException(int i, String str, Throwable th) {
        super(str, th);
        this.mReason = i;
        this.mMessage = str;
        this.mCause = th;
    }

    public CameraRuntimeException(int i, Throwable th) {
        super(th);
        this.mReason = i;
        this.mCause = th;
    }

    public CameraAccessException asChecked() {
        CameraAccessException cameraAccessException = (this.mMessage == null || this.mCause == null) ? this.mMessage != null ? new CameraAccessException(this.mReason, this.mMessage) : this.mCause != null ? new CameraAccessException(this.mReason, this.mCause) : new CameraAccessException(this.mReason) : new CameraAccessException(this.mReason, this.mMessage, this.mCause);
        cameraAccessException.setStackTrace(getStackTrace());
        return cameraAccessException;
    }

    public final int getReason() {
        return this.mReason;
    }
}
