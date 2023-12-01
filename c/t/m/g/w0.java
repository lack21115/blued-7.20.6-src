package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import c.t.m.g.v0;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w0.class */
public class w0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f4031a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f4032c = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w0$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                w0.this.b.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public w0(Context context) {
        this.f4031a = context;
    }

    public void a(v0.b bVar) {
        try {
            this.f4031a.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e) {
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (this.f4031a.bindService(intent, this.f4032c, 1)) {
            try {
                g1 g1Var = new g1(this.b.take(), this.f4031a);
                String f = g1Var.f();
                g1Var.e();
                g1Var.g();
                boolean a2 = a();
                if (bVar != null) {
                    bVar.a(f, a2);
                }
            } catch (Exception e2) {
            } catch (Throwable th) {
                this.f4031a.unbindService(this.f4032c);
                throw th;
            }
            this.f4031a.unbindService(this.f4032c);
        }
    }

    public boolean a() {
        try {
            PackageManager packageManager = this.f4031a.getPackageManager();
            packageManager.getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}
