package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveMultiPkResultBinding;
import com.blued.android.module.live_china.view.LiveMultiPKResult;
import com.bytedance.applog.tracker.Tracker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPKResult.class */
public final class LiveMultiPKResult extends FrameLayout implements View.OnClickListener {
    private Context a;
    private boolean b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private final Lazy i;
    private Runnable j;
    private EventCallBack k;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPKResult$EventCallBack.class */
    public interface EventCallBack {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKResult(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKResult(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKResult(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f = DensityUtils.a(getContext(), 140.0f);
        this.g = DensityUtils.a(getContext(), 140.0f);
        this.h = 0.6f;
        this.i = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMultiPkResultBinding>() { // from class: com.blued.android.module.live_china.view.LiveMultiPKResult$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMultiPkResultBinding invoke() {
                return LiveMultiPkResultBinding.a(LayoutInflater.from(LiveMultiPKResult.this.getContext()), LiveMultiPKResult.this, true);
            }
        });
        this.j = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKResult$S7hbE4W7mePJFVW3xjiE4SgZxwQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKResult.b(LiveMultiPKResult.this);
            }
        };
        this.a = context;
        b();
    }

    private final void b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, android.view.ViewTreeObserver] */
    public static final void b(final LiveMultiPKResult this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(false);
        this$0.clearAnimation();
        this$0.startAnimation(alphaAnimation);
        this$0.setVisibility(0);
        this$0.getViewBinding().b.setVisibility(8);
        this$0.getViewBinding().c.setVisibility(8);
        this$0.getViewBinding().a.setVisibility(8);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = this$0.getViewBinding().b.getViewTreeObserver();
        ((ViewTreeObserver) objectRef.a).addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKResult$runnable$1$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                objectRef.a.removeGlobalOnLayoutListener(this);
                int width = this$0.getWidth();
                int height = this$0.getHeight();
                float iconWidth = (width - this$0.getIconWidth()) / 2;
                float iconHeight = (height - this$0.getIconHeight()) / 2;
                this$0.getViewBinding().b.setX(iconWidth);
                this$0.getViewBinding().b.setY(iconHeight);
                if (this$0.getResult() == 3) {
                    this$0.getViewBinding().b.setImageResource(R.drawable.live_multi_pk_draw);
                    this$0.getViewBinding().a.setVisibility(8);
                } else if (this$0.getResult() == 1) {
                    this$0.getViewBinding().b.setImageResource(R.drawable.live_multi_pk_fail);
                    this$0.getViewBinding().a.setVisibility(8);
                } else {
                    this$0.getViewBinding().b.setImageResource(R.drawable.live_multi_pk_win);
                    this$0.getViewBinding().a.setVisibility(0);
                }
                this$0.getViewBinding().b.setVisibility(0);
                this$0.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        getViewBinding().b.setScaleX(1.0f);
        getViewBinding().b.setScaleY(1.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.3f, 1.0f);
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKResult$scaleAnimView$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LiveMultiPKResult.this.getViewBinding().b.setScaleX(floatValue);
                LiveMultiPKResult.this.getViewBinding().b.setScaleY(floatValue);
            }
        });
        ofFloat.start();
        getViewBinding().b.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKResult$eKb4fChEQG02aM851SwdagpzKIc
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKResult.c(LiveMultiPKResult.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveMultiPKResult this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    private final void d() {
        int i = this.c;
        if (i == 3 || i == 1) {
            getViewBinding().a.setVisibility(8);
            getViewBinding().c.setVisibility(8);
            getViewBinding().a.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKResult$svSbviyoqUVoz-GYkx6R_WjbIZI
                @Override // java.lang.Runnable
                public final void run() {
                    LiveMultiPKResult.d(LiveMultiPKResult.this);
                }
            }, 1800L);
            return;
        }
        getViewBinding().c.setVisibility(0);
        ImageLoader.c(null, "live_multi_pk_win_star.png").e(((int) System.currentTimeMillis()) / 1000).g(-1).a(getViewBinding().c);
        getViewBinding().a.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKResult$pCLLQgULv7VjfljSkPOuUpBl1qU
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKResult.e(LiveMultiPKResult.this);
            }
        }, 1800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveMultiPKResult this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.e) {
            this$0.f();
        } else {
            this$0.e();
        }
    }

    private final void e() {
        getWidth();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = this.d == 4 ? getHeight() / 2 : getHeight();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.a = getViewBinding().b.getX();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        floatRef2.a = getViewBinding().b.getY();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.a = DensityUtils.a(getContext(), 3.0f);
        final Ref.IntRef intRef3 = new Ref.IntRef();
        intRef3.a = DensityUtils.a(getContext(), 27.5f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKResult$translateAnim$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveMultiPKResult.this.setAniming(false);
                if (LiveMultiPKResult.this.getCallBack() != null) {
                    LiveMultiPKResult.EventCallBack callBack = LiveMultiPKResult.this.getCallBack();
                    Intrinsics.a(callBack);
                    callBack.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.setDuration(600L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKResult$translateAnim$2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                float f = 2;
                LiveMultiPKResult.this.getViewBinding().b.setX(floatRef.a + (((intRef2.a - floatRef.a) - ((LiveMultiPKResult.this.getScale() * LiveMultiPKResult.this.getIconWidth()) / f)) * floatValue));
                LiveMultiPKResult.this.getViewBinding().b.setY(floatRef2.a + (((((intRef.a - intRef3.a) - LiveMultiPKResult.this.getIconHeight()) + ((LiveMultiPKResult.this.getScale() * LiveMultiPKResult.this.getIconHeight()) / f)) - floatRef2.a) * floatValue));
                float f2 = 1;
                LiveMultiPKResult.this.getViewBinding().b.setScaleX(f2 - (LiveMultiPKResult.this.getScale() * floatValue));
                LiveMultiPKResult.this.getViewBinding().b.setScaleY(f2 - (floatValue * LiveMultiPKResult.this.getScale()));
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveMultiPKResult this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.getViewBinding().a.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(80L);
        alphaAnimation.setFillAfter(false);
        this$0.getViewBinding().a.clearAnimation();
        this$0.getViewBinding().a.startAnimation(alphaAnimation);
        this$0.getViewBinding().a.setVisibility(8);
        this$0.getViewBinding().c.setVisibility(8);
        if (this$0.e) {
            this$0.f();
        } else {
            this$0.e();
        }
    }

    private final void f() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.3f, 0.0f);
        ofFloat.setDuration(360L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKResult$animDismiss$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                float floatValue = ((Float) animatedValue).floatValue();
                LiveMultiPKResult.this.getViewBinding().b.setScaleX(floatValue);
                LiveMultiPKResult.this.getViewBinding().b.setScaleY(floatValue);
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKResult$animDismiss$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveMultiPKResult.this.setAniming(false);
                LiveMultiPKResult.this.setVisibility(8);
                if (LiveMultiPKResult.this.getCallBack() != null) {
                    LiveMultiPKResult.EventCallBack callBack = LiveMultiPKResult.this.getCallBack();
                    Intrinsics.a(callBack);
                    callBack.a();
                }
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

    public final void a() {
        this.b = false;
        this.k = null;
        removeCallbacks(this.j);
        setVisibility(8);
    }

    public final void a(int i, int i2, boolean z) {
        Log.i("==xpm", "result:" + i + " anim:" + this.b);
        if (this.b) {
            return;
        }
        this.b = true;
        this.c = i;
        this.e = z;
        this.d = i2;
        post(this.j);
    }

    public final boolean getAniming() {
        return this.b;
    }

    public final EventCallBack getCallBack() {
        return this.k;
    }

    public final boolean getGroup() {
        return this.e;
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

    public final int getPlaySize() {
        return this.d;
    }

    public final int getResult() {
        return this.c;
    }

    public final Runnable getRunnable() {
        return this.j;
    }

    public final float getScale() {
        return this.h;
    }

    public final LiveMultiPkResultBinding getViewBinding() {
        return (LiveMultiPkResultBinding) this.i.getValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibility(8);
        removeCallbacks(this.j);
    }

    public final void setAniming(boolean z) {
        this.b = z;
    }

    public final void setCallBack(EventCallBack eventCallBack) {
        this.k = eventCallBack;
    }

    public final void setEventCallback(EventCallBack eventCallBack) {
        this.k = eventCallBack;
    }

    public final void setGroup(boolean z) {
        this.e = z;
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

    public final void setPlaySize(int i) {
        this.d = i;
    }

    public final void setResult(int i) {
        this.c = i;
    }

    public final void setRunnable(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.j = runnable;
    }

    public final void setScale(float f) {
        this.h = f;
    }
}
