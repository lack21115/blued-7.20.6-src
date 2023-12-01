package com.alipay.sdk.data;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/data/b.class */
public class b implements Runnable {
    final /* synthetic */ com.alipay.sdk.sys.a a;
    final /* synthetic */ Context b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.alipay.sdk.sys.a aVar2, Context context) {
        this.c = aVar;
        this.a = aVar2;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b a = new com.alipay.sdk.packet.impl.b().a(this.a, this.b);
            if (a != null) {
                this.c.b(a.b());
                this.c.a(com.alipay.sdk.sys.a.a());
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
