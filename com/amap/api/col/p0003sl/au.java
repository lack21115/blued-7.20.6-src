package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* renamed from: com.amap.api.col.3sl.au  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/au.class */
public final class au {
    Context c;
    private View e;
    private TextView f;
    private TextView g;
    private IInfoWindowAction i;
    private IInfoWindowAction j;
    private BaseOverlay k;
    AMap.InfoWindowAdapter a = null;
    AMap.CommonInfoWindowAdapter b = null;
    private boolean d = true;
    private Drawable h = null;
    private AMap.InfoWindowAdapter l = new AMap.InfoWindowAdapter() { // from class: com.amap.api.col.3sl.au.1
        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public final View getInfoWindow(Marker marker) {
            try {
                if (au.this.h == null) {
                    au.this.h = dl.a(au.this.c, "infowindow_bg.9.png");
                }
                if (au.this.e == null) {
                    au.this.e = new LinearLayout(au.this.c);
                    au.this.e.setBackground(au.this.h);
                    au.this.f = new TextView(au.this.c);
                    au.this.f.setText(marker.getTitle());
                    au.this.f.setTextColor(View.MEASURED_STATE_MASK);
                    au.this.g = new TextView(au.this.c);
                    au.this.g.setTextColor(View.MEASURED_STATE_MASK);
                    au.this.g.setText(marker.getSnippet());
                    ((LinearLayout) au.this.e).setOrientation(1);
                    ((LinearLayout) au.this.e).addView(au.this.f);
                    ((LinearLayout) au.this.e).addView(au.this.g);
                }
            } catch (Throwable th) {
                iw.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return au.this.e;
        }
    };
    private AMap.CommonInfoWindowAdapter m = new AMap.CommonInfoWindowAdapter() { // from class: com.amap.api.col.3sl.au.2
        private InfoWindowParams b = null;

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.b == null) {
                    this.b = new InfoWindowParams();
                    if (au.this.h == null) {
                        au.this.h = dl.a(au.this.c, "infowindow_bg.9.png");
                    }
                    au.this.e = new LinearLayout(au.this.c);
                    au.this.e.setBackground(au.this.h);
                    au.this.f = new TextView(au.this.c);
                    au.this.f.setText("标题");
                    au.this.f.setTextColor(View.MEASURED_STATE_MASK);
                    au.this.g = new TextView(au.this.c);
                    au.this.g.setTextColor(View.MEASURED_STATE_MASK);
                    au.this.g.setText("内容");
                    ((LinearLayout) au.this.e).setOrientation(1);
                    ((LinearLayout) au.this.e).addView(au.this.f);
                    ((LinearLayout) au.this.e).addView(au.this.g);
                    this.b.setInfoWindowType(2);
                    this.b.setInfoWindow(au.this.e);
                }
                return this.b;
            } catch (Throwable th) {
                iw.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    };

    public au(Context context) {
        this.c = context;
    }

    private static void a(View view, BasePointOverlay basePointOverlay) {
        if (view == null || basePointOverlay == null || basePointOverlay.getPosition() == null || !dk.c()) {
            return;
        }
        String b = dw.b(view);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        dk.a().a(basePointOverlay.getPosition(), b, "");
    }

    private static boolean b(AMap.InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            return true;
        }
        Marker marker = new Marker(null, new MarkerOptions(), "check");
        return infoWindowAdapter.getInfoWindow(marker) == null && infoWindowAdapter.getInfoContents(marker) == null;
    }

    private IInfoWindowAction d() {
        synchronized (this) {
            if (this.a != null) {
                if (this.a instanceof AMap.ImageInfoWindowAdapter) {
                    return this.j;
                } else if (this.a instanceof AMap.MultiPositionInfoWindowAdapter) {
                    return this.j;
                }
            }
            if (this.b == null || this.b.getInfoWindowParams(null).getInfoWindowType() != 1) {
                return this.i;
            }
            return this.j;
        }
    }

    public final View a(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            View infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
            a(infoWindow, basePointOverlay);
            return infoWindow;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoWindow2 = infoWindowParams.getInfoWindow();
            a(infoWindow2, basePointOverlay);
            return infoWindow2;
        }
        InfoWindowParams infoWindowParams2 = this.m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public final BaseOverlay a(MotionEvent motionEvent) {
        IInfoWindowAction d = d();
        if (d == null || !d.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.k;
    }

    public final void a(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        synchronized (this) {
            this.b = commonInfoWindowAdapter;
            this.a = null;
            if (commonInfoWindowAdapter == null) {
                this.b = this.m;
                this.d = true;
            } else {
                this.d = false;
            }
            if (this.j != null) {
                this.j.hideInfoWindow();
            }
            if (this.i != null) {
                this.i.hideInfoWindow();
            }
        }
    }

    public final void a(AMap.InfoWindowAdapter infoWindowAdapter) {
        synchronized (this) {
            this.a = infoWindowAdapter;
            this.b = null;
            if (b(infoWindowAdapter)) {
                this.a = this.l;
                this.d = true;
            } else {
                this.d = false;
            }
            if (this.j != null) {
                this.j.hideInfoWindow();
            }
            if (this.i != null) {
                this.i.hideInfoWindow();
            }
        }
    }

    public final void a(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction d = d();
        if (d == null || !(baseOverlay instanceof BasePointOverlay)) {
            return;
        }
        d.showInfoWindow((BasePointOverlay) baseOverlay);
        this.k = baseOverlay;
    }

    public final void a(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction d = d();
        if (d != null) {
            d.showInfoWindow(baseOverlayImp);
        }
    }

    public final void a(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.i = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final void a(String str, String str2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.requestLayout();
            this.f.setText(str);
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.requestLayout();
            this.g.setText(str2);
        }
        View view = this.e;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }

    public final View b(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            View infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
            a(infoContents, basePointOverlay);
            return infoContents;
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            View infoContents2 = infoWindowParams.getInfoContents();
            a(infoContents2, basePointOverlay);
            return infoContents2;
        }
        InfoWindowParams infoWindowParams2 = this.m.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public final void b() {
        IInfoWindowAction d = d();
        if (d != null) {
            d.redrawInfoWindow();
        }
    }

    public final void b(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.j = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final long c(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter == null || !(infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
            if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
                return 0L;
            }
            return infoWindowParams.getInfoWindowUpdateTime();
        }
        return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
    }

    public final void c() {
        IInfoWindowAction d = d();
        if (d != null) {
            d.hideInfoWindow();
        }
    }
}
