package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.SubMarkerInfo;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.BitmapScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.scatterplot.DotScatterPlotOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.trails.TrailOverlayProvider;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc.class */
public class rc extends u1 implements e1, j5 {
    private static final int i0 = 50;
    private static final int j0 = 6;
    private static final int k0 = 100;
    private static final int l0 = 100;
    private static final float m0 = 2.0f;
    private f A;
    private v B;
    private final LinkedBlockingQueue<b> C;
    private de D;
    private yd E;
    private volatile boolean F;
    private ab<Integer, Integer> G;
    private boolean H;
    private zd I;
    private boolean J;
    private d K;
    private e L;
    private hh M;
    private boolean N;
    private boolean O;
    private int P;
    private int Q;
    private Rect R;
    private float S;
    private float T;
    private boolean U;
    private int V;
    private int W;
    private Rect X;
    private CustomRender Y;
    private boolean Z;
    private int a0;
    private pe b0;
    private pg c0;
    private List<ne> d0;
    private String e0;
    private i1 f0;
    private TencentMap.OnVectorOverlayClickListener g0;
    private w4 h0;
    private final int n;
    private ri o;
    private cc p;
    private d0 q;
    private dh r;
    private j1 s;
    private qc t;
    private a1 u;
    private t4 v;
    private Rect w;
    private boolean x;
    private boolean y;
    private w z;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc$a.class */
    public class a implements b {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            if (rc.this.o != null) {
                rc.this.p.b(gl10);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc$b.class */
    public interface b {
        void a(GL10 gl10);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc$c.class */
    public enum c {
        UnderMainMap(2),
        Under3DBuiding(4),
        UnderHandDraw(6),
        UnderPoi(8),
        UnderToplayer(10),
        AboveToplayer(12);
        
        public int b;

        c(int i2) {
            this.b = i2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc$d.class */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        private List<d5> f24053a = new CopyOnWriteArrayList();

        public d() {
        }

        private void a(Language language) {
            synchronized (this) {
                for (d5 d5Var : this.f24053a) {
                    if (d5Var != null) {
                        d5Var.a(language);
                    }
                }
            }
        }

        public Language a() {
            if (rc.this.o != null && rc.this.o.w() == 1) {
                return Language.en;
            }
            return Language.zh;
        }

        public void a(d5 d5Var) {
            if (d5Var == null) {
                return;
            }
            synchronized (this.f24053a) {
                if (!this.f24053a.contains(d5Var)) {
                    this.f24053a.add(d5Var);
                }
            }
        }

        public void b(d5 d5Var) {
            if (d5Var == null) {
                return;
            }
            this.f24053a.remove(d5Var);
        }

        public void b(Language language) {
            if (rc.this.o != null) {
                rc.this.o.k(language.ordinal());
                rc.this.F = true;
                rc.this.w0();
                a(language);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc$e.class */
    public class e implements d5 {

        /* renamed from: a  reason: collision with root package name */
        private List<MapRouteSection> f24054a;
        private List<GeoPoint> b;

        public e() {
            rc.this.a(this);
        }

        public void a() {
            rc.this.o.g();
            this.f24054a = null;
            this.b = null;
        }

        @Override // com.tencent.mapsdk.internal.d5
        public void a(Language language) {
            if (language != Language.zh) {
                rc.this.o.g();
            } else if (this.f24054a == null || this.b == null) {
            } else {
                rc.this.o.a(this.f24054a, this.b);
            }
        }

        public void a(List<MapRouteSection> list, List<GeoPoint> list2) {
            this.f24054a = list;
            this.b = list2;
            rc.this.o.a(list, list2);
        }

        public void b() {
            rc.this.b(this);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc$f.class */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<g> f24056a;
        private g b;

        private f() {
            this.f24056a = new ArrayList<>();
        }

        public /* synthetic */ f(rc rcVar, a aVar) {
            this();
        }

        private Bitmap a(GL10 gl10, int i, int i2) {
            int i3 = i * i2;
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            gl10.glReadPixels((rc.this.w.width() - i) / 2, (rc.this.w.height() - i2) / 2, i, i2, 6408, 5121, wrap);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= i2) {
                    try {
                        return Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.RGB_565);
                    } catch (OutOfMemoryError e) {
                        return Bitmap.createBitmap(iArr2, i, i2, Bitmap.Config.RGB_565);
                    }
                }
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < i) {
                        int i8 = iArr[(i5 * i) + i7];
                        iArr2[(((i2 - i5) - 1) * i) + i7] = (i8 & Color.GREEN) | ((i8 << 16) & Spanned.SPAN_PRIORITY) | ((i8 >> 16) & 255);
                        i6 = i7 + 1;
                    }
                }
                i4 = i5 + 1;
            }
        }

