package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.blued.android.core.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePushGuideView$showTips$1.class */
public final class LivePushGuideView$showTips$1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f14890a;
    final /* synthetic */ LivePushGuideView b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f14891c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LivePushGuideView$showTips$1(Ref.LongRef longRef, LivePushGuideView livePushGuideView, int i) {
        this.f14890a = longRef;
        this.b = livePushGuideView;
        this.f14891c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePushGuideView this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.d(i);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.e(animation, "animation");
        super.onAnimationEnd(animation);
        Handler n = AppInfo.n();
        final LivePushGuideView livePushGuideView = this.b;
        final int i = this.f14891c;
        n.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePushGuideView$showTips$1$nbo12L8mOW1CukRVBo6T1DAf1Ek
            @Override // java.lang.Runnable
            public final void run() {
                LivePushGuideView$showTips$1.a(LivePushGuideView.this, i);
            }
        }, this.f14890a.f42544a);
    }
}
