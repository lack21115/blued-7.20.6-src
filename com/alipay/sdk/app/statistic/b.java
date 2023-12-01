package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/statistic/b.class */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4607a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, Context context) {
        this.f4607a = str;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        if (!TextUtils.isEmpty(this.f4607a)) {
            b2 = a.b.b(this.b, this.f4607a);
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
            String a2 = a.C0046a.a(this.b);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            b = a.b.b(this.b, a2);
            if (!b) {
                return;
            }
            i = i2 + 1;
        }
    }
}
