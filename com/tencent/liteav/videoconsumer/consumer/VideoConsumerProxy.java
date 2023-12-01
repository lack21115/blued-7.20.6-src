package com.tencent.liteav.videoconsumer.consumer;

import android.content.ContentResolver;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.b;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/VideoConsumerProxy.class */
public class VideoConsumerProxy {
    private final j mConsumer;

    public VideoConsumerProxy(IVideoReporter iVideoReporter) {
        this.mConsumer = new j(iVideoReporter);
    }

    public static VideoDecoderDef.DecodeAbility getDecodeAbility() {
        com.tencent.liteav.videoconsumer.decoder.b bVar;
        bVar = b.a.f23086a;
        return bVar.f23085a;
    }

    public void appendNALPacket(EncodedVideoFrame encodedVideoFrame) {
        j jVar = this.mConsumer;
        if (encodedVideoFrame == null || encodedVideoFrame.data == null) {
            LiteavLog.w(jVar.f23014a, "packet or packet.data is null,packet={%s}", encodedVideoFrame);
        } else {
            jVar.a(aa.a(jVar, encodedVideoFrame), "appendNALPacket", false);
        }
    }

    public long getCurrentRenderTimeStamp() {
        return this.mConsumer.v.get();
    }

    public void initialize() {
        j jVar = this.mConsumer;
        synchronized (jVar) {
            if (jVar.b != null) {
                LiteavLog.w(jVar.f23014a, "videoConsumer is initialized!");
                return;
            }
            LiteavLog.i(jVar.f23014a, "initialize videoConsumer");
            HandlerThread handlerThread = new HandlerThread("VideoConsumer_" + jVar.hashCode());
            handlerThread.start();
            jVar.b = new com.tencent.liteav.base.util.b(handlerThread.getLooper(), t.a(jVar));
            jVar.a(v.a(jVar), ContentResolver.SYNC_EXTRAS_INITIALIZE, false);
        }
    }

    public void pause() {
        j jVar = this.mConsumer;
        jVar.a(y.a(jVar), com.anythink.expressad.foundation.d.c.cb, false);
    }

    public void resume() {
        j jVar = this.mConsumer;
        jVar.a(z.a(jVar), "resume", false);
    }

    public void setCustomRenderListener(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        j jVar = this.mConsumer;
        jVar.a(r.a(jVar, pixelFormatType, pixelBufferType, videoRenderListener), "setCustomRenderListener", false);
    }

    public void setDecoderStrategy(VideoDecodeController.DecodeStrategy decodeStrategy) {
        j jVar = this.mConsumer;
        jVar.a(n.a(jVar, decodeStrategy), "setDecoderType", true);
    }

    public void setDisplayTarget(DisplayTarget displayTarget, boolean z) {
        j jVar = this.mConsumer;
        jVar.a(o.a(jVar, displayTarget, z), "setDisplayTarget", true);
    }

    public void setHWDecoderDeviceRelatedParams(String str) {
        j jVar = this.mConsumer;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        jVar.a(q.a(jVar, str), "setHWDecoderDeviceRelatedParams", true);
    }

    public void setRenderMirrorEnabled(boolean z) {
        j jVar = this.mConsumer;
        jVar.a(ac.a(jVar, z), "setRenderMirrorEnabled", true);
    }

    public void setRenderRotation(Rotation rotation) {
        j jVar = this.mConsumer;
        jVar.a(l.a(jVar, rotation), "setRenderRotation", true);
    }

    public void setScaleType(GLConstants.GLScaleType gLScaleType) {
        j jVar = this.mConsumer;
        jVar.a(m.a(jVar, gLScaleType), "setScaleType", true);
    }

    public void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
        j jVar = this.mConsumer;
        jVar.a(ab.a(jVar, consumerScene), "setScene", false);
    }

    public void setServerConfig(ServerVideoConsumerConfig serverVideoConsumerConfig) {
        j jVar = this.mConsumer;
        jVar.a(u.a(jVar, serverVideoConsumerConfig), "setServerConfig", true);
    }

    public void setSharedEGLContext(Object obj) {
        j jVar = this.mConsumer;
        String str = jVar.f23014a;
        LiteavLog.i(str, "setSharedEGLContext(object:" + obj + ")");
        jVar.a(s.a(jVar, obj), "setSharedEGLContext", false);
    }

    public void start() {
        j jVar = this.mConsumer;
        jVar.a(w.a(jVar), "Start", false);
    }

    public void stop(boolean z) {
        this.mConsumer.a(z);
    }

    public void takeSnapshot(SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        j jVar = this.mConsumer;
        jVar.a(p.a(jVar, snapshotSourceType, takeSnapshotListener), "takeSnapshot", false);
    }

    public void uninitialize() {
        final j jVar = this.mConsumer;
        jVar.a(false);
        jVar.a(new Runnable() { // from class: com.tencent.liteav.videoconsumer.consumer.j.5
            @Override // java.lang.Runnable
            public final void run() {
                LiteavLog.i(jVar.f23014a, "uninitialize videoConsumer");
                if (jVar.d != null) {
                    jVar.d.setDisplayView(null, false);
                    jVar.d = null;
                }
                jVar.e = null;
                if (jVar.f != null) {
                    jVar.f.i();
                    jVar.f = null;
                }
                jVar.u = null;
                jVar.i = null;
                jVar.g = null;
                jVar.h = null;
                synchronized (this) {
                    if (jVar.b != null) {
                        jVar.b.a();
                        jVar.b = null;
                    }
                }
            }
        }, "uninitialize", false);
    }
}
