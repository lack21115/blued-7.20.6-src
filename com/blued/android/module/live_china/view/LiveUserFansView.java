package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LayoutLiveUserFansViewBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.LiveCountDownTimeUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveUserFansView.class */
public final class LiveUserFansView extends FrameLayout {
    public static final Companion a = new Companion(null);
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 3;
    private LayoutLiveUserFansViewBinding b;
    private boolean c;
    private int d;
    private LifecycleOwner e;
    private ValueAnimator f;
    private ValueAnimator g;
    private ValueAnimator h;
    private ValueAnimator i;
    private ValueAnimator j;
    private ValueAnimator k;
    private ValueAnimator l;
    private ValueAnimator m;
    private long n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private StartFansClubAnchorBgListener v;
    private OnBtnClickListener w;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveUserFansView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return LiveUserFansView.x;
        }

        public final int b() {
            return LiveUserFansView.y;
        }

        public final int c() {
            return LiveUserFansView.z;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveUserFansView$OnBtnClickListener.class */
    public interface OnBtnClickListener {
        void a();

        void b();
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveUserFansView$StartFansClubAnchorBgListener.class */
    public interface StartFansClubAnchorBgListener {
        void a();

        void a(float f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveUserFansView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveUserFansView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveUserFansView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.d = x;
    }

    private final void a(int i, int i2, int i3, int i4, final ShapeTextView shapeTextView, long j) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ShapeModel shapeModel = shapeTextView == null ? null : shapeTextView.getShapeModel();
        final ShapeModel shapeModel2 = shapeModel;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$AXJ1kZkQb3LWIM5y5T2lZE16vy8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveUserFansView.a(ShapeModel.this, shapeTextView, valueAnimator);
            }
        });
        ofInt.setDuration(j);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.start();
        ValueAnimator ofInt2 = ValueAnimator.ofInt(i3, i4);
        final ShapeModel shapeModel3 = shapeModel;
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$RFcZ2Z8FKvBTDsEl7d92pMTpBVQ
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveUserFansView.b(ShapeModel.this, shapeTextView, valueAnimator);
            }
        });
        ofInt2.setDuration(j);
        ofInt2.setEvaluator(new ArgbEvaluator());
        ofInt2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final View view, int i) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = i;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(360L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveUserFansView$showFollowZoomAnim$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                this.b(view, Ref.IntRef.this.a);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
                Ref.IntRef.this.a++;
            }
        });
        view.startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ShapeModel shapeModel, ShapeTextView shapeTextView, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        if (shapeModel != null) {
            shapeModel.t = intValue;
        }
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setShapeModel(shapeModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LayoutLiveUserFansViewBinding this_run, Context context) {
        Intrinsics.e(this_run, "$this_run");
        Intrinsics.e(context, "$context");
        this_run.a.setPivotX(UiUtils.a(context, 80.0f));
        this_run.a.setPivotY(UiUtils.a(context, 25.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LayoutLiveUserFansViewBinding this_run, RelativeLayout.LayoutParams rlP, ValueAnimator valueAnimator) {
        Intrinsics.e(this_run, "$this_run");
        Intrinsics.e(rlP, "$rlP");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        ShapeTextView liveFollowBtn = this_run.h;
        Intrinsics.c(liveFollowBtn, "liveFollowBtn");
        BluedViewExtKt.a((View) liveFollowBtn, intValue);
        rlP.width = intValue;
        this_run.a.setLayoutParams(rlP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveUserFansView this$0, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        StartFansClubAnchorBgListener startFansClubAnchorBgListener = this$0.v;
        if (startFansClubAnchorBgListener == null) {
            return;
        }
        startFansClubAnchorBgListener.a(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveUserFansView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.c) {
            this$0.b("join");
            OnBtnClickListener onBtnClickListener = this$0.w;
            if (onBtnClickListener == null) {
                return;
            }
            onBtnClickListener.b();
            return;
        }
        this$0.c = true;
        this$0.b();
        OnBtnClickListener onBtnClickListener2 = this$0.w;
        if (onBtnClickListener2 == null) {
            return;
        }
        onBtnClickListener2.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveUserFansView this$0, RelativeLayout.LayoutParams rlP, ValueAnimator valueAnimator) {
        ShapeTextView shapeTextView;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(rlP, "$rlP");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this$0.b;
        if (layoutLiveUserFansViewBinding != null && (shapeTextView = layoutLiveUserFansViewBinding.h) != null) {
            BluedViewExtKt.a((View) shapeTextView, intValue);
        }
        rlP.width = intValue;
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding2 = this$0.b;
        FrameLayout frameLayout = layoutLiveUserFansViewBinding2 == null ? null : layoutLiveUserFansViewBinding2.a;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setLayoutParams(rlP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveUserFansView this$0, ShapeModel shapeModel, ValueAnimator valueAnimator) {
        ImageView imageView;
        Intrinsics.e(this$0, "this$0");
        valueAnimator.getAnimatedValue();
        long currentTimeMillis = System.currentTimeMillis() - this$0.n;
        if (currentTimeMillis > 300 && !this$0.o) {
            this$0.o = true;
            LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this$0.b;
            if (layoutLiveUserFansViewBinding != null && (imageView = layoutLiveUserFansViewBinding.e) != null) {
                BluedViewExKt.b(imageView);
            }
            ImageWrapper a2 = ImageLoader.c(null, "live_add_fans_club_overshoot_bg.png").g(-1).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.view.LiveUserFansView$openAddFansBtn$1$1
                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void a() {
                }

                @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                public void b() {
                    LiveUserFansView.this.setShowClubOvershoot(false);
                }
            });
            LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding2 = this$0.b;
            a2.a(layoutLiveUserFansViewBinding2 == null ? null : layoutLiveUserFansViewBinding2.e);
        }
        if (!(1171 <= currentTimeMillis && currentTimeMillis < 1680)) {
            if (!(1680 <= currentTimeMillis && currentTimeMillis < 2130)) {
                boolean z2 = false;
                if (2130 <= currentTimeMillis) {
                    z2 = false;
                    if (currentTimeMillis < 2581) {
                        z2 = true;
                    }
                }
                if (z2 && !this$0.r) {
                    this$0.r = true;
                    int color = this$0.getResources().getColor(R.color.syc_E34469);
                    int color2 = this$0.getResources().getColor(R.color.syc_F5A300);
                    int color3 = this$0.getResources().getColor(R.color.syc_FF3A66);
                    int color4 = this$0.getResources().getColor(R.color.syc_F5A300);
                    LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding3 = this$0.b;
                    this$0.a(color, color2, color3, color4, layoutLiveUserFansViewBinding3 == null ? null : layoutLiveUserFansViewBinding3.h, 450L);
                }
            } else if (!this$0.q) {
                this$0.q = true;
                int color5 = this$0.getResources().getColor(R.color.syc_FF9843);
                int color6 = this$0.getResources().getColor(R.color.syc_E34469);
                int color7 = this$0.getResources().getColor(R.color.syc_FF733F);
                int color8 = this$0.getResources().getColor(R.color.syc_FF3A66);
                LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding4 = this$0.b;
                this$0.a(color5, color6, color7, color8, layoutLiveUserFansViewBinding4 == null ? null : layoutLiveUserFansViewBinding4.h, 450L);
            }
        } else if (!this$0.p) {
            this$0.p = true;
            int color9 = this$0.getResources().getColor(R.color.syc_dark_922CEE);
            int color10 = this$0.getResources().getColor(R.color.syc_FF9843);
            int color11 = this$0.getResources().getColor(R.color.syc_dark_FF3AAA);
            int color12 = this$0.getResources().getColor(R.color.syc_FF733F);
            LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding5 = this$0.b;
            this$0.a(color9, color10, color11, color12, layoutLiveUserFansViewBinding5 == null ? null : layoutLiveUserFansViewBinding5.h, 510L);
        }
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding6 = this$0.b;
        ShapeTextView shapeTextView = layoutLiveUserFansViewBinding6 == null ? null : layoutLiveUserFansViewBinding6.h;
        if (shapeTextView != null) {
            shapeTextView.setShapeModel(shapeModel);
        }
        if (currentTimeMillis <= 4170 || this$0.s) {
            return;
        }
        this$0.s = true;
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Boolean bool) {
    }

    private final void a(String str) {
        EventTrackLive.a(LiveProtos.Event.LIVE_FANS_GUIDE_ICON_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str);
        EventTrackLive.a(LiveProtos.Event.LIVE_FANS_ENTER_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final View view, int i) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = i;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(360L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveUserFansView$showFollowSmallAnim$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                if (Ref.IntRef.this.a < 3) {
                    this.a(view, Ref.IntRef.this.a);
                }
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
        view.startAnimation(scaleAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ShapeModel shapeModel, ShapeTextView shapeTextView, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        if (shapeModel != null) {
            shapeModel.v = intValue;
        }
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setShapeModel(shapeModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveUserFansView this$0, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this$0.b;
        ShapeTextView shapeTextView = layoutLiveUserFansViewBinding == null ? null : layoutLiveUserFansViewBinding.h;
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setAlpha(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveUserFansView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        OnBtnClickListener onBtnClickListener = this$0.w;
        if (onBtnClickListener != null) {
            onBtnClickListener.b();
        }
        if (this$0.u) {
            this$0.b("dynamic");
        } else if (this$0.d == z) {
            this$0.b("static_join");
        } else {
            this$0.b("static");
        }
    }

    private final void b(String str) {
        EventTrackLive.a(LiveProtos.Event.LIVE_FANS_GUIDE_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveUserFansView this$0, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        StartFansClubAnchorBgListener startFansClubAnchorBgListener = this$0.v;
        if (startFansClubAnchorBgListener == null) {
            return;
        }
        startFansClubAnchorBgListener.a(floatValue);
    }

    public static final int getFANS_CLUB() {
        return a.c();
    }

    public static final int getFOLLOW() {
        return a.b();
    }

    public static final int getNOT_FOLLOW() {
        return a.a();
    }

    private final void i() {
        final LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this.b;
        if (layoutLiveUserFansViewBinding == null) {
            return;
        }
        FrameLayout flFollow = layoutLiveUserFansViewBinding.a;
        Intrinsics.c(flFollow, "flFollow");
        BluedViewExKt.b(flFollow);
        layoutLiveUserFansViewBinding.h.setText("加入粉丝团");
        LogUtils.d("pLog", "expandAddFansBtn动画执行--------  ");
        ViewGroup.LayoutParams layoutParams = layoutLiveUserFansViewBinding.a.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        final RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        setExpandValueAnimator(ValueAnimator.ofInt(UiUtils.a(getContext(), 40.0f), UiUtils.a(getContext(), 80.0f)));
        ValueAnimator expandValueAnimator = getExpandValueAnimator();
        if (expandValueAnimator != null) {
            expandValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$V4VJG97hhfFy2-fLToCbl1comJA
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LiveUserFansView.a(LayoutLiveUserFansViewBinding.this, layoutParams2, valueAnimator);
                }
            });
        }
        layoutLiveUserFansViewBinding.h.setAlpha(1.0f);
        ValueAnimator expandValueAnimator2 = getExpandValueAnimator();
        if (expandValueAnimator2 != null) {
            expandValueAnimator2.setDuration(330L);
        }
        ValueAnimator expandValueAnimator3 = getExpandValueAnimator();
        if (expandValueAnimator3 != null) {
            expandValueAnimator3.start();
        }
        setExpandAlphaValueAnimator(ValueAnimator.ofFloat(1.0f, 0.3f));
        ValueAnimator expandAlphaValueAnimator = getExpandAlphaValueAnimator();
        if (expandAlphaValueAnimator != null) {
            expandAlphaValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$wpgRd5fiJ28MIc5OWOkPPL-ab10
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LiveUserFansView.a(LiveUserFansView.this, valueAnimator);
                }
            });
        }
        ValueAnimator expandAlphaValueAnimator2 = getExpandAlphaValueAnimator();
        if (expandAlphaValueAnimator2 != null) {
            expandAlphaValueAnimator2.setDuration(330L);
        }
        ValueAnimator expandAlphaValueAnimator3 = getExpandAlphaValueAnimator();
        if (expandAlphaValueAnimator3 == null) {
            return;
        }
        expandAlphaValueAnimator3.start();
    }

    private final void j() {
        FrameLayout frameLayout;
        LogUtils.d("pLog", "hideAddFansBtn 动画执行--------  ");
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this.b;
        RelativeLayout.LayoutParams layoutParams = null;
        if (layoutLiveUserFansViewBinding != null && (frameLayout = layoutLiveUserFansViewBinding.a) != null) {
            layoutParams = frameLayout.getLayoutParams();
        }
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        final RelativeLayout.LayoutParams layoutParams2 = layoutParams;
        ValueAnimator ofInt = ValueAnimator.ofInt(UiUtils.a(getContext(), 80.0f), UiUtils.a(getContext(), 40.0f));
        this.h = ofInt;
        if (ofInt != null) {
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$kZGSywlN-A2DBI5IZWY01xRV5Bg
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LiveUserFansView.a(LiveUserFansView.this, layoutParams2, valueAnimator);
                }
            });
        }
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LiveUserFansView$hideAddFansBtn$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding2;
                    FrameLayout frameLayout2;
                    super.onAnimationEnd(animator);
                    layoutLiveUserFansViewBinding2 = LiveUserFansView.this.b;
                    if (layoutLiveUserFansViewBinding2 != null && (frameLayout2 = layoutLiveUserFansViewBinding2.a) != null) {
                        BluedViewExKt.a(frameLayout2);
                    }
                    LiveUserFansView.this.k();
                }
            });
        }
        ValueAnimator valueAnimator2 = this.h;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(180L);
        }
        ValueAnimator valueAnimator3 = this.h;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f);
        this.i = ofFloat;
        if (ofFloat != null) {
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$f0Tq8y3U6e_kEyvqifuh57hx44Y
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                    LiveUserFansView.b(LiveUserFansView.this, valueAnimator4);
                }
            });
        }
        ValueAnimator valueAnimator4 = this.i;
        if (valueAnimator4 != null) {
            valueAnimator4.setDuration(180L);
        }
        ValueAnimator valueAnimator5 = this.i;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.3f, 1.0f);
        this.k = ofFloat2;
        if (ofFloat2 != null) {
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$TG2IiPhlCw3Pji6bzsJaEUN24yU
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator6) {
                    LiveUserFansView.c(LiveUserFansView.this, valueAnimator6);
                }
            });
        }
        ValueAnimator valueAnimator6 = this.k;
        if (valueAnimator6 != null) {
            valueAnimator6.setDuration(180L);
        }
        ValueAnimator valueAnimator7 = this.k;
        if (valueAnimator7 == null) {
            return;
        }
        valueAnimator7.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        a("dynamic");
        final LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this.b;
        if (layoutLiveUserFansViewBinding == null) {
            return;
        }
        setShowFansClubAnim(true);
        StartFansClubAnchorBgListener startFansClubAnchorBgListener = this.v;
        if (startFansClubAnchorBgListener != null) {
            startFansClubAnchorBgListener.a();
        }
        ShapeFrameLayout flLiveFans = layoutLiveUserFansViewBinding.b;
        Intrinsics.c(flLiveFans, "flLiveFans");
        BluedViewExKt.b(flLiveFans);
        layoutLiveUserFansViewBinding.g.setBackgroundResource(R.drawable.img_live_fans_not_followed);
        ImageLoader.c(null, "live_fans_star.png").g(1).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.view.LiveUserFansView$showFansClubBtn$1$1
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
                ImageView imgLiveFansStar = LayoutLiveUserFansViewBinding.this.d;
                Intrinsics.c(imgLiveFansStar, "imgLiveFansStar");
                BluedViewExKt.b(imgLiveFansStar);
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
                ImageView imgLiveFansStar = LayoutLiveUserFansViewBinding.this.d;
                Intrinsics.c(imgLiveFansStar, "imgLiveFansStar");
                BluedViewExKt.a(imgLiveFansStar);
            }
        }).a(layoutLiveUserFansViewBinding.d);
        ImageView imgLiveFansHeartBg = layoutLiveUserFansViewBinding.c;
        Intrinsics.c(imgLiveFansHeartBg, "imgLiveFansHeartBg");
        BluedViewExKt.b(imgLiveFansHeartBg);
        ImageLoader.c(null, "live_fans_heart_bg.png").g(1).f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.view.LiveUserFansView$showFansClubBtn$1$2
            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
            public void b() {
                ShapeTextView liveFansDotTips = LayoutLiveUserFansViewBinding.this.f;
                Intrinsics.c(liveFansDotTips, "liveFansDotTips");
                BluedViewExKt.b((View) liveFansDotTips);
                this.setShowFansClubAnim(false);
                LayoutLiveUserFansViewBinding.this.c.setImageResource(R.drawable.img_live_fans_club_heart_bg);
            }
        }).a(layoutLiveUserFansViewBinding.c);
    }

    private final void l() {
        LiveCountDownTimeUtils.a.b().a();
    }

    private final void m() {
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this.b;
        if (layoutLiveUserFansViewBinding == null) {
            return;
        }
        FrameLayout flFollow = layoutLiveUserFansViewBinding.a;
        Intrinsics.c(flFollow, "flFollow");
        a(flFollow, 0);
        ShapeTextView liveFollowBtn = layoutLiveUserFansViewBinding.h;
        Intrinsics.c(liveFollowBtn, "liveFollowBtn");
        a((View) liveFollowBtn, 0);
    }

    public final void a(final Context context) {
        Intrinsics.e(context, "context");
        final LayoutLiveUserFansViewBinding a2 = LayoutLiveUserFansViewBinding.a(LayoutInflater.from(context), this, true);
        this.b = a2;
        if (a2 == null) {
            return;
        }
        a2.a.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$kib6b13mlE-_eDZVl85JNNo1-CA
            @Override // java.lang.Runnable
            public final void run() {
                LiveUserFansView.a(LayoutLiveUserFansViewBinding.this, context);
            }
        });
        a2.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$U-mRZz1JbLHcbbCttMjv4wnnGKw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveUserFansView.a(LiveUserFansView.this, view);
            }
        });
        a2.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$WAG48z6PzggrirQ4NTYijhItZRQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveUserFansView.b(LiveUserFansView.this, view);
            }
        });
    }

    public final boolean a() {
        return this.t;
    }

    public final void b() {
        ShapeTextView shapeTextView;
        a("join");
        this.t = true;
        this.f = ValueAnimator.ofFloat(0.0f, 1.0f);
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this.b;
        ShapeModel shapeModel = null;
        if (layoutLiveUserFansViewBinding != null && (shapeTextView = layoutLiveUserFansViewBinding.h) != null) {
            shapeModel = shapeTextView.getShapeModel();
        }
        if (shapeModel != null) {
            shapeModel.t = getResources().getColor(R.color.syc_dark_922CEE);
        }
        if (shapeModel != null) {
            shapeModel.v = getResources().getColor(R.color.syc_dark_FF3AAA);
        }
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            final ShapeModel shapeModel2 = shapeModel;
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$8lUPevlh_4C8hGEz2F0NJXEf6Ik
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    LiveUserFansView.a(LiveUserFansView.this, shapeModel2, valueAnimator2);
                }
            });
        }
        ValueAnimator valueAnimator2 = this.f;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(4350L);
        }
        ValueAnimator valueAnimator3 = this.f;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LiveUserFansView$openAddFansBtn$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LiveUserFansView.this.setOpenAddFansAnimShow(false);
                    LiveUserFansView.this.setShowAnimation1(false);
                    LiveUserFansView.this.setShowAnimation2(false);
                    LiveUserFansView.this.setShowAnimation3(false);
                    LiveUserFansView.this.setShowHideAnimation(false);
                }
            });
        }
        this.n = System.currentTimeMillis();
        ValueAnimator valueAnimator4 = this.f;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
        i();
    }

    public final void b(Context context) {
        Intrinsics.e(context, "context");
        a(context);
    }

    public final void c() {
        l();
        LiveEventBus.get("key_event_live_update_follow_state", Boolean.TYPE).removeObserver(new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveUserFansView$oxbunWddbaWEyxwiznQZaaVrq7o
            public final void onChanged(Object obj) {
                LiveUserFansView.a((Boolean) obj);
            }
        });
        d();
    }

    public final void d() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.g;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.h;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator4 = this.i;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        ValueAnimator valueAnimator5 = this.k;
        if (valueAnimator5 != null) {
            valueAnimator5.cancel();
        }
        ValueAnimator valueAnimator6 = this.j;
        if (valueAnimator6 != null) {
            valueAnimator6.cancel();
        }
        ValueAnimator valueAnimator7 = this.i;
        if (valueAnimator7 != null) {
            valueAnimator7.cancel();
        }
        ValueAnimator valueAnimator8 = this.l;
        if (valueAnimator8 != null) {
            valueAnimator8.cancel();
        }
        ValueAnimator valueAnimator9 = this.m;
        if (valueAnimator9 != null) {
            valueAnimator9.cancel();
        }
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        StartFansClubAnchorBgListener startFansClubAnchorBgListener = this.v;
        if (startFansClubAnchorBgListener == null) {
            return;
        }
        startFansClubAnchorBgListener.a(1.0f);
    }

    public final void e() {
        m();
    }

    public final ValueAnimator getExpandAlphaValueAnimator() {
        return this.j;
    }

    public final ValueAnimator getExpandValueAnimator() {
        return this.g;
    }

    public final ValueAnimator getHideAlphaValueAnimator() {
        return this.i;
    }

    public final ValueAnimator getHideInfoBgAlphaValueAnimator() {
        return this.k;
    }

    public final ValueAnimator getHideValueAnimator() {
        return this.h;
    }

    public final long getStartTime() {
        return this.n;
    }

    public final ValueAnimator getValueAnimator() {
        return this.f;
    }

    public final ValueAnimator getZoomValueAnimatorH() {
        return this.m;
    }

    public final ValueAnimator getZoomValueAnimatorW() {
        return this.l;
    }

    public final void setBtnClickListener(OnBtnClickListener btnClickListener) {
        Intrinsics.e(btnClickListener, "btnClickListener");
        this.w = btnClickListener;
    }

    public final void setExpandAlphaValueAnimator(ValueAnimator valueAnimator) {
        this.j = valueAnimator;
    }

    public final void setExpandValueAnimator(ValueAnimator valueAnimator) {
        this.g = valueAnimator;
    }

    public final void setFansViewState(int i) {
        this.d = i;
        LayoutLiveUserFansViewBinding layoutLiveUserFansViewBinding = this.b;
        if (layoutLiveUserFansViewBinding == null) {
            return;
        }
        if (i == x) {
            d();
            this.c = false;
            d();
            FrameLayout flFollow = layoutLiveUserFansViewBinding.a;
            Intrinsics.c(flFollow, "flFollow");
            BluedViewExKt.b(flFollow);
            ImageView liveAddFollowOvershootBg = layoutLiveUserFansViewBinding.e;
            Intrinsics.c(liveAddFollowOvershootBg, "liveAddFollowOvershootBg");
            BluedViewExKt.a(liveAddFollowOvershootBg);
            ViewGroup.LayoutParams layoutParams = layoutLiveUserFansViewBinding.a.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            ShapeFrameLayout flLiveFans = layoutLiveUserFansViewBinding.b;
            Intrinsics.c(flLiveFans, "flLiveFans");
            BluedViewExKt.a(flLiveFans);
            layoutLiveUserFansViewBinding.h.setText("关注");
            ShapeTextView liveFollowBtn = layoutLiveUserFansViewBinding.h;
            Intrinsics.c(liveFollowBtn, "liveFollowBtn");
            BluedViewExtKt.a((View) liveFollowBtn, UiUtils.a(getContext(), 40.0f));
            layoutParams2.width = UiUtils.a(getContext(), 40.0f);
            layoutLiveUserFansViewBinding.a.setLayoutParams(layoutParams2);
            layoutLiveUserFansViewBinding.h.setAlpha(1.0f);
            ShapeModel shapeModel = layoutLiveUserFansViewBinding.h.getShapeModel();
            if (shapeModel != null) {
                shapeModel.t = getResources().getColor(R.color.syc_dark_922CEE);
            }
            if (shapeModel != null) {
                shapeModel.v = getResources().getColor(R.color.syc_dark_FF3AAA);
            }
            layoutLiveUserFansViewBinding.h.setShapeModel(shapeModel);
        } else if (i == y) {
            this.c = true;
            if (a()) {
                return;
            }
            FrameLayout flFollow2 = layoutLiveUserFansViewBinding.a;
            Intrinsics.c(flFollow2, "flFollow");
            BluedViewExKt.a(flFollow2);
            ShapeFrameLayout flLiveFans2 = layoutLiveUserFansViewBinding.b;
            Intrinsics.c(flLiveFans2, "flLiveFans");
            BluedViewExKt.b(flLiveFans2);
            ShapeTextView liveFansDotTips = layoutLiveUserFansViewBinding.f;
            Intrinsics.c(liveFansDotTips, "liveFansDotTips");
            BluedViewExKt.b((View) liveFansDotTips);
            layoutLiveUserFansViewBinding.g.setBackgroundResource(R.drawable.img_live_fans_not_followed);
            layoutLiveUserFansViewBinding.c.setImageResource(R.drawable.img_live_fans_club_heart_bg);
            a("static");
        } else if (i != z) {
            FrameLayout flFollow3 = layoutLiveUserFansViewBinding.a;
            Intrinsics.c(flFollow3, "flFollow");
            BluedViewExKt.a(flFollow3);
        } else {
            this.c = true;
            FrameLayout flFollow4 = layoutLiveUserFansViewBinding.a;
            Intrinsics.c(flFollow4, "flFollow");
            BluedViewExKt.a(flFollow4);
            ShapeTextView liveFansDotTips2 = layoutLiveUserFansViewBinding.f;
            Intrinsics.c(liveFansDotTips2, "liveFansDotTips");
            BluedViewExKt.a((View) liveFansDotTips2);
            ShapeFrameLayout flLiveFans3 = layoutLiveUserFansViewBinding.b;
            Intrinsics.c(flLiveFans3, "flLiveFans");
            BluedViewExKt.b(flLiveFans3);
            layoutLiveUserFansViewBinding.g.setBackgroundResource(R.drawable.img_live_fans_followed);
            layoutLiveUserFansViewBinding.c.setImageResource(R.drawable.img_live_fans_club_heart_bg);
            a("static_join");
        }
    }

    public final void setHideAlphaValueAnimator(ValueAnimator valueAnimator) {
        this.i = valueAnimator;
    }

    public final void setHideInfoBgAlphaValueAnimator(ValueAnimator valueAnimator) {
        this.k = valueAnimator;
    }

    public final void setHideValueAnimator(ValueAnimator valueAnimator) {
        this.h = valueAnimator;
    }

    public final void setOpenAddFansAnimShow(boolean z2) {
        this.t = z2;
    }

    public final void setShowAnimation1(boolean z2) {
        this.p = z2;
    }

    public final void setShowAnimation2(boolean z2) {
        this.q = z2;
    }

    public final void setShowAnimation3(boolean z2) {
        this.r = z2;
    }

    public final void setShowClubOvershoot(boolean z2) {
        this.o = z2;
    }

    public final void setShowFansClubAnim(boolean z2) {
        this.u = z2;
    }

    public final void setShowHideAnimation(boolean z2) {
        this.s = z2;
    }

    public final void setStartFansClubAnchorBgListener(StartFansClubAnchorBgListener startFansClubAnchorBgListener) {
        Intrinsics.e(startFansClubAnchorBgListener, "startFansClubAnchorBgListener");
        this.v = startFansClubAnchorBgListener;
    }

    public final void setStartTime(long j) {
        this.n = j;
    }

    public final void setValueAnimator(ValueAnimator valueAnimator) {
        this.f = valueAnimator;
    }

    public final void setViewLifeCycle(LifecycleOwner lifecycleOwner) {
        Intrinsics.e(lifecycleOwner, "lifecycleOwner");
        this.e = lifecycleOwner;
    }

    public final void setZoomValueAnimatorH(ValueAnimator valueAnimator) {
        this.m = valueAnimator;
    }

    public final void setZoomValueAnimatorW(ValueAnimator valueAnimator) {
        this.l = valueAnimator;
    }
}
