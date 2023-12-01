package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/c.class */
public class c implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0011a alertDialogC0011a;
        a.AlertDialogC0011a alertDialogC0011a2;
        Handler handler;
        a.AlertDialogC0011a alertDialogC0011a3;
        alertDialogC0011a = this.a.e;
        if (alertDialogC0011a != null) {
            alertDialogC0011a2 = this.a.e;
            if (alertDialogC0011a2.isShowing()) {
                try {
                    handler = this.a.l;
                    handler.removeMessages(1);
                    alertDialogC0011a3 = this.a.e;
                    alertDialogC0011a3.dismiss();
                } catch (Exception e) {
                    com.alipay.sdk.util.c.a(e);
                }
            }
        }
    }
}
