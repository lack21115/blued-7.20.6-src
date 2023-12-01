package com.opos.exoplayer.core.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.j;
import com.opos.exoplayer.core.i.t;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.video.f;
import com.sina.weibo.sdk.constant.WBConstants;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/c.class */
public class c extends com.opos.exoplayer.core.d.b {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f25568c = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, 960, 854, 640, LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE, 480};
    private int A;
    private int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private float G;
    private boolean H;
    private int I;
    private long J;
    private int K;
    b b;
    private final Context d;
    private final d e;
    private final f.a f;
    private final long g;
    private final int h;
    private final boolean i;
    private final long[] j;
    private Format[] k;
    private a l;
    private boolean m;
    private Surface n;
    private Surface o;
    private int p;
    private boolean q;
    private long r;
    private long s;
    private int t;
    private int u;
    private int v;
    private long w;
    private int x;
    private float y;
    private int z;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25569a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f25570c;

        public a(int i, int i2, int i3) {
            this.f25569a = i;
            this.b = i2;
            this.f25570c = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/c$b.class */
    public final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this != c.this.b) {
                return;
            }
            c.this.v();
        }
    }

    public c(Context context, com.opos.exoplayer.core.d.c cVar, long j, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, Handler handler, f fVar, int i) {
        super(2, cVar, bVar, z);
        this.g = j;
        this.h = i;
        this.d = context.getApplicationContext();
        this.e = new d(context);
        this.f = new f.a(handler, fVar);
        this.i = K();
        this.j = new long[10];
        this.J = com.anythink.expressad.exoplayer.b.b;
        this.r = com.anythink.expressad.exoplayer.b.b;
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.p = 1;
        G();
    }

    private void D() {
        this.r = this.g > 0 ? SystemClock.elapsedRealtime() + this.g : -9223372036854775807L;
    }

    private void E() {
        MediaCodec y;
        this.q = false;
        if (u.f25510a < 23 || !this.H || (y = y()) == null) {
            return;
        }
        this.b = new b(y);
    }

    private void F() {
        if (this.q) {
            this.f.a(this.n);
        }
    }

    private void G() {
        this.D = -1;
        this.E = -1;
        this.G = -1.0f;
        this.F = -1;
    }

    private void H() {
        if (this.z == -1 && this.A == -1) {
            return;
        }
        if (this.D == this.z && this.E == this.A && this.F == this.B && this.G == this.C) {
            return;
        }
        this.f.a(this.z, this.A, this.B, this.C);
        this.D = this.z;
        this.E = this.A;
        this.F = this.B;
        this.G = this.C;
    }

    private void I() {
        if (this.D == -1 && this.E == -1) {
            return;
        }
        this.f.a(this.D, this.E, this.F, this.G);
    }

    private void J() {
        if (this.t > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f.a(this.t, elapsedRealtime - this.s);
            this.t = 0;
            this.s = elapsedRealtime;
        }
    }

    private static boolean K() {
        return u.f25510a <= 22 && "foster".equals(u.b) && "NVIDIA".equals(u.f25511c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(String str, int i, int i2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6 = -1;
        if (i != -1) {
            if (i2 == -1) {
                return -1;
            }
            switch (str.hashCode()) {
                case -1664118616:
                    if (str.equals("video/3gpp")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case -1662541442:
                    if (str.equals("video/hevc")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1187890754:
                    if (str.equals("video/mp4v-es")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1331836730:
                    if (str.equals("video/avc")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1599127256:
                    if (str.equals("video/x-vnd.on2.vp8")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1599127257:
                    if (str.equals("video/x-vnd.on2.vp9")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            if (z && !z) {
                if (!z) {
                    if (!z) {
                        if (!z && !z) {
                            return -1;
                        }
                        i4 = i * i2;
                        i5 = 4;
                        i6 = (i4 * 3) / (i5 * 2);
                    }
                } else if ("BRAVIA 4K 2015".equals(u.d)) {
                    return -1;
                } else {
                    i3 = u.a(i, 16) * u.a(i2, 16) * 16 * 16;
                    i4 = i3;
                    i5 = 2;
                    i6 = (i4 * 3) / (i5 * 2);
                }
            }
            i3 = i * i2;
            i4 = i3;
            i5 = 2;
            i6 = (i4 * 3) / (i5 * 2);
        }
        return i6;
    }

    private static Point a(com.opos.exoplayer.core.d.a aVar, Format format) {
        int[] iArr;
        boolean z = format.k > format.j;
        int i = z ? format.k : format.j;
        int i2 = z ? format.j : format.k;
        float f = i2 / i;
        for (int i3 : f25568c) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (u.f25510a >= 21) {
                int i5 = z ? i4 : i3;
                if (z) {
                    i4 = i3;
                }
                Point a2 = aVar.a(i5, i4);
                if (aVar.a(a2.x, a2.y, format.l)) {
                    return a2;
                }
            } else {
                int a3 = u.a(i3, 16) * 16;
                int a4 = u.a(i4, 16) * 16;
                if (a3 * a4 <= com.opos.exoplayer.core.d.d.b()) {
                    int i6 = z ? a4 : a3;
                    if (z) {
                        a4 = a3;
                    }
                    return new Point(i6, a4);
                }
            }
        }
        return null;
    }

    private static void a(MediaCodec mediaCodec, int i) {
        mediaCodec.setVideoScalingMode(i);
    }

    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private static void a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback, true);
        mediaFormat.setInteger(MediaFormat.KEY_AUDIO_SESSION_ID, i);
    }

    private void a(Surface surface) {
        DummySurface dummySurface = surface;
        if (surface == null) {
            dummySurface = this.o;
            if (dummySurface == null) {
                com.opos.exoplayer.core.d.a z = z();
                dummySurface = surface;
                if (z != null) {
                    dummySurface = surface;
                    if (b(z)) {
                        dummySurface = DummySurface.a(this.d, z.d);
                        this.o = dummySurface;
                    }
                }
            }
        }
        if (this.n == dummySurface) {
            if (dummySurface == null || dummySurface == this.o) {
                return;
            }
            I();
            F();
            return;
        }
        this.n = dummySurface;
        int a_ = a_();
        if (a_ == 1 || a_ == 2) {
            MediaCodec y = y();
            if (u.f25510a < 23 || y == null || dummySurface == null || this.m) {
                A();
                x();
            } else {
                a(y, dummySurface);
            }
        }
        if (dummySurface == null || dummySurface == this.o) {
            G();
            E();
            return;
        }
        I();
        E();
        if (a_ == 2) {
            D();
        }
    }

    private static boolean a(String str) {
        if (("deb".equals(u.b) || "flo".equals(u.b) || "mido".equals(u.b) || "santoni".equals(u.b)) && "OMX.qcom.video.decoder.avc".equals(str)) {
            return true;
        }
        if (("tcl_eu".equals(u.b) || "SVP-DTV15".equals(u.b) || "BRAVIA_ATV2".equals(u.b) || u.b.startsWith("panell_") || "F3311".equals(u.b) || "M5c".equals(u.b) || "A7010a48".equals(u.b)) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str)) {
            return true;
        }
        return ("ALE-L21".equals(u.d) || "CAM-L21".equals(u.d)) && "OMX.k3.video.decoder.avc".equals(str);
    }

    private static boolean a(boolean z, Format format, Format format2) {
        if (format.f.equals(format2.f) && f(format) == f(format2)) {
            if (z) {
                return true;
            }
            return format.j == format2.j && format.k == format2.k;
        }
        return false;
    }

    private boolean b(com.opos.exoplayer.core.d.a aVar) {
        if (u.f25510a < 23 || this.H || a(aVar.f25256a)) {
            return false;
        }
        return !aVar.d || DummySurface.a(this.d);
    }

    private static int d(Format format) {
        if (format.g != -1) {
            int size = format.h.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += format.h.get(i2).length;
            }
            return format.g + i;
        }
        return a(format.f, format.j, format.k);
    }

    private static boolean d(long j) {
        return j < -30000;
    }

    private static float e(Format format) {
        if (format.n == -1.0f) {
            return 1.0f;
        }
        return format.n;
    }

    private static boolean e(long j) {
        return j < -500000;
    }

    private static int f(Format format) {
        if (format.m == -1) {
            return 0;
        }
        return format.m;
    }

    @Override // com.opos.exoplayer.core.d.b
    public void A() {
        try {
            super.A();
        } finally {
            this.v = 0;
            Surface surface = this.o;
            if (surface != null) {
                if (this.n == surface) {
                    this.n = null;
                }
                this.o.release();
                this.o = null;
            }
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    public void B() {
        super.B();
        this.v = 0;
    }

    @Override // com.opos.exoplayer.core.d.b
    public int a(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format) {
        String str = format.f;
        int i = 0;
        if (j.b(str)) {
            DrmInitData drmInitData = format.i;
            boolean z = false;
            boolean z2 = false;
            if (drmInitData != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    z = z2;
                    if (i3 >= drmInitData.b) {
                        break;
                    }
                    z2 |= drmInitData.a(i3).f25270c;
                    i2 = i3 + 1;
                }
            }
            com.opos.exoplayer.core.d.a a2 = cVar.a(str, z);
            if (a2 == null) {
                return (!z || cVar.a(str, false) == null) ? 1 : 2;
            } else if (a(bVar, drmInitData)) {
                boolean b2 = a2.b(format.f25001c);
                boolean z3 = b2;
                if (b2) {
                    z3 = b2;
                    if (format.j > 0) {
                        z3 = b2;
                        if (format.k > 0) {
                            if (u.f25510a >= 21) {
                                z3 = a2.a(format.j, format.k, format.l);
                            } else {
                                z3 = format.j * format.k <= com.opos.exoplayer.core.d.d.b();
                                if (!z3) {
                                    com.opos.cmn.an.f.a.b("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.j + "x" + format.k + "] [" + u.e + "]");
                                }
                            }
                        }
                    }
                }
                int i4 = a2.b ? 16 : 8;
                if (a2.f25257c) {
                    i = 32;
                }
                return i4 | i | (z3 ? 4 : 3);
            } else {
                return 2;
            }
        }
        return 0;
    }

    protected MediaFormat a(Format format, a aVar, boolean z, int i) {
        MediaFormat c2 = c(format);
        c2.setInteger(MediaFormat.KEY_MAX_WIDTH, aVar.f25569a);
        c2.setInteger(MediaFormat.KEY_MAX_HEIGHT, aVar.b);
        if (aVar.f25570c != -1) {
            c2.setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, aVar.f25570c);
        }
        if (z) {
            c2.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            a(c2, i);
        }
        return c2;
    }

    protected a a(com.opos.exoplayer.core.d.a aVar, Format format, Format[] formatArr) {
        boolean z;
        int i = format.j;
        int i2 = format.k;
        int d = d(format);
        if (formatArr.length == 1) {
            return new a(i, i2, d);
        }
        int length = formatArr.length;
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i3 >= length) {
                break;
            }
            Format format2 = formatArr[i3];
            int i4 = i;
            int i5 = i2;
            int i6 = d;
            boolean z3 = z;
            if (a(aVar.b, format, format2)) {
                z3 = z | (format2.j == -1 || format2.k == -1);
                i4 = Math.max(i, format2.j);
                i5 = Math.max(i2, format2.k);
                i6 = Math.max(d, d(format2));
            }
            i3++;
            i = i4;
            i2 = i5;
            d = i6;
            z2 = z3;
        }
        int i7 = i;
        int i8 = i2;
        int i9 = d;
        if (z) {
            com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point a2 = a(aVar, format);
            i7 = i;
            i8 = i2;
            i9 = d;
            if (a2 != null) {
                i7 = Math.max(i, a2.x);
                i8 = Math.max(i2, a2.y);
                i9 = Math.max(d, a(format.f, i7, i8));
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i7 + "x" + i8);
            }
        }
        return new a(i7, i8, i9);
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.r.b
    public void a(int i, Object obj) {
        if (i == 1) {
            a((Surface) obj);
        } else if (i != 4) {
            super.a(i, obj);
        } else {
            this.p = ((Integer) obj).intValue();
            MediaCodec y = y();
            if (y != null) {
                a(y, this.p);
            }
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        super.a(j, z);
        E();
        this.u = 0;
        int i = this.K;
        if (i != 0) {
            this.J = this.j[i - 1];
            this.K = 0;
        }
        if (z) {
            D();
        } else {
            this.r = com.anythink.expressad.exoplayer.b.b;
        }
    }

    protected void a(MediaCodec mediaCodec, int i, long j) {
        t.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.a();
        this.f25258a.f++;
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.z = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        this.A = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.C = this.y;
        if (u.f25510a >= 21) {
            int i = this.x;
            if (i == 90 || i == 270) {
                int i2 = this.z;
                this.z = this.A;
                this.A = i2;
                this.C = 1.0f / this.C;
            }
        } else {
            this.B = this.x;
        }
        a(mediaCodec, this.p);
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(com.opos.exoplayer.core.b.e eVar) {
        this.v++;
        if (u.f25510a >= 23 || !this.H) {
            return;
        }
        v();
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a a2 = a(aVar, format, this.k);
        this.l = a2;
        MediaFormat a3 = a(format, a2, this.i, this.I);
        if (this.n == null) {
            com.opos.exoplayer.core.i.a.b(b(aVar));
            if (this.o == null) {
                this.o = DummySurface.a(this.d, aVar.d);
            }
            this.n = this.o;
        }
        mediaCodec.configure(a3, this.n, mediaCrypto, 0);
        if (u.f25510a < 23 || !this.H) {
            return;
        }
        this.b = new b(mediaCodec);
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(String str, long j, long j2) {
        this.f.a(str, j, j2);
        this.m = a(str);
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void a(boolean z) {
        super.a(z);
        int i = q().b;
        this.I = i;
        this.H = i != 0;
        this.f.a(this.f25258a);
        this.e.a();
    }

    @Override // com.opos.exoplayer.core.a
    public void a(Format[] formatArr, long j) {
        this.k = formatArr;
        if (this.J == com.anythink.expressad.exoplayer.b.b) {
            this.J = j;
        } else {
            int i = this.K;
            if (i == this.j.length) {
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.j[this.K - 1]);
            } else {
                this.K = i + 1;
            }
            this.j[this.K - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.opos.exoplayer.core.d.b
    public boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        long nanoTime;
        while (true) {
            int i3 = this.K;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.j;
            if (j3 < jArr[0]) {
                break;
            }
            this.J = jArr[0];
            int i4 = i3 - 1;
            this.K = i4;
            System.arraycopy((Object) jArr, 1, (Object) jArr, 0, i4);
        }
        long j4 = j3 - this.J;
        if (!z) {
            long j5 = j3 - j;
            if (this.n != this.o) {
                long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                boolean z2 = a_() == 2;
                if (!this.q || (z2 && d(j5, elapsedRealtime - this.w))) {
                    if (u.f25510a >= 21) {
                        nanoTime = System.nanoTime();
                        b(mediaCodec, i, j4, nanoTime);
                        return true;
                    }
                    c(mediaCodec, i, j4);
                    return true;
                } else if (z2) {
                    long nanoTime2 = System.nanoTime();
                    long a2 = this.e.a(j3, ((j5 - (elapsedRealtime - j2)) * 1000) + nanoTime2);
                    long j6 = (a2 - nanoTime2) / 1000;
                    if (c(j6, j2) && a(mediaCodec, i, j4, j)) {
                        return false;
                    }
                    if (b(j6, j2)) {
                        b(mediaCodec, i, j4);
                        return true;
                    } else if (u.f25510a >= 21) {
                        if (j6 < 50000) {
                            nanoTime = a2;
                            b(mediaCodec, i, j4, nanoTime);
                            return true;
                        }
                        return false;
                    } else if (j6 < 30000) {
                        if (j6 > 11000) {
                            try {
                                Thread.sleep((j6 - 10000) / 1000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        c(mediaCodec, i, j4);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (!d(j5)) {
                return false;
            }
        }
        a(mediaCodec, i, j4);
        return true;
    }

    protected boolean a(MediaCodec mediaCodec, int i, long j, long j2) {
        int b2 = b(j2);
        if (b2 == 0) {
            return false;
        }
        this.f25258a.i++;
        b(b2 + this.v);
        B();
        return true;
    }

    @Override // com.opos.exoplayer.core.d.b
    public boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return a(z, format, format2) && format2.j <= this.l.f25569a && format2.k <= this.l.b && d(format2) <= this.l.f25570c;
    }

    @Override // com.opos.exoplayer.core.d.b
    public boolean a(com.opos.exoplayer.core.d.a aVar) {
        return this.n != null || b(aVar);
    }

    protected void b(int i) {
        this.f25258a.g += i;
        this.t += i;
        this.u += i;
        this.f25258a.h = Math.max(this.u, this.f25258a.h);
        if (this.t >= this.h) {
            J();
        }
    }

    protected void b(MediaCodec mediaCodec, int i, long j) {
        t.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        t.a();
        b(1);
    }

    protected void b(MediaCodec mediaCodec, int i, long j, long j2) {
        H();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        t.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        this.f25258a.e++;
        this.u = 0;
        v();
    }

    @Override // com.opos.exoplayer.core.d.b
    public void b(Format format) {
        super.b(format);
        this.f.a(format);
        this.y = e(format);
        this.x = f(format);
    }

    protected boolean b(long j, long j2) {
        return d(j);
    }

    @Override // com.opos.exoplayer.core.d.b
    public void c(long j) {
        this.v--;
    }

    protected void c(MediaCodec mediaCodec, int i, long j) {
        H();
        t.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        t.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        this.f25258a.e++;
        this.u = 0;
        v();
    }

    protected boolean c(long j, long j2) {
        return e(j);
    }

    protected boolean d(long j, long j2) {
        return d(j) && j2 > 100000;
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void n() {
        super.n();
        this.t = 0;
        this.s = SystemClock.elapsedRealtime();
        this.w = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void o() {
        this.r = com.anythink.expressad.exoplayer.b.b;
        J();
        super.o();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void p() {
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.J = com.anythink.expressad.exoplayer.b.b;
        this.K = 0;
        G();
        E();
        this.e.b();
        this.b = null;
        this.H = false;
        try {
            super.p();
        } finally {
            this.f25258a.a();
            this.f.b(this.f25258a);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.s
    public boolean t() {
        Surface surface;
        if (super.t() && (this.q || (((surface = this.o) != null && this.n == surface) || y() == null || this.H))) {
            this.r = com.anythink.expressad.exoplayer.b.b;
            return true;
        } else if (this.r == com.anythink.expressad.exoplayer.b.b) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() >= this.r) {
                this.r = com.anythink.expressad.exoplayer.b.b;
                return false;
            }
            return true;
        }
    }

    void v() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.f.a(this.n);
    }
}
