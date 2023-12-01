package com.zego.zegoavkit2.screencapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import com.zego.zegoavkit2.screencapture.ve_gl.EglBase;
import com.zego.zegoavkit2.screencapture.ve_gl.EglBase14;
import com.zego.zegoavkit2.screencapture.ve_gl.GlRectDrawer;
import com.zego.zegoavkit2.screencapture.ve_gl.GlUtil;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/screencapture/ZegoScreenCaptureDevice.class */
public class ZegoScreenCaptureDevice extends ZegoVideoCaptureDevice implements SurfaceTexture.OnFrameAvailableListener {
    private int mCaptureHeight;
    private int mCaptureWidth;
    private boolean mEgl14Supported;
    private EglBase mEglSysToVideoMemory;
    private EglBase mEglVideoMemoryToSDK;
    private int mFrameBufferId;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private volatile MediaProjection mMediaProjection;
    private int mSDKTextureId;
    private SurfaceTexture mSdkSurfaceTexture;
    private int mSetCaptureHeight;
    private int mSetCaptureWidth;
    private SurfaceTexture mSysSurfaceTexture;
    private int mSysTextureId;
    private GlRectDrawer mSysToVideoMemoryDrawer;
    private GlRectDrawer mVideoMemoryToSDKDrawer;
    private WindowManager mWindowManager;
    private volatile ZegoVideoCaptureDevice.Client mClient = null;
    private volatile VirtualDisplay mVirtualDisplay = null;
    private int mSdkSurfaceBufferWidth = 0;
    private int mSdkSurfaceBufferHeight = 0;
    private volatile boolean isStartPreview = false;
    private volatile boolean isStartCapture = false;
    private volatile boolean isCapturing = false;
    private volatile Surface mSurface = null;
    private float[] transformationMatrix = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] mInputMatrix = new float[16];
    private volatile int mDrawToSDKInterval = 66;
    private DrawRunnable mDrawRunnable = new DrawRunnable();
    private DisplayMetrics mOutMetrics = new DisplayMetrics();

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/screencapture/ZegoScreenCaptureDevice$DrawRunnable.class */
    class DrawRunnable implements Runnable {
        private DrawRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            ZegoScreenCaptureDevice.this.resizeVirtualDisplayInNeed();
            ZegoScreenCaptureDevice.this.drawRGBTextureToSDK();
            long currentTimeMillis2 = ZegoScreenCaptureDevice.this.mDrawToSDKInterval - (System.currentTimeMillis() - currentTimeMillis);
            long j = currentTimeMillis2;
            if (currentTimeMillis2 < 0) {
                j = 0;
            }
            if (ZegoScreenCaptureDevice.this.mHandler != null) {
                ZegoScreenCaptureDevice.this.mHandler.postDelayed(ZegoScreenCaptureDevice.this.mDrawRunnable, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZegoScreenCaptureDevice(Context context, MediaProjection mediaProjection, int i, int i2) {
        this.mHandlerThread = null;
        this.mHandler = null;
        this.mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        this.mMediaProjection = mediaProjection;
        this.mSetCaptureWidth = i;
        this.mSetCaptureHeight = i2;
        HandlerThread handlerThread = new HandlerThread("ZegoScreenCapture");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    private void drawOESTexture() {
        synchronized (this) {
            if (!this.mEglSysToVideoMemory.hasSurface()) {
                this.mEglSysToVideoMemory.createDummyPbufferSurface();
            }
            this.mEglSysToVideoMemory.makeCurrent();
            if (this.mSysToVideoMemoryDrawer == null) {
                this.mSysToVideoMemoryDrawer = new GlRectDrawer();
            }
            this.mSysSurfaceTexture.updateTexImage();
            this.mSysSurfaceTexture.getTransformMatrix(this.mInputMatrix);
            if (this.mSDKTextureId == 0) {
                GLES20.glActiveTexture(33984);
                this.mSDKTextureId = GlUtil.generateTexture(3553);
                GLES20.glTexImage2D(3553, 0, 6408, this.mCaptureWidth, this.mCaptureHeight, 0, 6408, 5121, null);
                this.mFrameBufferId = GlUtil.generateFrameBuffer(this.mSDKTextureId);
            } else {
                GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
            }
            GLES20.glClear(16384);
            this.mSysToVideoMemoryDrawer.drawOes(this.mSysTextureId, this.mInputMatrix, this.mCaptureWidth, this.mCaptureHeight, 0, 0, this.mCaptureWidth, this.mCaptureHeight);
            GLES20.glBindFramebuffer(36160, 0);
            this.mEglSysToVideoMemory.detachCurrent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawRGBTextureToSDK() {
        synchronized (this) {
            try {
                if (!this.mEglVideoMemoryToSDK.hasSurface() && this.mSdkSurfaceTexture != null) {
                    this.mEglVideoMemoryToSDK.createSurface(this.mSdkSurfaceTexture);
                }
                this.mEglVideoMemoryToSDK.makeCurrent();
                if (this.mVideoMemoryToSDKDrawer == null) {
                    this.mVideoMemoryToSDKDrawer = new GlRectDrawer();
                }
                long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
                GLES20.glClear(16384);
                this.mVideoMemoryToSDKDrawer.drawRgb(this.mSDKTextureId, this.transformationMatrix, this.mCaptureWidth, this.mCaptureHeight, 0, 0, this.mSdkSurfaceBufferWidth, this.mSdkSurfaceBufferHeight);
                if (this.mEgl14Supported) {
                    ((EglBase14) this.mEglVideoMemoryToSDK).swapBuffers(nanos);
                } else {
                    this.mEglVideoMemoryToSDK.swapBuffers();
                }
                this.mEglVideoMemoryToSDK.detachCurrent();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private void getSurface() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.screencapture.ZegoScreenCaptureDevice.1
            @Override // java.lang.Runnable
            public void run() {
                if (ZegoScreenCaptureDevice.this.mEglSysToVideoMemory == null) {
                    ZegoScreenCaptureDevice.this.mEglSysToVideoMemory = EglBase.create(null, EglBase.CONFIG_PIXEL_BUFFER);
                }
                if (!ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.hasSurface()) {
                    try {
                        ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.createDummyPbufferSurface();
                        ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.makeCurrent();
                        ZegoScreenCaptureDevice.this.mSysToVideoMemoryDrawer = new GlRectDrawer();
                    } catch (RuntimeException e) {
                        ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.releaseSurface();
                        e.printStackTrace();
                        throw e;
                    }
                }
                ZegoScreenCaptureDevice.this.mEgl14Supported = EglBase14.isEGL14Supported();
                ZegoScreenCaptureDevice.this.mSysTextureId = GlUtil.generateTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
                ZegoScreenCaptureDevice.this.mSysSurfaceTexture = new SurfaceTexture(ZegoScreenCaptureDevice.this.mSysTextureId);
                ZegoScreenCaptureDevice.this.mSysSurfaceTexture.setDefaultBufferSize(ZegoScreenCaptureDevice.this.mCaptureWidth, ZegoScreenCaptureDevice.this.mCaptureHeight);
                ZegoScreenCaptureDevice.this.mSurface = new Surface(ZegoScreenCaptureDevice.this.mSysSurfaceTexture);
                ZegoScreenCaptureDevice.this.mSysSurfaceTexture.setOnFrameAvailableListener(ZegoScreenCaptureDevice.this);
                if (ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK == null) {
                    ZegoScreenCaptureDevice zegoScreenCaptureDevice = ZegoScreenCaptureDevice.this;
                    zegoScreenCaptureDevice.mEglVideoMemoryToSDK = EglBase.create(zegoScreenCaptureDevice.mEglSysToVideoMemory.getEglBaseContext(), EglBase.CONFIG_RECORDABLE);
                }
                if (!ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.hasSurface()) {
                    ZegoScreenCaptureDevice zegoScreenCaptureDevice2 = ZegoScreenCaptureDevice.this;
                    zegoScreenCaptureDevice2.mSdkSurfaceTexture = zegoScreenCaptureDevice2.mClient.getSurfaceTexture();
                    ZegoScreenCaptureDevice.this.mSdkSurfaceTexture.setDefaultBufferSize(ZegoScreenCaptureDevice.this.mSdkSurfaceBufferWidth, ZegoScreenCaptureDevice.this.mSdkSurfaceBufferHeight);
                    try {
                        ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.createSurface(ZegoScreenCaptureDevice.this.mSdkSurfaceTexture);
                        ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.makeCurrent();
                        ZegoScreenCaptureDevice.this.mVideoMemoryToSDKDrawer = new GlRectDrawer();
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                        ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.releaseSurface();
                        return;
                    }
                }
                ZegoScreenCaptureDevice.this.mHandler.postDelayed(ZegoScreenCaptureDevice.this.mDrawRunnable, ZegoScreenCaptureDevice.this.mDrawToSDKInterval);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initCaptureSize() {
        if (isDefaultCaptureSize()) {
            this.mWindowManager.getDefaultDisplay().getRealMetrics(this.mOutMetrics);
            this.mCaptureWidth = this.mOutMetrics.widthPixels;
            this.mCaptureHeight = this.mOutMetrics.heightPixels;
        } else {
            this.mCaptureWidth = this.mSetCaptureWidth;
            this.mCaptureHeight = this.mSetCaptureHeight;
        }
        if (this.mSdkSurfaceBufferWidth == 0 && this.mSdkSurfaceBufferHeight == 0) {
            this.mSdkSurfaceBufferWidth = this.mCaptureWidth;
            this.mSdkSurfaceBufferHeight = this.mCaptureHeight;
        }
    }

    private boolean isDefaultCaptureSize() {
        return this.mSetCaptureWidth == 0 || this.mSetCaptureHeight == 0;
    }

    private void releaseEGLSurface() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.screencapture.ZegoScreenCaptureDevice.2
            @Override // java.lang.Runnable
            public void run() {
                if (ZegoScreenCaptureDevice.this.mHandler != null) {
                    ZegoScreenCaptureDevice.this.mHandler.removeCallbacks(ZegoScreenCaptureDevice.this.mDrawRunnable);
                }
                if (ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK != null && ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.hasSurface()) {
                    ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.makeCurrent();
                    if (ZegoScreenCaptureDevice.this.mVideoMemoryToSDKDrawer != null) {
                        ZegoScreenCaptureDevice.this.mVideoMemoryToSDKDrawer.release();
                        ZegoScreenCaptureDevice.this.mVideoMemoryToSDKDrawer = null;
                    }
                    ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.releaseSurface();
                    ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.detachCurrent();
                    ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK.release();
                    ZegoScreenCaptureDevice.this.mEglVideoMemoryToSDK = null;
                }
                if (ZegoScreenCaptureDevice.this.mEglSysToVideoMemory != null && ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.hasSurface()) {
                    ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.makeCurrent();
                    if (ZegoScreenCaptureDevice.this.mFrameBufferId != 0) {
                        GLES20.glDeleteFramebuffers(1, new int[]{ZegoScreenCaptureDevice.this.mFrameBufferId}, 0);
                        ZegoScreenCaptureDevice.this.mFrameBufferId = 0;
                    }
                    if (ZegoScreenCaptureDevice.this.mSDKTextureId != 0) {
                        GLES20.glDeleteTextures(1, new int[]{ZegoScreenCaptureDevice.this.mSDKTextureId}, 0);
                        ZegoScreenCaptureDevice.this.mSDKTextureId = 0;
                    }
                    if (ZegoScreenCaptureDevice.this.mSysTextureId != 0) {
                        GLES20.glDeleteTextures(1, new int[]{ZegoScreenCaptureDevice.this.mSysTextureId}, 0);
                        ZegoScreenCaptureDevice.this.mSysTextureId = 0;
                    }
                    if (ZegoScreenCaptureDevice.this.mSysToVideoMemoryDrawer != null) {
                        ZegoScreenCaptureDevice.this.mSysToVideoMemoryDrawer.release();
                        ZegoScreenCaptureDevice.this.mSysToVideoMemoryDrawer = null;
                    }
                    ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.releaseSurface();
                    ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.detachCurrent();
                    ZegoScreenCaptureDevice.this.mEglSysToVideoMemory.release();
                    ZegoScreenCaptureDevice.this.mEglSysToVideoMemory = null;
                }
                if (ZegoScreenCaptureDevice.this.mSurface != null) {
                    ZegoScreenCaptureDevice.this.mSurface.release();
                    ZegoScreenCaptureDevice.this.mSurface = null;
                }
                if (ZegoScreenCaptureDevice.this.mSysSurfaceTexture != null) {
                    ZegoScreenCaptureDevice.this.mSysSurfaceTexture.setOnFrameAvailableListener(null);
                    ZegoScreenCaptureDevice.this.mSysSurfaceTexture.release();
                    ZegoScreenCaptureDevice.this.mSysSurfaceTexture = null;
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeSdkSurface(int i, int i2) {
        if (this.mSdkSurfaceBufferWidth == i && this.mSdkSurfaceBufferHeight == i2) {
            return;
        }
        this.mSdkSurfaceBufferWidth = i;
        this.mSdkSurfaceBufferHeight = i2;
        EglBase eglBase = this.mEglVideoMemoryToSDK;
        if (eglBase != null) {
            eglBase.makeCurrent();
            GlRectDrawer glRectDrawer = this.mVideoMemoryToSDKDrawer;
            if (glRectDrawer != null) {
                glRectDrawer.release();
                this.mVideoMemoryToSDKDrawer = null;
            }
            this.mEglVideoMemoryToSDK.releaseSurface();
            this.mEglVideoMemoryToSDK.detachCurrent();
        }
        SurfaceTexture surfaceTexture = this.mSdkSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(this.mSdkSurfaceBufferWidth, this.mSdkSurfaceBufferHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeVirtualDisplayInNeed() {
        EglBase eglBase = this.mEglSysToVideoMemory;
        if (eglBase == null || !eglBase.hasSurface()) {
            return;
        }
        int i = this.mSetCaptureWidth;
        int i2 = this.mSetCaptureHeight;
        if (isDefaultCaptureSize()) {
            this.mWindowManager.getDefaultDisplay().getRealMetrics(this.mOutMetrics);
            i = this.mOutMetrics.widthPixels;
            i2 = this.mOutMetrics.heightPixels;
        }
        if (this.mCaptureWidth == i && this.mCaptureHeight == i2) {
            return;
        }
        this.mCaptureWidth = i;
        this.mCaptureHeight = i2;
        EglBase eglBase2 = this.mEglSysToVideoMemory;
        if (eglBase2 != null) {
            eglBase2.makeCurrent();
        }
        int i3 = this.mFrameBufferId;
        if (i3 != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i3}, 0);
            this.mFrameBufferId = 0;
        }
        int i4 = this.mSDKTextureId;
        if (i4 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i4}, 0);
            this.mSDKTextureId = 0;
        }
        GlRectDrawer glRectDrawer = this.mSysToVideoMemoryDrawer;
        if (glRectDrawer != null) {
            glRectDrawer.release();
            this.mSysToVideoMemoryDrawer = null;
        }
        EglBase eglBase3 = this.mEglSysToVideoMemory;
        if (eglBase3 != null) {
            eglBase3.releaseSurface();
            this.mEglSysToVideoMemory.detachCurrent();
        }
        SurfaceTexture surfaceTexture = this.mSysSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(this.mCaptureWidth, this.mCaptureHeight);
        }
        if (this.mVirtualDisplay == null || this.mMediaProjection == null) {
            return;
        }
        this.mVirtualDisplay.release();
        this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenCapture", this.mCaptureWidth, this.mCaptureHeight, 1, 1, this.mSurface, (VirtualDisplay.Callback) null, this.mHandler);
    }

    private void startScreenCapture() {
        initCaptureSize();
        getSurface();
        this.isCapturing = true;
        setMediaProjection(this.mMediaProjection);
    }

    private void stopScreenCaptureInNeed() {
        this.isCapturing = false;
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
            this.mVirtualDisplay = null;
        }
        releaseEGLSurface();
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public void allocateAndStart(ZegoVideoCaptureDevice.Client client) {
        this.mClient = client;
        startScreenCapture();
    }

    public void clearDevice() {
        setMediaProjection(null);
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
            this.mHandler = null;
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int enableTorch(boolean z) {
        return 0;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.isCapturing) {
            drawOESTexture();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCaptureResolution(int i, int i2) {
        this.mSetCaptureWidth = i;
        this.mSetCaptureHeight = i2;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setCaptureRotation(int i) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setFrameRate(int i) {
        this.mDrawToSDKInterval = 1000 / i;
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setFrontCam(int i) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMediaProjection(MediaProjection mediaProjection) {
        this.mMediaProjection = mediaProjection;
        if (this.isCapturing) {
            if (this.mVirtualDisplay != null) {
                this.mVirtualDisplay.release();
                this.mVirtualDisplay = null;
            }
            if (this.mClient == null || this.mMediaProjection == null || this.mSurface == null) {
                return;
            }
            this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenCapture", this.mCaptureWidth, this.mCaptureHeight, 1, 1, this.mSurface, (VirtualDisplay.Callback) null, this.mHandler);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setPowerlineFreq(int i) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setResolution(final int i, final int i2) {
        this.mHandler.post(new Runnable() { // from class: com.zego.zegoavkit2.screencapture.ZegoScreenCaptureDevice.3
            @Override // java.lang.Runnable
            public void run() {
                ZegoScreenCaptureDevice.this.resizeSdkSurface(i, i2);
            }
        });
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setView(View view) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setViewMode(int i) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setViewRotation(int i) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int startCapture() {
        this.isStartCapture = true;
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int startPreview() {
        this.isStartPreview = true;
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public void stopAndDeAllocate() {
        stopScreenCaptureInNeed();
        if (this.mClient != null) {
            this.mClient.destroy();
            this.mClient = null;
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int stopCapture() {
        this.isStartCapture = false;
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int stopPreview() {
        this.isStartPreview = false;
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int supportBufferType() {
        return 4;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int takeSnapshot() {
        return 0;
    }
}
