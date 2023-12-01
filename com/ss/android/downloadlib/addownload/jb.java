package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/jb.class */
public class jb implements IReserveWifiStatusListener {
    @Override // com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener
    public void onStatusChanged(DownloadInfo downloadInfo, int i, int i2) {
        com.ss.android.downloadad.api.mb.ox mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.RESERVE_WIFI_SOURCE, Integer.valueOf(i2));
            jSONObject.putOpt(EventConstants.ExtraJson.RESERVE_WIFI_STATUS, Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.PAUSE_RESERVE_WIFI, jSONObject, mb);
    }
}
