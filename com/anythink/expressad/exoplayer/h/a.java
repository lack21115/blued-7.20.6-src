package com.anythink.expressad.exoplayer.h;

import android.util.Pair;
import com.anythink.expressad.exoplayer.ae;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a.class */
abstract class a extends com.anythink.expressad.exoplayer.ae {
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final aa f7380c;
    private final boolean d;

    public a(boolean z, aa aaVar) {
        this.d = z;
        this.f7380c = aaVar;
        this.b = aaVar.a();
    }

    private int a(int i, boolean z) {
        if (z) {
            return this.f7380c.a(i);
        }
        if (i < this.b - 1) {
            return i + 1;
        }
        return -1;
    }

    private int b(int i, boolean z) {
        if (z) {
            return this.f7380c.b(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    protected abstract int a(int i);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(int i, int i2, boolean z) {
        int i3;
        int i4 = i2;
        if (this.d) {
            i4 = i2;
            if (i2 == 1) {
                i4 = 2;
            }
            z = false;
        }
        int b = b(i);
        int e = e(b);
        int a2 = c(b).a(i - e, i4 == 2 ? 0 : i4, z);
        if (a2 != -1) {
            return e + a2;
        }
        int a3 = a(b, z);
        while (true) {
            i3 = a3;
            if (i3 == -1 || !c(i3).a()) {
                break;
            }
            a3 = a(i3, z);
        }
        if (i3 != -1) {
            return e(i3) + c(i3).b(z);
        }
        if (i4 == 2) {
            return b(z);
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(Object obj) {
        int a2;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int b = b(obj2);
            if (b == -1 || (a2 = c(b).a(obj3)) == -1) {
                return -1;
            }
            return d(b) + a2;
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final int a(boolean z) {
        if (this.b == 0) {
            return -1;
        }
        if (this.d) {
            z = false;
        }
        int b = z ? this.f7380c.b() : this.b - 1;
        while (c(b).a()) {
            int b2 = b(b, z);
            b = b2;
            if (b2 == -1) {
                return -1;
            }
        }
        return e(b) + c(b).a(z);
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final ae.a a(int i, ae.a aVar, boolean z) {
        int a2 = a(i);
        int e = e(a2);
        c(a2).a(i - d(a2), aVar, z);
        aVar.f7162c += e;
        if (z) {
            aVar.b = Pair.create(f(a2), aVar.b);
        }
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.ae
    public final ae.b a(int i, ae.b bVar, boolean z, long j) {
        int b = b(i);
        int e = e(b);
        int d = d(b);
        c(b).a(i - e, bVar, z, j);
        bVar.f += d;
        bVar.g += d;
        return bVar;
    }

    protected abstract int b(int i);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(int i, int i2, boolean z) {
        int i3;
        int i4 = i2;
        if (this.d) {
            i4 = i2;
            if (i2 == 1) {
                i4 = 2;
            }
            z = false;
        }
        int b = b(i);
        int e = e(b);
        int b2 = c(b).b(i - e, i4 == 2 ? 0 : i4, z);
        if (b2 != -1) {
            return e + b2;
        }
        int b3 = b(b, z);
        while (true) {
            i3 = b3;
            if (i3 == -1 || !c(i3).a()) {
                break;
            }
            b3 = b(i3, z);
        }
        if (i3 != -1) {
            return e(i3) + c(i3).a(z);
        }
        if (i4 == 2) {
            return a(z);
        }
        return -1;
    }

    protected abstract int b(Object obj);

    @Override // com.anythink.expressad.exoplayer.ae
    public final int b(boolean z) {
        if (this.b == 0) {
            return -1;
        }
        int i = 0;
        if (this.d) {
            z = false;
        }
        if (z) {
            i = this.f7380c.c();
        }
        while (c(i).a()) {
            int a2 = a(i, z);
            i = a2;
            if (a2 == -1) {
                return -1;
            }
        }
        return e(i) + c(i).b(z);
    }

    protected abstract com.anythink.expressad.exoplayer.ae c(int i);

    protected abstract int d(int i);

    protected abstract int e(int i);

    protected abstract Object f(int i);
}
