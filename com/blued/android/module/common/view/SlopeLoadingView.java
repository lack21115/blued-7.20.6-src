package com.blued.android.module.common.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/SlopeLoadingView.class */
public final class SlopeLoadingView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f11051a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private ValueAnimator f11052c;
    private int d;
    private int e;
    private float f;
    private float g;
    private Paint h;
    private ObjectAnimator i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlopeLoadingView(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.b = 100;
        this.f = 100.0f;
        a(context, (AttributeSet) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlopeLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        this.b = 100;
        this.f = 100.0f;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlopeLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.b = 100;
        this.f = 100.0f;
        a(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlopeLoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.e(context, "context");
        this.b = 100;
        this.f = 100.0f;
        a(context, attributeSet);
    }

    private final void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        a(attributeSet);
    }

    private final void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f11051a = 0;
            this.f = DisplayUtil.a(getContext(), 45.0f);
            this.g = DisplayUtil.a(getContext(), 6.0f);
            this.e = ContextCompat.getColor(getContext(), R.color.syc_dark_a);
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.slope_loading);
        Intrinsics.c(obtainStyledAttributes, "context.obtainStyledAttr….styleable.slope_loading)");
        this.f = obtainStyledAttributes.getDimension(R.styleable.slope_loading_slope_diameter, DisplayUtil.a(getContext(), 45.0f));
        this.g = obtainStyledAttributes.getDimension(R.styleable.slope_loading_slope_line_width, DisplayUtil.a(getContext(), 6.0f));
        this.e = obtainStyledAttributes.getColor(R.styleable.slope_loading_slope_color, ContextCompat.getColor(getContext(), R.color.syc_dark_a));
        obtainStyledAttributes.recycle();
        post(new Runnable() { // from class: com.blued.android.module.common.view.-$$Lambda$SlopeLoadingView$XNbO7knKPOu5MvoEWLdvvcTbPIE
            @Override // java.lang.Runnable
            public final void run() {
                SlopeLoadingView.a(SlopeLoadingView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SlopeLoadingView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SlopeLoadingView this$0, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        this$0.d = ((Integer) animatedValue).intValue();
    }

    public final void a() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            Intrinsics.a(objectAnimator);
            if (objectAnimator.isRunning()) {
                return;
            }
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 360);
        this.f11052c = ofInt;
        Intrinsics.a(ofInt);
        ofInt.setDuration(780L);
        ValueAnimator valueAnimator = this.f11052c;
        Intrinsics.a(valueAnimator);
        valueAnimator.setRepeatCount(-1);
        ValueAnimator valueAnimator2 = this.f11052c;
        Intrinsics.a(valueAnimator2);
        valueAnimator2.setRepeatMode(1);
        ValueAnimator valueAnimator3 = this.f11052c;
        Intrinsics.a(valueAnimator3);
        valueAnimator3.setInterpolator(new LinearInterpolator());
        ValueAnimator valueAnimator4 = this.f11052c;
        Intrinsics.a(valueAnimator4);
        valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.-$$Lambda$SlopeLoadingView$dFJQOupSg5dJMPJCqO5YfEhOUPE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                SlopeLoadingView.a(SlopeLoadingView.this, valueAnimator5);
            }
        });
        ValueAnimator valueAnimator5 = this.f11052c;
        Intrinsics.a(valueAnimator5);
        valueAnimator5.start();
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "progress", 90, 1);
        this.i = ofInt2;
        Intrinsics.a(ofInt2);
        ofInt2.setRepeatCount(-1);
        ObjectAnimator objectAnimator2 = this.i;
        Intrinsics.a(objectAnimator2);
        objectAnimator2.setRepeatMode(2);
        ObjectAnimator objectAnimator3 = this.i;
        Intrinsics.a(objectAnimator3);
        objectAnimator3.setDuration(920L);
        ObjectAnimator objectAnimator4 = this.i;
        Intrinsics.a(objectAnimator4);
        objectAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator objectAnimator5 = this.i;
        Intrinsics.a(objectAnimator5);
        objectAnimator5.start();
    }

    public final void a(boolean z) {
        if (z) {
            setAlpha(0.0f);
            setVisibility(0);
            animate().alpha(1.0f).setDuration(300L).setStartDelay(250L).start();
            a();
            return;
        }
        setVisibility(8);
        ValueAnimator valueAnimator = this.f11052c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f11052c;
        if (valueAnimator2 != null) {
            valueAnimator2.mo53clone();
        }
        this.f11052c = null;
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.i;
        if (objectAnimator2 != null) {
            objectAnimator2.mo53clone();
        }
        this.i = null;
    }

    public final void b() {
        a(true);
    }

    public final void c() {
        a(false);
    }

    public final int getCurrentRotation() {
        return this.d;
    }

    public final float getLine() {
        return this.g;
    }

    public final int getMaxProgress() {
        return this.b;
    }

    public final int getProgress() {
        return this.f11051a;
    }

    public final ValueAnimator getRotationAnim() {
        return this.f11052c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        if (this.h == null) {
            Paint paint = new Paint();
            this.h = paint;
            Intrinsics.a(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.h;
            Intrinsics.a(paint2);
            paint2.setDither(true);
            Paint paint3 = this.h;
            Intrinsics.a(paint3);
            paint3.setStyle(Paint.Style.STROKE);
            Paint paint4 = this.h;
            Intrinsics.a(paint4);
            paint4.setStrokeCap(Paint.Cap.ROUND);
            Paint paint5 = this.h;
            Intrinsics.a(paint5);
            paint5.setStrokeWidth(this.g);
        }
        float f = this.f11051a / this.b;
        float f2 = this.d;
        float f3 = 2;
        float measuredWidth = (getMeasuredWidth() - this.f) / f3;
        float measuredHeight = (getMeasuredHeight() - this.f) / f3;
        float f4 = this.f;
        RectF rectF = new RectF(measuredWidth, measuredHeight, measuredWidth + f4, f4 + measuredHeight);
        Paint paint6 = this.h;
        Intrinsics.a(paint6);
        paint6.setColor(this.e);
        Paint paint7 = this.h;
        Intrinsics.a(paint7);
        canvas.drawArc(rectF, ((-90) - (180 * f)) + f2, f * 360, false, paint7);
    }

    public final void setCurrentRotation(int i) {
        this.d = i;
    }

    public final void setLine(float f) {
        this.g = f;
    }

    public final void setMaxProgress(int i) {
        this.b = i;
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
        this.f11051a = i4;
        invalidate();
    }

    public final void setRingColor(int i) {
        if (i != 0) {
            this.e = i;
        }
    }

    public final void setRotationAnim(ValueAnimator valueAnimator) {
        this.f11052c = valueAnimator;
    }
}
