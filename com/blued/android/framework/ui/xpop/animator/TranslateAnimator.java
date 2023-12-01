package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/TranslateAnimator.class */
public class TranslateAnimator extends PopupAnimator {
    public boolean a;
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
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            a = iArr;
            try {
                iArr[PopupAnimation.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[PopupAnimation.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[PopupAnimation.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[PopupAnimation.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public TranslateAnimator(View view, PopupAnimation popupAnimation) {
        super(view, popupAnimation);
        this.a = false;
    }

    private void d() {
        int i = AnonymousClass1.a[this.d.ordinal()];
        if (i == 1) {
            this.c.setTranslationX(-this.c.getRight());
        } else if (i == 2) {
            this.c.setTranslationY(-this.c.getBottom());
        } else if (i == 3) {
            this.c.setTranslationX(((View) this.c.getParent()).getMeasuredWidth() - this.c.getLeft());
        } else if (i != 4) {
        } else {
            this.c.setTranslationY(((View) this.c.getParent()).getMeasuredHeight() - this.c.getTop());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        if (!this.a) {
            this.h = this.c.getTranslationX();
            this.i = this.c.getTranslationY();
            this.a = true;
        }
        d();
        this.b = this.c.getTranslationX();
        this.e = this.c.getTranslationY();
        this.f = this.c.getMeasuredWidth();
        this.g = this.c.getMeasuredHeight();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.c.animate().translationX(this.h).translationY(this.i).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        int i = AnonymousClass1.a[this.d.ordinal()];
        if (i == 1) {
            this.b -= this.c.getMeasuredWidth() - this.f;
        } else if (i == 2) {
            this.e -= this.c.getMeasuredHeight() - this.g;
        } else if (i == 3) {
            this.b += this.c.getMeasuredWidth() - this.f;
        } else if (i == 4) {
            this.e += this.c.getMeasuredHeight() - this.g;
        }
        this.c.animate().translationX(this.b).translationY(this.e).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }
}
