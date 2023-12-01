package com.tencent.mapsdk.vector;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.a0;
import com.tencent.mapsdk.internal.a5;
import com.tencent.mapsdk.internal.a9;
import com.tencent.mapsdk.internal.ah;
import com.tencent.mapsdk.internal.b1;
import com.tencent.mapsdk.internal.b5;
import com.tencent.mapsdk.internal.c0;
import com.tencent.mapsdk.internal.d0;
import com.tencent.mapsdk.internal.d5;
import com.tencent.mapsdk.internal.de;
import com.tencent.mapsdk.internal.dg;
import com.tencent.mapsdk.internal.e0;
import com.tencent.mapsdk.internal.e5;
import com.tencent.mapsdk.internal.f0;
import com.tencent.mapsdk.internal.f5;
import com.tencent.mapsdk.internal.fj;
import com.tencent.mapsdk.internal.g1;
import com.tencent.mapsdk.internal.g5;
import com.tencent.mapsdk.internal.ga;
import com.tencent.mapsdk.internal.gj;
import com.tencent.mapsdk.internal.h1;
import com.tencent.mapsdk.internal.h5;
import com.tencent.mapsdk.internal.j5;
import com.tencent.mapsdk.internal.j8;
import com.tencent.mapsdk.internal.k1;
import com.tencent.mapsdk.internal.k5;
import com.tencent.mapsdk.internal.k8;
import com.tencent.mapsdk.internal.kf;
import com.tencent.mapsdk.internal.l1;
import com.tencent.mapsdk.internal.l4;
import com.tencent.mapsdk.internal.l5;
import com.tencent.mapsdk.internal.le;
import com.tencent.mapsdk.internal.m5;
import com.tencent.mapsdk.internal.ma;
import com.tencent.mapsdk.internal.mc;
import com.tencent.mapsdk.internal.mf;
import com.tencent.mapsdk.internal.na;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.o1;
import com.tencent.mapsdk.internal.pe;
import com.tencent.mapsdk.internal.qc;
import com.tencent.mapsdk.internal.rc;
import com.tencent.mapsdk.internal.t4;
import com.tencent.mapsdk.internal.te;
import com.tencent.mapsdk.internal.th;
import com.tencent.mapsdk.internal.u4;
import com.tencent.mapsdk.internal.v;
import com.tencent.mapsdk.internal.v4;
import com.tencent.mapsdk.internal.w;
import com.tencent.mapsdk.internal.w0;
import com.tencent.mapsdk.internal.w4;
import com.tencent.mapsdk.internal.x;
import com.tencent.mapsdk.internal.x4;
import com.tencent.mapsdk.internal.y4;
import com.tencent.mapsdk.internal.yf;
import com.tencent.mapsdk.internal.z3;
import com.tencent.mapsdk.internal.z4;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.MapParamConstants;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapFontSize;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/vector/VectorMap.class */
public class VectorMap extends o1 {
    public static final int A = 5;
    public static final int B = 11;
    public static final int C = 15;
    public static final int D = 18;
    public static final float E = MapParamConstants.MAX_SKEW_ANGLE;
    public static final int F = 0;
    public static final int G = 1;
    public static final int H = 2;
    private static final int I = 1;
    private static final int J = 2;
    private static final int K = 3;
    public static final int L = 0;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static final int v = 0;
    public static final int w = 1;
    public static final int x = 2;
    public static final int y = 3;
    public static final int z = 4;
    private rc b;
    private h1 d;
    private a0 i;
    private kf l;
    private UiSettings o;
    private boolean p;
    private TencentMapPro q;
    private gj r;
    private float s;

