package com.alipay.sdk.app;

import com.alipay.sdk.util.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/a.class */
public class a implements e.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AuthTask f4588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AuthTask authTask) {
        this.f4588a = authTask;
    }

    @Override // com.alipay.sdk.util.e.a
    public void a() {
    }

    @Override // com.alipay.sdk.util.e.a
    public void b() {
        this.f4588a.c();
    }
}
