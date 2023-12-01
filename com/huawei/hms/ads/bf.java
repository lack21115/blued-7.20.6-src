package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.inner.AdEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/bf.class */
public class bf extends be {
    private static final String Z = "JsbReportClickEvent";

    public bf() {
        super(ai.l);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        ge.Code(Z, "start");
        final AdEventReport adEventReport = (AdEventReport) com.huawei.openalliance.ad.utils.z.Code(str, AdEventReport.class, new Class[0]);
        Code(context, str, true, new ab() { // from class: com.huawei.hms.ads.bf.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                int i;
                String str2;
                String str3;
                int i2;
                if (adContentData == null) {
                    ge.V(bf.Z, "ad not exist");
                    i = 3002;
                } else if (bf.this.Code(adContentData)) {
                    String str4 = com.huawei.openalliance.ad.constant.s.f9348a;
                    int i3 = 13;
                    AdEventReport adEventReport2 = adEventReport;
                    int i4 = 0;
                    if (adEventReport2 != null) {
                        i2 = adEventReport2.c();
                        i4 = adEventReport.d();
                        if (!TextUtils.isEmpty(adEventReport.e())) {
                            str4 = adEventReport.e();
                        }
                        if (adEventReport.C() != null) {
                            i3 = adEventReport.C().intValue();
                        }
                        String str5 = str4;
                        str3 = adEventReport.k();
                        str2 = str5;
                    } else {
                        str2 = com.huawei.openalliance.ad.constant.s.f9348a;
                        str3 = null;
                        i2 = 0;
                        i3 = 13;
                    }
                    Context context2 = context;
                    ko.Code(context2, adContentData, str3, i2, i4, str2, i3, b.Code(context2), bf.this.C(str));
                    i = 1000;
                } else {
                    ge.V(bf.Z, "ad is not in whitelist");
                    i = 3004;
                }
                af.Code(remoteCallResultCallback, bf.this.Code, i, null, true);
            }
        });
    }
}
