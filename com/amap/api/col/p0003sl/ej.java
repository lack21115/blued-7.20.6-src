package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.anythink.core.common.b.g;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* renamed from: com.amap.api.col.3sl.ej  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ej.class */
public final class ej extends View {
    private String a;
    private int b;
    private IAMapDelegate c;
    private Paint d;
    private Paint e;
    private Rect f;
    private IPoint g;
    private float h;
    private final int[] i;

    public ej(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.a = "";
        this.b = 0;
        this.h = 0.0f;
        this.i = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, g.j.p, 50000, 30000, Window.PROGRESS_SECONDARY_START, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.c = iAMapDelegate;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(View.MEASURED_STATE_MASK);
        this.d.setStrokeWidth(w.a * 2.0f);
        this.d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(View.MEASURED_STATE_MASK);
        this.e.setTextSize(w.a * 20.0f);
        this.h = dq.b(context);
        this.g = new IPoint();
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(String str) {
        this.a = str;
    }

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.g = null;
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
            b();
            return;
        }
        a("");
        a(0);
        setVisibility(8);
    }

    public final void b() {
        IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.c.getPreciseLevel(engineIDWithType);
            this.c.getGeoCenter(engineIDWithType, this.g);
            if (this.g == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(this.g.x, this.g.y, 20);
            float mapZoomScale = this.c.getMapZoomScale();
            double cos = (float) ((((Math.cos((pixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int i = (int) preciseLevel;
            int i2 = (int) (this.i[i] / (cos * mapZoomScale));
            String a = dw.a(this.i[i]);
            a(i2);
            a(a);
            pixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th) {
            iw.c(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.a;
        if (str == null || "".equals(str) || this.b == 0 || (waterMarkerPositon = this.c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.e;
        String str2 = this.a;
        paint.getTextBounds(str2, 0, str2.length(), this.f);
        int i = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f.height()) + 5;
        canvas.drawText(this.a, ((this.b - this.f.width()) / 2) + i, height, this.e);
        float f = i;
        float height2 = height + (this.f.height() - 5);
        canvas.drawLine(f, height2 - (this.h * 2.0f), f, height2 + w.a, this.d);
        canvas.drawLine(f, height2, this.b + i, height2, this.d);
        int i2 = this.b;
        canvas.drawLine(i + i2, height2 - (this.h * 2.0f), i + i2, height2 + w.a, this.d);
    }
}
