package com.ss.android.downloadlib.b;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/u.class */
public class u implements com.ss.android.socialbase.appdownloader.b.hj {
    private Context mb;

    public u(Context context) {
        this.mb = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(int i, int i2, String str, int i3, long j) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.mb.ox mb;
        Context context = this.mb;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() == 0 || (mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        if (i2 == 1) {
            com.ss.android.downloadlib.mb.mb(downloadInfo, mb);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.mb.mb().mb(downloadInfo, mb.ox(), mb.je(), mb.h(), downloadInfo.getTitle(), mb.hj(), downloadInfo.getTargetFilePath());
            }
        } else if (i2 == 3) {
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_INSTALL, com.ss.android.downloadlib.mb.ox(new JSONObject(), downloadInfo), mb);
        } else if (i2 == 5) {
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_PAUSE, mb);
        } else if (i2 == 6) {
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_CONTINUE, mb);
        } else if (i2 != 7) {
        } else {
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_CLICK, mb);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(int i, int i2, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.mb;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.ox.mb().mb(this.mb, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(Context context, String str) {
        com.ss.android.downloadlib.mb.mb().mb(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.ko.mb().mb(downloadInfo);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("report_download_cancel", 1) == 1) {
            AdEventHandler.mb().mb(downloadInfo, new BaseException(1012, ""));
        } else {
            AdEventHandler.mb().ox(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public boolean mb() {
        return com.ss.android.downloadlib.addownload.ox.mb().ox();
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public boolean mb(int i, boolean z) {
        if (x.o() != null) {
            return x.o().mb(z);
        }
        return false;
    }
}
