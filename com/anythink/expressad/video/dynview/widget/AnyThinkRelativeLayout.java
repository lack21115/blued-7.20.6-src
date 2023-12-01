package com.anythink.expressad.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/widget/AnyThinkRelativeLayout.class */
public class AnyThinkRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8422a;
    private AnimatorSet b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8423c;

    public AnyThinkRelativeLayout(Context context) {
        super(context);
    }

    public AnyThinkRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnyThinkRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.f8422a) {
            this.f8422a = true;
        }
        AnimatorSet animatorSet = this.b;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.b = animatorSet;
    }
}
