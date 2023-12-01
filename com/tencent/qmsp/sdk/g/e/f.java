package com.tencent.qmsp.sdk.g.e;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/e/f.class */
public class f implements com.tencent.qmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f38638a;

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        return d.b(this.f38638a);
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f38638a = context;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        return d.a(this.f38638a);
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean d() {
        return true;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean e() {
        return d.a();
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
    }
}
