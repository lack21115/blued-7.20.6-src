package com.blued.android.module.live_china.view.operation;

import android.os.CountDownTimer;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnticipateInterpolator;
import android.widget.TextView;
import com.blued.android.module.live_china.databinding.LiveOperationDescViewBinding;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/LiveOperationDescView$initTimer$1.class */
public final class LiveOperationDescView$initTimer$1 extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f15347a;
    final /* synthetic */ LiveOperationDescView b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ LiveRoomOperationModel f15348c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOperationDescView$initTimer$1(Ref.LongRef longRef, LiveOperationDescView liveOperationDescView, LiveRoomOperationModel liveRoomOperationModel) {
        super(longRef.f42544a, 1000L);
        this.f15347a = longRef;
        this.b = liveOperationDescView;
        this.f15348c = liveRoomOperationModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOperationDescView this$0) {
        LiveOperationDescViewBinding vb;
        LiveOperationDescViewBinding vb2;
        Intrinsics.e(this$0, "this$0");
        vb = this$0.getVb();
        ViewPropertyAnimator animate = vb.f12310a.animate();
        vb2 = this$0.getVb();
        animate.translationY(vb2.f12310a.getHeight() * 3).setInterpolator(new AnticipateInterpolator(2.0f)).setDuration(500L).start();
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.b.b();
        final LiveOperationDescView liveOperationDescView = this.b;
        liveOperationDescView.post(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$LiveOperationDescView$initTimer$1$Xb-1UOMiR6H_H_Ca7LWTsQwWqNI
            @Override // java.lang.Runnable
            public final void run() {
                LiveOperationDescView$initTimer$1.a(LiveOperationDescView.this);
            }
        });
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        LiveOperationDescViewBinding vb;
        String a2;
        long b = MathKt.b(j);
        vb = this.b.getVb();
        TextView textView = vb.f;
        a2 = this.b.a(this.f15348c, b);
        textView.setText(a2);
    }
}
