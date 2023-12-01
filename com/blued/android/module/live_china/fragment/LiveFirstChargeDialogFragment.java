package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveFirstChargeBinding;
import com.blued.android.module.live_china.databinding.LiveFirstChargeGiftItemBinding;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFirstChargeDialogFragment.class */
public final class LiveFirstChargeDialogFragment extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12881a = new Companion(null);
    private int d;
    private boolean e;
    private final String b = "liveScreen";

    /* renamed from: c  reason: collision with root package name */
    private final String f12882c = "LiveFirstCharge";
    private final List<FirstChargeGift.FirstChargeGiftItem> f = new ArrayList();
    private final Lazy g = LazyKt.a(new Function0<FragmentLiveFirstChargeBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLiveFirstChargeBinding invoke() {
            return FragmentLiveFirstChargeBinding.a(LayoutInflater.from(LiveFirstChargeDialogFragment.this.getContext()), null, false);
        }
    });
    private List<View> h = new ArrayList();
    private String i = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFirstChargeDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Fragment fragment, int i, boolean z) {
            Intrinsics.e(fragment, "fragment");
            LiveFirstChargeDialogFragment liveFirstChargeDialogFragment = new LiveFirstChargeDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("from", i);
            bundle.putBoolean("isFromGuide", z);
            liveFirstChargeDialogFragment.setArguments(bundle);
            liveFirstChargeDialogFragment.setCancelable(false);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.getChildFragmentManager()");
            liveFirstChargeDialogFragment.show(childFragmentManager, liveFirstChargeDialogFragment.b());
        }
    }

    private final Animator a(View view, int i) {
        int[] iArr = new int[2];
        i().w.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        int i2 = iArr[0];
        int width = i().w.getWidth();
        int i3 = iArr[1];
        int height = i().w.getHeight();
        int i4 = iArr2[0];
        int width2 = view.getWidth() / 2;
        int i5 = iArr2[1];
        int height2 = view.getHeight() / 2;
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationX", 0.0f, (i2 + width) - (i4 + width2));
        Intrinsics.c(ofFloat, "ofFloat(\n            car…treX).toFloat()\n        )");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.setInterpolator(new DecelerateInterpolator(0.5f - (i / 500)));
        int i6 = i / 2;
        objectAnimator.setDuration(i6 + 650);
        long j = i6;
        objectAnimator.setStartDelay(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "TranslationY", 0.0f, (i3 + height) - (i5 + height2));
        Intrinsics.c(ofFloat2, "ofFloat(\n            car…treY).toFloat()\n        )");
        ObjectAnimator objectAnimator2 = ofFloat2;
        objectAnimator2.setInterpolator(new AnticipateInterpolator((i / 300) + 1.0f));
        objectAnimator2.setDuration(i6 + 700);
        objectAnimator.setStartDelay(j);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "ScaleX", 1.0f, 0.0f);
        Intrinsics.c(ofFloat3, "ofFloat(card, \"ScaleX\", 1f, 0f)");
        ObjectAnimator objectAnimator3 = ofFloat3;
        long j2 = i6 + 200;
        objectAnimator3.setDuration(j2);
        long j3 = i6 + 400;
        objectAnimator3.setStartDelay(j3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "ScaleY", 1.0f, 0.0f);
        Intrinsics.c(ofFloat4, "ofFloat(card, \"ScaleY\", 1f, 0f)");
        ObjectAnimator objectAnimator4 = ofFloat4;
        objectAnimator4.setDuration(j2);
        objectAnimator4.setStartDelay(j3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator).with(objectAnimator2).with(objectAnimator3).with(objectAnimator4);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveFirstChargeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.isEmpty(this$0.i)) {
            return;
        }
        this$0.i().k.setVisibility(0);
        this$0.i().u.setText(this$0.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveFirstChargeDialogFragment this$0, PayResultEvent payResultEvent) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(payResultEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveFirstChargeDialogFragment this$0, Ref.ObjectRef payModel, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(payModel, "$payModel");
        T payModel2 = payModel.f42545a;
        Intrinsics.c(payModel2, "payModel");
        this$0.a((PayOption._pay_list) payModel2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveFirstChargeDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveFirstChargeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i().k.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveFirstChargeDialogFragment this$0, Ref.ObjectRef payModel, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(payModel, "$payModel");
        T payModel2 = payModel.f42545a;
        Intrinsics.c(payModel2, "payModel");
        this$0.a((PayOption._pay_list) payModel2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveFirstChargeDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveFirstChargeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_NEW_FIRST_PAY_POP_MORE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        if (LiveDataManager.a().f()) {
            LiveRoomInfo.a().a(this$0.getContext(), 8);
        } else {
            LiveRoomInfo.a().a(this$0.getContext(), this$0.getChildFragmentManager(), 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveFirstChargeDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveFirstChargeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveFirstChargeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveFirstChargeDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLiveFirstChargeBinding i() {
        return (FragmentLiveFirstChargeBinding) this.g.getValue();
    }

    private final void j() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        a(arguments.getInt("from", 0));
        a(arguments.getBoolean("isFromGuide", false));
    }

    private final void k() {
        EventTrackLive.a(LiveProtos.Event.LIVE_NEW_FIRST_PAY_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        i().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$2vHOkIHjzsVtZYpi8rkwaKOLBJU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFirstChargeDialogFragment.a(LiveFirstChargeDialogFragment.this, view);
            }
        });
        i().q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$arHePXj2h1cA89MZ6B4OUAf3FmI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFirstChargeDialogFragment.b(LiveFirstChargeDialogFragment.this, view);
            }
        });
        i().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$N6SdGgTZTHmbKV6ibCgYL8T2-bc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFirstChargeDialogFragment.c(LiveFirstChargeDialogFragment.this, view);
            }
        });
        i().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$UHxaF_n2uOs5I05NY_H4eaAASsE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFirstChargeDialogFragment.d(LiveFirstChargeDialogFragment.this, view);
            }
        });
        i().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$oyyOhwlHAgLwfqI36hjHIeHobik
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFirstChargeDialogFragment.e(LiveFirstChargeDialogFragment.this, view);
            }
        });
        i().t.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$B8b44QrrLZ_OLcAdNM0oq9Kmzbo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFirstChargeDialogFragment.f(LiveFirstChargeDialogFragment.this, view);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.d, PayResultEvent.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$KRQTvrertHRc8jFb8qPjaO6TPqs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveFirstChargeDialogFragment.a(LiveFirstChargeDialogFragment.this, (PayResultEvent) obj);
            }
        });
    }

    private final void l() {
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
        i().f11923c.startAnimation(animationSet);
    }

    private final void m() {
        int a2 = DensityUtils.a(getActivity());
        if (this.d == 1) {
            int size = this.h.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                int[] iArr = new int[2];
                View view = this.h.get(i2);
                view.getLocationOnScreen(iArr);
                if (view.getParent() instanceof ViewGroup) {
                    ViewParent parent = view.getParent();
                    if (parent == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    ((ViewGroup) parent).removeView(view);
                }
                i().l.addView(view);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.topMargin = iArr[1] - a2;
                view.setLayoutParams(layoutParams);
                i = i2 + 1;
            }
        }
        i().m.setAlpha(0.0f);
        i().n.setVisibility(0);
        EventTrackLive.a(LiveProtos.Event.LIVE_NEW_FIRST_PAY_POP_SUCCESS_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        i().n.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$7klKs81gfo3d32UNws16U7-DXf8
            @Override // java.lang.Runnable
            public final void run() {
                LiveFirstChargeDialogFragment.d(LiveFirstChargeDialogFragment.this);
            }
        });
    }

    private final void n() {
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder play = animatorSet.play(o());
        if (this.d == 1) {
            int size = this.h.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                play.with(a(this.h.get(i2), (size - i2) * 70));
                i = i2 + 1;
            }
        }
        play.with(p());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment$startRechargeSucceedAnim$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        animatorSet.start();
    }

    private final Animator o() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(i().f11922a, "alpha", 1.0f, 0.0f);
        Intrinsics.c(ofFloat, "ofFloat(vb.flMain, \"alpha\", 1f, 0f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.setDuration(1000L);
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment$hideGiftBagAnim$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                FragmentLiveFirstChargeBinding i;
                Intrinsics.e(animation, "animation");
                if (LiveFirstChargeDialogFragment.this.getActivity() != null) {
                    FragmentActivity activity = LiveFirstChargeDialogFragment.this.getActivity();
                    Intrinsics.a(activity);
                    if (activity.isFinishing() || LiveFirstChargeDialogFragment.this.getDialog() == null) {
                        return;
                    }
                    Dialog dialog = LiveFirstChargeDialogFragment.this.getDialog();
                    Intrinsics.a(dialog);
                    if (dialog.isShowing()) {
                        super.onAnimationEnd(animation);
                        i = LiveFirstChargeDialogFragment.this.i();
                        i.f11922a.setVisibility(8);
                    }
                }
            }
        });
        return objectAnimator;
    }

    private final Animator p() {
        int height = (i().n.getHeight() - i().m.getHeight()) / 2;
        i().m.setTranslationY(i().n.getHeight() - height);
        i().m.setAlpha(1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(i().m, "TranslationY", i().n.getHeight() - height, 0.0f);
        Intrinsics.c(ofFloat, "ofFloat(vb.rvSuccess, \"T…ght - top).toFloat(), 0f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.setInterpolator(new OvershootInterpolator(1.5f));
        objectAnimator.setDuration(350L);
        objectAnimator.setStartDelay(300L);
        return objectAnimator;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new CubicInterpolator(0.2f, 0.04f, 0.83f, 0.96f));
        scaleAnimation.setDuration(700L);
        scaleAnimation.setFillAfter(false);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment$showItemAnim$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        if (view == null) {
            return;
        }
        view.startAnimation(scaleAnimation);
    }

    public final void a(PayOption._pay_list payModel) {
        Intrinsics.e(payModel, "payModel");
        LiveRoomInfo.a().a(getActivity(), payModel, this.b);
        EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_SKU_CLICK, this.d, (int) payModel.money);
    }

    /* JADX WARN: Type inference failed for: r1v28, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.Object] */
    public final void a(FirstChargeGift firstChargeGift) {
        if (firstChargeGift == null) {
            i().j.setVisibility(0);
            return;
        }
        this.i = firstChargeGift.rule;
        i().j.setVisibility(8);
        if (firstChargeGift.gifts != null) {
            this.f.clear();
            List<FirstChargeGift.FirstChargeGiftItem> list = this.f;
            List<FirstChargeGift.FirstChargeGiftItem> list2 = firstChargeGift.gifts;
            Intrinsics.c(list2, "model.gifts");
            list.addAll(list2);
        }
        g();
        if (firstChargeGift.pay_list != null) {
            if (firstChargeGift.pay_list.size() >= 1) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.f42545a = firstChargeGift.pay_list.get(0);
                if (objectRef.f42545a != 0) {
                    i().p.setText(Intrinsics.a(CommonStringUtils.a(((PayOption._pay_list) objectRef.f42545a).money * ((PayOption._pay_list) objectRef.f42545a).ratio), (Object) getString(R.string.Live_SendPresent_wandou)));
                    i().o.setText(Intrinsics.a(CommonStringUtils.a(((PayOption._pay_list) objectRef.f42545a).money), (Object) getString(R.string.Live_SendPresent_RMB)));
                    i().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$Y5DKWJdUBinabwRmrirmj7mxSqM
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LiveFirstChargeDialogFragment.a(LiveFirstChargeDialogFragment.this, objectRef, view);
                        }
                    });
                }
            }
            if (firstChargeGift.pay_list.size() >= 2) {
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.f42545a = firstChargeGift.pay_list.get(1);
                if (objectRef2.f42545a != 0) {
                    i().s.setText(Intrinsics.a(CommonStringUtils.a(((PayOption._pay_list) objectRef2.f42545a).money * ((PayOption._pay_list) objectRef2.f42545a).ratio), (Object) getString(R.string.Live_SendPresent_wandou)));
                    i().r.setText(Intrinsics.a(CommonStringUtils.a(((PayOption._pay_list) objectRef2.f42545a).money), (Object) getString(R.string.Live_SendPresent_RMB)));
                    i().f11923c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$7iEmtd_6jbZQj1aK6mIYEi4fzJA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            LiveFirstChargeDialogFragment.b(LiveFirstChargeDialogFragment.this, objectRef2, view);
                        }
                    });
                }
            }
        }
        h();
    }

    public final void a(PayResultEvent payResultEvent) {
        if (payResultEvent == null) {
            return;
        }
        LogUtils.c(payResultEvent.flag + ", from:" + this.d + ", " + ((Object) payResultEvent.from) + ", money: " + payResultEvent.money);
        if (payResultEvent.flag) {
            LiveRoomManager.a().p().rechargeGiftBagIconShowType = 0;
            LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue()));
            LiveEventBusUtil.a(0);
            LiveDataManager.a().a("live_gift");
            LiveGiftManager.a().a(false);
            a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$erFImryQDih4tLv2PFBDCrWX4pk
                @Override // java.lang.Runnable
                public final void run() {
                    LiveFirstChargeDialogFragment.b(LiveFirstChargeDialogFragment.this);
                }
            }, 300L);
            LiveRefreshUIObserver.a().c(LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE);
            EventTrackLive.b(LiveProtos.Event.LIVE_NEW_FIRST_PAY_POP_SUCCESS, payResultEvent.money);
        }
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void f() {
        if (LiveRoomManager.a().D() != null && !TypeUtils.a((List<?>) LiveRoomManager.a().D().pay_list)) {
            a(LiveRoomManager.a().D());
            return;
        }
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.p(new BluedUIHttpResponse<BluedEntityA<FirstChargeGift>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment$onLoadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FirstChargeGift> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                if (bluedEntity.getSingleData() == null) {
                    LiveFirstChargeDialogFragment.this.a((FirstChargeGift) null);
                    return;
                }
                LiveRoomManager.a().a(bluedEntity.getSingleData());
                LiveFirstChargeDialogFragment.this.a(bluedEntity.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                LiveFirstChargeDialogFragment.this.a((FirstChargeGift) null);
                return super.onUIFailure(i, errorMessage);
            }
        }, a());
    }

    public final void g() {
        i().i.removeAllViews();
        this.h.clear();
        int min = Math.min(6, this.f.size() - 1);
        if (min < 0) {
            return;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2 % 3;
            int i4 = i;
            if (i3 == 0) {
                i4 = i + 1;
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                i().i.addView(linearLayout);
            }
            LinearLayout linearLayout2 = i().i;
            Intrinsics.c(linearLayout2, "vb.llFirstCharge");
            ViewGroup viewGroup = (ViewGroup) ViewGroupKt.get(linearLayout2, i4);
            if (viewGroup == null) {
                return;
            }
            LiveFirstChargeGiftItemBinding a2 = LiveFirstChargeGiftItemBinding.a(LayoutInflater.from(getContext()), null, false);
            Intrinsics.c(a2, "inflate(LayoutInflater.from(context), null, false)");
            FirstChargeGift.FirstChargeGiftItem firstChargeGiftItem = this.f.get(i2);
            if (firstChargeGiftItem.amount > 1) {
                a2.b.setVisibility(0);
                a2.b.setText(Intrinsics.a("x", (Object) Integer.valueOf(firstChargeGiftItem.amount)));
            } else {
                a2.b.setVisibility(8);
            }
            List<View> list = this.h;
            ImageView imageView = a2.f12205a;
            Intrinsics.c(imageView, "giftVb.ivAvatar");
            list.add(imageView);
            ImageLoader.a(a(), firstChargeGiftItem.image).a(a2.f12205a);
            a2.f12206c.setText(firstChargeGiftItem.title);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            if (i3 == 2) {
                marginLayoutParams.rightMargin = 0;
            } else {
                marginLayoutParams.rightMargin = AppMethods.b(5);
            }
            if (i4 > 0) {
                marginLayoutParams.topMargin = AppMethods.b(7);
            } else {
                marginLayoutParams.topMargin = 0;
            }
            viewGroup.addView(a2.getRoot(), marginLayoutParams);
            a(a2.f12205a);
            if (i2 == min) {
                return;
            }
            i2++;
            i = i4;
        }
    }

    public final void h() {
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
        alphaAnimation2.setStartOffset(2800L);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment$playHand$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                FragmentLiveFirstChargeBinding i;
                Intrinsics.e(animation, "animation");
                i = LiveFirstChargeDialogFragment.this.i();
                i.x.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                FragmentLiveFirstChargeBinding i;
                Intrinsics.e(animation, "animation");
                i = LiveFirstChargeDialogFragment.this.i();
                i.x.setVisibility(0);
            }
        });
        animationSet.addAnimation(alphaAnimation2);
        i().x.startAnimation(animationSet);
        a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveFirstChargeDialogFragment$GX3Cwg92gTl5DZF9O7D2gpx2hQk
            @Override // java.lang.Runnable
            public final void run() {
                LiveFirstChargeDialogFragment.c(LiveFirstChargeDialogFragment.this);
            }
        }, 450L);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (i().k.getVisibility() == 0) {
            i().k.setVisibility(8);
            return false;
        }
        return super.onBackPressed();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        if (i().d.getParent() != null) {
            ViewParent parent = i().d.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(i().d);
        }
        j();
        k();
        f();
        return i().d;
    }
}
