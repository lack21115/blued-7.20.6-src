package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.push.util.t;
import com.vivo.push.util.z;
import com.vivo.vms.IPCInvoke;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/b.class */
public final class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f41032a = new Object();
    private static Map<String, b> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private boolean f41033c;
    private String d;
    private Context e;
    private volatile IPCInvoke g;
    private String i;
    private Handler j;
    private Object h = new Object();
    private AtomicInteger f = new AtomicInteger(1);

    private b(Context context, String str) {
        this.d = null;
        this.j = null;
        this.e = context;
        this.i = str;
        boolean z = true;
        this.j = new Handler(Looper.getMainLooper(), new c(this));
        String b2 = t.b(context);
        this.d = b2;
        if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(this.i)) {
            this.f41033c = z.a(context, this.d) < 1260 ? false : z;
            b();
            return;
        }
        com.vivo.push.util.p.c(this.e, "init error : push pkgname is " + this.d + " ; action is " + this.i);
        this.f41033c = false;
    }

    public static b a(Context context, String str) {
        b bVar;
        b bVar2 = b.get(str);
        if (bVar2 == null) {
            synchronized (f41032a) {
                b bVar3 = b.get(str);
                bVar = bVar3;
                if (bVar3 == null) {
                    bVar = new b(context, str);
                    b.put(str, bVar);
                }
            }
            return bVar;
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f.set(i);
    }

    private void b() {
        int i = this.f.get();
        com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: ".concat(String.valueOf(i)));
        if (i == 4 || i == 2 || i == 3 || i == 5 || !this.f41033c) {
            return;
        }
        a(2);
        if (c()) {
            d();
            return;
        }
        a(1);
        com.vivo.push.util.p.a("AidlManager", "bind core service fail");
    }

    private boolean c() {
        Intent intent = new Intent(this.i);
        intent.setPackage(this.d);
        try {
            return this.e.bindService(intent, this, 1);
        } catch (Exception e) {
            com.vivo.push.util.p.a("AidlManager", "bind core error", e);
            return false;
        }
    }

    private void d() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, com.anythink.expressad.video.module.a.a.m.ag);
    }

    private void e() {
        this.j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.e.unbindService(this);
        } catch (Exception e) {
            com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e.getMessage());
        }
    }

    public final boolean a() {
        String b2 = t.b(this.e);
        this.d = b2;
        boolean z = false;
        if (TextUtils.isEmpty(b2)) {
            com.vivo.push.util.p.c(this.e, "push pkgname is null");
            return false;
        }
        if (z.a(this.e, this.d) >= 1260) {
            z = true;
        }
        this.f41033c = z;
        return z;
    }

    public final boolean a(Bundle bundle) {
        b();
        if (this.f.get() == 2) {
            synchronized (this.h) {
                try {
                    this.h.wait(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            int i = this.f.get();
            if (i != 4) {
                com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = ".concat(String.valueOf(i)));
                return false;
            }
            this.j.removeMessages(2);
            this.j.sendEmptyMessageDelayed(2, 30000L);
            this.g.asyncCall(bundle, null);
            return true;
        } catch (Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "invoke error ", e2);
            int i2 = this.f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: ".concat(String.valueOf(i2)));
            if (i2 == 2) {
                e();
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return false;
                }
                a(1);
                f();
                return false;
            }
            a(1);
            return false;
        }
    }

    public final void onBindingDied(ComponentName componentName) {
        com.vivo.push.util.p.b("AidlManager", "onBindingDied : ".concat(String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e();
        this.g = IPCInvoke.Stub.asInterface(iBinder);
        if (this.g == null) {
            com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f.set(1);
            return;
        }
        if (this.f.get() == 2) {
            a(4);
        } else if (this.f.get() != 4) {
            f();
        }
        synchronized (this.h) {
            this.h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.g = null;
        a(1);
    }
}
