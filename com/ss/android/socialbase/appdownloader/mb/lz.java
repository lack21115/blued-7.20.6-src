package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/mb/lz.class */
public class lz extends mb {
    private String h;
    private String hj;

    public lz(Context context, DownloadSetting downloadSetting, String str, String str2, String str3) {
        super(context, downloadSetting, str);
        this.hj = str2;
        this.h = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String str;
        String optString = this.ox.optString("s");
        String mb = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ak"), optString);
        String mb2 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("am"), optString);
        String mb3 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("an"), optString);
        String str2 = null;
        if (TextUtils.isEmpty(mb3) || mb3.split(",").length != 2) {
            return null;
        }
        String[] split = mb3.split(",");
        String mb4 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString(c.bl), optString);
        String mb5 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ao"), optString);
        if (TextUtils.isEmpty(mb5) || mb5.split(",").length != 2) {
            return null;
        }
        String[] split2 = mb5.split(",");
        JSONObject optJSONObject = this.ox.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (optJSONObject != null) {
            String optString2 = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
            if (TextUtils.isEmpty(optString2) || !optString2.contains("%s")) {
                str = this.h;
            } else {
                try {
                    str = String.format(optString2, this.h);
                } catch (Throwable th) {
                    str = this.h;
                }
            }
            String str3 = str;
            str2 = str3;
            if (str3.length() > 255) {
                str2 = mb4.substring(str3.length() - 255);
            }
        }
        Intent intent = new Intent(mb);
        intent.putExtra(split2[0], split2[1]);
        intent.putExtra(mb2, this.hj);
        intent.putExtra(mb4, str2);
        intent.putExtra(split[0], Integer.parseInt(split[1]));
        intent.addFlags(268468224);
        return intent;
    }
}
