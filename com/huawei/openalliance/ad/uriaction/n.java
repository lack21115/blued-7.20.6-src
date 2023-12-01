package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.km;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/n.class */
public class n extends q {
    private static final String Code = "OuterWebAction";

    public n(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private String Z() {
        for (String str : fk.Code(this.I).l()) {
            if (com.huawei.openalliance.ad.utils.e.Code(this.I, str)) {
                return str;
            }
        }
        return "";
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        if (this.Z == null || !(km.Code(this.Z.r()) || ai.Z(this.I))) {
            return V();
        }
        ge.V(Code, "handle outer browser action");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String e = this.Z.e();
        if (!au.Code(e)) {
            intent.setData(Uri.parse(e));
            if (!(this.I instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                if (km.V(this.Z.r())) {
                    ge.Code(Code, "handleUri, use default browser");
                    String Z = Z();
                    if (TextUtils.isEmpty(Z)) {
                        ge.I(Code, "can not find default browser");
                    } else {
                        intent.setPackage(Z);
                    }
                }
                PackageManager packageManager = this.I.getPackageManager();
                if (packageManager != null && !packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                    intent.setClipData(t.cF);
                    this.I.startActivity(intent);
                    Code(s.B);
                    return true;
                }
            } catch (ActivityNotFoundException e2) {
                ge.Z(Code, "fail to open uri");
            } catch (Throwable th) {
                ge.Z(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            }
        }
        return V();
    }
}
