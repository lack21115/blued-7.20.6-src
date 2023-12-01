package com.tencent.qmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.IBinder;
import com.tencent.qmsp.oaid2.q;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/r.class */
public class r {
    public static String e = "com.mdid.msa";

    /* renamed from: a  reason: collision with root package name */
    public s f38501a;
    public ServiceConnection b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38502c;
    public q d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/r$a.class */
    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public s f38503a;

        public a(r rVar, s sVar) {
            this.f38503a = sVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                r.this.d = q.a.a(iBinder);
                new t(r.this.d, this.f38503a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
        this.f38502c = context;
        this.f38501a = sVar;
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
            return this.d == null ? "" : this.d.d();
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
        if (this.f38502c.bindService(intent, this.b, 1) || (sVar = this.f38501a) == null) {
            return;
        }
        sVar.b();
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
            return this.d.g();
        } catch (Exception e2) {
            return false;
        }
    }

    public void d() {
        q qVar = this.d;
        if (qVar != null) {
            try {
                qVar.f();
                if (this.b != null) {
                    this.f38502c.unbindService(this.b);
                }
            } catch (Exception e2) {
            }
            this.b = null;
            this.d = null;
        }
    }
}
