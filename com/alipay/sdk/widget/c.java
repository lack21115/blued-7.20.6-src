package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/c.class */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4683a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f4683a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0051a alertDialogC0051a;
        a.AlertDialogC0051a alertDialogC0051a2;
        Handler handler;
        a.AlertDialogC0051a alertDialogC0051a3;
        alertDialogC0051a = this.f4683a.e;
        if (alertDialogC0051a != null) {
            alertDialogC0051a2 = this.f4683a.e;
            if (alertDialogC0051a2.isShowing()) {
                try {
                    handler = this.f4683a.l;
                    handler.removeMessages(1);
                    alertDialogC0051a3 = this.f4683a.e;
                    alertDialogC0051a3.dismiss();
                } catch (Exception e) {
                    com.alipay.sdk.util.c.a(e);
                }
            }
        }
    }
}
