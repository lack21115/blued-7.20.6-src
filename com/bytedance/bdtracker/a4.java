package com.bytedance.bdtracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/a4.class */
public final class a4<SERVICE, RESULT> {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f7584a = new CountDownLatch(1);
    public final Intent b;

    /* renamed from: c  reason: collision with root package name */
    public final b<SERVICE, RESULT> f7585c;
    public final Context d;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/a4$a.class */
    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final CountDownLatch f7586a;
        public final b<SERVICE, RESULT> b;

        /* renamed from: c  reason: collision with root package name */
        public SERVICE f7587c;

        public a(a4 a4Var, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.f7586a = countDownLatch;
            this.b = bVar;
        }

        public void onBindingDied(ComponentName componentName) {
        }

        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            z2.a("ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.f7587c = this.b.a(iBinder);
                this.f7586a.countDown();
            } catch (Exception e) {
                z2.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            z2.a("ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.f7586a.countDown();
            } catch (Exception e) {
                z2.a(e);
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/a4$b.class */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t);
    }

    public a4(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.d = context;
        this.b = intent;
        this.f7585c = bVar;
    }

    public RESULT a() {
        a4<SERVICE, RESULT>.a aVar;
        if (j1.a(Looper.getMainLooper() == Looper.myLooper(), "can't run in ui thread")) {
            return null;
        }
        try {
            aVar = new a(this, this.f7584a, this.f7585c);
            this.d.bindService(this.b, aVar, 1);
            this.f7584a.await();
        } catch (Throwable th) {
            th = th;
            aVar = null;
        }
        try {
            RESULT a2 = this.f7585c.a((b<SERVICE, RESULT>) aVar.f7587c);
            a(aVar);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            try {
                z2.a(th);
                a(aVar);
                return null;
            } catch (Throwable th3) {
                a(aVar);
                throw th3;
            }
        }
    }

    public final void a(a4<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.d.unbindService(aVar);
            } catch (Throwable th) {
                z2.a(th);
            }
        }
    }
}
