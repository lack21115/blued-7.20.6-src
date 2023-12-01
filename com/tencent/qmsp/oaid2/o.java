package com.tencent.qmsp.oaid2;

import android.content.Context;
import com.tencent.qmsp.oaid2.p;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/o.class */
public class o implements b, p.b {

    /* renamed from: a  reason: collision with root package name */
    public p f38496a;
    public IVendorCallback b;

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        String a2;
        return (e() && (a2 = this.f38496a.a()) != null) ? a2 : "";
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.b = iVendorCallback;
        this.f38496a = new p(context, this);
    }

    @Override // com.tencent.qmsp.oaid2.p.b
    public void a(p pVar) {
        try {
            if (this.b != null) {
                this.b.onResult(e(), d(), a());
            }
        } catch (Exception e) {
            IVendorCallback iVendorCallback = this.b;
            if (iVendorCallback != null) {
                iVendorCallback.onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
            }
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        String c2;
        return (e() && (c2 = this.f38496a.c()) != null) ? c2 : "";
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        p pVar = this.f38496a;
        if (pVar != null) {
            return pVar.b();
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
        p pVar = this.f38496a;
        if (pVar != null) {
            pVar.d();
        }
    }
}
