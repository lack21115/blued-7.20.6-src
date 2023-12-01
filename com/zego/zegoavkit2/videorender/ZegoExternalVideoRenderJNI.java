package com.zego.zegoavkit2.videorender;

import com.zego.zegoavkit2.entities.EncodedVideoFrame;
import com.zego.zegoavkit2.entities.VideoFrame;
import com.zego.zegoavkit2.enums.VideoCodecType;
import com.zego.zegoavkit2.enums.VideoPixelFormat;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videorender/ZegoExternalVideoRenderJNI.class */
final class ZegoExternalVideoRenderJNI {
    private static volatile IZegoVideoDecodeCallback s_ZegoVideoDecodeCallback;
    private static volatile IZegoVideoRenderCallback s_ZegoVideoRenderCallback;

    ZegoExternalVideoRenderJNI() {
    }

    public static native boolean enableVideoPreview(boolean z, int i);

    public static native boolean enableVideoRender(boolean z, String str);

    public static void onVideoDecodeCallback(ByteBuffer byteBuffer, int i, boolean z, double d, int i2, String str) {
        if (s_ZegoVideoDecodeCallback != null) {
            EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
            encodedVideoFrame.data = byteBuffer;
            encodedVideoFrame.codecType = VideoCodecType.valueOf(i);
            encodedVideoFrame.isKeyFrame = z;
            encodedVideoFrame.reference_time_ms = d;
            encodedVideoFrame.rotation = i2;
            s_ZegoVideoDecodeCallback.onVideoDecodeCallback(encodedVideoFrame, str);
        }
    }

    public static void onVideoRenderCallback(ByteBuffer[] byteBufferArr, int[] iArr, int i, int i2, int i3, String str) {
        if (s_ZegoVideoRenderCallback == null) {
            return;
        }
        VideoFrame videoFrame = new VideoFrame();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= videoFrame.byteBuffers.length) {
                videoFrame.width = i;
                videoFrame.height = i2;
                s_ZegoVideoRenderCallback.onVideoRenderCallback(videoFrame, VideoPixelFormat.valueOf(i3), str);
                return;
            }
            videoFrame.byteBuffers[i5] = byteBufferArr[i5];
            videoFrame.strides[i5] = iArr[i5];
            i4 = i5 + 1;
        }
    }

    public static void setFlipMode(String str, int i) {
        if (s_ZegoVideoRenderCallback != null) {
            s_ZegoVideoRenderCallback.setFlipMode(str, i);
        }
    }

    private static native void setNativeVideoDecodeCallback(boolean z);

    private static native void setNativeVideoRenderCallback(boolean z);

    public static void setRotation(String str, int i) {
        if (s_ZegoVideoRenderCallback != null) {
            s_ZegoVideoRenderCallback.setRotation(str, i);
        }
    }

    public static void setVideoDecodeCallback(IZegoVideoDecodeCallback iZegoVideoDecodeCallback) {
        s_ZegoVideoDecodeCallback = iZegoVideoDecodeCallback;
        setNativeVideoDecodeCallback(iZegoVideoDecodeCallback != null);
    }

    public static void setVideoRenderCallback(IZegoVideoRenderCallback iZegoVideoRenderCallback) {
        s_ZegoVideoRenderCallback = iZegoVideoRenderCallback;
        setNativeVideoRenderCallback(iZegoVideoRenderCallback != null);
    }

    public static native void setVideoRenderType(int i);
}
