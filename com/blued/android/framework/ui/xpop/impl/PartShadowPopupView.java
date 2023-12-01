package com.blued.android.framework.ui.xpop.impl;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.OnClickOutsideListener;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.PartShadowContainer;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/impl/PartShadowPopupView.class */
public abstract class PartShadowPopupView extends BasePopupView {
    protected PartShadowContainer a;
    public boolean b;

    /* renamed from: com.blued.android.framework.ui.xpop.impl.PartShadowPopupView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/impl/PartShadowPopupView$1.class */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ PartShadowPopupView a;

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    public void a() {
        if (this.l.a() == null) {
            throw new IllegalArgumentException("atView must not be null for PartShadowPopupView！");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getPopupContentView().getLayoutParams();
        marginLayoutParams.width = getMeasuredWidth();
        int[] iArr = new int[2];
        this.l.a().getLocationOnScreen(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.l.a().getMeasuredWidth(), iArr[1] + this.l.a().getMeasuredHeight());
        if (!this.l.A || getPopupImplView() == null) {
            int i = rect.left + this.l.x;
            int i2 = i;
            if (getPopupImplView().getMeasuredWidth() + i > XPopupUtils.a(getContext())) {
                i2 = i - ((getPopupImplView().getMeasuredWidth() + i) - XPopupUtils.a(getContext()));
            }
            getPopupImplView().setTranslationX(i2);
        } else {
            getPopupImplView().setTranslationX(((rect.left + rect.right) / 2) - (getPopupImplView().getMeasuredWidth() / 2));
        }
        if ((rect.top + (rect.height() / 2) > getMeasuredHeight() / 2 || this.l.s == PopupPosition.Top) && this.l.s != PopupPosition.Bottom) {
            marginLayoutParams.height = rect.top;
            this.b = true;
            View childAt = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.gravity = 80;
            if (getMaxHeight() != 0) {
                layoutParams.height = Math.min(childAt.getMeasuredHeight(), getMaxHeight());
            }
            childAt.setLayoutParams(layoutParams);
        } else {
            marginLayoutParams.height = getMeasuredHeight() - rect.bottom;
            this.b = false;
            marginLayoutParams.topMargin = rect.bottom;
            View childAt2 = ((ViewGroup) getPopupContentView()).getChildAt(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
            layoutParams2.gravity = 48;
            if (getMaxHeight() != 0) {
                layoutParams2.height = Math.min(childAt2.getMeasuredHeight(), getMaxHeight());
            }
            childAt2.setLayoutParams(layoutParams2);
        }
        getPopupContentView().setLayoutParams(marginLayoutParams);
        getPopupImplView().setTranslationY(this.l.y);
        this.a.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.framework.ui.xpop.impl.PartShadowPopupView.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (PartShadowPopupView.this.l.c.booleanValue()) {
                    PartShadowPopupView.this.p();
                    return false;
                }
                return false;
            }
        });
        this.a.setOnClickOutsideListener(new OnClickOutsideListener() { // from class: com.blued.android.framework.ui.xpop.impl.PartShadowPopupView.4
            @Override // com.blued.android.framework.ui.xpop.interfaces.OnClickOutsideListener
            public void a() {
                if (PartShadowPopupView.this.l.c.booleanValue()) {
                    PartShadowPopupView.this.p();
                }
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public PopupAnimator getPopupAnimator() {
        return new TranslateAnimator(getPopupImplView(), this.b ? PopupAnimation.TranslateFromBottom : PopupAnimation.TranslateFromTop);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getPopupLayoutId() {
        return R.layout._xpopup_partshadow_popup_view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() { // from class: com.blued.android.framework.ui.xpop.impl.PartShadowPopupView.2
            @Override // java.lang.Runnable
            public void run() {
                PartShadowPopupView.this.a();
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.l.c.booleanValue()) {
            p();
        }
        if (this.r != null && this.l.D) {
            this.r.a(motionEvent);
        }
        return this.l.D;
    }
}
