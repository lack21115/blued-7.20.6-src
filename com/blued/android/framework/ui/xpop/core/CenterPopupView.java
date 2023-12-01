package com.blued.android.framework.ui.xpop.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.ScaleAlphaAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/CenterPopupView.class */
public class CenterPopupView extends BasePopupView {
    protected FrameLayout a;
    protected View b;

    public CenterPopupView(Context context) {
        super(context);
        this.a = (FrameLayout) findViewById(R.id.centerPopupContainer);
    }

    protected void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.a, false);
        this.b = inflate;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 17;
        this.a.addView(this.b, layoutParams);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.a.getChildCount() == 0) {
            a();
        }
        getPopupContentView().setTranslationX(this.l.x);
        getPopupContentView().setTranslationY(this.l.y);
        XPopupUtils.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return this.l.l == 0 ? (int) (XPopupUtils.a(getContext()) * 0.8f) : this.l.l;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected PopupAnimator getPopupAnimator() {
        return new ScaleAlphaAnimator(getPopupContentView(), PopupAnimation.ScaleAlphaFromCenter);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_center_popup_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setTranslationY(0.0f);
    }
}
