package com.blued.android.module.live_china.view.pkdared;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredPropProgressView.class */
public class PkDaredPropProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int f15414a;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    private float f15415c;
    private float d;
    private float e;
    private float f;
    private int g;

    public PkDaredPropProgressView(Context context) {
        super(context);
        this.e = 100.0f;
        this.f = -1.0f;
        a(context);
    }

    public PkDaredPropProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 100.0f;
        this.f = -1.0f;
        a(context);
    }

    public PkDaredPropProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 100.0f;
        this.f = -1.0f;
        a(context);
    }

    private void a(Canvas canvas) {
        if (this.f15414a == 0) {
            return;
        }
        float min = (int) ((Math.min(getMeasuredWidth(), getMeasuredHeight()) - this.e) / 2.0f);
        float f = this.e;
        RectF rectF = new RectF(min, min, min + f, f + min);
        Paint paint = getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f);
        canvas.drawArc(rectF, -90.0f, (-(this.f15414a / this.b)) * 360.0f, false, paint);
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(this.g);
        paint.setStrokeCap(Paint.Cap.ROUND);
        return paint;
    }

    protected void a(Context context) {
        this.f15414a = 90;
        this.b = 100;
    }

    public int getColor() {
        return this.g;
    }

    public int getProgress() {
        return this.f15414a;
    }

    public int getProgressMax() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f15415c = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.d = measuredHeight;
        float min = Math.min(this.f15415c, measuredHeight);
        float f = (min / 18.0f) * 1.5f;
        this.f = f;
        this.e = min - (f * 2.0f);
    }

    public void setColor(int i) {
        this.g = i;
        invalidate();
    }

    public void setProgress(float f) {
        setProgress((int) (this.b * f));
    }

    public void setProgress(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        int i3 = this.b;
        int i4 = i2;
        if (i2 > i3) {
            i4 = i3;
        }
        this.f15414a = i4;
        invalidate();
    }

    public void setProgressMax(int i) {
        this.b = i;
    }
}
