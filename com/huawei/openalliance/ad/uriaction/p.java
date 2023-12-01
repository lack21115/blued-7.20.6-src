package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/p.class */
public class p extends q {
    private static final String Code = "SpecifiedAgdDownloadAction";
    private int C;
    private int V;

    public p(Context context, AdContentData adContentData) {
        super(context, adContentData);
        this.V = 2;
        this.C = 1;
    }

    private AppDownloadTask Code(AppInfo appInfo) {
        AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(appInfo);
        AppDownloadTask appDownloadTask = V;
        if (V == null) {
            AppDownloadTask Code2 = new AppDownloadTask.a().Code(appInfo).Code();
            appDownloadTask = Code2;
            if (Code2 != null) {
                Code2.Code(Integer.valueOf(this.V));
                Code2.I(Integer.valueOf(this.C));
                Code2.Code(this.Z);
                appDownloadTask = Code2;
            }
        }
        if (appDownloadTask != null && this.Z != null) {
            appDownloadTask.B(this.Z.s());
            appDownloadTask.Z(this.Z.C());
            appDownloadTask.C(this.Z.S());
            appDownloadTask.I(this.Z.B());
            appDownloadTask.a(this.Z.az());
            appDownloadTask.C(this.Z.aA());
        }
        return appDownloadTask;
    }

    public void Code(int i) {
        this.V = i;
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        ge.V(Code, "handle SpecifiedAgdDownloadAction");
        if (this.Z == null || this.Z.u() == null) {
            ge.V(Code, "getAppInfo is null");
            return V();
        }
        AppInfo u = this.Z.u();
        if (u != null && com.huawei.openalliance.ad.utils.e.Code(this.I, u.Code())) {
            ge.V(Code, "app installed");
            return V();
        }
        AppDownloadTask Code2 = Code(u);
        if (Code2 == null) {
            ge.V(Code, "downloadTask is null");
            return V();
        }
        Code2.Code(Integer.valueOf(this.V));
        Code(s.Code);
        com.huawei.openalliance.ad.download.app.g.I().Code(Code2);
        return true;
    }

    public void V(int i) {
        this.C = i;
    }
}
