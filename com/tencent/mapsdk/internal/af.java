package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/af.class */
public class af extends ze<n0> implements n0, r4 {
    public static final float O = 5.0f;
    private static AtomicInteger P = new AtomicInteger(0);
    private ig B;
    private Bitmap C;
    private int D;
    private int E;
    private GeoPoint F;
    private yi G;
    private o0 H;
    private boolean I;
    private float J;
    private float K;
    private boolean L;
    private View M;
    private int N;

    public af(yi yiVar, o0 o0Var) {
        super(yiVar);
        this.C = null;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = false;
        this.J = 0.5f;
        this.K = 0.5f;
        this.L = false;
        this.G = yiVar;
        this.H = o0Var;
        K();
    }

    private void K() {
        o0 o0Var = this.H;
        if (this.G == null || o0Var == null || o0Var.getOptions() == null) {
            return;
        }
        L();
        if (this.G.getMap().F() == null) {
            return;
        }
        this.B = new ig(this, this.G, b(o0Var.getOptions()));
        na.c("create InfoWindowView:" + this.M);
        b(b7.a(this.M));
    }

    private void L() {
        yi yiVar = this.G;
        if (yiVar == null || yiVar.getContext() == null) {
            return;
        }
        TencentMap.InfoWindowAdapter infoWindowAdapter = null;
        o0 o0Var = this.H;
        if (o0Var != null) {
            infoWindowAdapter = o0Var.t();
        }
        View a2 = a(yiVar.getContext(), yiVar.getMapContext(), this, infoWindowAdapter, o0Var);
        this.M = a2;
        if (a2 != null) {
            a2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.D = this.M.getMeasuredWidth();
            this.E = this.M.getMeasuredHeight();
            View view = this.M;
            view.layout(0, 0, view.getMeasuredWidth(), this.M.getMeasuredHeight());
        }
    }

    public static View a(Context context, e1 e1Var, r4 r4Var, TencentMap.InfoWindowAdapter infoWindowAdapter, Marker marker) {
        if (context == null || r4Var == null || marker == null || e1Var == null) {
            return null;
        }
        String title = marker.getTitle();
        String snippet = marker.getSnippet();
        if (infoWindowAdapter == null) {
            if (f7.b(title) && f7.b(snippet)) {
                return null;
            }
            return a(context, e1Var, r4Var, title, snippet);
        }
        LinearLayout linearLayout = (LinearLayout) r4Var.o();
        LinearLayout linearLayout2 = linearLayout;
        if (linearLayout == null) {
            linearLayout2 = a(context);
        }
        w0 w0Var = (w0) e1Var.g().c().a(marker.getId(), w0.class);
        if (w0Var == null) {
            return null;
        }
        View infoWindow = infoWindowAdapter.getInfoWindow(w0Var);
        if (infoWindow != null) {
            if (infoWindow.getParent() == linearLayout2) {
                return linearLayout2;
            }
            if (infoWindow.getParent() instanceof ViewGroup) {
                ((ViewGroup) infoWindow.getParent()).removeAllViews();
            }
            linearLayout2.setBackgroundDrawable(null);
            linearLayout2.removeAllViews();
            linearLayout2.addView(infoWindow);
            return linearLayout2;
        }
        View infoContents = infoWindowAdapter.getInfoContents(w0Var);
        if (infoContents != null) {
            if (infoContents.getParent() == linearLayout2) {
                return linearLayout2;
            }
            if (infoContents.getParent() instanceof ViewGroup) {
                ((ViewGroup) infoContents.getParent()).removeAllViews();
            }
            a(linearLayout2, "marker_infowindow.9.png");
            linearLayout2.removeAllViews();
            linearLayout2.addView(infoContents);
            return linearLayout2;
        } else if (f7.b(title) && f7.b(snippet)) {
            return null;
        } else {
            a(linearLayout2, "marker_infowindow.9.png");
            linearLayout2.removeAllViews();
            a(e1Var, linearLayout2, r4.d, title);
            a(e1Var, linearLayout2, r4.e, snippet);
            return linearLayout2;
        }
    }

