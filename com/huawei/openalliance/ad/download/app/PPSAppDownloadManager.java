package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.dp;
import com.huawei.hms.ads.eu;
import com.huawei.hms.ads.ev;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kn;
import com.huawei.hms.ads.ko;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ac;
import com.huawei.openalliance.ad.constant.at;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.u;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/PPSAppDownloadManager.class */
public class PPSAppDownloadManager implements IAppDownloadManager {
    private String D;
    private boolean L;
    private final ev B = new eu();
    private int C = 2;
    private Integer S = 6;
    g Code = g.I();

    private AppDownloadTask Code(com.huawei.openalliance.ad.inter.data.d dVar) {
        AppDownloadTask Code = new AppDownloadTask.a().Code(true).Code(dVar.v()).Code();
        if (Code != null) {
            Code.C(dVar.D());
            Code.Z(dVar.m());
            AdContentData l = dVar.l();
            Code.Code(l);
            if (l != null) {
                Code.B(l.s());
                Code.I(l.B());
                Code.D(l.E());
                Code.a(l.az());
                Code.C(l.aA());
            }
        }
        return Code;
    }

    private void Code(Context context, AdContentData adContentData, AppInfo appInfo, String str) {
        if (adContentData != null) {
            ko.Code(context, adContentData, 0, 0, V(appInfo) ? s.F : "download", 6, str);
        }
    }

    private void Code(Context context, AdContentData adContentData, String str) {
        if (adContentData != null) {
            ko.Code(context, adContentData, 0, 0, "app", 6, str);
        }
    }

