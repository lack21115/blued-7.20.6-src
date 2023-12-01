package com.tencent.qmsp.sdk.g.h;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.g.h.b;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/h/c.class */
public class c implements com.tencent.qmsp.sdk.base.b, b.InterfaceC0832b {

    /* renamed from: a  reason: collision with root package name */
    public IVendorCallback f24961a;
    private b b;

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        String b;
        return (e() && (b = this.b.b()) != null) ? b : "";
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f24961a = iVendorCallback;
        b bVar = new b(context, this);
        this.b = bVar;
        bVar.c();
    }

    @Override // com.tencent.qmsp.sdk.g.h.b.InterfaceC0832b
    public void a(b bVar) {
        IVendorCallback iVendorCallback = this.f24961a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), b(), a());
        }
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        String a2;
        return (e() && (a2 = this.b.a()) != null) ? a2 : "";
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean e() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.d();
        }
        return false;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.e();
        }
    }
}
