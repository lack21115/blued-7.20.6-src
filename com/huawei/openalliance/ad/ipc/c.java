package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.cj;
import com.huawei.openalliance.ad.ipc.a;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.v;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/c.class */
public abstract class c<SERVICE extends IInterface> implements a.InterfaceC0436a {
    protected static final long Code = 3000;
    private static final String Z = "install_service_timeout_task";
    private SERVICE C;
    protected com.huawei.openalliance.ad.ipc.a I;
    protected Context V;
    private final String B = Z + hashCode();
    private boolean S = false;
    private final byte[] F = new byte[0];
    private Set<a> D = new CopyOnWriteArraySet();
    private ServiceConnection L = new ServiceConnection() { // from class: com.huawei.openalliance.ad.ipc.c.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ge.Code(c.this.V(), "onServiceConnected comp name: %s pkgName: %s", componentName.getClassName(), componentName.getPackageName());
                if (!c.this.F().equalsIgnoreCase(componentName.getClassName())) {
                    c.this.Code("pps remote service name not match, disconnect service.");
                    c.this.Code((c) null);
                    return;
                }
                ba.Code(c.this.B);
                ge.V(c.this.V(), "PPS remote service connected: %d", Long.valueOf(System.currentTimeMillis()));
                c.this.Code((c) c.this.Code(iBinder));
                c.this.Code(componentName);
                if (c.this.S() && c.this.D()) {
                    ge.I(c.this.V(), "request is already timeout");
                    return;
                }
                IInterface a2 = c.this.a();
                if (a2 != null) {
                    ArrayList<a> arrayList = new ArrayList(c.this.D);
                    c.this.D.clear();
                    for (a aVar : arrayList) {
                        aVar.Code((a) a2);
                    }
                }
            } catch (Throwable th) {
                ge.I(c.this.V(), "BaseASM Service, service error: %s", th.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ge.V(c.this.V(), "PPS remote service disconnected");
            c.this.Code((c) null);
            c.this.C();
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/c$a.class */
    public static abstract class a<SERVICE extends IInterface> {
        private com.huawei.openalliance.ad.ipc.a Code;

        public abstract void Code(SERVICE service);

        public void Code(com.huawei.openalliance.ad.ipc.a aVar) {
            this.Code = aVar;
        }

        public abstract void Code(String str);

        protected void finalize() {
            super.finalize();
            com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.Code == null || v.B(a.this.Code.Code())) {
                        return;
                    }
                    a.this.Code.I();
                }
            });
        }
    }

    public c(Context context) {
        this.V = context.getApplicationContext();
        this.I = new com.huawei.openalliance.ad.ipc.a(context, V(), this);
    }

    private void Code(long j) {
        ba.Code(this.B);
        Code(false);
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.1
            @Override // java.lang.Runnable
            public void run() {
                String V = c.this.V();
                ge.V(V, "bind timeout " + System.currentTimeMillis());
                c.this.Code(true);
                c.this.Code("service bind timeout");
            }
        }, this.B, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(SERVICE service) {
        synchronized (this) {
            this.C = service;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        try {
            ArrayList<a> arrayList = new ArrayList(this.D);
            this.D.clear();
            for (a aVar : arrayList) {
                aVar.Code(str);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        synchronized (this.F) {
            this.S = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        boolean z;
        synchronized (this.F) {
            z = this.S;
        }
        return z;
    }

    private boolean L() {
        try {
            String V = V();
            ge.V(V, "bindService " + System.currentTimeMillis());
            B();
            Intent intent = new Intent(I());
            String Z2 = Z();
            String V2 = V();
            ge.V(V2, "bind service pkg: " + Z2);
            intent.setPackage(Z2);
            if (!dt.B(this.V) && com.huawei.openalliance.ad.utils.e.Code(Z2)) {
                String B = com.huawei.openalliance.ad.utils.e.B(this.V, Z2);
                boolean isEmpty = TextUtils.isEmpty(B);
                ge.V(V(), "is sign empty: %s", Boolean.valueOf(isEmpty));
                if (!isEmpty && !cj.Code(this.V, Z2, B)) {
                    return false;
                }
            }
            boolean bindService = this.V.bindService(intent, this.L, 1);
            ge.V(V(), "bind service result: %s", Boolean.valueOf(bindService));
            if (!bindService) {
                Code("bind service failed");
            }
            return bindService;
        } catch (SecurityException e) {
            ge.I(V(), "bindService SecurityException");
            Code("bindService SecurityException");
            return false;
        } catch (Exception e2) {
            String V3 = V();
            ge.I(V3, "bindService " + e2.getClass().getSimpleName());
            Code("bindService " + e2.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SERVICE a() {
        SERVICE service;
        synchronized (this) {
            service = this.C;
        }
        return service;
    }

    protected abstract void B();

    protected void C() {
    }

    protected abstract SERVICE Code(IBinder iBinder);

    @Override // com.huawei.openalliance.ad.ipc.a.InterfaceC0436a
    public void Code() {
        synchronized (this) {
            this.V.unbindService(this.L);
            this.C = null;
        }
    }

    protected abstract void Code(ComponentName componentName);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(a aVar, long j) {
        ge.Code(V(), "handleTask");
        aVar.Code(this.I);
        this.I.V();
        SERVICE a2 = a();
        if (a2 != null) {
            aVar.Code((a) a2);
            return;
        }
        this.D.add(aVar);
        if (L() && S()) {
            Code(j);
        }
    }

    protected abstract String F();

    protected abstract String I();

    protected boolean S() {
        return false;
    }

    protected String V() {
        return "";
    }

    protected abstract String Z();
}
