package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.constant.bc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.ads.do  reason: invalid class name */
/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/do.class */
public class Cdo extends ISplashApi.b {
    private gz l;
    private AdContentData m;
    private WeakReference<Context> n;
    private Context o;

    public Cdo(Context context, gz gzVar, AdContentData adContentData) {
        this.o = context.getApplicationContext();
        this.n = new WeakReference<>(context);
        this.l = gzVar;
        this.m = adContentData;
    }

    private int Code(int i) {
        Integer L = com.huawei.openalliance.ad.utils.v.L(this.o);
        int i2 = i;
        if (!com.huawei.openalliance.ad.utils.v.I()) {
            if (L != null && L.intValue() >= 30454100) {
                return i;
            }
            ge.V("SplashProxy", "HMS version is low, interactMode is %s", Integer.valueOf(i));
            int i3 = i;
            if (i == 4) {
                i3 = 1;
            }
            i2 = i3;
            if (i3 == 3) {
                i2 = 2;
            }
        }
        return i2;
    }

    private void Code(Bundle bundle) {
        boolean z = bundle.getBoolean(bc.e.k);
        AdEventReport Code = ko.Code(this.m);
        Code.V(z);
        com.huawei.openalliance.ad.ipc.g.V(this.o).Code(com.huawei.openalliance.ad.constant.p.i, com.huawei.openalliance.ad.utils.z.V(Code), null, null);
    }

    private void I(Bundle bundle) {
        ko.Code(this.o, this.m, com.huawei.openalliance.ad.constant.ac.Z, Long.valueOf(bundle.getLong("startTime")), Long.valueOf(bundle.getLong("endTime")), Integer.valueOf((int) bundle.getLong(bc.e.h)), Integer.valueOf((int) bundle.getLong(bc.e.i)));
    }

    private void V(Bundle bundle) {
        ko.Code(this.o, this.m, com.huawei.openalliance.ad.constant.ac.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    private void Z(Bundle bundle) {
        eh.Code(this.o, bundle.getInt(bc.e.l), bundle.getString("reason"), this.m);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isDestroyed() {
        Context context = this.n.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isDestroyed();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean isFinishing() {
        Context context = this.n.get();
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        return ((Activity) context).isFinishing();
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdDismissed() {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.L();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void notifyAdFailedToLoad(int i) {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.I(i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public String notifyAdLoaded() {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.Code(this.m);
            return null;
        }
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdFailToDisplay() {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.l();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onAdShowEnd(long j, int i) {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.Code(this.m, j, i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onDisplayTimeUp() {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.i();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onEasterEggPrepare() {
        kr.Code(this.o).Code(this.m);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onFeedback(int i) {
        ge.V("SplashProxy", "onFeedback");
        er.Code(this.o).Code();
        eh.Code(this.o);
        Intent intent = new Intent();
        intent.setAction(com.huawei.openalliance.ad.constant.t.ag);
        intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(this.o));
        intent.putExtra(com.huawei.openalliance.ad.constant.at.ah, Code(i));
        if (!(this.o instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.huawei.openalliance.ad.utils.ay.Code(this.o, intent);
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.B();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoadFailed() {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.Z(this.m);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onMaterialLoaded() {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.S();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onSkipAd(int i, int i2) {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.Code(i, i2);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void onStartEasterEggFailed(Bundle bundle) {
        kr.Code(this.o).I(this.m, bundle);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public boolean onTouch(int i, int i2, long j, String str, int i3) {
        ge.V("SplashProxy", "onTouch");
        gz gzVar = this.l;
        boolean z = false;
        if (gzVar != null) {
            z = gzVar.Code(i, i2, this.m, Long.valueOf(j), (com.huawei.openalliance.ad.inter.data.m) com.huawei.openalliance.ad.utils.z.V(str, com.huawei.openalliance.ad.inter.data.m.class, new Class[0]), i3);
        }
        return z;
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void removeExSplashBlock() {
        com.huawei.openalliance.ad.utils.ax.V(this.o);
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportEvents(String str, Bundle bundle) {
        if (com.huawei.openalliance.ad.utils.au.Code(str)) {
            return;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case -1888605810:
                if (str.equals(com.huawei.openalliance.ad.constant.ac.B)) {
                    z = true;
                    break;
                }
                break;
            case -1694029870:
                if (str.equals(com.huawei.openalliance.ad.constant.p.q)) {
                    z = true;
                    break;
                }
                break;
            case -493598457:
                if (str.equals(com.huawei.openalliance.ad.constant.ac.Z)) {
                    z = true;
                    break;
                }
                break;
            case 886907255:
                if (str.equals(com.huawei.openalliance.ad.constant.p.i)) {
                    z = false;
                    break;
                }
                break;
        }
        if (!z) {
            Code(bundle);
        } else if (z) {
            V(bundle);
        } else if (z) {
            I(bundle);
        } else if (!z) {
        } else {
            Z(bundle);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void reportShowStartEvent() {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.D();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void toShowSpare(int i) {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.V(i);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.ISplashApi
    public void updatePhyShowStart(long j) {
        gz gzVar = this.l;
        if (gzVar != null) {
            gzVar.Code(j);
        }
    }
}
