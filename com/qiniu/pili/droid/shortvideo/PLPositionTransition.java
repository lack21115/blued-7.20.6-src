package com.qiniu.pili.droid.shortvideo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLPositionTransition.class */
public class PLPositionTransition extends PLTransition {

    /* renamed from: c  reason: collision with root package name */
    private int f27499c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public PLPositionTransition(long j, long j2, int i, int i2, int i3, int i4) {
        super(j, j2);
        this.f27499c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public float a(long j) {
        long j2 = this.b * 1000000;
        long j3 = this.f27504a;
        long a2 = a();
        if (j < j2 || j > a2 * 1000000) {
            return 0.0f;
        }
        float abs = Math.abs(this.f27499c - this.e) * (((float) (j - j2)) / ((float) (j3 * 1000000)));
        int i = this.f27499c;
        return (i < this.e ? i + abs : i - abs) / this.g;
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLTransition
    public Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", this.f27499c, this.e);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", this.d, this.f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.f27504a);
        ofFloat.setStartDelay(this.b);
        ofFloat2.setDuration(this.f27504a);
        ofFloat2.setStartDelay(this.b);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public void a(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    public float b(long j) {
        long j2 = this.b * 1000000;
        long j3 = this.f27504a;
        long a2 = a();
        if (j < j2 || j > a2 * 1000000) {
            return 0.0f;
        }
        float abs = Math.abs(this.d - this.f) * (((float) (j - j2)) / ((float) (j3 * 1000000)));
        int i = this.d;
        return (i < this.f ? i + abs : i - abs) / this.h;
    }
}
