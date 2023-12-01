package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.constant.ac;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/b.class */
public class b extends q {
    private static final String Code = "AppDeepLinkAction";

    public b(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void Z() {
        ko.Code(this.I, this.Z, ac.D, (Integer) 3, Integer.valueOf(com.huawei.openalliance.ad.utils.e.Code(this.I, this.Z.u().i()) ? 2 : 1));
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        String str;
        ge.V(Code, "handle AppDeepLinkAction");
        try {
        } catch (ActivityNotFoundException e) {
            str = "activity not exist";
            ge.I(Code, str);
            Z();
            return V();
        } catch (Exception e2) {
            str = "handle intent url fail";
            ge.I(Code, str);
            Z();
            return V();
        }
        if (this.Z != null && this.Z.u() != null) {
            AppInfo u = this.Z.u();
            Intent V = com.huawei.openalliance.ad.utils.e.V(this.I, u.h(), u.i());
            if (V == null) {
                ge.I(Code, "cannot find target activity");
                Z();
                return V();
            }
            if (!(this.I instanceof Activity)) {
                V.addFlags(268435456);
            }
            V.setClipData(t.cF);
            this.I.startActivity(V);
            if (!TextUtils.isEmpty(u.Code())) {
                AppDownloadTask Code2 = new AppDownloadTask.a().Code(u).Code();
                Code2.Code(this.Z);
                Code2.I(System.currentTimeMillis());
                com.huawei.openalliance.ad.download.app.l.Code(this.I).Code(u.Code(), Code2);
            }
            Code(s.Code);
            ko.Code(this.I, this.Z, "intentSuccess", (Integer) 3, (Integer) null);
            return true;
        }
        ge.V(Code, "getAppInfo is null");
        return V();
    }
}
