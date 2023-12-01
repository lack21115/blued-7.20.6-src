package com.tencent.qmsp.oaid2;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/a0.class */
public class a0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f38458a;

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        return y.b(this.f38458a);
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f38458a = context;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        return y.a(this.f38458a);
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        return y.a();
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        return true;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
    }
}
