package com.bun.miitmdid.c.j;

import android.content.Context;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/j/a.class */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private String f21150a = "";
    private Context b;

    /* renamed from: com.bun.miitmdid.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/j/a$a.class */
    class RunnableC0304a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SupplierListener f21151a;

        RunnableC0304a(SupplierListener supplierListener) {
            this.f21151a = supplierListener;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public a(Context context) {
        this.b = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(SupplierListener supplierListener);

    public native void a(String str);

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
