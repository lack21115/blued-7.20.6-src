package com.anythink.expressad.exoplayer.j;

import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/l.class */
public final class l implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7585a = 100;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7586c;
    private final byte[] d;
    private final a[] e;
    private int f;
    private int g;
    private int h;
    private a[] i;

    private l() {
        com.anythink.expressad.exoplayer.k.a.a(true);
        com.anythink.expressad.exoplayer.k.a.a(true);
        this.b = true;
        this.f7586c = 65536;
        this.h = 0;
        this.i = new a[100];
        this.d = null;
        this.e = new a[1];
    }

    public l(byte b) {
        this();
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final a a() {
        a aVar;
        synchronized (this) {
            this.g++;
            if (this.h > 0) {
                a[] aVarArr = this.i;
                int i = this.h - 1;
                this.h = i;
                aVar = aVarArr[i];
                this.i[i] = null;
            } else {
                aVar = new a(new byte[this.f7586c]);
            }
        }
        return aVar;
    }

    public final void a(int i) {
        synchronized (this) {
            boolean z = i < this.f;
            this.f = i;
            if (z) {
                b();
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final void a(a aVar) {
        synchronized (this) {
            this.e[0] = aVar;
            a(this.e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final void a(a[] aVarArr) {
        synchronized (this) {
            if (this.h + aVarArr.length >= this.i.length) {
                this.i = (a[]) Arrays.copyOf(this.i, Math.max(this.i.length * 2, this.h + aVarArr.length));
            }
            int length = aVarArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    a aVar = aVarArr[i2];
                    if (aVar.f7550a != this.d && aVar.f7550a.length != this.f7586c) {
                        throw new IllegalArgumentException("Unexpected allocation: " + System.identityHashCode(aVar.f7550a) + ", " + System.identityHashCode(this.d) + ", " + aVar.f7550a.length + ", " + this.f7586c);
                    }
                    a[] aVarArr2 = this.i;
                    int i3 = this.h;
                    this.h = i3 + 1;
                    aVarArr2[i3] = aVar;
                    i = i2 + 1;
                } else {
                    this.g -= aVarArr.length;
                    notifyAll();
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final void b() {
        synchronized (this) {
            int max = Math.max(0, af.a(this.f, this.f7586c) - this.g);
            if (max >= this.h) {
                return;
            }
            int i = max;
            if (this.d != null) {
                int i2 = this.h - 1;
                int i3 = 0;
                while (i3 <= i2) {
                    a aVar = this.i[i3];
                    if (aVar.f7550a == this.d) {
                        i3++;
                    } else {
                        a aVar2 = this.i[i2];
                        if (aVar2.f7550a != this.d) {
                            i2--;
                        } else {
                            this.i[i3] = aVar2;
                            this.i[i2] = aVar;
                            i2--;
                            i3++;
                        }
                    }
                }
                int max2 = Math.max(max, i3);
                i = max2;
                if (max2 >= this.h) {
                    return;
                }
            }
            Arrays.fill(this.i, i, this.h, (Object) null);
            this.h = i;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final int c() {
        int i;
        int i2;
        synchronized (this) {
            i = this.g;
            i2 = this.f7586c;
        }
        return i * i2;
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final int d() {
        return this.f7586c;
    }

    public final void e() {
        synchronized (this) {
            if (this.b) {
                a(0);
            }
        }
    }
}
