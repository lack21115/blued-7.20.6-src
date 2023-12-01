package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CountDownView.class */
public class CountDownView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private int f14709a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f14710c;
    private int d;
    private int e;
    private Paint f;
    private RectF g;
    private int h;
    private int i;
    private int j;
    private float k;
    private OnCountDownFinishListener l;

    /* renamed from: com.soft.blued.customview.CountDownView$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CountDownView$1.class */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownView f14711a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f14711a.k = (int) ((Float.valueOf(String.valueOf(valueAnimator.getAnimatedValue())).floatValue() / 100.0f) * 360.0f);
            this.f14711a.invalidate();
        }
    }

    /* renamed from: com.soft.blued.customview.CountDownView$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CountDownView$2.class */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownView f14712a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f14712a.l != null) {
                this.f14712a.l.a();
            }
            this.f14712a.setClickable(true);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CountDownView$OnCountDownFinishListener.class */
    public interface OnCountDownFinishListener {
        void a();
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CountDownView);
        this.f14709a = obtainStyledAttributes.getColor(3, context.getResources().getColor(2131101191));
        this.b = obtainStyledAttributes.getFloat(4, 2.0f);
        this.f14710c = obtainStyledAttributes.getDimensionPixelSize(2, a(18.0f));
        this.i = obtainStyledAttributes.getColor(1, context.getResources().getColor(2131101191));
        this.j = obtainStyledAttributes.getInteger(0, 5);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f = paint;
        paint.setAntiAlias(true);
        this.h = a(3.0f);
        setWillNotDraw(false);
    }

    private int a(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f.setColor(this.f14709a);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(this.b);
        canvas.drawArc(this.g, -90.0f, this.k, false, this.f);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        StringBuilder sb = new StringBuilder();
        int i = this.j;
        sb.append(i - ((int) ((this.k / 360.0f) * i)));
        sb.append("");
        String sb2 = sb.toString();
        paint.setTextSize(this.f14710c);
        paint.setColor(this.i);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.drawText(sb2, this.g.centerX(), (int) ((((this.g.bottom + this.g.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2.0f), paint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.d = getMeasuredWidth();
        this.e = getMeasuredHeight();
        float f = this.b;
        float f2 = f / 2.0f;
        int i5 = this.h;
        this.g = new RectF(f2 + 0.0f + i5, (f / 2.0f) + 0.0f + i5, (this.d - (f / 2.0f)) - i5, (this.e - (f / 2.0f)) - i5);
    }

    public void setAddCountDownListener(OnCountDownFinishListener onCountDownFinishListener) {
        this.l = onCountDownFinishListener;
    }

    public void setCountdownTime(int i) {
        this.j = i;
    }
}
