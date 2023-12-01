package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/TranslateAlphaAnimator.class */
public class TranslateAlphaAnimator extends PopupAnimator {

    /* renamed from: a  reason: collision with root package name */
    private float f9954a;
    private float b;
    private float e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.animator.TranslateAlphaAnimator$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/TranslateAlphaAnimator$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9955a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            f9955a = iArr;
            try {
                iArr[PopupAnimation.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9955a[PopupAnimation.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9955a[PopupAnimation.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9955a[PopupAnimation.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public TranslateAlphaAnimator(View view, PopupAnimation popupAnimation) {
        super(view, popupAnimation);
    }

    private void d() {
        int i = AnonymousClass1.f9955a[this.d.ordinal()];
        if (i == 1) {
            this.f9941c.setTranslationX(-this.f9941c.getMeasuredWidth());
        } else if (i == 2) {
            this.f9941c.setTranslationY(-this.f9941c.getMeasuredHeight());
        } else if (i == 3) {
            this.f9941c.setTranslationX(this.f9941c.getMeasuredWidth());
        } else if (i != 4) {
        } else {
            this.f9941c.setTranslationY(this.f9941c.getMeasuredHeight());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        this.e = this.f9941c.getTranslationX();
        this.f = this.f9941c.getTranslationY();
        this.f9941c.setAlpha(0.0f);
        d();
        this.f9954a = this.f9941c.getTranslationX();
        this.b = this.f9941c.getTranslationY();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.f9941c.animate().translationX(this.e).translationY(this.f).alpha(1.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        this.f9941c.animate().translationX(this.f9954a).translationY(this.b).alpha(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(XPopup.b()).withLayer().start();
    }
}
