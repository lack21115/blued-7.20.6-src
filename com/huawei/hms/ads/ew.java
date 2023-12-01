package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.m;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ew.class */
public class ew extends es {
    public static final String I = "16";
    public static final String V = "15";
    private static final String Z = "AlertReminder";

    public ew(Context context) {
        super(context);
    }

    private void I(final AppInfo appInfo, final AdContentData adContentData, long j) {
        ge.V(Z, "showNonWifiAlert, context:" + Code());
        com.huawei.openalliance.ad.download.app.f.V(Code(), j, new m.a() { // from class: com.huawei.hms.ads.ew.1
            @Override // com.huawei.openalliance.ad.utils.m.a
            public void Code() {
                c.Code(ew.this.Code, "15", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ew.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            ge.V(ew.Z, " traffic reminder accept");
                        }
                    }
                }, String.class);
                ew.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.m.a
            public void V() {
                c.Code(ew.this.Code, "16", adContentData, new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ew.1.2
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != -1) {
                            ge.V(ew.Z, " traffic reminder reject");
                        }
                    }
                }, String.class);
                ew.this.V(appInfo);
            }
        });
    }

    @Override // com.huawei.hms.ads.es
    public void Code(AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            I(appInfo, adContentData, j);
            return;
        }
        ge.V(Z, "appInfo or contentRecord is empty");
        V(appInfo);
    }
}
