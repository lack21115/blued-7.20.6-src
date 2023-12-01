package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/h.class */
public class h implements InnerEventListener {
    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onEvent(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.mb.ox mb;
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        JSONObject jSONObject2 = jSONObject;
        if (MonitorConstants.EventLabel.INSTALL_VIEW_RESULT.equals(str)) {
            jSONObject2 = jb.mb(jSONObject);
            com.ss.android.downloadlib.mb.mb(jSONObject2, downloadInfo);
            jb.mb(jSONObject2, EventConstants.ExtraJson.MODEL_ID, Long.valueOf(mb.ox()));
        }
        AdEventHandler.mb().ox(str, jSONObject2, mb);
    }

    @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
    public void onUnityEvent(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.mb.ox mb;
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        AdEventHandler.mb().mb(str, jSONObject, mb);
    }
}
