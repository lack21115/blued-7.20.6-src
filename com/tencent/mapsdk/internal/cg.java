package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cg.class */
public class cg extends LinearLayout {
    private Path g;
    private Paint h;
    private Paint i;
    private RectF j;
    private float k;
    private float l;
    private int m;

    public cg(Context context) {
        super(context);
        this.m = -1;
        a();
    }

    public cg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = -1;
        a();
    }

    private void a() {
        this.l = getResources().getDisplayMetrics().density / 2.0f;
        this.g = new Path();
        b();
    }

    private void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT <= 27) {
            this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.g, this.h);
            return;
        }
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CW);
        path.op(this.g, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.h);
    }

    private void b() {
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(this.m);
        this.h.setAntiAlias(true);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setShadowLayer(this.l, 0.0f, 0.0f, -1);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setColor(this.m);
        this.i.setAntiAlias(true);
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setShadowLayer(this.l, 0.0f, 0.0f, -16777216);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(this.j, null, 31);
        canvas.drawColor(this.m);
        canvas.drawPath(this.g, this.i);
        a(canvas);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.j == null) {
            this.j = new RectF();
        }
        this.j.right = getMeasuredWidth();
        this.j.bottom = getMeasuredHeight();
        if (this.j.width() < this.j.height()) {
            this.k = this.j.width() / 2.0f;
        } else {
            this.k = this.j.height() / 2.0f;
        }
        this.g.reset();
        Path path = this.g;
        RectF rectF = this.j;
        float f = this.k;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    public void setDarkStyle(boolean z) {
        if (z) {
            this.m = Color.parseColor("#2C2C2C");
        } else {
            this.m = -1;
        }
        b();
        invalidate();
    }
}
