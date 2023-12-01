package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/TranslateAlphaAnimator.class */
public class TranslateAlphaAnimator extends PopupAnimator {
    private float a;
    private float b;
    private float e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.animator.TranslateAlphaAnimator$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/TranslateAlphaAnimator$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            a = iArr;
            try {
                iArr[PopupAnimation.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[PopupAnimation.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public TranslateAlphaAnimator(View view, PopupAnimation popupAnimation) {
        super(view, popupAnimation);
    }

    private void d() {
        int i = AnonymousClass1.a[this.d.ordinal()];
        if (i == 1) {
            this.c.setTranslationX(-this.c.getMeasuredWidth());
        } else if (i == 2) {
            this.c.setTranslationY(-this.c.getMeasuredHeight());
        } else if (i == 3) {
            this.c.setTranslationX(this.c.getMeasuredWidth());
        } else if (i != 4) {
        } else {
            this.c.setTranslationY(this.c.getMeasuredHeight());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        this.e = this.c.getTranslationX();
        this.f = this.c.getTranslationY();
        this.c.setAlpha(0.0f);
        d();
        this.a = this.c.getTranslationX();
        this.b = this.c.getTranslationY();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.c.animate().translationX(this.e).translationY(this.f).alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        this.c.animate().translationX(this.a).translationY(this.b).alpha(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }
}
