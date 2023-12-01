package com.anythink.expressad.exoplayer.h;

import java.util.Arrays;
import java.util.Random;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/aa.class */
public interface aa {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/aa$a.class */
    public static final class a implements aa {

        /* renamed from: a  reason: collision with root package name */
        private final Random f4563a;
        private final int[] b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f4564c;

        public a() {
            this(0, new Random());
        }

        private a(int i, long j) {
            this(i, new Random(j));
        }

        private a(int i, Random random) {
            this(a(i, random), random);
        }

        private a(int[] iArr, Random random) {
            this.b = iArr;
            this.f4563a = random;
            this.f4564c = new int[iArr.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iArr.length) {
                    return;
                }
                this.f4564c[iArr[i2]] = i2;
                i = i2 + 1;
            }
        }

        private static int[] a(int i, Random random) {
            int[] iArr = new int[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return iArr;
                }
                int i4 = i3 + 1;
                int nextInt = random.nextInt(i4);
                iArr[i3] = iArr[nextInt];
                iArr[nextInt] = i3;
                i2 = i4;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a() {
            return this.b.length;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a(int i) {
            int i2 = this.f4564c[i] + 1;
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa a(int i, int i2) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= i2) {
                    break;
                }
                iArr[i4] = this.f4563a.nextInt(this.b.length + 1);
                int i5 = i4 + 1;
                int nextInt = this.f4563a.nextInt(i5);
                iArr2[i4] = iArr2[nextInt];
                iArr2[nextInt] = i4 + i;
                i3 = i5;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.b.length + i2];
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= this.b.length + i2) {
                    return new a(iArr3, new Random(this.f4563a.nextLong()));
                }
                if (i6 >= i2 || i7 != iArr[i6]) {
                    iArr3[i9] = this.b[i7];
                    if (iArr3[i9] >= i) {
                        iArr3[i9] = iArr3[i9] + i2;
                    }
                    i7++;
                } else {
                    iArr3[i9] = iArr2[i6];
                    i6++;
                }
                i8 = i9 + 1;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b(int i) {
            int i2 = this.f4564c[i] - 1;
            if (i2 >= 0) {
                return this.b[i2];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int c() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa c(int i) {
            int[] iArr = new int[this.b.length - 1];
            int i2 = 0;
            boolean z = false;
            while (true) {
                int[] iArr2 = this.b;
                if (i2 >= iArr2.length) {
                    return new a(iArr, new Random(this.f4563a.nextLong()));
                }
                if (iArr2[i2] == i) {
                    z = true;
                } else {
                    int i3 = z ? i2 - 1 : i2;
                    int[] iArr3 = this.b;
                    iArr[i3] = iArr3[i2] > i ? iArr3[i2] - 1 : iArr3[i2];
                }
                i2++;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa d() {
            return new a(0, new Random(this.f4563a.nextLong()));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/aa$b.class */
    public static final class b implements aa {

        /* renamed from: a  reason: collision with root package name */
        private final int f4565a;

        public b(int i) {
            this.f4565a = i;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a() {
            return this.f4565a;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a(int i) {
            int i2 = i + 1;
            if (i2 < this.f4565a) {
                return i2;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa a(int i, int i2) {
            return new b(this.f4565a + i2);
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b() {
            int i = this.f4565a;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                return i2;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int c() {
            return this.f4565a > 0 ? 0 : -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa c(int i) {
            return new b(this.f4565a - 1);
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final aa d() {
            return new b(0);
        }
    }

    int a();

    int a(int i);

    aa a(int i, int i2);

    int b();

    int b(int i);

    int c();

    aa c(int i);

    aa d();
}