    public static View a(Context context, TencentMapContext tencentMapContext, r4 r4Var, String str, String str2) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = (LinearLayout) r4Var.o();
        if (linearLayout2 == null) {
            linearLayout = a(context);
        } else {
            linearLayout2.removeAllViews();
            linearLayout = linearLayout2;
        }
        a(linearLayout, "marker_infowindow.9.png");
        a(tencentMapContext, linearLayout, r4.d, str);
        a(tencentMapContext, linearLayout, r4.e, str2);
        return linearLayout;
    }

    public static LinearLayout a(Context context) {
        if (context == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setTag(r4.f24042c);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        return linearLayout;
    }

    private static void a(ViewGroup viewGroup, String str) {
        if (TextUtils.isEmpty(str)) {
            viewGroup.setBackgroundDrawable(null);
        }
        Bitmap c2 = b7.c(viewGroup.getContext(), str);
        if (c2 != null) {
            viewGroup.setBackgroundDrawable(new NinePatchDrawable(viewGroup.getContext().getResources(), c2, c2.getNinePatchChunk(), new Rect(10, 10, 10, 30), null));
        }
    }

    private static void a(TencentMapContext tencentMapContext, LinearLayout linearLayout, String str, String str2) {
        if (linearLayout == null || linearLayout.getContext() == null) {
            return;
        }
        Context context = linearLayout.getContext();
        View view = (TextView) linearLayout.findViewWithTag(str);
        if (TextUtils.isEmpty(str2)) {
            if (view != null) {
                linearLayout.removeView(view);
                return;
            }
            return;
        }
        View view2 = view;
        if (view == null) {
            oc ocVar = new oc(context, tencentMapContext);
            ocVar.setTag(str);
            ocVar.setGravity(3);
            ocVar.setTextColor(-16777216);
            linearLayout.addView(ocVar, new LinearLayout.LayoutParams(-2, -2));
            view2 = ocVar;
        }
        view2.setText(str2);
    }

    private jg b(MarkerOptions markerOptions) {
        int infoWindowOffsetX = markerOptions.getInfoWindowOffsetX();
        int infowindowOffsetY = markerOptions.getInfowindowOffsetY();
        w();
        k();
        return new jg().a(GeoPoint.from(markerOptions.getPosition())).a(markerOptions.getAlpha()).a(this.J - ((infoWindowOffsetX * 1.0f) / this.D), this.K - ((infowindowOffsetY * 1.0f) / this.E)).f(false).d((int) markerOptions.getZIndex()).b(markerOptions.getLevel()).e(this.I).d(true);
    }

    private void b(Bitmap bitmap) {
        this.C = bitmap;
        if (bitmap == null) {
            return;
        }
        na.c("setBitmapAssist:" + bitmap);
        String str = (bitmap.hashCode() + P.getAndIncrement()) + "";
        ig igVar = this.B;
        if (igVar != null) {
            igVar.b(str, bitmap);
        }
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        ig igVar;
        if (this.n && (igVar = this.B) != null) {
            igVar.E();
        }
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void G() {
        super.G();
        ig igVar = this.B;
        if (igVar == null || igVar.N() == this.N) {
            return;
        }
        na.a(ma.f, "设置主从绑定关系：" + this.H.a() + "|" + this.B.N());
        this.N = this.B.N();
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        releaseData();
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: J */
    public n0 x() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        ig igVar = this.B;
        return igVar != null ? igVar.a(t4Var) : new Rect(0, 0, 0, 0);
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void a(MarkerOptions markerOptions) {
        if (markerOptions == null || this.B == null) {
            return;
        }
        setVisible(markerOptions.isVisible());
        setLevel(markerOptions.getLevel());
        L();
        jg b = b(markerOptions);
        if (b == null) {
            return;
        }
        this.B.a(b);
        b(b7.a(this.M));
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public Rect getScreenBound(t4 t4Var) {
        ig igVar = this.B;
        if (igVar == null) {
            return null;
        }
        return igVar.b(t4Var);
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void e(boolean z) {
        this.L = z;
        yi yiVar = this.G;
        if (yiVar == null || yiVar.getMap() == null) {
            return;
        }
        this.G.getMap().v0();
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void k() {
        o0 o0Var = this.H;
        yi yiVar = this.G;
        if (o0Var == null || yiVar == null || yiVar.getContext() == null) {
            return;
        }
        int height = (int) (o0Var.getHeight(yiVar.getContext()) * o0Var.getAnchorV());
        int i = this.E;
        float f = 1.0f;
        if (o0Var.getOptions() != null) {
            f = o0Var.getOptions().getInfoWindowAnchorV();
        }
        int i2 = i;
        if (i == 0) {
            i2 = 1;
        }
        float f2 = height;
        float f3 = i2;
        this.K = (f2 + (f * f3)) / f3;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.q4
    public void n() {
    }

    @Override // com.tencent.mapsdk.internal.r4
    public View o() {
        return this.M;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        ig igVar = this.B;
        if (igVar == null) {
            return false;
        }
        return igVar.onTap(f, f2);
    }

    @Override // com.tencent.mapsdk.internal.r4
    public boolean r() {
        return this.L && this.C != null;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Removable
    public void releaseData() {
        Bitmap bitmap = this.C;
        if (bitmap != null) {
            bitmap.recycle();
            this.C = null;
        }
        this.H = null;
        this.G = null;
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setAnchor(float f, float f2) {
        int i;
        o0 o0Var = this.H;
        int i2 = 0;
        if (o0Var == null || o0Var.getOptions() == null) {
            i = 0;
        } else {
            i2 = o0Var.getOptions().getInfoWindowOffsetX();
            i = o0Var.getOptions().getInfowindowOffsetY();
        }
        w();
        k();
        float f3 = this.J;
        float f4 = (i2 * 1.0f) / this.D;
        float f5 = this.K;
        float f6 = (i * 1.0f) / this.E;
        ig igVar = this.B;
        if (igVar != null) {
            igVar.setAnchor(f3 - f4, f5 - f6);
        }
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setFixingPoint(int i, int i2) {
        if (this.B != null) {
            setFixingPointEnable(true);
            this.B.a(new GeoPoint(i2, i));
        }
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setFixingPointEnable(boolean z) {
        this.I = z;
        ig igVar = this.B;
        if (igVar != null) {
            igVar.h(z);
        }
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        GeoPoint geoPoint = this.F;
        if (geoPoint == null) {
            this.F = GeoPoint.from(latLng);
        } else {
            geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
            this.F.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        }
        ig igVar = this.B;
        if (igVar != null) {
            igVar.a(this.F);
        }
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void u() {
        o0 o0Var = this.H;
        if (o0Var == null) {
            return;
        }
        a(o0Var.getOptions());
    }

    @Override // com.tencent.mapsdk.internal.r4
    public void w() {
        o0 o0Var = this.H;
        yi yiVar = this.G;
        if (o0Var == null || yiVar == null || yiVar.getContext() == null) {
            return;
        }
        int width = o0Var.getWidth(yiVar.getContext());
        float infoWindowAnchorU = o0Var.getOptions() != null ? o0Var.getOptions().getInfoWindowAnchorU() : 0.5f;
        int i = this.D;
        int i2 = i;
        if (i == 0) {
            i2 = 1;
        }
        this.J = infoWindowAnchorU + ((width * (o0Var.getAnchorU() - 0.5f)) / i2);
    }
}
