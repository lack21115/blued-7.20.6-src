package com.ss.android.downloadlib;

import android.text.TextUtils;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.je;
import com.ss.android.download.api.config.lz;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/h.class */
public class h implements com.ss.android.download.api.mb {
    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(e eVar) {
        x.mb(eVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(je jeVar) {
        x.mb(jeVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(com.ss.android.download.api.config.ko koVar) {
        x.mb(koVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(lz lzVar) {
        x.mb(lzVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(final com.ss.android.download.api.config.ox oxVar) {
        x.mb(oxVar);
        AppStatusManager.getInstance().setInnerAppStatusChangeCaller(new AppStatusManager.InnerAppStatusChangeCaller() { // from class: com.ss.android.downloadlib.h.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
            public boolean isAppInBackground() {
                return oxVar.mb();
            }
        });
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(com.ss.android.download.api.config.ww wwVar) {
        x.mb(wwVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(com.ss.android.download.api.config.x xVar) {
        x.mb(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(com.ss.android.download.api.model.mb mbVar) {
        x.mb(mbVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new INotificationClickCallback() { // from class: com.ss.android.downloadlib.h.2
                private boolean mb(DownloadInfo downloadInfo) {
                    g l = x.l();
                    if (l != null) {
                        com.ss.android.downloadad.api.mb.ox mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
                        String mb2 = (mb == null || !mb.b()) ? com.ss.android.downloadlib.addownload.ww.mb(downloadInfo) : DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
                        if (TextUtils.isEmpty(mb2)) {
                            return false;
                        }
                        return l.mb(x.getContext(), mb2);
                    }
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.mb.ox mb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
                    if (mb != null) {
                        com.ss.android.downloadlib.ox.mb.mb(mb);
                    } else {
                        com.ss.android.downloadlib.utils.ww.ox(x.getContext(), downloadInfo.getPackageName());
                    }
                    DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
                    DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
                    if (obtain.optInt("notification_opt_2") != 1) {
                        boolean mb = mb(downloadInfo);
                        if (obtain.optInt("disable_delete_dialog", 0) == 1) {
                            return true;
                        }
                        return mb;
                    } else if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.mb(x.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.hj.x().ox(), Downloader.getInstance(x.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        return true;
                    } else {
                        return true;
                    }
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.b.b());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(String str) {
        x.mb(str);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public void mb() {
        if (!x.df()) {
            com.ss.android.downloadlib.exception.b.mb().mb("ttdownloader init error");
        }
        x.mb(com.ss.android.downloadlib.exception.b.mb());
        try {
            com.ss.android.socialbase.appdownloader.hj.x().ox(x.g());
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.hj.x().mb(mb.mb());
        hj.mb().ox(new Runnable() { // from class: com.ss.android.downloadlib.h.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.u.hj.mb("");
                if (com.ss.android.socialbase.appdownloader.u.hj.o()) {
                    DownloadComponentManager.setNotAutoRebootService(true);
                }
                if (DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.u.h.mb(x.getContext());
                }
            }
        });
    }
}
