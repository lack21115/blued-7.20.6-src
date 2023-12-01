package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.m;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/et.class */
public class et extends es {
    private static final String B = "117";
    private static final String I = "115";
    private static final String V = "ConfirmDownloadAlertStrategy";
    private static final String Z = "116";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/et$a.class */
    public static class a implements RemoteCallResultCallback<String> {
        private a() {
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            if (callResult.getCode() != -1) {
                ge.V(et.V, "confirm reminder reject");
            }
        }
    }

    public et(Context context) {
        super(context);
    }

    private void Code(final AppInfo appInfo, final AdContentData adContentData) {
        ge.V(V, "showConfirmDownloadAlert, context:" + Code());
        Code(I, adContentData);
        com.huawei.openalliance.ad.download.app.f.Code(Code(), new m.a() { // from class: com.huawei.hms.ads.et.1
            @Override // com.huawei.openalliance.ad.utils.m.a
            public void Code() {
                et.this.Code(et.Z, adContentData);
                et.this.Code(appInfo);
            }

            @Override // com.huawei.openalliance.ad.utils.m.a
            public void V() {
                et.this.Code(et.B, adContentData);
                et.this.V(appInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, AdContentData adContentData) {
        c.Code(this.Code, str, adContentData, new a(), String.class);
    }

    @Override // com.huawei.hms.ads.es
    public void Code(AppInfo appInfo, AdContentData adContentData, long j) {
        if (appInfo != null && adContentData != null) {
            Code(appInfo, adContentData);
            return;
        }
        ge.V(V, "appInfo or contentRecord is empty");
        V(appInfo);
    }
}
