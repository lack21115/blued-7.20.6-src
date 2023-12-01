package com.anythink.expressad.exoplayer.l;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.anythink.expressad.exoplayer.d.k;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.anythink.expressad.exoplayer.l.h;
import com.anythink.expressad.exoplayer.m;
import com.blued.das.live.LiveProtos;
import com.sina.weibo.sdk.constant.WBConstants;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/e.class */
public class e extends com.anythink.expressad.exoplayer.f.b {
    private static boolean A = false;
    private static final String s = "MediaCodecVideoRenderer";
    private static final String t = "crop-left";
    private static final String u = "crop-right";
    private static final String v = "crop-bottom";
    private static final String w = "crop-top";
    private static final int[] x = {WBConstants.SDK_NEW_PAY_VERSION, 1600, 1440, 1280, 960, 854, 640, LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE, 480};
    private static final int y = 10;
    private static boolean z;
    private final Context B;
    private final f C;
    private final h.a D;
    private final long E;
    private final int F;
    private final boolean G;
    private final long[] H;
    private final long[] I;
    private a J;
    private boolean K;
    private Surface L;
    private Surface M;
    private int N;
    private boolean O;
    private long P;
    private long Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private long V;
    private int W;
    private float X;
    private int Y;
    private int Z;
    private int aa;
    private float ab;
    private int ac;
    private int ad;
    private int ae;
    private float af;
    private boolean ag;
    private int ah;
    private long ai;
    private long aj;
    private int ak;
    b r;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4861a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4862c;

        public a(int i, int i2, int i3) {
            this.f4861a = i;
            this.b = i2;
            this.f4862c = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/e$b.class */
    public final class b implements MediaCodec.OnFrameRenderedListener {
        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        /* synthetic */ b(e eVar, MediaCodec mediaCodec, byte b) {
            this(mediaCodec);
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this != e.this.r) {
                return;
            }
            e.this.C();
        }
    }

    private e(Context context, com.anythink.expressad.exoplayer.f.c cVar) {
        this(context, cVar, (byte) 0);
    }

    private e(Context context, com.anythink.expressad.exoplayer.f.c cVar, byte b2) {
        this(context, cVar, null, null);
    }

    public e(Context context, com.anythink.expressad.exoplayer.f.c cVar, long j, com.anythink.expressad.exoplayer.d.g<k> gVar, Handler handler, h hVar, int i) {
        super(2, cVar, gVar, false);
        this.E = j;
        this.F = i;
        Context applicationContext = context.getApplicationContext();
        this.B = applicationContext;
        this.C = new f(applicationContext);
        this.D = new h.a(handler, hVar);
        boolean z2 = false;
        if (af.f4793a <= 22) {
            z2 = false;
            if ("foster".equals(af.b)) {
                z2 = false;
                if ("NVIDIA".equals(af.f4794c)) {
                    z2 = true;
                }
            }
        }
        this.G = z2;
        this.H = new long[10];
        this.I = new long[10];
        this.aj = com.anythink.expressad.exoplayer.b.b;
        this.ai = com.anythink.expressad.exoplayer.b.b;
        this.Q = com.anythink.expressad.exoplayer.b.b;
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.N = 1;
        G();
    }

    private e(Context context, com.anythink.expressad.exoplayer.f.c cVar, Handler handler, h hVar) {
        this(context, cVar, 0L, null, handler, hVar, -1);
    }

    private void D() {
        this.Q = this.E > 0 ? SystemClock.elapsedRealtime() + this.E : -9223372036854775807L;
    }

    private void E() {
        MediaCodec y2;
        this.O = false;
        if (af.f4793a < 23 || !this.ag || (y2 = y()) == null) {
            return;
        }
        this.r = new b(this, y2, (byte) 0);
    }

    private void F() {
        if (this.O) {
            this.D.a(this.L);
        }
    }

    private void G() {
        this.ac = -1;
        this.ad = -1;
        this.af = -1.0f;
        this.ae = -1;
    }

