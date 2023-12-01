package com.zego.ve;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.zego.ve.CameraAvailabilityCallback;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VCam.class */
public class VCam implements Handler.Callback {
    private static final int EXPOSURE_MODE_AUTO = 0;
    private static final int EXPOSURE_MODE_AUTO_EXPOSURE = 4;
    private static final int EXPOSURE_MODE_CONTINUOUS_AUTO_EXPOSURE = 5;
    private static final int EXPOSURE_MODE_CUSTOM = 1;
    private static final int FOCUS_MODE_AUTO = 0;
    private static final int FOCUS_MODE_AUTO_FOCUS = 8;
    private static final int FOCUS_MODE_CONTINUOUS_AUTO_FOCUS = 9;
    private static final int FOCUS_MODE_CONTINUOUS_PICTURE = 6;
    private static final int FOCUS_MODE_CONTINUOUS_VIDEO = 5;
    private static final int FOCUS_MODE_EDOF = 4;
    private static final int FOCUS_MODE_FIXED = 3;
    private static final int FOCUS_MODE_INFINITY = 1;
    private static final int FOCUS_MODE_MACRO = 2;
    private static final int MESSAGE_EXPOSURE_LOCK = 0;
    private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    private static final int SCENE_MODE_ACTION = 3;
    private static final int SCENE_MODE_LOW_LIGHT = 1;
    private static final int SCENE_MODE_NIGHT = 2;
    private static final int SCENE_MODE_NONE = 0;
    private static final int SCENE_MODE_PORTRAIT = 4;
    private static final String TAG = "vcap";
    private long mThis = 0;
    private Context mContext = null;
    private CameraAvailabilityCallback mCameraAvailabilityCallback = null;
    int mWidth = 640;
    int mHeight = 480;
    int mFrameRate = 15;
    boolean mNeedHack = false;
    int mFocusMode = -1;
    int mExposureMode = -1;
    float mExposureCompensation = 0.0f;
    float mFocusPointX = 0.0f;
    float mFocusPointY = 0.0f;
    float mExposurePointX = 0.0f;
    float mExposurePointY = 0.0f;
    int mFrontCameraId = -1;
    int mBackCameraId = -1;
    int mUseCameraId = -1;
    int mFPSMode = 0;
    boolean mUseFaceDetection = false;
    boolean mIsFocusing = false;
    int mAreaSize = 0;
    private Matrix matrix = new Matrix();
    int mSceneMode = 0;
    private boolean mTryDefault = true;
    private boolean mCamera2Error = false;
    boolean mLowLightBoost = false;
    private Handler mHandler = null;
    private int mExposureGeneration = 0;
    int mFpsMin = -1000;
    int mFpsMax = -1000;
    private final Set<byte[]> queuedBuffers = new HashSet();
    private int mFrameSize = 0;
    private CameraDev mCamDevice = null;
    private String[] mCameraIDList = null;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VCam$Cam2Device.class */
    class Cam2Device extends CameraDev {
        private Handler mCam2Handler;
        private HandlerThread mCam2Thread;
        private CameraCaptureSession mCamCapSession;
        private CameraCharacteristics mCamCharacteristics;
        public CameraDevice mCamDevice;
        private CaptureRequest.Builder mCapRequestBuilder;
        private DevStateCallback mDevStateCallback;
        private ImageReader mImageReader;
        private Semaphore mOpenSem;
        private boolean mOpened;
        private SessionStateCallback mSessionStateCallback;
        private SurfaceTexture mSurfaceTexture;

        /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VCam$Cam2Device$DevStateCallback.class */
        class DevStateCallback extends CameraDevice.StateCallback {
            DevStateCallback() {
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onClosed(CameraDevice cameraDevice) {
                android.util.Log.i(VCam.TAG, "vcap: camera onClosed");
                Cam2Device.this.mOpened = false;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                android.util.Log.i(VCam.TAG, "vcap: camera onDisconnected");
                Cam2Device.this.mOpened = false;
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i) {
                android.util.Log.i(VCam.TAG, "vcap: camera onError " + i);
                if (i == 4 || i == 5) {
                    VCam.this.mCamera2Error = true;
                }
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                Cam2Device.this.mOpened = true;
                Cam2Device.this.mCamDevice = cameraDevice;
                Cam2Device.this.mOpenSem.release();
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VCam$Cam2Device$SessionStateCallback.class */
        class SessionStateCallback extends CameraCaptureSession.StateCallback {
            SessionStateCallback() {
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                VCam.this.mCamera2Error = true;
                android.util.Log.i(VCam.TAG, "vcap: onConfigured failed");
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                try {
                    Cam2Device.this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                    Cam2Device.this.mCamCapSession = cameraCaptureSession;
                    Cam2Device.this.mCamCapSession.setRepeatingRequest(Cam2Device.this.mCapRequestBuilder.build(), null, null);
                } catch (Exception e) {
                    VCam.this.mCamera2Error = true;
                    android.util.Log.i(VCam.TAG, "vcap: cap session failed");
                    e.printStackTrace();
                }
            }
        }

        Cam2Device() {
            super();
            this.mCamDevice = null;
            this.mCamCharacteristics = null;
            this.mCamCapSession = null;
            this.mCapRequestBuilder = null;
            this.mOpenSem = new Semaphore(0);
            this.mOpened = false;
            this.mSurfaceTexture = null;
            this.mCam2Thread = null;
            this.mCam2Handler = null;
            this.mImageReader = null;
            this.mDevStateCallback = new DevStateCallback();
            this.mSessionStateCallback = new SessionStateCallback();
        }

        private Rect calculateArea2(float f, float f2) {
            Rect rect = (Rect) this.mCamCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            int width = (int) (((f + 1.0f) / 2.0f) * rect.width());
            int height = (int) (((f2 + 1.0f) / 2.0f) * rect.height());
            int width2 = rect.width() / 10;
            int i = (VCam.this.mWidth * width2) / VCam.this.mHeight;
            int i2 = width2 / 2;
            int clamp = VCam.clamp(width - i2, 0, rect.width() - width2);
            int i3 = i / 2;
            return new Rect(clamp, VCam.clamp(height - i3, 0, rect.height() - i), VCam.clamp(width + i2, 0, rect.width()), VCam.clamp(height + i3, 0, rect.height()));
        }

        @Override // com.zego.ve.VCam.CameraDev
        int closeTorch() {
            if (this.mCapRequestBuilder != null && ((Boolean) this.mCamCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
                boolean z = true;
                try {
                    this.mCapRequestBuilder.set(CaptureRequest.FLASH_MODE, 0);
                    this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set flash mode failed");
                    e.printStackTrace();
                    z = false;
                }
                if (z) {
                    return 0;
                }
                android.util.Log.i(VCam.TAG, "vcap: vcap: flash mode left unset");
                return 0;
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int createCam(int i) {
            if (this.mCamDevice != null) {
                return 0;
            }
            if (this.mCam2Thread == null) {
                HandlerThread handlerThread = new HandlerThread("cam2_thread");
                this.mCam2Thread = handlerThread;
                handlerThread.start();
                this.mCam2Handler = new Handler(this.mCam2Thread.getLooper(), (Handler.Callback) null);
            }
            if (Build.VERSION.SDK_INT < 23 || VCam.this.checkPermission()) {
                CameraManager cameraManager = (CameraManager) VCam.this.mContext.getSystemService("camera");
                this.mOpened = false;
                try {
                    cameraManager.openCamera(VCam.this.mCameraIDList[i], this.mDevStateCallback, this.mCam2Handler);
                    this.mCamCharacteristics = cameraManager.getCameraCharacteristics(VCam.this.mCameraIDList[i]);
                    if (VCam.this.isSupportCamera2()) {
                        VCam.this.registerCameraAvailabilityCallback(i);
                    }
                    VCam.this.mUseCameraId = i;
                    return 0;
                } catch (CameraAccessException | RuntimeException e) {
                    Log.e(VCam.TAG, "trace interruption open " + VCam.this.GetCameraString(i) + " failed, " + e);
                    VCam.this.mCamera2Error = true;
                    return -1;
                }
            }
            return -1;
        }

        int doSetExposureCompensation(float f) {
            Range range = (Range) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
            int intValue = ((Integer) range.getLower()).intValue();
            int intValue2 = ((Integer) range.getUpper()).intValue();
            if (intValue == 0 && intValue2 == 0) {
                return -1;
            }
            if (f < 0.0f) {
                intValue2 = -intValue;
            }
            int i = (int) (intValue2 * f);
            try {
                this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(i));
                android.util.Log.i(VCam.TAG, "vcap: set exposure compensation " + i);
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure compensation failed");
                e.printStackTrace();
                return -1;
            }
        }

        int doSetExposureMode(int i) {
            if (i == -1) {
                return 0;
            }
            VCam.access$708(VCam.this);
            try {
                if (i == 0 || i == 5 || i == 4) {
                    this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, false);
                } else if (i == 1) {
                    this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, true);
                }
                android.util.Log.i(VCam.TAG, "vcap: set exposure mode " + i);
                if (i == 4) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = Integer.valueOf(VCam.this.mExposureGeneration);
                    VCam.this.mHandler.sendMessageDelayed(obtain, 200L);
                }
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure mode failed");
                e.printStackTrace();
            }
            doSetExposureCompensation(VCam.this.mExposureCompensation);
            return 0;
        }

        int doSetExposurePoint(float f, float f2) {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics == null || ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue() == 0) {
                android.util.Log.i(VCam.TAG, "vcap: set exposure areas not supported");
                return -1;
            }
            Rect calculateArea2 = calculateArea2(f, f2);
            try {
                this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(calculateArea2, 800)});
                android.util.Log.i(VCam.TAG, "vcap: set exposure area " + calculateArea2.toString());
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure areas failed");
                e.printStackTrace();
                return -1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int doSetFocusMode(int r5) {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.Cam2Device.doSetFocusMode(int):int");
        }

