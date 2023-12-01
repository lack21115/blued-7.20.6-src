package com.blued.android.module.live_china.view.operation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/LiveOperationView$goBackToList$1.class */
public final class LiveOperationView$goBackToList$1 extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveOperationView f15355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveOperationView$goBackToList$1(LiveOperationView liveOperationView) {
        this.f15355a = liveOperationView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOperationView this$0) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Intrinsics.e(this$0, "this$0");
        arrayList = this$0.f;
        if (!arrayList.isEmpty()) {
            arrayList2 = this$0.f;
            Object obj = arrayList2.get(0);
            Intrinsics.c(obj, "descList[0]");
            this$0.c((LiveRoomOperationModel) obj);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        ArrayList arrayList;
        long j;
        Intrinsics.e(animation, "animation");
        super.onAnimationEnd(animation);
        arrayList = this.f15355a.f;
        if (arrayList.isEmpty()) {
            return;
        }
        Handler n = AppInfo.n();
        final LiveOperationView liveOperationView = this.f15355a;
        Runnable runnable = new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationView$goBackToList$1$VTb3DT63PhYFU06Uv0-x6N5fSas
            @Override // java.lang.Runnable
            public final void run() {
                LiveOperationView$goBackToList$1.a(LiveOperationView.this);
            }
        };
        j = this.f15355a.l;
        n.postDelayed(runnable, j + 240);
    }
}
