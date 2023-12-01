package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.huawei.hms.framework.common.ExceptionCode;
import com.sobot.chat.camera.StCameraView;

/* renamed from: com.amap.api.col.3sl.ej  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ej.class */
public final class ej extends View {

    /* renamed from: a  reason: collision with root package name */
    private String f4910a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private IAMapDelegate f4911c;
    private Paint d;
    private Paint e;
    private Rect f;
    private IPoint g;
    private float h;
    private final int[] i;

    public ej(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f4910a = "";
        this.b = 0;
        this.h = 0.0f;
        this.i = new int[]{ExceptionCode.CRASH_EXCEPTION, 5000000, 2000000, 1000000, 500000, StCameraView.MEDIA_QUALITY_DESPAIR, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.f4911c = iAMapDelegate;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(-16777216);
        this.d.setStrokeWidth(w.f5439a * 2.0f);
        this.d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(-16777216);
        this.e.setTextSize(w.f5439a * 20.0f);
        this.h = dq.b(context);
        this.g = new IPoint();
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(String str) {
        this.f4910a = str;
    }

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.f4910a = null;
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
        IAMapDelegate iAMapDelegate = this.f4911c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            int engineIDWithType = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
            float preciseLevel = this.f4911c.getPreciseLevel(engineIDWithType);
            this.f4911c.getGeoCenter(engineIDWithType, this.g);
            if (this.g == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(this.g.x, this.g.y, 20);
            float mapZoomScale = this.f4911c.getMapZoomScale();
            double cos = (float) ((((Math.cos((pixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d));
            int i = (int) preciseLevel;
            int i2 = (int) (this.i[i] / (cos * mapZoomScale));
            String a2 = dw.a(this.i[i]);
            a(i2);
            a(a2);
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
        String str = this.f4910a;
        if (str == null || "".equals(str) || this.b == 0 || (waterMarkerPositon = this.f4911c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.e;
        String str2 = this.f4910a;
        paint.getTextBounds(str2, 0, str2.length(), this.f);
        int i = waterMarkerPositon.x;
        int height = (waterMarkerPositon.y - this.f.height()) + 5;
        canvas.drawText(this.f4910a, ((this.b - this.f.width()) / 2) + i, height, this.e);
        float f = i;
        float height2 = height + (this.f.height() - 5);
        canvas.drawLine(f, height2 - (this.h * 2.0f), f, height2 + w.f5439a, this.d);
        canvas.drawLine(f, height2, this.b + i, height2, this.d);
        int i2 = this.b;
        canvas.drawLine(i + i2, height2 - (this.h * 2.0f), i + i2, height2 + w.f5439a, this.d);
    }
}
