package com.tencent.liteav.videoconsumer.decoder;

import android.content.ContentResolver;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ay;
import com.tencent.liteav.videoconsumer.decoder.b;
import com.tencent.liteav.videoconsumer.decoder.d;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecodeController.class */
public final class VideoDecodeController implements az {
    final IVideoReporter b;

    /* renamed from: c  reason: collision with root package name */
    final d f23044c;
    final aw d;
    final boolean e;
    com.tencent.liteav.base.util.r f;
    a g;
    Object h;
    com.tencent.liteav.videobase.b.e i;
    ay k;
    JSONArray l;
    ServerVideoConsumerConfig o;
    final com.tencent.liteav.videobase.utils.k p;
    private com.tencent.liteav.base.util.b q;
    private final d.InterfaceC0768d t;

    /* renamed from: a  reason: collision with root package name */
    public String f23043a = "VideoDecodeController";
    boolean j = false;
    private VideoDecoderDef.ConsumerScene r = VideoDecoderDef.ConsumerScene.UNKNOWN;
    private final Deque<EncodedVideoFrame> s = new LinkedList();
    final AtomicInteger m = new AtomicInteger(0);
    final com.tencent.liteav.videobase.utils.j n = new com.tencent.liteav.videobase.utils.j(1);

    /* renamed from: com.tencent.liteav.videoconsumer.decoder.VideoDecodeController$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecodeController$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23045a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[d.c.values().length];
            f23045a = iArr;
            try {
                iArr[d.c.DROP_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23045a[d.c.CONTINUE_DECODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23045a[d.c.SWITCH_TO_HARDWARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23045a[d.c.SWITCH_TO_SOFTWARE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23045a[d.c.RESTART_DECODER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23045a[d.c.REQUEST_KEY_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f23045a[d.c.REPORT_DECODE_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecodeController$DecodeStrategy.class */
    public enum DecodeStrategy {
        PREFER_HARDWARE(0),
        PREFER_SOFTWARE(1),
        USE_HARDWARE_ONLY(2),
        USE_SOFTWARE_ONLY(3);
        
        private static final DecodeStrategy[] e = values();
        private final int mValue;

        DecodeStrategy(int i) {
            this.mValue = i;
        }

