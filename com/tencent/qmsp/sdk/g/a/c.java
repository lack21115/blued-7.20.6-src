package com.tencent.qmsp.sdk.g.a;

import android.content.Context;
import android.os.IBinder;
import com.tencent.qmsp.sdk.base.IVendorCallback;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/a/c.class */
public class c implements com.tencent.qmsp.sdk.base.b, b {

    /* renamed from: a  reason: collision with root package name */
    private IVendorCallback f38607a;
    private d d;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f38608c = "";
    private boolean e = false;
    private boolean f = false;

    @Override // com.tencent.qmsp.sdk.base.b
    public String a() {
        return this.b;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f38607a = iVendorCallback;
        d dVar = new d(context);
        this.d = dVar;
        dVar.a(this);
    }

    @Override // com.tencent.qmsp.sdk.g.a.b
    public void a(a aVar) {
        try {
            String c2 = aVar.c();
            this.b = c2;
            if (c2 == null) {
                this.b = "";
            }
        } catch (Exception e) {
        }
        try {
            String h = aVar.h();
            this.f38608c = h;
            if (h == null) {
                this.f38608c = "";
            }
        } catch (Exception e2) {
        }
        try {
            this.f = aVar.g();
        } catch (Exception e3) {
        }
        this.e = true;
        IVendorCallback iVendorCallback = this.f38607a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(this.f, this.f38608c, this.b);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public String b() {
        return this.f38608c;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void c() {
        this.d.a(this);
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public boolean e() {
        return this.f;
    }

    @Override // com.tencent.qmsp.sdk.base.b
    public void f() {
        d dVar;
        if (!this.e || (dVar = this.d) == null) {
            return;
        }
        dVar.a();
    }

    @Override // com.tencent.qmsp.sdk.g.a.b
    public void g() {
        IVendorCallback iVendorCallback = this.f38607a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, null, null);
        }
    }
}
