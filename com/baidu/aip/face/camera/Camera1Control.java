package com.baidu.aip.face.camera;

import android.Manifest;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.baidu.aip.face.PreviewView;
import com.baidu.aip.face.camera.ICameraControl;
import com.tencent.ugc.UGCTransitionRules;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/camera/Camera1Control.class */
public class Camera1Control implements ICameraControl {
    private static final int MAX_PREVIEW_SIZE = 2048;
    private static final SparseIntArray ORIENTATIONS;
    private Camera camera;
    private Context context;
    private int flashMode;
    private ICameraControl.OnFrameListener onFrameListener;
    private Camera.Parameters parameters;
    private PermissionCallback permissionCallback;
    private PreviewView previewView;
    private SurfaceTexture surfaceTexture;
    private TextureView textureView;
    private int displayOrientation = 0;
    private int cameraId = 0;
    private AtomicBoolean takingPicture = new AtomicBoolean(false);
    private HandlerThread cameraHandlerThread = null;
    private Handler cameraHandler = null;
    private Handler uiHandler = null;
    private Rect previewFrame = new Rect();
    private int preferredWidth = 1280;
    private int preferredHeight = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
    private int cameraFacing = 1;
    private Comparator<Camera.Size> sizeComparator = new Comparator<Camera.Size>() { // from class: com.baidu.aip.face.camera.Camera1Control.4
        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ORIENTATIONS = sparseIntArray;
        sparseIntArray.append(0, 0);
        ORIENTATIONS.append(1, 90);
        ORIENTATIONS.append(2, 180);
        ORIENTATIONS.append(3, 270);
    }

    public Camera1Control(Context context) {
        this.context = context;
    }

    private int getCameraDisplayOrientation(int i, int i2, Camera camera) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        return cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360;
    }

    private Camera.Size getOptimalSize(int i, int i2, List<Camera.Size> list) {
        Camera.Size size = list.get(0);
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size2 : list) {
            if (size2.width >= i && size2.height >= i2 && size2.width * i2 == size2.height * i) {
                arrayList.add(size2);
            } else if (size2.height >= i && size2.width >= i2 && size2.width * i == size2.height * i2) {
                arrayList.add(size2);
            }
        }
        if (arrayList.isEmpty()) {
            for (Camera.Size size3 : list) {
                if (size3.width >= i && size3.height >= i2) {
                    return size3;
                }
            }
            return size;
        }
        return (Camera.Size) Collections.min(arrayList, this.sizeComparator);
    }

    private int getSurfaceOrientation() {
        int i = this.displayOrientation;
        if (i != 1) {
            return i != 2 ? 90 : 180;
        }
        return 0;
    }

    private void opPreviewSize(int i, int i2) {
        Camera camera = this.camera;
        if (camera == null || i <= 0) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            Camera.Size optimalSize = getOptimalSize(i, i2, this.camera.getParameters().getSupportedPreviewSizes());
            Log.i("wtf", "opPreviewSize-> " + optimalSize.width + " " + optimalSize.height);
            parameters.setPreviewSize(optimalSize.width, optimalSize.height);
            this.camera.setParameters(parameters);
            this.camera.startPreview();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private void postStartCamera() {
        HandlerThread handlerThread = this.cameraHandlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            HandlerThread handlerThread2 = new HandlerThread("camera");
            this.cameraHandlerThread = handlerThread2;
            handlerThread2.start();
            this.cameraHandler = new Handler(this.cameraHandlerThread.getLooper());
            this.uiHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.cameraHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.baidu.aip.face.camera.Camera1Control.1
            @Override // java.lang.Runnable
            public void run() {
                Camera1Control.this.startCamera();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b9, code lost:
        if (r0 == 270) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startCamera() {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.aip.face.camera.Camera1Control.startCamera():void");
    }

    private void startPreview(boolean z) {
        PermissionCallback permissionCallback;
        if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.CAMERA) == 0) {
            this.camera.startPreview();
        } else if (!z || (permissionCallback = this.permissionCallback) == null) {
        } else {
            permissionCallback.onRequestPermission();
        }
    }

    private void updateFlashMode(int i) {
        if (i == 0) {
            this.parameters.setFlashMode("off");
        } else if (i == 1) {
            this.parameters.setFlashMode("torch");
        } else if (i != 2) {
            this.parameters.setFlashMode("auto");
        } else {
            this.parameters.setFlashMode("auto");
        }
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public View getDisplayView() {
        return null;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public int getFlashMode() {
        return this.flashMode;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public Rect getPreviewFrame() {
        return this.previewFrame;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public PreviewView getPreviewView() {
        return this.previewView;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void pause() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.stopPreview();
        }
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void refreshPermission() {
        startPreview(true);
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void resume() {
        this.takingPicture.set(false);
        if (this.camera == null) {
            postStartCamera();
        }
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setCameraFacing(int i) {
        this.cameraFacing = i;
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void setDisplayOrientation(int i) {
        this.displayOrientation = i;
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
        setTextureView(previewView.getTextureView());
    }

    public void setTextureView(TextureView textureView) {
        this.textureView = textureView;
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.detachFromGLContext();
            textureView.setSurfaceTexture(this.surfaceTexture);
        }
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void start() {
        postStartCamera();
    }

    @Override // com.baidu.aip.face.camera.ICameraControl
    public void stop() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.stopPreview();
            this.camera.setPreviewCallback(null);
            this.camera.release();
            this.camera = null;
        }
        HandlerThread handlerThread = this.cameraHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.cameraHandlerThread = null;
        }
    }
}
