package com.tencent.mapsdk.internal;

import android.graphics.Color;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t5.class */
public class t5 {
    public static final int E = 0;
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 3;
    public static final int I = 9;
    public static final int J = -1;
    public static final float K = 200.0f;
    public static final float L = 60.0f;
    public static final String M = "color_texture_flat_style.png";
    public static final String N = "color_point_texture.png";
    public static final String O = "color_texture_line_v2.png";
    public boolean D;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<GeoPoint> f38015a;
    public ArrayList<GeoPoint> b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f38016c;
    public int[] d;
    public String[] e;
    public int[] f;
    public int[] g;
    public int[] h;
    public int[] i;
    public float j;
    public boolean k;
    public boolean l;
    public float m = 9.0f;
    public String n = "";
    public boolean o = true;
    public float p = 1.0f;
    public boolean q = true;
    public int r = 0;
    public boolean s = false;
    public boolean t = false;
    public Rect u = new Rect();
    public int v = 0;
    public String w = "";
    public float x = -1.0f;
    public int y = -1;
    public int z = -15248742;
    public List<Integer> A = null;
    private int B = 2;
    private int C = Color.GRAY;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t5$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f38017a = 0;
        public static final int b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f38018c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
        public static final int i = 8;
        public static final int j = 9;
        public static final int k = 33;
        public static final int l = 19;
        public static final int m = 20;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/t5$b.class */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f38019a;
        public int b;

