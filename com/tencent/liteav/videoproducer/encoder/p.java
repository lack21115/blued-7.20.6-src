package com.tencent.liteav.videoproducer.encoder;

import android.content.ContentResolver;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.bf;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import com.tencent.ugc.UGCTransitionRules;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/p.class */
public final class p implements bf, bf.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f37030a;
    private final IVideoReporter b;
    private final x d;
    private Surface e;
    private com.tencent.liteav.videobase.b.e f;
    private com.tencent.liteav.videobase.frame.j g;
    private VideoEncodeParams h;
    private volatile Handler j;
    private volatile bf.a k;
    private com.tencent.liteav.videobase.b.c l;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.liteav.base.util.n f37031c = new com.tencent.liteav.base.util.n(0, 0);
    private long i = 0;
    private final com.tencent.liteav.videobase.utils.k m = new com.tencent.liteav.videobase.utils.k("hwEn" + hashCode());

    public p(Bundle bundle, IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.d = new x(bundle, iVideoReporter, streamType);
        this.b = iVideoReporter;
        this.f37030a = "HardwareVideoEncoder_" + streamType + BridgeUtil.UNDERLINE_STR + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(p pVar) {
        bf.a aVar = pVar.k;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(p pVar, MediaFormat mediaFormat) {
        bf.a aVar = pVar.k;
        if (aVar != null) {
            aVar.onOutputFormatChanged(mediaFormat);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(p pVar, EncodedVideoFrame encodedVideoFrame, boolean z) {
        bf.a aVar = pVar.k;
        if (aVar != null) {
            aVar.onEncodedNAL(encodedVideoFrame, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(p pVar, h.a aVar) {
        bf.a aVar2 = pVar.k;
        if (aVar2 != null) {
            aVar2.onEncodedFail(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(p pVar, String str) {
        bf.a aVar = pVar.k;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    private void a(Runnable runnable) {
        Handler handler = this.j;
        if (handler != null) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    private boolean a(Object obj, Surface surface) {
        if (surface == null) {
            LiteavLog.w(this.f37030a, "init opengl: surface is null.");
            return false;
        }
        LiteavLog.d(this.f37030a, "initOpenGLComponents");
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.f = eVar;
        try {
            eVar.a(obj, surface, this.f37031c.f36340a, this.f37031c.b);
            this.m.a((com.tencent.liteav.videobase.frame.e) null);
            this.m.a(this.f37031c.f36340a, this.f37031c.b);
            this.g = new com.tencent.liteav.videobase.frame.j(this.f37031c.f36340a, this.f37031c.b);
            return true;
        } catch (com.tencent.liteav.videobase.b.g e) {
            IVideoReporter iVideoReporter = this.b;
            h.c cVar = h.c.WARNING_VIDEO_ENCODE_EGL_CORE_CREATE_FAILED;
            iVideoReporter.notifyWarning(cVar, "VideoEncode: create EGLCore failed, EGLCode:" + e.mErrorCode + " message:" + e.getMessage(), new Object[0]);
            this.d.a(e.getMessage());
            LiteavLog.e(this.f37030a, "create EGLCore failed.", e);
            this.f = null;
            return false;
        }
    }

    private void b() {
        if (this.f == null) {
            return;
        }
        LiteavLog.d(this.f37030a, "uninitOpenGLComponents");
        try {
            this.f.a();
            if (this.g != null) {
                this.g.a();
                this.g = null;
            }
            this.m.a();
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(this.f37030a, "makeCurrent failed.", e);
        }
        com.tencent.liteav.videobase.b.e.a(this.f);
        this.f = null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf.a
    public final void a() {
        a(q.a(this));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf.a
    public final void a(String str) {
        a(r.a(this, str));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf.a
    public final void a(boolean z, int i) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void ackRPSRecvFrameIndex(int i, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2 A[Catch: g -> 0x016a, TryCatch #0 {g -> 0x016a, blocks: (B:20:0x005e, B:22:0x0077, B:25:0x0084, B:28:0x008e, B:35:0x00a9, B:37:0x00c2, B:39:0x00cf, B:41:0x00e5, B:43:0x011f, B:45:0x0140, B:47:0x014b, B:49:0x0163, B:29:0x0096, B:33:0x00a3), top: B:56:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5 A[Catch: g -> 0x016a, TryCatch #0 {g -> 0x016a, blocks: (B:20:0x005e, B:22:0x0077, B:25:0x0084, B:28:0x008e, B:35:0x00a9, B:37:0x00c2, B:39:0x00cf, B:41:0x00e5, B:43:0x011f, B:45:0x0140, B:47:0x014b, B:49:0x0163, B:29:0x0096, B:33:0x00a3), top: B:56:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0140 A[Catch: g -> 0x016a, TryCatch #0 {g -> 0x016a, blocks: (B:20:0x005e, B:22:0x0077, B:25:0x0084, B:28:0x008e, B:35:0x00a9, B:37:0x00c2, B:39:0x00cf, B:41:0x00e5, B:43:0x011f, B:45:0x0140, B:47:0x014b, B:49:0x0163, B:29:0x0096, B:33:0x00a3), top: B:56:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01cb  */
    @Override // com.tencent.liteav.videoproducer.encoder.bf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void encodeFrame(com.tencent.liteav.videobase.frame.PixelFrame r6) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.p.encodeFrame(com.tencent.liteav.videobase.frame.PixelFrame):void");
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final VideoEncodeParams getEncodeParams() {
        return new VideoEncodeParams(this.h);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final VideoEncoderDef.a getEncoderType() {
        return VideoEncoderDef.a.HARDWARE;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void initialize() {
        LiteavLog.d(this.f37030a, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        this.j = new Handler(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.l = new com.tencent.liteav.videobase.b.c(this.j.getLooper());
        x xVar = this.d;
        LiteavLog.d(xVar.f37043a, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        HandlerThread handlerThread = new HandlerThread("hw-video-encoder");
        handlerThread.start();
        xVar.f37044c = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public final void onEncodedFail(h.a aVar) {
        a(u.a(this, aVar));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z) {
        a(t.a(this, encodedVideoFrame, z));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public final void onOutputFormatChanged(MediaFormat mediaFormat) {
        a(s.a(this, mediaFormat));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void restartIDRFrame() {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void setBitrate(int i) {
        LiteavLog.i(this.f37030a, "SetBitrate ".concat(String.valueOf(i)));
        VideoEncodeParams videoEncodeParams = this.h;
        if (videoEncodeParams != null) {
            videoEncodeParams.bitrate = i;
        }
        x xVar = this.d;
        xVar.f37044c.post(ae.a(xVar, i));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void setFps(int i) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void setRPSIFrameFPS(int i) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void setRPSNearestREFSize(int i) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
        x xVar = this.d;
        xVar.f37044c.post(ab.a(xVar, serverVideoProducerConfig));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void signalEndOfStream() {
        x xVar = this.d;
        xVar.f37044c.post(af.a(xVar));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final boolean start(VideoEncodeParams videoEncodeParams, bf.a aVar) {
        if (this.e != null) {
            LiteavLog.e(this.f37030a, "Encoder has started");
            return false;
        }
        LiteavLog.i(this.f37030a, "Start hw video encoder. %s", videoEncodeParams);
        this.k = aVar;
        x xVar = this.d;
        LiteavLog.d(xVar.f37043a, "start");
        Surface[] surfaceArr = new Surface[1];
        LiteavLog.i(xVar.f37043a, "startCodecInternal success: ".concat(String.valueOf(xVar.f37044c.a(ac.a(xVar, this, surfaceArr, videoEncodeParams), 5000L))));
        com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n(UGCTransitionRules.DEFAULT_IMAGE_WIDTH, 1280);
        if (xVar.f != null) {
            nVar.a(xVar.f.width, xVar.f.height);
        }
        Pair pair = new Pair(surfaceArr[0], nVar);
        this.e = (Surface) pair.first;
        this.f37031c.a((com.tencent.liteav.base.util.n) pair.second);
        this.h = new VideoEncodeParams(videoEncodeParams);
        return this.e != null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void stop() {
        LiteavLog.d(this.f37030a, "stop");
        b();
        Surface surface = this.e;
        if (surface != null) {
            surface.release();
            this.e = null;
        }
        x xVar = this.d;
        LiteavLog.d(xVar.f37043a, "stop");
        xVar.f37044c.post(ah.a(xVar));
        this.k = null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void takeSnapshot(TakeSnapshotListener takeSnapshotListener) {
        this.m.f36662a = takeSnapshotListener;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public final void uninitialize() {
        LiteavLog.d(this.f37030a, "uninitialize");
        x xVar = this.d;
        LiteavLog.d(xVar.f37043a, "uninitialize");
        xVar.f37044c.a();
        com.tencent.liteav.videobase.b.c cVar = this.l;
        cVar.f36591a.post(com.tencent.liteav.videobase.b.d.a(cVar));
        this.j = null;
    }
}
