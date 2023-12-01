package com.sobot.chat.camera;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sobot.chat.camera.listener.StErrorListener;
import com.sobot.chat.camera.util.AngleUtil;
import com.sobot.chat.camera.util.CameraParamUtil;
import com.sobot.chat.camera.util.CheckPermission;
import com.sobot.chat.camera.util.DeviceUtil;
import com.sobot.chat.camera.util.ScreenUtils;
import com.sobot.chat.camera.util.StCmeraLog;
import com.sobot.chat.utils.CommonUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/CameraInterface.class */
public class CameraInterface implements Camera.PreviewCallback {
    private static final String TAG = "CJT";
    public static final int TYPE_CAPTURE = 145;
    public static final int TYPE_RECORDER = 144;
    private static volatile CameraInterface mCameraInterface;
    private int SELECTED_CAMERA;
    private StErrorListener errorLisenter;
    private byte[] firstFrame_data;
    private Camera mCamera;
    private Context mContext;
    private Camera.Parameters mParams;
    private ImageView mSwitchView;
    private MediaRecorder mediaRecorder;
    private int nowAngle;
    private int preview_height;
    private int preview_width;
    private String saveVideoPath;
    private String videoFileAbsPath;
    private String videoFileName;
    private boolean isPreviewing = false;
    private int CAMERA_POST_POSITION = -1;
    private int CAMERA_FRONT_POSITION = -1;
    private SurfaceHolder mHolder = null;
    private float screenProp = -1.0f;
    private boolean isRecorder = false;
    private Bitmap videoFirstFrame = null;
    private int angle = 0;
    private int cameraAngle = 90;
    private int rotation = 0;
    private int nowScaleRate = 0;
    private int recordScleRate = 0;
    private int mediaQuality = StCameraView.MEDIA_QUALITY_MIDDLE;
    private SensorManager sm = null;
    private SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.sobot.chat.camera.CameraInterface.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 != sensorEvent.sensor.getType()) {
                return;
            }
            float[] fArr = sensorEvent.values;
            CameraInterface.this.angle = AngleUtil.getSensorAngle(fArr[0], fArr[1]);
            CameraInterface.this.rotationAnimation();
        }
    };
    int handlerTime = 0;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/CameraInterface$CameraOpenOverCallback.class */
    public interface CameraOpenOverCallback {
        void cameraHasOpened();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/CameraInterface$DestoryLinsten.class */
    interface DestoryLinsten {
        void onDestory();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/CameraInterface$ErrorCallback.class */
    public interface ErrorCallback {
        void onError();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/CameraInterface$FocusCallback.class */
    public interface FocusCallback {
        void focusSuccess();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/CameraInterface$StopRecordCallback.class */
    public interface StopRecordCallback {
        void recordResult(String str, Bitmap bitmap);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/CameraInterface$TakePictureCallback.class */
    public interface TakePictureCallback {
        void captureResult(Bitmap bitmap, boolean z);
    }

    private CameraInterface() {
        this.SELECTED_CAMERA = -1;
        findAvailableCameras();
        this.SELECTED_CAMERA = this.CAMERA_POST_POSITION;
        this.saveVideoPath = "";
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            int round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            int i5 = round2;
            if (round < round2) {
                i5 = round;
            }
            return i5;
        }
        return 1;
    }

    private static Rect calculateTapArea(float f, float f2, float f3, Context context) {
        int intValue = Float.valueOf(f3 * 300.0f).intValue();
        int screenWidth = (int) (((f / ScreenUtils.getScreenWidth(context)) * 2000.0f) - 1000.0f);
        int screenHeight = (int) (((f2 / ScreenUtils.getScreenHeight(context)) * 2000.0f) - 1000.0f);
        int i = intValue / 2;
        int clamp = clamp(screenWidth - i, -1000, 1000);
        int clamp2 = clamp(screenHeight - i, -1000, 1000);
        RectF rectF = new RectF(clamp, clamp2, clamp + intValue, clamp2 + intValue);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap compressBitmap(byte[] bArr, Context context) {
        int i;
        int i2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            i2 = windowManager.getDefaultDisplay().getWidth();
            i = windowManager.getDefaultDisplay().getHeight();
        } else {
            i = 0;
            i2 = 0;
        }
        options.inSampleSize = calculateInSampleSize(options, i2, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static void destroyCameraInterface() {
        if (mCameraInterface != null) {
            mCameraInterface = null;
        }
    }

    private void findAvailableCameras() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= numberOfCameras) {
                return;
            }
            Camera.getCameraInfo(i2, cameraInfo);
            int i3 = cameraInfo.facing;
            if (i3 == 0) {
                this.CAMERA_POST_POSITION = cameraInfo.facing;
            } else if (i3 == 1) {
                this.CAMERA_FRONT_POSITION = cameraInfo.facing;
            }
            i = i2 + 1;
        }
    }

    public static CameraInterface getInstance() {
        CameraInterface cameraInterface;
        synchronized (CameraInterface.class) {
            try {
                if (mCameraInterface == null) {
                    synchronized (CameraInterface.class) {
                        if (mCameraInterface == null) {
                            mCameraInterface = new CameraInterface();
                        }
                    }
                }
                cameraInterface = mCameraInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cameraInterface;
    }

    private void openCamera(int i) {
        synchronized (this) {
            try {
                this.mCamera = Camera.open(i);
            } catch (Exception e) {
                e.printStackTrace();
                if (this.errorLisenter != null) {
                    this.errorLisenter.onError();
                }
            }
            if (Build.VERSION.SDK_INT > 17 && this.mCamera != null) {
                try {
                    this.mCamera.enableShutterSound(false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.e(TAG, "enable shutter sound faild");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotationAnimation() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mSwitchView == null || (i = this.rotation) == (i2 = this.angle)) {
            return;
        }
        int i5 = 270;
        if (i == 0) {
            int i6 = -90;
            if (i2 != 90) {
                i6 = i2 != 270 ? 0 : 90;
            }
            i3 = i6;
            i4 = 0;
        } else if (i == 90) {
            i4 = -90;
            if (i2 != 0) {
                if (i2 != 180) {
                    i4 = -90;
                } else {
                    i4 = -90;
                    i3 = -180;
                }
            }
            i3 = 0;
        } else if (i != 180) {
            if (i != 270) {
                i4 = 0;
            } else if (i2 == 0 || i2 != 180) {
                i4 = 90;
            } else {
                i4 = 90;
                i3 = 180;
            }
            i3 = 0;
        } else {
            if (i2 != 90) {
                i5 = i2 != 270 ? 0 : 90;
            }
            i3 = i5;
            i4 = 180;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mSwitchView, "rotation", i4, i3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.start();
        this.rotation = this.angle;
    }

    private void setFlashModel() {
        Camera.Parameters parameters = this.mCamera.getParameters();
        this.mParams = parameters;
        parameters.setFlashMode("torch");
        this.mCamera.setParameters(this.mParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroyCamera() {
        Camera camera = this.mCamera;
        if (camera == null) {
            Log.i(TAG, "=== Camera  Null===");
            return;
        }
        try {
            camera.setPreviewCallback(null);
            this.mSwitchView = null;
            this.mCamera.stopPreview();
            this.mCamera.setPreviewDisplay(null);
            this.mHolder = null;
            this.isPreviewing = false;
            this.mCamera.release();
            this.mCamera = null;
            Log.i(TAG, "=== Destroy Camera ===");
        } catch (Exception e) {
            e.printStackTrace();
            this.errorLisenter.onError();
            destroyCameraInterface();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doOpenCamera(CameraOpenOverCallback cameraOpenOverCallback) {
        StErrorListener stErrorListener;
        if (Build.VERSION.SDK_INT < 23 && !CheckPermission.isCameraUseable(this.SELECTED_CAMERA) && (stErrorListener = this.errorLisenter) != null) {
            stErrorListener.onError();
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
        }
        cameraOpenOverCallback.cameraHasOpened();
    }

    public void doStartPreview(SurfaceHolder surfaceHolder, float f) {
        if (this.isPreviewing) {
            StCmeraLog.i("doStartPreview isPreviewing");
        }
        if (this.screenProp < 0.0f) {
            this.screenProp = f;
        }
        if (surfaceHolder == null) {
            return;
        }
        this.mHolder = surfaceHolder;
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                this.mParams = camera.getParameters();
                Camera.Size previewSize = CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 1000, f);
                Camera.Size pictureSize = CameraParamUtil.getInstance().getPictureSize(this.mParams.getSupportedPictureSizes(), 1000, f);
                this.mParams.setPreviewSize(previewSize.width, previewSize.height);
                this.preview_width = previewSize.width;
                this.preview_height = previewSize.height;
                this.mParams.setPictureSize(pictureSize.width, pictureSize.height);
                this.mParams.setRecordingHint(true);
                if (CameraParamUtil.getInstance().isSupportedFocusMode(this.mParams.getSupportedFocusModes(), "auto")) {
                    this.mParams.setFocusMode("auto");
                }
                if (CameraParamUtil.getInstance().isSupportedPictureFormats(this.mParams.getSupportedPictureFormats(), 256)) {
                    this.mParams.setPictureFormat(256);
                    this.mParams.setJpegQuality(100);
                }
                this.mCamera.setParameters(this.mParams);
                this.mParams = this.mCamera.getParameters();
                this.mCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.setDisplayOrientation(this.cameraAngle);
                this.mCamera.setPreviewCallback(this);
                this.mCamera.startPreview();
                this.isPreviewing = true;
                Log.i(TAG, "=== Start Preview ===");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void doStopPreview() {
        Camera camera = this.mCamera;
        if (camera != null) {
            try {
                camera.setPreviewCallback(null);
                this.mCamera.stopPreview();
                this.mCamera.setPreviewDisplay(null);
                this.isPreviewing = false;
                Log.i(TAG, "=== Stop Preview ===");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void handleFocus(final Context context, final float f, final float f2, final FocusCallback focusCallback) {
        Camera.Parameters parameters;
        Camera camera = this.mCamera;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return;
        }
        Rect calculateTapArea = calculateTapArea(f, f2, 1.0f, context);
        this.mCamera.cancelAutoFocus();
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i(TAG, "focus areas not supported");
            focusCallback.focusSuccess();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Camera.Area(calculateTapArea, 800));
        parameters.setFocusAreas(arrayList);
        final String focusMode = parameters.getFocusMode();
        try {
            parameters.setFocusMode("auto");
            this.mCamera.setParameters(parameters);
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.sobot.chat.camera.CameraInterface.3
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean z, Camera camera2) {
                    if (!z && CameraInterface.this.handlerTime <= 10) {
                        CameraInterface.this.handlerTime++;
                        CameraInterface.this.handleFocus(context, f, f2, focusCallback);
                        return;
                    }
                    Camera.Parameters parameters2 = camera2.getParameters();
                    parameters2.setFocusMode(focusMode);
                    camera2.setParameters(parameters2);
                    CameraInterface.this.handlerTime = 0;
                    focusCallback.focusSuccess();
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "autoFocus failer");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void isPreview(boolean z) {
        this.isPreviewing = z;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.firstFrame_data = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService("sensor");
        }
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            sensorManager.registerListener(this.sensorEventListener, sensorManager.getDefaultSensor(1), 3);
        }
    }

    public void setContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setErrorLinsenter(StErrorListener stErrorListener) {
        this.errorLisenter = stErrorListener;
    }

    public void setFlashMode(String str) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(str);
        this.mCamera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMediaQuality(int i) {
        this.mediaQuality = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSaveVideoPath(String str) {
        this.saveVideoPath = str;
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public void setSwitchView(ImageView imageView) {
        this.mSwitchView = imageView;
        if (imageView != null) {
            this.cameraAngle = CameraParamUtil.getInstance().getCameraDisplayOrientation(imageView.getContext(), this.SELECTED_CAMERA);
        }
    }

    public void setZoom(float f, int i) {
        int i2;
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        if (this.mParams == null) {
            this.mParams = camera.getParameters();
        }
        if (this.mParams.isZoomSupported() && this.mParams.isSmoothZoomSupported()) {
            if (i == 144) {
                if (this.isRecorder && f >= 0.0f && (i2 = (int) (f / 40.0f)) <= this.mParams.getMaxZoom() && i2 >= this.nowScaleRate && this.recordScleRate != i2) {
                    this.mParams.setZoom(i2);
                    this.mCamera.setParameters(this.mParams);
                    this.recordScleRate = i2;
                }
            } else if (i == 145 && !this.isRecorder) {
                int i3 = (int) (f / 50.0f);
                if (i3 < this.mParams.getMaxZoom()) {
                    int i4 = this.nowScaleRate + i3;
                    this.nowScaleRate = i4;
                    if (i4 < 0) {
                        this.nowScaleRate = 0;
                    } else if (i4 > this.mParams.getMaxZoom()) {
                        this.nowScaleRate = this.mParams.getMaxZoom();
                    }
                    this.mParams.setZoom(this.nowScaleRate);
                    this.mCamera.setParameters(this.mParams);
                }
                StCmeraLog.i("setZoom = " + this.nowScaleRate);
            }
        }
    }

    public void startRecord(Surface surface, float f, ErrorCallback errorCallback) {
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
            if (this.mCamera == null) {
                return;
            }
        }
        this.mCamera.stopPreview();
        this.mCamera.setPreviewCallback(null);
        int i = (this.angle + 90) % 360;
        Camera.Parameters parameters = this.mCamera.getParameters();
        if (parameters == null) {
            return;
        }
        int i2 = parameters.getPreviewSize().width;
        int i3 = parameters.getPreviewSize().height;
        YuvImage yuvImage = new YuvImage(this.firstFrame_data, parameters.getPreviewFormat(), i2, i3, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.videoFirstFrame = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Matrix matrix = new Matrix();
        int i4 = this.SELECTED_CAMERA;
        if (i4 == this.CAMERA_POST_POSITION) {
            matrix.setRotate(i);
        } else if (i4 == this.CAMERA_FRONT_POSITION) {
            matrix.setRotate(270.0f);
        }
        Bitmap bitmap = this.videoFirstFrame;
        this.videoFirstFrame = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.videoFirstFrame.getHeight(), matrix, true);
        if (this.isRecorder) {
            return;
        }
        if (this.mCamera == null) {
            openCamera(this.SELECTED_CAMERA);
            if (this.mCamera == null) {
                return;
            }
        }
        if (this.mediaRecorder == null) {
            this.mediaRecorder = new MediaRecorder();
        }
        if (this.mParams == null) {
            Camera.Parameters parameters2 = this.mCamera.getParameters();
            this.mParams = parameters2;
            if (parameters2 == null) {
                return;
            }
        }
        if (this.mParams.getSupportedFocusModes().contains("continuous-video")) {
            this.mParams.setFocusMode("continuous-video");
        }
        this.mCamera.setParameters(this.mParams);
        this.mCamera.unlock();
        this.mediaRecorder.reset();
        this.mediaRecorder.setCamera(this.mCamera);
        this.mediaRecorder.setVideoSource(1);
        this.mediaRecorder.setAudioSource(1);
        this.mediaRecorder.setOutputFormat(2);
        this.mediaRecorder.setVideoEncoder(2);
        this.mediaRecorder.setAudioEncoder(3);
        Camera.Size previewSize = this.mParams.getSupportedVideoSizes() == null ? CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedPreviewSizes(), 600, f) : CameraParamUtil.getInstance().getPreviewSize(this.mParams.getSupportedVideoSizes(), 600, f);
        Log.i(TAG, "setVideoSize    width = " + previewSize.width + "height = " + previewSize.height);
        if (previewSize.width == previewSize.height) {
            this.mediaRecorder.setVideoSize(this.preview_width, this.preview_height);
        } else {
            this.mediaRecorder.setVideoSize(previewSize.width, previewSize.height);
        }
        if (this.SELECTED_CAMERA != this.CAMERA_FRONT_POSITION) {
            this.mediaRecorder.setOrientationHint(i);
        } else if (this.cameraAngle == 270) {
            if (i == 0) {
                this.mediaRecorder.setOrientationHint(180);
            } else if (i == 270) {
                this.mediaRecorder.setOrientationHint(270);
            } else {
                this.mediaRecorder.setOrientationHint(90);
            }
        } else if (i == 90) {
            this.mediaRecorder.setOrientationHint(270);
        } else if (i == 270) {
            this.mediaRecorder.setOrientationHint(90);
        } else {
            this.mediaRecorder.setOrientationHint(i);
        }
        if (DeviceUtil.isHuaWeiRongyao()) {
            this.mediaRecorder.setVideoEncodingBitRate(StCameraView.MEDIA_QUALITY_FUNNY);
        } else {
            this.mediaRecorder.setVideoEncodingBitRate(this.mediaQuality);
        }
        this.mediaRecorder.setPreviewDisplay(surface);
        this.videoFileName = "v_" + System.currentTimeMillis() + ".mp4";
        if (this.saveVideoPath.equals("")) {
            this.saveVideoPath = CommonUtils.getSDCardRootPath(this.mContext);
        }
        String str = this.saveVideoPath + File.separator + this.videoFileName;
        this.videoFileAbsPath = str;
        this.mediaRecorder.setOutputFile(str);
        try {
            this.mediaRecorder.prepare();
            this.mediaRecorder.start();
            this.isRecorder = true;
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG, "startRecord IOException");
            StErrorListener stErrorListener = this.errorLisenter;
            if (stErrorListener != null) {
                stErrorListener.onError();
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            Log.i(TAG, "startRecord IllegalStateException");
            StErrorListener stErrorListener2 = this.errorLisenter;
            if (stErrorListener2 != null) {
                stErrorListener2.onError();
            }
        } catch (RuntimeException e3) {
            Log.i(TAG, "startRecord RuntimeException");
        } catch (Exception e4) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r7 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        r7.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
        r4.mediaRecorder = null;
        r4.isRecorder = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
        if (r7 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        if (r5 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        if (com.sobot.chat.camera.util.FileUtil.deleteFile(r4.videoFileAbsPath) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
        r6.recordResult(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
        doStopPreview();
        r0 = r4.saveVideoPath + java.io.File.separator + r4.videoFileName;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b0, code lost:
        if (r6 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b3, code lost:
        r6.recordResult(r0, r4.videoFirstFrame);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00be, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void stopRecord(boolean r5, com.sobot.chat.camera.CameraInterface.StopRecordCallback r6) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.camera.CameraInterface.stopRecord(boolean, com.sobot.chat.camera.CameraInterface$StopRecordCallback):void");
    }

    public void switchCamera(SurfaceHolder surfaceHolder, float f) {
        synchronized (this) {
            if (this.SELECTED_CAMERA == this.CAMERA_POST_POSITION) {
                this.SELECTED_CAMERA = this.CAMERA_FRONT_POSITION;
            } else {
                this.SELECTED_CAMERA = this.CAMERA_POST_POSITION;
            }
            doDestroyCamera();
            StCmeraLog.i("open start");
            openCamera(this.SELECTED_CAMERA);
            if (Build.VERSION.SDK_INT > 17 && this.mCamera != null) {
                try {
                    this.mCamera.enableShutterSound(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            StCmeraLog.i("open end");
            doStartPreview(surfaceHolder, f);
        }
    }

    public void takePicture(final TakePictureCallback takePictureCallback) {
        if (this.mCamera == null) {
            return;
        }
        int i = this.cameraAngle;
        if (i == 90) {
            this.nowAngle = Math.abs(this.angle + i) % 360;
        } else if (i == 270) {
            this.nowAngle = Math.abs(i - this.angle);
        }
        Log.i(TAG, this.angle + " = " + this.cameraAngle + " = " + this.nowAngle);
        try {
            this.mCamera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.sobot.chat.camera.CameraInterface.2
                @Override // android.hardware.Camera.PictureCallback
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    CameraInterface cameraInterface = CameraInterface.this;
                    Bitmap compressBitmap = cameraInterface.compressBitmap(bArr, cameraInterface.mContext);
                    Matrix matrix = new Matrix();
                    if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_POST_POSITION) {
                        matrix.setRotate(CameraInterface.this.nowAngle);
                    } else if (CameraInterface.this.SELECTED_CAMERA == CameraInterface.this.CAMERA_FRONT_POSITION) {
                        matrix.setRotate(360 - CameraInterface.this.nowAngle);
                        matrix.postScale(-1.0f, 1.0f);
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(compressBitmap, 0, 0, compressBitmap.getWidth(), compressBitmap.getHeight(), matrix, true);
                    if (takePictureCallback != null) {
                        if (CameraInterface.this.nowAngle == 90 || CameraInterface.this.nowAngle == 270) {
                            takePictureCallback.captureResult(createBitmap, true);
                        } else {
                            takePictureCallback.captureResult(createBitmap, false);
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterSensorManager(Context context) {
        if (this.sm == null) {
            this.sm = (SensorManager) context.getSystemService("sensor");
        }
        SensorManager sensorManager = this.sm;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.sensorEventListener);
        }
        this.sm = null;
    }
}
