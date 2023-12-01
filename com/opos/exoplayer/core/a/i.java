package com.opos.exoplayer.core.a;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.a.e;
import com.opos.exoplayer.core.a.f;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.p;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/i.class */
public class i extends com.opos.exoplayer.core.d.b implements com.opos.exoplayer.core.i.i {
    private final e.a b;

    /* renamed from: c  reason: collision with root package name */
    private final f f11349c;
    private boolean d;
    private boolean e;
    private MediaFormat f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private boolean m;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/i$a.class */
    final class a implements f.c {
        private a() {
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a() {
            i.this.v();
            i.this.m = true;
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i) {
            i.this.b.a(i);
            i.this.b(i);
        }

        @Override // com.opos.exoplayer.core.a.f.c
        public void a(int i, long j, long j2) {
            i.this.b.a(i, j, j2);
            i.this.a(i, j, j2);
        }
    }

    public i(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, Handler handler, e eVar, c cVar2, d... dVarArr) {
        this(cVar, bVar, z, handler, eVar, new g(cVar2, dVarArr));
    }

    public i(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, boolean z, Handler handler, e eVar, f fVar) {
        super(1, cVar, bVar, z);
        this.b = new e.a(handler, eVar);
        this.f11349c = fVar;
        fVar.a(new a());
    }

    private void D() {
        long a2 = this.f11349c.a(u());
        if (a2 != Long.MIN_VALUE) {
            if (!this.m) {
                a2 = Math.max(this.k, a2);
            }
            this.k = a2;
            this.m = false;
        }
    }

    private static boolean b(String str) {
        if (u.f11822a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(u.f11823c)) {
            return u.b.startsWith("zeroflte") || u.b.startsWith("herolte") || u.b.startsWith("heroqlte");
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.d.b
    public int a(com.opos.exoplayer.core.d.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, Format format) {
        String str = format.f;
        if (com.opos.exoplayer.core.i.j.a(str)) {
            int i = u.f11822a >= 21 ? 32 : 0;
            boolean a2 = a(bVar, format.i);
            if (a2 && a(str) && cVar.a() != null) {
                return i | 8 | 4;
            }
            if ((!"audio/raw".equals(str) || this.f11349c.a(format.t)) && this.f11349c.a(2)) {
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
                        z2 |= drmInitData.a(i3).f11582c;
                        i2 = i3 + 1;
                    }
                }
                com.opos.exoplayer.core.d.a a3 = cVar.a(str, z);
                if (a3 == null) {
                    return (!z || cVar.a(str, false) == null) ? 1 : 2;
                } else if (a2) {
                    boolean z3 = true;
                    if (u.f11822a >= 21) {
                        if (format.s == -1 || a3.a(format.s)) {
                            z3 = true;
                            if (format.r != -1) {
                                if (a3.b(format.r)) {
                                    z3 = true;
                                }
                            }
                        }
                        z3 = false;
                    }
                    return (z3 ? 4 : 3) | i | 8;
                } else {
                    return 2;
                }
            }
            return 1;
        }
        return 0;
    }

    @Override // com.opos.exoplayer.core.d.b
    public com.opos.exoplayer.core.d.a a(com.opos.exoplayer.core.d.c cVar, Format format, boolean z) {
        com.opos.exoplayer.core.d.a a2;
        if (!a(format.f) || (a2 = cVar.a()) == null) {
            this.d = false;
            return super.a(cVar, format, z);
        }
        this.d = true;
        return a2;
    }

    @Override // com.opos.exoplayer.core.i.i
    public p a(p pVar) {
        return this.f11349c.a(pVar);
    }

