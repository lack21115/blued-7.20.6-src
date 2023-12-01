package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.constant.ac;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/i.class */
public class i extends q {
    private static final String C = "HwMarketAction";
    public static final String Code = "appId";
    private static final String F = "com.huawei.appmarket";
    private static final String S = "com.huawei.appmarket.appmarket.intent.action.AppDetail.withid";
    public static final String V = "thirdId";
    private String D;
    private String L;

    public i(Context context, AdContentData adContentData, Map<String, String> map) {
        super(context, adContentData);
        this.D = map.get("appId");
        this.L = map.get(V);
    }

    private void Z() {
        ko.Code(this.I, this.Z, ac.D, (Integer) 3, Integer.valueOf(com.huawei.openalliance.ad.utils.e.Code(this.I, "com.huawei.appmarket") ? 2 : 1));
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        ge.V(C, "handle hw app market action");
        Intent intent = new Intent(S);
        intent.setPackage("com.huawei.appmarket");
        intent.putExtra("appId", this.D);
        intent.putExtra(V, this.L);
        if (!(this.I instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            PackageManager packageManager = this.I.getPackageManager();
            if (packageManager != null && !packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                intent.setClipData(t.cF);
                this.I.startActivity(intent);
                Code(s.Code);
                ko.Code(this.I, this.Z, "intentSuccess", (Integer) 3, (Integer) null);
                return true;
            }
        } catch (ActivityNotFoundException e) {
            ge.Z(C, "fail to open market detail page");
        }
        Z();
        return V();
    }
}
