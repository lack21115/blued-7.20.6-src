package com.opos.exoplayer.core.d;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.b.e;
import com.opos.exoplayer.core.d.d;
import com.opos.exoplayer.core.h;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.t;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/b.class */
public abstract class b extends com.opos.exoplayer.core.a {
    private static final byte[] b = u.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private ByteBuffer D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;

    /* renamed from: a  reason: collision with root package name */
    protected com.opos.exoplayer.core.b.d f25258a;

    /* renamed from: c  reason: collision with root package name */
    private final c f25259c;
    private final com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> d;
    private final boolean e;
    private final e f;
    private final e g;
    private final l h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private Format k;
    private com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> l;
    private com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> m;
    private MediaCodec n;
    private com.opos.exoplayer.core.d.a o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/d/b$a.class */
    public static class a extends Exception {

        /* renamed from: a  reason: collision with root package name */
        public final String f25260a;
        public final boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final String f25261c;
        public final String d;

        public a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.f25260a = format.f;
            this.b = z;
            this.f25261c = null;
            this.d = a(i);
        }

        public a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.f25260a = format.f;
            this.b = z;
            this.f25261c = str;
            this.d = u.f25510a >= 21 ? a(th) : null;
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

    public b(int i, c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z) {
        super(i);
        com.opos.exoplayer.core.i.a.b(u.f25510a >= 16);
        this.f25259c = (c) com.opos.exoplayer.core.i.a.a(cVar);
        this.d = bVar;
        this.e = z;
        this.f = new e(0);
        this.g = e.e();
        this.h = new l();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.G = 0;
        this.H = 0;
    }

    private void D() {
        if (u.f25510a < 21) {
            this.y = this.n.getInputBuffers();
            this.z = this.n.getOutputBuffers();
        }
    }

    private void E() {
        if (u.f25510a < 21) {
            this.y = null;
            this.z = null;
        }
    }

    private boolean F() {
        return this.C >= 0;
    }

    private void G() {
        this.B = -1;
        this.f.b = null;
    }

    private void H() {
        this.C = -1;
        this.D = null;
    }

