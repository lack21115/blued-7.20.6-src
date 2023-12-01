package com.bun.miitmdid.c.b;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/b/a.class */
public class a implements IDIDBinderStatusListener, InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private SupplierListener f7529a;
    private SupplementaryDIDManager f;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f7530c = "";
    private String d = "";
    private String e = "";
    private boolean g = false;
    private boolean h = false;

    public a(Context context, SupplierListener supplierListener) {
        this.f7529a = supplierListener;
        this.f = new SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public native void a(IDidAidlInterface iDidAidlInterface);

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(SupplierListener supplierListener);

    @Override // com.bun.supplier.InnerIdSupplier
    public native boolean a();

    @Override // android.os.IInterface
    public native IBinder asBinder();

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
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
