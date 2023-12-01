package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/TranslateAnimator.class */
public class TranslateAnimator extends PopupAnimator {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9956a;
    private float b;
    private float e;
    private int f;
    private int g;
    private float h;
    private float i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.animator.TranslateAnimator$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/TranslateAnimator$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9957a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            f9957a = iArr;
            try {
                iArr[PopupAnimation.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9957a[PopupAnimation.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9957a[PopupAnimation.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9957a[PopupAnimation.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public TranslateAnimator(View view, PopupAnimation popupAnimation) {
        super(view, popupAnimation);
        this.f9956a = false;
    }

    private void d() {
        int i = AnonymousClass1.f9957a[this.d.ordinal()];
        if (i == 1) {
            this.f9941c.setTranslationX(-this.f9941c.getRight());
        } else if (i == 2) {
            this.f9941c.setTranslationY(-this.f9941c.getBottom());
        } else if (i == 3) {
            this.f9941c.setTranslationX(((View) this.f9941c.getParent()).getMeasuredWidth() - this.f9941c.getLeft());
        } else if (i != 4) {
        } else {
            this.f9941c.setTranslationY(((View) this.f9941c.getParent()).getMeasuredHeight() - this.f9941c.getTop());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        if (!this.f9956a) {
            this.h = this.f9941c.getTranslationX();
            this.i = this.f9941c.getTranslationY();
            this.f9956a = true;
        }
        d();
        this.b = this.f9941c.getTranslationX();
        this.e = this.f9941c.getTranslationY();
        this.f = this.f9941c.getMeasuredWidth();
        this.g = this.f9941c.getMeasuredHeight();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.f9941c.animate().translationX(this.h).translationY(this.i).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        int i = AnonymousClass1.f9957a[this.d.ordinal()];
        if (i == 1) {
            this.b -= this.f9941c.getMeasuredWidth() - this.f;
        } else if (i == 2) {
            this.e -= this.f9941c.getMeasuredHeight() - this.g;
        } else if (i == 3) {
            this.b += this.f9941c.getMeasuredWidth() - this.f;
        } else if (i == 4) {
            this.e += this.f9941c.getMeasuredHeight() - this.g;
        }
        this.f9941c.animate().translationX(this.b).translationY(this.e).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }
}