        public static DecodeStrategy a(int i) {
            DecodeStrategy[] decodeStrategyArr = e;
            int length = decodeStrategyArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return PREFER_HARDWARE;
                }
                DecodeStrategy decodeStrategy = decodeStrategyArr[i3];
                if (decodeStrategy.mValue == i) {
                    return decodeStrategy;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecodeController$a.class */
    public interface a extends az {
    }

    public VideoDecodeController(IVideoReporter iVideoReporter, boolean z) {
        b unused;
        b unused2;
        d.InterfaceC0768d a2 = aa.a();
        this.t = a2;
        this.b = iVideoReporter;
        this.e = z;
        unused = b.a.f23086a;
        boolean a3 = ExternalDecodeFactoryManager.a();
        unused2 = b.a.f23086a;
        this.f23044c = new d(a2, iVideoReporter, a3, b.b());
        this.d = new aw(iVideoReporter);
        this.f23043a += "_" + hashCode();
        this.p = new com.tencent.liteav.videobase.utils.k("decoder" + hashCode());
        LiteavLog.i(this.f23043a, "mIsTranscodingMode=" + this.e);
    }

    private void a(EncodedVideoFrame encodedVideoFrame, ay.a aVar) {
        if (this.i == null) {
            LiteavLog.e(this.f23043a, "updateDecoderType mEGLCore is null");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h();
        SpsInfo a2 = this.t.a(encodedVideoFrame.isH265(), encodedVideoFrame.data);
        if (aVar == ay.a.SOFTWARE) {
            this.k = new SoftwareVideoDecoder(this.b);
        } else {
            boolean z = this.f23044c.w;
            if (encodedVideoFrame.videoFormat != null) {
                this.k = new r(encodedVideoFrame.videoFormat, z, this.l, this.b);
            } else {
                this.k = new r(new com.tencent.liteav.base.util.n(a2.width, a2.height), encodedVideoFrame.isH265(), z, this.l, this.b);
            }
        }
        this.k.initialize();
        this.k.setServerConfig(this.o);
        this.k.setScene(this.r);
        this.k.start(this.i.d(), this);
        this.m.set(0);
        String str = this.f23043a;
        LiteavLog.i(str, "open decoder cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + ",update decoder type to " + aVar + ", video " + a2);
        this.d.a(this.k.getDecoderType(), encodedVideoFrame.isH265());
    }

    private void c(EncodedVideoFrame encodedVideoFrame) {
        ay ayVar = this.k;
        if (ayVar == null) {
            LiteavLog.e(this.f23043a, "video decoder is null!");
        } else if (ayVar.decode(encodedVideoFrame)) {
            d(encodedVideoFrame);
            if (encodedVideoFrame.isEosFrame) {
                return;
            }
            this.d.a(encodedVideoFrame);
            this.m.incrementAndGet();
            this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_CACHE, Integer.valueOf(this.m.get() + e()));
        }
    }

    private void d(EncodedVideoFrame encodedVideoFrame) {
        synchronized (this) {
            this.s.remove(encodedVideoFrame);
        }
    }

    public final void a() {
        LiteavLog.i(this.f23043a, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        synchronized (this) {
            if (this.q != null) {
                LiteavLog.w(this.f23043a, "video decode controller is initialized");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("video-decoder-controller");
            handlerThread.start();
            this.q = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
            a(aj.a(this));
        }
    }

    public final void a(EncodedVideoFrame encodedVideoFrame) {
        b(encodedVideoFrame);
        a(au.a(this));
    }

    public final void a(a aVar) {
        a(as.a(this, aVar));
    }

    public final void a(VideoDecoderDef.ConsumerScene consumerScene) {
        this.r = consumerScene;
        this.f23044c.y = consumerScene;
    }

    public final void a(Object obj) {
        a(ap.a(this, obj));
    }

    public final boolean a(Runnable runnable) {
        boolean z;
        com.tencent.liteav.base.util.b bVar = this.q;
        if (bVar == null || !bVar.getLooper().getThread().isAlive()) {
            z = false;
        } else if (Looper.myLooper() == bVar.getLooper()) {
            runnable.run();
            z = true;
        } else {
            z = bVar.post(runnable);
        }
        if (!z) {
            LiteavLog.w(this.f23043a, "runnable:" + runnable + " is failed to post, handler:" + bVar);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        LiteavLog.i(this.f23043a, "initializeEGLCoreInternal()");
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.i = eVar;
        try {
            eVar.a(this.h, null, 128, 128);
            this.p.a((com.tencent.liteav.videobase.frame.e) null);
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(this.f23043a, "create egl core failed.", e);
            this.b.notifyWarning(h.c.WARNING_VIDEO_DECODE_EGL_CORE_CREATE_FAILED, "VideoDecode: create EGLCore failed", new Object[0]);
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame == null) {
            return;
        }
        synchronized (this) {
            this.s.addLast(encodedVideoFrame);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        LiteavLog.i(this.f23043a, "uninitializeEGLCoreInternal()");
        if (this.i == null) {
            return;
        }
        this.p.a();
        com.tencent.liteav.videobase.b.e.a(this.i);
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0165 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 1458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.decoder.VideoDecodeController.d():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e() {
        int size;
        synchronized (this) {
            size = this.s.size();
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ay.a f() {
        ay ayVar = this.k;
        if (ayVar == null) {
            return null;
        }
        return ayVar.getDecoderType();
    }

    public final void g() {
        a(ab.a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void h() {
        ay ayVar = this.k;
        if (ayVar != null) {
            ayVar.stop();
            this.k.uninitialize();
            this.k = null;
        }
        this.n.b();
    }

    public final void i() {
        LiteavLog.i(this.f23043a, "uninitialize");
        a(af.a(this));
        a(ag.a(this));
        synchronized (this) {
            if (this.q != null) {
                this.q.a();
                this.q = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        synchronized (this) {
            for (EncodedVideoFrame encodedVideoFrame : this.s) {
                if (encodedVideoFrame != null) {
                    encodedVideoFrame.release();
                }
            }
            this.s.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        try {
            this.i.a();
            return true;
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(this.f23043a, "make current failed.", e);
            return false;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public final void onAbandonDecodingFramesCompleted() {
        a(al.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public final void onDecodeCompleted() {
        a(an.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public final void onDecodeFailed() {
        a(ai.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public final void onDecodeFrame(PixelFrame pixelFrame, long j) {
        long timestamp = pixelFrame.getTimestamp();
        this.n.a(pixelFrame);
        if (a(ah.a(this, timestamp, j))) {
            return;
        }
        this.n.b(pixelFrame);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public final void onDecodeLatencyChanged(boolean z) {
        a(ao.a(this, z));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public final void onFrameEnqueuedToDecoder() {
        a(am.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.az
    public final void onRequestKeyFrame() {
        a(ak.a(this));
    }
}
