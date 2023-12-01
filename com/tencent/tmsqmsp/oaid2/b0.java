package com.tencent.tmsqmsp.oaid2;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/b0.class */
public class b0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public Context f39618a;

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        return c0.b(this.f39618a);
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f39618a = context;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        Context context = this.f39618a;
        return c0.a(context, e.a(context));
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        return c0.a(this.f39618a);
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        return true;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
    }
}
