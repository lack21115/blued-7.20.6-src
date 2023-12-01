package com.blued.android.module.common.view;

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

    /* renamed from: a  reason: collision with root package name */
    private float f11030a;
    private float b;
    private int e;
    private int f;
    private float g;
    private float h;
    private boolean i;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/PopTranslateAlphaAnimator$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11031a;

        static {
            int[] iArr = new int[PopupAnimation.values().length];
            iArr[PopupAnimation.TranslateAlphaFromLeft.ordinal()] = 1;
            iArr[PopupAnimation.TranslateAlphaFromTop.ordinal()] = 2;
            iArr[PopupAnimation.TranslateAlphaFromRight.ordinal()] = 3;
            iArr[PopupAnimation.TranslateAlphaFromBottom.ordinal()] = 4;
            f11031a = iArr;
        }
    }

    private final void d() {
        PopupAnimation popupAnimation = this.d;
        int i = popupAnimation == null ? -1 : WhenMappings.f11031a[popupAnimation.ordinal()];
        if (i == 1) {
            this.f9941c.setTranslationX(-this.f9941c.getRight());
        } else if (i == 2) {
            this.f9941c.setTranslationY(-this.f9941c.getBottom());
        } else if (i == 3) {
            View view = this.f9941c;
            ViewParent parent = this.f9941c.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            view.setTranslationX(((View) parent).getMeasuredWidth() - this.f9941c.getLeft());
        } else if (i != 4) {
        } else {
            View view2 = this.f9941c;
            ViewParent parent2 = this.f9941c.getParent();
            if (parent2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            view2.setTranslationY(((View) parent2).getMeasuredHeight() - this.f9941c.getTop());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        if (!this.i) {
            this.g = this.f9941c.getTranslationX();
            this.h = this.f9941c.getTranslationY();
            this.i = true;
        }
        d();
        this.f11030a = this.f9941c.getTranslationX();
        this.b = this.f9941c.getTranslationY();
        this.e = this.f9941c.getMeasuredWidth();
        this.f = this.f9941c.getMeasuredHeight();
        this.f9941c.setAlpha(0.0f);
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.f9941c.animate().alpha(1.0f).translationX(this.g).translationY(this.h).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        PopupAnimation popupAnimation = this.d;
        int i = popupAnimation == null ? -1 : WhenMappings.f11031a[popupAnimation.ordinal()];
        if (i == 1) {
            this.f11030a -= this.f9941c.getMeasuredWidth() - this.e;
        } else if (i == 2) {
            this.b -= this.f9941c.getMeasuredHeight() - this.f;
        } else if (i == 3) {
            this.f11030a += this.f9941c.getMeasuredWidth() - this.e;
        } else if (i == 4) {
            this.b += this.f9941c.getMeasuredHeight() - this.f;
        }
        this.f9941c.animate().alpha(0.0f).translationX(this.f11030a).translationY(this.b).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }
}