    private void H() {
        if (this.Y == -1 && this.Z == -1) {
            return;
        }
        if (this.ac == this.Y && this.ad == this.Z && this.ae == this.aa && this.af == this.ab) {
            return;
        }
        this.D.a(this.Y, this.Z, this.aa, this.ab);
        this.ac = this.Y;
        this.ad = this.Z;
        this.ae = this.aa;
        this.af = this.ab;
    }

    private void I() {
        if (this.ac == -1 && this.ad == -1) {
            return;
        }
        this.D.a(this.ac, this.ad, this.ae, this.af);
    }

    private void J() {
        if (this.S > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.D.a(this.S, elapsedRealtime - this.R);
            this.S = 0;
            this.R = elapsedRealtime;
        }
    }

    private static boolean K() {
        return af.f4793a <= 22 && "foster".equals(af.b) && "NVIDIA".equals(af.f4794c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(com.anythink.expressad.exoplayer.f.a aVar, String str, int i, int i2) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    z2 = false;
                    break;
                }
                z2 = true;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            default:
                z2 = true;
                break;
        }
        if (z2 && !z2) {
            if (z2) {
                if ("BRAVIA 4K 2015".equals(af.d)) {
                    return -1;
                }
                if ("Amazon".equals(af.f4794c)) {
                    if ("KFSOWI".equals(af.d)) {
                        return -1;
                    }
                    if ("AFTS".equals(af.d) && aVar.h) {
                        return -1;
                    }
                }
                i3 = af.a(i, 16) * af.a(i2, 16) * 16 * 16;
                i4 = i3;
                i5 = 2;
                return (i4 * 3) / (i5 * 2);
            } else if (!z2) {
                if (z2 || z2) {
                    i4 = i * i2;
                    i5 = 4;
                    return (i4 * 3) / (i5 * 2);
                }
                return -1;
            }
        }
        i3 = i * i2;
        i4 = i3;
        i5 = 2;
        return (i4 * 3) / (i5 * 2);
    }

    private static Point a(com.anythink.expressad.exoplayer.f.a aVar, m mVar) {
        int[] iArr;
        boolean z2 = mVar.n > mVar.m;
        int i = z2 ? mVar.n : mVar.m;
        int i2 = z2 ? mVar.m : mVar.n;
        float f = i2 / i;
        for (int i3 : x) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (af.f4793a >= 21) {
                int i5 = z2 ? i4 : i3;
                if (z2) {
                    i4 = i3;
                }
                Point a2 = aVar.a(i5, i4);
                if (aVar.a(a2.x, a2.y, mVar.o)) {
                    return a2;
                }
            } else {
                int a3 = af.a(i3, 16) * 16;
                int a4 = af.a(i4, 16) * 16;
                if (a3 * a4 <= com.anythink.expressad.exoplayer.f.d.b()) {
                    int i6 = z2 ? a4 : a3;
                    if (z2) {
                        a4 = a3;
                    }
                    return new Point(i6, a4);
                }
            }
        }
        return null;
    }

    private static MediaFormat a(m mVar, a aVar, boolean z2, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(MediaFormat.KEY_MIME, mVar.h);
        mediaFormat.setInteger("width", mVar.m);
        mediaFormat.setInteger("height", mVar.n);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.j);
        float f = mVar.o;
        if (f != -1.0f) {
            mediaFormat.setFloat(MediaFormat.KEY_FRAME_RATE, f);
        }
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.p);
        com.anythink.expressad.exoplayer.l.b bVar = mVar.t;
        if (bVar != null) {
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.f4855c);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.f4854a);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger(MediaFormat.KEY_MAX_WIDTH, aVar.f4861a);
        mediaFormat.setInteger(MediaFormat.KEY_MAX_HEIGHT, aVar.b);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, MediaFormat.KEY_MAX_INPUT_SIZE, aVar.f4862c);
        if (af.f4793a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z2) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback, true);
            mediaFormat.setInteger(MediaFormat.KEY_AUDIO_SESSION_ID, i);
        }
        return mediaFormat;
    }

    private static a a(com.anythink.expressad.exoplayer.f.a aVar, m mVar, m[] mVarArr) {
        boolean z2;
        int i = mVar.m;
        int i2 = mVar.n;
        int b2 = b(aVar, mVar);
        if (mVarArr.length == 1) {
            return new a(i, i2, b2);
        }
        int length = mVarArr.length;
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            z2 = z3;
            if (i3 >= length) {
                break;
            }
            m mVar2 = mVarArr[i3];
            int i4 = i;
            int i5 = i2;
            int i6 = b2;
            boolean z4 = z2;
            if (a(aVar.f, mVar, mVar2)) {
                z4 = z2 | (mVar2.m == -1 || mVar2.n == -1);
                i4 = Math.max(i, mVar2.m);
                i5 = Math.max(i2, mVar2.n);
                i6 = Math.max(b2, b(aVar, mVar2));
            }
            i3++;
            i = i4;
            i2 = i5;
            b2 = i6;
            z3 = z4;
        }
        int i7 = i;
        int i8 = i2;
        int i9 = b2;
        if (z2) {
            Log.w(s, "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point a2 = a(aVar, mVar);
            i7 = i;
            i8 = i2;
            i9 = b2;
            if (a2 != null) {
                i7 = Math.max(i, a2.x);
                i8 = Math.max(i2, a2.y);
                i9 = Math.max(b2, a(aVar, mVar.h, i7, i8));
                Log.w(s, "Codec max resolution adjusted to: " + i7 + "x" + i8);
            }
        }
        return new a(i7, i8, i9);
    }

    private void a(MediaCodec mediaCodec, int i) {
        ad.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        ad.a();
        this.q.f++;
    }

    private void a(MediaCodec mediaCodec, int i, long j) {
        H();
        ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        ad.a();
        this.V = SystemClock.elapsedRealtime() * 1000;
        this.q.e++;
        this.T = 0;
        C();
    }

    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private static void a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback, true);
        mediaFormat.setInteger(MediaFormat.KEY_AUDIO_SESSION_ID, i);
    }

    private void a(Surface surface) {
        c cVar = surface;
        if (surface == null) {
            cVar = this.M;
            if (cVar == null) {
                com.anythink.expressad.exoplayer.f.a z2 = z();
                cVar = surface;
                if (z2 != null) {
                    cVar = surface;
                    if (b(z2)) {
                        cVar = c.a(this.B, z2.h);
                        this.M = cVar;
                    }
                }
            }
        }
        if (this.L == cVar) {
            if (cVar == null || cVar == this.M) {
                return;
            }
            I();
            if (this.O) {
                this.D.a(this.L);
                return;
            }
            return;
        }
        this.L = cVar;
        int a_ = a_();
        if (a_ == 1 || a_ == 2) {
            MediaCodec y2 = y();
            if (af.f4793a < 23 || y2 == null || cVar == null || this.K) {
                A();
                x();
            } else {
                y2.setOutputSurface(cVar);
            }
        }
        if (cVar == null || cVar == this.M) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0d85  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 3469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.l.e.a(java.lang.String):boolean");
    }

    private static boolean a(boolean z2, m mVar, m mVar2) {
        if (mVar.h.equals(mVar2.h) && mVar.p == mVar2.p) {
            return (z2 || (mVar.m == mVar2.m && mVar.n == mVar2.n)) && af.a(mVar.t, mVar2.t);
        }
        return false;
    }

    private static int b(com.anythink.expressad.exoplayer.f.a aVar, m mVar) {
        if (mVar.i != -1) {
            int size = mVar.j.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += mVar.j.get(i2).length;
            }
            return mVar.i + i;
        }
        return a(aVar, mVar.h, mVar.m, mVar.n);
    }

    private void b(int i) {
        this.q.g += i;
        this.S += i;
        this.T += i;
        this.q.h = Math.max(this.T, this.q.h);
        if (this.S >= this.F) {
            J();
        }
    }

    private void b(MediaCodec mediaCodec, int i) {
        ad.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        ad.a();
        b(1);
    }

    private static boolean b(long j, long j2) {
        return g(j) && j2 > 100000;
    }

    private boolean b(com.anythink.expressad.exoplayer.f.a aVar) {
        if (af.f4793a < 23 || this.ag || a(aVar.f4491c)) {
            return false;
        }
        return !aVar.h || c.a(this.B);
    }

    private void c(MediaCodec mediaCodec, int i) {
        H();
        ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        ad.a();
        this.V = SystemClock.elapsedRealtime() * 1000;
        this.q.e++;
        this.T = 0;
        C();
    }

    private static boolean d(long j) {
        return g(j);
    }

    private static boolean e(long j) {
        return j < -500000;
    }

    private boolean f(long j) {
        int b2 = b(j);
        if (b2 == 0) {
            return false;
        }
        this.q.i++;
        b(this.U + b2);
        B();
        return true;
    }

    private static boolean g(long j) {
        return j < -30000;
    }

    private static boolean h(long j) {
        return j < -500000;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void A() {
        try {
            super.A();
        } finally {
            this.U = 0;
            Surface surface = this.M;
            if (surface != null) {
                if (this.L == surface) {
                    this.L = null;
                }
                this.M.release();
                this.M = null;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void B() {
        super.B();
        this.U = 0;
    }

    final void C() {
        if (this.O) {
            return;
        }
        this.O = true;
        this.D.a(this.L);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final int a(com.anythink.expressad.exoplayer.f.a aVar, m mVar, m mVar2) {
        if (!a(aVar.f, mVar, mVar2) || mVar2.m > this.J.f4861a || mVar2.n > this.J.b || b(aVar, mVar2) > this.J.f4862c) {
            return 0;
        }
        return mVar.b(mVar2) ? 1 : 3;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final int a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<k> gVar, m mVar) {
        boolean z2;
        String str = mVar.h;
        int i = 0;
        if (o.b(str)) {
            com.anythink.expressad.exoplayer.d.e eVar = mVar.k;
            if (eVar != null) {
                int i2 = 0;
                boolean z3 = false;
                while (true) {
                    z2 = z3;
                    if (i2 >= eVar.b) {
                        break;
                    }
                    z3 |= eVar.a(i2).d;
                    i2++;
                }
            } else {
                z2 = false;
            }
            com.anythink.expressad.exoplayer.f.a a2 = cVar.a(str, z2);
            if (a2 == null) {
                return (!z2 || cVar.a(str, false) == null) ? 1 : 2;
            } else if (a(gVar, eVar)) {
                boolean b2 = a2.b(mVar.e);
                boolean z4 = b2;
                if (b2) {
                    z4 = b2;
                    if (mVar.m > 0) {
                        z4 = b2;
                        if (mVar.n > 0) {
                            if (af.f4793a >= 21) {
                                z4 = a2.a(mVar.m, mVar.n, mVar.o);
                            } else {
                                z4 = mVar.m * mVar.n <= com.anythink.expressad.exoplayer.f.d.b();
                                if (!z4) {
                                    Log.d(s, "FalseCheck [legacyFrameSize, " + mVar.m + "x" + mVar.n + "] [" + af.e + "]");
                                }
                            }
                        }
                    }
                }
                int i3 = a2.f ? 16 : 8;
                if (a2.g) {
                    i = 32;
                }
                return (z4 ? 4 : 3) | i3 | i;
            } else {
                return 2;
            }
        }
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i, Object obj) {
        if (i != 1) {
            if (i != 4) {
                super.a(i, obj);
                return;
            }
            this.N = ((Integer) obj).intValue();
            MediaCodec y2 = y();
            if (y2 != null) {
                y2.setVideoScalingMode(this.N);
                return;
            }
            return;
        }
        Surface surface = (Surface) obj;
        c cVar = surface;
        if (surface == null) {
            cVar = this.M;
            if (cVar == null) {
                com.anythink.expressad.exoplayer.f.a z2 = z();
                cVar = surface;
                if (z2 != null) {
                    cVar = surface;
                    if (b(z2)) {
                        cVar = c.a(this.B, z2.h);
                        this.M = cVar;
                    }
                }
            }
        }
        if (this.L == cVar) {
            if (cVar == null || cVar == this.M) {
                return;
            }
            I();
            if (this.O) {
                this.D.a(this.L);
                return;
            }
            return;
        }
        this.L = cVar;
        int a_ = a_();
        if (a_ == 1 || a_ == 2) {
            MediaCodec y3 = y();
            if (af.f4793a < 23 || y3 == null || cVar == null || this.K) {
                A();
                x();
            } else {
                y3.setOutputSurface(cVar);
            }
        }
        if (cVar == null || cVar == this.M) {
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

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z2) {
        super.a(j, z2);
        E();
        this.P = com.anythink.expressad.exoplayer.b.b;
        this.T = 0;
        this.ai = com.anythink.expressad.exoplayer.b.b;
        int i = this.ak;
        if (i != 0) {
            this.aj = this.H[i - 1];
            this.ak = 0;
        }
        if (z2) {
            D();
        } else {
            this.Q = com.anythink.expressad.exoplayer.b.b;
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z2 = mediaFormat.containsKey(u) && mediaFormat.containsKey(t) && mediaFormat.containsKey(v) && mediaFormat.containsKey(w);
        this.Y = z2 ? (mediaFormat.getInteger(u) - mediaFormat.getInteger(t)) + 1 : mediaFormat.getInteger("width");
        this.Z = z2 ? (mediaFormat.getInteger(v) - mediaFormat.getInteger(w)) + 1 : mediaFormat.getInteger("height");
        this.ab = this.X;
        if (af.f4793a >= 21) {
            int i = this.W;
            if (i == 90 || i == 270) {
                int i2 = this.Y;
                this.Y = this.Z;
                this.Z = i2;
                this.ab = 1.0f / this.ab;
            }
        } else {
            this.aa = this.W;
        }
        mediaCodec.setVideoScalingMode(this.N);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(com.anythink.expressad.exoplayer.c.e eVar) {
        this.U++;
        this.ai = Math.max(eVar.f, this.ai);
        if (af.f4793a >= 23 || !this.ag) {
            return;
        }
        C();
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(com.anythink.expressad.exoplayer.f.a aVar, MediaCodec mediaCodec, m mVar, MediaCrypto mediaCrypto) {
        boolean z2;
        a aVar2;
        m[] q = q();
        int i = mVar.m;
        int i2 = mVar.n;
        int b2 = b(aVar, mVar);
        if (q.length == 1) {
            aVar2 = new a(i, i2, b2);
        } else {
            int length = q.length;
            int i3 = 0;
            boolean z3 = false;
            while (true) {
                z2 = z3;
                if (i3 >= length) {
                    break;
                }
                m mVar2 = q[i3];
                int i4 = i;
                int i5 = i2;
                int i6 = b2;
                boolean z4 = z2;
                if (a(aVar.f, mVar, mVar2)) {
                    z4 = z2 | (mVar2.m == -1 || mVar2.n == -1);
                    i4 = Math.max(i, mVar2.m);
                    i5 = Math.max(i2, mVar2.n);
                    i6 = Math.max(b2, b(aVar, mVar2));
                }
                i3++;
                i = i4;
                i2 = i5;
                b2 = i6;
                z3 = z4;
            }
            int i7 = i;
            int i8 = i2;
            int i9 = b2;
            if (z2) {
                Log.w(s, "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
                Point a2 = a(aVar, mVar);
                i7 = i;
                i8 = i2;
                i9 = b2;
                if (a2 != null) {
                    i7 = Math.max(i, a2.x);
                    i8 = Math.max(i2, a2.y);
                    i9 = Math.max(b2, a(aVar, mVar.h, i7, i8));
                    Log.w(s, "Codec max resolution adjusted to: " + i7 + "x" + i8);
                }
            }
            aVar2 = new a(i7, i8, i9);
        }
        this.J = aVar2;
        boolean z5 = this.G;
        int i10 = this.ah;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(MediaFormat.KEY_MIME, mVar.h);
        mediaFormat.setInteger("width", mVar.m);
        mediaFormat.setInteger("height", mVar.n);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.j);
        float f = mVar.o;
        if (f != -1.0f) {
            mediaFormat.setFloat(MediaFormat.KEY_FRAME_RATE, f);
        }
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.p);
        com.anythink.expressad.exoplayer.l.b bVar = mVar.t;
        if (bVar != null) {
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.f4855c);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.f4854a);
            com.anythink.expressad.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger(MediaFormat.KEY_MAX_WIDTH, aVar2.f4861a);
        mediaFormat.setInteger(MediaFormat.KEY_MAX_HEIGHT, aVar2.b);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, MediaFormat.KEY_MAX_INPUT_SIZE, aVar2.f4862c);
        if (af.f4793a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z5) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i10 != 0) {
            mediaFormat.setFeatureEnabled(MediaCodecInfo.CodecCapabilities.FEATURE_TunneledPlayback, true);
            mediaFormat.setInteger(MediaFormat.KEY_AUDIO_SESSION_ID, i10);
        }
        if (this.L == null) {
            com.anythink.expressad.exoplayer.k.a.b(b(aVar));
            if (this.M == null) {
                this.M = c.a(this.B, aVar.h);
            }
            this.L = this.M;
        }
        mediaCodec.configure(mediaFormat, this.L, mediaCrypto, 0);
        if (af.f4793a < 23 || !this.ag) {
            return;
        }
        this.r = new b(this, mediaCodec, (byte) 0);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(String str, long j, long j2) {
        this.D.a(str, j, j2);
        this.K = a(str);
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(boolean z2) {
        super.a(z2);
        int i = r().b;
        this.ah = i;
        this.ag = i != 0;
        this.D.a(this.q);
        this.C.a();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(m[] mVarArr, long j) {
        if (this.aj == com.anythink.expressad.exoplayer.b.b) {
            this.aj = j;
        } else {
            int i = this.ak;
            if (i == this.H.length) {
                Log.w(s, "Too many stream changes, so dropping offset: " + this.H[this.ak - 1]);
            } else {
                this.ak = i + 1;
            }
            long[] jArr = this.H;
            int i2 = this.ak;
            jArr[i2 - 1] = j;
            this.I[i2 - 1] = this.ai;
        }
        super.a(mVarArr, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
        if ((g(r0) && r0 - r10.V > 100000) != false) goto L74;
     */
    @Override // com.anythink.expressad.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(long r11, long r13, android.media.MediaCodec r15, java.nio.ByteBuffer r16, int r17, int r18, long r19, boolean r21) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.l.e.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final boolean a(com.anythink.expressad.exoplayer.f.a aVar) {
        return this.L != null || b(aVar);
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void b(m mVar) {
        super.b(mVar);
        this.D.a(mVar);
        this.X = mVar.q;
        this.W = mVar.p;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void c(long j) {
        this.U--;
        while (true) {
            int i = this.ak;
            if (i == 0 || j < this.I[0]) {
                return;
            }
            long[] jArr = this.H;
            this.aj = jArr[0];
            int i2 = i - 1;
            this.ak = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.I;
            System.arraycopy(jArr2, 1, jArr2, 0, this.ak);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void n() {
        super.n();
        this.S = 0;
        this.R = SystemClock.elapsedRealtime();
        this.V = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void o() {
        this.Q = com.anythink.expressad.exoplayer.b.b;
        J();
        super.o();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void p() {
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.aj = com.anythink.expressad.exoplayer.b.b;
        this.ai = com.anythink.expressad.exoplayer.b.b;
        this.ak = 0;
        G();
        E();
        this.C.b();
        this.r = null;
        this.ag = false;
        try {
            super.p();
        } finally {
            this.D.b(this.q);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean u() {
        Surface surface;
        if (super.u() && (this.O || (((surface = this.M) != null && this.L == surface) || y() == null || this.ag))) {
            this.Q = com.anythink.expressad.exoplayer.b.b;
            return true;
        } else if (this.Q == com.anythink.expressad.exoplayer.b.b) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.Q) {
                return true;
            }
            this.Q = com.anythink.expressad.exoplayer.b.b;
            return false;
        }
    }
}
