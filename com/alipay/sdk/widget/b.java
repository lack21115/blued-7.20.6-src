package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/b.class */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0011a alertDialogC0011a;
        a.AlertDialogC0011a alertDialogC0011a2;
        a.AlertDialogC0011a alertDialogC0011a3;
        Handler handler;
        a.AlertDialogC0011a alertDialogC0011a4;
        boolean z;
        alertDialogC0011a = this.a.e;
        if (alertDialogC0011a == null) {
            a aVar = this.a;
            a aVar2 = this.a;
            aVar.e = new a.AlertDialogC0011a(aVar2.f);
            alertDialogC0011a4 = this.a.e;
            z = this.a.k;
            alertDialogC0011a4.setCancelable(z);
        }
        try {
            alertDialogC0011a2 = this.a.e;
            if (alertDialogC0011a2.isShowing()) {
                return;
            }
            alertDialogC0011a3 = this.a.e;
            alertDialogC0011a3.show();
            handler = this.a.l;
            handler.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
        }
    }
}
