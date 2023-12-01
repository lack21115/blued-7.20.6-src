package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.os.Handler;
import com.blued.android.core.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPKPayMVPView$starMVPAnimStep5$2.class */
public final class LiveMultiPKPayMVPView$starMVPAnimStep5$2 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveMultiPKPayMVPView f14658a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveMultiPKPayMVPView$starMVPAnimStep5$2(LiveMultiPKPayMVPView liveMultiPKPayMVPView) {
        this.f14658a = liveMultiPKPayMVPView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMultiPKPayMVPView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Handler n = AppInfo.n();
        final LiveMultiPKPayMVPView liveMultiPKPayMVPView = this.f14658a;
        n.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKPayMVPView$starMVPAnimStep5$2$LGDh1cAeHmYPH1HrIdvjBKIxiqo
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKPayMVPView$starMVPAnimStep5$2.a(LiveMultiPKPayMVPView.this);
            }
        }, 1000L);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
