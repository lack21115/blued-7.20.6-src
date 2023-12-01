package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gj.class */
public abstract class gj extends r1<rc, VectorMap> implements a1, be, pe {
    private static final int G = 10;
    private static final int H = 16;
    public x1 A;
    private volatile boolean B;
    public TencentMap.OnPolylineClickListener C;
    public TencentMap.OnPolygonClickListener D;
    private TencentMap.InfoWindowAdapter E;
    private boolean F;
    public List<TencentMap.OnMapLoadedCallback> n;
    public TencentMapGestureListenerList o;
    public boolean p;
    public volatile boolean q;
    public volatile boolean r;
    public volatile boolean s;
    public int t;
    private rc u;
    private wf v;
    private sc w;
    private volatile boolean x;
    private float y;
    private int z;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gj$a.class */
    public class a implements Runnable {
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f23803c;
        public final /* synthetic */ float d;
        public final /* synthetic */ float e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ float g;

        /* renamed from: com.tencent.mapsdk.internal.gj$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gj$a$a.class */
        public class RunnableC0790a implements Runnable {
            public RunnableC0790a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                gj.this.u.h().b(a.this.g);
            }
        }

        public a(float f, float f2, float f3, float f4, boolean z, float f5) {
            this.b = f;
            this.f23803c = f2;
            this.d = f3;
            this.e = f4;
            this.f = z;
            this.g = f5;
        }

