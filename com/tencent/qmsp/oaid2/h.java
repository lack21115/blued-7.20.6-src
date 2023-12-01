package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.os.IBinder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/h.class */
public class h implements b, g {

    /* renamed from: a  reason: collision with root package name */
    public IVendorCallback f24779a;
    public i d;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f24780c = "";
    public boolean e = false;
    public boolean f = false;

    @Override // com.tencent.qmsp.oaid2.b
    public String a() {
        return this.b;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void a(Context context, IVendorCallback iVendorCallback) {
        this.f24779a = iVendorCallback;
        i iVar = new i(context);
        this.d = iVar;
        iVar.a(this);
    }

    @Override // com.tencent.qmsp.oaid2.g
    public void a(f fVar) {
        try {
            String c2 = fVar.c();
            this.b = c2;
            if (c2 == null) {
                this.b = "";
            }
        } catch (Exception e) {
        }
        try {
            String i = fVar.i();
            this.f24780c = i;
            if (i == null) {
                this.f24780c = "";
            }
        } catch (Exception e2) {
        }
        try {
            this.f = fVar.b();
        } catch (Exception e3) {
        }
        this.e = true;
        IVendorCallback iVendorCallback = this.f24779a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(this.f, this.f24780c, this.b);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.tencent.qmsp.oaid2.g
    public void b() {
        IVendorCallback iVendorCallback = this.f24779a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, null, null);
        }
    }

    @Override // com.tencent.qmsp.oaid2.b
    public String d() {
        return this.f24780c;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean e() {
        return this.f;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void j() {
        this.d.a(this);
    }

    @Override // com.tencent.qmsp.oaid2.b
    public boolean k() {
        return false;
    }

    @Override // com.tencent.qmsp.oaid2.b
    public void l() {
        i iVar;
        if (!this.e || (iVar = this.d) == null) {
            return;
        }
        iVar.a();
    }
}
