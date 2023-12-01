package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/f.class */
public class f implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f4663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f4663a = eVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.alipay.sdk.sys.a aVar;
        Object obj;
        Object obj2;
        aVar = this.f4663a.h;
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, "srvCon");
        obj = this.f4663a.e;
        synchronized (obj) {
            this.f4663a.d = IAlixPay.Stub.asInterface(iBinder);
            obj2 = this.f4663a.e;
            obj2.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.alipay.sdk.sys.a aVar;
        aVar = this.f4663a.h;
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, "srvDis");
        this.f4663a.d = null;
    }
}
