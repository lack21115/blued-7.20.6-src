package com.blued.android.framework.ui.xpop.core;

import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PartShadowContainer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/PositionPopupView.class */
public class PositionPopupView extends BasePopupView {

    /* renamed from: a  reason: collision with root package name */
    PartShadowContainer f9989a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        XPopupUtils.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), new Runnable() { // from class: com.blued.android.framework.ui.xpop.core.PositionPopupView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PositionPopupView.this.l.A) {
                    PositionPopupView.this.f9989a.setTranslationX((!XPopupUtils.c(PositionPopupView.this.getContext()) ? XPopupUtils.a(PositionPopupView.this.getContext()) - PositionPopupView.this.f9989a.getMeasuredWidth() : -(XPopupUtils.a(PositionPopupView.this.getContext()) - PositionPopupView.this.f9989a.getMeasuredWidth())) / 2.0f);
                } else {
                    PositionPopupView.this.f9989a.setTranslationX(PositionPopupView.this.l.x);
                }
                PositionPopupView.this.f9989a.setTranslationY(PositionPopupView.this.l.y);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected PopupAnimator getPopupAnimator() {
        return new ScaleAlphaAnimator(getPopupContentView(), PopupAnimation.ScaleAlphaFromCenter);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_attach_popup_view;
    }
}
