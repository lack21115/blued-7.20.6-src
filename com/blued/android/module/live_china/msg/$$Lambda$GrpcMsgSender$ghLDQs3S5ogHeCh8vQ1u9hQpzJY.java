package com.blued.android.module.live_china.msg;

import com.blued.android.module.live_china.model.MuteLiveAudioModel;

/* renamed from: com.blued.android.module.live_china.msg.-$$Lambda$GrpcMsgSender$ghLDQs3S5ogHeCh8vQ1u9hQpzJY  reason: invalid class name */
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/-$$Lambda$GrpcMsgSender$ghLDQs3S5ogHeCh8vQ1u9hQpzJY.class */
public final /* synthetic */ class $$Lambda$GrpcMsgSender$ghLDQs3S5ogHeCh8vQ1u9hQpzJY implements Runnable {
    private final /* synthetic */ MuteLiveAudioModel f$0;
    private final /* synthetic */ String f$1;

    public /* synthetic */ $$Lambda$GrpcMsgSender$ghLDQs3S5ogHeCh8vQ1u9hQpzJY(MuteLiveAudioModel muteLiveAudioModel, String str) {
        this.f$0 = muteLiveAudioModel;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GrpcMsgSender.a(this.f$0, this.f$1);
    }
}
