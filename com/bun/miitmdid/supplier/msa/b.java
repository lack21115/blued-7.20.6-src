package com.bun.miitmdid.supplier.msa;

import android.content.Context;
import android.text.TextUtils;
import com.bun.lib.sysParamters;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/supplier/msa/b.class */
public class b implements com.bun.miitmdid.c.e.a, InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    public SupplierListener f7558a;
    private MsaClient b;

    public b(Context context) {
        if (MsaClient.CheckService(context)) {
            String g = sysParamters.g();
            if (!TextUtils.isEmpty(g)) {
                MsaClient.StartMsaKlService(context, g);
            }
            this.b = new MsaClient(context, this);
        }
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(SupplierListener supplierListener);

    @Override // com.bun.miitmdid.c.e.a
    public native void a(boolean z);

    @Override // com.bun.supplier.InnerIdSupplier
    public native boolean a();

    @Override // com.bun.miitmdid.c.e.a
    public native void b();

    @Override // com.bun.supplier.IdSupplier
    public native String getAAID();

    @Override // com.bun.supplier.IdSupplier
    public native String getOAID();

    @Override // com.bun.supplier.InnerIdSupplier
    public native String getUDID();

    @Override // com.bun.supplier.IdSupplier
    public native String getVAID();

    @Override // com.bun.supplier.IdSupplier
    public native boolean isSupported();

    @Override // com.bun.supplier.InnerIdSupplier
    public native void shutDown();
}
