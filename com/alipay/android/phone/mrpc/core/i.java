package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/i.class */
final class i implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f4525a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, aa aaVar) {
        this.b = hVar;
        this.f4525a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final String a() {
        return this.f4525a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final ab b() {
        Context context;
        context = this.b.f4524a;
        return l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final aa c() {
        return this.f4525a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.f4525a.c();
    }
}
