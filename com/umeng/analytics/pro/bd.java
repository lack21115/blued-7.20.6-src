package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bd.class */
public class bd implements au {

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bd$a.class */
    static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f26961a;
        private final LinkedBlockingQueue<IBinder> b;

        private a() {
            this.f26961a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f26961a) {
                throw new IllegalStateException();
            }
            this.f26961a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return b.AbstractBinderC0906b.a(aVar.a()).a();
            } catch (Exception e) {
                return null;
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
