package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Message;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/o.class */
public class o implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f8707a;

    public o(p pVar) {
        this.f8707a = pVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null || message.what != 1001) {
            return false;
        }
        this.f8707a.a(HonorPushErrorCode.ERROR_SERVICE_TIME_OUT);
        return true;
    }
}
