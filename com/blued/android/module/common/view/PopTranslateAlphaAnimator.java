package com.blued.android.module.common.view;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewParent;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PopTranslateAlphaAnimator.class */
public final class PopTranslateAlphaAnimator extends PopupAnimator {
    private float a;
    private float b;
    private int e;
    private int f;
    private float g;
    private float h;
    private boolean i;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PopTranslateAlphaAnimator$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PopupAnimation.values().length];
            iArr[PopupAnimation.TranslateAlphaFromLeft.ordinal()] = 1;
            iArr[PopupAnimation.TranslateAlphaFromTop.ordinal()] = 2;
            iArr[PopupAnimation.TranslateAlphaFromRight.ordinal()] = 3;
            iArr[PopupAnimation.TranslateAlphaFromBottom.ordinal()] = 4;
            a = iArr;
        }
    }

    private final void d() {
        PopupAnimation popupAnimation = this.d;
        int i = popupAnimation == null ? -1 : WhenMappings.a[popupAnimation.ordinal()];
        if (i == 1) {
            this.c.setTranslationX(-this.c.getRight());
        } else if (i == 2) {
            this.c.setTranslationY(-this.c.getBottom());
        } else if (i == 3) {
            View view = this.c;
            ViewParent parent = this.c.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            view.setTranslationX(((View) parent).getMeasuredWidth() - this.c.getLeft());
        } else if (i != 4) {
        } else {
            View view2 = this.c;
            ViewParent parent2 = this.c.getParent();
            if (parent2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            view2.setTranslationY(((View) parent2).getMeasuredHeight() - this.c.getTop());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        if (!this.i) {
            this.g = this.c.getTranslationX();
            this.h = this.c.getTranslationY();
            this.i = true;
        }
        d();
        this.a = this.c.getTranslationX();
        this.b = this.c.getTranslationY();
        this.e = this.c.getMeasuredWidth();
        this.f = this.c.getMeasuredHeight();
        this.c.setAlpha(0.0f);
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.c.animate().alpha(1.0f).translationX(this.g).translationY(this.h).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        PopupAnimation popupAnimation = this.d;
        int i = popupAnimation == null ? -1 : WhenMappings.a[popupAnimation.ordinal()];
        if (i == 1) {
            this.a -= this.c.getMeasuredWidth() - this.e;
        } else if (i == 2) {
            this.b -= this.c.getMeasuredHeight() - this.f;
        } else if (i == 3) {
            this.a += this.c.getMeasuredWidth() - this.e;
        } else if (i == 4) {
            this.b += this.c.getMeasuredHeight() - this.f;
        }
        this.c.animate().alpha(0.0f).translationX(this.a).translationY(this.b).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }
}
