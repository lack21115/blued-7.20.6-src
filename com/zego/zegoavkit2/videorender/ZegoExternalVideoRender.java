package com.zego.zegoavkit2.videorender;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/videorender/ZegoExternalVideoRender.class */
public class ZegoExternalVideoRender {
    public static boolean enableVideoPreview(boolean z, int i) {
        return ZegoExternalVideoRenderJNI.enableVideoPreview(z, i);
    }

    public static boolean enableVideoRender(boolean z, String str) {
        return ZegoExternalVideoRenderJNI.enableVideoRender(z, str);
    }

    public static void setVideoDecodeCallback(IZegoVideoDecodeCallback iZegoVideoDecodeCallback) {
        ZegoExternalVideoRenderJNI.setVideoDecodeCallback(iZegoVideoDecodeCallback);
    }

    public static void setVideoRenderCallback(IZegoVideoRenderCallback iZegoVideoRenderCallback) {
        ZegoExternalVideoRenderJNI.setVideoRenderCallback(iZegoVideoRenderCallback);
    }

    public static void setVideoRenderType(VideoRenderType videoRenderType) {
        ZegoExternalVideoRenderJNI.setVideoRenderType(videoRenderType.value());
    }
}
