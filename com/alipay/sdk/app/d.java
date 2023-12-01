package com.alipay.sdk.app;

import android.content.DialogInterface;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/d.class */
class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4593a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f4593a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.alipay.sdk.sys.a aVar;
        Tracker.onClick(dialogInterface, i);
        this.f4593a.b.cancel();
        aVar = this.f4593a.f4592c.f4590c;
        com.alipay.sdk.app.statistic.a.a(aVar, "net", com.alipay.sdk.app.statistic.c.t, "1");
        j.a(j.c());
        this.f4593a.f4591a.finish();
    }
}
