package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.col.p0003sl.ee;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* renamed from: com.amap.api.col.3sl.eg  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/eg.class */
public final class eg extends ViewGroup implements eh {
    ei a;
    au b;
    private IAMapDelegate c;
    private IGlOverlayLayer d;
    private Context e;
    private ek f;
    private ef g;
    private ed h;
    private ej i;
    private ec j;
    private ee k;
    private el l;
    private View m;
    private BasePointOverlay n;
    private Drawable o;
    private boolean p;
    private View q;
    private boolean r;
    private boolean s;
    private boolean t;

    /* renamed from: com.amap.api.col.3sl.eg$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/eg$a.class */
    public static final class a extends ViewGroup.LayoutParams {
        public FPoint a;
        public boolean b;
        public int c;
        public int d;
        public int e;

        public a(int i, int i2, float f, float f2, int i3, int i4, int i5) {
            super(i, i2);
            FPoint fPoint = new FPoint();
            this.a = fPoint;
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = 51;
            fPoint.x = f;
            this.a.y = f2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        public a(FPoint fPoint, int i) {
            this(-2, -2, fPoint.x, fPoint.y, 0, 0, i);
        }
    }

    public eg(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        this.o = null;
        int i = 1;
        this.p = true;
        this.s = true;
        this.t = true;
        try {
            this.d = iGlOverlayLayer;
            this.c = iAMapDelegate;
            this.e = context;
            this.a = new ei();
            this.j = new ec(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.c.getGLMapView() != null) {
                addView(this.c.getGLMapView(), 0, layoutParams);
            } else {
                i = 0;
            }
            addView(this.j, i, layoutParams);
            if (this.s) {
                return;
            }
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
            dw.a(th);
        }
    }

