package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ef.class */
public class ef extends v0<n0> implements n0, ne, r4 {
    private yi g;
    private View h;
    private GeoPoint m;
    private boolean n;
    private boolean o;
    private o0 r;
    private int i = 0;
    private int j = 0;
    private float k = 0.5f;
    private float l = 0.5f;
    private boolean p = false;
    private final p5 q = new p5();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ef$a.class */
    public class a implements Runnable {
        public final /* synthetic */ View b;

        public a(View view) {
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ef.this.n) {
                this.b.setVisibility(8);
                return;
            }
            this.b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            ef.this.i = this.b.getMeasuredWidth();
            ef.this.j = this.b.getMeasuredHeight();
            View view = this.b;
            view.layout(0, 0, view.getMeasuredWidth(), this.b.getMeasuredHeight());
            ViewGroup F = ef.this.g.F();
            Rect screenBound = ef.this.getScreenBound(ef.this.g.getMap().getProjection());
            if (screenBound == null) {
                return;
            }
            if (this.b.getParent() == null) {
                F.addView(this.b);
            }
            Rect rect = new Rect();
            F.getLocalVisibleRect(rect);
            if (rect.isEmpty()) {
                this.b.setVisibility(8);
                return;
            }
            if (rect.intersect(screenBound)) {
                this.b.setVisibility(0);
            }
            this.b.setX(screenBound.left);
            this.b.setY(screenBound.top);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ef$b.class */
    public class b implements Runnable {
        public final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e1 f23721c;
        public final /* synthetic */ TencentMap.InfoWindowAdapter d;

        public b(Context context, e1 e1Var, TencentMap.InfoWindowAdapter infoWindowAdapter) {
            this.b = context;
            this.f23721c = e1Var;
            this.d = infoWindowAdapter;
        }

        @Override // java.lang.Runnable
        public void run() {
            ef efVar = ef.this;
            efVar.h = af.a(this.b, this.f23721c, efVar, this.d, efVar.r);
            ef.this.B();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ef$c.class */
    public class c implements Runnable {
        public final /* synthetic */ ViewParent b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f23722c;

        public c(ViewParent viewParent, View view) {
            this.b = viewParent;
            this.f23722c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ViewGroup) this.b).removeView(this.f23722c);
            View view = this.f23722c;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            }
            ef.this.releaseData();
        }
    }

    public ef(yi yiVar, o0 o0Var) {
        this.g = yiVar;
        this.r = o0Var;
        D();
        A();
        this.n = true;
    }

