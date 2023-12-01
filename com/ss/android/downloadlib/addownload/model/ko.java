package com.ss.android.downloadlib.addownload.model;

import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/ko.class */
public class ko {
    private static volatile ko mb;

    private ko() {
    }

    public static ko mb() {
        if (mb == null) {
            synchronized (hj.class) {
                try {
                    if (mb == null) {
                        mb = new ko();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    public void mb(int i, int i2, com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        DownloadSetting obtain = DownloadSetting.obtain(oxVar.m());
        if (obtain.optInt("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= obtain.optInt("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.ExtraJson.KEY_VERSION_CODE_DIFF, i3);
            jSONObject.put(EventConstants.ExtraJson.KEY_INSTALLED_VERSION_CODE, i2);
            jSONObject.put(EventConstants.ExtraJson.KEY_HIJACK_TYPE, 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().ox(EventConstants.Label.API_HIJACK, jSONObject, oxVar);
    }
}
