package com.alipay.sdk.data;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/data/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.alipay.sdk.sys.a f4621a;
    final /* synthetic */ Context b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f4622c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.alipay.sdk.sys.a aVar2, Context context) {
        this.f4622c = aVar;
        this.f4621a = aVar2;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.b().a(this.f4621a, this.b);
            if (a2 != null) {
                this.f4622c.b(a2.b());
                this.f4622c.a(com.alipay.sdk.sys.a.a());
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }
}
