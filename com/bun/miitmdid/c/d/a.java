package com.bun.miitmdid.c.d;

import android.content.Context;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/d/a.class */
public class a implements InnerIdSupplier {

    /* renamed from: a  reason: collision with root package name */
    private Context f21137a;
    private SupplierListener f;
    private boolean e = false;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f21138c = "";
    private String d = "";

    /* renamed from: com.bun.miitmdid.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/d/a$a.class */
    class RunnableC0301a implements Runnable {
        RunnableC0301a() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public a(Context context) {
        this.f21137a = context;
    }

    static native /* synthetic */ Context a(a aVar);

    static native /* synthetic */ String a(a aVar, String str);

    private native void b();

    static native /* synthetic */ void b(a aVar);

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
