package com.tencent.liteav.videoconsumer.decoder;

import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ay;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/aw.class */
public final class aw {
    final IVideoReporter b;
    ay.a f;
    boolean g;

    /* renamed from: a  reason: collision with root package name */
    String f23077a = "VideoDecodeControllerStatistics";
    long h = 0;
    long i = 0;
    private boolean k = false;
    long j = 0;
    private long l = 0;

    /* renamed from: c  reason: collision with root package name */
    final a f23078c = new a(this, (byte) 0);
    final b d = new b((byte) 0);
    final com.tencent.liteav.videobase.utils.f e = new com.tencent.liteav.videobase.utils.f("videoDecoder", 1000, new f.a(this) { // from class: com.tencent.liteav.videoconsumer.decoder.ax

        /* renamed from: a  reason: collision with root package name */
        private final aw f23082a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f23082a = this;
        }

        @Override // com.tencent.liteav.videobase.utils.f.a
        public final void a(double d) {
            this.f23082a.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_FRAMERATE, Double.valueOf(d));
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/aw$a.class */
    public final class a {

        /* renamed from: a  reason: collision with root package name */
        long f23079a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f23080c;
        long d;
        final Deque<Long> e;
        final List<Long> f;

        private a() {
            this.f23079a = 0L;
            this.b = 0L;
            this.f23080c = 0L;
            this.d = 0L;
            this.e = new LinkedList();
            this.f = new ArrayList();
        }

        /* synthetic */ a(aw awVar, byte b) {
            this();
        }

        public final void a() {
            this.f23079a = 0L;
            this.b = 0L;
            this.f23080c = 0L;
            this.d = 0L;
            this.e.clear();
            this.f.clear();
        }

        public final void a(long j) {
            if (this.e.isEmpty()) {
                this.d = SystemClock.elapsedRealtime();
            }
            this.e.addLast(Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/aw$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        long f23081a;
        long b;

        private b() {
            this.f23081a = 0L;
            this.b = 0L;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void a() {
            this.b = 0L;
            this.f23081a = 0L;
        }
    }

    public aw(IVideoReporter iVideoReporter) {
        this.b = iVideoReporter;
        this.f23077a += "_" + hashCode();
        a();
    }

    public final void a() {
        this.f23078c.a();
        this.d.a();
        this.e.b();
        this.g = false;
        this.f = null;
        this.g = false;
        this.k = false;
        this.i = 0L;
    }

    public final void a(EncodedVideoFrame encodedVideoFrame) {
        if (!this.k && encodedVideoFrame.isIDRFrame()) {
            this.h = SystemClock.elapsedRealtime();
            this.k = true;
            this.b.notifyEvent(h.b.EVT_VIDEO_DECODE_START_DECODE_FIRST_FRAME, "Start decode first frame", new Object[0]);
            LiteavLog.d(this.f23077a, "received first I frame.");
        }
        if (!this.g) {
            this.i++;
        }
        this.f23078c.a(encodedVideoFrame.pts);
    }

    public final void a(ay.a aVar, boolean z) {
        this.f = aVar;
        ay.a aVar2 = aVar;
        if (z) {
            aVar2 = aVar;
            if (aVar == ay.a.SOFTWARE) {
                aVar2 = ay.a.CUSTOM;
            }
        }
        this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_TYPE, new VideoDecoderDef.DecoderProperty(aVar2, z ? CodecType.H265 : CodecType.H264));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.l == 0) {
            this.l = SystemClock.elapsedRealtime();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.l + TimeUnit.SECONDS.toMillis(1L) < elapsedRealtime) {
            this.l = elapsedRealtime;
            this.b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_ERROR, Long.valueOf(this.j));
            this.j = 0L;
        }
    }
}
