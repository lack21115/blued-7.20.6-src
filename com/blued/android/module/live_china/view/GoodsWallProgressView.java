package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/GoodsWallProgressView.class */
public class GoodsWallProgressView extends View {
    protected int a;
    protected int b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;

    public GoodsWallProgressView(Context context) {
        super(context);
        this.a = 0;
        this.b = 100;
        this.e = -1;
        this.f = -1;
        a(context, (AttributeSet) null);
    }

    public GoodsWallProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 100;
        this.e = -1;
        this.f = -1;
        a(context, attributeSet);
    }

    public GoodsWallProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 100;
        this.e = -1;
        this.f = -1;
        a(context, attributeSet);
    }

    private void a(Canvas canvas, Paint paint) {
        float f = this.d;
        float f2 = f / 2.0f;
        float f3 = f / 2.0f;
        paint.setColor(this.h);
        canvas.drawLine(f2, f3, this.c - (f / 2.0f), f3, paint);
    }

    private void b(Canvas canvas, Paint paint) {
        int i;
        float f = this.d;
        if (f > 0.0f) {
            float f2 = this.c;
            if (f2 <= 0.0f || (i = this.a) == 0) {
                return;
            }
            float f3 = i / this.b;
            float f4 = f / 2.0f;
            float f5 = f / 2.0f;
            float f6 = f4 + ((f2 - f) * f3);
            if (this.e == -1 || this.f == -1) {
                paint.setColor(this.g);
            } else {
                paint.setColor(-1);
                paint.setShader(new LinearGradient(f4, 0.0f, f6, 0.0f, this.e, this.f, Shader.TileMode.CLAMP));
            }
            canvas.drawLine(f4, f5, f6, f5, paint);
        }
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.d);
        return paint;
    }

    protected void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PkDaredEggProgressView);
        this.e = obtainStyledAttributes.getColor(R.styleable.PkDaredEggProgressView_pdep_color_gradient_start, -1);
        this.f = obtainStyledAttributes.getColor(R.styleable.PkDaredEggProgressView_pdep_color_gradient_end, -1);
        this.g = obtainStyledAttributes.getColor(R.styleable.PkDaredEggProgressView_pdep_color, 0);
        this.h = obtainStyledAttributes.getColor(R.styleable.PkDaredEggProgressView_pdep_color_under, 0);
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
        Paint paint = getPaint();
        a(canvas, paint);
        b(canvas, paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = getMeasuredWidth();
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
