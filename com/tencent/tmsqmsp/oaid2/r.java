package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.tencent.tmsqmsp.oaid2.q;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/r.class */
public class r {
    public static String e = "com.mdid.msa";

    /* renamed from: a  reason: collision with root package name */
    public s f39660a;
    public ServiceConnection b;

    /* renamed from: c  reason: collision with root package name */
    public Context f39661c;
    public q d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/r$a.class */
    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public s f39662a;

        public a(r rVar, s sVar) {
            this.f39662a = sVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                r.this.d = q.a.a(iBinder);
                new t(r.this.d, this.f39662a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            r.this.d = null;
            r.this.d = null;
        }
    }

    public r(Context context, s sVar) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f39661c = context;
        this.f39660a = sVar;
        this.b = new a(this, sVar);
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
            q qVar = this.d;
            return qVar == null ? "" : qVar.d();
        } catch (Exception e2) {
            return "";
        }
    }

    public void a(String str) {
        s sVar;
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        if (this.f39661c.bindService(intent, this.b, 1) || (sVar = this.f39660a) == null) {
            return;
        }
        sVar.b();
    }

    public String b() {
        try {
            q qVar = this.d;
            return qVar == null ? "" : qVar.a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public boolean c() {
        try {
            q qVar = this.d;
            if (qVar == null) {
                return false;
            }
            return qVar.g();
        } catch (Exception e2) {
            return false;
        }
    }

    public void d() {
        q qVar = this.d;
        if (qVar != null) {
            try {
                qVar.f();
                ServiceConnection serviceConnection = this.b;
                if (serviceConnection != null) {
                    this.f39661c.unbindService(serviceConnection);
                }
            } catch (Exception e2) {
            }
            this.b = null;
            this.d = null;
        }
    }
}
