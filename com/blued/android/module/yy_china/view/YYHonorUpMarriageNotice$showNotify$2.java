package com.blued.android.module.yy_china.view;

import android.animation.Animator;
import android.os.Handler;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHonorUpMarriageNotice$showNotify$2.class */
public final class YYHonorUpMarriageNotice$showNotify$2 implements Animator.AnimatorListener {
    final /* synthetic */ ActivityFragmentActive a;
    final /* synthetic */ YYHonorUpMarriageNotice b;
    final /* synthetic */ ViewGroup c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHonorUpMarriageNotice$showNotify$2(ActivityFragmentActive activityFragmentActive, YYHonorUpMarriageNotice yYHonorUpMarriageNotice, ViewGroup viewGroup) {
        this.a = activityFragmentActive;
        this.b = yYHonorUpMarriageNotice;
        this.c = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ActivityFragmentActive active, YYHonorUpMarriageNotice this$0, ViewGroup attachView) {
        Intrinsics.e(active, "$active");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(attachView, "$attachView");
        if (active.isActive()) {
            this$0.a(attachView);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        LogUtils.d("notice", "fly in animation ending ... ");
        Handler n = AppInfo.n();
        final ActivityFragmentActive activityFragmentActive = this.a;
        final YYHonorUpMarriageNotice yYHonorUpMarriageNotice = this.b;
        final ViewGroup viewGroup = this.c;
        n.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHonorUpMarriageNotice$showNotify$2$REzuW9DT7F74V7gAug1aGaZktn8
            @Override // java.lang.Runnable
            public final void run() {
                YYHonorUpMarriageNotice$showNotify$2.a(ActivityFragmentActive.this, yYHonorUpMarriageNotice, viewGroup);
            }
        }, 4000L);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
