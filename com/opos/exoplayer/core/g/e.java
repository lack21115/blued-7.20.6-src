package com.opos.exoplayer.core.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.opos.exoplayer.core.e.l;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.g.f;
import com.opos.exoplayer.core.t;
import com.opos.exoplayer.core.u;
import java.util.Arrays;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/e.class */
public abstract class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Map<m, b>> f25429a = new SparseArray<>();
    private final SparseBooleanArray b = new SparseBooleanArray();

    /* renamed from: c  reason: collision with root package name */
    private int f25430c = 0;
    private a d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f25431a;
        private final int[] b;

        /* renamed from: c  reason: collision with root package name */
        private final m[] f25432c;
        private final int[] d;
        private final int[][][] e;
        private final m f;

        a(int[] iArr, m[] mVarArr, int[] iArr2, int[][][] iArr3, m mVar) {
            this.b = iArr;
            this.f25432c = mVarArr;
            this.e = iArr3;
            this.d = iArr2;
            this.f = mVar;
            this.f25431a = mVarArr.length;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/e$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final f.a f25433a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f25434c;

        public f a(m mVar) {
            return this.f25433a.b(mVar.a(this.b), this.f25434c);
        }
    }

    private static int a(t[] tVarArr, l lVar) {
        int length = tVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < tVarArr.length; i2++) {
            t tVar = tVarArr[i2];
            int i3 = 0;
            while (i3 < lVar.f25309a) {
                int a2 = tVar.a(lVar.a(i3)) & 7;
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
        r10 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.opos.exoplayer.core.t[] r4, com.opos.exoplayer.core.e.m[] r5, int[][][] r6, com.opos.exoplayer.core.u[] r7, com.opos.exoplayer.core.g.f[] r8, int r9) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.g.e.a(com.opos.exoplayer.core.t[], com.opos.exoplayer.core.e.m[], int[][][], com.opos.exoplayer.core.u[], com.opos.exoplayer.core.g.f[], int):void");
    }

    private static boolean a(int[][] iArr, m mVar, f fVar) {
        boolean z;
        if (fVar == null) {
            return false;
        }
        int a2 = mVar.a(fVar.d());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fVar.e()) {
                z = true;
                break;
            }
            z = false;
            if ((iArr[a2][fVar.b(i2)] & 32) != 32) {
                break;
            }
            i = i2 + 1;
        }
        return z;
    }

    private static int[] a(t tVar, l lVar) {
        int[] iArr = new int[lVar.f25309a];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= lVar.f25309a) {
                return iArr;
            }
            iArr[i2] = tVar.a(lVar.a(i2));
            i = i2 + 1;
        }
    }

    private static int[] a(t[] tVarArr) {
        int length = tVarArr.length;
        int[] iArr = new int[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return iArr;
            }
            iArr[i2] = tVarArr[i2].m();
            i = i2 + 1;
        }
    }

    private boolean[] a(t[] tVarArr, f[] fVarArr) {
        int length = fVarArr.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return zArr;
            }
            zArr[i2] = !this.b.get(i2) && (tVarArr[i2].a() == 5 || fVarArr[i2] != null);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int[][], int[][][]] */
    @Override // com.opos.exoplayer.core.g.h
    public final i a(t[] tVarArr, m mVar) {
        int[] iArr = new int[tVarArr.length + 1];
        int length = tVarArr.length + 1;
        l[] lVarArr = new l[length];
        ?? r0 = new int[tVarArr.length + 1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            lVarArr[i2] = new l[mVar.b];
            r0[i2] = new int[mVar.b];
            i = i2 + 1;
        }
        int[] a2 = a(tVarArr);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= mVar.b) {
                break;
            }
            l a3 = mVar.a(i4);
            int a4 = a(tVarArr, a3);
            int[] a5 = a4 == tVarArr.length ? new int[a3.f25309a] : a(tVarArr[a4], a3);
            int i5 = iArr[a4];
            lVarArr[a4][i5] = a3;
            r0[a4][i5] = a5;
            iArr[a4] = iArr[a4] + 1;
            i3 = i4 + 1;
        }
        m[] mVarArr = new m[tVarArr.length];
        int[] iArr2 = new int[tVarArr.length];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= tVarArr.length) {
                break;
            }
            int i8 = iArr[i7];
            mVarArr[i7] = new m((l[]) Arrays.copyOf(lVarArr[i7], i8));
            r0[i7] = (int[][]) Arrays.copyOf(r0[i7], i8);
            iArr2[i7] = tVarArr[i7].a();
            i6 = i7 + 1;
        }
        m mVar2 = new m((l[]) Arrays.copyOf(lVarArr[tVarArr.length], iArr[tVarArr.length]));
        f[] a6 = a(tVarArr, mVarArr, (int[][][]) r0);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            f fVar = null;
            if (i10 >= tVarArr.length) {
                break;
            }
            if (this.b.get(i10)) {
                a6[i10] = null;
            } else {
                m mVar3 = mVarArr[i10];
                if (a(i10, mVar3)) {
                    b bVar = this.f25429a.get(i10).get(mVar3);
                    if (bVar != null) {
                        fVar = bVar.a(mVar3);
                    }
                    a6[i10] = fVar;
                }
            }
            i9 = i10 + 1;
        }
        boolean[] a7 = a(tVarArr, a6);
        a aVar = new a(iArr2, mVarArr, a2, r0, mVar2);
        u[] uVarArr = new u[tVarArr.length];
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= tVarArr.length) {
                a(tVarArr, mVarArr, r0, uVarArr, a6, this.f25430c);
                return new i(mVar, a7, new g(a6), aVar, uVarArr);
            }
            uVarArr[i12] = a7[i12] ? u.f25558a : null;
            i11 = i12 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.g.h
    public final void a(Object obj) {
        this.d = (a) obj;
    }

    public final boolean a(int i, m mVar) {
        Map<m, b> map = this.f25429a.get(i);
        return map != null && map.containsKey(mVar);
    }

    protected abstract f[] a(t[] tVarArr, m[] mVarArr, int[][][] iArr);
}
