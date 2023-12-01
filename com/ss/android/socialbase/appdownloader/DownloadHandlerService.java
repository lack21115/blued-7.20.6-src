package com.ss.android.socialbase.appdownloader;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/DownloadHandlerService.class */
public class DownloadHandlerService extends Service {
    private static final String mb = DownloadHandlerService.class.getSimpleName();

    private static void mb(Context context, int i, boolean z) {
        boolean z2;
        INotificationClickCallback notificationClickCallback;
        DownloadInfo downloadInfo;
        if (z && (notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(i)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z2 = notificationClickCallback.onClickWhenSuccess(downloadInfo);
                if (z2 && b.mb(context, i, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (z2) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    private static void mb(Context context, final com.ss.android.socialbase.appdownloader.b.hj hjVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (hjVar == null && downloadNotificationEventListener == null) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo mb2;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (DownloadComponentManager.getAppContext() == null || (mb2 = b.mb(DownloadInfo.this, file)) == null) ? "" : mb2.packageName;
                            if (hjVar != null) {
                                hjVar.mb(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.onNotificationEvent(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private static void mb(Context context, DownloadInfo downloadInfo) {
        if (DownloadUtils.isWifi(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    public static void mb(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.b.hj hjVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        AbsNotificationItem notificationItem;
        int id = downloadInfo.getId();
        INotificationClickCallback notificationClickCallback = DownloadProcessDispatcher.getInstance().getNotificationClickCallback(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && notificationClickCallback != null && b.mb(context, downloadInfo) && notificationClickCallback.onClickWhenInstalled(downloadInfo)) {
            return;
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (DownloadSetting.obtain(id).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                return;
            case -3:
                mb(DownloadComponentManager.getAppContext(), id, true);
                mb(context, hjVar, downloadInfo);
                if (DownloadSetting.obtain(id).optInt("notification_click_install_auto_cancel", 1) != 0 || (notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(id)) == null) {
                    z = true;
                } else {
                    notificationItem.recordClickInstall();
                    notificationItem.refreshStatus(-3, null, false, true);
                }
                if (z) {
                    DownloadNotificationManager.getInstance().hideNotification(id);
                    return;
                }
                return;
            case -2:
                if (DownloadProcessDispatcher.getInstance().canResume(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    b.mb(downloadInfo, true, false);
                }
                if (hjVar != null) {
                    hjVar.mb(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(6, downloadInfo, "", "");
                    return;
                }
                return;
            case 0:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                mb(context, downloadInfo);
                if (hjVar != null) {
                    hjVar.mb(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (iDownloadNotificationEventListener != null) {
                    iDownloadNotificationEventListener.onNotificationEvent(5, downloadInfo, "", "");
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mb(com.ss.android.socialbase.downloader.model.DownloadInfo r9, com.ss.android.socialbase.appdownloader.b.hj r10, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener r11) {
        /*
            r8 = this;
            r0 = r9
            int r0 = r0.getId()
            r12 = r0
            com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher r0 = com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher.getInstance()
            r1 = r12
            com.ss.android.socialbase.downloader.depend.INotificationClickCallback r0 = r0.getNotificationClickCallback(r1)
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L29
            r0 = r14
            r1 = r9
            boolean r0 = r0.onClickWhenUnSuccess(r1)     // Catch: java.lang.Throwable -> L22
            r13 = r0
            goto L2c
        L22:
            r14 = move-exception
            r0 = r14
            r0.printStackTrace()
        L29:
            r0 = 0
            r13 = r0
        L2c:
            r0 = r13
            if (r0 != 0) goto L8a
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            r2 = r8
            java.lang.Class<com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity> r3 = com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class
            r1.<init>(r2, r3)
            r14 = r0
            r0 = r14
            java.lang.String r1 = "extra_click_download_ids"
            r2 = r12
            android.content.Intent r0 = r0.putExtra(r1, r2)
            r0 = r14
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r0 = r0.addFlags(r1)
            r0 = r8
            r1 = r14
            r0.startActivity(r1)
            com.ss.android.socialbase.downloader.notification.DownloadNotificationManager r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationManager.getInstance()
            r1 = r12
            r0.hideNotification(r1)
            r0 = r9
            r0.updateDownloadTime()
            r0 = r10
            if (r0 == 0) goto L79
            r0 = r10
            r1 = r12
            r2 = 7
            java.lang.String r3 = ""
            r4 = r9
            int r4 = r4.getStatus()
            r5 = r9
            long r5 = r5.getDownloadTime()
            r0.mb(r1, r2, r3, r4, r5)
        L79:
            r0 = r11
            if (r0 == 0) goto L8a
            r0 = r11
            r1 = 7
            r2 = r9
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            r0.onNotificationEvent(r1, r2, r3, r4)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.mb(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.appdownloader.b.hj, com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener):void");
    }

    private boolean mb(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.b.hj ox = hj.x().ox();
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        boolean z = true;
        if (intent.getBooleanExtra("extra_from_notification", false) && DownloadSetting.obtain(intExtra).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            mb(downloadInfo, ox, downloadNotificationEventListener);
            return false;
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            mb(this, downloadInfo, ox, downloadNotificationEventListener);
            return false;
        } else if (!action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
                ox(downloadInfo, ox, downloadNotificationEventListener);
                return false;
            } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
                DownloadNotificationManager.getInstance().hideNotification(intExtra);
                return false;
            } else if (action.equals(Intent.ACTION_BOOT_COMPLETED) || action.equals(Intent.ACTION_MEDIA_MOUNTED)) {
                DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(AdBaseConstants.MIME_APK);
                            arrayList.add(DownloadConstants.MIME_PLG);
                            Downloader.getInstance(DownloadComponentManager.getAppContext()).restartAllFailedDownloadTasks(arrayList);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                return true;
            } else {
                return false;
            }
        } else if (downloadInfo.getStatus() == 0) {
            return false;
        } else {
            mb(this, downloadInfo, ox, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.NO_HIDE_NOTIFICATION, 0) == 0) {
                if (DownloadSetting.obtain(intExtra).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2 || downloadInfo.getStatus() != -1) {
                    z = false;
                }
                if (z) {
                    return false;
                }
                DownloadNotificationManager.getInstance().hideNotification(intExtra);
                DownloadNotificationManager.getInstance().cancelNotification(intExtra);
                return false;
            }
            return false;
        }
    }

    private void ox(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.b.hj hjVar, IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
        intent.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, id);
        intent.addFlags(268435456);
        startActivity(intent);
        DownloadNotificationManager.getInstance().hideNotification(id);
        downloadInfo.updateDownloadTime();
        if (hjVar != null) {
            hjVar.mb(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (iDownloadNotificationEventListener != null) {
            iDownloadNotificationEventListener.onNotificationEvent(7, downloadInfo, "", "");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (Logger.debug()) {
            Logger.d(mb, "onStartCommand");
        }
        mb(intent);
        stopSelf();
        return 2;
    }
}
