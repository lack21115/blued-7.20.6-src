package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.je;
import com.ss.android.downloadlib.utils.lz;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ko.class */
public class ko implements je.mb {
    private boolean b = false;
    private ox h;
    private h hj;
    private long mb;
    private com.ss.android.downloadlib.addownload.model.h ox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ko$mb.class */
    public static class mb extends AbsDownloadExtListener {
        private com.ss.android.downloadlib.utils.je mb;

        /* JADX INFO: Access modifiers changed from: package-private */
        public mb(com.ss.android.downloadlib.utils.je jeVar) {
            this.mb = jeVar;
        }

        private void mb(DownloadInfo downloadInfo, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i;
            this.mb.sendMessage(obtain);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            mb(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            mb(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            mb(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            mb(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            mb(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            mb(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            mb(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener, com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
            mb(downloadInfo, 11);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/ko$ox.class */
    public interface ox {
        void mb(DownloadInfo downloadInfo);
    }

    public ko(h hVar) {
        this.hj = hVar;
    }

    private boolean b() {
        return hj() && h();
    }

    private boolean h() {
        return this.ox.hj.isAddToDownloadManage();
    }

    private boolean h(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.utils.jb.mb(this.ox.ox) && u(downloadInfo);
    }

    private boolean hj() {
        return (this.ox.ox == null || TextUtils.isEmpty(this.ox.ox.getPackageName()) || TextUtils.isEmpty(this.ox.ox.getDownloadUrl())) ? false : true;
    }

    private HttpHeader mb(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new HttpHeader("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            x.m().mb(e, "parseLogExtra Error");
            return null;
        }
    }

    private String mb(DownloadSetting downloadSetting) {
        if (TextUtils.isEmpty(this.ox.ox.getFilePath())) {
            DownloadInfo mb2 = com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), this.ox.ox.getDownloadUrl());
            boolean ox2 = com.ss.android.downloadlib.utils.lz.ox("android.permission.WRITE_EXTERNAL_STORAGE");
            String ox3 = ox();
            if (mb2 != null && !TextUtils.isEmpty(mb2.getSavePath())) {
                String savePath = mb2.getSavePath();
                if (!ox2 && !savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                    try {
                        if (!TextUtils.isEmpty(ox3)) {
                            if (savePath.startsWith(ox3)) {
                                return savePath;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(mb2.getId());
                }
                return savePath;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(EventConstants.ExtraJson.KEY_CODE, Integer.valueOf(ox2 ? 1 : 2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            AdEventHandler.mb().mb(EventConstants.UnityLabel.LABEL_EXTERNAL_PERMISSION, jSONObject, this.ox);
            String str = null;
            try {
                str = com.ss.android.socialbase.appdownloader.b.ox();
            } catch (Exception e3) {
            }
            int mb3 = com.ss.android.downloadlib.utils.hj.mb(downloadSetting);
            if (mb3 != 0) {
                if (mb3 == 4 || (!ox2 && mb3 == 2)) {
                    File filesDir = x.getContext().getFilesDir();
                    if (!filesDir.exists()) {
                        filesDir.mkdirs();
                    }
                    if (filesDir.exists()) {
                        return filesDir.getAbsolutePath();
                    }
                } else if ((mb3 == 3 || (!ox2 && mb3 == 1)) && !TextUtils.isEmpty(ox3)) {
                    return ox3;
                }
            }
            return str;
        }
        return this.ox.ox.getFilePath();
    }

    public static List<DownloadStatusChangeListener> mb(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            if (map.isEmpty()) {
                return arrayList;
            }
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof DownloadStatusChangeListener) {
                        arrayList.add((DownloadStatusChangeListener) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean mb(int i) {
        if (this.ox.hj.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.ox.hj.getDownloadMode() == 2 && i == 1 && x.lz().optInt("disable_lp_if_market", 0) == 1;
    }

    public static List<com.ss.android.download.api.download.mb> ox(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            if (map.isEmpty()) {
                return arrayList;
            }
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.mb) {
                    arrayList.add((com.ss.android.download.api.download.mb) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof com.ss.android.download.api.download.mb) {
                        arrayList.add((com.ss.android.download.api.download.mb) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private void ox(final gm gmVar) {
        if (!com.ss.android.downloadlib.utils.lz.ox("android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.ss.android.downloadlib.utils.lz.mb(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new lz.mb() { // from class: com.ss.android.downloadlib.addownload.ko.2
                @Override // com.ss.android.downloadlib.utils.lz.mb
                public void mb() {
                    gm gmVar2 = gmVar;
                    if (gmVar2 != null) {
                        gmVar2.mb();
                    }
                }

                @Override // com.ss.android.downloadlib.utils.lz.mb
                public void mb(String str) {
                    gm gmVar2 = gmVar;
                    if (gmVar2 != null) {
                        gmVar2.mb(str);
                    }
                }
            });
        } else if (gmVar != null) {
            gmVar.mb();
        }
    }

    private boolean u() {
        return com.ss.android.downloadlib.utils.jb.mb(this.ox.ox) && ww.mb(this.ox.hj.getLinkMode());
    }

    private boolean u(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && DownloadUtils.isFileExist(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(DownloadInfo downloadInfo) {
        if (!ww.mb(this.ox.ox) || this.b) {
            return;
        }
        AdEventHandler.mb().mb(EventConstants.Label.FILE_STATUS, (downloadInfo == null || !com.ss.android.downloadlib.utils.jb.ox(downloadInfo.getTargetFilePath())) ? 2 : 1, this.ox);
        this.b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hj(DownloadInfo downloadInfo) {
        return u() || h(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int mb(Context context, IDownloadListener iDownloadListener) {
        HttpHeader mb2;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.ox.ox.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (x.lz().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.ox.ox.getLogExtra()) && (mb2 = mb(this.ox.ox.getLogExtra())) != null) {
            arrayList.add(mb2);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new HttpHeader(entry.getKey(), entry.getValue()));
                }
            }
        }
        String mb3 = com.ss.android.downloadlib.utils.b.mb(String.valueOf(this.ox.ox.getId()), this.ox.ox.getNotificationJumpUrl(), this.ox.ox.isShowToast(), String.valueOf(this.ox.ox.getModelType()));
        DownloadSetting ox2 = com.ss.android.downloadlib.utils.hj.ox(this.ox.ox);
        JSONObject mb4 = com.ss.android.downloadlib.utils.hj.mb(this.ox.ox);
        JSONObject jSONObject = mb4;
        if (!this.ox.hj.enableAH()) {
            jSONObject = com.ss.android.downloadlib.utils.jb.mb(mb4);
            com.ss.android.downloadlib.utils.jb.mb(jSONObject, DownloadSettingKeys.KEY_AH_PLANS, new JSONArray());
        }
        this.ox.ox.getExecutorGroup();
        int i = (this.ox.ox.isAd() || ww.ox(this.ox.ox)) ? 4 : 4;
        String mb5 = mb(ox2);
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(DownloadComponentManager.getDownloadId(this.ox.ox.getDownloadUrl(), mb5));
        if (downloadInfo != null && 3 == this.ox.ox.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.u lc = new com.ss.android.socialbase.appdownloader.u(context, this.ox.ox.getDownloadUrl()).ox(this.ox.ox.getBackupUrls()).mb(this.ox.ox.getName()).hj(mb3).mb(arrayList).mb(this.ox.ox.isShowNotification()).b(this.ox.ox.isNeedWifi()).ox(this.ox.ox.getFileName()).b(mb5).x(this.ox.ox.getAppIcon()).ko(this.ox.ox.getMd5()).lz(this.ox.ox.getSdkMonitorScene()).mb(this.ox.ox.getExpectFileLength()).mb(iDownloadListener).je(this.ox.ox.needIndependentProcess() || ox2.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, 0) == 1).mb(this.ox.ox.getDownloadFileUriProvider()).ox(this.ox.ox.autoInstallWithoutNotification()).u(this.ox.ox.getPackageName()).hj(1000).h(100).mb(jSONObject).lz(true).x(true).ox(ox2.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, 5)).b(ox2.optInt("backup_url_retry_count", 0)).x(true).nk(ox2.optInt("need_head_connection", 0) == 1).hj(ox2.optInt("need_https_to_http_retry", 0) == 1).ww(ox2.optInt(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, 1) == 1).ko(ox2.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, 0) == 1).ww(ox2.optString("retry_delay_time_array")).jb(ox2.optInt("need_reuse_runnable", 0) == 1).u(i).io(this.ox.ox.isAutoInstall()).lc(this.ox.ox.distinctDir());
        if (TextUtils.isEmpty(this.ox.ox.getMimeType())) {
            lc.h(AdBaseConstants.MIME_APK);
        } else {
            lc.h(this.ox.ox.getMimeType());
        }
        if (ox2.optInt("notification_opt_2", 0) == 1) {
            lc.mb(false);
            lc.ox(true);
        }
        com.ss.android.downloadlib.addownload.ox.mb mbVar = null;
        if (ox2.optInt("clear_space_use_disk_handler", 0) == 1) {
            mbVar = new com.ss.android.downloadlib.addownload.ox.mb();
            lc.mb(mbVar);
        }
        int mb6 = ww.mb(this.ox, b(), lc);
        if (mbVar != null) {
            mbVar.mb(mb6);
        }
        return mb6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb() {
        if (this.h == null) {
            this.h = new ox() { // from class: com.ss.android.downloadlib.addownload.ko.3
                @Override // com.ss.android.downloadlib.addownload.ko.ox
                public void mb(DownloadInfo downloadInfo) {
                    AdEventHandler.mb().mb(ko.this.mb, 2, downloadInfo);
                }
            };
        }
    }

    public void mb(long j) {
        this.mb = j;
        com.ss.android.downloadlib.addownload.model.h h = com.ss.android.downloadlib.addownload.model.u.mb().h(j);
        this.ox = h;
        if (h.on()) {
            com.ss.android.downloadlib.exception.b.mb().mb("setAdId ModelBox notValid");
        }
    }

    @Override // com.ss.android.downloadlib.utils.je.mb
    public void mb(Message message) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        ox oxVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.ko.mb().mb(this.ox.ox, this.ox.hj, this.ox.b);
                downloadInfo.setFirstDownload(false);
            }
            AdEventHandler.mb().mb(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        lz.mb(downloadShortInfo);
        int mb2 = com.ss.android.socialbase.appdownloader.b.mb(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int i = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
        int curBytes = i > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((i > 0 || DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) && (oxVar = this.h) != null) {
            oxVar.mb(downloadInfo);
            this.h = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : mb(map)) {
            if (mb2 != 1) {
                if (mb2 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, lz.mb(downloadInfo.getId(), curBytes));
                } else if (mb2 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, lz.mb(downloadInfo.getId(), curBytes));
            } else {
                for (com.ss.android.download.api.download.mb mbVar : ox(map)) {
                    mbVar.mb(downloadInfo);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb(final gm gmVar) {
        if (!TextUtils.isEmpty(this.ox.ox.getFilePath())) {
            String filePath = this.ox.ox.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                gmVar.mb();
                return;
            }
            try {
                if (filePath.startsWith(x.getContext().getExternalCacheDir().getParent())) {
                    gmVar.mb();
                    return;
                }
            } catch (Exception e) {
            }
        }
        ox(new gm() { // from class: com.ss.android.downloadlib.addownload.ko.1
            @Override // com.ss.android.download.api.config.gm
            public void mb() {
                gmVar.mb();
            }

            @Override // com.ss.android.download.api.config.gm
            public void mb(String str) {
                x.b().mb(1, x.getContext(), ko.this.ox.ox, "您已禁止使用存储权限，请授权后再下载", null, 1);
                AdEventHandler.mb().ox(ko.this.mb, 1);
                gmVar.mb(str);
            }
        });
    }

    public void mb(DownloadInfo downloadInfo) {
        this.b = false;
        ox(downloadInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mb(com.ss.android.socialbase.downloader.model.DownloadInfo r6, com.ss.android.download.api.model.DownloadShortInfo r7, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r8) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.ko.mb(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mb(DownloadInfo downloadInfo, boolean z) {
        if (this.ox.ox == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4) {
            AdEventHandler.mb().mb(this.mb, 2);
        } else if (ww.mb(this.ox.ox)) {
            AdEventHandler.mb().mb(this.mb, 2);
        } else if (z && com.ss.android.downloadlib.event.ox.mb().b() && (status == -2 || status == -3)) {
            AdEventHandler.mb().mb(this.mb, 2);
        }
        switch (status) {
            case -4:
            case -1:
                mb();
                com.ss.android.downloadlib.addownload.model.u.mb().mb(new com.ss.android.downloadad.api.mb.ox(this.ox.ox, this.ox.b, this.ox.hj, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
                    com.ss.android.downloadlib.exception.b.mb().ox("SUCCESSED isInstalledApp");
                    return;
                }
                AdEventHandler.mb().mb(this.mb, 5, downloadInfo);
                if (z && com.ss.android.downloadlib.event.ox.mb().ox() && !com.ss.android.downloadlib.event.ox.mb().ox(this.mb, this.ox.ox.getLogExtra())) {
                    AdEventHandler.mb().mb(this.mb, 2);
                    return;
                }
                return;
            case -2:
                AdEventHandler.mb().mb(this.mb, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.event.ox.mb().ox() && !com.ss.android.downloadlib.event.ox.mb().ox(this.mb, this.ox.ox.getLogExtra())) {
                    AdEventHandler.mb().mb(this.mb, 2);
                    return;
                }
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                AdEventHandler.mb().mb(this.mb, 3, downloadInfo);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean mb(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
            com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(this.ox.mb);
            if (hj != null) {
                DownloadNotificationManager.getInstance().cancelNotification(hj.m());
            }
            return com.ss.android.downloadlib.ox.mb.mb(this.ox);
        } else if (!mb(i) || TextUtils.isEmpty(this.ox.ox.getPackageName()) || x.lz().optInt("disable_market") == 1) {
            if (z && this.ox.hj.getDownloadMode() == 4 && !this.hj.h()) {
                this.hj.b(true);
                return true;
            }
            return false;
        } else if (com.ss.android.downloadlib.ox.mb.mb(this.ox, i)) {
            return true;
        } else {
            boolean z2 = false;
            if (this.hj.lz()) {
                z2 = false;
                if (this.hj.hj(true)) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean mb(boolean z) {
        return !z && this.ox.hj.getDownloadMode() == 1;
    }

    public String ox() {
        File externalFilesDir = x.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            if (externalFilesDir.exists()) {
                return externalFilesDir.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public void ox(DownloadInfo downloadInfo) {
        ox oxVar = this.h;
        if (oxVar != null) {
            oxVar.mb(downloadInfo);
            this.h = null;
        }
    }
}
