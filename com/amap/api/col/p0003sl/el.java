package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.p0003sl.eg;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.col.3sl.el  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/el.class */
public final class el extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f4915a;
    private Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f4916c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    private ImageView m;
    private ImageView n;
    private IAMapDelegate o;

    public el(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.o = iAMapDelegate;
        try {
            Bitmap a2 = dw.a(context, "zoomin_selected.png");
            this.g = a2;
            this.f4915a = dw.a(a2, w.f5439a);
            Bitmap a3 = dw.a(context, "zoomin_unselected.png");
            this.h = a3;
            this.b = dw.a(a3, w.f5439a);
            Bitmap a4 = dw.a(context, "zoomout_selected.png");
            this.i = a4;
            this.f4916c = dw.a(a4, w.f5439a);
            Bitmap a5 = dw.a(context, "zoomout_unselected.png");
            this.j = a5;
            this.d = dw.a(a5, w.f5439a);
            Bitmap a6 = dw.a(context, "zoomin_pressed.png");
            this.k = a6;
            this.e = dw.a(a6, w.f5439a);
            Bitmap a7 = dw.a(context, "zoomout_pressed.png");
            this.l = a7;
            this.f = dw.a(a7, w.f5439a);
            ImageView imageView = new ImageView(context);
            this.m = imageView;
            imageView.setImageBitmap(this.f4915a);
            this.m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.n = imageView2;
            imageView2.setImageBitmap(this.f4916c);
            this.n.setClickable(true);
            this.m.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3sl.el.1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (el.this.o.getZoomLevel() >= el.this.o.getMaxZoomLevel() || !el.this.o.isMaploaded()) {
                            return false;
                        }
                        if (motionEvent.getAction() == 0) {
                            el.this.m.setImageBitmap(el.this.e);
                            return false;
                        } else if (motionEvent.getAction() == 1) {
                            el.this.m.setImageBitmap(el.this.f4915a);
                            try {
                                el.this.o.animateCamera(ak.a());
                                return false;
                            } catch (RemoteException e) {
                                iw.c(e, "ZoomControllerView", "zoomin ontouch");
                                e.printStackTrace();
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return false;
                    }
                }
            });
            this.n.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3sl.el.2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (el.this.o.getZoomLevel() <= el.this.o.getMinZoomLevel() || !el.this.o.isMaploaded()) {
                            return false;
                        }
                        if (motionEvent.getAction() == 0) {
                            el.this.n.setImageBitmap(el.this.f);
                            return false;
                        } else if (motionEvent.getAction() == 1) {
                            el.this.n.setImageBitmap(el.this.f4916c);
                            el.this.o.animateCamera(ak.b());
                            return false;
                        } else {
                            return false;
                        }
                    } catch (Throwable th) {
                        iw.c(th, "ZoomControllerView", "zoomout ontouch");
                        th.printStackTrace();
                        return false;
                    }
                }
            });
            this.m.setPadding(0, 0, 20, -2);
            this.n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.m);
            addView(this.n);
        } catch (Throwable th) {
            iw.c(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            dw.a(this.f4915a);
            dw.a(this.b);
            dw.a(this.f4916c);
            dw.a(this.d);
            dw.a(this.e);
            dw.a(this.f);
            this.f4915a = null;
            this.b = null;
            this.f4916c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            if (this.g != null) {
                dw.a(this.g);
                this.g = null;
            }
            if (this.h != null) {
                dw.a(this.h);
                this.h = null;
            }
            if (this.i != null) {
                dw.a(this.i);
                this.i = null;
            }
            if (this.j != null) {
                dw.a(this.j);
                this.g = null;
            }
            if (this.k != null) {
                dw.a(this.k);
                this.k = null;
            }
            if (this.l != null) {
                dw.a(this.l);
                this.l = null;
            }
            this.m = null;
            this.n = null;
        } catch (Throwable th) {
            iw.c(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public final void a(float f) {
        try {
            if (f < this.o.getMaxZoomLevel() && f > this.o.getMinZoomLevel()) {
                this.m.setImageBitmap(this.f4915a);
                this.n.setImageBitmap(this.f4916c);
            } else if (f == this.o.getMinZoomLevel()) {
                this.n.setImageBitmap(this.d);
                this.m.setImageBitmap(this.f4915a);
            } else if (f == this.o.getMaxZoomLevel()) {
                this.m.setImageBitmap(this.b);
                this.n.setImageBitmap(this.f4916c);
            }
        } catch (Throwable th) {
            iw.c(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void a(int i) {
        try {
            eg.a aVar = (eg.a) getLayoutParams();
            if (i == 1) {
                aVar.e = 16;
            } else if (i == 2) {
                aVar.e = 80;
            }
            setLayoutParams(aVar);
        } catch (Throwable th) {
            iw.c(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