    private void I() {
        MediaFormat outputFormat = this.n.getOutputFormat();
        if (this.p != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.x = true;
            return;
        }
        if (this.v) {
            outputFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, 1);
        }
        a(this.n, outputFormat);
    }

    private void J() {
        if (u.f25510a < 21) {
            this.z = this.n.getOutputBuffers();
        }
    }

    private void K() {
        if (this.H == 2) {
            A();
            x();
            return;
        }
        this.L = true;
        w();
    }

    private static MediaCodec.CryptoInfo a(e eVar, int i) {
        MediaCodec.CryptoInfo a2 = eVar.f25073a.a();
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

    private static void a(MediaFormat mediaFormat) {
        mediaFormat.setInteger("priority", 0);
    }

    private void a(a aVar) {
        throw h.a(aVar, r());
    }

    private static boolean a(String str) {
        if (u.f25510a >= 18) {
            if (u.f25510a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
                return true;
            }
            if (u.f25510a == 19 && u.d.startsWith("SM-G800")) {
                return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
            }
            return false;
        }
        return true;
    }

    private static boolean a(String str, Format format) {
        return u.f25510a < 21 && format.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private int b(String str) {
        if (u.f25510a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (u.d.startsWith("SM-T585") || u.d.startsWith("SM-A510") || u.d.startsWith("SM-A520") || u.d.startsWith("SM-J700"))) {
            return 2;
        }
        if (u.f25510a < 24) {
            if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
                return ("flounder".equals(u.b) || "flounder_lte".equals(u.b) || "grouper".equals(u.b) || "tilapia".equals(u.b)) ? 1 : 0;
            }
            return 0;
        }
        return 0;
    }

    private ByteBuffer b(int i) {
        return u.f25510a >= 21 ? this.n.getInputBuffer(i) : this.y[i];
    }

    private boolean b(long j, long j2) {
        boolean a2;
        int dequeueOutputBuffer;
        if (!F()) {
            if (this.u && this.J) {
                try {
                    dequeueOutputBuffer = this.n.dequeueOutputBuffer(this.j, C());
                } catch (IllegalStateException e) {
                    K();
                    if (!this.L) {
                        return false;
                    }
                    A();
                    return false;
                }
            } else {
                dequeueOutputBuffer = this.n.dequeueOutputBuffer(this.j, C());
            }
            if (dequeueOutputBuffer >= 0) {
                if (this.x) {
                    this.x = false;
                    this.n.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return true;
                } else if ((this.j.flags & 4) == 0) {
                    this.C = dequeueOutputBuffer;
                    ByteBuffer c2 = c(dequeueOutputBuffer);
                    this.D = c2;
                    if (c2 != null) {
                        c2.position(this.j.offset);
                        this.D.limit(this.j.offset + this.j.size);
                    }
                    this.E = d(this.j.presentationTimeUs);
                }
            } else if (dequeueOutputBuffer == -2) {
                I();
                return true;
            } else if (dequeueOutputBuffer == -3) {
                J();
                return true;
            } else if (!this.s) {
                return false;
            } else {
                if (!this.K && this.H != 2) {
                    return false;
                }
            }
            K();
            return false;
        }
        if (this.u && this.J) {
            try {
                a2 = a(j, j2, this.n, this.D, this.C, this.j.flags, this.j.presentationTimeUs, this.E);
            } catch (IllegalStateException e2) {
                K();
                if (!this.L) {
                    return false;
                }
                A();
                return false;
            }
        } else {
            a2 = a(j, j2, this.n, this.D, this.C, this.j.flags, this.j.presentationTimeUs, this.E);
        }
        if (a2) {
            c(this.j.presentationTimeUs);
            H();
            return true;
        }
        return false;
    }

    private static boolean b(String str, Format format) {
        return u.f25510a <= 18 && format.r == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private boolean b(boolean z) {
        if (this.l != null) {
            if (z || !this.e) {
                int a2 = this.l.a();
                if (a2 != 1) {
                    return a2 != 4;
                }
                throw h.a(this.l.b(), r());
            }
            return false;
        }
        return false;
    }

    private ByteBuffer c(int i) {
        return u.f25510a >= 21 ? this.n.getOutputBuffer(i) : this.z[i];
    }

    private static boolean c(String str) {
        if (u.f25510a <= 17) {
            return "OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str);
        }
        return false;
    }

    private boolean d(long j) {
        int size = this.i.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (this.i.get(i2).longValue() == j) {
                this.i.remove(i2);
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean d(String str) {
        if (u.f25510a > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (u.f25510a > 19 || !"hb2000".equals(u.b)) {
                return false;
            }
            return "OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str);
        }
        return true;
    }

    private static boolean e(String str) {
        return u.f25510a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private boolean v() {
        int position;
        int a2;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec == null || this.H == 2 || this.K) {
            return false;
        }
        if (this.B < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.B = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            this.f.b = b(dequeueInputBuffer);
            this.f.a();
        }
        if (this.H == 1) {
            if (!this.s) {
                this.J = true;
                this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                G();
            }
            this.H = 2;
            return false;
        } else if (this.w) {
            this.w = false;
            this.f.b.put(b);
            this.n.queueInputBuffer(this.B, 0, b.length, 0L, 0);
            G();
            this.I = true;
            return true;
        } else {
            if (this.M) {
                a2 = -4;
                position = 0;
            } else {
                if (this.G == 1) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.k.h.size()) {
                            break;
                        }
                        this.f.b.put(this.k.h.get(i2));
                        i = i2 + 1;
                    }
                    this.G = 2;
                }
                position = this.f.b.position();
                a2 = a(this.h, this.f, false);
            }
            if (a2 != -3) {
                if (a2 == -5) {
                    if (this.G == 2) {
                        this.f.a();
                        this.G = 1;
                    }
                    b(this.h.f25515a);
                    return true;
                } else if (this.f.c()) {
                    if (this.G == 2) {
                        this.f.a();
                        this.G = 1;
                    }
                    this.K = true;
                    if (!this.I) {
                        K();
                        return false;
                    }
                    try {
                        if (this.s) {
                            return false;
                        }
                        this.J = true;
                        this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                        G();
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw h.a(e, r());
                    }
                } else if (this.N && !this.f.d()) {
                    this.f.a();
                    if (this.G == 2) {
                        this.G = 1;
                        return true;
                    }
                    return true;
                } else {
                    this.N = false;
                    boolean g = this.f.g();
                    boolean b2 = b(g);
                    this.M = b2;
                    if (b2) {
                        return false;
                    }
                    if (this.q && !g) {
                        k.a(this.f.b);
                        if (this.f.b.position() == 0) {
                            return true;
                        }
                        this.q = false;
                    }
                    try {
                        long j = this.f.f25074c;
                        if (this.f.d_()) {
                            this.i.add(Long.valueOf(j));
                        }
                        this.f.h();
                        a(this.f);
                        if (g) {
                            this.n.queueSecureInputBuffer(this.B, 0, a(this.f, position), j, 0);
                        } else {
                            this.n.queueInputBuffer(this.B, 0, this.f.b.limit(), j, 0);
                        }
                        G();
                        this.I = true;
                        this.G = 0;
                        this.f25258a.f25072c++;
                        return true;
                    } catch (MediaCodec.CryptoException e2) {
                        throw h.a(e2, r());
                    }
                }
            }
            return false;
        }
    }

    public void A() {
        this.A = com.anythink.expressad.exoplayer.b.b;
        G();
        H();
        this.M = false;
        this.E = false;
        this.i.clear();
        E();
        this.o = null;
        this.F = false;
        this.I = false;
        this.q = false;
        this.r = false;
        this.p = 0;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.J = false;
        this.G = 0;
        this.H = 0;
        if (this.n != null) {
            this.f25258a.b++;
            try {
                this.n.stop();
                try {
                    this.n.release();
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar = this.l;
                    if (aVar == null || this.m == aVar) {
                        return;
                    }
                    try {
                        this.d.a(aVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar2 = this.l;
                    if (aVar2 != null && this.m != aVar2) {
                        try {
                            this.d.a(aVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.n.release();
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar3 = this.l;
                    if (aVar3 != null && this.m != aVar3) {
                        try {
                            this.d.a(aVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.n = null;
                    com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> aVar4 = this.l;
                    if (aVar4 != null && this.m != aVar4) {
                        try {
                            this.d.a(aVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void B() {
        this.A = com.anythink.expressad.exoplayer.b.b;
        G();
        H();
        this.N = true;
        this.M = false;
        this.E = false;
        this.i.clear();
        this.w = false;
        this.x = false;
        if (this.r || ((this.t && this.J) || this.H != 0)) {
            A();
            x();
        } else {
            this.n.flush();
            this.I = false;
        }
        if (!this.F || this.k == null) {
            return;
        }
        this.G = 1;
    }

    protected long C() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.t
    public final int a(Format format) {
        try {
            return a(this.f25259c, this.d, format);
        } catch (d.a e) {
            throw h.a(e, r());
        }
    }

    protected abstract int a(c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format);

    public com.opos.exoplayer.core.d.a a(c cVar, Format format, boolean z) {
        return cVar.a(format.f, z);
    }

    @Override // com.opos.exoplayer.core.s
    public void a(long j, long j2) {
        if (this.L) {
            w();
            return;
        }
        if (this.k == null) {
            this.g.a();
            int a2 = a(this.h, this.g, true);
            if (a2 != -5) {
                if (a2 == -4) {
                    com.opos.exoplayer.core.i.a.b(this.g.c());
                    this.K = true;
                    K();
                    return;
                }
                return;
            }
            b(this.h.f25515a);
        }
        x();
        if (this.n != null) {
            t.a("drainAndFeed");
            do {
            } while (b(j, j2));
            do {
            } while (v());
            t.a();
        } else {
            this.f25258a.d += b(j);
            this.g.a();
            int a3 = a(this.h, this.g, false);
            if (a3 == -5) {
                b(this.h.f25515a);
            } else if (a3 == -4) {
                com.opos.exoplayer.core.i.a.b(this.g.c());
                this.K = true;
                K();
            }
        }
        this.f25258a.a();
    }

    @Override // com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        this.K = false;
        this.L = false;
        if (this.n != null) {
            B();
        }
    }

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void a(e eVar) {
    }

    protected abstract void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    protected void a(String str, long j, long j2) {
    }

    @Override // com.opos.exoplayer.core.a
    public void a(boolean z) {
        this.f25258a = new com.opos.exoplayer.core.b.d();
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    protected boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    protected boolean a(com.opos.exoplayer.core.d.a aVar) {
        return true;
    }

    public void b(Format format) {
        MediaCodec mediaCodec;
        Format format2 = this.k;
        this.k = format;
        if (!u.a(format.i, format2 == null ? null : format2.i)) {
            if (this.k.i != null) {
                com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar = this.d;
                if (bVar == null) {
                    throw h.a(new IllegalStateException("Media requires a DrmSessionManager"), r());
                }
                com.opos.exoplayer.core.drm.a<com.opos.exoplayer.core.drm.d> a2 = bVar.a(Looper.myLooper(), this.k.i);
                this.m = a2;
                if (a2 == this.l) {
                    this.d.a(a2);
                }
            } else {
                this.m = null;
            }
        }
        if (this.m != this.l || (mediaCodec = this.n) == null || !a(mediaCodec, this.o.b, format2, this.k)) {
            if (this.I) {
                this.H = 1;
                return;
            }
            A();
            x();
            return;
        }
        this.F = true;
        this.G = 1;
        int i = this.p;
        boolean z = true;
        if (i != 2) {
            z = i == 1 && this.k.j == format2.j && this.k.k == format2.k;
        }
        this.w = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaFormat c(Format format) {
        MediaFormat b2 = format.b();
        if (u.f25510a >= 23) {
            a(b2);
        }
        return b2;
    }

    protected void c(long j) {
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.t
    public final int m() {
        return 8;
    }

    @Override // com.opos.exoplayer.core.a
    public void n() {
    }

    @Override // com.opos.exoplayer.core.a
    public void o() {
    }

    @Override // com.opos.exoplayer.core.a
    public void p() {
        this.k = null;
        try {
            A();
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.m != null && this.m != this.l) {
                        this.d.a(this.m);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.s
    public boolean t() {
        if (this.k == null || this.M) {
            return false;
        }
        if (s() || F()) {
            return true;
        }
        return this.A != com.anythink.expressad.exoplayer.b.b && SystemClock.elapsedRealtime() < this.A;
    }

    @Override // com.opos.exoplayer.core.s
    public boolean u() {
        return this.L;
    }

    protected void w() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void x() {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.d.b.x():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec y() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.opos.exoplayer.core.d.a z() {
        return this.o;
    }
}
