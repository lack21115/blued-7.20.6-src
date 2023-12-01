package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.blued.android.core.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePushGuideView$showFinger$1.class */
public final class LivePushGuideView$showFinger$1 extends AnimatorListenerAdapter {
    final /* synthetic */ Ref.LongRef a;
    final /* synthetic */ LivePushGuideView b;
    final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LivePushGuideView$showFinger$1(Ref.LongRef longRef, LivePushGuideView livePushGuideView, int i) {
        this.a = longRef;
        this.b = livePushGuideView;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePushGuideView this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(i);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.e(animation, "animation");
        super.onAnimationEnd(animation);
        Handler n = AppInfo.n();
        final LivePushGuideView livePushGuideView = this.b;
        final int i = this.c;
        n.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$showFinger$1$jexTeDSnbkudr28bfmqzDYCldng
            @Override // java.lang.Runnable
            public final void run() {
                LivePushGuideView$showFinger$1.a(LivePushGuideView.this, i);
            }
        }, this.a.a);
    }
}
