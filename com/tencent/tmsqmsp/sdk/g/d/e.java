package com.tencent.tmsqmsp.sdk.g.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tmsqmsp.sdk.base.IVendorCallback;
import com.tencent.tmsqmsp.sdk.base.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/d/e.class */
public class e implements com.tencent.tmsqmsp.sdk.base.b, c {

    /* renamed from: a  reason: collision with root package name */
    private b f26089a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IVendorCallback f26090c;

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String a() {
        String str = "";
        if (e()) {
            str = this.f26089a.b();
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        if (b.a(context)) {
            String a2 = f.a(context);
            if (!TextUtils.isEmpty(a2)) {
                b.a(context, a2);
            }
            this.f26089a = new b(context, this);
            this.f26090c = iVendorCallback;
            this.b = context;
        }
    }

    @Override // com.tencent.tmsqmsp.sdk.g.d.c
    public void a(boolean z) {
        IVendorCallback iVendorCallback = this.f26090c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), b(), a());
        }
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public String b() {
        String str = "";
        if (e()) {
            str = this.f26089a.a();
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void c() {
        b bVar = this.f26089a;
        if (bVar != null) {
            bVar.a(f.a(this.b));
        } else {
            g();
        }
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public boolean e() {
        b bVar = this.f26089a;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    @Override // com.tencent.tmsqmsp.sdk.base.b
    public void f() {
        b bVar = this.f26089a;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.tencent.tmsqmsp.sdk.g.d.c
    public void g() {
        IVendorCallback iVendorCallback = this.f26090c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, "", "");
        }
    }
}
