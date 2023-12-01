package com.tencent.qmsp.oaid2;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/b0.class */
public class b0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f38459a;

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        return c0.b(this.f38459a);
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f38459a = context;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        Context context = this.f38459a;
        return c0.a(context, e.a(context));
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        return c0.a(this.f38459a);
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
