package com.kwad.sdk.kwai.kwai;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/kwai/kwai/d.class */
public final class d {
    public static String tf() {
        String uT = com.kwad.sdk.core.config.d.uT();
        String str = uT;
        if (TextUtils.isEmpty(uT)) {
            str = "安装";
        }
        return str;
    }

    public static String tg() {
        String uU = com.kwad.sdk.core.config.d.uU();
        String str = uU;
        if (TextUtils.isEmpty(uU)) {
            str = "取消";
        }
        return str;
    }

    public static String z(AdInfo adInfo) {
        return com.kwad.sdk.core.config.d.uS().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.r.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
