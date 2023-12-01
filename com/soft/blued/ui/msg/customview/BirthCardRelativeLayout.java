package com.soft.blued.ui.msg.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/customview/BirthCardRelativeLayout.class */
public class BirthCardRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Rect f32270a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int f32271c;

    public BirthCardRelativeLayout(Context context) {
        this(context, null);
    }

    public BirthCardRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BirthCardRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32270a = new Rect();
        this.f32271c = 0;
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(this.f32271c);
        this.b.setStyle(Paint.Style.FILL);
    }

    public void a() {
        Logger.c(getClass().getSimpleName(), "startAnim");
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getMeasuredHeight());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.msg.customview.BirthCardRelativeLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BirthCardRelativeLayout.this.f32270a.top = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BirthCardRelativeLayout.this.invalidate();
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.msg.customview.BirthCardRelativeLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BirthCardRelativeLayout.this.b.setColor(0);
            }
        });
        ofInt.setDuration(2000L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        String simpleName = getClass().getSimpleName();
        Logger.c(simpleName, "dispatchDraw====" + this.b.getColor());
        canvas.drawRect(this.f32270a, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f32270a.left = 0;
        this.f32270a.right = getMeasuredWidth();
        this.f32270a.top = 0;
        this.f32270a.bottom = getMeasuredHeight();
    }

    public void setShadeColor(int i) {
        this.f32271c = i;
        this.b.setColor(i);
    }
}
