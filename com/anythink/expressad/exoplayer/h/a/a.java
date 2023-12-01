package com.anythink.expressad.exoplayer.h.a;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7381a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7382c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final a f = new a(new long[0]);
    public final int g;
    public final long[] h;
    public final C0130a[] i;
    public final long j;
    public final long k;

    /* renamed from: com.anythink.expressad.exoplayer.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/a$a.class */
    public static final class C0130a {

        /* renamed from: a  reason: collision with root package name */
        public final int f7383a;
        public final Uri[] b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f7384c;
        public final long[] d;

        public C0130a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private C0130a(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.anythink.expressad.exoplayer.k.a.a(iArr.length == uriArr.length);
            this.f7383a = i;
            this.f7384c = iArr;
            this.b = uriArr;
            this.d = jArr;
        }

        private static int[] a(int[] iArr, int i) {
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        private static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, (long) com.anythink.expressad.exoplayer.b.b);
            return copyOf;
        }

        private int c() {
            return a(-1);
        }

        public final int a(int i) {
            while (true) {
                i++;
                int[] iArr = this.f7384c;
                if (i >= iArr.length || iArr[i] == 0 || iArr[i] == 1) {
                    break;
                }
            }
            return i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
            if (r0[r9] == r8) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.anythink.expressad.exoplayer.h.a.a.C0130a a(int r8, int r9) {
            /*
                r7 = this;
                r0 = r7
                int r0 = r0.f7383a
                r10 = r0
                r0 = 0
                r12 = r0
                r0 = r10
                r1 = -1
                if (r0 == r1) goto L1b
                r0 = r9
                r1 = r10
                if (r0 >= r1) goto L15
                goto L1b
            L15:
                r0 = 0
                r11 = r0
                goto L1e
            L1b:
                r0 = 1
                r11 = r0
            L1e:
                r0 = r11
                com.anythink.expressad.exoplayer.k.a.a(r0)
                r0 = r7
                int[] r0 = r0.f7384c
                r1 = r9
                r2 = 1
                int r1 = r1 + r2
                int[] r0 = a(r0, r1)
                r15 = r0
                r0 = r15
                r1 = r9
                r0 = r0[r1]
                if (r0 == 0) goto L4a
                r0 = r15
                r1 = r9
                r0 = r0[r1]
                r1 = 1
                if (r0 == r1) goto L4a
                r0 = r12
                r11 = r0
                r0 = r15
                r1 = r9
                r0 = r0[r1]
                r1 = r8
                if (r0 != r1) goto L4d
            L4a:
                r0 = 1
                r11 = r0
            L4d:
                r0 = r11
                com.anythink.expressad.exoplayer.k.a.a(r0)
                r0 = r7
                long[] r0 = r0.d
                r13 = r0
                r0 = r13
                int r0 = r0.length
                r1 = r15
                int r1 = r1.length
                if (r0 != r1) goto L64
                goto L6e
            L64:
                r0 = r13
                r1 = r15
                int r1 = r1.length
                long[] r0 = a(r0, r1)
                r13 = r0
            L6e:
                r0 = r7
                android.net.Uri[] r0 = r0.b
                r14 = r0
                r0 = r14
                int r0 = r0.length
                r1 = r15
                int r1 = r1.length
                if (r0 != r1) goto L80
                goto L8d
            L80:
                r0 = r14
                r1 = r15
                int r1 = r1.length
                java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
                android.net.Uri[] r0 = (android.net.Uri[]) r0
                r14 = r0
            L8d:
                r0 = r15
                r1 = r9
                r2 = r8
                r0[r1] = r2
                com.anythink.expressad.exoplayer.h.a.a$a r0 = new com.anythink.expressad.exoplayer.h.a.a$a
                r1 = r0
                r2 = r7
                int r2 = r2.f7383a
                r3 = r15
                r4 = r14
                r5 = r13
                r1.<init>(r2, r3, r4, r5)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.h.a.a.C0130a.a(int, int):com.anythink.expressad.exoplayer.h.a.a$a");
        }

        public final C0130a a(Uri uri, int i) {
            int i2 = this.f7383a;
            com.anythink.expressad.exoplayer.k.a.a(i2 == -1 || i < i2);
            int[] a2 = a(this.f7384c, i + 1);
            boolean z = false;
            if (a2[i] == 0) {
                z = true;
            }
            com.anythink.expressad.exoplayer.k.a.a(z);
            long[] jArr = this.d;
            if (jArr.length != a2.length) {
                jArr = a(jArr, a2.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.b, a2.length);
            uriArr[i] = uri;
            a2[i] = 1;
            return new C0130a(this.f7383a, a2, uriArr, jArr);
        }

        public final C0130a a(long[] jArr) {
            com.anythink.expressad.exoplayer.k.a.a(this.f7383a == -1 || jArr.length <= this.b.length);
            int length = jArr.length;
            Uri[] uriArr = this.b;
            long[] jArr2 = jArr;
            if (length < uriArr.length) {
                jArr2 = a(jArr, uriArr.length);
            }
            return new C0130a(this.f7383a, this.f7384c, this.b, jArr2);
        }

        public final boolean a() {
            return this.f7383a == -1 || a(-1) < this.f7383a;
        }

        public final C0130a b() {
            if (this.f7383a == -1) {
                return new C0130a(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.f7384c;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                if (copyOf[i] == 1 || copyOf[i] == 0) {
                    copyOf[i] = 2;
                }
            }
            return new C0130a(length, copyOf, this.b, this.d);
        }

        public final C0130a b(int i) {
            com.anythink.expressad.exoplayer.k.a.a(this.f7383a == -1 && this.f7384c.length <= i);
            return new C0130a(i, a(this.f7384c, i), (Uri[]) Arrays.copyOf(this.b, i), a(this.d, i));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/a/a$b.class */
    public @interface b {
    }

    private a(long... jArr) {
        this.g = 0;
        this.h = Arrays.copyOf(jArr, 0);
        this.i = new C0130a[0];
        this.j = 0L;
        this.k = com.anythink.expressad.exoplayer.b.b;
    }

    private a(long[] jArr, C0130a[] c0130aArr, long j, long j2) {
        this.g = c0130aArr.length;
        this.h = jArr;
        this.i = c0130aArr;
        this.j = j;
        this.k = j2;
    }

    private int a(long j) {
        int i;
        int length = this.h.length;
        while (true) {
            i = length - 1;
            if (i < 0) {
                break;
            }
            long[] jArr = this.h;
            if (jArr[i] != Long.MIN_VALUE && jArr[i] <= j) {
                break;
            }
            length = i;
        }
        if (i < 0 || !this.i[i].a()) {
            return -1;
        }
        return i;
    }

    private a a(int i) {
        C0130a[] c0130aArr = this.i;
        C0130a[] c0130aArr2 = (C0130a[]) Arrays.copyOf(c0130aArr, c0130aArr.length);
        c0130aArr2[i] = c0130aArr2[i].b();
        return new a(this.h, c0130aArr2, this.j, this.k);
    }

    private a a(int i, int i2) {
        com.anythink.expressad.exoplayer.k.a.a(i2 > 0);
        if (this.i[i].f7383a == i2) {
            return this;
        }
        C0130a[] c0130aArr = this.i;
        C0130a[] c0130aArr2 = (C0130a[]) Arrays.copyOf(c0130aArr, c0130aArr.length);
        c0130aArr2[i] = this.i[i].b(i2);
        return new a(this.h, c0130aArr2, this.j, this.k);
    }

    private a a(int i, int i2, Uri uri) {
        C0130a[] c0130aArr = this.i;
        C0130a[] c0130aArr2 = (C0130a[]) Arrays.copyOf(c0130aArr, c0130aArr.length);
        c0130aArr2[i] = c0130aArr2[i].a(uri, i2);
        return new a(this.h, c0130aArr2, this.j, this.k);
    }

    private int b(long j) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            long[] jArr = this.h;
            if (i >= jArr.length || jArr[i] == Long.MIN_VALUE || (j < jArr[i] && this.i[i].a())) {
                break;
            }
            i2 = i + 1;
        }
        if (i < this.h.length) {
            return i;
        }
        return -1;
    }

    private a b(int i, int i2) {
        C0130a[] c0130aArr = this.i;
        C0130a[] c0130aArr2 = (C0130a[]) Arrays.copyOf(c0130aArr, c0130aArr.length);
        c0130aArr2[i] = c0130aArr2[i].a(3, i2);
        return new a(this.h, c0130aArr2, this.j, this.k);
    }

    private a c(int i, int i2) {
        C0130a[] c0130aArr = this.i;
        C0130a[] c0130aArr2 = (C0130a[]) Arrays.copyOf(c0130aArr, c0130aArr.length);
        c0130aArr2[i] = c0130aArr2[i].a(2, i2);
        return new a(this.h, c0130aArr2, this.j, this.k);
    }

    private a c(long j) {
        return this.j == j ? this : new a(this.h, this.i, j, this.k);
    }

    private a d(int i, int i2) {
        C0130a[] c0130aArr = this.i;
        C0130a[] c0130aArr2 = (C0130a[]) Arrays.copyOf(c0130aArr, c0130aArr.length);
        c0130aArr2[i] = c0130aArr2[i].a(4, i2);
        return new a(this.h, c0130aArr2, this.j, this.k);
    }

    private a d(long j) {
        return this.k == j ? this : new a(this.h, this.i, this.j, j);
    }

    public final a a(long[][] jArr) {
        C0130a[] c0130aArr = this.i;
        C0130a[] c0130aArr2 = (C0130a[]) Arrays.copyOf(c0130aArr, c0130aArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g) {
                return new a(this.h, c0130aArr2, this.j, this.k);
            }
            c0130aArr2[i2] = c0130aArr2[i2].a(jArr[i2]);
            i = i2 + 1;
        }
    }
}