        int doSetFocusPoint(float f, float f2) {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics == null || ((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() == 0) {
                android.util.Log.i(VCam.TAG, "vcap: set focus areas not supported");
                return -1;
            }
            Rect calculateArea2 = calculateArea2(f, f2);
            try {
                this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(calculateArea2, 800)});
                android.util.Log.i(VCam.TAG, "vcap: set focus area " + calculateArea2.toString());
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set focus areas failed");
                e.printStackTrace();
                return -1;
            }
        }

        int getFrontCam() {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            int i = 0;
            if (cameraCharacteristics != null) {
                i = 0;
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                    i = 1;
                }
            }
            return i;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int getMaxZoomRatio() {
            if (this.mCamDevice == null) {
                return 100;
            }
            return (int) (((Float) this.mCamCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() * 100.0f);
        }

        @Override // com.zego.ve.VCam.CameraDev
        int getOrientation() {
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics != null) {
                return ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int handleExposureMode(int i) {
            return doSetExposureMode(i);
        }

        @Override // com.zego.ve.VCam.CameraDev
        boolean isFocusSupported() {
            boolean z;
            CameraCharacteristics cameraCharacteristics = this.mCamCharacteristics;
            if (cameraCharacteristics == null) {
                return false;
            }
            int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    z = false;
                    break;
                }
                int i3 = iArr[i2];
                if (i3 == 1 || i3 == 3 || i3 == 4) {
                    break;
                }
                i = i2 + 1;
            }
            z = true;
            if (z) {
                boolean z2 = false;
                if (((Integer) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
                    z2 = true;
                }
                return z2;
            }
            return z;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int openTorch() {
            if (this.mCapRequestBuilder != null && ((Boolean) this.mCamCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue()) {
                boolean z = true;
                try {
                    this.mCapRequestBuilder.set(CaptureRequest.FLASH_MODE, 2);
                    this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set flash mode failed");
                    e.printStackTrace();
                    z = false;
                }
                if (z) {
                    return 0;
                }
                android.util.Log.i(VCam.TAG, "vcap: vcap: flash mode left unset");
                return 0;
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int releaseCam() {
            if (this.mCamDevice != null) {
                try {
                    if (this.mCamCapSession != null) {
                        this.mCamCapSession.close();
                    }
                    this.mCamDevice.close();
                    this.mCamDevice = null;
                    this.mCamCapSession = null;
                    this.mCapRequestBuilder = null;
                    this.mCamCharacteristics = null;
                    this.mSurfaceTexture = null;
                    if (this.mCam2Thread != null) {
                        this.mCam2Thread.quit();
                        this.mCam2Thread = null;
                    }
                    this.mCam2Handler = null;
                    this.mImageReader = null;
                    return 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setExposureCompensation(float f) {
            if (this.mCapRequestBuilder != null && doSetExposureCompensation(f) == 0) {
                try {
                    this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                    return 0;
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set exposure compensation -- set camera parameters error with exception");
                    e.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setExposureMode(int i) {
            if (this.mCapRequestBuilder != null && doSetExposureMode(VCam.this.mExposureMode) == 0) {
                try {
                    this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                    return 0;
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set exposure mode -- set camera parameters error with exception");
                    e.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setExposurePoint(float f, float f2) {
            if (this.mCapRequestBuilder == null || VCam.this.mUseFaceDetection) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure point -- skip");
                return -1;
            }
            doSetExposurePoint(f, f2);
            try {
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure point -- set camera parameters error with exception");
                e.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setFocusMode(int i) {
            CaptureRequest.Builder builder = this.mCapRequestBuilder;
            if (builder == null) {
                return -1;
            }
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            if (doSetFocusMode(VCam.this.mFocusMode) >= 0) {
                if (!VCam.this.mUseFaceDetection) {
                    doSetFocusPoint(VCam.this.mFocusPointX, VCam.this.mFocusPointY);
                }
            } else if (((Integer) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
                this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, null);
            }
            try {
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set focus mode -- set camera parameters error with exception");
                e.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setFocusPoint(float f, float f2) {
            if (this.mCapRequestBuilder == null || VCam.this.mUseFaceDetection || VCam.this.mIsFocusing) {
                return -1;
            }
            setFocusMode(VCam.this.mFocusMode);
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setImageReader(ImageReader imageReader) {
            this.mImageReader = imageReader;
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setRate(int i) {
            if (this.mCapRequestBuilder == null) {
                return 0;
            }
            updateRate(i);
            try {
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: update fps -- set camera parameters error with exception");
                e.printStackTrace();
                return 0;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setSurfaceTexture(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        void setZoomFactor(float f) {
            if (this.mCapRequestBuilder == null) {
                return;
            }
            Float f2 = (Float) this.mCamCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            float f3 = f;
            if (f > f2.floatValue()) {
                f3 = f2.floatValue();
            }
            float f4 = f3;
            if (f3 < 1.0f) {
                f4 = 1.0f;
            }
            Rect rect = (Rect) this.mCamCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            int width = rect.width() / 2;
            int height = rect.height() / 2;
            int width2 = (int) ((rect.width() * 0.5f) / f4);
            int height2 = (int) ((rect.height() * 0.5f) / f4);
            Rect rect2 = new Rect();
            rect2.set(width - width2, height - height2, width + width2, height + height2);
            try {
                this.mCapRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, rect2);
                this.mCamCapSession.setRepeatingRequest(this.mCapRequestBuilder.build(), null, null);
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set zoom failed");
                e.printStackTrace();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.zego.ve.VCam.CameraDev
        int startCam(boolean z) {
            int i;
            int i2;
            int i3;
            int i4;
            List asList;
            int i5;
            int i6;
            try {
            } catch (Exception e) {
                android.util.Log.i(VCam.TAG, "vcap: OpenSem failed");
            }
            if (this.mOpenSem.tryAcquire(1000L, TimeUnit.MILLISECONDS)) {
                CameraManager cameraManager = (CameraManager) VCam.this.mContext.getSystemService("camera");
                if (!this.mOpened) {
                    VCam.this.mCamera2Error = true;
                    android.util.Log.i(VCam.TAG, "vcap: Open Camera failed");
                    return -1;
                }
                VCam.this.mUseFaceDetection = (VCam.this.getFront() > 0) && z && ((Integer) this.mCamCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0;
                Size[] outputSizes = ((StreamConfigurationMap) this.mCamCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(35);
                if (outputSizes != null) {
                    int length = outputSizes.length;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        i6 = i9;
                        if (i7 >= length) {
                            break;
                        }
                        Size size = outputSizes[i7];
                        android.util.Log.i(VCam.TAG, "vcap: support size -- " + size.getWidth() + "x" + size.getHeight());
                        int i10 = i8;
                        int i11 = i6;
                        if (size.getWidth() * size.getHeight() > i8 * i6) {
                            if (size.getWidth() * 3 != size.getHeight() * 4) {
                                i10 = i8;
                                i11 = i6;
                                if (size.getWidth() * 9 != size.getHeight() * 16) {
                                }
                            }
                            i10 = size.getWidth();
                            i11 = size.getHeight();
                        }
                        i7++;
                        i8 = i10;
                        i9 = i11;
                    }
                    int length2 = outputSizes.length;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        int i15 = i14;
                        i = i8;
                        i2 = i6;
                        i3 = i13;
                        i4 = i15;
                        if (i12 >= length2) {
                            break;
                        }
                        Size size2 = outputSizes[i12];
                        int i16 = i13;
                        int i17 = i15;
                        if (size2.getWidth() % 16 == 0) {
                            if (size2.getHeight() % 16 != 0) {
                                i16 = i13;
                                i17 = i15;
                            } else if (size2.getWidth() < VCam.this.mWidth || size2.getHeight() < VCam.this.mHeight) {
                                if (size2.getWidth() < VCam.this.mWidth) {
                                    i16 = i13;
                                    i17 = i15;
                                    if (size2.getHeight() >= VCam.this.mHeight) {
                                        if (i13 >= VCam.this.mWidth && i15 >= VCam.this.mHeight) {
                                            i16 = i13;
                                            i17 = i15;
                                        } else if (i13 < VCam.this.mWidth && i15 < VCam.this.mHeight) {
                                            i16 = size2.getWidth();
                                            i17 = size2.getHeight();
                                        } else if (i15 < VCam.this.mHeight || size2.getWidth() <= i13) {
                                            i16 = i13;
                                            i17 = i15;
                                            if (size2.getWidth() * size2.getHeight() > i13 * i15) {
                                                i16 = size2.getWidth();
                                                i17 = size2.getHeight();
                                            }
                                        } else {
                                            i16 = size2.getWidth();
                                            i17 = size2.getHeight();
                                        }
                                    }
                                } else if (i13 >= VCam.this.mWidth && i15 >= VCam.this.mHeight) {
                                    i16 = i13;
                                    i17 = i15;
                                } else if (i13 < VCam.this.mWidth && i15 < VCam.this.mHeight) {
                                    i16 = size2.getWidth();
                                    i17 = size2.getHeight();
                                } else if (i13 < VCam.this.mWidth || size2.getHeight() <= i15) {
                                    i16 = i13;
                                    i17 = i15;
                                    if (size2.getWidth() * size2.getHeight() > i13 * i15) {
                                        i16 = size2.getWidth();
                                        i17 = size2.getHeight();
                                    }
                                } else {
                                    i16 = size2.getWidth();
                                    i17 = size2.getHeight();
                                }
                            } else if (i13 < VCam.this.mWidth || i15 < VCam.this.mHeight) {
                                i16 = size2.getWidth();
                                i17 = size2.getHeight();
                            } else {
                                i16 = i13;
                                i17 = i15;
                                if (size2.getWidth() * size2.getHeight() < i13 * i15) {
                                    i16 = size2.getWidth();
                                    i17 = size2.getHeight();
                                }
                            }
                        }
                        i12++;
                        i13 = i16;
                        i14 = i17;
                    }
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                if (i3 * i4 != 0) {
                    VCam.this.mWidth = i3;
                    VCam.this.mHeight = i4;
                } else if (i * i2 != 0) {
                    VCam.this.mWidth = i;
                    VCam.this.mHeight = i2;
                } else {
                    VCam.this.mWidth = 320;
                    VCam.this.mHeight = 240;
                }
                android.util.Log.i(VCam.TAG, "vcap: preview size -- , candidate:" + i3 + "x" + i4 + ", largest:" + i + "x" + i2 + ", preview:" + VCam.this.mWidth + "x" + VCam.this.mHeight);
                VCam.this.mIsFocusing = false;
                try {
                    CaptureRequest.Builder createCaptureRequest = this.mCamDevice.createCaptureRequest(1);
                    this.mCapRequestBuilder = createCaptureRequest;
                    createCaptureRequest.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    if (VCam.this.mUseFaceDetection) {
                        int[] iArr = (int[]) this.mCamCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES);
                        int length3 = iArr.length;
                        int i18 = 0;
                        int i19 = 0;
                        while (true) {
                            i5 = i19;
                            if (i18 >= length3) {
                                break;
                            }
                            int i20 = iArr[i18];
                            int i21 = i5;
                            if (i20 > i5) {
                                i21 = i20;
                            }
                            i18++;
                            i19 = i21;
                        }
                        if (i5 > 0) {
                            this.mCapRequestBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i5));
                        }
                    }
                    if (doSetFocusMode(VCam.this.mFocusMode) >= 0) {
                        if (!VCam.this.mUseFaceDetection) {
                            doSetFocusPoint(VCam.this.mFocusPointX, VCam.this.mFocusPointY);
                        }
                    } else if (((Integer) this.mCamCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0) {
                        this.mCapRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, null);
                    }
                    if (doSetExposureMode(VCam.this.mExposureMode) == 0 && !VCam.this.mUseFaceDetection) {
                        doSetExposurePoint(VCam.this.mExposurePointX, VCam.this.mExposurePointY);
                    }
                    try {
                        this.mSurfaceTexture.setDefaultBufferSize(VCam.this.mWidth, VCam.this.mHeight);
                        Surface surface = new Surface(this.mSurfaceTexture);
                        this.mCapRequestBuilder.addTarget(surface);
                        if (this.mImageReader != null) {
                            this.mCapRequestBuilder.addTarget(this.mImageReader.getSurface());
                            asList = Arrays.asList(surface, this.mImageReader.getSurface());
                        } else {
                            asList = Arrays.asList(surface);
                        }
                        if (VCam.this.mFPSMode != 0) {
                            updateRate(VCam.this.mFrameRate);
                        }
                        this.mCamDevice.createCaptureSession(asList, this.mSessionStateCallback, this.mCam2Handler);
                        return 0;
                    } catch (Exception e2) {
                        VCam.this.mCamera2Error = true;
                        android.util.Log.e(VCam.TAG, "vcap: createCaptureSession failed");
                        e2.printStackTrace();
                        return -1;
                    }
                } catch (Exception e3) {
                    VCam.this.mCamera2Error = true;
                    android.util.Log.i(VCam.TAG, "vcap: createCaptureRequest failed");
                    e3.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int stopCam() {
            if (this.mCamDevice != null) {
                try {
                    if (this.mCamCapSession != null) {
                        this.mCamCapSession.stopRepeating();
                        return 0;
                    }
                    return 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:107:0x0591  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x05f8  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x060d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int updateRate(int r6) {
            /*
                Method dump skipped, instructions count: 1640
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.Cam2Device.updateRate(int):int");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VCam$CamDevice.class */
    class CamDevice extends CameraDev implements Camera.PreviewCallback {
        private Camera mCam;
        private Camera.CameraInfo mCamInfo;
        private Camera.Parameters mParams;

        CamDevice() {
            super();
            this.mCam = null;
            this.mCamInfo = null;
            this.mParams = null;
        }

        private Rect calculateArea(float f, float f2) {
            float f3 = (VCam.this.mAreaSize / VCam.this.mWidth) * 2.0f;
            float f4 = (VCam.this.mAreaSize / VCam.this.mHeight) * 2.0f;
            float clamp2 = VCam.clamp2(f - (f3 / 2.0f), -1.0f, 1.0f - f3);
            float clamp22 = VCam.clamp2(f2 - (f4 / 2.0f), -1.0f, 1.0f - f4);
            return new Rect(VCam.clamp((int) (clamp2 * 1000.0f), -1000, 1000), VCam.clamp((int) (clamp22 * 1000.0f), -1000, 1000), VCam.clamp((int) ((clamp2 + f3) * 1000.0f), -1000, 1000), VCam.clamp((int) ((clamp22 + f4) * 1000.0f), -1000, 1000));
        }

        private void createPool() {
            VCam.this.queuedBuffers.clear();
            VCam vCam = VCam.this;
            vCam.mFrameSize = ((vCam.mWidth * VCam.this.mHeight) * 3) / 2;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 3) {
                    return;
                }
                byte[] array = ByteBuffer.allocateDirect(VCam.this.mFrameSize).array();
                VCam.this.queuedBuffers.add(array);
                this.mCam.addCallbackBuffer(array);
                i = i2 + 1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int closeTorch() {
            boolean z;
            if (this.mCam == null) {
                return -1;
            }
            String flashMode = this.mParams.getFlashMode();
            if (!this.mParams.getSupportedFlashModes().contains("off") || flashMode.equals("off")) {
                z = false;
            } else {
                z = true;
                try {
                    this.mParams.setFlashMode("off");
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set flash mode failed");
                    e.printStackTrace();
                }
            }
            if (!z) {
                android.util.Log.i(VCam.TAG, "vcap: flash mode left unset");
                return 0;
            }
            try {
                this.mCam.setParameters(this.mParams);
                return 0;
            } catch (Exception e2) {
                android.util.Log.e(VCam.TAG, "vcap: set flash mode -- set camera parameters error with exception");
                e2.printStackTrace();
                return 0;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        public int createCam(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            boolean z;
            int i6;
            int i7;
            if (this.mCam != null) {
                return 0;
            }
            this.mCamInfo = new Camera.CameraInfo();
            try {
                this.mCam = Camera.open(i);
                Camera.getCameraInfo(i, this.mCamInfo);
            } catch (RuntimeException e) {
                Log.e(VCam.TAG, "trace interruption open " + VCam.this.GetCameraString(i) + " failed, " + e);
                this.mCam = null;
            }
            VCam.this.mUseCameraId = i;
            if (this.mCam == null) {
                if (!VCam.this.mTryDefault) {
                    android.util.Log.e(VCam.TAG, "vcap: no camera found");
                    return -1;
                }
                android.util.Log.w(VCam.TAG, "vcap: no camera found, try default");
                try {
                    this.mCam = Camera.open();
                } catch (RuntimeException e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("trace interruption open ");
                    VCam vCam = VCam.this;
                    sb.append(vCam.GetCameraString(vCam.mBackCameraId));
                    sb.append(" failed, ");
                    sb.append(e2);
                    Log.e(VCam.TAG, sb.toString());
                    this.mCam = null;
                }
                if (this.mCam == null) {
                    android.util.Log.e(VCam.TAG, "vcap: no camera found");
                    return -1;
                }
                Camera.getCameraInfo(VCam.this.mBackCameraId, this.mCamInfo);
                VCam vCam2 = VCam.this;
                vCam2.mUseCameraId = vCam2.mBackCameraId;
            }
            Camera.Parameters parameters = this.mCam.getParameters();
            this.mParams = parameters;
            Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
            boolean z2 = VCam.this.mWidth >= 720 && VCam.this.mSceneMode != 0;
            List<Camera.Size> supportedVideoSizes = this.mParams.getSupportedVideoSizes();
            List<Camera.Size> list = supportedVideoSizes;
            if (supportedVideoSizes == null) {
                list = this.mParams.getSupportedPreviewSizes();
            }
            if (list != null) {
                int i8 = 0;
                int i9 = 0;
                for (Camera.Size size : list) {
                    android.util.Log.i(VCam.TAG, "vcap: support size -- " + size.width + "x" + size.height);
                    if (size.width * size.height > i8 * i9 && (size.width * 3 == size.height * 4 || size.width * 9 == size.height * 16)) {
                        i8 = size.width;
                        i9 = size.height;
                    }
                }
                Iterator<Camera.Size> it = list.iterator();
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    i2 = i10;
                    i3 = i12;
                    i4 = i8;
                    i5 = i9;
                    if (!it.hasNext()) {
                        break;
                    }
                    Camera.Size next = it.next();
                    int i13 = i10;
                    int i14 = i12;
                    if (next.width % 16 == 0) {
                        if (next.height % 16 != 0) {
                            i13 = i10;
                            i14 = i12;
                        } else if (z2 && next.width * preferredPreviewSizeForVideo.height != next.height * preferredPreviewSizeForVideo.width) {
                            i13 = i10;
                            i14 = i12;
                        } else if (next.width >= VCam.this.mWidth && next.height >= VCam.this.mHeight) {
                            if (i10 < VCam.this.mWidth || i12 < VCam.this.mHeight) {
                                i6 = next.width;
                                i7 = next.height;
                            } else {
                                i13 = i10;
                                i14 = i12;
                                if (next.width * next.height < i10 * i12) {
                                    i6 = next.width;
                                    i7 = next.height;
                                }
                            }
                            i13 = i6;
                            i14 = i7;
                        } else if (next.width < VCam.this.mWidth) {
                            i13 = i10;
                            i14 = i12;
                            if (next.height >= VCam.this.mHeight) {
                                if (i10 < VCam.this.mWidth || i12 < VCam.this.mHeight) {
                                    if (i10 < VCam.this.mWidth && i12 < VCam.this.mHeight) {
                                        i6 = next.width;
                                        i7 = next.height;
                                    } else if (i12 < VCam.this.mHeight || next.width <= i10) {
                                        i13 = i10;
                                        i14 = i12;
                                        if (next.width * next.height > i10 * i12) {
                                            i6 = next.width;
                                            i7 = next.height;
                                        }
                                    } else {
                                        i6 = next.width;
                                        i7 = next.height;
                                    }
                                    i13 = i6;
                                    i14 = i7;
                                } else {
                                    i13 = i10;
                                    i14 = i12;
                                }
                            }
                        } else if (i10 < VCam.this.mWidth || i12 < VCam.this.mHeight) {
                            if (i10 < VCam.this.mWidth && i12 < VCam.this.mHeight) {
                                i6 = next.width;
                                i7 = next.height;
                            } else if (i10 < VCam.this.mWidth || next.height <= i12) {
                                i13 = i10;
                                i14 = i12;
                                if (next.width * next.height > i10 * i12) {
                                    i6 = next.width;
                                    i7 = next.height;
                                }
                            } else {
                                i6 = next.width;
                                i7 = next.height;
                            }
                            i13 = i6;
                            i14 = i7;
                        } else {
                            i13 = i10;
                            i14 = i12;
                        }
                    }
                    i10 = i13;
                    i11 = i14;
                }
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i2 * i3 != 0) {
                this.mParams.setPreviewSize(i2, i3);
                VCam.this.mWidth = i2;
                VCam.this.mHeight = i3;
            } else if (i4 * i5 != 0) {
                this.mParams.setPreviewSize(i4, i5);
                VCam.this.mWidth = i4;
                VCam.this.mHeight = i5;
            } else {
                this.mParams.setPreviewSize(320, 240);
                VCam.this.mWidth = 320;
                VCam.this.mHeight = 240;
            }
            if ((Build.MANUFACTURER.equals("Xiaomi") && Build.MODEL.equals("MI 4LTE") && Build.VERSION.SDK_INT <= 19) || VCam.this.mNeedHack) {
                android.util.Log.i(VCam.TAG, "vcap: use prefer preview size");
                z = false;
            } else {
                z = true;
            }
            if (!z && preferredPreviewSizeForVideo != null) {
                this.mParams.setPreviewSize(preferredPreviewSizeForVideo.width, preferredPreviewSizeForVideo.height);
                VCam.this.mWidth = preferredPreviewSizeForVideo.width;
                VCam.this.mHeight = preferredPreviewSizeForVideo.height;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("vcap: preview size -- perferred:");
            sb2.append(preferredPreviewSizeForVideo == null ? 0 : preferredPreviewSizeForVideo.width);
            sb2.append("x");
            sb2.append(preferredPreviewSizeForVideo == null ? 0 : preferredPreviewSizeForVideo.height);
            sb2.append(", candidate:");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(i3);
            sb2.append(", preview:");
            sb2.append(VCam.this.mWidth);
            sb2.append("x");
            sb2.append(VCam.this.mHeight);
            android.util.Log.i(VCam.TAG, sb2.toString());
            if (VCam.this.mFPSMode != 0) {
                updateRate(VCam.this.mFrameRate, this.mParams);
            }
            this.mParams.setRecordingHint(z2);
            try {
                this.mCam.setParameters(this.mParams);
                Camera.Parameters parameters2 = this.mCam.getParameters();
                this.mParams = parameters2;
                VCam.this.mWidth = parameters2.getPreviewSize().width;
                VCam.this.mHeight = this.mParams.getPreviewSize().height;
                VCam vCam3 = VCam.this;
                vCam3.mAreaSize = vCam3.mWidth / 10;
                createPool();
                if (VCam.this.isSupportCamera2()) {
                    VCam.this.registerCameraAvailabilityCallback(i);
                    return 0;
                }
                return 0;
            } catch (Exception e3) {
                android.util.Log.e(VCam.TAG, "vcap: set camera parameters error with exception width:" + this.mParams.getPreviewSize().width + " height:" + this.mParams.getPreviewSize().height + ".");
                e3.printStackTrace();
                this.mCam.release();
                this.mCam = null;
                if (VCam.this.mNeedHack) {
                    return -1;
                }
                VCam.this.mNeedHack = true;
                return createCam(i);
            }
        }

        int doSetExposureCompensation(float f, Camera.Parameters parameters) {
            int minExposureCompensation = (int) ((f < 0.0f ? parameters.getMinExposureCompensation() * (-1) : parameters.getMaxExposureCompensation()) * f);
            try {
                parameters.setExposureCompensation(minExposureCompensation);
                android.util.Log.i(VCam.TAG, "vcap: set exposure compensation " + minExposureCompensation);
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure compensation failed");
                e.printStackTrace();
                return -1;
            }
        }

        int doSetExposureMode(int i, Camera.Parameters parameters) {
            if (i == -1) {
                return 0;
            }
            if (!parameters.isAutoExposureLockSupported()) {
                android.util.Log.e(VCam.TAG, "vcap: auto exposure lock not supported");
                return -1;
            }
            VCam.access$708(VCam.this);
            try {
                if (i == 0 || i == 5 || i == 4) {
                    parameters.setAutoExposureLock(false);
                } else if (i == 1) {
                    parameters.setAutoExposureLock(true);
                }
                android.util.Log.e(VCam.TAG, "vcap: set exposure mode " + i);
                if (i == 4) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = Integer.valueOf(VCam.this.mExposureGeneration);
                    VCam.this.mHandler.sendMessageDelayed(obtain, 200L);
                }
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure mode failed");
                e.printStackTrace();
            }
            doSetExposureCompensation(VCam.this.mExposureCompensation, parameters);
            return 0;
        }

        int doSetExposurePoint(float f, float f2, Camera.Parameters parameters) {
            if (parameters.getMaxNumMeteringAreas() == 0) {
                android.util.Log.i(VCam.TAG, "vcap: set exposure areas not supported");
                return -1;
            }
            Rect calculateArea = calculateArea(f, f2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateArea, 800));
            try {
                parameters.setMeteringAreas(arrayList);
                android.util.Log.i(VCam.TAG, "vcap: set exposure area " + calculateArea.toString());
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure areas failed");
                e.printStackTrace();
                return -1;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0118  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int doSetFocusMode(int r4, android.hardware.Camera.Parameters r5) {
            /*
                Method dump skipped, instructions count: 305
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.CamDevice.doSetFocusMode(int, android.hardware.Camera$Parameters):int");
        }

        int doSetFocusPoint(float f, float f2, Camera.Parameters parameters) {
            if (parameters.getMaxNumFocusAreas() == 0) {
                android.util.Log.i(VCam.TAG, "vcap: set focus areas not supported");
                return -1;
            }
            Rect calculateArea = calculateArea(f, f2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateArea, 800));
            try {
                parameters.setFocusAreas(arrayList);
                android.util.Log.i(VCam.TAG, "vcap: set focus area " + calculateArea.toString());
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set focus areas failed");
                e.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int getMaxZoomRatio() {
            if (this.mCam != null && this.mParams.isZoomSupported()) {
                List<Integer> zoomRatios = this.mParams.getZoomRatios();
                if (zoomRatios.size() == 0) {
                    return 100;
                }
                return zoomRatios.get(this.mParams.getMaxZoom()).intValue();
            }
            return 100;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int getOrientation() {
            Camera.CameraInfo cameraInfo = this.mCamInfo;
            if (cameraInfo != null) {
                return cameraInfo.orientation;
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int handleExposureMode(int i) {
            return doSetExposureMode(VCam.this.mExposureMode, this.mParams);
        }

        @Override // com.zego.ve.VCam.CameraDev
        boolean isFocusSupported() {
            Camera.Parameters parameters = this.mParams;
            if (parameters == null) {
                return false;
            }
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            boolean z = supportedFocusModes != null && (supportedFocusModes.contains("auto") || supportedFocusModes.contains("continuous-video") || supportedFocusModes.contains("continuous-picture"));
            if (z) {
                boolean z2 = false;
                if (this.mParams.getMaxNumFocusAreas() > 0) {
                    z2 = true;
                }
                return z2;
            }
            return z;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (VCam.this.queuedBuffers.contains(bArr)) {
                VCam.onBufferAvailable(VCam.this.mThis, bArr, VCam.this.mFrameRate);
                camera.addCallbackBuffer(bArr);
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int openTorch() {
            boolean z;
            if (this.mCam == null) {
                return -1;
            }
            String flashMode = this.mParams.getFlashMode();
            if (!this.mParams.getSupportedFlashModes().contains("torch") || flashMode.equals("torch")) {
                z = false;
            } else {
                z = true;
                try {
                    this.mParams.setFlashMode("torch");
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set flash mode failed");
                    e.printStackTrace();
                }
            }
            if (!z) {
                android.util.Log.i(VCam.TAG, "vcap: vcap: flash mode left unset");
                return 0;
            }
            try {
                this.mCam.setParameters(this.mParams);
                return 0;
            } catch (Exception e2) {
                android.util.Log.e(VCam.TAG, "vcap: set flash mode -- set camera parameters error with exception");
                e2.printStackTrace();
                return 0;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int releaseCam() {
            Camera camera = this.mCam;
            if (camera != null) {
                camera.release();
                this.mCam = null;
            }
            this.mCamInfo = null;
            this.mParams = null;
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setExposureCompensation(float f) {
            if (this.mCam != null && doSetExposureCompensation(f, this.mParams) == 0) {
                try {
                    this.mCam.setParameters(this.mParams);
                    return 0;
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set exposure compensation -- set camera parameters error with exception");
                    e.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setExposureMode(int i) {
            if (this.mCam != null && doSetExposureMode(VCam.this.mExposureMode, this.mParams) == 0) {
                try {
                    this.mCam.setParameters(this.mParams);
                    return 0;
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set exposure mode -- set camera parameters error with exception");
                    e.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setExposurePoint(float f, float f2) {
            if (this.mCam == null || VCam.this.mUseFaceDetection) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure point -- skip");
                return -1;
            }
            doSetExposurePoint(f, f2, this.mParams);
            try {
                this.mCam.setParameters(this.mParams);
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set exposure point -- set camera parameters error with exception");
                e.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setFocusMode(int i) {
            Camera camera = this.mCam;
            if (camera == null) {
                return -1;
            }
            camera.cancelAutoFocus();
            int doSetFocusMode = doSetFocusMode(VCam.this.mFocusMode, this.mParams);
            if (doSetFocusMode >= 0) {
                if (!VCam.this.mUseFaceDetection) {
                    doSetFocusPoint(VCam.this.mFocusPointX, VCam.this.mFocusPointY, this.mParams);
                }
            } else if (this.mParams.getMaxNumFocusAreas() > 0) {
                this.mParams.setFocusAreas(null);
            }
            try {
                this.mCam.setParameters(this.mParams);
                if (doSetFocusMode > 0) {
                    VCam.this.mIsFocusing = true;
                    this.mCam.autoFocus(new Camera.AutoFocusCallback() { // from class: com.zego.ve.VCam.CamDevice.3
                        @Override // android.hardware.Camera.AutoFocusCallback
                        public void onAutoFocus(boolean z, Camera camera2) {
                            android.util.Log.e(VCam.TAG, "vcap: set focus success:" + z);
                            VCam.this.mIsFocusing = false;
                        }
                    });
                    return 0;
                }
                return 0;
            } catch (Exception e) {
                android.util.Log.e(VCam.TAG, "vcap: set focus mode -- set camera parameters error with exception");
                e.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setFocusPoint(float f, float f2) {
            if (this.mCam == null || VCam.this.mUseFaceDetection || VCam.this.mIsFocusing) {
                return -1;
            }
            setFocusMode(VCam.this.mFocusMode);
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setImageReader(ImageReader imageReader) {
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setRate(int i) {
            if (this.mCam != null) {
                updateRate(i, this.mParams);
                try {
                    this.mCam.setParameters(this.mParams);
                    return 0;
                } catch (Exception e) {
                    android.util.Log.i(VCam.TAG, "vcap: update fps -- set camera parameters error with exception");
                    e.printStackTrace();
                    return 0;
                }
            }
            return 0;
        }

        @Override // com.zego.ve.VCam.CameraDev
        int setSurfaceTexture(SurfaceTexture surfaceTexture) {
            Camera camera = this.mCam;
            if (camera == null) {
                return -1;
            }
            try {
                camera.setPreviewTexture(surfaceTexture);
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        @Override // com.zego.ve.VCam.CameraDev
        void setZoomFactor(float f) {
            if (this.mCam != null && this.mParams.isZoomSupported()) {
                List<Integer> zoomRatios = this.mParams.getZoomRatios();
                if (zoomRatios.size() == 0) {
                    return;
                }
                int i = (int) (f * 100.0f);
                int i2 = 0;
                if (i != 100) {
                    int i3 = 1;
                    while (true) {
                        int i4 = i3;
                        i2 = 0;
                        if (i4 >= zoomRatios.size()) {
                            break;
                        } else if (zoomRatios.get(i4).intValue() >= i) {
                            i2 = i4;
                            break;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                }
                this.mParams.setZoom(i2);
                try {
                    this.mCam.setParameters(this.mParams);
                } catch (Exception e) {
                    android.util.Log.e(VCam.TAG, "vcap: set zoom failed");
                    e.printStackTrace();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
            if (r0.contains(android.hardware.Camera.Parameters.SCENE_MODE_NIGHT) != false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
            if (r0.contains(android.hardware.Camera.Parameters.SCENE_MODE_NIGHT) != false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
            r9 = android.hardware.Camera.Parameters.SCENE_MODE_NIGHT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00fc, code lost:
            if (r0.contains(android.hardware.Camera.Parameters.SCENE_MODE_SPORTS) != false) goto L20;
         */
        @Override // com.zego.ve.VCam.CameraDev
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int startCam(boolean r6) {
            /*
                Method dump skipped, instructions count: 655
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.VCam.CamDevice.startCam(boolean):int");
        }

        @Override // com.zego.ve.VCam.CameraDev
        int stopCam() {
            VCam.access$708(VCam.this);
            if (this.mCam != null) {
                if (VCam.this.mUseFaceDetection) {
                    this.mCam.stopFaceDetection();
                }
                try {
                    this.mCam.setPreviewCallbackWithBuffer(null);
                    this.mCam.setPreviewTexture(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Thread(new Runnable() { // from class: com.zego.ve.VCam.CamDevice.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Log.i(VCam.TAG, "vcap: stopPreview on release thread");
                            CamDevice.this.mCam.stopPreview();
                            Log.i(VCam.TAG, "vcap: stopPreview on release thread done");
                        } catch (Exception e2) {
                            Log.i(VCam.TAG, "vcap: stopPreview failed");
                        }
                        countDownLatch.countDown();
                    }
                }).start();
                if (ThreadUtils.awaitUninterruptibly(countDownLatch, 500L)) {
                    return 0;
                }
                Log.i(VCam.TAG, "vcap: stopPreview release timeout");
                return -1;
            }
            return 0;
        }

        int updateRate(int i, Camera.Parameters parameters) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange != null) {
                if (VCam.this.mFpsMin != -1000 && VCam.this.mFpsMax != -1000) {
                    Iterator<int[]> it = supportedPreviewFpsRange.iterator();
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    while (true) {
                        int i18 = i17;
                        i2 = i12;
                        i3 = i13;
                        i4 = i14;
                        i5 = i15;
                        if (!it.hasNext()) {
                            break;
                        }
                        int[] next = it.next();
                        Log.i(VCam.TAG, "cam fps:|" + (next[0] / 1000) + "|" + (next[1] / 1000) + "|");
                        int abs = Math.abs(next[0] - VCam.this.mFpsMin);
                        if (next[1] >= VCam.this.mFpsMax) {
                            if (i12 != 0 && next[1] >= i12 && (next[1] != i12 || abs >= i18)) {
                                if (next[1] == i12 && abs == i18) {
                                    i11 = i12;
                                    i7 = i13;
                                    i10 = i14;
                                    i6 = i15;
                                    i9 = i16;
                                    i8 = i18;
                                    if (next[0] <= i14) {
                                    }
                                }
                                i11 = i12;
                                i7 = i13;
                                i10 = i14;
                                i6 = i15;
                                i9 = i16;
                                i8 = i18;
                            }
                            i10 = next[0];
                            i11 = next[1];
                            i7 = i13;
                            i6 = i15;
                            i9 = i16;
                            i8 = abs;
                        } else {
                            if (i13 != 0 && next[1] <= i13 && (next[1] != i13 || abs >= i16)) {
                                if (next[1] == i13 && abs == i16) {
                                    i11 = i12;
                                    i7 = i13;
                                    i10 = i14;
                                    i6 = i15;
                                    i9 = i16;
                                    i8 = i18;
                                    if (next[0] <= i15) {
                                    }
                                }
                                i11 = i12;
                                i7 = i13;
                                i10 = i14;
                                i6 = i15;
                                i9 = i16;
                                i8 = i18;
                            }
                            i6 = next[0];
                            i7 = next[1];
                            i8 = i18;
                            i9 = abs;
                            i10 = i14;
                            i11 = i12;
                        }
                        i12 = i11;
                        i13 = i7;
                        i14 = i10;
                        i15 = i6;
                        i16 = i9;
                        i17 = i8;
                    }
                } else {
                    int i19 = VCam.this.mFrameRate * 1000;
                    if (!VCam.this.mLowLightBoost) {
                        Iterator<int[]> it2 = supportedPreviewFpsRange.iterator();
                        int i20 = 0;
                        int i21 = 0;
                        int i22 = 0;
                        int i23 = 0;
                        while (true) {
                            i2 = i20;
                            i3 = i21;
                            i4 = i22;
                            i5 = i23;
                            if (!it2.hasNext()) {
                                break;
                            }
                            int[] next2 = it2.next();
                            if (next2[1] >= i19) {
                                if (i20 == 0 || next2[1] < i20 || (next2[1] == i20 && next2[0] > i22)) {
                                    i22 = next2[0];
                                    i20 = next2[1];
                                }
                            } else if (i21 == 0 || next2[1] > i21 || (next2[1] == i21 && next2[0] > i23)) {
                                i23 = next2[0];
                                i21 = next2[1];
                            }
                        }
                    } else {
                        Iterator<int[]> it3 = supportedPreviewFpsRange.iterator();
                        int i24 = 0;
                        int i25 = 0;
                        int i26 = 0;
                        int i27 = 0;
                        while (true) {
                            i2 = i24;
                            i3 = i25;
                            i4 = i26;
                            i5 = i27;
                            if (!it3.hasNext()) {
                                break;
                            }
                            int[] next3 = it3.next();
                            if (next3[1] >= i19) {
                                if (i24 == 0 || next3[1] < i24 || (next3[1] == i24 && next3[0] < i26)) {
                                    i26 = next3[0];
                                    i24 = next3[1];
                                }
                            } else if (i25 == 0 || next3[1] > i25 || (next3[1] == i25 && next3[0] < i27)) {
                                i27 = next3[0];
                                i25 = next3[1];
                            }
                        }
                    }
                }
                if (i2 != 0) {
                    parameters.setPreviewFpsRange(i4, i2);
                } else if (i3 != 0) {
                    parameters.setPreviewFpsRange(i5, i3);
                }
            }
            int[] iArr = new int[2];
            parameters.getPreviewFpsRange(iArr);
            if (iArr[0] == iArr[1]) {
                VCam.this.mFrameRate = iArr[0] / 1000;
            } else {
                VCam.this.mFrameRate = (iArr[1] / 2) / 1000;
            }
            Log.i(VCam.TAG, "real fps:|" + (iArr[0] / 1000) + "|" + (iArr[1] / 1000) + "|");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/VCam$CameraDev.class */
    public abstract class CameraDev {
        CameraDev() {
        }

        abstract int closeTorch();

        abstract int createCam(int i);

        abstract int getMaxZoomRatio();

        abstract int getOrientation();

        abstract int handleExposureMode(int i);

        abstract boolean isFocusSupported();

        abstract int openTorch();

        abstract int releaseCam();

        abstract int setExposureCompensation(float f);

        abstract int setExposureMode(int i);

        abstract int setExposurePoint(float f, float f2);

        abstract int setFocusMode(int i);

        abstract int setFocusPoint(float f, float f2);

        abstract int setImageReader(ImageReader imageReader);

        abstract int setRate(int i);

        abstract int setSurfaceTexture(SurfaceTexture surfaceTexture);

        abstract void setZoomFactor(float f);

        abstract int startCam(boolean z);

        abstract int stopCam();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String GetCameraString(int i) {
        return i == this.mFrontCameraId ? "front camera" : "back camera";
    }

    static /* synthetic */ int access$708(VCam vCam) {
        int i = vCam.mExposureGeneration;
        vCam.mExposureGeneration = i + 1;
        return i;
    }

    static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    static float clamp2(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNumericString(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return true;
            }
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSupportCamera2() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onBufferAvailable(long j, byte[] bArr, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onCameraAvailable(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onCameraUnavailable(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public void registerCameraAvailabilityCallback(int i) {
        Context context = this.mContext;
        if (context != null) {
            try {
                CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
                CameraAvailabilityCallback cameraAvailabilityCallback = new CameraAvailabilityCallback(this.mThis, i, new CameraAvailabilityCallback.Listener() { // from class: com.zego.ve.VCam.1
                    @Override // com.zego.ve.CameraAvailabilityCallback.Listener
                    public void onCameraAvailable(long j, String str) {
                        Log.i(VCam.TAG, "trace interruption this: " + VCam.this + ", cameraId: " + str + " available, mUseCameraId: " + VCam.this.mUseCameraId);
                        if (VCam.this.isNumericString(str)) {
                            VCam.onCameraAvailable(j, Integer.parseInt(str));
                        } else {
                            VCam.onCameraAvailable(j, -1);
                        }
                    }

                    @Override // com.zego.ve.CameraAvailabilityCallback.Listener
                    public void onCameraUnavailable(long j, String str) {
                        Log.i(VCam.TAG, "trace interruption this: " + VCam.this + ", cameraId: " + str + " unavailable, mUseCameraId: " + VCam.this.mUseCameraId);
                        if (VCam.this.isNumericString(str)) {
                            VCam.onCameraUnavailable(j, Integer.parseInt(str));
                        } else {
                            VCam.onCameraUnavailable(j, -1);
                        }
                    }
                });
                this.mCameraAvailabilityCallback = cameraAvailabilityCallback;
                cameraManager.registerAvailabilityCallback(cameraAvailabilityCallback, null);
            } catch (Throwable th) {
                Log.e(TAG, "registerCameraAvailabilityCallback failed, " + th);
            }
        }
    }

    private void unregisterCameraAvailabilityCallback() {
        if (this.mContext != null) {
            try {
                if (this.mCameraAvailabilityCallback != null) {
                    this.mCameraAvailabilityCallback.uninit();
                    ((CameraManager) this.mContext.getSystemService("camera")).unregisterAvailabilityCallback(this.mCameraAvailabilityCallback);
                    this.mCameraAvailabilityCallback = null;
                }
            } catch (Throwable th) {
                Log.e(TAG, "unregisterCameraAvailabilityCallback failed, " + th);
            }
        }
    }

    boolean checkPermission() {
        return PermissionChecker.checkSelfPermission(this.mContext, Manifest.permission.CAMERA);
    }

    int closeTorch() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.closeTorch();
        }
        return 0;
    }

    int createCam(int i, int i2, boolean z, boolean z2) {
        if (i == -1) {
            android.util.Log.e(TAG, "vcap: invalid camera id");
            return -1;
        }
        this.mSceneMode = i2;
        this.mLowLightBoost = z;
        int i3 = 0;
        if (z2 && isSupportCamera2() && !this.mCamera2Error) {
            this.mCamDevice = new Cam2Device();
            i3 = 1;
        } else {
            this.mCamDevice = new CamDevice();
        }
        Log.i(TAG, "create cameraid:" + i + " camera2:" + i3);
        android.util.Log.i(TAG, "vcap -- board: " + Build.BOARD + " device: " + Build.DEVICE + " manufacturer: " + Build.MANUFACTURER + " brand: " + Build.BRAND + " model: " + Build.MODEL + " product: " + Build.PRODUCT + " sdk: " + Build.VERSION.SDK_INT + " cameraid:" + i + " camera2:" + i3);
        return this.mCamDevice.createCam(i);
    }

    void enumerateCamera(boolean z) {
        boolean z2;
        if (z && isSupportCamera2() && !this.mCamera2Error) {
            enumerateCamera2();
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || this.mCamera2Error) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int numberOfCameras = Camera.getNumberOfCameras();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= numberOfCameras) {
                    break;
                }
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 0 && this.mBackCameraId == -1) {
                    this.mBackCameraId = i2;
                }
                if (cameraInfo.facing == 1 && this.mFrontCameraId == -1) {
                    this.mFrontCameraId = i2;
                }
                i = i2 + 1;
            }
        }
        Log.i(TAG, "trace interruption enumerateCamera this: " + this + ", mFrontCameraId: " + this.mFrontCameraId + ", mBackCameraId: " + this.mBackCameraId);
    }

    void enumerateCamera2() {
        String[] cameraIdList;
        int i;
        int i2;
        this.mCameraIDList = new String[2];
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            int i3 = 0;
            for (String str : cameraManager.getCameraIdList()) {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                int i4 = i3;
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                    i4 = i3;
                    if (this.mFrontCameraId == -1) {
                        this.mFrontCameraId = i3;
                        this.mCameraIDList[i3] = str;
                        i4 = i3 + 1;
                    }
                }
                i3 = i4;
                if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                    i3 = i4;
                    if (this.mBackCameraId == -1) {
                        this.mBackCameraId = i4;
                        this.mCameraIDList[i4] = str;
                        i3 = i4 + 1;
                    }
                }
            }
            if ((this.mFrontCameraId == -1 || this.mBackCameraId == -1) && this.mContext.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_EXTERNAL)) {
                String[] cameraIdList2 = cameraManager.getCameraIdList();
                int length = cameraIdList2.length;
                int i5 = 0;
                while (i5 < length) {
                    String str2 = cameraIdList2[i5];
                    CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(str2);
                    if (((Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING)).intValue() == 2 && this.mFrontCameraId == -1) {
                        int i6 = i3 + 1;
                        this.mFrontCameraId = i3;
                        this.mCameraIDList[i3] = str2;
                        Log.i(TAG, "cam external front:" + str2);
                        i2 = i6;
                    } else {
                        i = i3;
                        if (((Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING)).intValue() == 2) {
                            i = i3;
                            if (this.mBackCameraId == -1) {
                                int i7 = i3 + 1;
                                this.mBackCameraId = i3;
                                this.mCameraIDList[i3] = str2;
                                Log.i(TAG, "cam external back" + str2);
                                i2 = i7;
                            }
                        }
                        i5++;
                        i3 = i;
                    }
                    i = i2;
                    i5++;
                    i3 = i;
                }
            }
        } catch (Exception e) {
            android.util.Log.e(TAG, "vcap: enumerate camera2 failed");
            this.mCamera2Error = true;
            e.printStackTrace();
        }
    }

    int getBackCameraId() {
        return this.mBackCameraId;
    }

    int getFramerate() {
        return this.mFrameRate;
    }

    int getFront() {
        int i = 0;
        if (this.mCamDevice != null) {
            i = 0;
            if (this.mUseCameraId == this.mFrontCameraId) {
                i = 1;
            }
        }
        return i;
    }

    int getFrontCameraId() {
        return this.mFrontCameraId;
    }

    int getHeight() {
        return this.mHeight;
    }

    int getMaxZoomRatio() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.getMaxZoomRatio();
        }
        return 100;
    }

    int getOrientation() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.getOrientation();
        }
        return 0;
    }

    int getWidth() {
        return this.mWidth;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0 && ((Integer) message.obj).intValue() == this.mExposureGeneration) {
            this.mCamDevice.handleExposureMode(1);
            return true;
        }
        return true;
    }

    void init() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.myLooper(), this);
        }
    }

    boolean isFocusSupported() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.isFocusSupported();
        }
        return false;
    }

    boolean isSamsung() {
        return "samsung".equals(Build.MANUFACTURER.toLowerCase());
    }

    int openTorch() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.openTorch();
        }
        return 0;
    }

    int releaseCam() {
        if (isSupportCamera2()) {
            unregisterCameraAvailabilityCallback();
        }
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            cameraDev.releaseCam();
            this.mCamDevice = null;
        }
        this.mUseCameraId = -1;
        return 0;
    }

    public int setContext(long j, Context context, boolean z) {
        this.mThis = j;
        this.mContext = context;
        this.mTryDefault = z;
        return 0;
    }

    int setExposureCompensation(float f) {
        this.mExposureCompensation = f;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setExposureCompensation(f);
        }
        return 0;
    }

    int setExposureMode(int i) {
        this.mExposureMode = i == -1 ? 0 : i;
        CameraDev cameraDev = this.mCamDevice;
        int i2 = 0;
        if (cameraDev != null) {
            i2 = cameraDev.setExposureMode(i);
        }
        return i2;
    }

    int setExposurePoint(float f, float f2) {
        this.mExposurePointX = f;
        this.mExposurePointY = f2;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setExposurePoint(f, f2);
        }
        return 0;
    }

    int setFPSRange(int i, int i2) {
        this.mFpsMin = i * 1000;
        this.mFpsMax = i2 * 1000;
        return 0;
    }

    int setFocusMode(int i) {
        this.mFocusMode = i;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setFocusMode(i);
        }
        return 0;
    }

    int setFocusPoint(float f, float f2) {
        this.mFocusPointX = f;
        this.mFocusPointY = f2;
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setFocusPoint(f, f2);
        }
        return 0;
    }

    int setImageReader(ImageReader imageReader) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setImageReader(imageReader);
        }
        return 0;
    }

    int setRate(int i, int i2) {
        this.mFPSMode = i2;
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            i = 30;
        }
        this.mFrameRate = i;
        CameraDev cameraDev = this.mCamDevice;
        int i3 = 0;
        if (cameraDev != null) {
            i3 = cameraDev.setRate(i);
        }
        return i3;
    }

    int setSize(int i, int i2) {
        if (i < i2) {
            this.mWidth = i2;
            this.mHeight = i;
        } else {
            this.mWidth = i;
            this.mHeight = i2;
        }
        this.mNeedHack = false;
        return 0;
    }

    int setSurfaceTexture(SurfaceTexture surfaceTexture) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.setSurfaceTexture(surfaceTexture);
        }
        return 0;
    }

    void setZoomFactor(float f) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            cameraDev.setZoomFactor(f);
        }
    }

    int startCam(boolean z) {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.startCam(z);
        }
        return 0;
    }

    int stopCam() {
        CameraDev cameraDev = this.mCamDevice;
        if (cameraDev != null) {
            return cameraDev.stopCam();
        }
        return 0;
    }

    void uninit() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(this);
            this.mHandler = null;
        }
    }
}
