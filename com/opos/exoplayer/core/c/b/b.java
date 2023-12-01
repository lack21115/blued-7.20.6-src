package com.opos.exoplayer.core.c.b;

import com.opos.exoplayer.core.o;
import java.util.Stack;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/b.class */
final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f25095a = new byte[8];
    private final Stack<a> b = new Stack<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f25096c = new f();
    private d d;
    private int e;
    private int f;
    private long g;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/b/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f25097a;
        private final long b;

        private a(int i, long j) {
            this.f25097a = i;
            this.b = j;
        }
    }

    private long a(com.opos.exoplayer.core.c.f fVar, int i) {
        fVar.b(this.f25095a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.f25095a[i2] & 255);
        }
        return j;
    }

    private double b(com.opos.exoplayer.core.c.f fVar, int i) {
        long a2 = a(fVar, i);
        return i == 4 ? Float.intBitsToFloat((int) a2) : Double.longBitsToDouble(a2);
    }

    private long b(com.opos.exoplayer.core.c.f fVar) {
        fVar.a();
        while (true) {
            fVar.c(this.f25095a, 0, 4);
            int a2 = f.a(this.f25095a[0]);
            if (a2 != -1 && a2 <= 4) {
                int a3 = (int) f.a(this.f25095a, a2, false);
                if (this.d.b(a3)) {
                    fVar.b(a2);
                    return a3;
                }
            }
            fVar.b(1);
        }
    }

    private String c(com.opos.exoplayer.core.c.f fVar, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        fVar.b(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public void a() {
        this.e = 0;
        this.b.clear();
        this.f25096c.a();
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public void a(d dVar) {
        this.d = dVar;
    }

    @Override // com.opos.exoplayer.core.c.b.c
    public boolean a(com.opos.exoplayer.core.c.f fVar) {
        com.opos.exoplayer.core.i.a.b(this.d != null);
        while (true) {
            if (!this.b.isEmpty() && fVar.c() >= this.b.peek().b) {
                this.d.c(this.b.pop().f25097a);
                return true;
            }
            if (this.e == 0) {
                long a2 = this.f25096c.a(fVar, true, false, 4);
                long j = a2;
                if (a2 == -2) {
                    j = b(fVar);
                }
                if (j == -1) {
                    return false;
                }
                this.f = (int) j;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.f25096c.a(fVar, false, true, 8);
                this.e = 2;
            }
            int a3 = this.d.a(this.f);
            if (a3 != 0) {
                if (a3 == 1) {
                    long c2 = fVar.c();
                    this.b.add(new a(this.f, this.g + c2));
                    this.d.a(this.f, c2, this.g);
                } else if (a3 == 2) {
                    long j2 = this.g;
                    if (j2 > 8) {
                        throw new o("Invalid integer size: " + this.g);
                    }
                    this.d.a(this.f, a(fVar, (int) j2));
                } else if (a3 == 3) {
                    long j3 = this.g;
                    if (j3 > 2147483647L) {
                        throw new o("String element size: " + this.g);
                    }
                    this.d.a(this.f, c(fVar, (int) j3));
                } else if (a3 == 4) {
                    this.d.a(this.f, (int) this.g, fVar);
                } else if (a3 != 5) {
                    throw new o("Invalid element type " + a3);
                } else {
                    long j4 = this.g;
                    if (j4 != 4 && j4 != 8) {
                        throw new o("Invalid float size: " + this.g);
                    }
                    this.d.a(this.f, b(fVar, (int) this.g));
                }
                this.e = 0;
                return true;
            }
            fVar.b((int) this.g);
            this.e = 0;
        }
    }
}
