package com.anythink.expressad.exoplayer.b;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.anythink.expressad.exoplayer.b.h;
import com.anythink.expressad.exoplayer.b.j;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.v;
import com.tencent.thumbplayer.api.TPErrorCode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/l.class */
public final class l implements h {
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4362c = false;
    private static final long d = 250000;
    private static final long e = 750000;
    private static final long f = 250000;
    private static final int g = 4;
    private static final int h = -2;
    private static final int i = 0;
    private static final int j = 1;
    private static final int k = 1;
    private static final int l = 1;
    private static final String m = "AudioTrack";
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private h.c A;
    private AudioTrack B;
    private AudioTrack C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private com.anythink.expressad.exoplayer.b.b J;
    private boolean K;
    private boolean L;
    private int M;
    private v N;
    private v O;
    private long P;
    private long Q;
    private ByteBuffer R;
    private int S;
    private int T;
    private long U;
    private long V;
    private int W;
    private long X;
    private long Y;
    private int Z;
    private int aa;
    private long ab;
    private float ac;
    private com.anythink.expressad.exoplayer.b.f[] ad;
    private ByteBuffer[] ae;
    private ByteBuffer af;
    private ByteBuffer ag;
    private byte[] ah;
    private int ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private int am;
    private boolean an;
    private long ao;
    private final com.anythink.expressad.exoplayer.b.c q;
    private final a r;
    private final boolean s;
    private final k t;
    private final u u;
    private final com.anythink.expressad.exoplayer.b.f[] v;
    private final com.anythink.expressad.exoplayer.b.f[] w;
    private final ConditionVariable x;
    private final j y;
    private final ArrayDeque<d> z;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/l$a.class */
    public interface a {
        long a(long j);

        v a(v vVar);

        com.anythink.expressad.exoplayer.b.f[] a();

        long b();
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/l$b.class */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final com.anythink.expressad.exoplayer.b.f[] f4365a;
        private final q b = new q();

        /* renamed from: c  reason: collision with root package name */
        private final t f4366c;

