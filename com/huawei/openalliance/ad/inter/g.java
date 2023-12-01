package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.huawei.hms.ads.dr;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.utils.z;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/inter/g.class */
public final class g implements h {
    private static final byte[] I = new byte[0];
    private static g V;
    private fk B;
    private AdSlotParam C;
    private com.huawei.openalliance.ad.inter.listeners.e F;
    private Integer S = null;
    private Context Z;

    private g(Context context) {
        this.Z = context.getApplicationContext();
        this.B = fk.Code(context);
        if (dt.V(this.Z)) {
            IntentFilter intentFilter = new IntentFilter(t.bj);
            Intent registerReceiver = this.Z.registerReceiver(null, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (registerReceiver != null && registerReceiver.getAction() != null && registerReceiver.getAction().equals(t.bj)) {
                Log.d("HiAdSplash", "HiAd: getIntent");
                new c(this.Z).onReceive(this.Z, registerReceiver);
            }
            this.Z.registerReceiver(new c(this.Z), intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            d.Code(this.Z).V();
        }
    }

    public static h Code(Context context) {
        return I(context);
    }

    private static h I(Context context) {
        g gVar;
        synchronized (I) {
            if (V == null) {
                V = new g(context);
            }
            gVar = V;
        }
        return gVar;
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public com.huawei.openalliance.ad.inter.listeners.e C() {
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public void C(int i) {
        if (1 == i || 2 == i) {
            fk.Code(this.Z).S(i);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public void Code() {
        Z(this.C);
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public Integer I() {
        return this.S;
    }

    public void I(AdSlotParam adSlotParam) {
        if (adSlotParam != null) {
            this.C = adSlotParam.g();
        }
    }

    public void Z(final AdSlotParam adSlotParam) {
        ge.V("HiAdSplash", "preloadAd request");
        if (adSlotParam != null) {
            ge.V("HiAdSplash", "request preload splash ad");
            com.huawei.openalliance.ad.utils.f.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.g.2
                @Override // java.lang.Runnable
                public void run() {
                    adSlotParam.Code(true);
                    adSlotParam.I(g.this.S);
                    AdSlotParam adSlotParam2 = adSlotParam;
                    adSlotParam2.Code(dr.Code(adSlotParam2.B()));
                    if (dt.Code(g.this.Z).V()) {
                        adSlotParam.I(com.huawei.openalliance.ad.utils.a.Code(g.this.Z));
                    }
                    adSlotParam.a(com.huawei.openalliance.ad.utils.c.d(g.this.Z));
                    adSlotParam.Z(com.huawei.hms.ads.f.Code());
                    com.huawei.openalliance.ad.ipc.g.V(g.this.Z).Code("reqPreSplashAd", z.V(adSlotParam), null, null);
                }
            });
            ac.Code(this.Z, adSlotParam.B());
        }
    }
}
