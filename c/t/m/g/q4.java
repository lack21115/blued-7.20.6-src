package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/q4.class */
public class q4 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final t3 f3899a;
    public boolean b;

    public q4(t3 t3Var) {
        this.f3899a = t3Var;
    }

    public void a() {
        if (this.b) {
            this.b = false;
            try {
                this.f3899a.f3944a.unregisterReceiver(this);
            } catch (Exception e) {
            }
        }
    }

    public final void a(Handler handler) {
        if (handler != null) {
            try {
                this.f3899a.f3944a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler);
            } catch (Exception e) {
            }
        }
    }

    public void b(Handler handler) {
        if (this.b) {
            return;
        }
        this.b = true;
        a(handler);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)) {
                this.f3899a.a((Object) (-1));
            } else if (a6.c(context)) {
                this.f3899a.a((Object) 1);
            } else {
                this.f3899a.a((Object) 0);
            }
        } catch (Exception e) {
        }
    }
}
