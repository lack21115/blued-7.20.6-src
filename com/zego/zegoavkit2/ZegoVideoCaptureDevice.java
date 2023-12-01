package com.zego.zegoavkit2;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.View;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureDevice.class */
public abstract class ZegoVideoCaptureDevice {
    public static final int PIXEL_BUFFER_TYPE_CV_PIXEL_BUFFER = 2;
    public static final int PIXEL_BUFFER_TYPE_ENCODED_FRAME = 16;
    public static final int PIXEL_BUFFER_TYPE_GL_TEXTURE_2D = 8;
    public static final int PIXEL_BUFFER_TYPE_GL_TEXTURE_EXTERNAL_OES = 64;
    public static final int PIXEL_BUFFER_TYPE_MEM = 1;
    public static final int PIXEL_BUFFER_TYPE_SURFACE_TEXTURE = 4;
    public static final int PIXEL_BUFFER_TYPE_UNKNOWN = 0;
    public static final int PIXEL_FORMAT_BGRA32 = 4;
    public static final int PIXEL_FORMAT_I420 = 1;
    public static final int PIXEL_FORMAT_NV12 = 2;
    public static final int PIXEL_FORMAT_NV21 = 3;
    public static final int PIXEL_FORMAT_RGBA32 = 5;
    public static final int PIXEL_FORMAT_UNKNOWN = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureDevice$Client.class */
    public interface Client {
        void destroy();

        SurfaceTexture getSurfaceTexture();

        void onByteBufferFrameCaptured(ByteBuffer byteBuffer, int i, VideoCaptureFormat videoCaptureFormat, long j, int i2);

        void onByteBufferFrameCaptured(byte[] bArr, int i, VideoCaptureFormat videoCaptureFormat, long j, int i2);

        void onEncodedFrameCaptured(ByteBuffer byteBuffer, int i, VideoCodecConfig videoCodecConfig, boolean z, double d);

        void onTakeSnapshot(Bitmap bitmap);

        void onTextureCaptured(int i, int i2, int i3, double d);

        void resetTextureContext();

        void setFillMode(int i);

        void setFlipMode(int i);

        void setRotation(int i);

        void setStatusReason(boolean z, int i);

        void setTextureResolution(int i, int i2);

        void setTransformMatrix(float[] fArr);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureDevice$VideoCaptureFormat.class */
    public static class VideoCaptureFormat {
        public int[] strides = {0, 0, 0, 0};
        public int width = 0;
        public int height = 0;
        public int rotation = 0;
        public int pixel_format = 0;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureDevice$VideoCodecConfig.class */
    public static class VideoCodecConfig {
        public int width = 0;
        public int height = 0;
        public int codec_type = 0;
        public int rotation = 0;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureDevice$ZegoVideoCodecType.class */
    public static class ZegoVideoCodecType {
        public static final int ZegoVideoCodecTypeAVCANNEXB = 1;
        public static final int ZegoVideoCodecTypeAVCAVCC = 0;
        public static final int ZegoVideoCodecTypeHEVCANNEXB = 4;
        public static final int ZegoVideoCodecTypeHEVCAVCC = 3;
        public static final int ZegoVideoCodecTypeVP8 = 2;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureDevice$ZegoVideoFlipMode.class */
    public static class ZegoVideoFlipMode {
        public static final int Horizontal = 1;
        public static final int None = 0;
        public static final int Vertical = 2;
    }

    protected abstract void allocateAndStart(Client client);

    protected abstract int enableTorch(boolean z);

    protected abstract int setCaptureRotation(int i);

    protected abstract int setFrameRate(int i);

    protected abstract int setFrontCam(int i);

    protected abstract int setPowerlineFreq(int i);

    protected abstract int setResolution(int i, int i2);

    protected abstract int setView(View view);

    protected abstract int setViewMode(int i);

    protected abstract int setViewRotation(int i);

    protected abstract int startCapture();

    protected abstract int startPreview();

    protected abstract void stopAndDeAllocate();

    protected abstract int stopCapture();

    protected abstract int stopPreview();

    protected abstract int supportBufferType();

    protected abstract int takeSnapshot();
}
