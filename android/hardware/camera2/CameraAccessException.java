package android.hardware.camera2;

import android.util.AndroidException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/CameraAccessException.class */
public class CameraAccessException extends AndroidException {
    public static final int CAMERA_DEPRECATED_HAL = 1000;
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int MAX_CAMERAS_IN_USE = 5;
    private static final long serialVersionUID = 5630338637471475675L;
    private final int mReason;

    public CameraAccessException(int i) {
        super(getDefaultMessage(i));
        this.mReason = i;
    }

    public CameraAccessException(int i, String str) {
        super(str);
        this.mReason = i;
    }

    public CameraAccessException(int i, String str, Throwable th) {
        super(str, th);
        this.mReason = i;
    }

    public CameraAccessException(int i, Throwable th) {
        super(getDefaultMessage(i), th);
        this.mReason = i;
    }

    public static String getDefaultMessage(int i) {
        switch (i) {
            case 1:
                return "The camera is disabled due to a device policy, and cannot be opened.";
            case 2:
                return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
            case 3:
                return "The camera device is currently in the error state; no further calls to it will succeed.";
            case 4:
                return "The camera device is in use already";
            case 5:
                return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
            default:
                return null;
        }
    }

    public final int getReason() {
        return this.mReason;
    }
}
