package com.efs.sdk.base.core.f;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/f/a.class */
public abstract class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public ControllerCenter f21773a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        super(com.efs.sdk.base.core.util.concurrent.a.f21795a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    abstract void a();

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
