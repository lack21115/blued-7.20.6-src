package com.opos.mobad.q.a.f.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/f/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private ObjectAnimator f13505a;
    private ObjectAnimator b;

    /* renamed from: c  reason: collision with root package name */
    private AnimatorSet f13506c;
    private View d;
    private float e;
    private float f;
    private long g;

    public f(View view, float f, float f2, long j) {
        this.e = 1.0f;
        this.f = 1.1f;
        this.g = com.igexin.push.config.c.j;
        this.d = view;
        if (f > 0.0f) {
            this.e = f;
        }
        if (f2 > 0.0f) {
            this.f = f2;
        }
        if (j > 0) {
            this.g = j;
        }
        c();
    }

    private void c() {
        try {
            if (this.d == null) {
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, "scaleX", this.e, this.f, this.e);
            this.f13505a = ofFloat;
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.d, "scaleY", this.e, this.f, this.e);
            this.b = ofFloat2;
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f13506c = animatorSet;
            animatorSet.play(this.f13505a).with(this.b);
            this.f13506c.setDuration(this.g);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e);
        }
    }

    public void a() {
        try {
            if (this.d == null) {
                return;
            }
            this.f13506c.start();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e);
        }
    }

    public void b() {
        try {
            if (this.d == null) {
                return;
            }
            this.f13506c.cancel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ScaleAnimator", "", (Throwable) e);
        }
    }
}
