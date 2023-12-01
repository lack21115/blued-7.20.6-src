package com.anythink.expressad.exoplayer.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import com.anythink.expressad.exoplayer.d.f;
import com.anythink.expressad.exoplayer.d.g;
import com.anythink.expressad.exoplayer.d.k;
import com.anythink.expressad.exoplayer.f.d;
import com.anythink.expressad.exoplayer.k.ad;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.m;
import com.anythink.expressad.exoplayer.n;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/b.class */
public abstract class b extends com.anythink.expressad.exoplayer.a {
    private static final int A = 1;
    private static final int B = 2;
    private static final byte[] C = af.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int D = 32;
    protected static final int n = 0;
    protected static final int o = 1;
    protected static final int p = 3;
    private static final String r = "MediaCodecRenderer";
    private static final long s = 1000;
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 0;
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 0;
    private final com.anythink.expressad.exoplayer.f.c E;
    private final g<k> F;
    private final boolean G;
    private final com.anythink.expressad.exoplayer.c.e H;
    private final com.anythink.expressad.exoplayer.c.e I;
    private final n J;
    private final List<Long> K;
    private final MediaCodec.BufferInfo L;
    private m M;
    private f<k> N;
    private f<k> O;
    private MediaCodec P;
    private com.anythink.expressad.exoplayer.f.a Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private ByteBuffer[] aa;
    private ByteBuffer[] ab;
    private long ac;
    private int ad;
    private int ae;
    private ByteBuffer af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    protected com.anythink.expressad.exoplayer.c.d q;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/b$a.class */
    @interface a {
    }

    /* renamed from: com.anythink.expressad.exoplayer.f.b$b  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/b$b.class */
    public static final class C0056b extends Exception {
        private static final int e = -50000;
        private static final int f = -49999;
        private static final int g = -49998;

        /* renamed from: a  reason: collision with root package name */
        public final String f4492a;
        public final boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4493c;
        public final String d;

