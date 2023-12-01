package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.c.m;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/c.class */
public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    private final f f25162a = new f();
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25163c;
    private final i d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/c$a.class */
    public class a implements l {
        private a() {
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return true;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return c.this.d.a(c.this.f);
        }

        @Override // com.opos.exoplayer.core.c.l
        public l.a b(long j) {
            if (j == 0) {
                return new l.a(new m(0L, c.this.b));
            }
            long b = c.this.d.b(j);
            c cVar = c.this;
            return new l.a(new m(j, cVar.a(cVar.b, b, 30000L)));
        }
    }

    public c(long j, long j2, i iVar, int i, long j3) {
        com.opos.exoplayer.core.i.a.a(j >= 0 && j2 > j);
        this.d = iVar;
        this.b = j;
        this.f25163c = j2;
        if (i != j2 - j) {
            this.e = 0;
            return;
        }
        this.f = j3;
        this.e = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j, long j2, long j3) {
        long j4 = this.f25163c;
        long j5 = this.b;
        long j6 = ((((j4 - j5) * j2) / this.f) - j3) + j;
        if (j6 < j5) {
            j6 = j5;
        }
        long j7 = this.f25163c;
        long j8 = j6;
        if (j6 >= j7) {
            j8 = j7 - 1;
        }
        return j8;
    }

    @Override // com.opos.exoplayer.core.c.e.g
    public long a(long j) {
        int i = this.e;
        com.opos.exoplayer.core.i.a.a(i == 3 || i == 2);
        this.h = j == 0 ? 0L : this.d.b(j);
        this.e = 2;
        b();
        return this.h;
    }

    public long a(long j, com.opos.exoplayer.core.c.f fVar) {
        long j2;
        if (this.i != this.j) {
            long c2 = fVar.c();
            if (!a(fVar, this.j)) {
                long j3 = this.i;
                if (j3 != c2) {
                    return j3;
                }
                throw new IOException("No ogg page can be found.");
            }
            this.f25162a.a(fVar, false);
            fVar.a();
            long j4 = j - this.f25162a.f25171c;
            int i = this.f25162a.h + this.f25162a.i;
            int i2 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i2 >= 0 && j4 <= 72000) {
                fVar.b(i);
                j2 = this.f25162a.f25171c;
                return -(j2 + 2);
            }
            if (i2 < 0) {
                this.j = c2;
                this.l = this.f25162a.f25171c;
            } else {
                long j5 = i;
                this.i = fVar.c() + j5;
                this.k = this.f25162a.f25171c;
                if ((this.j - this.i) + j5 < 100000) {
                    fVar.b(i);
                }
            }
            long j6 = this.j;
            long j7 = this.i;
            if (j6 - j7 < 100000) {
                this.j = j7;
                return j7;
            }
            long j8 = i;
            long j9 = i2 <= 0 ? 2L : 1L;
            long c3 = fVar.c();
            long j10 = this.j;
            long j11 = this.i;
            return Math.min(Math.max((c3 - (j9 * j8)) + ((j4 * (j10 - j11)) / (this.l - this.k)), j11), this.j - 1);
        }
        j2 = this.k;
        return -(j2 + 2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
        if (r0 <= r0) goto L22;
     */
    @Override // com.opos.exoplayer.core.c.e.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(com.opos.exoplayer.core.c.f r10) {
        /*
            r9 = this;
            r0 = r9
            int r0 = r0.e
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L62
            r0 = r11
            r1 = 1
            if (r0 == r1) goto L8a
            r0 = r11
            r1 = 2
            if (r0 == r1) goto L24
            r0 = r11
            r1 = 3
            if (r0 != r1) goto L1c
            r0 = -1
            return r0
        L1c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r1.<init>()
            throw r0
        L24:
            r0 = r9
            long r0 = r0.h
            r14 = r0
            r0 = 0
            r12 = r0
            r0 = r14
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L36
            goto L56
        L36:
            r0 = r9
            r1 = r14
            r2 = r10
            long r0 = r0.a(r1, r2)
            r12 = r0
            r0 = r12
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L46
            r0 = r12
            return r0
        L46:
            r0 = r9
            r1 = r10
            r2 = r9
            long r2 = r2.h
            r3 = r12
            r4 = 2
            long r3 = r3 + r4
            long r3 = -r3
            long r0 = r0.a(r1, r2, r3)
            r12 = r0
        L56:
            r0 = r9
            r1 = 3
            r0.e = r1
            r0 = r12
            r1 = 2
            long r0 = r0 + r1
            long r0 = -r0
            return r0
        L62:
            r0 = r10
            long r0 = r0.c()
            r16 = r0
            r0 = r9
            r1 = r16
            r0.g = r1
            r0 = r9
            r1 = 1
            r0.e = r1
            r0 = r9
            long r0 = r0.f25163c
            r1 = 65307(0xff1b, double:3.2266E-319)
            long r0 = r0 - r1
            r14 = r0
            r0 = r14
            r12 = r0
            r0 = r14
            r1 = r16
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L9d
        L8a:
            r0 = r9
            r1 = r9
            r2 = r10
            long r1 = r1.c(r2)
            r0.f = r1
            r0 = r9
            r1 = 3
            r0.e = r1
            r0 = r9
            long r0 = r0.g
            r12 = r0
        L9d:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.c.e.c.a(com.opos.exoplayer.core.c.f):long");
    }

    long a(com.opos.exoplayer.core.c.f fVar, long j, long j2) {
        f fVar2 = this.f25162a;
        while (true) {
            fVar2.a(fVar, false);
            if (this.f25162a.f25171c >= j) {
                fVar.a();
                return j2;
            }
            fVar.b(this.f25162a.h + this.f25162a.i);
            j2 = this.f25162a.f25171c;
            fVar2 = this.f25162a;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.g
    /* renamed from: a */
    public a c() {
        a aVar = null;
        if (this.f != 0) {
            aVar = new a();
        }
        return aVar;
    }

    boolean a(com.opos.exoplayer.core.c.f fVar, long j) {
        int i;
        long min = Math.min(j + 3, this.f25163c);
        int i2 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i3 = 0;
            if (fVar.c() + i2 > min) {
                int c2 = (int) (min - fVar.c());
                i2 = c2;
                if (c2 < 4) {
                    return false;
                }
            }
            fVar.b(bArr, 0, i2, false);
            while (true) {
                i = i2 - 3;
                if (i3 < i) {
                    if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        fVar.b(i3);
                        return true;
                    }
                    i3++;
                }
            }
            fVar.b(i);
        }
    }

    public void b() {
        this.i = this.b;
        this.j = this.f25163c;
        this.k = 0L;
        this.l = this.f;
    }

    void b(com.opos.exoplayer.core.c.f fVar) {
        if (!a(fVar, this.f25163c)) {
            throw new EOFException();
        }
    }

    long c(com.opos.exoplayer.core.c.f fVar) {
        b(fVar);
        this.f25162a.a();
        while ((this.f25162a.b & 4) != 4 && fVar.c() < this.f25163c) {
            this.f25162a.a(fVar, false);
            fVar.b(this.f25162a.h + this.f25162a.i);
        }
        return this.f25162a.f25171c;
    }
}
