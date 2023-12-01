package com.blued.android.module.live_china.view.pkdared;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredTimeProgressView.class */
public class PkDaredTimeProgressView extends View {
    protected int a;
    protected int b;
    private float c;
    private float d;
    private float e;

    public PkDaredTimeProgressView(Context context) {
        super(context);
        this.a = 300;
        this.b = 300;
        this.e = -1.0f;
        a(context);
    }

    public PkDaredTimeProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 300;
        this.b = 300;
        this.e = -1.0f;
        a(context);
    }

    public PkDaredTimeProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 300;
        this.b = 300;
        this.e = -1.0f;
        a(context);
    }

    private void a(Canvas canvas) {
        float f = this.d;
        float f2 = this.e;
        float f3 = f - f2;
        float f4 = (f2 / 2.0f) + (f3 / 2.0f);
        float f5 = f / 2.0f;
        float f6 = this.c;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(-2013265920);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f3);
        canvas.drawLine(f4, f5, f4 + ((f6 - f2) - f3), f5, paint);
    }

    private void a(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6) {
        if (f3 <= 0.0f) {
            return;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        float f7 = f - f4;
        float f8 = (float) (f7 * 3.141592653589793d);
        float f9 = (f2 - f4) - f7;
        float f10 = f8 * 2.0f;
        float f11 = ((f9 * 2.0f) + f10) * f3;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f4);
        if (f3 < 1.0f) {
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
        float f12 = f11 / f10;
        float f13 = f12;
        if (f12 > 0.5f) {
            f13 = 0.5f;
        }
        float f14 = f6 + f7;
        canvas.drawArc(f5, f6, f5 + f7, f14, -90.0f, (-f13) * 360.0f, false, paint);
        if (f11 <= f8) {
            return;
        }
        float f15 = f11 - f8;
        float f16 = f15 > f9 ? f9 : f15;
        float f17 = f5 + (f7 / 2.0f);
        float f18 = f16 + f17;
        canvas.drawLine(f17, f14, f18, f14, paint);
        if (f11 <= f8 + f9) {
            return;
        }
        float f19 = (f15 - f9) / f10;
        float f20 = f19;
        if (f19 > 0.5f) {
            f20 = 0.5f;
        }
        float f21 = f5 + f9;
        canvas.drawArc(f21, f6, f21 + f7, f14, 90.0f, (-f20) * 360.0f, false, paint);
        if (f11 <= f10 + f9) {
            return;
        }
        float f22 = (f11 - f10) - f9;
        if (f22 <= f9) {
            f9 = f22;
        }
        canvas.drawLine(f18, f6, f18 - f9, f6, paint);
    }

    private void b(Canvas canvas) {
        float f = this.d;
        float f2 = this.e;
        float f3 = f2 / 2.0f;
        float f4 = f2 / 2.0f;
        float f5 = f3 / 2.0f;
        a(canvas, -1996488705, f - f2, this.c - f2, 1.0f, f3, f4 + f5, (f2 / 2.0f) + f5);
    }

    private void c(Canvas canvas) {
        float f = this.d;
        float f2 = this.c;
        float f3 = this.a / this.b;
        float f4 = this.e;
        a(canvas, -1, f, f2, f3, f4, f4 / 2.0f, f4 / 2.0f);
    }

    protected void a(Context context) {
        this.e = 7.0f;
        this.b = 300;
        this.a = 300;
    }

    public int getProgress() {
        return this.a;
    }

    public int getProgressMax() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
        c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.d = measuredHeight;
        this.e = measuredHeight / 12.0f;
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
        this.a = i4;
        invalidate();
    }

    public void setProgressMax(int i) {
        this.b = i;
        invalidate();
    }
}