        public C0056b(m mVar, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + mVar, th);
            this.f4492a = mVar.h;
            this.b = z;
            this.f4493c = null;
            String str = i < 0 ? "neg_" : "";
            this.d = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i);
        }

        public C0056b(m mVar, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + mVar, th);
            this.f4492a = mVar.h;
            this.b = z;
            this.f4493c = str;
            String str2 = null;
            if (af.f4793a >= 21) {
                str2 = null;
                if (th instanceof MediaCodec.CodecException) {
                    str2 = ((MediaCodec.CodecException) th).getDiagnosticInfo();
                }
            }
            this.d = str2;
        }

        private static String a(int i) {
            String str = i < 0 ? "neg_" : "";
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i);
        }

        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/b$c.class */
    public @interface c {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/b$d.class */
    @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f/b$e.class */
    @interface e {
    }

    public b(int i, com.anythink.expressad.exoplayer.f.c cVar, g<k> gVar, boolean z2) {
        super(i);
        com.anythink.expressad.exoplayer.k.a.b(af.f4793a >= 16);
        this.E = (com.anythink.expressad.exoplayer.f.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
        this.F = gVar;
        this.G = false;
        this.H = new com.anythink.expressad.exoplayer.c.e(0);
        this.I = com.anythink.expressad.exoplayer.c.e.e();
        this.J = new n();
        this.K = new ArrayList();
        this.L = new MediaCodec.BufferInfo();
        this.ai = 0;
        this.aj = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x0244 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0246  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean C() {
        /*
            Method dump skipped, instructions count: 823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.b.C():boolean");
    }

    private void D() {
        if (af.f4793a < 21) {
            this.aa = this.P.getInputBuffers();
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void E() {
        if (af.f4793a < 21) {
            this.aa = null;
            this.ab = null;
        }
    }

    private boolean F() {
        return this.ae >= 0;
    }

    private void G() {
        this.ad = -1;
        this.H.e = null;
    }

    private void H() {
        this.ae = -1;
        this.af = null;
    }

    private static long I() {
        return 0L;
    }

    private void J() {
        MediaFormat outputFormat = this.P.getOutputFormat();
        if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.Z = true;
            return;
        }
        if (this.X) {
            outputFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, 1);
        }
        a(this.P, outputFormat);
    }

    private void K() {
        if (af.f4793a < 21) {
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void L() {
        if (this.aj == 2) {
            A();
            x();
            return;
        }
        this.an = true;
        w();
    }

    private static boolean M() {
        if ("Amazon".equals(af.f4794c)) {
            return "AFTM".equals(af.d) || "AFTB".equals(af.d);
        }
        return false;
    }

    private static MediaCodec.CryptoInfo a(com.anythink.expressad.exoplayer.c.e eVar, int i) {
        MediaCodec.CryptoInfo a2 = eVar.d.a();
        if (i == 0) {
            return a2;
        }
        if (a2.numBytesOfClearData == null) {
            a2.numBytesOfClearData = new int[1];
        }
        int[] iArr = a2.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return a2;
    }

    private void a(C0056b c0056b) {
        throw com.anythink.expressad.exoplayer.g.a(c0056b, s());
    }

    private static boolean a(String str) {
        if (af.f4793a >= 18) {
            if (af.f4793a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
                return true;
            }
            if (af.f4793a == 19 && af.d.startsWith("SM-G800")) {
                return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
            }
            return false;
        }
        return true;
    }

    private static boolean a(String str, m mVar) {
        return af.f4793a < 21 && mVar.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static int b(String str) {
        if (af.f4793a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (af.d.startsWith("SM-T585") || af.d.startsWith("SM-A510") || af.d.startsWith("SM-A520") || af.d.startsWith("SM-J700"))) {
            return 2;
        }
        if (af.f4793a < 24) {
            if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
                return ("flounder".equals(af.b) || "flounder_lte".equals(af.b) || "grouper".equals(af.b) || "tilapia".equals(af.b)) ? 1 : 0;
            }
            return 0;
        }
        return 0;
    }

    private ByteBuffer b(int i) {
        return af.f4793a >= 21 ? this.P.getInputBuffer(i) : this.aa[i];
    }

    private boolean b(long j, long j2) {
        boolean a2;
        int dequeueOutputBuffer;
        boolean z2;
        if (!F()) {
            if (this.W && this.al) {
                try {
                    dequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
                } catch (IllegalStateException e2) {
                    L();
                    if (this.an) {
                        A();
                        return false;
                    }
                    return false;
                }
            } else {
                dequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
            }
            if (dequeueOutputBuffer < 0) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.P.getOutputFormat();
                    if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.Z = true;
                        return true;
                    }
                    if (this.X) {
                        outputFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, 1);
                    }
                    a(this.P, outputFormat);
                    return true;
                } else if (dequeueOutputBuffer == -3) {
                    if (af.f4793a < 21) {
                        this.ab = this.P.getOutputBuffers();
                        return true;
                    }
                    return true;
                } else if (this.U) {
                    if (this.am || this.aj == 2) {
                        L();
                        return false;
                    }
                    return false;
                } else {
                    return false;
                }
            } else if (this.Z) {
                this.Z = false;
                this.P.releaseOutputBuffer(dequeueOutputBuffer, false);
                return true;
            } else if (this.L.size == 0 && (this.L.flags & 4) != 0) {
                L();
                return false;
            } else {
                this.ae = dequeueOutputBuffer;
                ByteBuffer outputBuffer = af.f4793a >= 21 ? this.P.getOutputBuffer(dequeueOutputBuffer) : this.ab[dequeueOutputBuffer];
                this.af = outputBuffer;
                if (outputBuffer != null) {
                    outputBuffer.position(this.L.offset);
                    this.af.limit(this.L.offset + this.L.size);
                }
                long j3 = this.L.presentationTimeUs;
                int size = this.K.size();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        z2 = false;
                        break;
                    } else if (this.K.get(i2).longValue() == j3) {
                        this.K.remove(i2);
                        z2 = true;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
                this.ag = z2;
            }
        }
        if (this.W && this.al) {
            try {
                a2 = a(j, j2, this.P, this.af, this.ae, this.L.flags, this.L.presentationTimeUs, this.ag);
            } catch (IllegalStateException e3) {
                L();
                if (this.an) {
                    A();
                    return false;
                }
                return false;
            }
        } else {
            a2 = a(j, j2, this.P, this.af, this.ae, this.L.flags, this.L.presentationTimeUs, this.ag);
        }
        if (a2) {
            c(this.L.presentationTimeUs);
            boolean z3 = (this.L.flags & 4) != 0;
            H();
            if (z3) {
                L();
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean b(com.anythink.expressad.exoplayer.f.a aVar) {
        String str = aVar.f4491c;
        if (af.f4793a > 17 || !("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) {
            return "Amazon".equals(af.f4794c) && "AFTS".equals(af.d) && aVar.h;
        }
        return true;
    }

    private static boolean b(String str, m mVar) {
        return af.f4793a <= 18 && mVar.u == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private boolean b(boolean z2) {
        if (this.N != null) {
            if (z2 || !this.G) {
                int e2 = this.N.e();
                if (e2 != 1) {
                    return e2 != 4;
                }
                throw com.anythink.expressad.exoplayer.g.a(this.N.f(), s());
            }
            return false;
        }
        return false;
    }

    private ByteBuffer c(int i) {
        return af.f4793a >= 21 ? this.P.getOutputBuffer(i) : this.ab[i];
    }

    private static boolean c(String str) {
        if (af.f4793a > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (af.f4793a > 19 || !"hb2000".equals(af.b)) {
                return false;
            }
            return "OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str);
        }
        return true;
    }

    private boolean d(long j) {
        int size = this.K.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (this.K.get(i2).longValue() == j) {
                this.K.remove(i2);
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean d(String str) {
        return af.f4793a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public void A() {
        this.ac = com.anythink.expressad.exoplayer.b.b;
        G();
        H();
        this.ao = false;
        this.ag = false;
        this.K.clear();
        if (af.f4793a < 21) {
            this.aa = null;
            this.ab = null;
        }
        this.Q = null;
        this.ah = false;
        this.ak = false;
        this.S = false;
        this.T = false;
        this.R = 0;
        this.U = false;
        this.V = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.al = false;
        this.ai = 0;
        this.aj = 0;
        if (this.P != null) {
            this.q.b++;
            try {
                this.P.stop();
                try {
                    this.P.release();
                    this.P = null;
                    f<k> fVar = this.N;
                    if (fVar == null || this.O == fVar) {
                        return;
                    }
                    try {
                        this.F.a(fVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.P = null;
                    f<k> fVar2 = this.N;
                    if (fVar2 != null && this.O != fVar2) {
                        try {
                            this.F.a(fVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.P.release();
                    this.P = null;
                    f<k> fVar3 = this.N;
                    if (fVar3 != null && this.O != fVar3) {
                        try {
                            this.F.a(fVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.P = null;
                    f<k> fVar4 = this.N;
                    if (fVar4 != null && this.O != fVar4) {
                        try {
                            this.F.a(fVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void B() {
        this.ac = com.anythink.expressad.exoplayer.b.b;
        G();
        H();
        this.ap = true;
        this.ao = false;
        this.ag = false;
        this.K.clear();
        this.Y = false;
        this.Z = false;
        if (this.T || (this.V && this.al)) {
            A();
            x();
        } else if (this.aj != 0) {
            A();
            x();
        } else {
            this.P.flush();
            this.ak = false;
        }
        if (!this.ah || this.M == null) {
            return;
        }
        this.ai = 1;
    }

    protected int a(com.anythink.expressad.exoplayer.f.a aVar, m mVar, m mVar2) {
        return 0;
    }

    protected abstract int a(com.anythink.expressad.exoplayer.f.c cVar, g<k> gVar, m mVar);

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(m mVar) {
        try {
            return a(this.E, this.F, mVar);
        } catch (d.b e2) {
            throw com.anythink.expressad.exoplayer.g.a(e2, s());
        }
    }

    public com.anythink.expressad.exoplayer.f.a a(com.anythink.expressad.exoplayer.f.c cVar, m mVar, boolean z2) {
        return cVar.a(mVar.h, z2);
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final void a(long j, long j2) {
        if (this.an) {
            w();
            return;
        }
        if (this.M == null) {
            this.I.a();
            int a2 = a(this.J, this.I, true);
            if (a2 != -5) {
                if (a2 == -4) {
                    com.anythink.expressad.exoplayer.k.a.b(this.I.c());
                    this.am = true;
                    L();
                    return;
                }
                return;
            }
            b(this.J.f4882a);
        }
        x();
        if (this.P != null) {
            ad.a("drainAndFeed");
            do {
            } while (b(j, j2));
            do {
            } while (C());
            ad.a();
            return;
        }
        this.q.d += b(j);
        this.I.a();
        int a3 = a(this.J, this.I, false);
        if (a3 == -5) {
            b(this.J.f4882a);
        } else if (a3 == -4) {
            com.anythink.expressad.exoplayer.k.a.b(this.I.c());
            this.am = true;
            L();
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void a(long j, boolean z2) {
        this.am = false;
        this.an = false;
        if (this.P != null) {
            B();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void a(com.anythink.expressad.exoplayer.c.e eVar) {
    }

    protected abstract void a(com.anythink.expressad.exoplayer.f.a aVar, MediaCodec mediaCodec, m mVar, MediaCrypto mediaCrypto);

    protected void a(String str, long j, long j2) {
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void a(boolean z2) {
        this.q = new com.anythink.expressad.exoplayer.c.d();
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z2);

    protected boolean a(com.anythink.expressad.exoplayer.f.a aVar) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0105, code lost:
        if (r5.M.n == r0.n) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.anythink.expressad.exoplayer.m r6) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.b.b(com.anythink.expressad.exoplayer.m):void");
    }

    protected void c(long j) {
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.z
    public final int m() {
        return 8;
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void n() {
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void o() {
    }

    @Override // com.anythink.expressad.exoplayer.a
    public void p() {
        this.M = null;
        try {
            A();
            try {
                if (this.N != null) {
                    this.F.a(this.N);
                }
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.N != null) {
                    this.F.a(this.N);
                }
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.O != null && this.O != this.N) {
                        this.F.a(this.O);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.y
    public boolean u() {
        if (this.M == null || this.ao) {
            return false;
        }
        if (t() || F()) {
            return true;
        }
        return this.ac != com.anythink.expressad.exoplayer.b.b && SystemClock.elapsedRealtime() < this.ac;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public boolean v() {
        return this.an;
    }

    protected void w() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x() {
        m mVar;
        MediaCrypto mediaCrypto;
        boolean z2;
        MediaCrypto a2;
        boolean a3;
        if (this.P != null || (mVar = this.M) == null) {
            return;
        }
        this.N = this.O;
        String str = mVar.h;
        f<k> fVar = this.N;
        if (fVar != null) {
            k g = fVar.g();
            if (g != null) {
                a2 = g.a();
                a3 = g.a(str);
            } else if (this.N.f() == null) {
                return;
            } else {
                a2 = null;
                a3 = false;
            }
            z2 = a3;
            mediaCrypto = a2;
            if ("Amazon".equals(af.f4794c) && ("AFTM".equals(af.d) || "AFTB".equals(af.d))) {
                int e2 = this.N.e();
                if (e2 == 1) {
                    throw com.anythink.expressad.exoplayer.g.a(this.N.f(), s());
                }
                z2 = a3;
                mediaCrypto = a2;
                if (e2 != 4) {
                    return;
                }
            }
        } else {
            mediaCrypto = null;
            z2 = false;
        }
        if (this.Q == null) {
            try {
                com.anythink.expressad.exoplayer.f.a a4 = a(this.E, this.M, z2);
                this.Q = a4;
                if (a4 == null && z2) {
                    com.anythink.expressad.exoplayer.f.a a5 = a(this.E, this.M, false);
                    this.Q = a5;
                    if (a5 != null) {
                        Log.w(r, "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.Q.f4491c + ".");
                    }
                }
            } catch (d.b e3) {
                a(new C0056b(this.M, e3, z2, -49998));
            }
            if (this.Q == null) {
                a(new C0056b(this.M, (Throwable) null, z2, -49999));
            }
        }
        if (a(this.Q)) {
            String str2 = this.Q.f4491c;
            this.R = (af.f4793a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str2) && (af.d.startsWith("SM-T585") || af.d.startsWith("SM-A510") || af.d.startsWith("SM-A520") || af.d.startsWith("SM-J700"))) ? 2 : (af.f4793a >= 24 || !(("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(af.b) || "flounder_lte".equals(af.b) || "grouper".equals(af.b) || "tilapia".equals(af.b)))) ? 0 : 1;
            this.S = af.f4793a < 21 && this.M.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            this.T = af.f4793a < 18 || (af.f4793a == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (af.f4793a == 19 && af.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            com.anythink.expressad.exoplayer.f.a aVar = this.Q;
            String str3 = aVar.f4491c;
            this.U = (af.f4793a <= 17 && ("OMX.rk.video_decoder.avc".equals(str3) || "OMX.allwinner.video.decoder.avc".equals(str3))) || ("Amazon".equals(af.f4794c) && "AFTS".equals(af.d) && aVar.h);
            this.V = (af.f4793a <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (af.f4793a <= 19 && "hb2000".equals(af.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.W = af.f4793a == 21 && "OMX.google.aac.decoder".equals(str2);
            m mVar2 = this.M;
            boolean z3 = false;
            if (af.f4793a <= 18) {
                z3 = false;
                if (mVar2.u == 1) {
                    z3 = false;
                    if ("OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                        z3 = true;
                    }
                }
            }
            this.X = z3;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ad.a("createCodec:".concat(String.valueOf(str2)));
                this.P = MediaCodec.createByCodecName(str2);
                ad.a();
                ad.a("configureCodec");
                a(this.Q, this.P, this.M, mediaCrypto);
                ad.a();
                ad.a("startCodec");
                this.P.start();
                ad.a();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                if (af.f4793a < 21) {
                    this.aa = this.P.getInputBuffers();
                    this.ab = this.P.getOutputBuffers();
                }
            } catch (Exception e4) {
                a(new C0056b(this.M, e4, z2, str2));
            }
            this.ac = a_() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            G();
            H();
            this.ap = true;
            this.q.f4385a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec y() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.anythink.expressad.exoplayer.f.a z() {
        return this.Q;
    }
}
