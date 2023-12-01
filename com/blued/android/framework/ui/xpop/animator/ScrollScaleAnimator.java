package com.blued.android.framework.ui.xpop.animator;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/ScrollScaleAnimator.class */
public class ScrollScaleAnimator extends PopupAnimator {
    public boolean a;
    private IntEvaluator b;
    private int e;
    private int f;
    private float g;
    private float h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator$4  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/ScrollScaleAnimator$4.class */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            a = iArr;
            try {
                iArr[PopupAnimation.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                a[PopupAnimation.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public ScrollScaleAnimator(View view, PopupAnimation popupAnimation) {
        super(view, popupAnimation);
        this.b = new IntEvaluator();
        this.g = 0.0f;
        this.h = 0.0f;
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        switch (AnonymousClass4.a[this.d.ordinal()]) {
            case 1:
                this.c.setPivotX(0.0f);
                this.c.setPivotY(this.c.getMeasuredHeight() / 2);
                this.e = this.c.getMeasuredWidth();
                this.f = 0;
                return;
            case 2:
                this.c.setPivotX(0.0f);
                this.c.setPivotY(0.0f);
                this.e = this.c.getMeasuredWidth();
                this.f = this.c.getMeasuredHeight();
                return;
            case 3:
                this.c.setPivotX(this.c.getMeasuredWidth() / 2);
                this.c.setPivotY(0.0f);
                this.f = this.c.getMeasuredHeight();
                return;
            case 4:
                this.c.setPivotX(this.c.getMeasuredWidth());
                this.c.setPivotY(0.0f);
                this.e = -this.c.getMeasuredWidth();
                this.f = this.c.getMeasuredHeight();
                return;
            case 5:
                this.c.setPivotX(this.c.getMeasuredWidth());
                this.c.setPivotY(this.c.getMeasuredHeight() / 2);
                this.e = -this.c.getMeasuredWidth();
                return;
            case 6:
                this.c.setPivotX(this.c.getMeasuredWidth());
                this.c.setPivotY(this.c.getMeasuredHeight());
                this.e = -this.c.getMeasuredWidth();
                this.f = -this.c.getMeasuredHeight();
                return;
            case 7:
                this.c.setPivotX(this.c.getMeasuredWidth() / 2);
                this.c.setPivotY(this.c.getMeasuredHeight());
                this.f = -this.c.getMeasuredHeight();
                return;
            case 8:
                this.c.setPivotX(0.0f);
                this.c.setPivotY(this.c.getMeasuredHeight());
                this.e = this.c.getMeasuredWidth();
                this.f = -this.c.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        this.c.setAlpha(this.g);
        this.c.setScaleX(this.h);
        if (!this.a) {
            this.c.setScaleY(this.h);
        }
        this.c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollScaleAnimator.this.d();
                ScrollScaleAnimator.this.c.scrollTo(ScrollScaleAnimator.this.e, ScrollScaleAnimator.this.f);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator.2
            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        ScrollScaleAnimator.this.c.setAlpha(animatedFraction);
                        ScrollScaleAnimator.this.c.scrollTo(ScrollScaleAnimator.this.b.evaluate(animatedFraction, Integer.valueOf(ScrollScaleAnimator.this.e), (Integer) 0).intValue(), ScrollScaleAnimator.this.b.evaluate(animatedFraction, Integer.valueOf(ScrollScaleAnimator.this.f), (Integer) 0).intValue());
                        ScrollScaleAnimator.this.c.setScaleX(animatedFraction);
                        if (ScrollScaleAnimator.this.a) {
                            return;
                        }
                        ScrollScaleAnimator.this.c.setScaleY(animatedFraction);
                    }
                });
                ofFloat.setDuration(XPopup.b()).setInterpolator(new FastOutSlowInInterpolator());
                ofFloat.start();
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float f = 1.0f - animatedFraction;
                ScrollScaleAnimator.this.c.setAlpha(f);
                ScrollScaleAnimator.this.c.scrollTo(ScrollScaleAnimator.this.b.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(ScrollScaleAnimator.this.e)).intValue(), ScrollScaleAnimator.this.b.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(ScrollScaleAnimator.this.f)).intValue());
                ScrollScaleAnimator.this.c.setScaleX(f);
                if (ScrollScaleAnimator.this.a) {
                    return;
                }
                ScrollScaleAnimator.this.c.setScaleY(f);
            }
        });
        ofFloat.setDuration(XPopup.b()).setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.start();
    }
}
