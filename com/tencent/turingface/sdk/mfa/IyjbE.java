package com.tencent.turingface.sdk.mfa;

import android.os.Handler;
import android.os.Message;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/IyjbE.class */
public final class IyjbE implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Handler.Callback f39885a;
    public final Ww1Z6 b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39886c;

    public IyjbE(Handler.Callback callback, Ww1Z6 ww1Z6, String str) {
        this.f39885a = callback;
        this.b = ww1Z6;
        this.f39886c = str;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            int i = message.arg2;
            int i2 = message.what;
            Ww1Z6 ww1Z6 = this.b;
            if (ww1Z6 != null && i2 == 1) {
                ww1Z6.a(this.f39886c);
            }
        } catch (Throwable th) {
        }
        Handler.Callback callback = this.f39885a;
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }
}
