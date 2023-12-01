package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.msgnotify.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/eq.class */
public class eq {
    private static eq V;
    private static final byte[] Z = new byte[0];
    private BroadcastReceiver B;
    private Context I;

    /* renamed from: com.huawei.hms.ads.eq$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/eq$1.class */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED");
            eq.this.B = new a(null);
            if (com.huawei.openalliance.ad.utils.v.B(eq.this.I)) {
                eq.this.I.registerReceiver(eq.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            } else {
                b.Code(eq.this.I, com.huawei.openalliance.ad.constant.bb.Code, new NotifyCallback() { // from class: com.huawei.hms.ads.eq.1.1
                    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                    public void onMessageNotify(String str, final Intent intent) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.eq.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (eq.this.B != null) {
                                    eq.this.B.onReceive(eq.this.I, intent);
                                }
                            }
                        });
                    }
                });
            }
            ge.V("RewardAdStatusHandler", "registerPPSReceiver");
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/eq$a.class */
    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean Code(int i, com.huawei.openalliance.ad.inter.listeners.g gVar) {
            if (gVar == null) {
                return false;
            }
            if (8 == i) {
                gVar.S();
                return true;
            } else if (9 == i) {
                gVar.C();
                return true;
            } else {
                return false;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            ge.V("RewardAdStatusHandler", "onReceive:" + intent.getAction());
            if ("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED".equals(intent.getAction())) {
                try {
                    com.huawei.openalliance.ad.inter.data.i Code = eo.Code();
                    if (Code != null && (Code instanceof com.huawei.openalliance.ad.inter.data.s)) {
                        com.huawei.openalliance.ad.inter.data.s sVar = (com.huawei.openalliance.ad.inter.data.s) Code;
                        com.huawei.openalliance.ad.inter.listeners.f Q = sVar.Q();
                        com.huawei.openalliance.ad.inter.listeners.g I = sVar.I();
                        int intExtra = intent.getIntExtra("reward_ad_status", -1);
                        String stringExtra = intent.getStringExtra(com.huawei.openalliance.ad.constant.at.e);
                        ge.V("RewardAdStatusHandler", "status:" + intExtra);
                        if (Code(intExtra, I)) {
                            return;
                        }
                        if (Q == null) {
                            ge.I("RewardAdStatusHandler", "there is no status listener");
                            return;
                        }
                        switch (intExtra) {
                            case 1:
                                Q.Code();
                                sVar.V(true);
                                return;
                            case 2:
                                Q.V();
                                return;
                            case 3:
                                Q.I();
                                return;
                            case 4:
                                Q.Z();
                                return;
                            case 5:
                                if (sVar.C()) {
                                    return;
                                }
                                Q.B();
                                sVar.Code(true);
                                AdContentData l = sVar.l();
                                l.V(stringExtra);
                                ko.Code(context, l, sVar.E(), sVar.G(), "");
                                return;
                            case 6:
                                Q.Code(intent.getIntExtra("reward_ad_error", -1), intent.getIntExtra("reward_ad_extra", -1));
                                return;
                            case 7:
                                if (eq.V != null) {
                                    eq.V.V();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    ge.I("RewardAdStatusHandler", "can not get reward");
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder();
                    sb.append("handler reward status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    ge.Z("RewardAdStatusHandler", sb.toString());
                } catch (Throwable th) {
                    e = th;
                    sb = new StringBuilder();
                    sb.append("handler reward status changed error,");
                    sb.append(e.getClass().getSimpleName());
                    ge.Z("RewardAdStatusHandler", sb.toString());
                }
            }
        }
    }

    private eq(Context context) {
        this.I = context.getApplicationContext();
    }

    public static eq Code(Context context) {
        return V(context);
    }

    private static eq V(Context context) {
        eq eqVar;
        synchronized (Z) {
            if (V == null) {
                V = new eq(context);
            }
            eqVar = V;
        }
        return eqVar;
    }

    public void Code() {
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new AnonymousClass1());
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.eq.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ge.V("RewardAdStatusHandler", "unregisterPPSReceiver");
                        eq.this.I.unregisterReceiver(eq.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        b.Code(this.I, com.huawei.openalliance.ad.constant.bb.Code);
    }
}
