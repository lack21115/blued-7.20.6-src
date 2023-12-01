package com.blued.android.module.live_china.view.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/progress/SlopeProgress.class */
public class SlopeProgress extends View {
    protected OnProgressListener a;
    public int b;
    protected int c;
    private int d;
    private int e;
    private float f;
    private int g;
    private float h;

    public SlopeProgress(Context context) {
        super(context);
        this.b = 0;
        this.c = 100;
        this.f = 100.0f;
        this.g = 0;
        this.h = -1.0f;
        this.d = ContextCompat.getColor(context, R.color.colorPrimary);
    }

    public SlopeProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 100;
        this.f = 100.0f;
        this.g = 0;
        this.h = -1.0f;
        a(context, attributeSet);
    }

    public SlopeProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = 100;
        this.f = 100.0f;
        this.g = 0;
        this.h = -1.0f;
        a(context, attributeSet);
    }

    private Paint a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.h);
        return paint;
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.b = 0;
            this.c = 100;
            this.d = -16736618;
            this.e = 855678614;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.slope_progress);
        this.h = obtainStyledAttributes.getDimension(R.styleable.slope_progress_bam_line_width, -1.0f);
        this.b = obtainStyledAttributes.getInteger(R.styleable.slope_progress_bam_progress, 0);
        this.c = obtainStyledAttributes.getInteger(R.styleable.slope_progress_bam_progress_max, 100);
        this.d = obtainStyledAttributes.getColor(R.styleable.slope_progress_bam_color_finished, -16736618);
        this.e = obtainStyledAttributes.getColor(R.styleable.slope_progress_bam_color_un_finished, 855678614);
        obtainStyledAttributes.recycle();
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.progress.-$$Lambda$T9WdYMh3OZkg06fFONPM3zVVf2w
            @Override // java.lang.Runnable
            public final void run() {
                SlopeProgress.this.invalidate();
            }
        });
    }

    private void a(Canvas canvas) {
        float f = (this.b / this.c) * 360.0f;
        this.g = (int) ((Math.min(getMeasuredWidth(), getMeasuredHeight()) - this.f) / 2.0f);
        int i = this.g;
        float f2 = i;
        float f3 = i;
        float f4 = i;
        float f5 = this.f;
        RectF rectF = new RectF(f2, f3, f4 + f5, i + f5);
        Paint a = a();
        a.setColor(this.e);
        canvas.drawArc(rectF, f + 90.0f, 360.0f - f, false, a);
        Paint a2 = a();
        a2.setColor(this.d);
        canvas.drawArc(rectF, 90.0f, f, false, a2);
    }

    public float getLineWidth() {
        return this.h;
    }

    public int getProgress() {
        return this.b;
    }

    public int getProgressMax() {
        return this.c;
    }

    public int getRingColor() {
        return this.d;
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
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int min = Math.min(measuredWidth, measuredHeight);
        float f = this.h;
        float f2 = f;
        if (f == -1.0f) {
            f2 = min * 0.13f;
        }
        this.h = f2;
        this.f = min - (f2 * 2.0f);
        this.g = (int) ((Math.min(measuredWidth, measuredHeight) - this.f) / 2.0f);
    }

    public void setLineWidth(float f) {
        this.h = f;
        invalidate();
    }

    public void setProgress(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        int i3 = this.c;
        int i4 = i2;
        if (i2 > i3) {
            i4 = i3;
        }
        this.b = i4;
        OnProgressListener onProgressListener = this.a;
        if (onProgressListener != null) {
            onProgressListener.a(this, i4);
        }
        invalidate();
    }

    public void setProgressListener(OnProgressListener onProgressListener) {
        this.a = onProgressListener;
    }

    public void setRingColor(int i) {
        if (i > 0) {
            this.d = i;
        }
        invalidate();
    }
}
