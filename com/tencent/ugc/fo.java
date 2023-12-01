package com.tencent.ugc;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fo.class */
public final /* synthetic */ class fo implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40390a;

    private fo(UGCVideoProcessor uGCVideoProcessor) {
        this.f40390a = uGCVideoProcessor;
    }

    public static Handler.Callback a(UGCVideoProcessor uGCVideoProcessor) {
        return new fo(uGCVideoProcessor);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        boolean handleMessage;
        handleMessage = this.f40390a.handleMessage(message);
        return handleMessage;
    }
}
