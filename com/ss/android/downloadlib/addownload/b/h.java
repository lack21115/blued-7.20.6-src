package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/b/h.class */
public class h implements hj {
    private long mb(int i) {
        return DownloadSetting.obtain(i).optInt("pause_optimise_mistake_click_interval", 300);
    }

    private boolean ox(int i) {
        boolean z = false;
        if (DownloadSetting.obtain(i).optInt("pause_optimise_mistake_click_interval_switch", 0) == 1) {
            z = true;
        }
        return z;
    }

    @Override // com.ss.android.downloadlib.addownload.b.hj
    public boolean mb(com.ss.android.downloadad.api.mb.ox oxVar, int i, b bVar) {
        if (oxVar != null && ox(oxVar.m())) {
            if (System.currentTimeMillis() - oxVar.sa() <= mb(oxVar.m())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "mistake_click");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
                return true;
            }
            return false;
        }
        return false;
    }
}
