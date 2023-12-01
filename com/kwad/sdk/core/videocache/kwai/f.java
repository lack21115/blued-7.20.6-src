package com.kwad.sdk.core.videocache.kwai;

import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.ad;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.HashMap;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/kwai/f.class */
public final class f implements c {
    private static String da(String str) {
        Uri parse = Uri.parse(str);
        String str2 = str;
        if (parse.getHost() != null) {
            str2 = str;
            if (parse.getHost().contains("yximgs.com")) {
                Uri.Builder buildUpon = parse.buildUpon();
                HashMap hashMap = new HashMap();
                if (parse.isHierarchical()) {
                    Set<String> queryParameterNames = parse.getQueryParameterNames();
                    for (String str3 : queryParameterNames) {
                        hashMap.put(str3, parse.getQueryParameter(str3));
                    }
                    buildUpon.clearQuery();
                    for (String str4 : queryParameterNames) {
                        if (!"tag".equals(str4) && !AppIconSetting.DEFAULT_LARGE_ICON.equals(str4) && str4 != null) {
                            buildUpon.appendQueryParameter(str4, (String) hashMap.get(str4));
                        }
                    }
                }
                str2 = buildUpon.toString();
            }
        }
        return str2;
    }

    private static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.kwad.sdk.core.videocache.kwai.c
    public final String generate(String str) {
        String da = da(str);
        String extension = getExtension(da);
        String eC = ad.eC(da);
        if (TextUtils.isEmpty(extension)) {
            return eC;
        }
        return eC + "." + extension;
    }
}
