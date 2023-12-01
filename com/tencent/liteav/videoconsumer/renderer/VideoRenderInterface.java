package com.tencent.liteav.videoconsumer.renderer;

import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/VideoRenderInterface.class */
public abstract class VideoRenderInterface {
    static VideoRenderInterface create(boolean z) {
        Looper myLooper = Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
        return z ? new com.tencent.liteav.videoconsumer.consumer.a(myLooper) : new g(myLooper, new com.tencent.liteav.videobase.videobase.f());
    }

    static Rotation createRotation(int i) {
        return Rotation.a(i);
    }

    static GLConstants.GLScaleType createScaleType(int i) {
        return GLConstants.GLScaleType.a(i);
    }

    public abstract void renderFrame(PixelFrame pixelFrame);

    public abstract void setDisplayView(DisplayTarget displayTarget, boolean z);

    public abstract void setHorizontalMirror(boolean z);

    public abstract void setRenderRotation(Rotation rotation);

    public abstract void setScaleType(GLConstants.GLScaleType gLScaleType);

    public abstract void setVerticalMirror(boolean z);

    public abstract void start(VideoRenderListener videoRenderListener);

    public abstract void stop(boolean z);

    public abstract void takeSnapshot(TakeSnapshotListener takeSnapshotListener);
}
