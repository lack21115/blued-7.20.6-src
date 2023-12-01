package com.ss.android.downloadlib.addownload.ox;

import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.model.ww;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ox/ox.class */
public class ox implements Runnable {
    private DownloadInfo mb;

    public ox(DownloadInfo downloadInfo) {
        this.mb = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        final com.ss.android.downloadad.api.mb.ox mb;
        if (this.mb == null || (mb = u.mb().mb(this.mb)) == null) {
            return;
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SPACE_TASK, mb);
        long longValue = Double.valueOf((com.ss.android.downloadlib.utils.hj.mb(this.mb.getId()) + 1.0d) * this.mb.getTotalBytes()).longValue() - this.mb.getCurBytes();
        long mb2 = jb.mb(0L);
        if (x.je() != null) {
            x.je().h();
        }
        b.mb();
        b.ox();
        if (com.ss.android.downloadlib.utils.hj.ko(mb.m())) {
            b.mb(x.getContext());
        }
        long mb3 = jb.mb(0L);
        if (mb3 >= longValue) {
            mb.je("1");
            ww.mb().mb(mb);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.QUITE_CLEAN_SIZE, Long.valueOf(mb3 - mb2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            AdEventHandler.mb().mb(EventConstants.UnityLabel.DOWNLOAD_AFTER_QUITE_CLEAN, jSONObject, mb);
            Downloader.getInstance(x.getContext()).restart(this.mb.getId());
        } else if (x.je() != null) {
            mb.hj(false);
            hj.mb().mb(mb.mb(), new h() { // from class: com.ss.android.downloadlib.addownload.ox.ox.1
            });
            if (x.je().mb(this.mb.getId(), this.mb.getUrl(), true, longValue)) {
                mb.h(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt(EventConstants.ExtraJson.CLEAN_SHOW_DIALOG_RESULT, 3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SHOW_DIALOG, jSONObject2, mb);
        }
    }
}