        private void a(g gVar) {
            if (gVar == null || gVar.d()) {
                return;
            }
            gVar.e();
            synchronized (this.f24056a) {
                this.f24056a.remove(gVar);
            }
            rc.this.q.N();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(u4 u4Var, Rect rect, k5 k5Var, int i, int i2) {
            g gVar = new g(rc.this, u4Var, rect, k5Var, i, i2, null);
            synchronized (this.f24056a) {
                this.f24056a.add(gVar);
            }
            na.c("snapshot addSnapshotRequest");
            rc.this.w0();
        }

        private g b() {
            g gVar;
            synchronized (this.f24056a) {
                gVar = this.f24056a.size() > 0 ? this.f24056a.get(0) : null;
            }
            return gVar;
        }

        public g a(GL10 gl10) {
            synchronized (this) {
                g b = b();
                this.b = b;
                if (b == null) {
                    return null;
                }
                if (b.b()) {
                    a(this.b);
                    return null;
                }
                rc.this.q.P();
                Rect rect = this.b.f;
                int i = this.b.d;
                int i2 = this.b.e;
                Rect rect2 = new Rect();
                int d = (int) (g7.d(rc.this.getContext()) * 20.0f);
                int width = ((rc.this.w.width() - i) / 2) + d;
                rect2.right = width;
                rect2.left = width;
                int height = ((rc.this.w.height() - i2) / 2) + d;
                rect2.bottom = height;
                rect2.top = height;
                rc.this.q.c(rect, rect2);
                return this.b;
            }
        }

        public void a() {
            synchronized (this) {
                na.c("snapshot cancel");
                synchronized (this.f24056a) {
                    this.f24056a.clear();
                }
                g gVar = this.b;
                if (gVar != null) {
                    gVar.a();
                }
            }
        }

        public void a(GL10 gl10, qc qcVar, Projection projection) {
            synchronized (this) {
                g gVar = this.b;
                if (gVar != null && !gVar.b()) {
                    int i = this.b.d;
                    int i2 = this.b.e;
                    k5 k5Var = this.b.b;
                    u4 u4Var = this.b.f24059c;
                    Bitmap a2 = a(gl10, i, i2);
                    if (k5Var != null && !this.b.d()) {
                        k5Var.a(a2, u4Var);
                    }
                    a(this.b);
                }
            }
        }

        public void b(GL10 gl10, qc qcVar, Projection projection) {
            synchronized (this) {
                if (rc.this.o == null) {
                    return;
                }
                u4 u4Var = this.b.f24059c;
                if (u4Var != null) {
                    u4Var.a(gl10);
                }
                qcVar.c();
            }
        }

        public boolean c() {
            boolean z;
            synchronized (this.f24056a) {
                ArrayList<g> arrayList = this.f24056a;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z = false;
                }
                z = true;
            }
            return z;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rc$g.class */
    public class g {
        public static final int i = 0;
        public static final int j = 1;
        public static final int k = 2;
        public static final int l = 3;

        /* renamed from: a  reason: collision with root package name */
        private int f24058a;
        private k5 b;

        /* renamed from: c  reason: collision with root package name */
        private u4 f24059c;
        private int d;
        private int e;
        private Rect f;
        private int g;

        private g(u4 u4Var, Rect rect, k5 k5Var, int i2, int i3) {
            this.f24058a = 0;
            this.f24059c = u4Var;
            this.f = rect;
            this.b = k5Var;
            this.d = i2;
            this.e = i3;
            this.g = 0;
        }

        public /* synthetic */ g(rc rcVar, u4 u4Var, Rect rect, k5 k5Var, int i2, int i3, a aVar) {
            this(u4Var, rect, k5Var, i2, i3);
        }

        public static /* synthetic */ int d(g gVar) {
            int i2 = gVar.f24058a;
            gVar.f24058a = i2 + 1;
            return i2;
        }

        public void a() {
            this.g = 1;
            this.f24058a = 0;
        }

        public void a(int i2) {
            this.g = i2;
        }

        public boolean b() {
            return this.g == 1;
        }

        public boolean c() {
            StringBuilder sb = new StringBuilder();
            sb.append("is processing:");
            sb.append(this.g == 3);
            na.c(sb.toString());
            return this.g == 3;
        }

        public boolean d() {
            boolean z;
            synchronized (this) {
                z = this.g == 2;
            }
            return z;
        }

        public void e() {
            synchronized (this) {
                this.g = 2;
                this.f24058a = 0;
            }
        }
    }

    public rc(Context context, TencentMapOptions tencentMapOptions, r1 r1Var) {
        super(context, tencentMapOptions, r1Var);
        this.F = false;
        this.H = true;
        this.J = true;
        this.N = true;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.S = 0.5f;
        this.T = 0.5f;
        this.U = true;
        this.V = 18;
        this.W = 14;
        this.h0 = null;
        a1 a1Var = (a1) r1Var;
        this.u = a1Var;
        this.f0 = new i1(a1Var, this);
        this.o = new ri(context, this);
        this.B = new v(this);
        this.w = new Rect();
        j1 j1Var = new j1(this.f0, this);
        this.s = j1Var;
        this.u.a(j1Var);
        this.c0 = new pg(getContext(), this);
        this.v = new y(this);
        d0 d0Var = new d0(this);
        this.q = d0Var;
        this.o.a(d0Var);
        cc ccVar = new cc(100);
        this.p = ccVar;
        this.t = new qc(this, ccVar, this.o);
        this.A = new f(this, null);
        this.C = new LinkedBlockingQueue<>();
        this.d0 = new CopyOnWriteArrayList();
        if (getContext() != null) {
            this.n = (int) ((getContext().getResources().getDisplayMetrics().density * 6.0f) + 0.5d);
        } else {
            this.n = 6;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        f(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
    }

    private void C0() {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.W();
        }
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        this.o.b(i, i2, i3, i4);
        this.P = i3;
        this.Q = i4;
        if (z) {
            a(this.S, this.T, this.U);
        }
    }

    private boolean a(Context context, be beVar) {
        String j = this.D.j();
        String h = this.D.h();
        String c2 = this.D.c();
        try {
            if (!this.E.a()) {
                j = this.D.i();
            }
            na.a(ma.f, "newEngine config:" + j);
            this.z.b();
            return this.o.a(context, beVar, this.z, j, h, c2, m0);
        } finally {
            this.z.d();
        }
    }

    private Point[] a(Rect rect) {
        return new Point[]{new Point(rect.centerX(), rect.centerY()), new Point(rect.left, rect.top), new Point(rect.left, rect.bottom), new Point(rect.right, rect.top), new Point(rect.right, rect.bottom)};
    }

    private rd b(r5 r5Var) {
        rd rdVar = new rd(r5Var.v, r5Var.f24043c);
        if (!TextUtils.isEmpty(r5Var.i)) {
            SubMarkerInfo subMarkerInfo = new SubMarkerInfo();
            subMarkerInfo.iconName(r5Var.i);
            subMarkerInfo.iconWidth(r5Var.j);
            subMarkerInfo.iconHeight(r5Var.k);
            subMarkerInfo.avoidAnnotation(true);
            subMarkerInfo.avoidOtherMarker(true);
            rdVar.subMarkerInfo(subMarkerInfo);
        }
        rdVar.iconWidth(r5Var.d);
        rdVar.iconHeight(r5Var.e);
        rdVar.avoidAnnotation(true);
        rdVar.avoidOtherMarker(true);
        float f2 = r5Var.h;
        rdVar.scale(f2, f2);
        rdVar.priority(r5Var.s);
        rdVar.displayLevel(2);
        rdVar.minScaleLevel(r5Var.t);
        rdVar.maxScaleLevel(r5Var.u);
        return rdVar;
    }

    private void b(GL10 gl10) {
        if (this.C.size() == 0) {
            return;
        }
        boolean z = true;
        while (z) {
            b poll = this.C.poll();
            if (poll != null) {
                try {
                    poll.a(gl10);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                z = false;
            }
        }
    }

    private void f(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.d(z);
        }
    }

    private void i0() {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.M();
        }
    }

    private boolean l0() {
        return ((double) this.q.v()) > 1.0E-10d;
    }

    private void w(boolean z) {
        ri riVar = this.o;
        if (riVar == null) {
            return;
        }
        riVar.q(z);
    }

    public void A0() {
        dh dhVar;
        if (!this.y || (dhVar = this.r) == null) {
            return;
        }
        dhVar.f();
    }

    public void B0() {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.V();
            this.x = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.q1
    public Map<Class<? extends TencentMapComponent.Component>, Class<? extends TencentMapComponent.Component>> C() {
        HashMap hashMap = new HashMap();
        hashMap.put(z3.class, ph.class);
        return hashMap;
    }

    public void D0() {
        this.A.a();
    }

    public void E0() {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.c();
        }
    }

    public int H() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.e();
        }
        return -1;
    }

