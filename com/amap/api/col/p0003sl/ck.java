package com.amap.api.col.p0003sl;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* renamed from: com.amap.api.col.3sl.ck  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ck.class */
public final class ck {
    ValueAnimator b;
    private IAMapDelegate e;
    private Marker f;
    private Circle g;
    private LatLng i;
    private double j;
    private Context k;
    private ad l;
    private MyLocationStyle h = new MyLocationStyle();
    private int m = 4;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;

    /* renamed from: a  reason: collision with root package name */
    a f4804a = null;

    /* renamed from: c  reason: collision with root package name */
    Animator.AnimatorListener f4805c = new Animator.AnimatorListener() { // from class: com.amap.api.col.3sl.ck.1
        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ck.this.k();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }
    };
    ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener() { // from class: com.amap.api.col.3sl.ck.2
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (ck.this.g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    ck.this.g.setCenter(latLng);
                    ck.this.f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    /* renamed from: com.amap.api.col.3sl.ck$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ck$a.class */
    public static final class a implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.latitude;
            double d2 = f;
            return new LatLng(d + ((latLng2.latitude - latLng.latitude) * d2), latLng.longitude + (d2 * (latLng2.longitude - latLng.longitude)));
        }
    }

    public ck(IAMapDelegate iAMapDelegate, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.k = applicationContext;
        this.e = iAMapDelegate;
        this.l = new ad(applicationContext, iAMapDelegate);
        a(4, true);
    }

    private void a(int i) {
        a(i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r4 != 7) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r4, boolean r5) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ck.a(int, boolean):void");
    }

    private void a(LatLng latLng) {
        LatLng position = this.f.getPosition();
        LatLng latLng2 = position;
        if (position == null) {
            latLng2 = new LatLng(0.0d, 0.0d);
        }
        if (this.f4804a == null) {
            this.f4804a = new a();
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new a(), latLng2, latLng);
            this.b = ofObject;
            ofObject.addListener(this.f4805c);
            this.b.addUpdateListener(this.d);
        } else {
            valueAnimator.setObjectValues(latLng2, latLng);
            this.b.setEvaluator(this.f4804a);
        }
        if (latLng2.latitude == 0.0d && latLng2.longitude == 0.0d) {
            this.b.setDuration(1L);
        } else {
            this.b.setDuration(1000L);
        }
        this.b.start();
    }

    private void a(boolean z) {
        Circle circle = this.g;
        if (circle != null && circle.isVisible() != z) {
            this.g.setVisible(z);
        }
        Marker marker = this.f;
        if (marker == null || marker.isVisible() == z) {
            return;
        }
        this.f.setVisible(z);
    }

    private void b(float f) {
        IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(ak.c(f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(float f) {
        float f2;
        if (this.q) {
            float f3 = f % 360.0f;
            if (f3 > 180.0f) {
                f2 = f3 - 360.0f;
            } else {
                f2 = f3;
                if (f3 < -180.0f) {
                    f2 = f3 + 360.0f;
                }
            }
            Marker marker = this.f;
            if (marker != null) {
                marker.setRotateAngle(-f2);
            }
        }
    }

    private void g() {
        this.l.b();
    }

    private void h() {
        b(0.0f);
    }

    private void i() {
        j();
    }

    private void j() {
        IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(ak.d(0.0f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i != null && this.o) {
            if (this.p && this.n) {
                return;
            }
            this.n = true;
            try {
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(this.i.longitude, this.i.latitude, obtain);
                this.e.animateCamera(ak.a(obtain));
            } catch (Throwable th) {
                iw.c(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void l() {
        MyLocationStyle myLocationStyle = this.h;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.h = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        } else if (myLocationStyle.getMyLocationIcon() == null || this.h.getMyLocationIcon().getBitmap() == null) {
            this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        n();
    }

    private void m() {
        Circle circle = this.g;
        if (circle != null) {
            try {
                this.e.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                iw.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
            this.f = null;
            this.l.a((Marker) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x016d A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:2:0x0000, B:4:0x0007, B:6:0x0020, B:8:0x0026, B:10:0x0038, B:12:0x0047, B:14:0x0057, B:16:0x0066, B:18:0x0076, B:20:0x0085, B:22:0x008b, B:24:0x0097, B:26:0x00aa, B:28:0x00b0, B:30:0x00c9, B:32:0x00cf, B:34:0x00e1, B:39:0x0109, B:41:0x0112, B:44:0x0122, B:46:0x012c, B:48:0x0147, B:51:0x0167, B:53:0x016d, B:49:0x0158, B:37:0x00f4, B:55:0x0181), top: B:60:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n() {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.ck.n():void");
    }

    public final MyLocationStyle a() {
        return this.h;
    }

    public final void a(float f) {
        Marker marker = this.f;
        if (marker != null) {
            marker.setRotateAngle(f);
        }
    }

    public final void a(Location location) {
        if (location == null) {
            return;
        }
        a(this.h.isMyLocationShowing());
        if (this.h.isMyLocationShowing()) {
            this.i = new LatLng(location.getLatitude(), location.getLongitude());
            this.j = location.getAccuracy();
            if (this.f == null && this.g == null) {
                l();
            }
            Circle circle = this.g;
            if (circle != null) {
                try {
                    if (this.j != -1.0d) {
                        circle.setRadius(this.j);
                    }
                } catch (Throwable th) {
                    iw.c(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            c(location.getBearing());
            if (this.i.equals(this.f.getPosition())) {
                k();
            } else {
                a(this.i);
            }
        }
    }

    public final void a(MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                this.l.a(false);
                this.m = this.h.getMyLocationType();
                return;
            }
            l();
            if (this.f == null && this.g == null) {
                return;
            }
            this.l.a(this.f);
            a(this.h.getMyLocationType());
        } catch (Throwable th) {
            iw.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        ad adVar;
        if (this.m != 3 || (adVar = this.l) == null) {
            return;
        }
        adVar.a();
    }

    public final void c() throws RemoteException {
        m();
        if (this.l != null) {
            g();
            this.l = null;
        }
    }

    public final String d() {
        Marker marker = this.f;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public final String e() throws RemoteException {
        Circle circle = this.g;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public final void f() {
        this.g = null;
        this.f = null;
    }
}
