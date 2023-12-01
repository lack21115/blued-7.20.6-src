package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.timepicker.TimeModel;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.ReturnCallback;
import com.tencent.map.tools.Util;
import com.tencent.mapsdk.engine.jni.models.TappedElement;
import com.tencent.mapsdk.internal.h1;
import com.tencent.mapsdk.internal.q1;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi.class */
public class yi extends gj implements TencentMap.OnCameraChangeListener {
    private GeoPoint A0;
    private boolean B0;
    private boolean C0;
    private volatile boolean D0;
    private boolean E0;
    private int F0;
    private int G0;
    private boolean H0;
    public final byte[] I;
    public boolean I0;
    private String J;
    public boolean J0;
    private boolean K;
    public boolean K0;
    public int L;
    public boolean L0;
    private wh M;
    public boolean M0;
    private ug N;
    private int N0;
    private qh O;
    private int O0;
    public eg P;
    private float P0;
    private b0 Q;
    private boolean Q0;
    public AnimationListener R;
    private boolean R0;
    private List<c5> S;
    public LatLng S0;
    private List<i5> T;
    public LatLng T0;
    public TencentMap.OnMapClickListener U;
    public int U0;
    public c1 V;
    public int V0;
    public List<TencentMap.OnCameraChangeListener> W;
    public int W0;
    public TencentMap.OnMapLongClickListener X;
    public int X0;
    private TencentMap.OnDismissCallback Y;
    public int Y0;
    public TencentMap.OnIndoorStateChangeListener Z;
    public int Z0;
    public TencentMap.OnMarkerClickListener a0;
    public int a1;
    public TencentMap.OnInfoWindowClickListener b0;
    private final w4 b1;
    public TencentMap.OnMapPoiClickListener c0;
    private w5 c1;
    private final b1 d0;
    public boolean d1;
    private yf e0;
    public o0 e1;
    private final h5 f0;
    private boolean f1;
    private Handler g0;
    private ff g1;
    public TencentMap.CancelableCallback h0;
    private vf h1;
    public TencentMap.OnCompassClickedListener i0;
    private TencentMap.OnTrafficEventClickListener i1;
    private h1.g j0;
    private List<o0> j1;
    private l5 k0;
    private List<MapPoi> k1;
    private TencentMap.OnScaleViewChangedListener l0;
    private List<d1> l1;
    private TencentMap.OnCameraChangeListener m0;
    private TencentMap.OnCameraChangeListener n0;
    private Handler o0;
    private long p0;
    private yd q0;
    private Bitmap.Config r0;
    private int s0;
    private int t0;
    private int u0;
    private int v0;
    public float w0;
    public float x0;
    public float y0;
    public float z0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi$a.class */
    public class a implements Callback<u4> {
        public final /* synthetic */ u4[] b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GL10 f24443c;