    public void I() {
        if (this.L == null) {
            this.L = new e();
        }
        this.L.a();
    }

    public void J() {
        pg pgVar = this.c0;
        if (pgVar != null) {
            pgVar.d();
        }
        pg.a(getContext());
        a((le) null);
        this.b0 = null;
        this.q.b(this);
        this.d0.clear();
        e eVar = this.L;
        if (eVar != null) {
            eVar.b();
        }
        this.q.T();
        this.H = true;
        hh hhVar = this.M;
        if (hhVar != null) {
            hhVar.a();
        }
        j1 j1Var = this.s;
        if (j1Var != null) {
            j1Var.e();
        }
        dh dhVar = this.r;
        if (dhVar != null) {
            dhVar.c();
        }
        ri riVar = this.o;
        if (riVar != null) {
            riVar.h();
        }
    }

    public void K() {
        this.F = true;
    }

    public boolean L() {
        ri riVar = this.o;
        if (riVar == null) {
            return false;
        }
        return riVar.l();
    }

    public yd M() {
        return this.E;
    }

    public String[] N() {
        Point[] a2 = a(this.q.i());
        HashSet hashSet = new HashSet();
        int length = a2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (String[]) hashSet.toArray(new String[0]);
            }
            Point point = a2[i2];
            String a3 = a(new GeoPoint(point.y, point.x));
            if (!f7.b(a3)) {
                hashSet.add(a3);
            }
            i = i2 + 1;
        }
    }

    public String O() {
        return a(this.q.h());
    }

