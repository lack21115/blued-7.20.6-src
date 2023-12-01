package com.blued.community.view;

import android.animation.Animator;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.view.CommonFloatBottomView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommonFloatBottomView$playImageButtonClickAnimator$3.class */
public final class CommonFloatBottomView$playImageButtonClickAnimator$3 implements Animator.AnimatorListener {
    final /* synthetic */ CommonFloatBottomView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonFloatBottomView$playImageButtonClickAnimator$3(CommonFloatBottomView commonFloatBottomView) {
        this.this$0 = commonFloatBottomView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onAnimationEnd$lambda-0  reason: not valid java name */
    public static final void m5146onAnimationEnd$lambda0(CommonFloatBottomView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.onClickContent();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.e(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        CommonFloatBottomView.OnBtnClickListener onBtnClickListener;
        FrameLayout frameLayout;
        Intrinsics.e(animation, "animation");
        onBtnClickListener = this.this$0.onBtnClickListener;
        if (onBtnClickListener != null) {
            onBtnClickListener.onClick();
        }
        frameLayout = this.this$0.contentView;
        if (frameLayout == null) {
            return;
        }
        final CommonFloatBottomView commonFloatBottomView = this.this$0;
        frameLayout.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$CommonFloatBottomView$playImageButtonClickAnimator$3$SffABqADUcAnLzFytY0TZhzltn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonFloatBottomView$playImageButtonClickAnimator$3.m5146onAnimationEnd$lambda0(CommonFloatBottomView.this, view);
            }
        }));
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.e(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        FrameLayout frameLayout;
        Intrinsics.e(animation, "animation");
        frameLayout = this.this$0.contentView;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setOnClickListener(null);
    }
}
