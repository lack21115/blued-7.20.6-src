package com.opos.exoplayer.core.f.c;

import android.graphics.Bitmap;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.f.d;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/c/a.class */
public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final m f25366a;
    private final C0663a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/c/a$a.class */
    public static final class C0663a {

        /* renamed from: a  reason: collision with root package name */
        private final m f25367a = new m();
        private final int[] b = new int[256];

        /* renamed from: c  reason: collision with root package name */
        private boolean f25368c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;

        /* JADX INFO: Access modifiers changed from: private */
        public void a(m mVar, int i) {
            if (i % 5 != 2) {
                return;
            }
            mVar.d(2);
            Arrays.fill(this.b, 0);
            int i2 = i / 5;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    this.f25368c = true;
                    return;
                }
                int g = mVar.g();
                int g2 = mVar.g();
                int g3 = mVar.g();
                int g4 = mVar.g();
                int g5 = mVar.g();
                double d = g2;
                double d2 = g3 - 128;
                int i5 = (int) ((1.402d * d2) + d);
                double d3 = g4 - 128;
                int i6 = (int) ((d - (0.34414d * d3)) - (d2 * 0.71414d));
                int i7 = (int) (d + (d3 * 1.772d));
                this.b[g] = u.a(i7, 0, 255) | (u.a(i6, 0, 255) << 8) | (g5 << 24) | (u.a(i5, 0, 255) << 16);
                i3 = i4 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(m mVar, int i) {
            int k;
            if (i < 4) {
                return;
            }
            mVar.d(3);
            int i2 = i - 4;
            int i3 = i2;
            if ((mVar.g() & 128) != 0) {
                if (i2 < 7 || (k = mVar.k()) < 4) {
                    return;
                }
                this.h = mVar.h();
                this.i = mVar.h();
                this.f25367a.a(k - 4);
                i3 = i2 - 7;
            }
            int d = this.f25367a.d();
            int c2 = this.f25367a.c();
            if (d >= c2 || i3 <= 0) {
                return;
            }
            int min = Math.min(i3, c2 - d);
            mVar.a(this.f25367a.f25496a, d, min);
            this.f25367a.c(min + d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(m mVar, int i) {
            if (i < 19) {
                return;
            }
            this.d = mVar.h();
            this.e = mVar.h();
            mVar.d(11);
            this.f = mVar.h();
            this.g = mVar.h();
        }

        public com.opos.exoplayer.core.f.b a() {
            if (this.d == 0 || this.e == 0 || this.h == 0 || this.i == 0 || this.f25367a.c() == 0 || this.f25367a.d() != this.f25367a.c() || !this.f25368c) {
                return null;
            }
            this.f25367a.c(0);
            int i = this.h * this.i;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int g = this.f25367a.g();
                if (g != 0) {
                    iArr[i2] = this.b[g];
                    i2++;
                } else {
                    int g2 = this.f25367a.g();
                    if (g2 != 0) {
                        int g3 = (g2 & 64) == 0 ? g2 & 63 : ((g2 & 63) << 8) | this.f25367a.g();
                        int i3 = (g2 & 128) == 0 ? 0 : this.b[this.f25367a.g()];
                        int i4 = g3 + i2;
                        Arrays.fill(iArr, i2, i4, i3);
                        i2 = i4;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, this.h, this.i, Bitmap.Config.ARGB_8888);
            float f = this.f;
            int i5 = this.d;
            float f2 = f / i5;
            float f3 = this.g;
            int i6 = this.e;
            return new com.opos.exoplayer.core.f.b(createBitmap, f2, 0, f3 / i6, 0, this.h / i5, this.i / i6);
        }

        public void b() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.f25367a.a(0);
            this.f25368c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f25366a = new m();
        this.b = new C0663a();
    }

    private static com.opos.exoplayer.core.f.b a(m mVar, C0663a c0663a) {
        com.opos.exoplayer.core.f.b bVar;
        int c2 = mVar.c();
        int g = mVar.g();
        int h = mVar.h();
        int d = mVar.d() + h;
        if (d > c2) {
            mVar.c(c2);
            return null;
        }
        if (g != 128) {
            switch (g) {
                case 20:
                    c0663a.a(mVar, h);
                    bVar = null;
                    break;
                case 21:
                    c0663a.b(mVar, h);
                    bVar = null;
                    break;
                case 22:
                    c0663a.c(mVar, h);
                    bVar = null;
                    break;
                default:
                    bVar = null;
                    break;
            }
        } else {
            com.opos.exoplayer.core.f.b a2 = c0663a.a();
            c0663a.b();
            bVar = a2;
        }
        mVar.c(d);
        return bVar;
    }

    @Override // com.opos.exoplayer.core.f.c
    public d a(byte[] bArr, int i, boolean z) {
        this.f25366a.a(bArr, i);
        this.b.b();
        ArrayList arrayList = new ArrayList();
        while (this.f25366a.b() >= 3) {
            com.opos.exoplayer.core.f.b a2 = a(this.f25366a, this.b);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
