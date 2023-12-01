package com.tencent.qmsp.oaid2;

import android.content.Context;
import com.tencent.qmsp.oaid2.j0;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/k0.class */
public class k0 implements b, j0.b {

    /* renamed from: a  reason: collision with root package name */
    public IVendorCallback f24795a;
    public j0 b;

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        String b;
        return (e() && (b = this.b.b()) != null) ? b : "";
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f24795a = iVendorCallback;
        j0 j0Var = new j0(context, this);
        this.b = j0Var;
        j0Var.c();
    }

    @Override // com.tencent.qmsp.oaid2.j0.b
    public void a(j0 j0Var) {
        IVendorCallback iVendorCallback = this.f24795a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), d(), a());
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        String a2;
        return (e() && (a2 = this.b.a()) != null) ? a2 : "";
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        j0 j0Var = this.b;
        if (j0Var != null) {
            return j0Var.d();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        j0 j0Var = this.b;
        if (j0Var != null) {
            j0Var.e();
        }
    }
}
