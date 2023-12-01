package com.tencent.qmsp.sdk.g.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/b/b.class */
public final class b implements ServiceConnection {

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadPoolExecutor f38613c = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    /* renamed from: a  reason: collision with root package name */
    public boolean f38614a = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/b/b$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f38615a;

        public a(IBinder iBinder) {
            this.f38615a = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.this.b.offer(this.f38615a);
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceConnected ");
            sb.append(System.currentTimeMillis());
            Log.d("PPSSerivceConnection", sb.toString());
            f38613c.execute(new a(iBinder));
        } catch (Throwable th) {
            Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + System.currentTimeMillis());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
