package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/o.class */
public class o extends q {
    private static final String Code = "OuterWebCCTAction";

    public o(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        if (this.Z == null || !(km.Code(this.Z.r()) || ai.Z(this.I))) {
            return V();
        }
        ge.Code(Code, "handleUri by cct, pkgName is : %s", this.I.getPackageName());
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String e = this.Z.e();
        if (!au.Code(e)) {
            Uri parse = Uri.parse(e);
            intent.setData(parse);
            if (!(this.I instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                kv.Code().Code(this.I, parse, true);
                Code(s.B);
                return true;
            } catch (ActivityNotFoundException e2) {
                ge.Z(Code, "fail to open uri by cct");
            } catch (Throwable th) {
                ge.Z(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            }
        }
        return V();
    }
}
