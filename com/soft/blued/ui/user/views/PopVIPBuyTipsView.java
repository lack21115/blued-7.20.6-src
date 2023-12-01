package com.soft.blued.ui.user.views;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.log.track.EventTrackVIP;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVIPBuyTipsView.class */
public class PopVIPBuyTipsView {

    /* renamed from: a  reason: collision with root package name */
    public View f20681a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public Context f20682c;
    private MyPopupWindow d;
    private BaseFragment e;
    private int f;

    /* renamed from: com.soft.blued.ui.user.views.PopVIPBuyTipsView$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVIPBuyTipsView$1.class */
    class AnonymousClass1 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.soft.blued.ui.user.views.PopVIPBuyTipsView$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVIPBuyTipsView$2.class */
    class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.soft.blued.ui.user.views.PopVIPBuyTipsView$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVIPBuyTipsView$3.class */
    class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopVIPBuyTipsView f20683a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_BUY_CLICK, this.f20683a.f);
            this.f20683a.a();
        }
    }

    /* renamed from: com.soft.blued.ui.user.views.PopVIPBuyTipsView$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVIPBuyTipsView$4.class */
    class AnonymousClass4 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopVIPBuyTipsView f20684a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            EventTrackVIP.a(VipProtos.Event.VIP_BUY_PAGE_CANCEL_POP_CANCEL_CLICK, this.f20684a.f);
            this.f20684a.a();
            if (this.f20684a.e.getActivity() != null) {
                this.f20684a.e.getActivity().finish();
            }
        }
    }

    /* renamed from: com.soft.blued.ui.user.views.PopVIPBuyTipsView$6  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVIPBuyTipsView$6.class */
    class AnonymousClass6 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/PopVIPBuyTipsView$MyPopupWindow.class */
    class MyPopupWindow extends PopupWindow {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopVIPBuyTipsView f20686a;

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                this.f20686a.a();
            } catch (Exception e) {
                if (this.f20686a.e == null || !this.f20686a.e.isAdded()) {
                    return;
                }
                a();
            }
        }
    }

    private void b() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.f20681a.startAnimation(alphaAnimation);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.f20682c, 2130772113));
    }

    public void a() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.views.PopVIPBuyTipsView.5
            @Override // java.lang.Runnable
            public void run() {
                PopVIPBuyTipsView.this.d.a();
            }
        }, 320L);
        b();
        this.b.setVisibility(8);
    }
}
