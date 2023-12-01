package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bi.class */
public class bi extends be {
    private static final String Z = "JsbReportPlayPauseEvent";

    public bi() {
        super(ai.j);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.bi.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                AdEventReport adEventReport2 = adEventReport;
                if (adEventReport2 != null) {
                    long j = 0;
                    long longValue = adEventReport2.D() == null ? 0L : adEventReport.D().longValue();
                    if (adEventReport.L() != null) {
                        j = adEventReport.L().longValue();
                    }
                    int i = 0;
                    int intValue = adEventReport.a() == null ? 0 : adEventReport.a().intValue();
                    if (adEventReport.b() != null) {
                        i = adEventReport.b().intValue();
                    }
                    ko.Code(context, adContentData, com.huawei.openalliance.ad.constant.ac.C, Long.valueOf(longValue), Long.valueOf(j), Integer.valueOf(intValue), Integer.valueOf(i));
                }
                bi.this.V(remoteCallResultCallback, true);
            }
        });
    }
}
