package com.tencent.qmsp.sdk.g.c;

import android.content.Context;
import com.tencent.qmsp.sdk.base.IVendorCallback;
import com.tencent.qmsp.sdk.g.c.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/c/b.class */
public class b implements com.tencent.qmsp.sdk.base.b, c.b {

    /* renamed from: a  reason: collision with root package name */
    private c f24930a;
    private IVendorCallback b;

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        String a2;
        return (e() && (a2 = this.f24930a.a()) != null) ? a2 : "";
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.b = iVendorCallback;
        this.f24930a = new c(context, this);
    }

    @Override // com.tencent.qmsp.sdk.g.c.c.b
    public void a(c cVar) {
        try {
            if (this.b != null) {
                this.b.onResult(e(), b(), a());
            }
        } catch (Exception e) {
            IVendorCallback iVendorCallback = this.b;
            if (iVendorCallback != null) {
                iVendorCallback.onResult(false, null, null);
            }
        }
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        String c2;
        return (e() && (c2 = this.f24930a.c()) != null) ? c2 : "";
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
        c cVar = this.f24930a;
        if (cVar != null) {
            return cVar.b();
        }
        return false;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
        c cVar = this.f24930a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
