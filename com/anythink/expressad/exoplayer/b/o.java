package com.anythink.expressad.exoplayer.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import com.anythink.expressad.exoplayer.b.g;
import com.anythink.expressad.exoplayer.b.h;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.v;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/o.class */
public final class o extends com.anythink.expressad.exoplayer.f.b implements com.anythink.expressad.exoplayer.k.n {
    private int A;
    private int B;
    private long C;
    private boolean D;
    private boolean E;
    private final Context r;
    private final g.a s;
    private final h t;
    private int u;
    private boolean v;
    private boolean w;
    private MediaFormat x;
    private int y;
    private int z;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/o$a.class */
    final class a implements h.c {
        private a() {
        }

        /* synthetic */ a(o oVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a() {
            o.b(o.this);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i) {
            o.this.s.a(i);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i, long j, long j2) {
            o.this.s.a(i, j, j2);
        }
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar) {
        this(context, cVar, null);
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, Handler handler, g gVar) {
        this(context, cVar, null, handler, gVar);
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(context, cVar, gVar, null, null);
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, Handler handler, g gVar2) {
        this(context, cVar, gVar, handler, gVar2, null, new f[0]);
    }

    public o(Context context, com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, Handler handler, g gVar2, c cVar2, f... fVarArr) {
        this(context, cVar, gVar, handler, gVar2, new l(cVar2, fVarArr));
    }

    private o(Context context, com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, Handler handler, g gVar2, h hVar) {
        super(1, cVar, gVar, false);
        this.r = context.getApplicationContext();
        this.t = hVar;
        this.s = new g.a(handler, gVar2);
        hVar.a(new a(this, (byte) 0));
    }

    private static void C() {
    }

    private static void D() {
    }

    private static void E() {
    }

    private void F() {
        long a2 = this.t.a(v());
        if (a2 != Long.MIN_VALUE) {
            if (!this.E) {
                a2 = Math.max(this.C, a2);
            }
            this.C = a2;
            this.E = false;
        }
    }

