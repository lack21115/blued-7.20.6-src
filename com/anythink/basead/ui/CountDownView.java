package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/CountDownView.class */
public class CountDownView extends View {
    private Paint a;
    private Paint b;
    private Paint c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private RectF l;
    private float m;
    private String n;
    private Rect o;
    private int p;
    private float q;
    private Paint.FontMetrics r;

    public CountDownView(Context context) {
        this(context, null);
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.e = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f = Color.parseColor("#66000000");
        this.g = Color.parseColor("#CC000000");
        this.h = -1;
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.d);
        Paint paint2 = new Paint(this.a);
        this.b = paint2;
        paint2.setColor(this.f);
        this.b.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setTextSize(this.e);
        this.c.setColor(this.h);
        this.l = new RectF();
        this.o = new Rect();
    }

    private void a() {
        float f = this.d * 0.5f;
        float f2 = 0.0f + f;
        this.l.set(f2, f2, this.i - f, this.j - f);
        this.k = ((int) this.l.width()) >> 1;
    }

    private void a(Context context) {
        this.d = TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.e = TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        this.f = Color.parseColor("#66000000");
        this.g = Color.parseColor("#CC000000");
        this.h = -1;
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.d);
        Paint paint2 = new Paint(this.a);
        this.b = paint2;
        paint2.setColor(this.f);
        this.b.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setTextSize(this.e);
        this.c.setColor(this.h);
        this.l = new RectF();
        this.o = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.l.centerX(), this.l.centerY(), this.k, this.b);
        this.a.setColor(this.g);
        canvas.drawArc(this.l, 0.0f, 360.0f, false, this.a);
        this.a.setColor(this.h);
        canvas.drawArc(this.l, -90.0f, this.m, false, this.a);
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        Paint paint = this.c;
        String str = this.n;
        paint.getTextBounds(str, 0, str.length(), this.o);
        this.q = this.c.measureText(this.n);
        this.r = this.c.getFontMetrics();
        canvas.drawText(this.n, this.l.centerX() - (this.q / 2.0f), this.l.centerY() + (((this.r.bottom - this.r.top) / 2.0f) - this.r.bottom), this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = i;
        this.j = i2;
        a();
    }

    public void refresh(int i) {
        this.m = ((i * 1.0f) / this.p) * 360.0f;
        StringBuilder sb = new StringBuilder();
        sb.append((int) Math.ceil((this.p - i) / 1000.0d));
        this.n = sb.toString();
        invalidate();
    }

    public void setBgColor(int i) {
        this.f = i;
        this.b.setColor(i);
    }

    public void setDuration(int i) {
        this.p = i;
        StringBuilder sb = new StringBuilder();
        sb.append(i / 1000);
        this.n = sb.toString();
    }

    public void setThickInPx(int i) {
        float f = i;
        this.d = f;
        this.a.setStrokeWidth(f);
        a();
    }

    public void setUnderRingColor(int i) {
        this.g = i;
    }
}
