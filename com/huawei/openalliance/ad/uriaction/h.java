package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.bb;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/h.class */
public class h extends q {
    private static final String Code = "HarmonyServiceAction";

    public h(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        try {
            ge.V(Code, "handle harmony service action");
            AppInfo u = this.Z.u();
            if (u == null || TextUtils.isEmpty(u.Code()) || TextUtils.isEmpty(u.s())) {
                ge.V(Code, "parameters occur error");
            } else if (Boolean.parseBoolean((String) bb.Code(this.I, this.Z, 12, String.class))) {
                Code(s.I);
                return true;
            }
        } catch (Throwable th) {
            ge.I(Code, "handle uri exception: %s", th.getClass().getSimpleName());
        }
        return V();
    }
}
