package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/jobs/AnimatedViewPortJob.class */
public abstract class AnimatedViewPortJob extends ViewPortJob implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    protected ObjectAnimator f22154a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    protected float f22155c;
    protected float d;

    public AnimatedViewPortJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view, float f3, float f4, long j) {
        super(viewPortHandler, f, f2, transformer, view);
        this.f22155c = f3;
        this.d = f4;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, TypedValues.CycleType.S_WAVE_PHASE, 0.0f, 1.0f);
        this.f22154a = ofFloat;
        ofFloat.setDuration(j);
        this.f22154a.addUpdateListener(this);
        this.f22154a.addListener(this);
    }

    public abstract void a();

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        try {
            a();
        } catch (IllegalArgumentException e) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        try {
            a();
        } catch (IllegalArgumentException e) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22154a.start();
    }
}
