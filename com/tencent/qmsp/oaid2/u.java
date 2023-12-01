package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/u.class */
public class u implements b, s {

    /* renamed from: a  reason: collision with root package name */
    public r f24814a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public IVendorCallback f24815c;

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        String str = "";
        if (e()) {
            str = this.f24814a.b();
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        if (r.a(context)) {
            String a2 = e.a(context);
            if (!TextUtils.isEmpty(a2)) {
                r.a(context, a2);
            }
            this.f24814a = new r(context, this);
            this.f24815c = iVendorCallback;
            this.b = context;
        }
    }

    @Override // com.tencent.qmsp.oaid2.s
    public void a(boolean z) {
        IVendorCallback iVendorCallback = this.f24815c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), d(), a());
        }
    }

    @Override // com.tencent.qmsp.oaid2.s
    public void b() {
        IVendorCallback iVendorCallback = this.f24815c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, "", "");
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        String str = "";
        if (e()) {
            str = this.f24814a.a();
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        r rVar = this.f24814a;
        if (rVar != null) {
            return rVar.c();
        }
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        r rVar = this.f24814a;
        if (rVar != null) {
            rVar.a(e.a(this.b));
        } else {
            b();
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        r rVar = this.f24814a;
        if (rVar != null) {
            rVar.d();
        }
    }
}