    private int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        if (af.f4793a < 24 && "OMX.google.raw.decoder".equals(aVar.f4491c)) {
            boolean z = true;
            if (af.f4793a == 23) {
                PackageManager packageManager = this.r.getPackageManager();
                z = true;
                if (packageManager != null) {
                    z = true;
                    if (packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)) {
                        z = false;
                    }
                }
            }
            if (z) {
                return -1;
            }
        }
        return mVar.i;
    }

    private static MediaFormat a(com.anythink.expressad.exoplayer.m mVar, String str, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(MediaFormat.KEY_MIME, str);
        mediaFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, mVar.u);
        mediaFormat.setInteger(MediaFormat.KEY_SAMPLE_RATE, mVar.v);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, mVar.j);
        com.anythink.expressad.exoplayer.f.e.a(mediaFormat, MediaFormat.KEY_MAX_INPUT_SIZE, i);
        if (af.f4793a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        return mediaFormat;
    }

    private static boolean a(com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        return mVar.h.equals(mVar2.h) && mVar.u == mVar2.u && mVar.v == mVar2.v && mVar.x == 0 && mVar.y == 0 && mVar2.x == 0 && mVar2.y == 0 && mVar.b(mVar2);
    }

    private boolean a(String str) {
        int e = com.anythink.expressad.exoplayer.k.o.e(str);
        return e != 0 && this.t.a(e);
    }

    private int b(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar) {
        if (af.f4793a < 24 && "OMX.google.raw.decoder".equals(aVar.f4491c)) {
            boolean z = true;
            if (af.f4793a == 23) {
                PackageManager packageManager = this.r.getPackageManager();
                z = true;
                if (packageManager != null) {
                    z = true;
                    if (packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)) {
                        z = false;
                    }
                }
            }
            if (z) {
                return -1;
            }
        }
        return mVar.i;
    }

    static /* synthetic */ boolean b(o oVar) {
        oVar.E = true;
        return true;
    }

    private static boolean b(String str) {
        if (af.f4793a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(af.f4794c)) {
            return af.b.startsWith("zeroflte") || af.b.startsWith("herolte") || af.b.startsWith("heroqlte");
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final int a(com.anythink.expressad.exoplayer.f.a aVar, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.m mVar2) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fb, code lost:
        if (r0.a(r7.v) != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0112, code lost:
        if (r0.b(r7.u) != false) goto L58;
     */
    @Override // com.anythink.expressad.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.anythink.expressad.exoplayer.f.c r5, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> r6, com.anythink.expressad.exoplayer.m r7) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.o.a(com.anythink.expressad.exoplayer.f.c, com.anythink.expressad.exoplayer.d.g, com.anythink.expressad.exoplayer.m):int");
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final com.anythink.expressad.exoplayer.f.a a(com.anythink.expressad.exoplayer.f.c cVar, com.anythink.expressad.exoplayer.m mVar, boolean z) {
        com.anythink.expressad.exoplayer.f.a a2;
        return (!a(mVar.h) || (a2 = cVar.a()) == null) ? super.a(cVar, mVar, z) : a2;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v a(v vVar) {
        return this.t.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i, Object obj) {
        if (i == 2) {
            this.t.a(((Float) obj).floatValue());
        } else if (i != 3) {
            super.a(i, obj);
        } else {
            this.t.a((b) obj);
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z) {
        super.a(j, z);
        this.t.i();
        this.C = j;
        this.D = true;
        this.E = true;
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.x;
        if (mediaFormat2 != null) {
            i = com.anythink.expressad.exoplayer.k.o.e(mediaFormat2.getString(MediaFormat.KEY_MIME));
            mediaFormat = this.x;
        } else {
            i = this.y;
        }
        int integer = mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
        int integer2 = mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
        if (this.w && integer == 6 && (i2 = this.z) < 6) {
            int[] iArr2 = new int[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                iArr = iArr2;
                if (i4 < this.z) {
                    iArr2[i4] = i4;
                    i3 = i4 + 1;
                }
            }
        } else {
            iArr = null;
        }
        try {
            this.t.a(i, integer, integer2, iArr, this.A, this.B);
        } catch (h.a e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(com.anythink.expressad.exoplayer.c.e eVar) {
        if (!this.D || eVar.b()) {
            return;
        }
        if (Math.abs(eVar.f - this.C) > 500000) {
            this.C = eVar.f;
        }
        this.D = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0148  */
    @Override // com.anythink.expressad.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.expressad.exoplayer.f.a r7, android.media.MediaCodec r8, com.anythink.expressad.exoplayer.m r9, android.media.MediaCrypto r10) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.b.o.a(com.anythink.expressad.exoplayer.f.a, android.media.MediaCodec, com.anythink.expressad.exoplayer.m, android.media.MediaCrypto):void");
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void a(String str, long j, long j2) {
        this.s.a(str, j, j2);
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void a(boolean z) {
        super.a(z);
        this.s.a(this.q);
        int i = r().b;
        if (i != 0) {
            this.t.c(i);
        } else {
            this.t.g();
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.v && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.q.f++;
            this.t.b();
            return true;
        } else {
            try {
                if (this.t.a(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.q.e++;
                    return true;
                }
                return false;
            } catch (h.b | h.d e) {
                throw com.anythink.expressad.exoplayer.g.a(e, s());
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void b(com.anythink.expressad.exoplayer.m mVar) {
        super.b(mVar);
        this.s.a(mVar);
        this.y = "audio/raw".equals(mVar.h) ? mVar.w : 2;
        this.z = mVar.u;
        this.A = mVar.x;
        this.B = mVar.y;
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.k.n c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            F();
        }
        return this.C;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final v e() {
        return this.t.f();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void n() {
        super.n();
        this.t.a();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void o() {
        F();
        this.t.h();
        super.o();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.a
    public final void p() {
        try {
            this.t.j();
            try {
                super.p();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean u() {
        return this.t.e() || super.u();
    }

    @Override // com.anythink.expressad.exoplayer.f.b, com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return super.v() && this.t.d();
    }

    @Override // com.anythink.expressad.exoplayer.f.b
    public final void w() {
        try {
            this.t.c();
        } catch (h.d e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }
}