        public a(u4[] u4VarArr, GL10 gl10) {
            this.b = u4VarArr;
            this.f24443c = gl10;
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(u4 u4Var) {
            if (u4Var instanceof v0) {
                if (!TextUtils.equals(u4Var.getId(), yi.this.J)) {
                    u4Var.a(this.f24443c);
                } else if (u4Var.isVisible() || yi.this.H0) {
                    this.b[0] = u4Var;
                } else {
                    u4Var.releaseData();
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi$b.class */
    public class b implements ReturnCallback<Boolean, u4> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24444a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object[] f24445c;

        public b(float f, float f2, Object[] objArr) {
            this.f24444a = f;
            this.b = f2;
            this.f24445c = objArr;
        }

        @Override // com.tencent.map.tools.ReturnCallback
        /* renamed from: a */
        public Boolean callback(u4 u4Var) {
            if (u4Var instanceof w0) {
                w0 w0Var = (w0) u4Var;
                r4 j = w0Var.x().j();
                if (!w0Var.getId().equals(yi.this.J) && j != null && j.r()) {
                    boolean onTap = j.onTap(this.f24444a, this.b);
                    this.f24445c[0] = Boolean.valueOf(onTap);
                    if (onTap) {
                        Object[] objArr = this.f24445c;
                        objArr[1] = w0Var;
                        objArr[2] = j;
                        return Boolean.TRUE;
                    }
                }
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi$c.class */
    public class c implements Callback<u4> {
        public c() {
        }

        @Override // com.tencent.map.tools.Callback
        /* renamed from: a */
        public void callback(u4 u4Var) {
            if (u4Var instanceof w0) {
                o0 x = ((w0) u4Var).x();
                if (x.j() != null) {
                    x.hideInfoWindow();
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi$d.class */
    public class d implements ReturnCallback<Boolean, u4> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f24446a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String[] f24447c;

        public d(float f, float f2, String[] strArr) {
            this.f24446a = f;
            this.b = f2;
            this.f24447c = strArr;
        }

        @Override // com.tencent.map.tools.ReturnCallback
        /* renamed from: a */
        public Boolean callback(u4 u4Var) {
            if (u4Var == null || !u4Var.isVisible()) {
                return Boolean.FALSE;
            }
            if ((u4Var instanceof w0) && u4Var.onTap(this.f24446a, this.b)) {
                this.f24447c[0] = u4Var.getId();
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi$e.class */
    public class e implements Runnable {
        public final /* synthetic */ CameraPosition b;

        public e(CameraPosition cameraPosition) {
            this.b = cameraPosition;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<TencentMap.OnCameraChangeListener> list = yi.this.W;
            if (list != null) {
                for (TencentMap.OnCameraChangeListener onCameraChangeListener : list) {
                    if (onCameraChangeListener != null) {
                        onCameraChangeListener.onCameraChange(this.b);
                    }
                }
            }
            if (yi.this.m0 != null) {
                yi.this.m0.onCameraChange(this.b);
            }
            if (yi.this.n0 != null) {
                yi.this.n0.onCameraChange(this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi$f.class */
    public class f implements Runnable {
        public final /* synthetic */ CameraPosition b;

        public f(CameraPosition cameraPosition) {
            this.b = cameraPosition;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<TencentMap.OnCameraChangeListener> list = yi.this.W;
            if (list != null) {
                for (TencentMap.OnCameraChangeListener onCameraChangeListener : list) {
                    if (onCameraChangeListener != null) {
                        onCameraChangeListener.onCameraChangeFinished(this.b);
                    }
                }
            }
            if (yi.this.m0 != null) {
                yi.this.m0.onCameraChangeFinished(this.b);
            }
            if (yi.this.n0 != null) {
                yi.this.n0.onCameraChangeFinished(this.b);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/yi$g.class */
    public class g implements Runnable {
        public final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f24450c;

        public g(boolean z, List list) {
            this.b = z;
            this.f24450c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d1 d1Var : yi.this.l1) {
                d1Var.a(this.b, this.f24450c);
            }
        }
    }

    public yi(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        super(context, tencentMapOptions, viewGroup);
        this.I = new byte[0];
        this.J = "";
        this.K = false;
        this.L = 22;
        this.M = null;
        this.N = null;
        this.Q = null;
        this.R = null;
        this.S = new CopyOnWriteArrayList();
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new CopyOnWriteArrayList();
        this.X = null;
        this.Y = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.e0 = new si(this);
        this.h0 = null;
        this.i0 = null;
        this.j0 = null;
        this.l0 = null;
        this.m0 = null;
        this.n0 = null;
        this.r0 = Bitmap.Config.RGB_565;
        this.s0 = Integer.MIN_VALUE;
        this.t0 = Integer.MIN_VALUE;
        this.u0 = Integer.MIN_VALUE;
        this.v0 = Integer.MIN_VALUE;
        this.w0 = 0.5f;
        this.x0 = 0.5f;
        this.y0 = 0.5f;
        this.z0 = 0.5f;
        this.A0 = null;
        this.B0 = false;
        this.C0 = true;
        this.D0 = false;
        this.E0 = false;
        this.F0 = 0;
        this.G0 = 0;
        this.H0 = false;
        this.I0 = true;
        this.J0 = true;
        this.K0 = true;
        this.L0 = true;
        this.M0 = true;
        this.N0 = 19;
        this.O0 = 3;
        this.P0 = 0.0f;
        this.Q0 = true;
        this.R0 = true;
        this.S0 = null;
        this.T0 = null;
        this.U0 = 0;
        this.V0 = 0;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 0;
        this.Z0 = 0;
        this.a1 = 0;
        this.d1 = false;
        this.e1 = null;
        this.f1 = false;
        this.j1 = new ArrayList();
        this.k1 = new ArrayList();
        this.l1 = new ArrayList();
        this.f0 = new dj(this);
        this.b1 = new wi(this);
        this.e0 = new si(this);
        this.k0 = new ui(this);
        this.d0 = new ti(this);
        int[] c2 = g7.c(getContext());
        this.Z0 = c2[0];
        this.a1 = c2[1];
    }

    private Bitmap a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), null);
        canvas.drawBitmap(bitmap2, this.O.d().left, this.O.d().top, (Paint) null);
        return createBitmap;
    }

    private void a(Handler handler, GL10 gl10) {
        if (gl10 == null || handler == null) {
            return;
        }
        int i = this.Z0;
        int i2 = this.a1;
        int i3 = i * i2;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        gl10.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                break;
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
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(iArr2, i, i2, this.r0);
        } catch (OutOfMemoryError e2) {
        }
        x1 x1Var = this.A;
        Bitmap bitmap2 = bitmap;
        if (x1Var != null) {
            bitmap2 = bitmap;
            if (!(x1Var instanceof ij)) {
                bitmap2 = bitmap;
                if (this.O.u()) {
                    bitmap2 = a(bitmap, this.O.f());
                }
            }
        }
        handler.sendMessage(handler.obtainMessage(0, bitmap2));
    }

    private void a(TencentMapOptions tencentMapOptions) {
        Context applicationContext = getContext().getApplicationContext();
        String j = h0().j();
        bj bjVar = new bj(this, j);
        this.q0 = bjVar;
        bjVar.a(true);
        qf.a(applicationContext, j);
        a(this.q0, zg.c());
        getMap().e(((k3) n2.a(k3.class)).j());
        q3 q3Var = (q3) n2.a(q3.class);
        String satelliteVersion = tencentMapOptions != null ? tencentMapOptions.getSatelliteVersion() : null;
        String str = satelliteVersion;
        if (TextUtils.isEmpty(satelliteVersion)) {
            str = "0";
        }
        String satelliteUrl = ((c3) q3Var.d()).satelliteUrl(TimeModel.NUMBER_FORMAT, TimeModel.NUMBER_FORMAT, TimeModel.NUMBER_FORMAT, str);
        if (!q3Var.b() || TextUtils.isEmpty(satelliteUrl)) {
            return;
        }
        na.c(ma.f, "satelliteUrl = " + satelliteUrl);
        getMap().f(satelliteUrl);
    }

    private boolean a(TappedElement tappedElement) {
        rc A = A();
        boolean z = false;
        if (A != null) {
            if (A.e0() == null) {
                return false;
            }
            TrafficEvent a2 = A.e0().a((int) tappedElement.itemId);
            TencentMap.OnTrafficEventClickListener onTrafficEventClickListener = this.i1;
            z = false;
            if (onTrafficEventClickListener != null) {
                z = false;
                if (a2 != null) {
                    onTrafficEventClickListener.onTrafficEventClicked(a2);
                    z = true;
                }
            }
        }
        return z;
    }

    private boolean a(u4 u4Var, float f2, float f3) {
        if (u4Var != null && u4Var.isVisible() && u4Var.handleOnTap()) {
            return u4Var.onTap(f2, f3);
        }
        return false;
    }

    private boolean a(w0 w0Var, float f2, float f3) {
        if (getMap() == null) {
            return false;
        }
        if (w0Var == null) {
            a("", true);
            return true;
        }
        o0 x = w0Var.x();
        String id = x.getId();
        TencentMap.OnMarkerClickListener onMarkerClickListener = this.a0;
        if (onMarkerClickListener == null || !onMarkerClickListener.onMarkerClick(w0Var)) {
            if (w0Var.isInfoWindowEnable()) {
                if (this.d1) {
                    if (x.j() == null) {
                        x.showInfoWindow();
                    } else if (x.isInfoWindowShown()) {
                        x.hideInfoWindow();
                    } else {
                        x.showInfoWindow();
                        this.e1 = x;
                    }
                    a(id, true);
                    return true;
                }
                o0 o0Var = this.e1;
                if (o0Var == null) {
                    x.showInfoWindow();
                    this.e1 = x;
                    return true;
                } else if (o0Var != x) {
                    o0Var.hideInfoWindow();
                    x.showInfoWindow();
                    this.e1 = x;
                    return true;
                } else {
                    boolean z = false;
                    if (x.j() != null) {
                        z = false;
                        if (x.j().r()) {
                            z = true;
                        }
                    }
                    if (z) {
                        x.hideInfoWindow();
                        this.e1 = null;
                        return true;
                    }
                    x.showInfoWindow();
                    this.e1 = x;
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(x0 x0Var, float f2, float f3) {
        TencentMap.OnPolygonClickListener onPolygonClickListener;
        if (!x0Var.isClickable() || (onPolygonClickListener = this.D) == null) {
            return false;
        }
        onPolygonClickListener.onPolygonClick(x0Var, getMapContext().getProjection().fromScreenLocation(new Point((int) f2, (int) f3)));
        return true;
    }

    private boolean a(y0 y0Var, float f2, float f3) {
        TencentMap.OnPolylineClickListener onPolylineClickListener;
        if (!y0Var.isClickable() || (onPolylineClickListener = this.C) == null) {
            return false;
        }
        onPolylineClickListener.onPolylineClick(y0Var, getMapContext().getProjection().fromScreenLocation(new Point((int) f2, (int) f3)));
        return true;
    }

    private boolean a(LatLng latLng, x5[] x5VarArr) {
        if (latLng == null) {
            return false;
        }
        x5 b2 = y.b(GeoPoint.from(latLng));
        boolean z = false;
        if (b2.b() >= x5VarArr[0].b()) {
            z = false;
            if (b2.b() <= x5VarArr[1].b()) {
                z = false;
                if (b2.c() <= x5VarArr[0].c()) {
                    z = false;
                    if (b2.c() >= x5VarArr[1].c()) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private boolean a(x5[] x5VarArr) {
        x5[] m0 = m0();
        if (m0 == null || x5VarArr == null) {
            return true;
        }
        return th.a(m0, x5VarArr);
    }

    private void b(Handler handler, GL10 gl10) {
        qh qhVar = this.O;
        if (qhVar != null) {
            qhVar.n();
        }
        a(handler, gl10);
        qh qhVar2 = this.O;
        if (qhVar2 != null) {
            qhVar2.m();
        }
    }

    private void b(GL10 gl10) {
        i1 Z;
        if (getMapContext() == null || (Z = getMapContext().Z()) == null) {
            return;
        }
        synchronized (this.I) {
            u4[] u4VarArr = new u4[1];
            u4VarArr[0] = null;
            Util.foreach(Z.f(), new a(u4VarArr, gl10));
            if (u4VarArr[0] != null) {
                u4VarArr[0].a(gl10);
            }
        }
    }

    private void e0() {
        if (!Y()) {
            ff ffVar = this.g1;
            if (ffVar != null) {
                ffVar.onTalkBackDeActivate(this.A.getView());
                this.g1 = null;
                return;
            }
            return;
        }
        x1 x1Var = this.A;
        if (x1Var instanceof View) {
            if (this.g1 == null) {
                this.g1 = new ff((View) x1Var, this);
            }
            this.g1.onTalkBackActivate(this.A.getView());
        }
    }

    private boolean f0() {
        return this.M.g();
    }

    private x5[] k0() {
        return new x5[]{y.b(getMap().getProjection().a(new p5(0.0d, 0.0d))), y.b(getMap().getProjection().a(new p5(X(), V())))};
    }

    @Override // com.tencent.mapsdk.internal.a1
    public int C() {
        return this.u0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean D() {
        return this.C0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void E() {
        synchronized (this.I) {
            A().Z().a();
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean G() {
        return this.K0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public int H() {
        return this.s0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public String I() {
        return this.J;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public CameraPosition J() {
        VectorMap map = getMap();
        GeoPoint s = map.s();
        if (s != null) {
            List<TencentMap.OnCameraChangeListener> list = this.W;
            if ((list == null || list.size() <= 0) && this.b1 == null) {
                return null;
            }
            LatLng d2 = fa.d(s);
            float T = map.T();
            float f2 = T;
            if (T < 0.0f) {
                f2 = (T % 360.0f) + 360.0f;
            }
            return CameraPosition.builder().zoom(map.M().x()).target(d2).bearing(f2).tilt(map.Z()).build();
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void K() {
        if (this.S.isEmpty()) {
            return;
        }
        v5 v5Var = new v5();
        v5Var.f24371a = 0;
        v5Var.b = this.Q0;
        v5Var.f24372c = this.R0;
        for (c5 c5Var : this.S) {
            c5Var.a(v5Var);
        }
    }

    @Override // com.tencent.mapsdk.internal.r1
    public void L() {
        super.L();
        if (this.B0) {
            t();
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean M() {
        return this.M0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void N() {
        int V = getMap().V();
        this.Q0 = true;
        this.R0 = true;
        if (V <= this.O0) {
            this.R0 = false;
        } else if (V >= this.N0) {
            this.Q0 = false;
        }
        if (this.S.isEmpty()) {
            return;
        }
        v5 v5Var = new v5();
        v5Var.f24371a = 0;
        v5Var.b = this.Q0;
        v5Var.f24372c = this.R0;
        for (c5 c5Var : this.S) {
            c5Var.a(v5Var);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean O() {
        return this.J0;
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.r1
    public void P() {
        super.P();
        wh whVar = new wh(this);
        this.M = whVar;
        whVar.a(this.k, OverSeaSource.DEFAULT, null);
        this.N0 = getMap().P();
        this.O0 = getMap().R();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public ze a(String str) {
        if (getMapContext() != null) {
            u4 b2 = getMapContext().Z().b(str);
            if (b2 instanceof v0) {
                p0 x = ((v0) b2).x();
                if (x instanceof ze) {
                    return (ze) x;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(int i, int i2) {
        this.s0 = i;
        this.t0 = i2;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(Context context, TencentMapOptions tencentMapOptions) {
        a(tencentMapOptions);
        if (getMap().j0()) {
            getMap().setMapStyle(5);
        } else {
            getMap().setMapStyle(0);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(Handler handler, Bitmap.Config config, int i) {
        this.o0 = handler;
        this.r0 = config;
        if (i > 0) {
            this.p0 = System.currentTimeMillis() + i;
        } else {
            this.p0 = Long.MAX_VALUE;
        }
        h();
        a();
    }

    public void a(bf bfVar) {
        ff ffVar;
        if (bfVar == null || (ffVar = this.g1) == null) {
            return;
        }
        ffVar.a(bfVar);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(c1 c1Var) {
        this.V = c1Var;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(c5 c5Var) {
        this.S.remove(c5Var);
    }

    public void a(d1 d1Var) {
        this.l1.remove(d1Var);
        this.l1.add(d1Var);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(eg egVar) {
        this.P = egVar;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(h1.g gVar) {
        this.j0 = gVar;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(i5 i5Var) {
        if (i5Var == null) {
            return;
        }
        if (this.T == null) {
            this.T = new ArrayList();
        }
        if (this.T.contains(i5Var)) {
            return;
        }
        this.T.add(i5Var);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(qh qhVar) {
        this.O = qhVar;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        List<TencentMap.OnCameraChangeListener> list = this.W;
        if (list != null && onCameraChangeListener != null) {
            list.add(onCameraChangeListener);
        }
        g(onCameraChangeListener == null);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(TencentMap.OnDismissCallback onDismissCallback) {
        this.Y = onDismissCallback;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.Z = onIndoorStateChangeListener;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        this.c0 = onMapPoiClickListener;
    }

    public void a(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        this.l0 = onScaleViewChangedListener;
    }

    public void a(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        this.i1 = onTrafficEventClickListener;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(OverSeaTileProvider overSeaTileProvider) {
        wh whVar = this.M;
        if (whVar != null) {
            whVar.a(overSeaTileProvider);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(TencentMapGestureListener tencentMapGestureListener) {
        TencentMapGestureListenerList tencentMapGestureListenerList = this.o;
        if (tencentMapGestureListenerList == null) {
            return;
        }
        tencentMapGestureListenerList.removeListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(String str, boolean z) {
        a(str, z, false);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(String str, boolean z, boolean z2) {
        synchronized (this.I) {
            if (!z2) {
                this.J = str;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.hj.n
    public void a(GL10 gl10, int i, int i2) {
        super.a(gl10, i, i2);
        this.Z0 = i;
        this.a1 = i2;
        a((int) (i * this.w0), (int) (i2 * this.x0));
        b((int) (this.Z0 * this.y0), (int) (this.a1 * this.z0));
        h1.g gVar = this.j0;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.hj.n
    public void a(GL10 gl10, EGLConfig eGLConfig) {
        ra.h(qa.X);
        super.a(gl10, eGLConfig);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(boolean z) {
        this.f1 = z;
    }

    public void a(boolean z, List<zh> list) {
        ca.a(new g(z, list));
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean a(float f2, float f3) {
        IndoorMapPoi mapPoi;
        TappedElement e2 = getMap().e(f2, f3);
        if (e2 != null) {
            int i = e2.type;
            if (i != 1) {
                return i != 4 ? i == 8 : a(e2);
            } else if (this.c0 != null) {
                if (e2.itemType == 1) {
                    IndoorMapPoi indoorMapPoi = new IndoorMapPoi();
                    indoorMapPoi.buildingName = e2.buildingName;
                    indoorMapPoi.buildingId = e2.buildingId;
                    indoorMapPoi.floorName = e2.floorName;
                    mapPoi = indoorMapPoi;
                } else {
                    mapPoi = new MapPoi();
                }
                mapPoi.name = e2.name;
                mapPoi.position = fa.b(e2.pixelX, e2.pixelY).toLatLng();
                mapPoi.poiId = e2.poiId;
                this.c0.onClicked(mapPoi);
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean a(MotionEvent motionEvent) {
        ff ffVar = this.g1;
        if (ffVar != null) {
            return ffVar.dispatchHoverEvent(motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.hj.n
    public boolean a(GL10 gl10) {
        b(gl10);
        boolean a2 = super.a(gl10);
        if (this.o0 != null && System.currentTimeMillis() > this.p0) {
            na.a(ma.f, "snapShot : 1");
            b(this.o0, gl10);
            this.o0 = null;
        }
        if ((this.o0 != null || !this.q) && getMap() != null && getMap().f0() && n0() != null && n0().f() && B()) {
            if (!this.q) {
                n(true);
            }
            na.a(ma.f, "snapShot : 2");
            b(this.o0, gl10);
            this.o0 = null;
        }
        return a2;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void b(float f2) {
        TencentMap.OnScaleViewChangedListener onScaleViewChangedListener = this.l0;
        if (onScaleViewChangedListener != null) {
            onScaleViewChangedListener.onScaleViewChanged(f2);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void b(int i, int i2) {
        this.u0 = i;
        this.v0 = i2;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void b(c5 c5Var) {
        this.S.remove(c5Var);
        this.S.add(c5Var);
    }

    public void b(d1 d1Var) {
        this.l1.remove(d1Var);
    }

    public void b(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        this.n0 = onCameraChangeListener;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void b(TencentMapGestureListener tencentMapGestureListener) {
        if (this.o == null) {
            this.o = new TencentMapGestureListenerList();
        }
        this.o.addListener(tencentMapGestureListener);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void b(boolean z) {
        this.L0 = z;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean b() {
        return this.f1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078 A[Catch: all -> 0x01d5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0009, B:7:0x001e, B:8:0x0028, B:14:0x003e, B:16:0x0048, B:22:0x0078, B:24:0x0092, B:27:0x00d2, B:29:0x00d9, B:35:0x00ea, B:37:0x00f4, B:39:0x0117, B:41:0x013c, B:44:0x013f, B:47:0x014c, B:51:0x0151), top: B:86:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2 A[Catch: all -> 0x01d5, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0009, B:7:0x001e, B:8:0x0028, B:14:0x003e, B:16:0x0048, B:22:0x0078, B:24:0x0092, B:27:0x00d2, B:29:0x00d9, B:35:0x00ea, B:37:0x00f4, B:39:0x0117, B:41:0x013c, B:44:0x013f, B:47:0x014c, B:51:0x0151), top: B:86:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013f A[Catch: all -> 0x01d5, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0009, B:7:0x001e, B:8:0x0028, B:14:0x003e, B:16:0x0048, B:22:0x0078, B:24:0x0092, B:27:0x00d2, B:29:0x00d9, B:35:0x00ea, B:37:0x00f4, B:39:0x0117, B:41:0x013c, B:44:0x013f, B:47:0x014c, B:51:0x0151), top: B:86:0x0009 }] */
    /* JADX WARN: Type inference failed for: r0v92, types: [com.tencent.tencentmap.mapsdk.maps.model.Marker] */
    @Override // com.tencent.mapsdk.internal.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(float r9, float r10) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.yi.b(float, float):boolean");
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean b(String str) {
        if (str == null) {
            return false;
        }
        boolean a2 = A().Z().a(str);
        if (a2) {
            getMap().v0();
        }
        return a2;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public GeoPoint c() {
        if (this.A0 == null) {
            if (this.s0 == Integer.MIN_VALUE) {
                this.s0 = this.Z0 / 2;
            }
            if (this.t0 == Integer.MIN_VALUE) {
                this.t0 = this.a1 / 2;
            }
            this.A0 = getMap().getProjection().a(new p5(this.s0, this.t0));
        }
        return this.A0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public String c(float f2, float f3) {
        String[] strArr = {null};
        synchronized (this.I) {
            Util.where(getMapContext().Z().f(), new d(f2, f3, strArr));
        }
        return strArr[0];
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void c(float f2) {
        if (this.P0 == f2) {
            return;
        }
        this.P0 = f2;
        if (this.S.isEmpty()) {
            return;
        }
        v5 v5Var = new v5();
        v5Var.f24371a = 1;
        v5Var.d = getMap().V();
        v5Var.e = getMap().getProjection().a(new Point(0, this.a1 / 2), new Point(this.Z0, this.a1 / 2));
        for (c5 c5Var : this.S) {
            c5Var.a(v5Var);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        if (this.A0 == null) {
            GeoPoint s = getMap().s();
            this.A0 = new GeoPoint(s.getLatitudeE6(), s.getLongitudeE6());
        }
        this.A0.setLatitudeE6(i);
        this.A0.setLongitudeE6(i2);
    }

    public void c(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        this.m0 = onCameraChangeListener;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void c(boolean z) {
        if (this.C0 != z) {
            v5 v5Var = new v5();
            v5Var.f24371a = 2;
            for (c5 c5Var : this.S) {
                c5Var.a(v5Var);
            }
        }
        this.C0 = z;
        getMap().d(z);
        getMap().v0();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public vf d() {
        return this.h1;
    }

    public void d(int i, int i2) {
        List<i5> list = this.T;
        if (list != null) {
            int size = list.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                i5 i5Var = this.T.get(i4);
                if (i5Var != null) {
                    i5Var.a(i, i2);
                }
                i3 = i4 + 1;
            }
        }
        if (getMapContext() != null) {
            getMapContext().Z().a(i, i2);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void d(boolean z) {
        this.M0 = z;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean d(float f2, float f3) {
        if (this.p) {
            return getMap().d(f2, f3);
        }
        return false;
    }

    public void d0() {
        rc mapContext = getMapContext();
        if (mapContext != null) {
            mapContext.a(!a(th.b().c(th.i)));
            wh whVar = this.M;
            if (whVar != null) {
                whVar.b();
            }
            boolean a2 = mapContext.a();
            if (this.O != null) {
                w5 i0 = i0();
                w5 w5Var = i0;
                if (mapContext.A()) {
                    w5Var = i0;
                    if (!mapContext.B()) {
                        w5Var = new w5(y.b(new GeoPoint(new LatLng(39.908823d, 116.39747d))), th.b().c(th.i), 18.0f);
                    }
                }
                this.O.a(w5Var, a2);
                this.O.e(a2);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void e() {
        Handler handler = this.g0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.o0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        List<i5> list = this.T;
        if (list != null) {
            list.clear();
            this.T = null;
        }
        E();
        this.U = null;
        this.b0 = null;
        this.X = null;
        this.i0 = null;
        this.R = null;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void e(boolean z) {
        this.J0 = z;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean e(float f2, float f3) {
        return A().a(f2, f3, this.b1);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean f() {
        return this.L0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean f(float f2, float f3) {
        String c2;
        if (this.V != null && (c2 = c(f2, f3)) != null && c2.trim().length() != 0) {
            this.V.a(c2);
            return true;
        } else if (this.X == null || !this.p) {
            return false;
        } else {
            this.X.onMapLongClick(fa.d(getMap().getProjection().a(new p5(f2, f3))));
            return false;
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void g(boolean z) {
        if (!z || f0()) {
            getMap().a(this.d0);
        } else {
            getMap().a((b1) null);
        }
    }

    public boolean g(float f2, float f3) {
        i1 Z = A().Z();
        List<u4> h = Z.h();
        u4 u4Var = null;
        boolean z = false;
        for (int size = h.size() - 1; size >= 0; size--) {
            u4Var = h.get(size);
            z = a(u4Var, f2, f3);
            if (z) {
                break;
            }
        }
        u4 u4Var2 = u4Var;
        boolean z2 = z;
        if (!z) {
            List<u4> d2 = Z.d();
            z2 = z;
            u4Var2 = u4Var;
            for (int size2 = d2.size() - 1; size2 >= 0; size2--) {
                u4Var2 = d2.get(size2);
                z2 = a(u4Var2, f2, f3);
                if (z2) {
                    break;
                }
            }
        }
        u4 u4Var3 = u4Var2;
        boolean z3 = z2;
        if (!z2) {
            List<Polygon> i = Z.i();
            int size3 = i.size();
            while (true) {
                int i2 = size3 - 1;
                u4Var3 = u4Var2;
                z3 = z2;
                if (i2 < 0) {
                    break;
                }
                u4Var2 = (u4) i.get(i2);
                z2 = a(u4Var2, f2, f3);
                if (z2) {
                    u4Var3 = u4Var2;
                    z3 = z2;
                    break;
                }
                size3 = i2;
            }
        }
        if (z3) {
            if (u4Var3 instanceof w0) {
                return a((w0) u4Var3, f2, f3);
            }
            if (u4Var3 instanceof y0) {
                return a((y0) u4Var3, f2, f3);
            }
            z3 = false;
            if (u4Var3 instanceof x0) {
                return a((x0) u4Var3, f2, f3);
            }
        }
        return z3;
    }

    public qh g0() {
        return this.O;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void h(boolean z) {
        this.K0 = z;
    }

    public q1.b h0() {
        return getMapContext().q();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public b0 i() {
        return this.Q;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void i(boolean z) {
        this.H0 = z;
    }

    public w5 i0() {
        x5[] m0 = m0();
        x5 b2 = y.b(getMap().s());
        float V = getMap().V();
        w5 w5Var = this.c1;
        if (w5Var == null) {
            this.c1 = new w5(b2, m0, V);
        } else {
            w5Var.a(b2, m0, V);
        }
        return this.c1;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean isHandDrawMapEnable() {
        ug ugVar = this.N;
        if (ugVar == null) {
            return false;
        }
        return ugVar.c();
    }

    @Override // com.tencent.mapsdk.internal.v4
    public void j() {
        getMap().o0();
        TencentMap.OnCompassClickedListener onCompassClickedListener = this.i0;
        if (onCompassClickedListener != null) {
            onCompassClickedListener.onCompassClicked();
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void j(boolean z) {
        this.p = z;
    }

    public List<o0> j0() {
        this.j1.clear();
        x5[] k0 = k0();
        for (u4 u4Var : A().Z().h()) {
            if (u4Var instanceof w0) {
                o0 x = ((w0) u4Var).x();
                if (a(x.getPosition(), k0)) {
                    this.j1.add(x);
                }
            }
        }
        return this.j1;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public eg k() {
        return this.P;
    }

    @Override // com.tencent.mapsdk.internal.r1
    public void k(boolean z) {
        super.k(z);
        d0();
    }

    public List<MapPoi> l0() {
        this.k1.clear();
        ArrayList<MapPoi> N = getMap().N();
        this.k1 = N;
        return N;
    }

    public x5[] m0() {
        t4 projection = getMap().getProjection();
        if (projection == null) {
            return null;
        }
        x5[] x5VarArr = new x5[4];
        float f2 = this.Z0;
        float f3 = this.a1;
        if (f2 <= 2.0f || f3 <= 2.0f) {
            return null;
        }
        p5 p5Var = new p5(0.0d, 0.0d);
        double d2 = f2;
        p5 p5Var2 = new p5(d2, 0.0d);
        double d3 = f3;
        p5 p5Var3 = new p5(d2, d3);
        p5 p5Var4 = new p5(0.0d, d3);
        for (int i = 0; i < 4; i++) {
            x5VarArr[i] = y.b(projection.a(new p5[]{p5Var, p5Var2, p5Var3, p5Var4}[i]));
        }
        return x5VarArr;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public int n() {
        return this.v0;
    }

    public boolean n(boolean z) {
        Handler handler = this.g0;
        if (handler == null || !handler.getLooper().getThread().isAlive()) {
            return false;
        }
        na.a(ma.f, "send onStable Event");
        this.g0.sendEmptyMessage(z ? 2 : 1);
        return true;
    }

    public wh n0() {
        return this.M;
    }

    public boolean o0() {
        Handler handler = this.g0;
        if (handler == null || !handler.getLooper().getThread().isAlive()) {
            return false;
        }
        this.g0.sendEmptyMessage(0);
        return true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        this.r = false;
        this.s = true;
        ca.b(new e(cameraPosition));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(CameraPosition cameraPosition) {
        if (this.t == 0 && this.r) {
            this.s = false;
            ca.b(new f(cameraPosition));
        }
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.r1, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        super.onCreated();
        this.g0 = new qi(this, ca.a("gesture"));
        this.h1 = new vf(getMapContext());
        getMap().a(this.e0);
        a(this.b1);
        getMap().a(this.d0);
        getMap().a(this.k0);
        getMap().a(this.e0);
        getMap().a(this.f0);
        getMap().a((v4) this);
        this.Q = new b0(this, h0().j());
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.r1, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        super.onDestroy();
        getMap().a((v4) null);
        List<TencentMap.OnCameraChangeListener> list = this.W;
        if (list != null) {
            list.clear();
        }
        ff ffVar = this.g1;
        if (ffVar != null) {
            ffVar.a();
        }
        this.c0 = null;
        this.i1 = null;
        this.l0 = null;
        this.E0 = true;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorBuildingDeactivated() {
        return getMapContext().Z().a((IndoorBuilding) null);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorBuildingFocused() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener
    public boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        return getMapContext().Z().a(indoorBuilding);
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.r1, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        super.onResume();
        this.t = 0;
        this.s = false;
        e0();
        b0 b0Var = this.Q;
        if (b0Var != null) {
            b0Var.m();
        }
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c1 c1Var = this.V;
        if (c1Var != null) {
            c1Var.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public int q() {
        return this.t0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean r() {
        return this.R0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean s() {
        return this.D0;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void setCompassExtraPadding(int i) {
        this.G0 = i;
        setCompassExtraPadding(this.F0, i);
        a();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void setCompassExtraPadding(int i, int i2) {
        this.F0 = i;
        this.G0 = i2;
        getMap().f(i, i2);
        a();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void setFlingGestureEnabled(boolean z) {
        this.I0 = z;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void setOnTapMapViewInfoWindowHidden(boolean z) {
        this.K = z;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void t() {
        if (this.N == null) {
            this.N = new ug(this);
        }
        this.N.b();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public vh u() {
        return this.M.e();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean v() {
        return this.Q0;
    }

    @Override // com.tencent.mapsdk.internal.gj, com.tencent.mapsdk.internal.hj.n
    public void x() {
        super.x();
        ra.i(qa.X);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void y() {
        ug ugVar = this.N;
        if (ugVar == null) {
            return;
        }
        ugVar.e();
    }

    @Override // com.tencent.mapsdk.internal.r1
    public void z() {
        super.z();
        TencentMapOptions tencentMapOptions = this.l;
        if (tencentMapOptions != null) {
            this.B0 = tencentMapOptions.isHandDrawMapEnable();
            this.d1 = this.l.isMultipleInfoWindowEnable();
        }
    }
}
