package com.blued.android.module.live_china.view.pkdared;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredScoreProgressView.class */
public class PkDaredScoreProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    protected float f15419a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    private float f15420c;
    private float d;

    public PkDaredScoreProgressView(Context context) {
        super(context);
        this.f15419a = 50.0f;
        this.b = 100.0f;
        a(context);
    }

    public PkDaredScoreProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15419a = 50.0f;
        this.b = 100.0f;
        a(context);
    }

    public PkDaredScoreProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15419a = 50.0f;
        this.b = 100.0f;
        a(context);
    }

    private Paint a(int i, int i2, float f, float f2) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.d);
        paint.setShader(new LinearGradient(f, 0.0f, f2, 0.0f, i, i2, Shader.TileMode.CLAMP));
        return paint;
    }

    private void a(Canvas canvas) {
        float f = this.f15419a / this.b;
        float f2 = this.d;
        float f3 = f2 / 2.0f;
        float f4 = (this.f15420c - f2) * f;
        float f5 = 0.0f;
        if (0.0f < f2) {
            f5 = 0.0f - f2;
        }
        canvas.drawLine(0.0f, f3, f4, f3, a(-14195216, -8931585, f5, f4));
    }

    private void b(Canvas canvas) {
        float f = this.f15419a / this.b;
        float f2 = this.f15420c;
        float f3 = this.d;
        float f4 = (f2 - f3) * f;
        float f5 = f3 / 2.0f;
        canvas.drawLine(f4, f5, f2, f5, a(-39971, -772534, f4, f2));
    }

    private void c(Canvas canvas) {
        float f = this.f15419a / this.b;
        float f2 = this.f15420c;
        float f3 = this.d;
        float f4 = (f2 - f3) * f;
        RectF rectF = new RectF(f4, 0.0f, f4 + f3, f3);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.live_pk_dared_score_progress), (Rect) null, rectF, paint);
    }

    protected void a(Context context) {
        this.f15419a = 50.0f;
        this.b = 100.0f;
    }

    public float getProgress() {
        return this.f15419a / this.b;
    }

    public float getProgressMax() {
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
        this.f15420c = getMeasuredWidth();
        this.d = getMeasuredHeight();
    }

    public void setProgress(float f) {
        setProgress((int) (this.b * f));
    }

    public void setProgress(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        float f = i2;
        float f2 = this.b;
        if (f > f2) {
            i2 = (int) f2;
        }
        this.f15419a = i2;
        invalidate();
    }

    public void setProgressMax(int i) {
        this.b = i;
    }
}
