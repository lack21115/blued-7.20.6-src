package com.blued.android.module.live_china.view.operation;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.blued.android.module.live_china.databinding.LiveOperationChildDefaultViewBinding;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/operation/OperationChildDefaultView$initTimer$1.class */
public final class OperationChildDefaultView$initTimer$1 extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f15364a;
    final /* synthetic */ OperationChildDefaultView b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ LiveRoomOperationModel f15365c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationChildDefaultView$initTimer$1(Ref.LongRef longRef, OperationChildDefaultView operationChildDefaultView, LiveRoomOperationModel liveRoomOperationModel) {
        super(longRef.f42544a, 1000L);
        this.f15364a = longRef;
        this.b = operationChildDefaultView;
        this.f15365c = liveRoomOperationModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(OperationChildDefaultView this$0, LiveRoomOperationModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        this$0.b(model);
        LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(model.getTools_type()));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.b.a();
        final OperationChildDefaultView operationChildDefaultView = this.b;
        final LiveRoomOperationModel liveRoomOperationModel = this.f15365c;
        operationChildDefaultView.post(new Runnable() { // from class: com.blued.android.module.live_china.view.operation.-$$Lambda$OperationChildDefaultView$initTimer$1$Sga3FH5RmWMETQr2WRjGYYNtvto
            @Override // java.lang.Runnable
            public final void run() {
                OperationChildDefaultView$initTimer$1.a(OperationChildDefaultView.this, liveRoomOperationModel);
            }
        });
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        LiveOperationChildDefaultViewBinding vb;
        String a2;
        long b = MathKt.b(j);
        vb = this.b.getVb();
        TextView textView = vb.e;
        a2 = this.b.a(this.f15365c, b);
        textView.setText(a2);
    }
}
