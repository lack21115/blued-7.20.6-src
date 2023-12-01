package com.tencent.tmsqmsp.sdk.g.e;

import android.content.Context;
import com.tencent.tmsqmsp.sdk.base.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/e/f.class */
public class f implements com.tencent.tmsqmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f39788a;

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String a() {
        return d.b(this.f39788a);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f39788a = context;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String b() {
        return d.a(this.f39788a);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean d() {
        return true;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean e() {
        return d.a();
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void f() {
    }
}
