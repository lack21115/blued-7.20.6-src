package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.tmsqmsp.oaid2.f;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/i.class */
public class i {
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public f f25944c;
    public g d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f25943a = false;
    public ServiceConnection e = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/i$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.a("HSDID did service binded");
            i.this.f25944c = f.a.a(iBinder);
            i.this.a(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            i.this.a(false);
        }
    }

    public i(Context context) {
        this.b = context;
    }

    public void a() {
        try {
            if (!this.f25943a || this.e == null || this.b == null) {
                return;
            }
            c.a("HSDID start to unbind did service");
            this.f25943a = false;
            this.b.unbindService(this.e);
        } catch (Exception e) {
            c.b("HSDID error:" + e.getMessage());
        }
    }

    public void a(g gVar) {
        try {
            this.d = gVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            c.a("HSDID start to bind did service");
            boolean bindService = this.b.bindService(intent2, this.e, 1);
            this.f25943a = bindService;
            if (bindService) {
                return;
            }
            this.d.b();
        } catch (Exception e) {
            a(false);
        }
    }

    public final void a(boolean z) {
        if (!z) {
            this.d.b();
            return;
        }
        try {
            this.d.a(this.f25944c);
        } catch (Exception e) {
            c.b("HSDID notify did bind status error :" + e.getMessage());
        }
    }
}
