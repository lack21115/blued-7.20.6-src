package com.tencent.liteav.videoproducer.encoder;

import android.os.Looper;
import android.os.SystemClock;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.a;
import com.tencent.liteav.videoproducer.encoder.c;
import com.tencent.liteav.videoproducer.encoder.w;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/c.class */
public final class c implements r.a, w.a {
    private static final b v = new b(d.CONTINUE_ENCODE, e.NONE);
    private boolean A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    final String f37010a;
    VideoEncodeParams o;
    VideoEncodeParams p;
    final IVideoReporter q;
    final VideoProducerDef.StreamType r;
    final w u;
    private com.tencent.liteav.base.util.r z;
    private long w = 0;
    long b = 0;
    private long x = 0;
    private long y = 0;

    /* renamed from: c  reason: collision with root package name */
    long f37011c = 0;
    float d = 0.0f;
    float e = 0.0f;
    float f = 0.0f;
    double g = 0.0d;
    boolean h = false;
    boolean i = false;
    VideoEncoderDef.EncodeStrategy j = VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE;
    VideoEncoderDef.a k = null;
    e l = e.NONE;
    int m = 0;
    int n = 0;
    boolean s = false;
    int t = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/c$a.class */
    interface a {
        b a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/c$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final d f37012a;
        public final e b;

        public b(d dVar, e eVar) {
            this.f37012a = dVar;
            this.b = eVar;
        }
    }

    /* renamed from: com.tencent.liteav.videoproducer.encoder.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/c$c.class */
    static final class C0942c {

        /* renamed from: a  reason: collision with root package name */
        public VideoEncoderDef.EncoderProfile f37013a;

        private C0942c() {
            this.f37013a = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
        }

