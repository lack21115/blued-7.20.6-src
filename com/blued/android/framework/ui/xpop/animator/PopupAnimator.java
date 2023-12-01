package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/PopupAnimator.class */
public abstract class PopupAnimator {
    public View c;
    public PopupAnimation d;

    public PopupAnimator() {
    }

    public PopupAnimator(View view) {
        this(view, null);
    }

    public PopupAnimator(View view, PopupAnimation popupAnimation) {
        this.c = view;
        this.d = popupAnimation;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();
}
