package com.blued.android.framework.ui.xpop.core;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupStatus;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/DrawerPopupView.class */
public abstract class DrawerPopupView extends BasePopupView {
    PopupDrawerLayout a;
    float b;
    Paint c;
    Rect d;
    public ArgbEvaluator e;
    int f;
    int g;

    /* renamed from: com.blued.android.framework.ui.xpop.core.DrawerPopupView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/DrawerPopupView$1.class */
    class AnonymousClass1 implements PopupDrawerLayout.OnCloseListener {
        final /* synthetic */ DrawerPopupView a;

        @Override // com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout.OnCloseListener
        public void a() {
            this.a.v();
            if (this.a.l.p != null) {
                this.a.l.p.e(this.a);
            }
            this.a.r();
        }

        @Override // com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout.OnCloseListener
        public void a(int i, float f, boolean z) {
            this.a.a.g = this.a.l.t.booleanValue();
            if (this.a.l.p != null) {
                this.a.l.p.a(this.a, i, f, z);
            }
            this.a.b = f;
            this.a.postInvalidate();
        }

        @Override // com.blued.android.framework.ui.xpop.widget.PopupDrawerLayout.OnCloseListener
        public void b() {
            DrawerPopupView.super.i();
        }
    }

    /* renamed from: com.blued.android.framework.ui.xpop.core.DrawerPopupView$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/DrawerPopupView$2.class */
    class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ DrawerPopupView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.p();
        }
    }

    public void c(boolean z) {
        if (this.l.t.booleanValue()) {
            ArgbEvaluator argbEvaluator = this.e;
            int i = 0;
            int i2 = z ? 0 : XPopup.a;
            if (z) {
                i = XPopup.a;
            }
            ValueAnimator ofObject = ValueAnimator.ofObject(argbEvaluator, Integer.valueOf(i2), Integer.valueOf(i));
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.framework.ui.xpop.core.DrawerPopupView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DrawerPopupView.this.f = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    DrawerPopupView.this.postInvalidate();
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
            if (this.d == null) {
                this.d = new Rect(0, 0, getMeasuredWidth(), XPopupUtils.a());
            }
            this.c.setColor(((Integer) this.e.evaluate(this.b, Integer.valueOf(this.g), Integer.valueOf(XPopup.a))).intValue());
            canvas.drawRect(this.d, this.c);
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected PopupAnimator getPopupAnimator() {
        return null;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_drawer_popup_view;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected View getTargetSizeView() {
        return getPopupImplView();
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void p() {
        if (this.p == PopupStatus.Dismissing) {
            return;
        }
        this.p = PopupStatus.Dismissing;
        if (this.l.o.booleanValue()) {
            KeyboardUtils.b(this);
        }
        clearFocus();
        c(false);
        this.a.a();
    }
}
