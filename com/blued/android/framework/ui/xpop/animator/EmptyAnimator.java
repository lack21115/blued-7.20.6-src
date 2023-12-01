package com.blued.android.framework.ui.xpop.animator;

import android.view.View;
import com.blued.android.framework.ui.xpop.XPopup;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/animator/EmptyAnimator.class */
public class EmptyAnimator extends PopupAnimator {
    public EmptyAnimator(View view) {
        super(view, null);
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void a() {
        this.f9941c.setAlpha(0.0f);
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void b() {
        this.f9941c.animate().alpha(1.0f).setDuration(XPopup.b()).withLayer().start();
    }

    @Override // com.blued.android.framework.ui.xpop.animator.PopupAnimator
    public void c() {
        this.f9941c.animate().alpha(0.0f).setDuration(XPopup.b()).withLayer().start();
    }
}
