package com.zego.zegoliveroom.screencapture;

import android.graphics.SurfaceTexture;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.View;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import com.zego.zegoliveroom.ZegoLiveRoom;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/screencapture/ZegoScreenCaptureDevice.class */
class ZegoScreenCaptureDevice extends ZegoVideoCaptureDevice {
    private int mCaptureHeight;
    private int mCaptureWidth;
    private volatile MediaProjection mMediaProjection;
    private volatile ZegoVideoCaptureDevice.Client mClient = null;
    private HandlerThread mHandlerThread = null;
    private Handler mHandler = null;
    private volatile VirtualDisplay mVirtualDisplay = null;
    private volatile boolean mIsCapturing = false;
    private volatile Surface mSurface = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZegoScreenCaptureDevice(MediaProjection mediaProjection, int i, int i2) {
        this.mMediaProjection = null;
        this.mCaptureWidth = 360;
        this.mCaptureHeight = 640;
        this.mMediaProjection = mediaProjection;
        this.mCaptureWidth = i;
        this.mCaptureHeight = i2;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public void allocateAndStart(ZegoVideoCaptureDevice.Client client) {
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureDevice_allocateAndStart], client:" + client, new Object[0]);
        this.mClient = client;
        HandlerThread handlerThread = new HandlerThread("ZegoScreenCapture");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        if (this.mClient != null) {
            SurfaceTexture surfaceTexture = client.getSurfaceTexture();
            surfaceTexture.setDefaultBufferSize(this.mCaptureWidth, this.mCaptureHeight);
            this.mSurface = new Surface(surfaceTexture);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int enableTorch(boolean z) {
        return 0;
    }

    public void setCaptureResolution(int i, int i2) {
        this.mCaptureWidth = i;
        this.mCaptureHeight = i2;
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.resize(this.mCaptureWidth, this.mCaptureHeight, 1);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setCaptureRotation(int i) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setFrameRate(int i) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setFrontCam(int i) {
        return 0;
    }

    public void setMediaProjection(MediaProjection mediaProjection) {
        this.mMediaProjection = mediaProjection;
        if (!this.mIsCapturing || this.mClient == null || this.mMediaProjection == null || this.mSurface == null) {
            return;
        }
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureDevice_restartCapture]", new Object[0]);
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
        }
        this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenCapture", this.mCaptureWidth, this.mCaptureHeight, 1, 1, this.mSurface, (VirtualDisplay.Callback) null, this.mHandler);
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setPowerlineFreq(int i) {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int setResolution(int i, int i2) {
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
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureDevice_startCapture], mMediaProjection:" + this.mMediaProjection + ", captureWidth:" + this.mCaptureWidth + ", captureHeight:" + this.mCaptureHeight, new Object[0]);
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureDevice_startCapture], mClient:" + this.mClient + ", mSurface:" + this.mSurface + ", mIsCapturing:" + this.mIsCapturing, new Object[0]);
        if (this.mClient == null || this.mIsCapturing || this.mMediaProjection == null || this.mSurface == null) {
            return 0;
        }
        this.mIsCapturing = true;
        this.mVirtualDisplay = this.mMediaProjection.createVirtualDisplay("ScreenCapture", this.mCaptureWidth, this.mCaptureHeight, 1, 1, this.mSurface, (VirtualDisplay.Callback) null, this.mHandler);
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int startPreview() {
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public void stopAndDeAllocate() {
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureDevice_stopAndDeAllocate]", new Object[0]);
        if (this.mClient != null) {
            this.mClient.destroy();
            this.mClient = null;
        }
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mHandlerThread = null;
            this.mHandler = null;
        }
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int stopCapture() {
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureDevice_stopCapture]", new Object[0]);
        this.mIsCapturing = false;
        if (this.mVirtualDisplay != null) {
            this.mVirtualDisplay.release();
            this.mVirtualDisplay = null;
            return 0;
        }
        return 0;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice
    public int stopPreview() {
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
