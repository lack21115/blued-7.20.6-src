package com.google.android.cameraview;

import android.view.View;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/android/cameraview/CameraViewImpl.class */
public abstract class CameraViewImpl {
    protected final Callback mCallback;
    protected final PreviewImpl mPreview;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/cameraview/CameraViewImpl$Callback.class */
    public interface Callback {
        void onCameraClosed();

        void onCameraOpened();

        void onPictureTaken(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraViewImpl(Callback callback, PreviewImpl previewImpl) {
        this.mCallback = callback;
        this.mPreview = previewImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AspectRatio getAspectRatio();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean getAutoFocus();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getFacing();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getFlash();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Set<AspectRatio> getSupportedAspectRatios();

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getView() {
        return this.mPreview.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isCameraOpened();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean setAspectRatio(AspectRatio aspectRatio);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setAutoFocus(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setDisplayOrientation(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setFacing(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setFlash(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean start();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void stop();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void takePicture();
}