    protected void a(int i, long j, long j2) {
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.r.b
    public void a(int i, Object obj) {
        if (i == 2) {
            this.f11349c.a(((Float) obj).floatValue());
        } else if (i != 3) {
            super.a(i, obj);
        } else {
            this.f11349c.a((b) obj);
        }
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        super.a(j, z);
        this.f11349c.i();
        this.k = j;
        this.l = true;
        this.m = true;
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.f;
        if (mediaFormat2 != null) {
            i = com.opos.exoplayer.core.i.j.f(mediaFormat2.getString(MediaFormat.KEY_MIME));
            mediaFormat = this.f;
        } else {
            i = this.g;
        }
        int integer = mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
        int integer2 = mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
        if (this.e && integer == 6 && (i2 = this.h) < 6) {
            int[] iArr2 = new int[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                iArr = iArr2;
                if (i4 < this.h) {
                    iArr2[i4] = i4;
                    i3 = i4 + 1;
                }
            }
        } else {
            iArr = null;
        }
        try {
            this.f11349c.a(i, integer, integer2, 0, iArr, this.i, this.j);
        } catch (f.a e) {
            throw com.opos.exoplayer.core.h.a(e, r());
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(com.opos.exoplayer.core.b.e eVar) {
        if (!this.l || eVar.d_()) {
            return;
        }
        if (Math.abs(eVar.f11386c - this.k) > 500000) {
            this.k = eVar.f11386c;
        }
        this.l = false;
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(com.opos.exoplayer.core.d.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.e = b(aVar.f11568a);
        MediaFormat c2 = c(format);
        if (!this.d) {
            mediaCodec.configure(c2, null, mediaCrypto, 0);
            this.f = null;
            return;
        }
        this.f = c2;
        c2.setString(MediaFormat.KEY_MIME, "audio/raw");
        mediaCodec.configure(this.f, null, mediaCrypto, 0);
        this.f.setString(MediaFormat.KEY_MIME, format.f);
    }

    @Override // com.opos.exoplayer.core.d.b
    public void a(String str, long j, long j2) {
        this.b.a(str, j, j2);
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void a(boolean z) {
        super.a(z);
        this.b.a(this.f11570a);
        int i = q().b;
        if (i != 0) {
            this.f11349c.b(i);
        } else {
            this.f11349c.g();
        }
    }

    @Override // com.opos.exoplayer.core.d.b
    public boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.d && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.f11570a.f++;
            this.f11349c.b();
            return true;
        } else {
            try {
                if (this.f11349c.a(byteBuffer, j3)) {
                    mediaCodec.releaseOutputBuffer(i, false);
                    this.f11570a.e++;
                    return true;
                }
                return false;
            } catch (f.b | f.d e) {
                throw com.opos.exoplayer.core.h.a(e, r());
            }
        }
    }

    protected boolean a(String str) {
        int f = com.opos.exoplayer.core.i.j.f(str);
        return f != 0 && this.f11349c.a(f);
    }

    protected void b(int i) {
    }

    @Override // com.opos.exoplayer.core.d.b
    public void b(Format format) {
        super.b(format);
        this.b.a(format);
        this.g = "audio/raw".equals(format.f) ? format.t : 2;
        this.h = format.r;
        this.i = format.u != -1 ? format.u : 0;
        int i = 0;
        if (format.v != -1) {
            i = format.v;
        }
        this.j = i;
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.s
    public com.opos.exoplayer.core.i.i c() {
        return this;
    }

    @Override // com.opos.exoplayer.core.i.i
    public long d() {
        if (a_() == 2) {
            D();
        }
        return this.k;
    }

    @Override // com.opos.exoplayer.core.i.i
    public p e() {
        return this.f11349c.f();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void n() {
        super.n();
        this.f11349c.a();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void o() {
        this.f11349c.h();
        D();
        super.o();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.a
    public void p() {
        try {
            this.f11349c.j();
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

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.s
    public boolean t() {
        return this.f11349c.e() || super.t();
    }

    @Override // com.opos.exoplayer.core.d.b, com.opos.exoplayer.core.s
    public boolean u() {
        return super.u() && this.f11349c.d();
    }

    protected void v() {
    }

    @Override // com.opos.exoplayer.core.d.b
    public void w() {
        try {
            this.f11349c.c();
        } catch (f.d e) {
            throw com.opos.exoplayer.core.h.a(e, r());
        }
    }
}
