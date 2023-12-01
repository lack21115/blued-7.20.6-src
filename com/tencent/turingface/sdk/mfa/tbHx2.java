package com.tencent.turingface.sdk.mfa;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/tbHx2.class */
public final class tbHx2 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f26304a = false;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    public final IBinder a() throws InterruptedException {
        if (this.f26304a) {
            throw new IllegalStateException();
        }
        this.f26304a = true;
        return this.b.take();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.b.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
