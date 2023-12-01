package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/animation/AlphaInAnimation.class */
public class AlphaInAnimation implements BaseAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final float f21565a;

    public AlphaInAnimation() {
        this(0.0f);
    }

    public AlphaInAnimation(float f) {
        this.f21565a = f;
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", this.f21565a, 1.0f)};
    }
}
