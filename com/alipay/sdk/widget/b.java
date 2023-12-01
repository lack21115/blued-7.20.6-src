package com.alipay.sdk.widget;

import android.os.Handler;
import com.alipay.sdk.widget.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4682a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.AlertDialogC0051a alertDialogC0051a;
        a.AlertDialogC0051a alertDialogC0051a2;
        a.AlertDialogC0051a alertDialogC0051a3;
        Handler handler;
        a.AlertDialogC0051a alertDialogC0051a4;
        boolean z;
        alertDialogC0051a = this.f4682a.e;
        if (alertDialogC0051a == null) {
            a aVar = this.f4682a;
            a aVar2 = this.f4682a;
            aVar.e = new a.AlertDialogC0051a(aVar2.f);
            alertDialogC0051a4 = this.f4682a.e;
            z = this.f4682a.k;
            alertDialogC0051a4.setCancelable(z);
        }
        try {
            alertDialogC0051a2 = this.f4682a.e;
            if (alertDialogC0051a2.isShowing()) {
                return;
            }
            alertDialogC0051a3 = this.f4682a.e;
            alertDialogC0051a3.show();
            handler = this.f4682a.l;
            handler.sendEmptyMessageDelayed(1, 15000L);
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
        }
    }
}
