package com.blued.android.framework.ui.xpop.animator;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/ScrollScaleAnimator.class */
public class ScrollScaleAnimator extends PopupAnimator {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9945a;
    private IntEvaluator b;
    private int e;
    private int f;
    private float g;
    private float h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator$4  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/ScrollScaleAnimator$4.class */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9950a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            f9950a = iArr;
            try {
                iArr[PopupAnimation.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9950a[PopupAnimation.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9950a[PopupAnimation.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9950a[PopupAnimation.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9950a[PopupAnimation.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9950a[PopupAnimation.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9950a[PopupAnimation.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f9950a[PopupAnimation.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public ScrollScaleAnimator(View view, PopupAnimation popupAnimation) {
        super(view, popupAnimation);
        this.b = new IntEvaluator();
        this.g = 0.0f;
        this.h = 0.0f;
        this.f9945a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        switch (AnonymousClass4.f9950a[this.d.ordinal()]) {
            case 1:
                this.f9941c.setPivotX(0.0f);
                this.f9941c.setPivotY(this.f9941c.getMeasuredHeight() / 2);
                this.e = this.f9941c.getMeasuredWidth();
                this.f = 0;
                return;
            case 2:
                this.f9941c.setPivotX(0.0f);
                this.f9941c.setPivotY(0.0f);
                this.e = this.f9941c.getMeasuredWidth();
                this.f = this.f9941c.getMeasuredHeight();
                return;
            case 3:
                this.f9941c.setPivotX(this.f9941c.getMeasuredWidth() / 2);
                this.f9941c.setPivotY(0.0f);
                this.f = this.f9941c.getMeasuredHeight();
                return;
            case 4:
                this.f9941c.setPivotX(this.f9941c.getMeasuredWidth());
                this.f9941c.setPivotY(0.0f);
                this.e = -this.f9941c.getMeasuredWidth();
                this.f = this.f9941c.getMeasuredHeight();
                return;
            case 5:
                this.f9941c.setPivotX(this.f9941c.getMeasuredWidth());
                this.f9941c.setPivotY(this.f9941c.getMeasuredHeight() / 2);
                this.e = -this.f9941c.getMeasuredWidth();
                return;
            case 6:
                this.f9941c.setPivotX(this.f9941c.getMeasuredWidth());
                this.f9941c.setPivotY(this.f9941c.getMeasuredHeight());
                this.e = -this.f9941c.getMeasuredWidth();
                this.f = -this.f9941c.getMeasuredHeight();
                return;
            case 7:
                this.f9941c.setPivotX(this.f9941c.getMeasuredWidth() / 2);
                this.f9941c.setPivotY(this.f9941c.getMeasuredHeight());
                this.f = -this.f9941c.getMeasuredHeight();
                return;
            case 8:
                this.f9941c.setPivotX(0.0f);
                this.f9941c.setPivotY(this.f9941c.getMeasuredHeight());
                this.e = this.f9941c.getMeasuredWidth();
                this.f = -this.f9941c.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        this.f9941c.setAlpha(this.g);
        this.f9941c.setScaleX(this.h);
        if (!this.f9945a) {
            this.f9941c.setScaleY(this.h);
        }
        this.f9941c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollScaleAnimator.this.d();
                ScrollScaleAnimator.this.f9941c.scrollTo(ScrollScaleAnimator.this.e, ScrollScaleAnimator.this.f);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.f9941c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator.2
            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        ScrollScaleAnimator.this.f9941c.setAlpha(animatedFraction);
                        ScrollScaleAnimator.this.f9941c.scrollTo(ScrollScaleAnimator.this.b.evaluate(animatedFraction, Integer.valueOf(ScrollScaleAnimator.this.e), (Integer) 0).intValue(), ScrollScaleAnimator.this.b.evaluate(animatedFraction, Integer.valueOf(ScrollScaleAnimator.this.f), (Integer) 0).intValue());
                        ScrollScaleAnimator.this.f9941c.setScaleX(animatedFraction);
                        if (ScrollScaleAnimator.this.f9945a) {
                            return;
                        }
                        ScrollScaleAnimator.this.f9941c.setScaleY(animatedFraction);
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
                ScrollScaleAnimator.this.f9941c.setAlpha(f);
                ScrollScaleAnimator.this.f9941c.scrollTo(ScrollScaleAnimator.this.b.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(ScrollScaleAnimator.this.e)).intValue(), ScrollScaleAnimator.this.b.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(ScrollScaleAnimator.this.f)).intValue());
                ScrollScaleAnimator.this.f9941c.setScaleX(f);
                if (ScrollScaleAnimator.this.f9945a) {
                    return;
                }
                ScrollScaleAnimator.this.f9941c.setScaleY(f);
            }
        });
        ofFloat.setDuration(XPopup.b()).setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.start();
    }
}