    /* renamed from: a  reason: collision with root package name */
    private boolean f24477a = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24478c = true;
    private mf e = null;
    private g1 f = null;
    private f0 g = null;
    private Projection h = null;
    private c0 j = null;
    private e0 k = null;
    private boolean m = false;
    private boolean n = false;
    private GeoPoint t = new GeoPoint();
    private int u = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/vector/VectorMap$a.class */
    public class a implements l1.d {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.l1.d
        public void a() {
            VectorMap.this.setMyLocationEnabled(true);
            Location myLocation = VectorMap.this.getMyLocation();
            if (myLocation != null) {
                VectorMap.this.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(myLocation.getLatitude(), myLocation.getLongitude())));
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/vector/VectorMap$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VectorMap.this.b.a(false, true, false, false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/vector/VectorMap$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24480a;

        static {
            Language.values();
            int[] iArr = new int[2];
            f24480a = iArr;
            try {
                Language language = Language.en;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f24480a;
                Language language2 = Language.zh;
                iArr2[0] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public VectorMap(rc rcVar) {
        this.b = rcVar;
    }

    private boolean a(float f, float f2) {
        kf kfVar;
        TappedElement e = e(f, f2);
        if (e == null || (kfVar = this.l) == null) {
            return false;
        }
        return kfVar.a(e);
    }

    private boolean b(float f, float f2) {
        return this.b.g().c(f, f2);
    }

    private boolean c(float f, float f2) {
        g1 g1Var = this.f;
        if (g1Var != null) {
            return g1Var.a(f, f2);
        }
        return false;
    }

    public static boolean c(int i, int i2) {
        return GeometryConstants.BOUNDARY_WORLD.contains(i2, i);
    }

    private void d0() {
        if (this.f == null) {
            this.f = new g1(this.b, this.i);
        }
        if (this.j == null) {
            this.j = new c0(this.f);
        }
    }

    public static boolean e(GeoPoint geoPoint) {
        return l4.e.contains(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
    }

    public static boolean f(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return false;
        }
        return c(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
    }

    private int p(int i) {
        int i2 = i;
        if (i < 3) {
            i2 = 3;
        }
        int i3 = i2;
        if (i2 > 22) {
            i3 = 22;
        }
        return i3;
    }

    private void r0() {
        e0 e0Var = this.k;
        if (e0Var != null) {
            e0Var.a();
            this.k = null;
        }
        c0 c0Var = this.j;
        if (c0Var != null) {
            c0Var.c();
            this.j = null;
        }
        a0 a0Var = this.i;
        if (a0Var != null) {
            a0Var.a();
            this.i = null;
        }
        if (this.h != null) {
            this.h = null;
        }
        f0 f0Var = this.g;
        if (f0Var != null) {
            f0Var.a();
            this.g = null;
        }
    }

    private void s0() {
        g1 g1Var = this.f;
        if (g1Var != null) {
            g1Var.e();
            this.f = null;
        }
        h1 h1Var = this.d;
        if (h1Var != null) {
            h1Var.i();
            this.d = null;
        }
    }

    public float A() {
        return this.b.h().j();
    }

    public void A0() {
        this.b.h().P();
    }

    public Rect B() {
        return this.b.Q();
    }

    public void B0() {
        this.b.h().Q();
    }

    public String[] C() {
        return this.b.R();
    }

    public void C0() {
        this.b.h().R();
    }

    public g1 D() {
        return this.f;
    }

    public void D0() {
        this.b.D0();
    }

    public int E() {
        return this.u;
    }

    public void E0() {
        this.b.E0();
    }

    public qc F() {
        return this.b.U();
    }

    public rc G() {
        return this.b;
    }

    public String H() {
        rc rcVar = this.b;
        if (rcVar == null) {
            return null;
        }
        return rcVar.W();
    }

    public String I() {
        rc rcVar = this.b;
        if (rcVar == null) {
            return null;
        }
        return rcVar.X();
    }

    public String J() {
        rc rcVar = this.b;
        if (rcVar != null) {
            return rcVar.p();
        }
        return null;
    }

    public Language K() {
        return this.b.T();
    }

    public h1 L() {
        return this.d;
    }

    public v M() {
        return this.b.b();
    }

    public ArrayList<MapPoi> N() {
        rc rcVar = this.b;
        if (rcVar == null) {
            return null;
        }
        return rcVar.Y();
    }

    public Rect O() {
        return this.b.h().n();
    }

    public int P() {
        return this.b.b().g();
    }

    public int Q() {
        return this.b.b().h();
    }

    public int R() {
        return this.b.b().j();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    /* renamed from: S */
    public t4 getProjection() {
        rc rcVar;
        return (this.m || (rcVar = this.b) == null) ? new x() : rcVar.getProjection();
    }

    public float T() {
        return this.b.h().p();
    }

    public float U() {
        return this.b.h().q();
    }

    public int V() {
        return this.b.h().r();
    }

    public GeoPoint W() {
        return this.b.h().t();
    }

    public Rect X() {
        return this.b.e();
    }

    public GeoPoint Y() {
        return this.b.h().u();
    }

    public float Z() {
        return this.b.h().v();
    }

    public double a(Rect rect, Rect rect2) {
        return this.b.h().b(rect, rect2);
    }

    public float a(double d, GeoPoint geoPoint) {
        if (geoPoint == null) {
            return 0.0f;
        }
        return this.b.a(d, geoPoint);
    }

    public int a(int i, int i2, int i3, int i4, int i5, float f) {
        return this.b.a(i, i2, i3, i4, i5, f);
    }

    public int a(int i, int i2, int i3, int i4, boolean z2) {
        return this.b.h().a(i, i2, i3, i4, z2);
    }

    @Deprecated
    public int a(TileOverlayCallback tileOverlayCallback, boolean z2) {
        return this.b.a(tileOverlayCallback, z2);
    }

    public int a(PolygonInfo polygonInfo) {
        return this.b.a(polygonInfo);
    }

    public int a(String str) {
        rc rcVar = this.b;
        if (rcVar == null) {
            return -1;
        }
        return rcVar.a(str);
    }

    public AnnocationTextResult a(AnnocationText annocationText) {
        return this.b.a(annocationText);
    }

    public k8 a(int i, Object obj, Object obj2) {
        return this.b.h().a(i, obj, obj2);
    }

    public String a(GeoPoint geoPoint) {
        return this.b.a(geoPoint);
    }

    public List<Integer> a(Rect rect, int i) {
        return this.b.a(rect, i);
    }

    public void a(double d) {
        this.b.h().l(d);
    }

    public void a(double d, double d2) {
        this.b.h().b(d, d2);
    }

    public void a(double d, double d2, double d3, double d4, double d5, Runnable runnable) {
        this.b.h().a(d, d2, d3, d4, d5, runnable);
    }

    public void a(float f) {
        this.s = f;
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.a(f);
            if (this.u != 2 || b0()) {
                return;
            }
            a(this.s);
        }
    }

    public void a(float f, float f2, float f3, float f4) {
        this.b.S().a(f, f2, f3, f4);
    }

    public void a(float f, float f2, int i, boolean z2) {
        this.b.h().b(true);
        this.b.h().a(f, f2, z2);
    }

    public void a(float f, float f2, boolean z2) {
        this.b.h().a(f, f2, 0, z2);
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void a(int i) {
        super.a(i);
        if (this.m || this.b == null) {
            return;
        }
        na.a(ma.f, "setIndoorConfigType:" + i);
        this.b.i(i);
    }

    public void a(int i, float f) {
        this.b.h().a(i, f, true);
    }

    public void a(int i, int i2) {
        this.b.a(i, i2);
    }

    @Deprecated
    public void a(int i, int i2, int i3) {
        this.b.b(i, i2, i3);
    }

    public void a(int i, int i2, int i3, int i4) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.a(i, i2, i3, i4);
        }
    }

    public void a(int i, GeoPoint geoPoint, Runnable runnable, j8 j8Var) {
        this.b.h().b(geoPoint, i, runnable);
    }

    public void a(Rect rect) {
        this.b.h().a(rect);
    }

    public void a(Rect rect, int i, int i2, k5 k5Var) {
        rc rcVar = this.b;
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = w();
        }
        rcVar.a(rect2, i, i2, k5Var);
    }

    public void a(Rect rect, Rect rect2, Runnable runnable, j8 j8Var) {
        this.b.h().a(rect, rect2, runnable, j8Var);
    }

    public void a(GeoPoint geoPoint, float f, float f2, boolean z2) {
        this.s = f;
        this.t.setLatitudeE6(geoPoint.getLatitudeE6());
        this.t.setLongitudeE6(geoPoint.getLongitudeE6());
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.a(this.t, this.s, f2, z2);
            int i = this.u;
            if (i == 1 || i == 2) {
                a(this.t, (Runnable) null);
            }
            if (this.u != 2 || b0()) {
                return;
            }
            a(this.s);
        }
    }

    public void a(GeoPoint geoPoint, float f, Runnable runnable) {
        this.b.h().a(geoPoint, f, runnable);
    }

    public void a(GeoPoint geoPoint, int i, Runnable runnable) {
        this.b.h().a(geoPoint, i, runnable);
    }

    public void a(GeoPoint geoPoint, Rect rect) {
        this.b.h().a(geoPoint, rect);
    }

    public void a(GeoPoint geoPoint, RectF rectF, boolean z2) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.a(geoPoint, rectF, z2);
        }
    }

