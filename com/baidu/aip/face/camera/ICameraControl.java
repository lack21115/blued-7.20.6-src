package com.baidu.aip.face.camera;

import android.graphics.Rect;
import android.view.View;
import com.baidu.aip.face.PreviewView;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/ICameraControl.class */
public interface ICameraControl<T> {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    public static final int CAMERA_USB = 2;
    public static final int FLASH_MODE_AUTO = 2;
    public static final int FLASH_MODE_OFF = 0;
    public static final int FLASH_MODE_TORCH = 1;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/ICameraControl$CameraFacing.class */
    public @interface CameraFacing {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/ICameraControl$FlashMode.class */
    public @interface FlashMode {
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/ICameraControl$OnFrameListener.class */
    public interface OnFrameListener<T> {
        void onPreviewFrame(T t, int i, int i2, int i3);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/ICameraControl$OnTakePictureCallback.class */
    public interface OnTakePictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    View getDisplayView();

    int getFlashMode();

    Rect getPreviewFrame();

    PreviewView getPreviewView();

    void pause();

    void refreshPermission();

    void resume();

    void setCameraFacing(int i);

    void setDisplayOrientation(int i);

    void setOnFrameListener(OnFrameListener onFrameListener);

    void setPermissionCallback(PermissionCallback permissionCallback);

    void setPreferredPreviewSize(int i, int i2);

    void setPreviewView(PreviewView previewView);

    void start();

    void stop();
}
