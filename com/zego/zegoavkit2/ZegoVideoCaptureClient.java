package com.zego.zegoavkit2;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import com.zego.zegoavkit2.ZegoVideoCaptureDevice;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/ZegoVideoCaptureClient.class */
public class ZegoVideoCaptureClient implements ZegoVideoCaptureDevice.Client {
    private long pthis = 0;

    private static native void destroy(long j);

    private static native SurfaceTexture get_surface_texture(long j);

    private static native int on_byte_array_frame_captured(long j, byte[] bArr, int i, int i2, int i3, int[] iArr, int i4, int i5, long j2, int i6);

    private static native int on_byte_buffer_frame_captured(long j, ByteBuffer byteBuffer, int i, int i2, int i3, int[] iArr, int i4, int i5, long j2, int i6);

    private static native int on_encoded_frame_captured(long j, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, boolean z, double d);

    private static native int on_take_snapshot(long j, Bitmap bitmap);

    private static native int on_texture_captured(long j, int i, int i2, int i3, double d);

    private static native void reset_texture_context(long j);

    private int setThis(long j) {
        this.pthis = j;
        return 0;
    }

    private static native void set_fill_mode(long j, int i);

    private static native void set_flip_mode(long j, int i);

    private static native void set_rotation(long j, int i);

    private static native void set_status_reason(long j, boolean z, int i);

    private static native void set_texture_resolution(long j, int i, int i2);

    private static native void set_transform_matrix(long j, float[] fArr);

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void destroy() {
        destroy(this.pthis);
        this.pthis = 0L;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public SurfaceTexture getSurfaceTexture() {
        long j = this.pthis;
        if (j != 0) {
            return get_surface_texture(j);
        }
        return null;
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onByteBufferFrameCaptured(ByteBuffer byteBuffer, int i, ZegoVideoCaptureDevice.VideoCaptureFormat videoCaptureFormat, long j, int i2) {
        long j2 = this.pthis;
        if (j2 != 0) {
            on_byte_buffer_frame_captured(j2, byteBuffer, i, videoCaptureFormat.width, videoCaptureFormat.height, videoCaptureFormat.strides, videoCaptureFormat.rotation, videoCaptureFormat.pixel_format, j, i2);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onByteBufferFrameCaptured(byte[] bArr, int i, ZegoVideoCaptureDevice.VideoCaptureFormat videoCaptureFormat, long j, int i2) {
        long j2 = this.pthis;
        if (j2 != 0) {
            on_byte_array_frame_captured(j2, bArr, i, videoCaptureFormat.width, videoCaptureFormat.height, videoCaptureFormat.strides, videoCaptureFormat.rotation, videoCaptureFormat.pixel_format, j, i2);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onEncodedFrameCaptured(ByteBuffer byteBuffer, int i, ZegoVideoCaptureDevice.VideoCodecConfig videoCodecConfig, boolean z, double d) {
        long j = this.pthis;
        if (j != 0) {
            on_encoded_frame_captured(j, byteBuffer, i, videoCodecConfig.width, videoCodecConfig.height, videoCodecConfig.codec_type, videoCodecConfig.rotation, z, d);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onTakeSnapshot(Bitmap bitmap) {
        long j = this.pthis;
        if (j != 0) {
            on_take_snapshot(j, bitmap);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void onTextureCaptured(int i, int i2, int i3, double d) {
        long j = this.pthis;
        if (j != 0) {
            on_texture_captured(j, i, i2, i3, d);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void resetTextureContext() {
        long j = this.pthis;
        if (j != 0) {
            reset_texture_context(j);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setFillMode(int i) {
        long j = this.pthis;
        if (j != 0) {
            set_fill_mode(j, i);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setFlipMode(int i) {
        long j = this.pthis;
        if (j != 0) {
            set_flip_mode(j, i);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setRotation(int i) {
        long j = this.pthis;
        if (j != 0) {
            set_rotation(j, i);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setStatusReason(boolean z, int i) {
        long j = this.pthis;
        if (j != 0) {
            set_status_reason(j, z, i);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setTextureResolution(int i, int i2) {
        long j = this.pthis;
        if (j != 0) {
            set_texture_resolution(j, i, i2);
        }
    }

    @Override // com.zego.zegoavkit2.ZegoVideoCaptureDevice.Client
    public void setTransformMatrix(float[] fArr) {
        long j = this.pthis;
        if (j != 0) {
            set_transform_matrix(j, fArr);
        }
    }
}
