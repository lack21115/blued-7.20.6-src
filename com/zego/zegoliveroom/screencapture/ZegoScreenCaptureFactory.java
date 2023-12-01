package com.zego.zegoliveroom.screencapture;

import android.media.projection.MediaProjection;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import com.zego.zegoavkit2.ZegoVideoCaptureFactory;
import com.zego.zegoliveroom.ZegoLiveRoom;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/screencapture/ZegoScreenCaptureFactory.class */
public class ZegoScreenCaptureFactory extends ZegoVideoCaptureFactory {
    public static final int DEFAULT_VIDEO_HEIGHT = 640;
    public static final int DEFAULT_VIDEO_WIDTH = 360;
    private volatile ZegoScreenCaptureDevice mDevice = null;
    private volatile MediaProjection mMediaProjection = null;
    private volatile int mCaptureWidth = 360;
    private volatile int mCaptureHeight = 640;

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureFactory
    public ZegoVideoCaptureDevice create(String str) {
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureFactory_create]", new Object[0]);
        if (this.mDevice == null) {
            this.mDevice = new ZegoScreenCaptureDevice(this.mMediaProjection, this.mCaptureWidth, this.mCaptureHeight);
        }
        return this.mDevice;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureFactory
    public void destroy(ZegoVideoCaptureDevice zegoVideoCaptureDevice) {
        ZegoLiveRoom._logPrint("[Java_ZegoScreenCaptureFactory_destroy]", new Object[0]);
        if (zegoVideoCaptureDevice == this.mDevice) {
            this.mMediaProjection = null;
            this.mCaptureWidth = 360;
            this.mCaptureHeight = 640;
            this.mDevice.setMediaProjection(null);
            this.mDevice.setCaptureResolution(360, 640);
            this.mDevice = null;
        }
    }

    public void setCaptureResolution(int i, int i2) {
        this.mCaptureWidth = i;
        this.mCaptureHeight = i2;
        ZegoScreenCaptureDevice zegoScreenCaptureDevice = this.mDevice;
        if (zegoScreenCaptureDevice != null) {
            zegoScreenCaptureDevice.setCaptureResolution(i, i2);
        }
    }

    public void setMediaProjection(MediaProjection mediaProjection) {
        this.mMediaProjection = mediaProjection;
        ZegoScreenCaptureDevice zegoScreenCaptureDevice = this.mDevice;
        if (zegoScreenCaptureDevice != null) {
            zegoScreenCaptureDevice.setMediaProjection(mediaProjection);
        }
    }
}
