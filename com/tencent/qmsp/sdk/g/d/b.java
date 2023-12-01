package com.tencent.qmsp.sdk.g.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.tencent.qmsp.sdk.g.d.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/d/b.class */
public class b {
    private static String e = "com.mdid.msa";

    /* renamed from: a  reason: collision with root package name */
    private c f38626a;
    private ServiceConnection b;

    /* renamed from: c  reason: collision with root package name */
    private Context f38627c;
    private com.tencent.qmsp.sdk.g.d.a d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/d/b$a.class */
    class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        c f38628a;

        a(b bVar, c cVar) {
            this.f38628a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                b.this.d = a.AbstractBinderC0997a.a(iBinder);
                new d(b.this.d, this.f38628a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.d = null;
            b.this.d = null;
        }
    }

    public b(Context context, c cVar) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f38627c = context;
        this.f38626a = cVar;
        this.b = new a(this, cVar);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(e, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) != null) {
            }
        } catch (Exception e2) {
        }
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo(e, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public String a() {
        try {
            return this.d == null ? "" : this.d.b();
        } catch (Exception e2) {
            return "";
        }
    }

    public void a(String str) {
        c cVar;
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        if (this.f38627c.bindService(intent, this.b, 1) || (cVar = this.f38626a) == null) {
            return;
        }
        cVar.g();
    }

    public String b() {
        try {
            return this.d == null ? "" : this.d.a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public boolean c() {
        try {
            if (this.d == null) {
                return false;
            }
            return this.d.d();
        } catch (Exception e2) {
            return false;
        }
    }

    public void d() {
        com.tencent.qmsp.sdk.g.d.a aVar = this.d;
        if (aVar != null) {
            try {
                aVar.e();
                if (this.b != null) {
                    this.f38627c.unbindService(this.b);
                }
            } catch (Exception e2) {
            }
            this.b = null;
            this.d = null;
        }
    }
}
