package com.blued.community.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommonFloatBottomView.class */
public final class CommonFloatBottomView extends FrameLayout {
    private final int ANIM_TIME;
    private BtnAnimatorUpdateListener btnAnimatorUpdateListener;
    private FrameLayout contentView;
    private int hideHeight;
    private boolean isPostBtnShowed;
    private OnBtnClickListener onBtnClickListener;

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommonFloatBottomView$BtnAnimatorUpdateListener.class */
    public interface BtnAnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommonFloatBottomView$OnBtnClickListener.class */
    public interface OnBtnClickListener {
        void onClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonFloatBottomView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
        initView();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonFloatBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonFloatBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.ANIM_TIME = 450;
        this.isPostBtnShowed = true;
        this.hideHeight = DisplayUtil.a(getContext(), 150.0f);
        initView();
    }

    private final void initView() {
        FrameLayout frameLayout = (FrameLayout) FrameLayout.inflate(getContext(), R.layout.common_float_bottom_layout, this);
        this.contentView = frameLayout;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setOnClickListener((View.OnClickListener) new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$CommonFloatBottomView$rLo6jh5cVYh7hnisKhDaOm2oXjc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonFloatBottomView.m2055initView$lambda0(CommonFloatBottomView.this, view);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m2055initView$lambda0(CommonFloatBottomView commonFloatBottomView, View view) {
        Intrinsics.e(commonFloatBottomView, "this$0");
        commonFloatBottomView.onClickContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickContent() {
        playImageButtonClickAnimator();
    }

    private final void playImageButtonClickAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.7f);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.-$$Lambda$CommonFloatBottomView$IbZnt168LEHess1K0gGOddqJD-M
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CommonFloatBottomView.m2057playImageButtonClickAnimator$lambda2(CommonFloatBottomView.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(0.7f, 1.0f);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.-$$Lambda$CommonFloatBottomView$ypfZCIJn226Aq34Ns4cYdahnBzc
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CommonFloatBottomView.m2058playImageButtonClickAnimator$lambda3(CommonFloatBottomView.this, valueAnimator);
            }
        });
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.addListener(new CommonFloatBottomView$playImageButtonClickAnimator$3(this));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: playImageButtonClickAnimator$lambda-2  reason: not valid java name */
    public static final void m2057playImageButtonClickAnimator$lambda2(CommonFloatBottomView commonFloatBottomView, ValueAnimator valueAnimator) {
        Intrinsics.e(commonFloatBottomView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        FrameLayout frameLayout = commonFloatBottomView.contentView;
        if (frameLayout != null) {
            frameLayout.setScaleX(floatValue);
        }
        FrameLayout frameLayout2 = commonFloatBottomView.contentView;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: playImageButtonClickAnimator$lambda-3  reason: not valid java name */
    public static final void m2058playImageButtonClickAnimator$lambda3(CommonFloatBottomView commonFloatBottomView, ValueAnimator valueAnimator) {
        Intrinsics.e(commonFloatBottomView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        FrameLayout frameLayout = commonFloatBottomView.contentView;
        if (frameLayout != null) {
            frameLayout.setScaleX(floatValue);
        }
        FrameLayout frameLayout2 = commonFloatBottomView.contentView;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.setScaleY(floatValue);
    }

    private final void startBtmBtnHideAnim() {
        final FrameLayout frameLayout = this.contentView;
        if (frameLayout == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 2.0f);
        translateAnimation.setDuration(this.ANIM_TIME);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.community.view.CommonFloatBottomView$startBtmBtnHideAnim$1$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                frameLayout.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        frameLayout.startAnimation(translateAnimation);
    }

    private final void startBtmBtnShowAnim() {
        final FrameLayout frameLayout = this.contentView;
        if (frameLayout == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 2.0f, 1, 0.0f);
        translateAnimation.setDuration(this.ANIM_TIME);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.community.view.CommonFloatBottomView$startBtmBtnShowAnim$1$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                frameLayout.setVisibility(0);
            }
        });
        frameLayout.startAnimation(translateAnimation);
    }

    public final void addChildView(View view) {
        FrameLayout frameLayout = this.contentView;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        if (view == null) {
            return;
        }
        new FrameLayout.LayoutParams(-2, -2).gravity = 17;
        FrameLayout frameLayout2 = this.contentView;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.addView(view);
    }

    public final void setBtnAnimatorUpdateListener(BtnAnimatorUpdateListener btnAnimatorUpdateListener) {
        this.btnAnimatorUpdateListener = btnAnimatorUpdateListener;
    }

    public final void setBtnEnabled(boolean z) {
        FrameLayout frameLayout = this.contentView;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setEnabled(z);
    }

    public final void setHideHeight(int i) {
        this.hideHeight = i;
    }

    public final void setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
        this.onBtnClickListener = onBtnClickListener;
    }

    public final void startBtmBtnHide() {
        if (this.isPostBtnShowed) {
            this.isPostBtnShowed = false;
            startBtmBtnHideAnim();
        }
    }

    public final void startBtmBtnShow() {
        if (this.isPostBtnShowed) {
            return;
        }
        this.isPostBtnShowed = true;
        startBtmBtnShowAnim();
    }
}
