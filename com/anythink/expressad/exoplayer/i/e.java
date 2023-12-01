package com.anythink.expressad.exoplayer.i;

import android.util.Pair;
import com.anythink.expressad.exoplayer.aa;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/e.class */
public abstract class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private a f4702a;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f4703a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4704c = 2;
        public static final int d = 3;
        @Deprecated
        public final int e;
        private final int f;
        private final int[] g;
        private final af[] h;
        private final int[] i;
        private final int[][][] j;
        private final af k;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.anythink.expressad.exoplayer.i.e$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/e$a$a.class */
        @interface InterfaceC0066a {
        }

        a(int[] iArr, af[] afVarArr, int[] iArr2, int[][][] iArr3, af afVar) {
            this.g = iArr;
            this.h = afVarArr;
            this.j = iArr3;
            this.i = iArr2;
            this.k = afVar;
            int length = iArr.length;
            this.f = length;
            this.e = length;
        }

        private int a(int i, int i2, int[] iArr) {
            int i3 = 0;
            String str = null;
            boolean z = false;
            int i4 = 0;
            int i5 = 16;
            while (i3 < iArr.length) {
                String str2 = this.h[i].a(i2).a(iArr[i3]).h;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !com.anythink.expressad.exoplayer.k.af.a((Object) str, (Object) str2);
                }
                i5 = Math.min(i5, this.j[i][i2][i3] & 24);
                i3++;
                i4++;
            }
            return z ? Math.min(i5, this.i[i]) : i5;
        }

        @Deprecated
        private int b(int i, int i2, int i3) {
            return a(i, i2, i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
            r5 = r5 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int c(int r5) {
            /*
                r4 = this;
                r0 = r4
                int[][][] r0 = r0.j
                r1 = r5
                r0 = r0[r1]
                r9 = r0
                r0 = 0
                r5 = r0
                r0 = 0
                r6 = r0
            Lc:
                r0 = r5
                r1 = r9
                int r1 = r1.length
                if (r0 >= r1) goto L55
                r0 = 0
                r7 = r0
            L15:
                r0 = r7
                r1 = r9
                r2 = r5
                r1 = r1[r2]
                int r1 = r1.length
                if (r0 >= r1) goto L4e
                r0 = r9
                r1 = r5
                r0 = r0[r1]
                r1 = r7
                r0 = r0[r1]
                r1 = 7
                r0 = r0 & r1
                r8 = r0
                r0 = r8
                r1 = 3
                if (r0 == r1) goto L3d
                r0 = r8
                r1 = 4
                if (r0 == r1) goto L3b
                r0 = 1
                r8 = r0
                goto L40
            L3b:
                r0 = 3
                return r0
            L3d:
                r0 = 2
                r8 = r0
            L40:
                r0 = r6
                r1 = r8
                int r0 = java.lang.Math.max(r0, r1)
                r6 = r0
                r0 = r7
                r1 = 1
                int r0 = r0 + r1
                r7 = r0
                goto L15
            L4e:
                r0 = r5
                r1 = 1
                int r0 = r0 + r1
                r5 = r0
                goto Lc
            L55:
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.i.e.a.c(int):int");
        }

        @Deprecated
        private af c() {
            return this.k;
        }

        @Deprecated
        private int d(int i) {
            int i2;
            int i3;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i4 >= this.f) {
                    return i6;
                }
                int i7 = i6;
                if (this.g[i4] == i) {
                    int[][] iArr = this.j[i4];
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        i2 = i9;
                        if (i8 >= iArr.length) {
                            break;
                        }
                        int i10 = 0;
                        while (true) {
                            int i11 = i10;
                            if (i11 < iArr[i8].length) {
                                int i12 = iArr[i8][i11] & 7;
                                if (i12 == 3) {
                                    i3 = 2;
                                } else if (i12 == 4) {
                                    i2 = 3;
                                    break;
                                } else {
                                    i3 = 1;
                                }
                                i9 = Math.max(i9, i3);
                                i10 = i11 + 1;
                            }
                        }
                        i8++;
                    }
                    i7 = Math.max(i6, i2);
                }
                i4++;
                i5 = i7;
            }
        }

        private int e(int i) {
            int i2;
            int i3;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i4 >= this.f) {
                    return i6;
                }
                int i7 = i6;
                if (this.g[i4] == i) {
                    int[][] iArr = this.j[i4];
                    int i8 = 0;
                    int i9 = 0;
                    while (true) {
                        i2 = i9;
                        if (i8 >= iArr.length) {
                            break;
                        }
                        int i10 = 0;
                        while (true) {
                            int i11 = i10;
                            if (i11 < iArr[i8].length) {
                                int i12 = iArr[i8][i11] & 7;
                                if (i12 == 3) {
                                    i3 = 2;
                                } else if (i12 == 4) {
                                    i2 = 3;
                                    break;
                                } else {
                                    i3 = 1;
                                }
                                i9 = Math.max(i9, i3);
                                i10 = i11 + 1;
                            }
                        }
                        i8++;
                    }
                    i7 = Math.max(i6, i2);
                }
                i4++;
                i5 = i7;
            }
        }

        public final int a() {
            return this.f;
        }

        public final int a(int i) {
            return this.g[i];
        }

        public final int a(int i, int i2) {
            int i3;
            int i4 = this.h[i].a(i2).f4578a;
            int[] iArr = new int[i4];
            int i5 = 0;
            int i6 = 0;
            while (true) {
                i3 = i6;
                if (i5 >= i4) {
                    break;
                }
                int i7 = i3;
                if (a(i, i2, i5) == 4) {
                    iArr[i3] = i5;
                    i7 = i3 + 1;
                }
                i5++;
                i6 = i7;
            }
            int[] copyOf = Arrays.copyOf(iArr, i3);
            int i8 = 16;
            String str = null;
            boolean z = false;
            int i9 = 0;
            int i10 = 0;
            while (i10 < copyOf.length) {
                String str2 = this.h[i].a(i2).a(copyOf[i10]).h;
                if (i9 == 0) {
                    str = str2;
                } else {
                    z |= !com.anythink.expressad.exoplayer.k.af.a((Object) str, (Object) str2);
                }
                i8 = Math.min(i8, this.j[i][i2][i10] & 24);
                i10++;
                i9++;
            }
            return z ? Math.min(i8, this.i[i]) : i8;
        }

        public final int a(int i, int i2, int i3) {
            return this.j[i][i2][i3] & 7;
        }

        public final af b() {
            return this.k;
        }

        public final af b(int i) {
            return this.h[i];
        }
    }

    private static int a(z[] zVarArr, ae aeVar) {
        int length = zVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < zVarArr.length; i2++) {
            z zVar = zVarArr[i2];
            int i3 = 0;
            while (i3 < aeVar.f4578a) {
                int a2 = zVar.a(aeVar.a(i3)) & 7;
                int i4 = i;
                if (a2 > i) {
                    if (a2 == 4) {
                        return i2;
                    }
                    length = i2;
                    i4 = a2;
                }
                i3++;
                i = i4;
            }
        }
        return length;
    }

    private static int[] a(z zVar, ae aeVar) {
        int[] iArr = new int[aeVar.f4578a];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aeVar.f4578a) {
                return iArr;
            }
            iArr[i2] = zVar.a(aeVar.a(i2));
            i = i2 + 1;
        }
    }

    private static int[] a(z[] zVarArr) {
        int length = zVarArr.length;
        int[] iArr = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return iArr;
            }
            iArr[i2] = zVarArr[i2].m();
            i = i2 + 1;
        }
    }

    protected abstract Pair<aa[], f[]> a(a aVar, int[][][] iArr, int[] iArr2);

    public final a a() {
        return this.f4702a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int[][], int[][][]] */
    @Override // com.anythink.expressad.exoplayer.i.h
    public final i a(z[] zVarArr, af afVar) {
        int i;
        int[] iArr;
        int[] iArr2 = new int[zVarArr.length + 1];
        int length = zVarArr.length + 1;
        ae[] aeVarArr = new ae[length];
        ?? r0 = new int[zVarArr.length + 1];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            aeVarArr[i3] = new ae[afVar.b];
            r0[i3] = new int[afVar.b];
            i2 = i3 + 1;
        }
        int length2 = zVarArr.length;
        int[] iArr3 = new int[length2];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length2) {
                break;
            }
            iArr3[i5] = zVarArr[i5].m();
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= afVar.b) {
                break;
            }
            ae a2 = afVar.a(i7);
            int length3 = zVarArr.length;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                i = length3;
                if (i8 >= zVarArr.length) {
                    break;
                }
                z zVar = zVarArr[i8];
                int i10 = 0;
                while (i10 < a2.f4578a) {
                    int a3 = zVar.a(a2.a(i10)) & 7;
                    int i11 = i9;
                    if (a3 > i9) {
                        if (a3 == 4) {
                            i = i8;
                            break;
                        }
                        length3 = i8;
                        i11 = a3;
                    }
                    i10++;
                    i9 = i11;
                }
                i8++;
            }
            if (i == zVarArr.length) {
                iArr = new int[a2.f4578a];
            } else {
                z zVar2 = zVarArr[i];
                iArr = new int[a2.f4578a];
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 < a2.f4578a) {
                        iArr[i13] = zVar2.a(a2.a(i13));
                        i12 = i13 + 1;
                    }
                }
            }
            int i14 = iArr2[i];
            aeVarArr[i][i14] = a2;
            r0[i][i14] = iArr;
            iArr2[i] = iArr2[i] + 1;
            i6 = i7 + 1;
        }
        af[] afVarArr = new af[zVarArr.length];
        int[] iArr4 = new int[zVarArr.length];
        int i15 = 0;
        while (true) {
            int i16 = i15;
            if (i16 >= zVarArr.length) {
                a aVar = new a(iArr4, afVarArr, iArr3, r0, new af((ae[]) com.anythink.expressad.exoplayer.k.af.a(aeVarArr[zVarArr.length], iArr2[zVarArr.length])));
                Pair<aa[], f[]> a4 = a(aVar, r0, iArr3);
                return new i(a4.first, a4.second, aVar);
            }
            int i17 = iArr2[i16];
            afVarArr[i16] = new af((ae[]) com.anythink.expressad.exoplayer.k.af.a(aeVarArr[i16], i17));
            r0[i16] = (int[][]) com.anythink.expressad.exoplayer.k.af.a(r0[i16], i17);
            iArr4[i16] = zVarArr[i16].a();
            i15 = i16 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.i.h
    public final void a(Object obj) {
        this.f4702a = (a) obj;
    }
}
