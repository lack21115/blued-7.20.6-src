package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/k.class */
public final class k implements ServiceConnection {

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadPoolExecutor f39642c = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    /* renamed from: a  reason: collision with root package name */
    public boolean f39643a = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/k$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final IBinder f39644a;

        public a(IBinder iBinder) {
            this.f39644a = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                k.this.b.offer(this.f39644a);
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            f39642c.execute(new a(iBinder));
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
