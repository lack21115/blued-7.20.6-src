package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.lz;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/b/mb.class */
public class mb implements hj {
    private static com.ss.android.downloadlib.addownload.mb.b mb;

    private int mb(int i) {
        return DownloadSetting.obtain(i).optInt("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    public static com.ss.android.downloadlib.addownload.mb.b mb() {
        return mb;
    }

    private static String mb(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + "G";
        } else if (j >= 1048576) {
            return (j / 1048576) + "M";
        } else {
            return decimalFormat.format(((float) j) / 1048576.0f) + "M";
        }
    }

    private boolean mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        boolean z = false;
        if (com.ss.android.downloadlib.utils.hj.mb(mbVar).optInt("pause_optimise_apk_size_switch", 0) == 1) {
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
        if (oxVar == null || oxVar.kk() || !mb(oxVar) || (ox = ww.mb((Context) null).ox(oxVar.mb())) == null) {
            return false;
        }
        long mb2 = lz.mb(ox.getId(), ox.getCurBytes(), ox.getTotalBytes());
        long totalBytes = ox.getTotalBytes();
        if (mb2 <= 0 || totalBytes <= 0 || totalBytes > mb(oxVar.m())) {
            return false;
        }
        mb = new com.ss.android.downloadlib.addownload.mb.b() { // from class: com.ss.android.downloadlib.addownload.b.mb.1
            @Override // com.ss.android.downloadlib.addownload.mb.b
            public void mb() {
                com.ss.android.downloadlib.addownload.mb.b unused = mb.mb = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, EventConstants.ExtraJson.APK_SIZE);
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, "confirm");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
            }

            @Override // com.ss.android.downloadlib.addownload.mb.b
            public void ox() {
                com.ss.android.downloadlib.addownload.mb.b unused = mb.mb = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, EventConstants.ExtraJson.APK_SIZE);
                    jSONObject.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, com.anythink.expressad.d.a.b.dO);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_OPTIMISE, jSONObject, oxVar);
                bVar.mb(oxVar);
            }
        };
        TTDelegateActivity.mb(oxVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", mb(totalBytes - mb2)), "继续", "暂停");
        oxVar.o(true);
        return true;
    }
}
