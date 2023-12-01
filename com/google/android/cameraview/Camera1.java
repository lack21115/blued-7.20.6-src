package com.google.android.cameraview;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import com.google.android.cameraview.CameraViewImpl;
import com.google.android.cameraview.PreviewImpl;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/android/cameraview/Camera1.class */
public class Camera1 extends CameraViewImpl {
    private static final SparseArrayCompat<String> FLASH_MODES;
    private static final int INVALID_CAMERA_ID = -1;
    private final AtomicBoolean isPictureCaptureInProgress;
    private AspectRatio mAspectRatio;
    private boolean mAutoFocus;
    Camera mCamera;
    private int mCameraId;
    private final Camera.CameraInfo mCameraInfo;
    private Camera.Parameters mCameraParameters;
    private int mDisplayOrientation;
    private int mFacing;
    private int mFlash;
    private final SizeMap mPictureSizes;
    private final SizeMap mPreviewSizes;
    private boolean mShowingPreview;

    static {
        SparseArrayCompat<String> sparseArrayCompat = new SparseArrayCompat<>();
        FLASH_MODES = sparseArrayCompat;
        sparseArrayCompat.put(0, "off");
        FLASH_MODES.put(1, "on");
        FLASH_MODES.put(2, "torch");
        FLASH_MODES.put(3, "auto");
        FLASH_MODES.put(4, Camera.Parameters.FLASH_MODE_RED_EYE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera1(CameraViewImpl.Callback callback, PreviewImpl previewImpl) {
        super(callback, previewImpl);
        this.isPictureCaptureInProgress = new AtomicBoolean(false);
        this.mCameraInfo = new Camera.CameraInfo();
        this.mPreviewSizes = new SizeMap();
        this.mPictureSizes = new SizeMap();
        previewImpl.setCallback(new PreviewImpl.Callback() { // from class: com.google.android.cameraview.Camera1.1
            @Override // com.google.android.cameraview.PreviewImpl.Callback
            public void onSurfaceChanged() {
                if (Camera1.this.mCamera != null) {
                    Camera1.this.setUpPreview();
                    Camera1.this.adjustCameraParameters();
                }
            }
        });
    }

    private int calcCameraRotation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (this.mCameraInfo.orientation + i) % 360;
        }
        return ((this.mCameraInfo.orientation + i) + (isLandscape(i) ? 180 : 0)) % 360;
    }

    private int calcDisplayOrientation(int i) {
        return this.mCameraInfo.facing == 1 ? (360 - ((this.mCameraInfo.orientation + i) % 360)) % 360 : ((this.mCameraInfo.orientation - i) + 360) % 360;
    }

