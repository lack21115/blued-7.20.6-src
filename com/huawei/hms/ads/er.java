package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.msgnotify.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/er.class */
public class er {
    private static er I;
    private static final byte[] V = new byte[0];
    private BroadcastReceiver B;
    private Context Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/er$a.class */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED".equals(intent.getAction())) {
                    fk.Code(context).B(intent.getStringExtra("splash_interact_close_expiretime"));
                }
            } catch (Throwable th) {
                ge.I("SplashAdInteractConfigHandler", "SplashAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
            er.I.V();
        }
    }

    private er(Context context) {
        if (context != null) {
            this.Z = context.getApplicationContext();
        }
    }

    public static er Code(Context context) {
        return V(context);
    }

    private static er V(Context context) {
        er erVar;
        synchronized (er.class) {
            try {
                synchronized (V) {
                    if (I == null) {
                        I = new er(context);
                    }
                    erVar = I;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return erVar;
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        ge.Code("SplashAdInteractConfigHandler", "registerPpsReceiver ");
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.er.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED");
                er.this.B = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.v.B(er.this.Z)) {
                    er.this.Z.registerReceiver(er.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    b.Code(er.this.Z, com.huawei.openalliance.ad.constant.bb.Z, new NotifyCallback() { // from class: com.huawei.hms.ads.er.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (er.this.B != null) {
                                er.this.B.onReceive(er.this.Z, intent);
                            }
                        }
                    });
                }
                ge.V("SplashAdInteractConfigHandler", "registerPpsReceiver");
            }
        });
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.er.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ge.V("SplashAdInteractConfigHandler", "unregisterPpsReceiver");
                        er.this.Z.unregisterReceiver(er.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }
}
