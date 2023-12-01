package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.tools.net.NetResponse;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/of.class */
public class of extends AsyncTask<Object, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f37677a;
    private WeakReference<a> b;

    /* renamed from: c  reason: collision with root package name */
    private vh f37678c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/of$a.class */
    public interface a {
        void a(boolean z, vh vhVar);
    }

    public of(h1 h1Var, a aVar) {
        this.f37677a = new WeakReference<>(h1Var.j());
        this.f37678c = h1Var.l().u();
        this.b = new WeakReference<>(aVar);
    }

    private boolean a(Context context, String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.f37678c.b(context, str);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Object... objArr) {
        if (this.f37677a.get() == null) {
            return Boolean.FALSE;
        }
        Context context = this.f37677a.get();
        try {
            NetResponse checkAuth = ((a3) ((o3) n2.a(o3.class)).d()).checkAuth(c7.t(), c7.F(), this.f37678c.j(), c7.A(), this.f37678c.a(), 3, this.f37678c.e());
            if (checkAuth != null && checkAuth.available()) {
                return Boolean.valueOf(a(context, checkAuth.toString()));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            na.a(th.getMessage(), th);
            return Boolean.FALSE;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        WeakReference<a> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.b.get().a(bool.booleanValue(), this.f37678c);
    }
}
