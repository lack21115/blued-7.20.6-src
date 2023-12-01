package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LineProgressView.class */
public final class LineProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f14337a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private float f14338c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private Paint j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineProgressView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.b = 100;
        this.e = -1;
        this.f = -1;
        this.g = -256;
        this.h = Color.CYAN;
        this.i = true;
        a(context, (AttributeSet) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.b = 100;
        this.e = -1;
        this.f = -1;
        this.g = -256;
        this.h = Color.CYAN;
        this.i = true;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.b = 100;
        this.e = -1;
        this.f = -1;
        this.g = -256;
        this.h = Color.CYAN;
        this.i = true;
        a(context, attributeSet);
    }

    private final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.e = -1;
            this.f = -1;
            this.g = -256;
            this.h = Color.CYAN;
            this.i = true;
            invalidate();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LineProgressView);
        Intrinsics.c(obtainStyledAttributes, "context.obtainStyledAttr…yleable.LineProgressView)");
        this.e = obtainStyledAttributes.getColor(R.styleable.LineProgressView_lpv_color_gradient_start, -1);
        this.f = obtainStyledAttributes.getColor(R.styleable.LineProgressView_lpv_color_gradient_end, -1);
        this.g = obtainStyledAttributes.getColor(R.styleable.LineProgressView_lpv_color, 0);
        this.h = obtainStyledAttributes.getColor(R.styleable.LineProgressView_lpv_color_under, 0);
        this.i = obtainStyledAttributes.getBoolean(R.styleable.LineProgressView_lpv_zero_has_dot, true);
        invalidate();
    }

    private final void a(Canvas canvas, Paint paint) {
        float f = this.d;
        float f2 = 2;
        float f3 = f / f2;
        float f4 = f / f2;
        paint.setColor(this.h);
        canvas.drawLine(f3, f4, this.f14338c - (f / f2), f4, paint);
    }

    private final void b(Canvas canvas, Paint paint) {
        if (this.d <= 0.0f || this.f14338c <= 0.0f) {
            return;
        }
        float f = this.f14337a / this.b;
        if (f > 0.0f || this.i) {
            float f2 = this.d;
            float f3 = 2;
            float f4 = f2 / f3;
            float f5 = f2 / f3;
            float f6 = f4 + ((this.f14338c - f2) * f);
            if (this.e == -1 || this.f == -1) {
                paint.setColor(this.g);
            } else {
                paint.setColor(0);
                paint.setShader(new LinearGradient(f4, 0.0f, f6, 0.0f, this.e, this.f, Shader.TileMode.CLAMP));
            }
            canvas.drawLine(f4, f5, f6, f5, paint);
        }
    }

    private final Paint getPaint() {
        if (this.j == null) {
            Paint paint = new Paint();
            this.j = paint;
            if (paint != null) {
                paint.setAntiAlias(true);
            }
            Paint paint2 = this.j;
            if (paint2 != null) {
                paint2.setDither(true);
            }
            Paint paint3 = this.j;
            if (paint3 != null) {
                paint3.setStrokeCap(Paint.Cap.ROUND);
            }
            Paint paint4 = this.j;
            if (paint4 != null) {
                paint4.setStyle(Paint.Style.STROKE);
            }
            Paint paint5 = this.j;
            if (paint5 != null) {
                paint5.setStrokeWidth(this.d);
            }
        }
        Paint paint6 = this.j;
        Intrinsics.a(paint6);
        return paint6;
    }

    public final int getProgress() {
        return this.f14337a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        Paint paint = getPaint();
        a(canvas, paint);
        b(canvas, paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f14338c = getMeasuredWidth();
        this.d = getMeasuredHeight();
        invalidate();
    }

    public final void setProgress(float f) {
        setProgress((int) (this.b * f));
    }

    public final void setProgress(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        int i3 = this.b;
        int i4 = i2;
        if (i2 > i3) {
            i4 = i3;
        }
        this.f14337a = i4;
        invalidate();
    }

    public final void setProgressMax(int i) {
        this.b = i;
        invalidate();
    }
}
