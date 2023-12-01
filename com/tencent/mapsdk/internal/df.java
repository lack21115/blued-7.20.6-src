package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.a8;
import com.tencent.mapsdk.internal.rc;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/df.class */
public class df extends ze<r0> implements r0 {
    private gg B;
    private hg C;
    private Polyline D;
    private final List<d> E;
    private final List<GeoPoint> F;
    private float G;
    private final rc H;
    private boolean I;
    private int[] J;
    private int[] K;
    private int[] L;
    private int M;
    private PolylineOptions.ColorType N;
    private BitmapDescriptor O;
    private final int P;
    private a8 Q;
    private float R;
    private d S;
    private float T;
    private int U;
    private PolylineOptions.Text V;
    private boolean W;
    private boolean X;
    private float Y;
    private boolean Z;
    private boolean a0;
    private int b0;
    private GeoPoint c0;
    private String d0;
    private int e0;
    private List<Integer> f0;
    private final float g0;
    private boolean h0;
    private Animation i0;
    private PolylineOptions j0;
    private List<LatLng> k0;
    private final a1 l0;
    private String m0;
    private boolean n0;
    private a8.b o0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/df$a.class */
    public class a implements rc.b {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            df.this.Q();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/df$b.class */
    public class b implements Comparator<Integer> {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            return num.compareTo(num2);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/df$c.class */
    public class c implements a8.b {
        public c() {
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void a(float f) {
            df.this.T = f;
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void a(float f, float f2, float f3, float f4) {
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void a(int i, int i2) {
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void setAlpha(float f) {
            df.this.R = f;
        }

        @Override // com.tencent.mapsdk.internal.a8.b
        public void setScale(float f, float f2) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/df$d.class */
    public static class d extends GeoPoint {
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public int f37396c;

        public d() {
            this.b = 0.0f;
            this.f37396c = 0;
        }

        public d(GeoPoint geoPoint) {
            super(geoPoint);
            this.b = 0.0f;
            this.f37396c = 0;
        }

        @Override // com.tencent.map.lib.models.GeoPoint
        public String toString() {
            return super.toString() + "," + this.b;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/df$e.class */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int[] f37397a;
        public int[] b;

        /* renamed from: c  reason: collision with root package name */
        public int f37398c;
        public int d;

        public e(int i) {
            this.d = i;
            this.f37397a = new int[i];
            this.b = new int[i];
        }

        public void a(int i, int i2) {
            int i3 = this.f37398c;
            if (i3 >= this.d) {
                return;
            }
            this.f37397a[i3] = i;
            this.b[i3] = i2;
            this.f37398c = i3 + 1;
        }
    }

    public df(a1 a1Var) {
        super(a1Var);
        this.B = null;
        this.C = null;
        this.D = null;
        this.I = false;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = Color.GRAY;
        this.O = null;
        this.P = 12;
        this.S = null;
        this.T = 1.0f;
        this.U = 0;
        this.W = false;
        this.X = true;
        this.Y = 0.0f;
        this.Z = false;
        this.a0 = false;
        this.b0 = -1;
        this.c0 = null;
        this.e0 = (int) (g7.d(z().getContext()) * 100.0f);
        this.m0 = hj.r;
        this.o0 = new c();
        this.l0 = a1Var;
        rc A = a1Var.A();
        this.H = A;
        this.E = new CopyOnWriteArrayList();
        this.F = new CopyOnWriteArrayList();
        this.g0 = A.getContext().getResources().getDisplayMetrics().density;
    }

    private t5 J() {
        t5 t5Var = new t5();
        if (this.H == null) {
            return t5Var;
        }
        BitmapDescriptor bitmapDescriptor = this.O;
        if (bitmapDescriptor != null && bitmapDescriptor.getFormater() != null) {
            t5Var.c(this.O.getFormater().getBitmapId());
        }
        e a2 = a(this.F);
        t5Var.b(this.I);
        t5Var.d(this.e0);
        t5Var.b(this.F);
        t5Var.a(this.M);
        if (this.U == 0) {
            int a3 = a(this.H.getContext(), this.O);
            if (a3 > 0) {
                float f = this.j;
                float f2 = a3;
                float f3 = f;
                if (f > f2) {
                    f3 = f2;
                }
                t5Var.e(f3);
            } else {
                t5Var.e(this.j);
            }
        } else {
            t5Var.e(this.j);
        }
        if (this.N == PolylineOptions.ColorType.LINE_COLOR_ARGB) {
            t5Var.c(true);
            float f4 = this.G;
            float f5 = this.j;
            if (f4 * 2.0f >= f5) {
                this.G = f5 / 3.0f;
            }
            t5Var.b(this.G);
        }
        int[] M = M();
        if (this.X) {
            t5Var.c(a2.f37397a);
            if (this.G <= 0.0f || M == null || M.length <= 0) {
                t5Var.d(a2.b);
            } else {
                t5Var.a(a2.b, M);
            }
        } else {
            t5Var.c(new int[]{0});
            if (this.G <= 0.0f || M == null || M.length <= 0) {
                t5Var.d(new int[]{this.l});
            } else {
                t5Var.a(new int[]{this.l}, new int[]{M[0]});
            }
        }
        t5Var.c(this.R);
        t5Var.c(this.U);
        t5Var.d((int) this.m);
        t5Var.a(this.W);
        t5Var.f(this.Z);
        t5Var.e(this.a0);
        t5Var.d(this.X);
        t5Var.a(this.d0);
        t5Var.a(this.f0);
        t5Var.b(this.p);
        t5Var.D = this.n0;
        return t5Var;
    }

    private void L() {
        hg hgVar;
        rc rcVar = this.H;
        if (rcVar == null || !this.h0) {
            return;
        }
        this.h0 = false;
        if (this.V == null && (hgVar = this.C) != null) {
            hgVar.a();
            this.C = null;
            return;
        }
        ri S = rcVar.S();
        PolylineOptions.Text text = this.V;
        if (text != null) {
            hg hgVar2 = this.C;
            if (hgVar2 != null) {
                hgVar2.a(text);
                return;
            }
            List<GeoPoint> list = this.F;
            if (list == null || list.size() < 2) {
                return;
            }
            List<GeoPoint> list2 = this.F;
            this.C = new hg(S, (GeoPoint[]) list2.toArray(new GeoPoint[list2.size()]), this.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.H == null || this.F.size() < 2 || !isVisible()) {
            return;
        }
        gg ggVar = this.B;
        t5 J = J();
        if (J.a()) {
            if (ggVar == null) {
                ggVar = new gg(this, this.l0, J);
                ggVar.i = this.i;
                this.H.g().b(ggVar);
                this.B = ggVar;
            } else {
                ggVar.a(J);
            }
            ggVar.a(this.b0, this.c0);
            this.H.w0();
        }
    }

    private void R() {
        if (Thread.currentThread().getName().contains(this.m0)) {
            Q();
        } else {
            this.H.a(new a());
        }
    }

    private float a(d dVar, d dVar2, GeoPoint geoPoint, d dVar3) {
        int latitudeE6;
        float f;
        double hypot;
        int longitudeE6 = dVar.getLongitudeE6();
        int latitudeE62 = dVar.getLatitudeE6();
        int longitudeE62 = dVar2.getLongitudeE6();
        int latitudeE63 = dVar2.getLatitudeE6();
        int longitudeE63 = geoPoint.getLongitudeE6();
        int i = longitudeE62 - longitudeE6;
        int i2 = longitudeE63 - longitudeE6;
        int i3 = latitudeE63 - latitudeE62;
        int latitudeE64 = geoPoint.getLatitudeE6() - latitudeE62;
        float f2 = (i * i2) + (i3 * latitudeE64);
        if (f2 <= 0.0f) {
            dVar3.setLatitudeE6(dVar.getLatitudeE6());
            dVar3.setLongitudeE6(dVar.getLongitudeE6());
            dVar3.b = dVar.b;
            hypot = Math.hypot(i2, latitudeE64);
        } else {
            double d2 = (i * i) + (i3 * i3);
            double d3 = f2;
            if (d3 >= d2) {
                dVar3.setLatitudeE6(dVar2.getLatitudeE6());
                dVar3.setLongitudeE6(dVar2.getLongitudeE6());
                dVar3.b = dVar2.b;
                hypot = Math.hypot(longitudeE63 - longitudeE62, latitudeE6 - latitudeE63);
            } else {
                float f3 = (float) (d3 / d2);
                float f4 = longitudeE6 + (i * f3);
                dVar3.setLongitudeE6(Math.round(f4));
                dVar3.setLatitudeE6(Math.round(latitudeE62 + (i3 * f3)));
                float f5 = dVar.b;
                dVar3.b = f5 + ((dVar2.b - f5) * f3);
                hypot = Math.hypot(longitudeE63 - f4, latitudeE6 - f);
            }
        }
        return (float) hypot;
    }

    private int a(Context context, BitmapDescriptor bitmapDescriptor) {
        Bitmap bitmap;
        int height;
        if (context == null || bitmapDescriptor == null || (bitmap = bitmapDescriptor.getBitmap(context)) == null || (height = bitmap.getHeight()) <= 0) {
            return 0;
        }
        return (int) ((Math.pow(2.0d, 25.0d) / Math.pow(height, 2.0d)) / g7.d(context));
    }

    private d a(GeoPoint geoPoint) {
        d dVar = new d();
        List<d> list = this.E;
        d dVar2 = null;
        d dVar3 = null;
        if (list != null) {
            dVar3 = null;
            if (list.size() >= 2) {
                dVar3 = null;
                if (geoPoint != null) {
                    d dVar4 = this.E.get(0);
                    int i = 1;
                    float f = Float.MAX_VALUE;
                    while (true) {
                        float f2 = f;
                        dVar3 = dVar2;
                        if (i >= this.E.size()) {
                            break;
                        }
                        d dVar5 = this.E.get(i);
                        float a2 = a(dVar4, dVar5, geoPoint, dVar);
                        d dVar6 = dVar;
                        float f3 = f2;
                        if (a2 < f2) {
                            dVar6 = new d();
                            f3 = a2;
                            dVar2 = dVar;
                        }
                        i++;
                        dVar4 = dVar5;
                        dVar = dVar6;
                        f = f3;
                    }
                }
            }
        }
        return dVar3;
    }

    private d a(d dVar, d dVar2, float f) {
        d dVar3 = new d();
        int longitudeE6 = dVar2.getLongitudeE6();
        int longitudeE62 = dVar.getLongitudeE6();
        dVar3.setLatitudeE6(dVar.getLatitudeE6() + Math.round((dVar2.getLatitudeE6() - dVar.getLatitudeE6()) * f));
        dVar3.setLongitudeE6(dVar.getLongitudeE6() + Math.round((longitudeE6 - longitudeE62) * f));
        float f2 = dVar.b;
        dVar3.b = f2 + ((dVar2.b - f2) * f);
        return dVar3;
    }

    private e a(List<GeoPoint> list) {
        int[] iArr;
        int[] iArr2 = this.J;
        if (iArr2 == null || (iArr = this.K) == null || list == null || iArr2.length == 0 || iArr.length == 0 || list.isEmpty()) {
            int i = this.l;
            int i2 = i;
            if (this.N == PolylineOptions.ColorType.LINE_COLOR_TEXTURE) {
                i2 = b(i);
            }
            e eVar = new e(1);
            eVar.a(0, i2);
            return eVar;
        }
        TreeSet treeSet = new TreeSet(new b());
        int[] iArr3 = this.K;
        int length = iArr3.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            int i5 = iArr3[i4];
            if (i5 >= 0 && i5 < list.size()) {
                treeSet.add(Integer.valueOf(i5));
            }
            i3 = i4 + 1;
        }
        ArrayList arrayList = new ArrayList();
        int[] iArr4 = this.J;
        int length2 = iArr4.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length2) {
                break;
            }
            arrayList.add(Integer.valueOf(iArr4[i7]));
            i6 = i7 + 1;
        }
        Integer[] numArr = (Integer[]) treeSet.toArray(new Integer[0]);
        if (numArr[0].intValue() != 0) {
            treeSet.add(0);
            arrayList.add(0, Integer.valueOf(this.J[0]));
        }
        if (numArr[numArr.length - 1].intValue() != list.size() - 1) {
            treeSet.add(Integer.valueOf(list.size() - 1));
            if (numArr.length > this.J.length) {
                int size = arrayList.size();
                int[] iArr5 = this.J;
                arrayList.add(size - 1, Integer.valueOf(iArr5[iArr5.length - 1]));
            }
        }
        ArrayList arrayList2 = new ArrayList(treeSet);
        int size2 = arrayList2.size();
        e eVar2 = new e(size2);
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= size2) {
                return eVar2;
            }
            if (i9 > arrayList.size() - 1) {
                eVar2.a(((Integer) arrayList2.get(i9)).intValue(), ((Integer) arrayList.get(arrayList.size() - 1)).intValue());
            } else {
                eVar2.a(((Integer) arrayList2.get(i9)).intValue(), ((Integer) arrayList.get(i9)).intValue());
            }
            i8 = i9 + 1;
        }
    }

    private PolylineOptions.ColorType a(PolylineOptions.ColorType colorType) {
        if (colorType != PolylineOptions.ColorType.LINE_COLOR_NONE) {
            return colorType;
        }
        int[] iArr = this.J;
        if (iArr == null || iArr.length <= 0) {
            int i = this.l;
            return (i < 0 || i >= 12) ? PolylineOptions.ColorType.LINE_COLOR_ARGB : PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
        }
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int[] iArr2 = this.J;
            if (iArr2[i2] < 0 || iArr2[i2] >= 12) {
                return PolylineOptions.ColorType.LINE_COLOR_ARGB;
            }
        }
        return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    }