        public b(int i, int i2) {
            this.b = i;
            this.f38019a = i2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            boolean z = false;
            if (bVar.f38019a == this.f38019a) {
                z = false;
                if (bVar.b == this.b) {
                    z = true;
                }
            }
            return z;
        }
    }

    public t5 a(float f) {
        this.p = f;
        return this;
    }

    public t5 a(int i) {
        this.C = i;
        return this;
    }

    public t5 a(int i, int i2) {
        this.y = i;
        this.z = i2;
        return this;
    }

    public t5 a(String str) {
        this.w = str;
        return this;
    }

    public t5 a(List<Integer> list) {
        if (list != null && list.size() % 2 != 0) {
            list.add(list.get(list.size() - 1));
        }
        this.A = list;
        return this;
    }

    public t5 a(boolean z) {
        this.s = z;
        return this;
    }

    public t5 a(int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            na.h("参数endNums不能为空!");
            return this;
        }
        this.d = iArr;
        return this;
    }

    public t5 a(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length < 1 || iArr2 == null || iArr2.length < 1) {
            na.h("参数colors 、borderColors为空，或者两者长度不同");
            return this;
        } else if (!this.k) {
            this.g = iArr;
            return this;
        } else {
            int[] iArr3 = iArr2;
            if (iArr2.length < iArr.length) {
                iArr3 = new int[iArr.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    if (i2 < iArr2.length) {
                        iArr3[i2] = iArr2[i2];
                    } else {
                        iArr3[i2] = iArr2[iArr2.length - 1];
                    }
                    i = i2 + 1;
                }
            }
            ArrayList arrayList = new ArrayList();
            int i3 = this.C;
            arrayList.add(new b(i3, i3));
            this.g = new int[iArr.length];
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= iArr.length) {
                    break;
                }
                b bVar = new b(iArr[i5], iArr3[i5]);
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
                this.g[i5] = arrayList.indexOf(bVar);
                i4 = i5 + 1;
            }
            int size = arrayList.size();
            this.h = new int[size];
            this.i = new int[size];
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= size) {
                    return this;
                }
                this.h[i7] = ((b) arrayList.get(i7)).b;
                this.i[i7] = ((b) arrayList.get(i7)).f38019a;
                i6 = i7 + 1;
            }
        }
    }

    public t5 a(String[] strArr) {
        if (strArr == null || strArr.length < 1) {
            na.h("参数roadNames不能为空!");
            return this;
        }
        this.e = strArr;
        return this;
    }

    public boolean a() {
        ArrayList<GeoPoint> arrayList = this.b;
        if (arrayList == null || arrayList.size() < 2) {
            na.h("LineOptions中点的个数不能小于2");
            return false;
        }
        int[] iArr = this.f;
        if (iArr == null || iArr.length < 1) {
            na.h("参数startIndexes不能为空!");
            return false;
        }
        int[] iArr2 = this.g;
        if (iArr2 == null || iArr2.length < 1) {
            na.h("参数colors不能为空!");
            return false;
        }
        return true;
    }

    public int b() {
        return this.r;
    }

    public t5 b(float f) {
        this.j = f;
        return this;
    }

    public t5 b(List<GeoPoint> list) {
        if (list == null || list.size() < 2) {
            na.h("参数points不能小于2!");
            return this;
        }
        ArrayList<GeoPoint> arrayList = new ArrayList<>(list.size());
        this.b = arrayList;
        arrayList.addAll(list);
        if (this.b.size() < 2) {
            na.h("参数points存在null值");
            return this;
        }
        ArrayList<GeoPoint> arrayList2 = new ArrayList<>(list.size());
        this.f38015a = arrayList2;
        arrayList2.addAll(this.b);
        return this;
    }

    public t5 b(boolean z) {
        this.l = z;
        return this;
    }

    public t5 b(int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            na.h("参数startNums不能为空!");
            return this;
        }
        this.f38016c = iArr;
        return this;
    }

    public void b(int i) {
        this.B = i;
    }

    @Deprecated
    public void b(String str) {
        this.n = str;
    }

    public int c() {
        return this.B;
    }

    public t5 c(int i) {
        this.r = i;
        return this;
    }

    public t5 c(String str) {
        this.n = str;
        return this;
    }

    public t5 c(boolean z) {
        this.k = z;
        return this;
    }

    public t5 c(int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            na.h("参数startIndexes不能为空!");
            return this;
        }
        this.f = iArr;
        return this;
    }

    @Deprecated
    public void c(float f) {
        this.p = f;
    }

    public float d() {
        return this.x;
    }

    public t5 d(float f) {
        this.x = f;
        return this;
    }

    public t5 d(int i) {
        this.v = i;
        return this;
    }

    public t5 d(boolean z) {
        this.q = z;
        return this;
    }

    public t5 d(int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            na.h("参数colors不能为空!");
            return this;
        } else if (!this.k) {
            this.g = iArr;
            return this;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(this.C));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iArr.length) {
                    break;
                }
                if (!arrayList.contains(Integer.valueOf(iArr[i2]))) {
                    arrayList.add(Integer.valueOf(iArr[i2]));
                }
                iArr[i2] = arrayList.indexOf(Integer.valueOf(iArr[i2]));
                i = i2 + 1;
            }
            this.g = iArr;
            int size = arrayList.size();
            this.h = new int[size];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    return this;
                }
                this.h[i4] = ((Integer) arrayList.get(i4)).intValue();
                i3 = i4 + 1;
            }
        }
    }

    public t5 e(float f) {
        this.m = f;
        return this;
    }

    @Deprecated
    public void e(boolean z) {
        this.o = z;
    }

    public int[] e() {
        return new int[]{this.y, this.z};
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        t5 t5Var = (t5) obj;
        return Float.compare(t5Var.j, this.j) == 0 && this.k == t5Var.k && this.l == t5Var.l && Float.compare(t5Var.m, this.m) == 0 && this.o == t5Var.o && Float.compare(t5Var.p, this.p) == 0 && this.q == t5Var.q && this.r == t5Var.r && this.s == t5Var.s && this.t == t5Var.t && this.v == t5Var.v && Float.compare(t5Var.x, this.x) == 0 && this.y == t5Var.y && this.z == t5Var.z && this.B == t5Var.B && this.C == t5Var.C && this.D == t5Var.D && Util.equals(this.f38015a, t5Var.f38015a) && Util.equals(this.b, t5Var.b) && Arrays.equals(this.f38016c, t5Var.f38016c) && Arrays.equals(this.d, t5Var.d) && Arrays.equals(this.e, t5Var.e) && Arrays.equals(this.f, t5Var.f) && Arrays.equals(this.g, t5Var.g) && Arrays.equals(this.h, t5Var.h) && Arrays.equals(this.i, t5Var.i) && Util.equals(this.n, t5Var.n) && Util.equals(this.u, t5Var.u) && Util.equals(this.w, t5Var.w) && Util.equals(this.A, t5Var.A);
    }

    public t5 f(boolean z) {
        this.t = z;
        return this;
    }

    public int hashCode() {
        return (((((((((((((Util.hash(this.f38015a, this.b, Float.valueOf(this.j), Boolean.valueOf(this.k), Boolean.valueOf(this.l), Float.valueOf(this.m), this.n, Boolean.valueOf(this.o), Float.valueOf(this.p), Boolean.valueOf(this.q), Integer.valueOf(this.r), Boolean.valueOf(this.s), Boolean.valueOf(this.t), this.u, Integer.valueOf(this.v), this.w, Float.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.z), this.A, Integer.valueOf(this.B), Integer.valueOf(this.C), Boolean.valueOf(this.D)) * 31) + Arrays.hashCode(this.f38016c)) * 31) + Arrays.hashCode(this.d)) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f)) * 31) + Arrays.hashCode(this.g)) * 31) + Arrays.hashCode(this.h)) * 31) + Arrays.hashCode(this.i);
    }
}
