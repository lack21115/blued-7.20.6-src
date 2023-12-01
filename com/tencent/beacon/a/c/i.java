package com.tencent.beacon.a.c;

import android.content.Context;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.QimeiSDK;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/i.class */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f34947a;
    final /* synthetic */ Context b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ IAsyncQimeiListener f34948c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Context context, IAsyncQimeiListener iAsyncQimeiListener) {
        this.f34947a = str;
        this.b = context;
        this.f34948c = iAsyncQimeiListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "async getQimeiWithAppkey  appkey is %s", this.f34947a);
        j.c(this.b.getApplicationContext(), this.f34947a);
        QimeiSDK.getInstance(this.f34947a).getQimei(this.f34948c);
    }
}
