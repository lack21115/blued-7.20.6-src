package com.opos.exoplayer.core.c.e;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.c.e.i;
import com.opos.exoplayer.core.c.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/d.class */
final class d extends i {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.exoplayer.core.i.f f25165a;
    private a b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/e/d$a.class */
    class a implements g, l {
        private long[] b;

        /* renamed from: c  reason: collision with root package name */
        private long[] f25167c;
        private long d = -1;
        private long e = -1;

        public a() {
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(long j) {
            long b = d.this.b(j);
            this.e = this.b[u.a(this.b, b, true, true)];
            return b;
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public long a(com.opos.exoplayer.core.c.f fVar) {
            long j = this.e;
            long j2 = -1;
            if (j >= 0) {
                j2 = -(j + 2);
                this.e = -1L;
            }
            return j2;
        }

        public void a(m mVar) {
            mVar.d(1);
            int k = mVar.k() / 18;
            this.b = new long[k];
            this.f25167c = new long[k];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= k) {
                    return;
                }
                this.b[i2] = mVar.q();
                this.f25167c[i2] = mVar.q();
                mVar.d(2);
                i = i2 + 1;
            }
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return true;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return d.this.f25165a.b();
        }

        @Override // com.opos.exoplayer.core.c.l
        public l.a b(long j) {
            int a2 = u.a(this.b, d.this.b(j), true, true);
            long a3 = d.this.a(this.b[a2]);
            com.opos.exoplayer.core.c.m mVar = new com.opos.exoplayer.core.c.m(a3, this.d + this.f25167c[a2]);
            if (a3 < j) {
                long[] jArr = this.b;
                if (a2 != jArr.length - 1) {
                    int i = a2 + 1;
                    return new l.a(mVar, new com.opos.exoplayer.core.c.m(d.this.a(jArr[i]), this.d + this.f25167c[i]));
                }
            }
            return new l.a(mVar);
        }

        @Override // com.opos.exoplayer.core.c.e.g
        public l c() {
            return this;
        }

        public void c(long j) {
            this.d = j;
        }
    }

    public static boolean a(m mVar) {
        return mVar.b() >= 5 && mVar.g() == 127 && mVar.m() == 1179402563;
    }

    private static boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr[0] == -1) {
            z = true;
        }
        return z;
    }

    private int c(m mVar) {
        int i;
        int i2;
        int i3 = (mVar.f25496a[2] & 255) >> 4;
        switch (i3) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                i = 576;
                i2 = i3 - 2;
                break;
            case 6:
            case 7:
                mVar.d(4);
                mVar.A();
                int g = i3 == 6 ? mVar.g() : mVar.h();
                mVar.c(0);
                return g + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i = 256;
                i2 = i3 - 8;
                break;
            default:
                return -1;
        }
        return i << i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.c.e.i
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f25165a = null;
            this.b = null;
        }
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected boolean a(m mVar, long j, i.a aVar) {
        byte[] bArr = mVar.f25496a;
        boolean z = false;
        if (this.f25165a == null) {
            this.f25165a = new com.opos.exoplayer.core.i.f(bArr, 17);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, mVar.c());
            copyOfRange[4] = (byte) (-128);
            aVar.f25176a = Format.a(null, "audio/flac", null, -1, this.f25165a.a(), this.f25165a.f, this.f25165a.e, Collections.singletonList(copyOfRange), null, 0, null);
        } else if ((bArr[0] & Byte.MAX_VALUE) == 3) {
            a aVar2 = new a();
            this.b = aVar2;
            aVar2.a(mVar);
        } else if (a(bArr)) {
            a aVar3 = this.b;
            if (aVar3 != null) {
                aVar3.c(j);
                aVar.b = this.b;
                return false;
            }
            return z;
        }
        z = true;
        return z;
    }

    @Override // com.opos.exoplayer.core.c.e.i
    protected long b(m mVar) {
        if (a(mVar.f25496a)) {
            return c(mVar);
        }
        return -1L;
    }
}
