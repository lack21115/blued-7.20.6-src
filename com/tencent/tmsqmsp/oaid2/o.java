package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import com.tencent.tmsqmsp.oaid2.p;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/o.class */
public class o implements b, p.b {

    /* renamed from: a  reason: collision with root package name */
    public p f39655a;
    public IVendorCallback b;

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String a() {
        String a2;
        return (e() && (a2 = this.f39655a.a()) != null) ? a2 : "";
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.b = iVendorCallback;
        this.f39655a = new p(context, this);
    }

    @Override // com.tencent.tmsqmsp.oaid2.p.b
    public void a(p pVar) {
        try {
            IVendorCallback iVendorCallback = this.b;
            if (iVendorCallback != null) {
                iVendorCallback.onResult(e(), d(), a());
            }
        } catch (Exception e) {
            IVendorCallback iVendorCallback2 = this.b;
            if (iVendorCallback2 != null) {
                iVendorCallback2.onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
            }
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public String d() {
        String c2;
        return (e() && (c2 = this.f39655a.c()) != null) ? c2 : "";
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean e() {
        p pVar = this.f39655a;
        if (pVar != null) {
            return pVar.b();
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void j() {
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public boolean k() {
        return false;
    }

    @Override // com.tencent.tmsqmsp.oaid2.b
    public void l() {
        p pVar = this.f39655a;
        if (pVar != null) {
            pVar.d();
        }
    }
}