    public String P() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.p();
        }
        return null;
    }

    public Rect Q() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.t();
        }
        return null;
    }

    public String[] R() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.v();
        }
        return null;
    }

    public ri S() {
        return this.o;
    }

    public Language T() {
        if (this.K == null) {
            this.K = new d();
        }
        return this.K.a();
    }

    public qc U() {
        return this.t;
    }

    public q1 V() {
        a1 a1Var = this.u;
        if (a1Var == null) {
            return null;
        }
        return a1Var.getMapContext();
    }

    public String W() {
        ri riVar = this.o;
        if (riVar == null) {
            return null;
        }
        return riVar.f();
    }

    public String X() {
        ri riVar = this.o;
        if (riVar == null) {
            return null;
        }
        return riVar.x();
    }

    public ArrayList<MapPoi> Y() {
        ri riVar = this.o;
        if (riVar == null) {
            return null;
        }
        return riVar.z();
    }

    public i1 Z() {
        return this.f0;
    }

    public float a(double d2, GeoPoint geoPoint) {
        t4 t4Var;
        if (geoPoint == null || this.B == null || (t4Var = this.v) == null) {
            return 0.0f;
        }
        double metersPerPixel = t4Var.metersPerPixel(geoPoint.getLatitudeE6() / 1000000.0d);
        if (metersPerPixel != 0.0d) {
            return (float) (d2 / metersPerPixel);
        }
        return 0.0f;
    }

    public int a(int i, int i2, int i3, int i4, int i5, float f2) {
        if (this.o == null) {
            return -1;
        }
        int i6 = i;
        if (i < 0) {
            i6 = 0;
        }
        int i7 = i6;
        if (i6 > 255) {
            i7 = 255;
        }
        int i8 = i2;
        if (i2 < 0) {
            i8 = 0;
        }
        int i9 = i8;
        if (i8 > 255) {
            i9 = 255;
        }
        int i10 = i3;
        if (i3 < 0) {
            i10 = 0;
        }
        int i11 = i10;
        if (i10 > 255) {
            i11 = 255;
        }
        int i12 = i4;
        if (i4 < 0) {
            i12 = 0;
        }
        int i13 = i12;
        if (i12 > 255) {
            i13 = 255;
        }
        MaskLayer maskLayer = new MaskLayer();
        maskLayer.color = new int[]{i7, i9, i11, 255 - i13};
        Rect rect = this.w;
        if (rect != null) {
            maskLayer.width = rect.width();
            maskLayer.height = this.w.height();
        }
        maskLayer.zIndex = f2;
        maskLayer.layer = i5;
        return this.o.a(maskLayer);
    }

    @Deprecated
    public int a(TileOverlayCallback tileOverlayCallback, boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.a(tileOverlayCallback, z);
        }
        return -1;
    }

    public int a(PolygonInfo polygonInfo) {
        ri riVar = this.o;
        if (riVar == null || polygonInfo == null) {
            return -1;
        }
        int a2 = riVar.a(polygonInfo);
        if (this.G == null) {
            this.G = new ab<>();
        }
        this.G.a(Integer.valueOf(a2), Integer.valueOf(polygonInfo.borderLineId));
        return a2;
    }

    public int a(r5 r5Var) {
        if (this.s == null || r5Var.v == null) {
            return -1;
        }
        pd pdVar = (pd) this.s.a((j1) b(r5Var));
        if (pdVar != null) {
            return pdVar.l();
        }
        return -1;
    }

    public int a(String str) {
        ri riVar = this.o;
        if (riVar == null) {
            return -1;
        }
        return riVar.c(str);
    }

    public int a(String str, float f2, float f3) {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.a(str, f2, f3);
        }
        return 0;
    }

    public AnnocationTextResult a(AnnocationText annocationText) {
        return this.o.a(annocationText);
    }

    public TappedElement a(float f2, float f3) {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.a(f2, f3);
        }
        return null;
    }

    public Circle a(CircleOptions circleOptions) {
        i1 i1Var = this.f0;
        if (i1Var == null || circleOptions == null) {
            return null;
        }
        return i1Var.a(circleOptions);
    }

    public GroundOverlay a(GroundOverlayOptions groundOverlayOptions) {
        if (this.o == null) {
            return null;
        }
        if (w() != null) {
            w().i().b();
        }
        return (GroundOverlay) this.s.a((j1) new id(this.o.o(), groundOverlayOptions));
    }

    public IntersectionOverlay a(IntersectionOverlayOptions intersectionOverlayOptions) {
        if (this.o == null) {
            return null;
        }
        return (IntersectionOverlay) this.s.a((j1) new od(intersectionOverlayOptions));
    }

    public Marker a(MarkerOptions markerOptions) {
        i1 i1Var = this.f0;
        if (i1Var == null || markerOptions == null) {
            return null;
        }
        return i1Var.a(markerOptions);
    }

    public Polyline a(PolylineOptions polylineOptions) {
        i1 i1Var = this.f0;
        if (i1Var == null || polylineOptions == null) {
            return null;
        }
        return i1Var.a(polylineOptions);
    }

    public VectorHeatOverlay a(VectorHeatOverlayOptions vectorHeatOverlayOptions) {
        if (this.o == null) {
            return null;
        }
        if (w() != null) {
            w().r().b();
        }
        return (VectorHeatOverlay) this.s.a((j1) new yc(vectorHeatOverlayOptions));
    }

    public <V extends VectorOverlay> V a(VectorOverlayProvider vectorOverlayProvider) {
        if (this.o == null) {
            return null;
        }
        if (vectorOverlayProvider instanceof AggregationOverlayProvider) {
            if (w() != null) {
                w().r().b();
            }
            return (xc) this.s.a((j1) new yc((AggregationOverlayProvider) vectorOverlayProvider));
        } else if (vectorOverlayProvider instanceof GradientVectorOverlayProvider) {
            if (w() != null) {
                w().j().b();
            }
            return (jd) this.s.a((j1) new ld((GradientVectorOverlayProvider) vectorOverlayProvider));
        } else if (vectorOverlayProvider instanceof ArcLineOverlayProvider) {
            if (w() != null) {
                w().c().b();
            }
            return (ad) this.s.a((j1) new cd((ArcLineOverlayProvider) vectorOverlayProvider));
        } else if (vectorOverlayProvider instanceof DotScatterPlotOverlayProvider) {
            if (w() != null) {
                w().g().b();
            }
            return (sd) this.s.a((j1) new ud(this.o.o(), (DotScatterPlotOverlayProvider) vectorOverlayProvider));
        } else if (vectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider) {
            if (w() != null) {
                w().d().b();
            }
            return (sd) this.s.a((j1) new ud(this.o.o(), (BitmapScatterPlotOverlayProvider) vectorOverlayProvider));
        } else if (vectorOverlayProvider instanceof TrailOverlayProvider) {
            if (w() != null) {
                w().p().b();
            }
            return (vd) this.s.a((j1) new xd((TrailOverlayProvider) vectorOverlayProvider));
        } else if (vectorOverlayProvider instanceof GLModelOverlayProvider) {
            if (w() != null) {
                w().h().b();
            }
            return (fd) this.s.a((j1) new ed((GLModelOverlayProvider) vectorOverlayProvider));
        } else {
            return null;
        }
    }

    public String a(GeoPoint geoPoint) {
        zd zdVar;
        String a2;
        if (this.E == null || (zdVar = this.I) == null || (a2 = zdVar.a(geoPoint)) == null) {
            ri riVar = this.o;
            return riVar == null ? "" : riVar.a(geoPoint);
        }
        return a2;
    }

    public List<Integer> a(Rect rect, int i) {
        return this.o.a(rect, i);
    }

    @Override // com.tencent.mapsdk.internal.j5
    public void a(double d2) {
    }

    public void a(float f2) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(f2);
        }
    }

    public void a(float f2, float f3, long j, String str, String str2) {
        TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener;
        if (j > 0) {
            Pair<VectorOverlay, TencentMap.IClickedObject> a2 = this.s.a(getProjection().fromScreenLocation(new Point((int) f2, (int) f3)), j, str, str2);
            VectorOverlay vectorOverlay = a2.first;
            if (vectorOverlay != null && (onVectorOverlayClickListener = this.g0) != null) {
                onVectorOverlayClickListener.onClicked(vectorOverlay, a2.second);
            }
        } else {
            this.h0.onSingleTap(f2, f3);
        }
        this.h0 = null;
    }

    public void a(float f2, float f3, boolean z) {
        Rect rect;
        this.S = f2;
        this.T = f3;
        double d2 = f2;
        double d3 = f3;
        double d4 = d2;
        double d5 = d3;
        if (this.w != null) {
            double d6 = d3;
            if (this.Q > 0) {
                d6 = 0.5d - (((0.5d - d3) * rect.height()) / this.Q);
            }
            d4 = d2;
            d5 = d6;
            if (this.P > 0) {
                d4 = 0.5d - (((0.5d - d2) * this.w.width()) / this.P);
                d5 = d6;
            }
        }
        this.o.b((float) d4, (float) d5, z);
    }

    public void a(float f2, int i, LatLng latLng) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(f2, i, latLng);
        }
    }

    public void a(int i, float f2) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(i, f2);
        }
    }

    public void a(int i, int i2) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(i, i2);
        }
    }

    public void a(int i, int i2, int i3) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(i, i2, i3);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(i, i2, i3, i4);
        }
    }

    public void a(int i, boolean z) {
        ab<Integer, Integer> abVar;
        if (this.o == null || (abVar = this.G) == null) {
            return;
        }
        int i2 = 0;
        Integer a2 = abVar.a((ab<Integer, Integer>) Integer.valueOf(i));
        if (a2 != null) {
            i2 = a2.intValue();
        }
        this.o.a(i, i2, z);
    }

    public void a(Rect rect, int i, int i2, k5 k5Var) {
        if (rect == null || i <= 0 || i2 <= 0 || k5Var == null) {
            return;
        }
        this.A.a(null, rect, k5Var, i, i2);
    }

    public void a(Rect rect, Rect rect2, boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(rect, rect2, z);
        }
    }

    public void a(GeoPoint geoPoint, float f2, float f3, boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(geoPoint, f2, f3, z);
        }
    }

    public void a(GeoPoint geoPoint, RectF rectF, boolean z) {
        Rect rect;
        if (rectF != null && (rect = this.R) != null) {
            rectF.left -= rect.left;
            rectF.top -= rect.top;
            rectF.right -= rect.right;
            rectF.bottom -= rect.bottom;
        }
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(geoPoint, rectF, this.W, this.V, z);
        }
    }

    public void a(ah ahVar) {
        dh dhVar = this.r;
        if (dhVar != null) {
            dhVar.a(ahVar);
        }
    }

    public void a(d5 d5Var) {
        if (this.K == null) {
            this.K = new d();
        }
        this.K.a(d5Var);
    }

    public void a(de deVar) {
        if (deVar == null) {
            return;
        }
        this.D = deVar;
        if (this.o != null) {
            String j = deVar.j();
            String h = this.D.h();
            String c2 = this.D.c();
            na.a(ma.f, "resetMapPath config:" + j);
            if (f7.b(c2) || f7.b(h)) {
                return;
            }
            try {
                this.z.b();
                this.o.a(j, h, c2);
            } finally {
                this.z.d();
            }
        }
    }

    public void a(le leVar) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(leVar);
        }
    }

    public void a(me meVar) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(meVar);
        }
    }

    public void a(ne neVar) {
        List<ne> list = this.d0;
        if (list != null) {
            list.add(neVar);
        }
    }

    public void a(pe peVar) {
        this.b0 = peVar;
    }

    public void a(b bVar) {
        try {
            this.C.put(bVar);
        } catch (InterruptedException e2) {
            na.f(e2.getMessage(), e2);
            Thread.currentThread().interrupt();
        }
    }

    public void a(u4 u4Var, int i, int i2, k5 k5Var) {
        a(u4Var, u4Var.getBound(this.v), i, i2, k5Var);
    }

    public void a(u4 u4Var, Rect rect, int i, int i2, k5 k5Var) {
        if (u4Var == null || rect == null || i <= 0 || i2 <= 0 || k5Var == null) {
            return;
        }
        this.A.a(u4Var, rect, k5Var, i, i2);
    }

    public void a(w4 w4Var) {
        a1 a1Var = this.u;
        if (a1Var != null) {
            a1Var.a(w4Var);
        }
    }

    public void a(CustomRender customRender) {
        this.Y = customRender;
        w0();
    }

    public void a(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.g0 = onVectorOverlayClickListener;
    }

    public void a(Language language) {
        if (this.K == null) {
            this.K = new d();
        }
        this.K.b(language);
    }

    public void a(LatLngBounds latLngBounds, int i) {
        if (this.o == null) {
            return;
        }
        if (latLngBounds == null || latLngBounds.isEmptySpan()) {
            this.o.a((double[]) null, (double[]) null, 0);
            return;
        }
        this.o.a(new double[]{latLngBounds.getLonWest(), latLngBounds.getLatSouth(), latLngBounds.getLonEast(), latLngBounds.getLatNorth()}, new double[]{0.0d, 0.0d, this.P, this.Q}, i);
    }

    public void a(OverSeaTileProvider overSeaTileProvider) {
        a1 a1Var = this.u;
        if (a1Var == null) {
            return;
        }
        a1Var.a(overSeaTileProvider);
    }

    public void a(TrafficStyle trafficStyle) {
        ri riVar = this.o;
        if (riVar == null) {
            return;
        }
        riVar.a(trafficStyle);
    }

    public void a(VectorOverlay vectorOverlay, VectorOverlayProvider vectorOverlayProvider) {
        if (this.o == null) {
            return;
        }
        if (vectorOverlayProvider instanceof AggregationOverlayProvider) {
            xc xcVar = (xc) this.s.a(xc.class, ((xc) vectorOverlay).l());
            if (xcVar != null) {
                xcVar.a((xc) new yc((AggregationOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        } else if (vectorOverlayProvider instanceof GradientVectorOverlayProvider) {
            jd jdVar = (jd) this.s.a(jd.class, ((jd) vectorOverlay).l());
            if (jdVar != null) {
                jdVar.a((jd) new ld((GradientVectorOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        } else if (vectorOverlayProvider instanceof ArcLineOverlayProvider) {
            ad adVar = (ad) this.s.a(ad.class, ((ad) vectorOverlay).l());
            if (adVar != null) {
                adVar.a((ad) new cd((ArcLineOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        } else if (vectorOverlayProvider instanceof DotScatterPlotOverlayProvider) {
            sd sdVar = (sd) this.s.a(sd.class, ((sd) vectorOverlay).l());
            if (sdVar != null) {
                sdVar.a((sd) new ud(this.o.o(), (DotScatterPlotOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        } else if (vectorOverlayProvider instanceof BitmapScatterPlotOverlayProvider) {
            sd sdVar2 = (sd) this.s.a(sd.class, ((sd) vectorOverlay).l());
            if (sdVar2 != null) {
                sdVar2.a((sd) new ud(this.o.o(), (BitmapScatterPlotOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        } else if (vectorOverlayProvider instanceof TrailOverlayProvider) {
            vd vdVar = (vd) this.s.a(vd.class, ((vd) vectorOverlay).l());
            if (vdVar != null) {
                vdVar.a((vd) new xd((TrailOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        } else if (vectorOverlayProvider instanceof GLModelOverlayProvider) {
            fd fdVar = (fd) this.s.a(fd.class, ((fd) vectorOverlay).l());
            if (fdVar != null) {
                fdVar.a((fd) new ed((GLModelOverlayProvider) vectorOverlayProvider));
            } else {
                a(vectorOverlayProvider);
            }
        }
    }

    public void a(String str, String str2) {
        ri riVar = this.o;
        if (riVar == null) {
            return;
        }
        riVar.a(str, str2);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(str, str2, str3, str4, str5);
        }
    }

    public void a(List<LatLngBounds> list) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(list);
        }
    }

    public void a(List<MapRouteSection> list, List<GeoPoint> list2) {
        if (this.L == null) {
            this.L = new e();
        }
        this.L.a(list, list2);
    }

    public void a(GL10 gl10) {
        cc ccVar;
        if (this.o == null || (ccVar = this.p) == null) {
            return;
        }
        ccVar.b();
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(z, z2, z3, z4);
        }
    }

    public void a(int[] iArr, int i) {
        ri riVar = this.o;
        if (riVar == null || iArr == null || i == 0) {
            return;
        }
        riVar.a(iArr, i);
    }

    public void a(int[] iArr, int i, boolean z) {
        ri riVar = this.o;
        if (riVar == null || iArr == null || i == 0) {
            return;
        }
        riVar.a(iArr, i, z);
    }

    public void a(String[] strArr) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(strArr);
        }
    }

    @Override // com.tencent.mapsdk.internal.q1, com.tencent.mapsdk.internal.e1
    public boolean a() {
        return d(this.q.m());
    }

    public boolean a(float f2, float f3, w4 w4Var) {
        ri riVar;
        if (this.h0 != null || !this.s.d() || (riVar = this.o) == null) {
            this.h0 = null;
            return false;
        }
        riVar.b(f2, f3);
        this.h0 = w4Var;
        return true;
    }

    public boolean a(int i) {
        ri riVar = this.o;
        if (riVar == null) {
            return false;
        }
        return riVar.b(i);
    }

    public boolean a(Context context, yd ydVar, ib ibVar, be beVar) {
        this.E = ydVar;
        de d2 = ydVar.d();
        this.D = d2;
        zd b2 = ydVar.b();
        this.I = b2;
        this.z = new w(context, this, d2, b2);
        if (this.r == null) {
            dh dhVar = new dh(this, ibVar);
            this.r = dhVar;
            a1 a1Var = this.u;
            if (a1Var != null) {
                a1Var.a(dhVar);
            }
        }
        boolean a2 = a(context, beVar);
        if (a2) {
            if (r() != null) {
                this.o.a(r().getTrafficStyle());
            }
            this.o.K();
            this.o.j(true);
            this.o.j(true);
            this.o.l(true);
            this.o.n(20);
            this.o.o(3);
            this.q.a(this);
            int i = this.n;
            c(i, i);
        }
        return a2;
    }

    public w a0() {
        return this.z;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public v b() {
        return this.B;
    }

    public String b(GeoPoint geoPoint) {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.c(geoPoint);
        }
        return null;
    }

    public void b(int i) {
        j1 j1Var = this.s;
        if (j1Var != null) {
            j1Var.a(i, pd.class);
        }
    }

    public void b(int i, int i2) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.b(i, i2);
        }
    }

    @Deprecated
    public void b(int i, int i2, int i3) {
        ri riVar = this.o;
        if (riVar == null) {
            return;
        }
        riVar.b(i, i2, i3);
    }

    public void b(Rect rect) {
        Rect rect2 = this.w;
        if (rect2 == null || rect == null) {
            return;
        }
        this.R = rect;
        int width = rect2.width();
        int height = this.w.height();
        int i = rect.left;
        int i2 = rect.bottom;
        a(i, i2, (width - rect.right) - i, (height - i2) - rect.top, true);
    }

    public void b(PolygonInfo polygonInfo) {
        ri riVar = this.o;
        if (riVar == null || polygonInfo == null) {
            return;
        }
        riVar.b(polygonInfo);
    }

    public void b(ah ahVar) {
        dh dhVar = this.r;
        if (dhVar != null) {
            dhVar.b(ahVar);
        }
    }

    public void b(d5 d5Var) {
        if (this.K == null) {
            this.K = new d();
        }
        this.K.b(d5Var);
    }

    public void b(ne neVar) {
        if (this.d0.isEmpty()) {
            return;
        }
        this.d0.remove(neVar);
    }

    public void b(w4 w4Var) {
        a1 a1Var = this.u;
        if (a1Var != null) {
            a1Var.b(w4Var);
        }
    }

    public void b(List<IndoorCellInfo> list) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.b(list);
        }
    }

    public boolean b(String str) {
        ri riVar = this.o;
        if (riVar == null) {
            return false;
        }
        return riVar.d(str);
    }

    public String b0() {
        return this.e0;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public int c() {
        return r().getExtSurfaceHeight();
    }

    public void c(int i) {
        ab<Integer, Integer> abVar;
        if (this.o == null || (abVar = this.G) == null) {
            return;
        }
        int i2 = 0;
        Integer a2 = abVar.a((ab<Integer, Integer>) Integer.valueOf(i));
        if (a2 != null) {
            i2 = a2.intValue();
        }
        this.o.c(i, i2);
    }

    public void c(int i, int i2) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.d(i + 50, i2 + 50);
        }
    }

    public void c(r5 r5Var) {
        if (this.s != null) {
            this.s.a(r5Var.b, (int) b(r5Var));
        }
    }

    public void c(String str) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.f(str);
        }
    }

    public void c(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a(z);
        }
    }

    public boolean c(GL10 gl10) {
        if (this.o == null) {
            return false;
        }
        this.s.b();
        this.q.J();
        b(gl10);
        this.o.X();
        boolean z = this.o.R() || this.F;
        if (z) {
            g a2 = this.A.a(gl10);
            if (a2 == null) {
                this.s.a(gl10);
            } else if (this.A != null && this.o.N()) {
                this.A.b(gl10, this.t, this.v);
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.o.S();
            this.F = false;
            if (!this.u.m()) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long j = 0;
                Object h = ra.h(qa.X, "nativeTotalTime");
                if (h != null) {
                    j = ((Long) h).longValue();
                }
                ra.b(qa.X, "nativeTime", Long.valueOf(currentTimeMillis2));
                ra.b(qa.X, "nativeTotalTime", Long.valueOf(j + currentTimeMillis2));
                ra.j(qa.X);
            }
            if (!this.A.c() && a2 != null) {
                if (a2.b()) {
                    a2.f24058a = 0;
                } else if (this.o.N() || a2.f24058a >= 100) {
                    a2.f24058a = 0;
                    this.A.a(gl10, this.t, this.v);
                } else {
                    g.d(a2);
                }
            }
        }
        qc qcVar = this.t;
        if (qcVar != null) {
            qcVar.c();
        }
        return z;
    }

    public cc c0() {
        return this.p;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public float d() {
        if (getContext() == null) {
            return 1.0f;
        }
        return g7.d(getContext());
    }

    public void d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.o.e(i, i2);
    }

    public void d(String str) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.h(str);
        }
    }

    public void d(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.b(z);
        }
    }

    public boolean d(int i) {
        return b().b(i);
    }

    public pg d0() {
        return this.c0;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public Rect e() {
        return this.w;
    }

    @Deprecated
    public void e(int i) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.d(i);
        }
    }

    public void e(int i, int i2) {
        this.W = i;
        this.V = i2;
    }

    public void e(String str) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.i(str);
        }
    }

    public void e(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.c(z);
        }
    }

    public hh e0() {
        return this.M;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public ri f() {
        return this.o;
    }

    public void f(int i) {
        ri riVar = this.o;
        if (riVar == null) {
            return;
        }
        riVar.f(i);
    }

    public void f(int i, int i2) {
        Rect rect = this.w;
        if (rect != null) {
            rect.set(0, 0, i, i2);
        }
    }

    public void f(String str) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.j(str);
        }
    }

    public Rect f0() {
        return this.R;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public j1 g() {
        return this.s;
    }

    @Deprecated
    public void g(int i) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.g(i);
            this.F = true;
        }
    }

    @Deprecated
    public void g(int i, int i2) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.f(i, i2);
        }
    }

    public void g(String str) {
        ri riVar = this.o;
        if (riVar != null) {
            this.e0 = str;
            riVar.k(str);
        }
    }

    public void g(boolean z) {
        this.J = z;
        f(z);
    }

    public boolean g0() {
        return this.x;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public t4 getProjection() {
        return this.v;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public d0 h() {
        return this.q;
    }

    public void h(int i, int i2) {
        if (this.o == null) {
            return;
        }
        this.F = true;
        this.w.set(0, 0, i, i2);
        a(0, 0, i, i2, false);
        this.q.H();
    }

    public void h(String str) {
        zd zdVar = this.I;
        if (zdVar == null) {
            return;
        }
        zdVar.setOptionalResourcePath(str);
    }

    public void h(boolean z) {
        this.q.e(z);
    }

    public boolean h(int i) {
        CustomRender customRender;
        if (i == c.AboveToplayer.b && (customRender = this.Y) != null) {
            customRender.onDrawFrame();
            return true;
        }
        return false;
    }

    public void h0() {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.L();
            this.x = false;
        }
    }

    @Override // com.tencent.mapsdk.internal.e1
    public Object i() {
        return r().getExtSurface();
    }

    public void i(int i) {
        this.o.h(i);
    }

    public void i(int i, int i2) {
        ri riVar = this.o;
        if (riVar == null) {
            return;
        }
        int i3 = i2;
        if (i2 < 0) {
            i3 = 0;
        }
        int i4 = i3;
        if (i3 > 255) {
            i4 = 255;
        }
        int i5 = 255 - i4;
        int i6 = i5;
        if (i5 == 0) {
            i6 = 1;
        }
        riVar.g(i, i6);
    }

    public void i(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.e(z);
        }
        w0();
    }

    @Override // com.tencent.mapsdk.internal.e1
    public boolean isOpaque() {
        return r().isOpaque();
    }

    public void j(int i) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.i(i);
        }
    }

    public void j(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.f(z);
        }
    }

    public boolean j0() {
        ri riVar = this.o;
        boolean z = false;
        if (riVar == null) {
            return false;
        }
        if (riVar.e(O()) == 1) {
            z = true;
        }
        return z;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public float k() {
        return r().getMapFrameRate();
    }

    public void k(int i) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.l(i);
        }
    }

    public void k(boolean z) {
        if (this.o != null) {
            na.a(ma.f, "setIndoorEnabled:" + z);
            this.o.g(z);
        }
    }

    @Deprecated
    public boolean k0() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.N();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.e1
    public int l() {
        return r().getExtSurfaceWidth();
    }

    public void l(int i) {
        this.o.m(i);
    }

    public void l(boolean z) {
        this.o.i(z);
    }

    public void m(int i) {
        d0 d0Var = this.q;
        if (d0Var != null) {
            d0Var.d(i);
        }
    }

    public void m(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.j(z);
        }
    }

    public boolean m0() {
        return this.O;
    }

    @Override // com.tencent.mapsdk.internal.q1
    public String n() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.q();
        }
        return null;
    }

    public void n(int i) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.n(i);
        }
        v vVar = this.B;
        if (vVar != null) {
            vVar.d(i);
        }
    }

    public void n(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.k(z);
        }
    }

    @Deprecated
    public boolean n0() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.Q();
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.q1
    public v1 o() {
        return this.o;
    }

    public void o(int i) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.o(i);
        }
        v vVar = this.B;
        if (vVar != null) {
            vVar.e(i);
        }
    }

    public void o(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.l(z);
        }
    }

    public boolean o0() {
        return this.y;
    }

    @Override // com.tencent.mapsdk.internal.q1
    public String p() {
        ri riVar = this.o;
        if (riVar != null) {
            return riVar.y();
        }
        return null;
    }

    public void p(int i) {
        ri riVar = this.o;
        if (riVar == null) {
            return;
        }
        riVar.p(i);
    }

    public void p(boolean z) {
        this.o.m(z);
    }

    public void p0() {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.a();
        }
    }

    public void q(boolean z) {
        d0 d0Var = this.q;
        if (d0Var != null) {
            d0Var.f(z);
        }
    }

    public ib q0() {
        return this.E.c();
    }

    public void r(boolean z) {
        if (this.O == z) {
            return;
        }
        this.O = z;
        ri riVar = this.o;
        if (riVar != null) {
            riVar.n(z);
        }
    }

    public void r0() {
        List<ne> list = this.d0;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (ne neVar : this.d0) {
            neVar.onMapCameraChangeStopped();
        }
    }

    public void s(boolean z) {
        d0 d0Var = this.q;
        if (d0Var != null) {
            d0Var.g(z);
        }
    }

    public void s0() {
        List<ne> list = this.d0;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (ne neVar : this.d0) {
            neVar.onMapCameraChanged();
        }
    }

    @Deprecated
    public void t(boolean z) {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.p(z);
        }
    }

    public void t0() {
        pe peVar = this.b0;
        if (peVar != null) {
            peVar.onMapLoaded();
        }
    }

    public String toString() {
        v vVar = this.B;
        return vVar != null ? vVar.toString() : "";
    }

    public void u(boolean z) {
        if (this.r != null) {
            this.y = z;
            if (z) {
                C0();
                this.r.d();
                return;
            }
            i0();
            this.r.a();
        }
    }

    public void u0() {
        dh dhVar;
        if (this.o == null) {
            return;
        }
        this.F = false;
        this.N = false;
        w(false);
        hh hhVar = this.M;
        if (hhVar != null) {
            hhVar.b();
        }
        this.q.I();
        this.o.L();
        if (!this.y || (dhVar = this.r) == null) {
            return;
        }
        dhVar.e();
    }

    public void v(boolean z) {
        if (this.M == null) {
            this.M = new hh(this);
        }
        this.M.a(z);
    }

    public void v0() {
        dh dhVar;
        if (!this.y || (dhVar = this.r) == null) {
            return;
        }
        dhVar.e();
    }

    public void w0() {
        this.q.a();
        this.F = true;
    }

    public void x0() {
        ri riVar = this.o;
        if (riVar != null) {
            riVar.U();
        }
    }

    public void y0() {
        if (this.o == null) {
            return;
        }
        a(new a());
    }

    public void z0() {
        dh dhVar;
        if (this.o == null) {
            return;
        }
        this.F = true;
        this.N = true;
        w(true);
        if (this.H) {
            this.q.S();
            this.H = false;
        } else {
            this.q.O();
        }
        a1 a1Var = this.u;
        if (a1Var != null) {
            a1Var.getMapRenderView().j();
        }
        if (this.x) {
            this.o.V();
        }
        if (this.y && (dhVar = this.r) != null) {
            dhVar.f();
        }
        hh hhVar = this.M;
        if (hhVar != null) {
            hhVar.c();
        }
    }
}
