package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* loaded from: source-7206380-dex2jar.jar:com/chad/library/adapter/base/animation/ScaleInAnimation.class */
public class ScaleInAnimation implements BaseAnimation {

    /* renamed from: a  reason: collision with root package name */
    private final float f7960a;

    public ScaleInAnimation() {
        this(0.5f);
    }

    public ScaleInAnimation(float f) {
        this.f7960a = f;
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] a(View view) {
        return new ObjectAnimator[]{ObjectAnimator.ofFloat(view, "scaleX", this.f7960a, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", this.f7960a, 1.0f)};
    }
}
