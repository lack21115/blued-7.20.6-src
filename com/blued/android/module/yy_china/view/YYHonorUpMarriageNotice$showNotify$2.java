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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityFragmentActive f18239a;
    final /* synthetic */ YYHonorUpMarriageNotice b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewGroup f18240c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHonorUpMarriageNotice$showNotify$2(ActivityFragmentActive activityFragmentActive, YYHonorUpMarriageNotice yYHonorUpMarriageNotice, ViewGroup viewGroup) {
        this.f18239a = activityFragmentActive;
        this.b = yYHonorUpMarriageNotice;
        this.f18240c = viewGroup;
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
        final ActivityFragmentActive activityFragmentActive = this.f18239a;
        final YYHonorUpMarriageNotice yYHonorUpMarriageNotice = this.b;
        final ViewGroup viewGroup = this.f18240c;
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
