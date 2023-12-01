package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES11Ext;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.l;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.af;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/CameraCaptureSingleton.class */
public class CameraCaptureSingleton implements SurfaceTexture.OnFrameAvailableListener, CaptureSourceInterface, ae {
    private static final int DELAY_FOR_RESTART_CAMERA = 2000;
    private static final int DELAY_FOR_SWITCH_TO_CAMERA1 = 1000;
    private static final int HOLD_POOL_MAX_SIZE = 1;
    private static final String TAG = "CameraCaptureSingleton";
    private static final boolean USE_DEFAULT_FRONT_CAMERA = true;
    private static volatile CameraCaptureSingleton sInstance;
    private ad mCameraController;
    protected com.tencent.liteav.videobase.b.e mEGLCore;
    protected com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private PixelFrame mPixelFrame;
    private Object mSharedContext;
    private SurfaceTexture mSurfaceTexture;
    private com.tencent.liteav.videobase.frame.l mTextureHolderPool;
    private final float[] mMatrix = new float[16];
    private boolean mNeedNotifyStartFinish = true;
    private final aq mListenerManager = new aq();
    private final af mCameraSupervisor = new af();
    protected int mPausedCount = 0;
    protected CameraCaptureParams mCurrentCaptureParams = null;
    private final AtomicBoolean mExpectFrontCamera = new AtomicBoolean();
    private int mOESTextureId = -1;
    private boolean mEnableTapToFocus = false;
    private boolean mEnableZoom = false;
    private float mZoomPercent = 0.0f;
    private float mExposureCompensation = 0.0f;
    private volatile Rotation mCameraRotation = Rotation.NORMAL;
    private boolean mIsFirstFrameCaptured = false;
    private boolean mIsZoomSupported = false;
    private boolean mIsTorchSupported = false;
    private boolean mIsFocusPositionInPreviewSupported = false;
    private boolean mIsCameraAutoFocusFaceModeSupported = false;
    private int mMaxZoomLevel = 0;
    private boolean mIsCameraInRestarting = false;
    private boolean mIsCameraInSwitching = false;
    private ServerVideoProducerConfig mServerConfig = null;
    private final Runnable mRestartCameraRunnable = new Runnable() { // from class: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.1
        /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r5 = this;
                java.lang.String r0 = "CameraCaptureSingleton"
                java.lang.String r1 = "restart camera runnable."
                com.tencent.liteav.base.util.LiteavLog.i(r0, r1)
                r0 = r5
                com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.this
                r1 = 1
                boolean r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.access$002(r0, r1)
                int r0 = com.tencent.liteav.base.system.LiteavSystemInfo.getAppBackgroundState()
                r1 = 1
                if (r0 != r1) goto L21
                java.lang.String r0 = "CameraCaptureSingleton"
                java.lang.String r1 = "not in Foreground"
                com.tencent.liteav.base.util.LiteavLog.i(r0, r1)
                goto L46
            L21:
                r0 = r5
                com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.this
                com.tencent.liteav.videoproducer.capture.ad r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.access$100(r0)
                if (r0 != 0) goto L46
                r0 = r5
                com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.this
                com.tencent.liteav.videoproducer.capture.CameraCaptureParams r0 = r0.mCurrentCaptureParams
                if (r0 == 0) goto L46
                r0 = r5
                com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.this
                r7 = r0
                r0 = r7
                r1 = r7
                com.tencent.liteav.videoproducer.capture.CameraCaptureParams r1 = r1.mCurrentCaptureParams
                boolean r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.access$200(r0, r1)
                r6 = r0
                goto L48
            L46:
                r0 = 0
                r6 = r0
            L48:
                r0 = r6
                if (r0 != 0) goto L60
                r0 = r5
                com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.this
                com.tencent.liteav.base.util.j r0 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.access$400(r0)
                r1 = r5
                com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton r1 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.this
                java.lang.Runnable r1 = com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.access$300(r1)
                r2 = 2000(0x7d0, double:9.88E-321)
                r0.a(r1, r2)
            L60:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.AnonymousClass1.run():void");
        }
    };
    private final Runnable mSwitchToCamera1Runnable = new Runnable() { // from class: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.2
        @Override // java.lang.Runnable
        public final void run() {
            boolean openCamera;
            LiteavLog.i(CameraCaptureSingleton.TAG, "switch to camera1 runnable.");
            CameraCaptureSingleton.this.mIsCameraInSwitching = true;
            if (LiteavSystemInfo.getAppBackgroundState() == 1) {
                LiteavLog.i(CameraCaptureSingleton.TAG, "not in Foreground");
                openCamera = false;
            } else {
                CameraCaptureSingleton cameraCaptureSingleton = CameraCaptureSingleton.this;
                openCamera = cameraCaptureSingleton.openCamera(cameraCaptureSingleton.mCurrentCaptureParams);
            }
            if (openCamera) {
                return;
            }
            CameraCaptureSingleton.this.mSequenceTaskRunner.a(CameraCaptureSingleton.this.mSwitchToCamera1Runnable, 1000L);
        }
    };
    private final com.tencent.liteav.base.util.j mSequenceTaskRunner = new com.tencent.liteav.base.util.j();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton$3  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/CameraCaptureSingleton$3.class */
    public static final /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23154a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[af.a.values().length];
            f23154a = iArr;
            try {
                iArr[af.a.MOCK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23154a[af.a.CAMERA_2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23154a[af.a.CAMERA_1.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private CameraCaptureSingleton(Context context) {
        this.mExpectFrontCamera.set(true);
    }

    private void checkFirstFrameCaptured() {
        if (this.mIsFirstFrameCaptured) {
            return;
        }
        this.mIsFirstFrameCaptured = true;
        LiteavLog.d(TAG, "camera capture first frame.");
    }

    private void closeCamera() {
        LiteavLog.i(TAG, "closeCamera");
        try {
            try {
                if (this.mCameraController != null) {
                    this.mCameraController.a();
                }
            } catch (Exception e) {
                LiteavLog.e(TAG, "closeCamera fail, Exception:".concat(String.valueOf(e)));
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            OpenGlUtils.deleteTexture(this.mOESTextureId);
            this.mOESTextureId = -1;
            this.mPixelFrame = null;
            this.mIsFirstFrameCaptured = false;
        } finally {
            this.mCameraRotation = Rotation.NORMAL;
            this.mCameraController = null;
            this.mMaxZoomLevel = 0;
        }
    }

    private ad createCameraController(af.a aVar) {
        com.tencent.liteav.videoproducer.capture.a.a aVar2;
        int i = AnonymousClass3.f23154a[aVar.ordinal()];
        if (i != 1) {
            aVar2 = i != 2 ? new com.tencent.liteav.videoproducer.capture.a.a() : new com.tencent.liteav.videoproducer.capture.b.a(this.mSequenceTaskRunner);
        } else {
            Object obj = null;
            try {
                obj = Class.forName("com.tencent.liteav.videoengine.demo.mock.camera.MockCameraController").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            aVar2 = (ad) obj;
        }
        if (aVar2 != null) {
            aVar2.a(this.mServerConfig);
        }
        LiteavLog.i(TAG, "createCameraController, CameraAPIType:" + aVar + ", return camera controller: " + aVar2);
        return aVar2;
    }

    public static CameraCaptureSingleton getInstance() {
        if (sInstance == null) {
            synchronized (CameraCaptureSingleton.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new CameraCaptureSingleton(ContextUtils.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    private void handleCameraStartFailed() {
        LiteavLog.e(TAG, "camera start failed. params: %s", this.mCurrentCaptureParams);
        ad adVar = this.mCameraController;
        if (adVar != null) {
            adVar.a();
        }
        this.mCameraController = null;
        if (this.mIsCameraInRestarting) {
            this.mSequenceTaskRunner.a(this.mRestartCameraRunnable, 2000L);
        } else if (this.mIsCameraInSwitching) {
            this.mSequenceTaskRunner.a(this.mSwitchToCamera1Runnable, 1000L);
        } else {
            af.a a2 = this.mCameraSupervisor.a();
            af afVar = this.mCameraSupervisor;
            if (afVar.f23168a == af.a.CAMERA_2) {
                afVar.f23169c = true;
            }
            if (a2 == this.mCameraSupervisor.a()) {
                if (this.mNeedNotifyStartFinish) {
                    this.mNeedNotifyStartFinish = false;
                    this.mListenerManager.a(false);
                    return;
                }
                return;
            }
            LiteavLog.w(TAG, "camera switch from " + a2 + " to " + this.mCameraSupervisor.a());
            this.mSequenceTaskRunner.a(this.mSwitchToCamera1Runnable, 1000L);
        }
    }

    private void handleCameraStartSuccess() {
        if (this.mCameraController == null || this.mSurfaceTexture == null) {
            LiteavLog.e(TAG, "camera start success, but mCameraController or mSurfaceTexture is null.");
            return;
        }
        LiteavLog.i(TAG, "camera start success. params: %s", this.mCurrentCaptureParams);
        this.mCameraRotation = this.mCameraController.b();
        this.mIsZoomSupported = this.mCameraController.e();
        this.mIsTorchSupported = this.mCameraController.f();
        this.mIsCameraAutoFocusFaceModeSupported = this.mCameraController.g();
        this.mIsFocusPositionInPreviewSupported = this.mCameraController.h();
        this.mMaxZoomLevel = this.mCameraController.c();
        com.tencent.liteav.base.util.n d = this.mCameraController.d();
        Rotation rotation = this.mCameraRotation;
        Object obj = this.mSharedContext;
        Object obj2 = obj;
        if (obj == null) {
            obj2 = this.mEGLCore.d();
        }
        this.mPixelFrame = initOutputPixelFrame(d, rotation, obj2, this.mOESTextureId);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        if (this.mNeedNotifyStartFinish) {
            this.mNeedNotifyStartFinish = false;
            this.mListenerManager.a(true);
        }
        this.mIsCameraInRestarting = false;
        this.mIsCameraInSwitching = false;
    }

    private void initGLComponents(Object obj) {
        if (this.mEGLCore != null) {
            return;
        }
        this.mEGLCore = new com.tencent.liteav.videobase.b.e();
        if (this.mTextureHolderPool == null) {
            this.mTextureHolderPool = new com.tencent.liteav.videobase.frame.l();
        }
        try {
            this.mEGLCore.a(obj, null, 128, 128);
            this.mEGLCore.a();
            this.mSharedContext = obj;
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(TAG, "initializeEGL failed.", e);
            this.mListenerManager.a();
            this.mEGLCore = null;
        }
        if (this.mEGLCore != null) {
            this.mGLTexturePool = new com.tencent.liteav.videobase.frame.e();
        }
    }

    private static PixelFrame initOutputPixelFrame(com.tencent.liteav.base.util.n nVar, Rotation rotation, Object obj, int i) {
        PixelFrame pixelFrame = new PixelFrame();
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            pixelFrame.setWidth(nVar.b);
            pixelFrame.setHeight(nVar.f22649a);
        } else {
            pixelFrame.setWidth(nVar.f22649a);
            pixelFrame.setHeight(nVar.b);
        }
        pixelFrame.setPixelBufferType(GLConstants.PixelBufferType.TEXTURE_OES);
        pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
        pixelFrame.setRotation(Rotation.NORMAL);
        pixelFrame.setGLContext(obj);
        pixelFrame.setTextureId(i);
        return pixelFrame;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c3, code lost:
        if (r5.mCurrentCaptureParams.b < r6.b) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isNeedRestartCamera(com.tencent.liteav.videoproducer.capture.CameraCaptureParams r6) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.CameraCaptureSingleton.isNeedRestartCamera(com.tencent.liteav.videoproducer.capture.CameraCaptureParams):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$enableCameraZoom$6(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        cameraCaptureSingleton.mEnableZoom = z;
        cameraCaptureSingleton.mListenerManager.d(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$enableTapToFocus$4(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        cameraCaptureSingleton.mEnableTapToFocus = z;
        ad adVar = cameraCaptureSingleton.mCameraController;
        if (adVar != null) {
            adVar.b(z);
        }
        cameraCaptureSingleton.mListenerManager.c(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onCameraError$10(CameraCaptureSingleton cameraCaptureSingleton, ad adVar) {
        ad adVar2 = cameraCaptureSingleton.mCameraController;
        if (adVar2 == null || adVar2 != adVar) {
            return;
        }
        LiteavLog.w(TAG, "VideoCapture: camera error");
        cameraCaptureSingleton.closeCamera();
        cameraCaptureSingleton.mSequenceTaskRunner.a(cameraCaptureSingleton.mRestartCameraRunnable, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onFrameAvailable$11(CameraCaptureSingleton cameraCaptureSingleton, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = cameraCaptureSingleton.mSurfaceTexture;
        if (surfaceTexture2 != null && surfaceTexture == surfaceTexture2) {
            if (cameraCaptureSingleton.makeCurrent()) {
                cameraCaptureSingleton.checkFirstFrameCaptured();
                cameraCaptureSingleton.onCaptureFrameAvailable();
                return;
            }
            return;
        }
        LiteavLog.i(TAG, "mSurfaceTexture= " + cameraCaptureSingleton.mSurfaceTexture + " ,surfaceTexture= " + surfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setExposureCompensation$9(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        cameraCaptureSingleton.mExposureCompensation = f;
        ad adVar = cameraCaptureSingleton.mCameraController;
        if (adVar != null) {
            adVar.b(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setServerConfig$1(CameraCaptureSingleton cameraCaptureSingleton, ServerVideoProducerConfig serverVideoProducerConfig) {
        cameraCaptureSingleton.mServerConfig = serverVideoProducerConfig;
        af afVar = cameraCaptureSingleton.mCameraSupervisor;
        int camera2SupportMinApiLevel = serverVideoProducerConfig.getCamera2SupportMinApiLevel();
        afVar.b = camera2SupportMinApiLevel;
        LiteavLog.i("CameraSupervisor", "setCamera2SupportMinApiLevel apiLevel:".concat(String.valueOf(camera2SupportMinApiLevel)));
        LiteavLog.i(TAG, "setServerConfig minApiLevel:" + serverVideoProducerConfig.getCamera2SupportMinApiLevel());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setZoomLevel$7(CameraCaptureSingleton cameraCaptureSingleton, float f) {
        int i = cameraCaptureSingleton.mMaxZoomLevel;
        if (i <= 0) {
            LiteavLog.w(TAG, "setZoomLevel maxZoomLevel=".concat(String.valueOf(i)));
        } else {
            cameraCaptureSingleton.setZoomInternal(f / i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$start$12(CameraCaptureSingleton cameraCaptureSingleton, CaptureSourceInterface.a aVar, CameraCaptureParams cameraCaptureParams) {
        cameraCaptureSingleton.mListenerManager.a(aVar);
        if (cameraCaptureSingleton.mEGLCore == null || cameraCaptureSingleton.mCurrentCaptureParams == null) {
            cameraCaptureSingleton.initGLComponents(au.a().b());
            cameraCaptureSingleton.openCamera(cameraCaptureParams);
            return;
        }
        LiteavLog.i(TAG, "capture source has already started!");
        cameraCaptureSingleton.updateParamsInternal(cameraCaptureParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$startAutoFocusAtPosition$5(CameraCaptureSingleton cameraCaptureSingleton, int i, int i2) {
        ad adVar;
        if (cameraCaptureSingleton.mEnableTapToFocus && (adVar = cameraCaptureSingleton.mCameraController) != null) {
            adVar.a(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$stop$13(CameraCaptureSingleton cameraCaptureSingleton) {
        LiteavLog.i(TAG, "stop listener count: " + cameraCaptureSingleton.mListenerManager.b());
        if (cameraCaptureSingleton.mListenerManager.b() == 0) {
            cameraCaptureSingleton.closeCamera();
            cameraCaptureSingleton.mZoomPercent = 0.0f;
            cameraCaptureSingleton.mNeedNotifyStartFinish = true;
            cameraCaptureSingleton.mCurrentCaptureParams = null;
            cameraCaptureSingleton.uninitGLComponents();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$switchCamera$2(CameraCaptureSingleton cameraCaptureSingleton) {
        boolean z = cameraCaptureSingleton.mExpectFrontCamera.get();
        CameraCaptureParams cameraCaptureParams = cameraCaptureSingleton.mCurrentCaptureParams;
        if (cameraCaptureParams == null || cameraCaptureParams.f23151a.booleanValue() == z) {
            return;
        }
        cameraCaptureSingleton.closeCamera();
        cameraCaptureSingleton.mZoomPercent = 0.0f;
        cameraCaptureSingleton.mNeedNotifyStartFinish = true;
        cameraCaptureSingleton.mCurrentCaptureParams.f23151a = Boolean.valueOf(z);
        cameraCaptureSingleton.openCamera(cameraCaptureSingleton.mCurrentCaptureParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$turnOnTorch$3(CameraCaptureSingleton cameraCaptureSingleton, boolean z) {
        ad adVar = cameraCaptureSingleton.mCameraController;
        if (adVar != null) {
            adVar.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateParams$15(CameraCaptureSingleton cameraCaptureSingleton, CameraCaptureParams cameraCaptureParams) {
        if (cameraCaptureSingleton.mEGLCore == null || cameraCaptureSingleton.mCurrentCaptureParams == null) {
            return;
        }
        LiteavLog.i(TAG, "capture source has already started!");
        cameraCaptureSingleton.updateParamsInternal(cameraCaptureParams);
    }

    private void onCaptureFrameAvailable() {
        com.tencent.liteav.videobase.frame.l lVar;
        if (this.mGLTexturePool == null || (lVar = this.mTextureHolderPool) == null) {
            LiteavLog.w(TAG, "onCaptureFrameAvailable mGLTexturePool:" + this.mGLTexturePool + " mTextureHolderPool:" + this.mTextureHolderPool);
            return;
        }
        l.b bVar = null;
        try {
            bVar = lVar.a();
        } catch (InterruptedException e) {
        }
        if (this.mPixelFrame.getMatrix() == null) {
            this.mPixelFrame.setMatrix(this.mMatrix);
        }
        try {
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mMatrix);
        } catch (Exception e2) {
            LiteavLog.w(TAG, "updateTexImage exception: ".concat(String.valueOf(e2)));
        }
        bVar.a(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, this.mOESTextureId, this.mPixelFrame.getWidth(), this.mPixelFrame.getHeight());
        PixelFrame a2 = bVar.a(this.mPixelFrame.getGLContext());
        a2.setMirrorHorizontal(isFrontCamera());
        a2.setMatrix(this.mMatrix);
        a2.setTimestamp(TimeUtil.c());
        if (a2.getGLContext() == null) {
            a2.setGLContext(this.mEGLCore.d());
        }
        this.mListenerManager.a(this, a2);
        bVar.release();
        a2.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openCamera(CameraCaptureParams cameraCaptureParams) {
        if (this.mCameraController != null) {
            LiteavLog.e(TAG, "camera is opened, you should Stop it first.");
            return true;
        }
        boolean openCameraInternal = openCameraInternal(cameraCaptureParams);
        if (openCameraInternal) {
            handleCameraStartSuccess();
            return openCameraInternal;
        }
        handleCameraStartFailed();
        return openCameraInternal;
    }

    private boolean openCameraInternal(CameraCaptureParams cameraCaptureParams) {
        if (!makeCurrent()) {
            LiteavLog.e(TAG, "openCameraInternal: set opengl context fail.");
            return false;
        }
        this.mOESTextureId = OpenGlUtils.generateTextureOES();
        this.mSurfaceTexture = new SurfaceTexture(this.mOESTextureId);
        this.mCameraController = createCameraController(this.mCameraSupervisor.a());
        if (cameraCaptureParams.f23151a == null) {
            cameraCaptureParams.f23151a = Boolean.valueOf(this.mExpectFrontCamera.get());
            LiteavLog.w(TAG, "openCameraInternal frontCamera not set, use expect front camera:" + cameraCaptureParams.f23151a);
        }
        this.mCurrentCaptureParams = cameraCaptureParams;
        this.mCameraController.b(this.mEnableTapToFocus);
        this.mCameraController.b(this.mExposureCompensation);
        this.mCameraController.a(this.mZoomPercent);
        this.mListenerManager.c(this.mEnableTapToFocus);
        this.mListenerManager.d(this.mEnableZoom);
        return this.mCameraController.a(this.mCurrentCaptureParams, this.mSurfaceTexture, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoomInternal(float f) {
        ad adVar;
        LiteavLog.i(TAG, "setZoomInternal ".concat(String.valueOf(f)));
        if (Math.abs(this.mZoomPercent - f) >= 0.001d && (adVar = this.mCameraController) != null) {
            this.mZoomPercent = f;
            adVar.a(f);
        }
    }

    private void updateParamsInternal(CameraCaptureParams cameraCaptureParams) {
        if (cameraCaptureParams.f23151a == null) {
            cameraCaptureParams.f23151a = this.mCurrentCaptureParams.f23151a;
            LiteavLog.i(TAG, "params not set frontCamera, use mCurrentCaptureParams frontCamera:" + this.mCurrentCaptureParams.f23151a);
        }
        if (isNeedRestartCamera(cameraCaptureParams)) {
            LiteavLog.i(TAG, "reopen camera params: ".concat(String.valueOf(cameraCaptureParams)));
            updateCamera(cameraCaptureParams);
        }
    }

    public void enableCameraZoom(boolean z) {
        LiteavLog.i(TAG, "enableCameraZoom ".concat(String.valueOf(z)));
        runInGLThread(p.a(this, z));
    }

    public void enableMockCamera(boolean z) {
        this.mCameraSupervisor.d = z;
    }

    public void enableTapToFocus(boolean z) {
        LiteavLog.i(TAG, "enableTapToFocus ".concat(String.valueOf(z)));
        runInGLThread(n.a(this, z));
    }

    public af.a getCameraAPIType() {
        return this.mCameraSupervisor.a();
    }

    public Rotation getCameraRotation() {
        return this.mCameraRotation;
    }

    public int getMaxZoomLevel() {
        return this.mMaxZoomLevel;
    }

    public boolean isAutoFocusEnabled() {
        return !this.mEnableTapToFocus;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.mIsCameraAutoFocusFaceModeSupported;
    }

    public boolean isCameraFocusPositionInPreviewSupported() {
        return this.mIsFocusPositionInPreviewSupported;
    }

    public boolean isFrontCamera() {
        CameraCaptureParams cameraCaptureParams = this.mCurrentCaptureParams;
        if (cameraCaptureParams == null || cameraCaptureParams.f23151a == null) {
            return false;
        }
        return cameraCaptureParams.f23151a.booleanValue();
    }

    public boolean isTorchSupported() {
        return this.mIsTorchSupported;
    }

    public boolean isZoomSupported() {
        return this.mIsZoomSupported;
    }

    protected boolean makeCurrent() {
        com.tencent.liteav.videobase.b.e eVar = this.mEGLCore;
        if (eVar == null) {
            LiteavLog.e(TAG, "makeCurrent on mEGLCore is null");
            return false;
        }
        try {
            eVar.a();
            return true;
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(TAG, "make current failed.", e);
            this.mListenerManager.a();
            return false;
        }
    }

    @Override // com.tencent.liteav.videoproducer.capture.ae
    public void onCameraError(ad adVar) {
        runInGLThread(d.a(this, adVar));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        runInGLThread(e.a(this, surfaceTexture));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void pause() {
        LiteavLog.i(TAG, com.anythink.expressad.foundation.d.c.cb);
        runInGLThread(h.a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pauseInternal() {
        this.mPausedCount++;
        int b = this.mListenerManager.b();
        LiteavLog.i(TAG, "pauseInternal paused cnt= " + this.mPausedCount + " , listener cnt=" + b);
        if (this.mPausedCount > b) {
            this.mPausedCount = b;
        }
        if (b != this.mPausedCount) {
            LiteavLog.i(TAG, "pauseInternal listeners is not zero.");
        } else {
            closeCamera();
        }
    }

    public void removeListener(CaptureSourceInterface.a aVar) {
        runInGLThread(b.a(this, aVar));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void resume() {
        LiteavLog.i(TAG, "resume");
        runInGLThread(i.a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resumeInternal(CameraCaptureParams cameraCaptureParams) {
        LiteavLog.i(TAG, "resumeInternal pausedCount %d, listeners size = %d", Integer.valueOf(this.mPausedCount), Integer.valueOf(this.mListenerManager.b()));
        if (this.mListenerManager.b() == this.mPausedCount) {
            openCamera(cameraCaptureParams);
        }
        int i = this.mPausedCount - 1;
        this.mPausedCount = i;
        if (i < 0) {
            this.mPausedCount = 0;
        }
    }

    protected void runInGLThread(Runnable runnable) {
        this.mSequenceTaskRunner.a(runnable);
    }

    public void setExposureCompensation(float f) {
        LiteavLog.i(TAG, "setExposureCompensation ".concat(String.valueOf(f)));
        runInGLThread(c.a(this, f));
    }

    public void setPercentOfMaxZoomLevel(float f) {
        runInGLThread(r.a(this, f));
    }

    public void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
        runInGLThread(k.a(this, serverVideoProducerConfig));
    }

    public void setZoomLevel(float f) {
        LiteavLog.i(TAG, "setZoomLevel ".concat(String.valueOf(f)));
        runInGLThread(q.a(this, f));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void start(Object obj, CaptureSourceInterface.CaptureParams captureParams, CaptureSourceInterface.a aVar) {
        LiteavLog.i(TAG, "Start ".concat(String.valueOf(obj)));
        runInGLThread(f.a(this, aVar, new CameraCaptureParams((CameraCaptureParams) captureParams)));
    }

    public void startAutoFocusAtPosition(int i, int i2) {
        LiteavLog.i(TAG, "startAutoFocusAtPosition " + i + ", " + i2);
        runInGLThread(o.a(this, i, i2));
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void stop() {
        LiteavLog.i(TAG, "Stop");
        runInGLThread(g.a(this));
    }

    public void switchCamera(boolean z) {
        LiteavLog.i(TAG, "switchCamera ".concat(String.valueOf(z)));
        this.mExpectFrontCamera.set(z);
        runInGLThread(l.a(this));
    }

    public void turnOnTorch(boolean z) {
        LiteavLog.i(TAG, "turnOnTorch ".concat(String.valueOf(z)));
        runInGLThread(m.a(this, z));
    }

    protected void uninitGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        com.tencent.liteav.videobase.frame.l lVar = this.mTextureHolderPool;
        if (lVar != null) {
            lVar.b();
            this.mTextureHolderPool = null;
        }
        try {
            this.mEGLCore.a();
            if (this.mGLTexturePool != null) {
                this.mGLTexturePool.b();
                this.mGLTexturePool = null;
            }
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(TAG, "EGLCore destroy failed.", e);
        }
        this.mSharedContext = null;
        com.tencent.liteav.videobase.b.e.a(this.mEGLCore);
        this.mEGLCore = null;
        this.mSequenceTaskRunner.c(this.mRestartCameraRunnable);
        this.mSequenceTaskRunner.c(this.mSwitchToCamera1Runnable);
    }

    protected void updateCamera(CameraCaptureParams cameraCaptureParams) {
        closeCamera();
        this.mNeedNotifyStartFinish = true;
        openCamera(cameraCaptureParams);
    }

    @Override // com.tencent.liteav.videoproducer.capture.CaptureSourceInterface
    public void updateParams(CaptureSourceInterface.CaptureParams captureParams) {
        CameraCaptureParams cameraCaptureParams = new CameraCaptureParams((CameraCaptureParams) captureParams);
        LiteavLog.i(TAG, "updateParams");
        runInGLThread(j.a(this, cameraCaptureParams));
    }
}