    private AspectRatio chooseAspectRatio() {
        Iterator<AspectRatio> it = this.mPreviewSizes.ratios().iterator();
        AspectRatio aspectRatio = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AspectRatio next = it.next();
            aspectRatio = next;
            if (next.equals(Constants.DEFAULT_ASPECT_RATIO)) {
                aspectRatio = next;
                break;
            }
        }
        return aspectRatio;
    }

    private void chooseCamera() {
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numberOfCameras) {
                this.mCameraId = -1;
                return;
            }
            Camera.getCameraInfo(i2, this.mCameraInfo);
            if (this.mCameraInfo.facing == this.mFacing) {
                this.mCameraId = i2;
                return;
            }
            i = i2 + 1;
        }
    }

    private Size chooseOptimalSize(SortedSet<Size> sortedSet) {
        if (this.mPreview.isReady()) {
            int width = this.mPreview.getWidth();
            int height = this.mPreview.getHeight();
            int i = width;
            int i2 = height;
            if (isLandscape(this.mDisplayOrientation)) {
                i2 = width;
                i = height;
            }
            Iterator<Size> it = sortedSet.iterator();
            Size size = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Size next = it.next();
                size = next;
                if (i <= next.getWidth()) {
                    size = next;
                    if (i2 <= next.getHeight()) {
                        size = next;
                        break;
                    }
                }
            }
            return size;
        }
        return sortedSet.first();
    }

    private boolean isLandscape(int i) {
        return i == 90 || i == 270;
    }

    private void openCamera() {
        try {
            if (this.mCamera != null) {
                releaseCamera();
            }
            Camera open = Camera.open(this.mCameraId);
            this.mCamera = open;
            this.mCameraParameters = open.getParameters();
            this.mPreviewSizes.clear();
            for (Camera.Size size : this.mCameraParameters.getSupportedPreviewSizes()) {
                this.mPreviewSizes.add(new Size(size.width, size.height));
            }
            this.mPictureSizes.clear();
            for (Camera.Size size2 : this.mCameraParameters.getSupportedPictureSizes()) {
                this.mPictureSizes.add(new Size(size2.width, size2.height));
            }
            if (this.mAspectRatio == null) {
                this.mAspectRatio = Constants.DEFAULT_ASPECT_RATIO;
            }
            adjustCameraParameters();
            this.mCamera.setDisplayOrientation(calcDisplayOrientation(this.mDisplayOrientation));
            this.mCallback.onCameraOpened();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
            this.mCallback.onCameraClosed();
        }
    }

    private boolean setAutoFocusInternal(boolean z) {
        this.mAutoFocus = z;
        if (isCameraOpened()) {
            List<String> supportedFocusModes = this.mCameraParameters.getSupportedFocusModes();
            if (z && supportedFocusModes.contains("continuous-picture")) {
                this.mCameraParameters.setFocusMode("continuous-picture");
                return true;
            } else if (supportedFocusModes.contains(Camera.Parameters.FOCUS_MODE_FIXED)) {
                this.mCameraParameters.setFocusMode(Camera.Parameters.FOCUS_MODE_FIXED);
                return true;
            } else if (supportedFocusModes.contains(Camera.Parameters.FOCUS_MODE_INFINITY)) {
                this.mCameraParameters.setFocusMode(Camera.Parameters.FOCUS_MODE_INFINITY);
                return true;
            } else {
                this.mCameraParameters.setFocusMode(supportedFocusModes.get(0));
                return true;
            }
        }
        return false;
    }

    private boolean setFlashInternal(int i) {
        if (!isCameraOpened()) {
            this.mFlash = i;
            return false;
        }
        List<String> supportedFlashModes = this.mCameraParameters.getSupportedFlashModes();
        String str = FLASH_MODES.get(i);
        if (supportedFlashModes != null && supportedFlashModes.contains(str)) {
            this.mCameraParameters.setFlashMode(str);
            this.mFlash = i;
            return true;
        }
        String str2 = FLASH_MODES.get(this.mFlash);
        if (supportedFlashModes == null || !supportedFlashModes.contains(str2)) {
            this.mCameraParameters.setFlashMode("off");
            this.mFlash = 0;
            return true;
        }
        return false;
    }

    void adjustCameraParameters() {
        SortedSet<Size> sizes = this.mPreviewSizes.sizes(this.mAspectRatio);
        SortedSet<Size> sortedSet = sizes;
        if (sizes == null) {
            AspectRatio chooseAspectRatio = chooseAspectRatio();
            this.mAspectRatio = chooseAspectRatio;
            sortedSet = this.mPreviewSizes.sizes(chooseAspectRatio);
        }
        Size chooseOptimalSize = chooseOptimalSize(sortedSet);
        Size last = this.mPictureSizes.sizes(this.mAspectRatio).last();
        if (this.mShowingPreview) {
            this.mCamera.stopPreview();
        }
        this.mCameraParameters.setPreviewSize(chooseOptimalSize.getWidth(), chooseOptimalSize.getHeight());
        this.mCameraParameters.setPictureSize(last.getWidth(), last.getHeight());
        this.mCameraParameters.setRotation(calcCameraRotation(this.mDisplayOrientation));
        setAutoFocusInternal(this.mAutoFocus);
        setFlashInternal(this.mFlash);
        this.mCamera.setParameters(this.mCameraParameters);
        if (this.mShowingPreview) {
            this.mCamera.startPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public AspectRatio getAspectRatio() {
        return this.mAspectRatio;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean getAutoFocus() {
        if (isCameraOpened()) {
            String focusMode = this.mCameraParameters.getFocusMode();
            return focusMode != null && focusMode.contains("continuous");
        }
        return this.mAutoFocus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public int getFacing() {
        return this.mFacing;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public int getFlash() {
        return this.mFlash;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public Set<AspectRatio> getSupportedAspectRatios() {
        SizeMap sizeMap = this.mPreviewSizes;
        for (AspectRatio aspectRatio : sizeMap.ratios()) {
            if (this.mPictureSizes.sizes(aspectRatio) == null) {
                sizeMap.remove(aspectRatio);
            }
        }
        return sizeMap.ratios();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean isCameraOpened() {
        return this.mCamera != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean setAspectRatio(AspectRatio aspectRatio) {
        if (this.mAspectRatio == null || !isCameraOpened()) {
            this.mAspectRatio = aspectRatio;
            return true;
        } else if (this.mAspectRatio.equals(aspectRatio)) {
            return false;
        } else {
            if (this.mPreviewSizes.sizes(aspectRatio) != null) {
                this.mAspectRatio = aspectRatio;
                adjustCameraParameters();
                return true;
            }
            throw new UnsupportedOperationException(aspectRatio + " is not supported");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public void setAutoFocus(boolean z) {
        if (this.mAutoFocus != z && setAutoFocusInternal(z)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public void setDisplayOrientation(int i) {
        if (this.mDisplayOrientation == i) {
            return;
        }
        this.mDisplayOrientation = i;
        if (isCameraOpened()) {
            this.mCameraParameters.setRotation(calcCameraRotation(i));
            this.mCamera.setParameters(this.mCameraParameters);
            boolean z = this.mShowingPreview && Build.VERSION.SDK_INT < 14;
            if (z) {
                this.mCamera.stopPreview();
            }
            this.mCamera.setDisplayOrientation(calcDisplayOrientation(i));
            if (z) {
                this.mCamera.startPreview();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public void setFacing(int i) {
        if (this.mFacing == i) {
            return;
        }
        this.mFacing = i;
        if (isCameraOpened()) {
            stop();
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public void setFlash(int i) {
        if (i != this.mFlash && setFlashInternal(i)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    void setUpPreview() {
        try {
            if (this.mPreview.getOutputClass() != SurfaceHolder.class) {
                this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
                return;
            }
            boolean z = this.mShowingPreview && Build.VERSION.SDK_INT < 14;
            if (z) {
                this.mCamera.stopPreview();
            }
            this.mCamera.setPreviewDisplay(this.mPreview.getSurfaceHolder());
            if (z) {
                this.mCamera.startPreview();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public boolean start() {
        chooseCamera();
        openCamera();
        if (this.mCamera != null) {
            if (this.mPreview.isReady()) {
                setUpPreview();
            }
            this.mShowingPreview = true;
            this.mCamera.startPreview();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public void stop() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
        }
        this.mShowingPreview = false;
        releaseCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.cameraview.CameraViewImpl
    public void takePicture() {
        if (!isCameraOpened()) {
            throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
        }
        if (!getAutoFocus()) {
            takePictureInternal();
            return;
        }
        this.mCamera.cancelAutoFocus();
        this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.google.android.cameraview.Camera1.2
            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
                Camera1.this.takePictureInternal();
            }
        });
    }

    void takePictureInternal() {
        if (this.isPictureCaptureInProgress.getAndSet(true)) {
            return;
        }
        this.mCamera.takePicture(null, null, null, new Camera.PictureCallback() { // from class: com.google.android.cameraview.Camera1.3
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                Camera1.this.isPictureCaptureInProgress.set(false);
                Camera1.this.mCallback.onPictureTaken(bArr);
                camera.cancelAutoFocus();
                camera.startPreview();
            }
        });
    }
}
