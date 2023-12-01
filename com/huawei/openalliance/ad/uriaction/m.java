package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/m.class */
public class m extends q {
    private static final String Code = "OpenMiniPageAction";
    private int V;

    public m(Context context, AdContentData adContentData) {
        super(context, adContentData);
        this.V = 2;
    }

    private AppDownloadTask Code(AppInfo appInfo) {
        AppDownloadTask appDownloadTask;
        AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(appInfo);
        if (V != null) {
            appDownloadTask = V;
            if (this.Z != null) {
                V.Z(this.Z.C());
                V.B(this.Z.s());
                V.C(this.Z.S());
                V.I(this.Z.B());
                V.a(this.Z.az());
                V.C(this.Z.aA());
                return V;
            }
            return appDownloadTask;
        }
        V = new AppDownloadTask.a().Code(appInfo).Code();
        appDownloadTask = V;
        if (V != null) {
            V.Code(Integer.valueOf(this.V));
            V.Code(this.Z);
            appDownloadTask = V;
            if (this.Z != null) {
                V.B(this.Z.s());
                V.Z(this.Z.C());
                V.C(this.Z.S());
                V.I(this.Z.B());
                V.a(this.Z.az());
                V.C(this.Z.aA());
                return V;
            }
        }
        return appDownloadTask;
    }

    public void Code(int i) {
        this.V = i;
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        ge.V(Code, "handle OpenMiniPageAction");
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
        Code2.S(this.Z.ao());
        Code2.F(this.Z.ap());
        Code2.Code(Integer.valueOf(this.V));
        Code2.D(this.Z.E());
        Code2.I((Integer) 1);
        Code(s.F);
        com.huawei.openalliance.ad.download.app.g.I().Code(Code2);
        return true;
    }
}
