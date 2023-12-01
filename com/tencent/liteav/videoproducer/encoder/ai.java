package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.a;
import com.tencent.liteav.videoproducer.encoder.bf;
import com.tencent.liteav.videoproducer.encoder.c;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ai.class */
public final class ai implements r.a, bf.a {
    private static final PixelFrame b = new PixelFrame();

    /* renamed from: a  reason: collision with root package name */
    private final String f23287a;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.liteav.videobase.utils.h f23288c;
    private com.tencent.liteav.base.util.b f;
    private com.tencent.liteav.base.util.r g;
    private bf h;
    private VideoEncoderDef.VideoEncoderDataListener i;
    private ServerVideoProducerConfig m;
    private long n;
    private long o;
    private long p;
    private final IVideoReporter u;
    private final c v;
    private final com.tencent.liteav.videobase.utils.f w;
    private final be x;
    private final VideoProducerDef.StreamType y;
    private final boolean z;
    private final Bundle d = new Bundle();
    private boolean e = false;
    private Rotation j = Rotation.NORMAL;
    private Rotation k = Rotation.NORMAL;
    private boolean l = false;
    private long q = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videoproducer.encoder.ai$2  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ai$2.class */
    public static final /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23290a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[c.d.values().length];
            f23290a = iArr;
            try {
                iArr[c.d.CONTINUE_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23290a[c.d.RESTART_ENCODER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23290a[c.d.USE_HARDWARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23290a[c.d.USE_SOFTWARE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23290a[c.d.REPORT_ENCODE_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public ai(IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType, boolean z) {
        a unused;
        a unused2;
        this.f23287a = "VideoEncodeController_" + streamType + "_" + hashCode();
        this.u = iVideoReporter;
        unused = a.C0771a.f23277a;
        boolean a2 = a.a();
        unused2 = a.C0771a.f23277a;
        this.v = new c(a2, this.u, streamType);
        this.w = new com.tencent.liteav.videobase.utils.f("VideoEncodeController", 2000, new f.a(this) { // from class: com.tencent.liteav.videoproducer.encoder.aj

            /* renamed from: a  reason: collision with root package name */
            private final ai f23291a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f23291a = this;
            }

            @Override // com.tencent.liteav.videobase.utils.f.a
            public final void a(double d) {
                LiteavLog.i(this.f23291a.f23287a, "encoder input fps: ".concat(String.valueOf(d)));
            }
        });
        this.x = new be(iVideoReporter, streamType);
        this.y = streamType;
        this.z = z;
        this.f23288c = z ? new com.tencent.liteav.videobase.utils.b() : new com.tencent.liteav.videobase.utils.j(2);
    }

    private void a(long j, long j2) {
        this.o = j;
        this.p = j2;
    }

    private void a(VideoEncoderDef.a aVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VideoEncoderDef.a k = k();
        CodecType l = l();
        VideoEncoderDef.ReferenceStrategy m = m();
        j();
        ServerVideoProducerConfig serverVideoProducerConfig = this.m;
        if ((serverVideoProducerConfig == null || serverVideoProducerConfig.isHardwareEncoderAllowed()) && VideoEncoderDef.a.HARDWARE == aVar) {
            this.h = new p(this.d, this.u, this.y);
            LiteavLog.i(this.f23287a, "create HardwareVideoEncoder");
        } else {
            this.h = new SoftwareVideoEncoder(this.u, this.y);
            LiteavLog.i(this.f23287a, "create SoftwareVideoEncoder");
        }
        this.h.initialize();
        this.h.setServerConfig(this.m);
        VideoEncodeParams b2 = this.v.b();
        b2.baseGopIndex = this.p + 1;
        b2.baseFrameIndex = this.o + 20;
        if (this.h.start(b2, this)) {
            this.u.notifyEvent(h.b.EVT_VIDEO_ENCODE_START_SUCCESS, "start encoder success.", new Object[0]);
        } else {
            this.v.h = true;
        }
        if (aVar != k || b2.codecType != l || b2.referenceStrategy != m) {
            this.u.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_TYPE, this.y.mValue, new VideoEncoderDef.EncoderProperty(aVar, b2.isEnablesRps() ? VideoEncoderDef.ReferenceStrategy.RPS : VideoEncoderDef.ReferenceStrategy.FIX_GOP, b2.codecType));
        }
        String str = this.f23287a;
        LiteavLog.i(str, "open encoder cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, int i) {
        bf bfVar = aiVar.h;
        if (bfVar != null) {
            bfVar.setRPSNearestREFSize(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, int i, int i2) {
        bf bfVar = aiVar.h;
        if (bfVar != null) {
            bfVar.ackRPSRecvFrameIndex(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, TakeSnapshotListener takeSnapshotListener) {
        bf bfVar = aiVar.h;
        if (bfVar != null) {
            bfVar.takeSnapshot(takeSnapshotListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, Rotation rotation) {
        LiteavLog.i(aiVar.f23287a, "setEncodeRotation: ".concat(String.valueOf(rotation)));
        if (rotation == null) {
            return;
        }
        aiVar.k = rotation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, h.a aVar) {
        LiteavLog.i(aiVar.f23287a, "onEncodedFail: ".concat(String.valueOf(aVar)));
        aiVar.u.notifyError(h.a.ERR_VIDEO_ENCODE_FATALERROR, "encode fail:".concat(String.valueOf(aVar)), new Object[0]);
        VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener = aiVar.i;
        if (videoEncoderDataListener != null) {
            videoEncoderDataListener.onEncodedFail(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, VideoEncodeParams videoEncodeParams) {
        LiteavLog.i(aiVar.f23287a, "reconfig: ".concat(String.valueOf(videoEncodeParams)));
        if (videoEncodeParams != null) {
            VideoEncodeParams b2 = aiVar.v.b();
            aiVar.v.a(videoEncodeParams);
            VideoEncodeParams b3 = aiVar.v.b();
            bf bfVar = aiVar.h;
            if (bfVar != null) {
                bfVar.setFps(b3.fps);
                aiVar.h.setBitrate(b3.bitrate);
                if (!aiVar.g() || b3.fps == b2.fps) {
                    return;
                }
                aiVar.o();
                aiVar.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        if (videoEncodeParams == null || videoEncodeParams.width == 0 || videoEncodeParams.height == 0 || videoEncodeParams.fps == 0 || videoEncodeParams.gop == 0 || videoEncodeParams.bitrate == 0) {
            LiteavLog.e(aiVar.f23287a, "invalid params, Start failed.");
            return;
        }
        aiVar.i = videoEncoderDataListener;
        aiVar.v.a(videoEncodeParams);
        aiVar.a(videoEncodeParams.baseFrameIndex, videoEncodeParams.baseGopIndex);
        if (aiVar.g()) {
            aiVar.n();
        } else {
            aiVar.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        a aVar;
        a aVar2;
        LiteavLog.i(aiVar.f23287a, "setEncodeStrategy ".concat(String.valueOf(encodeStrategy)));
        if (encodeStrategy == null) {
            return;
        }
        c cVar = aiVar.v;
        LiteavLog.i(cVar.f23319a, "strategy = ".concat(String.valueOf(encodeStrategy)));
        if (cVar.j != encodeStrategy) {
            cVar.j = encodeStrategy;
            cVar.k = null;
            boolean z = cVar.j != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY;
            aVar = a.C0771a.f23277a;
            aVar.f23276a.f23264a = z;
            IVideoReporter iVideoReporter = cVar.q;
            com.tencent.liteav.videobase.videobase.i iVar = com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_ABILITY;
            int i = cVar.r.mValue;
            aVar2 = a.C0771a.f23277a;
            iVideoReporter.updateStatus(iVar, i, aVar2.f23276a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, String str) {
        LiteavLog.i(aiVar.f23287a, "onEncodeError: ".concat(String.valueOf(str)));
        aiVar.v.h = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, boolean z, int i) {
        c cVar = aiVar.v;
        cVar.s = z;
        cVar.t = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ai aiVar, boolean z, EncodedVideoFrame encodedVideoFrame) {
        boolean z2 = true;
        if (!aiVar.s) {
            aiVar.s = true;
            LiteavLog.i(aiVar.f23287a, "encode first frame cost time: " + (SystemClock.elapsedRealtime() - aiVar.q));
        }
        if (z) {
            LiteavLog.i(aiVar.f23287a, "got eos");
        } else {
            aiVar.a(encodedVideoFrame.frameIndex, encodedVideoFrame.gopIndex);
            c cVar = aiVar.v;
            if (encodedVideoFrame != null) {
                cVar.b++;
            }
            w wVar = cVar.u;
            if (encodedVideoFrame == null || encodedVideoFrame.data == null) {
                LiteavLog.w(wVar.f23350a, "encodedVideoFrame is null.");
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime <= wVar.f23351c + wVar.i) {
                    wVar.d++;
                } else {
                    wVar.b = (wVar.d * 1000.0d) / (elapsedRealtime - wVar.f23351c);
                    wVar.d = 1L;
                    wVar.f23351c = elapsedRealtime;
                    if (wVar.h != null) {
                        wVar.h.a(wVar.b);
                    }
                }
                if (encodedVideoFrame.nalType != com.tencent.liteav.videobase.common.a.IDR) {
                    z2 = false;
                }
                long remaining = encodedVideoFrame.data.remaining();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                if (z2 && elapsedRealtime2 > wVar.f + wVar.j) {
                    wVar.e = (long) (((wVar.g * 8000.0d) / (elapsedRealtime2 - wVar.f)) / 1024.0d);
                    wVar.g = 0L;
                    wVar.f = elapsedRealtime2;
                    if (wVar.h != null) {
                        wVar.h.a(wVar.e);
                    }
                }
                wVar.g += remaining;
            }
            be beVar = aiVar.x;
            if (encodedVideoFrame != null && beVar.f23318c.containsKey(Long.valueOf(encodedVideoFrame.dts))) {
                long elapsedRealtime3 = SystemClock.elapsedRealtime() - beVar.f23318c.remove(Long.valueOf(encodedVideoFrame.dts)).longValue();
                beVar.e++;
                beVar.d += elapsedRealtime3;
                beVar.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_COST, Long.valueOf(elapsedRealtime3));
            }
        }
        VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener = aiVar.i;
        if (videoEncoderDataListener != null) {
            videoEncoderDataListener.onEncodedNAL(encodedVideoFrame, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ VideoEncodeParams b(ai aiVar) throws Exception {
        return new VideoEncodeParams(aiVar.v.b());
    }

    private void b(PixelFrame pixelFrame) {
        if (pixelFrame == b) {
            bf bfVar = this.h;
            if (bfVar != null) {
                bfVar.signalEndOfStream();
                return;
            }
            return;
        }
        bf bfVar2 = this.h;
        if (bfVar2 != null) {
            bfVar2.encodeFrame(c(pixelFrame));
        }
        if (pixelFrame != null) {
            pixelFrame.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ai aiVar, int i) {
        bf bfVar = aiVar.h;
        if (bfVar != null) {
            bfVar.setRPSIFrameFPS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(ai aiVar, Rotation rotation) {
        LiteavLog.i(aiVar.f23287a, "setCaptureRotation: ".concat(String.valueOf(rotation)));
        if (rotation == null) {
            return;
        }
        aiVar.j = rotation;
    }

    private PixelFrame c(PixelFrame pixelFrame) {
        PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
        pixelFrame2.postRotate(this.j);
        pixelFrame2.postRotate(this.k);
        if (this.l) {
            if (this.j == Rotation.ROTATION_90 || this.j == Rotation.ROTATION_270) {
                pixelFrame2.setMirrorVertical(!pixelFrame2.isMirrorVertical());
                return pixelFrame2;
            }
            pixelFrame2.setMirrorHorizontal(!pixelFrame2.isMirrorHorizontal());
            return pixelFrame2;
        }
        return pixelFrame2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(ai aiVar) {
        bf bfVar = aiVar.h;
        if (bfVar != null) {
            bfVar.restartIDRFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(ai aiVar) {
        LiteavLog.d(aiVar.f23287a, "stop");
        aiVar.o();
        aiVar.j();
        aiVar.f23288c.b();
        aiVar.r = false;
        aiVar.s = false;
        aiVar.w.b();
        c cVar = aiVar.v;
        cVar.c();
        cVar.o = null;
        cVar.p = null;
        cVar.f23320c = 0L;
        cVar.d = 0.0f;
        cVar.e = 0.0f;
        cVar.f = 0.0f;
        cVar.g = 0.0d;
        cVar.h = false;
        cVar.j = VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE;
        cVar.i = false;
        cVar.k = null;
        cVar.l = c.e.NONE;
        cVar.m = 0;
        cVar.n = 0;
        cVar.s = false;
        cVar.t = 0;
        be beVar = aiVar.x;
        beVar.f23318c.clear();
        beVar.e = 0L;
        beVar.d = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(ai aiVar) {
        if (!aiVar.r) {
            LiteavLog.i(aiVar.f23287a, "encoder receive first frame");
            aiVar.q = SystemClock.elapsedRealtime();
            if (aiVar.g()) {
                aiVar.n();
            }
            aiVar.r = true;
        }
        aiVar.w.a();
    }

    private boolean g() {
        return !this.z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        PixelFrame a2 = this.f23288c.a();
        if (a2 == null) {
            return;
        }
        be beVar = this.x;
        if (beVar.f == null) {
            beVar.f = new com.tencent.liteav.base.util.r(Looper.myLooper(), beVar);
            beVar.f.a(0, 1000);
        }
        if (beVar.f23318c.containsKey(Long.valueOf(a2.getTimestamp()))) {
            String str = beVar.f23317a;
            LiteavLog.i(str, "Duplicate timestamp!" + a2.getTimestamp());
        }
        beVar.f23318c.put(Long.valueOf(a2.getTimestamp()), Long.valueOf(SystemClock.elapsedRealtime()));
        int i = AnonymousClass2.f23290a[this.v.a(a2).ordinal()];
        if (i == 1) {
            b(a2);
        } else if (i == 2) {
            i();
            b(a2);
        } else if (i == 3) {
            a(VideoEncoderDef.a.HARDWARE);
            b(a2);
        } else if (i == 4) {
            a(VideoEncoderDef.a.SOFTWARE);
            b(a2);
        } else if (i != 5) {
            if (a2 != b) {
                a2.release();
            }
            LiteavLog.i(this.f23287a, "encode ask instruction return default.");
        } else {
            if (a2 != b) {
                be beVar2 = this.x;
                if (a2 != null && beVar2.f23318c.containsKey(Long.valueOf(a2.getTimestamp()))) {
                    beVar2.f23318c.remove(Long.valueOf(a2.getTimestamp()));
                }
                a2.release();
            }
            onEncodedFail(h.a.ERR_VIDEO_ENCODE_FAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        VideoEncoderDef.a k = k();
        if (k != null) {
            a(k);
        }
    }

    private void j() {
        bf bfVar = this.h;
        if (bfVar != null) {
            bfVar.stop();
            this.h.uninitialize();
            this.h = null;
            this.u.notifyEvent(h.b.EVT_VIDEO_ENCODE_STOP_SUCCESS, "stop encoder success", new Object[0]);
        }
    }

    static /* synthetic */ boolean j(ai aiVar) {
        aiVar.t = false;
        return false;
    }

    static /* synthetic */ com.tencent.liteav.base.util.b k(ai aiVar) {
        aiVar.f = null;
        return null;
    }

    private VideoEncoderDef.a k() {
        bf bfVar = this.h;
        if (bfVar == null) {
            return null;
        }
        return bfVar.getEncoderType();
    }

    private CodecType l() {
        bf bfVar = this.h;
        if (bfVar == null) {
            return null;
        }
        return bfVar.getEncodeParams().codecType;
    }

    private VideoEncoderDef.ReferenceStrategy m() {
        bf bfVar = this.h;
        if (bfVar == null) {
            return null;
        }
        return bfVar.getEncodeParams().referenceStrategy;
    }

    private void n() {
        com.tencent.liteav.base.util.b bVar;
        if (this.g != null) {
            LiteavLog.i(this.f23287a, "timer is not null before start.");
            return;
        }
        synchronized (this) {
            bVar = this.f;
        }
        if (bVar == null) {
            LiteavLog.i(this.f23287a, "startInternal handler is null.");
            return;
        }
        com.tencent.liteav.base.util.r rVar = new com.tencent.liteav.base.util.r(bVar.getLooper(), this);
        this.g = rVar;
        rVar.a(0, 15);
        VideoEncodeParams b2 = this.v.b();
        if (b2.fps != 0) {
            this.n = SystemClock.elapsedRealtime() + (TimeUnit.SECONDS.toMillis(1L) / b2.fps);
        } else {
            this.n = SystemClock.elapsedRealtime() + (TimeUnit.SECONDS.toMillis(1L) / 20);
        }
    }

    private void o() {
        com.tencent.liteav.base.util.r rVar = this.g;
        if (rVar != null) {
            rVar.a();
            this.g = null;
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf.a
    public final void a() {
        LiteavLog.i(this.f23287a, "onRequestRestart");
        a(ar.a(this), "restartEncoder");
    }

    public final void a(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        if (pixelFrame.getGLContext() != null) {
            GLES20.glFinish();
        }
        a(az.a(this), "");
        if (this.e) {
            return;
        }
        this.f23288c.a(pixelFrame);
        if (g()) {
            return;
        }
        a(ba.a(this), "encodeFrameInternal");
    }

    public final void a(Rotation rotation) {
        a(bd.a(this, rotation), "setCameraRotation");
    }

    public final void a(VideoEncodeParams videoEncodeParams) {
        a(ap.a(this, videoEncodeParams), "reconfig");
    }

    public final void a(VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        a(ay.a(this, videoEncodeParams, videoEncoderDataListener), "Start");
    }

    public final void a(VideoEncoderDef.EncodeStrategy encodeStrategy) {
        a(bc.a(this, encodeStrategy), "setEncodeStrategy");
    }

    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        a(ax.a(this, serverVideoProducerConfig), "setServerConfig");
    }

    public final void a(Runnable runnable, String str) {
        synchronized (this) {
            if (!this.t) {
                LiteavLog.w(this.f23287a, "runOnEncodeThread before initialize! ".concat(String.valueOf(str)));
                return;
            }
            com.tencent.liteav.base.util.b bVar = this.f;
            if (bVar == null) {
                LiteavLog.w(this.f23287a, "ignore runnable: ".concat(String.valueOf(str)));
            } else if (Looper.myLooper() == bVar.getLooper()) {
                runnable.run();
            } else {
                bVar.post(runnable);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf.a
    public final void a(String str) {
        a(as.a(this, str), "onEncodeError");
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf.a
    public final void a(boolean z, int i) {
        a(au.a(this, z, i), "onRpsFrameRateChanged");
    }

    @Override // com.tencent.liteav.base.util.r.a
    public final void a_() {
        VideoEncodeParams b2;
        if (SystemClock.elapsedRealtime() < this.n) {
            return;
        }
        if (this.v.b().fps == 0) {
            LiteavLog.w(this.f23287a, "onTimeout: encode param is null.");
            return;
        }
        this.n += TimeUnit.SECONDS.toMillis(1L) / b2.fps;
        h();
    }

    public final void b() {
        synchronized (this) {
            if (this.t) {
                LiteavLog.i(this.f23287a, "already initialzied");
                return;
            }
            LiteavLog.i(this.f23287a, "initialzie");
            HandlerThread handlerThread = new HandlerThread("video-encoder");
            handlerThread.start();
            this.f = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
            this.t = true;
        }
    }

    public final void b(Rotation rotation) {
        a(ak.a(this, rotation), "setEncodeRotation");
    }

    public final void c() {
        a(new Runnable() { // from class: com.tencent.liteav.videoproducer.encoder.ai.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (this) {
                    if (!ai.this.t) {
                        LiteavLog.i(ai.this.f23287a, "not initialized.");
                        return;
                    }
                    LiteavLog.d(ai.this.f23287a, "uninitialize");
                    com.tencent.liteav.base.util.b bVar = ai.this.f;
                    ai.j(ai.this);
                    ai.k(ai.this);
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        }, "uninitialize");
    }

    public final void d() {
        this.e = true;
        this.f23288c.a(b);
    }

    public final void e() {
        a(bb.a(this), "Stop");
    }

    public final VideoEncodeParams f() {
        VideoEncodeParams b2;
        FutureTask futureTask = new FutureTask(aq.a(this));
        a(futureTask, "getEncodeParams");
        try {
            b2 = (VideoEncodeParams) futureTask.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            if (e instanceof TimeoutException) {
                LiteavLog.w(this.f23287a, "getEncodeParams future task timeout:".concat(String.valueOf(e)));
            } else {
                LiteavLog.w(this.f23287a, "getEncodeParams future task error: ".concat(String.valueOf(e)));
            }
            synchronized (this) {
                b2 = this.v.b();
            }
        }
        if (b2 != null) {
            return new VideoEncodeParams(b2);
        }
        return null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public final void onEncodedFail(h.a aVar) {
        a(aw.a(this, aVar), "onEncodedFail");
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public final void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z) {
        if (encodedVideoFrame == null) {
            LiteavLog.d(this.f23287a, "onEncodedNAL encoded frame is null.");
            return;
        }
        synchronized (this) {
            if (this.t) {
                a(av.a(this, z, encodedVideoFrame), "");
            } else {
                LiteavLog.d(this.f23287a, "onEncodedNAL called when uninitialized!");
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public final void onOutputFormatChanged(MediaFormat mediaFormat) {
        LiteavLog.i(this.f23287a, "onOutputFormatChanged: ".concat(String.valueOf(mediaFormat)));
        VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener = this.i;
        if (videoEncoderDataListener != null) {
            videoEncoderDataListener.onOutputFormatChanged(mediaFormat);
        }
    }
}
