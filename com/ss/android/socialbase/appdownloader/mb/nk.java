package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.a;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb/nk.class */
public class nk extends mb {
    public nk(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    public static String mb(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String stringBuffer2 = stringBuffer.toString();
        String str = stringBuffer2;
        if (stringBuffer2.endsWith(ContainerUtils.FIELD_DELIMITER)) {
            str = stringBuffer2.substring(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String optString = this.ox.optString("s");
        String mb = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("bb"), optString);
        if (TextUtils.isEmpty(mb) || mb.split(",").length != 2) {
            return null;
        }
        String mb2 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("bc"), optString);
        if (TextUtils.isEmpty(mb2) || mb2.split(",").length != 2) {
            return null;
        }
        String[] split = mb.split(",");
        String[] split2 = mb2.split(",");
        String mb3 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString(a.L), optString);
        String mb4 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("be"), optString);
        String mb5 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("bf"), optString);
        HashMap hashMap = new HashMap();
        hashMap.put(split[0], split[1]);
        hashMap.put(split2[0], split2[1]);
        hashMap.put(mb3, this.b);
        Intent intent = new Intent();
        intent.setAction(mb5);
        intent.setData(Uri.parse(mb4 + mb(hashMap)));
        intent.addFlags(268468224);
        return intent;
    }
}