        /* synthetic */ C0942c(byte b) {
            this();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/c$d.class */
    public enum d {
        CONTINUE_ENCODE(0),
        RESTART_ENCODER(1),
        USE_HARDWARE(2),
        USE_SOFTWARE(3),
        REPORT_ENCODE_FAILED(4);
        
        private final int mPriority;

        d(int i) {
            this.mPriority = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/c$e.class */
    public enum e {
        NONE(0),
        STRATEGY(1),
        LOW_RESOLUTION_LIMIT(1),
        INPUT_OUTPUT_DIFFERENCE(2),
        NO_OUTPUT(3),
        CPU_USAGE(4),
        SVC_SCENE(5),
        RPS_SCENE(6),
        ENCODER_ERROR(7),
        OTHERS_DO_NOT_SUPPORT_H265(8);
        
        final int mPriority;

        e(int i) {
            this.mPriority = i;
        }
    }

    public c(boolean z, IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.A = false;
        this.B = false;
        this.q = iVideoReporter;
        this.A = z;
        this.B = false;
        this.r = streamType;
        this.u = new w(this, streamType);
        this.f37010a = "EncoderSupervisor_" + streamType + BridgeUtil.UNDERLINE_STR + hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b a(c cVar) {
        VideoEncodeParams videoEncodeParams = cVar.p;
        if (videoEncodeParams == null) {
            return v;
        }
        b bVar = v;
        b bVar2 = bVar;
        if (cVar.o != null) {
            VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
            videoEncodeParams2.setBaseFrameIndex(cVar.o.baseFrameIndex);
            videoEncodeParams2.setBaseGopIndex(cVar.o.baseGopIndex);
            if (videoEncodeParams2.getReferenceStrategy() == VideoEncoderDef.ReferenceStrategy.RPS) {
                videoEncodeParams2.setEncoderProfile(cVar.o.encoderProfile);
            }
            videoEncodeParams2.setReferenceStrategy(cVar.o.getReferenceStrategy());
            videoEncodeParams2.setFps(cVar.o.fps);
            videoEncodeParams2.setCodecType(cVar.o.codecType);
            videoEncodeParams2.setBitrate(cVar.o.bitrate);
            bVar2 = bVar;
            if (!cVar.o.equals(videoEncodeParams2)) {
                bVar2 = new b(d.RESTART_ENCODER, e.NONE);
            }
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r5.p != null) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ com.tencent.liteav.videoproducer.encoder.c.b b(com.tencent.liteav.videoproducer.encoder.c r5) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.c.b(com.tencent.liteav.videoproducer.encoder.c):com.tencent.liteav.videoproducer.encoder.c$b");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b c(c cVar) {
        if (cVar.p == null) {
            return v;
        }
        b bVar = v;
        VideoEncodeParams videoEncodeParams = cVar.o;
        b bVar2 = bVar;
        if (videoEncodeParams != null) {
            bVar2 = bVar;
            if (videoEncodeParams.fps != cVar.p.fps) {
                bVar2 = bVar;
                if (cVar.k == VideoEncoderDef.a.HARDWARE) {
                    bVar2 = new b(d.RESTART_ENCODER, e.NONE);
                }
            }
        }
        return bVar2;
    }

    private void d() {
        com.tencent.liteav.base.util.r rVar = new com.tencent.liteav.base.util.r(Looper.myLooper(), this);
        this.z = rVar;
        rVar.a(1000, 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b e(c cVar) {
        if (cVar.k == VideoEncoderDef.a.SOFTWARE || cVar.w - cVar.b <= 30) {
            return v;
        }
        String str = cVar.f37010a;
        LiteavLog.i(str, "checkFrameInOutDifference in frame:" + cVar.w + " out frame " + cVar.b);
        return new b(d.RESTART_ENCODER, e.INPUT_OUTPUT_DIFFERENCE);
    }

    private void e() {
        com.tencent.liteav.videoproducer.encoder.a aVar;
        com.tencent.liteav.videoproducer.encoder.a aVar2;
        aVar = a.C0941a.f36968a;
        aVar.f36967a.f36956c = false;
        IVideoReporter iVideoReporter = this.q;
        com.tencent.liteav.videobase.videobase.i iVar = com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_ABILITY;
        int i = this.r.mValue;
        aVar2 = a.C0941a.f36968a;
        iVideoReporter.updateStatus(iVar, i, aVar2.f36967a);
    }

    private boolean f() {
        return this.j == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE || this.j == VideoEncoderDef.EncodeStrategy.PREFER_SOFTWARE || this.j == VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b g(c cVar) {
        if (cVar.k != VideoEncoderDef.a.SOFTWARE && cVar.x + 5000 < SystemClock.elapsedRealtime()) {
            cVar.x = SystemClock.elapsedRealtime();
            long j = cVar.y;
            if (j != 0 && j == cVar.b) {
                return new b(d.RESTART_ENCODER, e.NO_OUTPUT);
            }
            cVar.y = cVar.b;
        }
        return v;
    }

    private boolean g() {
        return this.j == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE || this.j == VideoEncoderDef.EncodeStrategy.PREFER_SOFTWARE || this.j == VideoEncoderDef.EncodeStrategy.USE_SOFTWARE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b h() {
        if (this.h) {
            this.h = false;
            if (this.k == VideoEncoderDef.a.HARDWARE) {
                this.m++;
                VideoEncodeParams videoEncodeParams = this.o;
                if (videoEncodeParams == null) {
                    return v;
                }
                if (videoEncodeParams.codecType != CodecType.H265) {
                    return (!g() || this.n >= 5) ? new b(d.REPORT_ENCODE_FAILED, e.NONE) : new b(d.USE_SOFTWARE, e.ENCODER_ERROR);
                }
                this.A = false;
                if (g() && this.B && this.n < 5) {
                    return new b(d.USE_SOFTWARE, e.OTHERS_DO_NOT_SUPPORT_H265);
                }
                this.m = 0;
                this.o.setCodecType(CodecType.H264);
                VideoEncodeParams videoEncodeParams2 = this.p;
                if (videoEncodeParams2 != null) {
                    videoEncodeParams2.setCodecType(CodecType.H264);
                }
                e();
                b j = j();
                b bVar = j;
                if (j == null) {
                    bVar = new b(d.RESTART_ENCODER, e.ENCODER_ERROR);
                }
                return bVar;
            }
            this.n++;
            VideoEncodeParams videoEncodeParams3 = this.o;
            if (videoEncodeParams3 == null) {
                return v;
            }
            if (videoEncodeParams3.codecType != CodecType.H265) {
                return (!f() || this.m > 0) ? this.n >= 5 ? new b(d.REPORT_ENCODE_FAILED, e.NONE) : new b(d.RESTART_ENCODER, e.ENCODER_ERROR) : new b(d.USE_HARDWARE, e.ENCODER_ERROR);
            }
            this.B = false;
            if (f() && this.A && this.m <= 0) {
                return new b(d.USE_HARDWARE, e.OTHERS_DO_NOT_SUPPORT_H265);
            }
            this.n = 0;
            this.o.setCodecType(CodecType.H264);
            VideoEncodeParams videoEncodeParams4 = this.p;
            if (videoEncodeParams4 != null) {
                videoEncodeParams4.setCodecType(CodecType.H264);
            }
            e();
            b j2 = j();
            b bVar2 = j2;
            if (j2 == null) {
                bVar2 = new b(d.RESTART_ENCODER, e.ENCODER_ERROR);
            }
            return bVar2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b h(c cVar) {
        if (cVar.i) {
            cVar.i = false;
            if (cVar.k == VideoEncoderDef.a.SOFTWARE && cVar.m <= 0) {
                return new b(d.USE_HARDWARE, e.CPU_USAGE);
            }
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r0.codecType == com.tencent.liteav.videobase.common.CodecType.H264) goto L10;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.liteav.videoproducer.encoder.c.b i() {
        /*
            r5 = this;
            r0 = r5
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r0.o
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = r9
            if (r0 == 0) goto L20
            r0 = r9
            com.tencent.liteav.videobase.common.CodecType r0 = r0.codecType
            com.tencent.liteav.videobase.common.CodecType r1 = com.tencent.liteav.videobase.common.CodecType.H264
            if (r0 != r1) goto L1b
            goto L20
        L1b:
            r0 = 0
            r6 = r0
            goto L22
        L20:
            r0 = 1
            r6 = r0
        L22:
            r0 = r6
            if (r0 == 0) goto L2d
            r0 = r5
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r0.p
            if (r0 == 0) goto L47
        L2d:
            r0 = r5
            com.tencent.liteav.videoproducer.encoder.VideoEncodeParams r0 = r0.p
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L49
            r0 = r8
            r7 = r0
            r0 = r9
            com.tencent.liteav.videobase.common.CodecType r0 = r0.codecType
            com.tencent.liteav.videobase.common.CodecType r1 = com.tencent.liteav.videobase.common.CodecType.H264
            if (r0 != r1) goto L49
        L47:
            r0 = 1
            r7 = r0
        L49:
            r0 = r7
            if (r0 != 0) goto L4f
            r0 = 0
            return r0
        L4f:
            r0 = r5
            com.tencent.liteav.videoproducer.encoder.c$b r0 = r0.j()
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L6c
            r0 = r6
            if (r0 != 0) goto L6c
            com.tencent.liteav.videoproducer.encoder.c$b r0 = new com.tencent.liteav.videoproducer.encoder.c$b
            r1 = r0
            com.tencent.liteav.videoproducer.encoder.c$d r2 = com.tencent.liteav.videoproducer.encoder.c.d.RESTART_ENCODER
            com.tencent.liteav.videoproducer.encoder.c$e r3 = com.tencent.liteav.videoproducer.encoder.c.e.NONE
            r1.<init>(r2, r3)
            return r0
        L6c:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.encoder.c.i():com.tencent.liteav.videoproducer.encoder.c$b");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b i(c cVar) {
        if (cVar.g() && (cVar.k == VideoEncoderDef.a.HARDWARE || cVar.k == null)) {
            VideoEncodeParams videoEncodeParams = cVar.o;
            int i = videoEncodeParams != null ? videoEncodeParams.width * cVar.o.height : 0;
            boolean z = i != 0 && i <= 10000;
            VideoEncodeParams videoEncodeParams2 = cVar.p;
            int i2 = videoEncodeParams2 != null ? videoEncodeParams2.width * cVar.p.height : 0;
            boolean z2 = false;
            if (i2 != 0) {
                z2 = false;
                if (i2 <= 10000) {
                    z2 = true;
                }
            }
            if (z2 || (cVar.p == null && z)) {
                return new b(d.USE_SOFTWARE, e.LOW_RESOLUTION_LIMIT);
            }
        }
        return v;
    }

    private b j() {
        if (this.j != VideoEncoderDef.EncodeStrategy.USE_SOFTWARE_ONLY || this.k == VideoEncoderDef.a.SOFTWARE) {
            if ((this.j == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE || this.j == VideoEncoderDef.EncodeStrategy.PREFER_SOFTWARE || this.j == VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) && this.k == null) {
                return (this.j == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE || this.j == VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) ? new b(d.USE_HARDWARE, e.STRATEGY) : new b(d.USE_SOFTWARE, e.STRATEGY);
            }
            return null;
        }
        return new b(d.USE_SOFTWARE, e.STRATEGY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b j(c cVar) {
        VideoEncodeParams videoEncodeParams = cVar.p;
        if (videoEncodeParams == null) {
            return v;
        }
        b bVar = v;
        boolean isEnablesRps = videoEncodeParams.isEnablesRps();
        VideoEncodeParams videoEncodeParams2 = cVar.o;
        b bVar2 = bVar;
        if (isEnablesRps != (videoEncodeParams2 != null && videoEncodeParams2.isEnablesRps())) {
            if (cVar.j != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) {
                return (!isEnablesRps || cVar.k == VideoEncoderDef.a.SOFTWARE) ? (isEnablesRps || cVar.j != VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE) ? new b(d.RESTART_ENCODER, e.RPS_SCENE) : new b(d.USE_HARDWARE, e.RPS_SCENE) : new b(d.USE_SOFTWARE, e.RPS_SCENE);
            }
            bVar2 = bVar;
            if (isEnablesRps) {
                String str = cVar.f37010a;
                LiteavLog.e(str, "checkRpsStatus, enable rps failed while current encode strategy is " + cVar.j);
                bVar2 = new b(d.REPORT_ENCODE_FAILED, e.RPS_SCENE);
                cVar.p.setReferenceStrategy(VideoEncoderDef.ReferenceStrategy.FIX_GOP);
            }
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b k(c cVar) {
        VideoEncodeParams videoEncodeParams = cVar.p;
        if (videoEncodeParams == null) {
            return v;
        }
        b bVar = v;
        boolean isEnablesSvc = videoEncodeParams.isEnablesSvc();
        VideoEncodeParams videoEncodeParams2 = cVar.o;
        b bVar2 = bVar;
        if (isEnablesSvc != (videoEncodeParams2 != null && videoEncodeParams2.isEnablesSvc())) {
            if (cVar.j != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) {
                return (!isEnablesSvc || cVar.k == VideoEncoderDef.a.SOFTWARE) ? (isEnablesSvc || cVar.j != VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE) ? new b(d.RESTART_ENCODER, e.SVC_SCENE) : new b(d.USE_HARDWARE, e.SVC_SCENE) : new b(d.USE_SOFTWARE, e.SVC_SCENE);
            }
            bVar2 = bVar;
            if (isEnablesSvc) {
                LiteavLog.e(cVar.f37010a, "Can't use svc mode in use hardware only strategy!");
                bVar2 = new b(d.CONTINUE_ENCODE, e.SVC_SCENE);
                cVar.p.setReferenceStrategy(VideoEncoderDef.ReferenceStrategy.FIX_GOP);
            }
        }
        return bVar2;
    }

    public final d a(PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            this.w++;
        }
        Collection arrayList = new ArrayList(Arrays.asList(new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.d

            /* renamed from: a  reason: collision with root package name */
            private final c f37018a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37018a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.a(this.f37018a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.h

            /* renamed from: a  reason: collision with root package name */
            private final c f37022a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37022a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.b(this.f37022a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.i

            /* renamed from: a  reason: collision with root package name */
            private final c f37023a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37023a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.c(this.f37023a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.j

            /* renamed from: a  reason: collision with root package name */
            private final c f37024a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37024a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                c.b i;
                i = this.f37024a.i();
                return i;
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.k

            /* renamed from: a  reason: collision with root package name */
            private final c f37025a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37025a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.e(this.f37025a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.l

            /* renamed from: a  reason: collision with root package name */
            private final c f37026a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37026a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                c.b h;
                h = this.f37026a.h();
                return h;
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.m

            /* renamed from: a  reason: collision with root package name */
            private final c f37027a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37027a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.g(this.f37027a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.n

            /* renamed from: a  reason: collision with root package name */
            private final c f37028a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37028a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.h(this.f37028a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.o

            /* renamed from: a  reason: collision with root package name */
            private final c f37029a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f37029a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.i(this.f37029a);
            }
        }));
        if (this.j != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) {
            arrayList.addAll(Arrays.asList(new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.e

                /* renamed from: a  reason: collision with root package name */
                private final c f37019a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f37019a = this;
                }

                @Override // com.tencent.liteav.videoproducer.encoder.c.a
                public final c.b a() {
                    return c.j(this.f37019a);
                }
            }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.f

                /* renamed from: a  reason: collision with root package name */
                private final c f37020a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f37020a = this;
                }

                @Override // com.tencent.liteav.videoproducer.encoder.c.a
                public final c.b a() {
                    return c.k(this.f37020a);
                }
            }));
        }
        VideoEncodeParams videoEncodeParams = this.o;
        Collection<a> collection = arrayList;
        if (videoEncodeParams != null) {
            collection = arrayList;
            if (videoEncodeParams.isTranscodingMode()) {
                collection = Arrays.asList(new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.g

                    /* renamed from: a  reason: collision with root package name */
                    private final c f37021a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f37021a = this;
                    }

                    @Override // com.tencent.liteav.videoproducer.encoder.c.a
                    public final c.b a() {
                        c.b h;
                        h = this.f37021a.h();
                        return h;
                    }
                });
            }
        }
        b bVar = null;
        for (a aVar : collection) {
            b a2 = aVar.a();
            if (a2 != null) {
                if (bVar != null) {
                    if (a2.f37012a.mPriority > bVar.f37012a.mPriority || (a2.f37012a == bVar.f37012a && a2.b.mPriority > bVar.b.mPriority)) {
                    }
                }
                bVar = a2;
            }
        }
        VideoEncodeParams videoEncodeParams2 = this.p;
        if (videoEncodeParams2 != null) {
            this.o = videoEncodeParams2;
            this.p = null;
        }
        if (bVar == null) {
            bVar = this.k == null ? new b(d.USE_HARDWARE, e.NONE) : new b(d.CONTINUE_ENCODE, e.NONE);
        }
        b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new b(d.USE_HARDWARE, e.NONE);
        }
        if (bVar2.f37012a == d.USE_HARDWARE) {
            if (this.k == VideoEncoderDef.a.HARDWARE || this.l.mPriority > bVar2.b.mPriority) {
                return d.CONTINUE_ENCODE;
            }
            this.k = VideoEncoderDef.a.HARDWARE;
            e eVar = bVar2.b;
            this.l = eVar;
            if (eVar == e.CPU_USAGE) {
                this.q.notifyEvent(h.b.EVT_VIDEO_ENCODE_SW_TO_HW_CPU_USAGE, null, new Object[0]);
            }
        } else if (bVar2.f37012a == d.USE_SOFTWARE) {
            if (this.k == VideoEncoderDef.a.SOFTWARE || this.l.mPriority > bVar2.b.mPriority) {
                return d.CONTINUE_ENCODE;
            }
            this.k = VideoEncoderDef.a.SOFTWARE;
            e eVar2 = bVar2.b;
            this.l = eVar2;
            if (eVar2 == e.ENCODER_ERROR) {
                this.q.notifyEvent(h.b.EVT_VIDEO_ENCODE_HW_TO_SW_MEDIACODEC_NOT_WORK, null, new Object[0]);
            }
            d();
        }
        if (bVar2.f37012a != d.CONTINUE_ENCODE) {
            LiteavLog.i(this.f37010a, "instruction: " + bVar2.f37012a + ", reason: " + bVar2.b);
        }
        if (bVar2.f37012a == d.RESTART_ENCODER) {
            c();
        }
        return bVar2.f37012a;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.w.a
    public final void a(double d2) {
        this.g = d2;
        this.q.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODE_REAL_FRAME_RATE, Double.valueOf(d2));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.w.a
    public final void a(long j) {
        this.q.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODE_REAL_ENCODE_BITRATE, Long.valueOf(j));
    }

    public final void a(VideoEncodeParams videoEncodeParams) {
        VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
        C0942c c0942c = new C0942c((byte) 0);
        if (this.j == VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY || videoEncodeParams2.referenceStrategy != VideoEncoderDef.ReferenceStrategy.RPS) {
            if (!videoEncodeParams2.enableBFrame && (this.r == VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO || this.r == VideoProducerDef.StreamType.STREAM_TYPE_SUB_VIDEO)) {
                c0942c.f37013a = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
            }
        } else if (this.r == VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO || this.r == VideoProducerDef.StreamType.STREAM_TYPE_SUB_VIDEO) {
            c0942c.f37013a = VideoEncoderDef.EncoderProfile.PROFILE_HIGHRPS;
        }
        if (videoEncodeParams2.encoderProfile == null) {
            videoEncodeParams2.encoderProfile = c0942c.f37013a;
        }
        if (this.s) {
            videoEncodeParams2.fps = this.t;
        }
        this.p = videoEncodeParams2;
    }

    @Override // com.tencent.liteav.base.util.r.a
    public final void a_() {
        long a2 = com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_CheckCount");
        if (this.f37011c < a2) {
            int[] a3 = com.tencent.liteav.base.util.q.a();
            this.f37011c++;
            this.d += a3[0] / 10;
            this.e += a3[1] / 10;
            VideoEncodeParams videoEncodeParams = this.o;
            if (videoEncodeParams == null || videoEncodeParams.fps == 0) {
                return;
            }
            this.f = (float) (this.f + ((this.g * 100.0d) / videoEncodeParams.fps));
            return;
        }
        float f = (float) a2;
        float f2 = this.d / f;
        float f3 = this.f / f;
        float f4 = this.e / f;
        if (f2 >= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_CPU_MAX")) || f3 <= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_FPS_MIN")) || (f4 >= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_CPU")) && f3 <= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_FPS")))) {
            this.i = true;
        }
        com.tencent.liteav.base.util.r rVar = this.z;
        if (rVar != null) {
            rVar.a();
            this.z = null;
        }
        this.f37011c = 0L;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0d;
    }

    public final VideoEncodeParams b() {
        VideoEncodeParams videoEncodeParams = this.p;
        if (videoEncodeParams == null) {
            videoEncodeParams = this.o;
        }
        return new VideoEncodeParams(videoEncodeParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.b = 0L;
        this.w = 0L;
        this.y = 0L;
        this.x = 0L;
    }
}
