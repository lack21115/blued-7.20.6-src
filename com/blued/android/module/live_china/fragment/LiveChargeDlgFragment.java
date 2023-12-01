package com.blued.android.module.live_china.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveChargeDlgFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveGiftManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.FirstChargeGift;
import com.blued.android.module.live_china.model.LiveGuideType;
import com.blued.android.module.live_china.model.PayResultEvent;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveChargeDlgFragment.class */
public class LiveChargeDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    private View A;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private ImageView y;
    private ImageView z;
    private final String j = "liveScreen";
    private final String k = "LiveFirstCharge";
    private List<ImageView> t = new ArrayList();
    private List<View> u = new ArrayList();
    private List<View> B = new ArrayList();
    private int K = 0;
    private boolean L = false;
    private int[] M = new int[2];
    private int[] N = new int[2];
    private int[] O = new int[2];
    private int[] P = new int[2];
    private int[] Q = new int[2];
    private final List<FirstChargeGift.FirstChargeGiftItem> R = new ArrayList();
    private AtomicBoolean S = new AtomicBoolean(false);
    private ViewTreeObserver.OnGlobalLayoutListener T = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (LiveChargeDlgFragment.this.J.getLineCount() > 0) {
                LiveChargeDlgFragment.this.J.getViewTreeObserver().removeOnGlobalLayoutListener(LiveChargeDlgFragment.this.T);
                if (LiveChargeDlgFragment.this.J.getLineCount() > 2) {
                    float textSize = LiveChargeDlgFragment.this.J.getTextSize() - 4.0f;
                    LiveChargeDlgFragment.this.J.setTextSize(0, textSize);
                    LiveChargeDlgFragment.this.I.setTextSize(0, textSize);
                    LiveChargeDlgFragment.this.H.setTextSize(0, textSize);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveChargeDlgFragment$2.class */
    public class AnonymousClass2 implements Animation.AnimationListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            LiveChargeDlgFragment.this.n();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LiveChargeDlgFragment.this.a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$2$odf5YXbfWt2ODp2Xj9MWz1PfRCk
                @Override // java.lang.Runnable
                public final void run() {
                    LiveChargeDlgFragment.AnonymousClass2.this.a();
                }
            }, 90L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveChargeDlgFragment$3.class */
    public class AnonymousClass3 implements Animation.AnimationListener {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            LiveChargeDlgFragment.this.t();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LiveChargeDlgFragment.this.x.setVisibility(0);
            LiveChargeDlgFragment.this.y.setVisibility(0);
            LiveChargeDlgFragment.this.z.setVisibility(0);
            LiveChargeDlgFragment.this.o();
            LiveChargeDlgFragment.this.p();
            LiveChargeDlgFragment.this.q();
            LiveChargeDlgFragment.this.s();
            LiveChargeDlgFragment.this.a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$3$sqmVO1em4rBEVFRSB0JjaPElXyE
                @Override // java.lang.Runnable
                public final void run() {
                    LiveChargeDlgFragment.AnonymousClass3.this.a();
                }
            }, 1300L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LiveChargeDlgFragment.this.n.setVisibility(0);
            LiveChargeDlgFragment.this.x.setVisibility(4);
            LiveChargeDlgFragment.this.y.setVisibility(4);
            LiveChargeDlgFragment.this.z.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment$9  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveChargeDlgFragment$9.class */
    public class AnonymousClass9 implements Animation.AnimationListener {
        AnonymousClass9() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            LiveEventBusUtil.a(false);
            LiveChargeDlgFragment.this.dismissAllowingStateLoss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LiveChargeDlgFragment.this.a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$9$MGSkZmH-TUCk7xKDLdMSNA2vQhw
                @Override // java.lang.Runnable
                public final void run() {
                    LiveChargeDlgFragment.AnonymousClass9.this.a();
                }
            }, 200L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private void A() {
        if (LiveDataManager.a().f()) {
            LiveRoomInfo.a().a(getContext(), 8);
        } else {
            LiveRoomInfo.a().a(getContext(), getFragmentManager(), 8);
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_MORE_CLICK, this.K);
        EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_MORE_CHARGE_SHOW, this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        if (this.K == 1) {
            x();
            return;
        }
        this.m.setVisibility(8);
        this.C.setVisibility(8);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.A.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        y();
        LiveEventBusUtil.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (this.S.get()) {
            dismissAllowingStateLoss();
        }
    }

    private void a(int i, int i2, float f, float f2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, f * (-1.0f), 1, 0.0f, 1, f2 * (-1.0f));
        translateAnimation.setDuration(420L);
        translateAnimation.setRepeatMode(2);
        translateAnimation.setStartOffset(i2 + 340);
        this.u.get(i).startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.K == 1) {
            j();
        }
    }

    private void a(final View view, int[] iArr) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (AppInfo.l - DisplayUtil.a(getContext(), 53.0f)) - iArr[0], 0.0f, (AppInfo.m - DisplayUtil.a(getContext(), 50.0f)) - iArr[1]);
        translateAnimation.setDuration(880L);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setInterpolator(new CubicInterpolator(0.66f, 0.01f, 0.75f, 0.99f));
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        alphaAnimation.setDuration(880L);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    private void a(PayOption._pay_list _pay_listVar) {
        if (_pay_listVar == null) {
            return;
        }
        this.S.set(false);
        LiveRoomInfo.a().a(getActivity(), _pay_listVar, this.L ? "liveScreen" : "LiveFirstCharge");
        EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_SKU_CLICK, this.K, (int) _pay_listVar.money);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(PayOption._pay_list _pay_listVar, View view) {
        a(_pay_listVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FirstChargeGift firstChargeGift) {
        if (firstChargeGift == null) {
            return;
        }
        if (!TypeUtils.a((List<?>) firstChargeGift.gifts)) {
            this.R.addAll(firstChargeGift.gifts);
            z();
        }
        if (!TypeUtils.a((List<?>) firstChargeGift.pay_list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Math.min(firstChargeGift.pay_list.size(), this.B.size())) {
                    break;
                }
                final PayOption._pay_list _pay_listVar = firstChargeGift.pay_list.get(i2);
                TextView textView = (TextView) this.B.get(i2).findViewById(R.id.item_live_charge_pay_bean_num);
                textView.setText(CommonStringUtils.a(_pay_listVar.money * _pay_listVar.ratio) + getString(R.string.Live_SendPresent_wandou));
                TextView textView2 = (TextView) this.B.get(i2).findViewById(R.id.item_live_charge_pay_bean_money);
                textView2.setText(CommonStringUtils.a(_pay_listVar.money) + getString(R.string.Live_SendPresent_RMB));
                this.B.get(i2).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$kpl_tUO0_2IlbumfMA7tYbJvDlk
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveChargeDlgFragment.this.a(_pay_listVar, view);
                    }
                });
                i = i2 + 1;
            }
        }
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$alb1_7vu1nEfS4lV12KySBzwAxQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveChargeDlgFragment.this.C();
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayResultEvent payResultEvent) {
        if (payResultEvent == null) {
            return;
        }
        LogUtils.c(payResultEvent.flag + ", from:" + this.K + ", " + payResultEvent.from + ", money: " + payResultEvent.money);
        if (payResultEvent.flag) {
            LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue()));
            LiveEventBusUtil.a(0);
            LiveDataManager.a().a("live_gift");
            LiveGiftManager.a().a(false);
            a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$q20WSCCrJRmdfgacQj_vm33-h4I
                @Override // java.lang.Runnable
                public final void run() {
                    LiveChargeDlgFragment.this.B();
                }
            }, 300L);
            if ("LiveFirstCharge".equals(payResultEvent.from)) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_SKU_SUCCESS_SHOW, this.K, payResultEvent.money);
            } else if ("live_first_charge".equals(payResultEvent.from)) {
                EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_MORE_CHARGE_SUCCESS_SHOW, this.K, payResultEvent.money);
                LiveRefreshUIObserver.a().c(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveChargeDlgFragment.this.c(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.t.get(i).startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final int i) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment.6
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveChargeDlgFragment.this.b(i);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.t.get(i).startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        j();
    }

    private void k() {
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$wEGjEsvTcSsjS42pJ6sn86em2ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveChargeDlgFragment.this.e(view);
            }
        });
        this.b.findViewById(R.id.live_charge_success_close).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$dZM0PbkIe0YltxfwdHqXPJC_Vng
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveChargeDlgFragment.this.d(view);
            }
        });
        this.b.findViewById(R.id.live_charge_success_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$LvHTuW8nU9Y_cFSb5z1bdHckXC8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveChargeDlgFragment.this.c(view);
            }
        });
        this.b.findViewById(R.id.live_charge_more_layout).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$cUf7tDGhES5yKgkyxXbAL6BIu3A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveChargeDlgFragment.this.b(view);
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$djMwenpmLOVWLHsW3lgJinL3IT4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveChargeDlgFragment.this.a(view);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.d, PayResultEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$pzijwh_NWy9ZRA-bGa-ozQQLLOk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveChargeDlgFragment.this.a((PayResultEvent) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void C() {
        this.n.setVisibility(4);
        this.p.setVisibility(4);
        this.m.setVisibility(0);
        this.v.setVisibility(8);
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(60L);
        animationSet.addAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, -0.05f);
        translateAnimation.setDuration(240L);
        animationSet.addAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.05f, 1, 0.0f);
        translateAnimation2.setDuration(120L);
        translateAnimation2.setStartOffset(240L);
        animationSet.addAnimation(translateAnimation2);
        this.m.startAnimation(animationSet);
        m();
    }

    private void m() {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.04f);
        translateAnimation.setDuration(120L);
        animationSet.addAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.04f, 1, 0.0f);
        translateAnimation2.setDuration(90L);
        translateAnimation2.setStartOffset(120L);
        animationSet.addAnimation(translateAnimation2);
        animationSet.setAnimationListener(new AnonymousClass2());
        animationSet.setStartOffset(240L);
        this.o.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(90L);
        animationSet.addAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(210L);
        animationSet.addAnimation(translateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.1f, 0.8f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(210L);
        scaleAnimation.setAnimationListener(new AnonymousClass3());
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(210L);
        scaleAnimation2.setStartOffset(210L);
        animationSet.addAnimation(scaleAnimation2);
        this.n.startAnimation(animationSet);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(210L);
        animationSet.addAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.61f, 1, 0.0f, 1, 1.68f, 1, 0.0f);
        translateAnimation.setDuration(210L);
        animationSet.addAnimation(translateAnimation);
        this.x.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(330L);
        animationSet.addAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -0.5f, 1, 0.1f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(210L);
        animationSet.addAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.1f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation2.setDuration(120L);
        translateAnimation2.setStartOffset(210L);
        animationSet.addAnimation(translateAnimation2);
        this.y.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(330L);
        animationSet.addAnimation(alphaAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.5f, 1, -0.11f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(210L);
        animationSet.addAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, -0.11f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation2.setDuration(120L);
        translateAnimation2.setStartOffset(210L);
        animationSet.addAnimation(translateAnimation2);
        this.z.startAnimation(animationSet);
    }

    private void r() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(90L);
        animationSet.addAnimation(alphaAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 15.0f, 1, 1.0f, 1, 1.0f);
        rotateAnimation.setDuration(90L);
        rotateAnimation.setStartOffset(90L);
        rotateAnimation.setFillAfter(true);
        animationSet.addAnimation(rotateAnimation);
        RotateAnimation rotateAnimation2 = new RotateAnimation(15.0f, 0.0f, 1, 1.0f, 1, 1.0f);
        rotateAnimation2.setDuration(210L);
        rotateAnimation.setStartOffset(210L);
        animationSet.addAnimation(rotateAnimation2);
        this.w.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        a(0, 0, 0.06f, 0.1f);
        a(1, 60, 0.02f, 0.1f);
        a(2, 120, -0.02f, 0.1f);
        a(3, 180, -0.06f, 0.1f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(240L);
        alphaAnimation.setStartOffset(30L);
        this.p.startAnimation(alphaAnimation);
        this.p.setVisibility(0);
        u();
    }

    private void u() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(120L);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.7f, 1.0f, 1.7f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(330L);
        animationSet.addAnimation(scaleAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -9.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(120L);
        rotateAnimation.setStartOffset(450L);
        animationSet.addAnimation(rotateAnimation);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-9.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation2.setDuration(120L);
        rotateAnimation2.setStartOffset(570L);
        animationSet.addAnimation(rotateAnimation2);
        RotateAnimation rotateAnimation3 = new RotateAnimation(0.0f, -9.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation3.setDuration(120L);
        rotateAnimation3.setStartOffset(690L);
        animationSet.addAnimation(rotateAnimation3);
        RotateAnimation rotateAnimation4 = new RotateAnimation(-9.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation4.setDuration(120L);
        rotateAnimation4.setStartOffset(810L);
        animationSet.addAnimation(rotateAnimation4);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(390L);
        alphaAnimation2.setStartOffset(1420L);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveChargeDlgFragment.this.v.setVisibility(8);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= LiveChargeDlgFragment.this.t.size()) {
                        return;
                    }
                    LiveChargeDlgFragment.this.b(i2);
                    i = i2 + 1;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LiveChargeDlgFragment.this.v.setVisibility(0);
            }
        });
        animationSet.addAnimation(alphaAnimation2);
        this.v.startAnimation(animationSet);
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$zF1Am45BOsxTi6Moy_JFEHV97Yc
            @Override // java.lang.Runnable
            public final void run() {
                LiveChargeDlgFragment.this.F();
            }
        }, 450L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void F() {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(120L);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setFillAfter(false);
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(120L);
        scaleAnimation2.setStartOffset(120L);
        animationSet.addAnimation(scaleAnimation2);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setDuration(120L);
        scaleAnimation3.setStartOffset(240L);
        animationSet.addAnimation(scaleAnimation3);
        ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.9f, 1.0f, 0.9f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation4.setDuration(120L);
        scaleAnimation4.setStartOffset(360L);
        scaleAnimation4.setFillEnabled(true);
        scaleAnimation4.setFillBefore(false);
        scaleAnimation4.setFillAfter(true);
        animationSet.addAnimation(scaleAnimation4);
        this.B.get(2).startAnimation(animationSet);
    }

    private void w() {
        if (this.K == 1) {
            this.S.set(true);
            a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$X2LXmKei-ocXAiO9P0z7-1sjYtU
                @Override // java.lang.Runnable
                public final void run() {
                    LiveChargeDlgFragment.this.E();
                }
            }, 8000L);
        }
    }

    private void x() {
        this.u.get(0).getLocationInWindow(this.M);
        this.u.get(1).getLocationInWindow(this.N);
        this.u.get(2).getLocationInWindow(this.O);
        this.u.get(3).getLocationInWindow(this.P);
        this.G.getLocationInWindow(this.Q);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.leftMargin = this.M[0];
        layoutParams.topMargin = this.M[1];
        this.C.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.D.getLayoutParams();
        layoutParams2.leftMargin = this.N[0];
        layoutParams2.topMargin = this.N[1];
        this.D.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams3.leftMargin = this.O[0];
        layoutParams3.topMargin = this.O[1];
        this.E.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.F.getLayoutParams();
        layoutParams4.leftMargin = this.P[0];
        layoutParams4.topMargin = this.P[1];
        this.F.setLayoutParams(layoutParams4);
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(120L);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(120L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveChargeDlgFragment.this.m.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        animationSet.addAnimation(scaleAnimation);
        this.m.startAnimation(animationSet);
        a(this.C, this.M);
        a(this.D, this.N);
        a(this.E, this.O);
        a(this.F, this.P);
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveChargeDlgFragment$bRY-BRGAPL3Kfv1r75yAF60QfcI
            @Override // java.lang.Runnable
            public final void run() {
                LiveChargeDlgFragment.this.D();
            }
        }, 800L);
    }

    private void y() {
        this.G.setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.85f, 1, 0.0f, 1, 1.0f);
        scaleAnimation.setFillEnabled(true);
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setFillAfter(false);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setStartOffset(200L);
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.0f, 0.85f, 1.0f, 1, 0.0f, 1, 1.0f);
        scaleAnimation2.setDuration(180L);
        scaleAnimation2.setStartOffset(400L);
        animationSet.addAnimation(scaleAnimation2);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.95f, 1, 0.0f, 1, 1.0f);
        scaleAnimation3.setDuration(160L);
        scaleAnimation3.setStartOffset(580L);
        animationSet.addAnimation(scaleAnimation3);
        ScaleAnimation scaleAnimation4 = new ScaleAnimation(1.0f, 1.0f, 0.95f, 1.0f, 1, 0.0f, 1, 1.0f);
        scaleAnimation4.setDuration(120L);
        scaleAnimation4.setStartOffset(740L);
        scaleAnimation4.setFillEnabled(true);
        scaleAnimation4.setFillBefore(false);
        scaleAnimation4.setFillAfter(true);
        animationSet.addAnimation(scaleAnimation4);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(200L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new AnonymousClass9());
        this.G.startAnimation(animationSet);
    }

    private void z() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Math.min(this.u.size(), this.R.size())) {
                break;
            }
            FirstChargeGift.FirstChargeGiftItem firstChargeGiftItem = this.R.get(i2);
            TextView textView = (TextView) this.u.get(i2).findViewById(R.id.live_charge_gift_name);
            ImageView imageView = (ImageView) this.u.get(i2).findViewById(R.id.live_charge_gift_icon);
            if (firstChargeGiftItem.price > 0) {
                textView.setText(String.valueOf(firstChargeGiftItem.price));
                imageView.setVisibility(0);
            } else {
                textView.setText(firstChargeGiftItem.title);
                textView.setTextColor(Color.parseColor("#5745FC"));
                imageView.setVisibility(8);
            }
            TextView textView2 = (TextView) this.u.get(i2).findViewById(R.id.live_charge_gift_count);
            textView2.setText("x" + firstChargeGiftItem.amount);
            ImageLoader.a(a(), firstChargeGiftItem.image).b(R.drawable.defaultpicture).a((ImageView) this.u.get(i2).findViewById(R.id.live_charge_gift_iv));
            i = i2 + 1;
        }
        if (this.R.size() > 0) {
            ImageLoader.a(a(), this.R.get(0).image).a(this.C);
        }
        if (this.R.size() > 1) {
            ImageLoader.a(a(), this.R.get(1).image).a(this.D);
        }
        if (this.R.size() > 2) {
            ImageLoader.a(a(), this.R.get(2).image).a(this.E);
        }
        if (this.R.size() > 3) {
            ImageLoader.a(a(), this.R.get(3).image).a(this.F);
        }
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_charge;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.l = this.b.findViewById(R.id.live_charge_mask_view);
        this.m = this.b.findViewById(R.id.live_charge_content_layout);
        this.n = this.b.findViewById(R.id.live_charge_title_layout);
        this.o = this.b.findViewById(R.id.live_charge_middle_layout);
        this.p = this.b.findViewById(R.id.live_charge_price_layout);
        this.q = (ImageView) this.b.findViewById(R.id.live_charge_close);
        this.r = (ImageView) this.b.findViewById(R.id.live_charge_title_iv);
        this.s = (ImageView) this.b.findViewById(R.id.live_charge_title_bg_iv);
        View findViewById = this.b.findViewById(R.id.live_charge_gift_one_layout);
        View findViewById2 = this.b.findViewById(R.id.live_charge_gift_two_layout);
        View findViewById3 = this.b.findViewById(R.id.live_charge_gift_three_layout);
        View findViewById4 = this.b.findViewById(R.id.live_charge_gift_four_layout);
        this.u.add(findViewById);
        this.u.add(findViewById2);
        this.u.add(findViewById3);
        this.u.add(findViewById4);
        this.t.add((ImageView) findViewById.findViewById(R.id.live_charge_gift_iv));
        this.t.add((ImageView) findViewById2.findViewById(R.id.live_charge_gift_iv));
        this.t.add((ImageView) findViewById3.findViewById(R.id.live_charge_gift_iv));
        this.t.add((ImageView) findViewById4.findViewById(R.id.live_charge_gift_iv));
        this.B.add(this.b.findViewById(R.id.item_live_charge_pay_one));
        this.B.add(this.b.findViewById(R.id.item_live_charge_pay_two));
        this.B.add(this.b.findViewById(R.id.item_live_charge_pay_three));
        this.B.add(this.b.findViewById(R.id.item_live_charge_pay_four));
        this.v = (ImageView) this.b.findViewById(R.id.live_charge_hand_iv);
        this.w = (ImageView) this.b.findViewById(R.id.live_charge_limit_time_iv);
        this.x = (ImageView) this.b.findViewById(R.id.live_charge_gold_iv);
        this.y = (ImageView) this.b.findViewById(R.id.live_charge_yio_iv);
        this.z = (ImageView) this.b.findViewById(R.id.live_charge_gift_iv);
        this.C = (ImageView) this.b.findViewById(R.id.live_charge_gift_anim_one_iv);
        this.D = (ImageView) this.b.findViewById(R.id.live_charge_gift_anim_two_iv);
        this.E = (ImageView) this.b.findViewById(R.id.live_charge_gift_anim_three_iv);
        this.F = (ImageView) this.b.findViewById(R.id.live_charge_gift_anim_four_iv);
        this.G = (ImageView) this.b.findViewById(R.id.live_charge_gift_bag_iv);
        this.m.setVisibility(4);
        View findViewById5 = this.b.findViewById(R.id.live_charge_success_layout);
        this.A = findViewById5;
        findViewById5.setVisibility(8);
        this.H = (TextView) this.b.findViewById(R.id.live_charge_tips_one);
        this.I = (TextView) this.b.findViewById(R.id.live_charge_tips_two);
        TextView textView = (TextView) this.b.findViewById(R.id.live_charge_tips_three);
        this.J = textView;
        textView.getViewTreeObserver().addOnGlobalLayoutListener(this.T);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        this.K = this.f10822c.getInt("from");
        this.L = this.f10822c.getBoolean("isFromGuide");
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void g() {
        if (LiveRoomManager.a().D() == null || TypeUtils.a((List<?>) LiveRoomManager.a().D().pay_list)) {
            LiveRoomHttpUtils.p(new BluedUIHttpResponse<BluedEntityA<FirstChargeGift>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveChargeDlgFragment.10
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<FirstChargeGift> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                        LiveChargeDlgFragment.this.dismissAllowingStateLoss();
                        return;
                    }
                    LiveRoomManager.a().a(bluedEntityA.getSingleData());
                    LiveChargeDlgFragment.this.a(bluedEntityA.getSingleData());
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    LiveChargeDlgFragment.this.dismissAllowingStateLoss();
                    return super.onUIFailure(i, str);
                }
            }, a());
        } else {
            a(LiveRoomManager.a().D());
        }
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void j() {
        super.j();
        EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_CLOSE_CLICK, this.K);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.K == 1) {
            j();
            return true;
        }
        return false;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        k();
        g();
        w();
    }
}