        public b(com.anythink.expressad.exoplayer.b.f... fVarArr) {
            this.f4365a = (com.anythink.expressad.exoplayer.b.f[]) Arrays.copyOf(fVarArr, fVarArr.length + 2);
            t tVar = new t();
            this.f4366c = tVar;
            com.anythink.expressad.exoplayer.b.f[] fVarArr2 = this.f4365a;
            fVarArr2[fVarArr.length] = this.b;
            fVarArr2[fVarArr.length + 1] = tVar;
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final long a(long j) {
            return this.f4366c.a(j);
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final v a(v vVar) {
            this.b.a(vVar.d);
            return new v(this.f4366c.a(vVar.b), this.f4366c.b(vVar.f4902c), vVar.d);
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final com.anythink.expressad.exoplayer.b.f[] a() {
            return this.f4365a;
        }

        @Override // com.anythink.expressad.exoplayer.b.l.a
        public final long b() {
            return this.b.j();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/l$c.class */
    public static final class c extends RuntimeException {
        private c(String str) {
            super(str);
        }

        /* synthetic */ c(String str, byte b) {
            this(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/l$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final v f4367a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final long f4368c;

        private d(v vVar, long j, long j2) {
            this.f4367a = vVar;
            this.b = j;
            this.f4368c = j2;
        }

        /* synthetic */ d(v vVar, long j, long j2, byte b) {
            this(vVar, j, j2);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/l$e.class */
    final class e implements j.a {
        private e() {
        }

        /* synthetic */ e(l lVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(int i, long j) {
            if (l.this.A != null) {
                l.this.A.a(i, j, SystemClock.elapsedRealtime() - l.this.ao);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(long j) {
            Log.w(l.m, "Ignoring impossibly large audio latency: ".concat(String.valueOf(j)));
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void a(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + l.this.r() + ", " + l.this.s();
            if (l.f4362c) {
                throw new c(str, (byte) 0);
            }
            Log.w(l.m, str);
        }

        @Override // com.anythink.expressad.exoplayer.b.j.a
        public final void b(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + l.this.r() + ", " + l.this.s();
            if (l.f4362c) {
                throw new c(str, (byte) 0);
            }
            Log.w(l.m, str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/l$f.class */
    @interface f {
    }

    private l(com.anythink.expressad.exoplayer.b.c cVar, a aVar) {
        this.q = cVar;
        this.r = (a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        this.s = false;
        this.x = new ConditionVariable(true);
        this.y = new j(new e(this, (byte) 0));
        this.t = new k();
        this.u = new u();
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new p(), this.t, this.u);
        Collections.addAll(arrayList, aVar.a());
        this.v = (com.anythink.expressad.exoplayer.b.f[]) arrayList.toArray(new com.anythink.expressad.exoplayer.b.f[arrayList.size()]);
        this.w = new com.anythink.expressad.exoplayer.b.f[]{new n()};
        this.ac = 1.0f;
        this.aa = 0;
        this.J = com.anythink.expressad.exoplayer.b.b.f4333a;
        this.am = 0;
        this.O = v.f4901a;
        this.aj = -1;
        this.ad = new com.anythink.expressad.exoplayer.b.f[0];
        this.ae = new ByteBuffer[0];
        this.z = new ArrayDeque<>();
    }

    public l(com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.b.f[] fVarArr) {
        this(cVar, fVarArr, (byte) 0);
    }

    private l(com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.b.f[] fVarArr, byte b2) {
        this(cVar, new b(fVarArr));
    }

    private static int a(int i2, ByteBuffer byteBuffer) {
        if (i2 == 7 || i2 == 8) {
            return m.a(byteBuffer);
        }
        if (i2 == 5) {
            return com.anythink.expressad.exoplayer.b.a.a();
        }
        if (i2 == 6) {
            return com.anythink.expressad.exoplayer.b.a.a(byteBuffer);
        }
        if (i2 == 14) {
            int b2 = com.anythink.expressad.exoplayer.b.a.b(byteBuffer);
            if (b2 == -1) {
                return 0;
            }
            return com.anythink.expressad.exoplayer.b.a.a(byteBuffer, b2) * 16;
        }
        throw new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(i2)));
    }

    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (this.R == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.R = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.R.putInt(1431633921);
        }
        if (this.S == 0) {
            this.R.putInt(4, i2);
            this.R.putLong(8, j2 * 1000);
            this.R.position(0);
            this.S = i2;
        }
        int remaining = this.R.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.R, remaining, 1);
            if (write < 0) {
                this.S = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int write2 = audioTrack.write(byteBuffer, i2, 1);
        if (write2 < 0) {
            this.S = 0;
            return write2;
        }
        this.S -= write2;
        return write2;
    }

    private void a(long j2) {
        ByteBuffer byteBuffer;
        int length = this.ad.length;
        int i2 = length;
        while (true) {
            int i3 = i2;
            if (i3 < 0) {
                return;
            }
            if (i3 > 0) {
                byteBuffer = this.ae[i3 - 1];
            } else {
                byteBuffer = this.af;
                if (byteBuffer == null) {
                    byteBuffer = com.anythink.expressad.exoplayer.b.f.f4342a;
                }
            }
            if (i3 == length) {
                b(byteBuffer, j2);
            } else {
                com.anythink.expressad.exoplayer.b.f fVar = this.ad[i3];
                fVar.a(byteBuffer);
                ByteBuffer f2 = fVar.f();
                this.ae[i3] = f2;
                if (f2.hasRemaining()) {
                    i2 = i3 + 1;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i2 = i3 - 1;
        }
    }

    private static void a(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private long b(long j2) {
        d dVar;
        long j3;
        long a2;
        d dVar2 = null;
        while (true) {
            dVar = dVar2;
            if (this.z.isEmpty() || j2 < this.z.getFirst().f4368c) {
                break;
            }
            dVar2 = this.z.remove();
        }
        if (dVar != null) {
            this.O = dVar.f4367a;
            this.Q = dVar.f4368c;
            this.P = dVar.b - this.ab;
        }
        if (this.O.b == 1.0f) {
            return (j2 + this.P) - this.Q;
        }
        if (this.z.isEmpty()) {
            long j4 = this.P;
            a2 = this.r.a(j2 - this.Q);
            j3 = j4;
        } else {
            j3 = this.P;
            a2 = af.a(j2 - this.Q, this.O.b);
        }
        return j3 + a2;
    }

    private static void b(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void b(ByteBuffer byteBuffer, long j2) {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.ag;
            int i2 = 0;
            if (byteBuffer2 != null) {
                com.anythink.expressad.exoplayer.k.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.ag = byteBuffer;
                if (af.f4793a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.ah;
                    if (bArr == null || bArr.length < remaining) {
                        this.ah = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.ah, 0, remaining);
                    byteBuffer.position(position);
                    this.ai = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (af.f4793a < 21) {
                int b2 = this.y.b(this.X);
                if (b2 > 0) {
                    int write = this.C.write(this.ah, this.ai, Math.min(remaining2, b2));
                    i2 = write;
                    if (write > 0) {
                        this.ai += write;
                        byteBuffer.position(byteBuffer.position() + write);
                        i2 = write;
                    }
                }
            } else if (this.an) {
                com.anythink.expressad.exoplayer.k.a.b(j2 != com.anythink.expressad.exoplayer.b.b);
                i2 = a(this.C, byteBuffer, remaining2, j2);
            } else {
                i2 = this.C.write(byteBuffer, remaining2, 1);
            }
            this.ao = SystemClock.elapsedRealtime();
            if (i2 < 0) {
                throw new h.d(i2);
            }
            if (this.D) {
                this.X += i2;
            }
            if (i2 == remaining2) {
                if (!this.D) {
                    this.Y += this.Z;
                }
                this.ag = null;
            }
        }
    }

    private long c(long j2) {
        return j2 + e(this.r.b());
    }

    private long d(long j2) {
        return (j2 * 1000000) / this.F;
    }

    private static AudioTrack d(int i2) {
        return new AudioTrack(3, TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 4, 2, 2, 0, i2);
    }

    private long e(long j2) {
        return (j2 * 1000000) / this.G;
    }

    private long f(long j2) {
        return (j2 * this.G) / 1000000;
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        com.anythink.expressad.exoplayer.b.f[] v = v();
        int length = v.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                int size = arrayList.size();
                this.ad = (com.anythink.expressad.exoplayer.b.f[]) arrayList.toArray(new com.anythink.expressad.exoplayer.b.f[size]);
                this.ae = new ByteBuffer[size];
                l();
                return;
            }
            com.anythink.expressad.exoplayer.b.f fVar = v[i3];
            if (fVar.a()) {
                arrayList.add(fVar);
            } else {
                fVar.h();
            }
            i2 = i3 + 1;
        }
    }

    private void l() {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            com.anythink.expressad.exoplayer.b.f[] fVarArr = this.ad;
            if (i3 >= fVarArr.length) {
                return;
            }
            com.anythink.expressad.exoplayer.b.f fVar = fVarArr[i3];
            fVar.h();
            this.ae[i3] = fVar.f();
            i2 = i3 + 1;
        }
    }

    private void m() {
        this.x.block();
        AudioTrack t = t();
        this.C = t;
        int audioSessionId = t.getAudioSessionId();
        if (b && af.f4793a < 21) {
            AudioTrack audioTrack = this.B;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                p();
            }
            if (this.B == null) {
                this.B = new AudioTrack(3, TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 4, 2, 2, 0, audioSessionId);
            }
        }
        if (this.am != audioSessionId) {
            this.am = audioSessionId;
            h.c cVar = this.A;
            if (cVar != null) {
                cVar.a(audioSessionId);
            }
        }
        this.O = this.L ? this.r.a(this.O) : v.f4901a;
        k();
        this.y.a(this.C, this.I, this.W, this.M);
        o();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0056 -> B:9:0x001f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean n() {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.aj
            r1 = -1
            if (r0 != r1) goto L24
            r0 = r5
            boolean r0 = r0.K
            if (r0 == 0) goto L14
            r0 = 0
            r6 = r0
            goto L1a
        L14:
            r0 = r5
            com.anythink.expressad.exoplayer.b.f[] r0 = r0.ad
            int r0 = r0.length
            r6 = r0
        L1a:
            r0 = r5
            r1 = r6
            r0.aj = r1
        L1f:
            r0 = 1
            r6 = r0
            goto L26
        L24:
            r0 = 0
            r6 = r0
        L26:
            r0 = r5
            int r0 = r0.aj
            r7 = r0
            r0 = r5
            com.anythink.expressad.exoplayer.b.f[] r0 = r0.ad
            r8 = r0
            r0 = r7
            r1 = r8
            int r1 = r1.length
            if (r0 >= r1) goto L63
            r0 = r8
            r1 = r7
            r0 = r0[r1]
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L44
            r0 = r8
            r0.e()
        L44:
            r0 = r5
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.a(r1)
            r0 = r8
            boolean r0 = r0.g()
            if (r0 != 0) goto L56
            r0 = 0
            return r0
        L56:
            r0 = r5
            r1 = r5
            int r1 = r1.aj
            r2 = 1
            int r1 = r1 + r2
            r0.aj = r1
            goto L1f
        L63:
            r0 = r5
            java.nio.ByteBuffer r0 = r0.ag
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L7d
            r0 = r5
            r1 = r8
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.b(r1, r2)
            r0 = r5
            java.nio.ByteBuffer r0 = r0.ag
            if (r0 == 0) goto L7d
            r0 = 0
            return r0
        L7d:
            r0 = r5
            r1 = -1
            r0.aj = r1
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.l.n():boolean");
    }

    private void o() {
        if (q()) {
            if (af.f4793a >= 21) {
                this.C.setVolume(this.ac);
                return;
            }
            AudioTrack audioTrack = this.C;
            float f2 = this.ac;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.anythink.expressad.exoplayer.b.l$2] */
    private void p() {
        final AudioTrack audioTrack = this.B;
        if (audioTrack == null) {
            return;
        }
        this.B = null;
        new Thread() { // from class: com.anythink.expressad.exoplayer.b.l.2
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                audioTrack.release();
            }
        }.start();
    }

    private boolean q() {
        return this.C != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long r() {
        return this.D ? this.U / this.T : this.V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long s() {
        return this.D ? this.X / this.W : this.Y;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00e5 -> B:22:0x00d0). Please submit an issue!!! */
    private AudioTrack t() {
        AudioTrack audioTrack;
        if (af.f4793a >= 21) {
            AudioAttributes build = this.an ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.J.a();
            AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.H).setEncoding(this.I).setSampleRate(this.G).build();
            int i2 = this.am;
            if (i2 == 0) {
                i2 = 0;
            }
            audioTrack = new AudioTrack(build, build2, this.M, 1, i2);
        } else {
            int f2 = af.f(this.J.d);
            audioTrack = this.am == 0 ? new AudioTrack(f2, this.G, this.H, this.I, this.M, 1) : new AudioTrack(f2, this.G, this.H, this.I, this.M, 1, this.am);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception e2) {
        }
        throw new h.b(state, this.G, this.H, this.M);
    }

    private AudioTrack u() {
        AudioAttributes build = this.an ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.J.a();
        AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.H).setEncoding(this.I).setSampleRate(this.G).build();
        int i2 = this.am;
        if (i2 == 0) {
            i2 = 0;
        }
        return new AudioTrack(build, build2, this.M, 1, i2);
    }

    private com.anythink.expressad.exoplayer.b.f[] v() {
        return this.E ? this.w : this.v;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final long a(boolean z) {
        d dVar;
        long j2;
        long a2;
        long j3;
        if (!q() || this.aa == 0) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.y.a(z), e(s()));
        long j4 = this.ab;
        d dVar2 = null;
        while (true) {
            dVar = dVar2;
            if (this.z.isEmpty() || min < this.z.getFirst().f4368c) {
                break;
            }
            dVar2 = this.z.remove();
        }
        if (dVar != null) {
            this.O = dVar.f4367a;
            this.Q = dVar.f4368c;
            this.P = dVar.b - this.ab;
        }
        if (this.O.b == 1.0f) {
            j3 = (min + this.P) - this.Q;
        } else {
            if (this.z.isEmpty()) {
                j2 = this.P;
                a2 = this.r.a(min - this.Q);
            } else {
                j2 = this.P;
                a2 = af.a(min - this.Q, this.O.b);
            }
            j3 = a2 + j2;
        }
        return j4 + j3 + e(this.r.b());
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final v a(v vVar) {
        if (q() && !this.L) {
            v vVar2 = v.f4901a;
            this.O = vVar2;
            return vVar2;
        }
        v vVar3 = this.N;
        if (vVar3 == null) {
            vVar3 = !this.z.isEmpty() ? this.z.getLast().f4367a : this.O;
        }
        if (!vVar.equals(vVar3)) {
            if (q()) {
                this.N = vVar;
            } else {
                this.O = this.r.a(vVar);
            }
        }
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a() {
        this.al = true;
        if (q()) {
            this.y.a();
            this.C.play();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(float f2) {
        if (this.ac != f2) {
            this.ac = f2;
            o();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b1  */
    @Override // com.anythink.expressad.exoplayer.b.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r11, int r12, int r13, int[] r14, int r15, int r16) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.l.a(int, int, int, int[], int, int):void");
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(com.anythink.expressad.exoplayer.b.b bVar) {
        if (this.J.equals(bVar)) {
            return;
        }
        this.J = bVar;
        if (this.an) {
            return;
        }
        i();
        this.am = 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void a(h.c cVar) {
        this.A = cVar;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean a(int i2) {
        if (af.b(i2)) {
            return i2 != 4 || af.f4793a >= 21;
        }
        com.anythink.expressad.exoplayer.b.c cVar = this.q;
        return cVar != null && cVar.a(i2);
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean a(ByteBuffer byteBuffer, long j2) {
        int a2;
        ByteBuffer byteBuffer2 = this.af;
        com.anythink.expressad.exoplayer.k.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!q()) {
            this.x.block();
            AudioTrack t = t();
            this.C = t;
            int audioSessionId = t.getAudioSessionId();
            if (b && af.f4793a < 21) {
                AudioTrack audioTrack = this.B;
                if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                    p();
                }
                if (this.B == null) {
                    this.B = new AudioTrack(3, TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 4, 2, 2, 0, audioSessionId);
                }
            }
            if (this.am != audioSessionId) {
                this.am = audioSessionId;
                h.c cVar = this.A;
                if (cVar != null) {
                    cVar.a(audioSessionId);
                }
            }
            this.O = this.L ? this.r.a(this.O) : v.f4901a;
            k();
            this.y.a(this.C, this.I, this.W, this.M);
            o();
            if (this.al) {
                a();
            }
        }
        if (this.y.a(s())) {
            if (this.af == null) {
                if (!byteBuffer.hasRemaining()) {
                    return true;
                }
                if (!this.D && this.Z == 0) {
                    int i2 = this.I;
                    if (i2 == 7 || i2 == 8) {
                        a2 = m.a(byteBuffer);
                    } else if (i2 == 5) {
                        a2 = com.anythink.expressad.exoplayer.b.a.a();
                    } else if (i2 == 6) {
                        a2 = com.anythink.expressad.exoplayer.b.a.a(byteBuffer);
                    } else if (i2 != 14) {
                        throw new IllegalStateException("Unexpected audio encoding: ".concat(String.valueOf(i2)));
                    } else {
                        int b2 = com.anythink.expressad.exoplayer.b.a.b(byteBuffer);
                        a2 = b2 == -1 ? 0 : com.anythink.expressad.exoplayer.b.a.a(byteBuffer, b2) * 16;
                    }
                    this.Z = a2;
                    if (a2 == 0) {
                        return true;
                    }
                }
                if (this.N != null) {
                    if (!n()) {
                        return false;
                    }
                    v vVar = this.N;
                    this.N = null;
                    this.z.add(new d(this.r.a(vVar), Math.max(0L, j2), e(s()), (byte) 0));
                    k();
                }
                if (this.aa == 0) {
                    this.ab = Math.max(0L, j2);
                    this.aa = 1;
                } else {
                    long r = this.ab + ((r() * 1000000) / this.F);
                    if (this.aa == 1 && Math.abs(r - j2) > 200000) {
                        Log.e(m, "Discontinuity detected [expected " + r + ", got " + j2 + "]");
                        this.aa = 2;
                    }
                    if (this.aa == 2) {
                        this.ab += j2 - r;
                        this.aa = 1;
                        h.c cVar2 = this.A;
                        if (cVar2 != null) {
                            cVar2.a();
                        }
                    }
                }
                if (this.D) {
                    this.U += byteBuffer.remaining();
                } else {
                    this.V += this.Z;
                }
                this.af = byteBuffer;
            }
            if (this.K) {
                a(j2);
            } else {
                b(this.af, j2);
            }
            if (!this.af.hasRemaining()) {
                this.af = null;
                return true;
            } else if (this.y.c(s())) {
                Log.w(m, "Resetting stalled audio track");
                i();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void b() {
        if (this.aa == 1) {
            this.aa = 2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void b(int i2) {
        if (this.am != i2) {
            this.am = i2;
            i();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void c() {
        if (!this.ak && q() && n()) {
            this.y.d(s());
            this.C.stop();
            this.S = 0;
            this.ak = true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void c(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(af.f4793a >= 21);
        if (this.an && this.am == i2) {
            return;
        }
        this.an = true;
        this.am = i2;
        i();
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean d() {
        if (q()) {
            return this.ak && !e();
        }
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final boolean e() {
        return q() && this.y.e(s());
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final v f() {
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void g() {
        if (this.an) {
            this.an = false;
            this.am = 0;
            i();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void h() {
        this.al = false;
        if (q() && this.y.c()) {
            this.C.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r0v36, types: [com.anythink.expressad.exoplayer.b.l$1] */
    @Override // com.anythink.expressad.exoplayer.b.h
    public final void i() {
        if (q()) {
            this.U = 0L;
            this.V = 0L;
            this.X = 0L;
            this.Y = 0L;
            this.Z = 0;
            v vVar = this.N;
            if (vVar != null) {
                this.O = vVar;
                this.N = null;
            } else if (!this.z.isEmpty()) {
                this.O = this.z.getLast().f4367a;
            }
            this.z.clear();
            this.P = 0L;
            this.Q = 0L;
            this.af = null;
            this.ag = null;
            l();
            this.ak = false;
            this.aj = -1;
            this.R = null;
            this.S = 0;
            this.aa = 0;
            if (this.y.b()) {
                this.C.pause();
            }
            final AudioTrack audioTrack = this.C;
            this.C = null;
            this.y.d();
            this.x.close();
            new Thread() { // from class: com.anythink.expressad.exoplayer.b.l.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        l.this.x.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.h
    public final void j() {
        i();
        p();
        com.anythink.expressad.exoplayer.b.f[] fVarArr = this.v;
        int length = fVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            fVarArr[i3].i();
            i2 = i3 + 1;
        }
        com.anythink.expressad.exoplayer.b.f[] fVarArr2 = this.w;
        int length2 = fVarArr2.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length2) {
                this.am = 0;
                this.al = false;
                return;
            }
            fVarArr2[i5].i();
            i4 = i5 + 1;
        }
    }
}
