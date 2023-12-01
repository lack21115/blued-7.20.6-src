package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/b.class */
public final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, Context context) {
        this.a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        if (!TextUtils.isEmpty(this.a)) {
            b2 = a.b.b(this.b, this.a);
            if (!b2) {
                return;
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return;
            }
            String a = a.C0006a.a(this.b);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            b = a.b.b(this.b, a);
            if (!b) {
                return;
            }
            i = i2 + 1;
        }
    }
}
