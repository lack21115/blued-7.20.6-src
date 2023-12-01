package com.blued.android.module.live_china.view.operation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.databinding.LiveOperationViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/LiveOperationView$startShowDesc$1$1.class */
public final class LiveOperationView$startShowDesc$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ LiveOperationView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveOperationView$startShowDesc$1$1(LiveOperationView liveOperationView) {
        this.a = liveOperationView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOperationView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LiveOperationView this$0) {
        long j;
        Intrinsics.e(this$0, "this$0");
        Handler n = AppInfo.n();
        Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationView$startShowDesc$1$1$p9wdPdTtX2gEi0Ew49MK-fNG44I
            @Override // java.lang.Runnable
            public final void run() {
                LiveOperationView$startShowDesc$1$1.a(LiveOperationView.this);
            }
        };
        j = this$0.l;
        n.postDelayed(runnable, j + 240);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        LiveOperationViewBinding vb;
        Intrinsics.e(animation, "animation");
        super.onAnimationEnd(animation);
        vb = this.a.getVb();
        LiveOperationDescView liveOperationDescView = vb.b;
        final LiveOperationView liveOperationView = this.a;
        liveOperationDescView.a(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationView$startShowDesc$1$1$Fx6uxMGijpPUgBPZMedSWoZJeZQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveOperationView$startShowDesc$1$1.b(LiveOperationView.this);
            }
        });
    }
}
