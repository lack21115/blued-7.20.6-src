package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* renamed from: com.amap.api.col.3sl.ef  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ef.class */
public final class ef extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    Bitmap f4895a;
    Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    Bitmap f4896c;
    Bitmap d;
    Bitmap e;
    Bitmap f;
    ImageView g;
    IAMapDelegate h;
    boolean i;

    public ef(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.i = false;
        this.h = iAMapDelegate;
        try {
            Bitmap a2 = dw.a(context, "location_selected.png");
            this.d = a2;
            this.f4895a = dw.a(a2, w.f5439a);
            Bitmap a3 = dw.a(context, "location_pressed.png");
            this.e = a3;
            this.b = dw.a(a3, w.f5439a);
            Bitmap a4 = dw.a(context, "location_unselected.png");
            this.f = a4;
            this.f4896c = dw.a(a4, w.f5439a);
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.f4895a);
            this.g.setClickable(true);
            this.g.setPadding(0, 20, 20, 0);
            this.g.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3sl.ef.1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (ef.this.i) {
                        if (motionEvent.getAction() == 0) {
                            ef.this.g.setImageBitmap(ef.this.b);
                            return false;
                        } else if (motionEvent.getAction() == 1) {
                            try {
                                ef.this.g.setImageBitmap(ef.this.f4895a);
                                ef.this.h.setMyLocationEnabled(true);
                                Location myLocation = ef.this.h.getMyLocation();
                                if (myLocation == null) {
                                    return false;
                                }
                                LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                                ef.this.h.showMyLocationOverlay(myLocation);
                                ef.this.h.moveCamera(ak.a(latLng, ef.this.h.getZoomLevel()));
                                return false;
                            } catch (Throwable th) {
                                iw.c(th, "LocationView", "onTouch");
                                th.printStackTrace();
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                    return false;
                }
            });
            addView(this.g);
        } catch (Throwable th) {
            iw.c(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            if (this.f4895a != null) {
                dw.a(this.f4895a);
            }
            if (this.b != null) {
                dw.a(this.b);
            }
            if (this.b != null) {
                dw.a(this.f4896c);
            }
            this.f4895a = null;
            this.b = null;
            this.f4896c = null;
            if (this.d != null) {
                dw.a(this.d);
                this.d = null;
            }
            if (this.e != null) {
                dw.a(this.e);
                this.e = null;
            }
            if (this.f != null) {
                dw.a(this.f);
                this.f = null;
            }
        } catch (Throwable th) {
            iw.c(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        this.i = z;
        try {
            if (z) {
                this.g.setImageBitmap(this.f4895a);
            } else {
                this.g.setImageBitmap(this.f4896c);
            }
            this.g.invalidate();
        } catch (Throwable th) {
            iw.c(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
