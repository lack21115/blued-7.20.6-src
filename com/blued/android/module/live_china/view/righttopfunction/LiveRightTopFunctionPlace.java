package com.blued.android.module.live_china.view.righttopfunction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveRightTopFunctionPlaceBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftWallFloatModel;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.view.BluedViewExKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/righttopfunction/LiveRightTopFunctionPlace.class */
public final class LiveRightTopFunctionPlace extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15439a;
    private BaseFragment b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15440c;
    private final ArrayList<RightTopFunction> d;
    private View e;
    private ValueAnimator f;
    private final LiveRightTopFunctionPlaceBinding g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveRightTopFunctionPlace(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveRightTopFunctionPlace(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRightTopFunctionPlace(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.f15439a = mContext;
        this.f15440c = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        this.d = new ArrayList<>();
        LiveRightTopFunctionPlaceBinding a2 = LiveRightTopFunctionPlaceBinding.a(LayoutInflater.from(this.f15439a).inflate(R.layout.live_right_top_function_place, this));
        Intrinsics.c(a2, "bind(\n        LayoutInfl…nction_place, this)\n    )");
        this.g = a2;
        int childCount = a2.f12414a.getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            View childAt = this.g.f12414a.getChildAt(i3);
            if (childAt instanceof RightTopFunction) {
                this.d.add((RightTopFunction) childAt);
                BluedViewExKt.a(childAt);
            }
            i2 = i3 + 1;
        }
    }

    public /* synthetic */ LiveRightTopFunctionPlace(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.f42542a = this.g.f12414a.getWidth();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        View view = this.e;
        Intrinsics.a(view);
        floatRef2.f42542a = view.getLayoutParams().width;
        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
        floatRef3.f42542a = this.g.f12414a.getHeight();
        final Ref.FloatRef floatRef4 = new Ref.FloatRef();
        View view2 = this.e;
        if (view2 != null) {
            Intrinsics.a(view2);
            floatRef4.f42542a = view2.getLayoutParams().height + this.g.f12414a.getPaddingBottom();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f = ofFloat;
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveRightTopFunctionPlace$AKauXOKSBdpIhgPEo1M1_Q9m0xA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                LiveRightTopFunctionPlace.a(LiveRightTopFunctionPlace.this, floatRef, floatRef2, floatRef3, floatRef4, valueAnimator2);
            }
        });
        ofFloat.start();
    }

    private final void a(View view) {
        if (view instanceof RightTopFunction) {
            View view2 = this.e;
            if (view2 == null) {
                if (((RightTopFunction) view).a()) {
                    this.e = view;
                    view.setAlpha(1.0f);
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    a(true);
                }
            } else if (!Intrinsics.a(view2, view)) {
                RightTopFunction rightTopFunction = (RightTopFunction) view;
                if (rightTopFunction.a() && (this.e instanceof RightTopFunction)) {
                    int priority = rightTopFunction.getPriority();
                    View view3 = this.e;
                    if (view3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.view.righttopfunction.RightTopFunction");
                    }
                    if (priority > ((RightTopFunction) view3).getPriority()) {
                        b(view);
                    }
                }
            } else if (!((RightTopFunction) view).a()) {
                View view4 = null;
                for (RightTopFunction rightTopFunction2 : this.d) {
                    if (view4 == null && rightTopFunction2.a()) {
                        view4 = (View) rightTopFunction2;
                    }
                }
                if (view4 == null) {
                    a(false);
                } else {
                    b(view4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final View oldView, boolean z) {
        float width;
        float f;
        Intrinsics.e(oldView, "$oldView");
        if (z) {
            width = oldView.getWidth();
            f = 0.8f;
        } else {
            width = oldView.getWidth();
            f = 0.2f;
        }
        oldView.setPivotX(width * f);
        oldView.setPivotY(oldView.getHeight() / 2.0f);
        oldView.animate().alpha(0.0f).scaleX(0.6f).scaleY(0.6f).setDuration(500L).setInterpolator(new DecelerateInterpolator(1.5f)).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveRightTopFunctionPlace$uFhvtj8ait7vSCudObBQft73TWY
            @Override // java.lang.Runnable
            public final void run() {
                LiveRightTopFunctionPlace.c(View.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, boolean z, LiveRightTopFunctionPlace this$0) {
        Intrinsics.e(view, "$view");
        Intrinsics.e(this$0, "this$0");
        view.setTranslationX(z ? -this$0.getWidth() : this$0.getWidth());
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.animate().translationX(0.0f).setDuration(600L).setInterpolator(new DecelerateInterpolator(1.5f)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRightTopFunctionPlace this$0, Ref.FloatRef startHeight, Ref.FloatRef endHeight, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(startHeight, "$startHeight");
        Intrinsics.e(endHeight, "$endHeight");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.g.f12414a.getLayoutParams().height = (int) (startHeight.f42542a + ((endHeight.f42542a - startHeight.f42542a) * floatValue));
        this$0.g.f12414a.setLayoutParams(this$0.g.f12414a.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRightTopFunctionPlace this$0, Ref.FloatRef startWidth, Ref.FloatRef endWidth, Ref.FloatRef startHeight, Ref.FloatRef endHeight, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(startWidth, "$startWidth");
        Intrinsics.e(endWidth, "$endWidth");
        Intrinsics.e(startHeight, "$startHeight");
        Intrinsics.e(endHeight, "$endHeight");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.g.f12414a.getLayoutParams().width = (int) (startWidth.f42542a + ((endWidth.f42542a - startWidth.f42542a) * floatValue));
        this$0.g.f12414a.getLayoutParams().height = (int) (startHeight.f42542a + ((endHeight.f42542a - startHeight.f42542a) * floatValue));
        this$0.g.f12414a.setLayoutParams(this$0.g.f12414a.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveRightTopFunctionPlace this$0, boolean z, final Ref.FloatRef startHeight, final Ref.FloatRef endHeight) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(startHeight, "$startHeight");
        Intrinsics.e(endHeight, "$endHeight");
        ValueAnimator it = ValueAnimator.ofFloat(0.0f, 1.0f);
        this$0.f = it;
        it.setDuration(700L);
        it.setStartDelay(200L);
        it.setInterpolator(new DecelerateInterpolator(2.0f));
        it.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveRightTopFunctionPlace$Qmh6-xxwM4yMLFTZba_lobUyLtg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveRightTopFunctionPlace.a(LiveRightTopFunctionPlace.this, startHeight, endHeight, valueAnimator);
            }
        });
        if (!z) {
            Intrinsics.c(it, "it");
            it.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.righttopfunction.LiveRightTopFunctionPlace$showRoot$lambda-9$lambda-8$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    View view;
                    Intrinsics.e(animator, "animator");
                    view = LiveRightTopFunctionPlace.this.e;
                    if (view != null) {
                        BluedViewExKt.a(view);
                    }
                    LiveRightTopFunctionPlace.this.e = null;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }
            });
        }
        it.start();
    }

    private final void a(final boolean z) {
        View view;
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.f42542a = this.g.f12414a.getHeight();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        if (z && this.e != null) {
            floatRef.f42542a = 0.0f;
            View view2 = this.e;
            Intrinsics.a(view2);
            floatRef2.f42542a = view2.getLayoutParams().height + this.g.f12414a.getPaddingBottom();
        }
        this.g.f12414a.getLayoutParams().height = (int) floatRef.f42542a;
        this.g.f12414a.setLayoutParams(this.g.f12414a.getLayoutParams());
        if (z && (view = this.e) != null) {
            BluedViewExKt.b(view);
        }
        View view3 = this.e;
        if (view3 == null) {
            return;
        }
        view3.post(new Runnable() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveRightTopFunctionPlace$VTL-aJ-Q0U8B0voQxNq_-Ow94OQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveRightTopFunctionPlace.a(LiveRightTopFunctionPlace.this, z, floatRef, floatRef2);
            }
        });
    }

    private final void b(final View view) {
        final View view2 = this.e;
        if (view2 != null) {
            boolean z = ((RightTopFunction) view).getPriority() > ((RightTopFunction) view2).getPriority();
            final boolean z2 = z;
            view2.post(new Runnable() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveRightTopFunctionPlace$R2PizPU57Pz5mUi1UBCRMaRACb0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveRightTopFunctionPlace.a(View.this, z2);
                }
            });
            view.setAlpha(0.0f);
            BluedViewExKt.b(view);
            final boolean z3 = z;
            view.post(new Runnable() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveRightTopFunctionPlace$4El5rryx4qmldH6xN0qfMW95NjM
                @Override // java.lang.Runnable
                public final void run() {
                    LiveRightTopFunctionPlace.a(View.this, z3, this);
                }
            });
        }
        this.e = view;
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.blued.android.module.live_china.view.righttopfunction.-$$Lambda$LiveRightTopFunctionPlace$C3vv_x9O97EF4AQNrvfKvSKxZ6M
            @Override // java.lang.Runnable
            public final void run() {
                LiveRightTopFunctionPlace.b(LiveRightTopFunctionPlace.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveRightTopFunctionPlace this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View oldView) {
        Intrinsics.e(oldView, "$oldView");
        BluedViewExKt.a(oldView);
    }

    public final void a(LiveWishItemModel data) {
        Intrinsics.e(data, "data");
        this.g.f12415c.a(data);
    }

    public final Context getMContext() {
        return this.f15439a;
    }

    public final void setBaseFragment(BaseFragment baseFragment) {
        Intrinsics.e(baseFragment, "baseFragment");
        this.b = baseFragment;
        this.g.f12415c.setBaseFragment(baseFragment);
        this.g.b.setBaseFragment(baseFragment);
    }

    public final void setDataToGoodsWall(LiveGiftWallFloatModel liveGiftWallFloatModel) {
        this.g.b.setData(liveGiftWallFloatModel);
        LiveFloatGoodsWallView liveFloatGoodsWallView = this.g.b;
        Intrinsics.c(liveFloatGoodsWallView, "vb.liveGoodsWall");
        a(liveFloatGoodsWallView);
    }

    public final void setDataToWish(List<? extends LiveWishItemModel> list) {
        this.g.f12415c.setData(list);
        LiveWishView liveWishView = this.g.f12415c;
        Intrinsics.c(liveWishView, "vb.liveWishView");
        a(liveWishView);
    }
}