    public void a(GeoPoint geoPoint, j8 j8Var) {
        this.b.h().a(geoPoint, j8Var);
    }

    public void a(GeoPoint geoPoint, Runnable runnable) {
        b(geoPoint, V(), runnable);
    }

    public void a(GeoPoint geoPoint, Runnable runnable, j8 j8Var) {
        this.b.h().a(geoPoint, runnable, j8Var);
    }

    public void a(a5 a5Var) {
        this.b.g().a(a5Var);
    }

    public void a(a9 a9Var) {
        this.b.h().b(a9Var);
    }

    public void a(ah ahVar) {
        this.b.a(ahVar);
    }

    public void a(b1 b1Var) {
        this.b.h().a(b1Var);
    }

    public void a(b5 b5Var) {
        this.b.h().a(b5Var);
    }

    public void a(d0.h hVar) {
        this.b.h().a(hVar);
    }

    public void a(d5 d5Var) {
        this.b.a(d5Var);
    }

    public void a(de deVar) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.a(deVar);
        }
    }

    public void a(e5 e5Var) {
        this.b.h().a(e5Var);
    }

    public void a(f5 f5Var) {
        this.b.h().a(f5Var);
    }

    public void a(g5 g5Var) {
        this.b.h().a(g5Var);
    }

    public void a(h5 h5Var) {
        this.b.h().a(h5Var);
    }

    public void a(j5 j5Var) {
        this.b.h().a(j5Var);
    }

    public void a(l5 l5Var) {
        this.b.h().a(l5Var);
    }

    public void a(le leVar) {
        this.b.a(leVar);
    }

    public void a(m5 m5Var) {
        this.b.h().a(m5Var);
    }

    public void a(ne neVar) {
        this.b.a(neVar);
    }

    public void a(pe peVar) {
        rc rcVar = this.b;
        if (rcVar == null) {
            return;
        }
        rcVar.a(peVar);
    }

    public void a(te teVar) {
        this.b.h().a(teVar);
    }

    public void a(u4 u4Var) {
        this.b.g().a(u4Var);
        this.b.K();
    }

    public void a(u4 u4Var, int i, int i2, k5 k5Var) {
        this.b.a(u4Var, i, i2, k5Var);
    }

    public void a(u4 u4Var, u4 u4Var2) {
        synchronized (this) {
            this.b.g().a(u4Var, u4Var2);
            this.b.K();
        }
    }

    public void a(v4 v4Var) {
        this.b.g().a(v4Var);
    }

    public void a(w4 w4Var) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.a(w4Var);
        }
    }

    public void a(x4 x4Var) {
        this.b.g().a(x4Var);
    }

    public void a(y4 y4Var) {
        this.b.g().a(y4Var);
    }

    public void a(yf yfVar) {
        this.b.h().a(yfVar);
    }

    public void a(z4 z4Var) {
        this.b.h().a(z4Var);
    }

    public void a(Language language) {
        this.b.a(language);
    }

    public void a(LatLngBounds latLngBounds, int i) {
        rc rcVar = this.b;
        if (rcVar == null) {
            return;
        }
        rcVar.a(latLngBounds, i);
    }

    public void a(Runnable runnable) {
        this.b.h().a(runnable);
    }

    public void a(List<MapRouteSection> list, List<GeoPoint> list2) {
        this.b.a(list, list2);
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void a(boolean z2) {
        h1 h1Var;
        if (this.m || (h1Var = this.d) == null) {
            return;
        }
        h1Var.d(z2);
    }

    public void a(String[] strArr) {
        this.b.a(strArr);
    }

    public boolean a(String str, byte[] bArr) {
        w a0 = this.b.a0();
        if (a0 == null) {
            return false;
        }
        return a0.a(str, bArr);
    }

    public int a0() {
        return this.b.h().l().w();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public AoiLayer addAoiLayer(String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener) {
        kf kfVar;
        if (this.m || (kfVar = this.l) == null) {
            return null;
        }
        AoiLayer a2 = kfVar.a(str, aoiLayerOptions, onAoiLayerLoadListener);
        v0();
        return a2;
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Arc addArc(ArcOptions arcOptions) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null || arcOptions == null) {
            return null;
        }
        return rcVar.Z().a(arcOptions);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Circle addCircle(CircleOptions circleOptions) {
        rc rcVar;
        if (this.m || circleOptions == null || (rcVar = this.b) == null) {
            return null;
        }
        return rcVar.Z().a(circleOptions);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions) {
        a0 a0Var;
        super.addCustomLayer(customLayerOptions);
        if (this.m || (a0Var = this.i) == null) {
            return null;
        }
        return a0Var.a(customLayerOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null || groundOverlayOptions == null) {
            return null;
        }
        GroundOverlay a2 = rcVar.a(groundOverlayOptions);
        v0();
        return a2;
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Marker addMarker(MarkerOptions markerOptions) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null || markerOptions == null) {
            return null;
        }
        return rcVar.Z().a(markerOptions);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        a0 a0Var;
        super.addOnMapLoadedCallback(onMapLoadedCallback);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onMapLoadedCallback);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polygon addPolygon(PolygonOptions polygonOptions) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null || polygonOptions == null) {
            return null;
        }
        return rcVar.Z().a(polygonOptions);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polyline addPolyline(PolylineOptions polylineOptions) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null || polylineOptions == null) {
            return null;
        }
        return rcVar.Z().a(polylineOptions);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        a0 a0Var;
        super.addTencentMapGestureListener(tencentMapGestureListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        a0 a0Var;
        super.addTileOverlay(tileOverlayOptions);
        if (this.m || (a0Var = this.i) == null) {
            return null;
        }
        return a0Var.a(tileOverlayOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public VectorHeatOverlay addVectorHeatOverlay(VectorHeatOverlayOptions vectorHeatOverlayOptions) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null) {
            return null;
        }
        VectorHeatOverlay a2 = rcVar.a(vectorHeatOverlayOptions);
        v0();
        return a2;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public <L extends VectorOverlay> L addVectorOverlay(VectorOverlayProvider vectorOverlayProvider) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null) {
            return null;
        }
        L l = (L) rcVar.a(vectorOverlayProvider);
        v0();
        return l;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public VisualLayer addVisualLayer(VisualLayerOptions visualLayerOptions) {
        z3 z3Var = (z3) getMapComponent(z3.class);
        if (z3Var != null) {
            return z3Var.a(visualLayerOptions);
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate) {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null || a0Var.m()) {
            return;
        }
        this.i.a(cameraUpdate, 500L, (TencentMap.CancelableCallback) null);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate, long j, TencentMap.CancelableCallback cancelableCallback) {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null || a0Var.m()) {
            return;
        }
        this.i.a(cameraUpdate, j, cancelableCallback);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate, TencentMap.CancelableCallback cancelableCallback) {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null || a0Var.m()) {
            return;
        }
        this.i.a(cameraUpdate, 500L, cancelableCallback);
    }

    public dg b(GeoPoint geoPoint) {
        return this.b.S().b(geoPoint);
    }

    public void b(double d) {
        this.b.h().n(d);
    }

    public void b(float f) {
        this.b.h().a(f);
    }

    public void b(float f, float f2, boolean z2) {
        this.b.h().a(f, f2, z2);
    }

    public void b(int i) {
        this.b.h().a(i);
    }

    public void b(int i, float f) {
        this.b.a(i, f);
    }

    public void b(int i, int i2) {
        this.b.b(i, i2);
    }

    public void b(Rect rect) {
        this.b.h().b(rect);
    }

    public void b(Rect rect, Rect rect2) {
        this.b.h().c(rect, rect2);
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void b(Bundle bundle) {
        super.b(bundle);
        this.r = (gj) this.b.j();
        th.b().a(this.b.getContext());
        k1.a().a(this.b.V());
        h1 h1Var = new h1(this.b, this.r.getMapRenderView(), this.b.r());
        this.d = h1Var;
        this.g = new f0(h1Var);
        this.i = new a0(this.d);
        this.q = new TencentMapPro(this.d, this.g);
        this.l = new kf(this.b);
        this.k = new e0(this.d.n());
        this.d.a(new a());
        this.d.a(this.b.g(), this.b.r());
        mf mfVar = new mf(this.d);
        this.e = mfVar;
        mfVar.a(this.b.g(), this.b.r());
        this.e.b();
        addOnMapLoadedCallback(this.b.r().getOnMapLoadedCallback());
        this.p = true;
    }

    public void b(GeoPoint geoPoint, int i, Runnable runnable) {
        this.b.h().c(geoPoint, i, runnable);
    }

    public void b(PolygonInfo polygonInfo) {
        this.b.b(polygonInfo);
    }

    public void b(a5 a5Var) {
        this.b.g().a((a5) null);
    }

    public void b(ah ahVar) {
        this.b.b(ahVar);
    }

    public void b(b1 b1Var) {
        this.b.h().b(b1Var);
    }

    public void b(b5 b5Var) {
        this.b.h().b(b5Var);
    }

    public void b(d5 d5Var) {
        this.b.b(d5Var);
    }

    public void b(e5 e5Var) {
        this.b.h().b(e5Var);
    }

    public void b(f5 f5Var) {
        this.b.h().b(f5Var);
    }

    public void b(g5 g5Var) {
        this.b.h().b(g5Var);
    }

    public void b(h5 h5Var) {
        this.b.h().b(h5Var);
    }

    public void b(j5 j5Var) {
        this.b.h().b(j5Var);
    }

    public void b(l5 l5Var) {
        this.b.h().b(l5Var);
    }

    public void b(m5 m5Var) {
        this.b.h().b(m5Var);
    }

    public void b(ne neVar) {
        this.b.b(neVar);
    }

    public void b(te teVar) {
        this.b.h().b(teVar);
    }

    public void b(u4 u4Var) {
        this.b.g().b(u4Var);
        this.b.K();
    }

    public void b(u4 u4Var, u4 u4Var2) {
        synchronized (this) {
            this.b.g().b(u4Var, u4Var2);
            this.b.K();
        }
    }

    public void b(w4 w4Var) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.b(w4Var);
        }
    }

    public void b(x4 x4Var) {
        this.b.g().b(x4Var);
    }

    public void b(z4 z4Var) {
        this.b.h().b(z4Var);
    }

    public void b(Runnable runnable) {
        this.b.h().b(runnable);
    }

    public void b(boolean z2) {
        this.f24478c = z2;
        this.b.e(z2);
    }

    public boolean b(String str) {
        return this.b.b(str);
    }

    public boolean b(String str, byte[] bArr) {
        w a0 = this.b.a0();
        if (a0 == null) {
            return false;
        }
        return a0.b(str, bArr);
    }

    public boolean b0() {
        return this.b.h().w();
    }

    public String c(GeoPoint geoPoint) {
        return this.b.b(geoPoint);
    }

    public void c(double d) {
        this.b.h().e(d);
    }

    public void c(float f) {
        this.b.h().b(f);
    }

    public void c(int i) {
        this.b.c(i);
    }

    public void c(u4 u4Var) {
        this.b.g().c(u4Var);
        this.b.K();
    }

    public void c(String str) {
        this.b.d(str);
    }

    public void c(boolean z2) {
        this.f24477a = z2;
    }

    public boolean c0() {
        return this.b.g0();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CameraPosition calculateZoomToSpanLevel(List<IOverlay> list, List<LatLng> list2, int i, int i2, int i3, int i4) {
        ArrayList arrayList = null;
        if (this.m || this.i == null) {
            return null;
        }
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i3);
        int abs4 = Math.abs(i4);
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<IOverlay> it = list.iterator();
            while (true) {
                arrayList = arrayList2;
                if (!it.hasNext()) {
                    break;
                }
                IOverlay next = it.next();
                if (next instanceof u4) {
                    arrayList2.add((u4) next);
                }
            }
        }
        return this.i.a(arrayList, list2, abs, abs2, abs3, abs4);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clear() {
        super.clear();
        clearAllOverlays();
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearAllOverlays() {
        gj gjVar;
        super.clearAllOverlays();
        if (this.m || (gjVar = this.r) == null) {
            return;
        }
        gjVar.E();
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearCache() {
        super.clearCache();
        ga.e(mc.b(getMapContext().getContext()).b());
    }

    public void clearRouteNameSegments() {
        this.b.I();
    }

    public float d(int i) {
        return this.b.h().l().a(i);
    }

    public void d(float f) {
        this.b.h().c(f);
    }

    public void d(int i, int i2) {
        this.b.h().a(i, i2);
    }

    public void d(u4 u4Var) {
        this.b.g().d(u4Var);
        this.b.K();
    }

    public void d(String str) {
        this.b.S().i(str);
    }

    public void d(boolean z2) {
        this.b.h(z2);
    }

    public boolean d(float f, float f2) {
        return b(f, f2) || c(f, f2) || a(f, f2);
    }

    public boolean d(GeoPoint geoPoint) {
        return this.b.h().b(geoPoint);
    }

    public TappedElement e(float f, float f2) {
        return this.b.a(f, f2);
    }

    @Deprecated
    public void e(int i) {
        this.b.e(i);
    }

    public void e(int i, int i2) {
        this.b.h().b(i, i2);
    }

    public void e(String str) {
        this.b.f(str);
    }

    public void e(boolean z2) {
        this.b.S().j(z2);
    }

    public boolean e0() {
        return this.b.h().B();
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableAutoMaxSkew(boolean z2) {
        rc rcVar;
        super.enableAutoMaxSkew(z2);
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.b().a(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableMultipleInfowindow(boolean z2) {
        a0 a0Var;
        super.enableMultipleInfowindow(z2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(z2);
    }

    public void f(float f, float f2) {
        this.b.h().a(f, f2, 0, true);
    }

    public void f(int i) {
        this.b.f(i);
    }

    public void f(int i, int i2) {
        this.b.c(i, i2);
    }

    public void f(String str) {
        this.b.g(str);
    }

    public void f(boolean z2) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.q(z2);
        }
    }

    public boolean f0() {
        return this.f24477a;
    }

    public void g(float f, float f2) {
        this.b.h().a(f, f2, true);
    }

    @Deprecated
    public void g(int i) {
        this.b.g(i);
    }

    public void g(int i, int i2) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.e(i, i2);
        }
    }

    public void g(GeoPoint geoPoint) {
        if (f(geoPoint)) {
            this.b.h().a(geoPoint);
        }
    }

    public void g(boolean z2) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.s(z2);
        }
    }

    @Override // com.tencent.mapsdk.internal.o1
    public boolean g() {
        return (!this.p || this.n || this.m) ? false : true;
    }

    public boolean g0() {
        return this.b.j0();
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public String getActivedIndoorBuilding(LatLng latLng) {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return null;
        }
        return a0Var.b(latLng);
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public String[] getActivedIndoorFloorNames() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return null;
        }
        return a0Var.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public List<LatLng> getBounderPoints(Marker marker) {
        rc rcVar;
        w0 w0Var;
        if (marker == null || (rcVar = this.b) == null || (w0Var = (w0) rcVar.Z().a(marker.getId(), w0.class)) == null) {
            return null;
        }
        return w0Var.x().v();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CameraPosition getCameraPosition() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return null;
        }
        return a0Var.b();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String getCityName(LatLng latLng) {
        a0 a0Var;
        return (this.m || (a0Var = this.i) == null) ? "" : a0Var.a(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String getDebugError() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return null;
        }
        return a0Var.c();
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public int getIndoorFloorId() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return -1;
        }
        return a0Var.d();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public MapLanguage getLanguage() {
        return this.b.T().ordinal() != 1 ? MapLanguage.LAN_CHINESE : MapLanguage.LAN_ENGLISH;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public TencentMapContext getMapContext() {
        return this.b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapHeight() {
        return this.b.j().getMapRenderView().getHeight();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Rect getMapPadding() {
        return this.b.h().k();
    }

    public TencentMapPro getMapPro() {
        return this.q;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapStyle() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return 0;
        }
        return a0Var.g();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapType() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return 1000;
        }
        return a0Var.h();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public int getMapWidth() {
        return this.b.j().getMapRenderView().getWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public float getMaxZoomLevel() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return 0.0f;
        }
        return a0Var.i();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public float getMinZoomLevel() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return 0.0f;
        }
        return a0Var.j();
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public Location getMyLocation() {
        if (this.m) {
            return null;
        }
        d0();
        return this.j.d();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public UiSettings getUiSettings() {
        if (this.m) {
            return null;
        }
        if (this.o == null) {
            this.o = new fj(this.k);
        }
        return this.o;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String getVersion() {
        a0 a0Var;
        return (this.m || (a0Var = this.i) == null) ? "" : a0Var.k();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return 0.0f;
        }
        if (latLng == null || latLng2 == null) {
            return -1.0f;
        }
        return a0Var.a(latLng, latLng2);
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void h() {
        super.h();
        if (this.m) {
            return;
        }
        a0 a0Var = this.i;
        if (a0Var != null) {
            a0Var.o();
        }
        mf mfVar = this.e;
        if (mfVar != null) {
            mfVar.a();
        }
        kf kfVar = this.l;
        if (kfVar != null) {
            kfVar.c();
        }
        th.b().c();
        r0();
        s0();
        this.m = true;
    }

    public void h(float f, float f2) {
        rc rcVar = this.b;
        if (rcVar != null) {
            rcVar.h().b(f, f2);
        }
    }

    public void h(int i) {
        this.b.h().g().b(i);
    }

    @Deprecated
    public void h(int i, int i2) {
        this.b.g(i, i2);
    }

    public void h(GeoPoint geoPoint) {
        this.b.h().b(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
    }

    public void h(boolean z2) {
        this.b.j(z2);
    }

    public boolean h0() {
        return this.f24478c;
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void i() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.p();
        this.n = true;
    }

    public void i(int i) {
        this.b.k(i);
    }

    public void i(int i, int i2) {
        this.b.i(i, i2);
    }

    public void i(boolean z2) {
        this.b.l(z2);
    }

    public boolean i0() {
        return this.b.d0().c();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isBlockRouteEnabled() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isDestroyed() {
        return this.m;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isHandDrawMapEnable() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return false;
        }
        return a0Var.l();
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public boolean isMyLocationEnabled() {
        if (this.m) {
            return false;
        }
        d0();
        return this.j.e();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isSateLiteEnable() {
        return getMapType() == 1011;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public boolean isTrafficEnabled() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return false;
        }
        return a0Var.n();
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void j() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.q();
    }

    public void j(int i) {
        rc rcVar = this.b;
        if (rcVar == null) {
            return;
        }
        if (i != 0) {
            int i2 = 17;
            if (i == 1) {
                rcVar.a(false, false, false, false);
                if (getMapStyle() != 11) {
                    i2 = 18;
                }
                int i3 = i2 - 1;
                if (this.u == 2) {
                    b(i3);
                } else {
                    int V = V();
                    int i4 = i3;
                    if (V > i3) {
                        i4 = V;
                    }
                    b(this.t, i4, (Runnable) null);
                }
            } else if (i == 2) {
                if (getMapStyle() != 11) {
                    i2 = 18;
                }
                int V2 = V();
                int i5 = i2;
                if (V2 > i2) {
                    i5 = V2;
                }
                if (this.t.getLatitudeE6() != 0) {
                    this.b.h().a(this.t.getLatitudeE6(), this.t.getLongitudeE6(), 2);
                }
                a(i5, this.s);
                new Handler().postDelayed(new b(), 1000L);
            } else if (i == 3) {
                rcVar.a(false, false, false, true);
            }
        } else {
            rcVar.a(false, false, false, false);
        }
        this.u = i;
    }

    public void j(boolean z2) {
        this.b.n(z2);
    }

    public boolean j0() {
        return this.b.o0();
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void k() {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.r();
        this.n = false;
    }

    public void k(int i) {
        this.b.n(i);
    }

    public void k(boolean z2) {
        if (z2) {
            this.b.B0();
        } else {
            this.b.h0();
        }
    }

    public void k0() {
        this.b.p0();
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void l() {
        if (this.m || this.i == null) {
            return;
        }
        kf kfVar = this.l;
        if (kfVar != null) {
            this.r.b(kfVar);
        }
        this.i.s();
    }

    public void l(int i) {
        this.b.o(i);
    }

    public void l(boolean z2) {
        this.b.d0().a(z2);
    }

    public void l0() {
        this.b.h().G();
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void loadKMLFile(String str) {
        a0 a0Var;
        super.loadKMLFile(str);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.b(str);
    }

    @Override // com.tencent.mapsdk.internal.o1
    public void m() {
        if (this.m || this.i == null) {
            return;
        }
        kf kfVar = this.l;
        if (kfVar != null) {
            this.r.a(kfVar);
        }
        this.i.t();
    }

    public void m(int i) {
        this.b.h().e(i);
    }

    public void m(boolean z2) {
        this.b.u(z2);
    }

    public void m0() {
        this.b.h().g.h();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void moveCamera(CameraUpdate cameraUpdate) {
        a0 a0Var;
        if (this.m || (a0Var = this.i) == null || a0Var.m()) {
            return;
        }
        this.i.a(cameraUpdate);
    }

    public void n(int i) {
        this.b.p(i);
    }

    public boolean n() {
        return true;
    }

    public void n0() {
        this.b.v0();
    }

    public void o() {
        this.b.h().e();
    }

    public void o(int i) {
        this.b.h().e(i);
    }

    public void o0() {
        this.b.h().K();
    }

    public void p() {
        this.b.H();
    }

    public void p0() {
        this.b.h().L();
    }

    public v q() {
        return this.b.h().f();
    }

    public void q0() {
        this.b.h().M();
    }

    public String r() {
        return this.b.toString();
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        a0 a0Var;
        super.removeOnMapLoadedCallback(onMapLoadedCallback);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.b(onMapLoadedCallback);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        a0 a0Var;
        super.removeTencentMapGestureListener(tencentMapGestureListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.b(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.indoor.IIndoor
    public void resetIndoorCellInfo() {
        super.resetIndoorCellInfo();
        if (this.m || this.i == null) {
            return;
        }
        this.b.x0();
    }

    public GeoPoint s() {
        return this.b.h().h();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBaseMapEnabled(boolean z2) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.c(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuilding3dEffectEnable(boolean z2) {
        rc rcVar;
        super.setBuilding3dEffectEnable(z2);
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.g(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingBlackList(List<LatLngBounds> list) {
        super.setBuildingBlackList(list);
        this.b.a(list);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingEnable(boolean z2) {
        super.setBuildingEnable(z2);
        setBuilding3dEffectEnable(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f, float f2) {
        super.setCameraCenterProportion(f, f2);
        setCameraCenterProportion(f, f2, true);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f, float f2, boolean z2) {
        a0 a0Var;
        super.setCameraCenterProportion(f, f2, z2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(f, f2, z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCustomRender(CustomRender customRender) {
        rc rcVar;
        super.setCustomRender(customRender);
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.a(customRender);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setDrawPillarWith2DStyle(boolean z2) {
        rc rcVar;
        super.setDrawPillarWith2DStyle(z2);
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.g(!z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setForeignLanguage(Language language) {
        a0 a0Var;
        super.setForeignLanguage(language);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(language);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setHandDrawMapEnable(boolean z2) {
        a0 a0Var;
        super.setHandDrawMapEnable(z2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.b(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorCellInfo(List<IndoorCellInfo> list) {
        super.setIndoorCellInfo(list);
        if (this.m || this.i == null) {
            return;
        }
        this.b.b(list);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorEnabled(boolean z2) {
        a0 a0Var;
        super.setIndoorEnabled(z2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.c(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(int i) {
        a0 a0Var;
        super.setIndoorFloor(i);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.b(i);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(String str, String str2) {
        a0 a0Var;
        super.setIndoorFloor(str, str2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(str, str2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorMaskColor(int i) {
        super.setIndoorMaskColor(i);
        this.b.S().j(i);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        gj gjVar;
        super.setInfoWindowAdapter(infoWindowAdapter);
        if (this.m || (gjVar = this.r) == null) {
            return;
        }
        gjVar.a(infoWindowAdapter);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationCompassHidden(boolean z2) {
        super.setLocationCompassHidden(z2);
        this.b.m(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationNavigationGravityLineHidden(boolean z2) {
        super.setLocationNavigationGravityLineHidden(z2);
        this.b.o(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setLocationSource(LocationSource locationSource) {
        super.setLocationSource(locationSource);
        if (this.m) {
            return;
        }
        d0();
        this.j.a(locationSource);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapCenterAndScale(float f, float f2, float f3) {
        h1 h1Var;
        super.setMapCenterAndScale(f, f2, f3);
        if (this.m || (h1Var = this.d) == null) {
            return;
        }
        h1Var.a(f, f2, f3);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFontSize(MapFontSize mapFontSize) {
        if (this.m || this.i == null || mapFontSize == null) {
            return;
        }
        this.b.l(mapFontSize.getValue());
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFrameRate(float f) {
        super.setMapFrameRate(f);
        gj gjVar = this.r;
        if (gjVar != null) {
            gjVar.a(f);
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapStyle(int i) {
        a0 a0Var;
        super.setMapStyle(i);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.c(i);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapType(int i) {
        a0 a0Var;
        super.setMapType(i);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.d(i);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMaxZoomLevel(int i) {
        super.setMaxZoomLevel(i);
        if (this.m || this.i == null) {
            return;
        }
        int p = p(i);
        this.i.e(p);
        float f = p;
        if (this.i.b().zoom > f) {
            animateCamera(CameraUpdateFactory.zoomTo(f));
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMinZoomLevel(int i) {
        super.setMinZoomLevel(i);
        if (this.m || this.i == null) {
            return;
        }
        int p = p(i);
        this.i.f(p);
        float f = p;
        if (this.i.b().zoom < f) {
            animateCamera(CameraUpdateFactory.zoomTo(f));
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationClickListener(TencentMap.OnMyLocationClickListener onMyLocationClickListener) {
        super.setMyLocationClickListener(onMyLocationClickListener);
        if (this.m) {
            return;
        }
        if (this.f == null) {
            d0();
        }
        this.f.a(onMyLocationClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationEnabled(boolean z2) {
        super.setMyLocationEnabled(z2);
        if (this.m) {
            return;
        }
        d0();
        if (!z2) {
            this.j.a();
        } else if (isMyLocationEnabled()) {
        } else {
            this.j.b();
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        super.setMyLocationStyle(myLocationStyle);
        if (this.j == null) {
            d0();
        }
        this.j.a(myLocationStyle);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        a0 a0Var;
        super.setOnCameraChangeListener(onCameraChangeListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onCameraChangeListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCompassClickedListener(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        a0 a0Var;
        super.setOnCompassClickedListener(onCompassClickedListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onCompassClickedListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.indoor.IIndoor
    public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        a0 a0Var;
        super.setOnIndoorStateChangeListener(onIndoorStateChangeListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onIndoorStateChangeListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        a0 a0Var;
        super.setOnInfoWindowClickListener(onInfoWindowClickListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onInfoWindowClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        a0 a0Var;
        super.setOnMapClickListener(onMapClickListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onMapClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        a0 a0Var;
        super.setOnMapLongClickListener(onMapLongClickListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onMapLongClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        super.setOnMapPoiClickListener(onMapPoiClickListener);
        if (this.m || this.i == null) {
            return;
        }
        kf kfVar = this.l;
        if (kfVar != null) {
            kfVar.a(onMapPoiClickListener);
        }
        this.i.a(onMapPoiClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        a0 a0Var;
        super.setOnMarkerClickListener(onMarkerClickListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onMarkerClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerDragListener(TencentMap.OnMarkerDragListener onMarkerDragListener) {
        rc rcVar;
        super.setOnMarkerDragListener(onMarkerDragListener);
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.g().a(onMarkerDragListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        super.setOnMyLocationChangeListener(onMyLocationChangeListener);
        if (this.m) {
            return;
        }
        if (this.f == null) {
            d0();
        }
        this.f.a(onMyLocationChangeListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolygonClickListener(TencentMap.OnPolygonClickListener onPolygonClickListener) {
        gj gjVar;
        super.setOnPolygonClickListener(onPolygonClickListener);
        if (this.m || (gjVar = this.r) == null) {
            return;
        }
        gjVar.a(onPolygonClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolylineClickListener(TencentMap.OnPolylineClickListener onPolylineClickListener) {
        gj gjVar;
        super.setOnPolylineClickListener(onPolylineClickListener);
        if (this.m || (gjVar = this.r) == null) {
            return;
        }
        gjVar.a(onPolylineClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnScaleViewChangedListener(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        a0 a0Var;
        super.setOnScaleViewChangedListener(onScaleViewChangedListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onScaleViewChangedListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTapMapViewInfoWindowHidden(boolean z2) {
        a0 a0Var;
        super.setOnTapMapViewInfoWindowHidden(z2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.f(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        a0 a0Var;
        super.setOnTrafficEventClickListener(onTrafficEventClickListener);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(onTrafficEventClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnVectorOverlayClickListener(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        gj gjVar;
        super.setOnVectorOverlayClickListener(onVectorOverlayClickListener);
        if (this.m || (gjVar = this.r) == null) {
            return;
        }
        gjVar.a(onVectorOverlayClickListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaEnable(boolean z2) {
        super.setOverSeaEnable(z2);
        gj gjVar = this.r;
        if (gjVar != null) {
            gjVar.k(z2);
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaTileProvider(OverSeaTileProvider overSeaTileProvider) {
        rc rcVar;
        super.setOverSeaTileProvider(overSeaTileProvider);
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.a(overSeaTileProvider);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        h1 h1Var = this.d;
        if (h1Var != null) {
            h1Var.a(i, i2, i3, i4, false);
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i, int i2, int i3, int i4, boolean z2) {
        super.setPadding(i, i2, i3, i4, z2);
        h1 h1Var = this.d;
        if (h1Var != null) {
            h1Var.a(i, i2, i3, i4, z2);
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPointToCenter(int i, int i2) {
        t4 projection;
        super.setPointToCenter(i, i2);
        if (this.m || this.i == null || (projection = getProjection()) == null) {
            return;
        }
        this.i.a(CameraUpdateFactory.newLatLng(projection.fromScreenLocation(new Point(i, i2))));
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPoisEnabled(boolean z2) {
        a0 a0Var;
        super.setPoisEnabled(z2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.g(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setRestrictBounds(LatLngBounds latLngBounds, RestrictBoundsFitMode restrictBoundsFitMode) {
        a0 a0Var;
        super.setRestrictBounds(latLngBounds, restrictBoundsFitMode);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.a(latLngBounds, restrictBoundsFitMode == null ? 0 : restrictBoundsFitMode.ordinal());
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setSatelliteEnabled(boolean z2) {
        super.setSatelliteEnabled(z2);
        if (z2) {
            setMapType(1011);
        } else {
            setMapType(1000);
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        super.setTencentMapGestureListener(tencentMapGestureListener);
        addTencentMapGestureListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTrafficEnabled(boolean z2) {
        a0 a0Var;
        super.setTrafficEnabled(z2);
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.h(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void showBuilding(boolean z2) {
        super.showBuilding(z2);
        this.b.d(z2);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback) {
        super.snapshot(snapshotReadyCallback);
        snapshot(snapshotReadyCallback, Bitmap.Config.ARGB_8888);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config) {
        super.snapshot(snapshotReadyCallback, config);
        snapshot(snapshotReadyCallback, config, 0);
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i) {
        super.snapshot(snapshotReadyCallback, config, i);
        a0 a0Var = this.i;
        if (a0Var != null) {
            a0Var.a(snapshotReadyCallback, config, i);
        }
    }

    @Override // com.tencent.mapsdk.internal.o1, com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void stopAnimation() {
        a0 a0Var;
        super.stopAnimation();
        if (this.m || (a0Var = this.i) == null) {
            return;
        }
        a0Var.u();
    }

    public String[] t() {
        return this.b.N();
    }

    public void t0() {
        w a0 = this.b.a0();
        if (a0 == null) {
            return;
        }
        a0.c();
    }

    public String u() {
        return this.b.O();
    }

    public void u0() {
        this.b.h().a();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void updateVectorOverlay(VectorOverlay vectorOverlay, VectorOverlayProvider vectorOverlayProvider) {
        rc rcVar;
        if (this.m || (rcVar = this.b) == null) {
            return;
        }
        rcVar.a(vectorOverlay, vectorOverlayProvider);
        v0();
    }

    public int v() {
        return this.b.h().r();
    }

    public void v0() {
        this.b.w0();
    }

    public Rect w() {
        return this.b.h().i();
    }

    public void w0() {
        this.b.h().g().j();
    }

    public String x() {
        return this.b.P();
    }

    public void x0() {
        this.b.h().N();
    }

    public String y() {
        rc rcVar = this.b;
        if (rcVar != null) {
            return rcVar.n();
        }
        return null;
    }

    public void y0() {
        this.b.h().g.k();
    }

    public long z() {
        return this.b.h().g.e();
    }

    public void z0() {
        this.b.A0();
    }
}
