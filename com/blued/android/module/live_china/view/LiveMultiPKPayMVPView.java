package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.databinding.LiveMultiPkPayMapViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.bytedance.applog.tracker.Tracker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPKPayMVPView.class */
public final class LiveMultiPKPayMVPView extends FrameLayout implements View.OnClickListener {
    private Context a;
    private boolean b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private float k;
    private final Lazy l;
    private Runnable m;
    private Runnable n;
    private ScaleAnimation o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKPayMVPView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKPayMVPView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKPayMVPView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.c = "";
        this.d = "";
        this.g = DensityUtils.a(getContext(), 125.0f);
        this.h = DensityUtils.a(getContext(), 125.0f);
        this.i = DensityUtils.a(getContext(), 125.0f);
        this.j = DensityUtils.a(getContext(), 125.0f);
        this.l = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMultiPkPayMapViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMultiPkPayMapViewBinding invoke() {
                return LiveMultiPkPayMapViewBinding.a(LayoutInflater.from(LiveMultiPKPayMVPView.this.getContext()), LiveMultiPKPayMVPView.this, true);
            }
        });
        this.m = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$i3_ZDhnAS1TrIX6sIikHwj9EoPY
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView.f(LiveMultiPKPayMVPView.this);
            }
        };
        this.n = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$JG5NJ2auX_-o26PWllq1N6SEJJo
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView.j(LiveMultiPKPayMVPView.this);
            }
        };
        this.a = context;
        a();
    }

    private final void a() {
    }

    private final void b() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.3f, 1.0f);
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starFirstPayAnimStep1$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LiveMultiPKPayMVPView.this.getViewBinding().a.setScaleX(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().a.setScaleY(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().a.setAlpha(Math.max(floatValue, 1.0f));
            }
        });
        ofFloat.start();
        getViewBinding().a.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$F87VtewIqBIVcBbjPPzUOi9bpSY
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView.g(LiveMultiPKPayMVPView.this);
            }
        }, 100L);
    }

    private final void c() {
        getViewBinding().d.setVisibility(0);
        ImageLoader.c(null, "live_first_pay_anim.png").e(getViewBinding().d.hashCode()).g(-1).a(getViewBinding().d);
        getViewBinding().d.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$pQrragOTjOT3EBfqxEJrDRqW1FI
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView.h(LiveMultiPKPayMVPView.this);
            }
        }, 1800L);
    }

    private final void d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 0.0f);
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starFirstPayAnimStep3$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LiveMultiPKPayMVPView.this.getViewBinding().a.setScaleX(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().a.setScaleY(floatValue);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starFirstPayAnimStep3$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveMultiPKPayMVPView.this.setAniming(false);
                LiveMultiPKPayMVPView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    private final void e() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.2f, 1.0f);
        ofFloat.setDuration(360L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starMVPAnimStep1$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LiveMultiPKPayMVPView.this.getViewBinding().b.setScaleX(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().b.setScaleY(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().b.setAlpha(Math.min(floatValue, 1.0f));
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starMVPAnimStep1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveMultiPKPayMVPView.this.g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
        getViewBinding().a.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$k3G7hBN8T-7FXumPcpHAkF1L0iA
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView.k(LiveMultiPKPayMVPView.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveMultiPKPayMVPView this$0) {
        int i;
        int i2;
        int i3;
        Intrinsics.e(this$0, "this$0");
        int measuredWidth = this$0.getViewBinding().c.getMeasuredWidth();
        int measuredHeight = this$0.getViewBinding().c.getMeasuredHeight();
        int i4 = this$0.e;
        int i5 = 0;
        if (i4 == 0) {
            if (this$0.f >= 4) {
                i5 = ((measuredWidth / 2) - this$0.g) / 2;
                i = ((measuredHeight / 2) - this$0.h) / 2;
            } else {
                i5 = ((measuredWidth / 2) - this$0.g) / 2;
                i = (measuredHeight - this$0.h) / 2;
            }
        } else if (i4 != 1) {
            if (i4 == 2) {
                if (this$0.f >= 4) {
                    i5 = ((measuredWidth / 2) - this$0.g) / 2;
                    i2 = measuredHeight / 2;
                    i3 = (i2 - this$0.h) / 2;
                } else {
                    int i6 = measuredWidth / 2;
                    i5 = ((i6 - this$0.g) / 2) + i6;
                    i2 = measuredHeight / 2;
                    i3 = (i2 - this$0.h) / 2;
                }
            } else if (i4 == 3) {
                int i7 = measuredWidth / 2;
                i5 = ((i7 - this$0.g) / 2) + i7;
                i2 = measuredHeight / 2;
                i3 = (i2 - this$0.h) / 2;
            } else {
                i = 0;
            }
            i = i3 + i2;
        } else if (this$0.f >= 3) {
            int i8 = measuredWidth / 2;
            i5 = ((i8 - this$0.g) / 2) + i8;
            i = ((measuredHeight / 2) - this$0.h) / 2;
        } else {
            int i9 = measuredWidth / 2;
            i5 = ((i9 - this$0.g) / 2) + i9;
            i = (measuredHeight - this$0.h) / 2;
        }
        this$0.getViewBinding().a.setTranslationX(i5 * 1.0f);
        this$0.getViewBinding().a.setTranslationY(i * 1.0f);
        this$0.b();
    }

    private final void f() {
        getViewBinding().f.setVisibility(0);
        SVGAPlayer.Builder a = new SVGAPlayer.Builder().a("live_mvp_anim_btm.svga").a((Integer) 0).a(SVGAImageView.FillMode.Clear).a((Boolean) true);
        SVGAImageView sVGAImageView = getViewBinding().f;
        Intrinsics.c(sVGAImageView, "viewBinding.ivMvpAnim1");
        a.a(sVGAImageView);
        getViewBinding().g.setVisibility(0);
        SVGAPlayer.Builder a2 = new SVGAPlayer.Builder().a("live_mvp_anim_top.svga").a((Integer) 0).a(SVGAImageView.FillMode.Clear).a((Boolean) true);
        SVGAImageView sVGAImageView2 = getViewBinding().g;
        Intrinsics.c(sVGAImageView2, "viewBinding.ivMvpAnim2");
        a2.a(sVGAImageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final LiveMultiPKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.setVisibility(0);
        this$0.getViewBinding().a.setVisibility(0);
        this$0.getViewBinding().b.setVisibility(8);
        this$0.getViewBinding().a.setAlpha(0.0f);
        if (TextUtils.isEmpty(this$0.c)) {
            this$0.c = "";
        }
        String str = this$0.c;
        Intrinsics.a((Object) str);
        ImageLoader.a((IRequestHost) null, str).a(40.0f).a(this$0.getViewBinding().i);
        this$0.getViewBinding().l.setText(this$0.d);
        this$0.getViewBinding().c.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$USwYwXKBMEkGeJ2wn9kTPHqoSgQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView.e(LiveMultiPKPayMVPView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        this.o = scaleAnimation;
        Intrinsics.a(scaleAnimation);
        scaleAnimation.setDuration(360L);
        ScaleAnimation scaleAnimation2 = this.o;
        Intrinsics.a(scaleAnimation2);
        scaleAnimation2.setFillAfter(true);
        ScaleAnimation scaleAnimation3 = this.o;
        Intrinsics.a(scaleAnimation3);
        scaleAnimation3.setRepeatMode(2);
        ScaleAnimation scaleAnimation4 = this.o;
        Intrinsics.a(scaleAnimation4);
        scaleAnimation4.setRepeatCount(4);
        ScaleAnimation scaleAnimation5 = this.o;
        Intrinsics.a(scaleAnimation5);
        scaleAnimation5.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$startMVPAnim3$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveMultiPKPayMVPView.this.h();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        getViewBinding().b.clearAnimation();
        getViewBinding().b.startAnimation(this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LiveMultiPKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 0.5f);
        ofFloat.setDuration(600L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starMVPAnimStep4$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LiveMultiPKPayMVPView.this.getViewBinding().b.setScaleX(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().b.setScaleY(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().b.setAlpha((Math.min(floatValue, 1.0f) - 0.5f) / 0.5f);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starMVPAnimStep4$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveMultiPKPayMVPView.this.i();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LiveMultiPKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.getViewBinding().d.setVisibility(8);
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        getViewBinding().b.setScaleX(0.0f);
        getViewBinding().b.setScaleY(0.0f);
        getViewBinding().b.setX(-((float) (this.g * 0.1d)));
        getViewBinding().b.setY(-((float) (this.g * 0.1d)));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.5f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starMVPAnimStep5$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LiveMultiPKPayMVPView.this.getViewBinding().b.setScaleX(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().b.setScaleY(floatValue);
                LiveMultiPKPayMVPView.this.getViewBinding().b.setAlpha((floatValue / 0.5f) * 1);
            }
        });
        ofFloat.addListener(new LiveMultiPKPayMVPView$starMVPAnimStep5$2(this));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LiveMultiPKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        int measuredWidth = this$0.getViewBinding().c.getMeasuredWidth();
        int measuredHeight = this$0.getViewBinding().c.getMeasuredHeight();
        float f = (measuredWidth - this$0.g) / 2;
        float f2 = (measuredHeight - this$0.h) / 2;
        this$0.getViewBinding().b.setX(f);
        this$0.getViewBinding().b.setY(f2);
        this$0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starMVPAnimStep6$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                LiveMultiPKPayMVPView.this.getViewBinding().b.setAlpha(((Float) animatedValue).floatValue());
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKPayMVPView$starMVPAnimStep6$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveMultiPKPayMVPView.this.setAniming(false);
                LiveMultiPKPayMVPView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final LiveMultiPKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.b = true;
        this$0.setVisibility(0);
        this$0.getViewBinding().a.setVisibility(8);
        this$0.getViewBinding().b.setVisibility(0);
        this$0.getViewBinding().b.setAlpha(0.0f);
        if (TextUtils.isEmpty(this$0.c)) {
            this$0.c = "";
        }
        String str = this$0.c;
        Intrinsics.a((Object) str);
        ImageLoader.a((IRequestHost) null, str).a(40.0f).a(this$0.getViewBinding().h);
        this$0.getViewBinding().k.setText(this$0.d);
        this$0.getViewBinding().c.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$Tcm_OvBj_5AXnVVy0e6D_AbTHtU
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView.i(LiveMultiPKPayMVPView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LiveMultiPKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    public final void a(int i, int i2, String str, String str2) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.c = str2;
        this.d = str;
        this.e = i;
        this.f = i2;
        post(this.m);
    }

    public final void a(String str, String str2) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.c = str2;
        this.d = str;
        postDelayed(this.n, 500L);
    }

    public final boolean getAniming() {
        return this.b;
    }

    public final String getAvatar() {
        return this.c;
    }

    public final int getIconHeight() {
        return this.h;
    }

    public final int getIconWidth() {
        return this.g;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final int getMvpHeight() {
        return this.j;
    }

    public final int getMvpWidth() {
        return this.i;
    }

    public final String getName() {
        return this.d;
    }

    public final int getPosition() {
        return this.e;
    }

    public final Runnable getRunnableFirstPay() {
        return this.m;
    }

    public final Runnable getRunnableMVP() {
        return this.n;
    }

    public final float getScale() {
        return this.k;
    }

    public final ScaleAnimation getScaleAnimation() {
        return this.o;
    }

    public final int getTotalNum() {
        return this.f;
    }

    public final LiveMultiPkPayMapViewBinding getViewBinding() {
        return (LiveMultiPkPayMapViewBinding) this.l.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        setVisibility(8);
        removeCallbacks(this.m);
        removeCallbacks(this.n);
    }

    public final void setAniming(boolean z) {
        this.b = z;
    }

    public final void setAvatar(String str) {
        this.c = str;
    }

    public final void setIconHeight(int i) {
        this.h = i;
    }

    public final void setIconWidth(int i) {
        this.g = i;
    }

    public final void setMContext(Context context) {
        this.a = context;
    }

    public final void setMvpHeight(int i) {
        this.j = i;
    }

    public final void setMvpWidth(int i) {
        this.i = i;
    }

    public final void setName(String str) {
        this.d = str;
    }

    public final void setPosition(int i) {
        this.e = i;
    }

    public final void setRunnableFirstPay(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.m = runnable;
    }

    public final void setRunnableMVP(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.n = runnable;
    }

    public final void setScale(float f) {
        this.k = f;
    }

    public final void setScaleAnimation(ScaleAnimation scaleAnimation) {
        this.o = scaleAnimation;
    }

    public final void setTotalNum(int i) {
        this.f = i;
    }
}
