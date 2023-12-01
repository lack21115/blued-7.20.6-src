package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.mobads.sdk.internal.ci;
import com.soft.blued.utils.Logger;
import java.text.DecimalFormat;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/HelloProgressView.class */
public class HelloProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    DecimalFormat f14741a;
    private ValueAnimator b;

    /* renamed from: c  reason: collision with root package name */
    private float f14742c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int[] k;
    private float[] l;
    private double[] m;

    public HelloProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float a2 = a(15.0f);
        this.f14742c = a2;
        this.d = (int) Math.max(5.0f, a2);
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 360.0f;
        this.h = 10.0f;
        this.i = 10.0f;
        this.j = 3000;
        this.f14741a = new DecimalFormat(ci.d);
        int[] iArr = {Color.parseColor("#ffffff"), Color.parseColor("#016dff"), Color.parseColor("#62d4d4"), Color.parseColor("#62d4d4")};
        this.k = iArr;
        this.l = new float[iArr.length];
        this.m = new double[]{20.0d, 75.0d, 255.0d, 360.0d};
    }

    private int a(float f) {
        return (int) ((getContext().getResources().getDisplayMetrics().density * f) + ((f >= 0.0f ? 1 : -1) * 0.5f));
    }

    private int a(int i, boolean z) {
        int a2 = a(200.0f);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i2 = size;
        if (mode != Integer.MIN_VALUE) {
            i2 = size;
            if (mode != 1073741824) {
                int min = Math.min(a2, size);
                i2 = min;
                if (min == 0) {
                    i2 = 200;
                }
            }
        }
        return i2;
    }

    private void a(float f, float f2, int i) {
        this.b = ValueAnimator.ofFloat(f, f2);
        Logger.e("last=====", f + "");
        Logger.e("current=====", f2 + "");
        this.b.setDuration((long) i);
        this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.customview.HelloProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HelloProgressView.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                HelloProgressView.this.invalidate();
            }
        });
        this.b.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float a2 = a(5.0f);
        float height = (getHeight() - (this.d * 2)) / 2;
        int i = this.d;
        float f = i;
        float f2 = i;
        float f3 = 2.0f * height;
        RectF rectF = new RectF(f, f2, i + f3, f3 + i);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(a2);
        paint.setStrokeCap(Paint.Cap.ROUND);
        new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), this.k, this.l, Shader.TileMode.MIRROR);
        this.l[0] = Float.parseFloat(this.f14741a.format(this.m[0] / this.g));
        this.l[1] = Float.parseFloat(this.f14741a.format(this.m[1] / this.g));
        this.l[2] = Float.parseFloat(this.f14741a.format(this.m[2] / this.g));
        this.l[3] = Float.parseFloat(this.f14741a.format(this.m[3] / this.g));
        SweepGradient sweepGradient = new SweepGradient(height, height, this.k, this.l);
        Matrix matrix = new Matrix();
        matrix.setRotate(0.0f, height, height);
        sweepGradient.setLocalMatrix(matrix);
        paint.setShader(sweepGradient);
        canvas.scale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
        canvas.rotate(-89.0f, getWidth() / 2, getHeight() / 2);
        canvas.drawArc(rectF, this.h, this.e, false, paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i, true), a(i2, false));
    }

    public void setCurrentCount(float f) {
        float f2 = this.g;
        float f3 = f;
        if (f > f2) {
            f3 = f2;
        }
        this.f = f3;
        a(this.i, f3, this.j);
        this.i = this.e;
    }
}
