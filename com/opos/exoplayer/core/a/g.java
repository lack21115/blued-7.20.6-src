package com.opos.exoplayer.core.a;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.opos.exoplayer.core.a.f;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.p;
import com.tencent.thumbplayer.api.TPErrorCode;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/g.class */
public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f11338a = false;
    public static boolean b = false;
    private long A;
    private p B;
    private p C;
    private long D;
    private long E;
    private ByteBuffer F;
    private int G;
    private int H;
    private int I;
    private long J;
    private long K;
    private boolean L;
    private long M;
    private Method N;
    private int O;
    private long P;
    private long Q;
    private int R;
    private long S;
    private long T;
    private int U;
    private int V;
    private long W;
    private long X;
    private long Y;
    private float Z;
    private com.opos.exoplayer.core.a.d[] aa;
    private ByteBuffer[] ab;
    private ByteBuffer ac;
    private ByteBuffer ad;
    private byte[] ae;
    private int af;
    private int ag;
    private boolean ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private long am;

    /* renamed from: c  reason: collision with root package name */
    private final com.opos.exoplayer.core.a.c f11339c;
    private final boolean d;
    private final k e;
    private final o f;
    private final j g;
    private final com.opos.exoplayer.core.a.d[] h;
    private final com.opos.exoplayer.core.a.d[] i;
    private final ConditionVariable j;
    private final long[] k;
    private final b l;
    private final ArrayDeque<d> m;
    private f.c n;
    private AudioTrack o;
    private AudioTrack p;
    private boolean q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private com.opos.exoplayer.core.a.b w;
    private boolean x;
    private boolean y;
    private int z;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/g$a.class */
    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/g$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        protected AudioTrack f11342a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f11343c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;
        private long i;
        private long j;

        private b() {
        }

        public void a() {
            if (this.g != com.anythink.expressad.exoplayer.b.b) {
                return;
            }
            this.f11342a.pause();
        }

        public void a(long j) {
            this.i = b();
            this.g = SystemClock.elapsedRealtime() * 1000;
            this.j = j;
            this.f11342a.stop();
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.f11342a = audioTrack;
            this.b = z;
            this.g = com.anythink.expressad.exoplayer.b.b;
            this.h = com.anythink.expressad.exoplayer.b.b;
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            if (audioTrack != null) {
                this.f11343c = audioTrack.getSampleRate();
            }
        }

        public long b() {
            if (this.g != com.anythink.expressad.exoplayer.b.b) {
                return Math.min(this.j, ((((SystemClock.elapsedRealtime() * 1000) - this.g) * this.f11343c) / 1000000) + this.i);
            }
            int playState = this.f11342a.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.f11342a.getPlaybackHeadPosition();
            long j = playbackHeadPosition;
            if (this.b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f = this.d;
                }
                j = playbackHeadPosition + this.f;
            }
            if (u.f11822a <= 28) {
                if (j == 0 && this.d > 0 && playState == 3) {
                    if (this.h == com.anythink.expressad.exoplayer.b.b) {
                        this.h = SystemClock.elapsedRealtime();
                    }
                    return this.d;
                }
                this.h = com.anythink.expressad.exoplayer.b.b;
            }
            if (this.d > j) {
                this.e++;
            }
            this.d = j;
            return j + (this.e << 32);
        }

        public boolean b(long j) {
            return this.h != com.anythink.expressad.exoplayer.b.b && j > 0 && SystemClock.elapsedRealtime() - this.h >= 200;
        }

        public long c() {
            return (b() * 1000000) / this.f11343c;
        }

        public boolean d() {
            return false;
        }

        public long e() {
            throw new UnsupportedOperationException();
        }

        public long f() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/g$c.class */
    static class c extends b {
        private final AudioTimestamp b;

        /* renamed from: c  reason: collision with root package name */
        private long f11344c;
        private long d;
        private long e;

        public c() {
            super();
            this.b = new AudioTimestamp();
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.f11344c = 0L;
            this.d = 0L;
            this.e = 0L;
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public boolean d() {
            boolean timestamp = this.f11342a.getTimestamp(this.b);
            if (timestamp) {
                long j = this.b.framePosition;
                if (this.d > j) {
                    this.f11344c++;
                }
                this.d = j;
                this.e = j + (this.f11344c << 32);
            }
            return timestamp;
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public long e() {
            return this.b.nanoTime;
        }

        @Override // com.opos.exoplayer.core.a.g.b
        public long f() {
            return this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/g$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final p f11345a;
        private final long b;

        /* renamed from: c  reason: collision with root package name */
        private final long f11346c;

        private d(p pVar, long j, long j2) {
            this.f11345a = pVar;
            this.b = j;
            this.f11346c = j2;
        }
    }

    public g(com.opos.exoplayer.core.a.c cVar, com.opos.exoplayer.core.a.d[] dVarArr) {
        this(cVar, dVarArr, false);
    }

    public g(com.opos.exoplayer.core.a.c cVar, com.opos.exoplayer.core.a.d[] dVarArr, boolean z) {
        this.f11339c = cVar;
        this.d = z;
        this.j = new ConditionVariable(true);
        if (u.f11822a >= 18) {
            try {
                this.N = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        this.l = u.f11822a >= 19 ? new c() : new b();
        this.e = new k();
        this.f = new o();
        this.g = new j();
        com.opos.exoplayer.core.a.d[] dVarArr2 = new com.opos.exoplayer.core.a.d[dVarArr.length + 4];
        this.h = dVarArr2;
        dVarArr2[0] = new m();
        com.opos.exoplayer.core.a.d[] dVarArr3 = this.h;
        dVarArr3[1] = this.e;
        dVarArr3[2] = this.f;
        System.arraycopy(dVarArr, 0, dVarArr3, 3, dVarArr.length);
        this.h[dVarArr.length + 3] = this.g;
        this.i = new com.opos.exoplayer.core.a.d[]{new l()};
        this.k = new long[10];
        this.Z = 1.0f;
        this.V = 0;
        this.w = com.opos.exoplayer.core.a.b.f11320a;
        this.aj = 0;
        this.C = p.f11866a;
        this.ag = -1;
        this.aa = new com.opos.exoplayer.core.a.d[0];
        this.ab = new ByteBuffer[0];
        this.m = new ArrayDeque<>();
    }

    private static int a(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return h.a(byteBuffer);
        }
        if (i == 5) {
            return com.opos.exoplayer.core.a.a.a();
        }
        if (i == 6) {
            return com.opos.exoplayer.core.a.a.a(byteBuffer);
        }
        if (i == 14) {
            return com.opos.exoplayer.core.a.a.b(byteBuffer) * 8;
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i);
    }

    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.F == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.F = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.F.putInt(1431633921);
        }
        if (this.G == 0) {
            this.F.putInt(4, i);
            this.F.putLong(8, j * 1000);
            this.F.position(0);
            this.G = i;
        }
        int remaining = this.F.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.F, remaining, 1);
            if (write < 0) {
                this.G = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.G = 0;
        } else {
            this.G -= a2;
        }
        return a2;
    }

    private void a(long j) {
        ByteBuffer byteBuffer;
        int length = this.aa.length;
        int i = length;
        while (true) {
            int i2 = i;
            if (i2 < 0) {
                return;
            }
            if (i2 > 0) {
                byteBuffer = this.ab[i2 - 1];
            } else {
                byteBuffer = this.ac;
                if (byteBuffer == null) {
                    byteBuffer = com.opos.exoplayer.core.a.d.f11326a;
                }
            }
            if (i2 == length) {
                b(byteBuffer, j);
            } else {
                com.opos.exoplayer.core.a.d dVar = this.aa[i2];
                dVar.a(byteBuffer);
                ByteBuffer f = dVar.f();
                this.ab[i2] = f;
                if (f.hasRemaining()) {
                    i = i2 + 1;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            }
            i = i2 - 1;
        }
    }

    private static void a(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private long b(long j) {
        long a2;
        long j2;
        while (!this.m.isEmpty() && j >= this.m.getFirst().f11346c) {
            d remove = this.m.remove();
            this.C = remove.f11345a;
            this.E = remove.f11346c;
            this.D = remove.b - this.W;
        }
        if (this.C.b == 1.0f) {
            return (this.D + j) - this.E;
        }
        if (this.m.isEmpty()) {
            j2 = this.D;
            a2 = this.g.a(j - this.E);
        } else {
            long j3 = this.D;
            a2 = u.a(j - this.E, this.C.b);
            j2 = j3;
        }
        return j2 + a2;
    }

    private static void b(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    private void b(ByteBuffer byteBuffer, long j) {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.ad;
            int i = 0;
            if (byteBuffer2 != null) {
                com.opos.exoplayer.core.i.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.ad = byteBuffer;
                if (u.f11822a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.ae;
                    if (bArr == null || bArr.length < remaining) {
                        this.ae = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.ae, 0, remaining);
                    byteBuffer.position(position);
                    this.af = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (u.f11822a < 21) {
                int b2 = this.z - ((int) (this.S - (this.l.b() * this.R)));
                if (b2 > 0) {
                    int write = this.p.write(this.ae, this.af, Math.min(remaining2, b2));
                    i = write;
                    if (write > 0) {
                        this.af += write;
                        byteBuffer.position(byteBuffer.position() + write);
                        i = write;
                    }
                }
            } else if (this.ak) {
                com.opos.exoplayer.core.i.a.b(j != com.anythink.expressad.exoplayer.b.b);
                i = a(this.p, byteBuffer, remaining2, j);
            } else {
                i = a(this.p, byteBuffer, remaining2);
            }
            this.am = SystemClock.elapsedRealtime();
            if (i < 0) {
                throw new f.d(i);
            }
            if (this.q) {
                this.S += i;
            }
            if (i == remaining2) {
                if (!this.q) {
                    this.T += this.U;
                }
                this.ad = null;
            }
        }
    }

    private long c(long j) {
        return (j * 1000000) / this.s;
    }

    private AudioTrack c(int i) {
        return new AudioTrack(3, TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 4, 2, 2, 0, i);
    }

    private long d(long j) {
        return (j * 1000000) / this.t;
    }

    private static boolean d(int i) {
        return i == 3 || i == 2 || i == Integer.MIN_VALUE || i == 1073741824 || i == 4;
    }

    private long e(long j) {
        return (this.t * j) / 1000000;
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        com.opos.exoplayer.core.a.d[] z = z();
        int length = z.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            com.opos.exoplayer.core.a.d dVar = z[i2];
            if (dVar.a()) {
                arrayList.add(dVar);
            } else {
                dVar.h();
            }
            i = i2 + 1;
        }
        int size = arrayList.size();
        this.aa = (com.opos.exoplayer.core.a.d[]) arrayList.toArray(new com.opos.exoplayer.core.a.d[size]);
        this.ab = new ByteBuffer[size];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return;
            }
            com.opos.exoplayer.core.a.d dVar2 = this.aa[i4];
            dVar2.h();
            this.ab[i4] = dVar2.f();
            i3 = i4 + 1;
        }
    }

    private void l() {
        this.j.block();
        this.p = x();
        a(this.C);
        k();
        int audioSessionId = this.p.getAudioSessionId();
        if (f11338a && u.f11822a < 21) {
            AudioTrack audioTrack = this.o;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                o();
            }
            if (this.o == null) {
                this.o = c(audioSessionId);
            }
        }
        if (this.aj != audioSessionId) {
            this.aj = audioSessionId;
            f.c cVar = this.n;
            if (cVar != null) {
                cVar.a(audioSessionId);
            }
        }
        this.l.a(this.p, v());
        n();
        this.al = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r5.ad == null) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0060 -> B:8:0x001e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m() {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.ag
            r6 = r0
            r0 = 0
            r8 = r0
            r0 = r6
            r1 = -1
            if (r0 != r1) goto L28
            r0 = r5
            boolean r0 = r0.x
            if (r0 == 0) goto L18
            r0 = 0
            r6 = r0
            goto L1e
        L18:
            r0 = r5
            com.opos.exoplayer.core.a.d[] r0 = r0.aa
            int r0 = r0.length
            r6 = r0
        L1e:
            r0 = r5
            r1 = r6
            r0.ag = r1
            r0 = 1
            r6 = r0
            goto L2a
        L28:
            r0 = 0
            r6 = r0
        L2a:
            r0 = r5
            int r0 = r0.ag
            r7 = r0
            r0 = r5
            com.opos.exoplayer.core.a.d[] r0 = r0.aa
            r9 = r0
            r0 = r7
            r1 = r9
            int r1 = r1.length
            if (r0 >= r1) goto L6a
            r0 = r9
            r1 = r7
            r0 = r0[r1]
            r9 = r0
            r0 = r6
            if (r0 == 0) goto L4d
            r0 = r9
            r0.e()
        L4d:
            r0 = r5
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.a(r1)
            r0 = r9
            boolean r0 = r0.g()
            if (r0 != 0) goto L60
            r0 = 0
            return r0
        L60:
            r0 = r5
            int r0 = r0.ag
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L1e
        L6a:
            r0 = r5
            java.nio.ByteBuffer r0 = r0.ad
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L85
            r0 = r5
            r1 = r9
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.b(r1, r2)
            r0 = r5
            java.nio.ByteBuffer r0 = r0.ad
            if (r0 != 0) goto L8c
        L85:
            r0 = r5
            r1 = -1
            r0.ag = r1
            r0 = 1
            r8 = r0
        L8c:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.g.m():boolean");
    }

    private void n() {
        if (r()) {
            if (u.f11822a >= 21) {
                a(this.p, this.Z);
            } else {
                b(this.p, this.Z);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.opos.exoplayer.core.a.g$2] */
    private void o() {
        final AudioTrack audioTrack = this.o;
        if (audioTrack == null) {
            return;
        }
        this.o = null;
        new Thread() { // from class: com.opos.exoplayer.core.a.g.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                audioTrack.release();
            }
        }.start();
    }

    private boolean p() {
        return r() && this.V != 0;
    }

    private void q() {
        Method method;
        String str;
        long c2 = this.l.c();
        if (c2 == 0) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.K >= 30000) {
            long[] jArr = this.k;
            int i = this.H;
            jArr[i] = c2 - nanoTime;
            this.H = (i + 1) % 10;
            int i2 = this.I;
            if (i2 < 10) {
                this.I = i2 + 1;
            }
            this.K = nanoTime;
            this.J = 0L;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                int i5 = this.I;
                if (i4 >= i5) {
                    break;
                }
                this.J += this.k[i4] / i5;
                i3 = i4 + 1;
            }
        }
        if (v() || nanoTime - this.M < 500000) {
            return;
        }
        boolean d2 = this.l.d();
        this.L = d2;
        if (d2) {
            long e = this.l.e() / 1000;
            long f = this.l.f();
            if (e >= this.X) {
                if (Math.abs(e - nanoTime) > 5000000) {
                    str = "Spurious audio timestamp (system clock mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c2 + ", " + s() + ", " + t();
                    if (b) {
                        throw new a(str);
                    }
                } else if (Math.abs(d(f) - c2) > 5000000) {
                    str = "Spurious audio timestamp (frame position mismatch): " + f + ", " + e + ", " + nanoTime + ", " + c2 + ", " + s() + ", " + t();
                    if (b) {
                        throw new a(str);
                    }
                }
                com.opos.cmn.an.f.a.c("AudioTrack", str);
            }
            this.L = false;
        }
        if (this.N != null && this.q) {
            try {
                long intValue = (((Integer) method.invoke(this.p, null)).intValue() * 1000) - this.A;
                this.Y = intValue;
                long max = Math.max(intValue, 0L);
                this.Y = max;
                if (max > 5000000) {
                    com.opos.cmn.an.f.a.c("AudioTrack", "Ignoring impossibly large audio latency: " + this.Y);
                    this.Y = 0L;
                }
            } catch (Exception e2) {
                this.N = null;
            }
        }
        this.M = nanoTime;
    }

    private boolean r() {
        return this.p != null;
    }

    private long s() {
        return this.q ? this.P / this.O : this.Q;
    }

    private long t() {
        return this.q ? this.S / this.R : this.T;
    }

    private void u() {
        this.J = 0L;
        this.I = 0;
        this.H = 0;
        this.K = 0L;
        this.L = false;
        this.M = 0L;
    }

    private boolean v() {
        if (u.f11822a < 23) {
            int i = this.v;
            return i == 5 || i == 6;
        }
        return false;
    }

    private boolean w() {
        return v() && this.p.getPlayState() == 2 && this.p.getPlaybackHeadPosition() == 0;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0082 -> B:14:0x006d). Please submit an issue!!! */
    private AudioTrack x() {
        AudioTrack audioTrack;
        if (u.f11822a >= 21) {
            audioTrack = y();
        } else {
            int d2 = u.d(this.w.d);
            audioTrack = this.aj == 0 ? new AudioTrack(d2, this.t, this.u, this.v, this.z, 1) : new AudioTrack(d2, this.t, this.u, this.v, this.z, 1, this.aj);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception e) {
        }
        throw new f.b(state, this.t, this.u, this.z);
    }

    private AudioTrack y() {
        AudioAttributes build = this.ak ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.w.a();
        AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.u).setEncoding(this.v).setSampleRate(this.t).build();
        int i = this.aj;
        if (i == 0) {
            i = 0;
        }
        return new AudioTrack(build, build2, this.z, 1, i);
    }

    private com.opos.exoplayer.core.a.d[] z() {
        return this.r ? this.i : this.h;
    }

    @Override // com.opos.exoplayer.core.a.f
    public long a(boolean z) {
        long j;
        if (p()) {
            if (this.p.getPlayState() == 3) {
                q();
            }
            long nanoTime = System.nanoTime() / 1000;
            if (this.L) {
                j = d(e(nanoTime - (this.l.e() / 1000)) + this.l.f());
            } else {
                long c2 = this.I == 0 ? this.l.c() : nanoTime + this.J;
                j = c2;
                if (!z) {
                    j = c2 - this.Y;
                }
            }
            return b(Math.min(j, d(t()))) + this.W;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.opos.exoplayer.core.a.f
    public p a(p pVar) {
        if (r() && !this.y) {
            p pVar2 = p.f11866a;
            this.C = pVar2;
            return pVar2;
        }
        p pVar3 = new p(this.g.a(pVar.b), this.g.b(pVar.f11867c));
        p pVar4 = this.B;
        if (pVar4 == null) {
            pVar4 = !this.m.isEmpty() ? this.m.getLast().f11345a : this.C;
        }
        if (!pVar3.equals(pVar4)) {
            if (r()) {
                this.B = pVar3;
            } else {
                this.C = pVar3;
            }
        }
        return this.C;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a() {
        this.ai = true;
        if (r()) {
            this.X = System.nanoTime() / 1000;
            this.p.play();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(float f) {
        if (this.Z != f) {
            this.Z = f;
            n();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0286  */
    @Override // com.opos.exoplayer.core.a.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r10, int r11, int r12, int r13, int[] r14, int r15, int r16) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.a.g.a(int, int, int, int, int[], int, int):void");
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(com.opos.exoplayer.core.a.b bVar) {
        if (this.w.equals(bVar)) {
            return;
        }
        this.w = bVar;
        if (this.ak) {
            return;
        }
        i();
        this.aj = 0;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void a(f.c cVar) {
        this.n = cVar;
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean a(int i) {
        if (d(i)) {
            return i != 4 || u.f11822a >= 21;
        }
        com.opos.exoplayer.core.a.c cVar = this.f11339c;
        return cVar != null && cVar.a(i);
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean a(ByteBuffer byteBuffer, long j) {
        ByteBuffer byteBuffer2 = this.ac;
        com.opos.exoplayer.core.i.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!r()) {
            l();
            if (this.ai) {
                a();
            }
        }
        if (v()) {
            if (this.p.getPlayState() == 2) {
                this.al = false;
                return false;
            } else if (this.p.getPlayState() == 1 && this.l.b() != 0) {
                return false;
            }
        }
        boolean z = this.al;
        boolean e = e();
        this.al = e;
        if (z && !e && this.p.getPlayState() != 1 && this.n != null) {
            this.n.a(this.z, com.opos.exoplayer.core.b.a(this.A), SystemClock.elapsedRealtime() - this.am);
        }
        if (this.ac == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.q && this.U == 0) {
                int a2 = a(this.v, byteBuffer);
                this.U = a2;
                if (a2 == 0) {
                    return true;
                }
            }
            if (this.B != null) {
                if (!m()) {
                    return false;
                }
                this.m.add(new d(this.B, Math.max(0L, j), d(t())));
                this.B = null;
                k();
            }
            if (this.V == 0) {
                this.W = Math.max(0L, j);
                this.V = 1;
            } else {
                long c2 = this.W + c(s());
                if (this.V == 1 && Math.abs(c2 - j) > 200000) {
                    com.opos.cmn.an.f.a.d("AudioTrack", "Discontinuity detected [expected " + c2 + ", got " + j + "]");
                    this.V = 2;
                }
                if (this.V == 2) {
                    this.W = (j - c2) + this.W;
                    this.V = 1;
                    f.c cVar = this.n;
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            if (this.q) {
                this.P += byteBuffer.remaining();
            } else {
                this.Q += this.U;
            }
            this.ac = byteBuffer;
        }
        if (this.x) {
            a(j);
        } else {
            b(this.ac, j);
        }
        if (!this.ac.hasRemaining()) {
            this.ac = null;
            return true;
        } else if (this.l.b(t())) {
            com.opos.cmn.an.f.a.c("AudioTrack", "Resetting stalled audio track");
            i();
            return true;
        } else {
            return false;
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void b() {
        if (this.V == 1) {
            this.V = 2;
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void b(int i) {
        com.opos.exoplayer.core.i.a.b(u.f11822a >= 21);
        if (this.ak && this.aj == i) {
            return;
        }
        this.ak = true;
        this.aj = i;
        i();
    }

    @Override // com.opos.exoplayer.core.a.f
    public void c() {
        if (!this.ah && r() && m()) {
            this.l.a(t());
            this.G = 0;
            this.ah = true;
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean d() {
        if (r()) {
            return this.ah && !e();
        }
        return true;
    }

    @Override // com.opos.exoplayer.core.a.f
    public boolean e() {
        if (r()) {
            return t() > this.l.b() || w();
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.a.f
    public p f() {
        return this.C;
    }

    @Override // com.opos.exoplayer.core.a.f
    public void g() {
        if (this.ak) {
            this.ak = false;
            this.aj = 0;
            i();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void h() {
        this.ai = false;
        if (r()) {
            u();
            this.l.a();
        }
    }

    /* JADX WARN: Type inference failed for: r0v42, types: [com.opos.exoplayer.core.a.g$1] */
    @Override // com.opos.exoplayer.core.a.f
    public void i() {
        if (r()) {
            this.P = 0L;
            this.Q = 0L;
            this.S = 0L;
            this.T = 0L;
            this.U = 0;
            p pVar = this.B;
            if (pVar != null) {
                this.C = pVar;
                this.B = null;
            } else if (!this.m.isEmpty()) {
                this.C = this.m.getLast().f11345a;
            }
            this.m.clear();
            this.D = 0L;
            this.E = 0L;
            this.ac = null;
            this.ad = null;
            int i = 0;
            while (true) {
                int i2 = i;
                com.opos.exoplayer.core.a.d[] dVarArr = this.aa;
                if (i2 >= dVarArr.length) {
                    break;
                }
                com.opos.exoplayer.core.a.d dVar = dVarArr[i2];
                dVar.h();
                this.ab[i2] = dVar.f();
                i = i2 + 1;
            }
            this.ah = false;
            this.ag = -1;
            this.F = null;
            this.G = 0;
            this.V = 0;
            this.Y = 0L;
            u();
            if (this.p.getPlayState() == 3) {
                this.p.pause();
            }
            final AudioTrack audioTrack = this.p;
            this.p = null;
            this.l.a(null, false);
            this.j.close();
            new Thread() { // from class: com.opos.exoplayer.core.a.g.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        g.this.j.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.opos.exoplayer.core.a.f
    public void j() {
        i();
        o();
        com.opos.exoplayer.core.a.d[] dVarArr = this.h;
        int length = dVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            dVarArr[i2].i();
            i = i2 + 1;
        }
        com.opos.exoplayer.core.a.d[] dVarArr2 = this.i;
        int length2 = dVarArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                this.aj = 0;
                this.ai = false;
                return;
            }
            dVarArr2[i4].i();
            i3 = i4 + 1;
        }
    }
}
