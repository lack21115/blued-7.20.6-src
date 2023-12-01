package com.blued.android.framework.ui.xpop.impl;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/impl/FullScreenPopupView.class */
public class FullScreenPopupView extends BasePopupView {
    public ArgbEvaluator a;
    protected View b;
    protected FrameLayout c;
    Paint d;
    Rect e;
    int f;

    public FullScreenPopupView(Context context) {
        super(context);
        this.a = new ArgbEvaluator();
        this.d = new Paint();
        this.f = 0;
        this.c = (FrameLayout) findViewById(R.id.fullPopupContainer);
    }

    protected void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.c, false);
        this.b = inflate;
        this.c.addView(inflate);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.c.getChildCount() == 0) {
            a();
        }
        getPopupContentView().setTranslationX(this.l.x);
        getPopupContentView().setTranslationY(this.l.y);
    }

    public void c(boolean z) {
        if (this.l.t.booleanValue()) {
            ArgbEvaluator argbEvaluator = this.a;
            int i = 0;
            int i2 = z ? 0 : XPopup.a;
            if (z) {
                i = XPopup.a;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(argbEvaluator, Integer.valueOf(i2), Integer.valueOf(i));
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.ui.xpop.impl.FullScreenPopupView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    FullScreenPopupView.this.f = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    FullScreenPopupView.this.postInvalidate();
                }
            });
            ofObject.setDuration(XPopup.b()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.l.t.booleanValue()) {
            this.d.setColor(this.f);
            Rect rect = new Rect(0, 0, getMeasuredWidth(), XPopupUtils.a());
            this.e = rect;
            canvas.drawRect(rect, this.d);
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public PopupAnimator getPopupAnimator() {
        return new TranslateAnimator(getPopupContentView(), PopupAnimation.TranslateFromBottom);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getPopupLayoutId() {
        return R.layout._xpopup_fullscreen_popup_view;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void n() {
        super.n();
        c(true);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void o() {
        super.o();
        c(false);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d = null;
    }
}
