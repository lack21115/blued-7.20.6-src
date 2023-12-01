package com.tencent.turingface.sdk.mfa;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/RYhXO.class */
public abstract class RYhXO implements Xjpd8 {

    /* renamed from: a  reason: collision with root package name */
    public OTVRM f26223a;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/RYhXO$ShGzN.class */
    public final class ShGzN extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f26224a;
        public final /* synthetic */ AtomicReference b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f26225c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ AtomicReference e;
        public final /* synthetic */ Object f;

        public ShGzN(AtomicReference atomicReference, AtomicReference atomicReference2, AtomicReference atomicReference3, Context context, AtomicReference atomicReference4, Object obj) {
            this.f26224a = atomicReference;
            this.b = atomicReference2;
            this.f26225c = atomicReference3;
            this.d = context;
            this.e = atomicReference4;
            this.f = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String str;
            try {
                str = RYhXO.this.a((IBinder) this.f26224a.get());
            } catch (Throwable th) {
                this.b.set(Integer.valueOf((int) PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION));
                str = "";
            }
            this.f26225c.set(str);
            try {
                this.d.unbindService((ServiceConnection) this.e.get());
            } catch (Throwable th2) {
                this.b.set(Integer.valueOf((int) PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES));
            }
            synchronized (this.f) {
                try {
                    this.f.notifyAll();
                } catch (Throwable th3) {
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/RYhXO$spXPg.class */
    public final class spXPg implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f26226a;
        public final /* synthetic */ AtomicReference b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f26227c;

        public spXPg(AtomicReference atomicReference, AtomicReference atomicReference2, Object obj) {
            this.f26226a = atomicReference;
            this.b = atomicReference2;
            this.f26227c = obj;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f26226a.set(iBinder);
            this.b.set(this);
            synchronized (this.f26227c) {
                try {
                    this.f26227c.notifyAll();
                } catch (Throwable th) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2) {
        Object obj = new Object();
        Intent intent = new Intent(kC0XR.a(kC0XR.k));
        intent.setComponent(new ComponentName(kC0XR.a(kC0XR.g), kC0XR.a(kC0XR.h)));
        if (context.bindService(intent, new spXPg(atomicReference, atomicReference2, obj), 1)) {
            if (atomicReference.get() == null) {
                synchronized (obj) {
                    try {
                        obj.wait(1000L);
                    } catch (Throwable th) {
                    }
                }
            }
            if (atomicReference.get() == null) {
                return PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING;
            }
            return 0;
        }
        return -100;
    }

    public final int a(Context context, AtomicReference<IBinder> atomicReference, AtomicReference<ServiceConnection> atomicReference2, AtomicReference<String> atomicReference3) {
        Object obj = new Object();
        AtomicReference atomicReference4 = new AtomicReference(0);
        new ShGzN(atomicReference, atomicReference4, atomicReference3, context, atomicReference2, obj).start();
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (Throwable th) {
            }
        }
        return ((Integer) atomicReference4.get()).intValue();
    }

    public abstract String a(IBinder iBinder) throws Exception;

    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    public final void a(Context context) {
        this.f26223a = c(context);
    }

    @Override // com.tencent.turingface.sdk.mfa.Xjpd8
    public final OTVRM b(Context context) {
        OTVRM otvrm = this.f26223a;
        if (otvrm == null || otvrm.b != 0) {
            this.f26223a = c(context);
        }
        return this.f26223a;
    }

    public final OTVRM c(Context context) {
        int i;
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("");
        try {
            AtomicReference<IBinder> atomicReference2 = new AtomicReference<>();
            AtomicReference<ServiceConnection> atomicReference3 = new AtomicReference<>();
            int a2 = a(context, atomicReference2, atomicReference3);
            i = a2;
            if (a2 == 0) {
                try {
                    i = a(context, atomicReference2, atomicReference3, atomicReference);
                } catch (Throwable th) {
                    i = a2;
                }
            }
        } catch (Throwable th2) {
            i = -1;
        }
        return new OTVRM(atomicReference.get(), i);
    }
}