    public static void Code(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            ge.V("PPSAppDownloadManager", "appInfo is empty.");
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.download.a Code = com.huawei.openalliance.ad.download.a.Code();
                if (Code != null) {
                    Code.Code(AppInfo.this.Code());
                }
            }
        });
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.PPSAppDownloadManager.2
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.download.a Code = com.huawei.openalliance.ad.download.a.Code();
                if (Code != null) {
                    Code.Code(AppInfo.this);
                }
            }
        });
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        appDownloadTask.C(dVar.D());
        appDownloadTask.Code(this.S);
        appDownloadTask.V((Integer) (-1));
        appDownloadTask.I(Integer.valueOf(this.C));
    }

    private boolean Code() {
        return this.S.intValue() == 14;
    }

    private boolean Code(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        return appInfo.o();
    }

    private int D(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (a(context, dVar)) {
            ge.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        }
        AppInfo v = dVar.v();
        AppDownloadTask V = this.Code.V(v);
        if (V != null) {
            V(dVar, V);
            Code(dVar, V);
            this.Code.I(V);
            return 0;
        }
        AppDownloadTask Code = Code(dVar);
        if (Code == null) {
            ge.V("PPSAppDownloadManager", "failed when create task");
            return -1;
        }
        RewardVerifyConfig H = dVar.H();
        if (H != null) {
            Code.S(H.getData());
            Code.F(H.getUserId());
        }
        Code(dVar, Code);
        if (!Code()) {
            V(context, null, dVar);
            Code(context, dVar.l(), v, com.huawei.openalliance.ad.utils.b.Code(context));
        }
        this.Code.Code(Code);
        return 0;
    }

    private boolean I(AppInfo appInfo) {
        String str;
        if (appInfo == null) {
            str = " download app info is empty";
        } else if (TextUtils.isEmpty(appInfo.Code())) {
            str = "app packageName is empty";
        } else if (!Code(appInfo) && !dp.Code(appInfo) && (TextUtils.isEmpty(appInfo.Z()) || Z(appInfo) || appInfo.B() <= 0)) {
            str = " download app info is invalid";
        } else if (this.Code != null) {
            return true;
        } else {
            str = " download manager is not init";
        }
        ge.V("PPSAppDownloadManager", str);
        return false;
    }

    private boolean I(com.huawei.openalliance.ad.inter.data.d dVar) {
        return (dVar instanceof n) || (dVar instanceof u);
    }

    private boolean L(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        AppInfo v = dVar.v();
        if (!com.huawei.openalliance.ad.utils.e.Code(context, v.Code()) && com.huawei.openalliance.ad.utils.e.Code()) {
            str = "app not installed, need download";
        } else if (com.huawei.openalliance.ad.utils.e.Code(context, v.Code(), v.D())) {
            Code(context, v);
            ko.Code(context, dVar.l(), "intentSuccess", (Integer) 1, (Integer) null);
            if (Code()) {
                return true;
            }
            V(context, null, dVar);
            Code(context, dVar.l(), com.huawei.openalliance.ad.utils.b.Code(context));
            return true;
        } else {
            ge.V("PPSAppDownloadManager", "handleClick, openAppIntent failed");
            ko.Code(context, dVar.l(), ac.D, (Integer) 1, (Integer) 2);
            if (com.huawei.openalliance.ad.utils.e.I(context, v.Code())) {
                Code(context, v);
                ko.Code(context, dVar.l(), (Integer) 6);
                if (Code()) {
                    return true;
                }
                V(context, null, dVar);
                Code(context, dVar.l(), com.huawei.openalliance.ad.utils.b.Code(context));
                return true;
            }
            str = "handleClick, openAppMainPage failed";
        }
        ge.V("PPSAppDownloadManager", str);
        return false;
    }

    private void V(Context context, View view, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (view != null && (view instanceof PPSNativeView)) {
            ((PPSNativeView) view).Code((Integer) 6, true);
        } else if (dVar != null) {
            String str = null;
            if (dVar instanceof u) {
                str = ((u) dVar).l().B();
            }
            if (str == null || !str.equals(this.D)) {
                this.D = str;
                kn.a aVar = new kn.a();
                aVar.V(Long.valueOf(v.Code())).Code(Long.valueOf(dVar.r())).Code(Integer.valueOf(dVar.s())).V((Integer) 6).Code(com.huawei.openalliance.ad.utils.b.Code(context));
                ko.Code(context, dVar.l(), aVar.Code());
            }
        }
    }

    private void V(com.huawei.openalliance.ad.inter.data.d dVar, AppDownloadTask appDownloadTask) {
        AdContentData l = dVar.l();
        if (l != null) {
            appDownloadTask.I(l.B());
        }
    }

    private boolean V(AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        String r = appInfo.r();
        boolean z = false;
        if (!TextUtils.isEmpty(r)) {
            z = false;
            if (!TextUtils.isEmpty(appInfo.Code())) {
                z = false;
                if (r.equals("6")) {
                    z = true;
                }
            }
        }
        return z;
    }

    private boolean V(com.huawei.openalliance.ad.inter.data.d dVar) {
        return I(dVar) && I(dVar.v());
    }

    private boolean Z(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.S() && TextUtils.isEmpty(appInfo.C());
    }

    private boolean a(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        AppInfo v;
        boolean z = dVar instanceof u;
        if (this.L && z && (v = dVar.v()) != null && !aa.Code(v.t()) && com.huawei.openalliance.ad.uriaction.d.Code(context, dVar.l(), Code(dVar.l()), v.t()).Code()) {
            V(context, null, dVar);
            Code(context, dVar.l(), com.huawei.openalliance.ad.utils.b.Code(context));
            return true;
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void B(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (V(context, dVar) != null) {
            str = "ad is invalid ad when pause";
        } else if (this.B.Code(context, dVar, false)) {
            AppDownloadTask V = this.Code.V(dVar.v());
            if (V != null) {
                V(dVar, V);
                Code(dVar, V);
                this.Code.V(V);
                return;
            }
            return;
        } else {
            str = "pauseDownload has not permission, please add white list";
        }
        ge.V("PPSAppDownloadManager", str);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void C(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (V(context, dVar) != null) {
            str = "ad is invalid ad when cancel";
        } else if (this.B.Code(context, dVar, false)) {
            AppInfo v = dVar.v();
            AppDownloadTask V = this.Code.V(v);
            if (V != null) {
                V(dVar, V);
                Code(dVar, V);
                this.Code.Code(v);
                return;
            }
            return;
        } else {
            str = "cancelDownload has not permission, please add white list";
        }
        ge.V("PPSAppDownloadManager", str);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer V = V(context, dVar);
        if (V != null) {
            return V.intValue();
        }
        if (!(dVar instanceof u) && !this.B.Code(context, dVar, true)) {
            ge.V("PPSAppDownloadManager", "download has not permission, please add white list");
            return -2;
        } else if (L(context, dVar)) {
            ge.V("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        } else {
            return D(context, dVar);
        }
    }

    Map<String, String> Code(AdContentData adContentData) {
        HashMap hashMap = new HashMap();
        if (adContentData != null) {
            MetaData Z = adContentData.Z();
            hashMap.put("appId", Z == null ? "" : Z.L());
            hashMap.put(com.huawei.openalliance.ad.uriaction.i.V, Z == null ? "" : Z.D());
            if (adContentData.p() == null) {
                return hashMap;
            }
            com.huawei.openalliance.ad.inter.data.v vVar = new com.huawei.openalliance.ad.inter.data.v(adContentData.p());
            hashMap.put(at.m, adContentData.B());
            int L = vVar.L();
            ge.V("PPSAppDownloadManager", "buildLinkedAdConfig, set progress from native view " + L);
            hashMap.put(at.n, String.valueOf(adContentData.z()));
            hashMap.put(at.q, adContentData.y() ? "true" : "false");
            hashMap.put(at.p, vVar.a());
            hashMap.put(at.o, String.valueOf(L));
        }
        return hashMap;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(Integer num) {
        this.S = num;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public void Code(boolean z) {
        this.L = z;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int F(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        String str;
        if (dVar == null) {
            str = "ad is empty";
        } else if (V(dVar)) {
            AppDownloadTask V = this.Code.V(dVar.v());
            if (V != null) {
                return V.S();
            }
            str = "task is not exist.";
        } else {
            str = "ad is not native ad";
        }
        ge.V("PPSAppDownloadManager", str);
        return 0;
    }

    Integer I(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        return (context == null || dVar == null) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public k S(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            return k.DOWNLOAD;
        }
        if (!V(dVar)) {
            ge.V("PPSAppDownloadManager", "this ad is not a native ad");
            return k.DOWNLOAD;
        }
        AppInfo v = dVar.v();
        if (com.huawei.openalliance.ad.utils.e.Code(context, v.Code())) {
            ge.V("PPSAppDownloadManager", "app installed");
            return k.INSTALLED;
        }
        AppDownloadTask V = this.Code.V(v);
        if (V == null) {
            return k.DOWNLOAD;
        }
        V.C(dVar.D());
        return dp.Code(V);
    }

    Integer V(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer I = I(context, dVar);
        return I != null ? I : !V(dVar) ? -1 : null;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager
    public int Z(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        Integer V = V(context, dVar);
        if (V != null) {
            return V.intValue();
        }
        if (!this.B.Code(context, dVar, true)) {
            ge.V("PPSAppDownloadManager", "resumeDownload has not permission, please add white list");
            return -2;
        } else if (L(context, dVar)) {
            ge.V("PPSAppDownloadManager", "app is installed, open it.");
            return 0;
        } else if (a(context, dVar)) {
            ge.V("PPSAppDownloadManager", "do app click action.");
            return 0;
        } else {
            AppDownloadTask V2 = this.Code.V(dVar.v());
            if (V2 == null) {
                ge.V("PPSAppDownloadManager", "app download info is empty, must first invoke startDownload method");
                return -1;
            }
            V(dVar, V2);
            Code(dVar, V2);
            this.Code.I(V2);
            return 0;
        }
    }
}
