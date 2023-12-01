package com.huawei.openalliance.ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.t;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/d.class */
public class d {
    private static d I;
    private static final byte[] Z = new byte[0];
    private Context B;
    private a S;
    private boolean V = false;
    private CopyOnWriteArrayList<WeakReference<b>> C = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/d$a.class */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ge.V("ExSplashStartReceiver", "onReceive");
            if (intent == null) {
                return;
            }
            try {
                if (t.bk.equals(intent.getAction())) {
                    d.this.V = true;
                    d.this.Z();
                    context.removeStickyBroadcast(intent);
                }
            } catch (Throwable th) {
                ge.I("ExSplashStartReceiver", "ExSplashBeginReceiver err: %s", th.getClass().getSimpleName());
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/d$b.class */
    public interface b {
        void Code();
    }

    private d(Context context) {
        this.B = context.getApplicationContext();
    }

    public static d Code(Context context) {
        d dVar;
        synchronized (Z) {
            if (I == null) {
                I = new d(context);
            }
            dVar = I;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        if (this.C.isEmpty()) {
            return;
        }
        Iterator<WeakReference<b>> it = this.C.iterator();
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            if (next.get() != null) {
                next.get().Code();
            }
        }
    }

    public void Code(b bVar) {
        if (bVar != null) {
            this.C.add(new WeakReference<>(bVar));
        }
    }

    public void Code(boolean z) {
        this.V = z;
    }

    public void I() {
        String str;
        try {
            ge.V("ExSplashStartReceiver", "unregister receiver");
            if (this.S != null) {
                this.B.unregisterReceiver(this.S);
                this.S = null;
            }
        } catch (IllegalStateException e) {
            str = "unregisterReceiver IllegalStateException";
            ge.I("ExSplashStartReceiver", str);
        } catch (Throwable th) {
            str = "unregisterReceiver exception";
            ge.I("ExSplashStartReceiver", str);
        }
    }

    public void V() {
        String str;
        try {
            I();
            if (!dt.B(this.B)) {
                ge.I("ExSplashStartReceiver", "not inner device, no need to register");
                return;
            }
            IntentFilter intentFilter = new IntentFilter(t.bk);
            Intent registerReceiver = this.B.registerReceiver(null, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (registerReceiver != null && registerReceiver.getAction() != null && registerReceiver.getAction().equals(t.bk)) {
                ge.V("ExSplashStartReceiver", "isExSplashStart");
                this.V = true;
                this.B.removeStickyBroadcast(registerReceiver);
            }
            if (this.S == null) {
                this.S = new a();
            }
            ge.V("ExSplashStartReceiver", "register receiver");
            this.B.registerReceiver(this.S, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
        } catch (IllegalStateException e) {
            str = "registerReceiver IllegalStateException";
            ge.I("ExSplashStartReceiver", str);
        } catch (Throwable th) {
            str = "registerReceiver Exception";
            ge.I("ExSplashStartReceiver", str);
        }
    }

    public void V(b bVar) {
        try {
            if (this.C == null || this.C.size() <= 0) {
                return;
            }
            Iterator<WeakReference<b>> it = this.C.iterator();
            while (it.hasNext()) {
                WeakReference<b> next = it.next();
                b bVar2 = next.get();
                if (bVar2 == null || bVar2 == bVar) {
                    this.C.remove(next);
                }
            }
        } catch (Throwable th) {
            ge.V("ExSplashStartReceiver", "removeStartListener err: %s", th.getClass().getSimpleName());
        }
    }
}
