package com.blued.android.module.live_china.view;

import android.os.CountDownTimer;
import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePlanetTimeView$startTime$1.class */
public final class LivePlanetTimeView$startTime$1 extends CountDownTimer {
    final /* synthetic */ LivePlanetTimeView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePlanetTimeView$startTime$1(LivePlanetTimeView livePlanetTimeView, long j) {
        super(j, 1000L);
        this.a = livePlanetTimeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetTimeView this$0) {
        Intrinsics.e(this$0, "this$0");
        LiveEventBusUtil.i();
        this$0.a(10);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.a.getContext() == null) {
            return;
        }
        Handler n = AppInfo.n();
        final LivePlanetTimeView livePlanetTimeView = this.a;
        n.postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePlanetTimeView$startTime$1$lCerOYHX0WLOvF-K3nOyH4Vi8KY
            @Override // java.lang.Runnable
            public final void run() {
                LivePlanetTimeView$startTime$1.a(LivePlanetTimeView.this);
            }
        }, 300L);
        this.a.setData(-1);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        if (this.a.getContext() == null) {
            return;
        }
        long j2 = j / 1000;
        this.a.c(j2 < 0 ? 0 : (int) j2);
    }
}
