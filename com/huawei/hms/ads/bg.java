package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bg.class */
public class bg extends be {
    private static final String Z = "JsbReportCloseEvent";

    public bg() {
        super(ai.m);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.Code(Z, Z);
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bg.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                if (adContentData != null) {
                    List<String> list = null;
                    AdEventReport adEventReport2 = adEventReport;
                    if (adEventReport2 != null) {
                        list = adEventReport2.f();
                    }
                    ko.Code(context, adContentData, 0, 0, list);
                    bg.this.V(remoteCallResultCallback, true);
                }
            }
        });
    }
}
