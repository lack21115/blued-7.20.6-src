package com.anythink.expressad.exoplayer.h;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/g.class */
public final class g implements z {

    /* renamed from: a  reason: collision with root package name */
    protected final z[] f4616a;

    public g(z[] zVarArr) {
        this.f4616a = zVarArr;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        z[] zVarArr = this.f4616a;
        int length = zVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            zVarArr[i2].a_(j);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        boolean z;
        boolean z2;
        boolean c2;
        boolean z3 = false;
        do {
            long e = e();
            if (e == Long.MIN_VALUE) {
                return z3;
            }
            z[] zVarArr = this.f4616a;
            int length = zVarArr.length;
            int i = 0;
            boolean z4 = false;
            while (true) {
                z = z4;
                if (i < length) {
                    z zVar = zVarArr[i];
                    long e2 = zVar.e();
                    boolean z5 = e2 != Long.MIN_VALUE && e2 <= j;
                    if (e2 != e) {
                        c2 = z;
                        if (!z5) {
                            i++;
                            z4 = c2;
                        }
                    }
                    c2 = z | zVar.c(j);
                    i++;
                    z4 = c2;
                } else {
                    z2 = z3 | z;
                    z3 = z2;
                }
            }
        } while (z);
        return z2;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long j;
        z[] zVarArr = this.f4616a;
        int length = zVarArr.length;
        int i = 0;
        long j2 = Long.MAX_VALUE;
        while (true) {
            j = j2;
            if (i >= length) {
                break;
            }
            long d = zVarArr[i].d();
            long j3 = j;
            if (d != Long.MIN_VALUE) {
                j3 = Math.min(j, d);
            }
            i++;
            j2 = j3;
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long e() {
        long j;
        z[] zVarArr = this.f4616a;
        int length = zVarArr.length;
        int i = 0;
        long j2 = Long.MAX_VALUE;
        while (true) {
            j = j2;
            if (i >= length) {
                break;
            }
            long e = zVarArr[i].e();
            long j3 = j;
            if (e != Long.MIN_VALUE) {
                j3 = Math.min(j, e);
            }
            i++;
            j2 = j3;
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
