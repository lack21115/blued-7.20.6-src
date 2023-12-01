package com.opos.exoplayer.core.g;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.e.l;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/b.class */
public abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    protected final l f11731a;
    protected final int b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f11732c;
    private final Format[] d;
    private final long[] e;
    private int f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/b$a.class */
    static final class a implements Comparator<Format> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Format format, Format format2) {
            return format2.b - format.b;
        }
    }

    public b(l lVar, int... iArr) {
        com.opos.exoplayer.core.i.a.b(iArr.length > 0);
        this.f11731a = (l) com.opos.exoplayer.core.i.a.a(lVar);
        int length = iArr.length;
        this.b = length;
        this.d = new Format[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                break;
            }
            this.d[i2] = lVar.a(iArr[i2]);
            i = i2 + 1;
        }
        Arrays.sort(this.d, new a());
        this.f11732c = new int[this.b];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            int i5 = this.b;
            if (i4 >= i5) {
                this.e = new long[i5];
                return;
            } else {
                this.f11732c[i4] = lVar.a(this.d[i4]);
                i3 = i4 + 1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.g.f
    public final Format a(int i) {
        return this.d[i];
    }

    @Override // com.opos.exoplayer.core.g.f
    public void a() {
    }

    @Override // com.opos.exoplayer.core.g.f
    public void a(float f) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i, long j) {
        return this.e[i] > j;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final int b(int i) {
        return this.f11732c[i];
    }

    @Override // com.opos.exoplayer.core.g.f
    public void c() {
    }

    @Override // com.opos.exoplayer.core.g.f
    public final l d() {
        return this.f11731a;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final int e() {
        return this.f11732c.length;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                z = false;
                if (this.f11731a == bVar.f11731a) {
                    if (!Arrays.equals(this.f11732c, bVar.f11732c)) {
                        return false;
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    @Override // com.opos.exoplayer.core.g.f
    public final Format f() {
        return this.d[b()];
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = (System.identityHashCode(this.f11731a) * 31) + Arrays.hashCode(this.f11732c);
        }
        return this.f;
    }
}
