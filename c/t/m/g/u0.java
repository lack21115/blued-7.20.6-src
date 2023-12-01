package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.t.m.g.v0;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u0.class */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f4002a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f4003c = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/u0$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                u0.this.b.put(iBinder);
            } catch (Exception e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public u0(Context context) {
        this.f4002a = context;
    }

    public void a(v0.b bVar) {
        try {
            this.f4002a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e) {
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.f4002a.bindService(intent, this.f4003c, 1)) {
            try {
                f1 f1Var = new f1(this.b.take());
                String e2 = f1Var.e();
                boolean f = f1Var.f();
                if (bVar != null) {
                    bVar.a(e2, f);
                }
            } catch (Exception e3) {
            }
        }
    }
}
