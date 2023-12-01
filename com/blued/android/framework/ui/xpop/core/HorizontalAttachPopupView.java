package com.blued.android.framework.ui.xpop.core;

import android.graphics.Rect;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScrollScaleAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/HorizontalAttachPopupView.class */
public class HorizontalAttachPopupView extends AttachPopupView {
    private boolean z() {
        return (this.e || this.l.s == PopupPosition.Left) && this.l.s != PopupPosition.Right;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        this.a = this.l.y;
        this.b = this.l.x == 0 ? XPopupUtils.a(getContext(), 4.0f) : this.l.x;
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView
    public void d() {
        int i;
        float f;
        float height;
        boolean c = XPopupUtils.c(getContext());
        int measuredWidth = getPopupContentView().getMeasuredWidth();
        int measuredHeight = getPopupContentView().getMeasuredHeight();
        boolean z = true;
        if (this.l.k != null) {
            if (this.l.k.x <= XPopupUtils.a(getContext()) / 2) {
                z = false;
            }
            this.e = z;
            if (c) {
                f = -(this.e ? (XPopupUtils.a(getContext()) - this.l.k.x) + this.b : ((XPopupUtils.a(getContext()) - this.l.k.x) - getPopupContentView().getMeasuredWidth()) - this.b);
            } else {
                f = z() ? (this.l.k.x - measuredWidth) - this.b : this.l.k.x + this.b;
            }
            height = (this.l.k.y - (measuredHeight * 0.5f)) + this.a;
        } else {
            int[] iArr = new int[2];
            this.l.a().getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.l.a().getMeasuredWidth(), iArr[1] + this.l.a().getMeasuredHeight());
            this.e = (rect.left + rect.right) / 2 > XPopupUtils.a(getContext()) / 2;
            if (c) {
                i = -(this.e ? (XPopupUtils.a(getContext()) - rect.left) + this.b : ((XPopupUtils.a(getContext()) - rect.right) - getPopupContentView().getMeasuredWidth()) - this.b);
            } else {
                i = z() ? (rect.left - measuredWidth) - this.b : rect.right + this.b;
            }
            f = i;
            height = rect.top + ((rect.height() - measuredHeight) / 2) + this.a;
        }
        getPopupContentView().setTranslationX(f);
        getPopupContentView().setTranslationY(height);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    protected PopupAnimator getPopupAnimator() {
        ScrollScaleAnimator scrollScaleAnimator = z() ? new ScrollScaleAnimator(getPopupContentView(), PopupAnimation.ScrollAlphaFromRight) : new ScrollScaleAnimator(getPopupContentView(), PopupAnimation.ScrollAlphaFromLeft);
        scrollScaleAnimator.a = true;
        return scrollScaleAnimator;
    }
}
