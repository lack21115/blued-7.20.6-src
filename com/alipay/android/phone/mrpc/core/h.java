package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/h.class */
public final class h extends w {

    /* renamed from: a  reason: collision with root package name */
    private Context f4524a;

    public h(Context context) {
        this.f4524a = context;
    }

    @Override // com.alipay.android.phone.mrpc.core.w
    public final <T> T a(Class<T> cls, aa aaVar) {
        return (T) new x(new i(this, aaVar)).a(cls);
    }
}