    private View a(BasePointOverlay basePointOverlay) throws RemoteException {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        if (basePointOverlay instanceof Marker) {
            try {
                if (this.o == null) {
                    this.o = dl.a(this.e, "infowindow_bg.9.png");
                }
            } catch (Throwable th) {
                iw.c(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            View view6 = null;
            try {
                if (this.r) {
                    View a2 = this.b.a(basePointOverlay);
                    view4 = a2;
                    if (a2 == null) {
                        view6 = a2;
                        try {
                            view4 = this.b.b(basePointOverlay);
                        } catch (Throwable th2) {
                            th = th2;
                            iw.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view6;
                        }
                    }
                    View view7 = view4;
                    this.q = view4;
                    View view8 = view4;
                    this.r = false;
                } else {
                    view4 = this.q;
                }
                if (view4 != null) {
                    view5 = view4;
                } else if (!this.b.a()) {
                    return null;
                } else {
                    view6 = view4;
                    view5 = this.b.a(basePointOverlay);
                }
                view = view5;
                if (view5 != null) {
                    view = view5;
                    if (view5.getBackground() == null) {
                        view6 = view5;
                        view5.setBackground(this.o);
                        return view5;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.o == null) {
                    this.o = dl.a(this.e, "infowindow_bg.9.png");
                }
            } catch (Throwable th4) {
                iw.c(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            View view9 = null;
            try {
                if (this.r) {
                    View a3 = this.b.a(basePointOverlay);
                    view2 = a3;
                    if (a3 == null) {
                        view9 = a3;
                        try {
                            view2 = this.b.b(basePointOverlay);
                        } catch (Throwable th5) {
                            th = th5;
                            iw.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            view = view9;
                            return view;
                        }
                    }
                    View view10 = view2;
                    this.q = view2;
                    View view11 = view2;
                    this.r = false;
                } else {
                    view2 = this.q;
                }
                if (view2 != null) {
                    view3 = view2;
                } else if (!this.b.a()) {
                    return null;
                } else {
                    view9 = view2;
                    view3 = this.b.a(basePointOverlay);
                }
                if (view3.getBackground() == null) {
                    view9 = view3;
                    view3.setBackground(this.o);
                }
                return view3;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return view;
    }

    private void a(Context context) {
        ek ekVar = new ek(context);
        this.f = ekVar;
        ekVar.c(this.t);
        this.i = new ej(context, this.c);
        this.k = new ee(context);
        this.l = new el(context, this.c);
        this.g = new ef(context, this.c);
        this.h = new ed(context, this.c);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f, layoutParams);
        addView(this.i, layoutParams);
        addView(this.k, new ViewGroup.LayoutParams(-2, -2));
        addView(this.l, new a(new FPoint(0.0f, 0.0f), 83));
        addView(this.g, new a(FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.h, new a(FPoint.obtain(0.0f, 0.0f), 51));
        this.h.setVisibility(8);
        this.c.setMapWidgetListener(new AMapWidgetListener() { // from class: com.amap.api.col.3sl.eg.1
            public final void invalidateCompassView() {
                if (eg.this.h == null) {
                    return;
                }
                eg.this.h.post(new Runnable() { // from class: com.amap.api.col.3sl.eg.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        eg.this.h.b();
                    }
                });
            }

            public final void invalidateScaleView() {
                if (eg.this.i == null) {
                    return;
                }
                eg.this.i.post(new Runnable() { // from class: com.amap.api.col.3sl.eg.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        eg.this.i.b();
                    }
                });
            }

            public final void invalidateZoomController(final float f) {
                if (eg.this.l == null) {
                    return;
                }
                eg.this.l.post(new Runnable() { // from class: com.amap.api.col.3sl.eg.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        eg.this.l.a(f);
                    }
                });
            }

            public final void setFrontViewVisibility(boolean z) {
            }
        });
        try {
            if (this.c.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.g.setVisibility(8);
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    private void a(View view, int i, int i2, int i3, int i4) throws RemoteException {
        int i5;
        int i6;
        if (view == null) {
            return;
        }
        View view2 = this.m;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.m);
        }
        this.m = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.m.setDrawingCacheEnabled(true);
        this.m.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            i5 = layoutParams.width;
            i6 = layoutParams.height;
        } else {
            i5 = -2;
            i6 = -2;
        }
        addView(this.m, new a(i5, i6, i, i2, i3, i4, 81));
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = i5 & 7;
        int i10 = i5 & 112;
        if (i9 == 5) {
            i6 = i3 - i;
        } else {
            i6 = i3;
            if (i9 == 1) {
                i6 = i3 - (i / 2);
            }
        }
        if (i10 == 80) {
            i7 = i4 - i2;
        } else {
            if (i10 == 17) {
                i8 = i2 / 2;
            } else {
                i7 = i4;
                if (i10 == 16) {
                    i4 /= 2;
                    i8 = i2 / 2;
                }
            }
            i7 = i4 - i8;
        }
        view.layout(i6, i7, i6 + i, i7 + i2);
        if (view instanceof IGLSurfaceView) {
            this.c.changeSize(i, i2);
        }
    }

    private void a(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof ee) {
            a(view, iArr[0], iArr[1], 20, (this.c.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            a(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    private void a(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, aVar.width, aVar.height, iArr);
        if (view instanceof el) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), aVar.e);
        } else if (view instanceof ef) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], aVar.e);
        } else if (view instanceof ed) {
            a(view, iArr[0], iArr[1], 0, 0, aVar.e);
        } else if (aVar.a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.c.getMapConfig();
            GLMapState mapProjection = this.c.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                obtain.x = (int) aVar.a.x;
                obtain.y = (int) aVar.a.y;
            }
            obtain.x += aVar.c;
            obtain.y += aVar.d;
            a(view, iArr[0], iArr[1], obtain.x, obtain.y, aVar.e);
            obtain.recycle();
        }
    }

    static /* synthetic */ View f(eg egVar) {
        egVar.m = null;
        return null;
    }

    private void k() {
        ej ejVar = this.i;
        if (ejVar == null) {
            this.a.a(this, new Object[0]);
        } else if (ejVar == null || ejVar.getVisibility() != 0) {
        } else {
            this.i.postInvalidate();
        }
    }

