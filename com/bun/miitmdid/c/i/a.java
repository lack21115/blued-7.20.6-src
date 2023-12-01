package com.bun.miitmdid.c.i;

import android.content.Context;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;
import com.heytap.openid.sdk.OpenIDSDK;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/i/a.class */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f7542a;

    /* renamed from: com.bun.miitmdid.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/i/a$a.class */
    class RunnableC0133a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SupplierListener f7543a;

        RunnableC0133a(SupplierListener supplierListener) {
            this.f7543a = supplierListener;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public a(Context context) {
        OpenIDSDK.d(context);
        this.f7542a = context;
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
