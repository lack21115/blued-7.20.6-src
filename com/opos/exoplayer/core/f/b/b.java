package com.opos.exoplayer.core.f.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.SparseArray;
import com.opos.exoplayer.core.i.l;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b.class */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11659a = {0, 7, 8, 15};
    private static final byte[] b = {0, 119, -120, -1};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f11660c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint d;
    private final Paint e;
    private final Canvas f;
    private final C0492b g;
    private final a h;
    private final h i;
    private Bitmap j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f11661a;
        public final int[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f11662c;
        public final int[] d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f11661a = i;
            this.b = iArr;
            this.f11662c = iArr2;
            this.d = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.exoplayer.core.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$b.class */
    public static final class C0492b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11663a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11664c;
        public final int d;
        public final int e;
        public final int f;

        public C0492b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f11663a = i;
            this.b = i2;
            this.f11664c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f11665a;
        public final boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11666c;
        public final byte[] d;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.f11665a = i;
            this.b = z;
            this.f11666c = bArr;
            this.d = bArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$d.class */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f11667a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11668c;
        public final SparseArray<e> d;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f11667a = i;
            this.b = i2;
            this.f11668c = i3;
            this.d = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$e.class */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f11669a;
        public final int b;

        public e(int i, int i2) {
            this.f11669a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$f.class */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final int f11670a;
        public final boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11671c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final SparseArray<g> k;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.f11670a = i;
            this.b = z;
            this.f11671c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = i8;
            this.j = i9;
            this.k = sparseArray;
        }

        public void a(f fVar) {
            if (fVar == null) {
                return;
            }
            SparseArray<g> sparseArray = fVar.k;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sparseArray.size()) {
                    return;
                }
                this.k.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2));
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$g.class */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final int f11672a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11673c;
        public final int d;
        public final int e;
        public final int f;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f11672a = i;
            this.b = i2;
            this.f11673c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b/b$h.class */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public final int f11674a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final SparseArray<f> f11675c = new SparseArray<>();
        public final SparseArray<a> d = new SparseArray<>();
        public final SparseArray<c> e = new SparseArray<>();
        public final SparseArray<a> f = new SparseArray<>();
        public final SparseArray<c> g = new SparseArray<>();
        public C0492b h;
        public d i;

        public h(int i, int i2) {
            this.f11674a = i;
            this.b = i2;
        }

        public void a() {
            this.f11675c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h = null;
            this.i = null;
        }
    }

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.d.setPathEffect(null);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.e.setPathEffect(null);
        this.f = new Canvas();
        this.g = new C0492b(719, 575, 0, 719, 0, 575);
        this.h = new a(0, b(), c(), d());
        this.i = new h(i, i2);
    }

    private static int a(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010c A[LOOP:0: B:3:0x0009->B:39:0x010c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.opos.exoplayer.core.i.l r7, int[] r8, byte[] r9, int r10, int r11, android.graphics.Paint r12, android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.b.b.a(com.opos.exoplayer.core.i.l, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static C0492b a(l lVar) {
        int i;
        int i2;
        int i3;
        int i4;
        lVar.b(4);
        boolean e2 = lVar.e();
        lVar.b(3);
        int c2 = lVar.c(16);
        int c3 = lVar.c(16);
        if (e2) {
            i3 = lVar.c(16);
            i = lVar.c(16);
            i4 = lVar.c(16);
            i2 = lVar.c(16);
        } else {
            i = c2;
            i2 = c3;
            i3 = 0;
            i4 = 0;
        }
        return new C0492b(c2, c3, i3, i, i4, i2);
    }

    private static d a(l lVar, int i) {
        int c2 = lVar.c(8);
        int c3 = lVar.c(4);
        int c4 = lVar.c(2);
        lVar.b(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int c5 = lVar.c(8);
            lVar.b(8);
            i2 -= 6;
            sparseArray.put(c5, new e(lVar.c(16), lVar.c(16)));
        }
        return new d(c2, c3, c4, sparseArray);
    }

    private static void a(c cVar, a aVar, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr = i == 3 ? aVar.d : i == 2 ? aVar.f11662c : aVar.b;
        a(cVar.f11666c, iArr, i, i2, i3, paint, canvas);
        a(cVar.d, iArr, i, i2, i3 + 1, paint, canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v62, types: [com.opos.exoplayer.core.f.b.b$c] */
    /* JADX WARN: Type inference failed for: r0v65, types: [com.opos.exoplayer.core.f.b.b$c] */
    /* JADX WARN: Type inference failed for: r0v69, types: [com.opos.exoplayer.core.f.b.b$c] */
    private static void a(l lVar, h hVar) {
        a aVar;
        SparseArray sparseArray;
        int i;
        SparseArray sparseArray2;
        a aVar2;
        SparseArray sparseArray3;
        int c2 = lVar.c(8);
        int c3 = lVar.c(16);
        int c4 = lVar.c(16);
        int c5 = lVar.c();
        if (c4 * 8 > lVar.a()) {
            com.opos.cmn.an.f.a.c("DvbParser", "Data field length exceeds limit");
            lVar.b(lVar.a());
            return;
        }
        switch (c2) {
            case 16:
                if (c3 == hVar.f11674a) {
                    d dVar = hVar.i;
                    d a2 = a(lVar, c4);
                    if (a2.f11668c == 0) {
                        if (dVar != null && dVar.b != a2.b) {
                            hVar.i = a2;
                            break;
                        }
                    } else {
                        hVar.i = a2;
                        hVar.f11675c.clear();
                        hVar.d.clear();
                        hVar.e.clear();
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (c3 == hVar.f11674a && dVar2 != null) {
                    f b2 = b(lVar, c4);
                    if (dVar2.f11668c == 0) {
                        b2.a(hVar.f11675c.get(b2.f11670a));
                    }
                    hVar.f11675c.put(b2.f11670a, b2);
                    break;
                }
                break;
            case 18:
                if (c3 == hVar.f11674a) {
                    a c6 = c(lVar, c4);
                    sparseArray = hVar.d;
                    aVar = c6;
                } else if (c3 == hVar.b) {
                    a c7 = c(lVar, c4);
                    SparseArray sparseArray4 = hVar.f;
                    aVar = c7;
                    sparseArray = sparseArray4;
                }
                i = aVar.f11661a;
                sparseArray2 = sparseArray;
                aVar2 = aVar;
                sparseArray2.put(i, aVar2);
                break;
            case 19:
                if (c3 == hVar.f11674a) {
                    aVar2 = b(lVar);
                    sparseArray3 = hVar.e;
                } else if (c3 == hVar.b) {
                    aVar2 = b(lVar);
                    sparseArray3 = hVar.g;
                }
                i = aVar2.f11665a;
                sparseArray2 = sparseArray3;
                sparseArray2.put(i, aVar2);
                break;
            case 20:
                if (c3 == hVar.f11674a) {
                    hVar.h = a(lVar);
                    break;
                }
                break;
        }
        lVar.d((c5 + c4) - lVar.c());
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int a2;
        l lVar = new l(bArr);
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        int i4 = i3;
        int i5 = i2;
        while (lVar.a() != 0) {
            int c2 = lVar.c(8);
            if (c2 != 240) {
                switch (c2) {
                    case 16:
                        a2 = a(lVar, iArr, i == 3 ? bArr3 == null ? b : bArr3 : i == 2 ? bArr2 == null ? f11659a : bArr2 : null, i5, i4, paint, canvas);
                        i5 = a2;
                        lVar.f();
                        break;
                    case 17:
                        a2 = b(lVar, iArr, i == 3 ? f11660c : null, i5, i4, paint, canvas);
                        i5 = a2;
                        lVar.f();
                        break;
                    case 18:
                        i5 = c(lVar, iArr, null, i5, i4, paint, canvas);
                        break;
                    default:
                        switch (c2) {
                            case 32:
                                bArr2 = a(4, 4, lVar);
                                continue;
                            case 33:
                                bArr3 = a(4, 8, lVar);
                                continue;
                            case 34:
                                bArr3 = a(16, 8, lVar);
                                continue;
                        }
                }
            } else {
                i4 += 2;
                i5 = i2;
            }
        }
    }

    private static byte[] a(int i, int i2, l lVar) {
        byte[] bArr = new byte[i];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return bArr;
            }
            bArr[i4] = (byte) lVar.c(i2);
            i3 = i4 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0133 A[LOOP:0: B:3:0x0009->B:42:0x0133, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0130 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int b(com.opos.exoplayer.core.i.l r7, int[] r8, byte[] r9, int r10, int r11, android.graphics.Paint r12, android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.b.b.b(com.opos.exoplayer.core.i.l, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static c b(l lVar) {
        byte[] bArr;
        int c2 = lVar.c(16);
        lVar.b(4);
        int c3 = lVar.c(2);
        boolean e2 = lVar.e();
        lVar.b(1);
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        if (c3 == 1) {
            lVar.b(lVar.c(8) * 16);
        } else if (c3 == 0) {
            int c4 = lVar.c(16);
            int c5 = lVar.c(16);
            if (c4 > 0) {
                bArr2 = new byte[c4];
                lVar.b(bArr2, 0, c4);
            }
            bArr3 = bArr2;
            if (c5 > 0) {
                byte[] bArr4 = new byte[c5];
                lVar.b(bArr4, 0, c5);
                bArr3 = bArr2;
                bArr = bArr4;
                return new c(c2, e2, bArr3, bArr);
            }
        }
        bArr = bArr3;
        return new c(c2, e2, bArr3, bArr);
    }

    private static f b(l lVar, int i) {
        int c2;
        int i2;
        int c3 = lVar.c(8);
        lVar.b(4);
        boolean e2 = lVar.e();
        lVar.b(3);
        int c4 = lVar.c(16);
        int c5 = lVar.c(16);
        int c6 = lVar.c(3);
        int c7 = lVar.c(3);
        lVar.b(2);
        int c8 = lVar.c(8);
        int c9 = lVar.c(8);
        int c10 = lVar.c(4);
        int c11 = lVar.c(2);
        lVar.b(2);
        int i3 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int c12 = lVar.c(16);
            int c13 = lVar.c(2);
            int c14 = lVar.c(2);
            int c15 = lVar.c(12);
            lVar.b(4);
            int c16 = lVar.c(12);
            i3 -= 6;
            if (c13 == 1 || c13 == 2) {
                int c17 = lVar.c(8);
                c2 = lVar.c(8);
                i2 = c17;
                i3 -= 2;
            } else {
                i2 = 0;
                c2 = 0;
            }
            sparseArray.put(c12, new g(c13, c14, c15, c16, i2, c2));
        }
        return new f(c3, e2, c4, c5, c6, c7, c8, c9, c10, c11, sparseArray);
    }

    private static int[] b() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int c(l lVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int c2;
        int c3;
        boolean z = false;
        int i3 = i;
        while (true) {
            boolean z2 = z;
            int c4 = lVar.c(8);
            if (c4 != 0) {
                z = z2;
                c2 = 1;
                c3 = c4;
            } else if (lVar.e()) {
                c2 = lVar.c(7);
                z = z2;
                c3 = lVar.c(8);
            } else {
                c2 = lVar.c(7);
                if (c2 != 0) {
                    z = z2;
                    c3 = 0;
                } else {
                    c3 = 0;
                    z = true;
                    c2 = 0;
                }
            }
            if (c2 != 0 && paint != null) {
                byte b2 = c3;
                if (bArr != null) {
                    b2 = bArr[c3];
                }
                paint.setColor(iArr[b2]);
                canvas.drawRect(i3, i2, i3 + c2, i2 + 1, paint);
            }
            i3 += c2;
            if (z) {
                return i3;
            }
        }
    }

    private static a c(l lVar, int i) {
        int c2;
        int c3;
        int i2;
        int i3;
        int c4 = lVar.c(8);
        lVar.b(8);
        int i4 = i - 2;
        int[] b2 = b();
        int[] c5 = c();
        int[] d2 = d();
        while (i4 > 0) {
            int c6 = lVar.c(8);
            int c7 = lVar.c(8);
            int i5 = i4 - 2;
            int[] iArr = (c7 & 128) != 0 ? b2 : (c7 & 64) != 0 ? c5 : d2;
            if ((c7 & 1) != 0) {
                i2 = lVar.c(8);
                i3 = lVar.c(8);
                c2 = lVar.c(8);
                c3 = lVar.c(8);
                i4 = i5 - 4;
            } else {
                int c8 = lVar.c(6);
                int c9 = lVar.c(4);
                i4 = i5 - 2;
                c2 = lVar.c(4) << 4;
                c3 = lVar.c(2) << 6;
                i2 = c8 << 2;
                i3 = c9 << 4;
            }
            if (i2 == 0) {
                i3 = 0;
                c2 = 0;
                c3 = 255;
            }
            double d3 = i2;
            double d4 = i3 - 128;
            int i6 = (int) (d3 + (1.402d * d4));
            double d5 = c2 - 128;
            iArr[c6] = a((byte) (255 - (c3 & 255)), u.a(i6, 0, 255), u.a((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 0, 255), u.a((int) (d3 + (d5 * 1.772d)), 0, 255));
        }
        return new a(c4, b2, c5, d2);
    }

    private static int[] c() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return iArr;
            }
            if (i2 < 8) {
                iArr[i2] = a(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                int i3 = 127;
                int i4 = (i2 & 1) != 0 ? 127 : 0;
                int i5 = (i2 & 2) != 0 ? 127 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(255, i4, i5, i3);
            }
            i = i2 + 1;
        }
    }

    private static int[] d() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                return iArr;
            }
            int i3 = 255;
            if (i2 < 8) {
                int i4 = (i2 & 1) != 0 ? 255 : 0;
                int i5 = (i2 & 2) != 0 ? 255 : 0;
                if ((i2 & 4) == 0) {
                    i3 = 0;
                }
                iArr[i2] = a(63, i4, i5, i3);
            } else {
                int i6 = i2 & 136;
                int i7 = 170;
                int i8 = 85;
                if (i6 == 0) {
                    int i9 = (i2 & 1) != 0 ? 85 : 0;
                    int i10 = (i2 & 16) != 0 ? 170 : 0;
                    int i11 = (i2 & 2) != 0 ? 85 : 0;
                    int i12 = (i2 & 32) != 0 ? 170 : 0;
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(255, i9 + i10, i11 + i12, i7 + i8);
                } else if (i6 != 8) {
                    int i13 = 43;
                    if (i6 == 128) {
                        int i14 = (i2 & 1) != 0 ? 43 : 0;
                        int i15 = (i2 & 16) != 0 ? 85 : 0;
                        int i16 = (i2 & 2) != 0 ? 43 : 0;
                        int i17 = (i2 & 32) != 0 ? 85 : 0;
                        if ((i2 & 4) == 0) {
                            i13 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(255, i14 + 127 + i15, i16 + 127 + i17, i8 + i13 + 127);
                    } else if (i6 == 136) {
                        int i18 = (i2 & 1) != 0 ? 43 : 0;
                        int i19 = (i2 & 16) != 0 ? 85 : 0;
                        int i20 = (i2 & 2) != 0 ? 43 : 0;
                        int i21 = (i2 & 32) != 0 ? 85 : 0;
                        if ((i2 & 4) == 0) {
                            i13 = 0;
                        }
                        if ((i2 & 64) == 0) {
                            i8 = 0;
                        }
                        iArr[i2] = a(255, i18 + i19, i20 + i21, i8 + i13);
                    }
                } else {
                    int i22 = (i2 & 1) != 0 ? 85 : 0;
                    int i23 = (i2 & 16) != 0 ? 170 : 0;
                    int i24 = (i2 & 2) != 0 ? 85 : 0;
                    int i25 = (i2 & 32) != 0 ? 170 : 0;
                    if ((i2 & 4) == 0) {
                        i8 = 0;
                    }
                    if ((i2 & 64) == 0) {
                        i7 = 0;
                    }
                    iArr[i2] = a(127, i22 + i23, i24 + i25, i7 + i8);
                }
            }
            i = i2 + 1;
        }
    }

    public List<com.opos.exoplayer.core.f.b> a(byte[] bArr, int i) {
        l lVar = new l(bArr, i);
        while (lVar.a() >= 48 && lVar.c(8) == 15) {
            a(lVar, this.i);
        }
        if (this.i.i == null) {
            return Collections.emptyList();
        }
        C0492b c0492b = this.i.h != null ? this.i.h : this.g;
        if (this.j == null || c0492b.f11663a + 1 != this.j.getWidth() || c0492b.b + 1 != this.j.getHeight()) {
            Bitmap createBitmap = Bitmap.createBitmap(c0492b.f11663a + 1, c0492b.b + 1, Bitmap.Config.ARGB_8888);
            this.j = createBitmap;
            this.f.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.i.i.d;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= sparseArray.size()) {
                return arrayList;
            }
            e valueAt = sparseArray.valueAt(i3);
            f fVar = this.i.f11675c.get(sparseArray.keyAt(i3));
            int i4 = valueAt.f11669a + c0492b.f11664c;
            int i5 = valueAt.b + c0492b.e;
            int min = Math.min(fVar.f11671c + i4, c0492b.d);
            int min2 = Math.min(fVar.d + i5, c0492b.f);
            float f2 = i4;
            float f3 = i5;
            this.f.clipRect(f2, f3, min, min2, Region.Op.REPLACE);
            a aVar = this.i.d.get(fVar.g);
            a aVar2 = aVar;
            if (aVar == null) {
                a aVar3 = this.i.f.get(fVar.g);
                aVar2 = aVar3;
                if (aVar3 == null) {
                    aVar2 = this.h;
                }
            }
            SparseArray<g> sparseArray2 = fVar.k;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i7);
                g valueAt2 = sparseArray2.valueAt(i7);
                c cVar = this.i.e.get(keyAt);
                if (cVar == null) {
                    cVar = this.i.g.get(keyAt);
                }
                if (cVar != null) {
                    a(cVar, aVar2, fVar.f, valueAt2.f11673c + i4, valueAt2.d + i5, cVar.b ? null : this.d, this.f);
                }
                i6 = i7 + 1;
            }
            if (fVar.b) {
                this.e.setColor(fVar.f == 3 ? aVar2.d[fVar.h] : fVar.f == 2 ? aVar2.f11662c[fVar.i] : aVar2.b[fVar.j]);
                this.f.drawRect(f2, f3, fVar.f11671c + i4, fVar.d + i5, this.e);
            }
            arrayList.add(new com.opos.exoplayer.core.f.b(Bitmap.createBitmap(this.j, i4, i5, fVar.f11671c, fVar.d), f2 / c0492b.f11663a, 0, f3 / c0492b.b, 0, fVar.f11671c / c0492b.f11663a, fVar.d / c0492b.b));
            this.f.drawColor(0, PorterDuff.Mode.CLEAR);
            i2 = i3 + 1;
        }
    }

    public void a() {
        this.i.a();
    }
}
