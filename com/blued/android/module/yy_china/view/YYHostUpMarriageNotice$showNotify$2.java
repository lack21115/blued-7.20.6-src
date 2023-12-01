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
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYHostUpMarriageNotice$showNotify$2.class */
public final class YYHostUpMarriageNotice$showNotify$2 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivityFragmentActive f18251a;
    final /* synthetic */ YYHostUpMarriageNotice b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewGroup f18252c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHostUpMarriageNotice$showNotify$2(ActivityFragmentActive activityFragmentActive, YYHostUpMarriageNotice yYHostUpMarriageNotice, ViewGroup viewGroup) {
        this.f18251a = activityFragmentActive;
        this.b = yYHostUpMarriageNotice;
        this.f18252c = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ActivityFragmentActive active, YYHostUpMarriageNotice this$0, ViewGroup attachView) {
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
        final ActivityFragmentActive activityFragmentActive = this.f18251a;
        final YYHostUpMarriageNotice yYHostUpMarriageNotice = this.b;
        final ViewGroup viewGroup = this.f18252c;
        n.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYHostUpMarriageNotice$showNotify$2$1CLSQZu0qsVUFyFFY8Qonl_luRk
            @Override // java.lang.Runnable
            public final void run() {
                YYHostUpMarriageNotice$showNotify$2.a(ActivityFragmentActive.this, yYHostUpMarriageNotice, viewGroup);
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
