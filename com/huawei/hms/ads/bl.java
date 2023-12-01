package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bl.class */
public class bl extends be {
    private static final String Z = "JsbReportShowEvent";

    public bl() {
        super(ai.j);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.bl.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i;
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    if (adEventReport2.I()) {
                        ko.Code(context, adContentData, adEventReport.Z().longValue(), adEventReport.B().intValue());
                    } else if (adContentData == null) {
                        i = 3002;
                    } else if (bl.this.Code(adContentData)) {
                        ko.Code(context, adContentData, adEventReport.Z(), adEventReport.B(), adEventReport.C(), adEventReport.m());
                    } else {
                        ge.V(bl.Z, "ad is not in whitelist");
                        i = 3004;
                    }
                    i = 1000;
                } else {
                    i = 3001;
                }
                af.Code(remoteCallResultCallback, bl.this.Code, i, null, true);
            }
        });
    }
}