    private void l() {
        el elVar = this.l;
        if (elVar != null) {
            elVar.a();
        }
        ej ejVar = this.i;
        if (ejVar != null) {
            ejVar.a();
        }
        ek ekVar = this.f;
        if (ekVar != null) {
            ekVar.a();
        }
        ef efVar = this.g;
        if (efVar != null) {
            efVar.a();
        }
        ed edVar = this.h;
        if (edVar != null) {
            edVar.a();
        }
        ee eeVar = this.k;
        if (eeVar != null) {
            eeVar.a();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final float a(int i) {
        if (this.f != null) {
            k();
            return this.f.d(i);
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final Point a() {
        ek ekVar = this.f;
        if (ekVar == null) {
            return null;
        }
        return ekVar.b();
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.m;
        if (view == null || this.n == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.m.getLeft(), this.m.getTop(), new Paint());
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(ee.a aVar) {
        ee eeVar = this.k;
        if (eeVar == null) {
            this.a.a(this, aVar);
        } else {
            eeVar.a(aVar);
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(CameraPosition cameraPosition) {
        if (this.f == null) {
            this.a.a(this, cameraPosition);
        } else if (this.c.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f && !dp.a(cameraPosition.target.latitude, cameraPosition.target.longitude)) {
                this.f.setVisibility(8);
            } else if (this.c.getMaskLayerType() == -1) {
                this.f.setVisibility(0);
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(Boolean bool) {
        ee eeVar = this.k;
        if (eeVar == null) {
            this.a.a(this, bool);
        } else if (eeVar != null && bool.booleanValue() && this.c.canShowIndoorSwitch()) {
            this.k.a(true);
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(Float f) {
        el elVar = this.l;
        if (elVar == null) {
            this.a.a(this, f);
        } else if (elVar != null) {
            elVar.a(f.floatValue());
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(Integer num) {
        el elVar = this.l;
        if (elVar == null) {
            this.a.a(this, num);
        } else if (elVar != null) {
            elVar.a(num.intValue());
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(Integer num, Float f) {
        ek ekVar = this.f;
        if (ekVar != null) {
            this.a.a(this, num, f);
        } else if (ekVar != null) {
            ekVar.a(num.intValue(), f.floatValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(String str, Boolean bool, Integer num) {
        if (this.f == null) {
            this.a.a(this, str, bool, num);
        } else if (num.intValue() == 2) {
            this.f.b(bool.booleanValue());
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.f.a(str, num.intValue());
            this.f.d(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void a(boolean z) {
        ek ekVar = this.f;
        if (ekVar != null) {
            ekVar.c(z);
        }
        this.t = z;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void b(Boolean bool) {
        el elVar = this.l;
        if (elVar == null) {
            this.a.a(this, bool);
        } else {
            elVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void b(Integer num) {
        ek ekVar = this.f;
        if (ekVar == null) {
            this.a.a(this, num);
        } else if (ekVar != null) {
            ekVar.a(num.intValue());
            this.f.postInvalidate();
            k();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final boolean b() {
        ek ekVar = this.f;
        if (ekVar != null) {
            return ekVar.d();
        }
        return false;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void c() {
        ek ekVar = this.f;
        if (ekVar == null) {
            this.a.a(this, new Object[0]);
        } else if (ekVar != null) {
            ekVar.c();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void c(Boolean bool) {
        if (this.g == null) {
            this.a.a(this, bool);
        } else if (bool.booleanValue()) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void c(Integer num) {
        ek ekVar = this.f;
        if (ekVar == null) {
            this.a.a(this, num);
        } else if (ekVar != null) {
            ekVar.b(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final ec d() {
        return this.j;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void d(Boolean bool) {
        ed edVar = this.h;
        if (edVar == null) {
            this.a.a(this, bool);
        } else {
            edVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void d(Integer num) {
        ek ekVar = this.f;
        if (ekVar == null) {
            this.a.a(this, num);
        } else if (ekVar != null) {
            ekVar.c(num.intValue());
            k();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final ee e() {
        return this.k;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void e(Boolean bool) {
        ej ejVar = this.i;
        if (ejVar == null) {
            this.a.a(this, bool);
        } else {
            ejVar.a(bool.booleanValue());
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final ek f() {
        return this.f;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void f(Boolean bool) {
        ek ekVar = this.f;
        int i = 0;
        if (ekVar == null) {
            this.a.a(this, bool);
            return;
        }
        if (!bool.booleanValue()) {
            i = 8;
        }
        ekVar.setVisibility(i);
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void g() {
        hideInfoWindow();
        dw.a(this.o);
        l();
        removeAllViews();
        this.q = null;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void g(Boolean bool) {
        ek ekVar = this.f;
        if (ekVar == null) {
            this.a.a(this, bool);
        } else if (ekVar != null && bool.booleanValue()) {
            this.f.a(true);
        } else {
            ek ekVar2 = this.f;
            if (ekVar2 != null) {
                ekVar2.a(false);
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void h() {
        ed edVar = this.h;
        if (edVar == null) {
            this.a.a(this, new Object[0]);
        } else {
            edVar.b();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void h(Boolean bool) {
        ef efVar = this.g;
        if (efVar == null) {
            this.a.a(this, bool);
        } else {
            efVar.a(bool.booleanValue());
        }
    }

    public final void hideInfoWindow() {
        try {
            if (this.c == null || this.c.getMainHandler() == null) {
                return;
            }
            this.c.getMainHandler().post(new Runnable() { // from class: com.amap.api.col.3sl.eg.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (eg.this.m != null) {
                        eg.this.m.clearFocus();
                        eg egVar = eg.this;
                        egVar.removeView(egVar.m);
                        dw.a(eg.this.m.getBackground());
                        dw.a(eg.this.o);
                        eg.f(eg.this);
                    }
                }
            });
            if (this.n != null) {
                this.d.getNativeProperties(this.n.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
            }
            this.n = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void i() {
        Context context;
        if (!this.s || (context = this.e) == null) {
            return;
        }
        a(context);
        ei eiVar = this.a;
        if (eiVar != null) {
            eiVar.a();
        }
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final void i(Boolean bool) {
        ee eeVar = this.k;
        if (eeVar == null) {
            this.a.a(this, bool);
        } else {
            eeVar.a(bool.booleanValue());
        }
    }

    public final boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.amap.api.col.p0003sl.eh
    public final View j() {
        return this;
    }

    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.m == null || this.n == null || !dw.a(new Rect(this.m.getLeft(), this.m.getTop(), this.m.getRight(), this.m.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a(childAt, (a) childAt.getLayoutParams());
                    } else {
                        a(childAt, childAt.getLayoutParams());
                    }
                }
                i5 = i6 + 1;
            }
            if (this.f != null) {
                this.f.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void redrawInfoWindow() {
        try {
            if (this.n == null || !this.d.checkInBounds(this.n.getId())) {
                if (this.m == null || this.m.getVisibility() != 0) {
                    return;
                }
                this.m.setVisibility(8);
            } else if (this.p) {
                FPoint obtain = FPoint.obtain();
                this.d.getMarkerInfoWindowOffset(this.n.getId(), obtain);
                int i = (int) obtain.x;
                int i2 = (int) (obtain.y + 2.0f);
                obtain.recycle();
                View a2 = a(this.n);
                if (a2 == null) {
                    if (this.m == null || this.m.getVisibility() != 0) {
                        return;
                    }
                    hideInfoWindow();
                    return;
                }
                FPoint obtain2 = FPoint.obtain();
                this.d.getOverlayScreenPos(this.n.getId(), obtain2);
                a(a2, (int) obtain2.x, (int) obtain2.y, i, i2);
                if (this.m != null) {
                    a aVar = (a) this.m.getLayoutParams();
                    if (aVar != null) {
                        aVar.a = FPoint.obtain(obtain2.x, obtain2.y);
                        aVar.c = i;
                        aVar.d = i2;
                    }
                    onLayout(false, 0, 0, 0, 0);
                    if (this.b.a()) {
                        this.b.a(this.n.getTitle(), this.n.getSnippet());
                    }
                    if (this.m.getVisibility() == 8) {
                        this.m.setVisibility(0);
                    }
                }
                obtain2.recycle();
            }
        } catch (Throwable th) {
            iw.c(th, "MapOverlayViewGroup", "redrawInfoWindow");
            dw.a(th);
        }
    }

    public final void setInfoWindowAdapterManager(au auVar) {
        this.b = auVar;
    }

    public final void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            if (!(this.b != null && this.b.a() && basePointOverlay.getTitle() == null && basePointOverlay.getSnippet() == null) && basePointOverlay.isInfoWindowEnable()) {
                if (this.n != null && !this.n.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.b != null) {
                    this.n = basePointOverlay;
                    this.r = true;
                    this.d.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable th) {
        }
    }

    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            if (!(this.b != null && this.b.a() && baseOverlayImp.getTitle() == null && baseOverlayImp.getSnippet() == null) && baseOverlayImp.isInfoWindowEnable()) {
                if (this.n != null && !this.n.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.b != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.r = true;
                }
            }
        } catch (Throwable th) {
        }
    }
}
