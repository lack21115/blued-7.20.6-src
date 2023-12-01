package com.qiniu.pili.droid.shortvideo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLFadeTransition.class */
public class PLFadeTransition extends PLTransition {

    /* renamed from: c  reason: collision with root package name */
    private float f27492c;
    private float d;

    public PLFadeTransition(long j, long j2, float f, float f2) {
        super(j, j2);
        this.f27492c = f;
        this.d = f2;
    }

    public float a(long j) {
        long j2 = this.b * 1000000;
        long j3 = this.f27504a;
        long a2 = a();
        if (j < j2 || j > a2 * 1000000) {
            return 1.0f;
        }
        float abs = (Math.abs(this.f27492c - this.d) * ((float) (j - j2))) / ((float) (j3 * 1000000));
        float f = this.f27492c;
        return f < this.d ? f + abs : f - abs;
    }

    @Override // com.qiniu.pili.droid.shortvideo.PLTransition
    public Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", this.f27492c, this.d);
        ofFloat.setDuration(this.f27504a);
        ofFloat.setStartDelay(this.b);
        return ofFloat;
    }
}
