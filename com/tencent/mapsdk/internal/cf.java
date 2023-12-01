package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cf.class */
public class cf extends ze<q0> implements h5, q0 {
    private static final int X = 180;
    private static final int Y = 1;
    private static final double Z = 1.0E-10d;
    private List<GeoPoint> B;
    private List<LatLng> C;
    private x5[] D;
    private GeoPoint E;
    private Rect F;
    private Rect G;
    public final PolygonInfo H;
    private ig I;
    private final byte[] J;
    private c K;
    private String L;
    private GeoPoint M;
    private Rect N;
    private GeoPoint[] O;
    private boolean P;
    private boolean Q;
    private ArrayList<ig> R;
    private ArrayList<ig> S;
    private PolygonOptions T;
    private rc U;
    private String V;
    private BitmapDescriptor W;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cf$b.class */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public LatLng[] f23680a;

        public b(LatLng latLng, LatLng latLng2) {
            this.f23680a = r0;
            LatLng[] latLngArr = {latLng, latLng2};
        }

        public String toString() {
            return this.f23680a[0].toString() + "    " + this.f23680a[1].toString();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cf$c.class */
    public static class c {
        private static final int g = 900;
        private static final int h = 180;

        /* renamed from: a  reason: collision with root package name */
        private Bitmap f23681a;
        private TextPaint b;

        /* renamed from: c  reason: collision with root package name */
        private int f23682c;
        private int d;
        private int e;
        private HashMap<String, Integer> f;

        private c() {
            this.f23681a = null;
            this.b = null;
            this.f23682c = 900;
            this.d = 180;
            this.e = -1;
            this.f = new HashMap<>();
        }

        private String a(String str, String str2, int i) {
            return str + "_" + str2 + "_" + i;
        }

        private void a(int i) {
            TextPaint textPaint = this.b;
            if (textPaint != null) {
                textPaint.setTextSize(i);
            }
        }

        private void a(int i, int i2, Typeface typeface) {
            if (this.b == null) {
                TextPaint textPaint = new TextPaint(65);
                this.b = textPaint;
                textPaint.setStyle(Paint.Style.FILL);
                this.b.setTextAlign(Paint.Align.CENTER);
            }
            this.b.setColor(i2);
            this.b.setTextSize(i);
            this.b.setTypeface(typeface);
        }

        private void a(String str, int i, int i2, Typeface typeface) {
            if (this.f23681a == null) {
                try {
                    this.f23681a = Bitmap.createBitmap(this.f23682c, this.d, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    return;
                }
            }
            a(i, i2, typeface);
            Rect rect = new Rect();
            this.b.getTextBounds(str, 0, str.length(), rect);
            int abs = Math.abs(rect.width());
            int abs2 = Math.abs(rect.height());
            int i3 = this.f23682c;
            if (abs > i3 || abs2 > this.d) {
                this.f23682c = Math.max(abs, i3);
                int max = Math.max(abs2, this.d);
                this.d = max;
                this.f23681a = Bitmap.createBitmap(this.f23682c, max, Bitmap.Config.ARGB_8888);
            }
            this.f23681a.eraseColor(0);
            new Canvas(this.f23681a).drawText(str, this.f23682c / 2.0f, (this.d / 2.0f) - ((this.b.descent() + this.b.ascent()) / 2.0f), this.b);
        }

        private int[] a(String str, int i, Rect rect) {
            a(i);
            this.b.getTextBounds(str, 0, str.length(), rect);
            return new int[]{Math.abs(rect.width()), Math.abs(rect.height())};
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int a(android.graphics.Rect r8, java.lang.String r9, int r10, android.graphics.Typeface r11, int r12, int r13) {
            /*
                Method dump skipped, instructions count: 263
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.cf.c.a(android.graphics.Rect, java.lang.String, int, android.graphics.Typeface, int, int):int");
        }

        public void a() {
            Bitmap bitmap = this.f23681a;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.f23681a.recycle();
            this.f23681a = null;
        }

        public Object[] a(String str, String str2, int i, int i2, Typeface typeface) {
            String a2 = a(str, str2, i);
            int i3 = i;
            if (i > 180) {
                i3 = 180;
            }
            if (i3 != this.e) {
                a(str2, i3, i2, typeface);
                this.e = i3;
            }
            return new Object[]{a2, this.f23681a};
        }
    }

    public cf(a1 a1Var, PolygonOptions polygonOptions) {
        super(a1Var);
        this.B = new CopyOnWriteArrayList();
        this.J = new byte[0];
        this.K = new c();
        this.M = new GeoPoint();
        this.N = new Rect();
        this.P = false;
        this.Q = false;
        PolygonInfo polygonInfo = new PolygonInfo();
        this.H = polygonInfo;
        polygonInfo.polygonId = -1;
        this.T = polygonOptions;
        this.U = a1Var.A();
        if (polygonOptions != null && !f7.b(this.V)) {
            this.U.h().a(this);
        }
        a(polygonOptions);
    }

    private b[] L() {
        List<GeoPoint> list = this.B;
        List<LatLng> a2 = fa.a(list);
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = size - 1;
            if (i >= i2) {
                arrayList.add(new b(a2.get(i2), a2.get(0)));
                return (b[]) arrayList.toArray(new b[arrayList.size()]);
            }
            LatLng latLng = a2.get(i);
            i++;
            arrayList.add(new b(latLng, a2.get(i)));
        }
    }

    private double a(LatLng latLng, b[] bVarArr, LatLng latLng2) {
        int i;
        int length = bVarArr.length;
        LatLng latLng3 = new LatLng(0.0d, 0.0d);
        LatLng latLng4 = new LatLng(0.0d, 0.0d);
        LatLng[] latLngArr = bVarArr[0].f23680a;
        LatLng latLng5 = latLngArr[0];
        LatLng latLng6 = latLngArr[1];
        double c2 = xa.c((Coordinate) latLng, (Coordinate) latLng5, (Coordinate) latLng6);
        latLng3.latitude = latLng5.latitude;
        latLng3.longitude = latLng5.longitude;
        latLng4.latitude = latLng6.latitude;
        latLng4.longitude = latLng6.longitude;
        int i2 = 1;
        while (i2 < length) {
            LatLng[] latLngArr2 = bVarArr[i2].f23680a;
            LatLng latLng7 = latLngArr2[0];
            LatLng latLng8 = latLngArr2[1];
            double c3 = xa.c((Coordinate) latLng, (Coordinate) latLng7, (Coordinate) latLng8);
            double d = c2;
            if (c3 < c2) {
                latLng3.latitude = latLng7.latitude;
                latLng3.longitude = latLng7.longitude;
                latLng4.latitude = latLng8.latitude;
                latLng4.longitude = latLng8.longitude;
                d = c3;
            }
            i2++;
            c2 = d;
        }
        LatLng b2 = xa.b(latLng, latLng3, latLng4);
        LatLng latLng9 = new LatLng(0.0d, 0.0d);
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        double d2 = 0.0d;
        while (!z) {
            LatLng a2 = xa.a(latLng, b2, i3);
            double a3 = xa.a((Coordinate) a2, (Coordinate) b2);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    break;
                }
                LatLng[] latLngArr3 = bVarArr[i6].f23680a;
                if (xa.a(a2, a3, latLngArr3[0], latLngArr3[1])) {
                    z = true;
                    break;
                }
                i5 = i6 + 1;
            }
            if (z) {
                i = i3;
                if (i4 == 0) {
                    latLng9.latitude = a2.latitude;
                    latLng9.longitude = a2.longitude;
                } else {
                    i4++;
                    i3 = i;
                }
            } else {
                latLng9.latitude = a2.latitude;
                latLng9.longitude = a2.longitude;
                i3 += 5;
            }
            d2 = a3;
            i = i3;
            i4++;
            i3 = i;
        }
        latLng2.latitude = latLng9.latitude;
        latLng2.longitude = latLng9.longitude;
        return d2;
    }

    private double a(b[] bVarArr, LatLng latLng) {
        List<LatLng> a2;
        List<GeoPoint> i = i();
        if (i == null || i.isEmpty() || (a2 = fa.a(i)) == null || a2.isEmpty()) {
            return 0.0d;
        }
        int size = a2.size();
        LatLng[] latLngArr = new LatLng[size];
        double[] dArr = new double[size];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            latLngArr[i4] = new LatLng(0.0d, 0.0d);
            dArr[i4] = a(a2.get(i4), bVarArr, latLngArr[i4]);
            if (Double.isNaN(dArr[i4])) {
                dArr[i4] = 0.0d;
            }
            i3 = i4 + 1;
        }
        double d = dArr[0];
        int i5 = 1;
        while (i5 < size) {
            double d2 = d;
            if (dArr[i5] > d) {
                d2 = dArr[i5];
                i2 = i5;
            }
            i5++;
            d = d2;
        }
        latLng.latitude = latLngArr[i2].latitude;
        latLng.longitude = latLngArr[i2].longitude;
        return dArr[i2];
    }

    private int a(Rect rect, String str) {
        return 1;
    }

    private int a(String str, GeoPoint geoPoint, t4 t4Var) {
        Rect a2 = a(L());
        this.N = a2;
        geoPoint.setLatitudeE6(a2.centerY());
        geoPoint.setLongitudeE6(this.N.centerX());
        Rect rect = this.N;
        GeoPoint geoPoint2 = new GeoPoint(rect.top, rect.left);
        Rect rect2 = this.N;
        GeoPoint geoPoint3 = new GeoPoint(rect2.top, rect2.right);
        Rect rect3 = this.N;
        GeoPoint geoPoint4 = new GeoPoint(rect3.bottom, rect3.right);
        Rect rect4 = this.N;
        p5[] a3 = a(new p5[]{t4Var.a(geoPoint2), t4Var.a(geoPoint3), t4Var.a(geoPoint4), t4Var.a(new GeoPoint(rect4.bottom, rect4.left))});
        return a(new Rect((int) a3[0].b, (int) a3[0].f23992c, (int) a3[1].b, (int) a3[1].f23992c), str);
    }

    private int a(String str, t4 t4Var) {
        Rect rect = this.N;
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        Rect rect2 = this.N;
        GeoPoint geoPoint2 = new GeoPoint(rect2.top, rect2.right);
        Rect rect3 = this.N;
        GeoPoint geoPoint3 = new GeoPoint(rect3.bottom, rect3.right);
        Rect rect4 = this.N;
        p5[] a2 = a(new p5[]{t4Var.a(geoPoint), t4Var.a(geoPoint2), t4Var.a(geoPoint3), t4Var.a(new GeoPoint(rect4.bottom, rect4.left))});
        return a(new Rect((int) a2[0].b, (int) a2[0].f23992c, (int) a2[1].b, (int) a2[1].f23992c), str);
    }

    private Rect a(b[] bVarArr) {
        LatLng latLng = new LatLng(0.0d, 0.0d);
        double a2 = a(bVarArr, latLng);
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        return new Rect((int) ((d + a2) * 1000000.0d), (int) ((d2 + a2) * 1000000.0d), (int) ((d - a2) * 1000000.0d), (int) ((d2 - a2) * 1000000.0d));
    }

    private boolean a(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(b(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    private boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d3 - d;
        double d10 = d8 - d6;
        double d11 = d4 - d2;
        double d12 = d7 - d5;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d2 - d6;
            double d15 = d - d5;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            return d16 >= 0.0d && d16 <= 1.0d && d17 >= 0.0d && d17 <= 1.0d;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x019d, code lost:
        if (r0 > r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01bb, code lost:
        if (r0 > r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01d9, code lost:
        if (a(r0, r0, r0, r0, r0, r0, 180.0d, r0) != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f3 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.tencent.map.lib.models.GeoPoint r19) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.cf.a(com.tencent.map.lib.models.GeoPoint):boolean");
    }

    private boolean a(x5 x5Var) {
        int i;
        List<LatLng> list = this.C;
        if (list == null || list.size() <= 2) {
            return false;
        }
        this.D = new x5[this.C.size() + 1];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.C.size()) {
                break;
            }
            this.D[i3] = this.U.getProjection().a(this.C.get(i3));
            x5[] x5VarArr = this.D;
            x5VarArr[i3].setX(x5VarArr[i3].b() - x5Var.b());
            x5[] x5VarArr2 = this.D;
            x5VarArr2[i3].setY(x5VarArr2[i3].c() - x5Var.c());
            i2 = i3 + 1;
        }
        this.D[this.C.size()] = this.U.getProjection().a(this.C.get(0));
        this.D[this.C.size()].setX(this.D[this.C.size()].b() - x5Var.b());
        this.D[this.C.size()].setY(this.D[this.C.size()].c() - x5Var.c());
        double b2 = this.D[0].b();
        x5[] x5VarArr3 = this.D;
        int i4 = 1;
        int i5 = 0;
        int i6 = b2 >= 0.0d ? x5VarArr3[0].c() >= 0.0d ? 0 : 3 : x5VarArr3[0].c() >= 0.0d ? 1 : 2;
        while (true) {
            x5[] x5VarArr4 = this.D;
            if (i4 > x5VarArr4.length - 1 || (x5VarArr4[i4].b() == 0.0d && this.D[i4].c() == 0.0d)) {
                break;
            }
            int i7 = i4 - 1;
            int i8 = (((this.D[i4].c() * this.D[i7].b()) - (this.D[i4].b() * this.D[i7].c())) > 0.0d ? 1 : (((this.D[i4].c() * this.D[i7].b()) - (this.D[i4].b() * this.D[i7].c())) == 0.0d ? 0 : -1));
            if (i8 == 0 && this.D[i7].b() * this.D[i4].b() <= 0.0d && this.D[i7].c() * this.D[i4].c() <= 0.0d) {
                break;
            }
            double b3 = this.D[i4].b();
            x5[] x5VarArr5 = this.D;
            int i9 = b3 >= 0.0d ? x5VarArr5[i4].c() >= 0.0d ? 0 : 3 : x5VarArr5[i4].c() >= 0.0d ? 1 : 2;
            if (i9 == (i6 + 1) % 4) {
                i = i5 + 1;
            } else if (i9 == (i6 + 3) % 4) {
                i = i5 - 1;
            } else {
                i = i5;
                if (i9 == (i6 + 2) % 4) {
                    i = i8 > 0 ? i5 + 2 : i5 - 2;
                }
            }
            i4++;
            i6 = i9;
            i5 = i;
        }
        return i4 <= this.C.size() || i5 != 0;
    }

    private p5[] a(p5[] p5VarArr) {
        int length = p5VarArr.length;
        double d = p5VarArr[0].b;
        double d2 = p5VarArr[0].f23992c;
        double d3 = p5VarArr[0].b;
        double d4 = p5VarArr[0].f23992c;
        int i = 1;
        while (i < length) {
            double d5 = p5VarArr[i].b;
            double d6 = p5VarArr[i].f23992c;
            double d7 = d;
            if (d5 < d) {
                d7 = d5;
            }
            double d8 = d3;
            if (d5 > d3) {
                d8 = d5;
            }
            double d9 = d2;
            if (d6 < d2) {
                d9 = d6;
            }
            double d10 = d4;
            if (d6 > d4) {
                d10 = d6;
            }
            i++;
            d = d7;
            d2 = d9;
            d3 = d8;
            d4 = d10;
        }
        return new p5[]{new p5(d, d2), new p5(d3, d4)};
    }

    private double b(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    private boolean c(t4 t4Var) {
        Rect K;
        boolean z = false;
        if (this.H != null) {
            PolygonOptions polygonOptions = this.T;
            z = false;
            if (polygonOptions != null) {
                if (!polygonOptions.isValid() || (K = K()) == null) {
                    return false;
                }
                p5[] a2 = a(new p5[]{t4Var.a(new GeoPoint(K.top, K.left)), t4Var.a(new GeoPoint(K.top, K.right)), t4Var.a(new GeoPoint(K.bottom, K.right)), t4Var.a(new GeoPoint(K.bottom, K.left))});
                Rect rect = new Rect((int) a2[0].b, (int) a2[0].f23992c, (int) a2[1].b, (int) a2[1].f23992c);
                z = false;
                if (Math.abs(rect.width()) > 5) {
                    z = false;
                    if (Math.abs(rect.height()) > 5) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private void d(t4 t4Var) {
        if (this.U == null) {
            return;
        }
        String str = this.V;
        if (f7.b(str)) {
            return;
        }
        synchronized (this.J) {
            if (this.K == null) {
                this.K = new c();
            }
        }
        a(str, t4Var);
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        rc rcVar = this.U;
        if (rcVar == null) {
            return;
        }
        t4 projection = rcVar.getProjection();
        if (!isVisible()) {
            rcVar.c(this.H.polygonId);
            this.H.polygonId = -1;
        } else if (c(projection)) {
            if (f7.b(this.V)) {
                n();
            }
            J();
            ig igVar = this.I;
            if (igVar != null) {
                igVar.E();
                this.L = this.I.N() + "";
                if (this.Q) {
                    return;
                }
                rcVar.a(this.I.N(), p());
                this.Q = true;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        rc rcVar = this.U;
        if (rcVar == null) {
            return;
        }
        rcVar.h().b(this);
        PolygonInfo polygonInfo = this.H;
        if (polygonInfo != null) {
            this.U.c(polygonInfo.polygonId);
        }
        List<GeoPoint> list = this.B;
        if (list != null) {
            list.clear();
        }
        synchronized (this.J) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.a();
                this.K = null;
            }
        }
        if (this.I != null) {
            this.U.g().d(this.I);
            this.U.K();
            this.I = null;
        }
        this.P = false;
    }

    public void J() {
        PolygonInfo polygonInfo = this.H;
        if (-1 == polygonInfo.polygonId) {
            polygonInfo.polygonId = this.U.a(polygonInfo);
        } else if (C()) {
            this.U.b(this.H);
        }
    }

    public Rect K() {
        Rect rect = this.F;
        if (rect != null) {
            return rect;
        }
        List<GeoPoint> list = this.B;
        if (list == null || list.isEmpty() || this.B.size() < 3) {
            return null;
        }
        GeoPoint geoPoint = this.B.get(0);
        int latitudeE6 = geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint.getLongitudeE6();
        int size = this.B.size();
        int i = latitudeE6;
        int i2 = longitudeE6;
        for (int i3 = 1; i3 < size; i3++) {
            GeoPoint geoPoint2 = this.B.get(i3);
            int latitudeE62 = geoPoint2.getLatitudeE6();
            int longitudeE62 = geoPoint2.getLongitudeE6();
            longitudeE6 = Math.min(longitudeE6, longitudeE62);
            i2 = Math.max(i2, longitudeE62);
            latitudeE6 = Math.max(latitudeE6, latitudeE62);
            i = Math.min(i, latitudeE62);
        }
        Rect rect2 = new Rect(longitudeE6, latitudeE6, i2, i);
        this.F = rect2;
        return rect2;
    }

    public Rect M() {
        Rect rect = this.G;
        if (rect != null) {
            return rect;
        }
        List<GeoPoint> list = this.B;
        if (list == null || list.isEmpty() || this.B.size() < 3) {
            return null;
        }
        x5 a2 = this.U.getProjection().a(this.B.get(0).toLatLng());
        int x = (int) a2.x();
        int x2 = (int) a2.x();
        int y = (int) a2.y();
        int y2 = (int) a2.y();
        int size = this.B.size();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                Rect rect2 = new Rect(x, y, x2, y2);
                this.G = rect2;
                return rect2;
            }
            x5 a3 = this.U.getProjection().a(this.B.get(i2).toLatLng());
            x = (int) Math.min(x, a3.x());
            x2 = (int) Math.max(x2, a3.x());
            y = (int) Math.min(y, a3.y());
            y2 = (int) Math.max(y2, a3.y());
            i = i2 + 1;
        }
    }

    public Rect N() {
        if (this.U != null) {
            x5 a2 = this.U.getProjection().a(this.U.getProjection().a(new p5(0.0d, 0.0d)).toLatLng());
            x5 a3 = this.U.getProjection().a(this.U.getProjection().a(new p5(this.U.e().width(), this.U.e().height())).toLatLng());
            return new Rect((int) a2.x(), (int) a2.y(), (int) a3.x(), (int) a3.y());
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: O */
    public q0 x() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        Rect rect = new Rect();
        new Rect();
        if (this.H != null) {
            rect = K();
        }
        ig igVar = this.I;
        if (igVar != null) {
            Rect a2 = igVar.a(t4Var);
            rect.left = Math.min(rect.left, a2.left);
            rect.top = Math.min(rect.top, a2.top);
            rect.right = Math.max(rect.right, a2.right);
            rect.bottom = Math.max(rect.bottom, a2.bottom);
        }
        return rect;
    }

    @Override // com.tencent.mapsdk.internal.h5
    public void a(z5 z5Var) {
        rc rcVar;
        if (z5Var == z5.NO_CHANGED || (rcVar = this.U) == null) {
            return;
        }
        d(rcVar.getProjection());
    }

    @Override // com.tencent.mapsdk.internal.q0
    public void a(PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            return;
        }
        setFillColor(polygonOptions.getFillColor());
        setStrokeColor(polygonOptions.getStrokeColor());
        setStrokeWidth(polygonOptions.getStrokeWidth());
        setZIndex(polygonOptions.getZIndex());
        setVisible(polygonOptions.isVisible());
        setLevel(polygonOptions.getLevel());
        setClickable(polygonOptions.isClickable());
        setPoints(polygonOptions.getPoints());
        List<Integer> pattern = polygonOptions.getPattern();
        if (pattern != null && !pattern.isEmpty()) {
            int[] iArr = new int[pattern.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= pattern.size()) {
                    break;
                }
                iArr[i2] = pattern.get(i2).intValue();
                i = i2 + 1;
            }
            this.H.pattern = iArr;
        }
        BitmapDescriptor texture = polygonOptions.getTexture();
        if (this.W != texture) {
            this.W = texture;
            texture.getBitmap(this.U.getContext());
            this.H.textureName = this.W.getFormater().getBitmapId();
        }
        this.H.textureSpacing = polygonOptions.getTextureSpacing();
        B();
    }

    public void a(List<GeoPoint> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        List<GeoPoint> list2 = this.B;
        if (list2 == null) {
            this.B = new ArrayList();
        } else {
            list2.clear();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            GeoPoint geoPoint = list.get(i);
            if (geoPoint != null) {
                B();
                this.B.add(geoPoint);
            }
        }
    }

    public boolean a(Rect rect) {
        Rect rect2 = this.G;
        boolean z = false;
        if (rect2 != null) {
            z = false;
            if (rect != null) {
                z = false;
                if (rect2.right >= rect.left) {
                    z = false;
                    if (rect2.left <= rect.right) {
                        z = false;
                        if (rect2.bottom <= rect.top) {
                            z = false;
                            if (rect2.top >= rect.bottom) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public Rect getScreenBound(t4 t4Var) {
        Rect bound = getBound(t4Var);
        int i = bound.left;
        int i2 = bound.right;
        int i3 = bound.top;
        int i4 = bound.bottom;
        GeoPoint geoPoint = new GeoPoint(i3, i);
        GeoPoint geoPoint2 = new GeoPoint(i4, i);
        GeoPoint geoPoint3 = new GeoPoint(i4, i2);
        GeoPoint geoPoint4 = new GeoPoint(i3, i2);
        p5 a2 = t4Var.a(geoPoint);
        p5 a3 = t4Var.a(geoPoint2);
        p5 a4 = t4Var.a(geoPoint3);
        p5 a5 = t4Var.a(geoPoint4);
        return new Rect((int) Math.min(Math.min(a2.b, a3.b), Math.min(a4.b, a5.b)), (int) Math.min(Math.min(a2.f23992c, a3.f23992c), Math.min(a4.f23992c, a5.f23992c)), (int) Math.max(Math.max(a2.b, a3.b), Math.max(a4.b, a5.b)), (int) Math.max(Math.max(a2.f23992c, a3.f23992c), Math.max(a4.f23992c, a5.f23992c)));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public boolean contains(LatLng latLng) {
        boolean z;
        List<LatLng> points = getPoints();
        if (points == null || points.size() < 3 || latLng == null) {
            return false;
        }
        int size = points.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= points.size()) {
                int i3 = size - 1;
                int i4 = 0;
                boolean z2 = false;
                while (true) {
                    boolean z3 = z2;
                    if (i4 >= points.size()) {
                        return z3;
                    }
                    if (points.get(i4).latitude >= latLng.latitude || points.get(i3).latitude < latLng.latitude) {
                        z = z3;
                        if (points.get(i3).latitude < latLng.latitude) {
                            z = z3;
                            if (points.get(i4).latitude < latLng.latitude) {
                            }
                        }
                        i3 = i4;
                        i4++;
                        z2 = z;
                    }
                    if (points.get(i4).longitude > latLng.longitude) {
                        z = z3;
                        if (points.get(i3).longitude > latLng.longitude) {
                            i3 = i4;
                            i4++;
                            z2 = z;
                        }
                    }
                    z = z3 ^ (points.get(i4).longitude + (((latLng.latitude - points.get(i4).latitude) / (points.get(i3).latitude - points.get(i4).latitude)) * (points.get(i3).longitude - points.get(i4).longitude)) <= latLng.longitude);
                    i3 = i4;
                    i4++;
                    z2 = z;
                }
            } else if (points.get(i2).equals(latLng)) {
                return true;
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.q0
    public PolygonInfo e() {
        return this.H;
    }

    @Override // com.tencent.mapsdk.internal.q0
    public GeoPoint getCenter() {
        Rect K = K();
        return new GeoPoint(K.centerY(), K.centerX());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public List<LatLng> getPoints() {
        List<LatLng> list = this.C;
        return list != null ? list : fa.a(this.B);
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean handleOnTap() {
        return true;
    }

    @Override // com.tencent.mapsdk.internal.q0
    public List<GeoPoint> i() {
        ArrayList arrayList = new ArrayList(49);
        Rect K = K();
        int i = K.left;
        int i2 = K.top;
        int abs = Math.abs(K.width());
        int abs2 = Math.abs(K.height());
        double d = i;
        double d2 = abs;
        double d3 = i2;
        double d4 = abs2;
        int i3 = (int) (d3 - (0.125d * d4));
        int i4 = (int) (d - (d2 * 0.125d));
        GeoPoint geoPoint = new GeoPoint(new GeoPoint(i3, i4));
        if (a(geoPoint)) {
            arrayList.add(geoPoint);
        }
        int i5 = (int) (d3 - (0.25d * d4));
        GeoPoint geoPoint2 = new GeoPoint(new GeoPoint(i5, i4));
        if (a(geoPoint2)) {
            arrayList.add(geoPoint2);
        }
        int i6 = (int) (d3 - (0.375d * d4));
        GeoPoint geoPoint3 = new GeoPoint(new GeoPoint(i6, i4));
        if (a(geoPoint3)) {
            arrayList.add(geoPoint3);
        }
        int i7 = (int) (d3 - (0.5d * d4));
        GeoPoint geoPoint4 = new GeoPoint(new GeoPoint(i7, i4));
        if (a(geoPoint4)) {
            arrayList.add(geoPoint4);
        }
        int i8 = (int) (d3 - (0.625d * d4));
        GeoPoint geoPoint5 = new GeoPoint(new GeoPoint(i8, i4));
        if (a(geoPoint5)) {
            arrayList.add(geoPoint5);
        }
        int i9 = (int) (d3 - (0.75d * d4));
        GeoPoint geoPoint6 = new GeoPoint(new GeoPoint(i9, i4));
        if (a(geoPoint6)) {
            arrayList.add(geoPoint6);
        }
        int i10 = (int) (d3 - (d4 * 0.825d));
        GeoPoint geoPoint7 = new GeoPoint(new GeoPoint(i10, i4));
        if (a(geoPoint7)) {
            arrayList.add(geoPoint7);
        }
        int i11 = (int) (d - (d2 * 0.25d));
        GeoPoint geoPoint8 = new GeoPoint(new GeoPoint(i3, i11));
        if (a(geoPoint8)) {
            arrayList.add(geoPoint8);
        }
        GeoPoint geoPoint9 = new GeoPoint(new GeoPoint(i5, i11));
        if (a(geoPoint9)) {
            arrayList.add(geoPoint9);
        }
        GeoPoint geoPoint10 = new GeoPoint(new GeoPoint(i6, i11));
        if (a(geoPoint10)) {
            arrayList.add(geoPoint10);
        }
        GeoPoint geoPoint11 = new GeoPoint(new GeoPoint(i7, i11));
        if (a(geoPoint11)) {
            arrayList.add(geoPoint11);
        }
        GeoPoint geoPoint12 = new GeoPoint(new GeoPoint(i8, i11));
        if (a(geoPoint12)) {
            arrayList.add(geoPoint12);
        }
        GeoPoint geoPoint13 = new GeoPoint(new GeoPoint(i9, i11));
        if (a(geoPoint13)) {
            arrayList.add(geoPoint13);
        }
        GeoPoint geoPoint14 = new GeoPoint(new GeoPoint(i10, i11));
        if (a(geoPoint14)) {
            arrayList.add(geoPoint14);
        }
        int i12 = (int) (d - (d2 * 0.375d));
        GeoPoint geoPoint15 = new GeoPoint(new GeoPoint(i3, i12));
        if (a(geoPoint15)) {
            arrayList.add(geoPoint15);
        }
        GeoPoint geoPoint16 = new GeoPoint(new GeoPoint(i5, i12));
        if (a(geoPoint16)) {
            arrayList.add(geoPoint16);
        }
        GeoPoint geoPoint17 = new GeoPoint(new GeoPoint(i6, i12));
        if (a(geoPoint17)) {
            arrayList.add(geoPoint17);
        }
        GeoPoint geoPoint18 = new GeoPoint(new GeoPoint(i7, i12));
        if (a(geoPoint18)) {
            arrayList.add(geoPoint18);
        }
        GeoPoint geoPoint19 = new GeoPoint(new GeoPoint(i8, i12));
        if (a(geoPoint19)) {
            arrayList.add(geoPoint19);
        }
        GeoPoint geoPoint20 = new GeoPoint(new GeoPoint(i9, i12));
        if (a(geoPoint20)) {
            arrayList.add(geoPoint20);
        }
        GeoPoint geoPoint21 = new GeoPoint(new GeoPoint(i10, i12));
        if (a(geoPoint21)) {
            arrayList.add(geoPoint21);
        }
        int i13 = (int) (d - (d2 * 0.5d));
        GeoPoint geoPoint22 = new GeoPoint(new GeoPoint(i3, i13));
        if (a(geoPoint22)) {
            arrayList.add(geoPoint22);
        }
        GeoPoint geoPoint23 = new GeoPoint(new GeoPoint(i5, i13));
        if (a(geoPoint23)) {
            arrayList.add(geoPoint23);
        }
        GeoPoint geoPoint24 = new GeoPoint(new GeoPoint(i6, i13));
        if (a(geoPoint24)) {
            arrayList.add(geoPoint24);
        }
        GeoPoint geoPoint25 = new GeoPoint(new GeoPoint(i7, i13));
        if (a(geoPoint25)) {
            arrayList.add(geoPoint25);
        }
        GeoPoint geoPoint26 = new GeoPoint(new GeoPoint(i8, i13));
        if (a(geoPoint26)) {
            arrayList.add(geoPoint26);
        }
        GeoPoint geoPoint27 = new GeoPoint(new GeoPoint(i9, i13));
        if (a(geoPoint27)) {
            arrayList.add(geoPoint27);
        }
        GeoPoint geoPoint28 = new GeoPoint(new GeoPoint(i10, i13));
        if (a(geoPoint28)) {
            arrayList.add(geoPoint28);
        }
        int i14 = (int) (d - (d2 * 0.625d));
        GeoPoint geoPoint29 = new GeoPoint(new GeoPoint(i3, i14));
        if (a(geoPoint29)) {
            arrayList.add(geoPoint29);
        }
        GeoPoint geoPoint30 = new GeoPoint(new GeoPoint(i5, i14));
        if (a(geoPoint30)) {
            arrayList.add(geoPoint30);
        }
        GeoPoint geoPoint31 = new GeoPoint(new GeoPoint(i6, i14));
        if (a(geoPoint31)) {
            arrayList.add(geoPoint31);
        }
        GeoPoint geoPoint32 = new GeoPoint(new GeoPoint(i7, i14));
        if (a(geoPoint32)) {
            arrayList.add(geoPoint32);
        }
        GeoPoint geoPoint33 = new GeoPoint(new GeoPoint(i8, i14));
        if (a(geoPoint33)) {
            arrayList.add(geoPoint33);
        }
        GeoPoint geoPoint34 = new GeoPoint(new GeoPoint(i9, i14));
        if (a(geoPoint34)) {
            arrayList.add(geoPoint34);
        }
        GeoPoint geoPoint35 = new GeoPoint(new GeoPoint(i10, i14));
        if (a(geoPoint35)) {
            arrayList.add(geoPoint35);
        }
        int i15 = (int) (d - (d2 * 0.75d));
        GeoPoint geoPoint36 = new GeoPoint(new GeoPoint(i3, i15));
        if (a(geoPoint36)) {
            arrayList.add(geoPoint36);
        }
        GeoPoint geoPoint37 = new GeoPoint(new GeoPoint(i5, i15));
        if (a(geoPoint37)) {
            arrayList.add(geoPoint37);
        }
        GeoPoint geoPoint38 = new GeoPoint(new GeoPoint(i6, i15));
        if (a(geoPoint38)) {
            arrayList.add(geoPoint38);
        }
        GeoPoint geoPoint39 = new GeoPoint(new GeoPoint(i7, i15));
        if (a(geoPoint39)) {
            arrayList.add(geoPoint39);
        }
        GeoPoint geoPoint40 = new GeoPoint(new GeoPoint(i8, i15));
        if (a(geoPoint40)) {
            arrayList.add(geoPoint40);
        }
        GeoPoint geoPoint41 = new GeoPoint(new GeoPoint(i9, i15));
        if (a(geoPoint41)) {
            arrayList.add(geoPoint41);
        }
        GeoPoint geoPoint42 = new GeoPoint(new GeoPoint(i10, i15));
        if (a(geoPoint42)) {
            arrayList.add(geoPoint42);
        }
        int i16 = (int) (d - (d2 * 0.825d));
        GeoPoint geoPoint43 = new GeoPoint(new GeoPoint(i3, i16));
        if (a(geoPoint43)) {
            arrayList.add(geoPoint43);
        }
        GeoPoint geoPoint44 = new GeoPoint(new GeoPoint(i5, i16));
        if (a(geoPoint44)) {
            arrayList.add(geoPoint44);
        }
        GeoPoint geoPoint45 = new GeoPoint(new GeoPoint(i6, i16));
        if (a(geoPoint45)) {
            arrayList.add(geoPoint45);
        }
        GeoPoint geoPoint46 = new GeoPoint(new GeoPoint(i7, i16));
        if (a(geoPoint46)) {
            arrayList.add(geoPoint46);
        }
        GeoPoint geoPoint47 = new GeoPoint(new GeoPoint(i8, i16));
        if (a(geoPoint47)) {
            arrayList.add(geoPoint47);
        }
        GeoPoint geoPoint48 = new GeoPoint(new GeoPoint(i9, i16));
        if (a(geoPoint48)) {
            arrayList.add(geoPoint48);
        }
        GeoPoint geoPoint49 = new GeoPoint(new GeoPoint(i10, i16));
        if (a(geoPoint49)) {
            arrayList.add(geoPoint49);
        }
        return arrayList;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public boolean isSelected() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.q4
    public void n() {
        List<GeoPoint> list;
        if (this.U == null) {
            return;
        }
        if ((this.H.polygonId >= 0 && !C()) || (list = this.B) == null || list.size() <= 2) {
            return;
        }
        PolygonInfo polygonInfo = this.H;
        polygonInfo.color = this.k;
        polygonInfo.borderColor = this.l;
        polygonInfo.borderWidth = this.j;
        polygonInfo.zIndex = getZIndex();
        this.H.level = getLevel();
        int size = this.B.size();
        this.H.points = new LatLng[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.U.w0();
                B();
                return;
            }
            this.H.points[i2] = this.B.get(i2).toLatLng();
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        if (this.U == null || !isVisible()) {
            return false;
        }
        M();
        if (a(N())) {
            return a(this.U.getProjection().a(this.U.getProjection().a(new p5(f, f2)).toLatLng()));
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.q0
    public int p() {
        PolygonInfo polygonInfo = this.H;
        if (polygonInfo == null) {
            return -1;
        }
        return polygonInfo.polygonId;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public void setOptions(PolygonOptions polygonOptions) {
        a(polygonOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public void setPoints(List<LatLng> list) {
        int size;
        GeoPoint from;
        this.C = list;
        if (list == null || (size = list.size()) <= 0) {
            return;
        }
        PolygonOptions polygonOptions = this.T;
        if (polygonOptions != null) {
            polygonOptions.setPoints(new ArrayList(list));
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                a(arrayList);
                return;
            }
            LatLng latLng = list.get(i2);
            if (latLng != null && (from = GeoPoint.from(latLng)) != null) {
                arrayList.add(from);
            }
            i = i2 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelected(boolean z) {
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable
    public void setSelectedListener(Selectable.OnSelectedListener onSelectedListener) {
    }
}
