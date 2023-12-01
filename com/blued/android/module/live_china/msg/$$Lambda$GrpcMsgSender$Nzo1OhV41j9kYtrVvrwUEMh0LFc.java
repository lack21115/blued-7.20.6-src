package com.blued.android.module.live_china.msg;

import cn.irisgw.live.LiveChatOuterClass;
import com.blued.android.module.live.im.LiveIM;

/* renamed from: com.blued.android.module.live_china.msg.-$$Lambda$GrpcMsgSender$Nzo1OhV41j9kYtrVvrwUEMh0LFc  reason: invalid class name */
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/msg/-$$Lambda$GrpcMsgSender$Nzo1OhV41j9kYtrVvrwUEMh0LFc.class */
public final /* synthetic */ class $$Lambda$GrpcMsgSender$Nzo1OhV41j9kYtrVvrwUEMh0LFc implements LiveIM.OnSendLikeFinishListener {
    private final /* synthetic */ GrpcMsgSender f$0;

    @Override // com.blued.android.module.live.im.LiveIM.OnSendLikeFinishListener
    public final void onFinish(LiveChatOuterClass.LiveLikeResponse liveLikeResponse) {
        this.f$0.a(liveLikeResponse);
    }
}
