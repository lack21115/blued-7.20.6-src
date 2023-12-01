package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.b;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ba.class */
public class ba extends ap {
    public ba() {
        super(ai.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadTask Code(AppInfo appInfo, AdContentData adContentData) {
        AppDownloadTask Code = new AppDownloadTask.a().Code(appInfo).Code();
        Code.C(adContentData.aA());
        Code.D(adContentData.E());
        Code.I(adContentData.B());
        Code.Z(adContentData.C());
        Code.C(adContentData.S());
        return Code;
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, new ab() { // from class: com.huawei.hms.ads.ba.1
            @Override // com.huawei.hms.ads.ab
            public void Code(AdContentData adContentData) {
                RemoteCallResultCallback remoteCallResultCallback2;
                String str2;
                if (adContentData != null) {
                    com.huawei.openalliance.ad.inter.data.u uVar = new com.huawei.openalliance.ad.inter.data.u(adContentData);
                    if (uVar.v() != null) {
                        b.Code(context).Code(ba.this.Code(uVar.v(), adContentData));
                        ba.this.V((RemoteCallResultCallback<String>) remoteCallResultCallback, true);
                        return;
                    }
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = ba.this.Code;
                } else {
                    remoteCallResultCallback2 = remoteCallResultCallback;
                    str2 = ba.this.Code;
                }
                af.Code(remoteCallResultCallback2, str2, 3002, null, true);
            }
        });
    }
}
