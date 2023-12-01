package com.opos.exoplayer.core.h;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/j.class */
public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11763a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11764c;
    private final a[] d;
    private int e;
    private int f;
    private int g;
    private a[] h;

    public j(boolean z, int i) {
        this(z, i, 0);
    }

    public j(boolean z, int i, int i2) {
        com.opos.exoplayer.core.i.a.a(i > 0);
        com.opos.exoplayer.core.i.a.a(i2 >= 0);
        this.f11763a = z;
        this.b = i;
        this.g = i2;
        this.h = new a[i2 + 100];
        if (i2 > 0) {
            this.f11764c = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.h[i3] = new a(this.f11764c, i3 * i);
            }
        } else {
            this.f11764c = null;
        }
        this.d = new a[1];
    }

    @Override // com.opos.exoplayer.core.h.b
    public a a() {
        a aVar;
        synchronized (this) {
            this.f++;
            if (this.g > 0) {
                a[] aVarArr = this.h;
                int i = this.g - 1;
                this.g = i;
                aVar = aVarArr[i];
                this.h[i] = null;
            } else {
                aVar = new a(new byte[this.b], 0);
            }
        }
        return aVar;
    }

    public void a(int i) {
        synchronized (this) {
            boolean z = i < this.e;
            this.e = i;
            if (z) {
                b();
            }
        }
    }

    @Override // com.opos.exoplayer.core.h.b
    public void a(a aVar) {
        synchronized (this) {
            this.d[0] = aVar;
            a(this.d);
        }
    }

    @Override // com.opos.exoplayer.core.h.b
    public void a(a[] aVarArr) {
        boolean z;
        synchronized (this) {
            if (this.g + aVarArr.length >= this.h.length) {
                this.h = (a[]) Arrays.copyOf(this.h, Math.max(this.h.length * 2, this.g + aVarArr.length));
            }
            int length = aVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    a aVar = aVarArr[i2];
                    if (aVar.f11753a != this.f11764c && aVar.f11753a.length != this.b) {
                        z = false;
                        com.opos.exoplayer.core.i.a.a(z);
                        a[] aVarArr2 = this.h;
                        int i3 = this.g;
                        this.g = i3 + 1;
                        aVarArr2[i3] = aVar;
                        i = i2 + 1;
                    }
                    z = true;
                    com.opos.exoplayer.core.i.a.a(z);
                    a[] aVarArr22 = this.h;
                    int i32 = this.g;
                    this.g = i32 + 1;
                    aVarArr22[i32] = aVar;
                    i = i2 + 1;
                } else {
                    this.f -= aVarArr.length;
                    notifyAll();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a1, code lost:
        if (r6 < r5.g) goto L43;
     */
    @Override // com.opos.exoplayer.core.h.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.h.j.b():void");
    }

    @Override // com.opos.exoplayer.core.h.b
    public int c() {
        return this.b;
    }

    public void d() {
        synchronized (this) {
            if (this.f11763a) {
                a(0);
            }
        }
    }

    public int e() {
        int i;
        int i2;
        synchronized (this) {
            i = this.f;
            i2 = this.b;
        }
        return i * i2;
    }
}
