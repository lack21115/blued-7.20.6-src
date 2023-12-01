package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/b/hj.class */
public class hj implements com.ss.android.socialbase.appdownloader.b.ko, IDownloadCacheSyncStatusListener {
    public void mb(DownloadInfo downloadInfo, int i, boolean z) {
        com.ss.android.downloadlib.addownload.model.u.mb().ox();
        com.ss.android.downloadad.api.mb.ox mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        if (mb == null) {
            return;
        }
        try {
            if (z) {
                mb.b(downloadInfo.getFailedResumeCount());
            } else if (mb.nf() == -1) {
                return;
            } else {
                mb.b(-1);
            }
            com.ss.android.downloadlib.addownload.model.ww.mb().mb(mb);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            jSONObject.put(EventConstants.ExtraJson.KEY_LAUNCH_RESUMED, z ? 1 : 2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.DOWNLOAD_UNCOMPLETED, jSONObject, mb);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.ko
    public void mb(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        mb(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.ko
    public void mb(List<DownloadInfo> list) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onStart() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onSuccess() {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.hj.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.model.u.mb().ox();
                for (com.ss.android.downloadad.api.mb.ox oxVar : com.ss.android.downloadlib.addownload.model.u.mb().b().values()) {
                    int m = oxVar.m();
                    if (m != 0) {
                        DownloadSetting obtain = DownloadSetting.obtain(m);
                        if (obtain.optInt("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(m)) != null) {
                            if (jb.ox(oxVar) && !jb.b(oxVar.h())) {
                                int spIntVal2 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT);
                                if (spIntVal2 < obtain.optInt("noti_open_restart_times", 1)) {
                                    ww.mb().h(oxVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT, String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT);
                                if (spIntVal3 < obtain.optInt("noti_continue_restart_times", 1)) {
                                    ww.mb().mb(oxVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT, String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && DownloadUtils.isFileDownloaded(downloadInfo) && !jb.ox(oxVar) && (spIntVal = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT)) < obtain.optInt("noti_install_restart_times", 1)) {
                                ww.mb().b(oxVar);
                                downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT, String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
