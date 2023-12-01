package com.tencent.tmsqmsp.sdk.g.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.tencent.tmsqmsp.sdk.g.d.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/d/b.class */
public class b {
    private static String e = "com.mdid.msa";

    /* renamed from: a  reason: collision with root package name */
    private c f26085a;
    private ServiceConnection b;

    /* renamed from: c  reason: collision with root package name */
    private Context f26086c;
    private com.tencent.tmsqmsp.sdk.g.d.a d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/d/b$a.class */
    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public c f26087a;

        public a(b bVar, c cVar) {
            this.f26087a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                b.this.d = a.AbstractBinderC0884a.a(iBinder);
                new d(b.this.d, this.f26087a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
        this.f26086c = context;
        this.f26085a = cVar;
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
            com.tencent.tmsqmsp.sdk.g.d.a aVar = this.d;
            return aVar == null ? "" : aVar.b();
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
        if (this.f26086c.bindService(intent, this.b, 1) || (cVar = this.f26085a) == null) {
            return;
        }
        cVar.g();
    }

    public String b() {
        try {
            com.tencent.tmsqmsp.sdk.g.d.a aVar = this.d;
            return aVar == null ? "" : aVar.a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public boolean c() {
        try {
            com.tencent.tmsqmsp.sdk.g.d.a aVar = this.d;
            if (aVar == null) {
                return false;
            }
            return aVar.d();
        } catch (Exception e2) {
            return false;
        }
    }

    public void d() {
        com.tencent.tmsqmsp.sdk.g.d.a aVar = this.d;
        if (aVar != null) {
            try {
                aVar.e();
                ServiceConnection serviceConnection = this.b;
                if (serviceConnection != null) {
                    this.f26086c.unbindService(serviceConnection);
                }
            } catch (Exception e2) {
            }
            this.b = null;
            this.d = null;
        }
    }
}
