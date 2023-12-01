package com.bun.miitmdid.supplier.msa;

import android.os.AsyncTask;
import com.bun.lib.c;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/supplier/msa/a.class */
public class a extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public c f21163a;
    public com.bun.miitmdid.c.e.a b;

    public a(c cVar, com.bun.miitmdid.c.e.a aVar) {
        this.f21163a = cVar;
        this.b = aVar;
    }

    protected native Boolean a(Void... voidArr);

    protected native void a(Boolean bool);

    @Override // android.os.AsyncTask
    protected native /* bridge */ /* synthetic */ Boolean doInBackground(Void[] voidArr);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public native /* bridge */ /* synthetic */ void onPostExecute(Boolean bool);
}
