package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gg.class */
public class gg extends ze {
    private e1 B;
    private t5 C;
    private int[] D;
    private int[] E;
    private int F;
    private GeoPoint G;
    private boolean H;
    private Selectable.OnSelectedListener I;
    private int J;
    private a K;
    private float L;
    private int M;
    private qc N;
    private boolean O;
    private p0 P;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gg$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37491a;
        public int b;
    }

    public gg(p0 p0Var, a1 a1Var, t5 t5Var) {
        super(a1Var);
        this.H = true;
        this.J = -1;
        this.L = -1.0f;
        this.M = -1;
        this.P = p0Var;
        this.N = a1Var.w();
        a(t5Var);
    }

    private Rect a(List<GeoPoint> list) {
        int i;
        int i2;
        int i3;
        int i4;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i5 = 0;
        GeoPoint geoPoint = list.get(0);
        int longitudeE6 = geoPoint.getLongitudeE6();
        int longitudeE62 = geoPoint.getLongitudeE6();
        int latitudeE6 = geoPoint.getLatitudeE6();
        int latitudeE62 = geoPoint.getLatitudeE6();
        int size = list.size();
        while (i5 < size) {
            GeoPoint geoPoint2 = list.get(i5);
            if (geoPoint2 == null) {
                i3 = latitudeE62;
                i4 = latitudeE6;
            } else {
                int latitudeE63 = geoPoint2.getLatitudeE6();
                int longitudeE63 = geoPoint2.getLongitudeE6();
                if (longitudeE63 < longitudeE6) {
                    i = longitudeE63;
                    i2 = longitudeE62;
                } else {
                    i = longitudeE6;
                    i2 = longitudeE62;
                    if (longitudeE63 > longitudeE62) {
                        i2 = longitudeE63;
                        i = longitudeE6;
                    }
                }
                if (latitudeE63 < latitudeE62) {
                    i3 = latitudeE63;
                    longitudeE6 = i;
                    longitudeE62 = i2;
                    i4 = latitudeE6;
                } else {
                    i3 = latitudeE62;
                    longitudeE6 = i;
                    longitudeE62 = i2;
                    i4 = latitudeE6;
                    if (latitudeE63 > latitudeE6) {
                        i4 = latitudeE63;
                        longitudeE62 = i2;
                        longitudeE6 = i;
                        i3 = latitudeE62;
                    }
                }
            }
            i5++;
            latitudeE62 = i3;
            latitudeE6 = i4;
        }
        return new Rect(longitudeE6, latitudeE6, longitudeE62, latitudeE62);
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        qc qcVar = this.N;
        if (qcVar == null) {
            return;
        }
        e1 a2 = qcVar.a();
        this.B = a2;
        yi yiVar = (yi) a2.j();
        if (yiVar == null) {
            return;
        }
        if (this.O && this.J != -1) {
            na.a(ma.f, "deleteLine..." + this.J);
            yiVar.getMap().d(this);
            this.B.f().a(this.J, g0());
            this.J = -1;
            return;
        }
        float b = qcVar.b();
        float f = this.L;
        if (f == -1.0f || f != b) {
            this.L = b;
        }
        if (this.J == -1) {
            this.J = this.B.f().a(this);
            na.a(ma.f, "createLine..." + this.J);
        }
        if (C()) {
            this.B.f().l(this);
        }
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        this.O = true;
    }

    public void J() {
        a aVar = this.K;
        if (aVar != null) {
            aVar.f37491a = -1;
            B();
        }
    }

    public int[] K() {
        return this.C.i;
    }

    public int[] L() {
        return this.C.h;
    }

    public float M() {
        return this.C.j;
    }

    public String N() {
        return this.C.w;
    }

    public int O() {
        return this.C.b();
    }

    public GeoPoint P() {
        return this.G;
    }

    public int Q() {
        return this.F;
    }

    public final int R() {
        return this.J;
    }

    public ArrayList<GeoPoint> S() {
        return this.C.b;
    }

    public int[] T() {
        return this.C.d;
    }

    public int[] U() {
        return this.C.f38016c;
    }

    public String[] V() {
        return this.C.e;
    }

    public int[] W() {
        return this.E;
    }

    public int[] X() {
        return this.D;
    }

    public float Y() {
        return this.C.d();
    }

    public String Z() {
        t5 t5Var = this.C;
        int[] iArr = t5Var.g;
        if (iArr != null && iArr.length > 0) {
            if (iArr[0] == 33) {
                return t5.N;
            }
            if (iArr[0] == 20) {
                return t5.O;
            }
        }
        return f7.b(t5Var.n) ? t5.M : this.C.n;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0
    public Rect a(t4 t4Var) {
        ArrayList<GeoPoint> arrayList;
        t5 t5Var = this.C;
        if (t5Var == null || (arrayList = t5Var.b) == null || arrayList.isEmpty()) {
            return null;
        }
        Iterator<GeoPoint> it = this.C.b.iterator();
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            GeoPoint next = it.next();
            int latitudeE6 = next.getLatitudeE6();
            int longitudeE6 = next.getLongitudeE6();
            int i5 = i3;
            if (latitudeE6 > i3) {
                i5 = latitudeE6;
            }
            int i6 = i2;
            if (latitudeE6 < i2) {
                i6 = latitudeE6;
            }
            int i7 = i4;
            if (longitudeE6 > i4) {
                i7 = longitudeE6;
            }
            i2 = i6;
            i3 = i5;
            i4 = i7;
            if (longitudeE6 < i) {
                i = longitudeE6;
                i2 = i6;
                i3 = i5;
                i4 = i7;
            }
        }
        return new Rect(i, i3, i4, i2);
    }

    public void a(float f) {
        this.C.j = f;
    }

    public void a(int i, GeoPoint geoPoint) {
        this.F = i;
        this.G = geoPoint;
        B();
    }

    public void a(t5 t5Var) {
        if (t5Var == null || !t5Var.a()) {
            na.h("LineOptions不能为空！");
        } else if (t5Var.equals(this.C)) {
        } else {
            B();
            this.C = t5Var;
            this.D = t5Var.f;
            this.E = t5Var.g;
        }
    }

    public void a(String str) {
        this.C.n = str;
    }

    @Deprecated
    public void a(String str, int i) {
        this.C.n = str;
    }

    @Deprecated
    public void a(String str, String str2, int i) {
        this.C.n = str;
    }

    public void a(int[] iArr) {
        this.C.i = iArr;
    }

    public a a0() {
        return this.K;
    }

    @Override // com.tencent.mapsdk.internal.v0
    public Rect b(t4 t4Var) {
        Rect a2 = a(t4Var);
        if (a2 == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint(a2.top, a2.left);
        GeoPoint geoPoint2 = new GeoPoint(a2.bottom, a2.right);
        p5 a3 = t4Var.a(geoPoint);
        p5 a4 = t4Var.a(geoPoint2);
        return new Rect((int) a3.b, (int) a3.f37683c, (int) a4.b, (int) a4.f37683c);
    }

    public final void b(int i) {
        this.J = i;
    }

    public void b(int i, int i2) {
        a aVar = new a();
        this.K = aVar;
        aVar.f37491a = i;
        aVar.b = i2;
        B();
    }

    public void b(List<Integer> list) {
        this.C.a(list);
    }

    public void b(boolean z) {
        this.C.t = z;
    }

    public int[] b0() {
        t5 t5Var = this.C;
        return new int[]{t5Var.y, t5Var.z};
    }

    public Rect c() {
        int i;
        Rect a2;
        ArrayList<GeoPoint> arrayList = this.C.f38015a;
        if (arrayList != null && !arrayList.isEmpty() && (i = this.F) >= 0 && i < arrayList.size() && (a2 = a(arrayList.subList(this.F, arrayList.size()))) != null) {
            this.C.u = a2;
        }
        return this.C.u;
    }

    public boolean c0() {
        return this.C.l;
    }

    public boolean d0() {
        return this.C.k;
    }

    public boolean e0() {
        return this.C.o;
    }

    public boolean f0() {
        return this.C.t;
    }

    public boolean g0() {
        return this.C.q;
    }

    public float getAlpha() {
        t5 t5Var = this.C;
        if (t5Var == null) {
            return 1.0f;
        }
        return t5Var.p;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getLevel() {
        return this.C.c();
    }

    public List<Integer> getPattern() {
        return this.C.A;
    }

    public float getWidth() {
        return this.C.m;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public int getZIndex() {
        return this.C.v;
    }

    public boolean isAboveMaskLayer() {
        return this.C.s;
    }

    public boolean isGradientEnable() {
        return this.C.D;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public boolean isSelected() {
        return this.H;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        e1 e1Var = this.B;
        if (e1Var == null) {
            return false;
        }
        TappedElement a2 = e1Var.f().a(f, f2);
        boolean z = false;
        if (a2 != null) {
            z = false;
            if (a2.itemId == R()) {
                z = true;
            }
        }
        return z;
    }

    public void setAlpha(float f) {
        t5 t5Var = this.C;
        if (t5Var == null || f < 0.0f || f > 1.0f) {
            return;
        }
        t5Var.p = f;
    }

    public void setArrow(boolean z) {
        this.C.l = z;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelected(boolean z) {
        this.H = z;
        e1 e1Var = this.B;
        if (e1Var == null || e1Var.f() == null) {
            return;
        }
        this.B.f().h(this);
    }

    public void setWidth(float f) {
        this.C.m = f;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Levelable
    public void setZIndex(int i) {
        this.C.v = i;
        e1 e1Var = this.B;
        if (e1Var == null || e1Var.f() == null) {
            return;
        }
        this.B.f().a(this.M, i);
    }

    @Override // com.tencent.mapsdk.internal.v0
    public p0 x() {
        return this.P;
    }
}
