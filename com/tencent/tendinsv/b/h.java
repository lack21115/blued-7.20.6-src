package com.tencent.tendinsv.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/b/h.class */
public class h implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private b f25316a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private CountDownLatch f25317c;
    private IBinder d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, CountDownLatch countDownLatch) {
        this.b = str;
        this.f25317c = countDownLatch;
    }

    public b a() {
        return this.f25316a;
    }

    public boolean a(Context context, Intent intent) {
        if (context == null) {
            return false;
        }
        if (this.f25316a != null) {
            return true;
        }
        try {
            boolean bindService = context.bindService(intent, this, 1);
            this.f25317c.await();
            this.f25316a = b.a(this.d, this.b);
            return bindService;
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.d = iBinder;
            this.f25317c.countDown();
        } catch (Throwable th) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f25316a = null;
        this.d = null;
    }
}
