package com.blued.android.framework.ui.xpop.animator;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/ShadowBgAnimator.class */
public class ShadowBgAnimator extends PopupAnimator {

    /* renamed from: a  reason: collision with root package name */
    public ArgbEvaluator f9951a;
    public int b;
    public boolean e;

    public ShadowBgAnimator() {
        this.f9951a = new ArgbEvaluator();
        this.b = 0;
        this.e = false;
    }

    public ShadowBgAnimator(View view) {
        super(view);
        this.f9951a = new ArgbEvaluator();
        this.b = 0;
        this.e = false;
    }

    public int a(float f) {
        return ((Integer) this.f9951a.evaluate(f, Integer.valueOf(this.b), Integer.valueOf(XPopup.a()))).intValue();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        this.f9941c.setBackgroundColor(this.b);
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f9951a, Integer.valueOf(this.b), Integer.valueOf(XPopup.a()));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShadowBgAnimator.this.f9941c.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(this.e ? 0L : XPopup.b()).start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f9951a, Integer.valueOf(XPopup.a()), Integer.valueOf(this.b));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.ui.xpop.animator.ShadowBgAnimator.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShadowBgAnimator.this.f9941c.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(this.e ? 0L : XPopup.b()).start();
    }
}
