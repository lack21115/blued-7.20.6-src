package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveRechargeDlgFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.PayResultEvent;
import com.blued.android.module.live_china.model.ReChargeGift;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.net.HttpURLConnection;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRechargeDlgFragment.class */
public class LiveRechargeDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    private RelativeLayout A;
    private FrameLayout B;
    private FrameLayout C;
    private FrameLayout D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private LinearLayout M;
    private RelativeLayout N;
    private View O;
    private LinearInterpolator P;
    boolean j;
    boolean k;
    boolean l;
    private final String m;
    private boolean n;
    private ReChargeGift o;
    private View p;
    private View q;
    private View r;
    private View s;
    private View t;
    private View u;
    private View v;
    private View w;
    private View x;
    private View y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveRechargeDlgFragment$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRechargeDlgFragment$1.class */
    public class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (LiveRechargeDlgFragment.this.getActivity() == null || LiveRechargeDlgFragment.this.getActivity().isFinishing() || LiveRechargeDlgFragment.this.getDialog() == null || !LiveRechargeDlgFragment.this.getDialog().isShowing() || !LiveRechargeDlgFragment.this.k) {
                return;
            }
            LiveRechargeDlgFragment.this.dismissAllowingStateLoss();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (LiveRechargeDlgFragment.this.getActivity() == null || LiveRechargeDlgFragment.this.getActivity().isFinishing() || LiveRechargeDlgFragment.this.getDialog() == null || !LiveRechargeDlgFragment.this.getDialog().isShowing()) {
                return;
            }
            super.onAnimationEnd(animator);
            LiveRechargeDlgFragment.this.a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$1$XwvTQL_xoZd-FXz3MPjhLFNTelc
                @Override // java.lang.Runnable
                public final void run() {
                    LiveRechargeDlgFragment.AnonymousClass1.this.a();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveRechargeDlgFragment$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRechargeDlgFragment$3.class */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            if (LiveRechargeDlgFragment.this.getActivity() == null || LiveRechargeDlgFragment.this.getActivity().isFinishing() || LiveRechargeDlgFragment.this.getDialog() == null || !LiveRechargeDlgFragment.this.getDialog().isShowing() || !LiveRechargeDlgFragment.this.l) {
                return;
            }
            LiveRechargeDlgFragment.this.dismissAllowingStateLoss();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (LiveRechargeDlgFragment.this.getActivity() == null || LiveRechargeDlgFragment.this.getActivity().isFinishing() || LiveRechargeDlgFragment.this.getDialog() == null || !LiveRechargeDlgFragment.this.getDialog().isShowing()) {
                return;
            }
            super.onAnimationEnd(animator);
            LiveRechargeDlgFragment.this.a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$3$0mwHLyW5D7W-WCBX2NMOI6Dm9sg
                @Override // java.lang.Runnable
                public final void run() {
                    LiveRechargeDlgFragment.AnonymousClass3.this.a();
                }
            }, 3000L);
        }
    }

    public LiveRechargeDlgFragment() {
        this.m = "liveFirstN";
        this.n = false;
        this.j = false;
        this.k = true;
        this.l = true;
    }

    public LiveRechargeDlgFragment(boolean z) {
        this.m = "liveFirstN";
        this.n = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.n = z;
    }

    private Animator A() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(120L);
        View view = this.y;
        view.setPivotX(view.getWidth() / 2);
        View view2 = this.y;
        view2.setPivotY(view2.getHeight() / 2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, "ScaleX", 1.25f, 1.0f);
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(330L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.y, "ScaleY", 1.25f, 1.0f);
        ofFloat3.setInterpolator(this.P);
        ofFloat3.setDuration(330L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setStartDelay(100L);
        return animatorSet;
    }

    private Animator B() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, "Rotation", 0.0f, -9.0f, 0.0f, -9.0f, 0.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(480L);
        ofFloat.setStartDelay(250L);
        return ofFloat;
    }

    private Animator C() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.q, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(120L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, "alpha", 1.0f, 0.0f);
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(390L);
        ofFloat2.setStartDelay(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private void D() {
        this.b.animate().alpha(0.0f).setDuration(200L).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.LiveRechargeDlgFragment.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LiveRechargeDlgFragment.this.getActivity() == null || LiveRechargeDlgFragment.this.getActivity().isFinishing() || LiveRechargeDlgFragment.this.getDialog() == null || !LiveRechargeDlgFragment.this.getDialog().isShowing()) {
                    return;
                }
                super.onAnimationEnd(animator);
                if (LiveRechargeDlgFragment.this.j) {
                    LiveRechargeDlgFragment.super.dismissAllowingStateLoss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void J() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(F()).with(a(this.B, 210)).with(a(this.C, 140)).with(a(this.D, 70)).with(G());
        animatorSet.addListener(new AnonymousClass3());
        animatorSet.start();
    }

    private Animator F() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.r, "alpha", 1.0f, 0.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(450L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.LiveRechargeDlgFragment.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LiveRechargeDlgFragment.this.getActivity() == null || LiveRechargeDlgFragment.this.getActivity().isFinishing() || LiveRechargeDlgFragment.this.getDialog() == null || !LiveRechargeDlgFragment.this.getDialog().isShowing()) {
                    return;
                }
                super.onAnimationEnd(animator);
                LiveRechargeDlgFragment.this.r.setVisibility(8);
            }
        });
        return ofFloat;
    }

    private Animator G() {
        View view = (View) this.O.getParent();
        int height = (view.getHeight() - this.O.getHeight()) / 2;
        this.O.setTranslationY(view.getHeight() - height);
        this.O.setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O, "TranslationY", view.getHeight() - height, 0.0f);
        ofFloat.setInterpolator(new OvershootInterpolator(1.5f));
        ofFloat.setDuration(350L);
        ofFloat.setStartDelay(300L);
        return ofFloat;
    }

    private void H() {
        ReChargeGift reChargeGift = this.o;
        if (reChargeGift == null || reChargeGift.pay_list == null || this.o.pay_list.size() < 1) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_POP_EXCHANGE_CLICK, LiveRoomManager.a().g(), LiveRoomManager.a().e(), Boolean.valueOf(this.n));
        PayOption._pay_list _pay_listVar = this.o.pay_list.get(0);
        if (_pay_listVar == null) {
            return;
        }
        this.k = false;
        LiveRoomInfo.a().a((Context) getActivity(), _pay_listVar, "liveFirstN");
    }

    private void I() {
        int a = DensityUtils.a(getActivity());
        int childCount = this.A.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                View view = (View) this.O.getParent();
                this.O.setAlpha(0.0f);
                view.setVisibility(0);
                view.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$W82CR0sk6sWe27Ums2T-lQP8kuI
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveRechargeDlgFragment.this.J();
                    }
                });
                return;
            }
            int[] iArr = new int[2];
            View childAt = this.A.getChildAt(0);
            childAt.getLocationOnScreen(iArr);
            this.A.removeView(childAt);
            this.N.addView(childAt);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = iArr[0];
            layoutParams.topMargin = iArr[1] - a;
            childAt.setLayoutParams(layoutParams);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(p()).with(q()).with(r()).before(s()).before(t()).before(u());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(v()).with(w()).with(x()).before(y()).before(z()).before(A()).after(animatorSet);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(B()).before(C()).after(animatorSet2);
        animatorSet3.addListener(new AnonymousClass1());
        animatorSet3.start();
    }

    private Animator a(View view, int i) {
        int[] iArr = new int[2];
        this.z.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        int i2 = iArr[0];
        int width = this.z.getWidth();
        int i3 = iArr[1];
        int height = this.z.getHeight();
        int i4 = iArr2[0];
        int width2 = view.getWidth() / 2;
        int i5 = iArr2[1];
        int height2 = view.getHeight() / 2;
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationX", 0.0f, (i2 + width) - (i4 + width2));
        ofFloat.setInterpolator(new DecelerateInterpolator(0.5f - (i / 500)));
        int i6 = i / 2;
        ofFloat.setDuration(i6 + 650);
        long j = i6;
        ofFloat.setStartDelay(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "TranslationY", 0.0f, (i3 + height) - (i5 + height2));
        ofFloat2.setInterpolator(new AnticipateInterpolator((i / 300) + 1.0f));
        ofFloat2.setDuration(i6 + 700);
        ofFloat.setStartDelay(j);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view.findViewById(R.id.view_background), "alpha", 1.0f, 0.0f);
        ofFloat3.setInterpolator(this.P);
        long j2 = i6 + 200;
        ofFloat3.setDuration(j2);
        ofFloat3.setStartDelay(i6 + 100);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view.findViewById(R.id.tv_gift_name), "alpha", 1.0f, 0.0f);
        ofFloat4.setInterpolator(this.P);
        ofFloat4.setDuration(i6 + 250);
        ofFloat4.setStartDelay(i6 + 150);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "ScaleX", 1.0f, 0.0f);
        ofFloat5.setInterpolator(this.P);
        ofFloat5.setDuration(j2);
        long j3 = i6 + HttpURLConnection.HTTP_BAD_REQUEST;
        ofFloat5.setStartDelay(j3);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, "ScaleY", 1.0f, 0.0f);
        ofFloat6.setInterpolator(this.P);
        ofFloat6.setDuration(j2);
        ofFloat6.setStartDelay(j3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayResultEvent payResultEvent) {
        if (payResultEvent == null || !payResultEvent.flag || payResultEvent.from == null || !payResultEvent.from.equals("liveFirstN")) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_POP_EXCHANGE_SUCCESS, LiveRoomManager.a().g(), LiveRoomManager.a().e(), Boolean.valueOf(this.n));
        I();
        LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_RECHARGE_GIFT_BAG.getValue()));
        LiveRoomManager.a().p().rechargeGiftBagIconShowType = 0;
        LiveEventBusUtil.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        n();
    }

    private void l() {
        this.p = this.b.findViewById(R.id.view_shade);
        this.q = this.b.findViewById(R.id.iv_close);
        this.r = this.b.findViewById(R.id.fl_content);
        this.s = this.b.findViewById(R.id.fl_bag);
        this.t = this.b.findViewById(R.id.view_tongue);
        this.u = this.b.findViewById(R.id.view_title);
        this.v = this.b.findViewById(R.id.view_title_left);
        this.w = this.b.findViewById(R.id.view_title_right);
        this.A = (RelativeLayout) this.b.findViewById(R.id.view_gift_bar);
        this.B = (FrameLayout) this.b.findViewById(R.id.view_card_root_1);
        this.C = (FrameLayout) this.b.findViewById(R.id.view_card_root_2);
        this.D = (FrameLayout) this.b.findViewById(R.id.view_card_root_3);
        this.x = this.b.findViewById(R.id.view_recharge_bar);
        this.K = (TextView) this.b.findViewById(R.id.tv_recharge_bean);
        this.L = (TextView) this.b.findViewById(R.id.btn_recharge);
        this.M = (LinearLayout) this.b.findViewById(R.id.ll_rule_root);
        this.y = this.b.findViewById(R.id.view_hand);
        this.z = this.b.findViewById(R.id.view_gift_bag);
        this.E = (ImageView) this.B.findViewById(R.id.iv_gift);
        this.H = (TextView) this.B.findViewById(R.id.tv_gift_name);
        this.F = (ImageView) this.C.findViewById(R.id.iv_gift);
        this.I = (TextView) this.C.findViewById(R.id.tv_gift_name);
        this.G = (ImageView) this.D.findViewById(R.id.iv_gift);
        this.J = (TextView) this.D.findViewById(R.id.tv_gift_name);
        this.N = (RelativeLayout) this.b.findViewById(R.id.rl_gift_anim_root);
        this.O = this.b.findViewById(R.id.rl_recharge_succeed_root);
    }

    private void m() {
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$21ucqjoBmuJX33WfdkhhUSKb9S0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRechargeDlgFragment.this.e(view);
            }
        });
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$DgL16we2nYzggbeJ74qC9rVUevk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRechargeDlgFragment.this.d(view);
            }
        });
        this.b.findViewById(R.id.tv_roger).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$lsdQhIpXEtKz-PSrp1pkuX8q528
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRechargeDlgFragment.this.c(view);
            }
        });
        this.b.findViewById(R.id.iv_recharge_succeed_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$Ay_bGUXaEHykgsL-9Xyohkljn_8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRechargeDlgFragment.this.b(view);
            }
        });
        this.L.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$Hm0vO1k_s8clfDOaFYDJdWKc4ck
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRechargeDlgFragment.this.a(view);
            }
        });
    }

    private void n() {
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_POP_CLOSE_CLICK, LiveRoomManager.a().g(), LiveRoomManager.a().e(), Boolean.valueOf(this.n));
        dismissAllowingStateLoss();
    }

    private void o() {
        this.P = new LinearInterpolator();
        this.b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$qbdCHgOip3SrW4f8jQu4NiRRvlo
            @Override // java.lang.Runnable
            public final void run() {
                LiveRechargeDlgFragment.this.K();
            }
        });
    }

    private AnimatorSet p() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.p, "alpha", 0.0f, 0.6f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(360L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(60L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.s, "TranslationY", this.s.getTranslationY() + (this.s.getHeight() * 0.1f), this.s.getTranslationY() - (this.s.getHeight() * 0.1f), this.s.getTranslationY());
        ofFloat3.setInterpolator(this.P);
        ofFloat3.setDuration(360L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        return animatorSet;
    }

    private AnimatorSet q() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.t, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(60L);
        float translationY = this.t.getTranslationY();
        float height = this.t.getHeight();
        float translationY2 = this.t.getTranslationY() - (this.t.getHeight() * 0.087f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.t, "TranslationY", translationY + (height * 0.073f), translationY2);
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(270L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.t, "TranslationY", translationY2, this.t.getTranslationY());
        ofFloat3.setInterpolator(this.P);
        ofFloat3.setDuration(120L);
        ofFloat3.setStartDelay(270L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        return animatorSet;
    }

    private AnimatorSet r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.A, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(180L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.A, "TranslationY", this.A.getTranslationY() + (this.A.getHeight() * 0.3f), this.A.getTranslationY() - (this.A.getHeight() * 0.2f));
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(270L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.A, "TranslationY", this.A.getTranslationY() - (this.A.getHeight() * 0.2f), this.A.getTranslationY());
        ofFloat3.setInterpolator(this.P);
        ofFloat3.setDuration(180L);
        ofFloat3.setStartDelay(270L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        return animatorSet;
    }

    private AnimatorSet s() {
        View view;
        View view2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.u, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(90L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.u, "TranslationY", this.u.getTranslationY() + (this.u.getHeight() * 0.924f), this.u.getTranslationY());
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(210L);
        this.u.setPivotX(view.getWidth() / 2);
        this.u.setPivotY(view2.getHeight() / 2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.u, "ScaleX", 1.0f, 1.25f);
        ofFloat3.setInterpolator(this.P);
        ofFloat3.setDuration(210L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.u, "ScaleY", 1.0f, 1.25f);
        ofFloat4.setInterpolator(this.P);
        ofFloat4.setDuration(210L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.u, "ScaleX", 1.25f, 1.0f);
        ofFloat5.setInterpolator(this.P);
        ofFloat5.setDuration(210L);
        ofFloat5.setStartDelay(210L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.u, "ScaleY", 1.25f, 1.0f);
        ofFloat6.setInterpolator(this.P);
        ofFloat6.setDuration(210L);
        ofFloat6.setStartDelay(210L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
        return animatorSet;
    }

    private AnimatorSet t() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(330L);
        ofFloat.setStartDelay(210L);
        float translationX = this.v.getTranslationX() - (this.v.getWidth() * 0.633f);
        float translationX2 = this.v.getTranslationX();
        this.v.setTranslationX(translationX);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.v, "TranslationX", translationX, translationX2);
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(210L);
        ofFloat2.setStartDelay(210L);
        float translationY = this.v.getTranslationY() - (this.v.getHeight() * 0.043f);
        float translationY2 = this.v.getTranslationY();
        this.v.setTranslationY(translationY);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.v, "TranslationY", translationY, translationY2);
        ofFloat3.setInterpolator(this.P);
        ofFloat3.setDuration(210L);
        ofFloat3.setStartDelay(320L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        return animatorSet;
    }

    private AnimatorSet u() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.w, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(330L);
        ofFloat.setStartDelay(210L);
        float translationX = this.w.getTranslationX() + (this.w.getWidth() * 0.417f);
        float translationX2 = this.w.getTranslationX();
        this.w.setTranslationX(translationX);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, "TranslationX", translationX, translationX2);
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(210L);
        ofFloat2.setStartDelay(210L);
        float translationY = this.w.getTranslationY() - (this.w.getHeight() * 0.29f);
        float translationY2 = this.w.getTranslationY();
        this.w.setTranslationY(translationY);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w, "TranslationY", translationY, translationY2);
        ofFloat3.setInterpolator(this.P);
        ofFloat3.setDuration(210L);
        ofFloat3.setStartDelay(320L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        return animatorSet;
    }

    private AnimatorSet v() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.B, "TranslationX", this.B.getTranslationX(), this.B.getTranslationX() - (this.B.getWidth() * 0.049f), this.B.getTranslationX());
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(420L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.B, "TranslationY", this.B.getTranslationY(), this.B.getTranslationY() - (this.B.getHeight() * 0.017f), this.B.getTranslationY());
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(420L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setStartDelay(100L);
        return animatorSet;
    }

    private Animator w() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.C, "TranslationY", this.C.getTranslationY(), this.C.getTranslationY() - (this.C.getHeight() * 0.017f), this.C.getTranslationY());
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(420L);
        ofFloat.setStartDelay(160L);
        return ofFloat;
    }

    private AnimatorSet x() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D, "TranslationX", this.D.getTranslationX(), this.D.getTranslationX() + (this.D.getWidth() * 0.049f), this.D.getTranslationX());
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(420L);
        ofFloat.setStartDelay(220L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "TranslationY", this.D.getTranslationY(), this.D.getTranslationY() - (this.D.getHeight() * 0.017f), this.D.getTranslationY());
        ofFloat2.setInterpolator(this.P);
        ofFloat2.setDuration(420L);
        ofFloat2.setStartDelay(220L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private Animator y() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.x, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(240L);
        ofFloat.setStartDelay(50L);
        return ofFloat;
    }

    private Animator z() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.M, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(this.P);
        ofFloat.setDuration(240L);
        ofFloat.setStartDelay(50L);
        return ofFloat;
    }

    public void a(FragmentManager fragmentManager) {
        show(fragmentManager, b());
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_recharge;
    }

    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    public void dismissAllowingStateLoss() {
        if (this.j) {
            return;
        }
        this.j = true;
        D();
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        l();
        m();
        k();
        o();
        LiveEventBus.get(LiveEventBusUtil.d, PayResultEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRechargeDlgFragment$cS2_bDhJfbD6IZ-TaQBy0eXHnnI
            public final void onChanged(Object obj) {
                LiveRechargeDlgFragment.this.a((PayResultEvent) obj);
            }
        });
        EventTrackLive.a(LiveProtos.Event.LIVE_EXCHANGE_POP_SHOW, LiveRoomManager.a().g(), LiveRoomManager.a().e(), Boolean.valueOf(this.n));
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
    }

    public void k() {
        ReChargeGift E = LiveRoomManager.a().E();
        this.o = E;
        if (E == null) {
            return;
        }
        int i = 0;
        if (E.gifts != null) {
            if (this.o.gifts.size() > 0 && this.o.gifts.get(0) != null) {
                ImageLoader.a((IRequestHost) null, this.o.gifts.get(0).image).a(this.E);
                this.H.setText(this.o.gifts.get(0).title);
            }
            if (this.o.gifts.size() > 1 && this.o.gifts.get(1) != null) {
                ImageLoader.a((IRequestHost) null, this.o.gifts.get(1).image).a(this.F);
                this.I.setText(this.o.gifts.get(1).title);
            }
            if (this.o.gifts.size() > 2 && this.o.gifts.get(2) != null) {
                ImageLoader.a((IRequestHost) null, this.o.gifts.get(2).image).a(this.G);
                this.J.setText(this.o.gifts.get(2).title);
            }
        }
        if (this.o.pay_list == null || this.o.pay_list.get(0) == null) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.y.setVisibility(8);
        } else {
            this.K.setText(CommonStringUtils.a(this.o.pay_list.get(0).money * this.o.pay_list.get(0).ratio));
            this.L.setText(CommonStringUtils.a(this.o.pay_list.get(0).money) + getString(R.string.Live_SendPresent_RMB));
        }
        if (this.o.statements != null) {
            while (i < this.o.statements.size()) {
                View inflate = this.d.inflate(R.layout.item_live_recharge_dialog_rule, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_number);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_content);
                StringBuilder sb = new StringBuilder();
                int i2 = i + 1;
                sb.append(i2);
                sb.append(".");
                textView.setText(sb.toString());
                textView2.setText(this.o.statements.get(i));
                this.M.addView(inflate);
                i = i2;
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        n();
        return true;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.h = 0;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
