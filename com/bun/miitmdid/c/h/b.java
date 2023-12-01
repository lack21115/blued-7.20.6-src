package com.bun.miitmdid.c.h;

import android.content.Context;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/h/b.class */
public class b implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f21146a;

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/h/b$a.class */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SupplierListener f21147a;

        a(SupplierListener supplierListener) {
            this.f21147a = supplierListener;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public b(Context context) {
        this.f21146a = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(SupplierListener supplierListener);

    @Override // com.bun.supplier.InnerIdSupplier
    public native boolean a();

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
