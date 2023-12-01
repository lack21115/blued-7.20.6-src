package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* renamed from: com.amap.api.col.3sl.ed  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ed.class */
public final class ed extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    ImageView d;
    IAMapDelegate e;
    Matrix f;

    public ed(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f = new Matrix();
        this.e = iAMapDelegate;
        try {
            Bitmap a = dw.a(context, "maps_dav_compass_needle_large.png");
            this.c = a;
            this.b = dw.a(a, w.a * 0.8f);
            Bitmap a2 = dw.a(this.c, w.a * 0.7f);
            this.c = a2;
            if (this.b == null || a2 == null) {
                return;
            }
            this.a = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.a);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(this.c, (this.b.getWidth() - this.c.getWidth()) / 2.0f, (this.b.getHeight() - this.c.getHeight()) / 2.0f, paint);
            ImageView imageView = new ImageView(context);
            this.d = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            this.d.setImageBitmap(this.a);
            this.d.setClickable(true);
            b();
            this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.col.3sl.ed.1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (ed.this.e.isMaploaded()) {
                            if (motionEvent.getAction() == 0) {
                                ed.this.d.setImageBitmap(ed.this.b);
                                return false;
                            } else if (motionEvent.getAction() == 1) {
                                ed.this.d.setImageBitmap(ed.this.a);
                                CameraPosition cameraPosition = ed.this.e.getCameraPosition();
                                ed.this.e.animateCamera(ak.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                                return false;
                            } else {
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        iw.c(th, "CompassView", "onTouch");
                        th.printStackTrace();
                        return false;
                    }
                }
            });
            addView(this.d);
        } catch (Throwable th) {
            iw.c(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            if (this.a != null) {
                dw.a(this.a);
            }
            if (this.b != null) {
                dw.a(this.b);
            }
            if (this.c != null) {
                dw.a(this.c);
            }
            if (this.f != null) {
                this.f.reset();
                this.f = null;
            }
            this.c = null;
            this.a = null;
            this.b = null;
        } catch (Throwable th) {
            iw.c(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (!z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b();
    }

    public final void b() {
        try {
            if (this.e == null || this.d == null) {
                return;
            }
            int engineIDWithType = this.e.getGLMapEngine().getEngineIDWithType(1);
            float cameraDegree = this.e.getCameraDegree(engineIDWithType);
            float mapAngle = this.e.getMapAngle(engineIDWithType);
            if (this.f == null) {
                this.f = new Matrix();
            }
            this.f.reset();
            this.f.postRotate(-mapAngle, this.d.getDrawable().getBounds().width() / 2.0f, this.d.getDrawable().getBounds().height() / 2.0f);
            this.f.postScale(1.0f, (float) Math.cos((cameraDegree * 3.141592653589793d) / 180.0d), this.d.getDrawable().getBounds().width() / 2.0f, this.d.getDrawable().getBounds().height() / 2.0f);
            this.d.setImageMatrix(this.f);
        } catch (Throwable th) {
            iw.c(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
