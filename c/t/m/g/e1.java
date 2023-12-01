package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.t.m.g.v0;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e1.class */
public class e1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f3750a;
    public String b = "com.mdid.msa";

    /* renamed from: c  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f3751c = new LinkedBlockingQueue<>(1);
    public ServiceConnection d = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e1$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                e1.this.f3751c.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public e1(Context context) {
        this.f3750a = context;
    }

    public final int a() {
        try {
            this.f3750a.getPackageManager().getPackageInfo(this.b, 0);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public void a(v0.b bVar) {
        try {
            this.f3750a.getPackageManager().getPackageInfo(this.b, 0);
        } catch (Exception e) {
        }
        String packageName = this.f3750a.getPackageName();
        a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        if (this.f3750a.bindService(intent, this.d, 1)) {
            try {
                l1 l1Var = new l1(this.f3751c.take());
                String c2 = l1Var.c();
                boolean a2 = l1Var.a();
                if (bVar != null) {
                    bVar.a(c2, a2);
                }
                this.f3750a.unbindService(this.d);
            } catch (Exception e2) {
            } finally {
                this.f3750a.unbindService(this.d);
            }
        }
    }

    public final void a(String str) {
        a();
        Intent intent = new Intent();
        intent.setClassName(this.b, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (this.f3750a.startService(intent) != null) {
            }
        } catch (Exception e) {
        }
    }
}
