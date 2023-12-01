package com.tencent.liteav.videoconsumer.decoder;

import android.content.ContentResolver;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ay;
import com.tencent.liteav.videoconsumer.decoder.b;
import com.tencent.liteav.videoconsumer.decoder.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecodeController.class */
public final class VideoDecodeController implements az {
    final IVideoReporter b;

    /* renamed from: c  reason: collision with root package name */
    final d f36735c;
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
    private final d.InterfaceC0938d t;

    /* renamed from: a  reason: collision with root package name */
    public String f36734a = "VideoDecodeController";
    boolean j = false;
    private VideoDecoderDef.ConsumerScene r = VideoDecoderDef.ConsumerScene.UNKNOWN;
    private final Deque<EncodedVideoFrame> s = new LinkedList();
    final AtomicInteger m = new AtomicInteger(0);
    final com.tencent.liteav.videobase.utils.j n = new com.tencent.liteav.videobase.utils.j(1);

    /* renamed from: com.tencent.liteav.videoconsumer.decoder.VideoDecodeController$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/VideoDecodeController$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f36736a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[d.c.values().length];
            f36736a = iArr;
            try {
                iArr[d.c.DROP_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f36736a[d.c.CONTINUE_DECODE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f36736a[d.c.SWITCH_TO_HARDWARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f36736a[d.c.SWITCH_TO_SOFTWARE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f36736a[d.c.RESTART_DECODER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f36736a[d.c.REQUEST_KEY_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f36736a[d.c.REPORT_DECODE_ERROR.ordinal()] = 7;
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
        d.InterfaceC0938d a2 = aa.a();
        this.t = a2;
        this.b = iVideoReporter;
        this.e = z;
        unused = b.a.f36777a;
        boolean a3 = ExternalDecodeFactoryManager.a();
        unused2 = b.a.f36777a;
        this.f36735c = new d(a2, iVideoReporter, a3, b.b());
        this.d = new aw(iVideoReporter);
        this.f36734a += BridgeUtil.UNDERLINE_STR + hashCode();
        this.p = new com.tencent.liteav.videobase.utils.k("decoder" + hashCode());
        LiteavLog.i(this.f36734a, "mIsTranscodingMode=" + this.e);
    }

    private void a(EncodedVideoFrame encodedVideoFrame, ay.a aVar) {
        if (this.i == null) {
            LiteavLog.e(this.f36734a, "updateDecoderType mEGLCore is null");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h();
        SpsInfo a2 = this.t.a(encodedVideoFrame.isH265(), encodedVideoFrame.data);
        if (aVar == ay.a.SOFTWARE) {
            this.k = new SoftwareVideoDecoder(this.b);
        } else {
            boolean z = this.f36735c.w;
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
        String str = this.f36734a;
        LiteavLog.i(str, "open decoder cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + ",update decoder type to " + aVar + ", video " + a2);
        this.d.a(this.k.getDecoderType(), encodedVideoFrame.isH265());
    }

    private void c(EncodedVideoFrame encodedVideoFrame) {
        ay ayVar = this.k;
        if (ayVar == null) {
            LiteavLog.e(this.f36734a, "video decoder is null!");
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
        LiteavLog.i(this.f36734a, ContentResolver.SYNC_EXTRAS_INITIALIZE);
        synchronized (this) {
            if (this.q != null) {
                LiteavLog.w(this.f36734a, "video decode controller is initialized");
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
        this.f36735c.y = consumerScene;
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
            LiteavLog.w(this.f36734a, "runnable:" + runnable + " is failed to post, handler:" + bVar);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        LiteavLog.i(this.f36734a, "initializeEGLCoreInternal()");
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.i = eVar;
        try {
            eVar.a(this.h, null, 128, 128);
            this.p.a((com.tencent.liteav.videobase.frame.e) null);
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(this.f36734a, "create egl core failed.", e);
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
        LiteavLog.i(this.f36734a, "uninitializeEGLCoreInternal()");
        if (this.i == null) {
            return;
        }
        this.p.a();
        com.tencent.liteav.videobase.b.e.a(this.i);
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        EncodedVideoFrame peekFirst;
        EncodedVideoFrame peekLast;
        int size;
        d.c cVar;
        synchronized (this) {
            peekFirst = this.s.peekFirst();
            peekLast = this.s.peekLast();
            size = this.s.size();
        }
        if (peekFirst == null) {
            return;
        }
        if (peekFirst.isEosFrame) {
            c(peekFirst);
            return;
        }
        peekFirst.updateNALTypeAccordingNALHeader();
        if (peekLast != null && !this.e) {
            d dVar = this.f36735c;
            long j = peekLast.pts - peekFirst.pts;
            if (j >= 0 && size >= 0) {
                dVar.A = j;
                dVar.B = size;
            }
        }
        final d dVar2 = this.f36735c;
        if (dVar2.k != 0 && peekFirst.pts == dVar2.k) {
            cVar = d.c.CONTINUE_DECODE;
        } else if (peekFirst.isIDRFrame()) {
            if (!dVar2.o) {
                dVar2.o = true;
            }
            ArrayList<d.a> arrayList = new ArrayList(Arrays.asList(new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.e

                /* renamed from: a  reason: collision with root package name */
                private final d f36787a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36787a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    d dVar3 = this.f36787a;
                    if (dVar3.g != VideoDecodeController.DecodeStrategy.USE_SOFTWARE_ONLY || dVar3.h == ay.a.SOFTWARE) {
                        if ((dVar3.g == VideoDecodeController.DecodeStrategy.PREFER_HARDWARE || dVar3.g == VideoDecodeController.DecodeStrategy.USE_HARDWARE_ONLY) && dVar3.h == null) {
                            return new d.b(d.c.SWITCH_TO_HARDWARE, d.e.NONE);
                        }
                        if (dVar3.g == VideoDecodeController.DecodeStrategy.PREFER_SOFTWARE && dVar3.h == null) {
                            return new d.b(d.c.SWITCH_TO_SOFTWARE, d.e.NONE);
                        }
                        if (dVar3.h == null) {
                            return new d.b(d.c.SWITCH_TO_HARDWARE, d.e.NONE);
                        }
                        return null;
                    }
                    return new d.b(d.c.SWITCH_TO_SOFTWARE, d.e.NONE);
                }
            }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.g

                /* renamed from: a  reason: collision with root package name */
                private final d f36789a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36789a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    boolean z;
                    d dVar3 = this.f36789a;
                    SpsInfo a2 = dVar3.b.a(encodedVideoFrame.isH265(), encodedVideoFrame.data);
                    if (dVar3.d.equals(a2)) {
                        z = false;
                    } else {
                        dVar3.d.set(a2);
                        z = true;
                    }
                    if (dVar3.h == ay.a.HARDWARE && z) {
                        return new d.b(d.c.RESTART_DECODER, d.e.NONE);
                    }
                    return null;
                }
            }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.h

                /* renamed from: a  reason: collision with root package name */
                private final d f36790a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36790a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    d.b bVar;
                    d dVar3 = this.f36790a;
                    boolean isH265 = encodedVideoFrame.isH265();
                    if (isH265 != dVar3.i) {
                        dVar3.j = d.e.NONE;
                        dVar3.s = 0;
                        dVar3.t = 0;
                        LiteavLog.i(dVar3.f36779a, "checkH265Frame find h265 frame.");
                        bVar = new d.b(d.c.RESTART_DECODER, d.e.NONE);
                    } else {
                        bVar = null;
                    }
                    if (isH265 && !dVar3.f && !dVar3.e) {
                        dVar3.a();
                        return new d.b(d.c.REPORT_DECODE_ERROR, d.e.NONE);
                    } else if (isH265 && !dVar3.e && dVar3.h != ay.a.HARDWARE) {
                        if (dVar3.a(encodedVideoFrame)) {
                            return new d.b(d.c.SWITCH_TO_HARDWARE, d.e.OTHERS_DO_NOT_SUPPORT_H265);
                        }
                        dVar3.a();
                        return new d.b(d.c.REPORT_DECODE_ERROR, d.e.NONE);
                    } else if (!isH265 || dVar3.f || dVar3.h == ay.a.SOFTWARE) {
                        return bVar;
                    } else {
                        if (dVar3.b(encodedVideoFrame)) {
                            return new d.b(d.c.SWITCH_TO_SOFTWARE, d.e.OTHERS_DO_NOT_SUPPORT_H265);
                        }
                        dVar3.a();
                        return new d.b(d.c.REPORT_DECODE_ERROR, d.e.NONE);
                    }
                }
            }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.i

                /* renamed from: a  reason: collision with root package name */
                private final d f36791a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36791a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    d dVar3 = this.f36791a;
                    boolean isRPSEnable = encodedVideoFrame.isRPSEnable();
                    if (!isRPSEnable && dVar3.h == ay.a.SOFTWARE && dVar3.a(encodedVideoFrame)) {
                        if (dVar3.j == null || dVar3.j.mPriority <= d.e.RPS_MODE_UPDATED.mPriority) {
                            dVar3.f36780c.notifyEvent(h.b.EVT_VIDEO_DECODE_SW_TO_HW_REMOTE_VIDEO_DISABLE_RPS, "remote video disable RPS, switch SW to HW decode", new Object[0]);
                            return VideoDecodeController.DecodeStrategy.PREFER_SOFTWARE == dVar3.g ? new d.b(d.c.CONTINUE_DECODE, d.e.NONE) : new d.b(d.c.SWITCH_TO_HARDWARE, d.e.RPS_MODE_UPDATED);
                        }
                        return new d.b(d.c.CONTINUE_DECODE, d.e.NONE);
                    } else if (!isRPSEnable || dVar3.h == ay.a.SOFTWARE) {
                        return null;
                    } else {
                        if (dVar3.b(encodedVideoFrame)) {
                            dVar3.f36780c.notifyEvent(h.b.EVT_VIDEO_DECODE_HW_TO_SW_REMOTE_VIDEO_ENABLE_RPS, "remote video enable RPS, switch HW to SW decode", new Object[0]);
                            return new d.b(d.c.SWITCH_TO_SOFTWARE, d.e.RPS_MODE_UPDATED);
                        }
                        return new d.b(d.c.REPORT_DECODE_ERROR, d.e.NONE);
                    }
                }
            }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.j

                /* renamed from: a  reason: collision with root package name */
                private final d f36792a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36792a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    d dVar3 = this.f36792a;
                    boolean z = dVar3.x;
                    dVar3.x = encodedVideoFrame.isSVCEnable();
                    dVar3.w = dVar3.y == VideoDecoderDef.ConsumerScene.RTC && !encodedVideoFrame.isSVCEnable();
                    if (dVar3.h != ay.a.HARDWARE) {
                        return new d.b(d.c.CONTINUE_DECODE, d.e.NONE);
                    }
                    if (z == encodedVideoFrame.isSVCEnable() || dVar3.v == dVar3.w) {
                        return new d.b(d.c.CONTINUE_DECODE, d.e.NONE);
                    }
                    String str = dVar3.f36779a;
                    LiteavLog.i(str, "checkSVCStatus mExpectLowLatency:" + dVar3.w + ", mUsingLowLatency:" + dVar3.v);
                    return new d.b(d.c.RESTART_DECODER, d.e.NONE);
                }
            }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.k

                /* renamed from: a  reason: collision with root package name */
                private final d f36793a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36793a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    d dVar3 = this.f36793a;
                    if (dVar3.r) {
                        dVar3.r = false;
                        if (dVar3.h != ay.a.HARDWARE) {
                            if (dVar3.h == ay.a.SOFTWARE) {
                                dVar3.t++;
                                if (dVar3.t < 3) {
                                    LiteavLog.i(dVar3.f36779a, "checkPendingDecodeError failed decoder count is less max count.");
                                    return new d.b(d.c.RESTART_DECODER, d.e.NONE);
                                }
                                if (encodedVideoFrame.isH265()) {
                                    dVar3.e = false;
                                }
                                if (dVar3.a(encodedVideoFrame) && dVar3.s <= 0 && !encodedVideoFrame.isRPSEnable()) {
                                    LiteavLog.i(dVar3.f36779a, "checkPendingDecodeError switch SW to HW decode");
                                    return new d.b(d.c.SWITCH_TO_HARDWARE, d.e.DECODE_ERROR);
                                }
                                if (encodedVideoFrame.isH265()) {
                                    dVar3.a();
                                }
                                return new d.b(d.c.REPORT_DECODE_ERROR, d.e.NONE);
                            }
                            return null;
                        }
                        dVar3.s++;
                        if (encodedVideoFrame.isH265()) {
                            dVar3.f = false;
                        }
                        if (dVar3.t >= dVar3.D) {
                            if (dVar3.b(encodedVideoFrame)) {
                                dVar3.f36780c.notifyEvent(h.b.EVT_VIDEO_DECODE_HW_TO_SW_MEDIACODEC_NOT_WORK, "MediaCodec doesn't work, switch HW to SW decode", new Object[0]);
                                LiteavLog.i(dVar3.f36779a, "checkPendingDecodeError switch HW to SW decode");
                                return new d.b(d.c.SWITCH_TO_SOFTWARE, d.e.DECODE_ERROR);
                            }
                            if (encodedVideoFrame.isH265()) {
                                dVar3.a();
                            }
                            return new d.b(d.c.REPORT_DECODE_ERROR, d.e.NONE);
                        }
                        dVar3.t++;
                        LiteavLog.i(dVar3.f36779a, "checkPendingDecodeError restart. index:" + dVar3.t + " max:" + dVar3.D);
                        return new d.b(d.c.RESTART_DECODER, d.e.NONE);
                    }
                    return null;
                }
            }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.l

                /* renamed from: a  reason: collision with root package name */
                private final d f36794a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36794a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    d dVar3 = this.f36794a;
                    if (dVar3.u) {
                        dVar3.u = false;
                        LiteavLog.i(dVar3.f36779a, "EGLContext changed.");
                        if (dVar3.h == ay.a.HARDWARE) {
                            return new d.b(d.c.RESTART_DECODER, d.e.NONE);
                        }
                        return null;
                    }
                    return null;
                }
            }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.m

                /* renamed from: a  reason: collision with root package name */
                private final d f36795a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f36795a = dVar2;
                }

                @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                    d dVar3 = this.f36795a;
                    if (dVar3.A <= 5000 || dVar3.B <= 50) {
                        dVar3.C = false;
                    } else {
                        dVar3.C = true;
                        String str = dVar3.f36779a;
                        LiteavLog.i(str, "pending send to decoder frame too long, duration:" + dVar3.A + ",count:" + dVar3.B);
                    }
                    return new d.b(d.c.CONTINUE_DECODE, d.e.NONE);
                }
            }));
            if (dVar2.g != DecodeStrategy.USE_HARDWARE_ONLY) {
                arrayList.addAll(Arrays.asList(new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.n

                    /* renamed from: a  reason: collision with root package name */
                    private final d f36796a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f36796a = dVar2;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                    public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                        d dVar3 = this.f36796a;
                        com.tencent.liteav.base.util.n nVar = new com.tencent.liteav.base.util.n(dVar3.d.width, dVar3.d.height);
                        if (dVar3.h != ay.a.HARDWARE || nVar.b() <= 0) {
                            return null;
                        }
                        int i = nVar.b() >= 480000 ? dVar3.m : dVar3.n;
                        boolean z = dVar3.q >= i;
                        boolean z2 = dVar3.l != 0 && encodedVideoFrame.pts - dVar3.l >= ((long) (i * 66)) && dVar3.q >= i - 2;
                        boolean z3 = true;
                        if (!z) {
                            z3 = z2;
                        }
                        if (z3 && dVar3.b(encodedVideoFrame)) {
                            String str = "Remote-VideoDecoder[" + dVar3 + "]: " + (z ? "Too many hard decoder buffers, switch to soft decoder" : "Hard decoding takes too long, switch to soft decoder") + "[videoSize: " + nVar + "][decCacheNum:" + dVar3.q + "][decPts:" + encodedVideoFrame.pts + "][renderPts:" + dVar3.l + "][cacheHigh:" + dVar3.m + "][cacheLow:" + dVar3.n + "]";
                            if (z) {
                                dVar3.f36780c.notifyWarning(h.c.WARNING_VIDEO_DECODE_CACHE_EXCEEDED, "cache to much deviceName:" + LiteavSystemInfo.getModel(), new Object[0]);
                            }
                            if (z2) {
                                dVar3.f36780c.notifyEvent(h.b.EVT_VIDEO_DECODE_HW_TO_SW_DECODE_COST_TOO_HIGH, "decode cost too high, switch HW to SW, deviceName:" + LiteavSystemInfo.getModel(), new Object[0]);
                            }
                            LiteavLog.i(dVar3.f36779a, str);
                            return new d.b(d.c.SWITCH_TO_SOFTWARE, d.e.HARDWARE_DECODER_ABNORMAL);
                        }
                        return null;
                    }
                }, new d.a(dVar2) { // from class: com.tencent.liteav.videoconsumer.decoder.f

                    /* renamed from: a  reason: collision with root package name */
                    private final d f36788a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f36788a = dVar2;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.d.a
                    public final d.b a(EncodedVideoFrame encodedVideoFrame) {
                        d dVar3 = this.f36788a;
                        if (dVar3.h == ay.a.SOFTWARE || encodedVideoFrame == null || dVar3.d.width * dVar3.d.height > 40000 || !dVar3.b(encodedVideoFrame)) {
                            return null;
                        }
                        return new d.b(d.c.SWITCH_TO_SOFTWARE, d.e.LOW_RESOLUTION);
                    }
                }));
            }
            d.b bVar = null;
            for (d.a aVar : arrayList) {
                d.b a2 = aVar.a(peekFirst);
                if (a2 != null) {
                    if (bVar != null) {
                        if (d.c.a(a2.f36782a) > d.c.a(bVar.f36782a) || (d.c.a(a2.f36782a) == d.c.a(bVar.f36782a) && a2.b.mPriority > bVar.b.mPriority)) {
                        }
                    }
                    bVar = a2;
                }
            }
            if (bVar != null && bVar.f36782a != d.c.CONTINUE_DECODE) {
                LiteavLog.w(dVar2.f36779a, bVar + ", mUsingDecoderType = " + dVar2.h + ", mSwitchReason = " + dVar2.j);
            }
            if (bVar == null) {
                bVar = new d.b(d.c.CONTINUE_DECODE, d.e.NONE);
            }
            if (bVar.f36782a != d.c.SWITCH_TO_HARDWARE) {
                if (bVar.f36782a == d.c.SWITCH_TO_SOFTWARE) {
                    if (dVar2.h == ay.a.SOFTWARE || bVar.b.mPriority < dVar2.j.mPriority) {
                        cVar = d.c.CONTINUE_DECODE;
                    } else {
                        dVar2.j = bVar.b;
                        dVar2.h = ay.a.SOFTWARE;
                        dVar2.f36780c.notifyEvent(h.b.EVT_VIDEO_DECODE_TYPE_CHANGE, "UsingDecoderType:" + dVar2.h, new Object[0]);
                    }
                }
                cVar = bVar.f36782a;
            } else if (dVar2.h == ay.a.HARDWARE || bVar.b.mPriority < dVar2.j.mPriority) {
                cVar = d.c.CONTINUE_DECODE;
            } else {
                dVar2.j = bVar.b;
                dVar2.h = ay.a.HARDWARE;
                dVar2.f36780c.notifyEvent(h.b.EVT_VIDEO_DECODE_TYPE_CHANGE, "UsingDecoderType:" + dVar2.h, new Object[0]);
                cVar = bVar.f36782a;
            }
        } else {
            if (!dVar2.C) {
                if (dVar2.o) {
                    cVar = d.c.CONTINUE_DECODE;
                } else {
                    dVar2.p++;
                    if (dVar2.p > 40) {
                        LiteavLog.w(dVar2.f36779a, "decoding too many frame(>40) without output! request key frame now.");
                        dVar2.p = 0;
                        cVar = d.c.REQUEST_KEY_FRAME;
                    }
                }
            }
            cVar = d.c.DROP_FRAME;
        }
        d.c cVar2 = cVar;
        if (cVar == d.c.CONTINUE_DECODE) {
            if (dVar2.z == 0 || TimeUtil.c() - dVar2.z < com.igexin.push.config.c.j) {
                cVar2 = d.c.CONTINUE_DECODE;
            } else if (peekFirst.isIDRFrame()) {
                if (dVar2.h == ay.a.HARDWARE && dVar2.b(peekFirst) && dVar2.t > dVar2.D) {
                    dVar2.h = ay.a.SOFTWARE;
                    dVar2.j = d.e.DECODE_ERROR;
                    dVar2.f36780c.notifyEvent(h.b.EVT_VIDEO_DECODE_TYPE_CHANGE, "UsingDecoderType:" + dVar2.h, new Object[0]);
                    cVar2 = d.c.SWITCH_TO_SOFTWARE;
                } else {
                    if (dVar2.h == ay.a.HARDWARE) {
                        dVar2.t++;
                    }
                    cVar2 = d.c.RESTART_DECODER;
                }
                LiteavLog.i(dVar2.f36779a, "decoder thread stuck, switch decode type, instruction:".concat(String.valueOf(cVar2)));
            } else {
                cVar2 = d.c.DROP_FRAME;
            }
        }
        int i = d.AnonymousClass1.f36781a[cVar2.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            dVar2.q = 1;
            dVar2.i = peekFirst.isH265();
            dVar2.z = 0L;
        } else if (i == 4) {
            if (dVar2.k != peekFirst.pts) {
                dVar2.q++;
                dVar2.z = 0L;
            } else if (dVar2.z == 0) {
                dVar2.z = TimeUtil.c();
            }
        }
        dVar2.k = peekFirst.pts;
        switch (AnonymousClass1.f36736a[cVar2.ordinal()]) {
            case 1:
                d(peekFirst);
                peekFirst.release();
                return;
            case 2:
                c(peekFirst);
                return;
            case 3:
                a(peekFirst, ay.a.HARDWARE);
                c(peekFirst);
                return;
            case 4:
                a(peekFirst, ay.a.SOFTWARE);
                c(peekFirst);
                return;
            case 5:
                ay.a f = f();
                if (f != null) {
                    a(peekFirst, f);
                    c(peekFirst);
                    return;
                }
                return;
            case 6:
                a aVar2 = this.g;
                if (aVar2 != null) {
                    aVar2.onRequestKeyFrame();
                    return;
                }
                return;
            case 7:
                a aVar3 = this.g;
                if (aVar3 != null) {
                    aVar3.onDecodeFailed();
                    this.b.notifyWarning(h.c.WARNING_VIDEO_DECODE_FATAL_ERROR, "decoder error", new Object[0]);
                    return;
                }
                return;
            default:
                return;
        }
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
        LiteavLog.i(this.f36734a, "uninitialize");
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
            LiteavLog.e(this.f36734a, "make current failed.", e);
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
