package com.alipay.sdk.app;

import android.content.DialogInterface;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/d.class */
class d implements DialogInterface.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.alipay.sdk.sys.a aVar;
        Tracker.onClick(dialogInterface, i);
        this.a.b.cancel();
        aVar = this.a.c.c;
        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.c.a, com.alipay.sdk.app.statistic.c.t, "1");
        j.a(j.c());
        this.a.a.finish();
    }
}
