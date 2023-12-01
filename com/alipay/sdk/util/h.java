package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.util.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/h.class */
public class h extends IRemoteServiceCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f4665a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.f4665a = eVar;
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public boolean isHideLoadingScreen() throws RemoteException {
        return false;
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public void payEnd(boolean z, String str) throws RemoteException {
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
        com.alipay.sdk.sys.a aVar;
        com.alipay.sdk.sys.a aVar2;
        Activity activity;
        com.alipay.sdk.sys.a aVar3;
        com.alipay.sdk.sys.a aVar4;
        e.a aVar5;
        Activity activity2;
        com.alipay.sdk.sys.a aVar6;
        Intent intent = new Intent(Intent.ACTION_MAIN, (Uri) null);
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        try {
            bundle2.putInt("CallingPid", i);
            intent.putExtras(bundle2);
        } catch (Exception e) {
            aVar = this.f4665a.h;
            com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.R, e);
        }
        intent.setClassName(str, str2);
        try {
            activity = this.f4665a.f4662c;
            if (activity != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                activity2 = this.f4665a.f4662c;
                activity2.startActivity(intent);
                aVar6 = this.f4665a.h;
                com.alipay.sdk.app.statistic.a.b(aVar6, com.alipay.sdk.app.statistic.c.b, "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            } else {
                aVar3 = this.f4665a.h;
                com.alipay.sdk.app.statistic.a.a(aVar3, com.alipay.sdk.app.statistic.c.b, "ErrActNull", "");
                aVar4 = this.f4665a.h;
                Context b = aVar4.b();
                if (b != null) {
                    b.startActivity(intent);
                }
            }
            aVar5 = this.f4665a.g;
            aVar5.b();
        } catch (Throwable th) {
            aVar2 = this.f4665a.h;
            com.alipay.sdk.app.statistic.a.a(aVar2, com.alipay.sdk.app.statistic.c.b, "ErrActNull", th);
            throw th;
        }
    }
}
