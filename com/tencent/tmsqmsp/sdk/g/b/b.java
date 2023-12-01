package com.tencent.tmsqmsp.sdk.g.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/b/b.class */
public final class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f39766a = false;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceConnected ");
            sb.append(System.currentTimeMillis());
            Log.d("PPSSerivceConnection", sb.toString());
            this.b.put(iBinder);
        } catch (InterruptedException e) {
            Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + System.currentTimeMillis());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
