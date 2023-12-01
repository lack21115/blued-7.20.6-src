package com.blued.android.module.live_china.msg;

import cn.irisgw.live.Animation;
import com.blued.android.module.live_china.model.LiveGiftModel;

/* renamed from: com.blued.android.module.live_china.msg.-$$Lambda$GrpcMsgSender$_AgV9EwOlDKuqkCd4G0uKDGnLkU  reason: invalid class name */
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/-$$Lambda$GrpcMsgSender$_AgV9EwOlDKuqkCd4G0uKDGnLkU.class */
public final /* synthetic */ class $$Lambda$GrpcMsgSender$_AgV9EwOlDKuqkCd4G0uKDGnLkU implements Runnable {
    private final /* synthetic */ Animation f$0;
    private final /* synthetic */ LiveGiftModel f$1;

    public /* synthetic */ $$Lambda$GrpcMsgSender$_AgV9EwOlDKuqkCd4G0uKDGnLkU(Animation animation, LiveGiftModel liveGiftModel) {
        this.f$0 = animation;
        this.f$1 = liveGiftModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GrpcMsgSender.a(this.f$0, this.f$1);
    }
}
