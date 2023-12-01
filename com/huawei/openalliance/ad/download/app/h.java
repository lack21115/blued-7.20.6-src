package com.huawei.openalliance.ad.download.app;

import android.content.Context;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.constant.ac;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/download/app/h.class */
public class h {
    private static final String Code = "AppLauncher";

    private static void Code(Context context, final AppInfo appInfo) {
        if (appInfo == null) {
            ge.V(Code, "appInfo is empty.");
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.h.1
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                if (Code2 != null) {
                    Code2.Code(AppInfo.this.Code());
                }
            }
        });
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.download.app.h.2
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                if (Code2 != null) {
                    Code2.Code(AppInfo.this);
                }
            }
        });
    }

    public boolean Code(Context context, AppInfo appInfo, AdContentData adContentData, Integer num, boolean z) {
        if (context == null || appInfo == null) {
            ge.V(Code, "parameters occur error");
            return false;
        }
        String Code2 = appInfo.Code();
        if (com.huawei.openalliance.ad.utils.e.Code(context, Code2, appInfo.D())) {
            Code(context, appInfo);
            ko.Code(context, adContentData, "intentSuccess", (Integer) 1, (Integer) null);
            if (z) {
                ko.Code(context, adContentData, 0, 0, "app", num.intValue(), com.huawei.openalliance.ad.utils.b.Code(context));
                return true;
            }
            return true;
        }
        ge.V(Code, "handClick, openAppIntent fail");
        ko.Code(context, adContentData, ac.D, (Integer) 1, Integer.valueOf(com.huawei.openalliance.ad.utils.e.Code(context, Code2) ? 2 : 1));
        if (!com.huawei.openalliance.ad.utils.e.I(context, Code2)) {
            ge.V(Code, "handClick, openAppMainPage fail");
            return false;
        }
        ko.Code(context, adContentData, (Integer) 1);
        Code(context, appInfo);
        if (z) {
            ko.Code(context, adContentData, 0, 0, "app", num.intValue(), com.huawei.openalliance.ad.utils.b.Code(context));
            return true;
        }
        return true;
    }
}
