package com.blued.android.framework.ui.xpop.core;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.xpop.animator.PopupAnimator;
import com.blued.android.framework.ui.xpop.animator.TranslateAnimator;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupStatus;
import com.blued.android.framework.ui.xpop.util.KeyboardUtils;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.ui.xpop.widget.SmartDragLayout;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/core/BottomPopupView.class */
public class BottomPopupView extends BasePopupView {

    /* renamed from: a  reason: collision with root package name */
    protected SmartDragLayout f9977a;

    public BottomPopupView(Context context) {
        super(context);
        this.f9977a = (SmartDragLayout) findViewById(R.id.bottomPopupContainer);
    }

    protected void a() {
        this.f9977a.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f9977a, false));
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.f9977a.getChildCount() == 0) {
            a();
        }
        this.f9977a.b(this.l.z.booleanValue());
        this.f9977a.c(this.l.f9988c.booleanValue());
        this.f9977a.d(this.l.e.booleanValue());
        this.f9977a.a(this.l.G);
        getPopupImplView().setTranslationX(this.l.x);
        getPopupImplView().setTranslationY(this.l.y);
        XPopupUtils.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());
        this.f9977a.setOnCloseListener(new SmartDragLayout.OnCloseListener() { // from class: com.blued.android.framework.ui.xpop.core.BottomPopupView.1
            @Override // com.blued.android.framework.ui.xpop.widget.SmartDragLayout.OnCloseListener
            public void a() {
                BottomPopupView.this.v();
                if (BottomPopupView.this.l.p != null) {
                    BottomPopupView.this.l.p.e(BottomPopupView.this);
                }
                BottomPopupView.this.r();
            }

            @Override // com.blued.android.framework.ui.xpop.widget.SmartDragLayout.OnCloseListener
            public void a(int i, float f, boolean z) {
                if (BottomPopupView.this.l.p != null) {
                    BottomPopupView.this.l.p.a(BottomPopupView.this, i, f, z);
                }
            }

            @Override // com.blued.android.framework.ui.xpop.widget.SmartDragLayout.OnCloseListener
            public void b() {
                BottomPopupView.super.i();
            }
        });
        this.f9977a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.ui.xpop.core.BottomPopupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BottomPopupView.this.p();
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getAnimationDuration() {
        if (this.l.z.booleanValue()) {
            return 0;
        }
        return super.getAnimationDuration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return this.l.l == 0 ? XPopupUtils.a(getContext()) : this.l.l;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected PopupAnimator getPopupAnimator() {
        if (this.l.z.booleanValue()) {
            return null;
        }
        return new TranslateAnimator(getPopupContentView(), PopupAnimation.TranslateFromBottom);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected int getPopupLayoutId() {
        return R.layout._xpopup_bottom_popup_view;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    protected View getTargetSizeView() {
        return getPopupImplView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void i() {
        if (this.l.z.booleanValue()) {
            return;
        }
        super.i();
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void n() {
        if (this.l.z.booleanValue()) {
            this.f9977a.a();
        } else {
            super.n();
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void o() {
        if (this.l.z.booleanValue()) {
            this.f9977a.b();
        } else {
            super.o();
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void p() {
        if (this.l == null) {
            return;
        }
        if (!this.l.z.booleanValue()) {
            super.p();
        } else if (this.p == PopupStatus.Dismissing) {
        } else {
            this.p = PopupStatus.Dismissing;
            if (this.l.o.booleanValue()) {
                KeyboardUtils.b(this);
            }
            clearFocus();
            this.f9977a.b();
        }
    }
}