    private void A() {
        yi yiVar = this.g;
        if (yiVar == null || yiVar.getContext() == null) {
            return;
        }
        TencentMap.InfoWindowAdapter infoWindowAdapter = null;
        o0 o0Var = this.r;
        if (o0Var != null) {
            infoWindowAdapter = o0Var.t();
        }
        this.h = af.a(this.g.getContext(), this.g.getMapContext(), this, infoWindowAdapter, this.r);
        o0 o0Var2 = this.r;
        if (o0Var2 != null) {
            setPosition(o0Var2.getPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        View view;
        VectorMap map;
        ViewGroup y;
        yi yiVar = this.g;
        if (yiVar == null || (view = this.h) == null || (map = yiVar.getMap()) == null || map.getProjection() == null || (y = y()) == null) {
            return;
        }
        y.post(new a(view));
    }

    private void C() {
        yi yiVar = this.g;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        this.g.getMap().b((ne) this);
    }

    private void D() {
        yi yiVar = this.g;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        this.g.getMap().a((ne) this);
    }

    private ViewGroup y() {
        yi yiVar = this.g;
        if (yiVar == null) {
            return null;
        }
        return yiVar.F();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        Rect screenBound = getScreenBound(t4Var);
        if (screenBound == null || t4Var == null) {
            return null;
        }
        GeoPoint a2 = t4Var.a(new p5(screenBound.left, screenBound.top));
        GeoPoint a3 = t4Var.a(new p5(screenBound.right, screenBound.bottom));
        if (a2 == null || a3 == null) {
            return null;
        }
        return new Rect(a2.getLongitudeE6(), a2.getLatitudeE6(), a3.getLongitudeE6(), a3.getLatitudeE6());
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void a(MarkerOptions markerOptions) {
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.mapsdk.internal.o4
    public void a(GL10 gl10) {
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public Rect getScreenBound(t4 t4Var) {
        int i;
        float f;
        float f2;
        if (t4Var == null || this.h == null) {
            return null;
        }
        p5 a2 = this.p ? this.q : t4Var.a(this.m);
        if (a2 == null) {
            return null;
        }
        o0 o0Var = this.r;
        int i2 = 0;
        if (o0Var == null || o0Var.getOptions() == null) {
            i = 0;
        } else {
            i2 = this.r.getOptions().getInfoWindowOffsetX();
            i = this.r.getOptions().getInfowindowOffsetY();
        }
        w();
        k();
        float f3 = this.k;
        int i3 = this.i;
        float f4 = (i2 * 1.0f) / i3;
        float f5 = this.l;
        int i4 = this.j;
        float f6 = (i * 1.0f) / i4;
        int i5 = (int) (a2.b - (f * (f3 - f4)));
        int i6 = (int) (a2.f23992c - (f2 * (f5 - f6)));
        return new Rect(i5, i6, i3 + i5, i4 + i6);
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void e(boolean z) {
        if (this.h == null) {
            return;
        }
        this.n = z;
        B();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public boolean isRemoved() {
        return this.o;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public boolean isVisible() {
        return r();
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void k() {
        if (this.r == null || this.g.getContext() == null) {
            return;
        }
        int height = (int) (this.r.getHeight(this.g.getContext()) * this.r.getAnchorV());
        int i = this.j;
        float f = 1.0f;
        if (this.r.getOptions() != null) {
            f = this.r.getOptions().getInfoWindowAnchorV();
        }
        int i2 = i;
        if (i == 0) {
            i2 = 1;
        }
        float f2 = height;
        float f3 = i2;
        this.l = (f2 + (f * f3)) / f3;
    }

    @Override // com.tencent.mapsdk.internal.r4
    public View o() {
        return this.h;
    }

    @Override // com.tencent.mapsdk.internal.ne
    public void onMapCameraChangeStopped() {
        B();
    }

    @Override // com.tencent.mapsdk.internal.ne
    public void onMapCameraChanged() {
        B();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        yi yiVar;
        Rect screenBound;
        if (this.h == null || !this.n || (yiVar = this.g) == null || yiVar.getMap() == null || this.g.getMap().getProjection() == null || (screenBound = getScreenBound(this.g.getMap().getProjection())) == null || screenBound.isEmpty()) {
            return false;
        }
        return screenBound.contains((int) f, (int) f2);
    }

    @Override // com.tencent.mapsdk.internal.r4
    public boolean r() {
        View view;
        return this.n && (view = this.h) != null && view.getVisibility() == 0;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
        C();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void remove() {
        View view = this.h;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).post(new c(parent, view));
        }
        this.o = true;
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setAnchor(float f, float f2) {
        B();
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setFixingPoint(int i, int i2) {
        setFixingPointEnable(true);
        this.q.e(i, i2);
        B();
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setFixingPointEnable(boolean z) {
        this.p = z;
        if (z) {
            C();
        } else {
            D();
        }
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        GeoPoint geoPoint = this.m;
        if (geoPoint == null) {
            this.m = GeoPoint.from(latLng);
        } else {
            geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
            this.m.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        }
        B();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Visible
    public void setVisible(boolean z) {
        e(z);
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void u() {
        yi yiVar = this.g;
        if (yiVar == null) {
            return;
        }
        o0 o0Var = this.r;
        TencentMap.InfoWindowAdapter t = o0Var != null ? o0Var.t() : null;
        Context context = yiVar.getContext();
        rc mapContext = yiVar.getMapContext();
        ViewGroup y = y();
        if (y != null) {
            y.post(new b(context, mapContext, t));
        }
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void w() {
        if (this.r == null || this.g.getContext() == null) {
            return;
        }
        int width = this.r.getWidth(this.g.getContext());
        float infoWindowAnchorU = this.r.getOptions() != null ? this.r.getOptions().getInfoWindowAnchorU() : 0.5f;
        int i = this.i;
        int i2 = i;
        if (i == 0) {
            i2 = 1;
        }
        this.k = infoWindowAnchorU + ((width * (this.r.getAnchorU() - 0.5f)) / i2);
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: z */
    public n0 x() {
        return this;
    }
}
