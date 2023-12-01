package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/data/d.class */
public final class d implements Callable<String> {
    final /* synthetic */ com.alipay.sdk.sys.a a;
    final /* synthetic */ Context b;
    final /* synthetic */ HashMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.alipay.sdk.sys.a aVar, Context context, HashMap hashMap) {
        this.a = aVar;
        this.b = context;
        this.c = hashMap;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() throws Exception {
        String b;
        b = c.b(this.a, this.b, this.c);
        return b;
    }
}
