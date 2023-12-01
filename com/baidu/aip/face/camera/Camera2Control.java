package com.baidu.aip.face.camera;

import android.Manifest;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.aip.face.PreviewView;
import com.baidu.aip.face.camera.ICameraControl;
import com.tencent.ugc.UGCTransitionRules;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/Camera2Control.class */
public class Camera2Control implements ICameraControl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_PREVIEW_HEIGHT = 1080;
    private static final int MAX_PREVIEW_SIZE = 2048;
    private static final int MAX_PREVIEW_WIDTH = 1920;
    private static final SparseIntArray ORIENTATIONS;
    private static final int STATE_CAPTURING = 3;
    private static final int STATE_PICTURE_TAKEN = 4;
    private static final int STATE_PREVIEW = 0;
    private static final int STATE_WAITING_FOR_CAPTURE = 2;
    private static final int STATE_WAITING_FOR_LOCK = 1;
    private Handler backgroundHandler;
    private HandlerThread backgroundThread;
    private CameraDevice cameraDevice;
    private String cameraId;
    private CameraCaptureSession captureSession;
    private Context context;
    private int flashMode;
    private ImageReader imageReader;
    private ICameraControl.OnFrameListener onFrameListener;
    private ICameraControl.OnTakePictureCallback onTakePictureCallback;
    private PermissionCallback permissionCallback;
    private CaptureRequest previewRequest;
    private CaptureRequest.Builder previewRequestBuilder;
    private Size previewSize;
    private PreviewView previewView;
    private int sensorOrientation;
    private SurfaceTexture surfaceTexture;
    private TextureView textureView;
    private int orientation = 0;
    private int state = 0;
    private Semaphore cameraLock = new Semaphore(1);
    private int camFacing = 1;
    private Handler handler = new Handler(Looper.getMainLooper());
    private int preferredWidth = 1280;
    private int preferredHeight = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
    private boolean usbCamera = false;
    private final TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.aip.face.camera.Camera2Control.2
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Camera2Control.this.stop();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Camera2Control.this.configureTransform(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    };
    private final CameraDevice.StateCallback deviceStateCallback = new CameraDevice.StateCallback() { // from class: com.baidu.aip.face.camera.Camera2Control.3
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2Control.this.cameraLock.release();
            cameraDevice.close();
            Camera2Control.this.cameraDevice = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Camera2Control.this.cameraLock.release();
            cameraDevice.close();
            Camera2Control.this.cameraDevice = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Camera2Control.this.cameraLock.release();
            Camera2Control.this.cameraDevice = cameraDevice;
            Camera2Control.this.createCameraPreviewSession();
        }
    };
    private CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.baidu.aip.face.camera.Camera2Control.7
        private void process(CaptureResult captureResult) {
            int i = Camera2Control.this.state;
            if (i == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null || num.intValue() == 1) {
                    Camera2Control.this.captureStillPicture();
                } else if (4 == num.intValue() || num.intValue() == 0 || 5 == num.intValue() || 2 == num.intValue()) {
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num2 == null || num2.intValue() == 2) {
                        Camera2Control.this.captureStillPicture();
                    } else {
                        Camera2Control.this.runPreCaptureSequence();
                    }
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() != 5) {
                    Camera2Control.this.captureStillPicture();
                }
            } else {
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 == null || num4.intValue() == 5 || num4.intValue() == 4) {
                    Camera2Control.this.state = 3;
                } else if (num4.intValue() == 2) {
                    Camera2Control.this.captureStillPicture();
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            process(totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            process(captureResult);
        }
    };
    private Comparator<Size> sizeComparator = new Comparator<Size>() { // from class: com.baidu.aip.face.camera.Camera2Control.8
        @Override // java.util.Comparator
        public int compare(Size size, Size size2) {
            return Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
        }
    };
    private Matrix matrix = new Matrix();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ORIENTATIONS = sparseIntArray;
        sparseIntArray.append(0, 90);
        ORIENTATIONS.append(1, 0);
        ORIENTATIONS.append(2, 270);
        ORIENTATIONS.append(3, 180);
    }

    public Camera2Control(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void captureStillPicture() {
        try {
            if (this.context == null || this.cameraDevice == null) {
                return;
            }
            CaptureRequest.Builder createCaptureRequest = this.cameraDevice.createCaptureRequest(2);
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_MODE, 4);
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(getOrientation(this.orientation)));
            updateFlashMode(this.flashMode, createCaptureRequest);
            CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.baidu.aip.face.camera.Camera2Control.9
                @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                    Camera2Control.this.unlockFocus();
                }
            };
            this.captureSession.stopRepeating();
            this.captureSession.capture(createCaptureRequest.build(), captureCallback, this.backgroundHandler);
            this.state = 4;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void closeCamera() {
        try {
            try {
                this.cameraLock.acquire();
                if (this.captureSession != null) {
                    this.captureSession.close();
                    this.captureSession = null;
                }
                if (this.cameraDevice != null) {
                    this.cameraDevice.close();
                    this.cameraDevice = null;
                }
                if (this.imageReader != null) {
                    this.imageReader.close();
                    this.imageReader = null;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
            }
        } finally {
            this.cameraLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configureTransform(int i, int i2) {
        if (this.textureView == null || this.previewSize == null || this.context == null) {
            return;
        }
        int i3 = this.orientation;
        float f = i;
        float f2 = i2;
        RectF rectF = new RectF(0.0f, 0.0f, f, f2);
        RectF rectF2 = new RectF(0.0f, 0.0f, this.previewSize.getHeight(), this.previewSize.getWidth());
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        if (1 == i3 || 3 == i3) {
            rectF2.offset(centerX - rectF2.centerX(), centerY - rectF2.centerY());
            this.matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            float max = Math.max(f2 / this.previewSize.getHeight(), f / this.previewSize.getWidth());
            this.matrix.postScale(max, max, centerX, centerY);
            this.matrix.postRotate((i3 - 2) * 90, centerX, centerY);
        } else if (2 == i3) {
            this.matrix.postRotate(180.0f, centerX, centerY);
        }
        this.textureView.setTransform(this.matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createCameraPreviewSession() {
        try {
            if (this.surfaceTexture == null) {
                this.surfaceTexture = new SurfaceTexture(11);
            }
            if (this.textureView != null) {
                this.handler.post(new Runnable() { // from class: com.baidu.aip.face.camera.Camera2Control.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Camera2Control.this.surfaceTexture.detachFromGLContext();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (Camera2Control.this.textureView.getSurfaceTexture() != Camera2Control.this.surfaceTexture) {
                            Camera2Control.this.textureView.setSurfaceTexture(Camera2Control.this.surfaceTexture);
                        }
                    }
                });
            }
            Surface surface = new Surface(this.surfaceTexture);
            if (ORIENTATIONS.get(this.orientation) % 180 == 90) {
                this.surfaceTexture.setDefaultBufferSize(this.preferredWidth, this.preferredHeight);
            } else {
                this.surfaceTexture.setDefaultBufferSize(this.preferredHeight, this.preferredWidth);
            }
            CaptureRequest.Builder createCaptureRequest = this.cameraDevice.createCaptureRequest(1);
            this.previewRequestBuilder = createCaptureRequest;
            createCaptureRequest.addTarget(surface);
            ImageReader newInstance = ImageReader.newInstance(this.preferredWidth, this.preferredHeight, 35, 2);
            this.imageReader = newInstance;
            newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.baidu.aip.face.camera.Camera2Control.5
                /* JADX WARN: Code restructure failed: missing block: B:7:0x004e, code lost:
                    if (r0 == 270) goto L7;
                 */
                @Override // android.media.ImageReader.OnImageAvailableListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onImageAvailable(android.media.ImageReader r7) {
                    /*
                        Method dump skipped, instructions count: 338
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.aip.face.camera.Camera2Control.AnonymousClass5.onImageAvailable(android.media.ImageReader):void");
                }
            }, this.backgroundHandler);
            this.previewRequestBuilder.addTarget(this.imageReader.getSurface());
            updateFlashMode(this.flashMode, this.previewRequestBuilder);
            this.cameraDevice.createCaptureSession(Arrays.asList(surface, this.imageReader.getSurface()), new CameraCaptureSession.StateCallback() { // from class: com.baidu.aip.face.camera.Camera2Control.6
                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    Log.e("xx", "onConfigureFailed" + cameraCaptureSession);
                }

                @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    if (Camera2Control.this.cameraDevice == null) {
                        return;
                    }
                    Camera2Control.this.captureSession = cameraCaptureSession;
                    try {
                        Camera2Control.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                        Camera2Control.this.previewRequest = Camera2Control.this.previewRequestBuilder.build();
                        Camera2Control.this.captureSession.setRepeatingRequest(Camera2Control.this.previewRequest, Camera2Control.this.captureCallback, Camera2Control.this.backgroundHandler);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }, this.backgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private Size getOptimalSize(Size[] sizeArr, int i, int i2, int i3, int i4, Size size) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int width = size.getWidth();
        int height = size.getHeight();
        int length = sizeArr.length;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= length) {
                break;
            }
            Size size2 = sizeArr[i6];
            if (size2.getWidth() <= i3 && size2.getHeight() <= i4 && size2.getHeight() == (size2.getWidth() * height) / width) {
                if (size2.getWidth() < i || size2.getHeight() < i2) {
                    arrayList2.add(size2);
                } else {
                    arrayList.add(size2);
                }
            }
            i5 = i6 + 1;
        }
        if (arrayList.size() > 0) {
            return (Size) Collections.min(arrayList, this.sizeComparator);
        }
        int length2 = sizeArr.length;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= length2) {
                return arrayList2.size() > 0 ? (Size) Collections.max(arrayList2, this.sizeComparator) : sizeArr[0];
            }
            Size size3 = sizeArr[i8];
            if (size3.getWidth() > i3 && size3.getHeight() > i4) {
                return size3;
            }
            i7 = i8 + 1;
        }
    }

    private int getOrientation(int i) {
        return ((ORIENTATIONS.get(i) + this.sensorOrientation) + 270) % 360;
    }

    private void lockFocus() {
        if (this.captureSession == null || this.state != 0) {
            return;
        }
        try {
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            this.state = 1;
            this.captureSession.capture(this.previewRequestBuilder.build(), this.captureCallback, this.backgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void openCamera(int i, int i2) {
        if (ContextCompat.checkSelfPermission(this.context, Manifest.permission.CAMERA) != 0) {
            requestCameraPermission();
            return;
        }
        setUpCameraOutputs(i, i2);
        configureTransform(i, i2);
        CameraManager cameraManager = (CameraManager) this.context.getSystemService("camera");
        try {
            if (!this.cameraLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
                throw new RuntimeException("Time out waiting to lock camera opening.");
            }
            cameraManager.openCamera("0", this.deviceStateCallback, this.backgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e2);
        }
    }

    private void requestCameraPermission() {
        PermissionCallback permissionCallback = this.permissionCallback;
        if (permissionCallback != null) {
            permissionCallback.onRequestPermission();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runPreCaptureSequence() {
        try {
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            this.state = 2;
            this.captureSession.capture(this.previewRequestBuilder.build(), this.captureCallback, this.backgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
        r0 = (android.view.WindowManager) r11.context.getSystemService(android.content.Context.WINDOW_SERVICE);
        r0 = new android.graphics.Point();
        r0.getDefaultDisplay().getSize(r0);
        r0 = java.lang.Math.max(2048, (r0.y * 2) / 3);
        r0 = getOptimalSize(r0.getOutputSizes(256), r11.textureView.getWidth(), r11.textureView.getHeight(), r0, r0, new android.util.Size(4, 3));
        r0 = r11.orientation;
        r11.sensorOrientation = ((java.lang.Integer) r0.get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00de, code lost:
        if (r0 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00e3, code lost:
        if (r0 == 1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e8, code lost:
        if (r0 == 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ed, code lost:
        if (r0 == 3) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f0, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00fa, code lost:
        if (r11.sensorOrientation == 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ff, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0107, code lost:
        if (r11.sensorOrientation != 180) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0113, code lost:
        if (r11.sensorOrientation == 90) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0118, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0120, code lost:
        if (r11.sensorOrientation != 270) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0126, code lost:
        r0 = r0.x;
        r0 = r0.y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0135, code lost:
        if (r14 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0147, code lost:
        r14 = r12;
        r15 = r13;
        r12 = r0.y;
        r13 = r0.x;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0154, code lost:
        r11.previewSize = getOptimalSize(r0.getOutputSizes(android.graphics.SurfaceTexture.class), r15, r14, java.lang.Math.min(r12, 1920), java.lang.Math.min(r13, 1080), r0);
        r11.cameraId = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0181, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0196, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x019b, code lost:
        r15 = r12;
        r14 = r13;
        r12 = r0;
        r13 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setUpCameraOutputs(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.aip.face.camera.Camera2Control.setUpCameraOutputs(int, int):void");
    }

    private void startBackgroundThread() {
        HandlerThread handlerThread = new HandlerThread("ocr_camera");
        this.backgroundThread = handlerThread;
        handlerThread.start();
        this.backgroundHandler = new Handler(this.backgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        HandlerThread handlerThread = this.backgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.backgroundThread = null;
            this.backgroundHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unlockFocus() {
        try {
            this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            this.captureSession.capture(this.previewRequestBuilder.build(), this.captureCallback, this.backgroundHandler);
            this.state = 0;
            this.captureSession.setRepeatingRequest(this.previewRequest, this.captureCallback, this.backgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void updateFlashMode(int i, CaptureRequest.Builder builder) {
        if (i == 0) {
            builder.set(CaptureRequest.FLASH_MODE, 0);
        } else if (i != 1) {
            builder.set(CaptureRequest.FLASH_MODE, 1);
        } else {
            builder.set(CaptureRequest.FLASH_MODE, 2);
        }
    }

    public static byte[] yuvImageToByteArray(Image image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        int i = width * height;
        byte[] bArr = new byte[(i * 3) / 2];
        int rowStride = planes[0].getRowStride();
        if (rowStride != width) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= height) {
                    break;
                }
                planes[0].getBuffer().position(i3 * rowStride);
                planes[0].getBuffer().get(bArr, i3 * width, width);
                i2 = i3 + 1;
            }
        } else {
            planes[0].getBuffer().get(bArr, 0, width);
        }
        int rowStride2 = planes[1].getRowStride();
        byte[] bArr2 = new byte[rowStride2];
        byte[] bArr3 = new byte[rowStride2];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= height / 2) {
                return bArr;
            }
            int i6 = width / 2;
            ByteBuffer buffer = planes[1].getBuffer();
            int i7 = i5 * rowStride2;
            buffer.position(i7);
            planes[1].getBuffer().get(bArr2, 0, i6);
            planes[2].getBuffer().position(i7);
            planes[2].getBuffer().get(bArr3, 0, i6);
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 < i6) {
                    int i10 = (i9 * 2) + (i6 * i5) + i;
                    bArr[i10] = bArr3[i9];
                    bArr[i10 + 1] = bArr2[i9];
                    i8 = i9 + 1;
                }
            }
            i4 = i5 + 1;
        }
    }

    public int getCameraDisplayOrientation(Context context, int i, int i2, Camera camera) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public View getDisplayView() {
        return this.textureView;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public int getFlashMode() {
        return this.flashMode;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public Rect getPreviewFrame() {
        return null;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public PreviewView getPreviewView() {
        return this.previewView;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void pause() {
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void refreshPermission() {
        openCamera(this.preferredWidth, this.preferredHeight);
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void resume() {
        this.state = 0;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setCameraFacing(int i) {
        this.camFacing = i == 0 ? 0 : 1;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setDisplayOrientation(int i) {
        this.orientation = i / 90;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setOnFrameListener(ICameraControl.OnFrameListener onFrameListener) {
        this.onFrameListener = onFrameListener;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setPermissionCallback(PermissionCallback permissionCallback) {
        this.permissionCallback = permissionCallback;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setPreferredPreviewSize(int i, int i2) {
        this.preferredWidth = Math.max(i, i2);
        this.preferredHeight = Math.min(i, i2);
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setPreviewView(PreviewView previewView) {
        this.previewView = previewView;
        this.textureView = previewView.getTextureView();
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.detachFromGLContext();
            this.textureView.setSurfaceTexture(this.surfaceTexture);
        }
        this.textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void start() {
        startBackgroundThread();
        openCamera(this.preferredWidth, this.preferredHeight);
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void stop() {
        ImageReader imageReader = this.imageReader;
        if (imageReader != null) {
            imageReader.close();
            closeCamera();
            stopBackgroundThread();
            this.imageReader = null;
        }
    }

    public void switchCamera() {
        if (this.camFacing == 1) {
            this.camFacing = 0;
        } else {
            this.camFacing = 1;
        }
        stop();
        this.handler.postDelayed(new Runnable() { // from class: com.baidu.aip.face.camera.Camera2Control.1
            @Override // java.lang.Runnable
            public void run() {
                Camera2Control.this.start();
            }
        }, 800L);
    }
}
