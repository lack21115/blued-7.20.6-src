package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.msgnotify.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fy.class */
public class fy {
    private static final String Code = "LinkedAdStatusHandler";
    private static final int I = 0;
    private static final byte[] V = new byte[0];
    private static fy Z;
    private Context B;
    private BroadcastReceiver C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fy$a.class */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (fz.Code.equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra(fz.I, false);
                    int intExtra = intent.getIntExtra(fz.Z, 0);
                    ge.V(fy.Code, "LinkedAdBroadcastReceiver playProgress " + intExtra);
                    fw fwVar = new fw();
                    fwVar.V(booleanExtra);
                    fwVar.Code(intExtra);
                    fx.Code(fwVar);
                }
            } catch (Throwable th) {
                ge.I(fy.Code, "LinkedAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    private fy(Context context) {
        if (context != null) {
            this.B = context.getApplicationContext();
        }
    }

    public static fy Code(Context context) {
        return V(context);
    }

    private static fy V(Context context) {
        fy fyVar;
        synchronized (fy.class) {
            try {
                synchronized (V) {
                    if (Z == null) {
                        Z = new fy(context);
                    }
                    fyVar = Z;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fyVar;
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        ge.Code(Code, "registerPpsReceiver ");
        if (this.C != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fy.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter(fz.Code);
                intentFilter.addAction(fz.V);
                fy.this.C = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.v.B(fy.this.B)) {
                    fy.this.B.registerReceiver(fy.this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    b.Code(fy.this.B, com.huawei.openalliance.ad.constant.bb.I, new NotifyCallback() { // from class: com.huawei.hms.ads.fy.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (fy.this.C != null) {
                                fy.this.C.onReceive(fy.this.B, intent);
                            }
                        }
                    });
                }
                ge.V(fy.Code, "registerPpsReceiver");
            }
        });
    }

    public void V() {
        if (this.C != null) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.fy.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ge.V(fy.Code, "unregisterPpsReceiver");
                        fy.this.B.unregisterReceiver(fy.this.C);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        b.Code(this.B, com.huawei.openalliance.ad.constant.bb.I);
    }
}
