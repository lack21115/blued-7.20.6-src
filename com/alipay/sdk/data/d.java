package com.alipay.sdk.data;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/data/d.class */
public final class d implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.alipay.sdk.sys.a f4625a;
    final /* synthetic */ Context b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ HashMap f4626c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.alipay.sdk.sys.a aVar, Context context, HashMap hashMap) {
        this.f4625a = aVar;
        this.b = context;
        this.f4626c = hashMap;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() throws Exception {
        String b;
        b = c.b(this.f4625a, this.b, this.f4626c);
        return b;
    }
}
