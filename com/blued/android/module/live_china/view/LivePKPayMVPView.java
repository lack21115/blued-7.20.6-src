package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePkPayMapViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.bytedance.applog.tracker.Tracker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKPayMVPView.class */
public final class LivePKPayMVPView extends FrameLayout implements View.OnClickListener {
    private Context a;
    private boolean b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private float h;
    private final Lazy i;
    private Runnable j;
    private Runnable k;
    private ScaleAnimation l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePKPayMVPView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePKPayMVPView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePKPayMVPView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.c = "";
        this.d = "";
        this.f = DensityUtils.a(getContext(), 125.0f);
        this.g = DensityUtils.a(getContext(), 125.0f);
        this.i = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LivePkPayMapViewBinding>() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LivePkPayMapViewBinding invoke() {
                return LivePkPayMapViewBinding.a(LayoutInflater.from(LivePKPayMVPView.this.getContext()), LivePKPayMVPView.this, true);
            }
        });
        this.j = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKPayMVPView$q_GYmIluTrf6J23lILfEYUOmOk4
            @Override // java.lang.Runnable
            public final void run() {
                LivePKPayMVPView.e(LivePKPayMVPView.this);
            }
        };
        this.k = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKPayMVPView$k4NJNgh8lr6GWKdFUBw8iFHD6N8
            @Override // java.lang.Runnable
            public final void run() {
                LivePKPayMVPView.h(LivePKPayMVPView.this);
            }
        };
        this.a = context;
        b();
    }

    private final void b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        getViewBinding().a.setScaleX(1.0f);
        getViewBinding().a.setScaleY(1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.3f, 1.0f);
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$starFirstPayAnimStep1$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LivePKPayMVPView.this.getViewBinding().a.setScaleX(floatValue);
                LivePKPayMVPView.this.getViewBinding().a.setScaleY(floatValue);
                LivePKPayMVPView.this.getViewBinding().a.setAlpha(Math.max(floatValue, 1.0f));
            }
        });
        ofFloat.start();
        getViewBinding().a.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKPayMVPView$-nImQ8ilucMYuKmrjwcAr7JT5J8
            @Override // java.lang.Runnable
            public final void run() {
                LivePKPayMVPView.f(LivePKPayMVPView.this);
            }
        }, 100L);
    }

    private final void d() {
        getViewBinding().d.setVisibility(0);
        ImageLoader.c(null, "live_first_pay_anim.png").e(getViewBinding().d.hashCode()).g(-1).a(getViewBinding().d);
        getViewBinding().d.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKPayMVPView$Y7yW2ciOzSvcRt2PO0PzxTz1KRY
            @Override // java.lang.Runnable
            public final void run() {
                LivePKPayMVPView.g(LivePKPayMVPView.this);
            }
        }, 1800L);
    }

    private final void e() {
        int width = getViewBinding().c.getWidth();
        int height = getViewBinding().c.getHeight();
        float x = getViewBinding().a.getX();
        float y = getViewBinding().a.getY();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$starFirstPayAnimStep3$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                float f = 1 - floatValue;
                LivePKPayMVPView.this.getViewBinding().a.setScaleX(f);
                LivePKPayMVPView.this.getViewBinding().a.setScaleY(f);
                LivePKPayMVPView.this.getViewBinding().a.setAlpha(f);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$starFirstPayAnimStep3$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKPayMVPView.this.setAniming(false);
                LivePKPayMVPView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getViewBinding().a, "translationX", this.e == 0 ? (-x) * 2 : width - x);
        Intrinsics.c(ofFloat2, "ofFloat(viewBinding.flFi…ranslationX\", translateX)");
        ofFloat2.setDuration(600L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(getViewBinding().a, "translationY", (height - y) * 2);
        Intrinsics.c(ofFloat3, "ofFloat(viewBinding.flFi…entHeight-myIconTop) * 2)");
        ofFloat3.setDuration(600L);
        ofFloat3.setInterpolator(new AccelerateInterpolator(1.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat2).with(ofFloat3);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v30, types: [T, android.view.ViewTreeObserver] */
    public static final void e(final LivePKPayMVPView this$0) {
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
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.H = DensityUtils.a(this$0.getContext(), 23.5f);
        if (this$0.e == 0) {
            this$0.getViewBinding().e.setImageResource(R.drawable.live_pk_pay_first_my_bg);
            shapeModel.t = ContextCompat.getColor(this$0.getContext(), R.color.syc_dark_6C99FF);
            shapeModel.v = ContextCompat.getColor(this$0.getContext(), R.color.syc_dark_457EFF);
        } else {
            this$0.getViewBinding().e.setImageResource(R.drawable.live_pk_pay_first_you_bg);
            shapeModel.t = ContextCompat.getColor(this$0.getContext(), R.color.syc_dark_EA35BA);
            shapeModel.v = ContextCompat.getColor(this$0.getContext(), R.color.syc_dark_FC87BA);
        }
        this$0.getViewBinding().j.setShapeModel(shapeModel);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = this$0.getViewBinding().c.getViewTreeObserver();
        ((ViewTreeObserver) objectRef.a).addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$runnableFirstPay$1$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                objectRef.a.removeGlobalOnLayoutListener(this);
                int width = this$0.getViewBinding().c.getWidth();
                this$0.getViewBinding().c.getHeight();
                float iconWidth = (width - this$0.getIconWidth()) / 2;
                int a = DensityUtils.a(this$0.getContext(), 25.0f);
                this$0.getViewBinding().a.setX(iconWidth);
                this$0.getViewBinding().a.setY(a);
                this$0.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        getViewBinding().b.setScaleX(1.0f);
        getViewBinding().b.setScaleY(1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.2f, 1.0f);
        ofFloat.setDuration(360L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$starMVPAnimStep1$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LivePKPayMVPView.this.getViewBinding().b.setScaleX(floatValue);
                LivePKPayMVPView.this.getViewBinding().b.setScaleY(floatValue);
                LivePKPayMVPView.this.getViewBinding().b.setAlpha(Math.max(floatValue, 1.0f));
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$starMVPAnimStep1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKPayMVPView.this.h();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
        getViewBinding().a.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKPayMVPView$PtVrHzpNvvwh9nT7VNnTo7K6kSs
            @Override // java.lang.Runnable
            public final void run() {
                LivePKPayMVPView.i(LivePKPayMVPView.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LivePKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    private final void g() {
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
    public static final void g(LivePKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.getViewBinding().d.setVisibility(8);
        this$0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        this.l = scaleAnimation;
        Intrinsics.a(scaleAnimation);
        scaleAnimation.setDuration(360L);
        ScaleAnimation scaleAnimation2 = this.l;
        Intrinsics.a(scaleAnimation2);
        scaleAnimation2.setFillAfter(true);
        ScaleAnimation scaleAnimation3 = this.l;
        Intrinsics.a(scaleAnimation3);
        scaleAnimation3.setRepeatMode(2);
        ScaleAnimation scaleAnimation4 = this.l;
        Intrinsics.a(scaleAnimation4);
        scaleAnimation4.setRepeatCount(4);
        ScaleAnimation scaleAnimation5 = this.l;
        Intrinsics.a(scaleAnimation5);
        scaleAnimation5.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$startMVPAnim3$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivePKPayMVPView.this.i();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        getViewBinding().b.clearAnimation();
        getViewBinding().b.startAnimation(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, android.view.ViewTreeObserver] */
    public static final void h(final LivePKPayMVPView this$0) {
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
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = this$0.getViewBinding().c.getViewTreeObserver();
        ((ViewTreeObserver) objectRef.a).addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$runnableMVP$1$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                objectRef.a.removeGlobalOnLayoutListener(this);
                int width = this$0.getViewBinding().c.getWidth();
                int height = this$0.getViewBinding().c.getHeight();
                float iconWidth = (width - this$0.getIconWidth()) / 2;
                float iconHeight = (height - this$0.getIconHeight()) / 2;
                this$0.getViewBinding().b.setX(iconWidth);
                this$0.getViewBinding().b.setY(iconHeight);
                this$0.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 0.5f);
        ofFloat.setDuration(600L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$starMVPAnimStep4$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LivePKPayMVPView.this.getViewBinding().b.setScaleX(floatValue);
                LivePKPayMVPView.this.getViewBinding().b.setScaleY(floatValue);
                LivePKPayMVPView.this.getViewBinding().b.setAlpha((Math.min(floatValue, 1.0f) - 0.5f) / 0.5f);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LivePKPayMVPView$starMVPAnimStep4$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LivePKPayMVPView.this.setAniming(false);
                LivePKPayMVPView.this.setVisibility(8);
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
    public static final void i(LivePKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.g();
    }

    public final void a() {
        this.b = false;
        removeCallbacks(this.j);
        removeCallbacks(this.k);
        setVisibility(8);
    }

    public final void a(int i, String str, String str2) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.c = str2;
        this.d = str;
        this.e = i;
        post(this.j);
    }

    public final void a(String str, String str2) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.c = str2;
        this.d = str;
        post(this.k);
    }

    public final boolean getAniming() {
        return this.b;
    }

    public final String getAvatar() {
        return this.c;
    }

    public final int getIconHeight() {
        return this.g;
    }

    public final int getIconWidth() {
        return this.f;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final String getName() {
        return this.d;
    }

    public final int getResult() {
        return this.e;
    }

    public final Runnable getRunnableFirstPay() {
        return this.j;
    }

    public final Runnable getRunnableMVP() {
        return this.k;
    }

    public final float getScale() {
        return this.h;
    }

    public final ScaleAnimation getScaleAnimation() {
        return this.l;
    }

    public final LivePkPayMapViewBinding getViewBinding() {
        return (LivePkPayMapViewBinding) this.i.getValue();
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
        removeCallbacks(this.j);
        removeCallbacks(this.k);
    }

    public final void setAniming(boolean z) {
        this.b = z;
    }

    public final void setAvatar(String str) {
        this.c = str;
    }

    public final void setIconHeight(int i) {
        this.g = i;
    }

    public final void setIconWidth(int i) {
        this.f = i;
    }

    public final void setMContext(Context context) {
        this.a = context;
    }

    public final void setName(String str) {
        this.d = str;
    }

    public final void setResult(int i) {
        this.e = i;
    }

    public final void setRunnableFirstPay(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.j = runnable;
    }

    public final void setRunnableMVP(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.k = runnable;
    }

    public final void setScale(float f) {
        this.h = f;
    }

    public final void setScaleAnimation(ScaleAnimation scaleAnimation) {
        this.l = scaleAnimation;
    }
}
