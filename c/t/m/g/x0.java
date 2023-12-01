package c.t.m.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.t.m.g.v0;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x0.class */
public class x0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f3999a;
    public i1 b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f4000c = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/x0$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x0.this.b = new h1(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public x0(Context context) {
        this.f3999a = context;
    }

    public void a(v0.b bVar) {
        i1 i1Var;
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.f3999a.bindService(intent, this.f4000c, 1) || (i1Var = this.b) == null) {
            return;
        }
        String b = i1Var.b();
        boolean d = this.b.d();
        if (bVar != null) {
            bVar.a(b, d);
        }
    }
}
