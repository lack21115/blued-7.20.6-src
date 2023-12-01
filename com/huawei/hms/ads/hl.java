package com.huawei.hms.ads;

import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hl.class */
public class hl implements hp {
    public static final String Code = "appInfo";
    public static final String I = "downloadSource";
    public static final String V = "contentRecord";
    private static final String Z = "AppNotificationBaseAction";

    @Override // com.huawei.hms.ads.hp
    public void Code(Context context, Intent intent) {
        StringBuilder sb;
        String str;
        try {
            AppInfo appInfo = (AppInfo) intent.getSerializableExtra("appInfo");
            AdContentData adContentData = (AdContentData) intent.getSerializableExtra("contentRecord");
            int intExtra = intent.getIntExtra(I, 1);
            if (appInfo == null || adContentData == null) {
                return;
            }
            if (hq.Code(context).I(appInfo.Code())) {
                Code(context, appInfo, adContentData, intExtra);
                hq.Code(context).V(appInfo.Code());
                return;
            }
            ge.V(Z, "packageName may be illegal:" + appInfo.Code());
        } catch (IllegalStateException e) {
            e = e;
            sb = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive IllegalStateException:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            ge.I(Z, sb.toString());
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive Exception:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            ge.I(Z, sb.toString());
        }
    }

    protected void Code(Context context, AppInfo appInfo, AdContentData adContentData, int i) {
        ge.V(Z, "do nothing at base action!");
    }
}
