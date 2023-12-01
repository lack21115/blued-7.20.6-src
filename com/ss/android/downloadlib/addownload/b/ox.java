package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.lz;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/b/ox.class */
public class ox implements hj {
    private static com.ss.android.downloadlib.addownload.mb.b mb;

    private int mb(int i) {
        return DownloadSetting.obtain(i).optInt("pause_optimise_download_percent", 50);
    }

    public static com.ss.android.downloadlib.addownload.mb.b mb() {
        return mb;
    }

    private boolean mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        boolean z = false;
        if (com.ss.android.downloadlib.utils.hj.mb(mbVar).optInt("pause_optimise_download_percent_switch", 0) == 1) {
            z = false;
            if (mbVar.e()) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.ss.android.downloadlib.addownload.b.hj
    public boolean mb(final com.ss.android.downloadad.api.mb.ox oxVar, int i, final b bVar) {
        DownloadInfo ox;
        if (oxVar == null || oxVar.kg() || !mb(oxVar) || (ox = ww.mb((Context) null).ox(oxVar.mb())) == null) {
            return false;
        }
        long curBytes = ox.getCurBytes();
        long totalBytes = ox.getTotalBytes();
        if (curBytes <= 0 || totalBytes <= 0) {
            return false;
        }
        int mb2 = lz.mb(ox.getId(), (int) ((curBytes * 100) / totalBytes));
        if (mb2 > mb(oxVar.m())) {
            mb = new com.ss.android.downloadlib.addownload.mb.b() { // from class: com.ss.android.downloadlib.addownload.b.ox.1
                @Override // com.ss.android.downloadlib.addownload.mb.b
                public void mb() {
                    com.ss.android.downloadlib.addownload.mb.b unused = ox.mb = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "download_percent");
                        jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, "confirm");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
                }

                @Override // com.ss.android.downloadlib.addownload.mb.b
                public void ox() {
                    com.ss.android.downloadlib.addownload.mb.b unused = ox.mb = null;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "download_percent");
                        jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, com.anythink.expressad.d.a.b.dO);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
                    bVar.mb(oxVar);
                }
            };
            TTDelegateActivity.ox(oxVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(mb2)), "继续", "暂停");
            oxVar.lc(true);
            return true;
        }
        return false;
    }
}
