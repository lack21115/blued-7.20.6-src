package com.alipay.sdk.widget;

import android.content.DialogInterface;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/o.class */
class o implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f4694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f4694a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.alipay.sdk.sys.a aVar;
        Tracker.onClick(dialogInterface, i);
        this.f4694a.f4693a.cancel();
        aVar = this.f4694a.b.w;
        com.alipay.sdk.app.statistic.a.a(aVar, "net", com.alipay.sdk.app.statistic.c.t, "2");
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f4694a.b.f4685a.finish();
    }
}