        @Override // java.lang.Runnable
        public void run() {
            gj.this.y += this.b;
            gj gjVar = gj.this;
            gjVar.a(this.f23803c, gjVar.y, true);
            if (gj.b(gj.this) < 10) {
                ca.a(this, 16L);
                return;
            }
            gj.this.a(this.f23803c, this.d, true);
            float f = this.e;
            if (f < 3.0f || f > 20.0f) {
                return;
            }
            if (!this.f) {
                gj.this.u.h().b(this.g);
                return;
            }
            gj.this.u.h().a((int) this.e, (Runnable) new RunnableC0790a(), false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gj$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (TencentMap.OnMapLoadedCallback onMapLoadedCallback : gj.this.n) {
                if (onMapLoadedCallback != null) {
                    onMapLoadedCallback.onMapLoaded();
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/gj$c.class */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23804a;

        static {
            MapViewType.values();
            int[] iArr = new int[3];
            f23804a = iArr;
            try {
                MapViewType mapViewType = MapViewType.TextureView;
                iArr[1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f23804a;
                MapViewType mapViewType2 = MapViewType.RenderLayer;
                iArr2[2] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f23804a;
                MapViewType mapViewType3 = MapViewType.SurfaceView;
                iArr3[0] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public gj(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        super(context, tencentMapOptions, viewGroup);
        this.n = new CopyOnWriteArrayList();
        this.o = null;
        this.p = true;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.y = 0.5f;
        this.z = 0;
        this.A = null;
    }

    private void U() {
        if (this.w != null) {
            while (!this.w.e()) {
                try {
                    this.w.a();
                    this.w.c();
                } catch (InterruptedException e) {
                    na.c(Log.getStackTraceString(e));
                }
                if (!this.w.isAlive()) {
                    break;
                }
                this.w.join();
            }
        }
        this.w = null;
        this.x = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2, boolean z) {
        this.u.h().a(f, f2, 0, z);
    }

    public static /* synthetic */ int b(gj gjVar) {
        int i = gjVar.z;
        gjVar.z = i + 1;
        return i;
    }

    private void c0() {
        long currentTimeMillis = System.currentTimeMillis();
        w6 w = getMapContext().w();
        if (w != null) {
            w.l().b(true, currentTimeMillis);
        }
        this.B = false;
    }

    private float d(float f) {
        int i = (int) f;
        return (1 << (i - 3)) * 3.0517578E-5f * ((float) Math.pow(2.0d, f - i));
    }

    @Override // com.tencent.mapsdk.internal.a1
    public rc A() {
        return this.u;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean B() {
        rc rcVar = this.u;
        return rcVar != null && rcVar.k0();
    }

    @Override // com.tencent.mapsdk.internal.r1
    public void P() {
        super.P();
        a(this.k, this.l);
    }

    public int V() {
        x1 x1Var = this.A;
        if (x1Var != null) {
            return x1Var.getHeight();
        }
        return Integer.MAX_VALUE;
    }

    public TencentMap.InfoWindowAdapter W() {
        return this.E;
    }

    public int X() {
        x1 x1Var = this.A;
        if (x1Var != null) {
            return x1Var.getWidth();
        }
        return Integer.MAX_VALUE;
    }

    public boolean Y() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        boolean isEnabled = accessibilityManager.isEnabled();
        if (Build.VERSION.SDK_INT < 14) {
            return isEnabled;
        }
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        boolean z = false;
        if (isEnabled) {
            z = false;
            if (isTouchExplorationEnabled) {
                z = true;
            }
        }
        return z;
    }

    public void Z() {
        if (!this.q) {
            ca.b(new b());
        }
        this.q = true;
    }

    @Override // com.tencent.mapsdk.internal.r1
    /* renamed from: a */
    public x1 b(rc rcVar, ViewGroup viewGroup) {
        int ordinal = T().ordinal();
        x1 kjVar = ordinal != 1 ? ordinal != 2 ? new kj(rcVar) : new ij(rcVar) : new jj(rcVar);
        if (viewGroup != null) {
            viewGroup.addView(kjVar.getView());
        }
        return kjVar;
    }

    @Override // com.tencent.mapsdk.internal.r1
    /* renamed from: a */
    public VectorMap b(rc rcVar) {
        return new VectorMap(rcVar);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a() {
        x1 x1Var = this.A;
        if (x1Var != null) {
            x1Var.j();
        }
        rc rcVar = this.u;
        if (rcVar != null) {
            rcVar.w0();
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(de deVar) {
        this.u.a(deVar);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(w4 w4Var) {
        this.v.a(w4Var);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void a(yd ydVar, ib ibVar) {
        if (this.u.a(this.k.getApplicationContext(), ydVar, ibVar, this)) {
            this.u.h().z();
        }
    }

    public void a(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        this.E = infoWindowAdapter;
    }

    public void a(TencentMap.OnPolygonClickListener onPolygonClickListener) {
        this.D = onPolygonClickListener;
    }

    public void a(TencentMap.OnPolylineClickListener onPolylineClickListener) {
        this.C = onPolylineClickListener;
    }

    public void a(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.u.a(onVectorOverlayClickListener);
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public void a(GL10 gl10, int i, int i2) {
        this.u.h(i, i2);
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public void a(GL10 gl10, EGLConfig eGLConfig) {
        this.u.a(gl10);
    }

    @Override // com.tencent.mapsdk.internal.be
    public boolean a(int i) {
        rc rcVar = this.u;
        if (rcVar != null) {
            return rcVar.h(i);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public boolean a(GL10 gl10) {
        return this.u.c(gl10);
    }

    public void a0() {
        this.r = true;
        TencentMapGestureListenerList tencentMapGestureListenerList = this.o;
        if (tencentMapGestureListenerList == null || !this.p) {
            return;
        }
        tencentMapGestureListenerList.onMapStable();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void b(w4 w4Var) {
        this.v.b(w4Var);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean b(int i) {
        rc rcVar = this.u;
        if (rcVar == null) {
            return false;
        }
        return rcVar.a(i);
    }

    public void b0() {
        x1 x1Var = this.A;
        if (x1Var != null) {
            x1Var.j();
        }
    }

    @Override // com.tencent.mapsdk.internal.r1
    /* renamed from: c */
    public rc b(Context context, TencentMapOptions tencentMapOptions) {
        rc rcVar = new rc(context, tencentMapOptions, this);
        this.u = rcVar;
        return rcVar;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void f(boolean z) {
        this.u.p(z);
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void g() {
        if (this.w == null && this.u != null) {
            this.w = new sc(this.u);
        }
        if (this.x) {
            return;
        }
        try {
            this.w.start();
            this.x = true;
        } catch (Exception e) {
            na.f("startTextureCreatorIfNeed failed", e);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public Context getContext() {
        return this.k;
    }

    @Override // com.tencent.mapsdk.internal.a1, com.tencent.mapsdk.internal.me
    public int getEGLContextHash() {
        EGLContext eglGetCurrentContext;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        if (egl10 == null || (eglGetCurrentContext = egl10.eglGetCurrentContext()) == null) {
            return 0;
        }
        return eglGetCurrentContext.hashCode();
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void h() {
        rc rcVar = this.u;
        if (rcVar != null) {
            rcVar.K();
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public TencentMapOptions l() {
        return this.l;
    }

    public void l(boolean z) {
        this.B = z;
    }

    public void m(boolean z) {
        x1 x1Var = this.A;
        if (x1Var != null) {
            x1Var.setZOrderMediaOverlay(z);
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public boolean m() {
        return this.q;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public yd o() {
        rc rcVar = this.u;
        if (rcVar == null) {
            return null;
        }
        return rcVar.M();
    }

    @Override // com.tencent.mapsdk.internal.r1, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        super.onCreated();
        this.A = getMapRenderView();
        this.v = new wf(this);
        this.B = true;
        getMap().a((pe) this);
    }

    @Override // com.tencent.mapsdk.internal.r1, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mapsdk.internal.pe
    public void onMapLoaded() {
        if (this.B) {
            c0();
        }
    }

    @Override // com.tencent.mapsdk.internal.r1, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onPause() {
        super.onPause();
        sc scVar = this.w;
        if (scVar != null) {
            scVar.a();
        }
        this.u.u0();
    }

    @Override // com.tencent.mapsdk.internal.r1, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        super.onResume();
        sc scVar = this.w;
        if (scVar != null) {
            scVar.b();
        }
        this.u.z0();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean onTouchEvent(MotionEvent motionEvent) {
        wf wfVar = this.v;
        if (wfVar != null) {
            return wfVar.onTouch(null, motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void p() {
        U();
        if (this.u != null) {
            getEGLContextHash();
            this.u.J();
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public void setMapCenterAndScale(float f, float f2, float f3) {
        rc rcVar = this.u;
        if (rcVar != null) {
            float q = rcVar.h().q();
            float d = d(f3);
            boolean z = ((double) Math.abs(q - d)) > 1.0E-4d;
            this.z = 0;
            ca.b(new a((f2 - this.y) / 10.0f, f, f2, f3, z, d));
        }
    }

    @Override // com.tencent.mapsdk.internal.a1
    public qc w() {
        return this.u.U();
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public void x() {
    }
}
