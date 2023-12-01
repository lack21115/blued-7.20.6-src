package com.tencent.tmsqmsp.sdk.g.f;

import android.content.Context;
import com.tencent.tmsqmsp.sdk.base.IVendorCallback;
import com.tencent.tmsqmsp.sdk.base.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/f/a.class */
public class a implements com.tencent.tmsqmsp.sdk.base.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f26098a;

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String a() {
        return b.b(this.f26098a);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f26098a = context;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String b() {
        Context context = this.f26098a;
        return b.a(context, f.a(context));
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
        return b.a(this.f26098a);
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void f() {
    }
}
