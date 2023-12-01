package com.anythink.expressad.exoplayer.i;

import android.os.SystemClock;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.m;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/b.class */
public abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final m[] f7525a;
    private final long[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f7526c;
    protected final ae g;
    protected final int h;
    protected final int[] i;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/b$a.class */
    static final class a implements Comparator<m> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        private static int a(m mVar, m mVar2) {
            return mVar2.d - mVar.d;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(m mVar, m mVar2) {
            return mVar2.d - mVar.d;
        }
    }

    public b(ae aeVar, int... iArr) {
        com.anythink.expressad.exoplayer.k.a.b(iArr.length > 0);
        this.g = (ae) com.anythink.expressad.exoplayer.k.a.a(aeVar);
        int length = iArr.length;
        this.h = length;
        this.f7525a = new m[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                break;
            }
            this.f7525a[i2] = aeVar.a(iArr[i2]);
            i = i2 + 1;
        }
        Arrays.sort(this.f7525a, new a((byte) 0));
        this.i = new int[this.h];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            int i5 = this.h;
            if (i4 >= i5) {
                this.b = new long[i5];
                return;
            } else {
                this.i[i4] = aeVar.a(this.f7525a[i4]);
                i3 = i4 + 1;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public int a(long j, List<? extends com.anythink.expressad.exoplayer.h.b.i> list) {
        return list.size();
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int a(m mVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h) {
                return -1;
            }
            if (this.f7525a[i2] == mVar) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final m a(int i) {
        return this.f7525a[i];
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public void a() {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public void a(float f) {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final boolean a(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b = b(i, elapsedRealtime);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.h || b) {
                break;
            }
            b = (i3 == i || b(i3, elapsedRealtime)) ? false : true;
            i2 = i3 + 1;
        }
        if (b) {
            long[] jArr = this.b;
            jArr[i] = Math.max(jArr[i], elapsedRealtime + j);
            return true;
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b(int i) {
        return this.i[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(int i, long j) {
        return this.b[i] > j;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.h) {
                return -1;
            }
            if (this.i[i3] == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void e() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.g == bVar.g && Arrays.equals(this.i, bVar.i);
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final ae f() {
        return this.g;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int g() {
        return this.i.length;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final m h() {
        return this.f7525a[b()];
    }

    public int hashCode() {
        if (this.f7526c == 0) {
            this.f7526c = (System.identityHashCode(this.g) * 31) + Arrays.hashCode(this.i);
        }
        return this.f7526c;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int i() {
        return this.i[b()];
    }
}