    private void a(c8 c8Var) {
        if (this.H == null) {
            return;
        }
        this.Q = c8Var;
        GeoPoint from = GeoPoint.from(c8Var.i());
        d a2 = a(from);
        this.S = a2;
        if (a2 != null) {
            c8Var.a(this.o0);
            c8Var.a((GeoPoint) null, (GeoPoint) null);
            this.H.w0();
            return;
        }
        na.b("Error, start point not found. [p=" + from + "] [offsetGeoPoints=" + this.E + "]");
    }

    private void a(z7 z7Var) {
        this.Q = z7Var;
        z7Var.a(this.o0);
        this.Q.a((GeoPoint) null, (GeoPoint) null);
        rc rcVar = this.H;
        if (rcVar != null) {
            rcVar.w0();
        }
    }

    private int b(int i) {
        int i2 = i;
        if (i >= 12) {
            i2 = 11;
        }
        int i3 = i2;
        if (i2 < 0) {
            i3 = 0;
        }
        return i3;
    }

    private ArrayList<GeoPoint> b(List<d> list) {
        ArrayList<GeoPoint> arrayList = new ArrayList<>();
        if (list != null) {
            if (list.size() >= 2) {
                float f = this.S.b;
                float f2 = this.Y;
                float f3 = this.T;
                float f4 = f - (f * f3);
                float f5 = f + ((f2 - f) * f3);
                d dVar = null;
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    d dVar2 = list.get(i);
                    float f6 = dVar2.b;
                    if (f6 > f4 && f6 < f5) {
                        if (dVar != null) {
                            float f7 = dVar.b;
                            if (f7 < f4) {
                                d a2 = a(dVar, dVar2, (f4 - f7) / (f6 - f7));
                                a2.f37396c = dVar.f37396c;
                                arrayList.add(a2);
                            }
                        }
                        arrayList.add(dVar2);
                    } else if (f6 > f5) {
                        if (dVar != null) {
                            float f8 = dVar.b;
                            if (f8 < f5) {
                                d a3 = a(dVar, dVar2, (f5 - f8) / (f6 - f8));
                                a3.f37396c = dVar2.f37396c;
                                arrayList.add(a3);
                                return arrayList;
                            }
                        }
                    } else if (Float.compare(f6, f4) == 0 || Float.compare(dVar2.b, f5) == 0) {
                        arrayList.add(dVar2);
                    }
                    i++;
                    dVar = dVar2;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
        if (r4 != 4) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int c(int r4) {
        /*
            r3 = this;
            r0 = 4
            r5 = r0
            r0 = r4
            r1 = 6
            if (r0 == r1) goto L34
            r0 = r4
            r1 = 33
            if (r0 == r1) goto L31
            r0 = r4
            if (r0 == 0) goto L2f
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L2d
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L2b
            r0 = r4
            r1 = 3
            if (r0 == r1) goto L29
            r0 = r4
            r1 = 4
            if (r0 == r1) goto L37
            goto L34
        L29:
            r0 = 3
            return r0
        L2b:
            r0 = 2
            return r0
        L2d:
            r0 = 1
            return r0
        L2f:
            r0 = 0
            return r0
        L31:
            r0 = 33
            return r0
        L34:
            r0 = 6
            r5 = r0
        L37:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.df.c(int):int");
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void B() {
        super.B();
        gg ggVar = this.B;
        if (ggVar != null) {
            ggVar.B();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        this.m0 = Thread.currentThread().getName();
        if (this.H != null && isVisible()) {
            if (C()) {
                if (this.E.size() >= 2) {
                    this.F.clear();
                    this.F.addAll(this.E);
                }
                R();
            }
            K();
            L();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        gg ggVar = this.B;
        if (ggVar != null) {
            ggVar.remove();
            this.B = null;
        }
        hg hgVar = this.C;
        if (hgVar != null) {
            hgVar.a();
            this.C = null;
        }
        List<d> list = this.E;
        if (list != null) {
            list.clear();
        }
        List<GeoPoint> list2 = this.F;
        if (list2 != null) {
            list2.clear();
        }
    }

    public boolean K() {
        a8 a8Var;
        if (this.H == null || (a8Var = this.Q) == null || !a8Var.g()) {
            return false;
        }
        this.Q.a();
        a8 a8Var2 = this.Q;
        if (a8Var2 instanceof c8) {
            this.F.clear();
            this.F.addAll(b(this.E));
            if (this.F.size() >= 2) {
                R();
            }
        } else if (a8Var2 instanceof z7) {
            R();
        }
        this.H.w0();
        if (this.Q.e()) {
            this.Q.a((a8.b) null);
            this.Q = null;
            return true;
        }
        return true;
    }

    public int[] M() {
        return this.L;
    }

    public gg N() {
        return this.B;
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: O */
    public r0 x() {
        return this;
    }

    public Polyline P() {
        return this.D;
    }

    public float a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        float f = 0.0f;
        if (geoPoint != null) {
            f = 0.0f;
            if (geoPoint2 != null) {
                f = (float) (0.0f + Math.hypot(geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6(), geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6()));
            }
        }
        return f;
    }

    public void a(float f) {
        this.G = f;
    }

    @Override // com.tencent.mapsdk.internal.r0
    public void a(int i, LatLng latLng) {
        GeoPoint from = GeoPoint.from(latLng);
        if (i == -1 || from == null) {
            return;
        }
        this.b0 = i;
        this.c0 = from;
        gg ggVar = this.B;
        if (ggVar != null) {
            ggVar.a(i, from);
        }
        rc rcVar = this.H;
        if (rcVar != null) {
            rcVar.w0();
        }
    }

    @Override // com.tencent.mapsdk.internal.r0
    public void a(a8 a8Var) {
        a8 a8Var2 = this.Q;
        if (a8Var2 != null) {
            a8Var2.h();
            this.Q.a((a8.b) null);
        }
        if (a8Var instanceof c8) {
            a((c8) a8Var);
        } else if (a8Var instanceof z7) {
            a((z7) a8Var);
        } else {
            this.Q = null;
        }
    }

    public void a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor.getBitmap(this.l0.getContext()) != null) {
            this.d0 = bitmapDescriptor.getFormater().getBitmapId();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.s4
    public void a(IndoorBuilding indoorBuilding) {
        super.a(indoorBuilding);
        gg ggVar = this.B;
        if (ggVar != null) {
            ggVar.a(indoorBuilding);
        }
    }

    public void a(Polyline polyline) {
        this.D = polyline;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void addTurnArrow(int i, int i2) {
        gg ggVar = this.B;
        if (ggVar == null) {
            return;
        }
        ggVar.J();
        this.B.b(i, i2);
        R();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void appendPoint(LatLng... latLngArr) {
        if (this.k0 == null) {
            this.k0 = new ArrayList();
        }
        this.k0.addAll(Arrays.asList(latLngArr));
        c(this.k0);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void appendPoints(List<LatLng> list) {
        if (this.k0 == null) {
            this.k0 = new ArrayList();
        }
        this.k0.addAll(list);
        c(this.k0);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void arrowSpacing(int i) {
        if (this.e0 != i) {
            this.e0 = i;
            PolylineOptions polylineOptions = this.j0;
            if (polylineOptions != null) {
                polylineOptions.arrowSpacing(i);
            }
            B();
        }
    }

    @Override // com.tencent.mapsdk.internal.r0
    public void b(boolean z) {
        this.Z = z;
        gg ggVar = this.B;
        if (ggVar != null) {
            ggVar.b(z);
        }
        B();
    }

    @Override // com.tencent.mapsdk.internal.r0
    public Rect c() {
        return this.B.c();
    }

    public void c(List<LatLng> list) {
        int size;
        this.k0 = list;
        if (list == null || (size = list.size()) <= 0) {
            return;
        }
        this.Y = 0.0f;
        this.E.clear();
        GeoPoint geoPoint = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                B();
                return;
            }
            LatLng latLng = list.get(i2);
            if (latLng != null) {
                d dVar = new d(GeoPoint.from(latLng));
                if (geoPoint != null) {
                    float a2 = this.Y + a(dVar, geoPoint);
                    this.Y = a2;
                    dVar.b = a2;
                    dVar.f37396c = geoPoint.f37396c + 1;
                }
                this.E.add(dVar);
                geoPoint = dVar;
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void cleanTurnArrow() {
        gg ggVar = this.B;
        if (ggVar == null) {
            return;
        }
        ggVar.J();
        R();
    }

    public void d(int i) {
        this.e0 = i;
    }

    public void d(List<Integer> list) {
        this.f0 = list;
        B();
    }

    @Override // com.tencent.mapsdk.internal.r0
    public void d(boolean z) {
        f(z);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof df)) {
            return TextUtils.equals(y(), ((df) obj).y());
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void eraseColor(int i) {
        if (this.M != i) {
            this.M = i;
            PolylineOptions polylineOptions = this.j0;
            if (polylineOptions != null) {
                polylineOptions.eraseColor(i);
            }
            B();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void eraseTo(int i, LatLng latLng) {
        a(i, latLng);
    }

    public void f(boolean z) {
        this.a0 = z;
        B();
    }

    public float getAlpha() {
        return this.R;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public int getColor() {
        return getStrokeColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public int[][] getColors() {
        int[] iArr;
        int[] iArr2 = this.J;
        if (iArr2 == null || (iArr = this.K) == null) {
            return null;
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, 2, Math.max(iArr2.length, iArr.length));
        iArr3[0] = this.J;
        iArr3[1] = this.K;
        return iArr3;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    public List<Boundable<t4>> getGroupBounds() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.B);
        return arrayList;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public List<Integer> getPattern() {
        return this.f0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public List<LatLng> getPoints() {
        return this.k0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public PolylineOptions getPolylineOptions() {
        return this.j0;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public PolylineOptions.Text getText() {
        return this.V;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public Rect getVisibleRect() {
        return c();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public float getWidth() {
        return this.j;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean handleOnTap() {
        return true;
    }

    public int hashCode() {
        return y().hashCode();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public boolean isAboveMaskLayer() {
        return this.W;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public boolean isGradientEnable() {
        return this.n0;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.s4
    public void l() {
        super.l();
        gg ggVar = this.B;
        if (ggVar != null) {
            ggVar.l();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.q4
    public void n() {
        R();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        gg ggVar;
        if (this.H == null || !isVisible() || (ggVar = this.B) == null) {
            return false;
        }
        return ggVar.onTap(f, f2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void pattern(List<Integer> list) {
        d(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setAboveMaskLayer(boolean z) {
        if (this.W != z) {
            this.W = z;
            B();
        }
    }

    @Override // com.tencent.mapsdk.internal.r0
    public void setAlpha(float f) {
        this.R = f;
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public void setAnimation(Animation animation) {
        if ((animation instanceof AlphaAnimation) || (animation instanceof EmergeAnimation) || (animation instanceof IAlphaAnimation) || (animation instanceof IEmergeAnimation)) {
            this.i0 = animation;
        } else {
            na.h("Unsupported animation, only AlphaAnimation and EmergeAnimation allowed.");
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setArrow(boolean z) {
        if (this.I != z) {
            this.I = z;
            PolylineOptions polylineOptions = this.j0;
            if (polylineOptions != null) {
                polylineOptions.arrow(z);
            }
            B();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setBorderColors(int[] iArr) {
        if (this.L != iArr) {
            this.L = iArr;
            PolylineOptions polylineOptions = this.j0;
            if (polylineOptions != null) {
                polylineOptions.borderColors(iArr);
            }
            B();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColor(int i) {
        setStrokeColor(i);
        PolylineOptions polylineOptions = this.j0;
        if (polylineOptions != null) {
            polylineOptions.color(i);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColorTexture(BitmapDescriptor bitmapDescriptor) {
        if (this.H == null || bitmapDescriptor == null || bitmapDescriptor.getFormater() == null) {
            return;
        }
        this.O = bitmapDescriptor;
        bitmapDescriptor.getBitmap(this.H.getContext());
        this.N = PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColorTexture(String str) {
        setColorTexture(BitmapDescriptorFactory.fromAsset(str));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setColors(int[] iArr, int[] iArr2) {
        this.J = iArr;
        this.K = iArr2;
        this.N = a(PolylineOptions.ColorType.LINE_COLOR_NONE);
        this.X = true;
        B();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setEraseable(boolean z) {
        b(z);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setGradientEnable(boolean z) {
        if (this.U == 0 && this.X) {
            this.n0 = z;
            B();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setPoints(List<LatLng> list) {
        c(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setPolylineOptions(PolylineOptions polylineOptions) {
        if (this.H == null || polylineOptions == null) {
            return;
        }
        D();
        this.j0 = polylineOptions;
        if (polylineOptions.getWidth() == -1.0f) {
            setStrokeWidth(this.g0 * 9.0f);
        } else {
            setStrokeWidth(polylineOptions.getWidth());
        }
        setStrokeColor(polylineOptions.getColor());
        setZIndex(polylineOptions.getZIndex());
        setVisible(polylineOptions.isVisible());
        setAlpha(polylineOptions.getAlpha());
        setArrow(polylineOptions.isArrow());
        setColorTexture(polylineOptions.getColorTexture());
        f(polylineOptions.getLineCap());
        d(polylineOptions.getPattern());
        a(polylineOptions.getBorderWidth());
        setClickable(polylineOptions.isClickable());
        this.L = polylineOptions.getBorderColors();
        this.i = polylineOptions.getIndoorInfo();
        this.U = polylineOptions.getLineType();
        this.p = polylineOptions.getLevel();
        this.M = polylineOptions.getEraseColor();
        if (polylineOptions.isAbovePillar() && this.p == 0) {
            this.p = 2;
        }
        c(polylineOptions.getPoints());
        if (polylineOptions.getArrowTexture() != null) {
            a(polylineOptions.getArrowTexture());
        }
        d(polylineOptions.getArrowSpacing());
        this.X = polylineOptions.isRoad();
        Animation animation = polylineOptions.getAnimation();
        if (animation != null) {
            a(((j7) animation).f37563a);
        }
        int[][] colors = polylineOptions.getColors();
        if (colors != null && colors.length == 2) {
            int[] iArr = colors[0];
            int[] iArr2 = colors[1];
            if (iArr != null && iArr2 != null) {
                setColors(iArr, iArr2);
            }
        }
        this.N = a(polylineOptions.getColorType());
        setText(polylineOptions.getText());
        setGradientEnable(polylineOptions.isGradientEnable());
        I();
        R();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setText(PolylineOptions.Text text) {
        if (this.V != text) {
            this.V = text;
            this.h0 = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public void setVisible(boolean z) {
        super.setVisible(z);
        gg ggVar = this.B;
        if (ggVar != null) {
            ggVar.setVisible(z);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline
    public void setWidth(float f) {
        float f2 = f;
        if (f < 0.0f) {
            f2 = 1.0f;
        }
        float f3 = f2;
        if (f2 > 128.0f) {
            f3 = 128.0f;
        }
        setStrokeWidth(f3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polyline, com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public void startAnimation(Animation animation) {
        setAnimation(animation);
        startAnimation();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Animationable
    public boolean startAnimation() {
        j7 a2;
        if (this.i0 == null || (a2 = i8.a(this.H.V(), this.i0)) == null) {
            return false;
        }
        a(a2.f37563a);
        return false;
    }
}
