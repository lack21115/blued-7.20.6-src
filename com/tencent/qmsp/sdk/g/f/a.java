package com.tencent.qmsp.sdk.g.f;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.base.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/f/a.class */
public class a implements com.tencent.qmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f24948a;

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        return b.b(this.f24948a);
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f24948a = context;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        Context context = this.f24948a;
        return b.a(context, f.a(context));
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
        return b.a(this.f24948a);
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
    }
}
