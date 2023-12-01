package com.blued.android.module.live_china.view.recommend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/recommend/RefreshHeaderSlopeProgress.class */
public class RefreshHeaderSlopeProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f15435a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f15436c;
    private int d;
    private float e;
    private float f;

    public RefreshHeaderSlopeProgress(Context context) {
        super(context);
        this.f15435a = 0;
        this.b = 100;
        this.e = 100.0f;
        this.f = 0.0f;
        a(context);
    }

    public RefreshHeaderSlopeProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15435a = 0;
        this.b = 100;
        this.e = 100.0f;
        this.f = 0.0f;
        a(context);
    }

    public RefreshHeaderSlopeProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15435a = 0;
        this.b = 100;
        this.e = 100.0f;
        this.f = 0.0f;
        a(context);
    }

    public RefreshHeaderSlopeProgress(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f15435a = 0;
        this.b = 100;
        this.e = 100.0f;
        this.f = 0.0f;
        a(context);
    }

    private void a(Context context) {
        this.f15436c = ContextCompat.getColor(context, R.color.white);
        this.d = ContextCompat.getColor(context, R.color.syc_dark_30ffffff);
    }

    public float getLine() {
        return this.f;
    }

    public int getMaxProgress() {
        return this.b;
    }

    public int getProgress() {
        return this.f15435a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f);
        float f = this.f15435a / this.b;
        float f2 = (-90.0f) - (180.0f * f);
        float f3 = f * 360.0f;
        float f4 = (int) ((min - this.e) / 2.0f);
        float f5 = this.e;
        RectF rectF = new RectF(f4, f4, f4 + f5, f5 + f4);
        paint.setColor(this.d);
        canvas.drawArc(rectF, f2 + f3, 360.0f - f3, false, paint);
        paint.setColor(this.f15436c);
        canvas.drawArc(rectF, f2, f3, false, paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        if (this.f == 0.0f) {
            this.f = min * 0.13f;
        }
        this.e = min - (this.f * 2.0f);
        invalidate();
    }

    public void setLine(float f) {
        this.f = f;
    }

    public void setMaxProgress(int i) {
        this.b = i;
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
        this.f15435a = i4;
        invalidate();
    }

    public void setRingColor(int i) {
        if (i != 0) {
            this.f15436c = i;
        }
    }
}
