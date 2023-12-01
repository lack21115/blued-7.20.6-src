package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/ScaleAlphaAnimator.class */
public class ScaleAlphaAnimator extends PopupAnimator {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator$3  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/ScaleAlphaAnimator$3.class */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[PopupAnimation.values().length];
            a = iArr;
            try {
                iArr[PopupAnimation.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[PopupAnimation.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public ScaleAlphaAnimator(View view, PopupAnimation popupAnimation) {
        super(view, popupAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i = AnonymousClass3.a[this.d.ordinal()];
        if (i == 1) {
            this.c.setPivotX(this.c.getMeasuredWidth() / 2);
            this.c.setPivotY(this.c.getMeasuredHeight() / 2);
        } else if (i == 2) {
            this.c.setPivotX(0.0f);
            this.c.setPivotY(0.0f);
        } else if (i == 3) {
            this.c.setPivotX(this.c.getMeasuredWidth());
            this.c.setPivotY(0.0f);
        } else if (i == 4) {
            this.c.setPivotX(0.0f);
            this.c.setPivotY(this.c.getMeasuredHeight());
        } else if (i != 5) {
        } else {
            this.c.setPivotX(this.c.getMeasuredWidth());
            this.c.setPivotY(this.c.getMeasuredHeight());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        this.c.setScaleX(0.0f);
        this.c.setScaleY(0.0f);
        this.c.setAlpha(0.0f);
        this.c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator.1
            @Override // java.lang.Runnable
            public void run() {
                ScaleAlphaAnimator.this.d();
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.c.post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator.2
            @Override // java.lang.Runnable
            public void run() {
                ScaleAlphaAnimator.this.c.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(XPopup.b()).setInterpolator(new OvershootInterpolator(1.0f)).start();
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        this.c.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(XPopup.b()).setInterpolator(new FastOutSlowInInterpolator()).start();
    }
}
