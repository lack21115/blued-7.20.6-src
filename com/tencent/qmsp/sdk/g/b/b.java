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
    public static final ThreadPoolExecutor f24922c = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    /* renamed from: a  reason: collision with root package name */
    public boolean f24923a = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/b/b$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f24924a;

        public a(IBinder iBinder) {
            this.f24924a = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.this.b.offer(this.f24924a);
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
            f24922c.execute(new a(iBinder));
        } catch (Throwable th) {
            Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + System.currentTimeMillis());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
